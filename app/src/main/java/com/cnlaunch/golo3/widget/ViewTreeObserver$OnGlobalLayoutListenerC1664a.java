package com.cnlaunch.golo3.widget;

import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

/* compiled from: KJListView.java */
/* renamed from: com.cnlaunch.golo3.widget.a */
/* loaded from: classes.dex */
final class ViewTreeObserver$OnGlobalLayoutListenerC1664a implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ KJListView f8831a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTreeObserver$OnGlobalLayoutListenerC1664a(KJListView kJListView) {
        this.f8831a = kJListView;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        RelativeLayout relativeLayout;
        relativeLayout = this.f8831a.f8782e;
        int height = relativeLayout.getHeight();
        if (height > 0) {
            this.f8831a.f8786i = height;
        }
        this.f8831a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
}
