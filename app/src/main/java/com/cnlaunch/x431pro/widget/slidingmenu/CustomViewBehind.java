package com.cnlaunch.x431pro.widget.slidingmenu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.cnlaunch.x431pro.widget.slidingmenu.SlidingMenu;
import com.itextpdf.text.pdf.ColumnText;

/* renamed from: com.cnlaunch.x431pro.widget.slidingmenu.d */
/* loaded from: classes.dex */
public final class CustomViewBehind extends ViewGroup {

    /* renamed from: a */
    View f16781a;

    /* renamed from: b */
    View f16782b;

    /* renamed from: c */
    int f16783c;

    /* renamed from: d */
    int f16784d;

    /* renamed from: e */
    boolean f16785e;

    /* renamed from: f */
    final Paint f16786f;

    /* renamed from: g */
    float f16787g;

    /* renamed from: h */
    Drawable f16788h;

    /* renamed from: i */
    Drawable f16789i;

    /* renamed from: j */
    int f16790j;

    /* renamed from: k */
    float f16791k;

    /* renamed from: l */
    private CustomViewAbove f16792l;

    /* renamed from: m */
    private int f16793m;

    /* renamed from: n */
    private SlidingMenu.InterfaceC2949a f16794n;

    /* renamed from: o */
    private boolean f16795o;

    /* renamed from: p */
    private int f16796p;

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public CustomViewBehind(Context context) {
        this(context, (byte) 0);
    }

    private CustomViewBehind(Context context, byte b) {
        super(context, null);
        this.f16786f = new Paint();
        this.f16783c = (int) TypedValue.applyDimension(1, 20.0f, getResources().getDisplayMetrics());
    }

    public final void setCustomViewAbove(CustomViewAbove customViewAbove) {
        this.f16792l = customViewAbove;
    }

    public final void setCanvasTransformer(SlidingMenu.InterfaceC2949a interfaceC2949a) {
        this.f16794n = interfaceC2949a;
    }

    public final void setWidthOffset(int i) {
        this.f16793m = i;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.f16796p = displayMetrics.widthPixels - i;
        requestLayout();
    }

    public final int getBehindWidth() {
        return this.f16796p;
    }

    public final void setContent(View view) {
        View view2 = this.f16781a;
        if (view2 != null) {
            removeView(view2);
        }
        this.f16781a = view;
        addView(this.f16781a);
    }

    public final View getContent() {
        return this.f16781a;
    }

    public final void setSecondaryContent(View view) {
        View view2 = this.f16782b;
        if (view2 != null) {
            removeView(view2);
        }
        this.f16782b = view;
        addView(this.f16782b);
    }

    public final View getSecondaryContent() {
        return this.f16782b;
    }

    public final void setChildrenEnabled(boolean z) {
        this.f16795o = z;
    }

    @Override // android.view.View
    public final void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
        if (this.f16794n != null) {
            invalidate();
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f16795o;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void dispatchDraw(Canvas canvas) {
        if (this.f16794n != null) {
            canvas.save();
            this.f16792l.getPercentOpen();
            super.dispatchDraw(canvas);
            canvas.restore();
            return;
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.f16781a.layout(0, 0, i5 - this.f16793m, i6);
        View view = this.f16782b;
        if (view != null) {
            view.layout(0, 0, i5 - this.f16793m, i6);
        }
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(0, i);
        int defaultSize2 = getDefaultSize(0, i2);
        setMeasuredDimension(defaultSize, defaultSize2);
        int childMeasureSpec = getChildMeasureSpec(i, 0, defaultSize - this.f16793m);
        int childMeasureSpec2 = getChildMeasureSpec(i2, 0, defaultSize2);
        this.f16781a.measure(childMeasureSpec, childMeasureSpec2);
        View view = this.f16782b;
        if (view != null) {
            view.measure(childMeasureSpec, childMeasureSpec2);
        }
    }

    public final void setMode(int i) {
        if (i == 0 || i == 1) {
            View view = this.f16781a;
            if (view != null) {
                view.setVisibility(0);
            }
            View view2 = this.f16782b;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
        this.f16784d = i;
    }

    public final int getMode() {
        return this.f16784d;
    }

    public final void setScrollScale(float f) {
        this.f16787g = f;
    }

    public final float getScrollScale() {
        return this.f16787g;
    }

    public final void setShadowDrawable(Drawable drawable) {
        this.f16788h = drawable;
        invalidate();
    }

    public final void setSecondaryShadowDrawable(Drawable drawable) {
        this.f16789i = drawable;
        invalidate();
    }

    public final void setShadowWidth(int i) {
        this.f16790j = i;
        invalidate();
    }

    public final void setFadeEnabled(boolean z) {
        this.f16785e = z;
    }

    public final void setFadeDegree(float f) {
        if (f > 1.0f || f < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            throw new IllegalStateException("The BehindFadeDegree must be between 0.0f and 1.0f");
        }
        this.f16791k = f;
    }

    /* renamed from: a */
    public final int m4396a(int i) {
        if (i > 1) {
            i = 2;
        } else if (i <= 0) {
            i = 0;
        }
        if (this.f16784d != 0 || i <= 1) {
            if (this.f16784d != 1 || i > 0) {
                return i;
            }
            return 2;
        }
        return 0;
    }

    /* renamed from: a */
    public final int m4395a(View view, int i) {
        int i2 = this.f16784d;
        if (i2 == 0) {
            return view.getLeft() - getBehindWidth();
        }
        if (i2 == 1) {
            return view.getLeft() + getBehindWidth();
        }
        if (i2 == 2) {
            if (i != 0) {
                if (i != 2) {
                    return 0;
                }
                return view.getLeft() + getBehindWidth();
            }
            return view.getLeft() - getBehindWidth();
        }
        return 0;
    }
}
