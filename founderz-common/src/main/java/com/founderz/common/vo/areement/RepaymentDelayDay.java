package com.founderz.common.vo.areement;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

public record RepaymentDelayDay(
        @JsonValue
        Integer day
) implements ValueObject.LongValueObject {
    public static RepaymentDelayDay create(final Integer day) {
        return new RepaymentDelayDay(day);
    }
}
