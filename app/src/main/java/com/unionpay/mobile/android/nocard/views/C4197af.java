package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.nocard.utils.C4190f;
import com.unionpay.mobile.android.upviews.C4343a;
import com.unionpay.mobile.android.upwidget.C4378w;
import com.unionpay.mobile.android.widgets.C4449ay;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.nocard.views.af */
/* loaded from: classes2.dex */
public final class C4197af extends AbstractC4219b implements C4343a.InterfaceC4345b {

    /* renamed from: r */
    private TextView f22530r;

    /* renamed from: s */
    private View.OnClickListener f22531s;

    /* renamed from: t */
    private C4343a f22532t;

    /* renamed from: u */
    private int f22533u;

    public C4197af(Context context) {
        super(context);
        this.f22530r = null;
        this.f22531s = null;
        this.f22532t = null;
        this.f22533u = 0;
        this.f22595f = 12;
        this.f22531s = new View$OnClickListenerC4198ag(this);
        setBackgroundColor(-1052684);
        m1410e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m1473a(C4197af c4197af) {
        c4197af.f22533u = 1;
        C4343a.C4344a m1024b = c4197af.f22532t.m1024b();
        if (!m1024b.m1014a()) {
            c4197af.m1422a(m1024b.f23028b);
            return;
        }
        c4197af.f22599j = false;
        c4197af.f22591b.m635a(C4171c.f22227bD.f22248U);
        c4197af.f22594e.m1490m(m1024b.f23028b);
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: a */
    public final void mo827a(C4343a.C4344a c4344a) {
    }

    @Override // com.unionpay.mobile.android.nocard.views.InterfaceC4191a
    /* renamed from: a */
    public final void mo1077a(JSONObject jSONObject) {
        if (this.f22533u != 1) {
            return;
        }
        this.f22591b.m630c();
        C4190f.m1474c(this.f22590a, jSONObject);
        int m1475b = C4190f.m1475b(this.f22590a, jSONObject);
        if (m1475b != 0) {
            mo1137b(m1475b);
            return;
        }
        C4343a c4343a = this.f22532t;
        if (c4343a != null) {
            c4343a.m1015f();
        }
        m1411d(13);
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: a */
    public final void mo822a(boolean z) {
        TextView textView = this.f22530r;
        if (textView != null) {
            textView.setEnabled(!z);
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: b */
    protected final void mo1076b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        C4449ay c4449ay = new C4449ay(this.f22593d, C4171c.f22227bD.f22347m, this);
        layoutParams.addRule(13, -1);
        this.f22600k.addView(c4449ay, layoutParams);
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: c */
    protected final void mo1072c() {
        this.f22604o.m995a(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10, -1);
        layoutParams.topMargin = C4149a.f22117f;
        this.f22532t = new C4343a(this.f22593d, this.f22590a.f22398X, this, "");
        boolean z = true;
        this.f22532t.setOrientation(1);
        C4343a c4343a = this.f22532t;
        c4343a.setId(c4343a.hashCode());
        this.f22602m.addView(this.f22532t, layoutParams);
        C4378w m910a = C4378w.m910a(this.f22593d, this.f22590a.f22399Y, this.f22592c.m1037a(1017, -1, -1));
        if (m910a != null) {
            m910a.setId(m910a.hashCode());
            m910a.m909a(new View$OnClickListenerC4199ah(this, m910a.m911a()));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(3, this.f22532t.getId());
            int i = C4149a.f22115d;
            layoutParams2.bottomMargin = i;
            layoutParams2.topMargin = i;
            layoutParams2.leftMargin = C4149a.f22115d;
            this.f22602m.addView(m910a, layoutParams2);
        }
        this.f22530r = new TextView(this.f22593d);
        this.f22530r.setText(C4171c.f22227bD.f22348n);
        this.f22530r.setTextSize(C4150b.f22146i);
        this.f22530r.setTextColor(m1403o());
        this.f22530r.setGravity(17);
        TextView textView = this.f22530r;
        C4343a c4343a2 = this.f22532t;
        if (c4343a2 != null && !c4343a2.m1016e()) {
            z = false;
        }
        textView.setEnabled(z);
        int i2 = C4149a.f22125n;
        this.f22530r.setBackgroundDrawable(this.f22592c.m1037a(UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE, -1, -1));
        this.f22530r.setOnClickListener(this.f22531s);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, i2);
        layoutParams3.addRule(3, m910a != null ? m910a.getId() : this.f22532t.getId());
        layoutParams3.topMargin = C4149a.f22117f;
        this.f22602m.addView(this.f22530r, layoutParams3);
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: c */
    public final void mo821c(String str) {
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: c */
    public final void mo820c(String str, String str2) {
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: r */
    public final void mo767r() {
    }
}
