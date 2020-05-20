package com.itextpdf.p349a.p350a;

import com.itextpdf.p349a.p350a.p352b.HashCode;
import com.itextpdf.p349a.p350a.p352b.Messages;
import com.itextpdf.text.pdf.ColumnText;
import java.util.NoSuchElementException;

/* renamed from: com.itextpdf.a.a.o */
/* loaded from: classes.dex */
public abstract class Rectangle2D extends RectangularShape {
    public static final int OUT_BOTTOM = 8;
    public static final int OUT_LEFT = 1;
    public static final int OUT_RIGHT = 4;
    public static final int OUT_TOP = 2;

    public abstract Rectangle2D createIntersection(Rectangle2D rectangle2D);

    public abstract Rectangle2D createUnion(Rectangle2D rectangle2D);

    public abstract int outcode(double d, double d2);

    public abstract void setRect(double d, double d2, double d3, double d4);

    /* compiled from: Rectangle2D.java */
    /* renamed from: com.itextpdf.a.a.o$b */
    /* loaded from: classes.dex */
    public static class C3609b extends Rectangle2D {

        /* renamed from: a */
        public float f19537a;

        /* renamed from: b */
        public float f19538b;

        /* renamed from: c */
        public float f19539c;

        /* renamed from: d */
        public float f19540d;

        public C3609b() {
        }

        public C3609b(float f, float f2, float f3, float f4) {
            this.f19537a = f;
            this.f19538b = f2;
            this.f19539c = f3;
            this.f19540d = f4;
        }

        @Override // com.itextpdf.p349a.p350a.RectangularShape
        public final double getX() {
            return this.f19537a;
        }

        @Override // com.itextpdf.p349a.p350a.RectangularShape
        public final double getY() {
            return this.f19538b;
        }

        @Override // com.itextpdf.p349a.p350a.RectangularShape
        public final double getWidth() {
            return this.f19539c;
        }

        @Override // com.itextpdf.p349a.p350a.RectangularShape
        public final double getHeight() {
            return this.f19540d;
        }

        @Override // com.itextpdf.p349a.p350a.RectangularShape
        public final boolean isEmpty() {
            return this.f19539c <= ColumnText.GLOBAL_SPACE_CHAR_RATIO || this.f19540d <= ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }

        @Override // com.itextpdf.p349a.p350a.Rectangle2D
        public final void setRect(double d, double d2, double d3, double d4) {
            this.f19537a = (float) d;
            this.f19538b = (float) d2;
            this.f19539c = (float) d3;
            this.f19540d = (float) d4;
        }

        @Override // com.itextpdf.p349a.p350a.Rectangle2D
        public final void setRect(Rectangle2D rectangle2D) {
            this.f19537a = (float) rectangle2D.getX();
            this.f19538b = (float) rectangle2D.getY();
            this.f19539c = (float) rectangle2D.getWidth();
            this.f19540d = (float) rectangle2D.getHeight();
        }

        @Override // com.itextpdf.p349a.p350a.Rectangle2D
        public final int outcode(double d, double d2) {
            int i;
            float f = this.f19539c;
            if (f <= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                i = 5;
            } else {
                float f2 = this.f19537a;
                i = d < ((double) f2) ? 1 : d > ((double) (f2 + f)) ? 4 : 0;
            }
            float f3 = this.f19540d;
            if (f3 <= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                return i | 10;
            }
            float f4 = this.f19538b;
            return d2 < ((double) f4) ? i | 2 : d2 > ((double) (f4 + f3)) ? i | 8 : i;
        }

        @Override // com.itextpdf.p349a.p350a.Rectangle2D, com.itextpdf.p349a.p350a.Shape
        public final Rectangle2D getBounds2D() {
            return new C3609b(this.f19537a, this.f19538b, this.f19539c, this.f19540d);
        }

        @Override // com.itextpdf.p349a.p350a.Rectangle2D
        public final Rectangle2D createIntersection(Rectangle2D rectangle2D) {
            Rectangle2D c3609b;
            if (rectangle2D instanceof C3608a) {
                c3609b = new C3608a();
            } else {
                c3609b = new C3609b();
            }
            Rectangle2D.intersect(this, rectangle2D, c3609b);
            return c3609b;
        }

        @Override // com.itextpdf.p349a.p350a.Rectangle2D
        public final Rectangle2D createUnion(Rectangle2D rectangle2D) {
            Rectangle2D c3609b;
            if (rectangle2D instanceof C3608a) {
                c3609b = new C3608a();
            } else {
                c3609b = new C3609b();
            }
            Rectangle2D.union(this, rectangle2D, c3609b);
            return c3609b;
        }

