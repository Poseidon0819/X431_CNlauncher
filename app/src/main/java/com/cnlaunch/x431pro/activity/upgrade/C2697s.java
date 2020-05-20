package com.cnlaunch.x431pro.activity.upgrade;

import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloadFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.s */
/* loaded from: classes.dex */
public final class C2697s extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ DownloadFragment f15424a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2697s(DownloadFragment downloadFragment) {
        this.f15424a = downloadFragment;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        DownloadFragment.m5520aX(this.f15424a);
    }
}
