package com.founderz.repayment.domain;

import com.founderz.internal.data.repayment.RepaymentDto;

import java.util.List;

/**
 * <p>바운디드 컨텍스트: Repayment(상환)</p>
 * <p>책임: 상환 데이터베이스 테이블 쓰기 작업</p>
 * <p>계층: domain</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>상환 목록 저장</li>
 * </ul>
 */
public interface RepaymentDomainWriter {

    /**
     * 상환 목록 저장을 위한 메서드
     *
     * @param repaymentDto 상환 목록 정보
     */
    void saveAll(List<RepaymentDto> repaymentDto);
}
