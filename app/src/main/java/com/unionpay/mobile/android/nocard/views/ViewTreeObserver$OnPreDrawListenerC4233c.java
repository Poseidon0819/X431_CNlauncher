package com.unionpay.mobile.android.nocard.views;

import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.nocard.views.c */
/* loaded from: classes2.dex */
public final class ViewTreeObserver$OnPreDrawListenerC4233c implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a */
    final /* synthetic */ AbstractC4219b f22636a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTreeObserver$OnPreDrawListenerC4233c(AbstractC4219b abstractC4219b) {
        this.f22636a = abstractC4219b;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        linearLayout = this.f22636a.f22607r;
        linearLayout.getViewTreeObserver().removeOnPreDrawListener(this);
        AbstractC4219b abstractC4219b = this.f22636a;
        linearLayout2 = abstractC4219b.f22607r;
        abstractC4219b.f22610u = linearLayout2.getMeasuredHeight();
        AbstractC4219b abstractC4219b2 = this.f22636a;
        linearLayout3 = abstractC4219b2.f22607r;
        abstractC4219b2.f22611v = linearLayout3.getTop();
        return true;
    }
}
