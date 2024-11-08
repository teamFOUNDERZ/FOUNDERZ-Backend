package com.founderz.security.password;

import com.founderz.common.vo.auth.SecuredPassword;
import com.founderz.common.vo.auth.Password;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class PasswordEncoderImpl implements com.founderz.internal.function.security.PasswordEncoder {
    private final PasswordEncoder passwordEncoder;

    @Override
    public String encode(Password rawPassword) {
        return passwordEncoder.encode(rawPassword.password());
    }

    @Override
    public Boolean matches(Password rawPassword, SecuredPassword hashedPassword) {
        return passwordEncoder.matches(rawPassword.password(), hashedPassword.password());
    }
}
