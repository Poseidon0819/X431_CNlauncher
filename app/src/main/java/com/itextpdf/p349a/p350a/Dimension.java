package com.itextpdf.p349a.p350a;

import com.itextpdf.p349a.p350a.p352b.HashCode;
import java.io.Serializable;

/* renamed from: com.itextpdf.a.a.c */
/* loaded from: classes.dex */
public final class Dimension extends Dimension2D implements Serializable {
    private static final long serialVersionUID = 4723952579491349524L;
    public double height;
    public double width;

    public Dimension(Dimension dimension) {
        this(dimension.width, dimension.height);
    }

    public Dimension() {
        this(0, 0);
    }

    public Dimension(double d, double d2) {
        setSize(d, d2);
    }

    public Dimension(int i, int i2) {
        setSize(i, i2);
    }

    public final int hashCode() {
        HashCode hashCode = new HashCode();
        hashCode.m2743a(this.width);
        hashCode.m2743a(this.height);
        return hashCode.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Dimension) {
            Dimension dimension = (Dimension) obj;
            return dimension.width == this.width && dimension.height == this.height;
        }
        return false;
    }

    public final String toString() {
        return getClass().getName() + "[width=" + this.width + ",height=" + this.height + "]";
    }

    public final void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public final void setSize(Dimension dimension) {
        setSize(dimension.width, dimension.height);
    }

    @Override // com.itextpdf.p349a.p350a.Dimension2D
    public final void setSize(double d, double d2) {
        setSize((int) Math.ceil(d), (int) Math.ceil(d2));
    }

    public final Dimension getSize() {
        return new Dimension(this.width, this.height);
    }

    @Override // com.itextpdf.p349a.p350a.Dimension2D
    public final double getHeight() {
        return this.height;
    }

    @Override // com.itextpdf.p349a.p350a.Dimension2D
    public final double getWidth() {
        return this.width;
    }
}
