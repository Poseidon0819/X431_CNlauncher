package com.cnlaunch.x431pro.activity.mine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.cnlaunch.p120d.p121a.PreferencesManager;

/* compiled from: ModifyPasswordFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.ao */
/* loaded from: classes.dex */
final class C2403ao extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ModifyPasswordFragment f13688a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2403ao(ModifyPasswordFragment modifyPasswordFragment) {
        this.f13688a = modifyPasswordFragment;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        PreferencesManager preferencesManager;
        String action = intent.getAction();
        if (action.equalsIgnoreCase("login")) {
            this.f13688a.m6451a(true);
        } else if (action.equalsIgnoreCase("logout")) {
            this.f13688a.m6451a(false);
        }
        ModifyPasswordFragment modifyPasswordFragment = this.f13688a;
        preferencesManager = modifyPasswordFragment.f13685l;
        modifyPasswordFragment.f13686m = preferencesManager.m9584b("login_state", "0");
    }
}
