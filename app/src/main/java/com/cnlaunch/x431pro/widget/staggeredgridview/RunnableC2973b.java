package com.cnlaunch.x431pro.widget.staggeredgridview;

import android.view.View;
import com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView;

/* compiled from: ExtendableListView.java */
/* renamed from: com.cnlaunch.x431pro.widget.staggeredgridview.b */
/* loaded from: classes.dex */
final class RunnableC2973b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ View f16908a;

    /* renamed from: b */
    final /* synthetic */ ExtendableListView.RunnableC2968g f16909b;

    /* renamed from: c */
    final /* synthetic */ ExtendableListView f16910c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2973b(ExtendableListView extendableListView, View view, ExtendableListView.RunnableC2968g runnableC2968g) {
        this.f16910c = extendableListView;
        this.f16908a = view;
        this.f16909b = runnableC2968g;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16908a.setPressed(false);
        this.f16910c.setPressed(false);
        if (!this.f16910c.f16854z) {
            this.f16910c.post(this.f16909b);
        }
        this.f16910c.f16839k = 0;
    }
}
