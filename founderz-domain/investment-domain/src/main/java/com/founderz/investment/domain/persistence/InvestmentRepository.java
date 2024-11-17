package com.founderz.investment.domain.persistence;

import com.founderz.internal.data.investment.InvestmentDto;
import com.founderz.investment.domain.InvestmentDomainReader;
import com.founderz.investment.domain.InvestmentDomainWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
}
