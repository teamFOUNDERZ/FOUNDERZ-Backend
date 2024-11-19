package com.founderz.agreement.presentation;

import com.founderz.agreement.application.AgreementReadService;
import com.founderz.agreement.presentation.document.AgreementReadDocumentation;
import com.founderz.agreement.presentation.response.AgreementDetails;
import com.founderz.common.presentation.annotation.WebRestAdapter;
import com.founderz.common.vo.investment.SecuredInvestmentId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@WebRestAdapter("/api/agreement")
class AgreementReadAdapter implements AgreementReadDocumentation {
    private final AgreementReadService agreementReadService;

    @GetMapping("/{investmentId}")
    public AgreementDetails getByInvestmentId(@PathVariable final SecuredInvestmentId investmentId) {
        final var agreementWithRepayments = agreementReadService.getByInvestmentId(investmentId.toInvestmentId());

        return AgreementDetails.create(agreementWithRepayments.agreementDto(), agreementWithRepayments.repaymentDtos());
    }
}