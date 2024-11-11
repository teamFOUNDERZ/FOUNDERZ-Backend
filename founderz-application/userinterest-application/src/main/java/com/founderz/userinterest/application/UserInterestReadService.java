package com.founderz.userinterest.application;

import com.founderz.internal.data.userinterest.UserInterestDto;

import java.util.List;

/**
 * <p>바운디드 컨텍스트: UserInterest(사용자 관심사)</p>
 * <p>책임: 사용자 관심사 읽기 작업</p>
 * <p>계층: application</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>현재 사용자의 관심사 목록 조회</li>
 * </ul>
 */
public interface UserInterestReadService {
    /**
     * 현재 사용자의 정보를 통해 관심사를 조회하는 메서드
     *
     * @return 현재 사용자의 관심사 목록
     */
    List<UserInterestDto> getCurrentUserInterests();
}
