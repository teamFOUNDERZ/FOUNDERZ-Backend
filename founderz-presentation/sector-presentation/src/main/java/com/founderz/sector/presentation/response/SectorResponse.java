package com.founderz.sector.presentation.response;

import com.founderz.common.vo.tag.SecuredTagId;
import com.founderz.common.vo.tag.TagName;
import com.founderz.internal.data.sector.SectorDto;

public record SectorResponse(
        SecuredTagId tagId,
        TagName tagName
) {
    public static SectorResponse create(SectorDto dto) {
        return new SectorResponse(dto.tagId().toSecureTagId(), dto.tagName());
    }
}
