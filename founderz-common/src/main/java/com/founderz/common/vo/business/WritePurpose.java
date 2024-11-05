package com.founderz.common.vo.business;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

import java.util.regex.Pattern;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;
import static com.founderz.common.assertion.AssertionUtils.assertRegularExpression;
import static com.founderz.common.assertion.RegexUtils.ALLOWED_ONLY_KOR;

public record WritePurpose(
        @JsonValue
        String writePurpose
) implements ValueObject.StringValueObject {
    private static final Pattern WRITE_PURPOSE_REGEX = Pattern.compile(ALLOWED_ONLY_KOR.getRegex(5, 100));

    public WritePurpose {
        assertArgumentNotEmpty(writePurpose, "작성 목적이 입력되지 않았습니다.");
        assertRegularExpression(writePurpose, WRITE_PURPOSE_REGEX, "작성 목적은 5~100자의 한글로 입력되어야 합니다.");
    }

    public static WritePurpose create(final String writePurpose) {
        return new WritePurpose(writePurpose);
    }
}

