package com.itextpdf.p349a.p350a.p352b;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/* renamed from: com.itextpdf.a.a.b.b */
/* loaded from: classes.dex */
public final class Messages {

    /* renamed from: a */
    private static ResourceBundle f19500a;

    /* renamed from: a */
    public static String m2741a(String str) {
        ResourceBundle resourceBundle = f19500a;
        if (resourceBundle == null) {
            return str;
        }
        try {
            return resourceBundle.getString(str);
        } catch (MissingResourceException unused) {
            return "Missing message: ".concat(String.valueOf(str));
        }
    }
}
