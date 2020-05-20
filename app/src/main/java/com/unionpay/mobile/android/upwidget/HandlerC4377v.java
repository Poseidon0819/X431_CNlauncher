package com.unionpay.mobile.android.upwidget;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.upwidget.UPScrollView;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.upwidget.v */
/* loaded from: classes2.dex */
public final class HandlerC4377v extends Handler {

    /* renamed from: a */
    final /* synthetic */ UPScrollView f23168a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC4377v(UPScrollView uPScrollView) {
        this.f23168a = uPScrollView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        int i;
        WeakReference weakReference;
        WeakReference weakReference2;
        WeakReference weakReference3;
        Handler handler;
        Handler handler2;
        int scrollY = this.f23168a.getScrollY();
        i = this.f23168a.f23050b;
        if (i != scrollY) {
            this.f23168a.f23050b = scrollY;
            handler = this.f23168a.f23052d;
            handler2 = this.f23168a.f23052d;
            handler.sendMessageDelayed(handler2.obtainMessage(), 5L);
        }
        weakReference = this.f23168a.f23049a;
        if (weakReference != null) {
            weakReference2 = this.f23168a.f23049a;
            if (weakReference2.get() != null) {
                weakReference3 = this.f23168a.f23049a;
                ((UPScrollView.InterfaceC4353a) weakReference3.get()).mo990e(scrollY);
            }
        }
    }
}
