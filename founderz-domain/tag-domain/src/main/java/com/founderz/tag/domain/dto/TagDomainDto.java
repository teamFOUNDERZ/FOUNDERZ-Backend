package com.founderz.tag.domain.dto;

import com.founderz.common.vo.TagId;
import com.founderz.common.vo.TagName;

public record TagDomainDto(
        TagId id,
        TagName name
) {
}
