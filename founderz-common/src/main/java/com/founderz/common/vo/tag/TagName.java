package com.founderz.common.vo.tag;

import com.fasterxml.jackson.annotation.JsonValue;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;

public record TagName(
        @JsonValue
        String tagName
) {
    public TagName {
        assertArgumentNotEmpty(tagName, "태그 이름이 입력되지 않았습니다.");
    }

    public static TagName create(String tagName) {
        return new TagName(tagName);
    }
}
