package com.itextpdf.text.pdf.interfaces;

import com.itextpdf.text.DocumentException;
import java.security.cert.Certificate;

/* loaded from: classes.dex */
public interface PdfEncryptionSettings {
    void setEncryption(byte[] bArr, byte[] bArr2, int i, int i2) throws DocumentException;

    void setEncryption(Certificate[] certificateArr, int[] iArr, int i) throws DocumentException;
}
