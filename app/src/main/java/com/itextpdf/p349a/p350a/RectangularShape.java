package com.itextpdf.p349a.p350a;

import com.itextpdf.p349a.p350a.Rectangle2D;

/* renamed from: com.itextpdf.a.a.p */
/* loaded from: classes.dex */
public abstract class RectangularShape implements Shape, Cloneable {
    public abstract double getHeight();

    public abstract double getWidth();

    public abstract double getX();

    public abstract double getY();

    public abstract boolean isEmpty();

    public abstract void setFrame(double d, double d2, double d3, double d4);

    public double getMinX() {
        return getX();
    }

    public double getMinY() {
        return getY();
    }

    public double getMaxX() {
        return getX() + getWidth();
    }

    public double getMaxY() {
        return getY() + getHeight();
    }

    public double getCenterX() {
        return getX() + (getWidth() / 2.0d);
    }

    public double getCenterY() {
        return getY() + (getHeight() / 2.0d);
    }

    public Rectangle2D getFrame() {
        return new Rectangle2D.C3608a(getX(), getY(), getWidth(), getHeight());
    }

    public void setFrame(Point2D point2D, Dimension2D dimension2D) {
        setFrame(point2D.getX(), point2D.getY(), dimension2D.getWidth(), dimension2D.getHeight());
    }

    public void setFrame(Rectangle2D rectangle2D) {
        setFrame(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    public void setFrameFromDiagonal(double d, double d2, double d3, double d4) {
        double d5;
        double d6;
        double d7;
        double d8;
        if (d < d3) {
            d5 = d;
            d6 = d3 - d;
        } else {
            d5 = d3;
            d6 = d - d3;
        }
        if (d2 < d4) {
            d7 = d2;
            d8 = d4 - d2;
        } else {
            d7 = d4;
            d8 = d2 - d4;
        }
        setFrame(d5, d7, d6, d8);
    }

    public void setFrameFromDiagonal(Point2D point2D, Point2D point2D2) {
        setFrameFromDiagonal(point2D.getX(), point2D.getY(), point2D2.getX(), point2D2.getY());
    }

    public void setFrameFromCenter(double d, double d2, double d3, double d4) {
        double abs = Math.abs(d3 - d);
        double abs2 = Math.abs(d4 - d2);
        setFrame(d - abs, d2 - abs2, abs * 2.0d, abs2 * 2.0d);
    }

    public void setFrameFromCenter(Point2D point2D, Point2D point2D2) {
        setFrameFromCenter(point2D.getX(), point2D.getY(), point2D2.getX(), point2D2.getY());
    }

    public boolean contains(Point2D point2D) {
        return contains(point2D.getX(), point2D.getY());
    }

    public boolean intersects(Rectangle2D rectangle2D) {
        return intersects(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    public boolean contains(Rectangle2D rectangle2D) {
        return contains(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    public Rectangle getBounds() {
        int floor = (int) Math.floor(getMinX());
        int floor2 = (int) Math.floor(getMinY());
        return new Rectangle(floor, floor2, ((int) Math.ceil(getMaxX())) - floor, ((int) Math.ceil(getMaxY())) - floor2);
    }

    public PathIterator getPathIterator(AffineTransform affineTransform, double d) {
        return new FlatteningPathIterator(getPathIterator(affineTransform), d);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }
}
