package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.model.C4177f;
import com.unionpay.mobile.android.model.InterfaceC4176e;
import com.unionpay.mobile.android.nocard.utils.C4186b;
import com.unionpay.mobile.android.nocard.utils.C4190f;
import com.unionpay.mobile.android.resource.C4342c;
import com.unionpay.mobile.android.upviews.C4343a;
import com.unionpay.mobile.android.upwidget.C4354a;
import com.unionpay.mobile.android.upwidget.C4356c;
import com.unionpay.mobile.android.upwidget.C4360g;
import com.unionpay.mobile.android.utils.C4382c;
import com.unionpay.mobile.android.utils.C4386g;
import com.unionpay.mobile.android.utils.C4388i;
import com.unionpay.mobile.android.utils.C4389j;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.mobile.android.utils.C4394o;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.widgets.AbstractC4486z;
import com.unionpay.mobile.android.widgets.C4432aj;
import com.unionpay.mobile.android.widgets.C4449ay;
import com.unionpay.mobile.android.widgets.C4474p;
import com.unionpay.tsmservice.data.Constant;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.nocard.views.o */
/* loaded from: classes2.dex */
public final class C4245o extends AbstractC4219b implements C4343a.InterfaceC4345b {

    /* renamed from: A */
    private int f22679A;

    /* renamed from: B */
    private int f22680B;

    /* renamed from: C */
    private C4354a f22681C;

    /* renamed from: D */
    private C4343a f22682D;

    /* renamed from: E */
    private C4247b f22683E;

    /* renamed from: F */
    private String f22684F;

    /* renamed from: G */
    private View.OnClickListener f22685G;

    /* renamed from: H */
    private View.OnClickListener f22686H;

    /* renamed from: I */
    private boolean f22687I;

    /* renamed from: r */
    LinearLayout f22688r;

    /* renamed from: s */
    private int f22689s;

    /* renamed from: t */
    private C4343a f22690t;

    /* renamed from: u */
    private View.OnClickListener f22691u;

    /* renamed from: v */
    private View.OnClickListener f22692v;

    /* renamed from: w */
    private View.OnClickListener f22693w;

    /* renamed from: x */
    private TextView f22694x;

    /* renamed from: y */
    private int f22695y;

    /* renamed from: z */
    private int f22696z;

