package com.founderz.auth.presentation;

import com.founderz.auth.application.AuthWriteService;
import com.founderz.common.vo.PasetoToken;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
class AuthWriteController {
    private final AuthWriteService writeService;
    private final RegisterFormMapper registerFormMapper;
    private final LoginFormMapper loginFormMapper;

    @PostMapping("/register")
    void register(
            @RequestBody RegisterForm form
    ) {
        final var applicationDto = registerFormMapper.toApplicationDto(form);
        writeService.register(applicationDto);
    }

    @PostMapping("/login")
    PasetoToken login(
            @RequestBody LoginForm form
    ) {
        final var applicationDto = loginFormMapper.toApplicationDto(form);
        return writeService.login(applicationDto);
    }
}
