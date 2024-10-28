package com.founderz.auth.presentation;

import com.founderz.common.vo.AccountIdentifier;
import com.founderz.common.vo.Password;

record LoginForm(
        AccountIdentifier identifier,
        Password password
) {
}
