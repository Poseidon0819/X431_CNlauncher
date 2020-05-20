package com.cnlaunch.x431pro.activity.golousa;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: GoloUSAFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.golousa.b */
/* loaded from: classes.dex */
final class C2246b extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ GoloUSAFragment f12710a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2246b(GoloUSAFragment goloUSAFragment) {
        this.f12710a = goloUSAFragment;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equalsIgnoreCase("refreshtip")) {
            this.f12710a.m6948b();
        }
    }
}
