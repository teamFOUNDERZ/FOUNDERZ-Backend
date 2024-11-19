package com.founderz.common.vo.areement;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

public record DelinquentQuarter(
        @JsonValue
        Integer quarter
) implements ValueObject.LongValueObject {
    public static DelinquentQuarter create(final Integer quarter) {
        return new DelinquentQuarter(quarter);
    }
}