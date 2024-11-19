package com.founderz.repayment.application.impl;

import com.founderz.internal.data.repayment.RepaymentDto;
import com.founderz.repayment.application.RepaymentWriteService;
import com.founderz.repayment.domain.RepaymentDomainWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RepaymentWriteServiceImpl implements RepaymentWriteService {
    private final RepaymentDomainWriter writer;

    @Override
    public void saveAll(final List<RepaymentDto> repaymentDtoList) {
        writer.saveAll(repaymentDtoList);
    }
}
