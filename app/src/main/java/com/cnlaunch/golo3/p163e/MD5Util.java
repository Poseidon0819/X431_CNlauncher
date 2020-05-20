package com.cnlaunch.golo3.p163e;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.cnlaunch.golo3.e.c */
/* loaded from: classes.dex */
public final class MD5Util {
    /* renamed from: a */
    public static String m9159a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            try {
                messageDigest.update(str.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                while (hexString.length() < 2) {
                    hexString = "0".concat(String.valueOf(hexString));
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
