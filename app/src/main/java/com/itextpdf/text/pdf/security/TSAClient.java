package com.itextpdf.text.pdf.security;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public interface TSAClient {
    MessageDigest getMessageDigest() throws GeneralSecurityException;

    byte[] getTimeStampToken(byte[] bArr) throws Exception;

    int getTokenSizeEstimate();
}
