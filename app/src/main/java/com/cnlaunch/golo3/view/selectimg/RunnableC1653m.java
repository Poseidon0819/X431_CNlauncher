package com.cnlaunch.golo3.view.selectimg;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageViewTouchBase.java */
/* renamed from: com.cnlaunch.golo3.view.selectimg.m */
/* loaded from: classes.dex */
public final class RunnableC1653m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RotateBitmap f8726a;

    /* renamed from: b */
    final /* synthetic */ boolean f8727b;

    /* renamed from: c */
    final /* synthetic */ ImageViewTouchBase f8728c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1653m(ImageViewTouchBase imageViewTouchBase, RotateBitmap rotateBitmap, boolean z) {
        this.f8728c = imageViewTouchBase;
        this.f8726a = rotateBitmap;
        this.f8727b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8728c.m9018a(this.f8726a, this.f8727b);
    }
}
