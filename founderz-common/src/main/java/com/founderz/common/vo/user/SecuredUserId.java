package com.founderz.common.vo.user;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.crypto.CryptoUtils;
import com.founderz.common.vo.ValueObject;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;

public record SecuredUserId(
        @JsonValue
        String userId
) implements ValueObject.StringValueObject {
    public SecuredUserId {
        assertArgumentNotEmpty(userId, "유저 아이디가 입력되지 않았습니다.");
    }

    public static SecuredUserId create(final String userId) {
        return new SecuredUserId(userId);
    }

    public UserId toUserId() {
        return new UserId(CryptoUtils.decrypt(userId));
    }
}
