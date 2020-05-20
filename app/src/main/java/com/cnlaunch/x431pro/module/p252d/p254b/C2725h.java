package com.cnlaunch.x431pro.module.p252d.p254b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* compiled from: LocationInfo.java */
/* renamed from: com.cnlaunch.x431pro.module.d.b.h */
/* loaded from: classes.dex */
public final class C2725h extends AbstractC2709c {
    private static final long serialVersionUID = 3997679667558101627L;
    private double lat = 0.0d;
    private double lon = 0.0d;

    public final double getLat() {
        return this.lat;
    }

    public final void setLat(double d) {
        this.lat = d;
    }

    public final double getLon() {
        return this.lon;
    }

    public final void setLon(double d) {
        this.lon = d;
    }

    public final String toString() {
        return "lat=" + this.lat + " lon=" + this.lon;
    }
}
