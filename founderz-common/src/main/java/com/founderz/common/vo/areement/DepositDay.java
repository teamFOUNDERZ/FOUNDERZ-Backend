package com.founderz.common.vo.areement;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

public record DepositDay(
        @JsonValue
        Integer day
) implements ValueObject.LongValueObject {
    public static DepositDay create(final Integer day) {
        return new DepositDay(day);
    }
}