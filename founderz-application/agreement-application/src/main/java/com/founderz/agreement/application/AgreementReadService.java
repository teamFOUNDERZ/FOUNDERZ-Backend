package com.founderz.agreement.application;

import com.founderz.common.vo.investment.InvestmentId;
import com.founderz.internal.data.agreement.AgreementWithRepaymentDto;

/**
 * <p>바운디드 컨텍스트: Agreement(자금 투자 계약서)</p>
 * <p>책임: 자금 투자 계약서 읽기 작업</p>
 * <p>계층: application</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>자금 투자 계약서 조회</li>
 * </ul>
 */
public interface AgreementReadService {
    /**
     * 자금 투자 계약서 조회를 위한 메서드
     *
     * @return 자금 투자 계약서의 상세 정보
     */
    AgreementWithRepaymentDto getByInvestmentId(InvestmentId investmentId);
}
