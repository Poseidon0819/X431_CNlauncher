package com.unionpay.mobile.android.upviews;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.upwidget.C4371q;
import com.unionpay.mobile.android.utils.C4389j;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.mobile.android.widgets.AbstractC4420aa;
import com.unionpay.mobile.android.widgets.AbstractC4486z;
import com.unionpay.mobile.android.widgets.C4424ad;
import com.unionpay.mobile.android.widgets.C4426af;
import com.unionpay.mobile.android.widgets.C4429ah;
import com.unionpay.mobile.android.widgets.C4432aj;
import com.unionpay.mobile.android.widgets.C4439ap;
import com.unionpay.mobile.android.widgets.C4446av;
import com.unionpay.mobile.android.widgets.C4463e;
import com.unionpay.mobile.android.widgets.C4471m;
import com.unionpay.mobile.android.widgets.C4474p;
import com.unionpay.mobile.android.widgets.UPWidget;
import com.unionpay.mobile.android.widgets.View$OnClickListenerC4479u;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.upviews.a */
/* loaded from: classes2.dex */
public final class C4343a extends LinearLayout implements C4371q.InterfaceC4372a, AbstractC4420aa.InterfaceC4421a, C4429ah.InterfaceC4430a, C4432aj.InterfaceC4433a, C4439ap.InterfaceC4440a {

    /* renamed from: a */
    private Context f23018a;

    /* renamed from: b */
    private C4471m f23019b;

    /* renamed from: c */
    private ArrayList<AbstractC4486z> f23020c;

    /* renamed from: d */
    private long f23021d;

    /* renamed from: e */
    private InterfaceC4345b f23022e;

    /* renamed from: f */
    private boolean f23023f;

    /* renamed from: g */
    private boolean f23024g;

    /* renamed from: h */
    private JSONObject f23025h;

    /* renamed from: i */
    private String f23026i;

    /* renamed from: com.unionpay.mobile.android.upviews.a$a */
    /* loaded from: classes2.dex */
    public class C4344a {

        /* renamed from: a */
        public int f23027a = 0;

        /* renamed from: b */
        public String f23028b;

        C4344a(String str) {
            this.f23028b = str;
        }

        /* renamed from: a */
        public final void m1013a(int i, String str) {
            this.f23028b = str;
            this.f23027a = i;
        }

        /* renamed from: a */
        public final boolean m1014a() {
            return this.f23027a == 0;
        }
    }

    /* renamed from: com.unionpay.mobile.android.upviews.a$b */
    /* loaded from: classes2.dex */
    public interface InterfaceC4345b {
        /* renamed from: a */
        void mo827a(C4344a c4344a);

        /* renamed from: a */
        void mo822a(boolean z);

        /* renamed from: c */
        void mo821c(String str);

        /* renamed from: c */
        void mo820c(String str, String str2);

        /* renamed from: r */
        void mo767r();
    }

    public C4343a(Context context, JSONArray jSONArray, long j, InterfaceC4345b interfaceC4345b, String str, boolean z, String str2) {
        this(context, jSONArray, j, interfaceC4345b, str, z, str2, (byte) 0);
    }

    private C4343a(Context context, JSONArray jSONArray, long j, InterfaceC4345b interfaceC4345b, String str, boolean z, String str2, byte b) {
        this(context, jSONArray, j, interfaceC4345b, str, z, str2, (char) 0);
    }

    private C4343a(Context context, JSONArray jSONArray, long j, InterfaceC4345b interfaceC4345b, String str, boolean z, String str2, char c) {
        this(context, jSONArray, j, interfaceC4345b, str, z, false, null, null, str2);
    }

    public C4343a(Context context, JSONArray jSONArray, long j, InterfaceC4345b interfaceC4345b, String str, boolean z, boolean z2, AbstractC4486z abstractC4486z, JSONArray jSONArray2, String str2) {
        super(context);
        this.f23018a = null;
        this.f23019b = null;
        this.f23020c = null;
        this.f23021d = 0L;
        this.f23022e = null;
        this.f23023f = false;
        this.f23024g = true;
        this.f23025h = null;
        this.f23026i = "";
        this.f23018a = context;
        this.f23021d = j;
        this.f23022e = interfaceC4345b;
        this.f23023f = z2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i = C4149a.f22117f;
        layoutParams.bottomMargin = i;
        layoutParams.topMargin = i;
        setLayoutParams(layoutParams);
        setPadding(0, 0, 0, 0);
        setOrientation(1);
        setBackgroundColor(0);
        m1027a(jSONArray, str, z, abstractC4486z, jSONArray2, str2);
    }

