package com.cnlaunch.x431pro.activity.mine;

import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog;

/* compiled from: PDFReportFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.bi */
/* loaded from: classes.dex */
final class C2438bi extends SelectMessageDialog {

    /* renamed from: a */
    final /* synthetic */ PDFReportFragment f13932a;

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: b */
    public final void mo4608b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2438bi(PDFReportFragment pDFReportFragment) {
        this.f13932a = pDFReportFragment;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: a */
    public final void mo4611a() {
        String str;
        str = this.f13932a.f13919g;
        FileUtils.m5000d(str);
        this.f13932a.getFragmentManager().popBackStack();
    }
}
