package com.cnlaunch.x431pro.activity.info;

import android.view.View;

/* renamed from: com.cnlaunch.x431pro.activity.info.aa */
/* loaded from: classes.dex */
final class RepairInfoActivityFragment implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentC2297z f12872a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RepairInfoActivityFragment(FragmentC2297z fragmentC2297z) {
        this.f12872a = fragmentC2297z;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f12872a.replaceFragment(InfoFragment.class.getName(), 1);
    }
}
