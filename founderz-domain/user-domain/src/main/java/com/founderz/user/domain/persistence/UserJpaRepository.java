package com.founderz.user.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByAccountId(String accountId);
    boolean existsByPhoneNumber(String phoneNumber);
    Optional<UserEntity> findByAccountId(String accountId);
    Optional<UserEntity> findByPhoneNumber(String phoneNumber);
}
