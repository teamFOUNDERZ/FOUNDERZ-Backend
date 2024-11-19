package com.founderz.user.application;

import com.founderz.common.vo.user.AccountId;
import com.founderz.internal.data.user.UserDto;
import com.founderz.internal.data.user.UserWithInterestsDto;

/**
 * <p>바운디드 컨텍스트: User(사용자)</p>
 * <p>책임: 사용자 읽기 작업</p>
 * <p>계층: application</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>accountId로 유저 조회</li>
 * </ul>
 */
public interface UserReadService {
    /**
     * accountId를 통한 조회를 위한 메서드
     *
     * @return 유저 정보
     */
    UserDto getByAccountId(AccountId accountId);

    UserWithInterestsDto getCurrentUserInfo();
}
