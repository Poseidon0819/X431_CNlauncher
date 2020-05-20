package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.utils.C4387h;
import com.unionpay.mobile.android.utils.C4389j;
import java.util.ArrayList;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.widgets.k */
/* loaded from: classes2.dex */
public final class C4469k extends AbstractC4420aa {

    /* renamed from: c */
    private final String f23454c;

    /* renamed from: o */
    private ArrayList<View.OnClickListener> f23455o;

    /* renamed from: p */
    private ArrayList<View.OnClickListener> f23456p;

    /* renamed from: q */
    private TextView f23457q;

    /* renamed from: r */
    private boolean f23458r;

    /* renamed from: s */
    private String f23459s;

    /* renamed from: t */
    private String f23460t;

    /* renamed from: u */
    private View.OnClickListener f23461u;

    public C4469k(Context context, int i, JSONObject jSONObject, String str) {
        super(context, i, jSONObject, str);
        this.f23454c = "[A-Za-z0-9]{8,32}";
        this.f23455o = new ArrayList<>();
        this.f23456p = new ArrayList<>();
        this.f23457q = null;
        this.f23458r = true;
        this.f23459s = null;
        this.f23460t = null;
        this.f23461u = new View$OnClickListenerC4470l(this);
        this.f23459s = C4389j.m846a(jSONObject, "button_label");
        this.f23460t = C4389j.m846a(jSONObject, "button_action");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, C4150b.f22151n);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(15, -1);
        this.f23323b.setLayoutParams(layoutParams);
        this.f23457q = new TextView(getContext());
        this.f23457q.setGravity(17);
        this.f23457q.setText(this.f23459s);
        this.f23457q.setTextColor(C4387h.m854a(-10705958, -5846275, -5846275, -6710887));
        this.f23457q.setTextSize(C4150b.f22148k);
        this.f23457q.setOnClickListener(this.f23461u);
        m643a(false);
        this.f23323b.m606a(this.f23457q, new LinearLayout.LayoutParams(-2, -1));
    }

    /* renamed from: a */
    public final void m645a(View.OnClickListener onClickListener) {
        this.f23455o.add(onClickListener);
    }

    /* renamed from: a */
    public final void m643a(boolean z) {
        boolean z2;
        if (z) {
            this.f23457q.setText(C4171c.f22227bD.f22229B);
            z2 = false;
        } else {
            this.f23457q.setText(this.f23459s);
            z2 = true;
        }
        this.f23458r = z2;
    }

    /* renamed from: b */
    public final void m642b(View.OnClickListener onClickListener) {
        this.f23456p.add(onClickListener);
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: b */
    public final boolean mo584b() {
        return this.f23402i || 6 == mo585a().length();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba
    /* renamed from: d */
    public final String mo613d() {
        return "_input_coupon";
    }
}
