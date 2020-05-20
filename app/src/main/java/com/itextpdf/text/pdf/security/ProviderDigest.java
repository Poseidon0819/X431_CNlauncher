package com.itextpdf.text.pdf.security;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class ProviderDigest implements ExternalDigest {
    private String provider;

    public ProviderDigest(String str) {
        this.provider = str;
    }

    @Override // com.itextpdf.text.pdf.security.ExternalDigest
    public MessageDigest getMessageDigest(String str) throws GeneralSecurityException {
        return DigestAlgorithms.getMessageDigest(str, this.provider);
    }
}
