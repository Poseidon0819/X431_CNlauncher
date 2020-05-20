package com.cnlaunch.x431pro.widget;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

/* compiled from: DropdownEditText.java */
/* renamed from: com.cnlaunch.x431pro.widget.j */
/* loaded from: classes.dex */
final class HandlerC2911j extends Handler {

    /* renamed from: a */
    final /* synthetic */ DropdownEditText f16584a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2911j(DropdownEditText dropdownEditText) {
        this.f16584a = dropdownEditText;
    }

    @Override // android.os.Handler
    @SuppressLint({"HandlerLeak"})
    public final void handleMessage(Message message2) {
        super.handleMessage(message2);
        if (message2.what != 1) {
            return;
        }
        this.f16584a.f16003g.dismiss();
    }
}
