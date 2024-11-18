package com.founderz.agreement.application.impl;

import com.founderz.agreement.application.AgreementWriteService;
import com.founderz.agreement.domain.AgreementDomainWriter;
import com.founderz.common.vo.notice.NoticeContent;
import com.founderz.common.vo.notice.NoticeType;
import com.founderz.internal.data.agreement.AgreementDto;
import com.founderz.internal.event.NoticeAddEvent;
import com.founderz.investment.application.InvestmentWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AgreementWriteServiceImpl implements AgreementWriteService {
    private final AgreementDomainWriter writer;
    private final InvestmentWriteService investmentWriteService;
    private final ApplicationEventPublisher eventPublisher;

    public void write(AgreementDto dto) {
        writer.save(dto);

        investmentWriteService.changeStatus(dto.investmentId());

//        eventPublisher.publishEvent(NoticeAddEvent.create(
//                NoticeType.INVESTMENT_AGREEMENT_REVIEW,
//                investee.userId(),
//                NoticeContent.create(String.format(
//                        "%s님이 \"%s\"에 %l원 투자를 원하고 있어요.",
//                        investor.name(),
//                        business.businessName(),
//                        dto.investmentAmount())
//                )));
    }
}
