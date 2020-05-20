package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.view.ViewTreeObserver;
import com.unionpay.mobile.android.utils.C4390k;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.widgets.aw */
/* loaded from: classes2.dex */
public final class ViewTreeObserver$OnGlobalLayoutListenerC4447aw implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ UPWidget f23379a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTreeObserver$OnGlobalLayoutListenerC4447aw(UPWidget uPWidget) {
        this.f23379a = uPWidget;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        View m729x;
        View m729x2;
        int i;
        int i2;
        C4390k.m838a("uppay", "onGlobalLayout() +++");
        m729x = this.f23379a.m729x();
        int height = m729x.getRootView().getHeight();
        m729x2 = this.f23379a.m729x();
        int height2 = height - m729x2.getHeight();
        i = UPWidget.f23300o;
        if (height2 <= i) {
            i2 = UPWidget.f23300o;
            if (height2 <= i2) {
                this.f23379a.m732l();
            }
        }
        C4390k.m838a("uppay", "onGlobalLayout() ---");
    }
}
