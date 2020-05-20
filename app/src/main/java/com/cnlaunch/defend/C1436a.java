package com.cnlaunch.defend;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;

/* compiled from: DefendService.java */
/* renamed from: com.cnlaunch.defend.a */
/* loaded from: classes.dex */
final class C1436a extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ DefendService f7256a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1436a(DefendService defendService) {
        this.f7256a = defendService;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        DefendTimer defendTimer;
        DefendTimer defendTimer2;
        Log.d("Sanda", "DefendService: intent.getAction():" + intent.getAction());
        if (intent.getAction().equals("app_exit")) {
            defendTimer = this.f7256a.f7254b;
            if (defendTimer != null) {
                defendTimer2 = this.f7256a.f7254b;
                defendTimer2.m9427b();
            }
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }
}
