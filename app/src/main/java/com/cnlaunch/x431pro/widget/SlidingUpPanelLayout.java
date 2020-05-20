package com.cnlaunch.x431pro.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p012v4.view.MotionEventCompat;
import android.support.p012v4.view.ViewCompat;
import android.support.p012v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.ifoer.expedition.p348a.C3592a;
import com.itextpdf.text.pdf.ColumnText;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* loaded from: classes.dex */
public class SlidingUpPanelLayout extends ViewGroup {

    /* renamed from: b */
    private static final String f16054b = "SlidingUpPanelLayout";

    /* renamed from: c */
    private static final int[] f16055c = {16842927};

    /* renamed from: A */
    private final Rect f16056A;

    /* renamed from: a */
    InterfaceC2799c f16057a;

    /* renamed from: d */
    private int f16058d;

    /* renamed from: e */
    private int f16059e;

    /* renamed from: f */
    private final Paint f16060f;

    /* renamed from: g */
    private Drawable f16061g;

    /* renamed from: h */
    private int f16062h;

    /* renamed from: i */
    private int f16063i;

    /* renamed from: j */
    private boolean f16064j;

    /* renamed from: k */
    private boolean f16065k;

    /* renamed from: l */
    private View f16066l;

    /* renamed from: m */
    private int f16067m;

    /* renamed from: n */
    private View f16068n;

    /* renamed from: o */
    private EnumC2800d f16069o;

    /* renamed from: p */
    private float f16070p;

    /* renamed from: q */
    private int f16071q;

    /* renamed from: r */
    private boolean f16072r;

    /* renamed from: s */
    private boolean f16073s;

    /* renamed from: t */
    private boolean f16074t;

    /* renamed from: u */
    private final int f16075u;

    /* renamed from: v */
    private float f16076v;

    /* renamed from: w */
    private float f16077w;

    /* renamed from: x */
    private float f16078x;

    /* renamed from: y */
    private final ViewDragHelper f16079y;

    /* renamed from: z */
    private boolean f16080z;

    /* renamed from: com.cnlaunch.x431pro.widget.SlidingUpPanelLayout$c */
    /* loaded from: classes.dex */
    public interface InterfaceC2799c {
        /* renamed from: a */
        void mo4734a();

        /* renamed from: a */
        void mo4733a(float f);

        /* renamed from: a */
        void mo4732a(View view);
    }

