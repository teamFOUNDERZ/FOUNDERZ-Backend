package com.founderz.common.vo.repayment;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.crypto.CryptoUtils;
import com.founderz.common.vo.ValueObject;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;

public record SecuredRepaymentId(
        @JsonValue
        String repaymentId
) implements ValueObject.StringValueObject {
    public SecuredRepaymentId {
        assertArgumentNotEmpty(repaymentId, "상환의 아이디가 입력되지 않았습니다.");
    }

    public static SecuredRepaymentId create(final String repaymentId) {
        return new SecuredRepaymentId(repaymentId);
    }

    public RepaymentId toRepaymentId() {
        return RepaymentId.create(CryptoUtils.decrypt(repaymentId));
    }
}