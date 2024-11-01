package com.founderz.common.vo;

import com.fasterxml.jackson.annotation.JsonValue;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;

public record AccountIdentifier(
        @JsonValue
        String identifier
) {
    public AccountIdentifier {
        assertArgumentNotEmpty(identifier, "계정의 아이디 또는 전화번호를 입력해주세요.");
    }

    public AccountId toAccountId() {
        return new AccountId(identifier);
    }

    public PhoneNumber toTelNumber() {
        return new PhoneNumber(identifier);
    }
}
