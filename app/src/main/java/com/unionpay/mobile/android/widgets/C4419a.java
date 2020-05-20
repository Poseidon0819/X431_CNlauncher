package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.resource.C4342c;
import com.unionpay.mobile.android.upwidget.C4356c;
import com.unionpay.mobile.android.upwidget.C4360g;
import com.unionpay.mobile.android.utils.C4386g;
import com.unionpay.mobile.android.utils.C4389j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.widgets.a */
/* loaded from: classes2.dex */
public final class C4419a extends AbstractC4486z {

    /* renamed from: u */
    private static List<String> f23309u;

    /* renamed from: v */
    private static List<String> f23310v;

    /* renamed from: a */
    private Spinner f23311a;

    /* renamed from: b */
    private int f23312b;

    /* renamed from: c */
    private String f23313c;

    /* renamed from: o */
    private C4356c f23314o;

    /* renamed from: p */
    private TextView f23315p;

    /* renamed from: q */
    private RelativeLayout f23316q;

    /* renamed from: r */
    private PopupWindow f23317r;

    /* renamed from: s */
    private C4360g f23318s;

    /* renamed from: t */
    private List<Map<String, Object>> f23319t;

    /* renamed from: w */
    private final View.OnClickListener f23320w;

    /* renamed from: x */
    private final AdapterView.OnItemClickListener f23321x;

    public C4419a(Context context, JSONObject jSONObject, JSONArray jSONArray, String str) {
        super(context, jSONObject, str);
        this.f23311a = null;
        this.f23312b = 1;
        this.f23320w = new View$OnClickListenerC4452b(this);
        this.f23321x = new C4461c(this);
        ArrayList arrayList = new ArrayList(1);
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add((JSONArray) C4389j.m845b(jSONArray, i));
        }
        if (arrayList.size() > 0) {
            f23309u = new ArrayList(arrayList.size());
            f23310v = new ArrayList(arrayList.size());
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                f23310v.add(C4389j.m847a((JSONArray) arrayList.get(i2), 0));
                f23309u.add(C4389j.m847a((JSONArray) arrayList.get(i2), 1));
            }
        }
        RelativeLayout relativeLayout = this.f23406m;
        Drawable m1037a = C4342c.m1036a(this.f23397d).m1037a(2014, -1, -1);
        this.f23316q = new RelativeLayout(this.f23397d);
        this.f23316q.setBackgroundDrawable(m1037a);
        this.f23316q.setOnClickListener(new View$OnClickListenerC4462d(this));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, C4149a.f22125n);
        layoutParams.addRule(15, -1);
        relativeLayout.addView(this.f23316q, layoutParams);
        ImageView imageView = new ImageView(this.f23397d);
        imageView.setId(imageView.hashCode());
        imageView.setBackgroundDrawable(C4342c.m1036a(this.f23397d).m1037a(1002, -1, -1));
        int m858a = C4386g.m858a(this.f23397d, 15.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(m858a, m858a);
        layoutParams2.addRule(11, -1);
        layoutParams2.addRule(15, -1);
        layoutParams2.rightMargin = C4386g.m858a(this.f23397d, 10.0f);
        this.f23316q.addView(imageView, layoutParams2);
        TextView textView = new TextView(this.f23397d);
        textView.setId(textView.hashCode());
        textView.setTextSize(C4150b.f22148k);
        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        textView.setTextColor(-13421773);
        textView.setSingleLine(true);
        textView.setEms(4);
        textView.setText(C4171c.f22227bD.f22314bd);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(15, -1);
        layoutParams3.addRule(9, -1);
        layoutParams3.leftMargin = C4386g.m858a(this.f23397d, 10.0f);
        this.f23316q.addView(textView, layoutParams3);
        this.f23315p = new TextView(this.f23397d);
        this.f23315p.setTextSize(C4150b.f22148k);
        this.f23315p.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.f23315p.setSingleLine(true);
        this.f23315p.setTextColor(-10066330);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(15, -1);
        layoutParams4.addRule(1, textView.getId());
        layoutParams4.addRule(0, imageView.getId());
        this.f23316q.addView(this.f23315p, layoutParams4);
        if (this.f23402i) {
            this.f23315p.setText(m725b(mo579i()));
            imageView.setVisibility(8);
            this.f23316q.setClickable(false);
            return;
        }
        List<String> list = f23309u;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f23315p.setText(f23309u.get(0));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m727a(C4419a c4419a, int i) {
        List<String> list;
        c4419a.f23312b = i;
        int m972c = i - c4419a.f23314o.m972c();
        c4419a.f23314o.m979a(c4419a.f23312b);
        TextView textView = c4419a.f23315p;
        if (textView == null || (list = f23309u) == null) {
            return;
        }
        textView.setText(list.get(m972c));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m726a(C4419a c4419a, View view) {
        if (c4419a.f23317r == null) {
            c4419a.f23313c = C4171c.f22227bD.f22315be;
            ArrayList arrayList = null;
            List<String> list = f23309u;
            if (list != null && list.size() > 0) {
                arrayList = new ArrayList(f23309u.size());
                for (int i = 0; i < f23309u.size(); i++) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("text1", f23309u.get(i));
                    hashMap.put("text2", "");
                    hashMap.put("editable", Boolean.FALSE);
                    arrayList.add(hashMap);
                }
            }
            c4419a.f23319t = arrayList;
            c4419a.f23314o = new C4356c(c4419a.f23397d, c4419a.f23319t, c4419a.f23313c, "", "", c4419a.f23312b, 0);
            c4419a.f23318s = new C4360g(c4419a.f23397d, c4419a.f23314o);
            c4419a.f23318s.m961a(c4419a.f23321x);
            c4419a.f23318s.m962a(c4419a.f23320w);
            c4419a.f23317r = new PopupWindow((View) c4419a.f23318s, -1, -1, true);
            c4419a.f23317r.setBackgroundDrawable(new ColorDrawable(-1342177280));
            c4419a.f23317r.update();
        }
        c4419a.f23317r.showAtLocation(view, 80, 0, 0);
    }

    /* renamed from: b */
    private static String m725b(String str) {
        String str2 = "";
        for (int i = 0; i < f23310v.size(); i++) {
            if (f23310v.get(i).equals(str)) {
                str2 = f23309u.get(i);
            }
        }
        return str2;
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: a */
    public final String mo585a() {
        C4356c c4356c = this.f23314o;
        int m972c = this.f23312b - (c4356c == null ? 1 : c4356c.m972c());
        return this.f23402i ? mo579i() : (m972c < 0 || m972c > f23309u.size()) ? "" : f23310v.get(m972c);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba
    /* renamed from: d */
    public final String mo613d() {
        return "_select_areacode";
    }
}
