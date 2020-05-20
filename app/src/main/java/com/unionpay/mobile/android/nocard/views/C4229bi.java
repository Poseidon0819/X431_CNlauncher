package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.upviews.C4346b;
import com.unionpay.mobile.android.utils.C4386g;
import com.unionpay.mobile.android.widgets.C4449ay;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.nocard.views.bi */
/* loaded from: classes2.dex */
public final class C4229bi extends AbstractC4219b implements C4346b.InterfaceC4347a, C4346b.InterfaceC4348b {

    /* renamed from: w */
    private static String f22627w = "download://";

    /* renamed from: r */
    private C4346b f22628r;

    /* renamed from: s */
    private ViewGroup f22629s;

    /* renamed from: t */
    private int f22630t;

    /* renamed from: u */
    private boolean f22631u;

    /* renamed from: v */
    private boolean f22632v;

    public C4229bi(Context context) {
        this(context, false, false);
    }

    public C4229bi(Context context, boolean z, boolean z2) {
        super(context);
        this.f22628r = null;
        this.f22629s = null;
        this.f22630t = 0;
        this.f22631u = false;
        this.f22632v = false;
        this.f22595f = 14;
        this.f22630t = ((C4149a.f22131t - C4149a.f22122k) - C4149a.m1609b(this.f22593d)) - (C4149a.f22130s * 3);
        this.f22631u = z;
        this.f22632v = z2;
        this.f22600k = m1429a();
        mo1076b();
        mo1373d();
    }

    @Override // com.unionpay.mobile.android.nocard.views.InterfaceC4191a
    /* renamed from: a */
    public final void mo1077a(JSONObject jSONObject) {
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: b */
    protected final void mo1076b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        C4449ay c4449ay = new C4449ay(this.f22593d, this.f22590a.f22431af, this);
        if (this.f22631u) {
            c4449ay = new C4449ay(this.f22593d, this.f22590a.f22431af, this.f22592c.m1037a(1030, -1, -1), C4386g.m858a(this.f22593d, 20.0f), this);
        }
        layoutParams.addRule(13, -1);
        this.f22600k.addView(c4449ay, layoutParams);
    }

    @Override // com.unionpay.mobile.android.upviews.C4346b.InterfaceC4348b
    /* renamed from: c */
    public final void mo1001c(String str) {
        if (str == null || str.length() <= 0 || !str.startsWith(f22627w)) {
            return;
        }
        String substring = str.substring(f22627w.length());
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(substring));
        this.f22593d.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: d */
    public final void mo1373d() {
        super.mo1373d();
        this.f22628r = new C4346b(this.f22593d, this);
        this.f22628r.setOnTouchListener(new View$OnTouchListenerC4230bj(this));
        if (this.f22632v) {
            this.f22628r.m1009a(f22627w);
        }
        int i = this.f22630t;
        RelativeLayout.LayoutParams layoutParams = i == 0 ? new RelativeLayout.LayoutParams(-1, -1) : new RelativeLayout.LayoutParams(-1, i);
        layoutParams.addRule(3, this.f22600k.getId());
        layoutParams.addRule(12, -1);
        this.f22602m.addView(this.f22628r, layoutParams);
        this.f22629s = new RelativeLayout(this.f22593d);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, C4149a.f22131t - C4149a.f22122k);
        layoutParams2.addRule(3, this.f22600k.getId());
        layoutParams2.addRule(12, -1);
        layoutParams2.addRule(10, -1);
        layoutParams2.bottomMargin = 0;
        layoutParams2.topMargin = 0;
        this.f22602m.addView(this.f22629s, layoutParams2);
        ProgressBar progressBar = new ProgressBar(this.f22593d);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13, -1);
        this.f22629s.addView(progressBar, layoutParams3);
        this.f22628r.m1007b(this.f22590a.f22432ag);
        if (this.f22631u) {
            mo1138a(this.f22590a.f22459bi, false);
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: k */
    public final void mo1056k() {
        ((InputMethodManager) this.f22593d.getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
        if (!this.f22631u) {
            super.mo1056k();
            return;
        }
        this.f22591b.m636a(new View$OnClickListenerC4231bk(this), new View$OnClickListenerC4232bl(this));
        this.f22591b.m633a(C4171c.f22227bD.f22252Y, C4171c.f22227bD.f22302av, C4171c.f22227bD.f22250W, C4171c.f22227bD.f22251X);
    }

    @Override // com.unionpay.mobile.android.upviews.C4346b.InterfaceC4347a
    /* renamed from: r */
    public final void mo1003r() {
        this.f22628r.setVisibility(8);
        this.f22629s.setVisibility(0);
    }

    @Override // com.unionpay.mobile.android.upviews.C4346b.InterfaceC4347a
    /* renamed from: s */
    public final void mo1002s() {
        this.f22628r.setVisibility(0);
        this.f22629s.setVisibility(8);
    }
}
