package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.widgets.b */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4452b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4419a f23393a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4452b(C4419a c4419a) {
        this.f23393a = c4419a;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        popupWindow = this.f23393a.f23317r;
        if (popupWindow != null) {
            popupWindow2 = this.f23393a.f23317r;
            popupWindow2.dismiss();
        }
    }
}