    /* renamed from: com.unionpay.mobile.android.nocard.views.o$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC4246a {
        /* renamed from: a */
        void mo1337a(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.unionpay.mobile.android.nocard.views.o$b */
    /* loaded from: classes2.dex */
    public class C4247b extends LinearLayout {

        /* renamed from: b */
        private PopupWindow f22698b;

        /* renamed from: c */
        private C4356c f22699c;

        /* renamed from: d */
        private C4360g f22700d;

        /* renamed from: e */
        private String f22701e;

        /* renamed from: f */
        private TextView f22702f;

        /* renamed from: g */
        private int f22703g;

        /* renamed from: h */
        private final View.OnClickListener f22704h;

        /* renamed from: i */
        private final AdapterView.OnItemClickListener f22705i;

        /* renamed from: j */
        private List<Map<String, Object>> f22706j;

        /* renamed from: k */
        private InterfaceC4246a f22707k;

        /* renamed from: l */
        private String f22708l;

        /* JADX WARN: Multi-variable type inference failed */
        public C4247b(Context context, InterfaceC4246a interfaceC4246a, List<Map<String, Object>> list, JSONArray jSONArray, String str) {
            super(context);
            this.f22703g = 1;
            this.f22704h = new View$OnClickListenerC4194ac(this);
            this.f22705i = new C4195ad(this);
            setOrientation(1);
            this.f22707k = interfaceC4246a;
            this.f22706j = list;
            this.f22701e = jSONArray;
            this.f22708l = str;
            this.f22699c = new C4356c(C4245o.this.f22593d, this.f22706j, this.f22701e, this.f22708l, "", this.f22703g, 0);
            this.f22700d = new C4360g(C4245o.this.f22593d, this.f22699c);
            this.f22700d.m961a(this.f22705i);
            this.f22700d.m962a(this.f22704h);
            if (list == null || list.size() <= 0) {
                return;
            }
            Drawable m1037a = C4342c.m1036a(C4245o.this.f22593d).m1037a(2014, -1, -1);
            RelativeLayout relativeLayout = new RelativeLayout(C4245o.this.f22593d);
            relativeLayout.setBackgroundDrawable(m1037a);
            relativeLayout.setOnClickListener(new View$OnClickListenerC4196ae(this));
            addView(relativeLayout, new LinearLayout.LayoutParams(-1, C4149a.f22125n));
            ImageView imageView = new ImageView(C4245o.this.f22593d);
            imageView.setId(imageView.hashCode());
            imageView.setBackgroundDrawable(C4342c.m1036a(C4245o.this.f22593d).m1037a(1002, -1, -1));
            int m858a = C4386g.m858a(C4245o.this.f22593d, 15.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(m858a, m858a);
            layoutParams.addRule(11, -1);
            layoutParams.addRule(15, -1);
            layoutParams.rightMargin = C4386g.m858a(C4245o.this.f22593d, 10.0f);
            relativeLayout.addView(imageView, layoutParams);
            this.f22702f = new TextView(C4245o.this.f22593d);
            this.f22702f.setTextSize(C4150b.f22148k);
            this.f22702f.setTextColor(-10066330);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            this.f22702f.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            this.f22702f.setSingleLine(true);
            layoutParams2.leftMargin = C4386g.m858a(C4245o.this.f22593d, 10.0f);
            layoutParams2.rightMargin = layoutParams2.leftMargin;
            layoutParams2.addRule(15, -1);
            layoutParams2.addRule(9, -1);
            layoutParams2.addRule(0, imageView.getId());
            relativeLayout.addView(this.f22702f, layoutParams2);
            m1347a(0);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public static /* synthetic */ void m1344a(C4247b c4247b, View view) {
            if (c4247b.f22698b == null) {
                c4247b.f22698b = new PopupWindow((View) c4247b.f22700d, -1, -1, true);
                c4247b.f22698b.setBackgroundDrawable(new ColorDrawable(-1342177280));
                c4247b.f22698b.update();
            }
            c4247b.f22698b.showAtLocation(view, 80, 0, 0);
        }

        /* renamed from: a */
        public final void m1347a(int i) {
            int m972c = i + this.f22699c.m972c();
            TextView textView = this.f22702f;
            if (textView != null) {
                textView.setText(this.f22699c.m974b(m972c));
            }
        }
    }

    public C4245o(Context context, InterfaceC4176e interfaceC4176e) {
        super(context, interfaceC4176e);
        this.f22689s = 0;
        this.f22690t = null;
        this.f22691u = null;
        this.f22692v = null;
        this.f22693w = null;
        this.f22694x = null;
        this.f22688r = null;
        this.f22695y = 0;
        this.f22696z = 0;
        this.f22679A = 20;
        this.f22680B = 5;
        this.f22681C = null;
        this.f22682D = null;
        this.f22685G = new View$OnClickListenerC4248p(this);
        this.f22686H = new View$OnClickListenerC4253u(this);
        this.f22687I = false;
        this.f22595f = 13;
        this.f22606q = this.f22590a.f22385K ? "loginpay_phoneNO_change" : "loginpay";
        this.f22691u = new View$OnClickListenerC4254v(this);
        this.f22692v = new View$OnClickListenerC4255w(this);
        this.f22693w = new View$OnClickListenerC4256x(this);
        if (!m1402p() && !m1349t() && !this.f22590a.f22425aZ) {
            this.f22687I = true;
        }
        setBackgroundColor(-1052684);
        m1410e();
        if (this.f22590a.f22405aF != null) {
            m1412c((JSONObject) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ int m1364a(C4245o c4245o) {
        c4245o.f22680B = 5;
        return 5;
    }

    /* renamed from: a */
    private void m1365a(LinearLayout linearLayout) {
        JSONArray jSONArray = this.f22590a.f22428ac;
        if (jSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            AbstractC4486z a = m1418a((JSONObject) C4389j.m845b(jSONArray, i), this.f22606q);
            if (a != null) {
                linearLayout.addView(a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m1363a(C4245o c4245o, int i) {
        if (c4245o.f22590a.f22427ab != null && i == c4245o.f22590a.f22427ab.size()) {
            c4245o.f22590a.f22425aZ = true;
            c4245o.f22687I = true;
            c4245o.m1411d(13);
            return;
        }
        String[] strArr = C4394o.f23203f;
        new Object[1][0] = Integer.valueOf(i);
        c4245o.f22687I = false;
        c4245o.f22696z = c4245o.f22695y;
        c4245o.f22695y = i;
        String mo1544a = c4245o.f22590a.f22427ab.get(i).mo1544a();
        c4245o.f22599j = false;
        c4245o.f22689s = 1;
        c4245o.f22591b.m635a(C4171c.f22227bD.f22248U);
        c4245o.f22594e.m1494i(C4228bh.m1391a("1", mo1544a, "1", "2"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m1361a(C4245o c4245o, String str, String str2) {
        c4245o.f22689s = 8;
        c4245o.f22591b.m635a(C4171c.f22227bD.f22248U);
        c4245o.f22594e.m1506c(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ void m1359b(C4245o c4245o, String str) {
        c4245o.f22599j = false;
        c4245o.f22689s = 3;
        c4245o.f22591b.m635a(C4171c.f22227bD.f22248U);
        c4245o.f22594e.m1512a("1", "2", "yes", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m1354d(String str, String str2) {
        this.f22689s = 9;
        if (TextUtils.isEmpty(str2)) {
            this.f22594e.m1506c(str, "");
        } else {
            this.f22594e.m1513a(str, "\"uuid\":\"" + str2 + "\"", 10);
        }
        this.f22680B--;
    }

    /* renamed from: d */
    private void m1353d(JSONObject jSONObject) {
        boolean z = false;
        int m1478a = C4190f.m1478a(this.f22590a, jSONObject, false);
        if (m1478a != 0) {
            mo1137b(m1478a);
            if (1 == this.f22689s) {
                m1351f(this.f22696z);
                return;
            }
            return;
        }
        InterfaceC4176e m1476a = C4190f.m1476a(jSONObject);
        if (5 == this.f22689s) {
            if (this.f22590a.f22490z != null && this.f22590a.f22490z.length() > 0) {
                m1427a(6, m1476a);
                return;
            } else if (this.f22590a.f22378D == null || this.f22590a.f22378D.length() <= 0) {
                return;
            } else {
                m1411d(5);
                return;
            }
        }
        this.f22605p = m1476a;
        m1351f(this.f22695y);
        this.f22682D.m1027a(m1350s(), this.f22590a.f22442aq, true, null, this.f22590a.f22429ad, this.f22606q);
        this.f22682D.m1033a(this.f22685G);
        this.f22682D.m1023b(this.f22686H);
        this.f22682D.m1032a(this.f22591b, this.f22590a.f22420aU);
        this.f22682D.m1017d(this.f22590a.f22466bt);
        C4343a c4343a = this.f22682D;
        this.f22690t.m1027a(this.f22590a.f22490z, this.f22590a.f22442aq, true, c4343a != null ? c4343a.m1019c("instalment") : null, this.f22590a.f22429ad, this.f22606q);
        TextView textView = this.f22694x;
        C4343a c4343a2 = this.f22690t;
        textView.setEnabled((c4343a2 == null || c4343a2.m1016e()) ? true : true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static /* synthetic */ void m1352e(C4245o c4245o) {
        C4343a c4343a = c4245o.f22690t;
        if (c4343a != null) {
            C4343a.C4344a m1024b = c4343a.m1024b();
            if (!m1024b.m1014a()) {
                c4245o.m1422a(m1024b.f23028b);
                return;
            }
            c4245o.f22599j = false;
            c4245o.f22689s = 5;
            c4245o.f22591b.m635a(C4171c.f22227bD.f22248U);
            c4245o.f22594e.m1506c("bindcardrules", m1024b.f23028b);
        }
    }

    /* renamed from: f */
    private void m1351f(int i) {
        this.f22695y = i;
        this.f22683E.m1347a(this.f22695y);
    }

    /* renamed from: s */
    private JSONArray m1350s() {
        JSONArray jSONArray = new JSONArray();
        if (this.f22605p != null) {
            C4177f c4177f = (C4177f) this.f22605p;
            jSONArray.put(c4177f.m1533a("promotion"));
            jSONArray.put(c4177f.m1533a("instalment"));
            this.f22590a.f22420aU = c4177f.m1533a("promotion_instalment_msgbox");
        }
        return jSONArray;
    }

    /* renamed from: t */
    private final boolean m1349t() {
        return (this.f22590a.f22425aZ || this.f22590a.f22427ab == null || this.f22590a.f22427ab.size() <= 0) ? false : true;
    }

    /* renamed from: u */
    private void m1348u() {
        this.f22689s = 4;
        this.f22594e.m1513a("query", this.f22590a.f22435aj, 3);
        this.f22679A--;
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: a */
    public final void mo827a(C4343a.C4344a c4344a) {
        this.f22690t.m1018d();
        if (!c4344a.m1014a()) {
            m1422a(c4344a.f23028b);
            return;
        }
        this.f22599j = false;
        this.f22591b.m635a(C4171c.f22227bD.f22248U);
        this.f22594e.m1506c("sms", c4344a.f23028b);
        this.f22689s = 2;
    }

    @Override // com.unionpay.mobile.android.nocard.views.InterfaceC4191a
    /* renamed from: a */
    public final void mo1077a(JSONObject jSONObject) {
        int i = this.f22689s;
        if (i == 16) {
            if (this.f22591b.m638a()) {
                this.f22591b.m630c();
            }
            new JSONObject();
            if (TextUtils.isEmpty(C4389j.m846a(jSONObject, "instalment_empty_info"))) {
                jSONObject = C4389j.m843c(jSONObject, "instalment");
            }
            this.f22682D.m1026a(jSONObject);
            this.f22689s = 0;
            return;
        }
        switch (i) {
            case 1:
            case 5:
                m1407i();
                if (m1414b(jSONObject)) {
                    return;
                }
                if (this.f22689s == 5) {
                    this.f22590a.f22386L = true;
                }
                m1353d(jSONObject);
                return;
            case 2:
                m1407i();
                this.f22690t.m1034a(C4150b.f22153p);
                return;
            case 3:
                this.f22590a.f22435aj = C4388i.m851a(jSONObject.toString());
                String m846a = C4389j.m846a(jSONObject, "qn");
                if (!TextUtils.isEmpty(m846a)) {
                    this.f22590a.f22478n = this.f22594e.m1496h(C4382c.m881b(m846a));
                }
                if (this.f22590a.f22435aj == null) {
                    mo1137b(2);
                    return;
                }
                this.f22679A = 20;
                m1348u();
                return;
            case 4:
                String m846a2 = C4389j.m846a(jSONObject, "status");
                if (this.f22679A > 0 && m846a2.equalsIgnoreCase("01")) {
                    m1348u();
                    return;
                }
                m1407i();
                if (!m846a2.equalsIgnoreCase("00")) {
                    if (!m846a2.equalsIgnoreCase("03")) {
                        if (this.f22679A <= 0) {
                            mo1137b(19);
                            return;
                        }
                        return;
                    }
                    String m846a3 = C4389j.m846a(jSONObject, "fail_msg");
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f22606q);
                    sb.append("_fail");
                    String[] strArr = C4394o.f23207j;
                    String[] strArr2 = {m846a2, m846a3};
                    m1422a(m846a3);
                    return;
                }
                this.f22689s = 0;
                this.f22590a.f22382H = C4389j.m842d(jSONObject, "result");
                this.f22590a.f22390P = C4389j.m846a(jSONObject, "openupgrade_flag");
                this.f22590a.f22391Q = C4389j.m846a(jSONObject, "temporary_pay_flag");
                this.f22590a.f22392R = C4389j.m846a(jSONObject, "temporary_pay_info");
                this.f22590a.f22396V = C4389j.m846a(jSONObject, "front_url");
                this.f22590a.f22397W = C4389j.m846a(jSONObject, "front_request");
                this.f22590a.f22375A = C4389j.m846a(jSONObject, "title");
                this.f22590a.f22376B = C4389j.m846a(jSONObject, "succ_info");
                C4186b.m1483a(jSONObject, this.f22590a);
                C4186b.m1482b(jSONObject, this.f22590a);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f22606q);
                sb2.append("_succeed");
                if (!this.f22590a.f22470f) {
                    m1411d(8);
                    return;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.f22590a.f22416aQ);
                PreferenceUtils.m895c(this.f22593d, sb3.toString());
                this.f22590a.f22383I.f22848f = Constant.CASH_LOAD_SUCCESS;
                m1406j();
                return;
            case 6:
                m1407i();
                int m1478a = C4190f.m1478a(this.f22590a, jSONObject, true);
                if (m1478a != 0) {
                    mo1137b(m1478a);
                } else {
                    this.f22590a.f22385K = true;
                    InterfaceC4176e m1476a = C4190f.m1476a(jSONObject);
                    if (this.f22590a.f22490z != null && this.f22590a.f22490z.length() > 0) {
                        m1427a(6, m1476a);
                    } else if (this.f22590a.f22378D != null && this.f22590a.f22378D.length() > 0) {
                        m1411d(5);
                    }
                }
                this.f22689s = 0;
                return;
            case 7:
                m1407i();
                int m1478a2 = C4190f.m1478a(this.f22590a, jSONObject, false);
                if (m1478a2 != 0) {
                    mo1137b(m1478a2);
                    return;
                }
                InterfaceC4176e m1476a2 = C4190f.m1476a(jSONObject);
                if (this.f22590a.f22490z != null && this.f22590a.f22490z.length() > 0) {
                    m1427a(6, m1476a2);
                    return;
                } else if (this.f22590a.f22378D == null || this.f22590a.f22378D.length() <= 0) {
                    return;
                } else {
                    m1411d(5);
                    return;
                }
            case 8:
                m1407i();
                JSONArray m842d = C4389j.m842d(jSONObject, "options");
                C4343a c4343a = this.f22682D;
                if (c4343a != null) {
                    c4343a.m1029a(m842d);
                    return;
                }
                return;
            case 9:
                String m846a4 = C4389j.m846a(jSONObject, "status");
                if (m846a4 == null || !"01".equals(m846a4)) {
                    JSONArray m842d2 = C4389j.m842d(jSONObject, "options");
                    String m846a5 = C4389j.m846a(jSONObject, "empty_info");
                    C4343a c4343a2 = this.f22682D;
                    if (c4343a2 != null) {
                        c4343a2.m1028a(m842d2, m846a5);
                        return;
                    }
                    return;
                }
                String m846a6 = C4389j.m846a(jSONObject, "uuid");
                if (this.f22680B >= 0) {
                    m1354d(this.f22684F, m846a6);
                    return;
                }
                String str = C4171c.f22227bD.f22231D;
                C4343a c4343a3 = this.f22682D;
                if (c4343a3 != null) {
                    c4343a3.m1028a((JSONArray) null, str);
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
        this.f22694x.setEnabled(!z);
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: a */
    protected final boolean mo1078a(String str, JSONObject jSONObject) {
        if (this.f22689s == 1) {
            m1351f(this.f22696z);
            m1407i();
            m1422a(str);
            return true;
        }
        return false;
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: b */
    protected final void mo1076b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        String str = C4171c.f22227bD.f22349o;
        C4449ay c4449ay = new C4449ay(this.f22593d, str, this);
        if (this.f22590a.f22402aC && ((this.f22590a.f22481q == null || this.f22590a.f22481q.size() == 0) && !this.f22590a.f22425aZ && !TextUtils.isEmpty(this.f22590a.f22485u))) {
            c4449ay = new C4449ay(this.f22593d, str, this.f22592c.m1037a(1030, -1, -1), C4386g.m858a(this.f22593d, 20.0f), this);
        }
        layoutParams.addRule(13, -1);
        this.f22600k.addView(c4449ay, layoutParams);
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: b */
    public final void mo1137b(int i) {
        if (this.f22689s == 16) {
            if (this.f22591b != null) {
                this.f22591b.m630c();
            }
            AbstractC4486z m1019c = this.f22682D.m1019c("instalment");
            if (m1019c != null) {
                C4474p c4474p = (C4474p) m1019c;
                c4474p.m619a(false);
                c4474p.m616b(false);
            }
        }
        super.mo1137b(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: b */
    public final void mo1357b(String str, JSONObject jSONObject) {
        if ("init".equals(str)) {
            m1428a(2);
        } else if (!"".equals(str)) {
            this.f22591b.m635a(C4171c.f22227bD.f22248U);
            this.f22599j = false;
            this.f22689s = 7;
            this.f22594e.m1506c(str, "");
        } else {
            if (this.f22689s == 5) {
                this.f22590a.f22386L = true;
            }
            if (jSONObject != null) {
                m1353d(jSONObject);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0372, code lost:
        if (r1.m1016e() == false) goto L28;
     */
    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void mo1072c() {
        /*
            Method dump skipped, instructions count: 1056
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.mobile.android.nocard.views.C4245o.mo1072c():void");
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: c */
    public final void mo821c(String str) {
        StringBuilder sb;
        String mo1544a;
        this.f22599j = false;
        this.f22591b.m635a(C4171c.f22227bD.f22248U);
        if (this.f22590a.f22425aZ) {
            sb = new StringBuilder("\"card\":\"");
            mo1544a = this.f22590a.f22442aq;
        } else {
            sb = new StringBuilder("\"card\":\"");
            mo1544a = this.f22590a.f22427ab.get(this.f22695y).mo1544a();
        }
        sb.append(mo1544a);
        sb.append("\"");
        String sb2 = sb.toString();
        C4390k.m838a("uppay", "cmd:" + str + ", ele:" + sb2);
        this.f22594e.m1506c(str, sb2);
        this.f22689s = 6;
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: c */
    public final void mo820c(String str, String str2) {
        m1420a(str, str2);
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: k */
    public final void mo1056k() {
        if (!TextUtils.isEmpty(this.f22590a.f22485u) && this.f22590a.f22402aC && (this.f22590a.f22481q == null || this.f22590a.f22481q.size() == 0)) {
            this.f22591b.m636a(new View$OnClickListenerC4251s(this), new View$OnClickListenerC4252t(this));
            this.f22591b.m633a(C4171c.f22227bD.f22252Y, C4171c.f22227bD.f22302av, C4171c.f22227bD.f22250W, C4171c.f22227bD.f22251X);
            return;
        }
        if (this.f22590a.f22425aZ) {
            this.f22590a.f22425aZ = false;
        }
        C4343a c4343a = this.f22690t;
        if (c4343a == null || !c4343a.m1018d()) {
            if (this.f22590a.f22485u == null || this.f22590a.f22485u.length() <= 0) {
                m1405m();
            } else {
                m1428a(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: r */
    public final void mo767r() {
        AbstractC4486z m1019c;
        this.f22591b.m635a(C4171c.f22227bD.f22248U);
        String str = "\"\"";
        if (this.f22682D.m1019c("promotion") != null) {
            str = "\"" + ((C4432aj) m1019c).m692g() + "\"";
        }
        this.f22594e.m1506c("instalment", "\"promotion\":".concat(String.valueOf(str)));
        this.f22689s = 16;
    }
}
