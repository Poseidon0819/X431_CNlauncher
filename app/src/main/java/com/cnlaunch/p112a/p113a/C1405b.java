package com.cnlaunch.p112a.p113a;

import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractChart.java */
/* renamed from: com.cnlaunch.a.a.b */
/* loaded from: classes.dex */
public final class C1405b extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ AbstractChart f6719a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1405b(AbstractChart abstractChart) {
        this.f6719a = abstractChart;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.f6719a.mCurrentCount++;
    }
}
