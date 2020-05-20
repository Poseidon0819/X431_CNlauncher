package com.cnlaunch.golo3.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p012v4.view.PagerAdapter;
import android.support.p012v4.view.ViewPager;
import android.util.SparseArray;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cnlaunch.golo3.p165g.WindowUtils;
import com.itextpdf.text.pdf.ColumnText;

/* loaded from: classes.dex */
public final class PagerSlidingTabStrip extends HorizontalScrollView {

    /* renamed from: e */
    private static final int[] f8797e = {16842901, 16842904};

    /* renamed from: A */
    private int f8798A;

    /* renamed from: B */
    private int f8799B;

    /* renamed from: C */
    private int f8800C;

    /* renamed from: D */
    private int f8801D;

    /* renamed from: E */
    private int f8802E;

    /* renamed from: F */
    private boolean f8803F;

    /* renamed from: a */
    public ViewPager.InterfaceC0176e f8804a;

    /* renamed from: b */
    boolean f8805b;

    /* renamed from: c */
    private SparseArray<LinearLayout> f8806c;

    /* renamed from: d */
    private InterfaceC1662d f8807d;

    /* renamed from: f */
    private LinearLayout.LayoutParams f8808f;

    /* renamed from: g */
    private LinearLayout.LayoutParams f8809g;

    /* renamed from: h */
    private final C1663e f8810h;

    /* renamed from: i */
    private LinearLayout f8811i;

    /* renamed from: j */
    private ViewPager f8812j;

    /* renamed from: k */
    private int f8813k;

    /* renamed from: l */
    private int f8814l;

    /* renamed from: m */
    private int f8815m;

    /* renamed from: n */
    private float f8816n;

    /* renamed from: o */
    private Paint f8817o;

    /* renamed from: p */
    private Paint f8818p;

    /* renamed from: q */
    private int f8819q;

    /* renamed from: r */
    private int f8820r;

    /* renamed from: s */
    private int f8821s;

    /* renamed from: t */
    private boolean f8822t;

    /* renamed from: u */
    private boolean f8823u;

    /* renamed from: v */
    private int f8824v;

    /* renamed from: w */
    private int f8825w;

    /* renamed from: x */
    private int f8826x;

    /* renamed from: y */
    private int f8827y;

    /* renamed from: z */
    private int f8828z;

