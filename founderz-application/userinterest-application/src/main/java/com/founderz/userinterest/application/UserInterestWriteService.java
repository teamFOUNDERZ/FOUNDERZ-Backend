package com.founderz.userinterest.application;

import com.founderz.common.vo.tag.TagId;
import com.founderz.internal.data.userinterest.UserInterestDto;

/**
 * <p>바운디드 컨텍스트: UserInterest(사용자 관심사)</p>
 * <p>책임: 사용자 관심사 쓰기 작업</p>
 * <p>계층: application</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>사용자 관심사 등록</li>
 * </ul>
 */
public interface UserInterestWriteService {
    /**
     * 사용자의 관심사를 등록하는 메서드
     *
     * @param dto 관심사 정보
     */
    void addUserInterest(UserInterestDto dto);

    /**
     * 사용자의 관심사를 삭제하는 메서드
     *
     * @param tagId 삭제할 태그 아이디
     */
    void removeUserInterest(TagId tagId);
}
