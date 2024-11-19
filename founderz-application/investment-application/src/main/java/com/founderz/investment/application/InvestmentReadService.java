package com.founderz.investment.application;

import com.founderz.common.vo.investment.InvestmentId;
import com.founderz.internal.data.investment.InvestmentDto;

import java.util.List;

/**
 * <p>바운디드 컨텍스트: Investment(투자)</p>
 * <p>책임: 투자 읽기 작업</p>
 * <p>계층: application</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>받은 투자 요청 조회</li>
 *   <li>내 투자 조회</li>
 * </ul>
 */
public interface InvestmentReadService {
    /**
     * 받은 투자 요청 조회를 위한 메서드
     *
     * @return 받은 투자 요청 목록
     */
    List<InvestmentDto> getReceivedInvestmentRequest();

    /**
     * 내 투자 조회를 위한 메서드
     *
     * @return 내 투자 목록
     */
    List<InvestmentDto> getMyInvestment();

    /**
     * 아이디를 통한 투자 조회를 위한 메서드
     *
     * @return 내 투자 정
     */
    InvestmentDto getById(InvestmentId investmentId);
}