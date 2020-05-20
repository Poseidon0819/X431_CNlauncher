package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.mapapi.UIMsg;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.model.C4172a;
import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.model.InterfaceC4175d;
import com.unionpay.mobile.android.model.InterfaceC4176e;
import com.unionpay.mobile.android.nocard.utils.C4190f;
import com.unionpay.mobile.android.upviews.C4343a;
import com.unionpay.mobile.android.utils.C4386g;
import com.unionpay.mobile.android.utils.C4389j;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.mobile.android.utils.C4394o;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.views.order.C4417o;
import com.unionpay.mobile.android.views.order.InterfaceC4414l;
import com.unionpay.mobile.android.widgets.C4449ay;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.nocard.views.ao */
/* loaded from: classes2.dex */
public class C4206ao extends AbstractC4219b implements C4343a.InterfaceC4345b {

    /* renamed from: A */
    private Handler f22550A;

    /* renamed from: r */
    List<Map<String, Object>> f22551r;

    /* renamed from: s */
    private int f22552s;

    /* renamed from: t */
    private int f22553t;

    /* renamed from: u */
    private Button f22554u;

    /* renamed from: v */
    private C4343a f22555v;

    /* renamed from: w */
    private C4417o f22556w;

    /* renamed from: x */
    private LinearLayout f22557x;

    /* renamed from: y */
    private boolean f22558y;

    /* renamed from: z */
    private Handler f22559z;

    /* renamed from: com.unionpay.mobile.android.nocard.views.ao$a */
    /* loaded from: classes2.dex */
    public class C4207a implements C4417o.InterfaceC4418a {
        public C4207a() {
        }

        @Override // com.unionpay.mobile.android.views.order.C4402b.InterfaceC4404b
        /* renamed from: a */
        public final int mo785a() {
            C4206ao.this.f22590a.f22384J = true;
            C4206ao.this.m1411d(2);
            return 0;
        }

        @Override // com.unionpay.mobile.android.views.order.C4402b.InterfaceC4404b
        /* renamed from: a */
        public final int mo784a(int i) {
            C4206ao.this.f22553t = i;
            C4206ao.this.f22552s = 3;
            C4206ao c4206ao = C4206ao.this;
            c4206ao.f22599j = false;
            c4206ao.f22591b.m635a(C4171c.f22227bD.f22248U);
            C4206ao.this.f22594e.m1491l(C4206ao.this.f22590a.f22481q.get(i).mo1544a());
            return 0;
        }

        @Override // com.unionpay.mobile.android.views.order.AbstractMethod.InterfaceC4398a
        /* renamed from: a */
        public final void mo818a(int i, boolean z, int i2, C4343a.C4344a c4344a) {
            String m1388b;
            if (C4206ao.this.f22556w != null) {
                C4206ao.this.f22590a.f22416aQ = C4206ao.this.f22556w.m763a();
                StringBuilder sb = new StringBuilder();
                sb.append(C4206ao.this.f22590a.f22416aQ);
                C4390k.m836c("functionEx", sb.toString());
            }
            if (i == InterfaceC4414l.f23277e.intValue()) {
                C4206ao.m1458c(C4206ao.this, i2);
            } else if (z) {
                C4206ao.this.f22590a.f22388N = i2;
                C4206ao c4206ao = C4206ao.this;
                c4206ao.f22599j = false;
                c4206ao.f22552s = 2;
                C4206ao.this.f22591b.m635a(C4171c.f22227bD.f22248U);
                if (C4206ao.this.f22590a.f22481q.get(i2).mo1541c() == 0) {
                    String mo1544a = C4206ao.this.f22590a.f22481q.get(i2).mo1544a();
                    C4206ao.this.f22590a.f22387M = "1";
                    m1388b = C4228bh.m1391a(C4206ao.this.f22590a.f22387M, mo1544a, "1", "1");
                } else {
                    C4206ao.this.f22590a.f22387M = "0";
                    String mo1542b = C4206ao.this.f22590a.f22481q.get(i2).mo1542b();
                    String str = C4206ao.this.f22590a.f22387M;
                    m1388b = C4228bh.m1388b(str, "\"pan\":\"" + mo1542b + "\"", "2", "1\",\"carrier_tp\":\"2");
                }
                C4206ao.this.f22594e.m1506c(C4228bh.m1390a(C4206ao.this.f22590a.f22474j), m1388b);
            } else if (!c4344a.m1014a()) {
                C4206ao.this.m1422a(c4344a.f23028b);
            } else if (i == InterfaceC4414l.f23275c.intValue()) {
                C4206ao c4206ao2 = C4206ao.this;
                c4206ao2.f22599j = false;
                c4206ao2.f22552s = 4;
                C4206ao.this.f22591b.m635a(C4171c.f22227bD.f22248U);
                C4206ao.this.f22594e.m1490m(c4344a.f23028b);
            } else {
                C4206ao c4206ao3 = C4206ao.this;
                c4206ao3.f22599j = false;
                c4206ao3.f22552s = 2;
                C4206ao.this.f22591b.m635a(C4171c.f22227bD.f22248U);
                C4206ao.this.f22590a.f22387M = "0";
                C4206ao.this.f22594e.m1506c(C4228bh.m1390a(C4206ao.this.f22590a.f22474j), C4228bh.m1388b(C4206ao.this.f22590a.f22387M, c4344a.f23028b, "1", "1"));
            }
        }

