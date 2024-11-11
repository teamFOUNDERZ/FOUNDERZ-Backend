package com.founderz.userinterest.application.impl;

import com.founderz.common.exception.DataNotFoundException;
import com.founderz.common.vo.tag.TagId;
import com.founderz.internal.data.userinterest.UserInterestDto;
import com.founderz.internal.function.security.CurrentUser;
import com.founderz.internal.function.tag.TagReader;
import com.founderz.userinterest.application.UserInterestWriteService;
import com.founderz.userinterest.domain.UserInterestDomainReader;
import com.founderz.userinterest.domain.UserInterestDomainWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
class UserInterestWriteServiceImpl implements UserInterestWriteService {
    private final UserInterestDomainWriter writer;
    private final UserInterestDomainReader reader;
    private final CurrentUser currentUser;
    private final TagReader tagReader;

    @Override
    public void addUserInterest(final UserInterestDto dto) {
        final var user = currentUser.get();

        if (!reader.existsByUserIdAndTagId(user.userId(), dto.tagId())) {
            final var tag = tagReader.findById(dto.tagId())
                    .orElseThrow(() -> new DataNotFoundException("태그를 찾지 못했습니다."));

            final var fixedDto = dto.setTagNameAndUserId(user.userId(), tag.name());
            writer.save(fixedDto);
        }
    }

    @Override
    public void removeUserInterest(final TagId tagId) {
        final var user = currentUser.get();
        writer.delete(user.userId(), tagId);
    }
}
