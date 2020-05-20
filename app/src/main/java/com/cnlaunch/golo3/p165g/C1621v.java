package com.cnlaunch.golo3.p165g;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* compiled from: StringUtils.java */
/* renamed from: com.cnlaunch.golo3.g.v */
/* loaded from: classes.dex */
public final class C1621v {

    /* renamed from: a */
    public static DecimalFormat f8489a = new DecimalFormat(",###.#", new DecimalFormatSymbols(Locale.CHINA));

    /* renamed from: b */
    public static DecimalFormat f8490b = new DecimalFormat("#.#", new DecimalFormatSymbols(Locale.CHINA));

    /* renamed from: c */
    public static DecimalFormat f8491c = new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.CHINA));

    /* renamed from: d */
    public static DecimalFormat f8492d = new DecimalFormat("#", new DecimalFormatSymbols(Locale.CHINA));

    /* renamed from: e */
    public static DecimalFormat f8493e = new DecimalFormat(",###", new DecimalFormatSymbols(Locale.CHINA));

    /* renamed from: f */
    public static DecimalFormat f8494f = new DecimalFormat(",###.##", new DecimalFormatSymbols(Locale.CHINA));

    /* renamed from: a */
    public static boolean m9121a(String str) {
        return str == null || "".equals(str.trim()) || "null".equals(str.trim());
    }
}
