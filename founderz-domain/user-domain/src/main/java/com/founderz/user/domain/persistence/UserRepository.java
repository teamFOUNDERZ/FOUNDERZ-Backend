package com.founderz.user.domain.persistence;

import com.founderz.common.vo.user.AccountId;
import com.founderz.common.vo.user.PhoneNumber;
import com.founderz.internal.data.user.UserDto;
import com.founderz.user.domain.UserDomainReader;
import com.founderz.user.domain.UserDomainWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
class UserRepository implements UserDomainReader, UserDomainWriter {
    private final UserJpaRepository jpaRepository;
    private final UserDomainMapper mapper;

    @Override
    public UserDto save(final UserDto dto) {
        final var entity = mapper.toEntity(dto);
        final var savedEntity = jpaRepository.save(entity);

        return mapper.toDto(savedEntity);
    }

    @Override
    public boolean existsByAccountIdOrPhoneNumber(final AccountId accountId, final PhoneNumber tel) {
        return jpaRepository.existsByAccountIdOrPhoneNumber(accountId.accountId(), tel.phoneNumber());
    }

    @Override
    public boolean existsByAccountId(final AccountId accountId) {
        return jpaRepository.existsByAccountId(accountId.accountId());
    }

    @Override
    public boolean existsByTel(final PhoneNumber tel) {
        return jpaRepository.existsByPhoneNumber(tel.phoneNumber());
    }

    @Override
    public Optional<UserDto> findByAccountId(final AccountId accountId) {
        final var entityOptional = jpaRepository.findByAccountId(accountId.accountId());
        return mapper.toOptionalDto(entityOptional);
    }

    @Override
    public Optional<UserDto> findByTel(final PhoneNumber tel) {
        final var entityOptional = jpaRepository.findByPhoneNumber(tel.phoneNumber());
        return mapper.toOptionalDto(entityOptional);
    }
}
