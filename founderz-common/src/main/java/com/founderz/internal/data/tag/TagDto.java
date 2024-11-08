package com.founderz.internal.data.tag;

import com.founderz.common.vo.TagId;
import com.founderz.common.vo.TagName;

public record TagDto(
        TagId id,
        TagName name
) {
}
