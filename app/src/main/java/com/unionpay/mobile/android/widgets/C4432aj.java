package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.unionpay.mobile.android.data.C4147a;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.resource.C4342c;
import com.unionpay.mobile.android.upwidget.C4363j;
import com.unionpay.mobile.android.upwidget.C4371q;
import com.unionpay.mobile.android.utils.C4386g;
import com.unionpay.mobile.android.utils.C4389j;
import com.unionpay.mobile.android.utils.C4390k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.widgets.aj */
/* loaded from: classes2.dex */
public final class C4432aj extends AbstractC4486z {

    /* renamed from: A */
    private String f23345A;

    /* renamed from: B */
    private boolean f23346B;

    /* renamed from: C */
    private String f23347C;

    /* renamed from: D */
    private InterfaceC4433a f23348D;

    /* renamed from: a */
    private final View.OnClickListener f23349a;

    /* renamed from: b */
    private final View.OnClickListener f23350b;

    /* renamed from: c */
    private final AdapterView.OnItemClickListener f23351c;

    /* renamed from: o */
    private JSONArray f23352o;

    /* renamed from: p */
    private PopupWindow f23353p;

    /* renamed from: q */
    private C4363j f23354q;

    /* renamed from: r */
    private int f23355r;

    /* renamed from: s */
    private int f23356s;

    /* renamed from: t */
    private JSONArray f23357t;

    /* renamed from: u */
    private JSONArray f23358u;

    /* renamed from: v */
    private TextView f23359v;

    /* renamed from: w */
    private C4371q f23360w;

    /* renamed from: x */
    private TextView f23361x;

    /* renamed from: y */
    private String f23362y;

    /* renamed from: z */
    private RelativeLayout f23363z;

