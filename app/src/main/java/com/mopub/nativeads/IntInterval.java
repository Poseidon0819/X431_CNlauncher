package com.mopub.nativeads;

/* loaded from: classes2.dex */
public class IntInterval implements Comparable<IntInterval> {

    /* renamed from: a */
    private int f20778a;

    /* renamed from: b */
    private int f20779b;

    public IntInterval(int i, int i2) {
        this.f20778a = i;
        this.f20779b = i2;
    }

    public int getStart() {
        return this.f20778a;
    }

    public int getLength() {
        return this.f20779b;
    }

    public void setStart(int i) {
        this.f20778a = i;
    }

    public void setLength(int i) {
        this.f20779b = i;
    }

    public boolean equals(int i, int i2) {
        return this.f20778a == i && this.f20779b == i2;
    }

    public String toString() {
        return "{start : " + this.f20778a + ", length : " + this.f20779b + "}";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IntInterval) {
            IntInterval intInterval = (IntInterval) obj;
            return this.f20778a == intInterval.f20778a && this.f20779b == intInterval.f20779b;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f20778a + 899) * 31) + this.f20779b;
    }

    @Override // java.lang.Comparable
    public int compareTo(IntInterval intInterval) {
        int i = this.f20778a;
        int i2 = intInterval.f20778a;
        return i == i2 ? this.f20779b - intInterval.f20779b : i - i2;
    }
}
