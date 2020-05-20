package com.cnlaunch.x431pro.activity.p211a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;

/* compiled from: HistoryFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.a.j */
/* loaded from: classes.dex */
final class C1984j extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ HistoryFragment f10879a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1984j(HistoryFragment historyFragment) {
        this.f10879a = historyFragment;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        boolean z;
        Context context2;
        TextView textView;
        String str;
        String str2;
        String action = intent.getAction();
        if (action.equals("softs_updated")) {
            context2 = this.f10879a.mContext;
            String m9591a = PreferencesManager.m9595a(context2).m9591a("serialNo");
            if (!TextUtils.isEmpty(m9591a)) {
                str2 = this.f10879a.f10845F;
                if (m9591a.equalsIgnoreCase(str2)) {
                    return;
                }
            }
            this.f10879a.f10845F = m9591a;
            textView = this.f10879a.f10858m;
            str = this.f10879a.f10845F;
            textView.setText(str);
            this.f10879a.m7824i();
        } else if (action.equals("login_change_serialno")) {
            this.f10879a.m7826h();
            z = this.f10879a.f10850K;
            if (z) {
                this.f10879a.m7824i();
            }
        }
    }
}
