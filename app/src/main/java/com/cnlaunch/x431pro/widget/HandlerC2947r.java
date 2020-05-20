package com.cnlaunch.x431pro.widget;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TesterInfoDropdownEditText.java */
/* renamed from: com.cnlaunch.x431pro.widget.r */
/* loaded from: classes.dex */
public final class HandlerC2947r extends Handler {

    /* renamed from: a */
    final /* synthetic */ TesterInfoDropdownEditText f16736a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2947r(TesterInfoDropdownEditText testerInfoDropdownEditText) {
        this.f16736a = testerInfoDropdownEditText;
    }

    @Override // android.os.Handler
    @SuppressLint({"HandlerLeak"})
    public final void handleMessage(Message message2) {
        super.handleMessage(message2);
        if (message2.what != 1) {
            return;
        }
        this.f16736a.f16093g.dismiss();
    }
}
