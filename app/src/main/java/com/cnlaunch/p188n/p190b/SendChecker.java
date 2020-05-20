package com.cnlaunch.p188n.p190b;

import com.cnlaunch.p188n.p189a.IdleSendCheckerInface;
import com.cnlaunch.p188n.p189a.IdleSocketListener;
import com.cnlaunch.p188n.p191c.LoopTimer;
import com.cnlaunch.p188n.p191c.MLog;
import com.cnlaunch.p188n.p191c.ReportConstants;
import com.cnlaunch.p188n.p191c.SocketTools;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.session.IoSession;

/* renamed from: com.cnlaunch.n.b.o */
/* loaded from: classes.dex */
public class SendChecker implements IdleSendCheckerInface {

    /* renamed from: b */
    protected ArrayList<PackageWorker> f9615b;

    /* renamed from: e */
    protected IdleSocketListener f9618e;

    /* renamed from: g */
    LoopTimer f9620g;

    /* renamed from: h */
    protected int f9621h;

    /* renamed from: j */
    protected boolean f9623j;

    /* renamed from: a */
    protected String f9614a = "XRR";

    /* renamed from: c */
    public boolean f9616c = true;

    /* renamed from: d */
    public int f9617d = 0;

    /* renamed from: f */
    public IoSession f9619f = null;

    /* renamed from: k */
    private final int f9624k = 8;

    /* renamed from: l */
    private IoFutureListener<WriteFuture> f9625l = new C1802q(this);

    /* renamed from: m */
    private IoFutureListener<WriteFuture> f9626m = new C1803r(this);

    /* renamed from: i */
    protected Lock f9622i = new ReentrantLock();

    /* renamed from: a */
    public void mo8539a(IoSession ioSession, PackageData packageData) {
    }

    public SendChecker(IdleSocketListener idleSocketListener) {
        this.f9615b = null;
        this.f9618e = null;
        this.f9623j = false;
        this.f9615b = new ArrayList<>();
        this.f9618e = idleSocketListener;
        if (this.f9620g == null) {
            this.f9620g = new LoopTimer(8, new RunnableC1801p(this));
        }
        if (MLog.f9645a) {
            MLog.m8522a(this.f9614a, "new SendChecker");
        }
        this.f9623j = false;
    }

    @Override // com.cnlaunch.p188n.p189a.IdleSendCheckerInface
    /* renamed from: a */
    public final void mo8540a(IoSession ioSession) {
        m8533d();
        synchronized (this.f9615b) {
            if (this.f9615b.size() > 0) {
                this.f9615b.remove(0);
                if (this.f9615b.size() > 0) {
                    this.f9615b.get(0).resetResendTime();
                    if (this.f9618e == null) {
                        MLog.m8521b(this.f9614a, "------------idleListener == null------------------");
                    }
                    m8535b(ioSession, this.f9615b.get(0).getData());
                }
            }
        }
    }

    /* renamed from: c */
    public final void m8534c() {
        synchronized (this.f9615b) {
            if (this.f9615b.size() > 0) {
                this.f9615b.get(0).resetResendTime();
                if (this.f9615b.get(0).getData().getBusinessID() == 0) {
                    this.f9615b.remove(0);
                }
            }
        }
    }

    /* renamed from: b */
    public void mo8536b() {
        this.f9616c = false;
        LoopTimer loopTimer = this.f9620g;
        if (loopTimer != null) {
            loopTimer.m8523b();
            loopTimer.f9641a.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final void m8535b(IoSession ioSession, PackageData packageData) {
        m8533d();
        if (ioSession != null) {
            if (!packageData.isResponsPackage()) {
                ReportConstants.f9652a = packageData.isCCCReportUpload();
                m8538a(ioSession, packageData, false);
                return;
            }
            m8538a(ioSession, packageData, true);
        }
    }

    /* renamed from: a */
    public final synchronized void m8538a(IoSession ioSession, PackageData packageData, boolean z) {
        this.f9622i.lock();
        if (!z) {
            if (MLog.f9645a) {
                if (packageData.isCutPackage()) {
                    String str = this.f9614a;
                    MLog.m8521b(str, "---**开始发送拆包数据**----计数器:" + packageData.getSendCounter() + " 总长度:" + packageData.getCutPackage_Total_number() + " 当前长度:" + packageData.getCurPackage_Current_number());
                    String str2 = this.f9614a;
                    StringBuilder sb = new StringBuilder(" 数据:");
                    sb.append(SocketTools.m8518a(packageData.getData()));
                    MLog.m8521b(str2, sb.toString());
                } else {
                    String str3 = this.f9614a;
                    MLog.m8521b(str3, "--**发送整包数据--**计数器:" + packageData.getSendCounter() + " 数据:" + SocketTools.m8518a(packageData.getData()));
                }
            }
            ioSession.write(IoBuffer.wrap(packageData.getData())).addListener((IoFutureListener<?>) this.f9625l);
        } else {
            if (MLog.f9645a) {
                String str4 = this.f9614a;
                MLog.m8521b(str4, "~~~~~~~~~开始发送不需要回应的反馈包****返回服务器的计数器:" + packageData.getSendCounter() + " 数据:" + SocketTools.m8518a(packageData.getData()));
            }
            ioSession.write(IoBuffer.wrap(packageData.getData())).addListener((IoFutureListener<?>) this.f9626m);
        }
        this.f9622i.unlock();
    }

    @Override // com.cnlaunch.p188n.p189a.IdleSendCheckerInface
    /* renamed from: a */
    public final int mo8542a() {
        if (this.f9615b.size() > 0) {
            return this.f9615b.get(0).getData().getSendCounter();
        }
        return 0;
    }

    /* renamed from: d */
    public final void m8533d() {
        LoopTimer loopTimer = this.f9620g;
        if (loopTimer != null) {
            loopTimer.m8523b();
        }
    }

    /* renamed from: e */
    public final void m8532e() {
        synchronized (this.f9615b) {
            if (this.f9615b.size() > 0) {
                this.f9615b.remove(0);
            }
        }
        LoopTimer loopTimer = this.f9620g;
        if (loopTimer != null) {
            loopTimer.m8523b();
        }
    }

    /* renamed from: f */
    public final boolean m8531f() {
        return this.f9615b.size() > 2;
    }

    /* renamed from: g */
    public final boolean m8530g() {
        return this.f9623j;
    }

    /* renamed from: a */
    public final void m8537a(boolean z) {
        this.f9623j = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m8541a(SendChecker sendChecker) {
        synchronized (sendChecker.f9615b) {
            if (sendChecker.f9615b.size() > 0) {
                if (sendChecker.f9615b.get(0).getResendTime() < sendChecker.f9617d) {
                    sendChecker.f9615b.get(0).increaseResendTime();
                    sendChecker.m8535b(sendChecker.f9619f, sendChecker.f9615b.get(0).getData());
                    if (MLog.f9645a) {
                        String str = sendChecker.f9614a;
                        MLog.m8521b(str, "****------>自动重发------*****: BusinessID:" + sendChecker.f9615b.get(0).getData().getBusinessID() + " 重发次数:" + sendChecker.f9615b.get(0).getResendTime() + " 可以重发的次数:" + sendChecker.f9617d);
                    }
                } else if (sendChecker.f9618e != null) {
                    sendChecker.m8533d();
                    sendChecker.f9615b.get(0).resetResendTime();
                    sendChecker.f9618e.mo8500h();
                }
            }
        }
    }
}
