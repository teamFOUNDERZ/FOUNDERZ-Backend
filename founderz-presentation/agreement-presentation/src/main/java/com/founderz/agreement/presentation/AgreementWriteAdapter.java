package com.founderz.agreement.presentation;

import com.founderz.agreement.application.AgreementWriteService;
import com.founderz.agreement.presentation.document.AgreementWriteDocumentation;
import com.founderz.agreement.presentation.form.WriteAgreementForm;
import com.founderz.common.presentation.annotation.WebRestAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequiredArgsConstructor
@WebRestAdapter("/api/agreement")
class AgreementWriteAdapter implements AgreementWriteDocumentation {
    private final AgreementWriteService writeService;
    private final WriteAgreementFormMapper writeAgreementFormMapper;

    @PostMapping("/write")
    @ResponseStatus(HttpStatus.CREATED)
    public void write(@RequestBody WriteAgreementForm form) {
        final var internalDto = writeAgreementFormMapper.toDto(form);

        writeService.write(internalDto);
    }
}
