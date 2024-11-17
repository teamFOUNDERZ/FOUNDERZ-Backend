package com.founderz.common.vo.investment;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.crypto.CryptoUtils;
import com.founderz.common.vo.ValueObject;

public record InvestmentId(
        @JsonValue
        Long investmentId
) implements ValueObject.LongValueObject {
    public static InvestmentId create(final Long investmentId) {
        return new InvestmentId(investmentId);
    }

    public SecuredInvestmentId toSecureInvestmentId() {
        return SecuredInvestmentId.create(CryptoUtils.encrypt(investmentId));
    }
}

