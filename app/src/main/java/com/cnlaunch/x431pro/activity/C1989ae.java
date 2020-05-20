package com.cnlaunch.x431pro.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: ReportShowActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.ae */
/* loaded from: classes.dex */
final class C1989ae extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ReportShowActivity f10884a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1989ae(ReportShowActivity reportShowActivity) {
        this.f10884a = reportShowActivity;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("clos_report_show")) {
            this.f10884a.finish();
        }
    }
}
