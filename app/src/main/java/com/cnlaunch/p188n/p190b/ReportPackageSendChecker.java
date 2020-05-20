package com.cnlaunch.p188n.p190b;

import com.cnlaunch.p188n.p189a.IdleSocketListener;
import com.cnlaunch.p188n.p191c.MLog;
import org.apache.mina.core.session.IoSession;

/* renamed from: com.cnlaunch.n.b.m */
/* loaded from: classes.dex */
public class ReportPackageSendChecker extends SendChecker {

    /* renamed from: k */
    private static ReportPackageSendChecker f9598k;

    private ReportPackageSendChecker(IdleSocketListener idleSocketListener) {
        super(idleSocketListener);
        this.f9614a = "XMM";
        this.f9621h = 0;
    }

    /* renamed from: a */
    public static ReportPackageSendChecker m8550a(IdleSocketListener idleSocketListener) {
        if (f9598k == null) {
            synchronized (ReportPackageSendChecker.class) {
                if (f9598k == null) {
                    f9598k = new ReportPackageSendChecker(idleSocketListener);
                }
            }
        }
        return f9598k;
    }

    @Override // com.cnlaunch.p188n.p190b.SendChecker
    /* renamed from: a */
    public final void mo8539a(IoSession ioSession, PackageData packageData) {
        synchronized (this.f9615b) {
            String str = this.f9614a;
            MLog.m8522a(str, "***发送之前，还剩余没发送的包的数量***:" + this.f9615b.size());
            if (packageData.getBusinessID() == 2) {
                if (this.f9615b.size() <= 0 || this.f9615b.get(0).getData().getBusinessID() != 2) {
                    this.f9615b.add(0, new PackageWorker(packageData));
                }
                m8535b(ioSession, this.f9615b.get(0).getData());
            } else if (packageData.getBusinessID() == 1) {
                if (this.f9615b.size() == 0) {
                    MLog.m8522a(this.f9614a, "发送列表为空 发送心跳包");
                    this.f9615b.add(0, new PackageWorker(packageData));
                    m8535b(ioSession, this.f9615b.get(0).getData());
                }
            } else {
                this.f9615b.add(new PackageWorker(packageData));
                if (this.f9615b.size() == 1) {
                    m8535b(ioSession, this.f9615b.get(0).getData());
                }
            }
        }
    }

    @Override // com.cnlaunch.p188n.p190b.SendChecker
    /* renamed from: b */
    public final void mo8536b() {
        super.mo8536b();
        f9598k = null;
    }
}
