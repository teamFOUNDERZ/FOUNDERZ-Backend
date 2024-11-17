package com.founderz.notice.domain.persistence;

import com.founderz.common.vo.notice.NoticeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "founderz_notice_v1", indexes = @Index(name = "idx_user_id", columnList = "user_id"))
class NoticeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private NoticeType type;

    @Column(length = 100, nullable = false)
    private String content;

    @Column(name = "user_id", nullable = false)
    private Long userId;

}
