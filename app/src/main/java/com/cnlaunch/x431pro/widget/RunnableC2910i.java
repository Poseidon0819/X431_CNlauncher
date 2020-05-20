package com.cnlaunch.x431pro.widget;

import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DragGridView.java */
/* renamed from: com.cnlaunch.x431pro.widget.i */
/* loaded from: classes.dex */
public final class RunnableC2910i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ DragGridView f16583a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2910i(DragGridView dragGridView) {
        this.f16583a = dragGridView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Runnable runnable;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Handler handler2;
        Runnable runnable2;
        Handler handler3;
        Runnable runnable3;
        Handler handler4;
        Runnable runnable4;
        if (this.f16583a.getFirstVisiblePosition() == 0 || this.f16583a.getLastVisiblePosition() == this.f16583a.getCount() - 1) {
            handler = this.f16583a.f15969G;
            runnable = this.f16583a.f15971I;
            handler.removeCallbacks(runnable);
        }
        i = this.f16583a.f15977g;
        i2 = this.f16583a.f15991u;
        if (i > i2) {
            i5 = 20;
            handler4 = this.f16583a.f15969G;
            runnable4 = this.f16583a.f15971I;
            handler4.postDelayed(runnable4, 25L);
        } else {
            i3 = this.f16583a.f15977g;
            i4 = this.f16583a.f15990t;
            if (i3 < i4) {
                i5 = -20;
                handler3 = this.f16583a.f15969G;
                runnable3 = this.f16583a.f15971I;
                handler3.postDelayed(runnable3, 25L);
            } else {
                i5 = 0;
                handler2 = this.f16583a.f15969G;
                runnable2 = this.f16583a.f15971I;
                handler2.removeCallbacks(runnable2);
            }
        }
        this.f16583a.smoothScrollBy(i5, 10);
    }
}
