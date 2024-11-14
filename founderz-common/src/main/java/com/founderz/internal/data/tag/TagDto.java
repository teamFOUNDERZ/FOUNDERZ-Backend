package com.founderz.internal.data.tag;

import com.founderz.common.vo.tag.TagId;
import com.founderz.common.vo.tag.TagName;

public record TagDto(
        TagId id,
        TagName name
) {
}
