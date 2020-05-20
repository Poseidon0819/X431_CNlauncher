package com.cnlaunch.x431pro.activity.info;

import android.content.Context;
import android.view.View;
import com.cnlaunch.x431pro.p210a.LoginTools;

/* compiled from: RepairInfoActivityFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.info.ac */
/* loaded from: classes.dex */
final class View$OnClickListenerC2271ac implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentC2297z f12874a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2271ac(FragmentC2297z fragmentC2297z) {
        this.f12874a = fragmentC2297z;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        context = this.f12874a.mContext;
        if (LoginTools.m7945a(context, 2)) {
            this.f12874a.m6815a(true);
        }
    }
}
