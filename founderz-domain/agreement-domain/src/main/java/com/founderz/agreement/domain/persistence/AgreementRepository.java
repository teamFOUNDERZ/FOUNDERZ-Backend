package com.founderz.agreement.domain.persistence;

import com.founderz.agreement.domain.AgreementDomainReader;
import com.founderz.agreement.domain.AgreementDomainWriter;
import com.founderz.common.vo.investment.InvestmentId;
import com.founderz.internal.data.agreement.AgreementDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
class AgreementRepository implements AgreementDomainReader, AgreementDomainWriter {
    private final AgreementJpaRepository jpaRepository;
    private final AgreementDomainMapper mapper;

    @Override
    public AgreementDto save(final AgreementDto dto) {
        final var entity = mapper.toEntity(dto);
        final var saveEntity = jpaRepository.save(entity);

        return mapper.toDto(saveEntity);
    }

    @Override
    public Optional<AgreementDto> findByInvestmentId(final InvestmentId investmentId) {
        final var entity = jpaRepository.findByInvestmentId(investmentId.investmentId());

        return mapper.toOptionalDto(entity);
    }
}
