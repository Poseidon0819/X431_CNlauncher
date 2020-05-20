package com.cnlaunch.p188n;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p188n.p189a.IdleUSBRemoteListener;
import com.cnlaunch.p188n.p190b.RemoteBusinessPackage;
import com.cnlaunch.p188n.p190b.RemotePackageSendChecker;
import com.cnlaunch.p188n.p190b.SendChecker;
import com.cnlaunch.p188n.p191c.MLog;
import com.cnlaunch.p188n.p191c.RemoteConfig;
import com.cnlaunch.p188n.p191c.RemoteConstants;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.n.b */
/* loaded from: classes.dex */
public final class RemoteSocketControler extends SocketControler {

    /* renamed from: a */
    public static boolean f9537a = false;

    /* renamed from: b */
    public static boolean f9538b;

    /* renamed from: y */
    private static RemoteSocketControler f9539y;

    /* renamed from: A */
    private String f9540A;

    /* renamed from: B */
    private String f9541B;

    /* renamed from: D */
    private ArrayList<String> f9543D;

    /* renamed from: E */
    private ArrayList<String> f9544E;

    /* renamed from: F */
    private long f9545F;

    /* renamed from: x */
    private RemoteBusinessPackage f9549x;

    /* renamed from: z */
    private String f9550z;

    /* renamed from: c */
    public boolean f9547c = false;

    /* renamed from: C */
    private boolean f9542C = false;

    /* renamed from: G */
    private String f9546G = "";

    /* renamed from: d */
    public IdleUSBRemoteListener f9548d = null;

    private RemoteSocketControler() {
        this.f9669e = "XRR";
        this.f9681q = 1;
        this.f9670f = new HandlerC1804c(this);
    }

    /* renamed from: a */
    public static RemoteSocketControler m8607a() {
        if (f9539y == null) {
            f9539y = new RemoteSocketControler();
        }
        return f9539y;
    }

    /* renamed from: a */
    public final void m8604a(Context context) {
        this.f9680p = context;
    }

    /* renamed from: a */
    public final void m8602a(RemoteConfig remoteConfig) {
        this.f9685u = remoteConfig.getIp();
        this.f9686v = remoteConfig.getPort();
        this.f9550z = remoteConfig.getTech_id();
        this.f9540A = remoteConfig.getTech_name();
        this.f9541B = remoteConfig.getTech_tel();
        if (!TextUtils.isEmpty(this.f9550z)) {
            this.f9547c = true;
        } else {
            this.f9547c = false;
        }
        this.f9542C = remoteConfig.isUsb_p2p_mode();
        this.f9549x = new RemoteBusinessPackage(this.f9680p, remoteConfig.getSn(), remoteConfig.getKey());
        if (this.f9542C) {
            return;
        }
        this.f9548d = null;
    }

    /* renamed from: b */
    public final void m8599b() {
        this.f9672h.m8532e();
    }

    /* renamed from: c */
    public final void m8596c() {
        this.f9672h.m8537a(true);
    }

    /* renamed from: d */
    public final boolean m8595d() {
        return this.f9672h.m8530g();
    }

    @Override // com.cnlaunch.p188n.SocketControler
    /* renamed from: e */
    public final SendChecker mo8503e() {
        return RemotePackageSendChecker.m8566a(this);
    }

    @Override // com.cnlaunch.p188n.SocketControler
    /* renamed from: f */
    public final void mo8502f() {
        new C1806d(this).start();
    }

    @Override // com.cnlaunch.p188n.SocketControler
    /* renamed from: g */
    public final void mo8501g() {
        String str = this.f9669e;
        MLog.m8521b(str, "远程创建连接成功:" + this.f9550z);
        if (TextUtils.isEmpty(this.f9550z)) {
            MLog.m8520c(this.f9669e, "****开始发送终端登录包****");
            m8507a(this.f9549x.m8568h(), true);
            return;
        }
        MLog.m8520c(this.f9669e, "****开始发送技师登录包****");
        m8507a(this.f9549x.m8572a(this.f9550z), true);
    }

    @Override // com.cnlaunch.p188n.SocketControler, com.cnlaunch.p188n.p189a.IdleSocketListener
    /* renamed from: h */
    public final void mo8500h() {
        MLog.m8520c(this.f9669e, "远程重发超过规定次数 断开连接");
        mo8509a(4353);
    }

