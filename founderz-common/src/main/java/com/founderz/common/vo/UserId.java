package com.founderz.common.vo;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.crypto.CryptoUtils;

public record UserId(
        @JsonValue
        Long userId
) implements ValueObject.LongValueObject {
    public static UserId create(final Long userId) {
        return new UserId(userId);
    }

    public SecuredUserId toSecureUserId() {
        return new SecuredUserId(CryptoUtils.encrypt(userId));
    }
}
