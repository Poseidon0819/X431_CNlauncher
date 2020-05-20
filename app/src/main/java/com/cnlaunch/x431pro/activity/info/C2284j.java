package com.cnlaunch.x431pro.activity.info;

import android.text.Editable;
import android.text.TextWatcher;
import com.cnlaunch.golo3.p165g.C1621v;

/* compiled from: PdfSearchActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.info.j */
/* loaded from: classes.dex */
final class C2284j implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ PdfSearchActivity f12909a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2284j(PdfSearchActivity pdfSearchActivity) {
        this.f12909a = pdfSearchActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        PdfSearchFragment pdfSearchFragment;
        if (C1621v.m9121a(editable.toString())) {
            pdfSearchFragment = this.f12909a.f12864C;
            pdfSearchFragment.m6837a();
        }
    }
}
