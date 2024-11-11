package com.founderz.common.vo.userinterest;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.crypto.CryptoUtils;
import com.founderz.common.vo.ValueObject;
import com.founderz.common.vo.user.SecuredUserId;

public record UserInterestId(
        @JsonValue
        Long userInterestId
) implements ValueObject.LongValueObject {
    public static UserInterestId create(final Long userInterestId) {
        return new UserInterestId(userInterestId);
    }

    public SecuredUserId toSecureUserInterestId() {
        return SecuredUserId.create(CryptoUtils.encrypt(userInterestId));
    }
}
