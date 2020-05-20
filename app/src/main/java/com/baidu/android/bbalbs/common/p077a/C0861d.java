package com.baidu.android.bbalbs.common.p077a;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.baidu.android.bbalbs.common.a.d */
/* loaded from: classes.dex */
public final class C0861d {
    /* renamed from: a */
    public static byte[] m12427a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-1").digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
