package com.founderz.business.presentation.form;

import com.founderz.common.vo.business.BusinessIntroduction;
import com.founderz.common.vo.business.BusinessName;
import com.founderz.common.vo.business.OneLineIntroduction;
import com.founderz.common.vo.business.Vision;
import com.founderz.common.vo.business.WritePurpose;

public record WriteBusinessForm(
        BusinessName businessName,
        OneLineIntroduction oneLineIntroduction,
        BusinessIntroduction businessIntroduction,
        Vision vision,
        WritePurpose writePurpose
) {
}
