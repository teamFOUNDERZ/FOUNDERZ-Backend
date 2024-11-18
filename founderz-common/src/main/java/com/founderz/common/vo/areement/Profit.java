package com.founderz.common.vo.areement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

public record Profit(
        @JsonValue
        float profit
) implements ValueObject.LongValueObject {
    @JsonCreator
    public static Profit create(final float profit) {
        return new Profit(profit);
    }
}
