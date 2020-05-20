package com.cnlaunch.x431pro.module.golo.p262a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.p120d.p121a.KeyConstant;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p125c.p128c.C1426i;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.module.golo.model.AppraiseImageInfo;
import com.cnlaunch.x431pro.module.golo.model.AppraiseJsonInfo;
import com.cnlaunch.x431pro.module.golo.model.GoloAppraiseAllData;
import com.cnlaunch.x431pro.module.golo.model.GoloAppraiseResponse;
import com.cnlaunch.x431pro.module.golo.model.GoloRemoteOrderResponse;
import com.cnlaunch.x431pro.module.golo.model.MineCarInfoResponse;
import com.cnlaunch.x431pro.module.golo.model.RemoteSendResponse;
import com.cnlaunch.x431pro.module.p241a.BaseAction;
import com.itextpdf.text.html.HtmlTags;
import com.mopub.common.AdType;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.x431pro.module.golo.a.c */
/* loaded from: classes.dex */
public final class GoloAction extends BaseAction {
    public GoloAction(Context context) {
        super(context);
    }

    /* renamed from: a */
    public final MineCarInfoResponse m5318a(String str) throws C1425f {
        String b = m5451b(KeyConstant.f6796W);
        this.f15440b = m5452b();
        this.f15440b.m9506a("serial_no", str);
        String m9477a = this.f15446f.m9477a(m5455a(b, this.f15440b), this.f15440b);
        if (m9477a != null) {
            return (MineCarInfoResponse) m5438a(m9477a, MineCarInfoResponse.class);
        }
        return null;
    }

    /* renamed from: a */
    public final RemoteSendResponse m5317a(String str, String str2) throws C1425f {
        String b = m5451b(KeyConstant.f6803aC);
        this.f15440b = m5452b();
        this.f15440b.m9506a("pub_id", str);
        this.f15440b.m9506a("diag_id", str2);
        this.f15440b.m9506a("lan", LangManager.m9469a());
        String m9475b = this.f15446f.m9475b(m5455a(b, this.f15440b), this.f15440b);
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        return (RemoteSendResponse) m5438a(m9475b, RemoteSendResponse.class);
    }

    /* renamed from: b */
    public final RemoteSendResponse m5316b(String str, String str2) throws C1425f {
        String b = m5451b(KeyConstant.f6813aM);
        this.f15440b = m5452b();
        this.f15440b.m9506a("pub_id", str);
        this.f15440b.m9506a("diag_id", str2);
        String m9475b = this.f15446f.m9475b(m5455a(b, this.f15440b), this.f15440b);
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        return (RemoteSendResponse) m5438a(m9475b, RemoteSendResponse.class);
    }

    /* renamed from: c */
    public final RemoteSendResponse m5315c(String str, String str2) throws C1425f {
        String b = m5451b(KeyConstant.f6815aO);
        this.f15440b = m5452b();
        this.f15440b.m9506a("pub_id", str);
        this.f15440b.m9506a("diag_id", str2);
        String m9475b = this.f15446f.m9475b(m5455a(b, this.f15440b), this.f15440b);
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        return (RemoteSendResponse) m5438a(m9475b, RemoteSendResponse.class);
    }

    /* renamed from: d */
    public final RemoteSendResponse m5314d(String str, String str2) throws C1425f {
        String b = m5451b(KeyConstant.f6814aN);
        this.f15440b = m5452b();
        this.f15440b.m9506a("pub_id", str);
        this.f15440b.m9506a("diag_id", str2);
        String m9475b = this.f15446f.m9475b(m5455a(b, this.f15440b), this.f15440b);
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        return (RemoteSendResponse) m5438a(m9475b, RemoteSendResponse.class);
    }

    /* renamed from: g */
    public final GoloAppraiseAllData m5313g(String str) throws C1425f {
        JSONArray jSONArray;
        String b = m5451b(KeyConstant.f6817aQ);
        C1426i b2 = m5452b();
        b2.m9506a("id", str);
        String m9475b = this.f15446f.m9475b(m5455a(b, b2), b2);
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        GoloAppraiseAllData goloAppraiseAllData = new GoloAppraiseAllData();
        goloAppraiseAllData.setResponse((GoloAppraiseResponse) m5438a(m9475b, GoloAppraiseResponse.class));
        try {
            jSONArray = new JSONObject(m9475b).getJSONArray(DataPacketExtension.ELEMENT_NAME);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Sanda", "Error[1101]:" + e.toString());
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            JSONObject jSONObject = jSONArray.getJSONObject(0);
            String string = jSONObject.getString(HtmlTags.IMG);
            String string2 = jSONObject.getString(AdType.STATIC_NATIVE);
            NLog.m9452b("Sanda", "imgString:" + string + "|jsonString=" + string2);
            if (string.startsWith("[") && string.endsWith("]")) {
                goloAppraiseAllData.setImg(null);
            } else {
                goloAppraiseAllData.setImg((AppraiseImageInfo) m5438a(string, AppraiseImageInfo.class));
            }
            if (string2.startsWith("[") && string2.endsWith("]")) {
                goloAppraiseAllData.setJson(null);
            } else {
                goloAppraiseAllData.setJson((AppraiseJsonInfo) m5438a(string2, AppraiseJsonInfo.class));
            }
            return goloAppraiseAllData;
        }
        return null;
    }

    /* renamed from: h */
    public final GoloRemoteOrderResponse m5312h(String str) throws C1425f {
        String b = m5451b("diagnose_service.get_list_by_tech");
        Log.i("Sanda", "tech_id=".concat(String.valueOf(str)));
        C1426i b2 = m5452b();
        b2.m9506a("tech_id", str);
        String m9477a = this.f15446f.m9477a(m5455a(b, b2), b2);
        Log.d("Sanda", "diagnose_service.get_list_by_tech=".concat(String.valueOf(m9477a)));
        if (TextUtils.isEmpty(m9477a)) {
            return null;
        }
        return (GoloRemoteOrderResponse) m5438a(m9477a, GoloRemoteOrderResponse.class);
    }

    /* renamed from: i */
    public final RemoteSendResponse m5311i(String str) throws C1425f {
        String b = m5451b("diagnose_service.tech_cancel");
        this.f15440b = m5452b();
        this.f15440b.m9506a("diag_id", str);
        this.f15440b.m9506a("lan", LangManager.m9469a());
        String m9475b = this.f15446f.m9475b(m5455a(b, this.f15440b) + ("&lan=" + LangManager.m9469a()), this.f15440b);
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        return (RemoteSendResponse) m5438a(m9475b, RemoteSendResponse.class);
    }
}
