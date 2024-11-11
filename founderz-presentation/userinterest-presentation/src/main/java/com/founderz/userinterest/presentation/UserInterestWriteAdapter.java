package com.founderz.userinterest.presentation;

import com.founderz.common.presentation.annotation.RequiredRoles;
import com.founderz.common.presentation.annotation.WebRestAdapter;
import com.founderz.common.security.UserRole;
import com.founderz.common.vo.tag.SecuredTagId;
import com.founderz.userinterest.application.UserInterestWriteService;
import com.founderz.userinterest.presentation.form.UserInterestAddForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequiredArgsConstructor
@WebRestAdapter("/api/users/interests")
class UserInterestWriteAdapter {
    private final UserInterestWriteService writeService;
    private final UserInterestFormMapper mapper;

    @PostMapping
    @RequiredRoles({UserRole.PERSONAL})
    @ResponseStatus(HttpStatus.CREATED)
    public void addUserInterest(@RequestBody UserInterestAddForm form) {
        final var dto = mapper.toDto(form);
        writeService.addUserInterest(dto);
    }

    @DeleteMapping("/{tagId}")
    @RequiredRoles({UserRole.PERSONAL})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUserInterest(@PathVariable SecuredTagId tagId) {
        writeService.removeUserInterest(tagId.toTagId());
    }
}
