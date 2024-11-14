package com.founderz.user.domain;

import com.founderz.common.vo.user.AccountId;
import com.founderz.common.vo.user.PhoneNumber;
import com.founderz.internal.data.user.UserDto;

import java.util.Optional;

/**
 * <p>바운디드 컨텍스트: User(사용자)</p>
 * <p>책임: 사용자 데이터베이스 테이블 읽기 작업</p>
 * <p>계층: domain</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>계정 ID로 사용자 존재 여부 확인</li>
 *   <li>전화번호로 사용자 존재 여부 확인</li>
 *   <li>계정 ID로 사용자 정보 조회</li>
 *   <li>전화번호로 사용자 정보 조회</li>
 * </ul>
 */
public interface UserDomainReader {
    /**
     * 입력된 계정 ID 또는 전화번호를 사용하는 사용자 존재 여부 확인 메서드
     *
     * @param accountId 확인할 계정 ID, tel 확인할 전화번호
     * @return 사용자 존재 여부 (존재하면 true)
     */
    boolean existsByAccountIdOrPhoneNumber(AccountId accountId, PhoneNumber tel);

    /**
     * 입력된 계정 ID를 사용하는 사용자 존재 여부 확인 메서드
     *
     * @param accountId 확인할 계정 ID
     * @return 사용자 존재 여부 (존재하면 true)
     */
    boolean existsByAccountId(AccountId accountId);

    /**
     * 입력된 전화번호를 사용하는 사용자 존재 여부 확인 메서드
     *
     * @param tel 확인할 전화번호
     * @return 사용자 존재 여부 (존재하면 true)
     */
    boolean existsByTel(PhoneNumber tel);

    /**
     * 입력된 계정 ID로 사용자 정보 조회
     *
     * @param accountId 조회할 계정 ID
     * @return 사용자 정보 (Optional)
     */
    Optional<UserDto> findByAccountId(AccountId accountId);

    /**
     * 입력된 전화번호로 사용자 정보 조회
     *
     * @param tel 조회할 전화번호
     * @return 사용자 정보 (Optional)
     */
    Optional<UserDto> findByTel(PhoneNumber tel);
}