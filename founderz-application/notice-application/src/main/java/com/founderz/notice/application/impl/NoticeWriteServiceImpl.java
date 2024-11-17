package com.founderz.notice.application.impl;

import com.founderz.internal.data.notice.NoticeDto;
import com.founderz.notice.application.NoticeWriteService;
import com.founderz.notice.domain.NoticeDomainWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
class NoticeWriteServiceImpl implements NoticeWriteService {
    private final NoticeDomainWriter writer;

    @Override
    public NoticeDto save(final NoticeDto dto) {
        return writer.save(dto);
    }
}
