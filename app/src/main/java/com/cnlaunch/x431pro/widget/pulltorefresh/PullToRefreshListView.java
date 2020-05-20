package com.cnlaunch.x431pro.widget.pulltorefresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase;
import com.cnlaunch.x431pro.widget.pulltorefresh.p292a.EmptyViewMethodAccessor;
import com.cnlaunch.x431pro.widget.pulltorefresh.p292a.LoadingLayout;

/* loaded from: classes.dex */
public class PullToRefreshListView extends PullToRefreshAdapterViewBase<ListView> {

    /* renamed from: d */
    private LoadingLayout f16646d;

    /* renamed from: e */
    private LoadingLayout f16647e;

    /* renamed from: f */
    private FrameLayout f16648f;

    /* renamed from: g */
    private boolean f16649g;

    public PullToRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase
    public final PullToRefreshBase.EnumC2939h getPullToRefreshScrollDirection() {
        return PullToRefreshBase.EnumC2939h.VERTICAL;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshAdapterViewBase, com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase
    /* renamed from: a */
    public final void mo4438a(boolean z) {
        LoadingLayout footerLayout;
        LoadingLayout loadingLayout;
        LoadingLayout loadingLayout2;
        int count;
        int scrollY;
        ListAdapter adapter = ((ListView) this.f16693b).getAdapter();
        if (!this.f16649g || !getShowViewWhileRefreshing() || adapter == null || adapter.isEmpty()) {
            super.mo4438a(z);
            return;
        }
        super.mo4438a(false);
        switch (C2945k.f16735a[getCurrentMode().ordinal()]) {
            case 1:
            case 2:
                footerLayout = getFooterLayout();
                loadingLayout = this.f16647e;
                loadingLayout2 = this.f16646d;
                count = ((ListView) this.f16693b).getCount() - 1;
                scrollY = getScrollY() - getFooterSize();
                break;
            default:
                footerLayout = getHeaderLayout();
                loadingLayout = this.f16646d;
                loadingLayout2 = this.f16647e;
                scrollY = getHeaderSize() + getScrollY();
                count = 0;
                break;
        }
        footerLayout.m4461i();
        footerLayout.m4465e();
        loadingLayout2.setVisibility(8);
        loadingLayout.setVisibility(0);
        loadingLayout.m4463g();
        if (z) {
            this.f16694c = false;
            setHeaderScroll(scrollY);
            ((ListView) this.f16693b).setSelection(count);
            m4427j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshAdapterViewBase, com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase
    /* renamed from: c */
    public final void mo4434c() {
        LoadingLayout footerLayout;
        LoadingLayout loadingLayout;
        int count;
        int footerSize;
        if (!this.f16649g) {
            super.mo4434c();
            return;
        }
        boolean z = false;
        switch (C2945k.f16735a[getCurrentMode().ordinal()]) {
            case 1:
            case 2:
                footerLayout = getFooterLayout();
                loadingLayout = this.f16647e;
                count = ((ListView) this.f16693b).getCount() - 1;
                footerSize = getFooterSize();
                if (Math.abs(((ListView) this.f16693b).getLastVisiblePosition() - count) <= 1) {
                    z = true;
                    break;
                }
                break;
            default:
                footerLayout = getHeaderLayout();
                loadingLayout = this.f16646d;
                footerSize = -getHeaderSize();
                z = Math.abs(((ListView) this.f16693b).getFirstVisiblePosition() - 0) <= 1;
                count = 0;
                break;
        }
        if (loadingLayout.getVisibility() == 0) {
            footerLayout.m4460j();
            loadingLayout.setVisibility(8);
            if (z && getState() != PullToRefreshBase.EnumC2941j.MANUAL_REFRESHING) {
                ((ListView) this.f16693b).setSelection(count);
                setHeaderScroll(footerSize);
            }
        }
        super.mo4434c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase
    /* renamed from: a */
    public final LoadingLayoutProxy mo4437a(boolean z, boolean z2) {
        LoadingLayoutProxy a = super.mo4437a(z, z2);
        if (this.f16649g) {
            PullToRefreshBase.EnumC2933b mode = getMode();
            if (z && mode.showHeaderLoadingLayout()) {
                a.m4452a(this.f16646d);
            }
            if (z2 && mode.showFooterLoadingLayout()) {
                a.m4452a(this.f16647e);
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshAdapterViewBase, com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase
    /* renamed from: a */
    public final void mo4441a(TypedArray typedArray) {
        super.mo4441a(typedArray);
        this.f16649g = typedArray.getBoolean(11, true);
        if (this.f16649g) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 1);
            FrameLayout frameLayout = new FrameLayout(getContext());
            this.f16646d = m4442a(getContext(), PullToRefreshBase.EnumC2933b.PULL_FROM_START, typedArray);
            this.f16646d.setVisibility(8);
            frameLayout.addView(this.f16646d, layoutParams);
            ((ListView) this.f16693b).addHeaderView(frameLayout, null, false);
            this.f16648f = new FrameLayout(getContext());
            this.f16647e = m4442a(getContext(), PullToRefreshBase.EnumC2933b.PULL_FROM_END, typedArray);
            this.f16647e.setVisibility(8);
            this.f16648f.addView(this.f16647e, layoutParams);
            if (typedArray.hasValue(16)) {
                return;
            }
            setScrollingWhileRefreshingEnabled(true);
        }
    }

    @TargetApi(9)
    /* renamed from: com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshListView$b */
    /* loaded from: classes.dex */
    final class C2925b extends C2924a {
        public C2925b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.view.View
        protected final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            OverscrollHelper.m4450a(PullToRefreshListView.this, i, i3, i2, i4, z);
            return overScrollBy;
        }
    }

    /* renamed from: com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshListView$a */
    /* loaded from: classes.dex */
    protected class C2924a extends ListView implements EmptyViewMethodAccessor {

        /* renamed from: b */
        private boolean f16651b;

        public C2924a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f16651b = false;
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            try {
                super.dispatchDraw(canvas);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            try {
                return super.dispatchTouchEvent(motionEvent);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override // android.widget.AdapterView
        public void setAdapter(ListAdapter listAdapter) {
            if (PullToRefreshListView.this.f16648f != null && !this.f16651b) {
                addFooterView(PullToRefreshListView.this.f16648f, null, false);
                this.f16651b = true;
            }
            super.setAdapter(listAdapter);
        }

        @Override // android.widget.AdapterView
        public void setEmptyView(View view) {
            PullToRefreshListView.this.setEmptyView(view);
        }

        @Override // com.cnlaunch.x431pro.widget.pulltorefresh.p292a.EmptyViewMethodAccessor
        public void setEmptyViewInternal(View view) {
            super.setEmptyView(view);
        }
    }

    public void setSelection(int i) {
        ((ListView) this.f16693b).setSelection(i);
    }

    public int getLastVisiblePosition() {
        return ((ListView) this.f16693b).getLastVisiblePosition();
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase
    /* renamed from: a */
    protected final /* synthetic */ View mo4443a(Context context, AttributeSet attributeSet) {
        ListView c2924a;
        if (Build.VERSION.SDK_INT >= 9) {
            c2924a = new C2925b(context, attributeSet);
        } else {
            c2924a = new C2924a(context, attributeSet);
        }
        c2924a.setId(16908298);
        return c2924a;
    }
}
