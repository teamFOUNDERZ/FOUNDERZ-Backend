package com.founderz.internal.data.investment;

import com.founderz.common.vo.business.BusinessId;
import com.founderz.common.vo.business.InvestmentAmount;
import com.founderz.common.vo.investment.Contact;
import com.founderz.common.vo.investment.InvestmentId;
import com.founderz.common.vo.investment.InvestmentStatus;
import com.founderz.common.vo.investment.PreferContractPeriod;
import com.founderz.common.vo.user.AccountName;

public record InvestmentDto(
        InvestmentId investmentId,
        BusinessId businessId,
        AccountName investorName,
        InvestmentStatus investmentStatus,
        InvestmentAmount investmentAmount,
        Contact contact,
        PreferContractPeriod preferContractPeriod
) {
    public InvestmentDto {
        if (investmentStatus == null) {
            investmentStatus = InvestmentStatus.create();
        }
    }

    public InvestmentDto setInvestorName(AccountName investorName) {
        return new InvestmentDto(
                investmentId,
                businessId,
                investorName,
                investmentStatus,
                investmentAmount,
                contact,
                preferContractPeriod
        );
    }
}