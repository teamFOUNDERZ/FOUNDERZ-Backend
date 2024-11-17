package com.founderz.common.vo.investment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

import java.time.LocalDate;

public record PreferContractPeriod(
        @JsonValue
        LocalDate date
) implements ValueObject.LongValueObject {
    @JsonCreator
    public static PreferContractPeriod create(final LocalDate date) {
        return new PreferContractPeriod(date);
    }
}