    public C4343a(Context context, JSONArray jSONArray, InterfaceC4345b interfaceC4345b, String str) {
        this(context, jSONArray, -1L, interfaceC4345b, null, true, str);
    }

    /* renamed from: a */
    private C4344a m1025a(boolean z) {
        String str;
        Object[] objArr;
        String str2;
        Object[] objArr2;
        C4344a c4344a = new C4344a("");
        ArrayList<AbstractC4486z> arrayList = this.f23020c;
        if (arrayList != null) {
            Iterator<AbstractC4486z> it = arrayList.iterator();
            while (it.hasNext()) {
                AbstractC4486z next = it.next();
                if (!(next instanceof C4426af)) {
                    if (!next.mo583c()) {
                        str2 = C4171c.f22227bD.f22257aC;
                        objArr2 = new Object[]{next.m670r()};
                    } else if (!next.mo584b()) {
                        str2 = C4171c.f22227bD.f22258aD;
                        objArr2 = new Object[]{next.m670r()};
                    }
                    c4344a.m1013a(-1, String.format(str2, objArr2));
                    break;
                }
                if (!next.mo583c()) {
                    str = C4171c.f22227bD.f22257aC;
                    objArr = new Object[]{C4171c.f22227bD.f22259aE};
                } else if (!next.mo584b()) {
                    str = C4171c.f22227bD.f22258aD;
                    objArr = new Object[]{C4171c.f22227bD.f22259aE};
                }
                c4344a.m1013a(-1, String.format(str, objArr));
            }
        }
        if (c4344a.m1014a()) {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.f23020c != null) {
                for (int i = 0; i < this.f23020c.size(); i++) {
                    AbstractC4486z abstractC4486z = this.f23020c.get(i);
                    if (!(abstractC4486z instanceof C4424ad) && ((!(abstractC4486z instanceof UPWidget) || z) && !TextUtils.isEmpty(this.f23020c.get(i).mo580h()) && this.f23020c.get(i).mo581f())) {
                        stringBuffer.append(",");
                        stringBuffer.append(this.f23020c.get(i).mo580h());
                    }
                }
            }
            String stringBuffer2 = stringBuffer.toString();
            if (stringBuffer2.length() > 1) {
                stringBuffer2 = stringBuffer2.substring(1);
            }
            c4344a.m1013a(0, stringBuffer2);
            return c4344a;
        }
        return c4344a;
    }

    /* renamed from: a */
    private static AbstractC4486z m1030a(List<AbstractC4486z> list, String str) {
        for (AbstractC4486z abstractC4486z : list) {
            if (abstractC4486z.m674n().equalsIgnoreCase(str)) {
                return abstractC4486z;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0047 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.unionpay.mobile.android.upviews.C4343a.C4344a m1035a() {
        /*
            r7 = this;
            com.unionpay.mobile.android.upviews.a$a r0 = new com.unionpay.mobile.android.upviews.a$a
            java.lang.String r1 = ""
            r0.<init>(r1)
            java.util.ArrayList<com.unionpay.mobile.android.widgets.z> r1 = r7.f23020c
            java.lang.String r2 = "pin"
            com.unionpay.mobile.android.widgets.z r1 = m1030a(r1, r2)
            if (r1 == 0) goto L4e
            boolean r2 = r1.mo583c()
            r3 = -1
            r4 = 0
            r5 = 1
            if (r2 != 0) goto L2e
            com.unionpay.mobile.android.languages.c r2 = com.unionpay.mobile.android.languages.C4171c.f22227bD
            java.lang.String r2 = r2.f22257aC
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = r1.m670r()
            r5[r4] = r6
        L26:
            java.lang.String r2 = java.lang.String.format(r2, r5)
            r0.m1013a(r3, r2)
            goto L41
        L2e:
            boolean r2 = r1.mo584b()
            if (r2 != 0) goto L41
            com.unionpay.mobile.android.languages.c r2 = com.unionpay.mobile.android.languages.C4171c.f22227bD
            java.lang.String r2 = r2.f22258aD
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = r1.m670r()
            r5[r4] = r6
            goto L26
        L41:
            boolean r2 = r0.m1014a()
            if (r2 != 0) goto L48
            return r0
        L48:
            java.lang.String r1 = r1.mo585a()
            r0.f23028b = r1
        L4e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.mobile.android.upviews.C4343a.m1035a():com.unionpay.mobile.android.upviews.a$a");
    }

    /* renamed from: a */
    public final String m1031a(String str) {
        AbstractC4486z m1030a = m1030a(this.f23020c, str);
        String mo580h = m1030a != null ? m1030a.mo580h() : "";
        C4390k.m838a("uppay", " name:" + str + ", value:" + mo580h);
        return mo580h;
    }

    /* renamed from: a */
    public final void m1034a(int i) {
        AbstractC4486z m1030a = m1030a(this.f23020c, "sms");
        if (m1030a != null) {
            ((C4439ap) m1030a).m690a(i);
        }
    }

    /* renamed from: a */
    public final void m1033a(View.OnClickListener onClickListener) {
        AbstractC4486z m1019c = m1019c("promotion");
        if (m1019c == null || !(m1019c instanceof C4432aj)) {
            return;
        }
        ((C4432aj) m1019c).m694b(onClickListener);
    }

    /* renamed from: a */
    public final void m1032a(C4471m c4471m, JSONObject jSONObject) {
        this.f23019b = c4471m;
        this.f23025h = jSONObject;
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4420aa.InterfaceC4421a
    /* renamed from: a */
    public final void mo719a(View$OnClickListenerC4479u view$OnClickListenerC4479u, String str) {
        if (this.f23022e != null) {
            boolean z = true;
            if (str != null && str.length() > 0) {
                ArrayList<AbstractC4486z> arrayList = this.f23020c;
                if (arrayList != null) {
                    Iterator<AbstractC4486z> it = arrayList.iterator();
                    while (it.hasNext()) {
                        AbstractC4486z next = it.next();
                        if (next instanceof AbstractC4420aa) {
                            AbstractC4420aa abstractC4420aa = (AbstractC4420aa) next;
                            if (!abstractC4420aa.m721a(view$OnClickListenerC4479u) && !abstractC4420aa.mo583c()) {
                                break;
                            }
                        }
                    }
                }
                z = false;
            }
            this.f23022e.mo822a(z);
        }
    }

    @Override // com.unionpay.mobile.android.widgets.C4439ap.InterfaceC4440a
    /* renamed from: a */
    public final void mo684a(AbstractC4486z abstractC4486z) {
        String str;
        Object[] objArr;
        String str2;
        Object[] objArr2;
        boolean z = abstractC4486z instanceof C4439ap;
        if (this.f23022e == null || !z) {
            return;
        }
        m1018d();
        C4344a c4344a = new C4344a("");
        AbstractC4486z m1030a = m1030a(this.f23020c, "mobile");
        AbstractC4486z m1030a2 = m1030a(this.f23020c, Constant.KEY_PAN);
        AbstractC4486z m1030a3 = m1030a(this.f23020c, "card");
        AbstractC4486z m1030a4 = m1030a(this.f23020c, "area_code");
        String str3 = "";
        if (m1030a2 != null) {
            if (!m1030a2.mo583c()) {
                str2 = C4171c.f22227bD.f22257aC;
                objArr2 = new Object[]{C4171c.f22227bD.f22259aE};
            } else if (m1030a2.mo584b()) {
                str3 = "" + m1030a2.mo580h();
            } else {
                str2 = C4171c.f22227bD.f22258aD;
                objArr2 = new Object[]{C4171c.f22227bD.f22259aE};
            }
            c4344a.m1013a(-1, String.format(str2, objArr2));
        }
        if (c4344a.m1014a()) {
            if (m1030a != null) {
                if (!m1030a.mo583c()) {
                    str = C4171c.f22227bD.f22257aC;
                    objArr = new Object[]{m1030a.m670r()};
                } else if (m1030a.mo584b()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str3);
                    sb.append(str3.length() == 0 ? "" : ",");
                    str3 = sb.toString() + m1030a.mo580h();
                } else {
                    str = C4171c.f22227bD.f22258aD;
                    objArr = new Object[]{m1030a.m670r()};
                }
                c4344a.m1013a(-1, String.format(str, objArr));
            }
            if (c4344a.m1014a()) {
                if (m1030a3 != null && m1030a3.mo580h().length() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str3);
                    sb2.append(str3.length() == 0 ? "" : ",");
                    str3 = sb2.toString() + m1030a3.mo580h();
                }
                if (m1030a4 != null && m1030a4.mo580h().length() > 0) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str3);
                    sb3.append(str3.length() == 0 ? "" : ",");
                    str3 = sb3.toString() + m1030a4.mo580h();
                }
                c4344a.m1013a(0, str3);
            }
        }
        this.f23022e.mo827a(c4344a);
    }

    @Override // com.unionpay.mobile.android.upwidget.C4371q.InterfaceC4372a
    /* renamed from: a */
    public final void mo913a(String str, String str2) {
        if (this.f23022e != null) {
            m1018d();
            this.f23022e.mo820c(str, str2);
        }
    }

    @Override // com.unionpay.mobile.android.upwidget.C4371q.InterfaceC4372a
    /* renamed from: a */
    public final void mo912a(String str, boolean z) {
        String str2 = "promotion".equalsIgnoreCase(str) ? "instalment" : "promotion";
        AbstractC4486z m1019c = m1019c(str);
        AbstractC4486z m1019c2 = m1019c(str2);
        if (m1019c == null) {
            return;
        }
        if (!(m1019c instanceof C4432aj)) {
            if (m1019c instanceof C4474p) {
                if (z) {
                    this.f23022e.mo767r();
                }
                ((C4474p) m1019c).m616b(z);
                return;
            }
            return;
        }
        ((C4432aj) m1019c).m695a(z);
        if (m1019c2 != null) {
            C4474p c4474p = (C4474p) m1019c2;
            if (c4474p.m612g()) {
                Toast.makeText(this.f23018a, this.f23026i, 1).show();
                c4474p.m616b(false);
            }
        }
    }

    /* renamed from: a */
    public final void m1029a(JSONArray jSONArray) {
        AbstractC4486z m1019c = m1019c("promotion");
        if (m1019c == null || !(m1019c instanceof C4432aj)) {
            return;
        }
        ((C4432aj) m1019c).m697a(jSONArray);
    }

    /* renamed from: a */
    public final void m1028a(JSONArray jSONArray, String str) {
        AbstractC4486z m1019c = m1019c("promotion");
        if (m1019c == null || !(m1019c instanceof C4432aj)) {
            return;
        }
        ((C4432aj) m1019c).m696a(jSONArray, str);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:11|12|13|14|(1:16)(2:74|(1:76)(9:77|(5:133|134|135|136|137)(9:79|(1:81)(2:83|(1:85)(2:86|(1:88)(2:90|(1:92)(2:93|(1:95)(2:96|(1:98)(2:99|(1:101)(2:102|(1:104)(2:105|(1:107)(2:108|(1:110)(2:111|(1:113)(2:114|(1:116)(2:117|(1:119)(2:120|(1:122)(8:123|(4:125|126|127|128)(1:132)|18|19|20|21|(2:69|70)(9:23|(1:25)(2:63|(1:65)(2:66|(1:68)))|26|(1:30)|31|(12:33|(1:35)(2:59|(5:61|37|(2:53|(2:55|(1:58)))(3:41|(1:43)|44)|45|(3:49|50|51)))|36|37|(0)|53|(0)|45|(1:47)|49|50|51)|62|50|51)|52))))))))))))))|82|18|19|20|21|(0)(0)|52)|89|18|19|20|21|(0)(0)|52))|17|18|19|20|21|(0)(0)|52|9) */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01b2  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m1027a(org.json.JSONArray r21, java.lang.String r22, boolean r23, com.unionpay.mobile.android.widgets.AbstractC4486z r24, org.json.JSONArray r25, java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 661
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.mobile.android.upviews.C4343a.m1027a(org.json.JSONArray, java.lang.String, boolean, com.unionpay.mobile.android.widgets.z, org.json.JSONArray, java.lang.String):void");
    }

    /* renamed from: a */
    public final void m1026a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String m846a = C4389j.m846a(jSONObject, "instalment_empty_info");
        if (TextUtils.isEmpty(m846a)) {
            ((C4474p) m1019c("instalment")).m619a(true);
            ((C4474p) m1019c("instalment")).m616b(true);
            ((C4474p) m1030a(this.f23020c, "instalment_policy")).m620a(C4389j.m842d(jSONObject, "new_instalments"));
            return;
        }
        ((C4474p) m1019c("instalment")).m619a(false);
        ((C4474p) m1019c("instalment")).m616b(false);
        Toast.makeText(this.f23018a, m846a, 1).show();
    }

    /* renamed from: b */
    public final C4344a m1024b() {
        return m1025a(true);
    }

    /* renamed from: b */
    public final String m1022b(String str) {
        AbstractC4486z m1030a = m1030a(this.f23020c, str);
        return m1030a != null ? m1030a.mo585a() : "";
    }

    /* renamed from: b */
    public final void m1023b(View.OnClickListener onClickListener) {
        AbstractC4486z m1019c = m1019c("promotion");
        if (m1019c == null || !(m1019c instanceof C4432aj)) {
            return;
        }
        ((C4432aj) m1019c).m693c(onClickListener);
    }

    /* renamed from: c */
    public final AbstractC4486z m1019c(String str) {
        ArrayList<AbstractC4486z> arrayList = this.f23020c;
        if (arrayList != null && arrayList.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<AbstractC4486z> it = this.f23020c.iterator();
            while (it.hasNext()) {
                AbstractC4486z next = it.next();
                if (next.m673o().equalsIgnoreCase(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    /* renamed from: c */
    public final HashMap<String, String> m1021c() {
        if (m1025a(false).m1014a()) {
            HashMap<String, String> hashMap = new HashMap<>();
            if (this.f23020c != null) {
                for (int i = 0; i < this.f23020c.size(); i++) {
                    AbstractC4486z abstractC4486z = this.f23020c.get(i);
                    if (!(abstractC4486z instanceof C4424ad) && !(abstractC4486z instanceof UPWidget) && !TextUtils.isEmpty(abstractC4486z.mo585a())) {
                        hashMap.put(abstractC4486z.m674n(), abstractC4486z.mo585a());
                    }
                }
            }
            return hashMap;
        }
        return null;
    }

    /* renamed from: c */
    public final void m1020c(View.OnClickListener onClickListener) {
        AbstractC4486z m1019c = m1019c("promotion");
        if (m1019c == null || !(m1019c instanceof C4432aj)) {
            return;
        }
        ((C4432aj) m1019c).m705a(onClickListener);
    }

    /* renamed from: d */
    public final void m1017d(String str) {
        this.f23026i = str;
    }

    /* renamed from: d */
    public final boolean m1018d() {
        boolean z;
        ArrayList<AbstractC4486z> arrayList = this.f23020c;
        if (arrayList != null) {
            Iterator<AbstractC4486z> it = arrayList.iterator();
            while (it.hasNext()) {
                AbstractC4486z next = it.next();
                if (next instanceof UPWidget) {
                    UPWidget uPWidget = (UPWidget) next;
                    if (uPWidget.m734j()) {
                        uPWidget.m733k();
                        z = true;
                        break;
                    }
                }
            }
        }
        z = false;
        ((InputMethodManager) this.f23018a.getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
        return z;
    }

    @Override // com.unionpay.mobile.android.widgets.C4429ah.InterfaceC4430a
    /* renamed from: e */
    public final void mo708e(String str) {
        InterfaceC4345b interfaceC4345b = this.f23022e;
        if (interfaceC4345b != null) {
            interfaceC4345b.mo821c(str);
        }
    }

    /* renamed from: e */
    public final boolean m1016e() {
        boolean z;
        ArrayList<AbstractC4486z> arrayList = this.f23020c;
        if (arrayList != null) {
            Iterator<AbstractC4486z> it = arrayList.iterator();
            while (it.hasNext()) {
                AbstractC4486z next = it.next();
                if ((next instanceof AbstractC4420aa) && !((AbstractC4420aa) next).mo583c()) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        return !z;
    }

    /* renamed from: f */
    public final void m1015f() {
        ArrayList<AbstractC4486z> arrayList = this.f23020c;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<AbstractC4486z> it = this.f23020c.iterator();
        while (it.hasNext()) {
            AbstractC4486z next = it.next();
            if ((next instanceof UPWidget) || (next instanceof C4463e) || (next instanceof C4446av)) {
                ((AbstractC4420aa) next).m720g();
            }
        }
    }

    @Override // com.unionpay.mobile.android.widgets.C4432aj.InterfaceC4433a
    /* renamed from: g */
    public final void mo691g() {
        AbstractC4486z m1019c = m1019c("instalment");
        if (m1019c != null) {
            C4474p c4474p = (C4474p) m1019c;
            if (c4474p.m612g()) {
                Toast.makeText(this.f23018a, this.f23026i, 1).show();
                c4474p.m616b(false);
            }
        }
    }
}
