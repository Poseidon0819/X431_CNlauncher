package com.itextpdf.p349a.p350a;

import com.itextpdf.p349a.p350a.Rectangle2D;
import java.io.Serializable;

/* renamed from: com.itextpdf.a.a.n */
/* loaded from: classes.dex */
public final class Rectangle extends Rectangle2D implements Shape, Serializable {
    private static final long serialVersionUID = -4345857070255674764L;
    public double height;
    public double width;

    /* renamed from: x */
    public double f19531x;

    /* renamed from: y */
    public double f19532y;

    public Rectangle() {
        setBounds(0, 0, 0, 0);
    }

    public Rectangle(C3605k c3605k) {
        setBounds(c3605k.f19525x, c3605k.f19526y, 0.0d, 0.0d);
    }

    public Rectangle(C3605k c3605k, Dimension dimension) {
        setBounds(c3605k.f19525x, c3605k.f19526y, dimension.width, dimension.height);
    }

    public Rectangle(double d, double d2, double d3, double d4) {
        setBounds(d, d2, d3, d4);
    }

    public Rectangle(int i, int i2) {
        setBounds(0, 0, i, i2);
    }

    public Rectangle(Rectangle rectangle) {
        setBounds(rectangle.f19531x, rectangle.f19532y, rectangle.width, rectangle.height);
    }

    public Rectangle(com.itextpdf.text.Rectangle rectangle) {
        rectangle.normalize();
        setBounds(rectangle.getLeft(), rectangle.getBottom(), rectangle.getWidth(), rectangle.getHeight());
    }

    public Rectangle(Dimension dimension) {
        setBounds(0.0d, 0.0d, dimension.width, dimension.height);
    }

    @Override // com.itextpdf.p349a.p350a.RectangularShape
    public final double getX() {
        return this.f19531x;
    }

    @Override // com.itextpdf.p349a.p350a.RectangularShape
    public final double getY() {
        return this.f19532y;
    }

    @Override // com.itextpdf.p349a.p350a.RectangularShape
    public final double getHeight() {
        return this.height;
    }

    @Override // com.itextpdf.p349a.p350a.RectangularShape
    public final double getWidth() {
        return this.width;
    }

    @Override // com.itextpdf.p349a.p350a.RectangularShape
    public final boolean isEmpty() {
        return this.width <= 0.0d || this.height <= 0.0d;
    }

    public final Dimension getSize() {
        return new Dimension(this.width, this.height);
    }

    public final void setSize(int i, int i2) {
        setSize(i, i2);
    }

    public final void setSize(double d, double d2) {
        this.width = d;
        this.height = d2;
    }

    public final void setSize(Dimension dimension) {
        setSize(dimension.width, dimension.height);
    }

    public final C3605k getLocation() {
        return new C3605k(this.f19531x, this.f19532y);
    }

    public final void setLocation(int i, int i2) {
        setLocation(i, i2);
    }

    public final void setLocation(double d, double d2) {
        this.f19531x = d;
        this.f19532y = d2;
    }

    public final void setLocation(C3605k c3605k) {
        setLocation(c3605k.f19525x, c3605k.f19526y);
    }

    @Override // com.itextpdf.p349a.p350a.Rectangle2D
    public final void setRect(double d, double d2, double d3, double d4) {
        int floor = (int) Math.floor(d);
        int floor2 = (int) Math.floor(d2);
        setBounds(floor, floor2, ((int) Math.ceil(d + d3)) - floor, ((int) Math.ceil(d2 + d4)) - floor2);
    }

    @Override // com.itextpdf.p349a.p350a.RectangularShape
    public final Rectangle getBounds() {
        return new Rectangle(this.f19531x, this.f19532y, this.width, this.height);
    }

    @Override // com.itextpdf.p349a.p350a.Rectangle2D, com.itextpdf.p349a.p350a.Shape
    public final Rectangle2D getBounds2D() {
        return getBounds();
    }

    public final void setBounds(int i, int i2, int i3, int i4) {
        setBounds(i, i2, i3, i4);
    }

    public final void setBounds(double d, double d2, double d3, double d4) {
        this.f19531x = d;
        this.f19532y = d2;
        this.height = d4;
        this.width = d3;
    }

    public final void setBounds(Rectangle rectangle) {
        setBounds(rectangle.f19531x, rectangle.f19532y, rectangle.width, rectangle.height);
    }

    public final void grow(int i, int i2) {
        translate(i, i2);
    }

    public final void grow(double d, double d2) {
        this.f19531x -= d;
        this.f19532y -= d2;
        this.width += d + d;
        this.height += d2 + d2;
    }

    public final void translate(int i, int i2) {
        translate(i, i2);
    }

    public final void translate(double d, double d2) {
        this.f19531x += d;
        this.f19532y += d2;
    }

    public final void add(int i, int i2) {
        add(i, i2);
    }

