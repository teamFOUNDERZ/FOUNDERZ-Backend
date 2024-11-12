package com.founderz.auth.presentation;

import com.founderz.auth.application.AuthWriteService;
import com.founderz.auth.presentation.document.AuthWriteDocumentation;
import com.founderz.auth.presentation.form.LoginForm;
import com.founderz.auth.presentation.form.RegisterForm;
import com.founderz.auth.presentation.response.LoginResponse;
import com.founderz.common.presentation.annotation.WebRestAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@WebRestAdapter("/api/auth")
class AuthWriteAdapter implements AuthWriteDocumentation {
    private final AuthWriteService writeService;
    private final RegisterFormMapper registerFormMapper;
    private final LoginFormMapper loginFormMapper;

    @PostMapping("/register")
    public void register(
            @RequestBody RegisterForm form
    ) {
        final var internalDto = registerFormMapper.toDto(form);
        writeService.register(internalDto, form.tagIds());
    }

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginForm form
    ) {
        final var applicationDto = loginFormMapper.toApplicationDto(form);
        final var token = writeService.login(applicationDto);

        return LoginResponse.create(token);
    }
}
