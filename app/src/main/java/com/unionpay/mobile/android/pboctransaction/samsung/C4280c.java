package com.unionpay.mobile.android.pboctransaction.samsung;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pboctransaction.samsung.c */
/* loaded from: classes2.dex */
public final class C4280c implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ C4279b f22778a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4280c(C4279b c4279b) {
        this.f22778a = c4279b;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message2) {
        if (message2.what == 1) {
            this.f22778a.m1269a(false);
        }
        return true;
    }
}
