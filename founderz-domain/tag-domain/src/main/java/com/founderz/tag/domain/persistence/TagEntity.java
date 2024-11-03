package com.founderz.tag.domain.persistence;

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
    private TagEntityId id;
}

record TagEntityId(
        Long id,
        String name
) implements Serializable {
    public static TagEntityId create(Long id, String name) {
        return new TagEntityId(id, name);
    }
}
