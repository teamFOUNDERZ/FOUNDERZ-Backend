package com.founderz.agreement.application;

import com.founderz.internal.data.agreement.AgreementDto;
import com.founderz.internal.data.repayment.RepaymentDto;

import java.util.List;

/**
 * <p>바운디드 컨텍스트: Agreement(자금 투자 계약서)</p>
 * <p>책임: 자금 투자 계약서 쓰기 작업</p>
 * <p>계층: application</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>자금 투자 계약서 작성</li>
 * </ul>
 */
public interface AgreementWriteService {

    /**
     * 유저에게 정보를 입력 받아 자금 투자 계약서를 작성하는 메서드
     *
     * @param dto 자금 투자 계약서 작성을 위한 정보
     */
    void write(final AgreementDto dto, final List<RepaymentDto> repayments);
}
