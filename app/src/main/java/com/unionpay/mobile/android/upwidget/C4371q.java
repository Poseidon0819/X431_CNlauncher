package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.itextpdf.text.pdf.ColumnText;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.resource.C4342c;
import com.unionpay.mobile.android.utils.C4386g;
import com.unionpay.mobile.android.utils.C4387h;
import com.unionpay.mobile.android.utils.C4389j;
import com.unionpay.mobile.android.utils.C4394o;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.upwidget.q */
/* loaded from: classes2.dex */
public final class C4371q extends RelativeLayout {

    /* renamed from: a */
    private String f23143a;

    /* renamed from: b */
    private String f23144b;

    /* renamed from: c */
    private String f23145c;

    /* renamed from: d */
    private String f23146d;

    /* renamed from: e */
    private String f23147e;

    /* renamed from: f */
    private String f23148f;

    /* renamed from: g */
    private String f23149g;

    /* renamed from: h */
    private String f23150h;

    /* renamed from: i */
    private String f23151i;

    /* renamed from: j */
    private String f23152j;

    /* renamed from: k */
    private RelativeLayout f23153k;

    /* renamed from: l */
    private Button f23154l;

    /* renamed from: m */
    private boolean f23155m;

    /* renamed from: n */
    private Context f23156n;

    /* renamed from: o */
    private float f23157o;

    /* renamed from: p */
    private View.OnClickListener f23158p;

    /* renamed from: q */
    private View.OnClickListener f23159q;

    /* renamed from: r */
    private String f23160r;

    /* renamed from: s */
    private TextView f23161s;

    /* renamed from: t */
    private String f23162t;

    /* renamed from: u */
    private InterfaceC4372a f23163u;

    /* renamed from: com.unionpay.mobile.android.upwidget.q$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC4372a {
        /* renamed from: a */
        void mo913a(String str, String str2);

        /* renamed from: a */
        void mo912a(String str, boolean z);
    }

    public C4371q(Context context, JSONObject jSONObject, String str) {
        this(context, jSONObject, str, (byte) 0);
    }

    private C4371q(Context context, JSONObject jSONObject, String str, byte b) {
        super(context);
        this.f23143a = "";
        this.f23144b = "";
        this.f23145c = "";
        this.f23146d = "";
        this.f23147e = "";
        this.f23148f = "";
        this.f23149g = "";
        this.f23150h = "";
        this.f23151i = "";
        this.f23152j = "";
        this.f23154l = null;
        this.f23155m = false;
        this.f23156n = null;
        this.f23157o = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f23158p = new View$OnClickListenerC4373r(this);
        this.f23159q = new View$OnClickListenerC4374s(this);
        this.f23156n = context;
        this.f23157o = 16.0f;
        this.f23162t = str;
        this.f23143a = C4389j.m846a(jSONObject, "name");
        this.f23144b = C4389j.m846a(jSONObject, VastExtensionXmlManager.TYPE);
        this.f23145c = C4389j.m846a(jSONObject, "value");
        this.f23146d = C4389j.m846a(jSONObject, "label");
        this.f23147e = C4389j.m846a(jSONObject, "href_label");
        this.f23148f = C4389j.m846a(jSONObject, "href_url");
        this.f23149g = C4389j.m846a(jSONObject, "href_title");
        this.f23150h = C4389j.m846a(jSONObject, "checked");
        this.f23151i = C4389j.m846a(jSONObject, "required");
        this.f23152j = C4389j.m846a(jSONObject, "error_info");
        this.f23160r = C4389j.m846a(jSONObject, "ckb_style");
        this.f23153k = new RelativeLayout(this.f23156n);
        addView(this.f23153k, new RelativeLayout.LayoutParams(-1, C4149a.f22125n));
        if (m918a(this.f23146d)) {
            this.f23161s = new TextView(this.f23156n);
            TextView textView = this.f23161s;
            textView.setId(textView.hashCode());
            this.f23161s.setText(this.f23146d);
            this.f23161s.setTextSize(this.f23157o);
            this.f23161s.setTextColor(-16777216);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(9, -1);
            layoutParams.addRule(15, -1);
            this.f23153k.addView(this.f23161s, layoutParams);
        }
        this.f23154l = new Button(this.f23156n);
        Button button = this.f23154l;
        button.setId(button.hashCode());
        if (m918a(this.f23150h) && this.f23150h.equalsIgnoreCase("0")) {
            this.f23155m = true;
        } else {
            this.f23155m = false;
        }
        this.f23154l.setOnClickListener(this.f23158p);
        m914c();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(C4386g.m858a(this.f23156n, 60.0f), C4386g.m858a(this.f23156n, 34.0f));
        layoutParams2.addRule(11, -1);
        layoutParams2.addRule(15, -1);
        this.f23153k.addView(this.f23154l, layoutParams2);
        InterfaceC4372a interfaceC4372a = this.f23163u;
        if (interfaceC4372a != null) {
            interfaceC4372a.mo912a(this.f23144b, this.f23155m);
        }
        if (m918a(this.f23147e) && m918a(this.f23148f)) {
            TextView textView2 = new TextView(this.f23156n);
            textView2.setText(Html.fromHtml(this.f23147e));
            textView2.setTextSize(C4150b.f22149l);
            textView2.setOnClickListener(this.f23159q);
            textView2.setTextColor(C4387h.m854a(-10705958, -5846275, -5846275, -6710887));
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(1, this.f23161s.getId());
            layoutParams3.addRule(15, -1);
            layoutParams3.leftMargin = C4386g.m858a(this.f23156n, 10.0f);
            this.f23153k.addView(textView2, layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m919a(C4371q c4371q) {
        c4371q.f23155m = !c4371q.f23155m;
        String str = c4371q.f23155m ? "y" : "n";
        String[] strArr = C4394o.f23204g;
        new String[1][0] = str;
        InterfaceC4372a interfaceC4372a = c4371q.f23163u;
        if (interfaceC4372a != null) {
            interfaceC4372a.mo912a(c4371q.f23144b, c4371q.f23155m);
        }
        c4371q.m914c();
    }

    /* renamed from: a */
    private static boolean m918a(String str) {
        return str != null && str.length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ void m915b(C4371q c4371q) {
        InterfaceC4372a interfaceC4372a = c4371q.f23163u;
        if (interfaceC4372a != null) {
            interfaceC4372a.mo913a(c4371q.f23147e, c4371q.f23148f);
        }
    }

    /* renamed from: c */
    private void m914c() {
        if (this.f23154l == null) {
            return;
        }
        this.f23154l.setBackgroundDrawable(C4342c.m1036a(this.f23156n).m1037a(this.f23155m ? 1010 : 1009, C4386g.m858a(this.f23156n, 60.0f), C4386g.m858a(this.f23156n, 34.0f)));
    }

    /* renamed from: a */
    public final void m922a() {
        TextView textView = this.f23161s;
        if (textView != null) {
            textView.setTextColor(-13421773);
        }
    }

    /* renamed from: a */
    public final void m921a(float f) {
        TextView textView = this.f23161s;
        if (textView != null) {
            textView.setTextSize(f);
        }
    }

    /* renamed from: a */
    public final void m920a(InterfaceC4372a interfaceC4372a) {
        this.f23163u = interfaceC4372a;
    }

    /* renamed from: a */
    public final void m917a(boolean z) {
        this.f23155m = z;
        m914c();
    }

    /* renamed from: b */
    public final boolean m916b() {
        if (m918a(this.f23151i) && this.f23151i.equalsIgnoreCase("0")) {
            return this.f23155m;
        }
        return true;
    }
}
