package com.founderz.common.vo;

public sealed interface ValueObject permits
        AccountId,
        AccountIdentifier,
        AccountName,
        AccountType,
        PasetoToken,
        Password,
        PhoneNumber,
        UserId,
        SecuredPassword,
        SecuredUserId
{}
