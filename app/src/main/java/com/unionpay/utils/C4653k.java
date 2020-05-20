package com.unionpay.utils;

import java.util.Locale;

/* renamed from: com.unionpay.utils.k */
/* loaded from: classes2.dex */
public class C4653k {

    /* renamed from: g */
    private static C4653k f23761g;

    /* renamed from: a */
    public String f23762a = "";

    /* renamed from: b */
    public String f23763b = "";

    /* renamed from: c */
    public String f23764c = "";

    /* renamed from: d */
    public String f23765d = "";

    /* renamed from: e */
    public String f23766e = "";

    /* renamed from: f */
    public String f23767f = "";

    /* renamed from: a */
    public static C4653k m431a() {
        if (f23761g == null) {
            f23761g = Locale.getDefault().toString().startsWith("zh") ? new C4654l() : new C4655m();
        }
        return f23761g;
    }
}
