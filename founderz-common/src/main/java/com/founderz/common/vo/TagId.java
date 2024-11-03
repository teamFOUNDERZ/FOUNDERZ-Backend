package com.founderz.common.vo;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.crypto.CryptoUtils;

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
