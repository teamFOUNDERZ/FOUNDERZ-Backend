package com.founderz.auth.application;

import com.founderz.common.vo.user.AccountId;
import com.founderz.common.vo.user.PhoneNumber;

/**
 * <p>바운디드 컨텍스트: Auth(인증)</p>
 * <p>책임: 인증 읽기 작업</p>
 * <p>계층: application</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>계정 ID로 회원가입 여부 확인</li>
 *   <li>전화번호로 회원가입 여부 확인</li>
 * </ul>
 */
public interface AuthReadService {

    /**
     * 입력된 계정 ID의 회원가입 여부 확인 메서드
     *
     * @param accountId 확인할 계정 ID
     * @return 회원가입 여부 (가입 된 경우 true)
     */
    boolean isRegisteredAccount(AccountId accountId);

    /**
     * 입력된 전화번호로 인증번호를 발송하는 메서드
     *
     * @param tel 발송할 전화번호
     * @return 발송 성공 여부 (발송된 경우 true)
     */
    boolean sendSMS(PhoneNumber tel);

    /**
     * 입력된 인증번호를 검증하는 메서드
     *
     * @param tel 겅증할 인증번호
     * @return 유효 여부 (유효한 경우 true)
     */
    boolean isVerify(PhoneNumber tel, String randomNum);
}

