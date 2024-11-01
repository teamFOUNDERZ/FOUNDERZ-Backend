package com.founderz.common.vo;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.regex.Pattern;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;
import static com.founderz.common.assertion.AssertionUtils.assertRegularExpression;
import static com.founderz.common.assertion.RegexUtils.PASSWORD;

public record Password(
        @JsonValue
        String password
) implements ValueObject {
    private static final Pattern PASSWORD_REGEX = Pattern.compile(PASSWORD.getRegex(8, 20));

    public Password {
        assertArgumentNotEmpty(password, "비밀번호가 입력되지 않았습니다.");
        assertRegularExpression(password, PASSWORD_REGEX, "비밀번호는 8~20자의 영문자, 숫자, 특수문자를 포함해야 합니다.");
    }
}
