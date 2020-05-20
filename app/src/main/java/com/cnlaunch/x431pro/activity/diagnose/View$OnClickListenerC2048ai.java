package com.cnlaunch.x431pro.activity.diagnose;

import android.view.View;
import com.cnlaunch.physics.p199e.IPhysics;
import java.util.Timer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.ai */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2048ai implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f11496a;

    /* renamed from: b */
    final /* synthetic */ IPhysics f11497b;

    /* renamed from: c */
    final /* synthetic */ Timer f11498c;

    /* renamed from: d */
    final /* synthetic */ DiagnoseActivity f11499d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2048ai(DiagnoseActivity diagnoseActivity, int i, IPhysics iPhysics, Timer timer) {
        this.f11499d = diagnoseActivity;
        this.f11496a = i;
        this.f11497b = iPhysics;
        this.f11498c = timer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0006, code lost:
        if (r4 != 3) goto L11;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onClick(android.view.View r4) {
        /*
            r3 = this;
            int r4 = r3.f11496a
            r0 = 0
            r1 = 3
            if (r4 == 0) goto L9
            if (r4 == r1) goto L1d
            goto L32
        L9:
            com.cnlaunch.physics.e.c r4 = r3.f11497b
            boolean r2 = r4 instanceof com.cnlaunch.physics.p192a.BluetoothManager
            if (r2 == 0) goto L12
            com.cnlaunch.physics.a.b r4 = (com.cnlaunch.physics.p192a.BluetoothManager) r4
            goto L13
        L12:
            r4 = r0
        L13:
            if (r4 == 0) goto L1d
            com.cnlaunch.x431pro.activity.diagnose.aj r2 = new com.cnlaunch.x431pro.activity.diagnose.aj
            r2.<init>(r3, r4)
            r2.start()
        L1d:
            com.cnlaunch.physics.e.c r4 = r3.f11497b
            boolean r2 = r4 instanceof com.cnlaunch.physics.p204j.DPUUSBManager
            if (r2 == 0) goto L26
            r0 = r4
            com.cnlaunch.physics.j.b r0 = (com.cnlaunch.physics.p204j.DPUUSBManager) r0
        L26:
            if (r0 == 0) goto L32
            int r4 = r0.getState()
            if (r4 == r1) goto L32
            r4 = 0
            r0.m8234a(r4)
        L32:
            java.util.Timer r4 = r3.f11498c
            r4.cancel()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.diagnose.View$OnClickListenerC2048ai.onClick(android.view.View):void");
    }
}
