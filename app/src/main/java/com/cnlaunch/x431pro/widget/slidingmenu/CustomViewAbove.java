package com.cnlaunch.x431pro.widget.slidingmenu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.support.p012v4.view.MotionEventCompat;
import android.support.p012v4.view.VelocityTrackerCompat;
import android.support.p012v4.view.ViewConfigurationCompat;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Scroller;
import com.cnlaunch.x431pro.widget.slidingmenu.SlidingMenu;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.ColumnText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.widget.slidingmenu.a */
/* loaded from: classes.dex */
public final class CustomViewAbove extends ViewGroup {

    /* renamed from: e */
    private static final Interpolator f16743e = new animationInterpolatorC2956b();

    /* renamed from: A */
    private boolean f16744A;

    /* renamed from: B */
    private Bitmap f16745B;

    /* renamed from: C */
    private View f16746C;

    /* renamed from: a */
    protected int f16747a;

    /* renamed from: b */
    protected VelocityTracker f16748b;

    /* renamed from: c */
    protected int f16749c;

    /* renamed from: d */
    protected int f16750d;

    /* renamed from: f */
    private View f16751f;

    /* renamed from: g */
    private int f16752g;

    /* renamed from: h */
    private Scroller f16753h;

    /* renamed from: i */
    private boolean f16754i;

    /* renamed from: j */
    private boolean f16755j;

    /* renamed from: k */
    private boolean f16756k;

    /* renamed from: l */
    private boolean f16757l;

    /* renamed from: m */
    private int f16758m;

    /* renamed from: n */
    private float f16759n;

    /* renamed from: o */
    private float f16760o;

    /* renamed from: p */
    private float f16761p;

    /* renamed from: q */
    private int f16762q;

    /* renamed from: r */
    private int f16763r;

    /* renamed from: s */
    private CustomViewBehind f16764s;

    /* renamed from: t */
    private boolean f16765t;

    /* renamed from: u */
    private InterfaceC2954a f16766u;

    /* renamed from: v */
    private InterfaceC2954a f16767v;

    /* renamed from: w */
    private SlidingMenu.InterfaceC2951c f16768w;

    /* renamed from: x */
    private SlidingMenu.InterfaceC2953e f16769x;

    /* renamed from: y */
    private List<View> f16770y;

    /* renamed from: z */
    private float f16771z;

