package com.founderz.internal.function.sector;

import com.founderz.common.vo.business.BusinessId;
import com.founderz.internal.data.sector.SectorDto;

import java.util.List;

public interface SectorReader {
    /**
     * 단일 사업 아이템의 분야 목록 조회 메서드
     *
     * @param businessId 사업 아이템 아이디
     * @return 분야 목록
     */
    List<SectorDto> getAllByBusinessId(BusinessId businessId);
}
