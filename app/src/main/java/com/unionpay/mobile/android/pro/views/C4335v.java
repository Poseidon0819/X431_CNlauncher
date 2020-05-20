package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.os.Handler;
import com.unionpay.mobile.android.hce.C4153c;
import com.unionpay.mobile.android.hce.C4156f;
import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.model.InterfaceC4175d;
import com.unionpay.mobile.android.model.InterfaceC4176e;
import com.unionpay.mobile.android.nocard.views.C4206ao;
import com.unionpay.mobile.android.pro.pboc.engine.C4298b;
import com.unionpay.uppay.PayActivity;
import java.util.Iterator;

/* renamed from: com.unionpay.mobile.android.pro.views.v */
/* loaded from: classes2.dex */
public final class C4335v extends C4206ao {
    public C4335v(Context context, InterfaceC4176e interfaceC4176e) {
        super(context, interfaceC4176e);
    }

    @Override // com.unionpay.mobile.android.nocard.views.C4206ao
    /* renamed from: a */
    public final void mo1097a(Handler handler) {
        Object mo476a = ((PayActivity) this.f22593d).mo476a(C4156f.class.toString());
        if (mo476a != null) {
            ((C4156f) mo476a).m1589a(handler);
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.C4206ao
    /* renamed from: d */
    public final void mo1088d(String str, String str2) {
        if (C4173b.f22373bn) {
            mo1138a(this.f22590a.f22441ap, false);
            return;
        }
        Object mo476a = ((PayActivity) this.f22593d).mo476a(C4298b.class.toString());
        if (mo476a != null) {
            ((C4298b) mo476a).m1221a(new Handler(new C4336w(this)), str, str2);
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.C4206ao
    /* renamed from: t */
    public final boolean mo1087t() {
        return true;
    }

    @Override // com.unionpay.mobile.android.nocard.views.C4206ao
    /* renamed from: u */
    public final void mo1086u() {
        if (C4173b.f22370bb != null) {
            Iterator<InterfaceC4175d> it = C4173b.f22370bb.iterator();
            while (it.hasNext()) {
                try {
                    this.f22593d.unbindService(((C4153c) it.next()).m1602h());
                } catch (IllegalArgumentException unused) {
                }
            }
        }
    }
}
