package com.cnlaunch.x431pro.utils;

import android.util.Base64;
import java.io.UnsupportedEncodingException;

/* renamed from: com.cnlaunch.x431pro.utils.l */
/* loaded from: classes.dex */
public final class Base64Utils {
    /* renamed from: a */
    public static String m4923a(String str) {
        if (str != null) {
            try {
                return new String(Base64.encode(str.getBytes("utf-8"), 2), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "";
            }
        }
        return "";
    }

    /* renamed from: b */
    public static String m4922b(String str) {
        if (str != null) {
            try {
                return new String(Base64.decode(str, 2), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "";
            }
        }
        return "";
    }
}
