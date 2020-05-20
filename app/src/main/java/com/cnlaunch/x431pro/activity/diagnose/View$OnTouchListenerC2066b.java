package com.cnlaunch.x431pro.activity.diagnose;

import android.view.MotionEvent;
import android.view.View;
import com.cnlaunch.p120d.p130d.NLog;

/* compiled from: CarIconFragmentForAll.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.b */
/* loaded from: classes.dex */
final class View$OnTouchListenerC2066b implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ CarIconFragmentForAll f11520a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnTouchListenerC2066b(CarIconFragmentForAll carIconFragmentForAll) {
        this.f11520a = carIconFragmentForAll;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        String str;
        str = CarIconFragmentForAll.f11144b;
        NLog.m9456a(str, "ontouch enter.");
        return true;
    }
}
