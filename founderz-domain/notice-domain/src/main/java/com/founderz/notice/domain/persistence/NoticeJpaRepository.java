package com.founderz.notice.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface NoticeJpaRepository extends JpaRepository<NoticeEntity, Long> {
    List<NoticeEntity> findAllByUserId(Long userId);
}
