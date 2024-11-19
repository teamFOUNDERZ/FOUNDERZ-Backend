package com.founderz.common.vo.user;

import com.fasterxml.jackson.annotation.JsonValue;
import com.founderz.common.vo.ValueObject;

public record MyMoney(
        @JsonValue
        Long money
) implements ValueObject.LongValueObject {
    public MyMoney() {
        this(0L);
    }

    public static MyMoney create() {
        return new MyMoney();
    }

    public static MyMoney create(final Long money) {
        return new MyMoney(money);
    }
}
