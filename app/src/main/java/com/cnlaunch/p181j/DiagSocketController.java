package com.cnlaunch.p181j;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.cnlaunch.diagnosemodule.DiagnoseBusiness;
import com.cnlaunch.diagnosemodule.utils.VersionCompatibileTool;
import com.cnlaunch.p120d.p130d.NLog;
import com.itextpdf.text.Annotation;
import com.launch.rcu.socket.SocketCall;
import java.io.UnsupportedEncodingException;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.j.v */
/* loaded from: classes.dex */
public final class DiagSocketController {

    /* renamed from: g */
    public static DiagSocketController f9467g;

    /* renamed from: a */
    public Context f9468a = null;

    /* renamed from: b */
    public int f9469b = 0;

    /* renamed from: c */
    public int f9470c = 3;

    /* renamed from: d */
    public boolean f9471d = false;

    /* renamed from: e */
    public Messenger f9472e = null;

    /* renamed from: f */
    public SocketDataAdapter f9473f = null;

    /* renamed from: h */
    public boolean f9474h = false;

    /* renamed from: k */
    private long f9477k = 0;

    /* renamed from: i */
    public RemoteClickListener f9475i = null;

    /* renamed from: j */
    public RemoteSetValueListener f9476j = null;

    /* renamed from: a */
    public static DiagSocketController m8651a() {
        if (f9467g == null) {
            f9467g = new DiagSocketController();
        }
        return f9467g;
    }

    /* renamed from: a */
    public final void m8649a(String str) {
        if (this.f9470c < 3) {
            try {
                str = VersionCompatibileTool.compatibleSendData(str, this.f9469b);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        NLog.m9452b("GOLOX", "socket send:".concat(String.valueOf(str)));
        if (this.f9471d) {
            Message obtain = Message.obtain((Handler) null, 107);
            Bundle bundle = new Bundle();
            bundle.putString("sendData", str);
            obtain.setData(bundle);
            try {
                this.f9472e.send(obtain);
                return;
            } catch (RemoteException e3) {
                e3.printStackTrace();
                return;
            }
        }
        SocketCall.getInstance().sendRemoteData(str, 1);
    }

    /* renamed from: b */
    public final synchronized void m8647b(String str) {
        if (this.f9470c < 3) {
            try {
                str = VersionCompatibileTool.compatibleReciveData(str, this.f9469b);
            } catch (Exception e) {
                Log.e("Sanda", "receiveData:" + e.toString());
                e.printStackTrace();
            }
        }
        NLog.m9451c("GOLOX", "socket receive:".concat(String.valueOf(str)));
        SocketDataFilter.f9422a = "";
        if (this.f9473f != null && !this.f9474h) {
            this.f9473f.mo8676a(str);
        }
    }

    /* renamed from: a */
    public final void m8648a(String str, JSONObject jSONObject) {
        try {
            if (str.equalsIgnoreCase("back")) {
                DiagnoseBusiness.getInstance(this.f9468a).backToPreviousLevel();
            } else if (str.equalsIgnoreCase("switch_page")) {
                if (this.f9475i != null) {
                    this.f9475i.switchPage(jSONObject.getString("page_type"), str, jSONObject.getInt(Annotation.PAGE));
                }
            } else if (str.equalsIgnoreCase("config_datastream")) {
                if (this.f9475i != null) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(DataPacketExtension.ELEMENT_NAME);
                    if (this.f9469b == 0) {
                        this.f9475i.initDataStreamConifg(jSONObject2.toString(), jSONObject.getInt("page_num"));
                    } else {
                        this.f9475i.initDataStreamConifg(jSONObject2.toString(), 0);
                    }
                }
            } else if (str.equalsIgnoreCase("scroll_page")) {
                if (this.f9475i != null) {
                    this.f9475i.onScrollPage(jSONObject.getInt("position"));
                } else {
                    Log.i("XEE", "remoteClick == null");
                }
            } else if (str.equalsIgnoreCase("vehicle_info")) {
                if (this.f9475i != null) {
                    this.f9475i.initVehicleInfo(jSONObject);
                }
            } else {
                if (str.equalsIgnoreCase("remote_start_downloading")) {
                    if (this.f9475i != null) {
                        this.f9475i.remoteOtherMessage("remote_start_downloading", -1);
                    }
                } else if (str.equalsIgnoreCase("remote_download_finished")) {
                    if (this.f9475i != null) {
                        this.f9475i.remoteOtherMessage("remote_download_finished", -1);
                    }
                } else if (str.equalsIgnoreCase("remote_download_failed")) {
                    if (this.f9475i != null) {
                        this.f9475i.remoteOtherMessage("remote_download_failed", -1);
                    }
                } else if (str.equalsIgnoreCase("remote_downloading")) {
                    if (this.f9475i != null) {
                        this.f9475i.remoteOtherMessage("remote_downloading", jSONObject.has("progress") ? jSONObject.getInt("progress") : -1);
                    }
                } else if (str.equalsIgnoreCase("remote_download_finished_confirm")) {
                    if (this.f9475i != null) {
                        this.f9475i.remoteOtherMessage("remote_download_finished_confirm", -1);
                    }
                } else if (str.equalsIgnoreCase("remote_download_cancel")) {
                    if (this.f9475i != null) {
                        this.f9475i.remoteOtherMessage("remote_download_cancel", -1);
                    }
                } else if (this.f9475i != null) {
                    this.f9475i.onClick(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Sanda", "dealSpecialCMD error:" + e.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x01c3, code lost:
        r7 = new org.json.JSONObject(r1);
        r7.put("remote_data_type", "feedback_normal");
        m8649a(r7.toString());
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m8650a(android.os.Message r7) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.p181j.DiagSocketController.m8650a(android.os.Message):boolean");
    }

    /* renamed from: c */
    public final void m8646c(String str) {
        RemoteSetValueListener remoteSetValueListener = this.f9476j;
        if (remoteSetValueListener != null) {
            remoteSetValueListener.setRemoteMessage(str);
        }
    }
}
