package com.founderz.auth.application;

import com.founderz.common.vo.AccountId;
import com.founderz.common.vo.TelNumber;
import com.founderz.user.domain.UserDomainReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface AuthReadService {
    boolean existsByAccountId(AccountId accountId);
    boolean existsByTel(TelNumber tel);
}

@Service
@RequiredArgsConstructor
class AuthReadServiceImpl implements AuthReadService {
    private final UserDomainReader reader;

    @Override
    public boolean existsByAccountId(final AccountId accountId) {
        return reader.existsByAccountId(accountId);
    }

    @Override
    public boolean existsByTel(final TelNumber tel) {
        return reader.existsByTel(tel);
    }
}
