package com.founderz.userinterest.domain.persistence;

import com.founderz.common.vo.tag.TagId;
import com.founderz.common.vo.user.UserId;
import com.founderz.internal.data.userinterest.UserInterestDto;
import com.founderz.userinterest.domain.UserInterestDomainReader;
import com.founderz.userinterest.domain.UserInterestDomainWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
class UserInterestRepository implements UserInterestDomainReader, UserInterestDomainWriter {
    private final UserInterestJpaRepository jpaRepository;
    private final UserInterestDomainMapper mapper;

    @Override
    public List<UserInterestDto> findAllByUserId(final UserId userId) {
        final var entities = jpaRepository.findAllById_UserId(userId.userId());

        return entities.stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public boolean existsByUserIdAndTagId(final UserId userId, final TagId tagId) {
        return jpaRepository.existsById(UserInterestEntityId.create(userId.userId(), tagId.tagId()));
    }

    @Override
    public void save(final UserInterestDto dto) {
        final var entity = mapper.toEntity(dto);

        jpaRepository.save(entity);
    }

    @Override
    public void saveAll(final List<UserInterestDto> dtoList) {
        final var entities = mapper.toEntityList(dtoList);
        jpaRepository.saveAll(entities);
    }

    @Override
    public void delete(final UserId userId, final TagId tagId) {
        jpaRepository.deleteById(UserInterestEntityId.create(userId.userId(), tagId.tagId()));
    }
}
