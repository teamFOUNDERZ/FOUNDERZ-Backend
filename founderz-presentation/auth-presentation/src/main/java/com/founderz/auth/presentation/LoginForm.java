package com.founderz.auth.presentation;

import com.founderz.common.vo.auth.AccountIdentifier;
import com.founderz.common.vo.auth.Password;

public record LoginForm(
        AccountIdentifier identifier,
        Password password
) {
}
