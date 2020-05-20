package com.cnlaunch.x431pro.activity.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: OneKeyFeedbackHistoryFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.ah */
/* loaded from: classes.dex */
final class C2523ah extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ OneKeyFeedbackHistoryFragment f14572a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2523ah(OneKeyFeedbackHistoryFragment oneKeyFeedbackHistoryFragment) {
        this.f14572a = oneKeyFeedbackHistoryFragment;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equalsIgnoreCase("login_change_serialno")) {
            this.f14572a.m6029a();
        }
    }
}
