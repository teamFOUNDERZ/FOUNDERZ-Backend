package com.founderz.internal.dto.user;

import com.founderz.common.vo.user.AccountId;
import com.founderz.common.vo.user.AccountName;
import com.founderz.common.vo.user.AccountType;
import com.founderz.common.vo.auth.SecuredPassword;
import com.founderz.common.vo.user.PhoneNumber;
import com.founderz.common.vo.user.UserId;

public record UserDto(
        UserId id,
        AccountId accountId,
        AccountName name,
        AccountType type,
        PhoneNumber phoneNumber,
        SecuredPassword securedPassword
) {
}
