package com.unionpay.mobile.android.widgets;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.html.HtmlTags;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.resource.C4342c;
import com.unionpay.mobile.android.upwidget.C4358e;
import com.unionpay.mobile.android.upwidget.C4371q;
import com.unionpay.mobile.android.utils.C4386g;
import com.unionpay.mobile.android.utils.C4389j;
import com.unionpay.mobile.android.utils.C4390k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.widgets.p */
/* loaded from: classes2.dex */
public final class C4474p extends AbstractC4486z {

    /* renamed from: a */
    private final View.OnClickListener f23479a;

    /* renamed from: b */
    private final AdapterView.OnItemClickListener f23480b;

    /* renamed from: c */
    private JSONArray f23481c;

    /* renamed from: o */
    private List<Map<String, Object>> f23482o;

    /* renamed from: p */
    private AlertDialog f23483p;

    /* renamed from: q */
    private PopupWindow f23484q;

    /* renamed from: r */
    private C4358e f23485r;

    /* renamed from: s */
    private int f23486s;

    /* renamed from: t */
    private TextView f23487t;

    /* renamed from: u */
    private C4371q f23488u;

    /* renamed from: v */
    private TextView f23489v;

    /* renamed from: w */
    private String f23490w;

    /* renamed from: x */
    private RelativeLayout f23491x;

    /* renamed from: y */
    private boolean f23492y;

    /* renamed from: z */
    private boolean f23493z;

    public C4474p(Context context, JSONObject jSONObject, String str) {
        super(context, jSONObject, str);
        this.f23479a = new View$OnClickListenerC4475q(this);
        this.f23480b = new C4476r(this);
        this.f23492y = false;
        this.f23493z = true;
        this.f23486s = 1;
        this.f23481c = C4389j.m842d(this.f23407n, "new_instalments");
        this.f23490w = C4389j.m846a(jSONObject, "label");
        if (mo582a(this.f23490w)) {
            this.f23490w = C4171c.f22227bD.f22317bg;
        }
        this.f23482o = m617b(this.f23481c);
        this.f23485r = new C4358e(this.f23397d, this.f23482o, "");
        m625a(this.f23406m);
    }

    /* renamed from: a */
    private String m627a(int i, String str) {
        Object m845b = C4389j.m845b(this.f23481c, i);
        return m845b != null ? C4389j.m846a((JSONObject) m845b, str) : "";
    }

