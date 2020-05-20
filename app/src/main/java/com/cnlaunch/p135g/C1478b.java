package com.cnlaunch.p135g;

import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BLocationLogic.java */
/* renamed from: com.cnlaunch.g.b */
/* loaded from: classes.dex */
public final class C1478b extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ BLocationLogic f7297a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1478b(BLocationLogic bLocationLogic) {
        this.f7297a = bLocationLogic;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.f7297a.m9426a();
    }
}
