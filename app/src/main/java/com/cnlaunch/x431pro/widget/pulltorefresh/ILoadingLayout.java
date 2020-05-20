package com.cnlaunch.x431pro.widget.pulltorefresh;

import android.graphics.drawable.Drawable;

/* renamed from: com.cnlaunch.x431pro.widget.pulltorefresh.a */
/* loaded from: classes.dex */
public interface ILoadingLayout {
    void setLastUpdatedLabel(CharSequence charSequence);

    void setLoadingDrawable(Drawable drawable);

    void setPullLabel(CharSequence charSequence);

    void setRefreshingLabel(CharSequence charSequence);

    void setReleaseLabel(CharSequence charSequence);
}
