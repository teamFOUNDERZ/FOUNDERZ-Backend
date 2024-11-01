package com.founderz.user.domain;

import com.founderz.user.domain.dto.UserDomainDto;

/**
 * <p>바운디드 컨텍스트: User(사용자)</p>
 * <p>책임: 사용자 데이터베이스 테이블 쓰기 작업</p>
 * <p>계층: domain</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>계정 저장</li>
 * </ul>
 */
public interface UserDomainWriter {

    /**
     * 계정 생성 또는 업데이트를 위한 메서드
     *
     * @param dto 유저 도메인 정보
     */
    void save(UserDomainDto dto);
}
