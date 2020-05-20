package com.cnlaunch.x431pro.activity.info;

import android.content.Context;
import android.view.View;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.p210a.LoginTools;

/* compiled from: RepairInfoActivityFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.info.ab */
/* loaded from: classes.dex */
final class View$OnClickListenerC2270ab implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentC2297z f12873a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2270ab(FragmentC2297z fragmentC2297z) {
        this.f12873a = fragmentC2297z;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        Context context2;
        Context context3;
        context = this.f12873a.mContext;
        if (LoginTools.m7945a(context, 2)) {
            context2 = this.f12873a.mContext;
            if (!PreferencesManager.m9595a(context2).m9584b("show_cy_infomation_tips", "1").equals("1")) {
                this.f12873a.m6815a(false);
                return;
            }
            FragmentC2297z fragmentC2297z = this.f12873a;
            context3 = fragmentC2297z.mContext;
            FragmentC2297z.m6821a(fragmentC2297z, context3);
        }
    }
}
