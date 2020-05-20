package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import com.unionpay.mobile.android.hce.C4156f;
import com.unionpay.mobile.android.pro.pboc.engine.C4298b;
import com.unionpay.uppay.PayActivity;

/* renamed from: com.unionpay.mobile.android.pro.views.j */
/* loaded from: classes2.dex */
public final class C4323j extends C4321h {
    public C4323j(Context context) {
        super(context);
    }

    @Override // com.unionpay.mobile.android.nocard.views.C4242l
    /* renamed from: a */
    public final void mo1156a(int i, int i2, String str, String str2, int i3, String str3) {
        Object mo476a = ((PayActivity) this.f22593d).mo476a(C4156f.class.toString());
        if (mo476a != null) {
            C4156f c4156f = (C4156f) mo476a;
            c4156f.m1592a();
            c4156f.m1591a(i);
            c4156f.m1582b(i2);
            c4156f.m1585a(str);
            c4156f.m1579b(str2);
            c4156f.m1575c(str3);
            c4156f.m1577c(i3);
            c4156f.m1578c();
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.C4242l
    /* renamed from: s */
    public final boolean mo1155s() {
        return true;
    }

    @Override // com.unionpay.mobile.android.nocard.views.C4242l
    /* renamed from: t */
    public final boolean mo1154t() {
        return true;
    }

    @Override // com.unionpay.mobile.android.pro.views.C4321h
    /* renamed from: y */
    public final C4298b mo1153y() {
        Object mo476a = ((PayActivity) this.f22593d).mo476a(C4298b.class.toString());
        if (mo476a != null) {
            return (C4298b) mo476a;
        }
        return null;
    }
}
