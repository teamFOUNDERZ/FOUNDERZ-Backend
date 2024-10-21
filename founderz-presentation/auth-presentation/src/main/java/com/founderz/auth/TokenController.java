package com.founderz.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
class TokenController {
    @PostMapping("/login")
    Object login() {
        return null;
    }
}
