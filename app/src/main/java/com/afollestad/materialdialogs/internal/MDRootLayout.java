package com.afollestad.materialdialogs.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.p023v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ScrollView;
import com.afollestad.materialdialogs.C0710c;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.StackingBehavior;
import com.afollestad.materialdialogs.p069a.DialogUtils;
import com.itextpdf.text.pdf.ColumnText;

/* loaded from: classes.dex */
public class MDRootLayout extends ViewGroup {

    /* renamed from: a */
    private final MDButton[] f3446a;

    /* renamed from: b */
    private int f3447b;

    /* renamed from: c */
    private View f3448c;

    /* renamed from: d */
    private View f3449d;

    /* renamed from: e */
    private boolean f3450e;

    /* renamed from: f */
    private boolean f3451f;

    /* renamed from: g */
    private StackingBehavior f3452g;

    /* renamed from: h */
    private boolean f3453h;

    /* renamed from: i */
    private boolean f3454i;

    /* renamed from: j */
    private boolean f3455j;

    /* renamed from: k */
    private boolean f3456k;

    /* renamed from: l */
    private int f3457l;

    /* renamed from: m */
    private int f3458m;

    /* renamed from: n */
    private int f3459n;

    /* renamed from: o */
    private GravityEnum f3460o;

    /* renamed from: p */
    private int f3461p;

    /* renamed from: q */
    private Paint f3462q;

    /* renamed from: r */
    private ViewTreeObserver.OnScrollChangedListener f3463r;

    /* renamed from: s */
    private ViewTreeObserver.OnScrollChangedListener f3464s;

