package com.founderz.tag.domain.persistence;

import com.founderz.common.vo.tag.TagId;
import com.founderz.tag.domain.TagDomainReader;
import com.founderz.tag.domain.TagDomainWriter;
import com.founderz.internal.data.tag.TagDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
class TagRepository implements TagDomainWriter, TagDomainReader {
    private final TagJpaRepository jpaRepository;
    private final TagDomainMapper mapper;

    @Override
    public List<TagDto> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public Optional<TagDto> findById(final TagId tagId) {
        final var entity = jpaRepository.findById_Id(tagId.tagId());
        return mapper.toOptionalDto(entity);
    }

    @Override
    public void save(final TagDto dto) {
        final var entity = mapper.toEntity(dto);
        final var savedEntity = jpaRepository.save(entity);

        mapper.toDto(savedEntity);
    }

    @Override
    public void delete(final TagId tagId) {
        jpaRepository.deleteById_Id(tagId.tagId());
    }
}
