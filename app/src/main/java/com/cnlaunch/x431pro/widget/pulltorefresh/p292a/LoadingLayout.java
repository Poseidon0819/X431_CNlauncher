package com.cnlaunch.x431pro.widget.pulltorefresh.p292a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cnlaunch.x431pro.widget.progress.ProgressBarCircularIndeterminate;
import com.cnlaunch.x431pro.widget.pulltorefresh.ILoadingLayout;
import com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase;
import com.ifoer.expedition.pro.R;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.cnlaunch.x431pro.widget.pulltorefresh.a.f */
/* loaded from: classes.dex */
public abstract class LoadingLayout extends FrameLayout implements ILoadingLayout {

    /* renamed from: a */
    static final Interpolator f16662a = new LinearInterpolator();

    /* renamed from: b */
    protected final ImageView f16663b;

    /* renamed from: c */
    protected final ProgressBarCircularIndeterminate f16664c;

    /* renamed from: d */
    protected final PullToRefreshBase.EnumC2933b f16665d;

    /* renamed from: e */
    protected final PullToRefreshBase.EnumC2939h f16666e;

    /* renamed from: f */
    private FrameLayout f16667f;

    /* renamed from: g */
    private boolean f16668g;

    /* renamed from: h */
    private final TextView f16669h;

    /* renamed from: i */
    private final TextView f16670i;

    /* renamed from: j */
    private CharSequence f16671j;

    /* renamed from: k */
    private CharSequence f16672k;

    /* renamed from: l */
    private CharSequence f16673l;

    /* renamed from: a */
    protected abstract void mo4459a();

    /* renamed from: a */
    protected abstract void mo4458a(float f);

    /* renamed from: a */
    protected abstract void mo4457a(Drawable drawable);

    /* renamed from: b */
    protected abstract void mo4456b();

    /* renamed from: c */
    protected abstract void mo4455c();

    /* renamed from: d */
    protected abstract void mo4454d();

    protected abstract int getDefaultDrawableResId();

