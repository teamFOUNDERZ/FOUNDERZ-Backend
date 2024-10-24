package com.founderz.user.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
class UserRepository implements UserDomainReader, UserDomainWriter {
    private final UserJpaRepository jpaRepository;
    private final UserDomainMapper mapper;

    @Override
    public void save(final UserDomainDto dto) {
        final var entity = mapper.toEntity(dto);
        jpaRepository.save(entity);
    }
}
