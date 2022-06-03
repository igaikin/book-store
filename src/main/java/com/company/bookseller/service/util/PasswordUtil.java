package com.company.bookseller.service.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class PasswordUtil {
    public static final String ALGORITHM = "SHA-1";
    public static final int POSITIVE_SIGN = 1;
    public static final int HEX_RADIX = 16;

    public static String encryptPassword(String originalPassword) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);
            messageDigest.update(originalPassword.getBytes(StandardCharsets.UTF_8));
            byte[] encryptedPasswordBytes = messageDigest.digest();
            BigInteger encryptedPasswordNumber = new BigInteger(POSITIVE_SIGN, encryptedPasswordBytes);
            return encryptedPasswordNumber.toString(HEX_RADIX);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
