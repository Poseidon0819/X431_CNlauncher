package com.cnlaunch.x431pro.activity.golo.function;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: GoloFunctionActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.golo.function.c */
/* loaded from: classes.dex */
final class C2238c extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ GoloFunctionActivity f12613a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2238c(GoloFunctionActivity goloFunctionActivity) {
        this.f12613a = goloFunctionActivity;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.f12613a.m7018a(intent);
    }
}
