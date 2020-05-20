package com.unionpay.mobile.android.views.order;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.upviews.C4343a;
import com.unionpay.mobile.android.utils.C4386g;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.views.order.i */
/* loaded from: classes2.dex */
public final class C4411i extends AbstractMethod {

    /* renamed from: g */
    private JSONObject f23265g;

    /* renamed from: h */
    private JSONObject f23266h;

    /* renamed from: i */
    private C4343a f23267i;

    /* renamed from: j */
    private TextView f23268j;

    /* renamed from: k */
    private TextView f23269k;

    /* renamed from: l */
    private RelativeLayout f23270l;

    public C4411i(Context context) {
        super(context);
    }

    /* renamed from: e */
    private static JSONArray m770e(String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("label", "");
            jSONObject.put("name", "user_name");
            if (!m824a(str)) {
                jSONObject.put("value", str);
            }
            jSONObject.put("regexp", "[.@_A-Za-z0-9]{1,64}");
            jSONObject.put(VastExtensionXmlManager.TYPE, "user_name");
            jSONObject.put("tip", "");
            jSONObject.put("placeholder", C4171c.f22227bD.f22333bw);
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("label", "");
            jSONObject2.put("name", "password");
            jSONObject2.put(VastExtensionXmlManager.TYPE, "password");
            jSONObject2.put("placeholder", C4171c.f22227bD.f22334bx);
            jSONArray.put(jSONObject2);
        } catch (Exception unused) {
        }
        return jSONArray;
    }

    /* renamed from: a */
    public final C4411i m780a(JSONObject jSONObject) {
        this.f23265g = jSONObject;
        if (this.f23268j != null) {
            String a = m823a(this.f23265g, "label");
            if (!TextUtils.isEmpty(a)) {
                this.f23268j.setText(Html.fromHtml(a));
                RelativeLayout relativeLayout = this.f23270l;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
            }
        }
        return this;
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    /* renamed from: a */
    public final void mo782a(RelativeLayout relativeLayout) {
        TextView textView = new TextView(this.f23213b);
        textView.setText(this.f23214c);
        textView.setTextColor(-13421773);
        textView.setTextSize(C4150b.f22148k);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(15, -1);
        layoutParams.leftMargin = C4386g.m858a(this.f23213b, 10.0f);
        relativeLayout.addView(textView, layoutParams);
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    /* renamed from: b */
    public final int mo779b() {
        return InterfaceC4414l.f23275c.intValue();
    }

    /* renamed from: b */
    public final C4411i m776b(String str) {
        this.f23214c = str;
        return this;
    }

    /* renamed from: b */
    public final C4411i m775b(JSONObject jSONObject) {
        this.f23266h = jSONObject;
        if (this.f23269k != null) {
            String a = m823a(this.f23266h, "label");
            if (!TextUtils.isEmpty(a)) {
                this.f23269k.setText(Html.fromHtml(a));
                RelativeLayout relativeLayout = this.f23270l;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
            }
        }
        return this;
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    /* renamed from: b */
    public final void mo778b(RelativeLayout relativeLayout) {
        this.f23267i = new C4343a(this.f23213b, m770e(PreferenceUtils.m896c(this.f23213b)), this, "");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = C4149a.f22117f;
        relativeLayout.addView(this.f23267i, layoutParams);
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    /* renamed from: c */
    public final C4343a.C4344a mo774c() {
        C4343a c4343a = this.f23267i;
        if (c4343a != null) {
            return c4343a.m1024b();
        }
        return null;
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    /* renamed from: c */
    public final void mo773c(RelativeLayout relativeLayout) {
        String a = m823a(this.f23265g, "label");
        this.f23268j = new TextView(this.f23213b);
        m828a(this.f23268j);
        if (!TextUtils.isEmpty(a)) {
            this.f23268j.setText(Html.fromHtml(a));
        }
        this.f23268j.setOnClickListener(new View$OnClickListenerC4412j(this));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(15, -1);
        layoutParams.leftMargin = C4386g.m858a(this.f23213b, 10.0f);
        relativeLayout.addView(this.f23268j, layoutParams);
        String a2 = m823a(this.f23266h, "label");
        this.f23269k = new TextView(this.f23213b);
        m828a(this.f23269k);
        if (!TextUtils.isEmpty(a2)) {
            this.f23269k.setText(Html.fromHtml(a2));
        }
        this.f23269k.setOnClickListener(new View$OnClickListenerC4413k(this));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(11, -1);
        layoutParams2.addRule(15, -1);
        layoutParams2.rightMargin = C4386g.m858a(this.f23213b, 10.0f);
        relativeLayout.addView(this.f23269k, layoutParams2);
        if (TextUtils.isEmpty(a2) && TextUtils.isEmpty(a)) {
            relativeLayout.setVisibility(8);
        }
        this.f23270l = relativeLayout;
    }

    /* renamed from: d */
    public final C4411i m772d(String str) {
        this.f23215d = str;
        return this;
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    /* renamed from: e */
    public final String mo771e() {
        return this.f23215d;
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    /* renamed from: f */
    public final boolean mo769f() {
        C4343a c4343a = this.f23267i;
        return c4343a == null || c4343a.m1016e();
    }

    /* renamed from: h */
    public final String m768h() {
        C4343a c4343a = this.f23267i;
        return c4343a != null ? c4343a.m1022b("user_name") : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextUtils.isEmpty(m768h());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C4343a c4343a = this.f23267i;
        if (c4343a != null) {
            c4343a.m1015f();
        }
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: r */
    public final void mo767r() {
    }
}
