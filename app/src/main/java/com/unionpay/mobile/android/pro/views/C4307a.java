package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.itextpdf.text.pdf.ByteBuffer;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.hce.BinderC4152b;
import com.unionpay.mobile.android.hce.C4151a;
import com.unionpay.mobile.android.hce.C4153c;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.model.C4177f;
import com.unionpay.mobile.android.model.InterfaceC4175d;
import com.unionpay.mobile.android.model.InterfaceC4176e;
import com.unionpay.mobile.android.nocard.utils.C4186b;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.nocard.views.AbstractC4219b;
import com.unionpay.mobile.android.pboctransaction.C4264e;
import com.unionpay.mobile.android.pro.pboc.engine.C4298b;
import com.unionpay.mobile.android.upviews.C4343a;
import com.unionpay.mobile.android.utils.C4382c;
import com.unionpay.mobile.android.utils.C4386g;
import com.unionpay.mobile.android.utils.C4388i;
import com.unionpay.mobile.android.utils.C4389j;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.mobile.android.utils.C4394o;
import com.unionpay.mobile.android.widgets.AbstractC4486z;
import com.unionpay.mobile.android.widgets.C4449ay;
import com.unionpay.tsmservice.data.Constant;
import com.unionpay.tsmservice.data.ResultCode;
import com.unionpay.uppay.PayActivity;
import java.security.MessageDigest;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.pro.views.a */
/* loaded from: classes2.dex */
public final class C4307a extends AbstractC4219b implements Handler.Callback, C4343a.InterfaceC4345b {

    /* renamed from: M */
    private static Date f22890M = new Date(System.currentTimeMillis());

    /* renamed from: N */
    private static String f22891N = new SimpleDateFormat("yyyyMMddhhmmss").format((java.util.Date) f22890M);

    /* renamed from: P */
    private static HashMap<String, String> f22892P = new HashMap<>();

    /* renamed from: Q */
    private static HashMap<String, String> f22893Q = new HashMap<>();

    /* renamed from: A */
    private C4449ay f22894A;

    /* renamed from: B */
    private String f22895B;

    /* renamed from: C */
    private C4153c f22896C;

    /* renamed from: D */
    private int f22897D;

    /* renamed from: E */
    private String f22898E;

    /* renamed from: F */
    private boolean f22899F;

    /* renamed from: G */
    private Handler.Callback f22900G;

    /* renamed from: H */
    private Handler f22901H;

    /* renamed from: I */
    private View.OnClickListener f22902I;

    /* renamed from: J */
    private View.OnClickListener f22903J;

    /* renamed from: K */
    private View.OnClickListener f22904K;

    /* renamed from: L */
    private View.OnClickListener f22905L;

    /* renamed from: O */
    private String f22906O;

    /* renamed from: r */
    public String f22907r;

    /* renamed from: s */
    UPPayEngine f22908s;

    /* renamed from: t */
    private int f22909t;

    /* renamed from: u */
    private int f22910u;

    /* renamed from: v */
    private TextView f22911v;

    /* renamed from: w */
    private boolean f22912w;

    /* renamed from: x */
    private C4343a f22913x;

    /* renamed from: y */
    private C4343a f22914y;

    /* renamed from: z */
    private Handler f22915z;

    public C4307a(Context context, InterfaceC4176e interfaceC4176e, UPPayEngine uPPayEngine) {
        super(context, interfaceC4176e);
        this.f22909t = 20;
        this.f22910u = 100;
        this.f22907r = "1.9";
        this.f22911v = null;
        this.f22912w = false;
        this.f22913x = null;
        this.f22914y = null;
        this.f22915z = null;
        this.f22897D = 5;
        this.f22899F = false;
        this.f22900G = new C4315b(this);
        this.f22901H = new Handler(this.f22900G);
        this.f22902I = new View$OnClickListenerC4316c(this);
        this.f22903J = new View$OnClickListenerC4317d(this);
        this.f22904K = new View$OnClickListenerC4318e(this);
        this.f22905L = new View$OnClickListenerC4319f(this);
        this.f22906O = null;
        this.f22595f = 6;
        this.f22606q = "hcepay";
        this.f22908s = uPPayEngine;
        this.f22915z = new Handler(this);
        this.f22896C = (C4153c) C4173b.f22370bb.get(this.f22590a.f22453bc);
        this.f22912w = this.f22590a.f22385K;
        setBackgroundColor(-1052684);
        m1410e();
    }

