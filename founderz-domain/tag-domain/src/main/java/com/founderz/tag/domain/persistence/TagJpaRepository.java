package com.founderz.tag.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

interface TagJpaRepository extends JpaRepository<TagEntity, TagEntityId> {
    Optional<TagEntity> findById_Id(Long id);
    List<TagEntity> findAllByIdIdIn(List<Long> ids);
    void deleteById_Id(Long id);
    Optional<TagEntity> findById_Name(String name);
}
