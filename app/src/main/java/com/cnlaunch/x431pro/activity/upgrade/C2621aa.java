package com.cnlaunch.x431pro.activity.upgrade;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: UpgradeDetailActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.aa */
/* loaded from: classes.dex */
final class C2621aa extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ UpgradeDetailActivity f15064a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2621aa(UpgradeDetailActivity upgradeDetailActivity) {
        this.f15064a = upgradeDetailActivity;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        char c;
        new StringBuilder("UpgradeNoticeDialog---onReceive---").append(intent.getAction());
        String action = intent.getAction();
        int hashCode = action.hashCode();
        if (hashCode != -1888297704) {
            if (hashCode == 1561194197 && action.equals("BROADCAST_ACTION_UPGRADE_SUCCESSFULLY")) {
                c = 0;
            }
            c = 65535;
        } else {
            if (action.equals("BROADCAST_ACTION_PIN_CARD_PAY_SUCCESSFULLY")) {
                c = 1;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
                UpgradeDetailActivity.m5817a(this.f15064a, intent.getStringExtra("BROADCAST_KEY_ID"), intent.getStringExtra("BROADCAST_KEY_NAME"));
                return;
            case 1:
                this.f15064a.finish();
                return;
            default:
                return;
        }
    }
}
