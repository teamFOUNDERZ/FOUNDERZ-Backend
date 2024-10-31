package com.founderz.tag.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Entity
@Table(name = "tag_founderz_v1")
class TagEntity {
    @EmbeddedId
    private TagId id;

    record TagId(
            Long id,
            String name
    ) implements Serializable {
    }
}