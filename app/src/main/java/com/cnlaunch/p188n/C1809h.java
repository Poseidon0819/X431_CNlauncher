package com.cnlaunch.p188n;

import com.cnlaunch.p188n.p191c.MLog;

/* compiled from: ReportSocketControler.java */
/* renamed from: com.cnlaunch.n.h */
/* loaded from: classes.dex */
final class C1809h extends Thread {

    /* renamed from: a */
    final /* synthetic */ ReportSocketControler f9666a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1809h(ReportSocketControler reportSocketControler) {
        this.f9666a = reportSocketControler;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        super.run();
        try {
            MLog.m8522a(this.f9666a.f9669e, String.format("connect ReportSocketControler ip=%s port=%d", this.f9666a.f9685u, Integer.valueOf(this.f9666a.f9686v)));
            this.f9666a.m8506a(this.f9666a.f9685u, this.f9666a.f9686v, 3);
        } catch (Exception e) {
            String str = this.f9666a.f9669e;
            MLog.m8522a(str, "connect ReportSocketControler error---:" + e.toString());
            e.printStackTrace();
        }
    }
}
