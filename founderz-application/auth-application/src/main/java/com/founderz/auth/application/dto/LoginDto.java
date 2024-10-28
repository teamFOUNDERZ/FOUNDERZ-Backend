package com.founderz.auth.application.dto;

import com.founderz.common.vo.Password;
import com.founderz.common.vo.AccountIdentifier;

public record LoginDto(
        AccountIdentifier identifier,
        Password password
) {
}
