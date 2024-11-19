package com.founderz.common.vo.repayment;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

public record RepaymentAmount(
        @JsonValue
        Long repaymentAmount
) implements ValueObject.LongValueObject {
    public static RepaymentAmount create(final Long repaymentAmount) {
        return new RepaymentAmount(repaymentAmount);
    }
}
