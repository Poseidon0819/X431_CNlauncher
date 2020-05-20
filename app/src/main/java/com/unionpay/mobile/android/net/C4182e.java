package com.unionpay.mobile.android.net;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* renamed from: com.unionpay.mobile.android.net.e */
/* loaded from: classes2.dex */
public final class C4182e {
    /* renamed from: a */
    public static String m1519a(InputStream inputStream, String str) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    return byteArrayOutputStream.toString(str);
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Throwable unused) {
                return null;
            }
        }
    }
}
