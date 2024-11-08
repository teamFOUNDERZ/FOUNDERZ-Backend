package com.founderz.tag.domain.persistence;

import com.founderz.common.vo.TagId;
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
    private final TagJpaRepository repository;
    private final TagDomainMapper mapper;

    @Override
    public List<TagDto> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public Optional<TagDto> findById(final TagId tagId) {
        final var entity = repository.findById_Id(tagId.tagId());
        return mapper.toOptionalDto(entity);
    }

    @Override
    public TagDto save(final TagDto dto) {
        final var entity = mapper.toEntity(dto);
        final var savedEntity = repository.save(entity);

        return mapper.toDto(savedEntity);
    }
}
