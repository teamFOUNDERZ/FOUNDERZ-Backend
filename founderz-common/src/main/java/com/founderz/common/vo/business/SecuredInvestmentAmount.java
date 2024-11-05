package com.founderz.common.vo.business;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.crypto.CryptoUtils;
import com.founderz.common.vo.ValueObject;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;

public record SecuredInvestmentAmount(
        @JsonValue
        String investmentAmount
) implements ValueObject.StringValueObject {
    public SecuredInvestmentAmount {
        assertArgumentNotEmpty(investmentAmount, "총 투자금이 입력되지 않았습니다.");
    }

    public static SecuredInvestmentAmount create(final String investmentAmount) {
        return new SecuredInvestmentAmount(investmentAmount);
    }

    public InvestmentAmount toInvestmentAmount() {
        return new InvestmentAmount(CryptoUtils.decrypt(investmentAmount));
    }
}
