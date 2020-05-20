package com.unionpay.mobile.android.pboctransaction.nfc;

import com.itextpdf.text.pdf.PdfWriter;

/* renamed from: com.unionpay.mobile.android.pboctransaction.nfc.c */
/* loaded from: classes2.dex */
public final class C4273c {

    /* renamed from: a */
    private static final char[] f22759a = {'0', '1', PdfWriter.VERSION_1_2, PdfWriter.VERSION_1_3, PdfWriter.VERSION_1_4, PdfWriter.VERSION_1_5, PdfWriter.VERSION_1_6, PdfWriter.VERSION_1_7, '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public static String m1280a(byte[] bArr, int i) {
        char[] cArr = new char[i * 2];
        int i2 = i + 0;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            byte b = bArr[i4];
            int i5 = i3 + 1;
            char[] cArr2 = f22759a;
            cArr[i3] = cArr2[(b >> 4) & 15];
            i3 = i5 + 1;
            cArr[i5] = cArr2[b & 15];
        }
        return new String(cArr);
    }
}
