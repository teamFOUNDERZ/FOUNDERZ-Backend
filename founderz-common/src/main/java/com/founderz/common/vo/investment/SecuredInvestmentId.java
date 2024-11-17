package com.founderz.common.vo.investment;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.crypto.CryptoUtils;
import com.founderz.common.vo.ValueObject;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;

public record SecuredInvestmentId(
        @JsonValue
        String investmentId
) implements ValueObject.StringValueObject {
    public SecuredInvestmentId {
        assertArgumentNotEmpty(investmentId, "투자 아이디가 입력되지 않았습니다.");
    }

    public static SecuredInvestmentId create(final String investmentId) {
        return new SecuredInvestmentId(investmentId);
    }

    public InvestmentId toinvestmentId() {
        return InvestmentId.create(CryptoUtils.decrypt(investmentId));
    }
}