    /* renamed from: a */
    public final void m8600a(Object... objArr) {
        this.f9544E = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            this.f9544E.add(String.valueOf(objArr[i]));
        }
    }

    /* renamed from: b */
    public final void m8597b(Object... objArr) {
        this.f9543D = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            this.f9543D.add(String.valueOf(objArr[i]));
        }
    }

    /* renamed from: l */
    private synchronized boolean m8592l() {
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.f9545F) < 600) {
            return true;
        }
        this.f9545F = currentTimeMillis;
        return false;
    }

    /* renamed from: b */
    private boolean m8598b(String str) {
        String string;
        boolean z;
        try {
            string = new JSONObject(str).getString(VastExtensionXmlManager.TYPE);
            if (this.f9544E != null) {
                Iterator<String> it = this.f9544E.iterator();
                while (it.hasNext()) {
                    if (string.equals(it.next())) {
                        return false;
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (string.equals(DiagnoseConstants.UI_TYPE_CURRENT_MENU_PATH)) {
            if (this.f9546G.equals(str)) {
                return false;
            }
            this.f9546G = str;
            return true;
        }
        if (this.f9543D != null && this.f9543D.size() > 0) {
            Iterator<String> it2 = this.f9543D.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = false;
                    break;
                } else if (string.equals(it2.next())) {
                    z = true;
                    break;
                }
            }
            if (z && m8592l()) {
                return false;
            }
            if (z && this.f9672h.m8531f()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public final synchronized void m8601a(String str) {
        if (m8598b(str)) {
            MLog.m8520c(this.f9669e, "****增加发送诊断数据包****:".concat(String.valueOf(str)));
            this.f9678n.m8524a();
            try {
                byte[] bytes = str.getBytes("utf-8");
                int length = bytes.length;
                int i = length;
                int i2 = 0;
                boolean z = false;
                while (i > 2047) {
                    byte[] bArr = new byte[2048];
                    bArr[0] = 1;
                    System.arraycopy(bytes, i2, bArr, 1, 2047);
                    m8507a(this.f9549x.m8570a(bArr, true, length, 2047), true);
                    i2 += 2047;
                    i -= 2047;
                    z = true;
                }
                byte[] bArr2 = new byte[i + 1];
                bArr2[0] = 0;
                System.arraycopy(bytes, i2, bArr2, 1, bytes.length - i2);
                m8507a(this.f9549x.m8570a(bArr2, z, length, bArr2.length - 1), true);
            } catch (UnsupportedEncodingException e) {
                MLog.m8520c(this.f9669e, "sendRemoteDataPagckage error:" + e.toString());
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public final void m8605a(int i, int i2) {
        m8507a(this.f9549x.m8573a(i, i2), false);
    }

    /* renamed from: a */
    public final void m8606a(int i, byte b) {
        m8507a(this.f9549x.m8574a(i, b), false);
    }

    /* renamed from: j */
    public final void m8594j() {
        String str = this.f9669e;
        MLog.m8520c(str, "****开始发送透传命令包 传递诊断配置信息  动作测试、特殊功能 是否支持返回:" + f9538b);
        m8507a(this.f9549x.m8571a(f9538b), true);
    }

    @Override // com.cnlaunch.p188n.SocketControler
    /* renamed from: a */
    public final void mo8509a(int i) {
        switch (i) {
            case 4353:
                if (RemoteConstants.f9649a == 1) {
                    RemoteConstants.f9649a = 0;
                }
                this.f9679o.sendEmptyMessage(12293);
                return;
            case 4354:
                if (RemoteConstants.f9649a == 1) {
                    this.f9679o.sendEmptyMessage(12306);
                    return;
                }
                return;
            case 4355:
                if (RemoteConstants.f9649a == 1) {
                    this.f9679o.sendEmptyMessage(12307);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: k */
    public final void m8593k() {
        mo8505a(false, true, 0);
    }

    @Override // com.cnlaunch.p188n.SocketControler
    /* renamed from: a */
    public final void mo8505a(boolean z, boolean z2, int i) {
        if (!this.f9675k) {
            MLog.m8520c(this.f9669e, "当前没有连接，是否主动关闭:".concat(String.valueOf(z2)));
            this.f9687w = z2;
            if (z) {
                return;
            }
            RemoteConstants.f9649a = 0;
            RemoteConstants.f9650b = true;
            return;
        }
        new C1807e(this, z, z2, i).start();
    }

    @Override // com.cnlaunch.p188n.SocketControler
    /* renamed from: i */
    public final void mo8499i() {
        m8507a(this.f9549x.m8569g(), true);
    }
}
