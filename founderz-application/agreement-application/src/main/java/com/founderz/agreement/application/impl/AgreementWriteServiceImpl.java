package com.founderz.agreement.application.impl;

import com.founderz.agreement.application.AgreementWriteService;
import com.founderz.agreement.domain.AgreementDomainWriter;
import com.founderz.business.application.BusinessReadService;
import com.founderz.common.vo.notice.NoticeContent;
import com.founderz.common.vo.notice.NoticeType;
import com.founderz.internal.data.agreement.AgreementDto;
import com.founderz.internal.event.NoticeAddEvent;
import com.founderz.investment.application.InvestmentReadService;
import com.founderz.investment.application.InvestmentWriteService;
import com.founderz.user.application.UserReadService;
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
    private final InvestmentReadService investmentReadService;
    private final UserReadService userReadService;
    private final ApplicationEventPublisher eventPublisher;
    private final BusinessReadService businessReadService;

    public void write(AgreementDto dto) {
        writer.save(dto);
        final var investment = investmentReadService.getById(dto.investmentId());
        final var business = businessReadService.getById(investment.businessId());
        final var investor = userReadService.getByAccountId(investment.investorAccountId());
        final var investee = userReadService.getByAccountId(business.writerAccountId());

        if ("WRITING".equals(investment.investmentStatus().status()) ||
                "REJECTED".equals(investment.investmentStatus().status())) {
            eventPublisher.publishEvent(NoticeAddEvent.create(
                    NoticeType.INVESTMENT_AGREEMENT_REVIEW,
                    investor.userId(),
                    NoticeContent.create(String.format(
                            "\"%s\"의 %s님이 자금 투자 계약서 작성을 마쳤어요.\n이상 내용이 없는지 확인해 보세요.",
                            investment.businessName(),
                            investment.investeeName()
                    ))));
        } else if(investment.investmentStatus().status().equals("COMPLETE")) {
            eventPublisher.publishEvent(NoticeAddEvent.create(
                    NoticeType.INVESTMENT_AGREEMENT_MODIFY_REQUEST,
                    investee.userId(),
                    NoticeContent.create(String.format(
                            "%s님이 자금 투자 계약서 수정을 요청했어요.",
                            investor.name()
                    ))));
        }

        investmentWriteService.changeStatus(dto.investmentId());
    }
}