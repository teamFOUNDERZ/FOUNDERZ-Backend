package com.founderz.tag.domain.persistence;

import com.founderz.common.vo.tag.TagName;
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
    public Optional<TagDto> findByName(final TagName tagName) {
        final var entity = jpaRepository.findById_Name(tagName.tagName());
        return mapper.toOptionalDto(entity);
    }

    @Override
    public void save(final TagDto dto) {
        final var entity = mapper.toEntity(dto);
        jpaRepository.save(entity);
    }

    @Override
    public void delete(final TagId tagId) {
        jpaRepository.deleteById_Id(tagId.tagId());
    }

    @Override
    public List<TagDto> findAllByIds(final List<Long> ids) {
        return jpaRepository.findAllByIdIdIn(ids).stream()
                .map(mapper::toDto)
                .toList();
    }
}
