package com.founderz.userinterest.domain;

import com.founderz.common.vo.tag.TagId;
import com.founderz.common.vo.user.UserId;
import com.founderz.internal.data.userinterest.UserInterestDto;

import java.util.List;

/**
 * <p>바운디드 컨텍스트: UserInterest(사용자 관심사)</p>
 * <p>책임: 사용자 관심사 데이터베이스 테이블 읽기 작업</p>
 * <p>계층: domain</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>사용자의 관심사 목록 조회</li>
 *   <li>관심사 존재여부 조회</li>
 * </ul>
 */
public interface UserInterestDomainReader {
    /**
     * 현재 사용자의 관심사 목록 조회를 위한 메서드
     *
     * @param userId 사용자 아이디
     * @return 현재 사용자의 관심사 목록
     */
    List<UserInterestDto> findAllByUserId(UserId userId);

    /**
     * 관심사 존재여부 조회를 위한 메서드
     *
     * @param userId 사용자 아이디
     * @param tagId 태그 아이디
     * @return 관심사 존재 여부 (존재하면 true)
     */
    boolean existsByUserIdAndTagId(UserId userId, TagId tagId);
}
