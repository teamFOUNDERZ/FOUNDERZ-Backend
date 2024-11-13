package com.founderz.userinterest.application;

import com.founderz.common.vo.tag.TagId;
import com.founderz.common.vo.user.UserId;
import com.founderz.internal.data.userinterest.UserInterestDto;

import java.util.List;

/**
 * <p>바운디드 컨텍스트: UserInterest(사용자 관심사)</p>
 * <p>책임: 사용자 관심사 쓰기 작업</p>
 * <p>계층: application</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>사용자 관심사 단일 등록</li>
 *   <li>사용자 관심사 목록 등록</li>
 *   <li>사용자 관심사 삭제</li>
 * </ul>
 */
public interface UserInterestWriteService {
    /**
     * 사용자의 관심사를 단일 등록하는 메서드
     *
     * @param dto 관심사 정보
     */
    void addUserInterest(UserInterestDto dto);

    /**
     * 사용자 관심사 목록을 등록하는 메서드
     * <p>Event 처리에 사용되는 메서드, PRESENTATION layer에서 접근 불허용</p>
     *
     * @param userId 사용자 아이디
     * @param tagIds 태그 아이디 목록
     */
    void addUserInterests(UserId userId, List<TagId> tagIds);

    /**
     * 사용자의 관심사를 삭제하는 메서드
     *
     * @param tagId 삭제할 태그 아이디
     */
    void removeUserInterest(TagId tagId);
}
