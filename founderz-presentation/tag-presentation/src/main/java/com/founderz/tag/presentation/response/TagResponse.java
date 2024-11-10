package com.founderz.tag.presentation.response;

import com.founderz.common.vo.tag.SecuredTagId;
import com.founderz.common.vo.tag.TagName;
import com.founderz.internal.data.tag.TagDto;

public record TagResponse(
        SecuredTagId tagId,
        TagName tagName
) {
    public static TagResponse create(TagDto dto) {
        return new TagResponse(dto.id().toSecureTagId(), dto.name());
    }
}
