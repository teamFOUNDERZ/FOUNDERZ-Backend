package com.founderz.common.vo.business;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;
import static com.founderz.common.assertion.AssertionUtils.assertArgumentLength;

public record OneLineIntroduction(
        @JsonValue
        String oneLineIntroduction
) implements ValueObject.StringValueObject {
    public OneLineIntroduction {
        assertArgumentNotEmpty(oneLineIntroduction, "소개가 입력되지 않았습니다.");
        assertArgumentLength(oneLineIntroduction, 3, 100, "소개는 3~100자로 입력되어야 합니다.");
    }

    public static OneLineIntroduction create(final String oneLineIntroduction) {
        return new OneLineIntroduction(oneLineIntroduction);
    }
}