    /* compiled from: CustomViewAbove.java */
    /* renamed from: com.cnlaunch.x431pro.widget.slidingmenu.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC2954a {
        /* renamed from: a */
        void mo4394a(int i);
    }

    /* compiled from: CustomViewAbove.java */
    /* renamed from: com.cnlaunch.x431pro.widget.slidingmenu.a$b */
    /* loaded from: classes.dex */
    public static class C2955b implements InterfaceC2954a {
        @Override // com.cnlaunch.x431pro.widget.slidingmenu.CustomViewAbove.InterfaceC2954a
        /* renamed from: a */
        public void mo4394a(int i) {
        }
    }

    public CustomViewAbove(Context context) {
        this(context, (byte) 0);
    }

    private CustomViewAbove(Context context, byte b) {
        this(context, (char) 0);
    }

    private CustomViewAbove(Context context, char c) {
        super(context, null);
        this.f16747a = -1;
        this.f16765t = true;
        this.f16770y = new ArrayList();
        this.f16750d = 0;
        this.f16771z = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f16744A = true;
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context2 = getContext();
        this.f16753h = new Scroller(context2, f16743e);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        this.f16758m = ViewConfigurationCompat.m14530a(viewConfiguration);
        this.f16762q = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f16749c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f16767v = new C2957c(this);
        this.f16763r = (int) (context2.getResources().getDisplayMetrics().density * 25.0f);
    }

    public final int getCurrentItem() {
        return this.f16752g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m4409a(int i, boolean z, int i2) {
        InterfaceC2954a interfaceC2954a;
        InterfaceC2954a interfaceC2954a2;
        if (!z && this.f16752g == i) {
            setScrollingCacheEnabled(false);
            return;
        }
        int m4396a = this.f16764s.m4396a(i);
        boolean z2 = this.f16752g != m4396a;
        this.f16752g = m4396a;
        int m4411a = m4411a(this.f16752g);
        if (z2 && (interfaceC2954a2 = this.f16766u) != null) {
            interfaceC2954a2.mo4394a(m4396a);
        }
        if (z2 && (interfaceC2954a = this.f16767v) != null) {
            interfaceC2954a.mo4394a(m4396a);
        }
        m4410a(m4411a, i2);
    }

    public final void setOnPageChangeListener(InterfaceC2954a interfaceC2954a) {
        this.f16766u = interfaceC2954a;
    }

    public final void setOnOpenedListener(SlidingMenu.InterfaceC2953e interfaceC2953e) {
        this.f16769x = interfaceC2953e;
    }

    public final void setOnClosedListener(SlidingMenu.InterfaceC2951c interfaceC2951c) {
        this.f16768w = interfaceC2951c;
    }

    /* renamed from: a */
    private static float m4412a(float f) {
        double d;
        Double.isNaN(f - 0.5f);
        return (float) Math.sin((float) (d * 0.4712389167638204d));
    }

    /* renamed from: a */
    private int m4411a(int i) {
        switch (i) {
            case 0:
            case 2:
                return this.f16764s.m4395a(this.f16751f, i);
            case 1:
                return this.f16751f.getLeft();
            default:
                return 0;
        }
    }

    private int getLeftBound() {
        CustomViewBehind customViewBehind = this.f16764s;
        View view = this.f16751f;
        if (customViewBehind.f16784d == 0 || customViewBehind.f16784d == 2) {
            return view.getLeft() - customViewBehind.getBehindWidth();
        }
        if (customViewBehind.f16784d == 1) {
            return view.getLeft();
        }
        return 0;
    }

    private int getRightBound() {
        CustomViewBehind customViewBehind = this.f16764s;
        View view = this.f16751f;
        if (customViewBehind.f16784d == 0) {
            return view.getLeft();
        }
        if (customViewBehind.f16784d == 1 || customViewBehind.f16784d == 2) {
            return view.getLeft() + customViewBehind.getBehindWidth();
        }
        return 0;
    }

    public final int getContentLeft() {
        return this.f16751f.getLeft() + this.f16751f.getPaddingLeft();
    }

    /* renamed from: a */
    private boolean m4413a() {
        int i = this.f16752g;
        return i == 0 || i == 2;
    }

    public final int getBehindWidth() {
        CustomViewBehind customViewBehind = this.f16764s;
        if (customViewBehind == null) {
            return 0;
        }
        return customViewBehind.getBehindWidth();
    }

    public final void setSlidingEnabled(boolean z) {
        this.f16765t = z;
    }

    /* renamed from: a */
    private void m4410a(int i, int i2) {
        int i3;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = 0 - scrollY;
        if (i4 == 0 && i5 == 0) {
            m4405b();
            return;
        }
        setScrollingCacheEnabled(true);
        this.f16755j = true;
        int behindWidth = getBehindWidth();
        float f = behindWidth / 2;
        float m4412a = f + (m4412a(Math.min(1.0f, (Math.abs(i4) * 1.0f) / behindWidth)) * f);
        int abs = Math.abs(i2);
        if (abs > 0) {
            i3 = Math.round(Math.abs(m4412a / abs) * 1000.0f) * 4;
        } else {
            Math.abs(i4);
            i3 = 600;
        }
        this.f16753h.startScroll(scrollX, scrollY, i4, i5, Math.min(i3, 600));
        invalidate();
    }

    public final void setContent(View view) {
        View view2 = this.f16751f;
        if (view2 != null) {
            removeView(view2);
        }
        this.f16751f = view;
        addView(this.f16751f);
    }

    public final View getContent() {
        return this.f16751f;
    }

    public final void setCustomViewBehind(CustomViewBehind customViewBehind) {
        this.f16764s = customViewBehind;
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(0, i);
        int defaultSize2 = getDefaultSize(0, i2);
        setMeasuredDimension(defaultSize, defaultSize2);
        this.f16751f.measure(getChildMeasureSpec(i, 0, defaultSize), getChildMeasureSpec(i2, 0, defaultSize2));
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m4405b();
            scrollTo(m4411a(this.f16752g), getScrollY());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f16751f.layout(0, 0, i3 - i, i4 - i2);
    }

    public final void setAboveOffset(int i) {
        View view = this.f16751f;
        view.setPadding(i, view.getPaddingTop(), this.f16751f.getPaddingRight(), this.f16751f.getPaddingBottom());
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (!this.f16753h.isFinished() && this.f16753h.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f16753h.getCurrX();
            int currY = this.f16753h.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                getWidth();
            }
            invalidate();
            return;
        }
        m4405b();
    }

    /* renamed from: b */
    private void m4405b() {
        if (this.f16755j) {
            setScrollingCacheEnabled(false);
            this.f16753h.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f16753h.getCurrX();
            int currY = this.f16753h.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
        }
        this.f16755j = false;
    }

    public final void setTouchMode(int i) {
        this.f16750d = i;
    }

    public final int getTouchMode() {
        return this.f16750d;
    }

    /* renamed from: a */
    private boolean m4408a(MotionEvent motionEvent) {
        boolean z;
        int x = (int) (motionEvent.getX() + this.f16771z);
        if (m4413a()) {
            CustomViewBehind customViewBehind = this.f16764s;
            View view = this.f16751f;
            int i = this.f16752g;
            return (customViewBehind.f16784d == 0 || (customViewBehind.f16784d == 2 && i == 0)) ? x >= view.getLeft() : (customViewBehind.f16784d == 1 || (customViewBehind.f16784d == 2 && i == 2)) && x <= view.getRight();
        }
        switch (this.f16750d) {
            case 0:
                CustomViewBehind customViewBehind2 = this.f16764s;
                View view2 = this.f16751f;
                int left = view2.getLeft();
                int right = view2.getRight();
                if (customViewBehind2.f16784d == 0) {
                    return x >= left && x <= customViewBehind2.f16783c + left;
                } else if (customViewBehind2.f16784d == 1) {
                    return x <= right && x >= right - customViewBehind2.f16783c;
                } else if (customViewBehind2.f16784d == 2) {
                    return (x >= left && x <= customViewBehind2.f16783c + left) || (x <= right && x >= right - customViewBehind2.f16783c);
                } else {
                    return false;
                }
            case 1:
                Rect rect = new Rect();
                Iterator<View> it = this.f16770y.iterator();
                while (true) {
                    if (it.hasNext()) {
                        it.next().getHitRect(rect);
                        z = rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
                    }
                }
                return !z;
            case 2:
                return false;
            default:
                return false;
        }
    }

    /* renamed from: b */
    private boolean m4404b(float f) {
        if (m4413a()) {
            CustomViewBehind customViewBehind = this.f16764s;
            return customViewBehind.f16784d == 0 ? f < ColumnText.GLOBAL_SPACE_CHAR_RATIO : customViewBehind.f16784d == 1 ? f > ColumnText.GLOBAL_SPACE_CHAR_RATIO : customViewBehind.f16784d == 2;
        }
        CustomViewBehind customViewBehind2 = this.f16764s;
        return customViewBehind2.f16784d == 0 ? f > ColumnText.GLOBAL_SPACE_CHAR_RATIO : customViewBehind2.f16784d == 1 ? f < ColumnText.GLOBAL_SPACE_CHAR_RATIO : customViewBehind2.f16784d == 2;
    }

    /* renamed from: a */
    private int m4407a(MotionEvent motionEvent, int i) {
        int m14413a = MotionEventCompat.m14413a(motionEvent, i);
        if (m14413a == -1) {
            this.f16747a = -1;
        }
        return m14413a;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f16765t) {
            int action = motionEvent.getAction() & 255;
            if (action == 3 || action == 1 || (action != 0 && this.f16757l)) {
                m4401c();
                return false;
            }
            if (action == 0) {
                int action2 = motionEvent.getAction();
                int i = Build.VERSION.SDK_INT;
                this.f16747a = action2 & 65280;
                float m14410c = MotionEventCompat.m14410c(motionEvent, this.f16747a);
                this.f16759n = m14410c;
                this.f16760o = m14410c;
                this.f16761p = MotionEventCompat.m14409d(motionEvent, this.f16747a);
                if (m4408a(motionEvent)) {
                    this.f16756k = false;
                    this.f16757l = false;
                    if (m4413a()) {
                        return true;
                    }
                } else {
                    this.f16757l = true;
                }
            } else if (action == 2) {
                int i2 = this.f16747a;
                if (i2 != -1) {
                    int m4407a = m4407a(motionEvent, i2);
                    if (this.f16747a != -1) {
                        float m14410c2 = MotionEventCompat.m14410c(motionEvent, m4407a);
                        float f = m14410c2 - this.f16760o;
                        float abs = Math.abs(f);
                        float abs2 = Math.abs(MotionEventCompat.m14409d(motionEvent, m4407a) - this.f16761p);
                        if (abs > this.f16758m && abs > abs2 && m4404b(f)) {
                            this.f16756k = true;
                            this.f16760o = m14410c2;
                            setScrollingCacheEnabled(true);
                            m4398f();
                        } else if (abs2 > this.f16758m) {
                            this.f16757l = true;
                        }
                    }
                }
            } else if (action == 6) {
                m4402b(motionEvent);
            }
            if (!this.f16756k) {
                if (this.f16748b == null) {
                    this.f16748b = VelocityTracker.obtain();
                }
                this.f16748b.addMovement(motionEvent);
            }
            return this.f16756k;
        }
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f16765t) {
            if (this.f16756k || m4408a(motionEvent)) {
                int action = motionEvent.getAction();
                if (this.f16748b == null) {
                    this.f16748b = VelocityTracker.obtain();
                }
                this.f16748b.addMovement(motionEvent);
                switch (action & 255) {
                    case 0:
                        m4405b();
                        float x = motionEvent.getX();
                        this.f16759n = x;
                        this.f16760o = x;
                        this.f16747a = MotionEventCompat.m14411b(motionEvent, 0);
                        break;
                    case 1:
                        if (this.f16756k) {
                            VelocityTracker velocityTracker = this.f16748b;
                            velocityTracker.computeCurrentVelocity(1000, this.f16749c);
                            int m14666a = (int) VelocityTrackerCompat.m14666a(velocityTracker, this.f16747a);
                            float scrollX = (getScrollX() - m4411a(this.f16752g)) / getBehindWidth();
                            int m4407a = m4407a(motionEvent, this.f16747a);
                            if (this.f16747a != -1) {
                                int m14410c = (int) (MotionEventCompat.m14410c(motionEvent, m4407a) - this.f16759n);
                                int i = this.f16752g;
                                if (Math.abs(m14410c) <= this.f16763r || Math.abs(m14666a) <= this.f16762q) {
                                    i = Math.round(this.f16752g + scrollX);
                                } else if (m14666a > 0 && m14410c > 0) {
                                    i--;
                                } else if (m14666a < 0 && m14410c < 0) {
                                    i++;
                                }
                                m4409a(i, true, m14666a);
                            } else {
                                m4409a(this.f16752g, true, m14666a);
                            }
                            this.f16747a = -1;
                            m4401c();
                            break;
                        } else if (m4413a()) {
                            setCurrentItem(1);
                            break;
                        }
                        break;
                    case 2:
                        if (!this.f16756k) {
                            int m4407a2 = m4407a(motionEvent, this.f16747a);
                            if (this.f16747a != -1) {
                                float m14410c2 = MotionEventCompat.m14410c(motionEvent, m4407a2);
                                float f = m14410c2 - this.f16760o;
                                float abs = Math.abs(f);
                                float abs2 = Math.abs(MotionEventCompat.m14409d(motionEvent, m4407a2) - this.f16761p);
                                if (abs > this.f16758m && abs > abs2 && m4404b(f)) {
                                    this.f16756k = true;
                                    this.f16760o = m14410c2;
                                    setScrollingCacheEnabled(true);
                                    m4398f();
                                }
                            }
                        }
                        if (this.f16756k) {
                            int m4407a3 = m4407a(motionEvent, this.f16747a);
                            if (this.f16747a != -1) {
                                float m14410c3 = MotionEventCompat.m14410c(motionEvent, m4407a3);
                                float f2 = this.f16760o - m14410c3;
                                this.f16760o = m14410c3;
                                float scrollX2 = getScrollX() + f2;
                                float leftBound = getLeftBound();
                                float rightBound = getRightBound();
                                if (scrollX2 < leftBound) {
                                    scrollX2 = leftBound;
                                } else if (scrollX2 > rightBound) {
                                    scrollX2 = rightBound;
                                }
                                int i2 = (int) scrollX2;
                                this.f16760o += scrollX2 - i2;
                                scrollTo(i2, getScrollY());
                                getWidth();
                                break;
                            }
                        }
                        break;
                    case 3:
                        if (this.f16756k) {
                            m4409a(this.f16752g, true, 0);
                            this.f16747a = -1;
                            m4401c();
                            break;
                        }
                        break;
                    case 5:
                        int m14412b = MotionEventCompat.m14412b(motionEvent);
                        this.f16760o = MotionEventCompat.m14410c(motionEvent, m14412b);
                        this.f16747a = MotionEventCompat.m14411b(motionEvent, m14412b);
                        break;
                    case 6:
                        m4402b(motionEvent);
                        int m4407a4 = m4407a(motionEvent, this.f16747a);
                        if (this.f16747a != -1) {
                            this.f16760o = MotionEventCompat.m14410c(motionEvent, m4407a4);
                            break;
                        }
                        break;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public final void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
        this.f16771z = i;
        if (this.f16765t) {
            CustomViewBehind customViewBehind = this.f16764s;
            View view = this.f16751f;
            if (customViewBehind.f16784d == 0) {
                r3 = i >= view.getLeft() ? 8 : 0;
                customViewBehind.scrollTo((int) ((i + customViewBehind.getBehindWidth()) * customViewBehind.f16787g), i2);
            } else if (customViewBehind.f16784d == 1) {
                r3 = i <= view.getLeft() ? 8 : 0;
                customViewBehind.scrollTo((int) ((customViewBehind.getBehindWidth() - customViewBehind.getWidth()) + ((i - customViewBehind.getBehindWidth()) * customViewBehind.f16787g)), i2);
            } else if (customViewBehind.f16784d == 2) {
                customViewBehind.f16781a.setVisibility(i >= view.getLeft() ? 8 : 0);
                customViewBehind.f16782b.setVisibility(i <= view.getLeft() ? 8 : 0);
                r3 = i == 0 ? 8 : 0;
                if (i <= view.getLeft()) {
                    customViewBehind.scrollTo((int) ((i + customViewBehind.getBehindWidth()) * customViewBehind.f16787g), i2);
                } else {
                    customViewBehind.scrollTo((int) ((customViewBehind.getBehindWidth() - customViewBehind.getWidth()) + ((i - customViewBehind.getBehindWidth()) * customViewBehind.f16787g)), i2);
                }
            }
            customViewBehind.setVisibility(r3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getPercentOpen() {
        return Math.abs(this.f16771z) / getBehindWidth();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void dispatchDraw(Canvas canvas) {
        int i;
        int left;
        super.dispatchDraw(canvas);
        CustomViewBehind customViewBehind = this.f16764s;
        View view = this.f16751f;
        int i2 = 0;
        if (customViewBehind.f16788h != null && customViewBehind.f16790j > 0) {
            if (customViewBehind.f16784d != 0) {
                if (customViewBehind.f16784d == 1) {
                    left = view.getRight();
                } else if (customViewBehind.f16784d != 2) {
                    left = 0;
                } else if (customViewBehind.f16789i != null) {
                    int right = view.getRight();
                    customViewBehind.f16789i.setBounds(right, 0, customViewBehind.f16790j + right, customViewBehind.getHeight());
                    customViewBehind.f16789i.draw(canvas);
                }
                customViewBehind.f16788h.setBounds(left, 0, customViewBehind.f16790j + left, customViewBehind.getHeight());
                customViewBehind.f16788h.draw(canvas);
            }
            left = view.getLeft() - customViewBehind.f16790j;
            customViewBehind.f16788h.setBounds(left, 0, customViewBehind.f16790j + left, customViewBehind.getHeight());
            customViewBehind.f16788h.draw(canvas);
        }
        CustomViewBehind customViewBehind2 = this.f16764s;
        View view2 = this.f16751f;
        float percentOpen = getPercentOpen();
        if (customViewBehind2.f16785e) {
            customViewBehind2.f16786f.setColor(Color.argb((int) (customViewBehind2.f16791k * 255.0f * Math.abs(1.0f - percentOpen)), 0, 0, 0));
            if (customViewBehind2.f16784d == 0) {
                i2 = view2.getLeft() - customViewBehind2.getBehindWidth();
                i = view2.getLeft();
            } else if (customViewBehind2.f16784d == 1) {
                i2 = view2.getRight();
                i = view2.getRight() + customViewBehind2.getBehindWidth();
            } else if (customViewBehind2.f16784d == 2) {
                canvas.drawRect(view2.getLeft() - customViewBehind2.getBehindWidth(), ColumnText.GLOBAL_SPACE_CHAR_RATIO, view2.getLeft(), customViewBehind2.getHeight(), customViewBehind2.f16786f);
                i2 = view2.getRight();
                i = view2.getRight() + customViewBehind2.getBehindWidth();
            } else {
                i = 0;
            }
            canvas.drawRect(i2, ColumnText.GLOBAL_SPACE_CHAR_RATIO, i, customViewBehind2.getHeight(), customViewBehind2.f16786f);
        }
    }

    public final void setSelectorEnabled(boolean z) {
        this.f16744A = z;
    }

    public final void setSelectedView(View view) {
        View view2 = this.f16746C;
        if (view2 != null) {
            view2.setTag(R.id.selected_view, null);
            this.f16746C = null;
        }
        if (view.getParent() != null) {
            this.f16746C = view;
            this.f16746C.setTag(R.id.selected_view, "CustomViewAboveSelectedView");
            invalidate();
        }
    }

    private int getSelectedTop() {
        return this.f16746C.getTop() + ((this.f16746C.getHeight() - this.f16745B.getHeight()) / 2);
    }

    public final void setSelectorBitmap(Bitmap bitmap) {
        this.f16745B = bitmap;
        refreshDrawableState();
    }

    /* renamed from: b */
    private void m4402b(MotionEvent motionEvent) {
        int m14412b = MotionEventCompat.m14412b(motionEvent);
        if (MotionEventCompat.m14411b(motionEvent, m14412b) == this.f16747a) {
            int i = m14412b == 0 ? 1 : 0;
            this.f16760o = MotionEventCompat.m14410c(motionEvent, i);
            this.f16747a = MotionEventCompat.m14411b(motionEvent, i);
            VelocityTracker velocityTracker = this.f16748b;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* renamed from: c */
    private void m4401c() {
        this.f16756k = false;
        this.f16757l = false;
        this.f16747a = -1;
        VelocityTracker velocityTracker = this.f16748b;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f16748b = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f16754i != z) {
            this.f16754i = z;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049 A[RETURN] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r5) {
        /*
            r4 = this;
            boolean r0 = super.dispatchKeyEvent(r5)
            r1 = 1
            if (r0 != 0) goto L4a
            int r0 = r5.getAction()
            r2 = 0
            if (r0 != 0) goto L45
            int r0 = r5.getKeyCode()
            r3 = 61
            if (r0 == r3) goto L28
            switch(r0) {
                case 21: goto L21;
                case 22: goto L1a;
                default: goto L19;
            }
        L19:
            goto L45
        L1a:
            r5 = 66
            boolean r5 = r4.m4403b(r5)
            goto L46
        L21:
            r5 = 17
            boolean r5 = r4.m4403b(r5)
            goto L46
        L28:
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 11
            if (r0 < r3) goto L45
            boolean r0 = android.support.p012v4.view.KeyEventCompat.m14442a(r5)
            if (r0 == 0) goto L3a
            r5 = 2
            boolean r5 = r4.m4403b(r5)
            goto L46
        L3a:
            boolean r5 = android.support.p012v4.view.KeyEventCompat.m14441a(r5, r1)
            if (r5 == 0) goto L45
            boolean r5 = r4.m4403b(r1)
            goto L46
        L45:
            r5 = 0
        L46:
            if (r5 == 0) goto L49
            goto L4a
        L49:
            return r2
        L4a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.widget.slidingmenu.CustomViewAbove.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
        if (r6 != 2) goto L9;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m4403b(int r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.findFocus()
            if (r0 != r5) goto L7
            r0 = 0
        L7:
            r1 = 0
            android.view.FocusFinder r2 = android.view.FocusFinder.getInstance()
            android.view.View r2 = r2.findNextFocus(r5, r0, r6)
            r3 = 66
            r4 = 17
            if (r2 == 0) goto L32
            if (r2 == r0) goto L32
            if (r6 != r4) goto L1f
            boolean r1 = r2.requestFocus()
            goto L46
        L1f:
            if (r6 != r3) goto L46
            if (r0 == 0) goto L2d
            int r1 = r2.getLeft()
            int r0 = r0.getLeft()
            if (r1 <= r0) goto L3d
        L2d:
            boolean r1 = r2.requestFocus()
            goto L46
        L32:
            if (r6 == r4) goto L42
            r0 = 1
            if (r6 != r0) goto L38
            goto L42
        L38:
            if (r6 == r3) goto L3d
            r0 = 2
            if (r6 != r0) goto L46
        L3d:
            boolean r1 = r5.m4399e()
            goto L46
        L42:
            boolean r1 = r5.m4400d()
        L46:
            if (r1 == 0) goto L4f
            int r6 = android.view.SoundEffectConstants.getContantForFocusDirection(r6)
            r5.playSoundEffect(r6)
        L4f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.widget.slidingmenu.CustomViewAbove.m4403b(int):boolean");
    }

    /* renamed from: d */
    private boolean m4400d() {
        int i = this.f16752g;
        if (i > 0) {
            m4409a(i - 1, false, 0);
            return true;
        }
        return false;
    }

    /* renamed from: e */
    private boolean m4399e() {
        int i = this.f16752g;
        if (i <= 0) {
            m4409a(i + 1, false, 0);
            return true;
        }
        return false;
    }

    /* renamed from: f */
    private void m4398f() {
        View view = this.f16751f;
        if (view != null) {
            Context context = view.getContext();
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            View currentFocus = ((Activity) context).getCurrentFocus();
            if (inputMethodManager == null || currentFocus == null) {
                return;
            }
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    public final void setCurrentItem(int i) {
        m4409a(i, false, 0);
    }
}
