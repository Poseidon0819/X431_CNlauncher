package com.cnlaunch.x431pro.activity.diagnose;

import android.widget.PopupWindow;
import android.widget.RadioButton;

/* compiled from: CarIconFragmentForAll.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.k */
/* loaded from: classes.dex */
final class RunnableC2203k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CarIconFragmentForAll f12477a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2203k(CarIconFragmentForAll carIconFragmentForAll) {
        this.f12477a = carIconFragmentForAll;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        int i;
        PopupWindow popupWindow;
        RadioButton radioButton;
        RadioButton radioButton2;
        RadioButton radioButton3;
        z = this.f12477a.f11177aF;
        if (z) {
            CarIconFragmentForAll carIconFragmentForAll = this.f12477a;
            i = carIconFragmentForAll.f11175aD;
            carIconFragmentForAll.m7555d(i);
            popupWindow = this.f12477a.f11176aE;
            radioButton = this.f12477a.f11198ai;
            radioButton2 = this.f12477a.f11198ai;
            radioButton3 = this.f12477a.f11198ai;
            popupWindow.showAsDropDown(radioButton, radioButton2.getWidth() - 15, -radioButton3.getHeight());
        }
    }
}
