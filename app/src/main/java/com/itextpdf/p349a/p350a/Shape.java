package com.itextpdf.p349a.p350a;

/* renamed from: com.itextpdf.a.a.q */
/* loaded from: classes.dex */
public interface Shape {
    boolean contains(double d, double d2);

    boolean contains(double d, double d2, double d3, double d4);

    Rectangle2D getBounds2D();

    PathIterator getPathIterator(AffineTransform affineTransform);

    boolean intersects(double d, double d2, double d3, double d4);
}
