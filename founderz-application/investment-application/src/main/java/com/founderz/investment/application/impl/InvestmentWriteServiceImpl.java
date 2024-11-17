package com.founderz.investment.application.impl;

import com.founderz.internal.data.investment.InvestmentDto;
import com.founderz.internal.function.security.CurrentUser;
import com.founderz.investment.application.InvestmentWriteService;
import com.founderz.investment.domain.InvestmentDomainWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class InvestmentWriteServiceImpl implements InvestmentWriteService {
    private final InvestmentDomainWriter writer;
    private final CurrentUser currentUser;

    @Override
    public void request(final InvestmentDto dto) {
        writer.save(dto.setInvestorName(currentUser.get().name()));
    }
}
