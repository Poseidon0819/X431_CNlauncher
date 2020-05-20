package com.cnlaunch.p169im;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMPresenter.java */
/* renamed from: com.cnlaunch.im.e */
/* loaded from: classes.dex */
public final class HandlerC1736e extends Handler {

    /* renamed from: a */
    final /* synthetic */ IMPresenter f9236a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC1736e(IMPresenter iMPresenter) {
        this.f9236a = iMPresenter;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        if (message2.what != 0) {
            return;
        }
        IMPresenter iMPresenter = this.f9236a;
        int i = message2.arg1;
        int i2 = message2.arg2;
        iMPresenter.m8792d(i);
    }
}
