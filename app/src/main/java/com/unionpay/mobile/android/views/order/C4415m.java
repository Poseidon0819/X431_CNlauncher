package com.unionpay.mobile.android.views.order;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.nocard.views.C4228bh;
import com.unionpay.mobile.android.utils.C4386g;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.mobile.android.widgets.C4424ad;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.views.order.m */
/* loaded from: classes2.dex */
public final class C4415m extends RelativeLayout {

    /* renamed from: a */
    private Context f23279a;

    /* renamed from: b */
    private ImageView f23280b;

    /* renamed from: c */
    private LinearLayout f23281c;

    /* renamed from: d */
    private LinearLayout f23282d;

    /* renamed from: e */
    private Drawable f23283e;

    /* renamed from: f */
    private Drawable f23284f;

    public C4415m(Context context) {
        super(context);
        this.f23279a = context;
        int m858a = C4386g.m858a(context, 10.0f);
        setPadding(m858a, m858a, m858a, m858a);
        setBackgroundColor(-1);
        setOnClickListener(new View$OnClickListenerC4416n(this));
        int m858a2 = C4386g.m858a(context, 15.0f);
        this.f23280b = new ImageView(context);
        ImageView imageView = this.f23280b;
        imageView.setId(imageView.hashCode());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(m858a2, m858a2);
        layoutParams.addRule(11, -1);
        layoutParams.addRule(12, -1);
        addView(this.f23280b, layoutParams);
        this.f23281c = new LinearLayout(context);
        this.f23281c.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.rightMargin = m858a;
        layoutParams2.addRule(9, -1);
        layoutParams2.addRule(15, -1);
        layoutParams2.addRule(0, this.f23280b.getId());
        addView(this.f23281c, layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m765a(C4415m c4415m) {
        int i = c4415m.f23282d.getVisibility() == 8 ? 0 : 8;
        c4415m.f23282d.setVisibility(i);
        c4415m.f23280b.setBackgroundDrawable(i == 0 ? c4415m.f23283e : c4415m.f23284f);
    }

    /* renamed from: a */
    public final void m766a(Drawable drawable, Drawable drawable2) {
        this.f23283e = drawable;
        this.f23284f = drawable2;
    }

    /* renamed from: a */
    public final void m764a(boolean z, JSONArray jSONArray, JSONObject jSONObject) {
        this.f23281c.removeAllViews();
        Drawable drawable = this.f23284f;
        if (drawable != null) {
            this.f23280b.setBackgroundDrawable(drawable);
        }
        int i = (jSONArray == null || jSONArray.length() == 0) ? 0 : 1;
        if (!z && jSONArray != null) {
            i = 2;
            if (jSONArray.length() <= 2) {
                i = jSONArray.length();
            }
        }
        if (jSONArray == null || i == 0) {
            C4390k.m836c("uppay", "init order detail = null!!!");
            return;
        }
        this.f23281c.addView(C4228bh.m1393a(this.f23279a, jSONArray, 0, i), new LinearLayout.LayoutParams(-1, -2));
        this.f23282d = C4228bh.m1393a(this.f23279a, jSONArray, i, jSONArray.length());
        if (jSONObject != null) {
            C4424ad c4424ad = new C4424ad(this.f23279a, jSONObject, "");
            c4424ad.m717g();
            c4424ad.m718a(C4150b.f22150m);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = C4386g.m858a(this.f23279a, 8.0f);
            this.f23282d.addView(c4424ad, layoutParams);
        }
        this.f23282d.setVisibility(8);
        this.f23281c.addView(this.f23282d, new LinearLayout.LayoutParams(-1, -2));
    }
}