    public LoadingLayout(Context context, PullToRefreshBase.EnumC2933b enumC2933b, PullToRefreshBase.EnumC2939h enumC2939h, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.f16665d = enumC2933b;
        this.f16666e = enumC2939h;
        if (C2928g.f16674a[enumC2939h.ordinal()] == 1) {
            LayoutInflater.from(context).inflate(R.layout.pulltorefresh_header, this);
        } else {
            LayoutInflater.from(context).inflate(R.layout.pulltorefresh_header, this);
        }
        this.f16667f = (FrameLayout) findViewById(R.id.fl_inner);
        this.f16669h = (TextView) this.f16667f.findViewById(R.id.pull_to_refresh_text);
        this.f16664c = (ProgressBarCircularIndeterminate) this.f16667f.findViewById(R.id.pull_to_refresh_progress);
        this.f16670i = (TextView) this.f16667f.findViewById(R.id.pull_to_refresh_sub_text);
        this.f16663b = (ImageView) this.f16667f.findViewById(R.id.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f16667f.getLayoutParams();
        if (C2928g.f16675b[enumC2933b.ordinal()] == 1) {
            layoutParams.gravity = enumC2939h == PullToRefreshBase.EnumC2939h.VERTICAL ? 48 : 3;
            this.f16671j = context.getString(R.string.pull_to_refresh_from_bottom_pull_label);
            this.f16672k = context.getString(R.string.pull_to_refresh_from_bottom_refreshing_label);
            this.f16673l = context.getString(R.string.pull_to_refresh_from_bottom_release_label);
        } else {
            layoutParams.gravity = enumC2939h == PullToRefreshBase.EnumC2939h.VERTICAL ? 80 : 5;
            this.f16671j = context.getString(R.string.pull_to_refresh_pull_label);
            this.f16672k = context.getString(R.string.pull_to_refresh_refreshing_label);
            this.f16673l = context.getString(R.string.pull_to_refresh_release_label);
        }
        if (typedArray.hasValue(7) && (drawable = typedArray.getDrawable(7)) != null) {
            if (Build.VERSION.SDK_INT < 16) {
                setBackgroundDrawable(drawable);
            } else {
                setBackground(drawable);
            }
        }
        if (typedArray.hasValue(9)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(9, typedValue);
            setTextAppearance(typedValue.data);
        }
        if (typedArray.hasValue(18)) {
            TypedValue typedValue2 = new TypedValue();
            typedArray.getValue(18, typedValue2);
            setSubTextAppearance(typedValue2.data);
        }
        if (typedArray.hasValue(10) && (colorStateList2 = typedArray.getColorStateList(10)) != null) {
            setTextColor(colorStateList2);
        }
        if (typedArray.hasValue(8) && (colorStateList = typedArray.getColorStateList(8)) != null) {
            setSubTextColor(colorStateList);
        }
        Drawable drawable2 = typedArray.hasValue(2) ? typedArray.getDrawable(2) : null;
        if (C2928g.f16675b[enumC2933b.ordinal()] != 1) {
            if (typedArray.hasValue(5)) {
                drawable2 = typedArray.getDrawable(5);
            } else if (typedArray.hasValue(6)) {
                C2929i.m4453a("ptrDrawableTop", "ptrDrawableStart");
                drawable2 = typedArray.getDrawable(6);
            }
        } else if (typedArray.hasValue(4)) {
            drawable2 = typedArray.getDrawable(4);
        } else if (typedArray.hasValue(3)) {
            C2929i.m4453a("ptrDrawableBottom", "ptrDrawableEnd");
            drawable2 = typedArray.getDrawable(3);
        }
        if (drawable2 == null) {
            this.f16664c.setVisibility(0);
        }
        setLoadingDrawable(drawable2);
        m4461i();
    }

    public final void setHeight(int i) {
        getLayoutParams().height = i;
        requestLayout();
    }

    public final void setWidth(int i) {
        getLayoutParams().width = i;
        requestLayout();
    }

    public final int getContentSize() {
        if (C2928g.f16674a[this.f16666e.ordinal()] == 1) {
            return this.f16667f.getWidth();
        }
        return this.f16667f.getHeight();
    }

    /* renamed from: e */
    public final void m4465e() {
        if (this.f16669h.getVisibility() == 0) {
            this.f16669h.setVisibility(4);
        }
        if (this.f16664c.getVisibility() == 0) {
            this.f16664c.setVisibility(4);
        }
        if (this.f16663b.getVisibility() == 0) {
            this.f16663b.setVisibility(4);
        }
        if (this.f16670i.getVisibility() == 0) {
            this.f16670i.setVisibility(4);
        }
    }

    /* renamed from: b */
    public final void m4466b(float f) {
        if (this.f16668g) {
            return;
        }
        mo4458a(f);
    }

    /* renamed from: f */
    public final void m4464f() {
        TextView textView = this.f16669h;
        if (textView != null) {
            textView.setText(this.f16671j);
        }
        mo4459a();
    }

    /* renamed from: g */
    public final void m4463g() {
        TextView textView = this.f16669h;
        if (textView != null) {
            textView.setText(this.f16672k);
        }
        if (this.f16668g) {
            ((AnimationDrawable) this.f16663b.getDrawable()).start();
        } else {
            mo4456b();
        }
        TextView textView2 = this.f16670i;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
    }

    /* renamed from: h */
    public final void m4462h() {
        TextView textView = this.f16669h;
        if (textView != null) {
            textView.setText(this.f16673l);
        }
        mo4455c();
    }

    /* renamed from: i */
    public final void m4461i() {
        TextView textView = this.f16669h;
        if (textView != null) {
            textView.setText(this.f16671j);
        }
        this.f16663b.setVisibility(0);
        if (this.f16668g) {
            ((AnimationDrawable) this.f16663b.getDrawable()).stop();
        } else {
            mo4454d();
        }
        TextView textView2 = this.f16670i;
        if (textView2 != null) {
            if (TextUtils.isEmpty(textView2.getText())) {
                this.f16670i.setVisibility(8);
            } else {
                this.f16670i.setVisibility(0);
            }
        }
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.ILoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.ILoadingLayout
    public final void setLoadingDrawable(Drawable drawable) {
        this.f16663b.setImageDrawable(drawable);
        this.f16668g = drawable instanceof AnimationDrawable;
        mo4457a(drawable);
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.ILoadingLayout
    public void setPullLabel(CharSequence charSequence) {
        this.f16671j = charSequence;
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.ILoadingLayout
    public void setRefreshingLabel(CharSequence charSequence) {
        this.f16672k = charSequence;
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.ILoadingLayout
    public void setReleaseLabel(CharSequence charSequence) {
        this.f16673l = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.f16669h.setTypeface(typeface);
    }

    /* renamed from: j */
    public final void m4460j() {
        if (4 == this.f16669h.getVisibility()) {
            this.f16669h.setVisibility(0);
        }
        if (4 == this.f16664c.getVisibility()) {
            this.f16664c.setVisibility(0);
        }
        if (4 == this.f16663b.getVisibility()) {
            this.f16663b.setVisibility(0);
        }
        if (4 == this.f16670i.getVisibility()) {
            this.f16670i.setVisibility(0);
        }
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.f16670i != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.f16670i.setVisibility(8);
                return;
            }
            this.f16670i.setText(charSequence);
            if (8 == this.f16670i.getVisibility()) {
                this.f16670i.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        TextView textView = this.f16670i;
        if (textView != null) {
            textView.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        TextView textView = this.f16670i;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        TextView textView = this.f16669h;
        if (textView != null) {
            textView.setTextAppearance(getContext(), i);
        }
        TextView textView2 = this.f16670i;
        if (textView2 != null) {
            textView2.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        TextView textView = this.f16669h;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
        TextView textView2 = this.f16670i;
        if (textView2 != null) {
            textView2.setTextColor(colorStateList);
        }
    }
}
