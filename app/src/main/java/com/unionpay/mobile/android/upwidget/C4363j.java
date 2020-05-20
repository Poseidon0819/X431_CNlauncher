package com.unionpay.mobile.android.upwidget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.cnlaunch.p112a.p115c.DefaultRenderer;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.resource.C4342c;
import com.unionpay.mobile.android.utils.C4386g;
import com.unionpay.mobile.android.utils.C4387h;
import com.unionpay.mobile.android.utils.C4389j;
import com.unionpay.mobile.android.widgets.C4424ad;
import com.unionpay.mobile.android.widgets.C4469k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.upwidget.j */
/* loaded from: classes2.dex */
public final class C4363j extends LinearLayout {

    /* renamed from: A */
    private View.OnClickListener f23102A;

    /* renamed from: B */
    private View.OnClickListener f23103B;

    /* renamed from: C */
    private View.OnClickListener f23104C;

    /* renamed from: D */
    private View.OnClickListener f23105D;

    /* renamed from: a */
    private Context f23106a;

    /* renamed from: b */
    private JSONArray f23107b;

    /* renamed from: c */
    private int f23108c;

    /* renamed from: d */
    private int f23109d;

    /* renamed from: e */
    private boolean f23110e;

    /* renamed from: f */
    private C4364a[] f23111f;

    /* renamed from: g */
    private ArrayList<Object> f23112g;

    /* renamed from: h */
    private LinearLayout f23113h;

    /* renamed from: i */
    private HorizontalScrollView f23114i;

    /* renamed from: j */
    private C4469k f23115j;

    /* renamed from: k */
    private C4424ad f23116k;

    /* renamed from: l */
    private TextView f23117l;

    /* renamed from: m */
    private TextView f23118m;

    /* renamed from: n */
    private int f23119n;

    /* renamed from: o */
    private int f23120o;

    /* renamed from: p */
    private int f23121p;

    /* renamed from: q */
    private int f23122q;

    /* renamed from: r */
    private int f23123r;

    /* renamed from: s */
    private String f23124s;

    /* renamed from: t */
    private ArrayList<AdapterView.OnItemClickListener> f23125t;

    /* renamed from: u */
    private ArrayList<View.OnClickListener> f23126u;

    /* renamed from: v */
    private ArrayList<View.OnClickListener> f23127v;

    /* renamed from: w */
    private ArrayList<View.OnClickListener> f23128w;

    /* renamed from: x */
    private ArrayList<View.OnClickListener> f23129x;

    /* renamed from: y */
    private AdapterView.OnItemClickListener f23130y;

    /* renamed from: z */
    private View.OnClickListener f23131z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.unionpay.mobile.android.upwidget.j$a */
    /* loaded from: classes2.dex */
    public class C4364a {

        /* renamed from: a */
        TextView f23132a;

        /* renamed from: b */
        LinearLayout f23133b;

        /* renamed from: c */
        View f23134c;

        /* renamed from: d */
        String f23135d;

        private C4364a() {
        }

        /* synthetic */ C4364a(C4363j c4363j, byte b) {
            this();
        }
    }

