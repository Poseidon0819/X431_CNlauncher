package com.baidu.mapapi.model.inner;

import java.io.Serializable;

/* loaded from: classes.dex */
public class Point implements Serializable {

    /* renamed from: x */
    public int f5413x;

    /* renamed from: y */
    public int f5414y;

    public Point() {
    }

    public Point(int i, int i2) {
        this.f5413x = i;
        this.f5414y = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Point point = (Point) obj;
            return this.f5413x == point.f5413x && this.f5414y == point.f5414y;
        }
        return false;
    }

    public int getmPtx() {
        return this.f5413x;
    }

    public int getmPty() {
        return this.f5414y;
    }

    public int hashCode() {
        return ((this.f5413x + 31) * 31) + this.f5414y;
    }

    public void setmPtx(int i) {
        this.f5413x = i;
    }

    public void setmPty(int i) {
        this.f5414y = i;
    }

    public String toString() {
        return "Point [x=" + this.f5413x + ", y=" + this.f5414y + "]";
    }
}
