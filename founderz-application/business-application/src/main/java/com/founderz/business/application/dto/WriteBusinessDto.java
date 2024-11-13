package com.founderz.business.application.dto;

import com.founderz.common.vo.business.BusinessIntroduction;
import com.founderz.common.vo.business.BusinessName;
import com.founderz.common.vo.business.OneLineIntroduction;
import com.founderz.common.vo.business.Vision;
import com.founderz.common.vo.business.WritePurpose;

public record WriteBusinessDto(
        BusinessName businessName,
        OneLineIntroduction oneLinerIntroduction,
        BusinessIntroduction businessIntroduction,
        Vision vision,
        WritePurpose writePurpose
) {
}
