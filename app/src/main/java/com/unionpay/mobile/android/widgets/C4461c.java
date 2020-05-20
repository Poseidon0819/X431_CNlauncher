package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.widgets.c */
/* loaded from: classes2.dex */
public final class C4461c implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ C4419a f23436a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4461c(C4419a c4419a) {
        this.f23436a = c4419a;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f23436a.m669s());
        sb.append("_select_areacode");
        C4419a.m727a(this.f23436a, i);
        popupWindow = this.f23436a.f23317r;
        if (popupWindow != null) {
            popupWindow2 = this.f23436a.f23317r;
            popupWindow2.dismiss();
        }
    }
}
