package com.founderz.common.vo.areement;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.crypto.CryptoUtils;
import com.founderz.common.vo.ValueObject;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;

public record SecuredAgreementId(
        @JsonValue
        String agreementId
) implements ValueObject.StringValueObject {
    public SecuredAgreementId {
        assertArgumentNotEmpty(agreementId, "자금 투자 계약서의 아이디가 입력되지 않았습니다.");
    }

    public static SecuredAgreementId create(final String agreementId) {
        return new SecuredAgreementId(agreementId);
    }

    public AgreementId toAgreementId() {
        return AgreementId.create(CryptoUtils.decrypt(agreementId));
    }
}