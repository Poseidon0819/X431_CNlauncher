package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.model.InterfaceC4176e;
import com.unionpay.mobile.android.nocard.utils.C4190f;
import com.unionpay.mobile.android.upviews.C4343a;
import com.unionpay.mobile.android.upwidget.C4354a;
import com.unionpay.mobile.android.utils.C4386g;
import com.unionpay.mobile.android.utils.C4388i;
import com.unionpay.mobile.android.utils.C4389j;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.mobile.android.utils.C4394o;
import com.unionpay.mobile.android.widgets.C4449ay;
import com.unionpay.tsmservice.data.Constant;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.nocard.views.g */
/* loaded from: classes2.dex */
public final class C4237g extends AbstractC4219b implements C4343a.InterfaceC4345b {

    /* renamed from: r */
    private int f22643r;

    /* renamed from: s */
    private int f22644s;

    /* renamed from: t */
    private C4354a f22645t;

    /* renamed from: u */
    private TextView f22646u;

    /* renamed from: v */
    private C4343a f22647v;

    /* renamed from: w */
    private boolean f22648w;

    /* renamed from: x */
    private boolean f22649x;

    /* renamed from: y */
    private View.OnClickListener f22650y;

    /* renamed from: z */
    private View.OnClickListener f22651z;

    public C4237g(Context context) {
        super(context);
        this.f22643r = 20;
        this.f22644s = 100;
        this.f22645t = null;
        this.f22646u = null;
        this.f22647v = null;
        this.f22648w = false;
        this.f22649x = true;
        this.f22650y = new View$OnClickListenerC4238h(this);
        this.f22651z = new View$OnClickListenerC4239i(this);
        this.f22595f = 5;
        this.f22606q = this.f22590a.f22385K ? "entrust_phoneNO_change" : "entrust";
        this.f22649x = true ^ this.f22590a.f22385K;
        setBackgroundColor(-1052684);
        m1410e();
    }

