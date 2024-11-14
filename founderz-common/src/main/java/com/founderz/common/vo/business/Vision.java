package com.founderz.common.vo.business;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

import java.util.regex.Pattern;

import static com.founderz.common.assertion.AssertionUtils.*;
import static com.founderz.common.assertion.RegexUtils.ALLOWED_ONLY_KOR;
import static com.founderz.common.assertion.RegexUtils.ALLOWED_ONLY_KOR_N_ENG;

public record Vision(
        @JsonValue
        String vision
) implements ValueObject.StringValueObject {

    public Vision {
        assertArgumentNotEmpty(vision, "비전이 입력되지 않았습니다.");
        assertArgumentLength(vision,5, 50, "비전은 5~50자로 입력되어야 합니다.");
    }

    public static Vision create(final String vision) {
        return new Vision(vision);
    }
}
