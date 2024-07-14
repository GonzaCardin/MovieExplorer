package com.educacionit.utils;

import java.security.SecureRandom;
import java.util.Base64;
public class SecretKeyUtils {
    public static void main(String[] args) {
        byte[] key = new byte[32];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(key);

        String secretkey = Base64.getEncoder().encodeToString(key);
        System.out.println("Secret Key = " + secretkey);
    }
}
