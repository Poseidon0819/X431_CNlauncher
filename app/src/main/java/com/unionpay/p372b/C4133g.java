package com.unionpay.p372b;

import android.util.Log;
import com.unionpay.UPSEInfoResp;
import com.unionpay.tsmservice.p373mi.UPTsmAddon;
import com.unionpay.utils.C4652j;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.b.g */
/* loaded from: classes2.dex */
public final class C4133g implements UPTsmAddon.UPTsmConnectionListener {

    /* renamed from: a */
    final /* synthetic */ C4131e f22079a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4133g(C4131e c4131e) {
        this.f22079a = c4131e;
    }

    @Override // com.unionpay.tsmservice.p373mi.UPTsmAddon.UPTsmConnectionListener
    public final void onTsmConnected() {
        C4652j.m432b("uppay", "mi TsmService connected.");
        this.f22079a.m1617b();
    }

    @Override // com.unionpay.tsmservice.p373mi.UPTsmAddon.UPTsmConnectionListener
    public final void onTsmDisconnected() {
        String str;
        String str2;
        Log.e("uppay", "mi TsmService disconnected.");
        C4131e c4131e = this.f22079a;
        str = c4131e.f22071d;
        str2 = this.f22079a.f22072e;
        c4131e.m1618a(str, str2, UPSEInfoResp.ERROR_NONE, "Tsm service disconnect");
    }
}
