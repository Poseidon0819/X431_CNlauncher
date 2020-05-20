package com.unionpay.mobile.android.pro.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.model.C4177f;
import com.unionpay.mobile.android.model.InterfaceC4176e;
import com.unionpay.mobile.android.nocard.utils.C4186b;
import com.unionpay.mobile.android.nocard.utils.C4190f;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.nocard.views.AbstractC4219b;
import com.unionpay.mobile.android.pboctransaction.C4264e;
import com.unionpay.mobile.android.pboctransaction.nfc.C4269a;
import com.unionpay.mobile.android.pro.pboc.engine.C4298b;
import com.unionpay.mobile.android.upviews.C4343a;
import com.unionpay.mobile.android.upwidget.C4354a;
import com.unionpay.mobile.android.upwidget.UPRadiationView;
import com.unionpay.mobile.android.utils.C4382c;
import com.unionpay.mobile.android.utils.C4386g;
import com.unionpay.mobile.android.utils.C4388i;
import com.unionpay.mobile.android.utils.C4389j;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.mobile.android.utils.C4394o;
import com.unionpay.mobile.android.widgets.C4449ay;
import com.unionpay.tsmservice.data.ResultCode;
import com.unionpay.tsmservice.p373mi.data.Constant;
import com.unionpay.uppay.PayActivity;
import java.security.MessageDigest;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.pro.views.k */
/* loaded from: classes2.dex */
public final class C4324k extends AbstractC4219b implements Handler.Callback, C4343a.InterfaceC4345b {

    /* renamed from: ac */
    private static Date f22936ac = new Date(System.currentTimeMillis());

    /* renamed from: ad */
    private static String f22937ad = new SimpleDateFormat("yyyyMMddhhmmss").format((java.util.Date) f22936ac);

    /* renamed from: A */
    private LinearLayout f22938A;

    /* renamed from: B */
    private LinearLayout f22939B;

    /* renamed from: C */
    private RelativeLayout f22940C;

    /* renamed from: D */
    private LinearLayout f22941D;

    /* renamed from: E */
    private LinearLayout f22942E;

    /* renamed from: F */
    private C4449ay f22943F;

    /* renamed from: G */
    private UPRadiationView f22944G;

    /* renamed from: H */
    private ImageView f22945H;

    /* renamed from: I */
    private String f22946I;

    /* renamed from: J */
    private String f22947J;

    /* renamed from: K */
    private C4354a f22948K;

    /* renamed from: L */
    private C4354a f22949L;

    /* renamed from: M */
    private boolean f22950M;

    /* renamed from: N */
    private boolean f22951N;

    /* renamed from: O */
    private C4343a f22952O;

    /* renamed from: P */
    private String f22953P;

    /* renamed from: Q */
    private int f22954Q;

    /* renamed from: R */
    private NfcAdapter f22955R;

    /* renamed from: S */
    private FrameLayout f22956S;

    /* renamed from: T */
    private View.OnClickListener f22957T;

    /* renamed from: U */
    private View.OnClickListener f22958U;

    /* renamed from: V */
    private View.OnClickListener f22959V;

    /* renamed from: W */
    private View.OnClickListener f22960W;

    /* renamed from: aa */
    private View.OnClickListener f22961aa;

    /* renamed from: ab */
    private View.OnClickListener f22962ab;

    /* renamed from: ae */
    private String f22963ae;

    /* renamed from: af */
    private HashMap<String, String> f22964af;

    /* renamed from: r */
    public String f22965r;

    /* renamed from: s */
    UPPayEngine f22966s;

    /* renamed from: t */
    C4269a f22967t;

    /* renamed from: u */
    private int f22968u;

    /* renamed from: v */
    private int f22969v;

    /* renamed from: w */
    private TextView f22970w;

    /* renamed from: x */
    private boolean f22971x;

    /* renamed from: y */
    private C4343a f22972y;

    /* renamed from: z */
    private Handler f22973z;

