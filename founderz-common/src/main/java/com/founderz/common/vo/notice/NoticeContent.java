package com.founderz.common.vo.notice;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;

public record NoticeContent(
        @JsonValue
        String content
) implements ValueObject.StringValueObject {
    public NoticeContent {
        assertArgumentNotEmpty(content, "알림의 내용은 비어있을 수 없습니다.");
    }

    public static NoticeContent create(final String content) {
        return new NoticeContent(content);
    }
}
