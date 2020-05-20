package com.cnlaunch.gmap.p138a.p144f;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import java.io.File;

/* renamed from: com.cnlaunch.gmap.a.f.a */
/* loaded from: classes.dex */
public final class Utils {

    /* renamed from: a */
    private static long[] f7457a = new long[256];

    static {
        for (int i = 0; i < 256; i++) {
            long j = i;
            for (int i2 = 0; i2 < 8; i2++) {
                j = (j >> 1) ^ ((((int) j) & 1) != 0 ? -7661587058870466123L : 0L);
            }
            f7457a[i] = j;
        }
    }

    /* renamed from: a */
    public static File m9348a(Context context, String str) {
        String path;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            path = new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/cache/")).getPath();
        } else {
            path = context.getCacheDir().getPath();
        }
        return new File(path + File.separator + str);
    }

    /* renamed from: a */
    public static int m9347a(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    /* renamed from: a */
    public static boolean m9344a(byte[] bArr, byte[] bArr2) {
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
    public static final long m9345a(byte[] bArr) {
        long j = -1;
        for (byte b : bArr) {
            j = (j >> 8) ^ f7457a[(((int) j) ^ b) & 255];
        }
        return j;
    }

    /* renamed from: a */
    public static byte[] m9346a(String str) {
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
