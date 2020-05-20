package com.cnlaunch.p135g.p137b;

import java.util.Locale;

/* renamed from: com.cnlaunch.g.b.b */
/* loaded from: classes.dex */
public final class LocalUtils {
    /* renamed from: a */
    public static boolean m9423a() {
        return Locale.getDefault().toString().startsWith("zh_CN") || Locale.getDefault().getCountry().equalsIgnoreCase("CN");
    }
}
