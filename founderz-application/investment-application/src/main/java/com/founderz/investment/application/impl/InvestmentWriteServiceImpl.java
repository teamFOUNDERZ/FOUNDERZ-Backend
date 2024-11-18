package com.founderz.investment.application.impl;

import com.founderz.business.application.BusinessReadService;
import com.founderz.internal.data.investment.InvestmentDto;
import com.founderz.internal.function.security.CurrentUser;
import com.founderz.investment.application.InvestmentWriteService;
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
    private final CurrentUser currentUser;
    private final BusinessReadService businessReadService;
    private final UserReadService userReadService;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void request(final InvestmentDto dto) {
        final var business = businessReadService.getById(dto.businessId());
        final var investee = userReadService.getByAccountId(business.writerAccountId());

        writer.save(dto.initInvestmentDto(business.businessName(), currentUser.get().accountId(), currentUser.get().name(), investee.name()));

        eventPublisher.publishEvent(NoticeAddEvent.cre);
    }
}
