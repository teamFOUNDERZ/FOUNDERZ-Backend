package com.founderz.security.password;

import com.founderz.common.vo.HashedPassword;
import com.founderz.common.vo.Password;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class PasswordEncoderImpl implements com.founderz.common.crypto.PasswordEncoder {
    private final PasswordEncoder passwordEncoder;

    @Override
    public String encode(Password rawPassword) {
        return passwordEncoder.encode(rawPassword.password());
    }

    @Override
    public Boolean matches(Password rawPassword, HashedPassword hashedPassword) {
        return passwordEncoder.matches(rawPassword.password(), hashedPassword.password());
    }
}
