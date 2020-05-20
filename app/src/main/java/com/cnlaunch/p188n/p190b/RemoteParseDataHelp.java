package com.cnlaunch.p188n.p190b;

import android.os.Handler;
import com.baidu.mapapi.UIMsg;
import com.cnlaunch.p188n.RemoteSocketControler;
import com.cnlaunch.p188n.SocketControler;
import com.cnlaunch.p188n.p189a.IdleSendCheckerInface;
import com.cnlaunch.p188n.p191c.CRC16;
import com.cnlaunch.p188n.p191c.MLog;
import com.cnlaunch.p188n.p191c.RemoteConstants;
import com.cnlaunch.p188n.p191c.SocketTools;
import com.itextpdf.text.pdf.PdfAction;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.mina.core.session.IoSession;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.n.b.k */
/* loaded from: classes.dex */
public final class RemoteParseDataHelp {

    /* renamed from: a */
    private Handler f9585a;

    /* renamed from: b */
    private Handler f9586b;

    /* renamed from: c */
    private IoSession f9587c;

    /* renamed from: d */
    private IdleSendCheckerInface f9588d;

    /* renamed from: e */
    private RemoteSocketControler f9589e;

    /* renamed from: g */
    private byte[] f9591g;

    /* renamed from: j */
    private byte[] f9594j;

    /* renamed from: f */
    private boolean f9590f = true;

    /* renamed from: h */
    private Lock f9592h = new ReentrantLock();

    /* renamed from: i */
    private boolean f9593i = false;

    public RemoteParseDataHelp(SocketControler socketControler, Handler handler, Handler handler2, IoSession ioSession, IdleSendCheckerInface idleSendCheckerInface) {
        this.f9588d = null;
        this.f9589e = null;
        this.f9589e = (RemoteSocketControler) socketControler;
        this.f9586b = handler;
        this.f9585a = handler2;
        this.f9587c = ioSession;
        this.f9588d = idleSendCheckerInface;
    }

