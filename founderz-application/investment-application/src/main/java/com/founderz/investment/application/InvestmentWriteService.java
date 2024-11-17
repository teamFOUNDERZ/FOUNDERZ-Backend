package com.founderz.investment.application;

import com.founderz.internal.data.investment.InvestmentDto;

/**
 * <p>바운디드 컨텍스트: Investment(투자)</p>
 * <p>책임: 투자 쓰기 작업</p>
 * <p>계층: application</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>투자 요청하기</li>
 * </ul>
 */
public interface InvestmentWriteService {

    /**
     * 유저에게 정보를 입력 받아 투자를 요청하는 메서드
     *
     * @param dto 투자 요청을 위한 정보
     */
    void request(InvestmentDto dto);
}

