package com.unionpay.mobile.android.pboctransaction.samsung;

import android.text.TextUtils;
import com.unionpay.mobile.android.pboctransaction.C4264e;
import java.security.PrivateKey;
import javax.crypto.Cipher;

/* renamed from: com.unionpay.mobile.android.pboctransaction.samsung.a */
/* loaded from: classes2.dex */
public final class C4278a {
    /* renamed from: a */
    public static String m1273a(PrivateKey privateKey, String str) {
        if (TextUtils.isEmpty(str) || privateKey == null) {
            return "";
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            byte[] bArr = new byte[245];
            System.arraycopy(str.getBytes(), 0, bArr, 0, str.getBytes().length);
            cipher.init(1, privateKey);
            return C4264e.m1302a(cipher.doFinal(bArr));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
