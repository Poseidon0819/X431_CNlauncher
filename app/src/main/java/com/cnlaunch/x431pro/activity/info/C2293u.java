package com.cnlaunch.x431pro.activity.info;

import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog;

/* compiled from: PdfViewFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.info.u */
/* loaded from: classes.dex */
final class C2293u extends SelectMessageDialog {

    /* renamed from: a */
    final /* synthetic */ PdfViewFragment f12952a;

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: b */
    public final void mo4608b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2293u(PdfViewFragment pdfViewFragment) {
        this.f12952a = pdfViewFragment;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: a */
    public final void mo4611a() {
        String str;
        str = this.f12952a.f12937e;
        FileUtils.m5000d(str);
        this.f12952a.getFragmentManager().popBackStack();
    }
}
