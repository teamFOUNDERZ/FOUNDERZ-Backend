package com.founderz.common.vo.business;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;
import static com.founderz.common.assertion.AssertionUtils.assertArgumentLength;

public record BusinessIntroduction(
        @JsonValue
        String businessIntroduction
) implements ValueObject.StringValueObject {
    public BusinessIntroduction {
        assertArgumentNotEmpty(businessIntroduction, "소개가 입력되지 않았습니다.");
        assertArgumentLength(businessIntroduction, 50, 1000, "소개는 50~1000자로 입력되어야 합니다.");
    }

    public static BusinessIntroduction create(final String businessIntroduction) {
        return new BusinessIntroduction(businessIntroduction);
    }
}
