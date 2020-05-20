package com.cnlaunch.x431pro.activity.info;

import android.content.Context;
import com.artifex.mupdflib.MuPDFCore;
import com.artifex.mupdflib.MuPDFReaderView;
import com.artifex.mupdflib.SearchTask;
import com.artifex.mupdflib.SearchTaskResult;

/* compiled from: PdfSearchFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.info.n */
/* loaded from: classes.dex */
final class C2287n extends SearchTask {

    /* renamed from: a */
    final /* synthetic */ PdfSearchFragment f12929a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2287n(PdfSearchFragment pdfSearchFragment, Context context, MuPDFCore muPDFCore, MuPDFReaderView muPDFReaderView) {
        super(context, muPDFCore, muPDFReaderView);
        this.f12929a = pdfSearchFragment;
    }

    @Override // com.artifex.mupdflib.SearchTask
    public final void onTextFound(SearchTaskResult searchTaskResult) {
        MuPDFReaderView muPDFReaderView;
        MuPDFReaderView muPDFReaderView2;
        MuPDFReaderView muPDFReaderView3;
        SearchTaskResult.set(searchTaskResult);
        muPDFReaderView = this.f12929a.f12912c;
        if (muPDFReaderView == null || !this.f12929a.isAdded()) {
            return;
        }
        muPDFReaderView2 = this.f12929a.f12912c;
        muPDFReaderView2.setDisplayedViewIndex(searchTaskResult.pageNumber);
        muPDFReaderView3 = this.f12929a.f12912c;
        muPDFReaderView3.resetupChildren();
    }
}
