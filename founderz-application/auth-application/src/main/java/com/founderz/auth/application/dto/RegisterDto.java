package com.founderz.auth.application.dto;

import com.founderz.common.vo.auth.Password;
import com.founderz.common.vo.user.AccountId;
import com.founderz.common.vo.user.AccountName;
import com.founderz.common.vo.user.AccountType;
import com.founderz.common.vo.user.PhoneNumber;

public record RegisterDto(
        AccountId accountId,
        AccountName name,
        AccountType type,
        PhoneNumber phoneNumber,
        Password password
) {
}
