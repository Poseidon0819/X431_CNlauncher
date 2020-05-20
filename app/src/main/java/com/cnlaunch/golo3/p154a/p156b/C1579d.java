package com.cnlaunch.golo3.p154a.p156b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/* compiled from: BitmapDecoder.java */
/* renamed from: com.cnlaunch.golo3.a.b.d */
/* loaded from: classes.dex */
public final class C1579d {
    /* renamed from: a */
    public static Bitmap m9224a(byte[] bArr, int i, int i2, int i3, int i4) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inPurgeable = true;
        BitmapFactory.decodeByteArray(bArr, i, i2, options);
        options.inSampleSize = m9225a(options, i3, i4);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(bArr, i, i2, options);
    }

    /* renamed from: a */
    private static int m9225a(BitmapFactory.Options options, int i, int i2) {
        int round;
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 > i2 || i4 > i) {
            if (i4 > i3) {
                round = Math.round(i3 / i2);
            } else {
                round = Math.round(i4 / i);
            }
            while ((i4 * i3) / (round * round) > i * i2 * 2) {
                round++;
            }
            return round;
        }
        return 1;
    }
}
