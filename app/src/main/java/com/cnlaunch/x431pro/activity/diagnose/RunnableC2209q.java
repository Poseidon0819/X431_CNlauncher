package com.cnlaunch.x431pro.activity.diagnose;

import com.cnlaunch.x431pro.widget.ClearEditText;

/* compiled from: CarIconFragmentForAll.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.q */
/* loaded from: classes.dex */
final class RunnableC2209q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CarIconFragmentForAll f12483a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2209q(CarIconFragmentForAll carIconFragmentForAll) {
        this.f12483a = carIconFragmentForAll;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ClearEditText clearEditText;
        CarIconFragmentForAll carIconFragmentForAll = this.f12483a;
        clearEditText = carIconFragmentForAll.searchInputCars;
        carIconFragmentForAll.m7557c(clearEditText.getText().toString());
        this.f12483a.f11184aM = false;
    }
}
