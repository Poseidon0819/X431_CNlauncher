package com.cnlaunch.p188n;

import android.content.Context;
import com.cnlaunch.p188n.p190b.ReportBusinessPackage;
import com.cnlaunch.p188n.p190b.ReportPackageSendChecker;
import com.cnlaunch.p188n.p190b.ReportParseDataHelp;
import com.cnlaunch.p188n.p190b.SendChecker;
import com.cnlaunch.p188n.p191c.MLog;
import com.cnlaunch.p188n.p191c.RemoteConstants;

/* renamed from: com.cnlaunch.n.f */
/* loaded from: classes.dex */
public final class ReportSocketControler extends SocketControler {

    /* renamed from: a */
    public static boolean f9660a = true;

    /* renamed from: x */
    private static ReportSocketControler f9661x;

    /* renamed from: b */
    public Context f9662b;

    /* renamed from: c */
    public byte[] f9663c;

    /* renamed from: d */
    private ReportBusinessPackage f9664d;

    private ReportSocketControler() {
        this.f9669e = "XMM";
        this.f9681q = 0;
        this.f9670f = new HandlerC1808g(this);
    }

    /* renamed from: a */
    public static ReportSocketControler m8514a() {
        ReportSocketControler reportSocketControler = f9661x;
        if (reportSocketControler == null) {
            return null;
        }
        return reportSocketControler;
    }

    /* renamed from: b */
    public static ReportSocketControler m8512b() {
        if (f9661x == null) {
            f9661x = new ReportSocketControler();
        }
        return f9661x;
    }

    @Override // com.cnlaunch.p188n.SocketControler
    /* renamed from: e */
    public final SendChecker mo8503e() {
        return ReportPackageSendChecker.m8550a(this);
    }

    @Override // com.cnlaunch.p188n.SocketControler
    /* renamed from: f */
    public final void mo8502f() {
        if (!f9660a) {
            m8511c(28930);
            m8511c(28935);
            return;
        }
        new C1809h(this).start();
    }

    @Override // com.cnlaunch.p188n.SocketControler
    /* renamed from: g */
    public final void mo8501g() {
        MLog.m8522a(this.f9669e, "创建连接成功");
        MLog.m8522a(this.f9669e, "----开始发送登录信息包----");
        m8507a(this.f9664d.m8551e(), true);
    }

    @Override // com.cnlaunch.p188n.SocketControler, com.cnlaunch.p188n.p189a.IdleSocketListener
    /* renamed from: h */
    public final void mo8500h() {
        MLog.m8522a(this.f9669e, "重发超过规定次数");
        mo8505a(true, false, 0);
    }

    @Override // com.cnlaunch.p188n.SocketControler
    /* renamed from: i */
    public final void mo8499i() {
        MLog.m8522a(this.f9669e, "----开始发送心跳包----");
        m8507a(this.f9664d.m8552d(), true);
    }

    /* renamed from: a */
    public final void m8513a(boolean z) {
        this.f9678n.m8524a();
        m8507a(this.f9664d.m8554a(this.f9663c, z), false);
    }

    /* renamed from: c */
    private void m8511c(int i) {
        if (this.f9679o != null) {
            this.f9679o.sendEmptyMessage(i);
        }
    }

    @Override // com.cnlaunch.p188n.SocketControler
    /* renamed from: a */
    public final void mo8509a(int i) {
        switch (i) {
            case 4353:
                if (RemoteConstants.f9649a == 0) {
                    this.f9679o.sendEmptyMessage(28929);
                    ReportParseDataHelp.f9599a = true;
                    return;
                }
                return;
            case 4354:
                if (RemoteConstants.f9649a == 0) {
                    this.f9679o.sendEmptyMessage(28933);
                    return;
                }
                return;
            case 4355:
                if (RemoteConstants.f9649a == 0) {
                    this.f9679o.sendEmptyMessage(28934);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.cnlaunch.p188n.SocketControler
    /* renamed from: a */
    public final void mo8505a(boolean z, boolean z2, int i) {
        if (this.f9675k) {
            new C1810i(this, z).start();
        }
    }
}
