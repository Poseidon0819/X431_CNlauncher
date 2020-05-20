package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.widgets.ak */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4434ak implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4432aj f23364a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4434ak(C4432aj c4432aj) {
        this.f23364a = c4432aj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        popupWindow = this.f23364a.f23353p;
        if (popupWindow != null) {
            popupWindow2 = this.f23364a.f23353p;
            popupWindow2.dismiss();
        }
    }
}
