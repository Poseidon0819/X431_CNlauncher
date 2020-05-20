package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.itextpdf.text.pdf.ColumnText;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.resource.C4342c;
import com.unionpay.mobile.android.utils.C4386g;
import com.unionpay.mobile.android.utils.C4387h;
import com.unionpay.mobile.android.utils.C4389j;
import com.unionpay.mobile.android.utils.C4394o;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.upwidget.a */
/* loaded from: classes2.dex */
public final class C4354a extends LinearLayout {

    /* renamed from: a */
    private String f23053a;

    /* renamed from: b */
    private String f23054b;

    /* renamed from: c */
    private String f23055c;

    /* renamed from: d */
    private String f23056d;

    /* renamed from: e */
    private String f23057e;

    /* renamed from: f */
    private String f23058f;

    /* renamed from: g */
    private String f23059g;

    /* renamed from: h */
    private String f23060h;

    /* renamed from: i */
    private String f23061i;

    /* renamed from: j */
    private Button f23062j;

    /* renamed from: k */
    private boolean f23063k;

    /* renamed from: l */
    private Context f23064l;

    /* renamed from: m */
    private float f23065m;

    /* renamed from: n */
    private View.OnClickListener f23066n;

    /* renamed from: o */
    private String f23067o;

    /* renamed from: p */
    private TextView f23068p;

    /* renamed from: q */
    private String f23069q;

    public C4354a(Context context, JSONObject jSONObject, View.OnClickListener onClickListener, String str) {
        this(context, jSONObject, onClickListener, str, (byte) 0);
    }

    private C4354a(Context context, JSONObject jSONObject, View.OnClickListener onClickListener, String str, byte b) {
        super(context);
        this.f23053a = "";
        this.f23054b = "";
        this.f23055c = "";
        this.f23056d = "";
        this.f23057e = "";
        this.f23058f = "";
        this.f23059g = "";
        this.f23060h = "";
        this.f23061i = "";
        this.f23062j = null;
        this.f23063k = false;
        this.f23064l = null;
        this.f23065m = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f23066n = new View$OnClickListenerC4355b(this);
        this.f23064l = context;
        this.f23065m = 16.0f;
        this.f23069q = str;
        this.f23053a = C4389j.m846a(jSONObject, "name");
        this.f23054b = C4389j.m846a(jSONObject, "value");
        this.f23055c = C4389j.m846a(jSONObject, "label");
        this.f23056d = C4389j.m846a(jSONObject, "href_label");
        this.f23057e = C4389j.m846a(jSONObject, "href_url");
        this.f23058f = C4389j.m846a(jSONObject, "href_title");
        this.f23059g = C4389j.m846a(jSONObject, "checked");
        this.f23060h = C4389j.m846a(jSONObject, "required");
        this.f23061i = C4389j.m846a(jSONObject, "error_info");
        this.f23067o = C4389j.m846a(jSONObject, "ckb_style");
        this.f23062j = new Button(this.f23064l);
        if (m987a(this.f23059g) && this.f23059g.equalsIgnoreCase("0")) {
            this.f23063k = true;
        } else {
            this.f23063k = false;
        }
        this.f23062j.setOnClickListener(this.f23066n);
        m981g();
        m982f();
        int m858a = C4386g.m858a(this.f23064l, 20.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(m858a, m858a);
        layoutParams.gravity = 16;
        addView(this.f23062j, layoutParams);
        if (m987a(this.f23055c)) {
            this.f23068p = new TextView(this.f23064l);
            this.f23068p.setText(this.f23055c);
            this.f23068p.setTextSize(this.f23065m);
            this.f23068p.setTextColor(-16777216);
            this.f23068p.setOnClickListener(this.f23066n);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.leftMargin = C4149a.f22115d;
            addView(this.f23068p, layoutParams2);
        }
        if (m987a(this.f23056d) && m987a(this.f23057e)) {
            TextView textView = new TextView(this.f23064l);
            textView.setText(Html.fromHtml(this.f23056d));
            textView.setTextColor(C4387h.m854a(-10705958, -5846275, -5846275, -6710887));
            String.format("<u>%s</u>", this.f23056d);
            textView.setTextSize(this.f23065m);
            textView.setOnClickListener(onClickListener);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 16;
            addView(textView, layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m988a(C4354a c4354a) {
        c4354a.f23063k = !c4354a.f23063k;
        String str = c4354a.f23063k ? "y" : "n";
        String[] strArr = C4394o.f23204g;
        new String[1][0] = str;
        c4354a.m981g();
    }

    /* renamed from: a */
    private static boolean m987a(String str) {
        return str != null && str.length() > 0;
    }

    /* renamed from: f */
    private boolean m982f() {
        return "small".equalsIgnoreCase(this.f23067o);
    }

    /* renamed from: g */
    private void m981g() {
        if (this.f23062j == null) {
            return;
        }
        int i = this.f23063k ? 1008 : 1007;
        int m858a = m982f() ? C4386g.m858a(this.f23064l, 15.0f) : C4149a.f22134w;
        this.f23062j.setBackgroundDrawable(C4342c.m1036a(this.f23064l).m1037a(i, m858a, m858a));
    }

    /* renamed from: a */
    public final String m989a() {
        return String.format("\"%s\":\"%s\"", this.f23053a, this.f23063k ? this.f23054b : "");
    }

    /* renamed from: b */
    public final String m986b() {
        return this.f23061i;
    }

    /* renamed from: c */
    public final String m985c() {
        return this.f23057e;
    }

    /* renamed from: d */
    public final String m984d() {
        return this.f23058f;
    }

    /* renamed from: e */
    public final boolean m983e() {
        if (m987a(this.f23060h) && this.f23060h.equalsIgnoreCase("0")) {
            return this.f23063k;
        }
        return true;
    }
}
