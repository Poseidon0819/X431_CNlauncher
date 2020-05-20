package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.widgets.i */
/* loaded from: classes2.dex */
public final class C4467i implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ C4465g f23452a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4467i(C4465g c4465g) {
        this.f23452a = c4465g;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f23452a.m669s());
        sb.append("_select_certtype");
        this.f23452a.m650a(i);
        popupWindow = this.f23452a.f23446r;
        if (popupWindow != null) {
            popupWindow2 = this.f23452a.f23446r;
            popupWindow2.dismiss();
        }
    }
}
