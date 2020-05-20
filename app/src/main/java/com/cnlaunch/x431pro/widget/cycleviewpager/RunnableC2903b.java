package com.cnlaunch.x431pro.widget.cycleviewpager;

/* compiled from: CycleViewPager.java */
/* renamed from: com.cnlaunch.x431pro.widget.cycleviewpager.b */
/* loaded from: classes.dex */
final class RunnableC2903b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CycleViewPager f16573a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2903b(CycleViewPager cycleViewPager) {
        this.f16573a = cycleViewPager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        long j;
        int i;
        CycleViewPagerHandler cycleViewPagerHandler;
        int i2;
        CycleViewPagerHandler cycleViewPagerHandler2;
        int i3;
        if (this.f16573a.getActivity() == null || this.f16573a.getActivity().isFinishing()) {
            return;
        }
        z = this.f16573a.f16564n;
        if (z) {
            long currentTimeMillis = System.currentTimeMillis();
            j = this.f16573a.f16565o;
            long j2 = currentTimeMillis - j;
            i = this.f16573a.f16551a;
            if (j2 > i - 500) {
                cycleViewPagerHandler2 = this.f16573a.f16561k;
                i3 = this.f16573a.f16566p;
                cycleViewPagerHandler2.sendEmptyMessage(i3);
                return;
            }
            cycleViewPagerHandler = this.f16573a.f16561k;
            i2 = this.f16573a.f16567q;
            cycleViewPagerHandler.sendEmptyMessage(i2);
        }
    }
}