    /* renamed from: b */
    private static int m8561b(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length - 1];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length - 1);
        CRC16.m8528a();
        return CRC16.m8527a(bArr2);
    }

    /* renamed from: a */
    public final synchronized void m8563a(byte[] bArr) {
        this.f9592h.lock();
        if (this.f9590f) {
            m8559c(bArr);
            return;
        }
        byte[] bArr2 = new byte[this.f9591g.length + bArr.length];
        SocketTools.m8516a(bArr, bArr2, SocketTools.m8516a(this.f9591g, bArr2, 0) + 0);
        this.f9591g = bArr2;
        MLog.m8522a("XRR", "---开始拼包:" + SocketTools.m8518a(this.f9591g));
        m8559c(this.f9591g);
    }

    /* renamed from: c */
    private void m8559c(byte[] bArr) {
        int m8519a = SocketTools.m8519a(bArr[0]);
        if (m8519a != 128 && m8519a != 1) {
            MLog.m8522a("XEE", "***不支持的协议版本*：".concat(String.valueOf(m8519a)));
            this.f9592h.unlock();
        } else if (bArr.length < 3) {
            this.f9591g = bArr;
            this.f9590f = false;
            MLog.m8522a("XRR", "发送的字节长度小于4个");
            this.f9592h.unlock();
        } else {
            int m8517a = SocketTools.m8517a(bArr, 1) + 3;
            if (m8517a <= bArr.length) {
                if (m8517a != bArr.length) {
                    byte[] bArr2 = new byte[m8517a];
                    System.arraycopy(bArr, 0, bArr2, 0, m8517a);
                    m8557d(bArr2);
                    int length = bArr.length - m8517a;
                    byte[] bArr3 = new byte[length];
                    System.arraycopy(bArr, m8517a, bArr3, 0, length);
                    m8559c(bArr3);
                    MLog.m8522a("XRR", "---1个以上的包数据*");
                    return;
                }
                m8557d(bArr);
                this.f9590f = true;
                this.f9592h.unlock();
                return;
            }
            this.f9591g = bArr;
            this.f9590f = false;
            MLog.m8522a("XRR", "不是一个完整的包，开始等待拼包:" + SocketTools.m8518a(this.f9591g));
            this.f9592h.unlock();
        }
    }

    /* renamed from: d */
    private void m8557d(byte[] bArr) {
        BaseRemoteBusinessPackage m8589a = BaseRemoteBusinessPackage.m8589a(bArr);
        if (m8589a == null) {
            MLog.m8522a("XRR", "收到的数据格式错误");
            return;
        }
        if (m8561b(bArr) != m8589a.m8591a()) {
            MLog.m8522a("XRR", "校验错误：" + SocketTools.m8518a(bArr));
            MLog.m8522a("XRR", "我方校验" + m8561b(bArr) + " 对方校验" + m8589a.m8591a());
        }
        int m8587b = m8589a.m8587b();
        if (m8587b == 12) {
            MLog.m8522a("XRR", "收到中转下发通知中转下发通知:" + SocketTools.m8518a(m8589a.m8584d()));
            this.f9589e.m8605a(140, m8589a.m8585c());
        } else if (m8587b == 132) {
            if (m8565a(m8589a.m8585c())) {
                m8564a(this.f9587c);
            }
        } else if (m8587b != 135) {
            switch (m8587b) {
                case 3:
                    MLog.m8522a("XRR", "~~~配对结果~~~:" + m8589a.f9565o + " 计数器:" + m8589a.m8585c());
                    if (m8589a.f9565o == 1 || m8589a.f9565o == 14) {
                        m8558d(UIMsg.k_event.V_WM_DBCLICK);
                    } else {
                        m8558d(PdfAction.SUBMIT_EMBED_FORM);
                    }
                    this.f9589e.m8605a(131, m8589a.m8585c());
                    if (this.f9589e.f9547c) {
                        m8560c(25090);
                        return;
                    }
                    return;
                case 4:
                    byte[] m8556e = m8556e(m8589a.m8584d());
                    if (m8556e != null) {
                        if (this.f9589e.f9548d != null) {
                            System.arraycopy(m8556e, 1, new byte[m8556e.length - 1], 0, m8556e.length - 1);
                        } else {
                            try {
                                JSONObject jSONObject = new JSONObject(new String(m8556e, 1, m8556e.length - 1, "utf-8"));
                                MLog.m8521b("XRR", "~~~~~~~~对方远程数据传输 json:".concat(String.valueOf(jSONObject)));
                                FeedbackDiagControler.m8576a().m8575a(jSONObject);
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    if (this.f9589e.f9548d == null) {
                        this.f9589e.m8605a(132, m8589a.m8585c());
                        return;
                    }
                    return;
                case 5:
                    MLog.m8522a("XRR", "~~~收到结束远程诊断~~~:" + m8589a.f9565o);
                    this.f9589e.mo8505a(false, false, m8589a.m8585c());
                    m8560c(12298);
                    return;
                case 6:
                    MLog.m8522a("XRR", "~~~异常通知~~~:" + m8589a.f9565o);
                    this.f9589e.m8605a(134, m8589a.m8585c());
                    m8562b(m8589a.f9565o);
                    return;
                case 7:
                    int m8519a = SocketTools.m8519a(m8589a.m8584d()[0]);
                    switch (m8519a) {
                        case 7:
                            try {
                                JSONObject jSONObject2 = new JSONObject(new String(m8589a.m8584d(), 1, m8589a.m8584d().length - 1, "utf-8"));
                                MLog.m8522a("XRR", "透传命令: 计数器:" + m8589a.m8585c() + "json:" + jSONObject2);
                                if (jSONObject2.has("name")) {
                                    TechnicianInfo.f9632c = jSONObject2.getString("name");
                                }
                                if (jSONObject2.has("id")) {
                                    TechnicianInfo.f9630a = jSONObject2.getString("id");
                                }
                                if (jSONObject2.has("mobile")) {
                                    TechnicianInfo.f9631b = jSONObject2.getString("mobile");
                                }
                                if (jSONObject2.has("isWebTech")) {
                                    TechnicianInfo.f9634e = true;
                                }
                                if (RemoteConstants.f9649a != 1) {
                                    m8558d(8197);
                                    break;
                                } else {
                                    m8560c(25089);
                                    break;
                                }
                            } catch (UnsupportedEncodingException e3) {
                                MLog.m8522a("XRR", "透传命令错误:" + e3.toString());
                                e3.printStackTrace();
                                break;
                            } catch (JSONException e4) {
                                MLog.m8522a("XRR", "透传命令错误:" + e4.toString());
                                e4.printStackTrace();
                                break;
                            }
                        case 14:
                            try {
                                JSONObject jSONObject3 = new JSONObject(new String(m8589a.m8584d(), 1, m8589a.m8584d().length - 1, "utf-8"));
                                MLog.m8522a("XRR", "透传技师建议: 计数器:" + m8589a.m8585c() + "json:" + jSONObject3);
                                if (jSONObject3.has("reportText")) {
                                    TechnicianInfo.f9633d = jSONObject3.getString("reportText");
                                    break;
                                }
                            } catch (UnsupportedEncodingException e5) {
                                e5.printStackTrace();
                                break;
                            } catch (JSONException e6) {
                                e6.printStackTrace();
                                break;
                            }
                            break;
                    }
                    this.f9589e.m8606a(m8589a.m8585c(), m8589a.m8584d()[0]);
                    if (m8519a == 7) {
                        this.f9589e.m8596c();
                        this.f9589e.m8594j();
                        return;
                    }
                    return;
                default:
                    switch (m8587b) {
                        case 128:
                            if (m8565a(m8589a.m8585c())) {
                                if (this.f9589e.f9547c || this.f9589e.m8595d()) {
                                    m8564a(this.f9587c);
                                    return;
                                } else {
                                    this.f9589e.m8599b();
                                    return;
                                }
                            }
                            return;
                        case 129:
                            MLog.m8522a("XRR", "****技师端建立连接响应***:" + m8589a.f9565o);
                            if (m8565a(m8589a.m8585c())) {
                                this.f9589e.m8599b();
                                if (m8589a.f9565o == 1) {
                                    m8560c(12294);
                                    m8558d(UIMsg.k_event.V_WM_GETLASTCLRSATETIME);
                                    return;
                                }
                                m8560c(12295);
                                m8562b(m8589a.f9565o);
                                return;
                            }
                            return;
                        case 130:
                            if (m8565a(m8589a.m8585c())) {
                                this.f9589e.m8599b();
                                if (m8589a.f9565o == 1) {
                                    MLog.m8522a("XRR", "****登录远程服务器成功***");
                                    m8560c(12294);
                                    m8558d(UIMsg.k_event.V_WM_GETLASTCLRSATETIME);
                                    return;
                                }
                                m8560c(12295);
                                m8562b(m8589a.f9565o);
                                return;
                            }
                            return;
                        default:
                            MLog.m8522a("XRR", "***不支持的返回业务ID***：" + Integer.toHexString(m8589a.m8587b()));
                            return;
                    }
            }
        } else {
            MLog.m8522a("XRR", "~~~收到透传命令应答~~~:" + m8589a.f9565o);
            if (m8565a(m8589a.m8585c())) {
                m8564a(this.f9587c);
            }
        }
    }

    /* renamed from: e */
    private synchronized byte[] m8556e(byte[] bArr) {
        if (bArr[0] != 0 || this.f9593i) {
            if (bArr[0] == 1 && !this.f9593i) {
                this.f9593i = true;
                this.f9594j = bArr;
            } else if (bArr[0] == 1) {
                m8555f(bArr);
            } else if (bArr[0] == 0) {
                m8555f(bArr);
                this.f9593i = false;
                return this.f9594j;
            }
            return null;
        }
        return bArr;
    }

    /* renamed from: f */
    private void m8555f(byte[] bArr) {
        byte[] bArr2 = this.f9594j;
        byte[] bArr3 = new byte[(bArr2.length + bArr.length) - 1];
        System.arraycopy(bArr, 1, bArr3, SocketTools.m8516a(bArr2, bArr3, 0) + 0, bArr.length - 1);
        this.f9594j = bArr3;
    }

    /* renamed from: a */
    private void m8564a(IoSession ioSession) {
        IdleSendCheckerInface idleSendCheckerInface = this.f9588d;
        if (idleSendCheckerInface != null) {
            idleSendCheckerInface.mo8540a(ioSession);
        }
    }

    /* renamed from: a */
    private boolean m8565a(int i) {
        MLog.m8521b("XRR", "我方的计数器:" + this.f9588d.mo8542a() + " 服务器返回的计数器:" + i);
        IdleSendCheckerInface idleSendCheckerInface = this.f9588d;
        return idleSendCheckerInface != null && idleSendCheckerInface.mo8542a() == i;
    }

    /* renamed from: b */
    private void m8562b(int i) {
        switch (i) {
            case 1:
                return;
            case 2:
                return;
            case 3:
                return;
            case 4:
                return;
            case 5:
                return;
            case 6:
                return;
            case 7:
                return;
            case 8:
                return;
            case 9:
                return;
            case 10:
                return;
            case 11:
                return;
            case 12:
                return;
            case 13:
                m8560c(12304);
                return;
            case 14:
                return;
            case 15:
            default:
                return;
            case 16:
                return;
            case 17:
                return;
            case 18:
                return;
            case 19:
                return;
            case 20:
                return;
            case 21:
                return;
            case 22:
                m8560c(12304);
                return;
        }
    }

    /* renamed from: c */
    private void m8560c(int i) {
        Handler handler = this.f9585a;
        if (handler != null) {
            handler.sendEmptyMessage(i);
        }
    }

    /* renamed from: d */
    private void m8558d(int i) {
        Handler handler = this.f9586b;
        if (handler != null) {
            handler.sendEmptyMessage(i);
        }
    }
}
