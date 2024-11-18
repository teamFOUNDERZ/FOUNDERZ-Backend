package com.founderz.tag.presentation;

import com.founderz.common.presentation.annotation.RequiredRoles;
import com.founderz.common.presentation.annotation.WebRestAdapter;
import com.founderz.common.security.UserRole;
import com.founderz.common.vo.tag.SecuredTagId;
import com.founderz.tag.application.TagWriteService;
import com.founderz.tag.presentation.document.TagWriteDocumentation;
import com.founderz.tag.presentation.form.TagCreateForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequiredArgsConstructor
@WebRestAdapter("/api/tags")
class TagWriteAdapter implements TagWriteDocumentation {
    private final TagWriteService writeService;
    private final TagFormMapper formMapper;

    @PostMapping
    @RequiredRoles({UserRole.ADMIN})
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody TagCreateForm form) {
        final var dto = formMapper.toDto(form);

        writeService.create(dto);
    }

    @DeleteMapping("/{tagId}")
    @RequiredRoles({UserRole.ADMIN})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable SecuredTagId tagId) {
        writeService.delete(tagId.toTagId());
    }
}