    /* renamed from: t */
    private int f3465t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ boolean m12565a(MDRootLayout mDRootLayout) {
        mDRootLayout.f3450e = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ boolean m12560b(MDRootLayout mDRootLayout) {
        mDRootLayout.f3451f = false;
        return false;
    }

    public MDRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3446a = new MDButton[3];
        this.f3450e = false;
        this.f3451f = false;
        this.f3452g = StackingBehavior.ADAPTIVE;
        this.f3453h = false;
        this.f3454i = true;
        this.f3460o = GravityEnum.START;
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0710c.C0714d.MDRootLayout, 0, 0);
        this.f3455j = obtainStyledAttributes.getBoolean(C0710c.C0714d.MDRootLayout_md_reduce_padding_no_title_no_buttons, true);
        obtainStyledAttributes.recycle();
        this.f3457l = resources.getDimensionPixelSize(C0710c.C0712b.md_notitle_vertical_padding);
        this.f3458m = resources.getDimensionPixelSize(C0710c.C0712b.md_button_frame_vertical_padding);
        this.f3461p = resources.getDimensionPixelSize(C0710c.C0712b.md_button_padding_frame_side);
        this.f3459n = resources.getDimensionPixelSize(C0710c.C0712b.md_button_height);
        this.f3462q = new Paint();
        this.f3465t = resources.getDimensionPixelSize(C0710c.C0712b.md_divider_height);
        this.f3462q.setColor(DialogUtils.m12575a(context, C0710c.C0711a.md_divider_color));
        setWillNotDraw(false);
    }

    /* renamed from: a */
    private static boolean m12572a(View view) {
        boolean z = (view == null || view.getVisibility() == 8) ? false : true;
        return (z && (view instanceof MDButton)) ? ((MDButton) view).getText().toString().trim().length() > 0 : z;
    }

    /* renamed from: a */
    private static boolean m12573a(RecyclerView recyclerView) {
        return (recyclerView == null || recyclerView.getLayoutManager() == null || !recyclerView.getLayoutManager().mo13512f()) ? false : true;
    }

    /* renamed from: a */
    private static boolean m12566a(ScrollView scrollView) {
        if (scrollView.getChildCount() == 0) {
            return false;
        }
        return (scrollView.getMeasuredHeight() - scrollView.getPaddingTop()) - scrollView.getPaddingBottom() < scrollView.getChildAt(0).getMeasuredHeight();
    }

    /* renamed from: a */
    private static boolean m12567a(AdapterView adapterView) {
        if (adapterView.getLastVisiblePosition() == -1) {
            return false;
        }
        return !(adapterView.getFirstVisiblePosition() == 0) || !(adapterView.getLastVisiblePosition() == adapterView.getCount() - 1) || adapterView.getChildCount() <= 0 || adapterView.getChildAt(0).getTop() < adapterView.getPaddingTop() || adapterView.getChildAt(adapterView.getChildCount() - 1).getBottom() > adapterView.getHeight() - adapterView.getPaddingBottom();
    }

    /* renamed from: a */
    private static View m12570a(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() == 0) {
            return null;
        }
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt.getVisibility() == 0 && childAt.getBottom() == viewGroup.getMeasuredHeight()) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: b */
    private static View m12561b(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() == 0) {
            return null;
        }
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt.getVisibility() == 0 && childAt.getTop() == 0) {
                return childAt;
            }
        }
        return null;
    }

    public void setMaxHeight(int i) {
        this.f3447b = i;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getId() == C0710c.C0713c.md_titleFrame) {
                this.f3448c = childAt;
            } else if (childAt.getId() == C0710c.C0713c.md_buttonDefaultNeutral) {
                this.f3446a[0] = (MDButton) childAt;
            } else if (childAt.getId() == C0710c.C0713c.md_buttonDefaultNegative) {
                this.f3446a[1] = (MDButton) childAt;
            } else if (childAt.getId() == C0710c.C0713c.md_buttonDefaultPositive) {
                this.f3446a[2] = (MDButton) childAt;
            } else {
                this.f3449d = childAt;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r12, int r13) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.internal.MDRootLayout.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        View view = this.f3449d;
        if (view != null) {
            if (this.f3450e) {
                int top = view.getTop();
                canvas.drawRect(ColumnText.GLOBAL_SPACE_CHAR_RATIO, top - this.f3465t, getMeasuredWidth(), top, this.f3462q);
            }
            if (this.f3451f) {
                int bottom = this.f3449d.getBottom();
                canvas.drawRect(ColumnText.GLOBAL_SPACE_CHAR_RATIO, bottom, getMeasuredWidth(), bottom + this.f3465t, this.f3462q);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int measuredWidth;
        int i10;
        int measuredWidth2;
        MDButton[] mDButtonArr;
        if (m12572a(this.f3448c)) {
            int measuredHeight = this.f3448c.getMeasuredHeight() + i2;
            this.f3448c.layout(i, i2, i3, measuredHeight);
            i2 = measuredHeight;
        } else if (!this.f3456k && this.f3454i) {
            i2 += this.f3457l;
        }
        if (m12572a(this.f3449d)) {
            View view = this.f3449d;
            view.layout(i, i2, i3, view.getMeasuredHeight() + i2);
        }
        if (this.f3453h) {
            int i11 = i4 - this.f3458m;
            for (MDButton mDButton : this.f3446a) {
                if (m12572a(mDButton)) {
                    mDButton.layout(i, i11 - mDButton.getMeasuredHeight(), i3, i11);
                    i11 -= mDButton.getMeasuredHeight();
                }
            }
        } else {
            if (this.f3454i) {
                i4 -= this.f3458m;
            }
            int i12 = i4 - this.f3459n;
            int i13 = this.f3461p;
            if (m12572a(this.f3446a[2])) {
                if (this.f3460o == GravityEnum.END) {
                    measuredWidth2 = i + i13;
                    i10 = this.f3446a[2].getMeasuredWidth() + measuredWidth2;
                    i5 = -1;
                } else {
                    i10 = i3 - i13;
                    measuredWidth2 = i10 - this.f3446a[2].getMeasuredWidth();
                    i5 = measuredWidth2;
                }
                this.f3446a[2].layout(measuredWidth2, i12, i10, i4);
                i13 += this.f3446a[2].getMeasuredWidth();
            } else {
                i5 = -1;
            }
            if (m12572a(this.f3446a[1])) {
                if (this.f3460o == GravityEnum.END) {
                    i9 = i13 + i;
                    measuredWidth = this.f3446a[1].getMeasuredWidth() + i9;
                    i6 = -1;
                } else if (this.f3460o == GravityEnum.START) {
                    measuredWidth = i3 - i13;
                    i9 = measuredWidth - this.f3446a[1].getMeasuredWidth();
                    i6 = -1;
                } else {
                    i9 = this.f3461p + i;
                    measuredWidth = this.f3446a[1].getMeasuredWidth() + i9;
                    i6 = measuredWidth;
                }
                this.f3446a[1].layout(i9, i12, measuredWidth, i4);
            } else {
                i6 = -1;
            }
            if (m12572a(this.f3446a[0])) {
                if (this.f3460o == GravityEnum.END) {
                    i8 = i3 - this.f3461p;
                    i7 = i8 - this.f3446a[0].getMeasuredWidth();
                } else if (this.f3460o == GravityEnum.START) {
                    i7 = i + this.f3461p;
                    i8 = this.f3446a[0].getMeasuredWidth() + i7;
                } else if (i6 == -1 && i5 != -1) {
                    i7 = i5 - this.f3446a[0].getMeasuredWidth();
                    i8 = i5;
                } else if (i5 == -1 && i6 != -1) {
                    i7 = i6;
                    i8 = i6 + this.f3446a[0].getMeasuredWidth();
                } else if (i5 == -1) {
                    int measuredWidth3 = ((i3 - i) / 2) - (this.f3446a[0].getMeasuredWidth() / 2);
                    i7 = measuredWidth3;
                    i8 = measuredWidth3 + this.f3446a[0].getMeasuredWidth();
                } else {
                    i7 = i6;
                    i8 = i5;
                }
                this.f3446a[0].layout(i7, i12, i8, i4);
            }
        }
        m12571a(this.f3449d, true, true);
    }

    public void setStackingBehavior(StackingBehavior stackingBehavior) {
        this.f3452g = stackingBehavior;
        invalidate();
    }

    public void setDividerColor(int i) {
        this.f3462q.setColor(i);
        invalidate();
    }

    public void setButtonGravity(GravityEnum gravityEnum) {
        this.f3460o = gravityEnum;
        if (Build.VERSION.SDK_INT < 17 || getResources().getConfiguration().getLayoutDirection() != 1) {
            return;
        }
        switch (this.f3460o) {
            case START:
                this.f3460o = GravityEnum.END;
                return;
            case END:
                this.f3460o = GravityEnum.START;
                return;
            default:
                return;
        }
    }

    public void setButtonStackedGravity(GravityEnum gravityEnum) {
        MDButton[] mDButtonArr;
        for (MDButton mDButton : this.f3446a) {
            if (mDButton != null) {
                mDButton.setStackedGravity(gravityEnum);
            }
        }
    }

    /* renamed from: a */
    private void m12571a(View view, boolean z, boolean z2) {
        while (view != null) {
            if (view instanceof ScrollView) {
                ScrollView scrollView = (ScrollView) view;
                if (m12566a(scrollView)) {
                    m12569a((ViewGroup) scrollView, z, z2);
                    return;
                }
                if (z) {
                    this.f3450e = false;
                }
                if (z2) {
                    this.f3451f = false;
                    return;
                }
                return;
            } else if (view instanceof AdapterView) {
                AdapterView adapterView = (AdapterView) view;
                if (m12567a(adapterView)) {
                    m12569a((ViewGroup) adapterView, z, z2);
                    return;
                }
                if (z) {
                    this.f3450e = false;
                }
                if (z2) {
                    this.f3451f = false;
                    return;
                }
                return;
            } else if (view instanceof WebView) {
                view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver$OnPreDrawListenerC0716b(this, view, z, z2));
                return;
            } else if (view instanceof RecyclerView) {
                boolean m12573a = m12573a((RecyclerView) view);
                if (z) {
                    this.f3450e = m12573a;
                }
                if (z2) {
                    this.f3451f = m12573a;
                }
                if (m12573a) {
                    m12569a((ViewGroup) view, z, z2);
                    return;
                }
                return;
            } else if (!(view instanceof ViewGroup)) {
                return;
            } else {
                ViewGroup viewGroup = (ViewGroup) view;
                View m12561b = m12561b(viewGroup);
                m12571a(m12561b, z, z2);
                view = m12570a(viewGroup);
                if (view == m12561b) {
                    return;
                }
                z2 = true;
                z = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12569a(ViewGroup viewGroup, boolean z, boolean z2) {
        if ((z2 || this.f3463r != null) && !(z2 && this.f3464s == null)) {
            return;
        }
        if (viewGroup instanceof RecyclerView) {
            C0717c c0717c = new C0717c(this, viewGroup, z, z2);
            RecyclerView recyclerView = (RecyclerView) viewGroup;
            recyclerView.m13793a(c0717c);
            c0717c.mo12558a(recyclerView, 0, 0);
            return;
        }
        ViewTreeObserver$OnScrollChangedListenerC0718d viewTreeObserver$OnScrollChangedListenerC0718d = new ViewTreeObserver$OnScrollChangedListenerC0718d(this, viewGroup, z, z2);
        if (!z2) {
            this.f3463r = viewTreeObserver$OnScrollChangedListenerC0718d;
            viewGroup.getViewTreeObserver().addOnScrollChangedListener(this.f3463r);
        } else {
            this.f3464s = viewTreeObserver$OnScrollChangedListenerC0718d;
            viewGroup.getViewTreeObserver().addOnScrollChangedListener(this.f3464s);
        }
        viewTreeObserver$OnScrollChangedListenerC0718d.onScrollChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ boolean m12568a(WebView webView) {
        return ((float) webView.getMeasuredHeight()) < ((float) webView.getContentHeight()) * webView.getScale();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m12563a(MDRootLayout mDRootLayout, ViewGroup viewGroup, boolean z, boolean z2, boolean z3) {
        boolean z4 = true;
        if (z && viewGroup.getChildCount() > 0) {
            View view = mDRootLayout.f3448c;
            mDRootLayout.f3450e = (view == null || view.getVisibility() == 8 || viewGroup.getScrollY() + viewGroup.getPaddingTop() <= viewGroup.getChildAt(0).getTop()) ? false : true;
        }
        if (!z2 || viewGroup.getChildCount() <= 0) {
            return;
        }
        mDRootLayout.f3451f = (!z3 || (viewGroup.getScrollY() + viewGroup.getHeight()) - viewGroup.getPaddingBottom() >= viewGroup.getChildAt(viewGroup.getChildCount() - 1).getBottom()) ? false : false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m12562a(MDRootLayout mDRootLayout, WebView webView, boolean z, boolean z2, boolean z3) {
        boolean z4 = true;
        if (z) {
            View view = mDRootLayout.f3448c;
            mDRootLayout.f3450e = (view == null || view.getVisibility() == 8 || webView.getScrollY() + webView.getPaddingTop() <= 0) ? false : true;
        }
        if (z2) {
            mDRootLayout.f3451f = (!z3 || ((float) ((webView.getScrollY() + webView.getMeasuredHeight()) - webView.getPaddingBottom())) >= ((float) webView.getContentHeight()) * webView.getScale()) ? false : false;
        }
    }
}
