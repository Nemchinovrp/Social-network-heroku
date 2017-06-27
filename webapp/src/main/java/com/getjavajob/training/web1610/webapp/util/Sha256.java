package com.getjavajob.training.web1610.webapp.util;

import java.security.MessageDigest;

public class Sha256 {
    public static boolean checkPassword(String hashString, String password) {
        boolean flag = false;
        if (hashString != null && password != null) {
            if (hashString.equals(calculateSha256(password))) {
                flag = true;
            }
        }
        return flag;
    }

    public static String calculateSha256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
