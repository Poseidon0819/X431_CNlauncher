package com.cnlaunch.x431pro.activity.info;

import android.content.Context;
import android.widget.TextView;
import com.artifex.mupdflib.MuPDFCore;
import com.artifex.mupdflib.MuPDFReaderView;

/* compiled from: PdfSearchFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.info.m */
/* loaded from: classes.dex */
final class C2286m extends MuPDFReaderView {

    /* renamed from: a */
    final /* synthetic */ PdfSearchFragment f12928a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2286m(PdfSearchFragment pdfSearchFragment, Context context, MuPDFCore.Callback callback) {
        super(context, callback);
        this.f12928a = pdfSearchFragment;
    }

    @Override // com.artifex.mupdflib.MuPDFReaderView, com.artifex.mupdflib.ReaderView
    public final void onMoveToChild(int i) {
        MuPDFCore muPDFCore;
        TextView textView;
        muPDFCore = this.f12928a.f12911b;
        if (muPDFCore == null) {
            return;
        }
        textView = this.f12928a.f12916g;
        StringBuilder sb = new StringBuilder();
        int i2 = i + 1;
        sb.append(i2);
        sb.append("/");
        textView.setText(sb.toString());
        this.f12928a.f12919j = i2;
        super.onMoveToChild(i);
    }
}
