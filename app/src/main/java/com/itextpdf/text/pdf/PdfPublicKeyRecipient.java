package com.itextpdf.text.pdf;

import java.security.cert.Certificate;

/* loaded from: classes.dex */
public class PdfPublicKeyRecipient {
    private Certificate certificate;
    protected byte[] cms = null;
    private int permission;

    public PdfPublicKeyRecipient(Certificate certificate, int i) {
        this.certificate = null;
        this.permission = 0;
        this.certificate = certificate;
        this.permission = i;
    }

    public Certificate getCertificate() {
        return this.certificate;
    }

    public int getPermission() {
        return this.permission;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setCms(byte[] bArr) {
        this.cms = bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] getCms() {
        return this.cms;
    }
}
