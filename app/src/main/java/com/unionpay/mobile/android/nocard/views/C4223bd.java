package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.itextpdf.text.Annotation;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.utils.C4386g;
import com.unionpay.mobile.android.utils.C4388i;
import com.unionpay.mobile.android.utils.C4389j;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.views.order.InterfaceC4414l;
import com.unionpay.mobile.android.widgets.C4443as;
import com.unionpay.mobile.android.widgets.C4449ay;
import com.unionpay.tsmservice.data.Constant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.nocard.views.bd */
/* loaded from: classes2.dex */
public final class C4223bd extends AbstractC4219b {

    /* renamed from: r */
    private TextView f22616r;

    /* renamed from: s */
    private View.OnClickListener f22617s;

    /* renamed from: t */
    private C4224a f22618t;

    /* renamed from: com.unionpay.mobile.android.nocard.views.bd$a */
    /* loaded from: classes2.dex */
    public class C4224a extends LinearLayout {

        /* renamed from: b */
        private Context f22620b;

        public C4224a(Context context) {
            super(context);
            this.f22620b = context;
            setOrientation(1);
        }

        /* renamed from: a */
        private void m1396a(JSONArray jSONArray) {
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            LinearLayout linearLayout = new LinearLayout(C4223bd.this.f22593d);
            linearLayout.setOrientation(1);
            linearLayout.setBackgroundColor(-1);
            addView(linearLayout, layoutParams);
            ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, C4150b.f22151n);
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String m846a = C4389j.m846a(jSONObject, "label");
                    String m846a2 = C4389j.m846a(jSONObject, Annotation.URL);
                    LinearLayout linearLayout2 = new LinearLayout(C4223bd.this.f22593d);
                    linearLayout2.setBackgroundColor(-3419943);
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 1);
                    if (i != 0) {
                        layoutParams3.leftMargin = C4386g.m858a(C4223bd.this.f22593d, 12.0f);
                    }
                    linearLayout.addView(linearLayout2, layoutParams3);
                    Context context = this.f22620b;
                    RelativeLayout relativeLayout = new RelativeLayout(this.f22620b);
                    relativeLayout.setBackgroundDrawable(C4223bd.this.f22592c.m1037a(2014, -1, -1));
                    relativeLayout.setOnClickListener(new View$OnClickListenerC4227bg(this, i, m846a, m846a2));
                    TextView textView = new TextView(context);
                    textView.setText(m846a);
                    textView.setTextSize(C4150b.f22148k);
                    textView.setTextColor(-13421773);
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams4.addRule(15, -1);
                    layoutParams4.addRule(9, -1);
                    layoutParams4.leftMargin = C4386g.m858a(context, 12.0f);
                    relativeLayout.addView(textView, layoutParams4);
                    int m858a = C4386g.m858a(context, 20.0f);
                    Drawable m1037a = C4223bd.this.f22592c.m1037a(1002, -1, -1);
                    ImageView imageView = new ImageView(context);
                    imageView.setBackgroundDrawable(m1037a);
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(m858a, m858a);
                    layoutParams5.addRule(15, -1);
                    layoutParams5.addRule(11, -1);
                    layoutParams5.rightMargin = C4386g.m858a(context, 12.0f);
                    relativeLayout.addView(imageView, layoutParams5);
                    linearLayout.addView(relativeLayout, layoutParams2);
                    if (i == jSONArray.length() - 1) {
                        LinearLayout linearLayout3 = new LinearLayout(C4223bd.this.f22593d);
                        linearLayout3.setBackgroundColor(-3419943);
                        linearLayout.addView(linearLayout3, new LinearLayout.LayoutParams(-1, 1));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        /* renamed from: a */
        public final void m1395a(JSONObject jSONObject) {
            removeAllViews();
            String m846a = C4389j.m846a(jSONObject, "label");
            if (C4223bd.m1416b(m846a)) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.leftMargin = C4386g.m858a(C4223bd.this.f22593d, 12.0f);
                layoutParams.bottomMargin = C4149a.f22117f;
                TextView textView = new TextView(this.f22620b);
                textView.setText(m846a);
                textView.setTextSize(C4150b.f22148k);
                textView.setTextColor(-25009);
                addView(textView, layoutParams);
            }
            m1396a(C4389j.m842d(jSONObject, "options"));
        }
    }

    public C4223bd(Context context) {
        super(context);
        this.f22616r = null;
        this.f22617s = new View$OnClickListenerC4225be(this);
        m1410e();
        this.f22606q = "result";
        this.f22590a.f22442aq = null;
        if (this.f22590a.f22421aV) {
            this.f22594e.m1506c("bingopromotion", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m1397r() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f22590a.f22416aQ);
        String sb2 = sb.toString();
        C4390k.m836c("functionEx", sb2);
        if (this.f22590a.f22416aQ == InterfaceC4414l.f23274b.intValue() || this.f22590a.f22416aQ == InterfaceC4414l.f23275c.intValue()) {
            PreferenceUtils.m895c(this.f22593d, sb2);
        }
        this.f22590a.f22383I.f22848f = Constant.CASH_LOAD_SUCCESS;
        m1406j();
    }

    @Override // com.unionpay.mobile.android.nocard.views.InterfaceC4191a
    /* renamed from: a */
    public final void mo1077a(JSONObject jSONObject) {
        JSONObject m843c = C4389j.m843c(jSONObject, "luck_draw");
        if (m843c != null) {
            this.f22618t.setVisibility(0);
            this.f22618t.m1395a(m843c);
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: b */
    protected final void mo1076b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        C4449ay c4449ay = new C4449ay(getContext(), this.f22590a.f22375A, this);
        c4449ay.m683a();
        layoutParams.addRule(13, -1);
        this.f22600k.addView(c4449ay, layoutParams);
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: b */
    public final void mo1137b(int i) {
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: c */
    protected final void mo1072c() {
        this.f22602m.invalidate();
        if (this.f22604o != null) {
            this.f22604o.setBackgroundColor(-1052684);
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.f22593d);
        relativeLayout.setBackgroundColor(-1052684);
        relativeLayout.setId(relativeLayout.hashCode());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10, -1);
        layoutParams.topMargin = C4149a.f22115d;
        this.f22602m.addView(relativeLayout, layoutParams);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f22593d);
        relativeLayout2.setId(relativeLayout2.hashCode());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = C4149a.f22115d;
        relativeLayout.addView(relativeLayout2, layoutParams2);
        int i = C4149a.f22125n;
        Drawable m1037a = this.f22592c.m1037a(UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE, -1, -1);
        this.f22616r = new TextView(this.f22593d);
        TextView textView = this.f22616r;
        textView.setId(textView.hashCode());
        this.f22616r.setText(C4171c.f22227bD.f22232E);
        this.f22616r.setTextSize(C4150b.f22146i);
        this.f22616r.setTextColor(m1403o());
        this.f22616r.setGravity(17);
        this.f22616r.setOnClickListener(this.f22617s);
        this.f22616r.setBackgroundDrawable(m1037a);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, i);
        int m858a = C4386g.m858a(this.f22593d, 12.0f);
        layoutParams3.rightMargin = m858a;
        layoutParams3.leftMargin = m858a;
        layoutParams3.addRule(9, -1);
        layoutParams3.addRule(15, -1);
        relativeLayout2.addView(this.f22616r, layoutParams3);
        this.f22618t = new C4224a(this.f22593d);
        this.f22618t.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(3, relativeLayout2.getId());
        layoutParams4.topMargin = C4386g.m858a(this.f22593d, 20.0f);
        relativeLayout.addView(this.f22618t, layoutParams4);
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: f */
    protected final void mo1398f() {
        SpannableString spannableString;
        String str;
        String str2;
        String[] split;
        if (this.f22590a.f22382H != null) {
            LinearLayout linearLayout = new LinearLayout(this.f22593d);
            linearLayout.setOrientation(1);
            int m858a = C4386g.m858a(this.f22593d, 10.0f);
            if (!TextUtils.isEmpty(this.f22590a.f22376B)) {
                TextView textView = new TextView(this.f22593d);
                textView.setText(this.f22590a.f22376B);
                textView.setTextSize(24.0f);
                textView.setTextColor(-15365480);
                textView.setGravity(1);
                textView.setPadding(0, C4149a.f22115d, 0, 0);
                textView.getPaint().setFakeBoldText(true);
                linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
                LinearLayout linearLayout2 = new LinearLayout(this.f22593d);
                linearLayout2.setOrientation(0);
                linearLayout2.setBackgroundColor(-6958338);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
                int i = C4149a.f22115d;
                layoutParams.bottomMargin = i;
                layoutParams.topMargin = i;
                linearLayout.addView(linearLayout2, layoutParams);
                this.f22601l.addView(linearLayout);
            }
            JSONArray jSONArray = this.f22590a.f22382H;
            if (jSONArray != null) {
                int length = jSONArray.length() < 2 ? jSONArray.length() : 2;
                LinearLayout m1393a = C4228bh.m1393a(this.f22593d, jSONArray, 0, length);
                m1393a.setBackgroundColor(0);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams2.rightMargin = m858a;
                layoutParams2.leftMargin = m858a;
                linearLayout.addView(m1393a, layoutParams2);
                LinearLayout m1393a2 = C4228bh.m1393a(this.f22593d, jSONArray, length, jSONArray.length());
                m1393a2.setBackgroundColor(0);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.rightMargin = m858a;
                layoutParams3.leftMargin = m858a;
                this.f22601l.addView(m1393a2, layoutParams3);
            }
            C4443as c4443as = new C4443as(this.f22593d);
            c4443as.setId(c4443as.hashCode());
            this.f22601l.setOnClickListener(new View$OnClickListenerC4226bf(this));
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams4.bottomMargin = 0;
            this.f22601l.addView(c4443as, layoutParams4);
            return;
        }
        int m858a2 = C4386g.m858a(this.f22593d, 10.0f);
        LinearLayout linearLayout3 = new LinearLayout(this.f22593d);
        linearLayout3.setPadding(m858a2, m858a2, m858a2, m858a2);
        linearLayout3.setOrientation(1);
        linearLayout3.setBackgroundColor(-1);
        this.f22601l.addView(linearLayout3);
        LinearLayout linearLayout4 = new LinearLayout(this.f22593d);
        linearLayout4.setOrientation(0);
        linearLayout3.addView(linearLayout4);
        int m858a3 = C4386g.m858a(this.f22593d, 25.0f);
        ImageView imageView = new ImageView(this.f22593d);
        imageView.setBackgroundDrawable(this.f22592c.m1037a(1035, -1, -1));
        linearLayout4.addView(imageView, new LinearLayout.LayoutParams(m858a3, m858a3));
        LinearLayout linearLayout5 = new LinearLayout(this.f22593d);
        linearLayout5.setOrientation(1);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = m858a2;
        linearLayout4.addView(linearLayout5, layoutParams5);
        String str3 = this.f22590a.f22417aR;
        if (C4388i.m849b(str3)) {
            spannableString = null;
        } else {
            int indexOf = str3.indexOf(60);
            String substring = -1 != indexOf ? str3.substring(0, indexOf) : null;
            int indexOf2 = str3.indexOf(62) + 1;
            String substring2 = -1 != indexOf2 ? str3.substring(indexOf2) : null;
            int i2 = indexOf + 1;
            int i3 = indexOf2 - 1;
            if (-1 != indexOf && i2 < i3 && indexOf2 != -1) {
                String substring3 = str3.substring(i2, i3);
                if (!C4388i.m849b(substring3) && (split = substring3.split("#")) != null && split.length == 2) {
                    str2 = split[0];
                    str = split[1];
                    spannableString = C4388i.m850a(substring, str2, str, substring2);
                }
            }
            str = null;
            str2 = null;
            spannableString = C4388i.m850a(substring, str2, str, substring2);
        }
        if (spannableString != null) {
            TextView textView2 = new TextView(this.f22593d);
            textView2.setTextSize(20.0f);
            textView2.setText(spannableString);
            linearLayout5.addView(textView2);
        }
        if (m1416b(this.f22590a.f22418aS)) {
            TextView textView3 = new TextView(this.f22593d);
            textView3.setTextSize(C4150b.f22149l);
            textView3.setText(this.f22590a.f22418aS);
            textView3.setTextColor(-10066330);
            linearLayout5.addView(textView3);
        }
        if (m1416b(this.f22590a.f22419aT)) {
            TextView textView4 = new TextView(this.f22593d);
            textView4.setTextSize(C4150b.f22149l);
            textView4.setTextColor(-10066330);
            textView4.setText(this.f22590a.f22419aT);
            linearLayout5.addView(textView4);
        }
        int m858a4 = C4386g.m858a(this.f22593d, 5.0f);
        LinearLayout linearLayout6 = new LinearLayout(this.f22593d);
        linearLayout6.setOrientation(1);
        linearLayout6.setBackgroundColor(-1052684);
        linearLayout6.setPadding(m858a4, m858a4, m858a4, m858a4);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams6.topMargin = C4386g.m858a(this.f22593d, 10.0f);
        linearLayout3.addView(linearLayout6, layoutParams6);
        linearLayout6.setVisibility(8);
        if ("0".equals(this.f22590a.f22422aW) && m1416b(this.f22590a.f22423aX)) {
            TextView textView5 = new TextView(this.f22593d);
            textView5.setTextSize(C4150b.f22149l);
            textView5.setText(this.f22590a.f22423aX);
            linearLayout6.addView(textView5);
            linearLayout6.setVisibility(0);
        }
        Drawable m1037a = this.f22592c.m1037a(1026, -1, -1);
        LinearLayout linearLayout7 = new LinearLayout(this.f22593d);
        if (m1037a != null) {
            linearLayout7.setBackgroundDrawable(m1037a);
        }
        this.f22601l.addView(linearLayout7, new LinearLayout.LayoutParams(-1, C4386g.m858a(this.f22593d, 2.0f)));
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: k */
    public final void mo1056k() {
        m1397r();
    }
}
