package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.widget.PopupWindow;
import com.unionpay.mobile.android.nocard.views.C4245o;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.nocard.views.ac */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4194ac implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4245o.C4247b f22527a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4194ac(C4245o.C4247b c4247b) {
        this.f22527a = c4247b;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        popupWindow = this.f22527a.f22698b;
        if (popupWindow != null) {
            popupWindow2 = this.f22527a.f22698b;
            popupWindow2.dismiss();
        }
    }
}
