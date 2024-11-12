package com.founderz.sector.domain.presistence;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "founderz_sector_v1")
class SectorEntity {
    @EmbeddedId
    private SectorEntityId id;

    @Column(nullable = false, length = 10)
    private String cacheTagName;

}

record SectorEntityId(
        Long businessId,
        Long tagId
) implements Serializable {
    public static SectorEntityId create(Long businessId, Long tagId) {
        return new SectorEntityId(businessId, tagId);
    }
}
