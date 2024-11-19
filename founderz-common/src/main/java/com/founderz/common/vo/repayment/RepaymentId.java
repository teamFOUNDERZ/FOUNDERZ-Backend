package com.founderz.common.vo.repayment;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.crypto.CryptoUtils;
import com.founderz.common.vo.ValueObject;

public record RepaymentId(
        @JsonValue
        Long repaymentId
) implements ValueObject.LongValueObject {
    public static RepaymentId create(final Long repaymentId) {
        return new RepaymentId(repaymentId);
    }

    public SecuredRepaymentId toSecureRepaymentId() {
        return SecuredRepaymentId.create(CryptoUtils.encrypt(repaymentId));
    }
}
