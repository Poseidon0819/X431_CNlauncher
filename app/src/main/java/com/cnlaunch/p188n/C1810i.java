package com.cnlaunch.p188n;

import com.cnlaunch.p188n.p191c.MLog;

/* compiled from: ReportSocketControler.java */
/* renamed from: com.cnlaunch.n.i */
/* loaded from: classes.dex */
final class C1810i extends Thread {

    /* renamed from: a */
    final /* synthetic */ boolean f9667a;

    /* renamed from: b */
    final /* synthetic */ ReportSocketControler f9668b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1810i(ReportSocketControler reportSocketControler, boolean z) {
        this.f9668b = reportSocketControler;
        this.f9667a = z;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        super.run();
        this.f9668b.f9674j.lock();
        if (this.f9668b.f9678n != null) {
            try {
                this.f9668b.f9678n.m8523b();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ReportSocketControler reportSocketControler = this.f9668b;
        reportSocketControler.f9675k = false;
        if (!this.f9667a) {
            if (reportSocketControler.f9672h != null && this.f9668b.f9672h.f9616c) {
                MLog.m8522a(this.f9668b.f9669e, "------> mSendChecker.destory");
                this.f9668b.f9672h.mo8536b();
                this.f9668b.f9672h = null;
            }
            this.f9668b.f9687w = true;
        }
        if (this.f9668b.f9671g != null) {
            this.f9668b.f9671g.close(true);
            if (this.f9668b.f9671g.getService() != null) {
                this.f9668b.f9671g.getService().dispose();
            }
            this.f9668b.f9671g = null;
        }
        if (this.f9668b.f9673i != null) {
            this.f9668b.f9673i.dispose();
            this.f9668b.f9673i = null;
        }
        MLog.m8522a(this.f9668b.f9669e, "------> end<------");
        this.f9668b.f9674j.unlock();
    }
}
