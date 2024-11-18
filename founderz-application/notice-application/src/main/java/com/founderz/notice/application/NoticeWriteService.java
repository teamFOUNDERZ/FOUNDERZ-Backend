package com.founderz.notice.application;

import com.founderz.internal.data.notice.NoticeDto;

public interface NoticeWriteService {
    NoticeDto save(NoticeDto dto);
}
