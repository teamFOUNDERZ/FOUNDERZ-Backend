package com.founderz.investment.domain.persistence;

import com.founderz.common.vo.business.BusinessId;
import com.founderz.common.vo.investment.InvestmentId;
import com.founderz.common.vo.investment.InvestmentStatus;
import com.founderz.common.vo.user.AccountId;
import com.founderz.internal.data.investment.InvestmentDto;
import com.founderz.investment.domain.InvestmentDomainReader;
import com.founderz.investment.domain.InvestmentDomainWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
class InvestmentRepository implements InvestmentDomainReader, InvestmentDomainWriter {
    private final InvestmentJpaRepository jpaRepository;
    private final InvestmentDomainMapper mapper;

    @Override
    public InvestmentDto save(final InvestmentDto dto) {
        final var entity = mapper.toEntity(dto);
        final var saveEntity = jpaRepository.save(entity);

        return mapper.toDto(saveEntity);
    }

    @Override
    public List<InvestmentDto> findAllByInvestorAccountId(AccountId accountId) {
        return jpaRepository.findAllByInvestorAccountId(accountId.accountId()).stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public List<InvestmentDto> findAllBusinessIdIn(List<BusinessId> businessIds) {
        return jpaRepository.findAllByStatusAndBusinessIdIn(InvestmentEntity.Status.WRITING, businessIds.stream().map(BusinessId::businessId).toList())
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public Optional<InvestmentDto> findById(final InvestmentId investmentId) {
        final var entity = jpaRepository.findById(investmentId.investmentId());
        return mapper.toOptionalDto(entity);
    }
}
