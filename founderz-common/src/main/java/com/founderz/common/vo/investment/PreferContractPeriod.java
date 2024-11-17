package com.founderz.common.vo.investment;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

public record PreferContractPeriod(
        @JsonValue
        Long date
) implements ValueObject.LongValueObject {
    public static PreferContractPeriod create(final Long date) {
        return new PreferContractPeriod(date);
    }
}
