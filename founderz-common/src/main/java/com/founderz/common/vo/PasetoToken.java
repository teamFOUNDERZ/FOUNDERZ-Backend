package com.founderz.common.vo;

import com.fasterxml.jackson.annotation.JsonValue;

public record PasetoToken(
        @JsonValue
        String token
) implements ValueObject.StringValueObject {
}
