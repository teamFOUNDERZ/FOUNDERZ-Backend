package com.founderz.auth.presentation.form;

import com.founderz.common.vo.auth.Password;
import com.founderz.common.vo.tag.SecuredTagId;
import com.founderz.common.vo.user.AccountId;
import com.founderz.common.vo.user.AccountName;
import com.founderz.common.vo.user.PhoneNumber;
import com.founderz.common.vo.auth.RegisterType;

import java.util.List;

public record RegisterForm(
        AccountId accountId,
        AccountName name,
        RegisterType type,
        PhoneNumber phoneNumber,
        Password password,
        List<SecuredTagId> tagIds
) {
}
