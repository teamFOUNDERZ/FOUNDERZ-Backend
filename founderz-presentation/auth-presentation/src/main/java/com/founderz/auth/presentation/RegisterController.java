package com.founderz.auth.presentation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
class RegisterController {
    @PostMapping("/register")
    Object register(
            @RequestBody RegisterForm form
    ) {
        return null;
    }
}
