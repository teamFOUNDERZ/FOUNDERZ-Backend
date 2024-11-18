package com.founderz.common.vo.investment;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentLength;
import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;

public record Contact(
        @JsonValue
        String contact
) implements ValueObject.StringValueObject {
    public Contact {
        assertArgumentNotEmpty(contact, "연락처가 입력되지 않았습니다.");
        assertArgumentLength(contact, 5, 30, "연락처는 5~30자로 입력되어야 합니다.");
    }

    public static Contact create(final String contact) {
        return new Contact(contact);
    }
}