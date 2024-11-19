package com.founderz.common.vo.repayment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

import java.time.LocalDateTime;

public record RepaymentDate(
        @JsonValue
        LocalDateTime date
) implements ValueObject.LongValueObject {
    @JsonCreator
    public static RepaymentDate create(final LocalDateTime date) {
        return new RepaymentDate(date);
    }
}

