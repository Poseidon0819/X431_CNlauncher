package com.unionpay.mobile.android.pboctransaction.remoteapdu;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.unionpay.mobile.android.pboctransaction.remoteapdu.b */
/* loaded from: classes2.dex */
final class C4275b implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ C4274a f22769a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4275b(C4274a c4274a) {
        this.f22769a = c4274a;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message2) {
        if (message2.what == 3000 && this.f22769a.f22760a != null) {
            this.f22769a.f22760a.mo1205b();
            return false;
        }
        return false;
    }
}
