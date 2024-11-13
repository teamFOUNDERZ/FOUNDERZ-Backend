package com.founderz.internal.event;

import com.founderz.common.vo.business.BusinessId;
import com.founderz.common.vo.tag.SecuredTagId;
import com.founderz.common.vo.tag.TagId;

import java.util.List;

public record BusinessTypeAddEvent(
        List<TagId> tagIds,
        BusinessId businessId
) {
    public static BusinessTypeAddEvent create(List<SecuredTagId> tagIds, BusinessId businessId) {
        return new BusinessTypeAddEvent(
                tagIds.stream()
                        .map(SecuredTagId::toTagId)
                        .toList(),
                businessId
        );
    }
}
