package com.founderz.business.presentation;

import com.founderz.business.application.BusinessWriteService;
import com.founderz.business.presentation.document.BusinessWriteDocumentation;
import com.founderz.business.presentation.form.WriteBusinessForm;
import com.founderz.common.presentation.annotation.WebRestAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequiredArgsConstructor
@WebRestAdapter("/api/business")
public class BusinessWriteAdapter implements BusinessWriteDocumentation {
    private final BusinessWriteService writeService;
    private final WriteBusinessFormMapper writeBusinessFormMapper;

    @PostMapping("/write")
    @ResponseStatus(HttpStatus.CREATED)
    public void write(@RequestBody WriteBusinessForm form) {
        final var internalDto = writeBusinessFormMapper.toDto(form);

        writeService.write(internalDto, form.tagIds());
    }
}
