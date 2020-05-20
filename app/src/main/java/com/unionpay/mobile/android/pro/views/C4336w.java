package com.unionpay.mobile.android.pro.views;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.model.C4172a;
import com.unionpay.mobile.android.model.C4173b;

/* renamed from: com.unionpay.mobile.android.pro.views.w */
/* loaded from: classes2.dex */
final class C4336w implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ C4335v f22987a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4336w(C4335v c4335v) {
        this.f22987a = c4335v;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message2) {
        C4173b c4173b;
        C4173b c4173b2;
        C4173b c4173b3;
        switch (message2.what) {
            case 2000:
                if (message2.obj == null) {
                    C4335v c4335v = this.f22987a;
                    c4173b = c4335v.f22590a;
                    c4335v.mo1138a(c4173b.f22441ap, false);
                    return true;
                }
                C4172a c4172a = (C4172a) message2.obj;
                if (c4172a != null) {
                    this.f22987a.m1466a(c4172a);
                    return true;
                }
                return true;
            case 2001:
                if ("1003100020".equalsIgnoreCase((String) message2.obj)) {
                    if (C4173b.f22372bm) {
                        this.f22987a.m1451s();
                        return true;
                    }
                    return true;
                } else if (C4173b.f22372bm) {
                    C4335v c4335v2 = this.f22987a;
                    c4173b3 = c4335v2.f22590a;
                    c4335v2.m1454e(c4173b3.f22441ap, "fail");
                    return true;
                } else {
                    C4335v c4335v3 = this.f22987a;
                    c4173b2 = c4335v3.f22590a;
                    c4335v3.mo1138a(c4173b2.f22441ap, false);
                    return true;
                }
            default:
                return true;
        }
    }
}
