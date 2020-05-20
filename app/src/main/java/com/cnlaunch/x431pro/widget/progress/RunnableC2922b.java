package com.cnlaunch.x431pro.widget.progress;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Slider.java */
/* renamed from: com.cnlaunch.x431pro.widget.progress.b */
/* loaded from: classes.dex */
public final class RunnableC2922b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f16644a;

    /* renamed from: b */
    final /* synthetic */ Slider f16645b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2922b(Slider slider, int i) {
        this.f16645b = slider;
        this.f16644a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16645b.setValue(this.f16644a);
    }
}
