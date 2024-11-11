package com.founderz.internal.data.user;

import com.founderz.common.vo.user.AccountId;
import com.founderz.common.vo.user.AccountName;
import com.founderz.common.vo.user.AccountType;
import com.founderz.common.vo.auth.SecuredPassword;
import com.founderz.common.vo.user.PhoneNumber;
import com.founderz.common.vo.user.UserId;

public record UserDto(
        UserId userId,
        AccountId accountId,
        AccountName name,
        AccountType type,
        PhoneNumber phoneNumber,
        SecuredPassword securedPassword
) {
}
