package com.unionpay.mobile.android.upwidget;

import android.view.View;
import android.widget.TextView;
import com.unionpay.mobile.android.widgets.C4424ad;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.upwidget.n */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4368n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4363j f23140a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4368n(C4363j c4363j) {
        this.f23140a = c4363j;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        TextView textView;
        TextView textView2;
        C4424ad c4424ad;
        textView = this.f23140a.f23118m;
        textView.setEnabled(false);
        textView2 = this.f23140a.f23117l;
        textView2.setVisibility(8);
        c4424ad = this.f23140a.f23116k;
        c4424ad.setVisibility(0);
    }
}
