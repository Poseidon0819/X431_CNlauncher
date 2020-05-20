package com.unionpay.p372b;

import android.util.Log;
import com.unionpay.UPSEInfoResp;
import com.unionpay.tsmservice.UPTsmAddon;
import com.unionpay.utils.C4652j;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.b.d */
/* loaded from: classes2.dex */
public final class C4130d implements UPTsmAddon.UPTsmConnectionListener {

    /* renamed from: a */
    final /* synthetic */ C4128b f22067a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4130d(C4128b c4128b) {
        this.f22067a = c4128b;
    }

    @Override // com.unionpay.tsmservice.UPTsmAddon.UPTsmConnectionListener
    public final void onTsmConnected() {
        C4652j.m432b("uppay", "TsmService connected.");
        this.f22067a.m1629b();
    }

    @Override // com.unionpay.tsmservice.UPTsmAddon.UPTsmConnectionListener
    public final void onTsmDisconnected() {
        String str;
        String str2;
        Log.e("uppay", "TsmService disconnected.");
        C4128b c4128b = this.f22067a;
        str = c4128b.f22059d;
        str2 = this.f22067a.f22060e;
        c4128b.m1630a(str, str2, UPSEInfoResp.ERROR_NONE, "Tsm service disconnect");
    }
}
