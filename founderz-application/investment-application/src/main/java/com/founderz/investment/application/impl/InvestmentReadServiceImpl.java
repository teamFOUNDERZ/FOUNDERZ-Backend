package com.founderz.investment.application.impl;

import com.founderz.business.application.BusinessReadService;
import com.founderz.common.exception.DataNotFoundException;
import com.founderz.common.vo.investment.InvestmentId;
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

    @Override
    public InvestmentDto getById(InvestmentId investmentId) {
        return reader.findById(investmentId)
                .orElseThrow(() -> new DataNotFoundException("투자 요청을 찾지 못했습니다."));
    }
}
