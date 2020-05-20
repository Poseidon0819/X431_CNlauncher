package com.cnlaunch.x431pro.activity.mine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: PersonInformationFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.bu */
/* loaded from: classes.dex */
final class C2446bu extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ PersonInformationFragment f14006a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2446bu(PersonInformationFragment personInformationFragment) {
        this.f14006a = personInformationFragment;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        intent.getAction().equalsIgnoreCase("login");
    }
}
