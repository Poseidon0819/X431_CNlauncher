package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.widgets.q */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4475q implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4474p f23494a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4475q(C4474p c4474p) {
        this.f23494a = c4474p;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        popupWindow = this.f23494a.f23484q;
        if (popupWindow != null) {
            popupWindow2 = this.f23494a.f23484q;
            popupWindow2.dismiss();
        }
    }
}
