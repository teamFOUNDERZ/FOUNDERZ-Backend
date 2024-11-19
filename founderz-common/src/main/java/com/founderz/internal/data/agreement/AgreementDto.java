package com.founderz.internal.data.agreement;

import com.founderz.common.vo.areement.Address;
import com.founderz.common.vo.areement.AgreementId;
import com.founderz.common.vo.areement.DelinquentDamages;
import com.founderz.common.vo.areement.DelinquentQuarter;
import com.founderz.common.vo.areement.DepositDay;
import com.founderz.common.vo.areement.FinallyContractPeriod;
import com.founderz.common.vo.areement.Profit;
import com.founderz.common.vo.areement.RepaymentDelayDay;
import com.founderz.common.vo.areement.SignatureImageUrl;
import com.founderz.common.vo.areement.SpecialContractMatters;
import com.founderz.common.vo.business.InvestmentAmount;
import com.founderz.common.vo.investment.Contact;
import com.founderz.common.vo.investment.InvestmentId;
import com.founderz.common.vo.investment.PreferContractPeriod;
import com.founderz.common.vo.user.AccountName;
import com.founderz.internal.data.repayment.RepaymentDto;

import java.util.List;

public record AgreementDto(
        AgreementId agreementId,
        InvestmentId investmentId,
        AccountName investorName,
        AccountName investeeName,
        InvestmentAmount investmentAmount,
        PreferContractPeriod preferContractPeriod,
        FinallyContractPeriod finallyContractPeriod,
        Profit profit,
        DepositDay depositDay,
        RepaymentDelayDay repaymentDelayDay,
        DelinquentQuarter delinquentQuarter,
        DelinquentDamages delinquentDamages,
        List<SpecialContractMatters> specialContractMatters,
        Address address,
        AccountName representativeName,
        Contact contact,
        SignatureImageUrl signatureImageUrl
) {
}
