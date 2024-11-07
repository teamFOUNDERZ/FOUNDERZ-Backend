package com.founderz.business.domain.dto;

import com.founderz.common.vo.business.BusinessId;
import com.founderz.common.vo.business.BusinessIntroduction;
import com.founderz.common.vo.business.BusinessName;
import com.founderz.common.vo.business.InvestmentAmount;
import com.founderz.common.vo.business.OneLinerIntroduction;
import com.founderz.common.vo.business.Vision;
import com.founderz.common.vo.business.WritePurpose;
import com.founderz.common.vo.user.AccountId;

public record BusinessDomainDto(
        BusinessId id,
        BusinessName businessName,
        OneLinerIntroduction oneLinerIntroduction,
        BusinessIntroduction businessIntroduction,
        Vision vision,
        WritePurpose writePurpose,
        InvestmentAmount investmentAmount,
        AccountId writerAccountId
) {
}