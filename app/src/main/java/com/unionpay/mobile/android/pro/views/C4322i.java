package com.unionpay.mobile.android.pro.views;

import com.unionpay.mobile.android.model.InterfaceC4174c;
import com.unionpay.mobile.android.pro.pboc.engine.InterfaceC4297a;
import com.unionpay.mobile.android.utils.C4390k;
import java.util.ArrayList;

/* renamed from: com.unionpay.mobile.android.pro.views.i */
/* loaded from: classes2.dex */
final class C4322i implements InterfaceC4297a {

    /* renamed from: a */
    final /* synthetic */ C4321h f22935a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4322i(C4321h c4321h) {
        this.f22935a = c4321h;
    }

    @Override // com.unionpay.mobile.android.pro.pboc.engine.InterfaceC4297a
    /* renamed from: a */
    public final void mo1157a(ArrayList<InterfaceC4174c> arrayList) {
        C4390k.m838a("uppay", "deviceReady +++");
        if (arrayList != null && arrayList.size() > 0) {
            if (this.f22935a.f22668s == null) {
                this.f22935a.f22668s = new ArrayList(arrayList.size());
            }
            this.f22935a.f22668s.addAll(arrayList);
        }
        this.f22935a.m1369w();
        C4390k.m838a("uppay", "deviceReady ---");
    }
}
