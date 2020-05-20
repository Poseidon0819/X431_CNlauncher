package com.baidu.mapsdkplatform.comapi.synchronization.p091d;

import android.text.TextUtils;
import com.itextpdf.text.pdf.PdfWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.d.c */
/* loaded from: classes.dex */
public final class C1257c {

    /* renamed from: a */
    private static final String f6208a = "c";

    /* renamed from: a */
    public static String m10450a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return m10449a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            C1255a.m10456a(f6208a, "NoSuchAlgorithmException happened when get MD5 string", e);
            return null;
        }
    }

    /* renamed from: a */
    private static String m10449a(byte[] bArr) {
        char[] cArr = {'0', '1', PdfWriter.VERSION_1_2, PdfWriter.VERSION_1_3, PdfWriter.VERSION_1_4, PdfWriter.VERSION_1_5, PdfWriter.VERSION_1_6, PdfWriter.VERSION_1_7, '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i = i2 + 1;
            cArr2[i2] = cArr[b & 15];
        }
        return new String(cArr2).toLowerCase();
    }
}
