package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.model.C4177f;
import com.unionpay.mobile.android.model.InterfaceC4174c;
import com.unionpay.mobile.android.model.InterfaceC4176e;
import com.unionpay.mobile.android.nocard.utils.C4186b;
import com.unionpay.mobile.android.nocard.utils.C4190f;
import com.unionpay.mobile.android.nocard.views.AbstractC4219b;
import com.unionpay.mobile.android.nocard.views.C4228bh;
import com.unionpay.mobile.android.pro.pboc.engine.C4298b;
import com.unionpay.mobile.android.upviews.C4343a;
import com.unionpay.mobile.android.upwidget.C4354a;
import com.unionpay.mobile.android.utils.C4382c;
import com.unionpay.mobile.android.utils.C4386g;
import com.unionpay.mobile.android.utils.C4388i;
import com.unionpay.mobile.android.utils.C4389j;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.mobile.android.utils.C4394o;
import com.unionpay.mobile.android.widgets.C4449ay;
import com.unionpay.tsmservice.data.Constant;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.pro.views.y */
/* loaded from: classes2.dex */
public class C4338y extends AbstractC4219b implements Handler.Callback, C4343a.InterfaceC4345b {

    /* renamed from: A */
    private C4343a f22988A;

    /* renamed from: B */
    private String f22989B;

    /* renamed from: C */
    private boolean f22990C;

    /* renamed from: D */
    private Handler f22991D;

    /* renamed from: E */
    private View.OnClickListener f22992E;

    /* renamed from: F */
    private View.OnClickListener f22993F;

    /* renamed from: G */
    private View.OnClickListener f22994G;

    /* renamed from: H */
    private View.OnClickListener f22995H;

    /* renamed from: I */
    private View.OnClickListener f22996I;

    /* renamed from: r */
    private String f22997r;

    /* renamed from: s */
    private int f22998s;

    /* renamed from: t */
    private int f22999t;

    /* renamed from: u */
    private int f23000u;

    /* renamed from: v */
    private int f23001v;

    /* renamed from: w */
    private C4354a f23002w;

    /* renamed from: x */
    private C4354a f23003x;

    /* renamed from: y */
    private TextView f23004y;

    /* renamed from: z */
    private C4343a f23005z;

