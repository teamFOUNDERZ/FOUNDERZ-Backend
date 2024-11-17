package com.founderz.investment.application.impl;

import com.founderz.business.application.BusinessReadService;
import com.founderz.internal.data.business.BusinessDto;
import com.founderz.internal.data.investment.InvestmentDto;
import com.founderz.internal.function.security.CurrentUser;
import com.founderz.investment.application.InvestmentReadService;
import com.founderz.investment.domain.InvestmentDomainReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InvestmentReadServiceImpl implements InvestmentReadService {
    private final InvestmentDomainReader reader;
    private final BusinessReadService businessReadService;
    private final CurrentUser currentUser;

    @Override
    public List<InvestmentDto> getReceivedInvestmentRequest() {
        final var list = businessReadService.getAllByWriterAccountId(currentUser.get().accountId());

        return reader.findAllBusinessIdIn(list.stream().map(BusinessDto::businessId).toList());
    }

    @Override
    public List<InvestmentDto> getMyInvestment() {
        return reader.findAllByInvestorAccountId(currentUser.get().accountId());
    }
}
