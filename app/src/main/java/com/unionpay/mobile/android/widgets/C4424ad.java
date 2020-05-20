package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.itextpdf.text.html.HtmlTags;
import com.unionpay.mobile.android.data.C4147a;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.utils.C4389j;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.widgets.ad */
/* loaded from: classes2.dex */
public final class C4424ad extends AbstractC4486z {

    /* renamed from: a */
    private int f23327a;

    /* renamed from: b */
    private String f23328b;

    /* renamed from: c */
    private TextView f23329c;

    /* renamed from: o */
    private TextView f23330o;

    public C4424ad(Context context, int i, JSONObject jSONObject, String str) {
        this(context, i, jSONObject, str, (byte) 0);
    }

    private C4424ad(Context context, int i, JSONObject jSONObject, String str, byte b) {
        super(context, jSONObject, str);
        this.f23327a = 0;
        this.f23327a = i;
        if (jSONObject != null) {
            this.f23328b = C4389j.m846a(jSONObject, HtmlTags.STYLE);
        }
        RelativeLayout relativeLayout = this.f23406m;
        LinearLayout linearLayout = new LinearLayout(this.f23397d);
        relativeLayout.addView(linearLayout, new RelativeLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(0);
        this.f23329c = new TextView(this.f23397d);
        this.f23329c.setTextSize(C4150b.f22148k);
        this.f23329c.setText(m672p());
        this.f23329c.setGravity(3);
        this.f23329c.setTextColor(-13421773);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 0.3f);
        layoutParams.gravity = 3;
        linearLayout.addView(this.f23329c, layoutParams);
        this.f23330o = new TextView(this.f23397d);
        this.f23330o.setGravity(16);
        this.f23330o.setTextSize(C4150b.f22148k);
        this.f23330o.setText(C4147a.m1611a(mo579i(), this.f23328b));
        this.f23330o.setPadding(0, 0, C4149a.f22118g, 0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 0.7f);
        layoutParams2.gravity = 21;
        linearLayout.addView(this.f23330o, layoutParams2);
    }

    public C4424ad(Context context, JSONObject jSONObject, String str) {
        super(context, jSONObject, str);
        this.f23327a = 0;
        String p = m672p();
        if (p != null && p.length() > 0) {
            this.f23329c = new TextView(this.f23397d);
            this.f23329c.setTextSize(C4150b.f22148k);
            this.f23329c.setText(m672p());
            this.f23329c.setTextColor(-7829368);
            addView(this.f23329c);
        }
        String i = mo579i();
        if (i == null || i.length() <= 0) {
            return;
        }
        this.f23330o = new TextView(this.f23397d);
        this.f23330o.setTextSize(C4150b.f22148k);
        this.f23330o.setTextColor(-7829368);
        this.f23330o.setText(mo579i());
        addView(this.f23330o);
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: a */
    public final String mo585a() {
        return null;
    }

    /* renamed from: a */
    public final void m718a(float f) {
        this.f23330o.setTextSize(f);
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: b */
    public final boolean mo584b() {
        return true;
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: c */
    public final boolean mo583c() {
        return true;
    }

    /* renamed from: g */
    public final void m717g() {
        this.f23330o.setTextColor(-6710887);
    }
}
