package com.founderz.userinterest.domain.persistence;

import com.founderz.common.vo.user.UserId;
import com.founderz.internal.data.userinterest.UserInterestDto;
import com.founderz.userinterest.domain.UserInterestDomainReader;
import com.founderz.userinterest.domain.UserInterestDomainWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
class UserInterestRepository implements UserInterestDomainReader, UserInterestDomainWriter {
    private final UserInterestJpaRepository jpaRepository;
    private final UserInterestDomainMapper mapper;

    @Override
    public List<UserInterestDto> findAllByUserId(final UserId userId) {
        final var entities = jpaRepository.findAllByUserId(userId.userId());

        return entities.stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public void save(final UserInterestDto dto) {
        final var entity = mapper.toEntity(dto);

        jpaRepository.save(entity);
    }
}
