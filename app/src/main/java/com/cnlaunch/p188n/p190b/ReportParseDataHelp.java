package com.cnlaunch.p188n.p190b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import com.cnlaunch.p188n.ReportSocketControler;
import com.cnlaunch.p188n.SocketControler;
import com.cnlaunch.p188n.p189a.IdleSendCheckerInface;
import com.cnlaunch.p188n.p191c.MLog;
import com.cnlaunch.p188n.p191c.RemoteConstants;
import com.cnlaunch.p188n.p191c.ReportConstants;
import com.cnlaunch.p188n.p191c.SocketTools;
import java.io.UnsupportedEncodingException;
import org.apache.mina.core.session.IoSession;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.n.b.n */
/* loaded from: classes.dex */
public final class ReportParseDataHelp {

    /* renamed from: a */
    public static boolean f9599a = false;

    /* renamed from: b */
    public static boolean f9600b = false;

    /* renamed from: c */
    private byte[] f9601c;

    /* renamed from: d */
    private int f9602d;

    /* renamed from: e */
    private byte[] f9603e;

    /* renamed from: f */
    private Handler f9604f;

    /* renamed from: g */
    private Handler f9605g;

    /* renamed from: h */
    private IoSession f9606h;

    /* renamed from: i */
    private IdleSendCheckerInface f9607i;

    /* renamed from: l */
    private ReportSocketControler f9610l;

    /* renamed from: o */
    private byte[] f9613o;

    /* renamed from: j */
    private boolean f9608j = false;

    /* renamed from: k */
    private boolean f9609k = false;

    /* renamed from: m */
    private String f9611m = "";

    /* renamed from: n */
    private boolean f9612n = true;

    public ReportParseDataHelp(SocketControler socketControler, Handler handler, Handler handler2, IoSession ioSession, IdleSendCheckerInface idleSendCheckerInface) {
        this.f9607i = null;
        this.f9610l = (ReportSocketControler) socketControler;
        this.f9604f = handler2;
        this.f9606h = ioSession;
        this.f9607i = idleSendCheckerInface;
        this.f9605g = handler;
    }

    /* renamed from: a */
    public final synchronized void m8546a(byte[] bArr) {
        if (this.f9612n) {
            m8544b(bArr);
            return;
        }
        byte[] bArr2 = new byte[this.f9613o.length + bArr.length];
        SocketTools.m8516a(bArr, bArr2, SocketTools.m8516a(this.f9613o, bArr2, 0) + 0);
        this.f9613o = bArr2;
        MLog.m8522a("XMM", "---开始拼包:" + SocketTools.m8518a(this.f9613o));
        m8544b(this.f9613o);
    }

