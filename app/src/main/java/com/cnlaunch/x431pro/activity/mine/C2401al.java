package com.cnlaunch.x431pro.activity.mine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import com.ifoer.expedition.pro.R;

/* compiled from: MineFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.al */
/* loaded from: classes.dex */
final class C2401al extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ MineFragment f13671a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2401al(MineFragment mineFragment) {
        this.f13671a = mineFragment;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Button button;
        boolean z;
        boolean z2;
        Button button2;
        boolean z3;
        boolean z4;
        String action = intent.getAction();
        if (action.equalsIgnoreCase("login")) {
            button2 = this.f13671a.f13664m;
            button2.setText(R.string.logout_button);
            z3 = this.f13671a.f13666p;
            if (z3) {
                z4 = MineFragment.f13651n;
                if (z4) {
                }
            }
        } else if (action.equalsIgnoreCase("logout")) {
            button = this.f13671a.f13664m;
            button.setText(R.string.login_button);
            z = this.f13671a.f13666p;
            if (z) {
                z2 = MineFragment.f13651n;
                if (z2) {
                }
            }
        } else if (action.equalsIgnoreCase("refreshtip")) {
            MineFragment.m6458c(this.f13671a);
        }
    }
}
