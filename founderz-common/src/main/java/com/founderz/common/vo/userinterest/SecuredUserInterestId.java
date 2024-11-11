package com.founderz.common.vo.userinterest;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.crypto.CryptoUtils;
import com.founderz.common.vo.ValueObject;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;

public record SecuredUserInterestId(
        @JsonValue
        String userInterestId
) implements ValueObject.StringValueObject {
    public SecuredUserInterestId {
        assertArgumentNotEmpty(userInterestId, "유저 관심사 아이디가 입력되지 않았습니다.");
    }

    public static SecuredUserInterestId create(final String userInterestId) {
        return new SecuredUserInterestId(userInterestId);
    }

    public UserInterestId toUserInterestId() {
        return UserInterestId.create(CryptoUtils.decrypt(userInterestId));
    }
}
