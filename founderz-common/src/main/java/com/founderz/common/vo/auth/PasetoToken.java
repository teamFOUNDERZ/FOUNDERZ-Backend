package com.founderz.common.vo.auth;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

public record PasetoToken(
        @JsonValue
        String token
) implements ValueObject.StringValueObject {
}
