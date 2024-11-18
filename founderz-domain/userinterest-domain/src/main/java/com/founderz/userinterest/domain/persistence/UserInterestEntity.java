package com.founderz.userinterest.domain.persistence;

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
@Table(name = "founderz_user_interest_v1")
class UserInterestEntity {
    @EmbeddedId
    private UserInterestEntityId id;

    @Column(nullable = false, length = 10)
    private String cacheTagName;

}

record UserInterestEntityId(
        Long userId,
        Long tagId
) implements Serializable {
    public static UserInterestEntityId create(Long userId, Long tagId) {
        return new UserInterestEntityId(userId, tagId);
    }
}
