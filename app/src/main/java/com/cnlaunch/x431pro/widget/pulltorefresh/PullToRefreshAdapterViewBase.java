package com.cnlaunch.x431pro.widget.pulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase;
import com.cnlaunch.x431pro.widget.pulltorefresh.p292a.EmptyViewMethodAccessor;
import com.cnlaunch.x431pro.widget.pulltorefresh.p292a.IndicatorLayout;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.widget.pulltorefresh.e */
/* loaded from: classes.dex */
public abstract class PullToRefreshAdapterViewBase<T extends AbsListView> extends PullToRefreshBase<T> implements AbsListView.OnScrollListener {

    /* renamed from: d */
    private boolean f16683d;

    /* renamed from: e */
    private AbsListView.OnScrollListener f16684e;

    /* renamed from: f */
    private PullToRefreshBase.InterfaceC2934c f16685f;

    /* renamed from: g */
    private View f16686g;

    /* renamed from: h */
    private IndicatorLayout f16687h;

    /* renamed from: i */
    private IndicatorLayout f16688i;

    /* renamed from: j */
    private boolean f16689j;

    /* renamed from: k */
    private boolean f16690k;

    public PullToRefreshAdapterViewBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16690k = true;
        ((AbsListView) this.f16693b).setOnScrollListener(this);
    }

    public boolean getShowIndicator() {
        return this.f16689j;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f16685f != null) {
            this.f16683d = i3 > 0 && i + i2 >= i3 + (-1);
        }
        if (getShowIndicatorInternal()) {
            m4447m();
        }
        AbsListView.OnScrollListener onScrollListener = this.f16684e;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        AbsListView.OnScrollListener onScrollListener = this.f16684e;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
    }

    public void setAdapter(ListAdapter listAdapter) {
        ((AdapterView) this.f16693b).setAdapter(listAdapter);
    }

    public final void setEmptyView(View view) {
        FrameLayout refreshableViewWrapper = getRefreshableViewWrapper();
        if (view != null) {
            view.setClickable(true);
            ViewParent parent = view.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(view);
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = null;
            if (layoutParams != null) {
                layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    layoutParams2.gravity = ((LinearLayout.LayoutParams) layoutParams).gravity;
                } else {
                    layoutParams2.gravity = 17;
                }
            }
            if (layoutParams2 != null) {
                refreshableViewWrapper.addView(view, layoutParams2);
            } else {
                refreshableViewWrapper.addView(view);
            }
        }
        if (this.f16693b instanceof EmptyViewMethodAccessor) {
            ((EmptyViewMethodAccessor) this.f16693b).setEmptyViewInternal(view);
        } else {
            ((AbsListView) this.f16693b).setEmptyView(view);
        }
        this.f16686g = view;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        ((AbsListView) this.f16693b).setOnItemClickListener(onItemClickListener);
    }

    public final void setOnLastItemVisibleListener(PullToRefreshBase.InterfaceC2934c interfaceC2934c) {
        this.f16685f = interfaceC2934c;
    }

    public final void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f16684e = onScrollListener;
    }

    public final void setScrollEmptyView(boolean z) {
        this.f16690k = z;
    }

    public void setShowIndicator(boolean z) {
        this.f16689j = z;
        if (getShowIndicatorInternal()) {
            m4449k();
        } else {
            m4448l();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase
    /* renamed from: a */
    public final void mo4446a() {
        super.mo4446a();
        if (getShowIndicatorInternal()) {
            switch (getCurrentMode()) {
                case PULL_FROM_END:
                    this.f16688i.m4467e();
                    return;
                case PULL_FROM_START:
                    this.f16687h.m4467e();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase
    /* renamed from: a */
    public void mo4438a(boolean z) {
        super.mo4438a(z);
        if (getShowIndicatorInternal()) {
            m4447m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase
    /* renamed from: b */
    public final void mo4436b() {
        super.mo4436b();
        if (getShowIndicatorInternal()) {
            switch (getCurrentMode()) {
                case PULL_FROM_END:
                    this.f16688i.m4468d();
                    return;
                case PULL_FROM_START:
                    this.f16687h.m4468d();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase
    /* renamed from: c */
    public void mo4434c() {
        super.mo4434c();
        if (getShowIndicatorInternal()) {
            m4447m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase
    /* renamed from: a */
    public void mo4441a(TypedArray typedArray) {
        this.f16689j = typedArray.getBoolean(17, !m4430g());
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        View view = this.f16686g;
        if (view == null || this.f16690k) {
            return;
        }
        view.scrollTo(-i, -i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase
    /* renamed from: f */
    public final void mo4431f() {
        super.mo4431f();
        if (getShowIndicatorInternal()) {
            m4449k();
        } else {
            m4448l();
        }
    }

    /* renamed from: k */
    private void m4449k() {
        IndicatorLayout indicatorLayout;
        IndicatorLayout indicatorLayout2;
        PullToRefreshBase.EnumC2933b mode = getMode();
        FrameLayout refreshableViewWrapper = getRefreshableViewWrapper();
        if (mode.showHeaderLoadingLayout() && this.f16687h == null) {
            this.f16687h = new IndicatorLayout(getContext(), PullToRefreshBase.EnumC2933b.PULL_FROM_START);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.indicator_right_padding);
            layoutParams.gravity = 53;
            refreshableViewWrapper.addView(this.f16687h, layoutParams);
        } else if (!mode.showHeaderLoadingLayout() && (indicatorLayout = this.f16687h) != null) {
            refreshableViewWrapper.removeView(indicatorLayout);
            this.f16687h = null;
        }
        if (mode.showFooterLoadingLayout() && this.f16688i == null) {
            this.f16688i = new IndicatorLayout(getContext(), PullToRefreshBase.EnumC2933b.PULL_FROM_END);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.rightMargin = getResources().getDimensionPixelSize(R.dimen.indicator_right_padding);
            layoutParams2.gravity = 85;
            refreshableViewWrapper.addView(this.f16688i, layoutParams2);
        } else if (mode.showFooterLoadingLayout() || (indicatorLayout2 = this.f16688i) == null) {
        } else {
            refreshableViewWrapper.removeView(indicatorLayout2);
            this.f16688i = null;
        }
    }

    private boolean getShowIndicatorInternal() {
        return this.f16689j && this.f16692a.permitsPullToRefresh();
    }

    /* renamed from: l */
    private void m4448l() {
        if (this.f16687h != null) {
            getRefreshableViewWrapper().removeView(this.f16687h);
            this.f16687h = null;
        }
        if (this.f16688i != null) {
            getRefreshableViewWrapper().removeView(this.f16688i);
            this.f16688i = null;
        }
    }

    /* renamed from: m */
    private void m4447m() {
        if (this.f16687h != null) {
            if (!m4429h() && mo4433d()) {
                if (!this.f16687h.m4471a()) {
                    this.f16687h.m4469c();
                }
            } else if (this.f16687h.m4471a()) {
                this.f16687h.m4470b();
            }
        }
        if (this.f16688i != null) {
            if (!m4429h() && mo4432e()) {
                if (this.f16688i.m4471a()) {
                    return;
                }
                this.f16688i.m4469c();
            } else if (this.f16688i.m4471a()) {
                this.f16688i.m4470b();
            }
        }
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase
    /* renamed from: d */
    protected final boolean mo4433d() {
        View childAt;
        Adapter adapter = ((AbsListView) this.f16693b).getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        return ((AbsListView) this.f16693b).getFirstVisiblePosition() <= 1 && (childAt = ((AbsListView) this.f16693b).getChildAt(0)) != null && childAt.getTop() >= ((AbsListView) this.f16693b).getTop();
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase
    /* renamed from: e */
    protected final boolean mo4432e() {
        Adapter adapter = ((AbsListView) this.f16693b).getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        int lastVisiblePosition = ((AbsListView) this.f16693b).getLastVisiblePosition();
        if (lastVisiblePosition >= (((AbsListView) this.f16693b).getCount() - 1) - 1) {
            View childAt = ((AbsListView) this.f16693b).getChildAt(lastVisiblePosition - ((AbsListView) this.f16693b).getFirstVisiblePosition());
            return childAt != null && childAt.getBottom() <= ((AbsListView) this.f16693b).getBottom();
        }
        return false;
    }
}