        @Override // com.unionpay.mobile.android.views.order.AbstractMethod.InterfaceC4399b
        /* renamed from: a */
        public final void mo817a(String str, String str2) {
            C4206ao.this.m1420a(str, str2);
        }

        @Override // com.unionpay.mobile.android.views.order.C4402b.InterfaceC4404b
        /* renamed from: b */
        public final int mo783b(int i) {
            String[] strArr = C4394o.f23203f;
            new Object[1][0] = Integer.valueOf(i);
            return 0;
        }

        @Override // com.unionpay.mobile.android.views.order.CViewMethods.InterfaceC4400a
        /* renamed from: c */
        public final void mo807c(int i) {
            C4206ao.this.m1401q();
            if (i == InterfaceC4414l.f23274b.intValue()) {
                C4206ao.this.f22590a.f22415aP = InterfaceC4414l.f23274b.intValue();
                C4206ao.this.m1411d(2);
            } else if (i == InterfaceC4414l.f23275c.intValue()) {
                C4206ao.m1457d(C4206ao.this);
            } else if (i == InterfaceC4414l.f23276d.intValue()) {
                C4206ao.this.m1411d(17);
            } else if (i == InterfaceC4414l.f23277e.intValue()) {
                C4206ao.m1452f(C4206ao.this);
            } else if (i == InterfaceC4414l.f23278f.intValue()) {
                C4206ao c4206ao = C4206ao.this;
                c4206ao.mo1088d(c4206ao.f22590a.f22462bp, C4206ao.this.f22590a.f22463bq);
            }
        }
    }

