package com.cnlaunch.p188n;

import android.content.Context;
import android.os.Handler;
import com.cnlaunch.p188n.p189a.IdleSocketListener;
import com.cnlaunch.p188n.p190b.ByteArrayCodecFactory;
import com.cnlaunch.p188n.p190b.PackageData;
import com.cnlaunch.p188n.p190b.SendChecker;
import com.cnlaunch.p188n.p191c.LoopTimer;
import com.cnlaunch.p188n.p191c.MLog;
import com.cnlaunch.p188n.p191c.RemoteConstants;
import java.net.InetSocketAddress;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

/* renamed from: com.cnlaunch.n.j */
/* loaded from: classes.dex */
public abstract class SocketControler implements IdleSocketListener {

    /* renamed from: e */
    protected String f9669e;

    /* renamed from: f */
    public Handler f9670f;

    /* renamed from: n */
    protected LoopTimer f9678n;

    /* renamed from: o */
    protected Handler f9679o;

    /* renamed from: p */
    protected Context f9680p;

    /* renamed from: u */
    protected String f9685u;

    /* renamed from: v */
    protected int f9686v;

    /* renamed from: g */
    protected IoSession f9671g = null;

    /* renamed from: h */
    protected SendChecker f9672h = null;

    /* renamed from: i */
    NioSocketConnector f9673i = null;

    /* renamed from: j */
    protected Lock f9674j = new ReentrantLock();

    /* renamed from: k */
    protected boolean f9675k = false;

    /* renamed from: l */
    protected int f9676l = 0;

    /* renamed from: m */
    protected int f9677m = 2;

    /* renamed from: q */
    protected int f9681q = 0;

    /* renamed from: r */
    protected final int f9682r = 4353;

    /* renamed from: s */
    protected final int f9683s = 4354;

    /* renamed from: t */
    protected final int f9684t = 4355;

    /* renamed from: w */
    protected boolean f9687w = false;

    /* renamed from: a */
    public void mo8509a(int i) {
    }

    /* renamed from: a */
    public void mo8505a(boolean z, boolean z2, int i) {
    }

    /* renamed from: e */
    public abstract SendChecker mo8503e();

    /* renamed from: f */
    public void mo8502f() {
    }

    /* renamed from: g */
    public void mo8501g() {
    }

    @Override // com.cnlaunch.p188n.p189a.IdleSocketListener
    /* renamed from: h */
    public void mo8500h() {
    }

    /* renamed from: i */
    public void mo8499i() {
    }

    public SocketControler() {
        if (this.f9678n == null) {
            this.f9678n = new LoopTimer(20, new RunnableC1811k(this));
        }
    }

    /* renamed from: a */
    public final void m8508a(Handler handler) {
        this.f9679o = handler;
    }

    /* renamed from: a */
    public final void m8506a(String str, int i, int i2) {
        String str2 = this.f9669e;
        MLog.m8522a(str2, "isconnect:" + this.f9675k);
        if (this.f9675k) {
            return;
        }
        try {
            try {
                this.f9675k = true;
                this.f9673i = new NioSocketConnector();
                this.f9672h = mo8503e();
                this.f9673i.setConnectTimeoutMillis(60000L);
                this.f9673i.getSessionConfig().setUseReadOperation(false);
                this.f9673i.setHandler(new MessageHandlerAdapter(this, this.f9670f, this.f9679o, this.f9672h, this.f9681q));
                this.f9673i.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ByteArrayCodecFactory()));
                String str3 = this.f9669e;
                MLog.m8522a(str3, "------>创建连接:[" + str + ":" + i + "]");
                ConnectFuture connect = this.f9673i.connect(new InetSocketAddress(str, i));
                connect.awaitUninterruptibly();
                this.f9671g = connect.getSession();
                SendChecker sendChecker = this.f9672h;
                sendChecker.f9619f = this.f9671g;
                sendChecker.f9617d = i2;
                sendChecker.f9616c = true;
                sendChecker.m8534c();
                if (this.f9671g.isConnected()) {
                    if (this.f9676l > 0) {
                        mo8509a(4354);
                    }
                    this.f9676l = 0;
                    this.f9687w = false;
                    mo8501g();
                }
                connect.getSession().getCloseFuture().awaitUninterruptibly();
            } catch (Exception e) {
                e.printStackTrace();
                String str4 = this.f9669e;
                MLog.m8522a(str4, "SocketError[" + str + ":" + i + "]>>>");
                this.f9674j.lock();
                LoopTimer loopTimer = this.f9678n;
                if (loopTimer != null) {
                    try {
                        loopTimer.m8523b();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                this.f9675k = false;
                IoSession ioSession = this.f9671g;
                if (ioSession != null) {
                    ioSession.close(true);
                    if (this.f9671g.getService() != null) {
                        this.f9671g.getService().dispose();
                    }
                }
            }
        } finally {
            this.f9674j.lock();
            LoopTimer loopTimer2 = this.f9678n;
            if (loopTimer2 != null) {
                try {
                    loopTimer2.m8523b();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            this.f9675k = false;
            IoSession ioSession2 = this.f9671g;
            if (ioSession2 != null) {
                ioSession2.close(true);
                if (this.f9671g.getService() != null) {
                    this.f9671g.getService().dispose();
                }
                this.f9671g = null;
            }
            MLog.m8521b(this.f9669e, "SocketConnect Finally end!");
            this.f9674j.unlock();
            m8510a();
        }
    }

    /* renamed from: a */
    private synchronized void m8510a() {
        String str = this.f9669e;
        MLog.m8522a(str, "是否主动关闭连接:" + this.f9687w);
        if (this.f9687w) {
            return;
        }
        String str2 = this.f9669e;
        MLog.m8521b(str2, "服务器连接失败，第" + this.f9676l + "次 总共:" + this.f9677m);
        if (this.f9676l <= this.f9677m && RemoteConstants.f9649a != 0) {
            new Thread(new RunnableC1812l(this)).start();
        }
        mo8509a(4353);
        this.f9678n.m8523b();
        if (this.f9672h != null) {
            this.f9672h.m8533d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m8507a(PackageData packageData, boolean z) {
        SendChecker sendChecker;
        IoSession ioSession;
        if (this.f9687w || (sendChecker = this.f9672h) == null || (ioSession = this.f9671g) == null) {
            return;
        }
        if (z) {
            sendChecker.mo8539a(ioSession, packageData);
        } else if (ioSession != null) {
            sendChecker.m8538a(ioSession, packageData, true);
        }
    }

    /* renamed from: b */
    public final void m8504b(int i) {
        Handler handler = this.f9679o;
        if (handler != null) {
            handler.sendEmptyMessage(i);
        }
    }
}
