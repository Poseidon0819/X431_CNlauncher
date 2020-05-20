package com.unionpay.mobile.android.views.order;

import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.views.order.d */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4406d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4402b f23259a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4406d(C4402b c4402b) {
        this.f23259a = c4402b;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        popupWindow = this.f23259a.f23241m;
        if (popupWindow != null) {
            popupWindow2 = this.f23259a.f23241m;
            popupWindow2.dismiss();
        }
    }
}
