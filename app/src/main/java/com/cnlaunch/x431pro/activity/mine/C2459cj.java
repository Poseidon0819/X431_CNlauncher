package com.cnlaunch.x431pro.activity.mine;

import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog;

/* compiled from: ReadReportFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.cj */
/* loaded from: classes.dex */
final class C2459cj extends SelectMessageDialog {

    /* renamed from: a */
    final /* synthetic */ ReadReportFragment f14063a;

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: b */
    public final void mo4608b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2459cj(ReadReportFragment readReportFragment) {
        this.f14063a = readReportFragment;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: a */
    public final void mo4611a() {
        String str;
        str = this.f14063a.f14055g;
        FileUtils.m5000d(str);
        this.f14063a.getFragmentManager().popBackStack();
    }
}
