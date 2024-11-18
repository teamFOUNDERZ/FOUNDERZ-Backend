package com.founderz.agreement.domain;

import com.founderz.internal.data.agreement.AgreementDto;

/**
 * <p>바운디드 컨텍스트: Agreement(자금 투자 계약서)</p>
 * <p>책임: 자금 투자 계약서 데이터베이스 테이블 쓰기 작업</p>
 * <p>계층: domain</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>자금 투자 계약서 저장</li>
 * </ul>
 */
public interface AgreementDomainWriter {

    /**
     * 자금 투자 계약서 생성을 위한 메서드
     *
     * @param dto 자금 투자 계약서 도메인 정보
     */
    AgreementDto save(AgreementDto dto);
}