    @Override // com.itextpdf.p349a.p350a.Rectangle2D
    public final void add(double d, double d2) {
        double min = Math.min(this.f19531x, d);
        double max = Math.max(this.f19531x + this.width, d);
        double min2 = Math.min(this.f19532y, d2);
        setBounds(min, min2, max - min, Math.max(this.f19532y + this.height, d2) - min2);
    }

    public final void add(C3605k c3605k) {
        add(c3605k.f19525x, c3605k.f19526y);
    }

    public final void add(Rectangle rectangle) {
        double min = Math.min(this.f19531x, rectangle.f19531x);
        double max = Math.max(this.f19531x + this.width, rectangle.f19531x + rectangle.width);
        double min2 = Math.min(this.f19532y, rectangle.f19532y);
        setBounds(min, min2, max - min, Math.max(this.f19532y + this.height, rectangle.f19532y + rectangle.height) - min2);
    }

    public final boolean contains(int i, int i2) {
        return contains(i, i2);
    }

    @Override // com.itextpdf.p349a.p350a.Rectangle2D, com.itextpdf.p349a.p350a.Shape
    public final boolean contains(double d, double d2) {
        if (isEmpty()) {
            return false;
        }
        double d3 = this.f19531x;
        if (d >= d3) {
            double d4 = this.f19532y;
            if (d2 >= d4) {
                return d - d3 < this.width && d2 - d4 < this.height;
            }
        }
        return false;
    }

    public final boolean contains(C3605k c3605k) {
        return contains(c3605k.f19525x, c3605k.f19526y);
    }

    public final boolean contains(int i, int i2, int i3, int i4) {
        return contains(i, i2) && contains((i + i3) - 1, (i2 + i4) - 1);
    }

    @Override // com.itextpdf.p349a.p350a.Rectangle2D, com.itextpdf.p349a.p350a.Shape
    public final boolean contains(double d, double d2, double d3, double d4) {
        return contains(d, d2) && contains((d + d3) - 0.01d, (d2 + d4) - 0.01d);
    }

    public final boolean contains(Rectangle rectangle) {
        return contains(rectangle.f19531x, rectangle.f19532y, rectangle.width, rectangle.height);
    }

    @Override // com.itextpdf.p349a.p350a.Rectangle2D
    public final Rectangle2D createIntersection(Rectangle2D rectangle2D) {
        if (rectangle2D instanceof Rectangle) {
            return intersection((Rectangle) rectangle2D);
        }
        Rectangle2D.C3608a c3608a = new Rectangle2D.C3608a();
        Rectangle2D.intersect(this, rectangle2D, c3608a);
        return c3608a;
    }

    public final Rectangle intersection(Rectangle rectangle) {
        double max = Math.max(this.f19531x, rectangle.f19531x);
        double max2 = Math.max(this.f19532y, rectangle.f19532y);
        return new Rectangle(max, max2, Math.min(this.f19531x + this.width, rectangle.f19531x + rectangle.width) - max, Math.min(this.f19532y + this.height, rectangle.f19532y + rectangle.height) - max2);
    }

    public final boolean intersects(Rectangle rectangle) {
        return !intersection(rectangle).isEmpty();
    }

    @Override // com.itextpdf.p349a.p350a.Rectangle2D
    public final int outcode(double d, double d2) {
        int i;
        double d3 = this.width;
        if (d3 <= 0.0d) {
            i = 5;
        } else {
            double d4 = this.f19531x;
            i = d < d4 ? 1 : d > d4 + d3 ? 4 : 0;
        }
        double d5 = this.height;
        if (d5 <= 0.0d) {
            return i | 10;
        }
        double d6 = this.f19532y;
        return d2 < d6 ? i | 2 : d2 > d6 + d5 ? i | 8 : i;
    }

    @Override // com.itextpdf.p349a.p350a.Rectangle2D
    public final Rectangle2D createUnion(Rectangle2D rectangle2D) {
        if (rectangle2D instanceof Rectangle) {
            return union((Rectangle) rectangle2D);
        }
        Rectangle2D.C3608a c3608a = new Rectangle2D.C3608a();
        Rectangle2D.union(this, rectangle2D, c3608a);
        return c3608a;
    }

    public final Rectangle union(Rectangle rectangle) {
        Rectangle rectangle2 = new Rectangle(this);
        rectangle2.add(rectangle);
        return rectangle2;
    }

    @Override // com.itextpdf.p349a.p350a.Rectangle2D
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) obj;
            return rectangle.f19531x == this.f19531x && rectangle.f19532y == this.f19532y && rectangle.width == this.width && rectangle.height == this.height;
        }
        return false;
    }

    public final String toString() {
        return getClass().getName() + "[x=" + this.f19531x + ",y=" + this.f19532y + ",width=" + this.width + ",height=" + this.height + "]";
    }
}
