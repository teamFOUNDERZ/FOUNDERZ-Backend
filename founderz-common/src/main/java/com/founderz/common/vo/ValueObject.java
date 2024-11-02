package com.founderz.common.vo;

public sealed interface ValueObject permits
        ValueObject.LongValueObject,
        ValueObject.StringValueObject
{
    sealed interface StringValueObject extends ValueObject permits
            AccountId,
            AccountIdentifier,
            AccountName,
            AccountType,
            PasetoToken,
            Password,
            PhoneNumber,
            SecuredPassword,
            SecuredUserId
    {}

    sealed interface LongValueObject extends ValueObject permits
            UserId
    {}
}

