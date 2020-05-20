package com.cnlaunch.x431pro.widget;

import android.graphics.Bitmap;
import android.os.Vibrator;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DragGridView.java */
/* renamed from: com.cnlaunch.x431pro.widget.h */
/* loaded from: classes.dex */
public final class RunnableC2909h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ DragGridView f16582a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2909h(DragGridView dragGridView) {
        this.f16582a = dragGridView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Vibrator vibrator;
        View view;
        Bitmap bitmap;
        int i;
        int i2;
        DragGridView.m4795a(this.f16582a);
        vibrator = this.f16582a.f15981k;
        vibrator.vibrate(50L);
        view = this.f16582a.f15979i;
        view.setVisibility(4);
        DragGridView dragGridView = this.f16582a;
        bitmap = dragGridView.f15984n;
        i = this.f16582a.f15974d;
        i2 = this.f16582a.f15975e;
        dragGridView.m4796a(bitmap, i, i2);
    }
}
