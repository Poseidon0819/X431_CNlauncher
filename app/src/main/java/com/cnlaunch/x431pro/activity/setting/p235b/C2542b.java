package com.cnlaunch.x431pro.activity.setting.p235b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: DiagLogHistoryInfoManager.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.b.b */
/* loaded from: classes.dex */
final class C2542b extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ DiagLogHistoryInfoManager f14647a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2542b(DiagLogHistoryInfoManager diagLogHistoryInfoManager) {
        this.f14647a = diagLogHistoryInfoManager;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equalsIgnoreCase("logout")) {
            this.f14647a.onFailure(-100, 0, "");
        }
    }
}
