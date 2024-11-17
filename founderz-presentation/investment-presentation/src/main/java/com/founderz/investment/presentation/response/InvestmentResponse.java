package com.founderz.investment.presentation.response;

import com.founderz.common.vo.business.BusinessName;
import com.founderz.common.vo.business.InvestmentAmount;
import com.founderz.common.vo.business.SecuredBusinessId;
import com.founderz.common.vo.investment.Contact;
import com.founderz.common.vo.investment.InvestmentStatus;
import com.founderz.common.vo.investment.PreferContractPeriod;
import com.founderz.common.vo.investment.SecuredInvestmentId;
import com.founderz.common.vo.user.AccountId;
import com.founderz.common.vo.user.AccountName;
import com.founderz.internal.data.investment.InvestmentDto;

public record InvestmentResponse(
        SecuredInvestmentId investmentId,
        SecuredBusinessId businessId,
        BusinessName businessName,
        AccountId investorAccountId,
        AccountName investorName,
        AccountName investeeName,
        InvestmentStatus status,
        InvestmentAmount investmentAmount,
        Contact contact,
        PreferContractPeriod preferContractPeriod
) {
    public static InvestmentResponse create(InvestmentDto dto) {
        return new InvestmentResponse(dto.investmentId().toSecureInvestmentId(), dto.businessId().toSecureBusinessId(),
                dto.businessName(), dto.investorAccountId(), dto.investorName(), dto.investeeName(), dto.investmentStatus(),
                dto.investmentAmount(), dto.contact(), dto.preferContractPeriod());
    }
}