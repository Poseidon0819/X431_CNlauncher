package com.cnlaunch.x431pro.widget.switchbutton;

/* compiled from: SwitchButton.java */
/* renamed from: com.cnlaunch.x431pro.widget.switchbutton.b */
/* loaded from: classes.dex */
final class RunnableC2980b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ boolean f16957a;

    /* renamed from: b */
    final /* synthetic */ SwitchButton f16958b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2980b(SwitchButton switchButton, boolean z) {
        this.f16958b = switchButton;
        this.f16957a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16958b.setChecked(this.f16957a);
    }
}
