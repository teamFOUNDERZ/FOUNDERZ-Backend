package com.founderz.repayment.application;

import com.founderz.internal.data.repayment.RepaymentDto;

import java.util.List;

/**
 * <p>바운디드 컨텍스트: Repayment(상환)</p>
 * <p>책임: 상환 쓰기 작업</p>
 * <p>계층: application</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>상환 목록 저장</li>
 * </ul>
 */
public interface RepaymentWriteService {

    /**
     * 유저에게 정보를 입력 받아 상환 목록을 저장하는 메서드
     *
     * @param repaymentDtoList 상환 목록 저장을 위한 정보
     */
    void saveAll(List<RepaymentDto> repaymentDtoList);
}
