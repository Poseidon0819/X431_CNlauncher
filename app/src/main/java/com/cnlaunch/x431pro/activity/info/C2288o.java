package com.cnlaunch.x431pro.activity.info;

import android.text.Editable;
import android.text.TextWatcher;
import com.cnlaunch.golo3.p165g.C1621v;

/* compiled from: PdfSearchFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.info.o */
/* loaded from: classes.dex */
final class C2288o implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ PdfSearchFragment f12930a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2288o(PdfSearchFragment pdfSearchFragment) {
        this.f12930a = pdfSearchFragment;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        if (C1621v.m9121a(editable.toString())) {
            this.f12930a.m6837a();
        }
    }
}
