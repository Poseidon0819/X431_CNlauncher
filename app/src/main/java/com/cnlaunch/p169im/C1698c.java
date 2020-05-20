package com.cnlaunch.p169im;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.cnlaunch.x431pro.activity.golousa.GoloUSAActivity;
import com.cnlaunch.x431pro.activity.mine.MineActivity;
import com.cnlaunch.x431pro.utils.C2744aa;

/* compiled from: IMActivity.java */
/* renamed from: com.cnlaunch.im.c */
/* loaded from: classes.dex */
final class C1698c extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ IMActivity f9042a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1698c(IMActivity iMActivity) {
        this.f9042a = iMActivity;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Context context2;
        if (intent.getAction().equals("finishIMActivity")) {
            context2 = this.f9042a.f10981q;
            IMPresenter.m8804a(context2).m8791d((C2744aa.m5139k() ? GoloUSAActivity.class : MineActivity.class).getName());
        }
    }
}
