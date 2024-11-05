package com.founderz.common.vo.business;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

import java.util.regex.Pattern;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;
import static com.founderz.common.assertion.AssertionUtils.assertRegularExpression;
import static com.founderz.common.assertion.RegexUtils.ALLOWED_ONLY_KOR;

public record OneLinerIntroduction(
        @JsonValue
        String introduction
) implements ValueObject.StringValueObject {
    private static final Pattern ONE_LINER_INTRODUCTION_REGEX = Pattern.compile(ALLOWED_ONLY_KOR.getRegex(3, 100));

    public OneLinerIntroduction {
        assertArgumentNotEmpty(introduction, "소개가 입력되지 않았습니다.");
        assertRegularExpression(introduction, ONE_LINER_INTRODUCTION_REGEX, "소개는 3~100자의 한글로 입력되어야 합니다.");
    }

    public static OneLinerIntroduction create(final String introduction) {
        return new OneLinerIntroduction(introduction);
    }
}
