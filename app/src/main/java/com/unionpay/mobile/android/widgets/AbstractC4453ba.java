package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.itextpdf.text.pdf.PdfBoolean;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.resource.C4342c;
import com.unionpay.mobile.android.utils.C4386g;
import com.unionpay.mobile.android.utils.C4389j;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.widgets.ba */
/* loaded from: classes2.dex */
public abstract class AbstractC4453ba extends LinearLayout {

    /* renamed from: a */
    private String f23394a;

    /* renamed from: b */
    private String f23395b;

    /* renamed from: c */
    private String f23396c;

    /* renamed from: d */
    protected Context f23397d;

    /* renamed from: e */
    protected int f23398e;

    /* renamed from: f */
    protected int f23399f;

    /* renamed from: g */
    protected String f23400g;

    /* renamed from: h */
    protected String f23401h;

    /* renamed from: i */
    protected boolean f23402i;

    /* renamed from: j */
    protected String f23403j;

    /* renamed from: k */
    protected LinearLayout f23404k;

    /* renamed from: l */
    protected TextView f23405l;

    /* renamed from: m */
    protected RelativeLayout f23406m;

    /* renamed from: n */
    protected JSONObject f23407n;

    /* renamed from: o */
    private String f23408o;

    /* renamed from: p */
    private TextView f23409p;

    /* renamed from: q */
    private ImageView f23410q;

    /* renamed from: r */
    private boolean f23411r;

    /* renamed from: s */
    private String f23412s;

    /* renamed from: com.unionpay.mobile.android.widgets.ba$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC4454a {
        /* renamed from: a */
        String mo585a();

        /* renamed from: b */
        boolean mo584b();

        /* renamed from: c */
        boolean mo583c();
    }

    public AbstractC4453ba(Context context, JSONObject jSONObject, String str) {
        super(context);
        this.f23397d = null;
        this.f23398e = -16777216;
        this.f23399f = -7829368;
        this.f23394a = null;
        this.f23400g = null;
        this.f23395b = null;
        this.f23401h = null;
        this.f23396c = null;
        this.f23408o = null;
        this.f23402i = false;
        this.f23403j = null;
        this.f23409p = null;
        this.f23404k = null;
        this.f23405l = null;
        this.f23410q = null;
        this.f23406m = null;
        this.f23411r = false;
        this.f23412s = "uppay";
        this.f23407n = jSONObject;
        this.f23397d = context;
        this.f23401h = C4389j.m846a(jSONObject, "label");
        this.f23408o = C4389j.m846a(jSONObject, "placeholder");
        this.f23396c = C4389j.m846a(jSONObject, "tip");
        this.f23394a = C4389j.m846a(jSONObject, "name");
        this.f23400g = C4389j.m846a(jSONObject, "value");
        this.f23395b = C4389j.m846a(jSONObject, VastExtensionXmlManager.TYPE);
        this.f23403j = C4389j.m846a(jSONObject, "regexp");
        String m846a = C4389j.m846a(jSONObject, "readonly");
        if (m846a != null && m846a.equalsIgnoreCase(PdfBoolean.TRUE)) {
            this.f23402i = true;
        }
        this.f23411r = C4389j.m846a(jSONObject, "margin").length() > 0;
        this.f23412s = str;
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundColor(0);
        setOrientation(1);
        setPadding(2, 2, 2, 2);
        if (this.f23395b.equalsIgnoreCase("string")) {
            m675g();
            return;
        }
        if (!mo626a(this, this.f23401h)) {
            this.f23409p = new TextView(this.f23397d);
            this.f23409p.setTextSize(20.0f);
            this.f23409p.setText("");
            this.f23409p.setTextColor(this.f23398e);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.leftMargin = C4149a.f22117f;
            addView(this.f23409p, layoutParams);
            String str2 = this.f23401h;
            if (str2 != null && str2.length() != 0) {
                this.f23409p.setText(this.f23401h);
            }
            this.f23409p.setVisibility(8);
        }
        m675g();
        if (mo615b_()) {
            return;
        }
        this.f23404k = new LinearLayout(this.f23397d);
        this.f23404k.setBackgroundColor(-267336);
        addView(this.f23404k, new LinearLayout.LayoutParams(-1, -2));
        this.f23405l = new TextView(this.f23397d);
        this.f23405l.setTextSize(15.0f);
        this.f23405l.setTextColor(this.f23399f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        int m858a = C4386g.m858a(this.f23397d, 10.0f);
        layoutParams2.rightMargin = m858a;
        layoutParams2.leftMargin = m858a;
        int m858a2 = C4386g.m858a(this.f23397d, 5.0f);
        layoutParams2.bottomMargin = m858a2;
        layoutParams2.topMargin = m858a2;
        this.f23404k.addView(this.f23405l, layoutParams2);
        String str3 = this.f23396c;
        if (str3 == null || str3.length() <= 0) {
            this.f23404k.setVisibility(8);
            this.f23410q.setVisibility(8);
            return;
        }
        this.f23410q.setVisibility(0);
        this.f23405l.setText(this.f23396c);
    }

    /* renamed from: g */
    private void m675g() {
        FrameLayout frameLayout = new FrameLayout(this.f23397d);
        addView(frameLayout, new LinearLayout.LayoutParams(-1, -2));
        this.f23406m = new RelativeLayout(this.f23397d);
        frameLayout.addView(this.f23406m, new FrameLayout.LayoutParams(-1, -2));
        this.f23410q = new ImageView(this.f23397d);
        this.f23410q.setBackgroundDrawable(C4342c.m1036a(this.f23397d).m1037a(1038, -1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(C4386g.m858a(this.f23397d, 10.0f), C4386g.m858a(this.f23397d, 5.0f));
        layoutParams.gravity = 80;
        layoutParams.leftMargin = C4386g.m858a(this.f23397d, 20.0f);
        this.f23410q.setVisibility(8);
        frameLayout.addView(this.f23410q, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m677a(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.f23409p == null || charSequence.length() <= 0) {
            return;
        }
        this.f23409p.setText(charSequence, bufferType);
    }

    /* renamed from: a */
    protected boolean mo626a(LinearLayout linearLayout, String str) {
        return false;
    }

    /* renamed from: a */
    public boolean mo582a(String str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: b_ */
    protected boolean mo615b_() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public final void m676c(String str) {
        if (this.f23405l == null || str == null || str.length() <= 0) {
            return;
        }
        this.f23405l.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public String mo613d() {
        return "_input_method";
    }

    /* renamed from: f */
    public boolean mo581f() {
        return true;
    }

    /* renamed from: i */
    public String mo579i() {
        return this.f23400g;
    }

    /* renamed from: n */
    public final String m674n() {
        return this.f23394a;
    }

    /* renamed from: o */
    public final String m673o() {
        return this.f23395b;
    }

    /* renamed from: p */
    public final String m672p() {
        return this.f23401h;
    }

    /* renamed from: q */
    public final String m671q() {
        return this.f23396c;
    }

    /* renamed from: r */
    public final String m670r() {
        return this.f23408o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: s */
    public final String m669s() {
        return this.f23412s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: t */
    public final void m668t() {
        TextView textView = this.f23409p;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: u */
    public final void m667u() {
        TextView textView = this.f23405l;
        if (textView != null) {
            textView.setVisibility(0);
            this.f23410q.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: v */
    public final void m666v() {
        TextView textView = this.f23409p;
        if (textView != null) {
            textView.setTextSize(16.0f);
        }
    }
}
