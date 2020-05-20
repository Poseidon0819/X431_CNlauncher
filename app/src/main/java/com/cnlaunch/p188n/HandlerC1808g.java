package com.cnlaunch.p188n;

import android.os.Handler;
import android.os.Message;
import com.baidu.mapapi.UIMsg;

/* compiled from: ReportSocketControler.java */
/* renamed from: com.cnlaunch.n.g */
/* loaded from: classes.dex */
final class HandlerC1808g extends Handler {

    /* renamed from: a */
    final /* synthetic */ ReportSocketControler f9665a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC1808g(ReportSocketControler reportSocketControler) {
        this.f9665a = reportSocketControler;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        switch (message2.what) {
            case UIMsg.k_event.V_WM_ROTATE /* 8193 */:
                return;
            case UIMsg.k_event.V_WM_GETLASTCLRSATETIME /* 8194 */:
                this.f9665a.f9678n.m8524a();
                return;
            case UIMsg.k_event.V_WM_DBCLICK /* 8195 */:
                this.f9665a.f9678n.m8523b();
                return;
            default:
                return;
        }
    }
}
