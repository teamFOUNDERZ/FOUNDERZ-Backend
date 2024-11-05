package com.founderz.auth.application.impl;

import com.founderz.auth.application.AuthReadService;
import com.founderz.common.vo.user.AccountId;
import com.founderz.common.vo.user.PhoneNumber;
import com.founderz.user.domain.UserDomainReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class AuthReadServiceImpl implements AuthReadService {
    private final UserDomainReader reader;

    @Override
    public boolean isRegisteredAccount(final AccountId accountId) {
        return reader.existsByAccountId(accountId);
    }

    @Override
    public boolean isRegisteredPhoneNumber(final PhoneNumber tel) {
        return reader.existsByTel(tel);
    }
}
