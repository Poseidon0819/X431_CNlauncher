package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.view.View;
import com.cnlaunch.x431pro.activity.diagnose.p218a.SpeciaFunctionListViewAdapter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpeciaFunctionFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.bu */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2152bu implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpeciaFunctionFragment f12223a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2152bu(SpeciaFunctionFragment speciaFunctionFragment) {
        this.f12223a = speciaFunctionFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SpeciaFunctionListViewAdapter speciaFunctionListViewAdapter;
        SpeciaFunctionListViewAdapter speciaFunctionListViewAdapter2;
        speciaFunctionListViewAdapter = this.f12223a.f12210n;
        if (speciaFunctionListViewAdapter != null) {
            speciaFunctionListViewAdapter2 = this.f12223a.f12210n;
            speciaFunctionListViewAdapter2.m7481a(true);
        }
    }
}
