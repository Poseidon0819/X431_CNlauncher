package com.cnlaunch.p169im.p170a;

import android.os.PowerManager;
import com.cnlaunch.p169im.p176f.RecorderHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LayoutAdapter.java */
/* renamed from: com.cnlaunch.im.a.q */
/* loaded from: classes.dex */
public final class C1690q implements RecorderHelper.InterfaceC1741a {

    /* renamed from: a */
    final /* synthetic */ LayoutAdapter f9016a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1690q(LayoutAdapter layoutAdapter) {
        this.f9016a = layoutAdapter;
    }

    @Override // com.cnlaunch.p169im.p176f.RecorderHelper.InterfaceC1741a
    /* renamed from: a */
    public final void mo8723a(int i) {
        PowerManager.WakeLock wakeLock;
        PowerManager.WakeLock wakeLock2;
        PowerManager.WakeLock wakeLock3;
        if (i == 1) {
            wakeLock3 = this.f9016a.f9013z;
            wakeLock3.acquire();
            return;
        }
        wakeLock = this.f9016a.f9013z;
        if (wakeLock.isHeld()) {
            wakeLock2 = this.f9016a.f9013z;
            wakeLock2.release();
        }
    }
}
