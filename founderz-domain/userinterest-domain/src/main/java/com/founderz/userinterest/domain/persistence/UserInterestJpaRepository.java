package com.founderz.userinterest.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface UserInterestJpaRepository extends JpaRepository<UserInterestEntity, Long> {
    List<UserInterestEntity> findAllByUserId(Long userId);
}
