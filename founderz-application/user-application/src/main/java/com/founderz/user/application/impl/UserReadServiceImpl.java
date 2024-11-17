package com.founderz.user.application.impl;

import com.founderz.common.exception.DataNotFoundException;
import com.founderz.common.vo.user.AccountId;
import com.founderz.internal.data.user.UserDto;
import com.founderz.user.application.UserReadService;
import com.founderz.user.domain.UserDomainReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserReadServiceImpl implements UserReadService {
    private final UserDomainReader reader;

    @Override
    public UserDto getByAccountId(AccountId accountId) {
        return reader.findByAccountId(accountId)
                .orElseThrow(() -> new DataNotFoundException("사용자를 찾지 못했습니다."));
    }
}
