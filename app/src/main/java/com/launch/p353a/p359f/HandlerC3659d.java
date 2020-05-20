package com.launch.p353a.p359f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.launch.p353a.p363j.SplashADListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ClickManager.java */
/* renamed from: com.launch.a.f.d */
/* loaded from: classes.dex */
public final class HandlerC3659d extends Handler {

    /* renamed from: a */
    final /* synthetic */ ClickManager f19947a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC3659d(ClickManager clickManager, Looper looper) {
        super(looper);
        this.f19947a = clickManager;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        SplashADListener splashADListener;
        Handler handler;
        SplashADListener unused;
        if (message2.what != 0) {
            return;
        }
        splashADListener = this.f19947a.f19937f;
        if (splashADListener != null) {
            unused = this.f19947a.f19937f;
            handler = this.f19947a.f19944m;
            handler.removeCallbacksAndMessages(null);
        }
    }
}