    /* renamed from: d */
    private void m1381d(JSONObject jSONObject) {
        m1407i();
        this.f22590a.f22490z = C4389j.m842d(jSONObject, "rules");
        this.f22590a.f22375A = C4389j.m846a(jSONObject, "title");
        this.f22590a.f22377C = C4389j.m843c(jSONObject, "followrules_button");
        this.f22590a.f22437al = C4389j.m843c(jSONObject, "service_checkbox");
        this.f22590a.f22438am = C4389j.m843c(jSONObject, "bind_card_checkbox");
        this.f22590a.f22442aq = C4389j.m846a(jSONObject, Constant.KEY_PAN);
        if (this.f22590a.f22490z == null || this.f22590a.f22490z.length() <= 0) {
            mo1137b(2);
            return;
        }
        C4343a c4343a = this.f22647v;
        if (c4343a != null) {
            c4343a.m1015f();
        }
        InterfaceC4176e m1476a = C4190f.m1476a(jSONObject);
        this.f22590a.f22385K = false;
        m1427a(6, m1476a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public void m1380s() {
        this.f22594e.m1493j(this.f22647v.m1031a(Constant.KEY_PAN));
        this.f22644s = 104;
    }

    /* renamed from: t */
    private void m1379t() {
        this.f22644s = 103;
        this.f22594e.m1513a("query", this.f22590a.f22435aj, 3);
        this.f22643r--;
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: a */
    public final void mo827a(C4343a.C4344a c4344a) {
        if (!c4344a.m1014a()) {
            m1422a(c4344a.f23028b);
            return;
        }
        this.f22599j = false;
        this.f22644s = 101;
        this.f22591b.m635a(C4171c.f22227bD.f22248U);
        C4390k.m838a("uppay", "sms elements:" + c4344a.f23028b);
        this.f22594e.m1506c("sms", c4344a.f23028b);
    }

    @Override // com.unionpay.mobile.android.nocard.views.InterfaceC4191a
    /* renamed from: a */
    public final void mo1077a(JSONObject jSONObject) {
        this.f22649x = false;
        switch (this.f22644s) {
            case 101:
                this.f22647v.m1034a(C4150b.f22153p);
                this.f22591b.m630c();
                this.f22644s = 100;
                return;
            case 102:
                this.f22590a.f22435aj = C4388i.m851a(jSONObject.toString());
                if (this.f22590a.f22435aj == null || this.f22590a.f22435aj.length() <= 0) {
                    mo1137b(2);
                    return;
                }
                this.f22643r = 20;
                m1379t();
                return;
            case 103:
                String m846a = C4389j.m846a(jSONObject, "status");
                String m846a2 = C4389j.m846a(jSONObject, "fail_msg");
                if (this.f22643r > 0 && m846a.equalsIgnoreCase("01")) {
                    m1379t();
                    return;
                }
                this.f22644s = 100;
                if (m846a.equalsIgnoreCase("00")) {
                    this.f22648w = true;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f22606q);
                    sb.append("_open_succeed");
                    m1380s();
                    return;
                }
                m1407i();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f22606q);
                sb2.append("_open_fail");
                String[] strArr = C4394o.f23207j;
                String[] strArr2 = {m846a, m846a2};
                if (!m846a.equalsIgnoreCase("03")) {
                    if (this.f22643r <= 0) {
                        m1422a(this.f22590a.f22436ak);
                        return;
                    }
                    return;
                }
                View$OnClickListenerC4240j view$OnClickListenerC4240j = new View$OnClickListenerC4240j(this);
                View$OnClickListenerC4241k view$OnClickListenerC4241k = new View$OnClickListenerC4241k(this);
                if (this.f22590a.f22380F) {
                    this.f22591b.m636a(view$OnClickListenerC4240j, view$OnClickListenerC4241k);
                    this.f22591b.m633a(C4171c.f22227bD.f22282ab, m846a2, C4171c.f22227bD.f22283ac, C4171c.f22227bD.f22284ad);
                    return;
                }
                this.f22591b.m636a(view$OnClickListenerC4240j, null);
                this.f22591b.m634a(C4171c.f22227bD.f22282ab, m846a2, C4171c.f22227bD.f22283ac);
                return;
            case 104:
                if (m1414b(jSONObject)) {
                    return;
                }
                m1381d(jSONObject);
                return;
            case 105:
                m1407i();
                int m1478a = C4190f.m1478a(this.f22590a, jSONObject, false);
                if (m1478a != 0) {
                    mo1137b(m1478a);
                    return;
                }
                InterfaceC4176e m1476a = C4190f.m1476a(jSONObject);
                if (this.f22590a.f22490z != null && this.f22590a.f22490z.length() > 0) {
                    m1427a(6, m1476a);
                    return;
                } else if (this.f22590a.f22378D == null || this.f22590a.f22378D.length() <= 0) {
                    return;
                } else {
                    m1411d(5);
                    return;
                }
            default:
                return;
        }
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: a */
    public final void mo822a(boolean z) {
        TextView textView = this.f22646u;
        if (textView != null) {
            textView.setEnabled(!z);
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: a */
    protected final boolean mo1078a(String str, JSONObject jSONObject) {
        this.f22649x = false;
        return false;
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: b */
    protected final void mo1076b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        C4449ay c4449ay = new C4449ay(getContext(), this.f22590a.f22375A, this);
        layoutParams.addRule(13, -1);
        this.f22600k.addView(c4449ay, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: b */
    public final void mo1357b(String str, JSONObject jSONObject) {
        if ("init".equals(str)) {
            m1428a(2);
        } else if ("".equals(str)) {
            m1381d(jSONObject);
        } else {
            this.f22591b.m635a(C4171c.f22227bD.f22248U);
            this.f22599j = false;
            this.f22644s = 105;
            this.f22594e.m1506c(str, "");
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: c */
    protected final void mo1072c() {
        this.f22604o.m995a(this);
        LinearLayout linearLayout = new LinearLayout(this.f22593d);
        linearLayout.setOrientation(1);
        linearLayout.setId(linearLayout.hashCode());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        int i = C4149a.f22115d;
        this.f22602m.addView(linearLayout, layoutParams);
        this.f22647v = new C4343a(this.f22593d, this.f22590a.f22378D, this.f22594e.m1508c(), this, this.f22590a.f22442aq, true, this.f22606q);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.topMargin = C4149a.f22117f;
        linearLayout.addView(this.f22647v, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = i;
        layoutParams3.leftMargin = C4149a.f22117f;
        layoutParams3.addRule(3, linearLayout.getId());
        LinearLayout linearLayout2 = new LinearLayout(this.f22593d);
        boolean z = false;
        linearLayout2.setOrientation(0);
        linearLayout2.setId(linearLayout2.hashCode());
        Context context = this.f22593d;
        JSONObject jSONObject = this.f22590a.f22437al;
        View.OnClickListener onClickListener = this.f22651z;
        this.f22645t = new C4354a(context, jSONObject, onClickListener, this.f22606q + "_agree_user_protocol");
        linearLayout2.addView(this.f22645t, new LinearLayout.LayoutParams(-2, -2));
        this.f22602m.addView(linearLayout2, layoutParams3);
        this.f22646u = new TextView(this.f22593d);
        this.f22646u.setText(C4389j.m846a(this.f22590a.f22377C, "label"));
        this.f22646u.setTextSize(C4150b.f22146i);
        this.f22646u.setTextColor(m1403o());
        this.f22646u.setGravity(17);
        int i2 = C4149a.f22125n;
        this.f22646u.setBackgroundDrawable(this.f22592c.m1037a(UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE, -1, -1));
        this.f22646u.setOnClickListener(this.f22650y);
        TextView textView = this.f22646u;
        C4343a c4343a = this.f22647v;
        textView.setEnabled((c4343a == null || c4343a.m1016e()) ? true : true);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, i2);
        layoutParams4.topMargin = C4149a.f22117f;
        int m858a = C4386g.m858a(this.f22593d, 10.0f);
        layoutParams4.rightMargin = m858a;
        layoutParams4.leftMargin = m858a;
        layoutParams4.addRule(3, linearLayout2.getId());
        this.f22602m.addView(this.f22646u, layoutParams4);
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: c */
    public final void mo821c(String str) {
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: c */
    public final void mo820c(String str, String str2) {
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: k */
    public final void mo1056k() {
        if (this.f22647v.m1018d()) {
            return;
        }
        if (this.f22590a.f22386L) {
            m1428a(13);
            this.f22590a.f22386L = false;
        } else if (this.f22590a.f22385K && this.f22649x) {
            this.f22590a.f22385K = false;
            C4190f.m1479a(this.f22590a, this.f22590a.f22381G);
            m1405m();
        } else {
            this.f22590a.f22385K = false;
            this.f22590a.f22381G = null;
            m1428a(2);
        }
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: r */
    public final void mo767r() {
    }
}
