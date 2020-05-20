package com.cnlaunch.golo3.view.selectimg;

/* compiled from: ImageViewTouchBase.java */
/* renamed from: com.cnlaunch.golo3.view.selectimg.n */
/* loaded from: classes.dex */
final class RunnableC1654n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ float f8729a = 300.0f;

    /* renamed from: b */
    final /* synthetic */ long f8730b;

    /* renamed from: c */
    final /* synthetic */ float f8731c;

    /* renamed from: d */
    final /* synthetic */ float f8732d;

    /* renamed from: e */
    final /* synthetic */ float f8733e;

    /* renamed from: f */
    final /* synthetic */ float f8734f;

    /* renamed from: g */
    final /* synthetic */ ImageViewTouchBase f8735g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1654n(ImageViewTouchBase imageViewTouchBase, long j, float f, float f2, float f3, float f4) {
        this.f8735g = imageViewTouchBase;
        this.f8730b = j;
        this.f8731c = f;
        this.f8732d = f2;
        this.f8733e = f3;
        this.f8734f = f4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        float min = Math.min(this.f8729a, (float) (System.currentTimeMillis() - this.f8730b));
        this.f8735g.mo9021a(this.f8731c + (this.f8732d * min), this.f8733e, this.f8734f);
        if (min < this.f8729a) {
            this.f8735g.f8725m.post(this);
        }
    }
}
