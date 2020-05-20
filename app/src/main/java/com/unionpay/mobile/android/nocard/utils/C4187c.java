package com.unionpay.mobile.android.nocard.utils;

import android.content.Context;
import android.text.TextUtils;
import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.views.order.InterfaceC4414l;

/* renamed from: com.unionpay.mobile.android.nocard.utils.c */
/* loaded from: classes2.dex */
public final class C4187c {
    /* renamed from: a */
    public static int m1481a(Context context, C4173b c4173b) {
        Integer num;
        String m900b = PreferenceUtils.m900b(context);
        int intValue = InterfaceC4414l.f23274b.intValue();
        if (!TextUtils.isEmpty(m900b) && TextUtils.isDigitsOnly(m900b)) {
            intValue = Integer.valueOf(m900b).intValue();
        }
        boolean equalsIgnoreCase = "0".equalsIgnoreCase(c4173b.f22439an);
        if (c4173b.f22448aw && (c4173b.f22440ao & 69889) == 0) {
            equalsIgnoreCase = true;
        }
        if (equalsIgnoreCase) {
            num = InterfaceC4414l.f23273a;
        } else {
            if (!TextUtils.isEmpty(c4173b.f22485u)) {
                intValue = InterfaceC4414l.f23274b.intValue();
            }
            if (!C4190f.m1477a(c4173b.f22484t)) {
                return intValue;
            }
            num = InterfaceC4414l.f23274b;
        }
        return num.intValue();
    }
}
