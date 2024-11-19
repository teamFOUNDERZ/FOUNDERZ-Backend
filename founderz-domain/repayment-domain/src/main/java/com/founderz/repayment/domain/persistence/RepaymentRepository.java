package com.founderz.repayment.domain.persistence;

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
}
