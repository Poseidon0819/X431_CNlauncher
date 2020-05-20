package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.resource.C4342c;

/* renamed from: com.unionpay.mobile.android.widgets.as */
/* loaded from: classes2.dex */
public final class C4443as extends LinearLayout {

    /* renamed from: a */
    private C4342c f23375a;

    /* renamed from: b */
    private ImageView f23376b;

    /* renamed from: c */
    private ImageView f23377c;

    public C4443as(Context context) {
        super(context);
        this.f23375a = null;
        this.f23376b = null;
        this.f23377c = null;
        this.f23375a = C4342c.m1036a(context);
        setBackgroundColor(0);
        setOrientation(1);
        this.f23377c = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, C4149a.f22099C);
        layoutParams.gravity = 80;
        addView(this.f23377c, layoutParams);
        Drawable m1037a = this.f23375a.m1037a(1001, -1, -1);
        ImageView imageView = this.f23376b;
        if (imageView != null) {
            imageView.setBackgroundDrawable(m1037a);
        }
    }
}
