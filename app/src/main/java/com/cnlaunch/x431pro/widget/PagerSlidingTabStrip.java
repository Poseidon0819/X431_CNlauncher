package com.cnlaunch.x431pro.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p012v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ifoer.expedition.p348a.C3592a;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.ColumnText;
import java.util.Locale;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {

    /* renamed from: b */
    private static final int[] f16022b = {16842901, 16842904};

    /* renamed from: A */
    private int f16023A;

    /* renamed from: B */
    private int f16024B;

    /* renamed from: C */
    private int f16025C;

    /* renamed from: D */
    private Locale f16026D;

    /* renamed from: a */
    public ViewPager.InterfaceC0176e f16027a;

    /* renamed from: c */
    private LinearLayout.LayoutParams f16028c;

    /* renamed from: d */
    private LinearLayout.LayoutParams f16029d;

    /* renamed from: e */
    private final C2796b f16030e;

    /* renamed from: f */
    private LinearLayout f16031f;

    /* renamed from: g */
    private ViewPager f16032g;

    /* renamed from: h */
    private int f16033h;

    /* renamed from: i */
    private int f16034i;

    /* renamed from: j */
    private float f16035j;

    /* renamed from: k */
    private Paint f16036k;

    /* renamed from: l */
    private Paint f16037l;

    /* renamed from: m */
    private int f16038m;

    /* renamed from: n */
    private int f16039n;

    /* renamed from: o */
    private int f16040o;

    /* renamed from: p */
    private boolean f16041p;

    /* renamed from: q */
    private boolean f16042q;

    /* renamed from: r */
    private int f16043r;

    /* renamed from: s */
    private int f16044s;

    /* renamed from: t */
    private int f16045t;

    /* renamed from: u */
    private int f16046u;

    /* renamed from: v */
    private int f16047v;

    /* renamed from: w */
    private int f16048w;

    /* renamed from: x */
    private int f16049x;

    /* renamed from: y */
    private int f16050y;

    /* renamed from: z */
    private Typeface f16051z;

    /* renamed from: com.cnlaunch.x431pro.widget.PagerSlidingTabStrip$a */
    /* loaded from: classes.dex */
    public interface InterfaceC2795a {
        /* renamed from: a */
        int m4759a();
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    private PagerSlidingTabStrip(Context context, AttributeSet attributeSet, byte b) {
        super(context, attributeSet, 0);
        this.f16030e = new C2796b(this, (byte) 0);
        this.f16034i = 0;
        this.f16035j = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f16038m = -10066330;
        this.f16039n = 436207616;
        this.f16040o = 436207616;
        this.f16041p = false;
        this.f16042q = true;
        this.f16043r = 52;
        this.f16044s = 8;
        this.f16045t = 2;
        this.f16046u = 12;
        this.f16047v = 20;
        this.f16048w = 1;
        this.f16049x = 12;
        this.f16050y = -10066330;
        this.f16051z = null;
        this.f16023A = 1;
        this.f16024B = 0;
        this.f16025C = R.drawable.background_tab;
        setFillViewport(true);
        setWillNotDraw(false);
        this.f16031f = new LinearLayout(context);
        this.f16031f.setOrientation(0);
        this.f16031f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.f16031f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f16043r = (int) TypedValue.applyDimension(1, this.f16043r, displayMetrics);
        this.f16044s = (int) TypedValue.applyDimension(1, this.f16044s, displayMetrics);
        this.f16045t = (int) TypedValue.applyDimension(1, this.f16045t, displayMetrics);
        this.f16046u = (int) TypedValue.applyDimension(1, this.f16046u, displayMetrics);
        this.f16047v = (int) TypedValue.applyDimension(1, this.f16047v, displayMetrics);
        this.f16048w = (int) TypedValue.applyDimension(1, this.f16048w, displayMetrics);
        this.f16049x = (int) TypedValue.applyDimension(2, this.f16049x, displayMetrics);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f16022b);
        this.f16049x = obtainStyledAttributes.getDimensionPixelSize(0, this.f16049x);
        this.f16050y = obtainStyledAttributes.getColor(1, this.f16050y);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, C3592a.C3593a.PagerSlidingTabStrip);
        this.f16038m = obtainStyledAttributes2.getColor(2, this.f16038m);
        this.f16039n = obtainStyledAttributes2.getColor(11, this.f16039n);
        this.f16040o = obtainStyledAttributes2.getColor(0, this.f16040o);
        this.f16044s = obtainStyledAttributes2.getDimensionPixelSize(3, this.f16044s);
        this.f16045t = obtainStyledAttributes2.getDimensionPixelSize(12, this.f16045t);
        this.f16046u = obtainStyledAttributes2.getDimensionPixelSize(1, this.f16046u);
        this.f16047v = obtainStyledAttributes2.getDimensionPixelSize(9, this.f16047v);
        this.f16025C = obtainStyledAttributes2.getResourceId(7, this.f16025C);
        this.f16041p = obtainStyledAttributes2.getBoolean(5, this.f16041p);
        this.f16043r = obtainStyledAttributes2.getDimensionPixelSize(4, this.f16043r);
        this.f16042q = obtainStyledAttributes2.getBoolean(10, this.f16042q);
        obtainStyledAttributes2.recycle();
        this.f16036k = new Paint();
        this.f16036k.setAntiAlias(true);
        this.f16036k.setStyle(Paint.Style.FILL);
        this.f16037l = new Paint();
        this.f16037l.setAntiAlias(true);
        this.f16037l.setStrokeWidth(this.f16048w);
        this.f16028c = new LinearLayout.LayoutParams(-2, -1);
        this.f16029d = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        if (this.f16026D == null) {
            this.f16026D = getResources().getConfiguration().locale;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.f16032g = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        viewPager.setOnPageChangeListener(this.f16030e);
        m4768a();
    }

    public void setOnPageChangeListener(ViewPager.InterfaceC0176e interfaceC0176e) {
        this.f16027a = interfaceC0176e;
    }

    /* renamed from: a */
    private void m4768a() {
        this.f16031f.removeAllViews();
        this.f16033h = this.f16032g.getAdapter().mo1771a();
        for (int i = 0; i < this.f16033h; i++) {
            if (this.f16032g.getAdapter() instanceof InterfaceC2795a) {
                int m4759a = ((InterfaceC2795a) this.f16032g.getAdapter()).m4759a();
                ImageButton imageButton = new ImageButton(getContext());
                imageButton.setImageResource(m4759a);
                m4767a(i, imageButton);
            } else {
                String charSequence = this.f16032g.getAdapter().mo5638a(i).toString();
                View inflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.pagersliding_tab_layout, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.tab_textview);
                textView.setText(charSequence);
                textView.setGravity(17);
                textView.setSingleLine();
                m4767a(i, inflate);
            }
        }
        m4762b();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver$OnGlobalLayoutListenerC2914m(this));
    }

    /* renamed from: a */
    private void m4767a(int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View$OnClickListenerC2915n(this, i));
        int i2 = this.f16047v;
        view.setPadding(i2, 0, i2, 0);
        this.f16031f.addView(view, i, this.f16041p ? this.f16029d : this.f16028c);
    }

    /* renamed from: b */
    private void m4762b() {
        for (int i = 0; i < this.f16033h; i++) {
            View childAt = this.f16031f.getChildAt(i);
            childAt.setBackgroundResource(this.f16025C);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                textView.setTextSize(2, this.f16049x);
                textView.setTypeface(this.f16051z, this.f16023A);
                textView.setTextColor(this.f16050y);
                if (this.f16042q) {
                    if (Build.VERSION.SDK_INT >= 14) {
                        textView.setAllCaps(true);
                    } else {
                        textView.setText(textView.getText().toString().toUpperCase(this.f16026D));
                    }
                }
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        float f2;
        int i;
        super.onDraw(canvas);
        if (isInEditMode() || this.f16033h == 0) {
            return;
        }
        int height = getHeight();
        this.f16036k.setColor(this.f16038m);
        View childAt = this.f16031f.getChildAt(this.f16034i);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.f16035j <= ColumnText.GLOBAL_SPACE_CHAR_RATIO || (i = this.f16034i) >= this.f16033h - 1) {
            f = right;
            f2 = left;
        } else {
            View childAt2 = this.f16031f.getChildAt(i + 1);
            float f3 = this.f16035j;
            f = (childAt2.getRight() * f3) + ((1.0f - f3) * right);
            f2 = (childAt2.getLeft() * f3) + ((1.0f - f3) * left);
        }
        float f4 = height;
        canvas.drawRect(f2, height - this.f16044s, f, f4, this.f16036k);
        this.f16036k.setColor(this.f16039n);
        canvas.drawRect(ColumnText.GLOBAL_SPACE_CHAR_RATIO, height - this.f16045t, this.f16031f.getWidth(), f4, this.f16036k);
        this.f16037l.setColor(this.f16040o);
        for (int i2 = 0; i2 < this.f16033h - 1; i2++) {
            View childAt3 = this.f16031f.getChildAt(i2);
            canvas.drawLine(childAt3.getRight(), this.f16046u, childAt3.getRight(), height - this.f16046u, this.f16037l);
        }
    }

    /* renamed from: com.cnlaunch.x431pro.widget.PagerSlidingTabStrip$b */
    /* loaded from: classes.dex */
    class C2796b implements ViewPager.InterfaceC0176e {
        private C2796b() {
        }

        /* synthetic */ C2796b(PagerSlidingTabStrip pagerSlidingTabStrip, byte b) {
            this();
        }

        @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
        /* renamed from: a */
        public final void mo1773a(int i, float f, int i2) {
            PagerSlidingTabStrip.this.f16034i = i;
            PagerSlidingTabStrip.this.f16035j = f;
            PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
            PagerSlidingTabStrip.m4763a(pagerSlidingTabStrip, i, (int) (pagerSlidingTabStrip.f16031f.getChildAt(i).getWidth() * f));
            PagerSlidingTabStrip.this.invalidate();
            if (PagerSlidingTabStrip.this.f16027a != null) {
                PagerSlidingTabStrip.this.f16027a.mo1773a(i, f, i2);
            }
        }

        @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
        /* renamed from: a_ */
        public final void mo1772a_(int i) {
            if (i == 0) {
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                PagerSlidingTabStrip.m4763a(pagerSlidingTabStrip, pagerSlidingTabStrip.f16032g.getCurrentItem(), 0);
            }
            if (PagerSlidingTabStrip.this.f16027a != null) {
                PagerSlidingTabStrip.this.f16027a.mo1772a_(i);
            }
        }

        @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
        /* renamed from: a */
        public final void mo1774a(int i) {
            if (PagerSlidingTabStrip.this.f16027a != null) {
                PagerSlidingTabStrip.this.f16027a.mo1774a(i);
            }
        }
    }

    public void setIndicatorColor(int i) {
        this.f16038m = i;
        invalidate();
    }

    public void setIndicatorColorResource(int i) {
        this.f16038m = getResources().getColor(i);
        invalidate();
    }

    public int getIndicatorColor() {
        return this.f16038m;
    }

    public void setIndicatorHeight(int i) {
        this.f16044s = i;
        invalidate();
    }

    public int getIndicatorHeight() {
        return this.f16044s;
    }

    public void setUnderlineColor(int i) {
        this.f16039n = i;
        invalidate();
    }

    public void setUnderlineColorResource(int i) {
        this.f16039n = getResources().getColor(i);
        invalidate();
    }

    public int getUnderlineColor() {
        return this.f16039n;
    }

    public void setDividerColor(int i) {
        this.f16040o = i;
        invalidate();
    }

    public void setDividerColorResource(int i) {
        this.f16040o = getResources().getColor(i);
        invalidate();
    }

    public int getDividerColor() {
        return this.f16040o;
    }

    public void setUnderlineHeight(int i) {
        this.f16045t = i;
        invalidate();
    }

    public int getUnderlineHeight() {
        return this.f16045t;
    }

    public void setDividerPadding(int i) {
        this.f16046u = i;
        invalidate();
    }

    public int getDividerPadding() {
        return this.f16046u;
    }

    public void setScrollOffset(int i) {
        this.f16043r = i;
        invalidate();
    }

    public int getScrollOffset() {
        return this.f16043r;
    }

    public void setShouldExpand(boolean z) {
        this.f16041p = z;
        requestLayout();
    }

    public boolean getShouldExpand() {
        return this.f16041p;
    }

    public void setAllCaps(boolean z) {
        this.f16042q = z;
    }

    public void setTextSize(int i) {
        this.f16049x = i;
        m4762b();
    }

    public int getTextSize() {
        return this.f16049x;
    }

    public void setTextColor(int i) {
        this.f16050y = i;
        m4762b();
    }

    public void setTextColorResource(int i) {
        this.f16050y = getResources().getColor(i);
        m4762b();
    }

    public int getTextColor() {
        return this.f16050y;
    }

    public void setTabBackground(int i) {
        this.f16025C = i;
    }

    public int getTabBackground() {
        return this.f16025C;
    }

    public void setTabPaddingLeftRight(int i) {
        this.f16047v = i;
        m4762b();
    }

    public int getTabPaddingLeftRight() {
        return this.f16047v;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f16034i = savedState.f16052a;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f16052a = this.f16034i;
        return savedState;
    }

    /* loaded from: classes.dex */
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C2916o();

        /* renamed from: a */
        int f16052a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ SavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f16052a = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f16052a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m4763a(PagerSlidingTabStrip pagerSlidingTabStrip, int i, int i2) {
        if (pagerSlidingTabStrip.f16033h != 0) {
            int left = pagerSlidingTabStrip.f16031f.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= pagerSlidingTabStrip.f16043r;
            }
            if (left != pagerSlidingTabStrip.f16024B) {
                pagerSlidingTabStrip.f16024B = left;
                pagerSlidingTabStrip.scrollTo(left, 0);
            }
        }
    }
}
