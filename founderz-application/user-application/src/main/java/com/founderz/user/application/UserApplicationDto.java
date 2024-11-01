package com.founderz.user.application;

import com.founderz.common.vo.AccountId;
import com.founderz.common.vo.AccountName;
import com.founderz.common.vo.AccountType;
import com.founderz.common.vo.SecuredPassword;
import com.founderz.common.vo.PhoneNumber;
import com.founderz.common.vo.UserId;

public record UserApplicationDto(
        UserId id,
        AccountId accountId,
        AccountName name,
        AccountType type,
        PhoneNumber phoneNumber,
        SecuredPassword hashedPassword
) {
}
