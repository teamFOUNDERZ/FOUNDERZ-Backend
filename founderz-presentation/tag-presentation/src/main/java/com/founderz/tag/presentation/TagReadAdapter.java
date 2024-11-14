package com.founderz.tag.presentation;

import com.founderz.common.presentation.annotation.WebRestAdapter;
import com.founderz.external.response.ListResponse;
import com.founderz.tag.application.TagReadService;
import com.founderz.tag.presentation.document.TagReadDocumentation;
import com.founderz.tag.presentation.response.TagResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@WebRestAdapter("/api/tags")
class TagReadAdapter implements TagReadDocumentation {
    private final TagReadService tagReadService;

    @GetMapping
    public ListResponse<TagResponse> getAll() {
        final var result = tagReadService.getAll().stream()
                .map(TagResponse::create)
                .toList();

        return ListResponse.create(result);
    }
}