    public C4338y(Context context, InterfaceC4176e interfaceC4176e) {
        super(context, interfaceC4176e);
        this.f22997r = "00";
        this.f22998s = 0;
        this.f22999t = 0;
        this.f23000u = 20;
        this.f23001v = 5;
        this.f23002w = null;
        this.f23003x = null;
        this.f23004y = null;
        this.f23005z = null;
        this.f22988A = null;
        this.f22990C = false;
        this.f22991D = null;
        this.f22992E = new View$OnClickListenerC4339z(this);
        this.f22993F = new View$OnClickListenerC4308aa(this);
        this.f22994G = new View$OnClickListenerC4309ab(this);
        this.f22995H = new View$OnClickListenerC4310ac(this);
        this.f22996I = new View$OnClickListenerC4312ae(this);
        this.f22595f = 6;
        this.f22606q = "sdpay";
        this.f22991D = new Handler(this);
        this.f22990C = this.f22590a.f22385K;
        setBackgroundColor(-1052684);
        m1410e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: C */
    public static /* synthetic */ String m1083C(C4338y c4338y) {
        C4343a.C4344a m1024b;
        String str = "";
        C4343a c4343a = c4338y.f22988A;
        if (c4343a != null) {
            if (c4343a.m1024b().m1014a()) {
                str = "" + m1024b.f23028b;
            }
        }
        C4343a c4343a2 = c4338y.f23005z;
        if (c4343a2 != null) {
            C4343a.C4344a m1024b2 = c4343a2.m1024b();
            if (m1024b2.m1014a()) {
                String str2 = m1024b2.f23028b;
                if (TextUtils.isEmpty(str2)) {
                    return str;
                }
                if (!TextUtils.isEmpty(str)) {
                    str = str + ",";
                }
                return str + str2;
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m1081a(C4338y c4338y, InterfaceC4174c interfaceC4174c, String str, HashMap hashMap) {
        c4338y.f22999t = 3;
        C4298b mo1047s = c4338y.mo1047s();
        if (mo1047s == null) {
            c4338y.mo1137b(5);
        } else {
            new Thread(new RunnableC4311ad(c4338y, mo1047s, interfaceC4174c, str, hashMap)).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m1079a(C4338y c4338y, String str, String str2) {
        c4338y.f22999t = 7;
        c4338y.f22591b.m635a(C4171c.f22227bD.f22248U);
        c4338y.f22594e.m1506c(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m1066d(String str, String str2) {
        this.f22999t = 8;
        if (TextUtils.isEmpty(str2)) {
            this.f22594e.m1506c(str, "");
        } else {
            this.f22594e.m1513a(str, "\"uuid\":\"" + str2 + "\"", 10);
        }
        this.f23001v--;
    }

    /* renamed from: f */
    private void m1063f(int i) {
        this.f22999t = 4;
        this.f22998s = i;
        this.f22594e.m1513a("query", this.f22590a.f22435aj, 3);
        this.f23000u--;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static /* synthetic */ void m1061f(C4338y c4338y, String str) {
        c4338y.f22599j = false;
        c4338y.f22999t = 3;
        String m1390a = C4228bh.m1390a(c4338y.f22590a.f22377C);
        C4354a c4354a = c4338y.f23002w;
        c4338y.f22594e.m1506c(m1390a, C4228bh.m1387c("2", "1", c4354a != null ? c4354a.m989a() : null, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public static /* synthetic */ HashMap m1058i(C4338y c4338y) {
        HashMap<String, String> hashMap = new HashMap<>();
        C4343a c4343a = c4338y.f22988A;
        if (c4343a != null) {
            hashMap = c4343a.m1021c();
        }
        C4343a c4343a2 = c4338y.f23005z;
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
    /* renamed from: m */
    public static /* synthetic */ int m1053m(C4338y c4338y) {
        c4338y.f23001v = 5;
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: z */
    public static /* synthetic */ int m1039z(C4338y c4338y) {
        c4338y.f22999t = 0;
        return 0;
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: a */
    public final void mo827a(C4343a.C4344a c4344a) {
        if (!c4344a.m1014a()) {
            m1422a(c4344a.f23028b);
            return;
        }
        C4390k.m838a("uppay", "sms elements:" + c4344a.f23028b);
        this.f22599j = false;
        this.f22591b.m635a(C4171c.f22227bD.f22248U);
        this.f22594e.m1506c("sms", c4344a.f23028b);
        this.f22999t = 1;
    }

    @Override // com.unionpay.mobile.android.nocard.views.InterfaceC4191a
    /* renamed from: a */
    public final void mo1077a(JSONObject jSONObject) {
        int i;
        this.f22990C = false;
        switch (this.f22999t) {
            case 1:
                m1407i();
                this.f22999t = 0;
                this.f22988A.m1034a(C4150b.f22153p);
                return;
            case 2:
            case 5:
            default:
                return;
            case 3:
                this.f22590a.f22435aj = C4388i.m851a(jSONObject.toString());
                String m846a = C4389j.m846a(jSONObject, "qn");
                if (!TextUtils.isEmpty(m846a)) {
                    this.f22590a.f22478n = this.f22594e.m1496h(C4382c.m881b(m846a));
                }
                if (this.f22590a.f22435aj == null || this.f22590a.f22435aj.length() <= 0) {
                    mo1137b(2);
                    return;
                }
                this.f23000u = 20;
                m1063f(this.f22999t);
                return;
            case 4:
                this.f22997r = C4389j.m846a(jSONObject, "status");
                if (this.f23000u > 0 && this.f22997r.equalsIgnoreCase("01")) {
                    m1063f(this.f22998s);
                    return;
                }
                this.f22999t = 0;
                if (this.f22997r.equalsIgnoreCase("00")) {
                    m1407i();
                    this.f22999t = 0;
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
                    C4343a c4343a = this.f22988A;
                    if (c4343a != null) {
                        c4343a.m1015f();
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f22606q);
                    sb.append("_succeed");
                    if (!this.f22590a.f22470f) {
                        m1411d(8);
                        return;
                    }
                    this.f22590a.f22383I.f22848f = Constant.CASH_LOAD_SUCCESS;
                    m1406j();
                    return;
                } else if (!this.f22997r.equalsIgnoreCase("03")) {
                    if (this.f23000u <= 0) {
                        if (this.f22998s == 3) {
                            mo1138a(this.f22590a.f22436ak, true);
                            return;
                        } else {
                            m1422a(this.f22590a.f22436ak);
                            return;
                        }
                    }
                    return;
                } else {
                    String m846a2 = C4389j.m846a(jSONObject, "fail_msg");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.f22606q);
                    sb2.append("_fail");
                    String[] strArr = C4394o.f23207j;
                    String[] strArr2 = {this.f22997r, m846a2};
                    if (this.f22999t == 3) {
                        m1422a(m846a2);
                        return;
                    }
                    View$OnClickListenerC4313af view$OnClickListenerC4313af = new View$OnClickListenerC4313af(this);
                    View$OnClickListenerC4314ag view$OnClickListenerC4314ag = new View$OnClickListenerC4314ag(this);
                    if (this.f22590a.f22380F) {
                        this.f22591b.m636a(view$OnClickListenerC4313af, view$OnClickListenerC4314ag);
                        this.f22591b.m633a(C4171c.f22227bD.f22252Y, m846a2, C4171c.f22227bD.f22250W, C4171c.f22227bD.f22251X);
                        return;
                    }
                    this.f22591b.m636a(view$OnClickListenerC4313af, null);
                    this.f22591b.m634a(C4171c.f22227bD.f22252Y, m846a2, C4171c.f22227bD.f22250W);
                    return;
                }
            case 6:
                m1407i();
                int m1478a = C4190f.m1478a(this.f22590a, jSONObject, false);
                if (m1478a != 0) {
                    mo1137b(m1478a);
                } else {
                    this.f22590a.f22385K = true;
                    if (this.f22590a.f22490z == null || this.f22590a.f22490z.length() <= 0) {
                        i = (this.f22590a.f22378D != null && this.f22590a.f22378D.length() > 0) ? 5 : 5;
                    } else {
                        i = 6;
                    }
                    m1411d(i);
                }
                this.f22999t = 0;
                return;
            case 7:
                m1407i();
                JSONArray m842d = C4389j.m842d(jSONObject, "options");
                C4343a c4343a2 = this.f23005z;
                if (c4343a2 != null) {
                    c4343a2.m1029a(m842d);
                    return;
                }
                return;
            case 8:
                String m846a3 = C4389j.m846a(jSONObject, "status");
                if (m846a3 == null || !"01".equals(m846a3)) {
                    JSONArray m842d2 = C4389j.m842d(jSONObject, "options");
                    String m846a4 = C4389j.m846a(jSONObject, "empty_info");
                    C4343a c4343a3 = this.f23005z;
                    if (c4343a3 != null) {
                        c4343a3.m1028a(m842d2, m846a4);
                        return;
                    }
                    return;
                }
                String m846a5 = C4389j.m846a(jSONObject, "uuid");
                if (this.f23001v >= 0) {
                    m1066d(this.f22989B, m846a5);
                    return;
                }
                String str = C4171c.f22227bD.f22231D;
                C4343a c4343a4 = this.f23005z;
                if (c4343a4 != null) {
                    c4343a4.m1028a((JSONArray) null, str);
                    return;
                }
                return;
        }
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: a */
    public final void mo822a(boolean z) {
        TextView textView = this.f23004y;
        if (textView != null) {
            textView.setEnabled(!z);
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: a */
    public final boolean mo1078a(String str, JSONObject jSONObject) {
        this.f22990C = false;
        return false;
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: b */
    public final void mo1076b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        C4449ay c4449ay = new C4449ay(getContext(), this.f22590a.f22375A, this);
        layoutParams.addRule(13, -1);
        this.f22600k.addView(c4449ay, layoutParams);
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: c */
    public final void mo1072c() {
        LinearLayout linearLayout = new LinearLayout(this.f22593d);
        linearLayout.setId(linearLayout.hashCode());
        boolean z = true;
        linearLayout.setOrientation(1);
        this.f22602m.addView(linearLayout, new RelativeLayout.LayoutParams(-1, -2));
        JSONArray jSONArray = new JSONArray();
        if (this.f22605p != null) {
            C4177f c4177f = (C4177f) this.f22605p;
            jSONArray.put(c4177f.m1533a("promotion"));
            jSONArray.put(c4177f.m1533a("instalment"));
            this.f22590a.f22420aU = c4177f.m1533a("promotion_instalment_msgbox");
        }
        if (jSONArray.length() > 0) {
            this.f23005z = new C4343a(this.f22593d, jSONArray, this, this.f22606q);
            this.f23005z.m1032a(this.f22591b, this.f22590a.f22420aU);
            this.f23005z.m1033a(this.f22993F);
            this.f23005z.m1023b(this.f22994G);
            this.f23005z.m1020c(this.f22995H);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = C4149a.f22117f;
            linearLayout.addView(this.f23005z, layoutParams);
        }
        C4343a c4343a = this.f23005z;
        if (c4343a != null) {
            c4343a.m1019c("instalment");
        }
        this.f22988A = new C4343a(this.f22593d, this.f22590a.f22490z, this.f22594e.m1508c(), this, this.f22590a.f22442aq, false, this.f22606q);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = C4149a.f22117f;
        linearLayout.addView(this.f22988A, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(this.f22593d);
        linearLayout2.setOrientation(1);
        linearLayout2.setId(linearLayout2.hashCode());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(3, linearLayout.getId());
        layoutParams3.leftMargin = C4149a.f22117f;
        layoutParams3.topMargin = layoutParams3.leftMargin;
        this.f22602m.addView(linearLayout2, layoutParams3);
        if (m1408h() || this.f22590a.f22437al != null || this.f22590a.f22438am != null) {
            if (this.f22590a.f22437al != null) {
                Context context = this.f22593d;
                JSONObject jSONObject = this.f22590a.f22437al;
                View.OnClickListener onClickListener = this.f22996I;
                this.f23003x = new C4354a(context, jSONObject, onClickListener, this.f22606q + "_agree_user_protocol");
                linearLayout2.addView(this.f23003x);
            }
            if (this.f22590a.f22438am != null) {
                Context context2 = this.f22593d;
                JSONObject jSONObject2 = this.f22590a.f22438am;
                this.f23002w = new C4354a(context2, jSONObject2, null, this.f22606q + "_remember_bankNO");
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams4.topMargin = C4149a.f22117f;
                linearLayout2.addView(this.f23002w, layoutParams4);
            }
        }
        this.f23004y = new TextView(this.f22593d);
        this.f23004y.setText(C4389j.m846a(this.f22590a.f22377C, "label"));
        this.f23004y.setTextSize(C4150b.f22146i);
        this.f23004y.setTextColor(m1403o());
        this.f23004y.setGravity(17);
        TextView textView = this.f23004y;
        C4343a c4343a2 = this.f22988A;
        if (c4343a2 != null && !c4343a2.m1016e()) {
            z = false;
        }
        textView.setEnabled(z);
        int i = C4149a.f22125n;
        this.f23004y.setBackgroundDrawable(this.f22592c.m1037a(UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE, -1, -1));
        this.f23004y.setOnClickListener(this.f22992E);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, i);
        layoutParams5.addRule(3, linearLayout2.getId());
        layoutParams5.topMargin = C4149a.f22117f;
        int m858a = C4386g.m858a(this.f22593d, 10.0f);
        layoutParams5.rightMargin = m858a;
        layoutParams5.leftMargin = m858a;
        this.f22602m.addView(this.f23004y, layoutParams5);
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: c */
    public final void mo821c(String str) {
        this.f22599j = false;
        this.f22591b.m635a(C4171c.f22227bD.f22248U);
        String str2 = "\"card\":\"" + this.f22590a.f22481q.get(this.f22590a.f22388N).mo1544a() + "\"";
        C4390k.m838a("uppay", "cmd:" + str + ", ele:" + str2);
        this.f22594e.m1506c(str, str2);
        this.f22999t = 6;
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: c */
    public final void mo820c(String str, String str2) {
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message2) {
        if (message2.obj != null) {
            Bundle bundle = (Bundle) message2.obj;
            String string = bundle.getString("action_resp_code");
            String string2 = bundle.getString("action_resp_message");
            if (!"0000".equalsIgnoreCase(string)) {
                mo1138a(this.f22590a.f22441ap, false);
            } else if (string2 != null) {
                mo1426a(0, string2);
            }
            return true;
        }
        mo1137b(1);
        return true;
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: k */
    public final void mo1056k() {
        if (this.f22988A.m1018d()) {
            return;
        }
        if (this.f22590a.f22385K && this.f22990C) {
            this.f22590a.f22385K = false;
            m1405m();
            return;
        }
        this.f22590a.f22385K = false;
        this.f22590a.f22464br = false;
        m1428a(2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f22988A.m1018d();
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: r */
    public final void mo767r() {
    }

    /* renamed from: s */
    public C4298b mo1047s() {
        return null;
    }
}
