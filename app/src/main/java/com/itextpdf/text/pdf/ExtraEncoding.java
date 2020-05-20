package com.itextpdf.text.pdf;

/* loaded from: classes.dex */
public interface ExtraEncoding {
    String byteToChar(byte[] bArr, String str);

    byte[] charToByte(char c, String str);

    byte[] charToByte(String str, String str2);
}
