package com.founderz.agreement.presentation.form;

import com.founderz.common.vo.investment.SecuredInvestmentId;
import com.founderz.common.vo.repayment.RepaymentAmount;
import com.founderz.common.vo.repayment.RepaymentDate;

public record RepaymentForm(
        SecuredInvestmentId investmentId,
        RepaymentAmount repaymentAmount,
        RepaymentDate repaymentDate
) {
}
