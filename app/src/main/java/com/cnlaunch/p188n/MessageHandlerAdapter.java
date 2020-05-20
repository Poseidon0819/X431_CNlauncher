package com.cnlaunch.p188n;

import android.os.Handler;
import com.cnlaunch.p188n.p189a.IdleSendCheckerInface;
import com.cnlaunch.p188n.p190b.RemoteParseDataHelp;
import com.cnlaunch.p188n.p190b.ReportParseDataHelp;
import com.cnlaunch.p188n.p191c.MLog;
import com.cnlaunch.p188n.p191c.SocketTools;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/* renamed from: com.cnlaunch.n.a */
/* loaded from: classes.dex */
public final class MessageHandlerAdapter extends IoHandlerAdapter {

    /* renamed from: a */
    private static String f9529a = "XRR";

    /* renamed from: b */
    private IdleSendCheckerInface f9530b;

    /* renamed from: c */
    private Handler f9531c;

    /* renamed from: d */
    private Handler f9532d;

    /* renamed from: e */
    private RemoteParseDataHelp f9533e;

    /* renamed from: f */
    private ReportParseDataHelp f9534f;

    /* renamed from: g */
    private int f9535g;

    /* renamed from: h */
    private SocketControler f9536h;

    public MessageHandlerAdapter(SocketControler socketControler, Handler handler, Handler handler2, IdleSendCheckerInface idleSendCheckerInface, int i) {
        this.f9530b = null;
        this.f9535g = 0;
        this.f9536h = socketControler;
        this.f9532d = handler;
        this.f9531c = handler2;
        this.f9530b = idleSendCheckerInface;
        this.f9535g = i;
        int i2 = this.f9535g;
        if (i2 == 0) {
            f9529a = "XMM";
        } else if (i2 == 1) {
            f9529a = "XRR";
        }
    }

    @Override // org.apache.mina.core.service.IoHandlerAdapter, org.apache.mina.core.service.IoHandler
    public final void exceptionCaught(IoSession ioSession, Throwable th) throws Exception {
        super.exceptionCaught(ioSession, th);
        if (MLog.f9645a) {
            MLog.m8522a(f9529a, "MessageListenter=exceptionCaught");
        }
    }

    @Override // org.apache.mina.core.service.IoHandlerAdapter, org.apache.mina.core.service.IoHandler
    public final void messageReceived(IoSession ioSession, Object obj) throws Exception {
        byte[] bArr = (byte[]) obj;
        if (bArr == null || bArr.length == 0) {
            return;
        }
        if (MLog.f9645a) {
            String str = f9529a;
            MLog.m8522a(str, "***服务器返回的一包数据***:" + SocketTools.m8518a(bArr));
        }
        switch (this.f9535g) {
            case 0:
                if (this.f9534f == null) {
                    this.f9534f = new ReportParseDataHelp(this.f9536h, this.f9532d, this.f9531c, ioSession, this.f9530b);
                }
                this.f9534f.m8546a(bArr);
                break;
            case 1:
                if (this.f9533e == null) {
                    this.f9533e = new RemoteParseDataHelp(this.f9536h, this.f9532d, this.f9531c, ioSession, this.f9530b);
                }
                this.f9533e.m8563a(bArr);
                break;
        }
        super.messageReceived(ioSession, obj);
    }

    @Override // org.apache.mina.core.service.IoHandlerAdapter, org.apache.mina.core.service.IoHandler
    public final void sessionCreated(IoSession ioSession) throws Exception {
        if (MLog.f9645a) {
            MLog.m8520c(f9529a, "服务器与客户端创建连接...");
        }
        super.sessionCreated(ioSession);
    }

    @Override // org.apache.mina.core.service.IoHandlerAdapter, org.apache.mina.core.service.IoHandler
    public final void sessionOpened(IoSession ioSession) throws Exception {
        if (MLog.f9645a) {
            MLog.m8522a(f9529a, "sessionOpened 服务器与客户端连接打开...");
        }
        super.sessionOpened(ioSession);
    }

    @Override // org.apache.mina.core.service.IoHandlerAdapter, org.apache.mina.core.service.IoHandler
    public final void messageSent(IoSession ioSession, Object obj) throws Exception {
        super.messageSent(ioSession, obj);
    }

    @Override // org.apache.mina.core.service.IoHandlerAdapter, org.apache.mina.core.service.IoHandler
    public final void sessionClosed(IoSession ioSession) throws Exception {
        super.sessionClosed(ioSession);
        if (MLog.f9645a) {
            MLog.m8522a(f9529a, "MessageListenter=sessionClosed");
        }
    }

    @Override // org.apache.mina.core.service.IoHandlerAdapter, org.apache.mina.core.service.IoHandler
    public final void sessionIdle(IoSession ioSession, IdleStatus idleStatus) throws Exception {
        super.sessionIdle(ioSession, idleStatus);
        if (MLog.f9645a) {
            MLog.m8522a(f9529a, "MessageListenter=sessionIdle 进入空闲状态...");
        }
    }
}
