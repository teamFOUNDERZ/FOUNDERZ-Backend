package com.founderz.tag.domain;

import org.springframework.data.jpa.repository.JpaRepository;

interface TagJpaRepository extends JpaRepository<TagEntity, TagEntity.TagId> {
}
