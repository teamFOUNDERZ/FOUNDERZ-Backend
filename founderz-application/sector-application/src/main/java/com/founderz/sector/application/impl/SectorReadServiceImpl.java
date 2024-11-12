package com.founderz.sector.application.impl;

import com.founderz.common.vo.business.BusinessId;
import com.founderz.internal.data.sector.SectorDto;
import com.founderz.sector.application.SectorReadService;
import com.founderz.sector.domain.SectorDomainReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class SectorReadServiceImpl implements SectorReadService {
    private final SectorDomainReader reader;

    @Override
    public List<SectorDto> getBusinessSectors(final BusinessId businessId) {
        return reader.getAllByBusinessId(businessId);
    }
}
