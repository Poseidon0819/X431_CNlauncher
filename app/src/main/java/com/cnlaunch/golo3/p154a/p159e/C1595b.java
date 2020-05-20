package com.cnlaunch.golo3.p154a.p159e;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import java.io.File;

/* compiled from: Utils.java */
/* renamed from: com.cnlaunch.golo3.a.e.b */
/* loaded from: classes.dex */
public final class C1595b {

    /* renamed from: a */
    private static long[] f7796a = new long[256];

    static {
        for (int i = 0; i < 256; i++) {
            long j = i;
            for (int i2 = 0; i2 < 8; i2++) {
                j = (j >> 1) ^ ((((int) j) & 1) != 0 ? -7661587058870466123L : 0L);
            }
            f7796a[i] = j;
        }
    }

    /* renamed from: a */
    public static File m9186a(Context context, String str) {
        String path;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            path = new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/cache/")).getPath();
        } else {
            path = context.getCacheDir().getPath();
        }
        return new File(path + File.separator + str);
    }

    /* renamed from: a */
    public static int m9185a(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    /* renamed from: a */
    public static boolean m9182a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (bArr2.length < length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static final long m9183a(byte[] bArr) {
        long j = -1;
        for (byte b : bArr) {
            j = (j >> 8) ^ f7796a[(((int) j) ^ b) & 255];
        }
        return j;
    }

    /* renamed from: a */
    public static byte[] m9184a(String str) {
        char[] charArray;
        byte[] bArr = new byte[str.length() * 2];
        int i = 0;
        for (char c : str.toCharArray()) {
            int i2 = i + 1;
            bArr[i] = (byte) (c & 255);
            i = i2 + 1;
            bArr[i2] = (byte) (c >> '\b');
        }
        return bArr;
    }
}