    /* renamed from: com.cnlaunch.golo3.widget.PagerSlidingTabStrip$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1659a {
        /* renamed from: a */
        View m8967a();
    }

    /* renamed from: com.cnlaunch.golo3.widget.PagerSlidingTabStrip$b */
    /* loaded from: classes.dex */
    public interface InterfaceC1660b {
        /* renamed from: a */
        int m8966a();
    }

    /* renamed from: com.cnlaunch.golo3.widget.PagerSlidingTabStrip$c */
    /* loaded from: classes.dex */
    public interface InterfaceC1661c {
    }

    /* renamed from: com.cnlaunch.golo3.widget.PagerSlidingTabStrip$d */
    /* loaded from: classes.dex */
    public interface InterfaceC1662d {
    }

    public final SparseArray<LinearLayout> getTabView() {
        return this.f8806c;
    }

    public final void setViewPager(ViewPager viewPager) {
        this.f8812j = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        viewPager.setOnPageChangeListener(this.f8810h);
        m8979a();
    }

    public final void setOnPageChangeListener(ViewPager.InterfaceC0176e interfaceC0176e) {
        this.f8804a = interfaceC0176e;
    }

    /* renamed from: a */
    private void m8979a() {
        this.f8811i.removeAllViews();
        PagerAdapter adapter = this.f8812j.getAdapter();
        this.f8813k = adapter.mo1771a();
        for (int i = 0; i < this.f8813k; i++) {
            if (adapter instanceof InterfaceC1660b) {
                int m8966a = ((InterfaceC1660b) adapter).m8966a();
                ImageButton imageButton = new ImageButton(getContext());
                imageButton.setImageResource(m8966a);
                m8978a(i, imageButton);
            } else if (adapter instanceof InterfaceC1661c) {
                String charSequence = adapter.mo5638a(i).toString();
                LinearLayout linearLayout = new LinearLayout(getContext());
                linearLayout.setOrientation(0);
                linearLayout.setGravity(17);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                TextView textView = new TextView(getContext());
                textView.setText(charSequence);
                textView.setTextSize(2, 14.0f);
                textView.setGravity(17);
                textView.setSingleLine();
                linearLayout.addView(textView, layoutParams);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(WindowUtils.m9109a(20.0f), WindowUtils.m9109a(20.0f));
                layoutParams2.gravity = 17;
                layoutParams2.leftMargin = 5;
                TextView textView2 = new TextView(getContext());
                textView2.setSingleLine();
                textView2.setTextSize(2, 12.0f);
                textView2.setGravity(17);
                textView2.setVisibility(8);
                linearLayout.addView(textView2, layoutParams2);
                this.f8806c.put(i, linearLayout);
                m8978a(i, linearLayout);
            } else if (adapter instanceof InterfaceC1659a) {
                m8978a(i, ((InterfaceC1659a) adapter).m8967a());
            } else {
                String charSequence2 = adapter.mo5638a(i).toString();
                TextView textView3 = new TextView(getContext());
                textView3.setText(charSequence2);
                textView3.setGravity(17);
                textView3.setSingleLine();
                textView3.setTextSize(2, 14.0f);
                m8978a(i, textView3);
            }
        }
        m8973b();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver$OnGlobalLayoutListenerC1669g(this));
    }

    /* renamed from: a */
    private void m8978a(int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View$OnClickListenerC1670h(this, i));
        int i2 = this.f8828z;
        view.setPadding(i2, 0, i2, 0);
        this.f8811i.addView(view, i, this.f8822t ? this.f8809g : this.f8808f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8973b() {
        for (int i = 0; i < this.f8813k; i++) {
            View childAt = this.f8811i.getChildAt(i);
            childAt.setBackgroundResource(this.f8802E);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                textView.setTextColor(this.f8799B);
                if (i == this.f8815m) {
                    textView.setTextColor(this.f8800C);
                }
            }
            if (i == this.f8815m) {
                View childAt2 = this.f8811i.getChildAt(i);
                if (childAt2 instanceof LinearLayout) {
                    View childAt3 = ((LinearLayout) childAt2).getChildAt(0);
                    if (childAt3 instanceof TextView) {
                        ((TextView) childAt3).setTextColor(this.f8800C);
                    }
                }
            } else {
                View childAt4 = this.f8811i.getChildAt(i);
                if (childAt4 instanceof LinearLayout) {
                    View childAt5 = ((LinearLayout) childAt4).getChildAt(0);
                    if (childAt5 instanceof TextView) {
                        ((TextView) childAt5).setTextColor(this.f8799B);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        float f;
        float f2;
        int i;
        super.onDraw(canvas);
        if (isInEditMode() || this.f8813k == 0) {
            return;
        }
        int height = getHeight();
        this.f8817o.setColor(this.f8820r);
        float f3 = height;
        canvas.drawRect(ColumnText.GLOBAL_SPACE_CHAR_RATIO, height - this.f8826x, this.f8811i.getWidth(), f3, this.f8817o);
        this.f8817o.setColor(this.f8819q);
        View childAt = this.f8811i.getChildAt(this.f8814l);
        if (childAt == null) {
            return;
        }
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.f8816n <= ColumnText.GLOBAL_SPACE_CHAR_RATIO || (i = this.f8814l) >= this.f8813k - 1) {
            f = right;
            f2 = left;
        } else {
            View childAt2 = this.f8811i.getChildAt(i + 1);
            float f4 = this.f8816n;
            f = (childAt2.getRight() * f4) + ((1.0f - f4) * right);
            f2 = (childAt2.getLeft() * f4) + ((1.0f - f4) * left);
        }
        canvas.drawRect(f2, height - this.f8825w, f, f3, this.f8817o);
        if (this.f8803F) {
            this.f8818p.setColor(this.f8821s);
            for (int i2 = 0; i2 < this.f8813k - 1; i2++) {
                View childAt3 = this.f8811i.getChildAt(i2);
                canvas.drawLine(childAt3.getRight(), this.f8827y, childAt3.getRight(), height - this.f8827y, this.f8818p);
            }
        }
    }

    /* renamed from: com.cnlaunch.golo3.widget.PagerSlidingTabStrip$e */
    /* loaded from: classes.dex */
    class C1663e implements ViewPager.InterfaceC0176e {

        /* renamed from: a */
        final /* synthetic */ PagerSlidingTabStrip f8830a;

        @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
        /* renamed from: a */
        public final void mo1773a(int i, float f, int i2) {
            this.f8830a.f8814l = i;
            this.f8830a.f8816n = f;
            if (this.f8830a.f8811i == null || this.f8830a.f8811i.getChildCount() <= 0) {
                return;
            }
            PagerSlidingTabStrip pagerSlidingTabStrip = this.f8830a;
            PagerSlidingTabStrip.m8974a(pagerSlidingTabStrip, i, (int) (pagerSlidingTabStrip.f8811i.getChildAt(i).getWidth() * f));
            this.f8830a.invalidate();
            if (this.f8830a.f8804a != null) {
                this.f8830a.f8804a.mo1773a(i, f, i2);
            }
        }

        @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
        /* renamed from: a_ */
        public final void mo1772a_(int i) {
            if (i == 0) {
                PagerSlidingTabStrip pagerSlidingTabStrip = this.f8830a;
                PagerSlidingTabStrip.m8974a(pagerSlidingTabStrip, pagerSlidingTabStrip.f8812j.getCurrentItem(), 0);
            }
            if (this.f8830a.f8804a != null) {
                this.f8830a.f8804a.mo1772a_(i);
            }
        }

        @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
        /* renamed from: a */
        public final void mo1774a(int i) {
            this.f8830a.f8815m = i;
            this.f8830a.m8973b();
            if (this.f8830a.f8804a != null) {
                this.f8830a.f8804a.mo1774a(i);
            }
        }
    }

    public final void setTabClick(InterfaceC1662d interfaceC1662d) {
        this.f8807d = interfaceC1662d;
    }

    public final void setIndicatorColor(int i) {
        this.f8819q = i;
        invalidate();
    }

    public final void setIndicatorColorResource(int i) {
        this.f8819q = getResources().getColor(i);
        invalidate();
    }

    public final int getIndicatorColor() {
        return this.f8819q;
    }

    public final void setIndicatorHeight(int i) {
        this.f8825w = i;
        invalidate();
    }

    public final int getIndicatorHeight() {
        return this.f8825w;
    }

    public final void setUnderlineColor(int i) {
        this.f8820r = i;
        invalidate();
    }

    public final void setUnderlineColorResource(int i) {
        this.f8820r = getResources().getColor(i);
        invalidate();
    }

    public final int getUnderlineColor() {
        return this.f8820r;
    }

    public final void setDivider(boolean z) {
        this.f8803F = z;
        invalidate();
    }

    public final void setDividerColor(int i) {
        this.f8821s = i;
        invalidate();
    }

    public final void setDividerColorResource(int i) {
        this.f8821s = getResources().getColor(i);
        invalidate();
    }

    public final int getDividerColor() {
        return this.f8821s;
    }

    public final void setUnderlineHeight(int i) {
        this.f8826x = i;
        invalidate();
    }

    public final int getUnderlineHeight() {
        return this.f8826x;
    }

    public final void setDividerPadding(int i) {
        this.f8827y = i;
        invalidate();
    }

    public final int getDividerPadding() {
        return this.f8827y;
    }

    public final void setScrollOffset(int i) {
        this.f8824v = i;
        invalidate();
    }

    public final int getScrollOffset() {
        return this.f8824v;
    }

    public final void setShouldExpand(boolean z) {
        this.f8822t = z;
        if (this.f8812j != null) {
            m8979a();
        }
    }

    public final boolean getShouldExpand() {
        return this.f8822t;
    }

    public final void setAllCaps(boolean z) {
        this.f8823u = z;
    }

    public final void setTextSize(int i) {
        this.f8798A = i;
        m8973b();
    }

    public final void setCurrentTabs(int i) {
        this.f8814l = i;
        this.f8815m = i;
        m8973b();
    }

    public final int getTextSize() {
        return this.f8798A;
    }

    public final void setTextColor(int i) {
        this.f8799B = i;
        m8973b();
    }

    public final void setTextColorResource(int i) {
        this.f8799B = getResources().getColor(i);
        m8973b();
    }

    public final int getTextColor() {
        return this.f8799B;
    }

    public final void setSelectedTextColor(int i) {
        this.f8800C = i;
        m8973b();
    }

    public final void setSelectedTextColorResource(int i) {
        this.f8800C = getResources().getColor(i);
        m8973b();
    }

    public final int getSelectedTextColor() {
        return this.f8800C;
    }

    public final void setTabBackground(int i) {
        this.f8802E = i;
        m8973b();
    }

    public final int getTabBackground() {
        return this.f8802E;
    }

    public final void setTabPaddingLeftRight(int i) {
        this.f8828z = i;
        m8973b();
    }

    public final int getTabPaddingLeftRight() {
        return this.f8828z;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f8814l = savedState.f8829a;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f8829a = this.f8814l;
        return savedState;
    }

    /* loaded from: classes.dex */
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1672j();

        /* renamed from: a */
        int f8829a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ SavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f8829a = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f8829a);
        }
    }

    public final void setCurrentPage(int i) {
        ViewPager viewPager = this.f8812j;
        if (viewPager == null || i < 0) {
            return;
        }
        viewPager.setCurrentItem(i);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver$OnGlobalLayoutListenerC1671i(this, i));
    }

    public final void setScrllo(boolean z) {
        this.f8805b = z;
    }

    public final int getCurrentPosition() {
        return this.f8814l;
    }

    public final LinearLayout getTabsContainer() {
        return this.f8811i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m8974a(PagerSlidingTabStrip pagerSlidingTabStrip, int i, int i2) {
        if (pagerSlidingTabStrip.f8813k == 0 || pagerSlidingTabStrip.f8811i.getChildAt(i) == null) {
            return;
        }
        int left = pagerSlidingTabStrip.f8811i.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= pagerSlidingTabStrip.f8824v;
        }
        if (left != pagerSlidingTabStrip.f8801D) {
            pagerSlidingTabStrip.f8801D = left;
            pagerSlidingTabStrip.scrollTo(left, 0);
        }
    }
}
