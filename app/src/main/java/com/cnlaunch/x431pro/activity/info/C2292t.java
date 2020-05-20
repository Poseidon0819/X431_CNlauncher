package com.cnlaunch.x431pro.activity.info;

import android.content.Context;
import android.widget.TextView;
import com.artifex.mupdflib.MuPDFCore;
import com.artifex.mupdflib.MuPDFReaderView;

/* compiled from: PdfViewFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.info.t */
/* loaded from: classes.dex */
final class C2292t extends MuPDFReaderView {

    /* renamed from: a */
    final /* synthetic */ PdfViewFragment f12951a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2292t(PdfViewFragment pdfViewFragment, Context context, MuPDFCore.Callback callback) {
        super(context, callback);
        this.f12951a = pdfViewFragment;
    }

    @Override // com.artifex.mupdflib.MuPDFReaderView, com.artifex.mupdflib.ReaderView
    public final void onMoveToChild(int i) {
        MuPDFCore muPDFCore;
        TextView textView;
        muPDFCore = this.f12951a.f12934b;
        if (muPDFCore == null) {
            return;
        }
        textView = this.f12951a.f12939g;
        StringBuilder sb = new StringBuilder();
        int i2 = i + 1;
        sb.append(i2);
        sb.append("/");
        textView.setText(sb.toString());
        this.f12951a.f12942j = i2;
        super.onMoveToChild(i);
    }
}
