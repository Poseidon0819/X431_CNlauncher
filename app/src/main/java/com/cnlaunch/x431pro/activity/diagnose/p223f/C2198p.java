package com.cnlaunch.x431pro.activity.diagnose.p223f;

import java.util.TimerTask;

/* compiled from: RemoteDiagHandler.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.f.p */
/* loaded from: classes.dex */
public final class C2198p extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ RemoteDiagHandler f12472a;

    public C2198p(RemoteDiagHandler remoteDiagHandler) {
        this.f12472a = remoteDiagHandler;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.f12472a.sendEmptyMessage(111);
    }
}
