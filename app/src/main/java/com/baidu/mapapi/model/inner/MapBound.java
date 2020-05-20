package com.baidu.mapapi.model.inner;

import java.io.Serializable;

/* loaded from: classes.dex */
public class MapBound implements Serializable {
    public Point ptLB;
    public Point ptRT;

    public MapBound() {
        if (this.ptLB == null) {
            this.ptLB = new Point();
        }
        if (this.ptRT == null) {
            this.ptRT = new Point();
        }
    }

    public Point getPtLB() {
        return this.ptLB;
    }

    public Point getPtRT() {
        return this.ptRT;
    }

    public void setPtLB(Point point) {
        this.ptLB = point;
    }

    public void setPtRT(Point point) {
        this.ptRT = point;
    }
}
