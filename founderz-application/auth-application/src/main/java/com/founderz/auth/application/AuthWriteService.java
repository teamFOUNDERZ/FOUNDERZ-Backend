package com.founderz.auth.application;

import com.founderz.auth.application.dto.LoginDto;
import com.founderz.common.vo.auth.PasetoToken;
import com.founderz.internal.data.user.UserDto;

/**
 * <p>바운디드 컨텍스트: Auth(인증)</p>
 * <p>책임: 인증 쓰기 작업</p>
 * <p>계층: application</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>회원가입</li>
 *   <li>로그인</li>
 * </ul>
 */
public interface AuthWriteService {

    /**
     * 유저에게 정보를 입력 받아 회원가입을 진행하는 메서드
     *
     * @param dto 회원가입를 위한 유저 정보
     */
    void register(UserDto dto);

    /**
     * 식별자(계정 ID, 전화번호), 비밀번호를 통해 로그인을 진행하는 메서드
     *
     * @param dto 로그인을 위한 유저 정보
     * @return 토큰
     */
    PasetoToken login(LoginDto dto);
}

