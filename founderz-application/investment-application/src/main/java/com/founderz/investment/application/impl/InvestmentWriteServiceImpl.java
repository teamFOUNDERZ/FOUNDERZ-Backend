package com.founderz.investment.application.impl;

import com.founderz.business.application.BusinessReadService;
import com.founderz.common.exception.BadRequestException;
import com.founderz.common.exception.DataNotFoundException;
import com.founderz.common.vo.investment.InvestmentId;
import com.founderz.common.vo.investment.InvestmentStatus;
import com.founderz.common.vo.notice.NoticeContent;
import com.founderz.common.vo.notice.NoticeType;
import com.founderz.internal.data.investment.InvestmentDto;
import com.founderz.internal.event.NoticeAddEvent;
import com.founderz.internal.function.security.CurrentUser;
import com.founderz.investment.application.InvestmentWriteService;
import com.founderz.investment.domain.InvestmentDomainReader;
import com.founderz.investment.domain.InvestmentDomainWriter;
import com.founderz.user.application.UserReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class InvestmentWriteServiceImpl implements InvestmentWriteService {
    private final InvestmentDomainWriter writer;
    private final InvestmentDomainReader reader;
    private final CurrentUser currentUser;
    private final BusinessReadService businessReadService;
    private final UserReadService userReadService;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void request(final InvestmentDto dto) {
        final var business = businessReadService.getById(dto.businessId());
        final var investor = currentUser.get();
        final var investee = userReadService.getByAccountId(business.writerAccountId());

        writer.save(dto.initInvestmentDto(business.businessName(), investor.accountId(), investor.name(), investee.name()));

        eventPublisher.publishEvent(NoticeAddEvent.create(
                NoticeType.INVESTMENT_REQUEST,
                investee.userId(),
                NoticeContent.create(String.format(
                        "%s님이 \"%s\"에 %l원 투자를 원하고 있어요.",
                        investor.name(),
                        business.businessName(),
                        dto.investmentAmount())
        )));
    }

    @Override
    public void changeStatus(InvestmentId investmentId) {
        final var investment = reader.findById(investmentId)
                .orElseThrow(() -> new DataNotFoundException("투자을 찾지 못했습니다."));

        final InvestmentStatus investmentStatus = switch (investment.investmentStatus().status()) {
            case "WRITING", "REJECTED" -> InvestmentStatus.create("COMPLETE");
            case "COMPLETE" -> InvestmentStatus.create("REJECTED");
            default -> throw new BadRequestException("입력된 투자의 상태가 유효하지 않습니다.");
        };

        //writer.save(investment.changeInvestmentStatus(investmentStatus));
    }
}
