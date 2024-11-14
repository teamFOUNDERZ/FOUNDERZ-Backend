package com.founderz.business.domain.persistence;

import com.founderz.business.domain.BusinessDomainReader;
import com.founderz.business.domain.BusinessDomainWriter;
import com.founderz.common.vo.business.BusinessId;
import com.founderz.internal.data.business.BusinessDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<BusinessDto> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public Optional<BusinessDto> findById(final BusinessId businessId) {
        final var entity = jpaRepository.findById(businessId.businessId());
        return mapper.toOptionalDto(entity);
    }
}