package com.founderz.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByAccountId(String accountId);
    boolean existsByTel(String tel);
    Optional<UserEntity> findByAccountId(String accountId);
    Optional<UserEntity> findByTel(String tel);
}
