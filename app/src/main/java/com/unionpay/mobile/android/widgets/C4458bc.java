package com.unionpay.mobile.android.widgets;

import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import com.unionpay.mobile.android.global.C4149a;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.widgets.bc */
/* loaded from: classes2.dex */
public final class C4458bc implements PopupWindow.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ C4455bb f23425a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4458bc(C4455bb c4455bb) {
        this.f23425a = c4455bb;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ScrollView scrollView;
        ScrollView scrollView2;
        int i;
        ScrollView scrollView3;
        scrollView = this.f23425a.f23420g;
        if (scrollView != null) {
            scrollView2 = this.f23425a.f23420g;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) scrollView2.getLayoutParams();
            marginLayoutParams.bottomMargin = C4149a.f22113b;
            i = this.f23425a.f23421h;
            marginLayoutParams.height = i;
            scrollView3 = this.f23425a.f23420g;
            scrollView3.setLayoutParams(marginLayoutParams);
        }
    }
}
