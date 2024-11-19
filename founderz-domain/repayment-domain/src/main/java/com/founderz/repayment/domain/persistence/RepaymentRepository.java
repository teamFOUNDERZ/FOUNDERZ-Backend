package com.founderz.repayment.domain.persistence;

import com.founderz.common.vo.investment.InvestmentId;
import com.founderz.common.vo.user.AccountId;
import com.founderz.internal.data.business.BusinessDto;
import com.founderz.internal.data.repayment.RepaymentDto;
import com.founderz.repayment.domain.RepaymentDomainReader;
import com.founderz.repayment.domain.RepaymentDomainWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
class RepaymentRepository implements RepaymentDomainReader, RepaymentDomainWriter {
    private final RepaymentJpaRepository jpaRepository;
    private final RepaymentDomainMapper mapper;

    @Override
    public void saveAll(final List<RepaymentDto> dto) {
        final var entity = dto.stream()
                .map(mapper::toEntity)
                .toList();

        jpaRepository.saveAll(entity);
    }

    @Override
    public List<RepaymentDto> findAllByInvestmentId(final InvestmentId investmentId) {
        return jpaRepository.findAllByInvestmentId(investmentId.investmentId()).stream()
                .map(mapper::toDto)
                .toList();
    }
}
