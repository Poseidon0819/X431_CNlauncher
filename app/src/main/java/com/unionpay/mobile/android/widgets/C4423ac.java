package com.unionpay.mobile.android.widgets;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.unionpay.mobile.android.widgets.AbstractC4420aa;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.widgets.ac */
/* loaded from: classes2.dex */
public final class C4423ac implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ AbstractC4420aa f23326a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4423ac(AbstractC4420aa abstractC4420aa) {
        this.f23326a = abstractC4420aa;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.f23326a.mo656a(editable);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f23326a.f23323b.hasFocus() && TextUtils.isEmpty(this.f23326a.f23323b.m600b())) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f23326a.m669s());
            sb.append(this.f23326a.mo613d());
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        AbstractC4420aa.InterfaceC4421a interfaceC4421a;
        AbstractC4420aa.InterfaceC4421a interfaceC4421a2;
        interfaceC4421a = this.f23326a.f23324c;
        if (interfaceC4421a != null) {
            interfaceC4421a2 = this.f23326a.f23324c;
            interfaceC4421a2.mo719a(this.f23326a.f23323b, charSequence.toString());
        }
    }
}
