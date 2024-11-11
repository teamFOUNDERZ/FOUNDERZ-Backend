package com.founderz.tag.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface TagJpaRepository extends JpaRepository<TagEntity, Long> {
    List<TagEntity> findAllByIdIn(List<Long> ids);
    Optional<TagEntity> findByName(String name);
}
