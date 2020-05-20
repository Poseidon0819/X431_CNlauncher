package com.unionpay.mobile.android.upwidget;

import android.os.Handler;
import android.view.ViewTreeObserver;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.upwidget.u */
/* loaded from: classes2.dex */
public final class ViewTreeObserver$OnGlobalLayoutListenerC4376u implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ UPScrollView f23167a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTreeObserver$OnGlobalLayoutListenerC4376u(UPScrollView uPScrollView) {
        this.f23167a = uPScrollView;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Handler handler;
        Handler handler2;
        handler = this.f23167a.f23052d;
        handler2 = this.f23167a.f23052d;
        handler.sendMessageDelayed(handler2.obtainMessage(), 5L);
    }
}
