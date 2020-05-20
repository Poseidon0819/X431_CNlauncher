package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.widget.ListView;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.p210a.LoginTools;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase;
import com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshListView;
import com.ifoer.expedition.pro.R;

/* compiled from: ReportPagersFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.cq */
/* loaded from: classes.dex */
final class C2466cq implements PullToRefreshBase.InterfaceC2936e<ListView> {

    /* renamed from: a */
    final /* synthetic */ ReportPagersFragment f14109a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2466cq(ReportPagersFragment reportPagersFragment) {
        this.f14109a = reportPagersFragment;
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase.InterfaceC2936e
    /* renamed from: f_ */
    public final void mo4423f_() {
        Context context;
        Context context2;
        Context context3;
        PullToRefreshListView pullToRefreshListView;
        Context context4;
        PullToRefreshListView pullToRefreshListView2;
        context = this.f14109a.mContext;
        if (!LoginTools.m7946a(context)) {
            context4 = this.f14109a.mContext;
            NToast.m9450a(context4, (int) R.string.login_tip);
            pullToRefreshListView2 = this.f14109a.f14100x;
            pullToRefreshListView2.m4428i();
            return;
        }
        context2 = this.f14109a.mContext;
        if (!C2778n.m4917a(context2)) {
            context3 = this.f14109a.mContext;
            NToast.m9450a(context3, (int) R.string.common_network_unavailable);
            pullToRefreshListView = this.f14109a.f14100x;
            pullToRefreshListView.m4428i();
            return;
        }
        this.f14109a.request(30001);
    }
}
