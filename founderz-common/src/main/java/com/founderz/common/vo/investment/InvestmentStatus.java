package com.founderz.common.vo.investment;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

import java.util.regex.Pattern;

import static com.founderz.common.assertion.AssertionUtils.assertArgumentNotEmpty;
import static com.founderz.common.assertion.AssertionUtils.assertRegularExpression;

public record InvestmentStatus(
        @JsonValue
        String status
) implements ValueObject.StringValueObject {
    public InvestmentStatus() {
        this("WRITING");
    }

    public static InvestmentStatus create() {
        return new InvestmentStatus();
    }

    private static final Pattern INVESTMENT_STATUS_REGEX = Pattern.compile("^(WRITING|COMPLETE|REJECTED|CONCLUDED)");

    public InvestmentStatus {
        assertArgumentNotEmpty(status, "투자의 상태가 입력되지 않았습니다.");
        assertRegularExpression(status, INVESTMENT_STATUS_REGEX, "투자의 유형은 'WRITING','COMPLETE','REJECTED','CONCLUDED' 이어야 합니다.");
    }

    public static InvestmentStatus create(final String status) {
        return new InvestmentStatus(status);
    }
}