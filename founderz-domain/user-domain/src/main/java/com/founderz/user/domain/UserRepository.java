package com.founderz.user.domain;

import com.founderz.common.vo.AccountId;
import com.founderz.common.vo.TelNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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

    @Override
    public boolean existsByAccountId(final AccountId accountId) {
        return jpaRepository.existsByAccountId(accountId.accountId());
    }

    @Override
    public boolean existsByTel(final TelNumber tel) {
        return jpaRepository.existsByTel(tel.tel());
    }

    @Override
    public Optional<UserDomainDto> findByAccountId(final AccountId accountId) {
        final var entityOptional = jpaRepository.findByAccountId(accountId.accountId());
        return mapper.toOptionalDto(entityOptional);
    }

    @Override
    public Optional<UserDomainDto> findByTel(final TelNumber tel) {
        final var entityOptional = jpaRepository.findByTel(tel.tel());
        return mapper.toOptionalDto(entityOptional);
    }
}
