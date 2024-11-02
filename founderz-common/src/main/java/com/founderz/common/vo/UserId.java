package com.founderz.common.vo;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.crypto.CryptoUtils;

public record UserId(
        @JsonValue
        Long userId
) implements ValueObject.LongValueObject {
    public SecuredUserId toSecureUserId() {
        return new SecuredUserId(CryptoUtils.encrypt(userId));
    }
}
