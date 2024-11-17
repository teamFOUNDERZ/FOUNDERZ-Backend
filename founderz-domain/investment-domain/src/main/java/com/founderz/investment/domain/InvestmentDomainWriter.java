package com.founderz.investment.domain;

import com.founderz.internal.data.investment.InvestmentDto;

/**
 * <p>바운디드 컨텍스트: Investment(투자)</p>
 * <p>책임: 투자 데이터베이스 테이블 쓰기 작업</p>
 * <p>계층: domain</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>투자 저장</li>
 * </ul>
 */
public interface InvestmentDomainWriter {

    /**
     * 투자 생성을 위한 메서드
     *
     * @param dto 투자 도메인 정보
     */
    InvestmentDto save(InvestmentDto dto);
}
