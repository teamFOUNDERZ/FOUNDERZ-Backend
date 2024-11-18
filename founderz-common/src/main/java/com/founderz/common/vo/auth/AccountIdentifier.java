package com.founderz.common.vo.auth;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.user.AccountId;
import com.founderz.common.vo.user.PhoneNumber;
import com.founderz.common.vo.ValueObject;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;

public record AccountIdentifier(
        @JsonValue
        String identifier
) implements ValueObject.StringValueObject {
    public AccountIdentifier {
        assertArgumentNotEmpty(identifier, "계정의 아이디 또는 전화번호를 입력해주세요.");
    }

    public AccountId toAccountId() {
        return AccountId.create(identifier);
    }

    public PhoneNumber toTelNumber() {
        return PhoneNumber.create(identifier);
    }
}
