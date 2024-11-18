package com.founderz.common.vo.tag;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.crypto.CryptoUtils;
import com.founderz.common.vo.ValueObject;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;

public record SecuredTagId(
        @JsonValue
        String tagId
) implements ValueObject.StringValueObject {
    public SecuredTagId {
        assertArgumentNotEmpty(tagId, "태그 아이디가 입력되지 않았습니다.");
    }

    public static SecuredTagId create(final String tagId) {
        return new SecuredTagId(tagId);
    }

    public TagId toTagId() {
        return new TagId(CryptoUtils.decrypt(tagId));
    }
}
