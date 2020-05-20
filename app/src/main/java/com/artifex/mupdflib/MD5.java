package com.artifex.mupdflib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.http.conn.ssl.TokenParser;

/* loaded from: classes.dex */
public class MD5 {
    public static boolean checkMD5(String str, File file) throws IOException {
        String calculateMD5;
        if (str == null || str == "" || file == null || (calculateMD5 = calculateMD5(file)) == null) {
            return false;
        }
        return calculateMD5.equalsIgnoreCase(str);
    }

    public static String calculateMD5(File file) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[8192];
                while (true) {
                    try {
                        try {
                            int read = fileInputStream.read(bArr);
                            if (read > 0) {
                                messageDigest.update(bArr, 0, read);
                            } else {
                                String replace = String.format("%32s", new BigInteger(1, messageDigest.digest()).toString(16)).replace(TokenParser.f24154SP, '0');
                                try {
                                    fileInputStream.close();
                                    return replace;
                                } catch (IOException e) {
                                    throw new RuntimeException("Unable to close input stream for MD5 calculation", e);
                                }
                            }
                        } catch (IOException e2) {
                            throw new RuntimeException("Unable to process file for MD5", e2);
                        }
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                            throw th;
                        } catch (IOException e3) {
                            throw new RuntimeException("Unable to close input stream for MD5 calculation", e3);
                        }
                    }
                }
            } catch (FileNotFoundException unused) {
                return null;
            }
        } catch (NoSuchAlgorithmException unused2) {
            return null;
        }
    }

    public static String MD5Hash(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes(), 0, str.length());
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}
