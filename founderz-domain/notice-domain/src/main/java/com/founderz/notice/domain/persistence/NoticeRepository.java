package com.founderz.notice.domain.persistence;

import com.founderz.common.vo.notice.NoticeId;
import com.founderz.common.vo.user.UserId;
import com.founderz.internal.data.notice.NoticeDto;
import com.founderz.notice.domain.NoticeDomainReader;
import com.founderz.notice.domain.NoticeDomainWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
class NoticeRepository implements NoticeDomainReader, NoticeDomainWriter {
    private final NoticeJpaRepository jpaRepository;
    private final NoticeDomainMapper mapper;

    @Override
    public NoticeDto save(final NoticeDto dto) {
        final var entity = mapper.toEntity(dto);
        final var savedEntity = jpaRepository.save(entity);

        return mapper.toDto(savedEntity);
    }

    @Override
    public Optional<NoticeDto> findById(final NoticeId noticeId) {
        final var entity = jpaRepository.findById(noticeId.noticeId());

        return mapper.toOptionalDto(entity);
    }

    @Override
    public List<NoticeDto> findAllByUserId(final UserId userId) {
        final var entities = jpaRepository.findAllByUserId(userId.userId());

        return mapper.toListDto(entities);
    }
}