        public final String toString() {
            return getClass().getName() + "[x=" + this.f19537a + ",y=" + this.f19538b + ",width=" + this.f19539c + ",height=" + this.f19540d + "]";
        }
    }

    /* compiled from: Rectangle2D.java */
    /* renamed from: com.itextpdf.a.a.o$a */
    /* loaded from: classes.dex */
    public static class C3608a extends Rectangle2D {

        /* renamed from: a */
        public double f19533a;

        /* renamed from: b */
        public double f19534b;

        /* renamed from: c */
        public double f19535c;

        /* renamed from: d */
        public double f19536d;

        public C3608a() {
        }

        public C3608a(double d, double d2, double d3, double d4) {
            setRect(d, d2, d3, d4);
        }

        @Override // com.itextpdf.p349a.p350a.RectangularShape
        public final double getX() {
            return this.f19533a;
        }

        @Override // com.itextpdf.p349a.p350a.RectangularShape
        public final double getY() {
            return this.f19534b;
        }

        @Override // com.itextpdf.p349a.p350a.RectangularShape
        public final double getWidth() {
            return this.f19535c;
        }

        @Override // com.itextpdf.p349a.p350a.RectangularShape
        public final double getHeight() {
            return this.f19536d;
        }

        @Override // com.itextpdf.p349a.p350a.RectangularShape
        public final boolean isEmpty() {
            return this.f19535c <= 0.0d || this.f19536d <= 0.0d;
        }

        @Override // com.itextpdf.p349a.p350a.Rectangle2D
        public final void setRect(double d, double d2, double d3, double d4) {
            this.f19533a = d;
            this.f19534b = d2;
            this.f19535c = d3;
            this.f19536d = d4;
        }

        @Override // com.itextpdf.p349a.p350a.Rectangle2D
        public final void setRect(Rectangle2D rectangle2D) {
            this.f19533a = rectangle2D.getX();
            this.f19534b = rectangle2D.getY();
            this.f19535c = rectangle2D.getWidth();
            this.f19536d = rectangle2D.getHeight();
        }

        @Override // com.itextpdf.p349a.p350a.Rectangle2D
        public final int outcode(double d, double d2) {
            int i;
            double d3 = this.f19535c;
            if (d3 <= 0.0d) {
                i = 5;
            } else {
                double d4 = this.f19533a;
                i = d < d4 ? 1 : d > d4 + d3 ? 4 : 0;
            }
            double d5 = this.f19536d;
            if (d5 <= 0.0d) {
                return i | 10;
            }
            double d6 = this.f19534b;
            return d2 < d6 ? i | 2 : d2 > d6 + d5 ? i | 8 : i;
        }

        @Override // com.itextpdf.p349a.p350a.Rectangle2D, com.itextpdf.p349a.p350a.Shape
        public final Rectangle2D getBounds2D() {
            return new C3608a(this.f19533a, this.f19534b, this.f19535c, this.f19536d);
        }

        @Override // com.itextpdf.p349a.p350a.Rectangle2D
        public final Rectangle2D createIntersection(Rectangle2D rectangle2D) {
            C3608a c3608a = new C3608a();
            Rectangle2D.intersect(this, rectangle2D, c3608a);
            return c3608a;
        }

        @Override // com.itextpdf.p349a.p350a.Rectangle2D
        public final Rectangle2D createUnion(Rectangle2D rectangle2D) {
            C3608a c3608a = new C3608a();
            Rectangle2D.union(this, rectangle2D, c3608a);
            return c3608a;
        }

        public final String toString() {
            return getClass().getName() + "[x=" + this.f19533a + ",y=" + this.f19534b + ",width=" + this.f19535c + ",height=" + this.f19536d + "]";
        }
    }

    /* compiled from: Rectangle2D.java */
    /* renamed from: com.itextpdf.a.a.o$c */
    /* loaded from: classes.dex */
    class C3610c implements PathIterator {

        /* renamed from: a */
        double f19541a;

        /* renamed from: b */
        double f19542b;

        /* renamed from: c */
        double f19543c;

        /* renamed from: d */
        double f19544d;

        /* renamed from: e */
        AffineTransform f19545e;

        /* renamed from: f */
        int f19546f;

        @Override // com.itextpdf.p349a.p350a.PathIterator
        /* renamed from: a */
        public final int mo2729a() {
            return 1;
        }

