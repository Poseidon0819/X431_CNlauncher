package com.unionpay.mobile.android.views.order;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.resource.C4342c;
import com.unionpay.mobile.android.upviews.C4343a;
import com.unionpay.mobile.android.upwidget.C4356c;
import com.unionpay.mobile.android.upwidget.C4360g;
import com.unionpay.mobile.android.utils.C4386g;
import com.unionpay.mobile.android.utils.C4390k;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.views.order.b */
/* loaded from: classes2.dex */
public final class C4402b extends AbstractMethod {

    /* renamed from: A */
    private TextView f23232A;

    /* renamed from: B */
    private boolean f23233B;

    /* renamed from: C */
    private int f23234C;

    /* renamed from: g */
    private JSONObject f23235g;

    /* renamed from: h */
    private JSONArray f23236h;

    /* renamed from: i */
    private boolean f23237i;

    /* renamed from: j */
    private C4343a f23238j;

    /* renamed from: k */
    private List<Map<String, Object>> f23239k;

    /* renamed from: l */
    private Drawable f23240l;

    /* renamed from: m */
    private PopupWindow f23241m;

    /* renamed from: n */
    private C4360g f23242n;

    /* renamed from: o */
    private C4356c f23243o;

    /* renamed from: p */
    private String f23244p;

    /* renamed from: q */
    private final View.OnClickListener f23245q;

    /* renamed from: r */
    private final View.OnClickListener f23246r;

    /* renamed from: s */
    private final AdapterView.OnItemClickListener f23247s;

    /* renamed from: t */
    private C4403a f23248t;

    /* renamed from: u */
    private int f23249u;

    /* renamed from: v */
    private int f23250v;

    /* renamed from: w */
    private InterfaceC4404b f23251w;

    /* renamed from: x */
    private Drawable f23252x;

    /* renamed from: y */
    private Drawable f23253y;

    /* renamed from: z */
    private Drawable f23254z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.unionpay.mobile.android.views.order.b$a */
    /* loaded from: classes2.dex */
    public class C4403a {

        /* renamed from: a */
        View f23255a;

        /* renamed from: b */
        TextView f23256b;

        private C4403a() {
        }

        /* synthetic */ C4403a(C4402b c4402b, byte b) {
            this();
        }
    }

    /* renamed from: com.unionpay.mobile.android.views.order.b$b */
    /* loaded from: classes2.dex */
    public interface InterfaceC4404b {
        /* renamed from: a */
        int mo785a();

        /* renamed from: a */
        int mo784a(int i);

        /* renamed from: b */
        int mo783b(int i);
    }

