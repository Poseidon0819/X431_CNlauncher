package com.cnlaunch.x431pro.activity.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: SettingFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.bh */
/* loaded from: classes.dex */
final class C2551bh extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ SettingFragment f14684a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2551bh(SettingFragment settingFragment) {
        this.f14684a = settingFragment;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equalsIgnoreCase("replace_printSetFragmet")) {
            this.f14684a.replaceFragment(WifiPrintSettingFragment.class.getName(), 1);
        }
    }
}
