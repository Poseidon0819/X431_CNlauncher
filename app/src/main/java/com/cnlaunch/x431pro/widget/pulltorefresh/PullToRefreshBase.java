package com.cnlaunch.x431pro.widget.pulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.cnlaunch.x431pro.widget.pulltorefresh.p292a.C2929i;
import com.cnlaunch.x431pro.widget.pulltorefresh.p292a.FlipLoadingLayout;
import com.cnlaunch.x431pro.widget.pulltorefresh.p292a.LoadingLayout;
import com.cnlaunch.x431pro.widget.pulltorefresh.p292a.RotateLoadingLayout;
import com.ifoer.expedition.p348a.C3592a;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentParser;
import com.itextpdf.text.pdf.codec.TIFFConstants;

/* renamed from: com.cnlaunch.x431pro.widget.pulltorefresh.g */
/* loaded from: classes.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {

    /* renamed from: a */
    EnumC2933b f16692a;

    /* renamed from: b */
    T f16693b;

    /* renamed from: c */
    boolean f16694c;

    /* renamed from: d */
    private int f16695d;

    /* renamed from: e */
    private float f16696e;

    /* renamed from: f */
    private float f16697f;

    /* renamed from: g */
    private float f16698g;

    /* renamed from: h */
    private float f16699h;

    /* renamed from: i */
    private boolean f16700i;

    /* renamed from: j */
    private EnumC2941j f16701j;

    /* renamed from: k */
    private EnumC2933b f16702k;

    /* renamed from: l */
    private FrameLayout f16703l;

    /* renamed from: m */
    private boolean f16704m;

    /* renamed from: n */
    private boolean f16705n;

    /* renamed from: o */
    private boolean f16706o;

    /* renamed from: p */
    private boolean f16707p;

    /* renamed from: q */
    private Interpolator f16708q;

    /* renamed from: r */
    private EnumC2932a f16709r;

    /* renamed from: s */
    private LoadingLayout f16710s;

    /* renamed from: t */
    private LoadingLayout f16711t;

    /* renamed from: u */
    private InterfaceC2936e<T> f16712u;

    /* renamed from: v */
    private InterfaceC2937f<T> f16713v;

    /* renamed from: w */
    private InterfaceC2935d<T> f16714w;

    /* renamed from: x */
    private PullToRefreshBase<T>.RunnableC2940i f16715x;

    /* compiled from: PullToRefreshBase.java */
    /* renamed from: com.cnlaunch.x431pro.widget.pulltorefresh.g$c */
    /* loaded from: classes.dex */
    public interface InterfaceC2934c {
    }

    /* compiled from: PullToRefreshBase.java */
    /* renamed from: com.cnlaunch.x431pro.widget.pulltorefresh.g$d */
    /* loaded from: classes.dex */
    public interface InterfaceC2935d<V extends View> {
    }

    /* compiled from: PullToRefreshBase.java */
    /* renamed from: com.cnlaunch.x431pro.widget.pulltorefresh.g$e */
    /* loaded from: classes.dex */
    public interface InterfaceC2936e<V extends View> {
        /* renamed from: f_ */
        void mo4423f_();
    }

    /* compiled from: PullToRefreshBase.java */
    /* renamed from: com.cnlaunch.x431pro.widget.pulltorefresh.g$f */
    /* loaded from: classes.dex */
    public interface InterfaceC2937f<V extends View> {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PullToRefreshBase.java */
    /* renamed from: com.cnlaunch.x431pro.widget.pulltorefresh.g$g */
    /* loaded from: classes.dex */
    public interface InterfaceC2938g {
        /* renamed from: a */
        void mo4421a();
    }

    /* compiled from: PullToRefreshBase.java */
    /* renamed from: com.cnlaunch.x431pro.widget.pulltorefresh.g$h */
    /* loaded from: classes.dex */
    public enum EnumC2939h {
        VERTICAL,
        HORIZONTAL
    }

    /* renamed from: a */
    protected abstract T mo4443a(Context context, AttributeSet attributeSet);

    /* renamed from: a */
    protected void mo4441a(TypedArray typedArray) {
    }

    /* renamed from: d */
    protected abstract boolean mo4433d();

    /* renamed from: e */
    protected abstract boolean mo4432e();

    public abstract EnumC2939h getPullToRefreshScrollDirection();

    protected int getPullToRefreshScrollDuration() {
        return PdfContentParser.COMMAND_TYPE;
    }

    protected int getPullToRefreshScrollDurationLonger() {
        return TIFFConstants.TIFFTAG_TILEBYTECOUNTS;
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16700i = false;
        this.f16701j = EnumC2941j.RESET;
        this.f16692a = EnumC2933b.getDefault();
        this.f16704m = true;
        this.f16705n = false;
        this.f16706o = true;
        this.f16707p = true;
        this.f16694c = true;
        this.f16709r = EnumC2932a.getDefault();
        if (C2944j.f16731a[getPullToRefreshScrollDirection().ordinal()] == 1) {
            setOrientation(0);
        } else {
            setOrientation(1);
        }
        setGravity(17);
        this.f16695d = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3592a.C3593a.PullToRefresh);
        if (obtainStyledAttributes.hasValue(12)) {
            this.f16692a = EnumC2933b.mapIntToValue(obtainStyledAttributes.getInteger(12, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.f16709r = EnumC2932a.mapIntToValue(obtainStyledAttributes.getInteger(1, 0));
        }
        this.f16693b = mo4443a(context, attributeSet);
        T t = this.f16693b;
        this.f16703l = new FrameLayout(context);
        this.f16703l.addView(t, -1, -1);
        super.addView(this.f16703l, -1, new LinearLayout.LayoutParams(-1, -1));
        this.f16710s = m4442a(context, EnumC2933b.PULL_FROM_START, obtainStyledAttributes);
        this.f16711t = m4442a(context, EnumC2933b.PULL_FROM_END, obtainStyledAttributes);
        if (obtainStyledAttributes.hasValue(14)) {
            Drawable drawable = obtainStyledAttributes.getDrawable(14);
            if (drawable != null) {
                this.f16693b.setBackgroundDrawable(drawable);
            }
        } else if (obtainStyledAttributes.hasValue(0)) {
            C2929i.m4453a("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
            Drawable drawable2 = obtainStyledAttributes.getDrawable(0);
            if (drawable2 != null) {
                this.f16693b.setBackgroundDrawable(drawable2);
            }
        }
        if (obtainStyledAttributes.hasValue(13)) {
            this.f16707p = obtainStyledAttributes.getBoolean(13, true);
        }
        if (obtainStyledAttributes.hasValue(16)) {
            this.f16705n = obtainStyledAttributes.getBoolean(16, false);
        }
        mo4441a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        mo4431f();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        T refreshableView = getRefreshableView();
        if (refreshableView instanceof ViewGroup) {
            ((ViewGroup) refreshableView).addView(view, i, layoutParams);
            return;
        }
        throw new UnsupportedOperationException("Refreshable View is not a ViewGroup so can't addView");
    }

    public final EnumC2933b getCurrentMode() {
        return this.f16702k;
    }

    public final boolean getFilterTouchEvents() {
        return this.f16706o;
    }

    public final EnumC2933b getMode() {
        return this.f16692a;
    }

    public final T getRefreshableView() {
        return this.f16693b;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.f16704m;
    }

    public final EnumC2941j getState() {
        return this.f16701j;
    }

    /* renamed from: g */
    public final boolean m4430g() {
        return Build.VERSION.SDK_INT >= 9 && this.f16707p && OverscrollHelper.m4451a(this.f16693b);
    }

    /* renamed from: h */
    public final boolean m4429h() {
        return this.f16701j == EnumC2941j.REFRESHING || this.f16701j == EnumC2941j.MANUAL_REFRESHING;
    }

    /* renamed from: i */
    public final void m4428i() {
        m4440a(EnumC2941j.RESET, new boolean[0]);
    }

    public final void setScrollingWhileRefreshingEnabled(boolean z) {
        this.f16705n = z;
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        setScrollingWhileRefreshingEnabled(!z);
    }

    public final void setFilterTouchEvents(boolean z) {
        this.f16706o = z;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setLastUpdatedLabel(charSequence);
    }

    public void setLoadingDrawable(Drawable drawable) {
        getLoadingLayoutProxy().setLoadingDrawable(drawable);
    }

    @Override // android.view.View
    public void setLongClickable(boolean z) {
        getRefreshableView().setLongClickable(z);
    }

    public final void setMode(EnumC2933b enumC2933b) {
        if (enumC2933b != this.f16692a) {
            this.f16692a = enumC2933b;
            mo4431f();
        }
    }

    public void setOnPullEventListener(InterfaceC2935d<T> interfaceC2935d) {
        this.f16714w = interfaceC2935d;
    }

    public final void setOnRefreshListener(InterfaceC2936e<T> interfaceC2936e) {
        this.f16712u = interfaceC2936e;
        this.f16713v = null;
    }

    public final void setOnRefreshListener(InterfaceC2937f<T> interfaceC2937f) {
        this.f16713v = interfaceC2937f;
        this.f16712u = null;
    }

    public void setPullLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setPullLabel(charSequence);
    }

    public final void setPullToRefreshEnabled(boolean z) {
        setMode(z ? EnumC2933b.getDefault() : EnumC2933b.DISABLED);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        this.f16707p = z;
    }

    public final void setRefreshing(boolean z) {
        if (m4429h()) {
            return;
        }
        m4440a(EnumC2941j.MANUAL_REFRESHING, z);
    }

    public void setRefreshingLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setRefreshingLabel(charSequence);
    }

    public void setReleaseLabel(CharSequence charSequence) {
        EnumC2933b enumC2933b = EnumC2933b.BOTH;
        mo4437a(enumC2933b.showHeaderLoadingLayout(), enumC2933b.showFooterLoadingLayout()).setReleaseLabel(charSequence);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.f16708q = interpolator;
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        this.f16704m = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m4440a(EnumC2941j enumC2941j, boolean... zArr) {
        this.f16701j = enumC2941j;
        switch (C2944j.f16732b[this.f16701j.ordinal()]) {
            case 1:
                mo4434c();
                return;
            case 2:
                mo4446a();
                return;
            case 3:
                mo4436b();
                return;
            case 4:
            case 5:
                mo4438a(zArr[0]);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final LoadingLayout m4442a(Context context, EnumC2933b enumC2933b, TypedArray typedArray) {
        LoadingLayout createLoadingLayout = this.f16709r.createLoadingLayout(context, enumC2933b, getPullToRefreshScrollDirection(), typedArray);
        createLoadingLayout.setVisibility(4);
        return createLoadingLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public LoadingLayoutProxy mo4437a(boolean z, boolean z2) {
        LoadingLayoutProxy loadingLayoutProxy = new LoadingLayoutProxy();
        if (z && this.f16692a.showHeaderLoadingLayout()) {
            loadingLayoutProxy.m4452a(this.f16710s);
        }
        if (z2 && this.f16692a.showFooterLoadingLayout()) {
            loadingLayoutProxy.m4452a(this.f16711t);
        }
        return loadingLayoutProxy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LoadingLayout getFooterLayout() {
        return this.f16711t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getFooterSize() {
        return this.f16711t.getContentSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LoadingLayout getHeaderLayout() {
        return this.f16710s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getHeaderSize() {
        return this.f16710s.getContentSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FrameLayout getRefreshableViewWrapper() {
        return this.f16703l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4446a() {
        switch (C2944j.f16733c[this.f16702k.ordinal()]) {
            case 1:
                this.f16711t.m4464f();
                return;
            case 2:
                this.f16710s.m4464f();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4438a(boolean z) {
        if (this.f16692a.showHeaderLoadingLayout()) {
            this.f16710s.m4463g();
        }
        if (this.f16692a.showFooterLoadingLayout()) {
            this.f16711t.m4463g();
        }
        if (z) {
            if (this.f16704m) {
                C2942h c2942h = new C2942h(this);
                int i = C2944j.f16733c[this.f16702k.ordinal()];
                if (i == 1 || i == 3) {
                    m4444a(getFooterSize(), c2942h);
                    return;
                } else {
                    m4444a(-getHeaderSize(), c2942h);
                    return;
                }
            }
            m4427j();
            return;
        }
        m4425l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void mo4436b() {
        switch (C2944j.f16733c[this.f16702k.ordinal()]) {
            case 1:
                this.f16711t.m4462h();
                return;
            case 2:
                this.f16710s.m4462h();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void mo4434c() {
        this.f16700i = false;
        this.f16694c = true;
        this.f16710s.m4461i();
        this.f16711t.m4461i();
        m4427j();
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(EnumC2933b.mapIntToValue(bundle.getInt("ptr_mode", 0)));
            this.f16702k = EnumC2933b.mapIntToValue(bundle.getInt("ptr_current_mode", 0));
            this.f16705n = bundle.getBoolean("ptr_disable_scrolling", false);
            this.f16704m = bundle.getBoolean("ptr_show_refreshing_view", true);
            super.onRestoreInstanceState(bundle.getParcelable("ptr_super"));
            EnumC2941j mapIntToValue = EnumC2941j.mapIntToValue(bundle.getInt("ptr_state", 0));
            if (mapIntToValue == EnumC2941j.REFRESHING || mapIntToValue == EnumC2941j.MANUAL_REFRESHING) {
                m4440a(mapIntToValue, true);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putInt("ptr_state", this.f16701j.getIntValue());
        bundle.putInt("ptr_mode", this.f16692a.getIntValue());
        bundle.putInt("ptr_current_mode", this.f16702k.getIntValue());
        bundle.putBoolean("ptr_disable_scrolling", this.f16705n);
        bundle.putBoolean("ptr_show_refreshing_view", this.f16704m);
        bundle.putParcelable("ptr_super", super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m4426k();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f16703l.getLayoutParams();
        switch (C2944j.f16731a[getPullToRefreshScrollDirection().ordinal()]) {
            case 1:
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                    this.f16703l.requestLayout();
                    break;
                }
                break;
            case 2:
                if (layoutParams.height != i2) {
                    layoutParams.height = i2;
                    this.f16703l.requestLayout();
                    break;
                }
                break;
        }
        post(new RunnableC2943i(this));
    }

    /* renamed from: k */
    private void m4426k() {
        int maximumPullScroll = (int) (getMaximumPullScroll() * 1.2f);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        switch (C2944j.f16731a[getPullToRefreshScrollDirection().ordinal()]) {
            case 1:
                if (this.f16692a.showHeaderLoadingLayout()) {
                    this.f16710s.setWidth(maximumPullScroll);
                    paddingLeft = -maximumPullScroll;
                } else {
                    paddingLeft = 0;
                }
                if (!this.f16692a.showFooterLoadingLayout()) {
                    paddingRight = 0;
                    break;
                } else {
                    this.f16711t.setWidth(maximumPullScroll);
                    paddingRight = -maximumPullScroll;
                    break;
                }
            case 2:
                if (this.f16692a.showHeaderLoadingLayout()) {
                    this.f16710s.setHeight(maximumPullScroll);
                    paddingTop = -maximumPullScroll;
                } else {
                    paddingTop = 0;
                }
                if (!this.f16692a.showFooterLoadingLayout()) {
                    paddingBottom = 0;
                    break;
                } else {
                    this.f16711t.setHeight(maximumPullScroll);
                    paddingBottom = -maximumPullScroll;
                    break;
                }
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setHeaderScroll(int i) {
        int maximumPullScroll = getMaximumPullScroll();
        int min = Math.min(maximumPullScroll, Math.max(-maximumPullScroll, i));
        if (this.f16694c) {
            if (min < 0) {
                this.f16710s.setVisibility(0);
            } else if (min > 0) {
                this.f16711t.setVisibility(0);
            } else {
                this.f16710s.setVisibility(4);
                this.f16711t.setVisibility(4);
            }
        }
        switch (C2944j.f16731a[getPullToRefreshScrollDirection().ordinal()]) {
            case 1:
                scrollTo(min, 0);
                return;
            case 2:
                scrollTo(0, min);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: j */
    public final void m4427j() {
        m4445a(0, getPullToRefreshScrollDuration(), (InterfaceC2938g) null);
    }

    /* renamed from: a */
    private void m4444a(int i, InterfaceC2938g interfaceC2938g) {
        m4445a(i, getPullToRefreshScrollDuration(), interfaceC2938g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public void mo4431f() {
        LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.f16710s.getParent()) {
            removeView(this.f16710s);
        }
        if (this.f16692a.showHeaderLoadingLayout()) {
            super.addView(this.f16710s, 0, loadingLayoutLayoutParams);
        }
        if (this == this.f16711t.getParent()) {
            removeView(this.f16711t);
        }
        if (this.f16692a.showFooterLoadingLayout()) {
            super.addView(this.f16711t, -1, loadingLayoutLayoutParams);
        }
        m4426k();
        this.f16702k = this.f16692a != EnumC2933b.BOTH ? this.f16692a : EnumC2933b.PULL_FROM_START;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m4425l() {
        InterfaceC2936e<T> interfaceC2936e = this.f16712u;
        if (interfaceC2936e != null) {
            interfaceC2936e.mo4423f_();
        } else if (this.f16713v == null || this.f16702k == EnumC2933b.PULL_FROM_START) {
        } else {
            EnumC2933b enumC2933b = EnumC2933b.PULL_FROM_END;
        }
    }

    /* renamed from: m */
    private boolean m4424m() {
        int i = C2944j.f16733c[this.f16692a.ordinal()];
        if (i == 4) {
            return mo4432e() || mo4433d();
        }
        switch (i) {
            case 1:
                return mo4432e();
            case 2:
                return mo4433d();
            default:
                return false;
        }
    }

    private LinearLayout.LayoutParams getLoadingLayoutLayoutParams() {
        if (C2944j.f16731a[getPullToRefreshScrollDirection().ordinal()] == 1) {
            return new LinearLayout.LayoutParams(-2, -1);
        }
        return new LinearLayout.LayoutParams(-1, -2);
    }

    private int getMaximumPullScroll() {
        if (C2944j.f16731a[getPullToRefreshScrollDirection().ordinal()] == 1) {
            return Math.round(getWidth() / 2.0f);
        }
        return Math.round(getHeight() / 2.0f);
    }

    /* renamed from: a */
    private final void m4445a(int i, long j, InterfaceC2938g interfaceC2938g) {
        int scrollX;
        PullToRefreshBase<T>.RunnableC2940i runnableC2940i = this.f16715x;
        if (runnableC2940i != null) {
            runnableC2940i.m4422a();
        }
        if (C2944j.f16731a[getPullToRefreshScrollDirection().ordinal()] == 1) {
            scrollX = getScrollX();
        } else {
            scrollX = getScrollY();
        }
        if (scrollX != i) {
            if (this.f16708q == null) {
                this.f16708q = new DecelerateInterpolator();
            }
            this.f16715x = new RunnableC2940i(scrollX, i, j, interfaceC2938g);
            post(this.f16715x);
        }
    }

    /* compiled from: PullToRefreshBase.java */
    /* renamed from: com.cnlaunch.x431pro.widget.pulltorefresh.g$a */
    /* loaded from: classes.dex */
    public enum EnumC2932a {
        ROTATE,
        FLIP;

        static EnumC2932a getDefault() {
            return ROTATE;
        }

        static EnumC2932a mapIntToValue(int i) {
            if (i != 1) {
                return ROTATE;
            }
            return FLIP;
        }

        final LoadingLayout createLoadingLayout(Context context, EnumC2933b enumC2933b, EnumC2939h enumC2939h, TypedArray typedArray) {
            if (C2944j.f16734d[ordinal()] != 2) {
                return new RotateLoadingLayout(context, enumC2933b, enumC2939h, typedArray);
            }
            return new FlipLoadingLayout(context, enumC2933b, enumC2939h, typedArray);
        }
    }

    /* compiled from: PullToRefreshBase.java */
    /* renamed from: com.cnlaunch.x431pro.widget.pulltorefresh.g$b */
    /* loaded from: classes.dex */
    public enum EnumC2933b {
        DISABLED(0),
        PULL_FROM_START(1),
        PULL_FROM_END(2),
        BOTH(3),
        MANUAL_REFRESH_ONLY(4);
        
        public static EnumC2933b PULL_DOWN_TO_REFRESH;
        public static EnumC2933b PULL_UP_TO_REFRESH;
        private int mIntValue;

        static {
            EnumC2933b enumC2933b = PULL_FROM_START;
            EnumC2933b enumC2933b2 = PULL_FROM_END;
            PULL_DOWN_TO_REFRESH = enumC2933b;
            PULL_UP_TO_REFRESH = enumC2933b2;
        }

        static EnumC2933b mapIntToValue(int i) {
            EnumC2933b[] values;
            for (EnumC2933b enumC2933b : values()) {
                if (i == enumC2933b.getIntValue()) {
                    return enumC2933b;
                }
            }
            return getDefault();
        }

        static EnumC2933b getDefault() {
            return PULL_FROM_START;
        }

        EnumC2933b(int i) {
            this.mIntValue = i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean permitsPullToRefresh() {
            return (this == DISABLED || this == MANUAL_REFRESH_ONLY) ? false : true;
        }

        public final boolean showHeaderLoadingLayout() {
            return this == PULL_FROM_START || this == BOTH;
        }

        public final boolean showFooterLoadingLayout() {
            return this == PULL_FROM_END || this == BOTH || this == MANUAL_REFRESH_ONLY;
        }

        final int getIntValue() {
            return this.mIntValue;
        }
    }

    /* compiled from: PullToRefreshBase.java */
    /* renamed from: com.cnlaunch.x431pro.widget.pulltorefresh.g$j */
    /* loaded from: classes.dex */
    public enum EnumC2941j {
        RESET(0),
        PULL_TO_REFRESH(1),
        RELEASE_TO_REFRESH(2),
        REFRESHING(8),
        MANUAL_REFRESHING(9),
        OVERSCROLLING(16);
        
        private int mIntValue;

        static EnumC2941j mapIntToValue(int i) {
            EnumC2941j[] values;
            for (EnumC2941j enumC2941j : values()) {
                if (i == enumC2941j.getIntValue()) {
                    return enumC2941j;
                }
            }
            return RESET;
        }

        EnumC2941j(int i) {
            this.mIntValue = i;
        }

        final int getIntValue() {
            return this.mIntValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PullToRefreshBase.java */
    /* renamed from: com.cnlaunch.x431pro.widget.pulltorefresh.g$i */
    /* loaded from: classes.dex */
    public final class RunnableC2940i implements Runnable {

        /* renamed from: b */
        private final Interpolator f16720b;

        /* renamed from: c */
        private final int f16721c;

        /* renamed from: d */
        private final int f16722d;

        /* renamed from: e */
        private final long f16723e;

        /* renamed from: f */
        private InterfaceC2938g f16724f;

        /* renamed from: g */
        private boolean f16725g = true;

        /* renamed from: h */
        private long f16726h = -1;

        /* renamed from: i */
        private int f16727i = -1;

        public RunnableC2940i(int i, int i2, long j, InterfaceC2938g interfaceC2938g) {
            this.f16722d = i;
            this.f16721c = i2;
            this.f16720b = PullToRefreshBase.this.f16708q;
            this.f16723e = j;
            this.f16724f = interfaceC2938g;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f16726h == -1) {
                this.f16726h = System.currentTimeMillis();
            } else {
                this.f16727i = this.f16722d - Math.round((this.f16722d - this.f16721c) * this.f16720b.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.f16726h) * 1000) / this.f16723e, 1000L), 0L)) / 1000.0f));
                PullToRefreshBase.this.setHeaderScroll(this.f16727i);
            }
            if (this.f16725g && this.f16721c != this.f16727i) {
                PullToRefreshBase pullToRefreshBase = PullToRefreshBase.this;
                if (Build.VERSION.SDK_INT < 16) {
                    pullToRefreshBase.postDelayed(this, 16L);
                    return;
                } else {
                    pullToRefreshBase.postOnAnimation(this);
                    return;
                }
            }
            InterfaceC2938g interfaceC2938g = this.f16724f;
            if (interfaceC2938g != null) {
                interfaceC2938g.mo4421a();
            }
        }

        /* renamed from: a */
        public final void m4422a() {
            this.f16725g = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }
    }

    public final ILoadingLayout getLoadingLayoutProxy() {
        return mo4437a(true, true);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (this.f16692a.permitsPullToRefresh()) {
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.f16700i = false;
                return false;
            } else if (action == 0 || !this.f16700i) {
                if (action != 0) {
                    if (action == 2) {
                        if (!this.f16705n && m4429h()) {
                            return true;
                        }
                        if (m4424m()) {
                            float y = motionEvent.getY();
                            float x = motionEvent.getX();
                            if (C2944j.f16731a[getPullToRefreshScrollDirection().ordinal()] == 1) {
                                f = x - this.f16696e;
                                f2 = y - this.f16697f;
                            } else {
                                f = y - this.f16697f;
                                f2 = x - this.f16696e;
                            }
                            float abs = Math.abs(f);
                            if (abs > this.f16695d && (!this.f16706o || abs > Math.abs(f2))) {
                                if (this.f16692a.showHeaderLoadingLayout() && f >= 1.0f && mo4433d()) {
                                    this.f16697f = y;
                                    this.f16696e = x;
                                    this.f16700i = true;
                                    if (this.f16692a == EnumC2933b.BOTH) {
                                        this.f16702k = EnumC2933b.PULL_FROM_START;
                                    }
                                } else if (this.f16692a.showFooterLoadingLayout() && f <= -1.0f && mo4432e()) {
                                    this.f16697f = y;
                                    this.f16696e = x;
                                    this.f16700i = true;
                                    if (this.f16692a == EnumC2933b.BOTH) {
                                        this.f16702k = EnumC2933b.PULL_FROM_END;
                                    }
                                }
                            }
                        }
                    }
                } else if (m4424m()) {
                    float y2 = motionEvent.getY();
                    this.f16699h = y2;
                    this.f16697f = y2;
                    float x2 = motionEvent.getX();
                    this.f16698g = x2;
                    this.f16696e = x2;
                    this.f16700i = false;
                }
                return this.f16700i;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        int round;
        int footerSize;
        if (this.f16692a.permitsPullToRefresh()) {
            if (this.f16705n || !m4429h()) {
                if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            if (m4424m()) {
                                float y = motionEvent.getY();
                                this.f16699h = y;
                                this.f16697f = y;
                                float x = motionEvent.getX();
                                this.f16698g = x;
                                this.f16696e = x;
                                return true;
                            }
                            break;
                        case 1:
                        case 3:
                            if (this.f16700i) {
                                this.f16700i = false;
                                if (this.f16701j == EnumC2941j.RELEASE_TO_REFRESH && (this.f16712u != null || this.f16713v != null)) {
                                    m4440a(EnumC2941j.REFRESHING, true);
                                    return true;
                                } else if (m4429h()) {
                                    m4427j();
                                    return true;
                                } else {
                                    m4440a(EnumC2941j.RESET, new boolean[0]);
                                    return true;
                                }
                            }
                            break;
                        case 2:
                            if (this.f16700i) {
                                this.f16697f = motionEvent.getY();
                                this.f16696e = motionEvent.getX();
                                if (C2944j.f16731a[getPullToRefreshScrollDirection().ordinal()] == 1) {
                                    f = this.f16698g;
                                    f2 = this.f16696e;
                                } else {
                                    f = this.f16699h;
                                    f2 = this.f16697f;
                                }
                                if (C2944j.f16733c[this.f16702k.ordinal()] == 1) {
                                    round = Math.round(Math.max(f - f2, (float) ColumnText.GLOBAL_SPACE_CHAR_RATIO) / 2.0f);
                                    footerSize = getFooterSize();
                                } else {
                                    round = Math.round(Math.min(f - f2, (float) ColumnText.GLOBAL_SPACE_CHAR_RATIO) / 2.0f);
                                    footerSize = getHeaderSize();
                                }
                                setHeaderScroll(round);
                                if (round != 0 && !m4429h()) {
                                    float abs = Math.abs(round) / footerSize;
                                    if (C2944j.f16733c[this.f16702k.ordinal()] == 1) {
                                        this.f16711t.m4466b(abs);
                                    } else {
                                        this.f16710s.m4466b(abs);
                                    }
                                    if (this.f16701j == EnumC2941j.RELEASE_TO_REFRESH) {
                                        if (Math.abs(round) <= footerSize) {
                                            m4440a(EnumC2941j.PULL_TO_REFRESH, new boolean[0]);
                                        }
                                    } else if (this.f16701j != EnumC2941j.PULL_TO_REFRESH && Math.abs(round) > 0) {
                                        m4440a(EnumC2941j.PULL_TO_REFRESH, new boolean[0]);
                                    } else if (this.f16701j == EnumC2941j.PULL_TO_REFRESH && Math.abs(round) > footerSize) {
                                        m4440a(EnumC2941j.RELEASE_TO_REFRESH, new boolean[0]);
                                    }
                                }
                                return true;
                            }
                            break;
                    }
                    return false;
                }
                return false;
            }
            return true;
        }
        return false;
    }
}
