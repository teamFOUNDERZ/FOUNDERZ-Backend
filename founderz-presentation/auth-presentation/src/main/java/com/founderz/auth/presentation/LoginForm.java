package com.founderz.auth.presentation;

import com.founderz.common.vo.AccountIdentifier;
import com.founderz.common.vo.Password;

public record LoginForm(
        AccountIdentifier identifier,
        Password password
) {
}
