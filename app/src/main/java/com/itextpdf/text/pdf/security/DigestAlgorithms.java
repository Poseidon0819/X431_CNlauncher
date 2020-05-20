package com.itextpdf.text.pdf.security;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;

/* loaded from: classes.dex */
public class DigestAlgorithms {
    public static final String RIPEMD160 = "RIPEMD160";
    public static final String SHA1 = "SHA-1";
    public static final String SHA256 = "SHA-256";
    public static final String SHA384 = "SHA-384";
    public static final String SHA512 = "SHA-512";
    private static final HashMap<String, String> digestNames = new HashMap<>();
    private static final HashMap<String, String> fixNames = new HashMap<>();
    private static final HashMap<String, String> allowedDigests = new HashMap<>();

    static {
        digestNames.put("1.2.840.113549.2.5", "MD5");
        digestNames.put("1.2.840.113549.2.2", "MD2");
        digestNames.put("1.3.14.3.2.26", "SHA1");
        digestNames.put("2.16.840.1.101.3.4.2.4", "SHA224");
        digestNames.put("2.16.840.1.101.3.4.2.1", "SHA256");
        digestNames.put("2.16.840.1.101.3.4.2.2", "SHA384");
        digestNames.put("2.16.840.1.101.3.4.2.3", "SHA512");
        digestNames.put("1.3.36.3.2.2", "RIPEMD128");
        digestNames.put("1.3.36.3.2.1", RIPEMD160);
        digestNames.put("1.3.36.3.2.3", "RIPEMD256");
        digestNames.put("1.2.840.113549.1.1.4", "MD5");
        digestNames.put("1.2.840.113549.1.1.2", "MD2");
        digestNames.put("1.2.840.113549.1.1.5", "SHA1");
        digestNames.put("1.2.840.113549.1.1.14", "SHA224");
        digestNames.put("1.2.840.113549.1.1.11", "SHA256");
        digestNames.put("1.2.840.113549.1.1.12", "SHA384");
        digestNames.put("1.2.840.113549.1.1.13", "SHA512");
        digestNames.put("1.2.840.113549.2.5", "MD5");
        digestNames.put("1.2.840.113549.2.2", "MD2");
        digestNames.put("1.2.840.10040.4.3", "SHA1");
        digestNames.put("2.16.840.1.101.3.4.3.1", "SHA224");
        digestNames.put("2.16.840.1.101.3.4.3.2", "SHA256");
        digestNames.put("2.16.840.1.101.3.4.3.3", "SHA384");
        digestNames.put("2.16.840.1.101.3.4.3.4", "SHA512");
        digestNames.put("1.3.36.3.3.1.3", "RIPEMD128");
        digestNames.put("1.3.36.3.3.1.2", RIPEMD160);
        digestNames.put("1.3.36.3.3.1.4", "RIPEMD256");
        digestNames.put("1.2.643.2.2.9", "GOST3411");
        fixNames.put("SHA256", "SHA-256");
        fixNames.put("SHA384", SHA384);
        fixNames.put("SHA512", SHA512);
        allowedDigests.put("MD2", "1.2.840.113549.2.2");
        allowedDigests.put("MD-2", "1.2.840.113549.2.2");
        allowedDigests.put("MD5", "1.2.840.113549.2.5");
        allowedDigests.put("MD-5", "1.2.840.113549.2.5");
        allowedDigests.put("SHA1", "1.3.14.3.2.26");
        allowedDigests.put("SHA-1", "1.3.14.3.2.26");
        allowedDigests.put("SHA224", "2.16.840.1.101.3.4.2.4");
        allowedDigests.put("SHA-224", "2.16.840.1.101.3.4.2.4");
        allowedDigests.put("SHA256", "2.16.840.1.101.3.4.2.1");
        allowedDigests.put("SHA-256", "2.16.840.1.101.3.4.2.1");
        allowedDigests.put("SHA384", "2.16.840.1.101.3.4.2.2");
        allowedDigests.put(SHA384, "2.16.840.1.101.3.4.2.2");
        allowedDigests.put("SHA512", "2.16.840.1.101.3.4.2.3");
        allowedDigests.put(SHA512, "2.16.840.1.101.3.4.2.3");
        allowedDigests.put("RIPEMD128", "1.3.36.3.2.2");
        allowedDigests.put("RIPEMD-128", "1.3.36.3.2.2");
        allowedDigests.put(RIPEMD160, "1.3.36.3.2.1");
        allowedDigests.put("RIPEMD-160", "1.3.36.3.2.1");
        allowedDigests.put("RIPEMD256", "1.3.36.3.2.3");
        allowedDigests.put("RIPEMD-256", "1.3.36.3.2.3");
        allowedDigests.put("GOST3411", "1.2.643.2.2.9");
    }

    public static MessageDigest getMessageDigestFromOid(String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException {
        return getMessageDigest(getDigest(str), str2);
    }

    public static MessageDigest getMessageDigest(String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (str2 == null || str2.startsWith("SunPKCS11") || str2.startsWith("SunMSCAPI")) {
            return MessageDigest.getInstance(normalizeDigestName(str));
        }
        return MessageDigest.getInstance(str, str2);
    }

    public static byte[] digest(InputStream inputStream, String str, String str2) throws GeneralSecurityException, IOException {
        return digest(inputStream, getMessageDigest(str, str2));
    }

    public static byte[] digest(InputStream inputStream, MessageDigest messageDigest) throws GeneralSecurityException, IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                messageDigest.update(bArr, 0, read);
            } else {
                return messageDigest.digest();
            }
        }
    }

    public static String getDigest(String str) {
        String str2 = digestNames.get(str);
        return str2 == null ? str : str2;
    }

    public static String normalizeDigestName(String str) {
        return fixNames.containsKey(str) ? fixNames.get(str) : str;
    }

    public static String getAllowedDigests(String str) {
        return allowedDigests.get(str.toUpperCase());
    }
}
