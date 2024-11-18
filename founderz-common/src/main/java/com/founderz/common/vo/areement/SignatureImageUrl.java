package com.founderz.common.vo.areement;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentLength;
import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;

public record SignatureImageUrl(
        @JsonValue
        String url
) implements ValueObject.StringValueObject {
    public SignatureImageUrl {
        assertArgumentNotEmpty(url, "사인 파일이 입력되지 않았습니다.");
        assertArgumentLength(url, 10, 50, "사진 파일이 10~50자로 입력되어야 합니다.");
    }

    public static SignatureImageUrl create(final String url) {
        return new SignatureImageUrl(url);
    }
}