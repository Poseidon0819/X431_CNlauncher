package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.widgets.h */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4466h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4465g f23451a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4466h(C4465g c4465g) {
        this.f23451a = c4465g;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        popupWindow = this.f23451a.f23446r;
        if (popupWindow != null) {
            popupWindow2 = this.f23451a.f23446r;
            popupWindow2.dismiss();
        }
    }
}
