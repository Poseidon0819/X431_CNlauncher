package com.cnlaunch.x431pro.activity.diagnose;

import android.os.Handler;
import android.os.Message;
import java.util.List;

/* compiled from: FittingsSearchFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.bn */
/* loaded from: classes.dex */
final class HandlerC2079bn extends Handler {

    /* renamed from: a */
    final /* synthetic */ FittingsSearchFragment f11561a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2079bn(FittingsSearchFragment fittingsSearchFragment) {
        this.f11561a = fittingsSearchFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        List list;
        if (message2.what != 123123) {
            return;
        }
        int intValue = ((Integer) message2.obj).intValue();
        list = this.f11561a.f11555a;
        list.remove(intValue);
        this.f11561a.m7467a();
    }
}
