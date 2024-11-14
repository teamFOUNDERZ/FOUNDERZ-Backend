package com.founderz.business.presentation.form;

import com.founderz.common.vo.business.BusinessIntroduction;
import com.founderz.common.vo.business.BusinessName;
import com.founderz.common.vo.business.OneLineIntroduction;
import com.founderz.common.vo.business.Vision;
import com.founderz.common.vo.business.WritePurpose;
import com.founderz.common.vo.tag.SecuredTagId;

import java.util.List;

public record WriteBusinessForm(
        BusinessName businessName,
        OneLineIntroduction oneLineIntroduction,
        BusinessIntroduction businessIntroduction,
        Vision vision,
        WritePurpose writePurpose,
        List<SecuredTagId> tagIds
) {
}
