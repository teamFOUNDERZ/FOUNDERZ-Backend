package com.founderz.common.crypto;

import com.founderz.common.vo.SecuredPassword;
import com.founderz.common.vo.Password;

public interface PasswordEncoder {
    String encode(Password rawPassword);
    Boolean matches(Password rawPassword, SecuredPassword hashedPassword);
}
