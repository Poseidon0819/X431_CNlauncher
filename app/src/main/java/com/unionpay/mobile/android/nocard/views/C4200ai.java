package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.utils.C4387h;
import com.unionpay.mobile.android.utils.C4389j;
import com.unionpay.mobile.android.widgets.C4449ay;
import com.unionpay.tsmservice.data.Constant;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.nocard.views.ai */
/* loaded from: classes2.dex */
public final class C4200ai extends AbstractC4219b {

    /* renamed from: r */
    private TextView f22537r;

    /* renamed from: s */
    private View.OnClickListener f22538s;

    public C4200ai(Context context) {
        super(context);
        this.f22537r = null;
        this.f22538s = new View$OnClickListenerC4201aj(this);
        this.f22595f = 11;
        this.f22600k = m1429a();
        mo1076b();
        super.mo1373d();
        mo1072c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m1471r() {
        this.f22590a.f22383I.f22848f = Constant.CASH_LOAD_SUCCESS;
        m1406j();
    }

    @Override // com.unionpay.mobile.android.nocard.views.InterfaceC4191a
    /* renamed from: a */
    public final void mo1077a(JSONObject jSONObject) {
        m1407i();
        this.f22590a.f22394T = C4389j.m842d(jSONObject, "open_rules");
        if (this.f22590a.f22394T == null || this.f22590a.f22394T.length() <= 0) {
            mo1137b(2);
        } else {
            m1411d(10);
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: b */
    protected final void mo1076b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        C4449ay c4449ay = new C4449ay(getContext(), this.f22590a.f22375A, this);
        layoutParams.addRule(13, -1);
        this.f22600k.addView(c4449ay, layoutParams);
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: c */
    protected final void mo1072c() {
        int i = C4149a.f22115d;
        LinearLayout linearLayout = new LinearLayout(this.f22593d);
        linearLayout.setBackgroundColor(-1114114);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(0, i, 0, i);
        linearLayout.setId(linearLayout.hashCode());
        TextView textView = new TextView(this.f22593d);
        textView.setText(this.f22590a.f22376B);
        textView.setTextSize(24.0f);
        textView.setTextColor(-15365480);
        textView.setGravity(1);
        textView.getPaint().setFakeBoldText(true);
        linearLayout.addView(textView);
        LinearLayout linearLayout2 = new LinearLayout(this.f22593d);
        linearLayout2.setOrientation(0);
        linearLayout2.setBackgroundColor(-6958338);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, 2);
        layoutParams.addRule(14, -1);
        int i2 = C4149a.f22115d;
        layoutParams.bottomMargin = i2;
        layoutParams.topMargin = i2;
        linearLayout.addView(linearLayout2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(10, -1);
        this.f22602m.addView(linearLayout, layoutParams2);
        LinearLayout linearLayout3 = new LinearLayout(this.f22593d);
        linearLayout3.setPadding(i, i, i, i);
        linearLayout3.setOrientation(1);
        linearLayout3.setId(linearLayout3.hashCode());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(3, linearLayout.getId());
        this.f22602m.addView(linearLayout3, layoutParams3);
        TextView textView2 = new TextView(this.f22593d);
        textView2.setTextSize(18.0f);
        textView2.setText(this.f22590a.f22393S);
        textView2.setTextColor(-10066330);
        textView2.setGravity(3);
        linearLayout3.addView(textView2, new RelativeLayout.LayoutParams(-1, -2));
        this.f22537r = new TextView(this.f22593d);
        this.f22537r.setText(C4171c.f22227bD.f22232E);
        this.f22537r.setTextSize(22.0f);
        this.f22537r.setTextColor(C4387h.m854a(-1, -730710, -730710, -6745));
        this.f22537r.setGravity(17);
        this.f22537r.setOnClickListener(this.f22538s);
        int i3 = C4149a.f22125n;
        this.f22537r.setBackgroundDrawable(this.f22592c.m1037a(UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE, -1, -1));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, i3);
        layoutParams4.addRule(3, linearLayout3.getId());
        layoutParams4.addRule(12, -1);
        layoutParams4.bottomMargin = C4149a.f22113b;
        layoutParams4.topMargin = C4149a.f22113b;
        int i4 = C4149a.f22115d;
        layoutParams4.rightMargin = i4;
        layoutParams4.leftMargin = i4;
        this.f22602m.addView(this.f22537r, layoutParams4);
    }

    @Override // com.unionpay.mobile.android.nocard.views.AbstractC4219b
    /* renamed from: k */
    public final void mo1056k() {
        m1471r();
    }
}
