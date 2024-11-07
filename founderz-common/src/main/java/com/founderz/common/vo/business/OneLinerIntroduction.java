package com.founderz.common.vo.business;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

import java.util.regex.Pattern;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;
import static com.founderz.common.assertion.AssertionUtils.assertArgumentLength;

public record OneLinerIntroduction(
        @JsonValue
        String introduction
) implements ValueObject.StringValueObject {
        
    public OneLinerIntroduction {
        assertArgumentNotEmpty(introduction, "소개가 입력되지 않았습니다.");
        assertArgumentLength(introduction, 3, 100, "소개는 3~100자로 입력되어야 합니다.");
    }

    public static OneLinerIntroduction create(final String introduction) {
        return new OneLinerIntroduction(introduction);
    }
}
