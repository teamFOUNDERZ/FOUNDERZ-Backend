package com.founderz.business.presentation.response;

import com.founderz.common.vo.business.BusinessName;
import com.founderz.common.vo.business.InvestmentAmount;
import com.founderz.common.vo.business.OneLineIntroduction;
import com.founderz.common.vo.business.SecuredBusinessId;
import com.founderz.internal.data.business.BusinessDto;
import com.founderz.internal.data.sector.SectorDto;
import com.founderz.external.response.sector.SectorResponse;

import java.util.List;

public record BusinessListResponse(
        SecuredBusinessId businessId,
        BusinessName businessName,
        OneLineIntroduction oneLineIntroduction,
        InvestmentAmount investmentAmount,
        List<SectorResponse> tags
) {
    public static BusinessListResponse create(BusinessDto dto, List<SectorDto> tags) {
        return new BusinessListResponse(dto.businessId().toSecureBusinessId(), dto.businessName(),
                dto.oneLineIntroduction(), dto.investmentAmount(), tags.stream().map(SectorResponse::create).toList());
    }
}