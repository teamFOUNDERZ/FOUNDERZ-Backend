package com.founderz.auth.application.dto;

import com.founderz.common.vo.Password;
import com.founderz.common.vo.AccountId;
import com.founderz.common.vo.AccountName;
import com.founderz.common.vo.AccountType;
import com.founderz.common.vo.PhoneNumber;

public record RegisterDto(
        AccountId accountId,
        AccountName name,
        AccountType type,
        PhoneNumber phoneNumber,
        Password password
) {
}
