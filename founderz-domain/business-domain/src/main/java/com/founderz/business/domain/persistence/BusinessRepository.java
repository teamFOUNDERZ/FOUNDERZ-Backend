package com.founderz.business.domain.persistence;

import com.founderz.business.domain.BusinessDomainReader;
import com.founderz.business.domain.BusinessDomainWriter;
import com.founderz.internal.data.business.BusinessDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
class BusinessRepository implements BusinessDomainReader, BusinessDomainWriter {
    private final BusinessJpaRepository jpaRepository;
    private final BusinessDomainMapper mapper;

    @Override
    public BusinessDto save(final BusinessDto dto) {
        final var entity = mapper.toEntity(dto);
        final var saveEntity = jpaRepository.save(entity);

        return mapper.toDto(saveEntity);
    }
}