package com.cnlaunch.x431pro.activity.info;

import android.view.View;
import com.artifex.mupdflib.MuPDFView;
import com.artifex.mupdflib.ReaderView;

/* compiled from: PdfViewFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.info.v */
/* loaded from: classes.dex */
final class C2294v extends ReaderView.ViewMapper {

    /* renamed from: a */
    final /* synthetic */ PdfViewFragment f12953a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2294v(PdfViewFragment pdfViewFragment) {
        this.f12953a = pdfViewFragment;
    }

    @Override // com.artifex.mupdflib.ReaderView.ViewMapper
    public final void applyToView(View view) {
        ((MuPDFView) view).releaseBitmaps();
    }
}