    /* renamed from: a */
    private JSONObject m621a(String str, String str2, String str3) {
        JSONObject m843c;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(VastExtensionXmlManager.TYPE, str);
            jSONObject.put("label", str2);
            jSONObject.put("checked", str3);
            jSONObject.put("ckb_style", "small");
            jSONObject.put("required", "0");
            if ("instalment".equals(str) && (m843c = C4389j.m843c(this.f23407n, Annotation.URL)) != null) {
                jSONObject.put("href_label", C4389j.m846a(m843c, "label"));
                jSONObject.put("href_url", C4389j.m846a(m843c, HtmlTags.HREF));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m628a(int i) {
        this.f23486s = i;
        int m967a = i - this.f23485r.m967a();
        this.f23485r.m966a(this.f23486s);
        TextView textView = this.f23487t;
        if (textView != null) {
            textView.setText(m627a(m967a, "label"));
        }
    }

    /* renamed from: a */
    private void m625a(RelativeLayout relativeLayout) {
        Drawable m1037a = C4342c.m1036a(this.f23397d).m1037a(2014, -1, -1);
        LinearLayout linearLayout = new LinearLayout(this.f23397d);
        linearLayout.setId(linearLayout.hashCode());
        linearLayout.setBackgroundColor(-3419943);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, 1);
        String m846a = C4389j.m846a(this.f23407n, VastExtensionXmlManager.TYPE);
        if ("instalment".equals(m846a)) {
            layoutParams.leftMargin = C4386g.m858a(this.f23397d, 10.0f);
        }
        relativeLayout.addView(linearLayout, layoutParams);
        this.f23491x = new RelativeLayout(this.f23397d);
        RelativeLayout relativeLayout2 = this.f23491x;
        relativeLayout2.setId(relativeLayout2.hashCode());
        this.f23491x.setBackgroundDrawable(m1037a);
        this.f23491x.setOnClickListener(new View$OnClickListenerC4477s(this));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, C4149a.f22125n);
        layoutParams2.addRule(15, -1);
        layoutParams2.addRule(3, linearLayout.getId());
        relativeLayout.addView(this.f23491x, layoutParams2);
        ImageView imageView = new ImageView(this.f23397d);
        imageView.setId(imageView.hashCode());
        imageView.setBackgroundDrawable(C4342c.m1036a(this.f23397d).m1037a(1002, -1, -1));
        int m858a = C4386g.m858a(this.f23397d, 15.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(m858a, m858a);
        layoutParams3.addRule(11, -1);
        layoutParams3.addRule(15, -1);
        layoutParams3.rightMargin = C4386g.m858a(this.f23397d, 10.0f);
        this.f23491x.addView(imageView, layoutParams3);
        this.f23487t = new TextView(this.f23397d);
        this.f23487t.setTextSize(C4150b.f22148k);
        this.f23487t.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.f23487t.setSingleLine(true);
        this.f23487t.setTextColor(-10066330);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(15, -1);
        layoutParams4.addRule(9, -1);
        layoutParams4.addRule(0, imageView.getId());
        layoutParams4.leftMargin = C4386g.m858a(this.f23397d, 10.0f);
        layoutParams4.rightMargin = layoutParams4.leftMargin;
        this.f23491x.addView(this.f23487t, layoutParams4);
        if (!"instalment".equals(m846a)) {
            LinearLayout linearLayout2 = new LinearLayout(this.f23397d);
            linearLayout2.setBackgroundColor(-3419943);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, 1);
            layoutParams5.bottomMargin = C4149a.f22117f;
            layoutParams5.addRule(3, this.f23491x.getId());
            relativeLayout.addView(linearLayout2, layoutParams5);
        }
        m616b(m612g());
        m628a(this.f23485r.m967a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ Dialog m618b(C4474p c4474p) {
        if (c4474p.f23483p == null || c4474p.f23493z) {
            c4474p.f23493z = false;
            c4474p.f23483p = new AlertDialog.Builder(c4474p.f23397d).setInverseBackgroundForced(false).create();
            AlertDialog alertDialog = c4474p.f23483p;
            LinearLayout linearLayout = new LinearLayout(c4474p.f23397d);
            linearLayout.setOrientation(1);
            linearLayout.setBackgroundColor(-1);
            int m858a = C4386g.m858a(c4474p.f23397d, 1.0f);
            RelativeLayout relativeLayout = new RelativeLayout(c4474p.f23397d);
            int i = C4150b.f22144g;
            relativeLayout.setPadding(i, i, i, i);
            linearLayout.addView(relativeLayout);
            LinearLayout linearLayout2 = new LinearLayout(c4474p.f23397d);
            linearLayout2.setBackgroundColor(-3419943);
            linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, 1));
            TextView textView = new TextView(c4474p.f23397d);
            textView.setText(c4474p.f23490w);
            textView.setTextSize(C4150b.f22146i);
            textView.setTextColor(-13421773);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13, -1);
            relativeLayout.addView(textView, layoutParams);
            relativeLayout.setBackgroundColor(-986892);
            new LinearLayout.LayoutParams(-1, -2);
            ListView listView = new ListView(c4474p.f23397d);
            listView.setDivider(null);
            listView.setAdapter((ListAdapter) c4474p.f23485r);
            listView.setDividerHeight(m858a);
            listView.setOnItemClickListener(new C4478t(c4474p));
            new LinearLayout.LayoutParams(-1, -2);
            linearLayout.addView(listView);
            alertDialog.setView(linearLayout, -1, -1, -1, -1);
            c4474p.f23483p.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        return c4474p.f23483p;
    }

