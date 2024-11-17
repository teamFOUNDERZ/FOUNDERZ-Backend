package com.founderz.internal.data.investment;

import com.founderz.common.vo.business.InvestmentAmount;
import com.founderz.common.vo.business.SecuredBusinessId;
import com.founderz.common.vo.investment.Contact;
import com.founderz.common.vo.investment.InvestmentId;
import com.founderz.common.vo.investment.PreferContractPeriod;
import com.founderz.common.vo.user.AccountName;

public record InvestmentDto(
        InvestmentId investmentId,
        SecuredBusinessId businessId,
        AccountName investorName,
        InvestmentAmount investmentAmount,
        Contact contact,
        PreferContractPeriod preferContractPeriod
) {
}