        C3610c(Rectangle2D rectangle2D, AffineTransform affineTransform) {
            this.f19541a = rectangle2D.getX();
            this.f19542b = rectangle2D.getY();
            this.f19543c = rectangle2D.getWidth();
            this.f19544d = rectangle2D.getHeight();
            this.f19545e = affineTransform;
            if (this.f19543c < 0.0d || this.f19544d < 0.0d) {
                this.f19546f = 6;
            }
        }

        @Override // com.itextpdf.p349a.p350a.PathIterator
        /* renamed from: b */
        public final boolean mo2726b() {
            return this.f19546f > 5;
        }

        @Override // com.itextpdf.p349a.p350a.PathIterator
        /* renamed from: c */
        public final void mo2725c() {
            this.f19546f++;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:21:0x004c  */
        @Override // com.itextpdf.p349a.p350a.PathIterator
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final int mo2728a(double[] r8) {
            /*
                r7 = this;
                boolean r0 = r7.mo2726b()
                if (r0 != 0) goto L55
                int r0 = r7.f19546f
                r1 = 5
                if (r0 != r1) goto Ld
                r8 = 4
                return r8
            Ld:
                r1 = 0
                r2 = 1
                if (r0 != 0) goto L13
                r0 = 0
                goto L18
            L13:
                switch(r0) {
                    case 1: goto L3c;
                    case 2: goto L2d;
                    case 3: goto L21;
                    case 4: goto L17;
                    default: goto L16;
                }
            L16:
                goto L47
            L17:
                r0 = 1
            L18:
                double r3 = r7.f19541a
                r8[r1] = r3
                double r3 = r7.f19542b
                r8[r2] = r3
                goto L48
            L21:
                double r3 = r7.f19541a
                r8[r1] = r3
                double r0 = r7.f19542b
                double r3 = r7.f19544d
                double r0 = r0 + r3
                r8[r2] = r0
                goto L47
            L2d:
                double r3 = r7.f19541a
                double r5 = r7.f19543c
                double r3 = r3 + r5
                r8[r1] = r3
                double r0 = r7.f19542b
                double r3 = r7.f19544d
                double r0 = r0 + r3
                r8[r2] = r0
                goto L47
            L3c:
                double r3 = r7.f19541a
                double r5 = r7.f19543c
                double r3 = r3 + r5
                r8[r1] = r3
                double r0 = r7.f19542b
                r8[r2] = r0
            L47:
                r0 = 1
            L48:
                com.itextpdf.a.a.a r1 = r7.f19545e
                if (r1 == 0) goto L54
                r3 = 0
                r5 = 0
                r6 = 1
                r2 = r8
                r4 = r8
                r1.transform(r2, r3, r4, r5, r6)
            L54:
                return r0
            L55:
                java.util.NoSuchElementException r8 = new java.util.NoSuchElementException
                java.lang.String r0 = "awt.4B"
                java.lang.String r0 = com.itextpdf.p349a.p350a.p352b.Messages.m2741a(r0)
                r8.<init>(r0)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.p349a.p350a.Rectangle2D.C3610c.mo2728a(double[]):int");
        }

        @Override // com.itextpdf.p349a.p350a.PathIterator
        /* renamed from: a */
        public final int mo2727a(float[] fArr) {
            if (mo2726b()) {
                throw new NoSuchElementException(Messages.m2741a("awt.4B"));
            }
            int i = this.f19546f;
            if (i == 5) {
                return 4;
            }
            int i2 = 0;
            if (i == 0) {
                fArr[0] = (float) this.f19541a;
                fArr[1] = (float) this.f19542b;
            } else {
                switch (i) {
                    case 1:
                        fArr[0] = (float) (this.f19541a + this.f19543c);
                        fArr[1] = (float) this.f19542b;
                        break;
                    case 2:
                        fArr[0] = (float) (this.f19541a + this.f19543c);
                        fArr[1] = (float) (this.f19542b + this.f19544d);
                        break;
                    case 3:
                        fArr[0] = (float) this.f19541a;
                        fArr[1] = (float) (this.f19542b + this.f19544d);
                        break;
                    case 4:
                        fArr[0] = (float) this.f19541a;
                        fArr[1] = (float) this.f19542b;
                        break;
                }
                i2 = 1;
            }
            AffineTransform affineTransform = this.f19545e;
            if (affineTransform != null) {
                affineTransform.transform(fArr, 0, fArr, 0, 1);
            }
            return i2;
        }
    }

    public void setRect(Rectangle2D rectangle2D) {
        setRect(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    @Override // com.itextpdf.p349a.p350a.RectangularShape
    public void setFrame(double d, double d2, double d3, double d4) {
        setRect(d, d2, d3, d4);
    }

    @Override // com.itextpdf.p349a.p350a.Shape
    public Rectangle2D getBounds2D() {
        return (Rectangle2D) clone();
    }

    public boolean intersectsLine(double d, double d2, double d3, double d4) {
        double x = getX();
        double y = getY();
        double width = x + getWidth();
        double height = y + getHeight();
        if (x > d || d > width || y > d2 || d2 > height) {
            return (x <= d3 && d3 <= width && y <= d4 && d4 <= height) || Line2D.m2735a(x, y, width, height, d, d2, d3, d4) || Line2D.m2735a(width, y, x, height, d, d2, d3, d4);
        }
        return true;
    }

    public boolean intersectsLine(Line2D line2D) {
        return intersectsLine(line2D.m2737a(), line2D.m2734b(), line2D.m2733c(), line2D.m2732d());
    }

    public int outcode(Point2D point2D) {
        return outcode(point2D.getX(), point2D.getY());
    }

    @Override // com.itextpdf.p349a.p350a.Shape
    public boolean contains(double d, double d2) {
        if (isEmpty()) {
            return false;
        }
        double x = getX();
        double y = getY();
        return x <= d && d < getWidth() + x && y <= d2 && d2 < getHeight() + y;
    }

    @Override // com.itextpdf.p349a.p350a.Shape
    public boolean intersects(double d, double d2, double d3, double d4) {
        if (isEmpty() || d3 <= 0.0d || d4 <= 0.0d) {
            return false;
        }
        double x = getX();
        double y = getY();
        return d + d3 > x && d < getWidth() + x && d2 + d4 > y && d2 < getHeight() + y;
    }

    @Override // com.itextpdf.p349a.p350a.Shape
    public boolean contains(double d, double d2, double d3, double d4) {
        if (isEmpty() || d3 <= 0.0d || d4 <= 0.0d) {
            return false;
        }
        double x = getX();
        double y = getY();
        return x <= d && d + d3 <= getWidth() + x && y <= d2 && d2 + d4 <= getHeight() + y;
    }

    public static void intersect(Rectangle2D rectangle2D, Rectangle2D rectangle2D2, Rectangle2D rectangle2D3) {
        double max = Math.max(rectangle2D.getMinX(), rectangle2D2.getMinX());
        double max2 = Math.max(rectangle2D.getMinY(), rectangle2D2.getMinY());
        rectangle2D3.setFrame(max, max2, Math.min(rectangle2D.getMaxX(), rectangle2D2.getMaxX()) - max, Math.min(rectangle2D.getMaxY(), rectangle2D2.getMaxY()) - max2);
    }

    public static void union(Rectangle2D rectangle2D, Rectangle2D rectangle2D2, Rectangle2D rectangle2D3) {
        double min = Math.min(rectangle2D.getMinX(), rectangle2D2.getMinX());
        double min2 = Math.min(rectangle2D.getMinY(), rectangle2D2.getMinY());
        rectangle2D3.setFrame(min, min2, Math.max(rectangle2D.getMaxX(), rectangle2D2.getMaxX()) - min, Math.max(rectangle2D.getMaxY(), rectangle2D2.getMaxY()) - min2);
    }

    public void add(double d, double d2) {
        double min = Math.min(getMinX(), d);
        double min2 = Math.min(getMinY(), d2);
        setRect(min, min2, Math.max(getMaxX(), d) - min, Math.max(getMaxY(), d2) - min2);
    }

    public void add(Point2D point2D) {
        add(point2D.getX(), point2D.getY());
    }

    public void add(Rectangle2D rectangle2D) {
        union(this, rectangle2D, this);
    }

    @Override // com.itextpdf.p349a.p350a.Shape
    public PathIterator getPathIterator(AffineTransform affineTransform) {
        return new C3610c(this, affineTransform);
    }

    @Override // com.itextpdf.p349a.p350a.RectangularShape
    public PathIterator getPathIterator(AffineTransform affineTransform, double d) {
        return new C3610c(this, affineTransform);
    }

    public int hashCode() {
        HashCode hashCode = new HashCode();
        hashCode.m2743a(getX());
        hashCode.m2743a(getY());
        hashCode.m2743a(getWidth());
        hashCode.m2743a(getHeight());
        return hashCode.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Rectangle2D) {
            Rectangle2D rectangle2D = (Rectangle2D) obj;
            return getX() == rectangle2D.getX() && getY() == rectangle2D.getY() && getWidth() == rectangle2D.getWidth() && getHeight() == rectangle2D.getHeight();
        }
        return false;
    }
}
