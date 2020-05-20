package com.unionpay.mobile.android.nocard.views;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.model.InterfaceC4176e;
import com.unionpay.mobile.android.nocard.utils.C4188d;
import com.unionpay.mobile.android.nocard.utils.C4190f;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.plugin.BaseActivity;
import com.unionpay.mobile.android.resource.C4342c;
import com.unionpay.mobile.android.upwidget.UPScrollView;
import com.unionpay.mobile.android.utils.C4386g;
import com.unionpay.mobile.android.utils.C4387h;
import com.unionpay.mobile.android.utils.C4389j;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.mobile.android.views.order.C4415m;
import com.unionpay.mobile.android.views.order.InterfaceC4414l;
import com.unionpay.mobile.android.widgets.AbstractC4420aa;
import com.unionpay.mobile.android.widgets.AbstractC4486z;
import com.unionpay.mobile.android.widgets.C4424ad;
import com.unionpay.mobile.android.widgets.C4425ae;
import com.unionpay.mobile.android.widgets.C4426af;
import com.unionpay.mobile.android.widgets.C4429ah;
import com.unionpay.mobile.android.widgets.C4438ao;
import com.unionpay.mobile.android.widgets.C4439ap;
import com.unionpay.mobile.android.widgets.C4443as;
import com.unionpay.mobile.android.widgets.C4444at;
import com.unionpay.mobile.android.widgets.C4445au;
import com.unionpay.mobile.android.widgets.C4446av;
import com.unionpay.mobile.android.widgets.C4449ay;
import com.unionpay.mobile.android.widgets.C4463e;
import com.unionpay.mobile.android.widgets.C4464f;
import com.unionpay.mobile.android.widgets.C4465g;
import com.unionpay.mobile.android.widgets.C4471m;
import com.unionpay.mobile.android.widgets.C4485y;
import com.unionpay.mobile.android.widgets.UPWidget;
import com.unionpay.mobile.android.widgets.View$OnClickListenerC4479u;
import com.unionpay.tsmservice.data.Constant;
import org.jivesoftware.smackx.FormField;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.nocard.views.b */
/* loaded from: classes2.dex */
public abstract class AbstractC4219b extends RelativeLayout implements UPPayEngine.InterfaceC4183a, InterfaceC4191a, UPScrollView.InterfaceC4353a, AbstractC4420aa.InterfaceC4421a, C4449ay.InterfaceC4450a {

    /* renamed from: a */
    public C4173b f22590a;

    /* renamed from: b */
    public C4471m f22591b;

    /* renamed from: c */
    protected C4342c f22592c;

    /* renamed from: d */
    public Context f22593d;

    /* renamed from: e */
    public UPPayEngine f22594e;

    /* renamed from: f */
    protected int f22595f;

    /* renamed from: g */
    protected String f22596g;

    /* renamed from: h */
    protected String f22597h;

    /* renamed from: i */
    protected String f22598i;

    /* renamed from: j */
    public boolean f22599j;

    /* renamed from: k */
    protected RelativeLayout f22600k;

    /* renamed from: l */
    protected ViewGroup f22601l;

    /* renamed from: m */
    protected RelativeLayout f22602m;

    /* renamed from: n */
    protected C4443as f22603n;

    /* renamed from: o */
    protected UPScrollView f22604o;

    /* renamed from: p */
    protected InterfaceC4176e f22605p;

    /* renamed from: q */
    public String f22606q;

    /* renamed from: r */
    private LinearLayout f22607r;

    /* renamed from: s */
    private LinearLayout f22608s;

    /* renamed from: t */
    private LinearLayout f22609t;

    /* renamed from: u */
    private int f22610u;

    /* renamed from: v */
    private int f22611v;

    /* renamed from: w */
    private Activity f22612w;

    public AbstractC4219b(Context context) {
        this(context, null);
    }

