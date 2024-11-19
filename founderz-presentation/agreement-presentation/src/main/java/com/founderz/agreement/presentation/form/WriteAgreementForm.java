package com.founderz.agreement.presentation.form;

import java.util.List;

public record WriteAgreementForm(
        AgreementForm agreementForm,
        List<RepaymentForm> repaymentForms
) {
}