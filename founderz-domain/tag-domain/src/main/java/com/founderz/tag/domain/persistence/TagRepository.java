package com.founderz.tag.domain.persistence;

import com.founderz.common.vo.TagId;
import com.founderz.tag.domain.TagDomainReader;
import com.founderz.tag.domain.TagDomainWriter;
import com.founderz.tag.domain.dto.TagDomainDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
class TagRepository implements TagDomainWriter, TagDomainReader {
    private final TagJpaRepository repository;
    private final TagDomainMapper mapper;

    @Override
    public List<TagDomainDto> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public Optional<TagDomainDto> findById(final TagId tagId) {
        final var entity = repository.findById_Id(tagId.tagId());
        return mapper.toOptionalDto(entity);
    }

    @Override
    public TagDomainDto save(final TagDomainDto dto) {
        final var entity = mapper.toEntity(dto);
        final var savedEntity = repository.save(entity);

        return mapper.toDto(savedEntity);
    }
}
