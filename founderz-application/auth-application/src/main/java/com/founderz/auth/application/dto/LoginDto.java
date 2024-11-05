package com.founderz.auth.application.dto;

import com.founderz.common.vo.auth.Password;
import com.founderz.common.vo.auth.AccountIdentifier;

public record LoginDto(
        AccountIdentifier identifier,
        Password password
) {
}
