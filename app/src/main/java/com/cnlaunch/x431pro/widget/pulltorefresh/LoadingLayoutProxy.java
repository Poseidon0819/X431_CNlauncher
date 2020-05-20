package com.cnlaunch.x431pro.widget.pulltorefresh;

import android.graphics.drawable.Drawable;
import com.cnlaunch.x431pro.widget.pulltorefresh.p292a.LoadingLayout;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.cnlaunch.x431pro.widget.pulltorefresh.b */
/* loaded from: classes.dex */
public final class LoadingLayoutProxy implements ILoadingLayout {

    /* renamed from: a */
    private final HashSet<LoadingLayout> f16681a = new HashSet<>();

    /* renamed from: a */
    public final void m4452a(LoadingLayout loadingLayout) {
        if (loadingLayout != null) {
            this.f16681a.add(loadingLayout);
        }
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.ILoadingLayout
    public final void setLastUpdatedLabel(CharSequence charSequence) {
        Iterator<LoadingLayout> it = this.f16681a.iterator();
        while (it.hasNext()) {
            it.next().setLastUpdatedLabel(charSequence);
        }
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.ILoadingLayout
    public final void setLoadingDrawable(Drawable drawable) {
        Iterator<LoadingLayout> it = this.f16681a.iterator();
        while (it.hasNext()) {
            it.next().setLoadingDrawable(drawable);
        }
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.ILoadingLayout
    public final void setRefreshingLabel(CharSequence charSequence) {
        Iterator<LoadingLayout> it = this.f16681a.iterator();
        while (it.hasNext()) {
            it.next().setRefreshingLabel(charSequence);
        }
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.ILoadingLayout
    public final void setPullLabel(CharSequence charSequence) {
        Iterator<LoadingLayout> it = this.f16681a.iterator();
        while (it.hasNext()) {
            it.next().setPullLabel(charSequence);
        }
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.ILoadingLayout
    public final void setReleaseLabel(CharSequence charSequence) {
        Iterator<LoadingLayout> it = this.f16681a.iterator();
        while (it.hasNext()) {
            it.next().setReleaseLabel(charSequence);
        }
    }
}