    public AbstractC4219b(Context context, InterfaceC4176e interfaceC4176e) {
        super(context);
        this.f22590a = null;
        this.f22591b = null;
        this.f22592c = null;
        this.f22593d = null;
        this.f22594e = null;
        this.f22596g = null;
        this.f22597h = null;
        this.f22598i = null;
        this.f22599j = true;
        this.f22600k = null;
        this.f22601l = null;
        this.f22602m = null;
        this.f22603n = null;
        this.f22604o = null;
        this.f22606q = "uppay";
        this.f22612w = null;
        this.f22595f = 0;
        this.f22593d = context;
        Context context2 = this.f22593d;
        if (context2 instanceof Activity) {
            this.f22612w = (Activity) context2;
        }
        this.f22605p = interfaceC4176e;
        BaseActivity baseActivity = (BaseActivity) context;
        this.f22594e = (UPPayEngine) baseActivity.mo476a(UPPayEngine.class.toString());
        this.f22590a = (C4173b) baseActivity.mo476a((String) null);
        this.f22591b = (C4471m) baseActivity.mo476a(C4471m.class.toString());
        this.f22592c = C4342c.m1036a(context);
        setId(8888);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        setBackgroundColor(-1);
        C4390k.m837b("uppayEx", "UPViewBase:" + toString());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    private void m1425a(int i, boolean z, boolean z2) {
        Context context = this.f22593d;
        BaseActivity baseActivity = (BaseActivity) context;
        AbstractC4219b abstractC4219b = null;
        switch (i) {
            case 2:
            case 17:
            case 18:
                abstractC4219b = baseActivity.mo477a(i, null);
                break;
            case 5:
                abstractC4219b = new C4237g(context);
                break;
            case 6:
                int i2 = 0;
                if (this.f22590a.f22481q != null && this.f22590a.f22481q.size() > 0) {
                    i2 = this.f22590a.f22481q.get(this.f22590a.f22388N).mo1541c();
                }
                if ((!m1408h() && i2 != 0) || this.f22590a.f22464br) {
                    i = 6;
                    abstractC4219b = baseActivity.mo477a(i, null);
                    break;
                } else {
                    abstractC4219b = new C4212at(this.f22593d);
                    break;
                }
            case 8:
                abstractC4219b = new C4223bd(context);
                break;
            case 10:
                abstractC4219b = new C4202ak(context);
                break;
            case 11:
                abstractC4219b = new C4200ai(context);
                break;
            case 12:
                abstractC4219b = new C4197af(context);
                break;
            case 13:
                abstractC4219b = new C4245o(context, null);
                break;
            case 14:
                abstractC4219b = new C4229bi(context, z, z2);
                break;
        }
        if (abstractC4219b != null) {
            baseActivity.m1226a(abstractC4219b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public static boolean m1416b(String str) {
        return str != null && str.length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: o */
    public static ColorStateList m1403o() {
        int i = C4150b.f22139b;
        int i2 = C4150b.f22140c;
        return C4387h.m854a(i, i2, i2, C4150b.f22141d);
    }

    /* renamed from: r */
    private RelativeLayout m1400r() {
        LinearLayout linearLayout;
        int i;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        RelativeLayout relativeLayout = this.f22600k;
        if (relativeLayout != null) {
            layoutParams.addRule(3, relativeLayout.getId());
            layoutParams.addRule(12, -1);
        }
        FrameLayout frameLayout = new FrameLayout(this.f22593d);
        addView(frameLayout, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.f22604o = new UPScrollView(this.f22593d);
        this.f22604o.setPadding(0, 0, 0, 0);
        frameLayout.addView(this.f22604o, layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        int m858a = C4386g.m858a(this.f22593d, 10.0f);
        this.f22609t = new LinearLayout(this.f22593d);
        LinearLayout linearLayout2 = this.f22609t;
        linearLayout2.setId(linearLayout2.hashCode());
        this.f22609t.setOrientation(1);
        if (!this.f22590a.f22412aM || C4173b.f22372bm) {
            linearLayout = this.f22609t;
            i = -267336;
        } else {
            linearLayout = this.f22609t;
            i = -34177;
        }
        linearLayout.setBackgroundColor(i);
        this.f22609t.setPadding(m858a, m858a, m858a, m858a);
        String str = "";
        if (m1416b(this.f22590a.f22443ar)) {
            str = "" + this.f22590a.f22443ar;
        }
        if (m1416b(str)) {
            TextView textView = new TextView(this.f22593d);
            if (!this.f22590a.f22412aM || C4173b.f22372bm) {
                textView.setTextColor(-10066330);
            } else {
                textView.setTextColor(-1);
            }
            textView.setText(str);
            textView.setTextSize(C4150b.f22148k);
            this.f22609t.addView(textView);
        } else {
            this.f22609t.setVisibility(8);
        }
        this.f22609t.setVisibility(8);
        frameLayout.addView(this.f22609t, layoutParams3);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f22593d);
        relativeLayout2.setBackgroundColor(-1052684);
        this.f22604o.addView(relativeLayout2, new RelativeLayout.LayoutParams(-1, -1));
        return relativeLayout2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final RelativeLayout m1429a() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setId(relativeLayout.hashCode());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10, -1);
        addView(relativeLayout, layoutParams);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final AbstractC4486z m1418a(JSONObject jSONObject, String str) {
        String m846a = C4389j.m846a(jSONObject, VastExtensionXmlManager.TYPE);
        int i = C4149a.f22105I - (C4149a.f22117f * 4);
        AbstractC4486z c4426af = Constant.KEY_PAN.equalsIgnoreCase(m846a) ? new C4426af(this.f22593d, i, jSONObject, str) : "mobile".equalsIgnoreCase(m846a) ? new C4429ah(this.f22593d, i, jSONObject, str) : "sms".equalsIgnoreCase(m846a) ? new C4439ap(this.f22593d, i, jSONObject, str) : Constant.KEY_CVN2.equalsIgnoreCase(m846a) ? new C4463e(this.f22593d, i, jSONObject, str) : "expire".equalsIgnoreCase(m846a) ? new C4446av(this.f22593d, i, jSONObject, str) : "pwd".equalsIgnoreCase(m846a) ? new UPWidget(this.f22593d, this.f22594e.m1508c(), i, jSONObject, str) : "text".equalsIgnoreCase(m846a) ? new C4444at(this.f22593d, i, jSONObject, str) : "string".equalsIgnoreCase(m846a) ? new C4424ad(this.f22593d, jSONObject, str) : "cert_id".equalsIgnoreCase(m846a) ? new C4464f(this.f22593d, i, jSONObject, str) : "cert_type".equalsIgnoreCase(m846a) ? new C4465g(this.f22593d, jSONObject, str) : "name".equalsIgnoreCase(m846a) ? new C4425ae(this.f22593d, i, jSONObject, str) : FormField.TYPE_HIDDEN.equalsIgnoreCase(m846a) ? new C4485y(this.f22593d, jSONObject, str) : "user_name".equalsIgnoreCase(m846a) ? new C4445au(this.f22593d, i, jSONObject, str) : "password".equalsIgnoreCase(m846a) ? new C4438ao(this.f22593d, i, jSONObject, str) : null;
        if (c4426af != null && (c4426af instanceof AbstractC4420aa)) {
            ((AbstractC4420aa) c4426af).m723a((AbstractC4420aa.InterfaceC4421a) this);
        }
        return c4426af;
    }

    /* renamed from: a */
    public final void m1428a(int i) {
        ((BaseActivity) this.f22593d).m1227a(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    public final void m1427a(int i, InterfaceC4176e interfaceC4176e) {
        AbstractC4219b a;
        Context context = this.f22593d;
        BaseActivity baseActivity = (BaseActivity) context;
        switch (i) {
            case 2:
            case 17:
            case 18:
                a = baseActivity.mo477a(i, interfaceC4176e);
                break;
            case 3:
            case 4:
            case 7:
            case 9:
            case 15:
            case 16:
            default:
                a = null;
                break;
            case 5:
                a = new C4237g(context);
                break;
            case 6:
                int i2 = 0;
                if (this.f22590a.f22481q != null && this.f22590a.f22481q.size() > 0) {
                    i2 = this.f22590a.f22481q.get(this.f22590a.f22388N).mo1541c();
                }
                if ((!m1408h() && i2 != 0 && this.f22590a.f22415aP != InterfaceC4414l.f23275c.intValue()) || this.f22590a.f22464br) {
                    i = 6;
                    a = baseActivity.mo477a(i, interfaceC4176e);
                    break;
                } else {
                    a = new C4212at(this.f22593d, interfaceC4176e);
                    break;
                }
                break;
            case 8:
                a = new C4223bd(context);
                break;
            case 10:
                a = new C4202ak(context);
                break;
            case 11:
                a = new C4200ai(context);
                break;
            case 12:
                a = new C4197af(context);
                break;
            case 13:
                a = new C4245o(context, interfaceC4176e);
                break;
            case 14:
                a = new C4229bi(context);
                break;
        }
        if (a != null) {
            baseActivity.m1226a(a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0114  */
    @Override // com.unionpay.mobile.android.nocard.utils.UPPayEngine.InterfaceC4183a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo1426a(int r5, java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.mobile.android.nocard.views.AbstractC4219b.mo1426a(int, java.lang.String):void");
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4420aa.InterfaceC4421a
    /* renamed from: a */
    public final void mo719a(View$OnClickListenerC4479u view$OnClickListenerC4479u, String str) {
    }

    /* renamed from: a */
    public final void m1422a(String str) {
        mo1138a(str, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m1421a(String str, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.f22591b.m636a(onClickListener, onClickListener2);
        Activity activity = this.f22612w;
        if (activity == null || activity.isFinishing() || C4171c.f22227bD == null) {
            return;
        }
        this.f22591b.m632a(C4171c.f22227bD.f22252Y, str, C4171c.f22227bD.f22250W, C4171c.f22227bD.f22251X, false);
    }

    /* renamed from: a */
    public final void m1420a(String str, String str2) {
        m1419a(str, str2, false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m1419a(String str, String str2, boolean z, boolean z2) {
        ((InputMethodManager) this.f22593d.getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
        C4173b c4173b = this.f22590a;
        c4173b.f22432ag = str2;
        c4173b.f22431af = str;
        m1425a(14, z, z2);
    }

    /* renamed from: a */
    public void mo1138a(String str, boolean z) {
        View$OnClickListenerC4234d view$OnClickListenerC4234d = new View$OnClickListenerC4234d(this, z);
        C4390k.m838a("uppay", " showErrDialog(msg, boolean)  ");
        this.f22591b.m636a(view$OnClickListenerC4234d, null);
        Activity activity = this.f22612w;
        if (activity == null || activity.isFinishing() || C4171c.f22227bD == null) {
            return;
        }
        this.f22591b.m634a(C4171c.f22227bD.f22252Y, str, C4171c.f22227bD.f22250W);
    }

    /* renamed from: a */
    protected boolean mo1078a(String str, JSONObject jSONObject) {
        return false;
    }

    /* renamed from: b */
    protected void mo1076b() {
    }

    /* renamed from: b */
    public void mo1137b(int i) {
        String m1413c;
        boolean z;
        if (i == 8 || i == 17 || i == 19) {
            this.f22590a.f22383I.f22848f = "fail";
            C4390k.m838a("uppay", "showErrDialog 1");
            m1413c = m1413c(i);
            z = true;
        } else {
            C4390k.m838a("uppay", "showErrDialog 2");
            m1413c = m1413c(i);
            z = false;
        }
        mo1138a(m1413c, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final void m1415b(String str, String str2) {
        m1419a(str, str2, true, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void mo1357b(String str, JSONObject jSONObject) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final boolean m1414b(JSONObject jSONObject) {
        if (C4190f.m1474c(this.f22590a, jSONObject)) {
            m1412c(jSONObject);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: c */
    public final String m1413c(int i) {
        switch (i) {
            case 2:
                return C4171c.f22227bD.f22256aB;
            case 3:
                break;
            case 4:
                return C4171c.f22227bD.f22306az;
            case 5:
                return C4171c.f22227bD.f22262aH;
            case 6:
                return C4171c.f22227bD.f22263aI;
            case 7:
                return C4171c.f22227bD.f22261aG;
            case 8:
                return C4171c.f22227bD.f22264aJ;
            case 9:
                return C4171c.f22227bD.f22265aK;
            default:
                switch (i) {
                    case 16:
                        return C4171c.f22227bD.f22267aM;
                    case 17:
                        break;
                    case 18:
                        return C4171c.f22227bD.f22270aP;
                    case 19:
                        return C4171c.f22227bD.f22268aN;
                    case 20:
                        return C4171c.f22227bD.f22269aO;
                    case 21:
                        return C4171c.f22227bD.f22266aL;
                    default:
                        return C4171c.f22227bD.f22255aA;
                }
        }
        return this.f22597h;
    }

    /* renamed from: c */
    protected void mo1072c() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public final void m1412c(JSONObject jSONObject) {
        C4173b c4173b;
        this.f22591b.m636a(new View$OnClickListenerC4235e(this, jSONObject), new View$OnClickListenerC4236f(this, jSONObject));
        Activity activity = this.f22612w;
        if (activity == null || activity.isFinishing() || (c4173b = this.f22590a) == null) {
            return;
        }
        this.f22591b.m633a(c4173b.f22406aG, this.f22590a.f22407aH, this.f22590a.f22408aI, this.f22590a.f22410aK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public void mo1373d() {
        this.f22602m = m1400r();
    }

    /* renamed from: d */
    public final void m1411d(int i) {
        m1425a(i, false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public final void m1410e() {
        this.f22600k = m1429a();
        mo1076b();
        RelativeLayout m1400r = m1400r();
        LinearLayout linearLayout = new LinearLayout(this.f22593d);
        linearLayout.setOrientation(1);
        linearLayout.setId(linearLayout.hashCode());
        linearLayout.setBackgroundColor(-1114114);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10, -1);
        m1400r.addView(linearLayout, layoutParams);
        this.f22601l = linearLayout;
        this.f22601l.setBackgroundColor(0);
        mo1398f();
        int id = this.f22601l.getId();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(12, -1);
        layoutParams2.addRule(3, id);
        RelativeLayout relativeLayout = new RelativeLayout(this.f22593d);
        m1400r.addView(relativeLayout, layoutParams2);
        this.f22602m = relativeLayout;
        mo1072c();
    }

    @Override // com.unionpay.mobile.android.upwidget.UPScrollView.InterfaceC4353a
    /* renamed from: e */
    public final void mo990e(int i) {
        LinearLayout linearLayout;
        int i2 = this.f22611v;
        if (i >= i2) {
            if (this.f22609t.getVisibility() == 0 || this.f22609t == null || this.f22607r.getVisibility() != 0) {
                return;
            }
            this.f22609t.setVisibility(0);
        } else if (i > i2 + this.f22610u || this.f22609t.getVisibility() != 0 || (linearLayout = this.f22609t) == null) {
        } else {
            linearLayout.setVisibility(8);
        }
    }

    /* renamed from: f */
    protected void mo1398f() {
        this.f22608s = new LinearLayout(this.f22593d);
        this.f22608s.setOrientation(1);
        if (!this.f22590a.f22412aM || C4173b.f22372bm) {
            this.f22608s.setBackgroundColor(-267336);
        } else {
            this.f22608s.setBackgroundColor(-34177);
        }
        int m858a = C4386g.m858a(this.f22593d, 10.0f);
        if (m1416b(this.f22590a.f22443ar)) {
            this.f22608s.setPadding(m858a, m858a, m858a, 0);
        } else {
            this.f22608s.setPadding(m858a, m858a, m858a, m858a);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = 0;
        this.f22601l.addView(this.f22608s, layoutParams);
        String str = "";
        if (m1416b(this.f22590a.f22445at)) {
            str = "" + this.f22590a.f22445at;
        }
        if (m1416b(str)) {
            TextView textView = new TextView(this.f22593d);
            if (!this.f22590a.f22412aM || C4173b.f22372bm) {
                textView.setTextColor(-10066330);
            } else {
                textView.setTextColor(-1);
            }
            textView.setText(str);
            textView.setTextSize(C4150b.f22148k);
            this.f22608s.addView(textView);
        } else {
            this.f22608s.setVisibility(8);
        }
        this.f22607r = new LinearLayout(this.f22593d);
        this.f22607r.setOrientation(1);
        if (!this.f22590a.f22412aM || C4173b.f22372bm) {
            this.f22607r.setBackgroundColor(-267336);
        } else {
            this.f22607r.setBackgroundColor(-34177);
        }
        this.f22607r.setPadding(m858a, m858a, m858a, m858a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = 0;
        this.f22601l.addView(this.f22607r, layoutParams2);
        String str2 = "";
        if (m1416b(this.f22590a.f22443ar)) {
            str2 = "" + this.f22590a.f22443ar;
        }
        if (m1416b(str2)) {
            TextView textView2 = new TextView(this.f22593d);
            if (!this.f22590a.f22412aM || C4173b.f22372bm) {
                textView2.setTextColor(-10066330);
            } else {
                textView2.setTextColor(-1);
            }
            textView2.setText(str2);
            textView2.setTextSize(C4150b.f22148k);
            this.f22607r.addView(textView2);
        } else {
            this.f22607r.setVisibility(8);
        }
        this.f22607r.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver$OnPreDrawListenerC4233c(this));
        C4415m c4415m = new C4415m(this.f22593d);
        c4415m.m766a(this.f22592c.m1037a(1003, -1, -1), this.f22592c.m1037a(1001, -1, -1));
        c4415m.m764a(this instanceof C4206ao ? false : true, this.f22590a.f22472h, this.f22590a.f22473i);
        this.f22601l.addView(c4415m, new LinearLayout.LayoutParams(-1, -2));
        Drawable m1037a = this.f22592c.m1037a(1026, -1, -1);
        LinearLayout linearLayout = new LinearLayout(this.f22593d);
        if (m1037a != null) {
            linearLayout.setBackgroundDrawable(m1037a);
        }
        this.f22601l.addView(linearLayout, new LinearLayout.LayoutParams(-1, C4386g.m858a(this.f22593d, 2.0f)));
    }

    /* renamed from: g */
    public final int m1409g() {
        return this.f22595f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public final boolean m1408h() {
        return this.f22590a.f22384J || this.f22590a.f22481q == null || this.f22590a.f22481q.size() == 0;
    }

    /* renamed from: i */
    public final void m1407i() {
        C4471m c4471m = this.f22591b;
        if (c4471m == null || !c4471m.m638a()) {
            return;
        }
        this.f22591b.m630c();
    }

    /* renamed from: j */
    public final void m1406j() {
        C4188d.m1480a(this.f22593d, this.f22590a);
    }

    /* renamed from: k */
    public void mo1056k() {
        if (this.f22599j) {
            m1405m();
        }
    }

    @Override // com.unionpay.mobile.android.widgets.C4449ay.InterfaceC4450a
    /* renamed from: l */
    public final void mo678l() {
        mo1056k();
    }

    /* renamed from: m */
    public final void m1405m() {
        ((BaseActivity) this.f22593d).m1225b();
    }

    /* renamed from: n */
    public final boolean m1404n() {
        C4471m c4471m = this.f22591b;
        boolean z = c4471m != null && c4471m.m638a();
        C4390k.m838a("uppay", " dialog showing:".concat(String.valueOf(z)));
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        C4390k.m837b("uppayEx", toString() + " onAttachedToWindow()");
        super.onAttachedToWindow();
        this.f22594e.m1515a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: p */
    public final boolean m1402p() {
        return !this.f22590a.f22467c;
    }

    /* renamed from: q */
    public final void m1401q() {
        Context context = this.f22593d;
        if (context != null) {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }
}
