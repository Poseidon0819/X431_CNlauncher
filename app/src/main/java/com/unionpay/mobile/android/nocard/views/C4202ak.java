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
import com.unionpay.mobile.android.upviews.C4343a;
import com.unionpay.mobile.android.upwidget.C4354a;
import com.unionpay.mobile.android.utils.C4388i;
import com.unionpay.mobile.android.utils.C4389j;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.mobile.android.widgets.C4449ay;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.nocard.views.ak */
/* loaded from: classes2.dex */
public final class C4202ak extends AbstractC4219b implements C4343a.InterfaceC4345b {

    /* renamed from: r */
    private int f22540r;

    /* renamed from: s */
    private int f22541s;

    /* renamed from: t */
    private C4354a f22542t;

    /* renamed from: u */
    private TextView f22543u;

    /* renamed from: v */
    private C4343a f22544v;

    /* renamed from: w */
    private View.OnClickListener f22545w;

    /* renamed from: x */
    private View.OnClickListener f22546x;

    public C4202ak(Context context) {
        super(context);
        this.f22540r = 100;
        this.f22541s = 20;
        this.f22542t = null;
        this.f22543u = null;
        this.f22544v = null;
        this.f22545w = new View$OnClickListenerC4203al(this);
        this.f22546x = new View$OnClickListenerC4204am(this);
        this.f22595f = 10;
        this.f22606q = "openupgrade";
        setBackgroundColor(-1052684);
        this.f22600k = m1429a();
        mo1076b();
        super.mo1373d();
        mo1072c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static /* synthetic */ int m1468c(C4202ak c4202ak) {
        c4202ak.f22540r = 102;
        return 102;
    }

    /* renamed from: s */
    private void m1467s() {
        this.f22540r = 103;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f22541s);
        C4390k.m836c("uppay", sb.toString());
        this.f22594e.m1513a("query", this.f22590a.f22435aj, 3);
        this.f22541s--;
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: a */
    public final void mo827a(C4343a.C4344a c4344a) {
        if (!c4344a.m1014a()) {
            m1422a(c4344a.f23028b);
            return;
        }
        this.f22599j = false;
        this.f22540r = 101;
        this.f22591b.m635a(C4171c.f22227bD.f22248U);
        C4390k.m838a("uppay", "sms elements:" + c4344a.f23028b);
        this.f22594e.m1506c("sms", c4344a.f23028b);
    }

    @Override // com.unionpay.mobile.android.nocard.views.InterfaceC4191a
    /* renamed from: a */
    public final void mo1077a(JSONObject jSONObject) {
        switch (this.f22540r) {
            case 101:
                this.f22544v.m1034a(C4150b.f22153p);
                this.f22591b.m630c();
                this.f22540r = 100;
                return;
            case 102:
                this.f22590a.f22435aj = C4388i.m851a(jSONObject.toString());
                if (this.f22590a.f22435aj == null || this.f22590a.f22435aj.length() <= 0) {
                    mo1137b(2);
                    return;
                }
                this.f22541s = 20;
                m1467s();
                return;
            case 103:
                String m846a = C4389j.m846a(jSONObject, "status");
                String m846a2 = C4389j.m846a(jSONObject, "fail_msg");
                this.f22590a.f22393S = C4389j.m846a(jSONObject, "open_info");
                this.f22590a.f22375A = C4389j.m846a(jSONObject, "title");
                this.f22590a.f22376B = C4389j.m846a(jSONObject, "succ_info");
                if (this.f22541s > 0 && m846a.equalsIgnoreCase("01")) {
                    m1467s();
                    return;
                }
                this.f22540r = 100;
                m1407i();
                if (m846a.equalsIgnoreCase("00")) {
                    m1411d(11);
                    return;
                } else if (m846a.equalsIgnoreCase("03")) {
                    this.f22591b.m636a(new View$OnClickListenerC4205an(this), null);
                    this.f22591b.m634a(C4171c.f22227bD.f22282ab, m846a2, C4171c.f22227bD.f22283ac);
                    return;
                } else if (this.f22541s <= 0) {
                    mo1137b(20);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: a */
    public final void mo822a(boolean z) {
        TextView textView = this.f22543u;
        if (textView != null) {
            textView.setEnabled(!z);
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: b */
    protected final void mo1076b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        C4449ay c4449ay = new C4449ay(getContext(), this.f22590a.f22375A, this);
        layoutParams.addRule(13, -1);
        this.f22600k.addView(c4449ay, layoutParams);
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: c */
    protected final void mo1072c() {
        LinearLayout linearLayout = new LinearLayout(this.f22593d);
        linearLayout.setBackgroundColor(-1);
        boolean z = true;
        linearLayout.setOrientation(1);
        linearLayout.setId(linearLayout.hashCode());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        int i = C4149a.f22117f;
        layoutParams.rightMargin = i;
        layoutParams.leftMargin = i;
        this.f22602m.addView(linearLayout, layoutParams);
        this.f22544v = new C4343a(this.f22593d, this.f22590a.f22394T, this.f22594e.m1508c(), this, this.f22590a.f22442aq, true, this.f22606q);
        new LinearLayout.LayoutParams(-1, -1).topMargin = C4149a.f22117f;
        linearLayout.addView(this.f22544v);
        LinearLayout linearLayout2 = new LinearLayout(this.f22593d);
        linearLayout2.setOrientation(1);
        linearLayout2.setId(linearLayout2.hashCode());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = C4149a.f22115d;
        layoutParams2.leftMargin = C4149a.f22115d;
        layoutParams2.addRule(3, linearLayout.getId());
        this.f22602m.addView(linearLayout2, layoutParams2);
        Context context = this.f22593d;
        JSONObject jSONObject = this.f22590a.f22437al;
        View.OnClickListener onClickListener = this.f22546x;
        this.f22542t = new C4354a(context, jSONObject, onClickListener, this.f22606q + "_agree_user_protocol");
        linearLayout2.addView(this.f22542t);
        this.f22543u = new TextView(this.f22593d);
        this.f22543u.setText(C4389j.m846a(this.f22590a.f22377C, "label"));
        this.f22543u.setTextSize(C4150b.f22146i);
        this.f22543u.setTextColor(m1403o());
        this.f22543u.setGravity(17);
        int i2 = C4149a.f22125n;
        this.f22543u.setBackgroundDrawable(this.f22592c.m1037a(UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE, -1, -1));
        this.f22543u.setOnClickListener(this.f22545w);
        TextView textView = this.f22543u;
        C4343a c4343a = this.f22544v;
        if (c4343a != null && !c4343a.m1016e()) {
            z = false;
        }
        textView.setEnabled(z);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, i2);
        layoutParams3.topMargin = C4149a.f22115d;
        int i3 = C4149a.f22115d;
        layoutParams3.rightMargin = i3;
        layoutParams3.leftMargin = i3;
        layoutParams3.addRule(3, linearLayout2.getId());
        this.f22602m.addView(this.f22543u, layoutParams3);
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
        if (this.f22544v.m1018d()) {
            return;
        }
        m1405m();
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: r */
    public final void mo767r() {
    }
}
