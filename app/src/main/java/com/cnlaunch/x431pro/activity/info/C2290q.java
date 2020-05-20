package com.cnlaunch.x431pro.activity.info;

import android.view.View;
import com.artifex.mupdflib.MuPDFView;
import com.artifex.mupdflib.ReaderView;

/* compiled from: PdfSearchFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.info.q */
/* loaded from: classes.dex */
final class C2290q extends ReaderView.ViewMapper {

    /* renamed from: a */
    final /* synthetic */ PdfSearchFragment f12932a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2290q(PdfSearchFragment pdfSearchFragment) {
        this.f12932a = pdfSearchFragment;
    }

    @Override // com.artifex.mupdflib.ReaderView.ViewMapper
    public final void applyToView(View view) {
        ((MuPDFView) view).releaseBitmaps();
    }
}