    public C4402b(Context context, List<Map<String, Object>> list, String str) {
        super(context);
        this.f23245q = new View$OnClickListenerC4405c(this);
        this.f23246r = new View$OnClickListenerC4406d(this);
        this.f23247s = new C4407e(this);
        this.f23233B = false;
        this.f23234C = InterfaceC4414l.f23274b.intValue();
        this.f23250v = 1;
        this.f23249u = -1;
        this.f23239k = list;
        this.f23244p = str;
        this.f23243o = new C4356c(this.f23213b, this.f23239k, C4171c.f22227bD.f22318bh, this.f23244p, C4171c.f22227bD.f22319bi, this.f23250v, 0);
        this.f23243o.m978a(this.f23245q);
        this.f23242n = new C4360g(this.f23213b, this.f23243o);
        this.f23242n.m961a(this.f23247s);
        this.f23242n.m962a(this.f23246r);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m801a(C4402b c4402b, View view) {
        if (c4402b.f23241m == null) {
            c4402b.f23241m = new PopupWindow((View) c4402b.f23242n, -1, -1, true);
            c4402b.f23241m.setBackgroundDrawable(new ColorDrawable(-1342177280));
            c4402b.f23241m.update();
        }
        c4402b.f23241m.showAtLocation(view, 80, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public final void m793c(int i) {
        int m972c = i - this.f23243o.m972c();
        if (i == 0) {
            return;
        }
        List<Map<String, Object>> list = this.f23239k;
        if (list != null && i == list.size() + this.f23243o.m972c()) {
            C4390k.m838a("direct", " new ");
            InterfaceC4404b interfaceC4404b = this.f23251w;
            if (interfaceC4404b != null) {
                interfaceC4404b.mo785a();
            }
        } else if (this.f23243o.m975b() && this.f23243o.m971c(i)) {
            C4390k.m838a("direct", " delete ".concat(String.valueOf(i)));
            m786i();
            InterfaceC4404b interfaceC4404b2 = this.f23251w;
            if (interfaceC4404b2 != null) {
                this.f23249u = m972c;
                interfaceC4404b2.mo784a(m972c);
            }
        } else {
            this.f23250v = i;
            this.f23243o.m979a(this.f23250v);
            C4390k.m838a("direct", " pay with ".concat(String.valueOf(i)));
            C4403a c4403a = this.f23248t;
            if (c4403a != null) {
                c4403a.f23256b.setText(this.f23243o.m974b(this.f23250v));
            }
            InterfaceC4404b interfaceC4404b3 = this.f23251w;
            if (interfaceC4404b3 != null) {
                interfaceC4404b3.mo783b(m972c);
            }
        }
        this.f23241m.dismiss();
    }

    /* renamed from: h */
    private boolean m787h() {
        List<Map<String, Object>> list;
        return this.f23237i || (list = this.f23239k) == null || list.size() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m786i() {
        C4356c c4356c = this.f23243o;
        if (c4356c != null) {
            c4356c.m980a();
            String str = this.f23243o.m975b() ? C4171c.f22227bD.f22320bj : C4171c.f22227bD.f22318bh;
            String str2 = this.f23243o.m975b() ? C4171c.f22227bD.f22321bk : C4171c.f22227bD.f22319bi;
            this.f23243o.m976a(str);
            this.f23243o.m973b(str2);
            this.f23243o.notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public final C4402b m805a(Drawable drawable, Drawable drawable2, Drawable drawable3) {
        this.f23252x = drawable;
        this.f23253y = drawable2;
        this.f23254z = drawable3;
        return this;
    }

    /* renamed from: a */
    public final C4402b m804a(InterfaceC4404b interfaceC4404b) {
        this.f23251w = interfaceC4404b;
        return this;
    }

    /* renamed from: a */
    public final C4402b m800a(JSONArray jSONArray) {
        this.f23236h = jSONArray;
        return this;
    }

    /* renamed from: a */
    public final C4402b m799a(JSONObject jSONObject) {
        this.f23235g = jSONObject;
        TextView textView = this.f23232A;
        if (textView != null) {
            textView.setText(Html.fromHtml(m823a(this.f23235g, "label")));
        }
        return this;
    }

    /* renamed from: a */
    public final void m806a(int i) {
        int i2;
        List<Map<String, Object>> list = this.f23239k;
        int size = list != null ? list.size() : 0;
        if (size > 0 && (i2 = this.f23249u) >= 0 && i2 < size) {
            this.f23239k.remove(i2);
            this.f23249u = -1;
            this.f23243o.notifyDataSetChanged();
        }
        m793c(i + this.f23243o.m972c());
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    /* renamed from: a */
    public final void mo782a(RelativeLayout relativeLayout) {
        TextView textView = new TextView(this.f23213b);
        textView.setTextSize(C4150b.f22148k);
        textView.setTextColor(-13421773);
        textView.setText(this.f23214c);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(15, -1);
        layoutParams.leftMargin = C4386g.m858a(this.f23213b, 10.0f);
        relativeLayout.addView(textView, layoutParams);
        if (TextUtils.isEmpty(this.f23214c)) {
            relativeLayout.setVisibility(8);
        }
        if (m787h()) {
            String a = m823a(this.f23235g, "label");
            this.f23232A = new TextView(this.f23213b);
            this.f23232A.setOnClickListener(new View$OnClickListenerC4408f(this));
            if (!m824a(a)) {
                this.f23232A.setText(Html.fromHtml(a));
            }
            m828a(this.f23232A);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(11, -1);
            layoutParams2.rightMargin = C4386g.m858a(this.f23213b, 10.0f);
            layoutParams2.addRule(15, -1);
            relativeLayout.addView(this.f23232A, layoutParams2);
        }
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    /* renamed from: b */
    public final int mo779b() {
        return this.f23234C;
    }

    /* renamed from: b */
    public final C4402b m797b(Drawable drawable) {
        this.f23240l = drawable;
        return this;
    }

    /* renamed from: b */
    public final C4402b m794b(boolean z) {
        this.f23233B = z;
        return this;
    }

    /* renamed from: b */
    public final void m798b(int i) {
        this.f23234C = i;
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    /* renamed from: b */
    public final void mo778b(RelativeLayout relativeLayout) {
        if (m787h() || this.f23233B) {
            if (this.f23233B) {
                m819g();
            }
            this.f23238j = new C4343a(this.f23213b, this.f23236h, this, "bankpay");
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = C4149a.f22117f;
            relativeLayout.addView(this.f23238j, layoutParams);
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.f23213b);
        linearLayout.setId(linearLayout.hashCode());
        linearLayout.setBackgroundColor(-3419943);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, 1);
        layoutParams2.topMargin = C4149a.f22117f;
        relativeLayout.addView(linearLayout, layoutParams2);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f23213b);
        relativeLayout2.setId(relativeLayout2.hashCode());
        relativeLayout2.setBackgroundDrawable(this.f23240l);
        relativeLayout2.setOnClickListener(new View$OnClickListenerC4409g(this));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, C4150b.f22151n);
        layoutParams3.addRule(3, linearLayout.getId());
        relativeLayout.addView(relativeLayout2, layoutParams3);
        ImageView imageView = new ImageView(this.f23213b);
        imageView.setId(imageView.hashCode());
        imageView.setBackgroundDrawable(C4342c.m1036a(this.f23213b).m1037a(1002, -1, -1));
        int m858a = C4386g.m858a(this.f23213b, 15.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(m858a, m858a);
        layoutParams4.addRule(11, -1);
        layoutParams4.addRule(15, -1);
        layoutParams4.rightMargin = C4386g.m858a(this.f23213b, 10.0f);
        relativeLayout2.addView(imageView, layoutParams4);
        TextView textView = new TextView(this.f23213b);
        textView.setText(this.f23243o.m974b(this.f23250v));
        textView.setTextSize(C4150b.f22148k);
        textView.setTextColor(-10066330);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(9, -1);
        layoutParams5.addRule(15, -1);
        layoutParams5.addRule(0, imageView.getId());
        layoutParams5.leftMargin = C4386g.m858a(this.f23213b, 10.0f);
        relativeLayout2.addView(textView, layoutParams5);
        LinearLayout linearLayout2 = new LinearLayout(this.f23213b);
        linearLayout2.setBackgroundColor(-3419943);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, 1);
        layoutParams6.bottomMargin = C4149a.f22117f;
        layoutParams6.addRule(3, relativeLayout2.getId());
        relativeLayout.addView(linearLayout2, layoutParams6);
        this.f23248t = new C4403a(this, (byte) 0);
        C4403a c4403a = this.f23248t;
        c4403a.f23255a = relativeLayout2;
        c4403a.f23256b = textView;
    }

    /* renamed from: b */
    public final void m795b(String str) {
        C4403a c4403a = this.f23248t;
        if (c4403a != null) {
            c4403a.f23256b.setText(str);
        }
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    /* renamed from: c */
    public final C4343a.C4344a mo774c() {
        C4343a c4343a = this.f23238j;
        if (c4343a != null) {
            return c4343a.m1024b();
        }
        return null;
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    /* renamed from: c */
    public final void mo773c(RelativeLayout relativeLayout) {
        relativeLayout.setVisibility(8);
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    /* renamed from: d */
    public final int mo791d() {
        return this.f23250v - this.f23243o.m972c();
    }

    /* renamed from: d */
    public final C4402b m790d(String str) {
        this.f23214c = str;
        return this;
    }

    /* renamed from: e */
    public final C4402b m789e(String str) {
        this.f23215d = str;
        return this;
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    /* renamed from: e */
    public final String mo771e() {
        return this.f23215d;
    }

    /* renamed from: f */
    public final void m788f(String str) {
        this.f23243o.m973b(str);
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    /* renamed from: f */
    public final boolean mo769f() {
        C4343a c4343a = this.f23238j;
        return c4343a == null || c4343a.m1016e();
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: r */
    public final void mo767r() {
    }
}
