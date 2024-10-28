package com.founderz.user.domain;

import com.founderz.common.vo.AccountId;
import com.founderz.common.vo.TelNumber;

import java.util.Optional;

public interface UserDomainReader {
    boolean existsByAccountId(AccountId accountId);
    boolean existsByTel(TelNumber tel);
    Optional<UserDomainDto> findByAccountId(AccountId accountId);
    Optional<UserDomainDto> findByTel(TelNumber tel);
}
