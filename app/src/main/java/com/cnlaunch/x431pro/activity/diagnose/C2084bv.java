package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Intent;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog;

/* compiled from: ReportShowFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.bv */
/* loaded from: classes.dex */
final class C2084bv extends SelectMessageDialog {

    /* renamed from: a */
    final /* synthetic */ ReportShowFragment f11668a;

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: b */
    public final void mo4608b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2084bv(ReportShowFragment reportShowFragment) {
        this.f11668a = reportShowFragment;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: a */
    public final void mo4611a() {
        String str;
        str = this.f11668a.f11635al;
        FileUtils.m5000d(str);
        this.f11668a.getFragmentManager().popBackStack();
        this.f11668a.getActivity().sendBroadcast(new Intent("clos_report_show"));
    }
}
