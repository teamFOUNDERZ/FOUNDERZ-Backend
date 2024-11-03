package com.founderz.common.vo;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.regex.Pattern;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;
import static com.founderz.common.assertion.AssertionUtils.assertRegularExpression;
import static com.founderz.common.assertion.RegexUtils.ALLOWED_ONLY_KOR;

public record AccountName(
        @JsonValue
        String name
) implements ValueObject.StringValueObject {
    private static final Pattern ACCOUNT_NAME_REGEX = Pattern.compile(ALLOWED_ONLY_KOR.getRegex(2, 6));

    public AccountName {
        assertArgumentNotEmpty(name, "이름이 입력되지 않았습니다.");
        assertRegularExpression(name, ACCOUNT_NAME_REGEX, "이름은 2~6자의 한글로 입력되어야 합니다.");
    }

    public static AccountName create(final String name) {
        return new AccountName(name);
    }
}
