package com.cnlaunch.x431pro.activity.info;

import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog;

/* compiled from: PdfSearchFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.info.p */
/* loaded from: classes.dex */
final class C2289p extends SelectMessageDialog {

    /* renamed from: a */
    final /* synthetic */ PdfSearchFragment f12931a;

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: b */
    public final void mo4608b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2289p(PdfSearchFragment pdfSearchFragment) {
        this.f12931a = pdfSearchFragment;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: a */
    public final void mo4611a() {
        String str;
        str = this.f12931a.f12914e;
        FileUtils.m5000d(str);
        this.f12931a.getFragmentManager().popBackStack();
    }
}
