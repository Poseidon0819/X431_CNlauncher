package com.cnlaunch.p169im.p170a;

import android.os.Handler;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LayoutAdapter.java */
/* renamed from: com.cnlaunch.im.a.p */
/* loaded from: classes.dex */
public final class C1689p extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ LayoutAdapter f9015a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1689p(LayoutAdapter layoutAdapter) {
        this.f9015a = layoutAdapter;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        int i;
        Handler handler;
        LayoutAdapter.m8892b(this.f9015a);
        i = this.f9015a.f9002o;
        if (i >= 59) {
            handler = this.f9015a.f8991c;
            handler.sendEmptyMessageDelayed(10013, 800L);
        }
    }
}
