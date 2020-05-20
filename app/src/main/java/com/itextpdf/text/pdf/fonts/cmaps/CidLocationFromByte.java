package com.itextpdf.text.pdf.fonts.cmaps;

import com.itextpdf.text.pdf.PRTokeniser;
import java.io.IOException;

/* loaded from: classes.dex */
public class CidLocationFromByte implements CidLocation {
    private byte[] data;

    public CidLocationFromByte(byte[] bArr) {
        this.data = bArr;
    }

    @Override // com.itextpdf.text.pdf.fonts.cmaps.CidLocation
    public PRTokeniser getLocation(String str) throws IOException {
        return new PRTokeniser(this.data);
    }
}
