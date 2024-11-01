package com.founderz.common.crypto;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.UUID;

public class CryptoUtils {
    private static final String ALGORITHM = "AES";

    private static final String SECRET_KEY = UUID.randomUUID().toString().substring(0, 16);

    private static final SecretKeySpec SECRET_KEY_SPEC = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);

    private static final Cipher CIPHER;

    static {
        try {
            CIPHER = Cipher.getInstance(ALGORITHM);

        } catch (final Exception e) {
            throw new IllegalStateException("알고리즘이 잘못됐어요.");
        }
    }

    public static String encrypt(Long rawValue) {
        try {
            CIPHER.init(Cipher.ENCRYPT_MODE, SECRET_KEY_SPEC);

            final var encrypted = CIPHER.doFinal(String.valueOf(rawValue).getBytes());
            return Base64.getUrlEncoder().withoutPadding().encodeToString(encrypted);
        } catch (final Exception e) {
            throw new IllegalArgumentException("암호화 실패");
        }
    }

    public static Long decrypt(String hashedValue) {
        try {
            CIPHER.init(Cipher.DECRYPT_MODE, SECRET_KEY_SPEC);

            final var decoded = Base64.getUrlDecoder().decode(hashedValue);
            final var decrypted = CIPHER.doFinal(decoded);

            return Long.parseLong(new String(decrypted));
        } catch (final Exception e) {
            throw new IllegalArgumentException("잘못된 해시값입니다.");
        }
    }
}
