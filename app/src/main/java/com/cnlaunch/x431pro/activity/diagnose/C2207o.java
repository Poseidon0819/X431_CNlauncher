package com.cnlaunch.x431pro.activity.diagnose;

import android.os.Handler;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.golo.others.GoloTextWatcher;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CarIconFragmentForAll.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.o */
/* loaded from: classes.dex */
public final class C2207o extends GoloTextWatcher {

    /* renamed from: a */
    final /* synthetic */ CarIconFragmentForAll f12481a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2207o(CarIconFragmentForAll carIconFragmentForAll) {
        this.f12481a = carIconFragmentForAll;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        Handler handler;
        Runnable runnable;
        NLog.m9456a("yhx", "onTextChanged enter.");
        z = this.f12481a.f11184aM;
        if (z) {
            return;
        }
        this.f12481a.f11184aM = true;
        handler = this.f12481a.f11178aG;
        runnable = this.f12481a.f11188aQ;
        handler.postDelayed(runnable, 1000L);
    }
}
