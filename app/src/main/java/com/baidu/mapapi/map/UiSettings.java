package com.baidu.mapapi.map;

import com.baidu.mapsdkplatform.comapi.map.C1210e;

/* loaded from: classes.dex */
public final class UiSettings {

    /* renamed from: a */
    private C1210e f5346a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UiSettings(C1210e c1210e) {
        this.f5346a = c1210e;
    }

    public final boolean isCompassEnabled() {
        return this.f5346a.m10660r();
    }

    public final boolean isOverlookingGesturesEnabled() {
        return this.f5346a.m10647z();
    }

    public final boolean isRotateGesturesEnabled() {
        return this.f5346a.m10648y();
    }

    public final boolean isScrollGesturesEnabled() {
        return this.f5346a.m10650w();
    }

    public final boolean isZoomGesturesEnabled() {
        return this.f5346a.m10649x();
    }

    public final void setAllGesturesEnabled(boolean z) {
        setRotateGesturesEnabled(z);
        setScrollGesturesEnabled(z);
        setOverlookingGesturesEnabled(z);
        setZoomGesturesEnabled(z);
    }

    public final void setCompassEnabled(boolean z) {
        this.f5346a.m10675j(z);
    }

    public final void setEnlargeCenterWithDoubleClickEnable(boolean z) {
        this.f5346a.m10661q(z);
    }

    public final void setOverlookingGesturesEnabled(boolean z) {
        this.f5346a.m10657s(z);
    }

    public final void setRotateGesturesEnabled(boolean z) {
        this.f5346a.m10659r(z);
    }

    public final void setScrollGesturesEnabled(boolean z) {
        this.f5346a.m10665o(z);
    }

    public final void setZoomGesturesEnabled(boolean z) {
        this.f5346a.m10663p(z);
    }
}
