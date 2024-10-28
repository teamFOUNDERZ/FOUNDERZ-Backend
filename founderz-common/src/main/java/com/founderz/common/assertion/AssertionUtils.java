package com.founderz.common.assertion;

import com.founderz.common.exception.BadRequestException;

import java.util.regex.Pattern;

public class AssertionUtils {
    public static void assertArgumentNotEmpty(final String aString, final String aMessage) {
        if (aString == null || aString.trim().isEmpty()) {
            throw new BadRequestException(aMessage);
        }
    }

    public static void assertRegularExpression(final String aString, final Pattern regex, final String aMessage) {
        if (!regex.matcher(aString).matches()) {
            throw new BadRequestException(aMessage);
        }
    }
}