    /* renamed from: com.cnlaunch.x431pro.widget.SlidingUpPanelLayout$d */
    /* loaded from: classes.dex */
    enum EnumC2800d {
        EXPANDED,
        COLLAPSED,
        ANCHORED
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    private SlidingUpPanelLayout(Context context, AttributeSet attributeSet, byte b) {
        super(context, attributeSet, 0);
        this.f16058d = 400;
        this.f16059e = -1728053248;
        this.f16060f = new Paint();
        this.f16062h = -1;
        this.f16063i = -1;
        this.f16067m = -1;
        this.f16069o = EnumC2800d.COLLAPSED;
        this.f16078x = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f16080z = true;
        this.f16056A = new Rect();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f16055c);
            if (obtainStyledAttributes != null) {
                int i = obtainStyledAttributes.getInt(0, 0);
                if (i != 48 && i != 80) {
                    throw new IllegalArgumentException("layout_gravity must be set to either top or bottom");
                }
                this.f16064j = i == 80;
            }
            obtainStyledAttributes.recycle();
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, C3592a.C3593a.SlidingUpPanelLayout);
            if (obtainStyledAttributes2 != null) {
                this.f16062h = obtainStyledAttributes2.getDimensionPixelSize(0, -1);
                this.f16063i = obtainStyledAttributes2.getDimensionPixelSize(4, -1);
                this.f16058d = obtainStyledAttributes2.getInt(3, 400);
                this.f16059e = obtainStyledAttributes2.getColor(2, -1728053248);
                this.f16067m = obtainStyledAttributes2.getResourceId(1, -1);
            }
            obtainStyledAttributes2.recycle();
        }
        float f = context.getResources().getDisplayMetrics().density;
        if (this.f16062h == -1) {
            this.f16062h = (int) ((68.0f * f) + 0.5f);
        }
        if (this.f16063i == -1) {
            this.f16063i = (int) ((4.0f * f) + 0.5f);
        }
        setWillNotDraw(false);
        this.f16079y = ViewDragHelper.m14296a(this, 0.5f, new C2797a(this, (byte) 0));
        this.f16079y.f1012g = this.f16058d * f;
        this.f16065k = true;
        this.f16073s = true;
        this.f16075u = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i = this.f16067m;
        if (i != -1) {
            this.f16066l = findViewById(i);
        }
    }

    public void setCoveredFadeColor(int i) {
        this.f16059e = i;
        invalidate();
    }

    public int getCoveredFadeColor() {
        return this.f16059e;
    }

    public void setPanelHeight(int i) {
        this.f16062h = i;
        requestLayout();
    }

    public int getPanelHeight() {
        return this.f16062h;
    }

    public void setPanelSlideListener(InterfaceC2799c interfaceC2799c) {
        this.f16057a = interfaceC2799c;
    }

    public void setDragView(View view) {
        this.f16066l = view;
    }

    public void setAnchorPoint(float f) {
        if (f <= ColumnText.GLOBAL_SPACE_CHAR_RATIO || f >= 1.0f) {
            return;
        }
        this.f16078x = f;
    }

    public void setShadowDrawable(Drawable drawable) {
        this.f16061g = drawable;
    }

    /* renamed from: a */
    final void m4758a() {
        int i;
        int i2;
        int i3;
        int i4;
        int max;
        boolean z;
        if (getChildCount() == 0) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        View view = this.f16068n;
        int i5 = 0;
        if (view != null) {
            Drawable background = view.getBackground();
            if (background != null) {
                z = background.getOpacity() == -1;
            } else {
                z = false;
            }
            if (z) {
                i = this.f16068n.getLeft();
                i2 = this.f16068n.getRight();
                i3 = this.f16068n.getTop();
                i4 = this.f16068n.getBottom();
                View childAt = getChildAt(0);
                max = Math.max(paddingLeft, childAt.getLeft());
                int max2 = Math.max(paddingTop, childAt.getTop());
                int min = Math.min(width, childAt.getRight());
                int min2 = Math.min(height, childAt.getBottom());
                if (max >= i && max2 >= i3 && min <= i2 && min2 <= i4) {
                    i5 = 4;
                }
                childAt.setVisibility(i5);
            }
        }
        i = 0;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        View childAt2 = getChildAt(0);
        max = Math.max(paddingLeft, childAt2.getLeft());
        int max22 = Math.max(paddingTop, childAt2.getTop());
        int min3 = Math.min(width, childAt2.getRight());
        int min22 = Math.min(height, childAt2.getBottom());
        if (max >= i) {
            i5 = 4;
        }
        childAt2.setVisibility(i5);
    }

    /* renamed from: b */
    final void m4752b() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f16080z = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f16080z = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int makeMeasureSpec;
        int makeMeasureSpec2;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        }
        if (mode2 != 1073741824) {
            throw new IllegalStateException("Height must have an exact value or MATCH_PARENT");
        }
        int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
        int i4 = this.f16062h;
        int childCount = getChildCount();
        int i5 = 8;
        boolean z = false;
        boolean z2 = true;
        if (childCount > 2) {
            Log.e(f16054b, "onMeasure: More than two child views are not supported.");
        } else if (getChildAt(1).getVisibility() == 8) {
            i4 = 0;
        }
        this.f16068n = null;
        this.f16065k = false;
        int i6 = 0;
        while (i6 < childCount) {
            View childAt = getChildAt(i6);
            C2798b c2798b = (C2798b) childAt.getLayoutParams();
            if (childAt.getVisibility() == i5) {
                c2798b.f16085b = z;
            } else {
                if (i6 == z2) {
                    c2798b.f16084a = z2;
                    c2798b.f16085b = z2;
                    this.f16068n = childAt;
                    this.f16065k = z2;
                    i3 = paddingTop;
                } else {
                    i3 = paddingTop - i4;
                }
                if (c2798b.width == -2) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, NTLMConstants.FLAG_NEGOTIATE_56_BIT_ENCRYPTION);
                } else if (c2798b.width == -1) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, NTLMConstants.FLAG_NEGOTIATE_KEY_EXCHANGE);
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(c2798b.width, NTLMConstants.FLAG_NEGOTIATE_KEY_EXCHANGE);
                }
                if (c2798b.height == -2) {
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i3, NTLMConstants.FLAG_NEGOTIATE_56_BIT_ENCRYPTION);
                } else if (c2798b.height == -1) {
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i3, NTLMConstants.FLAG_NEGOTIATE_KEY_EXCHANGE);
                } else {
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(c2798b.height, NTLMConstants.FLAG_NEGOTIATE_KEY_EXCHANGE);
                }
                childAt.measure(makeMeasureSpec, makeMeasureSpec2);
            }
            i6++;
            i5 = 8;
            z = false;
            z2 = true;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int slidingTop = getSlidingTop();
        int childCount = getChildCount();
        if (this.f16080z) {
            switch (C2917p.f16591a[this.f16069o.ordinal()]) {
                case 1:
                    this.f16070p = this.f16065k ? ColumnText.GLOBAL_SPACE_CHAR_RATIO : 1.0f;
                    break;
                case 2:
                    this.f16070p = this.f16065k ? this.f16078x : 1.0f;
                    break;
                default:
                    this.f16070p = 1.0f;
                    break;
            }
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                C2798b c2798b = (C2798b) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                if (c2798b.f16084a) {
                    this.f16071q = measuredHeight - this.f16062h;
                }
                if (this.f16064j) {
                    i5 = c2798b.f16084a ? ((int) (this.f16071q * this.f16070p)) + slidingTop : paddingTop;
                } else {
                    i5 = c2798b.f16084a ? slidingTop - ((int) (this.f16071q * this.f16070p)) : this.f16062h + paddingTop;
                }
                childAt.layout(paddingLeft, i5, childAt.getMeasuredWidth() + paddingLeft, measuredHeight + i5);
            }
        }
        if (this.f16080z) {
            m4758a();
        }
        this.f16080z = false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i2 != i4) {
            this.f16080z = true;
        }
    }

    public void setSlidingEnabled(boolean z) {
        this.f16073s = z;
    }

    public void setEnableDragViewTouchEvents(boolean z) {
        this.f16074t = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int m14414a = MotionEventCompat.m14414a(motionEvent);
        if (!this.f16065k || !this.f16073s || (this.f16072r && m14414a != 0)) {
            this.f16079y.m14295b();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (m14414a == 3 || m14414a == 1) {
            this.f16079y.m14295b();
            return false;
        } else {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (m14414a != 0) {
                if (m14414a == 2) {
                    float abs = Math.abs(x - this.f16076v);
                    float abs2 = Math.abs(y - this.f16077w);
                    int i = this.f16079y.f1007b;
                    if (this.f16074t) {
                        int i2 = this.f16075u;
                        if (abs > i2 && abs2 < i2) {
                            return super.onInterceptTouchEvent(motionEvent);
                        }
                        if (abs2 > this.f16075u) {
                            z = m4756a((int) x, (int) y);
                            if ((abs2 > i && abs > abs2) || !m4756a((int) x, (int) y)) {
                                this.f16079y.m14295b();
                                this.f16072r = true;
                                return false;
                            }
                        }
                    }
                    z = false;
                    if (abs2 > i) {
                        this.f16079y.m14295b();
                        this.f16072r = true;
                        return false;
                    }
                    this.f16079y.m14295b();
                    this.f16072r = true;
                    return false;
                }
                z = false;
            } else {
                this.f16072r = false;
                this.f16076v = x;
                this.f16077w = y;
                if (m4756a((int) x, (int) y) && !this.f16074t) {
                    z = true;
                }
                z = false;
            }
            return this.f16079y.m14301a(motionEvent) || z;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f16065k || !this.f16073s) {
            return super.onTouchEvent(motionEvent);
        }
        this.f16079y.m14289b(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.f16076v = x;
                this.f16077w = y;
                break;
            case 1:
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float f = x2 - this.f16076v;
                float f2 = y2 - this.f16077w;
                int i = this.f16079y.f1007b;
                View view = this.f16066l;
                if (view == null) {
                    view = this.f16068n;
                }
                if ((f * f) + (f2 * f2) < i * i && m4756a((int) x2, (int) y2)) {
                    view.playSoundEffect(0);
                    if (!(this.f16069o == EnumC2800d.EXPANDED)) {
                        if (!(this.f16069o == EnumC2800d.ANCHORED)) {
                            float f3 = this.f16078x;
                            if (!(getChildCount() >= 2 && getChildAt(1).getVisibility() == 0) && getChildCount() >= 2) {
                                getChildAt(1).setVisibility(0);
                                requestLayout();
                            }
                            if (!this.f16080z) {
                                m4757a(f3);
                                break;
                            }
                        }
                    }
                    m4750c();
                    break;
                }
                break;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m4756a(int i, int i2) {
        View view = this.f16066l;
        if (view == null) {
            view = this.f16068n;
        }
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr2);
        int i3 = iArr2[0] + i;
        int i4 = iArr2[1] + i2;
        return i3 >= iArr[0] && i3 < iArr[0] + view.getWidth() && i4 >= iArr[1] && i4 < iArr[1] + view.getHeight();
    }

    /* renamed from: c */
    public final boolean m4750c() {
        return this.f16080z || m4757a(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSlidingTop() {
        if (this.f16068n != null) {
            return (getMeasuredHeight() - getPaddingBottom()) - this.f16068n.getMeasuredHeight();
        }
        return getMeasuredHeight() - getPaddingBottom();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005a  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean drawChild(android.graphics.Canvas r6, android.view.View r7, long r8) {
        /*
            r5 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.cnlaunch.x431pro.widget.SlidingUpPanelLayout$b r0 = (com.cnlaunch.x431pro.widget.SlidingUpPanelLayout.C2798b) r0
            r1 = 2
            int r1 = r6.save(r1)
            boolean r2 = r5.f16065k
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r2 == 0) goto L50
            boolean r0 = r0.f16084a
            if (r0 != 0) goto L50
            android.view.View r0 = r5.f16068n
            if (r0 == 0) goto L50
            android.graphics.Rect r0 = r5.f16056A
            r6.getClipBounds(r0)
            boolean r0 = r5.f16064j
            if (r0 == 0) goto L33
            android.graphics.Rect r0 = r5.f16056A
            int r2 = r0.bottom
            android.view.View r4 = r5.f16068n
            int r4 = r4.getTop()
            int r2 = java.lang.Math.min(r2, r4)
            r0.bottom = r2
            goto L43
        L33:
            android.graphics.Rect r0 = r5.f16056A
            int r2 = r0.top
            android.view.View r4 = r5.f16068n
            int r4 = r4.getBottom()
            int r2 = java.lang.Math.max(r2, r4)
            r0.top = r2
        L43:
            android.graphics.Rect r0 = r5.f16056A
            r6.clipRect(r0)
            float r0 = r5.f16070p
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L50
            r0 = 1
            goto L51
        L50:
            r0 = 0
        L51:
            boolean r7 = super.drawChild(r6, r7, r8)
            r6.restoreToCount(r1)
            if (r0 == 0) goto L7b
            int r8 = r5.f16059e
            r9 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r9 = r9 & r8
            int r9 = r9 >>> 24
            float r9 = (float) r9
            float r0 = r5.f16070p
            float r3 = r3 - r0
            float r9 = r9 * r3
            int r9 = (int) r9
            int r9 = r9 << 24
            r0 = 16777215(0xffffff, float:2.3509886E-38)
            r8 = r8 & r0
            r8 = r8 | r9
            android.graphics.Paint r9 = r5.f16060f
            r9.setColor(r8)
            android.graphics.Rect r8 = r5.f16056A
            android.graphics.Paint r9 = r5.f16060f
            r6.drawRect(r8, r9)
        L7b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.widget.SlidingUpPanelLayout.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
    }

    /* renamed from: a */
    private boolean m4757a(float f) {
        if (this.f16065k) {
            int slidingTop = getSlidingTop();
            int i = (int) (this.f16064j ? slidingTop + (f * this.f16071q) : slidingTop - (f * this.f16071q));
            ViewDragHelper viewDragHelper = this.f16079y;
            View view = this.f16068n;
            if (viewDragHelper.m14298a(view, view.getLeft(), i)) {
                m4752b();
                ViewCompat.m14626e(this);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f16079y.m14282d()) {
            if (!this.f16065k) {
                this.f16079y.m14286c();
            } else {
                ViewCompat.m14626e(this);
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int bottom;
        int bottom2;
        super.draw(canvas);
        View view = this.f16068n;
        if (view == null) {
            return;
        }
        int right = view.getRight();
        if (this.f16064j) {
            bottom = this.f16068n.getTop() - this.f16063i;
            bottom2 = this.f16068n.getTop();
        } else {
            bottom = this.f16068n.getBottom();
            bottom2 = this.f16068n.getBottom() + this.f16063i;
        }
        int left = this.f16068n.getLeft();
        Drawable drawable = this.f16061g;
        if (drawable != null) {
            drawable.setBounds(left, bottom, right, bottom2);
            this.f16061g.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C2798b();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new C2798b((ViewGroup.MarginLayoutParams) layoutParams) : new C2798b(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C2798b) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C2798b(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f16081a = this.f16069o;
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f16069o = savedState.f16081a;
    }

    /* renamed from: com.cnlaunch.x431pro.widget.SlidingUpPanelLayout$a */
    /* loaded from: classes.dex */
    class C2797a extends ViewDragHelper.AbstractC0321a {
        private C2797a() {
        }

        /* synthetic */ C2797a(SlidingUpPanelLayout slidingUpPanelLayout, byte b) {
            this();
        }

        @Override // android.support.p012v4.widget.ViewDragHelper.AbstractC0321a
        /* renamed from: a */
        public final boolean mo4740a(View view) {
            if (SlidingUpPanelLayout.this.f16072r) {
                return false;
            }
            return ((C2798b) view.getLayoutParams()).f16084a;
        }

        @Override // android.support.p012v4.widget.ViewDragHelper.AbstractC0321a
        /* renamed from: a */
        public final void mo4741a(int i) {
            int i2 = (int) (SlidingUpPanelLayout.this.f16078x * SlidingUpPanelLayout.this.f16071q);
            if (SlidingUpPanelLayout.this.f16079y.f1006a == 0) {
                if (SlidingUpPanelLayout.this.f16070p == ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                    if (SlidingUpPanelLayout.this.f16069o != EnumC2800d.EXPANDED) {
                        SlidingUpPanelLayout.this.m4758a();
                        SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
                        View unused = slidingUpPanelLayout.f16068n;
                        if (slidingUpPanelLayout.f16057a != null) {
                            slidingUpPanelLayout.f16057a.mo4734a();
                        }
                        slidingUpPanelLayout.sendAccessibilityEvent(32);
                        SlidingUpPanelLayout.this.f16069o = EnumC2800d.EXPANDED;
                    }
                } else if (SlidingUpPanelLayout.this.f16070p == i2 / SlidingUpPanelLayout.this.f16071q) {
                    if (SlidingUpPanelLayout.this.f16069o != EnumC2800d.ANCHORED) {
                        SlidingUpPanelLayout.this.m4758a();
                        SlidingUpPanelLayout slidingUpPanelLayout2 = SlidingUpPanelLayout.this;
                        View unused2 = slidingUpPanelLayout2.f16068n;
                        slidingUpPanelLayout2.sendAccessibilityEvent(32);
                        SlidingUpPanelLayout.this.f16069o = EnumC2800d.ANCHORED;
                    }
                } else if (SlidingUpPanelLayout.this.f16069o != EnumC2800d.COLLAPSED) {
                    SlidingUpPanelLayout slidingUpPanelLayout3 = SlidingUpPanelLayout.this;
                    View view = slidingUpPanelLayout3.f16068n;
                    if (slidingUpPanelLayout3.f16057a != null) {
                        slidingUpPanelLayout3.f16057a.mo4732a(view);
                    }
                    slidingUpPanelLayout3.sendAccessibilityEvent(32);
                    SlidingUpPanelLayout.this.f16069o = EnumC2800d.COLLAPSED;
                }
            }
        }

        @Override // android.support.p012v4.widget.ViewDragHelper.AbstractC0321a
        /* renamed from: b */
        public final void mo4737b(View view) {
            SlidingUpPanelLayout.this.m4752b();
        }

        @Override // android.support.p012v4.widget.ViewDragHelper.AbstractC0321a
        /* renamed from: a */
        public final void mo4738a(View view, int i, int i2, int i3, int i4) {
            SlidingUpPanelLayout.m4754a(SlidingUpPanelLayout.this, i2);
            SlidingUpPanelLayout.this.invalidate();
        }

        @Override // android.support.p012v4.widget.ViewDragHelper.AbstractC0321a
        /* renamed from: a */
        public final void mo4739a(View view, float f, float f2) {
            int slidingTop = SlidingUpPanelLayout.this.f16064j ? SlidingUpPanelLayout.this.getSlidingTop() : SlidingUpPanelLayout.this.getSlidingTop() - SlidingUpPanelLayout.this.f16071q;
            if (SlidingUpPanelLayout.this.f16078x != ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                float f3 = SlidingUpPanelLayout.this.f16064j ? ((int) (SlidingUpPanelLayout.this.f16078x * SlidingUpPanelLayout.this.f16071q)) / SlidingUpPanelLayout.this.f16071q : (SlidingUpPanelLayout.this.f16062h - (SlidingUpPanelLayout.this.f16062h - ((int) (SlidingUpPanelLayout.this.f16078x * SlidingUpPanelLayout.this.f16071q)))) / SlidingUpPanelLayout.this.f16071q;
                if (f2 > ColumnText.GLOBAL_SPACE_CHAR_RATIO || (f2 == ColumnText.GLOBAL_SPACE_CHAR_RATIO && SlidingUpPanelLayout.this.f16070p >= (f3 + 1.0f) / 2.0f)) {
                    slidingTop += SlidingUpPanelLayout.this.f16071q;
                } else if (f2 == ColumnText.GLOBAL_SPACE_CHAR_RATIO && SlidingUpPanelLayout.this.f16070p < (1.0f + f3) / 2.0f && SlidingUpPanelLayout.this.f16070p >= f3 / 2.0f) {
                    slidingTop = (int) (slidingTop + (SlidingUpPanelLayout.this.f16071q * SlidingUpPanelLayout.this.f16078x));
                }
            } else if (f2 > ColumnText.GLOBAL_SPACE_CHAR_RATIO || (f2 == ColumnText.GLOBAL_SPACE_CHAR_RATIO && SlidingUpPanelLayout.this.f16070p > 0.5f)) {
                slidingTop += SlidingUpPanelLayout.this.f16071q;
            }
            SlidingUpPanelLayout.this.f16079y.m14304a(view.getLeft(), slidingTop);
            SlidingUpPanelLayout.this.invalidate();
        }

        @Override // android.support.p012v4.widget.ViewDragHelper.AbstractC0321a
        /* renamed from: c */
        public final int mo4735c() {
            return SlidingUpPanelLayout.this.f16071q;
        }

        @Override // android.support.p012v4.widget.ViewDragHelper.AbstractC0321a
        /* renamed from: b */
        public final int mo4736b(View view, int i) {
            int paddingTop;
            int i2;
            if (SlidingUpPanelLayout.this.f16064j) {
                i2 = SlidingUpPanelLayout.this.getSlidingTop();
                paddingTop = SlidingUpPanelLayout.this.f16071q + i2;
            } else {
                paddingTop = SlidingUpPanelLayout.this.getPaddingTop();
                i2 = paddingTop - SlidingUpPanelLayout.this.f16071q;
            }
            return Math.min(Math.max(i, i2), paddingTop);
        }
    }

    /* renamed from: com.cnlaunch.x431pro.widget.SlidingUpPanelLayout$b */
    /* loaded from: classes.dex */
    public static class C2798b extends ViewGroup.MarginLayoutParams {

        /* renamed from: c */
        private static final int[] f16083c = {16843137};

        /* renamed from: a */
        boolean f16084a;

        /* renamed from: b */
        boolean f16085b;

        public C2798b() {
            super(-1, -1);
        }

        public C2798b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C2798b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C2798b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context.obtainStyledAttributes(attributeSet, f16083c).recycle();
        }
    }

    /* loaded from: classes.dex */
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C2946q();

        /* renamed from: a */
        EnumC2800d f16081a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ SavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            try {
                this.f16081a = (EnumC2800d) Enum.valueOf(EnumC2800d.class, parcel.readString());
            } catch (IllegalArgumentException unused) {
                this.f16081a = EnumC2800d.COLLAPSED;
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f16081a.toString());
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m4754a(SlidingUpPanelLayout slidingUpPanelLayout, int i) {
        int slidingTop = slidingUpPanelLayout.getSlidingTop();
        slidingUpPanelLayout.f16070p = (slidingUpPanelLayout.f16064j ? i - slidingTop : slidingTop - i) / slidingUpPanelLayout.f16071q;
        InterfaceC2799c interfaceC2799c = slidingUpPanelLayout.f16057a;
        if (interfaceC2799c != null) {
            interfaceC2799c.mo4733a(slidingUpPanelLayout.f16070p);
        }
    }
}
