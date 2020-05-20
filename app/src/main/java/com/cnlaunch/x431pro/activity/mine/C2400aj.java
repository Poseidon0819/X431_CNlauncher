package com.cnlaunch.x431pro.activity.mine;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FirmwareFixFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.aj */
/* loaded from: classes.dex */
public final class C2400aj extends Thread {

    /* renamed from: a */
    final /* synthetic */ FirmwareFixFragment f13650a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2400aj(FirmwareFixFragment firmwareFixFragment) {
        this.f13650a = firmwareFixFragment;
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0006 */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r3 = this;
        L0:
            com.cnlaunch.x431pro.activity.mine.ae r0 = r3.f13650a
            boolean r0 = com.cnlaunch.x431pro.activity.mine.FirmwareFixFragment.m6472q(r0)
            if (r0 == 0) goto L56
            r0 = 300(0x12c, double:1.48E-321)
            sleep(r0)     // Catch: java.lang.InterruptedException -> Le
            goto L12
        Le:
            r0 = move-exception
            r0.printStackTrace()
        L12:
            com.cnlaunch.x431pro.activity.mine.ae r0 = r3.f13650a
            int r0 = com.cnlaunch.x431pro.activity.mine.FirmwareFixFragment.m6496B(r0)
            r1 = 10
            if (r0 <= r1) goto L29
            com.cnlaunch.x431pro.activity.mine.ae r0 = r3.f13650a
            com.cnlaunch.x431pro.activity.mine.FirmwareFixFragment.m6495C(r0)
            com.cnlaunch.x431pro.activity.mine.ae r0 = r3.f13650a
            java.lang.String r1 = "."
            com.cnlaunch.x431pro.activity.mine.FirmwareFixFragment.m6489a(r0, r1)
            goto L45
        L29:
            com.cnlaunch.x431pro.activity.mine.ae r0 = r3.f13650a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.cnlaunch.x431pro.activity.mine.ae r2 = r3.f13650a
            java.lang.String r2 = com.cnlaunch.x431pro.activity.mine.FirmwareFixFragment.m6474o(r2)
            r1.append(r2)
            java.lang.String r2 = "."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.cnlaunch.x431pro.activity.mine.FirmwareFixFragment.m6489a(r0, r1)
        L45:
            com.cnlaunch.x431pro.activity.mine.ae r0 = r3.f13650a
            com.cnlaunch.x431pro.activity.mine.FirmwareFixFragment.m6494D(r0)
            com.cnlaunch.x431pro.activity.mine.ae r0 = r3.f13650a
            android.os.Handler r0 = com.cnlaunch.x431pro.activity.mine.FirmwareFixFragment.m6497A(r0)
            r1 = 4096(0x1000, float:5.74E-42)
            r0.sendEmptyMessage(r1)
            goto L0
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.mine.C2400aj.run():void");
    }
}
