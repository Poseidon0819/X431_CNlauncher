package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.resource.C4342c;
import com.unionpay.mobile.android.utils.C4386g;

/* renamed from: com.unionpay.mobile.android.widgets.ay */
/* loaded from: classes2.dex */
public final class C4449ay extends RelativeLayout {

    /* renamed from: a */
    private Context f23381a;

    /* renamed from: b */
    private TextView f23382b;

    /* renamed from: c */
    private ImageView f23383c;

    /* renamed from: d */
    private TextView f23384d;

    /* renamed from: e */
    private Drawable f23385e;

    /* renamed from: f */
    private ImageView f23386f;

    /* renamed from: g */
    private LinearLayout f23387g;

    /* renamed from: h */
    private int f23388h;

    /* renamed from: i */
    private int f23389i;

    /* renamed from: j */
    private int f23390j;

    /* renamed from: k */
    private InterfaceC4450a f23391k;

    /* renamed from: com.unionpay.mobile.android.widgets.ay$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC4450a {
        /* renamed from: l */
        void mo678l();
    }

    public C4449ay(Context context, String str, Drawable drawable, int i, InterfaceC4450a interfaceC4450a) {
        super(context);
        this.f23381a = null;
        this.f23382b = null;
        this.f23383c = null;
        this.f23384d = null;
        this.f23385e = null;
        this.f23388h = 0;
        this.f23389i = 0;
        this.f23390j = 0;
        this.f23381a = context;
        this.f23391k = interfaceC4450a;
        this.f23390j = C4386g.m858a(this.f23381a, 10.0f);
        this.f23385e = drawable;
        this.f23388h = i;
        m679b(str);
    }

    public C4449ay(Context context, String str, InterfaceC4450a interfaceC4450a) {
        this(context, str, interfaceC4450a, (byte) 0);
    }

    private C4449ay(Context context, String str, InterfaceC4450a interfaceC4450a, byte b) {
        super(context);
        this.f23381a = null;
        this.f23382b = null;
        this.f23383c = null;
        this.f23384d = null;
        this.f23385e = null;
        this.f23388h = 0;
        this.f23389i = 0;
        this.f23390j = 0;
        this.f23381a = context;
        this.f23391k = interfaceC4450a;
        this.f23390j = C4386g.m858a(this.f23381a, 10.0f);
        m679b(str);
    }

    /* renamed from: b */
    private void m679b(String str) {
        this.f23389i = C4149a.f22122k;
        setLayoutParams(new RelativeLayout.LayoutParams(-1, this.f23389i));
        setBackgroundColor(C4149a.f22109M);
        C4342c m1036a = C4342c.m1036a(this.f23381a);
        this.f23387g = new LinearLayout(this.f23381a);
        this.f23387g.setOnClickListener(new View$OnClickListenerC4451az(this));
        LinearLayout linearLayout = this.f23387g;
        int i = this.f23390j;
        linearLayout.setPadding(i, i, i, i);
        this.f23387g.setGravity(16);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(15, -1);
        addView(this.f23387g, layoutParams);
        int m858a = C4386g.m858a(this.f23381a, 20.0f);
        int m858a2 = C4386g.m858a(this.f23381a, 11.0f);
        int i2 = this.f23388h;
        if (i2 != 0) {
            m858a2 = i2;
        }
        ImageView imageView = new ImageView(this.f23381a);
        Drawable drawable = this.f23385e;
        if (drawable == null) {
            drawable = m1036a.m1037a(1029, -1, -1);
        }
        imageView.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(m858a2, m858a);
        layoutParams2.addRule(15, -1);
        this.f23387g.addView(imageView, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(C4149a.f22123l, this.f23389i);
        layoutParams3.addRule(13, -1);
        this.f23384d = new TextView(this.f23381a);
        this.f23384d.setTextSize(20.0f);
        this.f23384d.setTextColor(-1);
        this.f23384d.setText(str);
        this.f23384d.setGravity(17);
        this.f23384d.setSingleLine(true);
        this.f23384d.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.f23384d, layoutParams3);
        if (!TextUtils.isEmpty(null)) {
            int i3 = C4149a.f22116e;
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, this.f23389i);
            layoutParams4.addRule(11, -1);
            layoutParams4.addRule(15, -1);
            layoutParams4.rightMargin = i3;
            this.f23382b = new TextView(this.f23381a);
            this.f23382b.setTextSize(16.0f);
            this.f23382b.setTextColor(-1);
            this.f23382b.setText((CharSequence) null);
            this.f23382b.setGravity(16);
            TextView textView = this.f23382b;
            textView.setId(textView.hashCode());
            addView(this.f23382b, layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(C4149a.f22104H, C4149a.f22124m);
            layoutParams5.addRule(0, this.f23382b.getId());
            layoutParams5.addRule(15, -1);
            layoutParams5.rightMargin = i3;
            addView(new C4473o(this.f23381a, C4149a.f22110N, 1), layoutParams5);
        }
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(C4149a.f22101E, C4149a.f22100D);
        layoutParams6.addRule(11, -1);
        layoutParams6.addRule(15, -1);
        layoutParams6.rightMargin = this.f23390j;
        Drawable m1037a = m1036a.m1037a(1031, -1, -1);
        this.f23386f = new ImageView(this.f23381a);
        this.f23386f.setBackgroundDrawable(m1037a);
        addView(this.f23386f, layoutParams6);
        int i4 = C4149a.f22100D;
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(i4, i4);
        layoutParams7.addRule(11, -1);
        layoutParams7.addRule(15, -1);
        layoutParams7.rightMargin = this.f23390j;
        this.f23383c = new ImageView(this.f23381a);
        addView(this.f23383c, layoutParams7);
    }

    /* renamed from: a */
    public final void m683a() {
        LinearLayout linearLayout = this.f23387g;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    /* renamed from: a */
    public final void m682a(int i) {
        ImageView imageView;
        ImageView imageView2 = this.f23383c;
        if (imageView2 != null) {
            int i2 = 8;
            if (i == 0) {
                this.f23386f.setVisibility(8);
                imageView = this.f23383c;
            } else {
                imageView2.setVisibility(8);
                imageView = this.f23386f;
                i2 = 0;
            }
            imageView.setVisibility(i2);
            this.f23383c.setVisibility(i);
        }
    }

    /* renamed from: a */
    public final void m680a(String str) {
        TextView textView = this.f23384d;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
