package com.cnlaunch.x431pro.activity.upgrade;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.login.LoginFunction;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import java.util.List;

/* compiled from: UpgradeFragmentForPro.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.bj */
/* loaded from: classes.dex */
final class C2657bj extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ UpgradeFragmentForPro f15243a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2657bj(UpgradeFragmentForPro upgradeFragmentForPro) {
        this.f15243a = upgradeFragmentForPro;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        List list;
        List list2;
        boolean z;
        Context context2;
        Handler handler;
        Handler handler2;
        boolean z2;
        String str;
        boolean z3;
        Context context3;
        Context context4;
        String action = intent.getAction();
        if (action.equalsIgnoreCase("login_change_serialno")) {
            this.f15243a.m5655l();
            list = this.f15243a.f15149L;
            if (list.size() == 0) {
                list2 = this.f15243a.f15149L;
                if (list2.size() == 0) {
                    if (this.f15243a.isVisible() && !LoginFunction.m6569f()) {
                        context2 = this.f15243a.mContext;
                        if (PreferencesManager.m9595a(context2).m9583b("iSGetSerialNumberFailed", false)) {
                            handler = this.f15243a.f15140C;
                            Message obtainMessage = handler.obtainMessage(7, 0, 0);
                            handler2 = this.f15243a.f15140C;
                            handler2.sendMessage(obtainMessage);
                        }
                    }
                    z = this.f15243a.f15185an;
                    if (z) {
                        this.f15243a.m5678b();
                        UpgradeFragmentForPro.m5654l(this.f15243a);
                        UpgradeFragmentForPro.m5652m(this.f15243a);
                        this.f15243a.m5667f();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.f15243a.isVisible()) {
                z3 = this.f15243a.f15185an;
                if (z3) {
                    context3 = this.f15243a.mContext;
                    context4 = this.f15243a.mContext;
                    LoadDialog.m4684a(context3, context4.getString(R.string.refresh_txt));
                }
            }
            z2 = this.f15243a.f15185an;
            if (z2) {
                this.f15243a.m5678b();
                this.f15243a.request(2101);
                str = this.f15243a.f15164a;
                NLog.m9456a(str, "BroadcastReceiver: REQ_QUERYLATESTPUBLICSOFTS_CODE");
            }
        } else if (action.equalsIgnoreCase("logout")) {
            UpgradeFragmentForPro.m5650o(this.f15243a);
            this.f15243a.m5678b();
            UpgradeFragmentForPro.m5654l(this.f15243a);
            UpgradeFragmentForPro.m5652m(this.f15243a);
            this.f15243a.m5667f();
        }
    }
}
