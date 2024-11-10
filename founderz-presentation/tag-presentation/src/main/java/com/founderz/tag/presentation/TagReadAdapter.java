package com.founderz.tag.presentation;

import com.founderz.common.presentation.annotation.WebRestAdapter;
import com.founderz.tag.application.TagReadService;
import com.founderz.tag.presentation.document.TagReadDocumentation;
import com.founderz.tag.presentation.response.TagResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@WebRestAdapter("/api/tags")
class TagReadAdapter implements TagReadDocumentation {
    private final TagReadService tagReadService;

    @GetMapping
    public List<TagResponse> getAll() {
        return tagReadService.getAll().stream()
                .map(TagResponse::create)
                .toList();
    }
}
