package com.founderz.auth.presentation;

import com.founderz.auth.application.AuthWriteService;
import com.founderz.auth.document.AuthWriteDocumentation;
import com.founderz.common.presentation.annotation.WebRestAdapter;
import com.founderz.common.vo.PasetoToken;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@WebRestAdapter("/api/auth")
class AuthWriteController implements AuthWriteDocumentation {
    private final AuthWriteService writeService;
    private final RegisterFormMapper registerFormMapper;
    private final LoginFormMapper loginFormMapper;

    @PostMapping("/register")
    public void register(
            @RequestBody RegisterForm form
    ) {
        final var applicationDto = registerFormMapper.toApplicationDto(form);
        writeService.register(applicationDto);
    }

    @PostMapping("/login")
    public PasetoToken login(
            @RequestBody LoginForm form
    ) {
        final var applicationDto = loginFormMapper.toApplicationDto(form);
        return writeService.login(applicationDto);
    }
}
