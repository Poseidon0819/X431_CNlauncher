package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.utils.C4387h;

/* renamed from: com.unionpay.mobile.android.upwidget.x */
/* loaded from: classes2.dex */
public final class C4379x extends LinearLayout {

    /* renamed from: a */
    private Context f23171a;

    /* renamed from: b */
    private TextView f23172b;

    private C4379x(Context context, Drawable drawable) {
        super(context);
        this.f23171a = null;
        this.f23172b = null;
        this.f23171a = context;
        setOrientation(0);
        Context context2 = this.f23171a;
        if (drawable != null) {
            ImageView imageView = new ImageView(context2);
            imageView.setBackgroundDrawable(drawable);
            int i = C4150b.f22152o;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
            layoutParams.gravity = 16;
            addView(imageView, layoutParams);
        }
        this.f23172b = new TextView(context2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        if (drawable != null) {
            layoutParams2.leftMargin = C4149a.f22115d;
        }
        addView(this.f23172b, layoutParams2);
    }

    /* renamed from: a */
    public static C4379x m908a(Context context, Drawable drawable) {
        C4379x c4379x = new C4379x(context, drawable);
        TextView textView = c4379x.f23172b;
        if (textView != null) {
            textView.setTextSize(16.0f);
        }
        c4379x.m907a(C4387h.m856a(-16758391, -65536));
        return c4379x;
    }

    /* renamed from: a */
    public final void m907a(ColorStateList colorStateList) {
        TextView textView = this.f23172b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* renamed from: a */
    public final void m906a(CharSequence charSequence) {
        TextView textView = this.f23172b;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.f23172b;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }
}
