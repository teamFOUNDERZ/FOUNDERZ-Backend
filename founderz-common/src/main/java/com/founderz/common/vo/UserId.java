package com.founderz.common.vo;

import com.fasterxml.jackson.annotation.JsonValue;

public record UserId(
        @JsonValue
        Long id
) implements ValueObject {
}
