package com.founderz.common.vo.areement;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.crypto.CryptoUtils;
import com.founderz.common.vo.ValueObject;

public record AgreementId(
        @JsonValue
        Long agreementId
) implements ValueObject.LongValueObject {
    public static AgreementId create(final Long agreementId) {
        return new AgreementId(agreementId);
    }

    public SecuredAgreementId toSecuredAgreementId() {
        return SecuredAgreementId.create(CryptoUtils.encrypt(agreementId));
    }
}
