package com.founderz.common.vo.tag;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.crypto.CryptoUtils;
import com.founderz.common.vo.ValueObject;

public record TagId(
        @JsonValue
        Long tagId
) implements ValueObject.LongValueObject {
    public static TagId create(final Long tagId) {
        return new TagId(tagId);
    }

    public SecuredTagId toSecureTagId() {
        return new SecuredTagId(CryptoUtils.encrypt(tagId));
    }
}
