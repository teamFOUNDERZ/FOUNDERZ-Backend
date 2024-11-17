package com.founderz.investment.domain;

import com.founderz.common.vo.business.BusinessId;
import com.founderz.common.vo.user.AccountId;
import com.founderz.internal.data.investment.InvestmentDto;

import java.util.List;

/**
 * <p>바운디드 컨텍스트: Investment(투자)</p>
 * <p>책임: 투자 데이터베이스 테이블 읽기 작업</p>
 * <p>계층: domain</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>내 투자 전체 조회</li>
 * </ul>
 */
public interface InvestmentDomainReader {
    /**
     * 내 투자 전체를 조회할 때 사용하는 메서드
     *
     * @return 투자 목록
     */
    List<InvestmentDto> findAllByInvestorAccountId(AccountId accountId);

    /**
     * 사업들의 투자 요청을 조회할 때 사용하는 메서드
     *
     * @return 투자 목록
     */
    List<InvestmentDto> findAllBusinessIdIn(List<BusinessId> businessIds);
}