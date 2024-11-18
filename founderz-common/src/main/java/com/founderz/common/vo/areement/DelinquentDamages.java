package com.founderz.common.vo.areement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

public record DelinquentDamages(
        @JsonValue
        float damages
) implements ValueObject.LongValueObject {
    @JsonCreator
    public static DelinquentDamages create(final float damages) {
        return new DelinquentDamages(damages);
    }
}
