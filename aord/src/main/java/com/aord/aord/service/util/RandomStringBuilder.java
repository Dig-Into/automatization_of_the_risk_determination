package com.aord.aord.service.util;

import java.security.SecureRandom;

import org.jboss.aerogear.security.otp.api.Base32;

public class RandomStringBuilder {
    private static final Double SCALING_OF_BASE36 = 1.6;

    private static final SecureRandom numberGenerator = new SecureRandom();

    private RandomStringBuilder() {
    }

    public static String generateBase32String(int length) {
        byte[] values = new byte[(int) (length / SCALING_OF_BASE36)];
        numberGenerator.nextBytes(values);
        return Base32.encode(values);
    }

}