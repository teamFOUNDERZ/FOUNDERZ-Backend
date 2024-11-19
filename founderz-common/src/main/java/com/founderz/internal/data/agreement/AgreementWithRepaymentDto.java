package com.founderz.internal.data.agreement;

import com.founderz.internal.data.repayment.RepaymentDto;

import java.util.List;

public record AgreementWithRepaymentDto(
        AgreementDto agreementDto,
        List<RepaymentDto> repaymentDtos
) {
    public static AgreementWithRepaymentDto create(AgreementDto agreementDto, List<RepaymentDto> repaymentDtos) {
        return new AgreementWithRepaymentDto(agreementDto, repaymentDtos);
    }
}