    /* renamed from: a */
    private void m1204a(LinearLayout linearLayout) {
        C4343a c4343a = this.f22914y;
        AbstractC4486z m1019c = c4343a != null ? c4343a.m1019c("instalment") : null;
        int length = this.f22590a.f22490z.length();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < length; i++) {
            Object m845b = C4389j.m845b(this.f22590a.f22490z, i);
            if (m845b != null) {
                try {
                    JSONObject jSONObject = (JSONObject) m845b;
                    if (Constant.KEY_PAN.equals(C4389j.m846a(jSONObject, VastExtensionXmlManager.TYPE))) {
                        jSONObject.put("label", this.f22896C.mo1537b() + this.f22896C.mo1536c());
                    }
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        this.f22913x = new C4343a(this.f22593d, jSONArray, this.f22594e.m1508c(), this, this.f22896C.mo1538a(), true, false, m1019c, this.f22590a.f22429ad, this.f22606q);
        linearLayout.addView(this.f22913x, new LinearLayout.LayoutParams(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m1201a(C4307a c4307a, String str, String str2) {
        c4307a.f22910u = 8;
        c4307a.f22591b.m635a(C4171c.f22227bD.f22248U);
        c4307a.f22594e.m1506c(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m1200a(C4307a c4307a, String str, HashMap hashMap) {
        Object mo476a = ((PayActivity) c4307a.f22593d).mo476a(C4298b.class.toString());
        if ((mo476a != null ? (C4298b) mo476a : null) == null) {
            c4307a.mo1137b(5);
        } else {
            new Thread(new RunnableC4320g(c4307a, str, hashMap)).start();
        }
    }

    /* renamed from: a */
    private static void m1198a(StringBuffer stringBuffer) {
        for (String str : f22892P.keySet()) {
            String str2 = f22892P.get(str);
            if (!TextUtils.isEmpty(str2)) {
                String m1301a = C4264e.m1301a(new byte[]{(byte) (str2.length() / 2)}, 1);
                stringBuffer.append(str);
                stringBuffer.append(m1301a);
                stringBuffer.append(str2);
            }
        }
    }

    /* renamed from: b */
    private boolean m1193b(HashMap<String, String> hashMap) {
        String substring = f22891N.substring(2, 8);
        long time = new Date(System.currentTimeMillis()).getTime();
        String valueOf = String.valueOf(time);
        String format = valueOf.length() < 8 ? String.format("%08d", Long.valueOf(time)) : valueOf.substring(valueOf.length() - 8, valueOf.length());
        f22892P.put("9F26", "");
        f22892P.put("9F27", DiagnoseConstants.FEEDBACK_SPT_VERYDY_MAINTENANCE);
        f22892P.put("9F10", "");
        f22892P.put("9F37", format);
        f22892P.put("9F36", "");
        f22892P.put("95", "0000000800");
        f22892P.put("9A", substring);
        f22892P.put("9C", "45");
        f22892P.put("9F02", Constant.DEFAULT_BALANCE);
        f22892P.put("5F2A", "0156");
        f22892P.put(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, "");
        f22892P.put("9F1A", "0156");
        f22892P.put("9F03", Constant.DEFAULT_BALANCE);
        f22892P.put("9F33", "A04000");
        f22892P.put("9F34", "420300");
        f22892P.put("9F35", DiagnoseConstants.FEEDBACK_DATASTREAM_PAGE);
        f22892P.put("9F1E", "3030303030303030");
        f22892P.put(DiagnoseConstants.FEEDBACK_SPT_MULTI_INPUT_COMB_WINDOW, "");
        f22892P.put("9F09", "0001");
        f22892P.put("9F41", "");
        f22892P.put(DiagnoseConstants.FEEDBACK_SPT_GET_NEW_VEHICLE_DATA, "");
        f22892P.put(DiagnoseConstants.FEEDBACK_TROUBLE_CODE_ID_EX_RETURN_VALUE, "");
        f22892P.put(DiagnoseConstants.FEEDBACK_DIAG_CALL_SERVICE_ALGORITHM_BASE, "");
        f22892P.put("DF31", "");
        f22892P.put("9F74", "");
        f22892P.put("9F63", "");
        f22892P.put("8A", "");
        f22893Q.put("9F66", "26C00000");
        m1165t();
        f22892P.put("9F02", hashMap.get("trans_amt"));
        f22892P.put("9F1A", "0156");
        f22892P.put("5F2A", hashMap.get("trans currcy code"));
        f22892P.put("9C", hashMap.get("trans_type"));
        f22893Q.put("CUR", f22892P.get("5F2A"));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("9F66", f22893Q.get("9F66"));
            jSONObject.put("9F02", f22892P.get("9F02"));
            jSONObject.put("9F03", f22892P.get("9F03"));
            jSONObject.put("9F1A", f22892P.get("9F1A"));
            jSONObject.put("95", f22892P.get("95"));
            jSONObject.put("5F2A", f22892P.get("5F2A"));
            jSONObject.put("9A", f22892P.get("9A"));
            jSONObject.put("9C", f22892P.get("9C"));
            jSONObject.put("9F37", f22892P.get("9F37"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String m1604f = this.f22896C.m1604f();
        try {
            this.f22896C.m1603g().mo1550a(C4151a.m1605b(this.f22896C.mo1538a(), m1604f), C4151a.m1605b(jSONObject.toString(), m1604f), "", new BinderC4152b(UIMsg.m_AppUI.MSG_APP_VERSION, "", this.f22901H));
            this.f22901H.sendMessageDelayed(this.f22901H.obtainMessage(UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND), this.f22590a.f22455be);
            return true;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            mo1138a(this.f22590a.f22441ap, false);
            return false;
        }
    }

    /* renamed from: d */
    private static final String m1188d(String str) {
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            return C4264e.m1302a(messageDigest.digest());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: d */
    private static String m1187d(String str, String str2) {
        byte[] m1305a = C4264e.m1305a(str);
        byte[] m1305a2 = C4264e.m1305a(str2);
        for (int i = 0; i < m1305a.length; i++) {
            m1305a[i] = (byte) (m1305a[i] ^ m1305a2[i]);
        }
        return C4264e.m1302a(m1305a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static /* synthetic */ boolean m1186d(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String m846a = C4389j.m846a(jSONObject, next);
            if (!TextUtils.isEmpty(m846a)) {
                (("5F34".equals(next) || "57".equals(next) || "9F6C".equals(next) || "9F5D".equals(next) || "5F20".equals(next)) ? f22893Q : f22892P).put(next, m846a);
            }
        }
        String str = f22892P.get("9F10");
        return TextUtils.isEmpty(str) || ((byte) (C4264e.m1305a(str)[4] & ByteBuffer.ZERO)) == 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m1183e(String str, String str2) {
        this.f22910u = 9;
        if (TextUtils.isEmpty(str2)) {
            this.f22594e.m1506c(str, "");
        } else {
            this.f22594e.m1513a(str, "\"uuid\":\"" + str2 + "\"", 10);
        }
        this.f22897D--;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static /* synthetic */ HashMap m1182f(C4307a c4307a) {
        HashMap<String, String> hashMap = new HashMap<>();
        C4343a c4343a = c4307a.f22913x;
        if (c4343a != null) {
            hashMap = c4343a.m1021c();
        }
        C4343a c4343a2 = c4307a.f22914y;
        if (c4343a2 != null) {
            HashMap<String, String> m1021c = c4343a2.m1021c();
            if (m1021c != null && hashMap != null) {
                hashMap.putAll(m1021c);
            } else if (m1021c != null && hashMap == null) {
                return m1021c;
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public static /* synthetic */ int m1177i(C4307a c4307a) {
        c4307a.f22897D = 5;
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public static /* synthetic */ void m1170p(C4307a c4307a) {
        c4307a.f22910u = 104;
        c4307a.f22599j = false;
        c4307a.f22591b.m635a(C4171c.f22227bD.f22248U);
        C4390k.m836c("uppay", "");
        c4307a.f22594e.m1506c("cardsecret", "");
    }

    /* renamed from: s */
    private void m1167s() {
        this.f22910u = 103;
        this.f22594e.m1513a("query", this.f22590a.f22435aj, 3);
        this.f22909t--;
    }

    /* renamed from: t */
    private static Bundle m1165t() {
        Bundle bundle = new Bundle();
        bundle.putString("action_resp_code", "0000");
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: u */
    public static /* synthetic */ int m1163u(C4307a c4307a) {
        c4307a.f22910u = 101;
        return 101;
    }

    /* renamed from: a */
    public final synchronized Bundle m1199a(String str, HashMap<String, String> hashMap) {
        Bundle m1165t;
        m1165t = m1165t();
        f22893Q.put("PIN", str);
        f22893Q.put("AN1", this.f22896C.mo1538a());
        StringBuffer stringBuffer = new StringBuffer();
        m1198a(stringBuffer);
        f22893Q.put("DCD", stringBuffer.toString());
        this.f22895B = m1187d(this.f22590a.f22456bf, this.f22908s.m1511b());
        if (f22893Q.get("5F34") != null) {
            StringBuffer stringBuffer2 = new StringBuffer(f22893Q.get("5F34"));
            stringBuffer2.insert(0, "0");
            f22893Q.put("5F34", stringBuffer2.toString());
        } else {
            f22893Q.put("5F34", "");
        }
        if (f22893Q.get("57") != null) {
            String upperCase = f22893Q.get("57").toUpperCase();
            while (true) {
                if (!upperCase.substring(upperCase.length() - 1, upperCase.length()).equalsIgnoreCase("f") && !upperCase.substring(upperCase.length() - 1, upperCase.length()).equalsIgnoreCase("F")) {
                    break;
                }
                upperCase = upperCase.substring(0, upperCase.length() - 1);
            }
            f22893Q.put("TD2", upperCase.toString());
            int indexOf = upperCase.indexOf("D");
            String substring = upperCase.substring(0, indexOf);
            if (substring.endsWith("F") || substring.endsWith("f")) {
                substring = substring.substring(0, substring.length() - 1);
            }
            f22893Q.put("AN1", substring);
            f22893Q.put("ED", upperCase.substring(indexOf + 1, indexOf + 5));
        }
        f22893Q.put("AMT", f22892P.get("9F02"));
        String str2 = (((("pan=" + f22893Q.get("AN1")) + "&pin=" + f22893Q.get("PIN")) + "&icc_data=" + f22893Q.get("DCD")) + "&card_seq_id=" + f22893Q.get("5F34")) + "&auth_id=" + this.f22590a.f22457bg;
        C4390k.m836c(com.unionpay.tsmservice.p373mi.data.Constant.KEY_MAC, str2);
        String m1188d = m1188d(str2);
        C4390k.m836c("md5", m1188d);
        String m1498g = this.f22594e.m1498g(m1188d);
        C4390k.m836c("sig", m1498g);
        String m1514a = this.f22594e.m1514a(str2 + "&" + m1498g, this.f22895B);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("v", this.f22907r);
            jSONObject.put("cmd", "pay");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(Constant.KEY_PARAMS, jSONObject2);
            jSONObject2.put("encrypt_key_field", m1514a);
            jSONObject2.put("pay_type", "2");
            jSONObject2.put("pay_mode", "1");
            jSONObject2.put("bind", "no");
            jSONObject2.put("carrier_tp", "9");
            jSONObject2.put("carrier_app_tp", "0");
            jSONObject2.put("sign", m1498g);
            jSONObject2.put(Constant.KEY_PAN, f22893Q.get("AN1"));
            if (f22893Q.get("ED") != null) {
                jSONObject2.put("expire", f22893Q.get("ED"));
            }
            if (f22893Q.get("TD2") != null) {
                jSONObject2.put("track2_data", f22893Q.get("TD2"));
            }
            if (hashMap != null && hashMap.keySet() != null && hashMap.keySet().size() > 0) {
                hashMap.remove(Constant.KEY_PAN);
                hashMap.remove(Constant.KEY_PIN);
                for (String str3 : hashMap.keySet()) {
                    jSONObject2.put(str3, hashMap.get(str3));
                }
            }
            m1165t.putString("action_resp_message", this.f22908s.mo833a(jSONObject.toString()));
        } catch (JSONException unused) {
            m1165t.putString("action_resp_code", ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE);
            return m1165t;
        }
        return m1165t;
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: a */
    public final void mo827a(C4343a.C4344a c4344a) {
    }

    @Override // com.unionpay.mobile.android.nocard.views.InterfaceC4191a
    /* renamed from: a */
    public final void mo1077a(JSONObject jSONObject) {
        switch (this.f22910u) {
            case 8:
                m1407i();
                JSONArray m842d = C4389j.m842d(jSONObject, "options");
                C4343a c4343a = this.f22914y;
                if (c4343a != null) {
                    c4343a.m1029a(m842d);
                    return;
                }
                return;
            case 9:
                String m846a = C4389j.m846a(jSONObject, "status");
                if (m846a == null || !"01".equals(m846a)) {
                    JSONArray m842d2 = C4389j.m842d(jSONObject, "options");
                    String m846a2 = C4389j.m846a(jSONObject, "empty_info");
                    C4343a c4343a2 = this.f22914y;
                    if (c4343a2 != null) {
                        c4343a2.m1028a(m842d2, m846a2);
                        return;
                    }
                    return;
                }
                String m846a3 = C4389j.m846a(jSONObject, "uuid");
                if (this.f22897D >= 0) {
                    m1183e(this.f22898E, m846a3);
                    return;
                }
                String str = C4171c.f22227bD.f22231D;
                C4343a c4343a3 = this.f22914y;
                if (c4343a3 != null) {
                    c4343a3.m1028a((JSONArray) null, str);
                    return;
                }
                return;
            case 101:
                this.f22590a.f22435aj = C4388i.m851a(jSONObject.toString());
                String m846a4 = C4389j.m846a(jSONObject, "qn");
                if (!TextUtils.isEmpty(m846a4)) {
                    this.f22590a.f22478n = this.f22594e.m1496h(C4382c.m881b(m846a4));
                }
                if (this.f22590a.f22435aj == null || this.f22590a.f22435aj.length() <= 0) {
                    mo1137b(2);
                    return;
                }
                this.f22909t = 20;
                m1167s();
                return;
            case 103:
                String m846a5 = C4389j.m846a(jSONObject, "status");
                String m846a6 = C4389j.m846a(jSONObject, "fail_msg");
                if (this.f22909t > 0 && m846a5.equalsIgnoreCase("01")) {
                    m1167s();
                    return;
                }
                this.f22910u = 100;
                if (!m846a5.equalsIgnoreCase("00")) {
                    m1407i();
                    this.f22899F = true;
                    if (!m846a5.equalsIgnoreCase("03")) {
                        if (this.f22909t <= 0) {
                            mo1137b(19);
                            return;
                        }
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f22606q);
                    sb.append("_fail");
                    String[] strArr = C4394o.f23207j;
                    String[] strArr2 = {m846a5, m846a6};
                    m1422a(m846a6);
                    return;
                }
                m1407i();
                this.f22910u = 100;
                this.f22590a.f22382H = C4389j.m842d(jSONObject, "result");
                this.f22590a.f22390P = C4389j.m846a(jSONObject, "openupgrade_flag");
                this.f22590a.f22391Q = C4389j.m846a(jSONObject, "temporary_pay_flag");
                this.f22590a.f22392R = C4389j.m846a(jSONObject, "temporary_pay_info");
                this.f22590a.f22396V = C4389j.m846a(jSONObject, "front_url");
                this.f22590a.f22397W = C4389j.m846a(jSONObject, "front_request");
                this.f22590a.f22375A = C4389j.m846a(jSONObject, "title");
                this.f22590a.f22376B = C4389j.m846a(jSONObject, "succ_info");
                C4186b.m1482b(jSONObject, this.f22590a);
                C4186b.m1483a(jSONObject, this.f22590a);
                C4343a c4343a4 = this.f22913x;
                if (c4343a4 != null) {
                    c4343a4.m1015f();
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f22606q);
                sb2.append("_succeed");
                Iterator<InterfaceC4175d> it = C4173b.f22370bb.iterator();
                while (it.hasNext()) {
                    try {
                        this.f22593d.unbindService(((C4153c) it.next()).m1602h());
                    } catch (IllegalArgumentException unused) {
                    }
                }
                if (!this.f22590a.f22470f) {
                    m1411d(8);
                    return;
                }
                this.f22590a.f22383I.f22848f = Constant.CASH_LOAD_SUCCESS;
                m1406j();
                return;
            case 104:
                try {
                    this.f22590a.f22456bf = (String) jSONObject.get("encrypt_key");
                    this.f22590a.f22457bg = (String) jSONObject.get("auth_id");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (this.f22590a.f22480p != null) {
                    C4343a.C4344a m1035a = this.f22913x.m1035a();
                    if (m1035a.m1014a()) {
                        this.f22910u = 101;
                        m1197a(this.f22590a.f22480p);
                        return;
                    }
                    this.f22899F = true;
                    m1422a(m1035a.f23028b);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: a */
    public final void mo822a(boolean z) {
        TextView textView = this.f22911v;
        if (textView != null) {
            textView.setEnabled(!z);
        }
    }

    /* renamed from: a */
    public final boolean m1197a(HashMap<String, String> hashMap) {
        f22890M = new Date(System.currentTimeMillis());
        f22891N = new SimpleDateFormat("yyyyMMddHHmmss").format((java.util.Date) f22890M);
        this.f22906O = new String(f22891N);
        return m1193b(hashMap);
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: b */
    public final void mo1076b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        this.f22894A = new C4449ay(getContext(), C4171c.f22227bD.f22327bq, this);
        layoutParams.addRule(13, -1);
        this.f22600k.addView(this.f22894A, layoutParams);
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: b */
    public final void mo1137b(int i) {
        switch (this.f22910u) {
            case 101:
            case 103:
            case 104:
                this.f22899F = true;
                break;
        }
        super.mo1137b(i);
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: c */
    public final void mo1072c() {
        this.f22602m.removeAllViews();
        this.f22604o.m995a(this);
        LinearLayout linearLayout = new LinearLayout(this.f22593d);
        boolean z = true;
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = C4149a.f22117f;
        layoutParams.addRule(10, -1);
        this.f22602m.addView(linearLayout, layoutParams);
        JSONArray jSONArray = new JSONArray();
        if (this.f22605p != null) {
            C4177f c4177f = (C4177f) this.f22605p;
            jSONArray.put(c4177f.m1533a("promotion"));
            jSONArray.put(c4177f.m1533a("instalment"));
            this.f22590a.f22420aU = c4177f.m1533a("promotion_instalment_msgbox");
        }
        if (jSONArray.length() > 0) {
            this.f22914y = new C4343a(this.f22593d, jSONArray, this, this.f22606q);
            this.f22914y.m1033a(this.f22902I);
            this.f22914y.m1023b(this.f22903J);
            this.f22914y.m1020c(this.f22904K);
            this.f22914y.m1032a(this.f22591b, this.f22590a.f22420aU);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.bottomMargin = C4149a.f22117f;
            linearLayout.addView(this.f22914y, layoutParams2);
        }
        m1204a(linearLayout);
        new LinearLayout.LayoutParams(-1, -2);
        this.f22911v = new TextView(this.f22593d);
        this.f22911v.setText(C4389j.m846a(this.f22590a.f22377C, "label"));
        this.f22911v.setTextSize(C4150b.f22146i);
        this.f22911v.setTextColor(m1403o());
        this.f22911v.setGravity(17);
        TextView textView = this.f22911v;
        C4343a c4343a = this.f22913x;
        if (c4343a != null && !c4343a.m1016e()) {
            z = false;
        }
        textView.setEnabled(z);
        int i = C4149a.f22125n;
        this.f22911v.setBackgroundDrawable(this.f22592c.m1037a(UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE, -1, -1));
        this.f22911v.setOnClickListener(this.f22905L);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, i);
        layoutParams3.topMargin = C4149a.f22117f;
        int m858a = C4386g.m858a(this.f22593d, 10.0f);
        layoutParams3.rightMargin = m858a;
        layoutParams3.leftMargin = m858a;
        linearLayout.addView(this.f22911v, layoutParams3);
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: c */
    public final void mo821c(String str) {
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: c */
    public final void mo820c(String str, String str2) {
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message2) {
        if (message2.obj != null) {
            Bundle bundle = (Bundle) message2.obj;
            String string = bundle.getString("action_resp_code");
            String string2 = bundle.getString("action_resp_message");
            if (!"0000".equalsIgnoreCase(string)) {
                mo1138a(this.f22590a.f22441ap, false);
                return true;
            } else if (string2 != null) {
                mo1426a(0, string2);
                return true;
            } else {
                return true;
            }
        }
        return true;
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: k */
    public final void mo1056k() {
        C4343a c4343a = this.f22913x;
        if (c4343a == null || !c4343a.m1018d()) {
            if (this.f22590a.f22385K && this.f22912w) {
                this.f22590a.f22385K = false;
                m1405m();
                return;
            }
            this.f22590a.f22385K = false;
            m1428a(2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C4343a c4343a = this.f22913x;
        if (c4343a != null) {
            c4343a.m1018d();
        }
        this.f22591b = null;
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: r */
    public final void mo767r() {
    }
}
