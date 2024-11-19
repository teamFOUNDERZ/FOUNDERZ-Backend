package com.founderz.internal.function.Interest;

import com.founderz.common.vo.user.UserId;
import com.founderz.internal.data.userinterest.UserInterestDto;

import java.util.List;

public interface InterestReader {
    /**
     * 현재 사용자의 관심사 목록 조회를 위한 메서드
     *
     * @param userId 사용자 아이디
     * @return 현재 사용자의 관심사 목록
     */
    List<UserInterestDto> findAllByUserId(UserId userId);
}
