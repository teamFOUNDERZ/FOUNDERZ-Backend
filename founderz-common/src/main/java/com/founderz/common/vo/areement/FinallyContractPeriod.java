package com.founderz.common.vo.areement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

import java.time.LocalDate;

public record FinallyContractPeriod(
        @JsonValue
        LocalDate date
) implements ValueObject.LongValueObject {
    @JsonCreator
    public static FinallyContractPeriod create(final LocalDate date) {
        return new FinallyContractPeriod(date);
    }
}
