package com.founderz.common.vo;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.crypto.CryptoUtils;

public record SecuredUserId(
        @JsonValue
        String userId
) implements ValueObject {
    public UserId toUserId() {
        return new UserId(CryptoUtils.decrypt(userId));
    }
}
