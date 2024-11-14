package com.founderz.internal.data.sector;

import com.founderz.common.vo.business.BusinessId;
import com.founderz.common.vo.tag.TagId;
import com.founderz.common.vo.tag.TagName;

public record SectorDto(
        BusinessId businessId,
        TagId tagId,
        TagName tagName
) {
    public static SectorDto create(final BusinessId businessId, final TagId tagId, final TagName tagName) {
        return new SectorDto(businessId, tagId, tagName);
    }
}
