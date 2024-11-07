package com.founderz.common.vo.business;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

import java.util.regex.Pattern;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;
import static com.founderz.common.assertion.AssertionUtils.assertRegularExpression;
import static com.founderz.common.assertion.RegexUtils.ALLOWED_ONLY_KOR;

public record Vision(
        @JsonValue
        String vision
) implements ValueObject.StringValueObject {
    private static final Pattern VISION_REGEX = Pattern.compile(ALLOWED_ONLY_KOR.getRegex(5, 50));

    public Vision {
        assertArgumentNotEmpty(vision, "비전이 입력되지 않았습니다.");
        assertRegularExpression(vision, VISION_REGEX, "비전은 5~50자의 한글로 입력되어야 합니다.");
    }

    public static Vision create(final String vision) {
        return new Vision(vision);
    }
}
