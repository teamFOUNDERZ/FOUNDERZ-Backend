package com.founderz.sector.domain.presistence;

import com.founderz.common.vo.business.BusinessId;
import com.founderz.common.vo.tag.TagId;
import com.founderz.common.vo.user.UserId;
import com.founderz.internal.data.sector.SectorDto;
import com.founderz.sector.domain.SectorDomainReader;
import com.founderz.sector.domain.SectorDomainWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
class SectorRepository implements SectorDomainReader, SectorDomainWriter {
    private final SectorJpaRepository jpaRepository;
    private final SectorDomainMapper mapper;

    @Override
    public void save(final SectorDto dto) {
        final var entity = mapper.toEntity(dto);
        jpaRepository.save(entity);
    }

    @Override
    public void saveAll(final List<SectorDto> dtoList) {
        final var entities = mapper.toEntityList(dtoList);
        jpaRepository.saveAll(entities);
    }

    @Override
    public void delete(final BusinessId businessId, final TagId tagId) {
        jpaRepository.deleteById(SectorEntityId.create(businessId.businessId(), tagId.tagId()));
    }

    @Override
    public List<SectorDto> getAllByBusinessId(final BusinessId businessId) {
        return jpaRepository.findAllById_BusinessId(businessId.businessId()).stream()
                .map(mapper::toDto)
                .toList();
    }
}