    /* renamed from: b */
    private List<Map<String, Object>> m617b(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            HashMap hashMap = new HashMap();
            hashMap.put("label", m627a(i, "label"));
            hashMap.put(HtmlTags.STYLE, m627a(i, "rel_value_style"));
            String[] split = m627a(i, "rel_value").split("\\|");
            ArrayList arrayList2 = new ArrayList(split.length);
            ArrayList arrayList3 = new ArrayList(split.length);
            for (String str : split) {
                String[] split2 = str.split(":");
                arrayList2.add(split2[0]);
                arrayList3.add(split2[1]);
            }
            hashMap.put("keys", arrayList2);
            hashMap.put("values", arrayList3);
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: a */
    public final String mo585a() {
        String m627a = m627a(this.f23486s - this.f23485r.m967a(), "value");
        C4371q c4371q = this.f23488u;
        if (c4371q != null && !c4371q.m916b()) {
            m627a = null;
        }
        C4390k.m836c("uppay", m674n() + " : " + m627a);
        return m627a;
    }

    /* renamed from: a */
    public final void m624a(C4371q.InterfaceC4372a interfaceC4372a) {
        this.f23488u.m920a(interfaceC4372a);
    }

    /* renamed from: a */
    public final void m620a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.f23493z = true;
        this.f23481c = jSONArray;
        this.f23482o = m617b(jSONArray);
        this.f23485r = new C4358e(this.f23397d, this.f23482o, "");
        m625a(this.f23406m);
    }

    /* renamed from: a */
    public final void m619a(boolean z) {
        this.f23492y = z;
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
        String m846a = C4389j.m846a(this.f23407n, VastExtensionXmlManager.TYPE);
        if ("instalment".equals(m846a)) {
            LinearLayout linearLayout3 = new LinearLayout(this.f23397d);
            linearLayout3.setId(linearLayout3.hashCode());
            linearLayout3.setBackgroundColor(-3419943);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
            layoutParams.leftMargin = C4386g.m858a(this.f23397d, 10.0f);
            linearLayout2.addView(linearLayout3, layoutParams);
        }
        JSONObject m621a = m621a(m846a, str, C4389j.m846a(this.f23407n, "checked"));
        Context context = this.f23397d;
        this.f23488u = new C4371q(context, m621a, m669s() + "_agree_installment");
        this.f23488u.m922a();
        this.f23488u.m921a(C4150b.f22148k);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, C4149a.f22125n);
        layoutParams2.gravity = 16;
        int m858a = C4386g.m858a(this.f23397d, 10.0f);
        layoutParams2.rightMargin = m858a;
        layoutParams2.leftMargin = m858a;
        linearLayout2.addView(this.f23488u, layoutParams2);
        return true;
    }

    /* renamed from: b */
    public final void m616b(boolean z) {
        this.f23488u.m917a(z);
        if (!z) {
            this.f23492y = z;
        }
        int i = (this.f23492y && z) ? 0 : 8;
        this.f23406m.setVisibility(i);
        TextView textView = this.f23489v;
        if (textView != null) {
            if (TextUtils.isEmpty(textView.getText().toString())) {
                this.f23489v.setVisibility(8);
            } else {
                this.f23489v.setVisibility(i);
            }
        }
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: b */
    public final boolean mo584b() {
        return true;
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba
    /* renamed from: b_ */
    protected final boolean mo615b_() {
        this.f23489v = new TextView(this.f23397d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = C4386g.m858a(this.f23397d, 10.0f);
        int m858a = C4386g.m858a(this.f23397d, 5.0f);
        layoutParams.bottomMargin = m858a;
        layoutParams.topMargin = m858a;
        this.f23489v.setTextSize(C4150b.f22148k);
        addView(this.f23489v, layoutParams);
        this.f23489v.setVisibility(8);
        return true;
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
        return "_select_installment";
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4486z, com.unionpay.mobile.android.widgets.AbstractC4453ba
    /* renamed from: f */
    public final boolean mo581f() {
        String m627a = m627a(this.f23486s - this.f23485r.m967a(), "available");
        return TextUtils.isEmpty(m627a) || !"1".equals(m627a);
    }

    /* renamed from: g */
    public final boolean m612g() {
        C4371q c4371q = this.f23488u;
        if (c4371q != null) {
            return c4371q.m916b();
        }
        return true;
    }
}
