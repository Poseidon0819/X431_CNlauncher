package com.unionpay.mobile.android.upwidget;

import android.os.Handler;
import android.os.Message;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.upwidget.t */
/* loaded from: classes2.dex */
public final class HandlerC4375t extends Handler {

    /* renamed from: a */
    final /* synthetic */ UPRadiationView f23166a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC4375t(UPRadiationView uPRadiationView) {
        this.f23166a = uPRadiationView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        List list;
        List list2;
        Handler handler;
        super.handleMessage(message2);
        if (message2.what != 0) {
            return;
        }
        UPRadiationView.m998a(this.f23166a);
        this.f23166a.invalidate();
        list = this.f23166a.f23039a;
        if (list != null) {
            list2 = this.f23166a.f23039a;
            if (list2.size() > 0) {
                handler = this.f23166a.f23043e;
                handler.sendEmptyMessageDelayed(0, 50L);
            }
        }
    }
}
