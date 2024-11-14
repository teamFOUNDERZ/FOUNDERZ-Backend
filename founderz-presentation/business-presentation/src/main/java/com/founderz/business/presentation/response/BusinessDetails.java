package com.founderz.business.presentation.response;

import com.founderz.common.vo.business.BusinessIntroduction;
import com.founderz.common.vo.business.BusinessName;
import com.founderz.common.vo.business.InvestmentAmount;
import com.founderz.common.vo.business.OneLineIntroduction;
import com.founderz.common.vo.business.SecuredBusinessId;
import com.founderz.common.vo.business.Vision;
import com.founderz.common.vo.business.WritePurpose;
import com.founderz.external.response.sector.SectorResponse;
import com.founderz.internal.data.business.BusinessDto;
import com.founderz.internal.data.sector.SectorDto;

import java.util.List;

public record BusinessDetails(
        SecuredBusinessId businessId,
        BusinessName businessName,
        OneLineIntroduction oneLineIntroduction,
        List<SectorResponse> tags,
        Vision vision,
        WritePurpose writePurpose,
        BusinessIntroduction businessIntroduction,
        InvestmentAmount investmentAmount
) {
    public static BusinessDetails create(BusinessDto dto, List<SectorDto> tags) {
        return new BusinessDetails(dto.businessId().toSecureBusinessId(), dto.businessName(), dto.oneLineIntroduction(),
                tags.stream().map(SectorResponse::create).toList(), dto.vision(), dto.writePurpose(), dto.businessIntroduction(), dto.investmentAmount());
    }
}
