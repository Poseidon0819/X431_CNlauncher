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
import com.unionpay.tsmservice.data.AppStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.widgets.g */
/* loaded from: classes2.dex */
public final class C4465g extends AbstractC4486z {

    /* renamed from: u */
    private static List<String> f23438u;

    /* renamed from: v */
    private static List<String> f23439v;

    /* renamed from: a */
    private Spinner f23440a;

    /* renamed from: b */
    private int f23441b;

    /* renamed from: c */
    private String f23442c;

    /* renamed from: o */
    private C4356c f23443o;

    /* renamed from: p */
    private TextView f23444p;

    /* renamed from: q */
    private RelativeLayout f23445q;

    /* renamed from: r */
    private PopupWindow f23446r;

    /* renamed from: s */
    private C4360g f23447s;

    /* renamed from: t */
    private List<Map<String, Object>> f23448t;

    /* renamed from: w */
    private final View.OnClickListener f23449w;

    /* renamed from: x */
    private final AdapterView.OnItemClickListener f23450x;

    static {
        ArrayList arrayList = new ArrayList(8);
        arrayList.add(C4171c.f22227bD.f22240M);
        arrayList.add(C4171c.f22227bD.f22241N);
        arrayList.add(C4171c.f22227bD.f22242O);
        arrayList.add(C4171c.f22227bD.f22243P);
        arrayList.add(C4171c.f22227bD.f22244Q);
        arrayList.add(C4171c.f22227bD.f22245R);
        arrayList.add(C4171c.f22227bD.f22246S);
        arrayList.add(C4171c.f22227bD.f22247T);
        f23438u = arrayList;
        ArrayList arrayList2 = new ArrayList(8);
        arrayList2.add("01");
        arrayList2.add("02");
        arrayList2.add("03");
        arrayList2.add("04");
        arrayList2.add(AppStatus.OPEN);
        arrayList2.add(AppStatus.APPLY);
        arrayList2.add(AppStatus.VIEW);
        arrayList2.add("99");
        f23439v = arrayList2;
    }

    public C4465g(Context context, JSONObject jSONObject, String str) {
        super(context, jSONObject, str);
        ArrayList arrayList = null;
        this.f23440a = null;
        this.f23441b = 1;
        this.f23449w = new View$OnClickListenerC4466h(this);
        this.f23450x = new C4467i(this);
        this.f23442c = C4171c.f22227bD.f22316bf;
        List<String> list = f23438u;
        if (list != null && list.size() > 0) {
            arrayList = new ArrayList(f23438u.size());
            for (int i = 0; i < f23438u.size(); i++) {
                HashMap hashMap = new HashMap();
                hashMap.put("text1", f23438u.get(i));
                hashMap.put("text2", "");
                hashMap.put("editable", Boolean.FALSE);
                arrayList.add(hashMap);
            }
        }
        this.f23448t = arrayList;
        this.f23443o = new C4356c(context, this.f23448t, this.f23442c, "", "", this.f23441b, 0);
        this.f23447s = new C4360g(this.f23397d, this.f23443o);
        this.f23447s.m961a(this.f23450x);
        this.f23447s.m962a(this.f23449w);
        RelativeLayout relativeLayout = this.f23406m;
        Drawable m1037a = C4342c.m1036a(this.f23397d).m1037a(2014, -1, -1);
        this.f23445q = new RelativeLayout(this.f23397d);
        this.f23445q.setBackgroundDrawable(m1037a);
        this.f23445q.setOnClickListener(new View$OnClickListenerC4468j(this));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, C4149a.f22125n);
        layoutParams.addRule(15, -1);
        relativeLayout.addView(this.f23445q, layoutParams);
        ImageView imageView = new ImageView(this.f23397d);
        imageView.setId(imageView.hashCode());
        imageView.setBackgroundDrawable(C4342c.m1036a(this.f23397d).m1037a(1002, -1, -1));
        int m858a = C4386g.m858a(this.f23397d, 15.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(m858a, m858a);
        layoutParams2.addRule(11, -1);
        layoutParams2.addRule(15, -1);
        layoutParams2.rightMargin = C4386g.m858a(this.f23397d, 10.0f);
        this.f23445q.addView(imageView, layoutParams2);
        TextView textView = new TextView(this.f23397d);
        textView.setId(textView.hashCode());
        textView.setTextSize(C4150b.f22148k);
        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        textView.setSingleLine(true);
        textView.setEms(4);
        textView.setText(C4171c.f22227bD.f22313bc);
        textView.setTextColor(-16777216);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(15, -1);
        layoutParams3.addRule(9, -1);
        layoutParams3.leftMargin = C4386g.m858a(this.f23397d, 10.0f);
        this.f23445q.addView(textView, layoutParams3);
        this.f23444p = new TextView(this.f23397d);
        this.f23444p.setTextSize(C4150b.f22148k);
        this.f23444p.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.f23444p.setSingleLine(true);
        this.f23444p.setTextColor(-10066330);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(15, -1);
        layoutParams4.addRule(1, textView.getId());
        layoutParams4.addRule(0, imageView.getId());
        this.f23445q.addView(this.f23444p, layoutParams4);
        if (!this.f23402i) {
            m650a(1);
            return;
        }
        this.f23444p.setText(m646b(mo579i()));
        imageView.setVisibility(8);
        this.f23445q.setClickable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m650a(int i) {
        List<String> list;
        this.f23441b = i;
        int m972c = i - this.f23443o.m972c();
        this.f23443o.m979a(this.f23441b);
        TextView textView = this.f23444p;
        if (textView == null || (list = f23438u) == null) {
            return;
        }
        textView.setText(list.get(m972c));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m647a(C4465g c4465g, View view) {
        if (c4465g.f23446r == null) {
            c4465g.f23446r = new PopupWindow((View) c4465g.f23447s, -1, -1, true);
            c4465g.f23446r.setBackgroundDrawable(new ColorDrawable(-1342177280));
            c4465g.f23446r.update();
        }
        c4465g.f23446r.showAtLocation(view, 80, 0, 0);
    }

    /* renamed from: b */
    private static String m646b(String str) {
        String str2 = "";
        for (int i = 0; i < f23439v.size(); i++) {
            if (f23439v.get(i).equals(str)) {
                str2 = f23438u.get(i);
            }
        }
        return str2;
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: a */
    public final String mo585a() {
        int m972c = this.f23441b - this.f23443o.m972c();
        return this.f23402i ? mo579i() : (m972c < 0 || m972c > f23438u.size()) ? "" : f23439v.get(m972c);
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
        return "_select_certtype";
    }
}
