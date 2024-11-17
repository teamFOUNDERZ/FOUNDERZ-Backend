package com.founderz.notice.domain;

import com.founderz.internal.data.notice.NoticeDto;

public interface NoticeDomainWriter {
    NoticeDto save(NoticeDto dto);
}
