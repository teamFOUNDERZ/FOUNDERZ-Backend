package com.founderz.notice.domain;

import com.founderz.common.vo.notice.NoticeId;
import com.founderz.common.vo.user.UserId;
import com.founderz.internal.data.notice.NoticeDto;

import java.util.List;
import java.util.Optional;

public interface NoticeDomainReader {
    Optional<NoticeDto> findById(NoticeId noticeId);
    List<NoticeDto> findAllByUserId(UserId userId);
}
