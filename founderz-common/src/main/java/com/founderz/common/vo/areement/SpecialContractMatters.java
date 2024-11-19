package com.founderz.common.vo.areement;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentLength;
import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;

public record SpecialContractMatters(
        @JsonValue
        String content
) implements ValueObject.StringValueObject {
    public SpecialContractMatters {
        assertArgumentNotEmpty(content, "특약사항이 입력되지 않았습니다.");
        assertArgumentLength(content, 5, 50, "특약사항은 5~50자로 입력되어야 합니다.");
    }

    public static SpecialContractMatters create(final String content) {
        return new SpecialContractMatters(content);
    }
}
