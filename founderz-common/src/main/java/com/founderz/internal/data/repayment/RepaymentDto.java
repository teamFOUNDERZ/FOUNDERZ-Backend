package com.founderz.internal.data.repayment;

import com.founderz.common.vo.investment.InvestmentId;
import com.founderz.common.vo.repayment.RepaymentAmount;
import com.founderz.common.vo.repayment.RepaymentDate;
import com.founderz.common.vo.repayment.RepaymentId;

public record RepaymentDto(
        RepaymentId repaymentId,
        InvestmentId investmentId,
        RepaymentAmount repaymentAmount,
        RepaymentDate repaymentDate
) {
}