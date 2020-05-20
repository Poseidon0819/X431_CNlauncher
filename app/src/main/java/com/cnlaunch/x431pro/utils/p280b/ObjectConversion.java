package com.cnlaunch.x431pro.utils.p280b;

import android.util.Base64;
import com.cnlaunch.diagnosemodule.utils.ByteHexHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* renamed from: com.cnlaunch.x431pro.utils.b.c */
/* loaded from: classes.dex */
public final class ObjectConversion {
    /* renamed from: a */
    public static Object m5097a(byte[] bArr) {
        try {
            return new ObjectInputStream(new ByteArrayInputStream(Base64.decode(ByteHexHelper.byteToWord(bArr), 0))).readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m5098a(Object obj) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
            return Base64.encode(byteArrayOutputStream.toByteArray(), 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