    public C4324k(Context context, InterfaceC4176e interfaceC4176e, UPPayEngine uPPayEngine) {
        super(context, interfaceC4176e);
        this.f22968u = 20;
        this.f22969v = 100;
        this.f22965r = "1.8";
        this.f22970w = null;
        this.f22971x = false;
        this.f22972y = null;
        this.f22973z = null;
        this.f22938A = null;
        this.f22939B = null;
        this.f22940C = null;
        this.f22941D = null;
        this.f22942E = null;
        this.f22948K = null;
        this.f22949L = null;
        this.f22950M = true;
        this.f22951N = false;
        this.f22952O = null;
        this.f22954Q = 5;
        this.f22957T = new View$OnClickListenerC4325l(this);
        this.f22958U = new View$OnClickListenerC4327n(this);
        this.f22959V = new View$OnClickListenerC4328o(this);
        this.f22960W = new View$OnClickListenerC4329p(this);
        this.f22961aa = new View$OnClickListenerC4330q(this);
        this.f22962ab = new View$OnClickListenerC4331r(this);
        this.f22963ae = null;
        this.f22964af = new HashMap<>();
        this.f22595f = 6;
        this.f22606q = "nfcpay";
        this.f22966s = uPPayEngine;
        this.f22973z = new Handler(this);
        this.f22971x = this.f22590a.f22385K;
        setBackgroundColor(-11495169);
        m1410e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: B */
    public static /* synthetic */ boolean m1151B(C4324k c4324k) {
        c4324k.f22950M = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m1142a(C4324k c4324k, String str, String str2) {
        c4324k.f22969v = 7;
        c4324k.f22591b.m635a(C4171c.f22227bD.f22248U);
        c4324k.f22594e.m1506c(str, str2);
    }

    /* renamed from: a */
    private void m1140a(String str, StringBuffer stringBuffer) {
        String str2 = this.f22964af.get(str);
        String m1301a = C4264e.m1301a(new byte[]{(byte) (str2.length() / 2)}, 1);
        stringBuffer.append(str);
        stringBuffer.append(m1301a);
        stringBuffer.append(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m1133b(String str, HashMap<String, String> hashMap) {
        Object mo476a = ((PayActivity) this.f22593d).mo476a(C4298b.class.toString());
        if ((mo476a != null ? (C4298b) mo476a : null) == null) {
            super.mo1137b(5);
        } else {
            new Thread(new RunnableC4332s(this, str, hashMap)).start();
        }
    }

    /* renamed from: d */
    private static final String m1127d(String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m1126d(String str, String str2) {
        this.f22969v = 8;
        if (TextUtils.isEmpty(str2)) {
            this.f22594e.m1506c(str, "");
        } else {
            this.f22594e.m1513a(str, "\"uuid\":\"" + str2 + "\"", 10);
        }
        this.f22954Q--;
    }

    /* renamed from: e */
    private static String m1123e(String str, String str2) {
        byte[] m1305a = C4264e.m1305a(str);
        byte[] m1305a2 = C4264e.m1305a(str2);
        for (int i = 0; i < m1305a.length; i++) {
            m1305a[i] = (byte) (m1305a[i] ^ m1305a2[i]);
        }
        return C4264e.m1302a(m1305a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public static /* synthetic */ int m1119i(C4324k c4324k) {
        c4324k.f22969v = 101;
        return 101;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public static /* synthetic */ int m1117k(C4324k c4324k) {
        c4324k.f22954Q = 5;
        return 5;
    }

    /* renamed from: s */
    private void m1109s() {
        this.f22969v = 103;
        this.f22594e.m1513a("query", this.f22590a.f22435aj, 3);
        this.f22968u--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public HashMap<String, String> m1107t() {
        HashMap<String, String> hashMap = new HashMap<>();
        C4343a c4343a = this.f22972y;
        if (c4343a != null) {
            hashMap = c4343a.m1021c();
        }
        C4343a c4343a2 = this.f22952O;
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

    /* renamed from: u */
    private static Bundle m1105u() {
        Bundle bundle = new Bundle();
        bundle.putString("action_resp_code", "0000");
        return bundle;
    }

    /* renamed from: v */
    private int m1103v() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.f22593d).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    /* renamed from: a */
    public final synchronized Bundle m1139a(String str, HashMap<String, String> hashMap) {
        Bundle m1105u;
        m1105u = m1105u();
        this.f22964af.put("PIN", str);
        StringBuffer stringBuffer = new StringBuffer();
        m1140a("9F26", stringBuffer);
        m1140a("9F27", stringBuffer);
        m1140a("9F10", stringBuffer);
        m1140a("9F37", stringBuffer);
        m1140a("9F36", stringBuffer);
        m1140a("95", stringBuffer);
        m1140a("9A", stringBuffer);
        m1140a("9C", stringBuffer);
        m1140a("9F02", stringBuffer);
        m1140a("5F2A", stringBuffer);
        m1140a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, stringBuffer);
        m1140a("9F1A", stringBuffer);
        m1140a("9F03", stringBuffer);
        m1140a("9F33", stringBuffer);
        m1140a("9F34", stringBuffer);
        m1140a("9F35", stringBuffer);
        m1140a("9F1E", stringBuffer);
        if (this.f22964af.get("9F63") != null && !TextUtils.isEmpty(this.f22964af.get("9F63"))) {
            m1140a("9F63", stringBuffer);
        }
        this.f22964af.put("DCD", stringBuffer.toString());
        this.f22946I = m1123e(this.f22946I, this.f22966s.m1511b());
        String str2 = (((("pan=" + this.f22964af.get("AN1")) + "&pin=" + this.f22964af.get("PIN")) + "&icc_data=" + this.f22964af.get("DCD")) + "&card_seq_id=" + this.f22964af.get("5F34")) + "&auth_id=" + this.f22947J;
        C4390k.m836c(Constant.KEY_MAC, str2);
        String m1127d = m1127d(str2);
        C4390k.m836c("md5", m1127d);
        String m1498g = this.f22594e.m1498g(m1127d);
        C4390k.m836c("sig", m1498g);
        String m1514a = this.f22594e.m1514a(str2 + "&" + m1498g, this.f22946I);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("v", this.f22965r);
            jSONObject.put("cmd", "pay");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(com.unionpay.tsmservice.data.Constant.KEY_PARAMS, jSONObject2);
            jSONObject2.put("encrypt_key_field", m1514a);
            jSONObject2.put("pay_type", "2");
            jSONObject2.put("pay_mode", "1");
            jSONObject2.put("bind", "no");
            jSONObject2.put("carrier_tp", "7");
            jSONObject2.put("carrier_app_tp", "0");
            jSONObject2.put("sign", m1498g);
            jSONObject2.put(com.unionpay.tsmservice.data.Constant.KEY_PAN, this.f22964af.get("AN1"));
            if (this.f22964af.get("ED") != null) {
                jSONObject2.put("expire", this.f22964af.get("ED"));
            }
            if (this.f22964af.get("TD2") != null) {
                jSONObject2.put("track2_data", this.f22964af.get("TD2"));
            }
            if (hashMap != null && hashMap.keySet() != null && hashMap.keySet().size() > 0) {
                hashMap.remove(com.unionpay.tsmservice.data.Constant.KEY_PAN);
                hashMap.remove(com.unionpay.tsmservice.data.Constant.KEY_PIN);
                for (String str3 : hashMap.keySet()) {
                    jSONObject2.put(str3, hashMap.get(str3));
                }
            }
            m1105u.putString("action_resp_message", this.f22966s.mo833a(jSONObject.toString()));
        } catch (JSONException unused) {
            m1105u.putString("action_resp_code", ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE);
            return m1105u;
        }
        return m1105u;
    }

    /* renamed from: a */
    public final void m1146a(NfcAdapter nfcAdapter) {
        this.f22955R = nfcAdapter;
        if (!this.f22955R.isEnabled()) {
            this.f22939B.setVisibility(0);
            this.f22941D.setVisibility(8);
            this.f22942E.setVisibility(0);
            UPRadiationView uPRadiationView = this.f22944G;
            if (uPRadiationView != null) {
                uPRadiationView.setVisibility(4);
                return;
            }
            return;
        }
        this.f22939B.setVisibility(8);
        if (this.f22950M) {
            this.f22941D.setVisibility(0);
        }
        this.f22942E.setVisibility(8);
        UPRadiationView uPRadiationView2 = this.f22944G;
        if (uPRadiationView2 != null) {
            uPRadiationView2.setVisibility(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x01e4  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m1145a(com.unionpay.mobile.android.pboctransaction.nfc.C4269a r9) {
        /*
            Method dump skipped, instructions count: 552
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.mobile.android.pro.views.C4324k.m1145a(com.unionpay.mobile.android.pboctransaction.nfc.a):void");
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: a */
    public final void mo827a(C4343a.C4344a c4344a) {
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: a */
    public final void mo1138a(String str, boolean z) {
        this.f22591b.m636a(new View$OnClickListenerC4326m(this, z), null);
        this.f22591b.m634a(C4171c.f22227bD.f22252Y, str, C4171c.f22227bD.f22250W);
    }

    @Override // com.unionpay.mobile.android.nocard.views.InterfaceC4191a
    /* renamed from: a */
    public final void mo1077a(JSONObject jSONObject) {
        int i = this.f22969v;
        switch (i) {
            case 7:
                m1407i();
                JSONArray m842d = C4389j.m842d(jSONObject, "options");
                C4343a c4343a = this.f22952O;
                if (c4343a != null) {
                    c4343a.m1029a(m842d);
                    return;
                }
                return;
            case 8:
                String m846a = C4389j.m846a(jSONObject, "status");
                if (m846a == null || !"01".equals(m846a)) {
                    JSONArray m842d2 = C4389j.m842d(jSONObject, "options");
                    String m846a2 = C4389j.m846a(jSONObject, "empty_info");
                    C4343a c4343a2 = this.f22952O;
                    if (c4343a2 != null) {
                        c4343a2.m1028a(m842d2, m846a2);
                        return;
                    }
                    return;
                }
                String m846a3 = C4389j.m846a(jSONObject, "uuid");
                if (this.f22954Q >= 0) {
                    m1126d(this.f22953P, m846a3);
                    return;
                }
                String str = C4171c.f22227bD.f22231D;
                C4343a c4343a3 = this.f22952O;
                if (c4343a3 != null) {
                    c4343a3.m1028a((JSONArray) null, str);
                    return;
                }
                return;
            default:
                boolean z = true;
                switch (i) {
                    case 101:
                        this.f22590a.f22435aj = C4388i.m851a(jSONObject.toString());
                        String m846a4 = C4389j.m846a(jSONObject, "qn");
                        if (!TextUtils.isEmpty(m846a4)) {
                            this.f22590a.f22478n = this.f22594e.m1496h(C4382c.m881b(m846a4));
                        }
                        if (this.f22590a.f22435aj == null || this.f22590a.f22435aj.length() <= 0) {
                            super.mo1137b(2);
                            return;
                        }
                        this.f22968u = 20;
                        m1109s();
                        return;
                    case 102:
                        this.f22591b.m630c();
                        try {
                            this.f22946I = (String) jSONObject.get("encrypt_key");
                            this.f22947J = (String) jSONObject.get("auth_id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        int m1478a = C4190f.m1478a(this.f22590a, jSONObject, false);
                        this.f22605p = C4190f.m1476a(jSONObject);
                        if (m1478a != 0) {
                            super.mo1137b(m1478a);
                            return;
                        }
                        this.f22950M = false;
                        this.f22956S.setBackgroundColor(-1052684);
                        setBackgroundColor(-1052684);
                        this.f22943F.setBackgroundColor(C4149a.f22109M);
                        this.f22943F.m682a(8);
                        this.f22938A.removeAllViews();
                        this.f22939B.setVisibility(8);
                        this.f22602m.setBackgroundColor(-1052684);
                        this.f22601l.setVisibility(0);
                        this.f22945H.setVisibility(8);
                        this.f22941D.setVisibility(8);
                        new LinearLayout.LayoutParams(-1, -2);
                        JSONArray jSONArray = new JSONArray();
                        if (this.f22605p != null) {
                            C4177f c4177f = (C4177f) this.f22605p;
                            jSONArray.put(c4177f.m1533a("promotion"));
                            jSONArray.put(c4177f.m1533a("instalment"));
                            this.f22590a.f22420aU = c4177f.m1533a("promotion_instalment_msgbox");
                        }
                        if (jSONArray.length() > 0) {
                            this.f22952O = new C4343a(this.f22593d, jSONArray, this, this.f22606q);
                            this.f22952O.m1032a(this.f22591b, this.f22590a.f22420aU);
                            this.f22952O.m1033a(this.f22958U);
                            this.f22952O.m1023b(this.f22959V);
                            this.f22952O.m1020c(this.f22960W);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                            layoutParams.topMargin = C4149a.f22117f;
                            this.f22938A.addView(this.f22952O, layoutParams);
                        }
                        C4343a c4343a4 = this.f22952O;
                        if (c4343a4 != null) {
                            c4343a4.m1019c("instalment");
                        }
                        this.f22972y = new C4343a(this.f22593d, this.f22590a.f22490z, this.f22594e.m1508c(), this, this.f22964af.get("AN1"), true, this.f22606q);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = C4149a.f22117f;
                        this.f22938A.addView(this.f22972y, layoutParams2);
                        LinearLayout linearLayout = new LinearLayout(this.f22593d);
                        linearLayout.setOrientation(1);
                        linearLayout.setId(linearLayout.hashCode());
                        new LinearLayout.LayoutParams(-1, -2);
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams3.topMargin = C4149a.f22117f;
                        layoutParams3.leftMargin = C4386g.m858a(this.f22593d, 10.0f);
                        this.f22938A.addView(linearLayout, layoutParams3);
                        if (m1408h() || this.f22590a.f22437al != null || this.f22590a.f22438am != null) {
                            if (this.f22590a.f22437al != null) {
                                Context context = this.f22593d;
                                JSONObject jSONObject2 = this.f22590a.f22437al;
                                View.OnClickListener onClickListener = this.f22962ab;
                                this.f22949L = new C4354a(context, jSONObject2, onClickListener, this.f22606q + "_agree_user_protocol");
                                linearLayout.addView(this.f22949L);
                            }
                            if (this.f22590a.f22438am != null) {
                                Context context2 = this.f22593d;
                                JSONObject jSONObject3 = this.f22590a.f22438am;
                                this.f22948K = new C4354a(context2, jSONObject3, null, this.f22606q + "_remember_bankNO");
                                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
                                layoutParams4.topMargin = C4149a.f22117f;
                                linearLayout.addView(this.f22948K, layoutParams4);
                            }
                        }
                        new LinearLayout.LayoutParams(-1, -2);
                        this.f22970w = new TextView(this.f22593d);
                        this.f22970w.setText(C4389j.m846a(this.f22590a.f22377C, "label"));
                        this.f22970w.setTextSize(C4150b.f22146i);
                        this.f22970w.setTextColor(m1403o());
                        this.f22970w.setGravity(17);
                        TextView textView = this.f22970w;
                        C4343a c4343a5 = this.f22972y;
                        if (c4343a5 != null && !c4343a5.m1016e()) {
                            z = false;
                        }
                        textView.setEnabled(z);
                        int i2 = C4149a.f22125n;
                        this.f22970w.setBackgroundDrawable(this.f22592c.m1037a(UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE, -1, -1));
                        this.f22970w.setOnClickListener(this.f22957T);
                        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, i2);
                        layoutParams5.topMargin = C4149a.f22117f;
                        int m858a = C4386g.m858a(this.f22593d, 10.0f);
                        layoutParams5.rightMargin = m858a;
                        layoutParams5.leftMargin = m858a;
                        this.f22938A.addView(this.f22970w, layoutParams5);
                        return;
                    case 103:
                        String m846a5 = C4389j.m846a(jSONObject, "status");
                        String m846a6 = C4389j.m846a(jSONObject, "fail_msg");
                        if (this.f22968u > 0 && m846a5.equalsIgnoreCase("01")) {
                            m1109s();
                            return;
                        }
                        this.f22969v = 100;
                        if (!m846a5.equalsIgnoreCase("00")) {
                            m1407i();
                            if (!m846a5.equalsIgnoreCase("03")) {
                                if (this.f22968u <= 0) {
                                    m1422a(this.f22590a.f22436ak);
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
                        this.f22969v = 100;
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
                        C4343a c4343a6 = this.f22972y;
                        if (c4343a6 != null) {
                            c4343a6.m1015f();
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(this.f22606q);
                        sb2.append("_succeed");
                        if (!this.f22590a.f22470f) {
                            m1411d(8);
                            return;
                        }
                        this.f22590a.f22383I.f22848f = com.unionpay.tsmservice.data.Constant.CASH_LOAD_SUCCESS;
                        m1406j();
                        return;
                    case 104:
                        try {
                            this.f22946I = (String) jSONObject.get("encrypt_key");
                            this.f22947J = (String) jSONObject.get("auth_id");
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        if (this.f22590a.f22480p != null) {
                            C4343a.C4344a m1035a = this.f22972y.m1035a();
                            if (!m1035a.m1014a()) {
                                m1422a(m1035a.f23028b);
                                return;
                            }
                            this.f22969v = 101;
                            m1133b(this.f22972y.m1035a().f23028b, m1107t());
                            return;
                        }
                        return;
                    default:
                        return;
                }
        }
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: a */
    public final void mo822a(boolean z) {
        TextView textView = this.f22970w;
        if (textView != null) {
            textView.setEnabled(!z);
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: b */
    public final void mo1076b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        this.f22943F = this.f22590a.f22403aD ? new C4449ay(this.f22593d, C4171c.f22227bD.f22325bo, this.f22592c.m1037a(1030, -1, -1), C4386g.m858a(this.f22593d, 20.0f), this) : new C4449ay(getContext(), C4171c.f22227bD.f22325bo, this);
        this.f22943F.setBackgroundColor(-16686660);
        this.f22943F.m682a(0);
        layoutParams.addRule(13, -1);
        this.f22600k.addView(this.f22943F, layoutParams);
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: b */
    public final void mo1137b(int i) {
        super.mo1137b(i);
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: c */
    public final void mo1072c() {
        setBackgroundColor(-11495169);
        this.f22601l.setVisibility(8);
        this.f22956S = new FrameLayout(this.f22593d);
        this.f22602m.addView(this.f22956S, new RelativeLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (m1103v() - C4150b.f22151n) - (C4150b.f22151n / 2));
        this.f22938A = new LinearLayout(this.f22593d);
        LinearLayout linearLayout = this.f22938A;
        linearLayout.setId(linearLayout.hashCode());
        this.f22938A.setOrientation(1);
        this.f22956S.addView(this.f22938A, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(C4150b.f22151n * 2, C4150b.f22151n * 2);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.f22593d).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams2.leftMargin = (displayMetrics.widthPixels / 2) - C4150b.f22151n;
        layoutParams2.topMargin = (m1103v() / 2) - (C4150b.f22151n * 2);
        this.f22945H = new ImageView(this.f22593d);
        this.f22945H.setBackgroundDrawable(this.f22592c.m1037a(1032, -1, -1));
        this.f22956S.addView(this.f22945H, layoutParams2);
        this.f22942E = new LinearLayout(this.f22593d);
        this.f22942E.setBackgroundColor(-1342177280);
        this.f22956S.addView(this.f22942E, new FrameLayout.LayoutParams(-1, -1));
        this.f22940C = new RelativeLayout(this.f22593d);
        this.f22956S.addView(this.f22940C, new FrameLayout.LayoutParams(-1, -1));
        this.f22602m.setBackgroundColor(-11495169);
        LinearLayout linearLayout2 = this.f22938A;
        linearLayout2.removeAllViews();
        this.f22944G = new UPRadiationView(this.f22593d);
        linearLayout2.addView(this.f22944G, new LinearLayout.LayoutParams(-1, -1));
        RelativeLayout relativeLayout = this.f22940C;
        relativeLayout.setGravity(1);
        int m858a = C4386g.m858a(this.f22593d, 10.0f);
        this.f22939B = new LinearLayout(this.f22593d);
        LinearLayout linearLayout3 = this.f22939B;
        linearLayout3.setId(linearLayout3.hashCode());
        this.f22939B.setOrientation(0);
        int i = m858a * 2;
        this.f22939B.setPadding(i, m858a, i, m858a);
        Drawable m1037a = this.f22592c.m1037a(1033, -1, -1);
        this.f22939B.setBackgroundDrawable(m1037a);
        String str = C4171c.f22227bD.f22322bl;
        TextView textView = new TextView(this.f22593d);
        textView.setTextColor(-1);
        textView.setText(str);
        textView.setTextSize(C4150b.f22148k);
        this.f22939B.addView(textView);
        String str2 = C4171c.f22227bD.f22323bm;
        TextView textView2 = new TextView(this.f22593d);
        textView2.setTextColor(-16729682);
        textView2.setText(str2);
        textView2.setTextSize(C4150b.f22148k);
        textView2.setOnClickListener(this.f22961aa);
        this.f22939B.addView(textView2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(10, -1);
        layoutParams3.topMargin = C4150b.f22151n;
        relativeLayout.addView(this.f22939B, layoutParams3);
        this.f22941D = new LinearLayout(this.f22593d);
        LinearLayout linearLayout4 = this.f22941D;
        linearLayout4.setId(linearLayout4.hashCode());
        this.f22941D.setOrientation(0);
        this.f22941D.setGravity(17);
        this.f22941D.setPadding(i, m858a, i, m858a);
        this.f22941D.setBackgroundDrawable(m1037a);
        String str3 = C4171c.f22227bD.f22324bn;
        TextView textView3 = new TextView(this.f22593d);
        textView3.setTextColor(-1);
        textView3.setText(str3);
        textView3.setTextSize(C4150b.f22148k);
        this.f22941D.addView(textView3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(12, -1);
        layoutParams4.bottomMargin = C4150b.f22151n;
        relativeLayout.addView(this.f22941D, layoutParams4);
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
                ResultCode.ERROR_INTERFACE_GET_CARD_INFO.equalsIgnoreCase(string);
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
        if (this.f22590a.f22403aD) {
            this.f22591b.m636a(new View$OnClickListenerC4333t(this), new View$OnClickListenerC4334u(this));
            this.f22591b.m633a(C4171c.f22227bD.f22252Y, C4171c.f22227bD.f22302av, C4171c.f22227bD.f22250W, C4171c.f22227bD.f22251X);
            return;
        }
        C4343a c4343a = this.f22972y;
        if (c4343a == null || !c4343a.m1018d()) {
            if (this.f22590a.f22385K && this.f22971x) {
                this.f22590a.f22385K = false;
                m1405m();
                return;
            }
            this.f22590a.f22385K = false;
            this.f22950M = false;
            m1428a(2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C4343a c4343a = this.f22972y;
        if (c4343a != null) {
            c4343a.m1018d();
        }
        UPRadiationView uPRadiationView = this.f22944G;
        if (uPRadiationView != null) {
            uPRadiationView.m1000a();
        }
        this.f22944G = null;
        this.f22591b = null;
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: r */
    public final void mo767r() {
    }
}
