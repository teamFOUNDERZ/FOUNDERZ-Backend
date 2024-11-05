package com.founderz.common.vo.business;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.crypto.CryptoUtils;
import com.founderz.common.vo.ValueObject;

public record InvestmentAmount(
        @JsonValue
        Long investmentAmount
) implements ValueObject.LongValueObject {
    public static InvestmentAmount create(final Long investmentAmount) {
        return new InvestmentAmount(investmentAmount);
    }

    public SecuredInvestmentAmount toSecureInvestmentAmount() {
        return new SecuredInvestmentAmount(CryptoUtils.encrypt(investmentAmount));
    }
}