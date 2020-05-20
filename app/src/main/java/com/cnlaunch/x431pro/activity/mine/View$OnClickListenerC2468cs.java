package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.view.View;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.p210a.LoginTools;
import com.cnlaunch.x431pro.utils.C2778n;
import com.ifoer.expedition.pro.R;

/* compiled from: ReportPagersFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.cs */
/* loaded from: classes.dex */
final class View$OnClickListenerC2468cs implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ReportPagersFragment f14111a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2468cs(ReportPagersFragment reportPagersFragment) {
        this.f14111a = reportPagersFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        context = this.f14111a.mContext;
        if (!LoginTools.m7946a(context)) {
            context4 = this.f14111a.mContext;
            NToast.m9450a(context4, (int) R.string.login_tip);
            return;
        }
        context2 = this.f14111a.mContext;
        if (!C2778n.m4917a(context2)) {
            context3 = this.f14111a.mContext;
            NToast.m9450a(context3, (int) R.string.common_network_unavailable);
            return;
        }
        ReportPagersFragment.m6201r(this.f14111a);
        this.f14111a.request(30001);
    }
}