    public C4363j(Context context, JSONArray jSONArray, int i, String str) {
        super(context);
        this.f23110e = true;
        this.f23115j = null;
        this.f23116k = null;
        this.f23117l = null;
        this.f23118m = null;
        this.f23119n = 0;
        this.f23120o = 0;
        this.f23121p = -1;
        this.f23125t = new ArrayList<>();
        this.f23126u = new ArrayList<>();
        this.f23127v = new ArrayList<>();
        this.f23128w = new ArrayList<>();
        this.f23129x = new ArrayList<>();
        this.f23130y = new C4365k(this);
        this.f23131z = new View$OnClickListenerC4366l(this);
        this.f23102A = new View$OnClickListenerC4367m(this);
        this.f23103B = new View$OnClickListenerC4368n(this);
        this.f23104C = new View$OnClickListenerC4369o(this);
        this.f23105D = new View$OnClickListenerC4370p(this);
        this.f23106a = context;
        this.f23107b = jSONArray;
        this.f23120o = i;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.f23106a).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f23122q = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        ((Activity) this.f23106a).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics2);
        this.f23123r = displayMetrics2.heightPixels;
        this.f23124s = str;
        if (this.f23107b != null) {
            FrameLayout frameLayout = new FrameLayout(this.f23106a);
            RelativeLayout relativeLayout = new RelativeLayout(this.f23106a);
            frameLayout.addView(relativeLayout, new FrameLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (this.f23123r / 3) * 2);
            layoutParams.addRule(12, -1);
            LinearLayout linearLayout = new LinearLayout(this.f23106a);
            linearLayout.setOrientation(1);
            linearLayout.setBackgroundColor(-1);
            linearLayout.setId(linearLayout.hashCode());
            relativeLayout.addView(linearLayout, layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            LinearLayout linearLayout2 = new LinearLayout(this.f23106a);
            layoutParams2.addRule(10, -1);
            layoutParams2.addRule(2, linearLayout.getId());
            relativeLayout.addView(linearLayout2, layoutParams2);
            linearLayout2.setOnClickListener(this.f23131z);
            this.f23113h = new LinearLayout(this.f23106a);
            this.f23113h.setBackgroundColor(-1);
            this.f23113h.setOrientation(0);
            linearLayout.addView(this.f23113h, new LinearLayout.LayoutParams(-1, C4149a.f22125n));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, C4386g.m858a(this.f23106a, 1.0f));
            LinearLayout linearLayout3 = new LinearLayout(this.f23106a);
            linearLayout3.setBackgroundColor(DefaultRenderer.TEXT_COLOR);
            linearLayout.addView(linearLayout3, layoutParams3);
            this.f23114i = new HorizontalScrollView(this.f23106a);
            this.f23114i.setBackgroundColor(-1052684);
            linearLayout.addView(this.f23114i, new LinearLayout.LayoutParams(-2, -1));
            int m858a = C4386g.m858a(this.f23106a, 40.0f);
            ImageView imageView = new ImageView(this.f23106a);
            imageView.setBackgroundDrawable(C4342c.m1036a(this.f23106a).m1037a(1034, -1, -1));
            imageView.setOnClickListener(this.f23131z);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(m858a, m858a);
            layoutParams4.gravity = 85;
            layoutParams4.rightMargin = C4386g.m858a(this.f23106a, 10.0f);
            layoutParams4.bottomMargin = ((this.f23123r / 3) * 2) - (m858a / 2);
            frameLayout.addView(imageView, layoutParams4);
            addView(frameLayout);
            m957a();
        }
    }

    /* renamed from: a */
    private View m953a(LinearLayout linearLayout, JSONObject jSONObject) {
        C4356c c4356c = new C4356c(this.f23106a, m941b(C4389j.m842d(jSONObject, "options")), "", "", "", this.f23121p, 1);
        this.f23112g.add(c4356c);
        ListView listView = new ListView(this.f23106a);
        listView.setDivider(null);
        listView.setAdapter((ListAdapter) c4356c);
        listView.setOnItemClickListener(this.f23130y);
        listView.setCacheColorHint(-1);
        linearLayout.addView(listView, new LinearLayout.LayoutParams(this.f23122q, -1));
        return listView;
    }

    /* renamed from: a */
    private static String m947a(JSONArray jSONArray, int i, String str) {
        Object m845b = C4389j.m845b(jSONArray, i);
        return m845b != null ? C4389j.m846a((JSONObject) m845b, str) : "";
    }

    /* renamed from: a */
    private void m957a() {
        View m953a;
        int length = this.f23107b.length();
        this.f23111f = new C4364a[length];
        for (int i = 0; i < length; i++) {
            this.f23111f[i] = new C4364a(this, (byte) 0);
            if (this.f23111f[i].f23132a == null) {
                this.f23111f[i].f23132a = new TextView(this.f23106a);
            }
            if (this.f23111f[i].f23133b == null) {
                this.f23111f[i].f23133b = new LinearLayout(this.f23106a);
            }
            if (this.f23111f[i].f23134c == null) {
                this.f23111f[i].f23134c = new ListView(this.f23106a);
            }
            if (this.f23111f[i].f23135d == null) {
                this.f23111f[i].f23135d = "";
            }
        }
        this.f23112g = new ArrayList<>(this.f23107b.length());
        LinearLayout linearLayout = new LinearLayout(this.f23106a);
        linearLayout.setOrientation(0);
        this.f23114i.addView(linearLayout, new LinearLayout.LayoutParams(-2, -1));
        for (int i2 = 0; i2 < this.f23107b.length(); i2++) {
            JSONObject jSONObject = (JSONObject) C4389j.m845b(this.f23107b, i2);
            String m846a = C4389j.m846a(jSONObject, "action");
            String m846a2 = C4389j.m846a(jSONObject, "label");
            RelativeLayout relativeLayout = new RelativeLayout(this.f23106a);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = C4386g.m858a(this.f23106a, 10.0f);
            this.f23113h.addView(relativeLayout, layoutParams);
            int m858a = C4386g.m858a(this.f23106a, 10.0f);
            TextView textView = new TextView(this.f23106a);
            textView.setText(m846a2);
            textView.setTextSize(C4150b.f22148k);
            textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            textView.setSingleLine(true);
            textView.setTextColor(-10066330);
            textView.setPadding(m858a, 0, m858a, 0);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(15, -1);
            relativeLayout.addView(textView, layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(((int) textView.getPaint().measureText(m846a2)) + m858a + m858a, C4386g.m858a(this.f23106a, 2.0f));
            layoutParams3.addRule(12, -1);
            LinearLayout linearLayout2 = new LinearLayout(this.f23106a);
            linearLayout2.setBackgroundColor(-16730965);
            if (this.f23120o != i2) {
                linearLayout2.setVisibility(8);
            }
            relativeLayout.addView(linearLayout2, layoutParams3);
            relativeLayout.setTag(Integer.valueOf(i2));
            relativeLayout.setOnClickListener(this.f23105D);
            C4364a[] c4364aArr = this.f23111f;
            c4364aArr[i2].f23132a = textView;
            c4364aArr[i2].f23133b = linearLayout2;
            c4364aArr[i2].f23135d = m846a;
            if (this.f23120o == i2) {
                this.f23121p = 0;
            } else {
                this.f23121p = -1;
            }
            String m846a3 = C4389j.m846a(jSONObject, VastExtensionXmlManager.TYPE);
            if ("coupon".equals(m846a3)) {
                this.f23109d = i2;
                m953a = m944b(linearLayout, jSONObject);
            } else {
                if ("point".equals(m846a3)) {
                    this.f23108c = i2;
                } else if (!"upoint".equals(m846a3)) {
                    m953a = m953a(linearLayout, jSONObject);
                }
                m953a = m939c(linearLayout, jSONObject);
            }
            C4364a[] c4364aArr2 = this.f23111f;
            c4364aArr2[i2].f23134c = m953a;
            c4364aArr2[i2].f23134c.setVisibility(8);
        }
        m956a(this.f23120o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m956a(int i) {
        this.f23111f[this.f23120o].f23133b.setVisibility(8);
        this.f23111f[this.f23120o].f23132a.setTextColor(-16777216);
        this.f23111f[this.f23120o].f23134c.setVisibility(8);
        this.f23111f[i].f23133b.setVisibility(0);
        this.f23111f[i].f23132a.setTextColor(-16730965);
        this.f23111f[i].f23134c.setVisibility(0);
        this.f23120o = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m952a(LinearLayout linearLayout, boolean z, String str, JSONObject jSONObject, C4356c c4356c) {
        linearLayout.removeAllViews();
        ListView listView = new ListView(this.f23106a);
        listView.setDivider(null);
        listView.setAdapter((ListAdapter) c4356c);
        listView.setOnItemClickListener(this.f23130y);
        this.f23112g.add(c4356c);
        linearLayout.addView(listView, new LinearLayout.LayoutParams(this.f23122q, -2));
        if (c4356c != null) {
            ((LinearLayout.LayoutParams) linearLayout.getLayoutParams()).gravity = 48;
        }
        if (z) {
            int i = C4149a.f22127p;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
            layoutParams.bottomMargin = C4386g.m858a(this.f23106a, 12.0f);
            layoutParams.gravity = 17;
            linearLayout.addView(new ProgressBar(this.f23106a), layoutParams);
        }
        TextView textView = new TextView(this.f23106a);
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
            textView.setTextSize(C4150b.f22148k);
            textView.setTextColor(-13421773);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            linearLayout.addView(textView, layoutParams2);
        }
        if (jSONObject != null) {
            TextView textView2 = new TextView(this.f23106a);
            textView2.setText(C4389j.m846a(jSONObject, "label"));
            textView2.setTextSize(C4150b.f22146i);
            int i2 = C4150b.f22139b;
            int i3 = C4150b.f22140c;
            textView2.setTextColor(C4387h.m854a(i2, i3, i3, C4150b.f22141d));
            textView2.setGravity(17);
            textView2.setEnabled(true);
            int i4 = C4149a.f22125n;
            textView2.setBackgroundDrawable(C4342c.m1036a(this.f23106a).m1037a(UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE, -1, -1));
            float measureText = textView.getPaint().measureText(str);
            textView2.setOnClickListener(this.f23102A);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((int) measureText, i4);
            int i5 = C4149a.f22117f;
            layoutParams3.bottomMargin = i5;
            layoutParams3.topMargin = i5;
            int m858a = C4386g.m858a(this.f23106a, 10.0f);
            layoutParams3.rightMargin = m858a;
            layoutParams3.leftMargin = m858a;
            linearLayout.addView(textView2, layoutParams3);
        }
    }

    /* renamed from: b */
    private View m944b(LinearLayout linearLayout, JSONObject jSONObject) {
        JSONObject jSONObject2;
        RelativeLayout relativeLayout = new RelativeLayout(this.f23106a);
        ListView listView = new ListView(this.f23106a);
        JSONObject jSONObject3 = null;
        listView.setDivider(null);
        listView.setAdapter((ListAdapter) null);
        this.f23112g.add(listView);
        JSONArray m842d = C4389j.m842d(jSONObject, "rules");
        if (m842d == null || m842d.length() <= 0) {
            jSONObject2 = null;
        } else {
            JSONObject jSONObject4 = null;
            jSONObject2 = null;
            for (int i = 0; i < m842d.length(); i++) {
                Object m845b = C4389j.m845b(m842d, i);
                if (m845b != null) {
                    JSONObject jSONObject5 = (JSONObject) m845b;
                    String m846a = C4389j.m846a(jSONObject5, VastExtensionXmlManager.TYPE);
                    if ("coupon_code".equals(m846a)) {
                        jSONObject4 = jSONObject5;
                    } else if ("string".equals(m846a)) {
                        jSONObject2 = jSONObject5;
                    }
                }
            }
            jSONObject3 = jSONObject4;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f23122q, -2);
        layoutParams.addRule(10, -1);
        relativeLayout.addView(listView, layoutParams);
        int i2 = C4149a.f22105I - (C4149a.f22117f * 4);
        this.f23115j = new C4469k(this.f23106a, i2, jSONObject3, this.f23124s);
        C4469k c4469k = this.f23115j;
        c4469k.setId(c4469k.hashCode());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.f23122q, -2);
        layoutParams2.addRule(10, -1);
        int m858a = C4386g.m858a(this.f23106a, 10.0f);
        layoutParams2.topMargin = m858a;
        layoutParams2.rightMargin = m858a;
        layoutParams2.leftMargin = m858a;
        relativeLayout.addView(this.f23115j, layoutParams2);
        this.f23116k = new C4424ad(this.f23106a, i2, jSONObject2, this.f23124s);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.f23122q, -2);
        layoutParams3.addRule(3, this.f23115j.getId());
        int m858a2 = C4386g.m858a(this.f23106a, 10.0f);
        layoutParams3.topMargin = m858a2;
        layoutParams3.rightMargin = m858a2;
        layoutParams3.leftMargin = m858a2;
        relativeLayout.addView(this.f23116k, layoutParams3);
        this.f23117l = new TextView(this.f23106a);
        this.f23117l.setTextSize(C4150b.f22148k);
        this.f23117l.setTextColor(-10066330);
        this.f23117l.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(this.f23122q, -2);
        layoutParams4.addRule(3, this.f23115j.getId());
        int m858a3 = C4386g.m858a(this.f23106a, 10.0f);
        layoutParams4.topMargin = m858a3;
        layoutParams4.rightMargin = m858a3;
        layoutParams4.leftMargin = m858a3;
        relativeLayout.addView(this.f23117l, layoutParams4);
        JSONObject m843c = C4389j.m843c(jSONObject, "use_button");
        LinearLayout linearLayout2 = new LinearLayout(this.f23106a);
        linearLayout2.setOrientation(1);
        linearLayout2.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, C4386g.m858a(this.f23106a, 1.0f));
        LinearLayout linearLayout3 = new LinearLayout(this.f23106a);
        linearLayout3.setBackgroundColor(DefaultRenderer.TEXT_COLOR);
        linearLayout2.addView(linearLayout3, layoutParams5);
        this.f23118m = new TextView(this.f23106a);
        this.f23118m.setText(C4389j.m846a(m843c, "label"));
        this.f23118m.setTextSize(C4150b.f22146i);
        TextView textView = this.f23118m;
        int i3 = C4150b.f22139b;
        int i4 = C4150b.f22140c;
        textView.setTextColor(C4387h.m854a(i3, i4, i4, C4150b.f22141d));
        this.f23118m.setGravity(17);
        this.f23118m.setEnabled(false);
        int i5 = C4149a.f22125n;
        this.f23118m.setBackgroundDrawable(C4342c.m1036a(this.f23106a).m1037a(UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE, -1, -1));
        this.f23118m.setTag(Integer.valueOf(this.f23109d));
        this.f23118m.setOnClickListener(this.f23104C);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, i5);
        int i6 = C4149a.f22117f;
        layoutParams6.bottomMargin = i6;
        layoutParams6.topMargin = i6;
        int m858a4 = C4386g.m858a(this.f23106a, 10.0f);
        layoutParams6.rightMargin = m858a4;
        layoutParams6.leftMargin = m858a4;
        linearLayout2.addView(this.f23118m, layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(this.f23122q, -2);
        layoutParams7.addRule(12, -1);
        relativeLayout.addView(linearLayout2, layoutParams7);
        linearLayout.addView(relativeLayout, new LinearLayout.LayoutParams(this.f23122q, -2));
        return relativeLayout;
    }

    /* renamed from: b */
    private static List<Map<String, Object>> m941b(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            HashMap hashMap = new HashMap();
            hashMap.put("text1", m947a(jSONArray, i, "label"));
            hashMap.put("text2", "");
            hashMap.put("editable", Boolean.FALSE);
            String m947a = m947a(jSONArray, i, "available");
            hashMap.put("available", Boolean.valueOf(TextUtils.isEmpty(m947a) || !"1".equals(m947a)));
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    /* renamed from: c */
    private View m939c(LinearLayout linearLayout, JSONObject jSONObject) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout linearLayout2 = new LinearLayout(this.f23106a);
        linearLayout2.setOrientation(1);
        String m846a = C4389j.m846a(jSONObject, "tip");
        String m846a2 = C4389j.m846a(jSONObject, "empty_info");
        JSONObject m843c = C4389j.m843c(jSONObject, "button");
        if (m843c != null) {
            m952a(linearLayout2, false, m846a, m843c, null);
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        } else if (!"upoint".equals(C4389j.m846a(jSONObject, VastExtensionXmlManager.TYPE))) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        } else if (m846a2 == null || TextUtils.isEmpty(m846a2)) {
            return m953a(linearLayout, jSONObject);
        } else {
            m952a(linearLayout2, false, m846a2, null, null);
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.gravity = 17;
        linearLayout2.setGravity(17);
        linearLayout.addView(linearLayout2, layoutParams);
        return linearLayout2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public static /* synthetic */ boolean m923o(C4363j c4363j) {
        c4363j.f23110e = false;
        return false;
    }

    /* renamed from: a */
    public final void m955a(View.OnClickListener onClickListener) {
        this.f23126u.add(onClickListener);
    }

    /* renamed from: a */
    public final void m954a(AdapterView.OnItemClickListener onItemClickListener) {
        this.f23125t.add(onItemClickListener);
    }

    /* renamed from: a */
    public final void m948a(JSONArray jSONArray) {
        Object m845b = C4389j.m845b(jSONArray, 0);
        if (m845b != null) {
            this.f23117l.setText(C4389j.m846a((JSONObject) m845b, "label"));
            this.f23117l.setVisibility(0);
            this.f23116k.setVisibility(8);
        }
        this.f23118m.setEnabled(true);
    }

    /* renamed from: a */
    public final void m946a(JSONArray jSONArray, String str) {
        C4356c c4356c;
        if (jSONArray == null || jSONArray.length() <= 0) {
            c4356c = null;
        } else {
            c4356c = new C4356c(this.f23106a, m941b(jSONArray), "", "", "", -1, 1);
            this.f23112g.add(this.f23108c, c4356c);
        }
        m952a((LinearLayout) this.f23111f[this.f23108c].f23134c, false, str, null, c4356c);
    }

    /* renamed from: b */
    public final void m945b(View.OnClickListener onClickListener) {
        this.f23127v.add(onClickListener);
    }

    /* renamed from: c */
    public final void m940c(View.OnClickListener onClickListener) {
        this.f23128w.add(onClickListener);
    }

    /* renamed from: d */
    public final void m936d(View.OnClickListener onClickListener) {
        this.f23129x.add(onClickListener);
    }

    /* renamed from: e */
    public final void m934e(View.OnClickListener onClickListener) {
        C4469k c4469k = this.f23115j;
        if (c4469k != null) {
            c4469k.m645a(onClickListener);
            this.f23115j.m642b(this.f23103B);
        }
    }
}
