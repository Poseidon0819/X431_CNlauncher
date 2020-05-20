package com.itextpdf.text.pdf.security;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.bouncycastle.jcajce.provider.digest.GOST3411;
import org.bouncycastle.jcajce.provider.digest.MD2;
import org.bouncycastle.jcajce.provider.digest.MD5;
import org.bouncycastle.jcajce.provider.digest.RIPEMD128;
import org.bouncycastle.jcajce.provider.digest.RIPEMD160;
import org.bouncycastle.jcajce.provider.digest.RIPEMD256;
import org.bouncycastle.jcajce.provider.digest.SHA1;
import org.bouncycastle.jcajce.provider.digest.SHA224;
import org.bouncycastle.jcajce.provider.digest.SHA256;
import org.bouncycastle.jcajce.provider.digest.SHA384;
import org.bouncycastle.jcajce.provider.digest.SHA512;

/* loaded from: classes.dex */
public class BouncyCastleDigest implements ExternalDigest {
    @Override // com.itextpdf.text.pdf.security.ExternalDigest
    public MessageDigest getMessageDigest(String str) throws GeneralSecurityException {
        String allowedDigests = DigestAlgorithms.getAllowedDigests(str);
        if (allowedDigests == null) {
            throw new NoSuchAlgorithmException(str);
        }
        if (allowedDigests.equals("1.2.840.113549.2.2")) {
            return new MD2.Digest();
        }
        if (allowedDigests.equals("1.2.840.113549.2.5")) {
            return new MD5.Digest();
        }
        if (allowedDigests.equals("1.3.14.3.2.26")) {
            return new SHA1.Digest();
        }
        if (allowedDigests.equals("2.16.840.1.101.3.4.2.4")) {
            return new SHA224.Digest();
        }
        if (allowedDigests.equals("2.16.840.1.101.3.4.2.1")) {
            return new SHA256.Digest();
        }
        if (allowedDigests.equals("2.16.840.1.101.3.4.2.2")) {
            return new SHA384.Digest();
        }
        if (allowedDigests.equals("2.16.840.1.101.3.4.2.3")) {
            return new SHA512.Digest();
        }
        if (allowedDigests.equals("1.3.36.3.2.2")) {
            return new RIPEMD128.Digest();
        }
        if (allowedDigests.equals("1.3.36.3.2.1")) {
            return new RIPEMD160.Digest();
        }
        if (allowedDigests.equals("1.3.36.3.2.3")) {
            return new RIPEMD256.Digest();
        }
        if (allowedDigests.equals("1.2.643.2.2.9")) {
            return new GOST3411.Digest();
        }
        throw new NoSuchAlgorithmException(str);
    }
}
