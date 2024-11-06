package com.founderz.common.vo.business;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.crypto.CryptoUtils;
import com.founderz.common.vo.ValueObject;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;

public record SecuredBusinessId(
        @JsonValue
        String businessId
) implements ValueObject.StringValueObject {
    public SecuredBusinessId {
        assertArgumentNotEmpty(businessId, "비즈니스 아이디가 입력되지 않았습니다.");
    }

    public static SecuredBusinessId create(final String businessId) {
        return new SecuredBusinessId(businessId);
    }

    public BusinessId toBusinessId() {
        return BusinessId.create(CryptoUtils.decrypt(businessId));
    }
}
