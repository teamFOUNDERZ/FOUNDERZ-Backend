package com.founderz.auth.application.dto;

import com.founderz.common.vo.auth.SecuredPassword;
import com.founderz.common.vo.user.AccountId;

public record AuthApplicationDto(
        AccountId accountId,
        SecuredPassword securedPassword
) {
}
