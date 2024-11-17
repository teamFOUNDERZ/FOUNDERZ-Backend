package com.founderz.internal.data.investment;

import com.founderz.common.vo.business.BusinessId;
import com.founderz.common.vo.business.InvestmentAmount;
import com.founderz.common.vo.investment.Contact;
import com.founderz.common.vo.investment.InvestmentId;
import com.founderz.common.vo.investment.PreferContractPeriod;
import com.founderz.common.vo.user.AccountName;

public record InvestmentDto(
        InvestmentId investmentId,
        BusinessId businessId,
        AccountName investorName,
        InvestmentAmount investmentAmount,
        Contact contact,
        PreferContractPeriod preferContractPeriod
) {
    public InvestmentDto setInvestorName(AccountName investorName) {
        return new InvestmentDto(
                investmentId,
                businessId,
                investorName,
                investmentAmount,
                contact,
                preferContractPeriod
        );
    }
}