    public C4206ao(Context context, InterfaceC4176e interfaceC4176e) {
        super(context, interfaceC4176e);
        this.f22552s = 0;
        this.f22553t = -1;
        this.f22554u = null;
        this.f22555v = null;
        this.f22551r = new ArrayList(1);
        this.f22558y = false;
        this.f22559z = null;
        this.f22550A = new Handler(new C4208ap(this));
        this.f22595f = 2;
        if (this.f22590a.f22404aE && this.f22590a.f22451az) {
            this.f22590a.f22415aP = InterfaceC4414l.f23277e.intValue();
        }
        this.f22606q = "order";
        setBackgroundColor(-1052684);
        m1410e();
        if (!TextUtils.isEmpty(this.f22590a.f22485u) || this.f22590a.f22402aC) {
            this.f22559z = new Handler(new C4209aq(this));
        }
        if (C4173b.f22371bl || this.f22590a.f22415aP != InterfaceC4414l.f23277e.intValue() || !this.f22590a.f22451az || this.f22590a.f22402aC || this.f22590a.f22403aD) {
            return;
        }
        this.f22550A.sendMessageDelayed(this.f22550A.obtainMessage(UIMsg.d_ResultType.SHORT_URL), 8000L);
        C4390k.m836c("uppay", "mHceHandler.sendMessageDelayed(msg, 8000)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static Map<String, Object> m1462b(InterfaceC4175d interfaceC4175d) {
        HashMap hashMap = new HashMap();
        hashMap.put("text1", interfaceC4175d.mo1537b() + interfaceC4175d.mo1536c());
        hashMap.put("text2", interfaceC4175d.mo1538a().substring(0, 4) + " **** " + interfaceC4175d.mo1538a().substring(interfaceC4175d.mo1538a().length() - 4));
        return hashMap;
    }

    /* renamed from: c */
    static /* synthetic */ void m1458c(C4206ao c4206ao, int i) {
        c4206ao.f22552s = 6;
        c4206ao.f22599j = false;
        c4206ao.f22591b.m635a(C4171c.f22227bD.f22248U);
        String mo1538a = C4173b.f22370bb.get(i).mo1538a();
        String mo1534e = C4173b.f22370bb.get(i).mo1534e();
        String mo1535d = C4173b.f22370bb.get(i).mo1535d();
        c4206ao.f22590a.f22453bc = i;
        String str = "\"pan\":\"" + mo1538a + "\",\"carrier_tp\":\"9\",\"issuer\":\"" + mo1534e + "\",\"type\":\"" + mo1535d + "\"";
        C4390k.m836c("uppay", str);
        c4206ao.f22594e.m1506c("cardrules", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static /* synthetic */ void m1457d(C4206ao c4206ao) {
        if (c4206ao.f22590a.f22485u == null || c4206ao.f22590a.f22485u.length() <= 0) {
            c4206ao.f22590a.f22415aP = InterfaceC4414l.f23275c.intValue();
            c4206ao.m1411d(2);
            return;
        }
        c4206ao.f22552s = 4;
        c4206ao.f22599j = false;
        c4206ao.f22591b.m635a(C4171c.f22227bD.f22248U);
        c4206ao.f22594e.m1490m(String.format("\"user_id\":\"%s\"", c4206ao.f22590a.f22485u));
    }

    /* renamed from: d */
    private void m1456d(JSONObject jSONObject) {
        int m1478a = C4190f.m1478a(this.f22590a, jSONObject, false);
        if (m1478a != 0) {
            mo1137b(m1478a);
        } else {
            InterfaceC4176e m1476a = C4190f.m1476a(jSONObject);
            if (this.f22590a.f22490z != null && this.f22590a.f22490z.length() > 0) {
                m1427a(6, m1476a);
            } else if (this.f22590a.f22378D != null && this.f22590a.f22378D.length() > 0) {
                m1411d(5);
            }
        }
        this.f22552s = 0;
    }

    /* renamed from: e */
    private void m1453e(JSONObject jSONObject) {
        int m1475b = C4190f.m1475b(this.f22590a, jSONObject);
        if (m1475b != 0) {
            mo1137b(m1475b);
            return;
        }
        String m846a = C4389j.m846a(jSONObject, "userId");
        if (!TextUtils.isEmpty(m846a)) {
            String[] strArr = C4394o.f23202e;
            new Object[1][0] = m846a;
        }
        C4417o c4417o = this.f22556w;
        if (c4417o != null) {
            String m751b = c4417o.m751b();
            if (!TextUtils.isEmpty(m751b)) {
                PreferenceUtils.m894d(this.f22593d, m751b);
            }
        }
        m1427a(13, C4190f.m1476a(jSONObject));
        this.f22552s = 0;
    }

    /* renamed from: f */
    static /* synthetic */ void m1452f(C4206ao c4206ao) {
        if (C4173b.f22371bl && (C4173b.f22370bb == null || C4173b.f22370bb.size() <= 0)) {
            c4206ao.m1419a(C4171c.f22227bD.f22327bq, c4206ao.f22590a.f22458bh, c4206ao.f22590a.f22404aE, true);
            return;
        }
        c4206ao.f22590a.f22415aP = InterfaceC4414l.f23277e.intValue();
        c4206ao.m1411d(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public void m1450v() {
        if (this.f22590a.f22415aP != InterfaceC4414l.f23277e.intValue() || !this.f22590a.f22451az || this.f22590a.f22402aC || this.f22590a.f22403aD) {
            return;
        }
        this.f22550A.removeMessages(UIMsg.d_ResultType.SHORT_URL);
        C4390k.m836c("uppay", "mHceHandler remove Message");
    }

    /* renamed from: a */
    protected void mo1097a(Handler handler) {
    }

    /* renamed from: a */
    public final void m1466a(C4172a c4172a) {
        this.f22590a.f22464br = true;
        this.f22590a.f22465bs = c4172a;
        this.f22552s = 2;
        this.f22591b.m635a(C4171c.f22227bD.f22248U);
        this.f22590a.f22387M = "0";
        String str = this.f22590a.f22387M;
        this.f22594e.m1506c(C4228bh.m1390a(this.f22590a.f22474j), C4228bh.m1388b(str, "\"pan\":\"" + c4172a.mo1542b() + "\"", "2", "1\",\"carrier_tp\":\"10"));
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: a */
    public final void mo827a(C4343a.C4344a c4344a) {
    }

    @Override // com.unionpay.mobile.android.nocard.views.InterfaceC4191a
    /* renamed from: a */
    public final void mo1077a(JSONObject jSONObject) {
        this.f22591b.m630c();
        switch (this.f22552s) {
            case 1:
                C4173b c4173b = this.f22590a;
                c4173b.f22398X = C4389j.m842d(jSONObject, "login_rules");
                c4173b.f22399Y = C4389j.m843c(jSONObject, "register_url");
                if (((c4173b.f22398X == null || c4173b.f22398X.length() <= 0) ? (char) 2 : (char) 0) != 0) {
                    mo1137b(2);
                } else {
                    m1411d(12);
                }
                this.f22552s = 0;
                return;
            case 2:
                if (m1414b(jSONObject)) {
                    return;
                }
                m1456d(jSONObject);
                return;
            case 3:
                C4173b c4173b2 = this.f22590a;
                int i = this.f22553t;
                if (c4173b2.f22481q != null && i < c4173b2.f22481q.size()) {
                    c4173b2.f22481q.remove(i);
                }
                if (this.f22590a.f22481q == null || this.f22590a.f22481q.size() <= 0) {
                    this.f22590a.f22388N = -1;
                    mo1072c();
                } else {
                    if (this.f22553t == this.f22590a.f22388N) {
                        this.f22590a.f22388N = 0;
                    } else if (this.f22553t < this.f22590a.f22388N) {
                        C4173b c4173b3 = this.f22590a;
                        c4173b3.f22388N--;
                    }
                    this.f22556w.m744c(this.f22590a.f22388N);
                }
                this.f22552s = 0;
                return;
            case 4:
                if (m1414b(jSONObject)) {
                    return;
                }
                m1453e(jSONObject);
                return;
            case 5:
                m1407i();
                int m1478a = C4190f.m1478a(this.f22590a, jSONObject, false);
                if (m1478a != 0) {
                    mo1137b(m1478a);
                    return;
                }
                InterfaceC4176e m1476a = C4190f.m1476a(jSONObject);
                if (this.f22590a.f22490z != null && this.f22590a.f22490z.length() > 0) {
                    m1427a(6, m1476a);
                    return;
                } else if (this.f22590a.f22378D == null || this.f22590a.f22378D.length() <= 0) {
                    return;
                } else {
                    m1411d(5);
                    return;
                }
            case 6:
                this.f22591b.m630c();
                int m1478a2 = C4190f.m1478a(this.f22590a, jSONObject, false);
                if (m1478a2 != 0) {
                    mo1137b(m1478a2);
                    return;
                }
                InterfaceC4176e m1476a2 = C4190f.m1476a(jSONObject);
                m1450v();
                m1427a(18, m1476a2);
                return;
            default:
                return;
        }
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: a */
    public final void mo822a(boolean z) {
        Button button = this.f22554u;
        if (button == null || button == null) {
            return;
        }
        button.setEnabled(!z);
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: b */
    protected final void mo1076b() {
        String str;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        String str2 = this.f22590a.f22479o;
        C4449ay c4449ay = new C4449ay(this.f22593d, str2, this);
        if (!this.f22590a.f22384J) {
            if ((this.f22590a.f22404aE && this.f22590a.f22415aP == InterfaceC4414l.f23277e.intValue()) || this.f22590a.f22415aP == InterfaceC4414l.f23273a.intValue() || (this.f22590a.f22415aP == InterfaceC4414l.f23275c.intValue() && this.f22590a.f22402aC && (this.f22590a.f22481q == null || this.f22590a.f22481q.size() <= 0))) {
                c4449ay = new C4449ay(this.f22593d, str2, this.f22592c.m1037a(1030, -1, -1), C4386g.m858a(this.f22593d, 20.0f), this);
            }
            if (this.f22590a.f22415aP == InterfaceC4414l.f23277e.intValue()) {
                str = C4171c.f22227bD.f22327bq;
            }
            layoutParams.addRule(13, -1);
            this.f22600k.addView(c4449ay, layoutParams);
        }
        str = C4171c.f22227bD.f22346l;
        c4449ay.m680a(str);
        layoutParams.addRule(13, -1);
        this.f22600k.addView(c4449ay, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: b */
    public final void mo1357b(String str, JSONObject jSONObject) {
        if ("init".equals(str)) {
            if (this.f22590a.f22384J) {
                m1405m();
            }
        } else if (!"".equals(str)) {
            this.f22591b.m635a(C4171c.f22227bD.f22248U);
            this.f22599j = false;
            this.f22552s = 5;
            this.f22594e.m1506c(str, "");
        } else {
            int i = this.f22552s;
            if (i == 2) {
                m1456d(jSONObject);
            } else if (i == 4) {
                m1453e(jSONObject);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x026c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void mo1072c() {
        /*
            Method dump skipped, instructions count: 816
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.mobile.android.nocard.views.C4206ao.mo1072c():void");
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: c */
    public final void mo821c(String str) {
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: c */
    public final void mo820c(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public void mo1088d(String str, String str2) {
    }

    /* renamed from: e */
    public final void m1454e(String str, String str2) {
        if (str2 != null && str2.length() > 0) {
            this.f22590a.f22383I.f22848f = str2;
        }
        mo1138a(str, true);
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: k */
    public final void mo1056k() {
        if (!this.f22590a.f22404aE && this.f22590a.f22384J) {
            super.mo1056k();
            m1450v();
            this.f22590a.f22384J = false;
        } else if (this.f22590a.f22404aE || ((this.f22590a.f22415aP == InterfaceC4414l.f23273a.intValue() || (this.f22590a.f22415aP == InterfaceC4414l.f23275c.intValue() && this.f22590a.f22402aC && (this.f22590a.f22481q == null || this.f22590a.f22481q.size() <= 0))) && this.f22590a.f22415aP != InterfaceC4414l.f23277e.intValue())) {
            m1450v();
            m1451s();
        } else {
            super.mo1056k();
            m1450v();
            this.f22590a.f22415aP = InterfaceC4414l.f23273a.intValue();
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (C4173b.f22372bm && this.f22590a.f22415aP == InterfaceC4414l.f23273a.intValue() && !"1".equalsIgnoreCase(this.f22590a.f22439an)) {
            C4390k.m836c("spay", "out");
            mo1088d(this.f22590a.f22462bp, this.f22590a.f22463bq);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C4343a c4343a = this.f22555v;
        if (c4343a != null) {
            c4343a.clearFocus();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Handler handler;
        super.onDraw(canvas);
        if (this.f22558y || (handler = this.f22559z) == null) {
            return;
        }
        this.f22558y = true;
        handler.sendEmptyMessage(0);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: r */
    public final void mo767r() {
    }

    /* renamed from: s */
    public final void m1451s() {
        this.f22591b.m636a(new View$OnClickListenerC4210ar(this), new View$OnClickListenerC4211as(this));
        this.f22591b.m633a(C4171c.f22227bD.f22252Y, C4171c.f22227bD.f22302av, C4171c.f22227bD.f22250W, C4171c.f22227bD.f22251X);
    }

    /* renamed from: t */
    protected boolean mo1087t() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: u */
    public void mo1086u() {
    }
}
