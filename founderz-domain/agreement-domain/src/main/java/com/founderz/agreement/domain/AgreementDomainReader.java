package com.founderz.agreement.domain;

import com.founderz.common.vo.investment.InvestmentId;
import com.founderz.internal.data.agreement.AgreementDto;

import java.util.Optional;

/**
 * <p>바운디드 컨텍스트: Agreement(자금 투자 계약서)</p>
 * <p>책임: 자금 투자 계약서 데이터베이스 테이블 읽기 작업</p>
 * <p>계층: domain</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>자금 투자 계약서 조회</li>
 * </ul>
 */
public interface AgreementDomainReader {
    /**
     * 자금 투자 계약서를 조회할 때 사용하는 메서드
     *
     * @return 자금 투자 계약서 상세 정보
     */
    Optional<AgreementDto>findByInvestmentId(InvestmentId investmentId);
}