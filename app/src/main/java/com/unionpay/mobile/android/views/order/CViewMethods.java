package com.unionpay.mobile.android.views.order;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.utils.C4386g;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class CViewMethods extends LinearLayout {

    /* renamed from: a */
    private static final Integer f23220a = -1;

    /* renamed from: b */
    private static final Integer f23221b = -2;

    /* renamed from: c */
    private static final int f23222c = C4150b.f22138a;

    /* renamed from: d */
    private Context f23223d;

    /* renamed from: e */
    private int f23224e;

    /* renamed from: f */
    private TextView f23225f;

    /* renamed from: g */
    private HashMap<Integer, String> f23226g;

    /* renamed from: h */
    private HashMap<Integer, Drawable> f23227h;

    /* renamed from: i */
    private String f23228i;

    /* renamed from: j */
    private InterfaceC4400a f23229j;

    /* renamed from: k */
    private Drawable f23230k;

    /* renamed from: com.unionpay.mobile.android.views.order.CViewMethods$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC4400a {
        /* renamed from: c */
        void mo807c(int i);
    }

    public CViewMethods(Context context) {
        this(context, null);
    }

    public CViewMethods(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CViewMethods(Context context, AttributeSet attributeSet, int i) {
        super(context);
        this.f23223d = context;
        this.f23224e = InterfaceC4414l.f23273a.intValue();
        setOrientation(1);
    }

    /* renamed from: a */
    private void m813a(LinearLayout linearLayout, int i) {
        String str;
        Drawable drawable;
        float f = C4150b.f22148k;
        RelativeLayout relativeLayout = new RelativeLayout(this.f23223d);
        relativeLayout.setClickable(true);
        Drawable drawable2 = this.f23230k;
        if (drawable2 != null) {
            relativeLayout.setBackgroundDrawable(drawable2.getConstantState().newDrawable());
        }
        relativeLayout.setOnClickListener(new View$OnClickListenerC4410h(this, i));
        linearLayout.addView(relativeLayout, new LinearLayout.LayoutParams(f23220a.intValue(), C4150b.f22151n));
        ImageView imageView = new ImageView(this.f23223d);
        imageView.setId(imageView.hashCode());
        HashMap<Integer, Drawable> hashMap = this.f23227h;
        if (hashMap != null && (drawable = hashMap.get(Integer.valueOf(i))) != null) {
            imageView.setBackgroundDrawable(drawable);
        }
        int m858a = C4386g.m858a(this.f23223d, 15.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(m858a, m858a);
        layoutParams.addRule(15, -1);
        layoutParams.addRule(11, -1);
        layoutParams.rightMargin = f23222c;
        relativeLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.f23223d);
        textView.setClickable(false);
        textView.setTextSize(f);
        textView.setTextColor(-13421773);
        HashMap<Integer, String> hashMap2 = this.f23226g;
        if (hashMap2 != null && (str = hashMap2.get(Integer.valueOf(i))) != null) {
            textView.setText(Html.fromHtml(str));
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(f23220a.intValue(), f23221b.intValue());
        layoutParams2.addRule(15, -1);
        layoutParams2.addRule(9, -1);
        layoutParams2.addRule(0, imageView.getId());
        layoutParams2.leftMargin = f23222c;
        relativeLayout.addView(textView, layoutParams2);
    }

    /* renamed from: a */
    public final CViewMethods m815a(int i) {
        if (i > 0) {
            this.f23224e = i;
        }
        return this;
    }

    /* renamed from: a */
    public final CViewMethods m814a(Drawable drawable) {
        this.f23230k = drawable;
        return this;
    }

    /* renamed from: a */
    public final CViewMethods m812a(InterfaceC4400a interfaceC4400a) {
        this.f23229j = interfaceC4400a;
        return this;
    }

    /* renamed from: a */
    public final CViewMethods m810a(String str) {
        this.f23228i = str;
        return this;
    }

    /* renamed from: a */
    public final CViewMethods m809a(HashMap<Integer, String> hashMap) {
        this.f23226g = hashMap;
        return this;
    }

    /* renamed from: a */
    public final void m816a() {
        TextView textView;
        removeAllViews();
        if (this.f23224e == InterfaceC4414l.f23273a.intValue()) {
            setVisibility(8);
            return;
        }
        this.f23225f = new TextView(this.f23223d);
        this.f23225f.setTextColor(-13421773);
        this.f23225f.setTextSize(C4150b.f22148k);
        String str = this.f23228i;
        if (str != null && (textView = this.f23225f) != null) {
            textView.setText(str);
        }
        this.f23225f.setGravity(19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f23220a.intValue(), f23221b.intValue());
        layoutParams.gravity = 19;
        layoutParams.topMargin = f23222c;
        layoutParams.leftMargin = C4386g.m858a(this.f23223d, 10.0f);
        addView(this.f23225f, layoutParams);
        LinearLayout linearLayout = new LinearLayout(this.f23223d);
        linearLayout.setBackgroundColor(-3419943);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        layoutParams2.topMargin = f23222c;
        addView(linearLayout, layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout linearLayout2 = new LinearLayout(this.f23223d);
        linearLayout2.setOrientation(1);
        linearLayout2.setBackgroundColor(-1);
        addView(linearLayout2, layoutParams3);
        if (InterfaceC4414l.f23274b.intValue() == (InterfaceC4414l.f23274b.intValue() & this.f23224e)) {
            m813a(linearLayout2, InterfaceC4414l.f23274b.intValue());
        }
        if (InterfaceC4414l.f23275c.intValue() == (InterfaceC4414l.f23275c.intValue() & this.f23224e)) {
            m813a(linearLayout2, InterfaceC4414l.f23275c.intValue());
        }
        if (InterfaceC4414l.f23277e.intValue() == (InterfaceC4414l.f23277e.intValue() & this.f23224e)) {
            LinearLayout linearLayout3 = new LinearLayout(this.f23223d);
            linearLayout3.setBackgroundColor(-3419943);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 1);
            layoutParams4.leftMargin = C4386g.m858a(this.f23223d, 10.0f);
            linearLayout2.addView(linearLayout3, layoutParams4);
            m813a(linearLayout2, InterfaceC4414l.f23277e.intValue());
        }
        if (InterfaceC4414l.f23276d.intValue() == (InterfaceC4414l.f23276d.intValue() & this.f23224e)) {
            LinearLayout linearLayout4 = new LinearLayout(this.f23223d);
            linearLayout4.setBackgroundColor(-3419943);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, 1);
            layoutParams5.leftMargin = C4386g.m858a(this.f23223d, 10.0f);
            linearLayout2.addView(linearLayout4, layoutParams5);
            m813a(linearLayout2, InterfaceC4414l.f23276d.intValue());
        }
        if (InterfaceC4414l.f23278f.intValue() == (InterfaceC4414l.f23278f.intValue() & this.f23224e)) {
            LinearLayout linearLayout5 = new LinearLayout(this.f23223d);
            linearLayout5.setBackgroundColor(-3419943);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, 1);
            layoutParams6.leftMargin = C4386g.m858a(this.f23223d, 10.0f);
            linearLayout2.addView(linearLayout5, layoutParams6);
            m813a(linearLayout2, InterfaceC4414l.f23278f.intValue());
        }
        LinearLayout linearLayout6 = new LinearLayout(this.f23223d);
        linearLayout6.setBackgroundColor(-3419943);
        addView(linearLayout6, new LinearLayout.LayoutParams(-1, 1));
    }

    /* renamed from: b */
    public final CViewMethods m808b(HashMap<Integer, Drawable> hashMap) {
        this.f23227h = hashMap;
        return this;
    }
}
