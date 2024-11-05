package com.founderz.common.vo.business;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

import java.util.regex.Pattern;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;
import static com.founderz.common.assertion.AssertionUtils.assertRegularExpression;
import static com.founderz.common.assertion.RegexUtils.ALLOWED_ONLY_KOR;

public record BusinessName(
        @JsonValue
        String name
) implements ValueObject.StringValueObject {
    private static final Pattern BUSINESS_NAME_REGEX = Pattern.compile(ALLOWED_ONLY_KOR.getRegex(1, 20));

    public BusinessName {
        assertArgumentNotEmpty(name, "이름이 입력되지 않았습니다.");
        assertRegularExpression(name, BUSINESS_NAME_REGEX, "이름은 1~20자의 한글로 입력되어야 합니다.");
    }

    public static BusinessName create(final String name) {
        return new BusinessName(name);
    }
}