    /* renamed from: b */
    private void m8544b(byte[] bArr) {
        if (bArr.length < 4) {
            this.f9613o = bArr;
            this.f9612n = false;
            MLog.m8522a("XMM", "发送的字节长度小于4个");
            return;
        }
        int m8515b = (int) SocketTools.m8515b(bArr, 0);
        if (m8515b <= bArr.length) {
            m8543c(bArr);
            if (m8515b != bArr.length) {
                int length = bArr.length - m8515b;
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, m8515b, bArr2, 0, length);
                m8544b(bArr2);
                MLog.m8522a("XMM", "---1个以上的包数据*");
                return;
            }
            this.f9612n = true;
            return;
        }
        MLog.m8522a("XMM", "不是一个完整的包，开始等待拼包");
        this.f9613o = bArr;
        this.f9612n = false;
    }

    /* renamed from: c */
    private void m8543c(byte[] bArr) {
        BaseReportBusinessPackage m8579a = BaseReportBusinessPackage.m8579a(bArr);
        if (m8579a != null) {
            byte[] m8578b = m8579a.m8578b();
            if (m8578b == null) {
                m8549a(2);
            }
            int m8519a = SocketTools.m8519a(m8578b[0]);
            int m8581a = m8579a.m8581a();
            if (m8581a != 4107) {
                switch (m8581a) {
                    case 4097:
                        MLog.m8522a("XMM", "心跳返回业务ID:" + m8579a.m8581a() + "发送成功");
                        m8549a(1);
                        return;
                    case 4098:
                        if (m8578b.length != 35) {
                            MLog.m8522a("XMM", "该条数据上传失败 服务器异常");
                            m8549a(2);
                            return;
                        }
                        int m8519a2 = SocketTools.m8519a(m8578b[1]);
                        int m8519a3 = SocketTools.m8519a(m8578b[2]);
                        String str = new String(m8578b, 3, 32);
                        Handler handler = this.f9605g;
                        if (handler != null) {
                            Message obtainMessage = handler.obtainMessage(UIMsg.k_event.V_WM_GETLASTCLRSATETIME);
                            Bundle bundle = new Bundle();
                            bundle.putInt("KEEP_ALIVE_FREQUECY", m8519a2);
                            bundle.putInt("TRANSMISSION_FREQUECY", m8519a3);
                            obtainMessage.setData(bundle);
                            this.f9605g.sendMessage(obtainMessage);
                        }
                        if (m8519a == 1) {
                            m8545b(28930);
                        } else if (m8519a == 0) {
                            m8545b(28931);
                        }
                        if (m8519a != 0) {
                            m8549a(m8519a);
                        }
                        MLog.m8522a("XMM", "res = " + m8519a + " heart = " + m8519a2 + " ,tranTime =" + m8519a3 + " , token = " + str);
                        return;
                    case 4099:
                        if (m8578b.length != 6) {
                            MLog.m8522a("XMM", "该条数据上传失败 服务器异常");
                            m8549a(2);
                            return;
                        }
                        MLog.m8522a("XMM", "诊断基础信息返回:" + m8579a.m8581a() + " packID:" + ((int) m8578b[5]) + "返回");
                        m8549a(m8519a);
                        return;
                    case 4100:
                        if (m8578b.length != 6) {
                            m8549a(2);
                            return;
                        }
                        MLog.m8522a("XMM", "故障码数据流业务ID:" + m8579a.m8581a() + " packID:" + ((int) m8578b[5]) + "返回");
                        m8549a(m8519a);
                        return;
                    case 4101:
                        if (m8578b.length != 6) {
                            m8549a(2);
                            return;
                        }
                        if (m8519a == 1) {
                            if (ReportConstants.f9652a) {
                                MLog.m8522a("XMM", "CCC报告上传成功:");
                            } else {
                                MLog.m8522a("XMM", "上传成功type:" + RemoteConstants.f9649a + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f9608j + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f9609k);
                                if (!RemoteConstants.f9650b && !this.f9608j) {
                                    m8545b(28932);
                                    this.f9608j = true;
                                } else if (RemoteConstants.f9650b && !this.f9609k) {
                                    m8545b(12305);
                                    this.f9609k = true;
                                }
                            }
                        }
                        MLog.m8522a("XMM", "车辆基础信息业务ID:" + m8579a.m8581a() + " packID:" + ((int) m8578b[5]) + "返回");
                        m8549a(m8519a);
                        return;
                    case 4102:
                        MLog.m8522a("XMM", "VIN配置下发请求返回:" + m8519a + "  id:" + m8579a.m8581a() + "发送成功");
                        if (m8519a != 1) {
                            m8545b(28938);
                        }
                        m8549a(1);
                        return;
                    case 4103:
                        if (m8578b.length != 6) {
                            MLog.m8522a("XMM", "该条数据上传失败 服务器异常");
                            m8549a(2);
                            return;
                        }
                        MLog.m8522a("XMM", "IM信息返回:" + m8579a.m8581a() + " packID:" + ((int) m8578b[5]) + "返回");
                        m8549a(m8519a);
                        return;
                    default:
                        return;
                }
            }
            MLog.m8522a("XMM", "收到下发命令");
            m8548a(m8579a);
        }
    }

    /* renamed from: a */
    private void m8548a(BaseReportBusinessPackage baseReportBusinessPackage) {
        int i;
        byte[] m8578b = baseReportBusinessPackage.m8578b();
        MLog.m8522a("XMM", "收到服务器发送指令:" + SocketTools.m8518a(m8578b));
        if (m8578b == null) {
            MLog.m8522a("XMM", "服务器出错了，报告上传结束后，收到服务器发送指令为空");
            return;
        }
        if (this.f9603e == null) {
            this.f9603e = new byte[8];
            int i2 = 0;
            i = 0;
            while (true) {
                byte[] bArr = this.f9603e;
                if (i2 >= bArr.length) {
                    break;
                }
                bArr[i] = m8578b[i2];
                i2++;
                i++;
            }
        } else {
            byte[] bArr2 = new byte[8];
            int i3 = 0;
            boolean z = true;
            int i4 = 0;
            while (i3 < 8) {
                int i5 = i4 + 1;
                bArr2[i4] = m8578b[i3];
                if (this.f9603e[i3] != m8578b[i3]) {
                    z = false;
                }
                i3++;
                i4 = i5;
            }
            if (z) {
                MLog.m8522a("XMM", "相同的流水号不做处理");
                return;
            } else {
                this.f9603e = bArr2;
                i = i4;
            }
        }
        if (ReportSocketControler.m8514a() != null) {
            ReportSocketControler.m8514a().f9663c = this.f9603e;
        }
        int i6 = i + 1;
        byte b = m8578b[i];
        int length = (m8578b.length - 8) - 1;
        this.f9601c = new byte[length];
        System.arraycopy(m8578b, i6, this.f9601c, 0, length);
        MLog.m8522a("XMM", "sn:" + SocketTools.m8518a(this.f9603e) + " messageID:" + Integer.toHexString(b) + " messageData:" + SocketTools.m8518a(this.f9601c));
        this.f9602d = SocketTools.m8519a(b);
        int i7 = this.f9602d;
        switch (i7) {
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
                return;
            case 14:
                return;
            case 15:
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
                return;
            case 23:
                return;
            case 24:
                return;
            default:
                switch (i7) {
                    case 32:
                        return;
                    case 33:
                        return;
                    case 34:
                        return;
                    case 35:
                        return;
                    case 36:
                        return;
                    case 37:
                        return;
                    case 38:
                        MLog.m8522a("XMM", "收到开始远程诊断指令: 远程诊断是否准备好:" + RemoteConstants.f9651c);
                        if (RemoteConstants.f9650b) {
                            MLog.m8522a("XMM", "---远程已经结束了，不再响应---");
                            return;
                        }
                        this.f9609k = false;
                        if (RemoteConstants.f9651c) {
                            if (RemoteConstants.f9649a == 1) {
                                this.f9610l.m8513a(true);
                                return;
                            }
                            this.f9610l.m8513a(true);
                            Handler handler = this.f9604f;
                            if (handler != null) {
                                handler.sendEmptyMessage(28936);
                                return;
                            }
                            return;
                        }
                        this.f9610l.m8513a(false);
                        MLog.m8522a("XMM", "诊断软件还未远程诊断就绪 （未返回130）,不做处理");
                        return;
                    case 39:
                        return;
                    case 40:
                        return;
                    case 41:
                        return;
                    case 42:
                        return;
                    case 43:
                        return;
                    case 44:
                        try {
                            MLog.m8522a("XMM", "VIN下发数据传输 str:" + new String(this.f9601c, "utf-8") + " vinold:" + this.f9611m + " isNeed:" + f9600b);
                            JSONObject jSONObject = new JSONObject(new String(this.f9601c, "utf-8"));
                            if (jSONObject.has("vin")) {
                                if (this.f9604f != null && TextUtils.isEmpty(this.f9611m) && f9600b) {
                                    this.f9611m = jSONObject.getString("vin");
                                    Message obtain = Message.obtain();
                                    obtain.what = 28937;
                                    obtain.obj = this.f9611m;
                                    this.f9604f.sendMessage(obtain);
                                    f9600b = false;
                                }
                                this.f9610l.m8513a(true);
                                return;
                            }
                        } catch (UnsupportedEncodingException e) {
                            MLog.m8522a("XMM", "~~~VIN下发数据传输 err2" + e.toString());
                            e.printStackTrace();
                        } catch (JSONException e2) {
                            MLog.m8522a("XMM", "~~~VIN下发数据传输 err1" + e2.toString());
                            e2.printStackTrace();
                        }
                        MLog.m8522a("XMM", "~~~VIN下发数据传输 err");
                        this.f9610l.m8513a(false);
                        return;
                    case 45:
                        this.f9604f.sendEmptyMessage(28940);
                        this.f9610l.m8513a(true);
                        return;
                    case 46:
                        try {
                            this.f9604f.sendMessage(this.f9604f.obtainMessage(28941, new String(this.f9601c, "utf-8")));
                            this.f9610l.m8513a(true);
                            return;
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            this.f9610l.m8513a(false);
                            return;
                        }
                    default:
                        switch (i7) {
                            case 48:
                                Handler handler2 = this.f9604f;
                                handler2.sendMessage(handler2.obtainMessage(28942, 1, 0));
                                this.f9610l.m8513a(true);
                                return;
                            case 49:
                                Handler handler3 = this.f9604f;
                                handler3.sendMessage(handler3.obtainMessage(28942, 0, 0));
                                this.f9610l.m8513a(true);
                                return;
                            default:
                                MLog.m8522a("XMM", "不支持的命令");
                                return;
                        }
                }
        }
    }

    /* renamed from: a */
    private void m8547a(IoSession ioSession) {
        IdleSendCheckerInface idleSendCheckerInface = this.f9607i;
        if (idleSendCheckerInface != null) {
            idleSendCheckerInface.mo8540a(ioSession);
        }
    }

    /* renamed from: a */
    private void m8549a(int i) {
        switch (i) {
            case 1:
                MLog.m8522a("XMM", "该条数据上传成功");
                m8547a(this.f9606h);
                return;
            case 2:
                MLog.m8522a("XMM", "该条数据上传失败 服务器异常 重新连接服务器");
                this.f9610l.mo8505a(true, false, 0);
                return;
            default:
                MLog.m8522a("XMM", "该条数据服务器解析数据异常，只能抛弃，发送下一条");
                m8547a(this.f9606h);
                return;
        }
    }

    /* renamed from: b */
    private void m8545b(int i) {
        Handler handler = this.f9604f;
        if (handler != null) {
            handler.sendEmptyMessage(i);
        }
    }
}
