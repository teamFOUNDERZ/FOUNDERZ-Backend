package com.founderz.internal.function.repayment;

import com.founderz.common.vo.investment.InvestmentId;
import com.founderz.internal.data.repayment.RepaymentDto;

import java.util.List;

public interface RepaymentReader {
    /**
     * 현재 투자의 상환 목록 조회를 위한 메서드
     *
     * @param investmentId 투자 아이디
     * @return 현재 투자의 상환 목록
     */
    List<RepaymentDto> findAllByInvestmentId(InvestmentId investmentId);
}
