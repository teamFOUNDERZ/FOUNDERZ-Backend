package com.founderz.investment.presentation.form;

import com.founderz.common.vo.business.InvestmentAmount;
import com.founderz.common.vo.business.SecuredBusinessId;
import com.founderz.common.vo.investment.Contact;
import com.founderz.common.vo.investment.PreferContractPeriod;

public record RequestInvestmentForm(
        SecuredBusinessId businessId,
        InvestmentAmount investmentAmount,
        Contact contact,
        PreferContractPeriod preferContractPeriod
) {
}
