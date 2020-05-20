package com.cnlaunch.x431pro.activity.info;

import android.content.Context;
import com.baidu.mapapi.UIMsg;
import com.cnlaunch.diagnosemodule.wiget.LoadDialog;
import com.cnlaunch.x431pro.activity.pay.p232a.TrialDialog;
import com.ifoer.expedition.pro.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RepairInfoActivityFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.info.ae */
/* loaded from: classes.dex */
public final class DialogC2273ae extends TrialDialog {

    /* renamed from: a */
    final /* synthetic */ String f12877a;

    /* renamed from: b */
    final /* synthetic */ String f12878b;

    /* renamed from: c */
    final /* synthetic */ FragmentC2297z f12879c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2273ae(FragmentC2297z fragmentC2297z, Context context, String str, String str2, String str3) {
        super(context, str);
        this.f12879c = fragmentC2297z;
        this.f12877a = str2;
        this.f12878b = str3;
    }

    @Override // com.cnlaunch.x431pro.activity.pay.p232a.TrialDialog
    /* renamed from: b */
    public final void mo6057b() {
        this.f12879c.m6817a(this.f12877a, this.f12878b);
    }

    @Override // com.cnlaunch.x431pro.activity.pay.p232a.TrialDialog
    /* renamed from: c */
    public final void mo6056c() {
        Context context;
        context = this.f12879c.mContext;
        LoadDialog.show(context, this.f12879c.getString(R.string.pull_to_refresh_refreshing_label));
        this.f12879c.request(UIMsg.f_FUN.FUN_ID_SCH_NAV, true);
    }
}
