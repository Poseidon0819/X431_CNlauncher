package com.cnlaunch.x431pro.widget;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

/* compiled from: VinDropdownEditText.java */
/* renamed from: com.cnlaunch.x431pro.widget.u */
/* loaded from: classes.dex */
final class HandlerC2982u extends Handler {

    /* renamed from: a */
    final /* synthetic */ VinDropdownEditText f16961a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2982u(VinDropdownEditText vinDropdownEditText) {
        this.f16961a = vinDropdownEditText;
    }

    @Override // android.os.Handler
    @SuppressLint({"HandlerLeak"})
    public final void handleMessage(Message message2) {
        super.handleMessage(message2);
        if (message2.what != 1) {
            return;
        }
        this.f16961a.f16109h.dismiss();
    }
}
