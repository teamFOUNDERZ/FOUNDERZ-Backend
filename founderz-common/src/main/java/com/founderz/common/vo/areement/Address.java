package com.founderz.common.vo.areement;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentLength;
import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;

public record Address(
        @JsonValue
        String address
) implements ValueObject.StringValueObject {
    public Address {
        assertArgumentNotEmpty(address, "주소가 입력되지 않았습니다.");
        assertArgumentLength(address, 10, 30, "주소는 10~30자로 입력되어야 합니다.");
    }

    public static Address create(final String address) {
        return new Address(address);
    }
}
