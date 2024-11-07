package com.founderz.common.vo.business;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;
import static com.founderz.common.assertion.AssertionUtils.assertArgumentLength;

public record WritePurpose(
        @JsonValue
        String writePurpose
) implements ValueObject.StringValueObject {
        
    public WritePurpose {
        assertArgumentNotEmpty(writePurpose, "작성 목적이 입력되지 않았습니다.");
        assertArgumentLength(writePurpose, 5, 100, "작성 목적은 5~100자로 입력되어야 합니다.");
    }

    public static WritePurpose create(final String writePurpose) {
        return new WritePurpose(writePurpose);
    }
}

