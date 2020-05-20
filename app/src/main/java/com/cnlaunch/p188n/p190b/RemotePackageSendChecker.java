package com.cnlaunch.p188n.p190b;

import com.cnlaunch.p188n.p189a.IdleSocketListener;
import com.cnlaunch.p188n.p191c.MLog;
import org.apache.mina.core.session.IoSession;

/* renamed from: com.cnlaunch.n.b.j */
/* loaded from: classes.dex */
public class RemotePackageSendChecker extends SendChecker {

    /* renamed from: k */
    private static RemotePackageSendChecker f9584k;

    private RemotePackageSendChecker(IdleSocketListener idleSocketListener) {
        super(idleSocketListener);
        this.f9614a = "XRR";
        this.f9621h = 1;
    }

    /* renamed from: a */
    public static RemotePackageSendChecker m8566a(IdleSocketListener idleSocketListener) {
        if (f9584k == null) {
            synchronized (RemotePackageSendChecker.class) {
                if (f9584k == null) {
                    f9584k = new RemotePackageSendChecker(idleSocketListener);
                }
            }
        }
        return f9584k;
    }

    @Override // com.cnlaunch.p188n.p190b.SendChecker
    /* renamed from: a */
    public final void mo8539a(IoSession ioSession, PackageData packageData) {
        synchronized (this.f9615b) {
            if (MLog.f9645a && !packageData.isResponsPackage()) {
                String str = this.f9614a;
                MLog.m8521b(str, "***有新数据要发送-- 计数器:" + packageData.getSendCounter() + " 发送队列还剩余***:" + this.f9615b.size());
            }
            if (packageData.getBusinessID() == 2) {
                if (this.f9615b.size() <= 0 || (this.f9615b.get(0).getData().getBusinessID() != 2 && this.f9615b.get(0).getData().getBusinessID() != 2)) {
                    this.f9615b.add(0, new PackageWorker(packageData));
                }
                MLog.m8520c(this.f9614a, "***登录包，优先放在第一位直接发送***");
                m8535b(ioSession, this.f9615b.get(0).getData());
                m8537a(false);
            } else if (packageData.getBusinessID() == 0) {
                if (this.f9615b.size() != 0 && this.f9623j) {
                    MLog.m8520c(this.f9614a, "心跳包发送列表不为空 不需要发送心跳包");
                }
                if (MLog.f9645a) {
                    if (this.f9615b.size() == 0) {
                        MLog.m8522a(this.f9614a, "发送列表为空  发送心跳包 ");
                    } else {
                        String str2 = this.f9614a;
                        MLog.m8522a(str2, "还没有收到技师透传包 发送心跳包 发送列表数量:" + this.f9615b.size());
                    }
                }
                this.f9615b.add(0, new PackageWorker(packageData));
                m8535b(ioSession, this.f9615b.get(0).getData());
            } else if (packageData.getBusinessID() == 7) {
                this.f9615b.add(0, new PackageWorker(packageData));
                MLog.m8520c(this.f9614a, "***中转透传命令放第一位优先发送***");
                m8535b(ioSession, this.f9615b.get(0).getData());
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
        f9584k = null;
    }
}
