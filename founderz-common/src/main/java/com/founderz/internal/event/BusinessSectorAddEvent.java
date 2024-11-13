package com.founderz.internal.event;

import com.founderz.common.vo.business.BusinessId;
import com.founderz.common.vo.tag.SecuredTagId;
import com.founderz.common.vo.tag.TagId;

import java.util.List;

public record BusinessSectorAddEvent(
        List<TagId> tagIds,
        BusinessId businessId
) {
    public static BusinessSectorAddEvent create(List<SecuredTagId> tagIds, BusinessId businessId) {
        return new BusinessSectorAddEvent(
                tagIds.stream()
                        .map(SecuredTagId::toTagId)
                        .toList(),
                businessId
        );
    }
}
