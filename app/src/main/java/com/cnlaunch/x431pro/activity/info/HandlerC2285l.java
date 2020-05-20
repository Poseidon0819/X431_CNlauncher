package com.cnlaunch.x431pro.activity.info;

import android.os.Handler;
import android.os.Message;
import com.artifex.mupdflib.MuPDFReaderView;

/* compiled from: PdfSearchFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.info.l */
/* loaded from: classes.dex */
final class HandlerC2285l extends Handler {

    /* renamed from: a */
    final /* synthetic */ PdfSearchFragment f12927a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2285l(PdfSearchFragment pdfSearchFragment) {
        this.f12927a = pdfSearchFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        MuPDFReaderView muPDFReaderView;
        MuPDFReaderView muPDFReaderView2;
        if (message2.what != 40994) {
            return;
        }
        muPDFReaderView = this.f12927a.f12912c;
        if (muPDFReaderView != null) {
            muPDFReaderView2 = this.f12927a.f12912c;
            muPDFReaderView2.postSettle();
        }
    }
}
