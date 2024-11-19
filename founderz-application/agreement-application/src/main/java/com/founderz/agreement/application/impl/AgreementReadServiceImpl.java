package com.founderz.agreement.application.impl;

import com.founderz.agreement.application.AgreementReadService;
import com.founderz.agreement.domain.AgreementDomainReader;
import com.founderz.common.exception.DataNotFoundException;
import com.founderz.common.vo.business.BusinessId;
import com.founderz.common.vo.investment.InvestmentId;
import com.founderz.internal.data.agreement.AgreementDto;
import com.founderz.internal.data.agreement.AgreementWithRepaymentDto;
import com.founderz.internal.data.business.BusinessDto;
import com.founderz.internal.function.repayment.RepaymentReader;
import com.founderz.repayment.application.RepaymentWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AgreementReadServiceImpl implements AgreementReadService {
    private final AgreementDomainReader reader;
    private final RepaymentReader repaymentReader;

    @Override
    public AgreementWithRepaymentDto getByInvestmentId(InvestmentId investmentId) {
        final var agreement = reader.findByInvestmentId(investmentId)
                .orElseThrow(() -> new DataNotFoundException("자금 투자 계약서를 찾지 못했습니다."));
        final var repayment = repaymentReader.findAllByInvestmentId(investmentId);

        return AgreementWithRepaymentDto.create(agreement, repayment);
    }
}
