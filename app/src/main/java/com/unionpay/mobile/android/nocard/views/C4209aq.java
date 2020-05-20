package com.unionpay.mobile.android.nocard.views;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.unionpay.mobile.android.views.order.InterfaceC4414l;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.nocard.views.aq */
/* loaded from: classes2.dex */
public final class C4209aq implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ C4206ao f22562a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4209aq(C4206ao c4206ao) {
        this.f22562a = c4206ao;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message2) {
        if (this.f22562a.f22590a.f22415aP != InterfaceC4414l.f23273a.intValue() || this.f22562a.f22590a.f22384J) {
            return true;
        }
        if (!TextUtils.isEmpty(this.f22562a.f22590a.f22485u)) {
            C4206ao c4206ao = this.f22562a;
            c4206ao.m1427a(13, c4206ao.f22605p);
            return true;
        } else if (this.f22562a.f22590a.f22402aC) {
            C4206ao.m1457d(this.f22562a);
            return true;
        } else {
            return true;
        }
    }
}
