package com.founderz.internal.data.investment;

import com.founderz.common.vo.business.BusinessId;
import com.founderz.common.vo.business.BusinessName;
import com.founderz.common.vo.business.InvestmentAmount;
import com.founderz.common.vo.investment.Contact;
import com.founderz.common.vo.investment.InvestmentId;
import com.founderz.common.vo.investment.InvestmentStatus;
import com.founderz.common.vo.investment.PreferContractPeriod;
import com.founderz.common.vo.user.AccountId;
import com.founderz.common.vo.user.AccountName;

public record InvestmentDto(
        InvestmentId investmentId,
        BusinessId businessId,
        BusinessName businessName,
        AccountId investorAccountId,
        AccountName investorName,
        AccountName investeeName,
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

    public InvestmentDto setInvestorAccountId(AccountId investorAccountId) {
        return new InvestmentDto(
                investmentId,
                businessId,
                businessName,
                investorAccountId,
                investorName,
                investeeName,
                investmentStatus,
                investmentAmount,
                contact,
                preferContractPeriod
        );
    }
}