package com.unionpay.p372b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.unionpay.UPSEInfoResp;
import com.unionpay.utils.C4652j;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.b.c */
/* loaded from: classes2.dex */
public final class C4129c implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ C4128b f22066a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4129c(C4128b c4128b) {
        this.f22066a = c4128b;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message2) {
        Handler handler;
        Handler handler2;
        int i = message2.what;
        if (i == 1) {
            handler = this.f22066a.f22064i;
            handler.removeMessages(4);
            C4652j.m432b("uppay", "msg error");
            C4128b.m1634a(this.f22066a, message2.arg1, (String) message2.obj);
            return false;
        } else if (i == 4) {
            C4652j.m432b("uppay", "timeout");
            C4128b.m1634a(this.f22066a, message2.arg1, UPSEInfoResp.ERROR_TIMEOUT);
            C4128b.m1628b(this.f22066a);
            return false;
        } else if (i != 4000) {
            return false;
        } else {
            handler2 = this.f22066a.f22064i;
            handler2.removeMessages(4);
            C4128b.m1633a(this.f22066a, (Bundle) message2.obj);
            return false;
        }
    }
}
