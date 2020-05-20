package com.cnlaunch.x431pro.activity.info;

import android.os.Handler;
import android.os.Message;
import com.artifex.mupdflib.MuPDFReaderView;

/* compiled from: PdfViewFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.info.s */
/* loaded from: classes.dex */
final class HandlerC2291s extends Handler {

    /* renamed from: a */
    final /* synthetic */ PdfViewFragment f12950a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2291s(PdfViewFragment pdfViewFragment) {
        this.f12950a = pdfViewFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        MuPDFReaderView muPDFReaderView;
        MuPDFReaderView muPDFReaderView2;
        if (message2.what != 40994) {
            return;
        }
        muPDFReaderView = this.f12950a.f12935c;
        if (muPDFReaderView != null) {
            muPDFReaderView2 = this.f12950a.f12935c;
            muPDFReaderView2.postSettle();
        }
    }
}
