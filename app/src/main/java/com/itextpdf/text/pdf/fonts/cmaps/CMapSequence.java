package com.itextpdf.text.pdf.fonts.cmaps;

/* loaded from: classes.dex */
public class CMapSequence {
    public int len;
    public int off;
    public byte[] seq;

    public CMapSequence() {
    }

    public CMapSequence(byte[] bArr, int i, int i2) {
        this.seq = bArr;
        this.off = i;
        this.len = i2;
    }
}
