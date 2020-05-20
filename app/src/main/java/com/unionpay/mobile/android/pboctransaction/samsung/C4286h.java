package com.unionpay.mobile.android.pboctransaction.samsung;

import android.util.Log;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.tsmservice.UPTsmAddon;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pboctransaction.samsung.h */
/* loaded from: classes2.dex */
public final class C4286h implements UPTsmAddon.UPTsmConnectionListener {

    /* renamed from: a */
    final /* synthetic */ C4283f f22819a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4286h(C4283f c4283f) {
        this.f22819a = c4283f;
    }

    @Override // com.unionpay.tsmservice.UPTsmAddon.UPTsmConnectionListener
    public final void onTsmConnected() {
        C4390k.m836c("uppay", "TsmService connected.");
        this.f22819a.m1250f();
    }

    @Override // com.unionpay.tsmservice.UPTsmAddon.UPTsmConnectionListener
    public final void onTsmDisconnected() {
        Log.e("uppay", "TsmService disconnected.");
        this.f22819a.m1262a(false);
    }
}
