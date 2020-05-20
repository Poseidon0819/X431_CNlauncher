package com.cnlaunch.x431pro.widget.pulltorefresh;

import android.annotation.TargetApi;
import android.view.View;
import com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase;

@TargetApi(9)
/* renamed from: com.cnlaunch.x431pro.widget.pulltorefresh.c */
/* loaded from: classes.dex */
public final class OverscrollHelper {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m4451a(View view) {
        return view.getOverScrollMode() != 2;
    }

    /* renamed from: a */
    public static void m4450a(PullToRefreshBase<?> pullToRefreshBase, int i, int i2, int i3, int i4, boolean z) {
        int scrollX;
        if (C2930d.f16682a[pullToRefreshBase.getPullToRefreshScrollDirection().ordinal()] == 1) {
            scrollX = pullToRefreshBase.getScrollX();
        } else {
            i2 = i4;
            scrollX = pullToRefreshBase.getScrollY();
            i = i3;
        }
        if (!pullToRefreshBase.m4430g() || pullToRefreshBase.m4429h()) {
            return;
        }
        PullToRefreshBase.EnumC2933b mode = pullToRefreshBase.getMode();
        if (!mode.permitsPullToRefresh() || z || i == 0) {
            if (z && PullToRefreshBase.EnumC2941j.OVERSCROLLING == pullToRefreshBase.getState()) {
                pullToRefreshBase.m4440a(PullToRefreshBase.EnumC2941j.RESET, new boolean[0]);
                return;
            }
            return;
        }
        int i5 = i + i2;
        if (i5 < 0) {
            if (mode.showHeaderLoadingLayout()) {
                if (scrollX == 0) {
                    pullToRefreshBase.m4440a(PullToRefreshBase.EnumC2941j.OVERSCROLLING, new boolean[0]);
                }
                pullToRefreshBase.setHeaderScroll((int) ((scrollX + i5) * 1.0f));
            }
        } else if (i5 > 0) {
            if (mode.showFooterLoadingLayout()) {
                if (scrollX == 0) {
                    pullToRefreshBase.m4440a(PullToRefreshBase.EnumC2941j.OVERSCROLLING, new boolean[0]);
                }
                pullToRefreshBase.setHeaderScroll((int) (((scrollX + i5) - 0) * 1.0f));
            }
        } else if (Math.abs(i5) <= 0 || Math.abs(i5 - 0) <= 0) {
            pullToRefreshBase.m4440a(PullToRefreshBase.EnumC2941j.RESET, new boolean[0]);
        }
    }
}