    /* renamed from: com.unionpay.mobile.android.widgets.aj$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC4433a {
        /* renamed from: g */
        void mo691g();
    }

    public C4432aj(Context context, JSONObject jSONObject, String str, InterfaceC4433a interfaceC4433a) {
        super(context, jSONObject, str);
        this.f23349a = new View$OnClickListenerC4434ak(this);
        this.f23350b = new View$OnClickListenerC4435al(this);
        this.f23351c = new C4436am(this);
        this.f23356s = 0;
        this.f23357t = null;
        this.f23358u = null;
        this.f23345A = "";
        this.f23346B = true;
        this.f23347C = "";
        this.f23348D = null;
        this.f23348D = interfaceC4433a;
        this.f23355r = 0;
        this.f23352o = C4389j.m842d(this.f23407n, "items");
        this.f23362y = C4389j.m846a(jSONObject, "label");
        if (mo582a(this.f23362y)) {
            this.f23362y = C4171c.f22227bD.f22317bg;
        }
        if (!TextUtils.isEmpty(C4389j.m846a(jSONObject, "default_item_idx"))) {
            this.f23356s = Integer.parseInt(C4389j.m846a(jSONObject, "default_item_idx"));
        }
        this.f23354q = new C4363j(context, this.f23352o, this.f23356s, str);
        this.f23354q.m954a(this.f23351c);
        this.f23354q.m955a(this.f23349a);
        this.f23354q.m936d(this.f23350b);
        RelativeLayout relativeLayout = this.f23406m;
        Drawable m1037a = C4342c.m1036a(this.f23397d).m1037a(2014, -1, -1);
        LinearLayout linearLayout = new LinearLayout(this.f23397d);
        linearLayout.setId(linearLayout.hashCode());
        linearLayout.setBackgroundColor(-3419943);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, 1);
        C4389j.m846a(this.f23407n, VastExtensionXmlManager.TYPE);
        relativeLayout.addView(linearLayout, layoutParams);
        this.f23363z = new RelativeLayout(this.f23397d);
        RelativeLayout relativeLayout2 = this.f23363z;
        relativeLayout2.setId(relativeLayout2.hashCode());
        this.f23363z.setBackgroundDrawable(m1037a);
        this.f23363z.setOnClickListener(new View$OnClickListenerC4437an(this));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, C4149a.f22125n);
        layoutParams2.addRule(15, -1);
        layoutParams2.addRule(3, linearLayout.getId());
        relativeLayout.addView(this.f23363z, layoutParams2);
        ImageView imageView = new ImageView(this.f23397d);
        imageView.setId(imageView.hashCode());
        imageView.setBackgroundDrawable(C4342c.m1036a(this.f23397d).m1037a(1002, -1, -1));
        int m858a = C4386g.m858a(this.f23397d, 15.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(m858a, m858a);
        layoutParams3.addRule(11, -1);
        layoutParams3.addRule(15, -1);
        layoutParams3.rightMargin = C4386g.m858a(this.f23397d, 10.0f);
        this.f23363z.addView(imageView, layoutParams3);
        this.f23359v = new TextView(this.f23397d);
        this.f23359v.setTextSize(C4150b.f22148k);
        this.f23359v.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.f23359v.setSingleLine(true);
        this.f23359v.setTextColor(-10066330);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(15, -1);
        layoutParams4.addRule(9, -1);
        layoutParams4.addRule(0, imageView.getId());
        layoutParams4.leftMargin = C4386g.m858a(this.f23397d, 10.0f);
        layoutParams4.rightMargin = layoutParams4.leftMargin;
        this.f23363z.addView(this.f23359v, layoutParams4);
        if (!"instalment".equals("promotion")) {
            LinearLayout linearLayout2 = new LinearLayout(this.f23397d);
            linearLayout2.setBackgroundColor(-3419943);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, 1);
            layoutParams5.bottomMargin = C4149a.f22117f;
            layoutParams5.addRule(3, this.f23363z.getId());
            relativeLayout.addView(linearLayout2, layoutParams5);
        }
        C4371q c4371q = this.f23360w;
        m695a(c4371q != null ? c4371q.m916b() : true);
        m707a(this.f23356s, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m706a(int i, int i2, String str) {
        Object m845b = C4389j.m845b(this.f23352o, i);
        if (m845b != null) {
            JSONObject jSONObject = (JSONObject) m845b;
            String m846a = C4389j.m846a(jSONObject, VastExtensionXmlManager.TYPE);
            Object m845b2 = C4389j.m845b("coupon".equals(m846a) ? this.f23357t : "point".equals(m846a) ? this.f23358u : C4389j.m842d(jSONObject, "options"), i2);
            return m845b2 != null ? C4389j.m846a((JSONObject) m845b2, str) : "";
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ String m700a(C4432aj c4432aj, int i, String str) {
        Object m845b = C4389j.m845b(c4432aj.f23352o, i);
        return m845b != null ? C4389j.m846a((JSONObject) m845b, str) : "";
    }

    /* renamed from: a */
    private static JSONObject m698a(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(VastExtensionXmlManager.TYPE, str);
            jSONObject.put("label", str2);
            jSONObject.put("checked", str3);
            jSONObject.put("ckb_style", "small");
            jSONObject.put("required", "0");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m707a(int i, int i2) {
        this.f23356s = i;
        this.f23355r = i2;
        TextView textView = this.f23359v;
        if (textView != null) {
            textView.setText(m706a(i, i2, "label"));
        }
        String m706a = m706a(i, i2, "rel_label");
        String m706a2 = m706a(i, i2, "rel_value");
        String m706a3 = m706a(i, i2, "rel_value_style");
        this.f23347C = m706a2;
        if (!this.f23346B) {
            this.f23348D.mo691g();
        }
        this.f23346B = false;
        this.f23345A = m706a(i, i2, "value");
        int i3 = 8;
        if (!mo582a(m706a) || !mo582a(m706a2)) {
            if (C4147a.m1612a(m706a3)) {
                int parseColor = Color.parseColor(m706a3);
                m706a3 = Integer.toString(parseColor, 16);
            }
            String concat = "#ff".concat(String.valueOf(m706a3));
            TextView textView2 = this.f23361x;
            int parseColor2 = Color.parseColor(concat);
            int length = m706a.length();
            int length2 = TextUtils.isEmpty(m706a2) ? 0 : m706a2.length();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(m706a + m706a2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(-13421773);
            ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(parseColor2);
            spannableStringBuilder.setSpan(foregroundColorSpan, 0, length, 33);
            spannableStringBuilder.setSpan(foregroundColorSpan2, length, length2 + length, 18);
            textView2.setText(spannableStringBuilder);
            C4371q c4371q = this.f23360w;
            if (c4371q != null ? c4371q.m916b() : true) {
                i3 = 0;
            }
        }
        this.f23361x.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m699a(C4432aj c4432aj, View view) {
        if (c4432aj.f23353p == null) {
            c4432aj.f23353p = new PopupWindow((View) c4432aj.f23354q, -1, -1, true);
            c4432aj.f23353p.setBackgroundDrawable(new ColorDrawable(-1342177280));
            c4432aj.f23353p.update();
        }
        c4432aj.f23353p.showAtLocation(view, 80, 0, 0);
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: a */
    public final String mo585a() {
        String m706a = m706a(this.f23356s, this.f23355r, "value");
        if (m706a != null) {
            m706a = m706a.replace("\"", "\\\"");
        }
        C4371q c4371q = this.f23360w;
        if (c4371q != null && !c4371q.m916b()) {
            m706a = null;
        }
        C4390k.m836c("uppay", m674n() + " : " + m706a);
        return m706a;
    }

    /* renamed from: a */
    public final void m705a(View.OnClickListener onClickListener) {
        this.f23354q.m945b(this.f23349a);
        this.f23354q.m945b(onClickListener);
    }

    /* renamed from: a */
    public final void m704a(C4371q.InterfaceC4372a interfaceC4372a) {
        C4371q c4371q = this.f23360w;
        if (c4371q != null) {
            c4371q.m920a(interfaceC4372a);
        }
    }

    /* renamed from: a */
    public final void m697a(JSONArray jSONArray) {
        this.f23357t = jSONArray;
        this.f23354q.m948a(jSONArray);
    }

    /* renamed from: a */
    public final void m696a(JSONArray jSONArray, String str) {
        this.f23358u = jSONArray;
        this.f23354q.m946a(jSONArray, str);
    }

    /* renamed from: a */
    public final void m695a(boolean z) {
        this.f23345A = !z ? "" : m706a(this.f23356s, this.f23355r, "value");
        C4371q c4371q = this.f23360w;
        if (c4371q != null) {
            c4371q.m917a(z);
        }
        int i = z ? 0 : 8;
        this.f23406m.setVisibility(i);
        TextView textView = this.f23361x;
        if (textView != null) {
            if (TextUtils.isEmpty(textView.getText().toString())) {
                this.f23361x.setVisibility(8);
            } else {
                this.f23361x.setVisibility(i);
            }
        }
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba
    /* renamed from: a */
    protected final boolean mo626a(LinearLayout linearLayout, String str) {
        if (mo582a(str)) {
            return true;
        }
        LinearLayout linearLayout2 = new LinearLayout(this.f23397d);
        linearLayout2.setBackgroundColor(-1);
        linearLayout2.setOrientation(1);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, C4149a.f22125n));
        JSONObject m698a = m698a(C4389j.m846a(this.f23407n, VastExtensionXmlManager.TYPE), str, C4389j.m846a(this.f23407n, "checked"));
        Context context = this.f23397d;
        this.f23360w = new C4371q(context, m698a, m669s() + "_agree_reduce_activity");
        this.f23360w.m922a();
        this.f23360w.m921a(C4150b.f22148k);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, C4149a.f22125n);
        layoutParams.gravity = 16;
        int m858a = C4386g.m858a(this.f23397d, 10.0f);
        layoutParams.rightMargin = m858a;
        layoutParams.leftMargin = m858a;
        linearLayout2.addView(this.f23360w, layoutParams);
        return true;
    }

    /* renamed from: b */
    public final void m694b(View.OnClickListener onClickListener) {
        this.f23354q.m934e(onClickListener);
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: b */
    public final boolean mo584b() {
        return true;
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba
    /* renamed from: b_ */
    protected final boolean mo615b_() {
        this.f23361x = new TextView(this.f23397d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = C4386g.m858a(this.f23397d, 10.0f);
        int m858a = C4386g.m858a(this.f23397d, 5.0f);
        layoutParams.bottomMargin = m858a;
        layoutParams.topMargin = m858a;
        this.f23361x.setTextSize(C4150b.f22148k);
        addView(this.f23361x, layoutParams);
        this.f23361x.setVisibility(8);
        return true;
    }

    /* renamed from: c */
    public final void m693c(View.OnClickListener onClickListener) {
        this.f23354q.m940c(onClickListener);
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: c */
    public final boolean mo583c() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba
    /* renamed from: d */
    public final String mo613d() {
        return "_select_reduce_activity";
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4486z, com.unionpay.mobile.android.widgets.AbstractC4453ba
    /* renamed from: f */
    public final boolean mo581f() {
        String m706a = m706a(this.f23356s, this.f23355r, "available");
        return TextUtils.isEmpty(m706a) || !"1".equals(m706a);
    }

    /* renamed from: g */
    public final String m692g() {
        return this.f23345A;
    }
}
