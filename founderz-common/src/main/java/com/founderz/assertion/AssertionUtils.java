package com.founderz.assertion;

import com.founderz.exception.BadRequestException;

import java.util.regex.Pattern;

public class AssertionUtils {
    public static void assertArgumentEquals(final Object anObject1, final Object anObject2, final String aMessage) {
        if (!anObject1.equals(anObject2)) {
            throw new BadRequestException(aMessage);
        }
    }

    public static void assertArgumentFalse(final boolean aBoolean, final String aMessage) {
        if (aBoolean) {
            throw new BadRequestException(aMessage);
        }
    }

    public static void assertArgumentLength(final String aString, final int aMaximum, final String aMessage) {
        if (aString == null) {
            return;
        }
        int length = aString.trim().length();
        if (length > aMaximum) {
            throw new BadRequestException(aMessage);
        }
    }

    public static void assertArgumentLength(final String aString, final int aMinimum, final int aMaximum, final String aMessage) {
        if (aString == null) {
            return;
        }
        int length = aString.trim().length();
        if (length < aMinimum || length > aMaximum) {
            throw new BadRequestException(aMessage);
        }
    }

    public static void assertArgumentNotEmpty(final String aString, final String aMessage) {
        if (aString == null || aString.trim().isEmpty()) {
            throw new BadRequestException(aMessage);
        }
    }

    public static void assertArgumentNotEquals(final Object anObject1, final Object anObject2, final String aMessage) {
        if (anObject1.equals(anObject2)) {
            throw new BadRequestException(aMessage);
        }
    }

    public static void assertArgumentNull(final Object anObject, final String aMessage) {
        if (anObject != null) {
            throw new BadRequestException(aMessage);
        }
    }

    public static void assertArgumentNotNull(final Object anObject, final String aMessage) {
        if (anObject == null) {
            throw new BadRequestException(aMessage);
        }
    }

    public static void assertRegularExpression(final String aString, final String regex, final String aMessage) {
        if (!Pattern.matches(regex, aString)) {
            throw new BadRequestException(aMessage);
        }
    }

    public static void assertArgumentTrue(final boolean aBoolean, final String aMessage) {
        if (!aBoolean) {
            throw new BadRequestException(aMessage);
        }
    }

    public static void assertStateFalse(final boolean aBoolean, final String aMessage) {
        if (aBoolean) {
            throw new BadRequestException(aMessage);
        }
    }

    public static void assertStateTrue(final boolean aBoolean, final String aMessage) {
        if (!aBoolean) {
            throw new BadRequestException(aMessage);
        }
    }
}
