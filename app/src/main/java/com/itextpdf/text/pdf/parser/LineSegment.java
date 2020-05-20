package com.itextpdf.text.pdf.parser;

import com.itextpdf.p349a.p350a.Rectangle2D;

/* loaded from: classes.dex */
public class LineSegment {
    private final Vector endPoint;
    private final Vector startPoint;

    public LineSegment(Vector vector, Vector vector2) {
        this.startPoint = vector;
        this.endPoint = vector2;
    }

    public Vector getStartPoint() {
        return this.startPoint;
    }

    public Vector getEndPoint() {
        return this.endPoint;
    }

    public float getLength() {
        return this.endPoint.subtract(this.startPoint).length();
    }

    public Rectangle2D.C3609b getBoundingRectange() {
        float f = getStartPoint().get(0);
        float f2 = getStartPoint().get(1);
        float f3 = getEndPoint().get(0);
        float f4 = getEndPoint().get(1);
        return new Rectangle2D.C3609b(Math.min(f, f3), Math.min(f2, f4), Math.abs(f3 - f), Math.abs(f4 - f2));
    }

    public LineSegment transformBy(Matrix matrix) {
        return new LineSegment(this.startPoint.cross(matrix), this.endPoint.cross(matrix));
    }
}
