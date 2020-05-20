package com.itextpdf.p349a.p350a;

import com.itextpdf.p349a.p350a.Point2D;
import com.itextpdf.p349a.p350a.p352b.HashCode;
import com.itextpdf.p349a.p350a.p352b.Messages;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* renamed from: com.itextpdf.a.a.a */
/* loaded from: classes.dex */
public final class AffineTransform implements Serializable, Cloneable {
    public static final int TYPE_FLIP = 64;
    public static final int TYPE_GENERAL_ROTATION = 16;
    public static final int TYPE_GENERAL_SCALE = 4;
    public static final int TYPE_GENERAL_TRANSFORM = 32;
    public static final int TYPE_IDENTITY = 0;
    public static final int TYPE_MASK_ROTATION = 24;
    public static final int TYPE_MASK_SCALE = 6;
    public static final int TYPE_QUADRANT_ROTATION = 8;
    public static final int TYPE_TRANSLATION = 1;
    public static final int TYPE_UNIFORM_SCALE = 2;
    static final int TYPE_UNKNOWN = -1;
    static final double ZERO = 1.0E-10d;
    private static final long serialVersionUID = 1330973210523860834L;
    double m00;
    double m01;
    double m02;
    double m10;
    double m11;
    double m12;
    transient int type;

    public AffineTransform() {
        this.type = 0;
        this.m11 = 1.0d;
        this.m00 = 1.0d;
        this.m12 = 0.0d;
        this.m02 = 0.0d;
        this.m01 = 0.0d;
        this.m10 = 0.0d;
    }

    public AffineTransform(AffineTransform affineTransform) {
        this.type = affineTransform.type;
        this.m00 = affineTransform.m00;
        this.m10 = affineTransform.m10;
        this.m01 = affineTransform.m01;
        this.m11 = affineTransform.m11;
        this.m02 = affineTransform.m02;
        this.m12 = affineTransform.m12;
    }

    public AffineTransform(float f, float f2, float f3, float f4, float f5, float f6) {
        this.type = -1;
        this.m00 = f;
        this.m10 = f2;
        this.m01 = f3;
        this.m11 = f4;
        this.m02 = f5;
        this.m12 = f6;
    }

    public AffineTransform(double d, double d2, double d3, double d4, double d5, double d6) {
        this.type = -1;
        this.m00 = d;
        this.m10 = d2;
        this.m01 = d3;
        this.m11 = d4;
        this.m02 = d5;
        this.m12 = d6;
    }

    public AffineTransform(float[] fArr) {
        this.type = -1;
        this.m00 = fArr[0];
        this.m10 = fArr[1];
        this.m01 = fArr[2];
        this.m11 = fArr[3];
        if (fArr.length > 4) {
            this.m02 = fArr[4];
            this.m12 = fArr[5];
        }
    }

    public AffineTransform(double[] dArr) {
        this.type = -1;
        this.m00 = dArr[0];
        this.m10 = dArr[1];
        this.m01 = dArr[2];
        this.m11 = dArr[3];
        if (dArr.length > 4) {
            this.m02 = dArr[4];
            this.m12 = dArr[5];
        }
    }

    public final int getType() {
        int i = this.type;
        if (i != -1) {
            return i;
        }
        double d = this.m00;
        double d2 = this.m01;
        double d3 = this.m10;
        double d4 = this.m11;
        if ((d * d2) + (d3 * d4) != 0.0d) {
            return 32;
        }
        int i2 = 0;
        if (this.m02 != 0.0d || this.m12 != 0.0d) {
            i2 = 1;
        } else if (d == 1.0d && d4 == 1.0d && d2 == 0.0d && d3 == 0.0d) {
            return 0;
        }
        if ((this.m00 * this.m11) - (this.m01 * this.m10) < 0.0d) {
            i2 |= 64;
        }
        double d5 = this.m00;
        double d6 = this.m10;
        double d7 = (d5 * d5) + (d6 * d6);
        double d8 = this.m01;
        double d9 = this.m11;
        if (d7 != (d8 * d8) + (d9 * d9)) {
            i2 |= 4;
        } else if (d7 != 1.0d) {
            i2 |= 2;
        }
        return ((this.m00 == 0.0d && this.m11 == 0.0d) || (this.m10 == 0.0d && this.m01 == 0.0d && (this.m00 < 0.0d || this.m11 < 0.0d))) ? i2 | 8 : (this.m01 == 0.0d && this.m10 == 0.0d) ? i2 : i2 | 16;
    }

    public final double getScaleX() {
        return this.m00;
    }

    public final double getScaleY() {
        return this.m11;
    }

    public final double getShearX() {
        return this.m01;
    }

    public final double getShearY() {
        return this.m10;
    }

    public final double getTranslateX() {
        return this.m02;
    }

    public final double getTranslateY() {
        return this.m12;
    }

    public final boolean isIdentity() {
        return getType() == 0;
    }

    public final void getMatrix(double[] dArr) {
        dArr[0] = this.m00;
        dArr[1] = this.m10;
        dArr[2] = this.m01;
        dArr[3] = this.m11;
        if (dArr.length > 4) {
            dArr[4] = this.m02;
            dArr[5] = this.m12;
        }
    }

    public final double getDeterminant() {
        return (this.m00 * this.m11) - (this.m01 * this.m10);
    }

    public final void setTransform(double d, double d2, double d3, double d4, double d5, double d6) {
        this.type = -1;
        this.m00 = d;
        this.m10 = d2;
        this.m01 = d3;
        this.m11 = d4;
        this.m02 = d5;
        this.m12 = d6;
    }

    public final void setTransform(AffineTransform affineTransform) {
        this.type = affineTransform.type;
        setTransform(affineTransform.m00, affineTransform.m10, affineTransform.m01, affineTransform.m11, affineTransform.m02, affineTransform.m12);
    }

    public final void setToIdentity() {
        this.type = 0;
        this.m11 = 1.0d;
        this.m00 = 1.0d;
        this.m12 = 0.0d;
        this.m02 = 0.0d;
        this.m01 = 0.0d;
        this.m10 = 0.0d;
    }

    public final void setToTranslation(double d, double d2) {
        this.m11 = 1.0d;
        this.m00 = 1.0d;
        this.m10 = 0.0d;
        this.m01 = 0.0d;
        this.m02 = d;
        this.m12 = d2;
        if (d == 0.0d && d2 == 0.0d) {
            this.type = 0;
        } else {
            this.type = 1;
        }
    }

    public final void setToScale(double d, double d2) {
        this.m00 = d;
        this.m11 = d2;
        this.m12 = 0.0d;
        this.m02 = 0.0d;
        this.m01 = 0.0d;
        this.m10 = 0.0d;
        if (d != 1.0d || d2 != 1.0d) {
            this.type = -1;
        } else {
            this.type = 0;
        }
    }

    public final void setToShear(double d, double d2) {
        this.m11 = 1.0d;
        this.m00 = 1.0d;
        this.m12 = 0.0d;
        this.m02 = 0.0d;
        this.m01 = d;
        this.m10 = d2;
        if (d != 0.0d || d2 != 0.0d) {
            this.type = -1;
        } else {
            this.type = 0;
        }
    }

    public final void setToRotation(double d) {
        double sin = Math.sin(d);
        double cos = Math.cos(d);
        if (Math.abs(cos) < ZERO) {
            sin = sin > 0.0d ? 1.0d : -1.0d;
            cos = 0.0d;
        } else if (Math.abs(sin) < ZERO) {
            cos = cos > 0.0d ? 1.0d : -1.0d;
            sin = 0.0d;
        }
        this.m11 = cos;
        this.m00 = cos;
        this.m01 = -sin;
        this.m10 = sin;
        this.m12 = 0.0d;
        this.m02 = 0.0d;
        this.type = -1;
    }

    public final void setToRotation(double d, double d2, double d3) {
        setToRotation(d);
        double d4 = this.m00;
        double d5 = this.m10;
        this.m02 = ((1.0d - d4) * d2) + (d3 * d5);
        this.m12 = (d3 * (1.0d - d4)) - (d2 * d5);
        this.type = -1;
    }

    public static AffineTransform getTranslateInstance(double d, double d2) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToTranslation(d, d2);
        return affineTransform;
    }

    public static AffineTransform getScaleInstance(double d, double d2) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToScale(d, d2);
        return affineTransform;
    }

    public static AffineTransform getShearInstance(double d, double d2) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToShear(d, d2);
        return affineTransform;
    }

    public static AffineTransform getRotateInstance(double d) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToRotation(d);
        return affineTransform;
    }

    public static AffineTransform getRotateInstance(double d, double d2, double d3) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToRotation(d, d2, d3);
        return affineTransform;
    }

    public final void translate(double d, double d2) {
        concatenate(getTranslateInstance(d, d2));
    }

    public final void scale(double d, double d2) {
        concatenate(getScaleInstance(d, d2));
    }

    public final void shear(double d, double d2) {
        concatenate(getShearInstance(d, d2));
    }

    public final void rotate(double d) {
        concatenate(getRotateInstance(d));
    }

    public final void rotate(double d, double d2, double d3) {
        concatenate(getRotateInstance(d, d2, d3));
    }

    final AffineTransform multiply(AffineTransform affineTransform, AffineTransform affineTransform2) {
        double d = affineTransform.m00;
        double d2 = affineTransform2.m00;
        double d3 = affineTransform.m10;
        double d4 = affineTransform2.m01;
        double d5 = (d * d2) + (d3 * d4);
        double d6 = affineTransform2.m10;
        double d7 = affineTransform2.m11;
        double d8 = (d3 * d7) + (d * d6);
        double d9 = affineTransform.m01;
        double d10 = affineTransform.m11;
        double d11 = (d10 * d7) + (d9 * d6);
        double d12 = affineTransform.m02;
        double d13 = affineTransform.m12;
        return new AffineTransform(d5, d8, (d9 * d2) + (d10 * d4), d11, affineTransform2.m02 + (d2 * d12) + (d4 * d13), (d12 * d6) + (d13 * d7) + affineTransform2.m12);
    }

    public final void concatenate(AffineTransform affineTransform) {
        setTransform(multiply(affineTransform, this));
    }

    public final void preConcatenate(AffineTransform affineTransform) {
        setTransform(multiply(this, affineTransform));
    }

    public final AffineTransform createInverse() throws NoninvertibleTransformException {
        double determinant = getDeterminant();
        if (Math.abs(determinant) < ZERO) {
            throw new NoninvertibleTransformException(Messages.m2741a("awt.204"));
        }
        double d = this.m11;
        double d2 = this.m10;
        double d3 = (-d2) / determinant;
        double d4 = this.m01;
        double d5 = (-d4) / determinant;
        double d6 = this.m00;
        double d7 = this.m12;
        double d8 = d4 * d7;
        double d9 = this.m02;
        return new AffineTransform(d / determinant, d3, d5, d6 / determinant, (d8 - (d * d9)) / determinant, ((d2 * d9) - (d6 * d7)) / determinant);
    }

    public final Point2D transform(Point2D point2D, Point2D point2D2) {
        if (point2D2 == null) {
            if (point2D instanceof Point2D.C3606a) {
                point2D2 = new Point2D.C3606a();
            } else {
                point2D2 = new Point2D.C3607b();
            }
        }
        double x = point2D.getX();
        double y = point2D.getY();
        point2D2.setLocation((this.m00 * x) + (this.m01 * y) + this.m02, (x * this.m10) + (y * this.m11) + this.m12);
        return point2D2;
    }

    public final void transform(Point2D[] point2DArr, int i, Point2D[] point2DArr2, int i2, int i3) {
        while (true) {
            i3--;
            if (i3 < 0) {
                return;
            }
            int i4 = i + 1;
            Point2D point2D = point2DArr[i];
            double x = point2D.getX();
            double y = point2D.getY();
            Point2D point2D2 = point2DArr2[i2];
            if (point2D2 == null) {
                if (point2D instanceof Point2D.C3606a) {
                    point2D2 = new Point2D.C3606a();
                } else {
                    point2D2 = new Point2D.C3607b();
                }
            }
            point2D2.setLocation((this.m00 * x) + (this.m01 * y) + this.m02, (x * this.m10) + (y * this.m11) + this.m12);
            point2DArr2[i2] = point2D2;
            i2++;
            i = i4;
        }
    }

    public final void transform(double[] dArr, int i, double[] dArr2, int i2, int i3) {
        int i4;
        int i5;
        int i6 = 2;
        if (dArr == dArr2 && i < i2 && i2 < (i5 = i + (i4 = i3 * 2))) {
            i = i5 - 2;
            i2 = (i2 + i4) - 2;
            i6 = -2;
        }
        while (true) {
            i3--;
            if (i3 < 0) {
                return;
            }
            double d = dArr[i + 0];
            double d2 = dArr[i + 1];
            dArr2[i2 + 0] = (this.m00 * d) + (this.m01 * d2) + this.m02;
            dArr2[i2 + 1] = (d * this.m10) + (d2 * this.m11) + this.m12;
            i += i6;
            i2 += i6;
        }
    }

    public final void transform(float[] fArr, int i, float[] fArr2, int i2, int i3) {
        int i4;
        int i5;
        int i6 = 2;
        if (fArr == fArr2 && i < i2 && i2 < (i5 = i + (i4 = i3 * 2))) {
            i = i5 - 2;
            i2 = (i2 + i4) - 2;
            i6 = -2;
        }
        while (true) {
            i3--;
            if (i3 < 0) {
                return;
            }
            float f = fArr[i + 0];
            float f2 = fArr[i + 1];
            double d = f;
            double d2 = this.m00;
            Double.isNaN(d);
            double d3 = f2;
            double d4 = this.m01;
            Double.isNaN(d3);
            fArr2[i2 + 0] = (float) ((d2 * d) + (d4 * d3) + this.m02);
            double d5 = this.m10;
            Double.isNaN(d);
            double d6 = d * d5;
            double d7 = this.m11;
            Double.isNaN(d3);
            fArr2[i2 + 1] = (float) (d6 + (d3 * d7) + this.m12);
            i += i6;
            i2 += i6;
        }
    }

    public final void transform(float[] fArr, int i, double[] dArr, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        while (true) {
            i6--;
            if (i6 < 0) {
                return;
            }
            int i7 = i4 + 1;
            float f = fArr[i4];
            int i8 = i7 + 1;
            float f2 = fArr[i7];
            int i9 = i5 + 1;
            double d = f;
            double d2 = this.m00;
            Double.isNaN(d);
            double d3 = f2;
            double d4 = this.m01;
            Double.isNaN(d3);
            dArr[i5] = (d2 * d) + (d4 * d3) + this.m02;
            i5 = i9 + 1;
            double d5 = this.m10;
            Double.isNaN(d);
            double d6 = d * d5;
            double d7 = this.m11;
            Double.isNaN(d3);
            dArr[i9] = d6 + (d3 * d7) + this.m12;
            i4 = i8;
        }
    }

    public final void transform(double[] dArr, int i, float[] fArr, int i2, int i3) {
        while (true) {
            i3--;
            if (i3 < 0) {
                return;
            }
            int i4 = i + 1;
            double d = dArr[i];
            i = i4 + 1;
            double d2 = dArr[i4];
            int i5 = i2 + 1;
            fArr[i2] = (float) ((this.m00 * d) + (this.m01 * d2) + this.m02);
            i2 = i5 + 1;
            fArr[i5] = (float) ((d * this.m10) + (d2 * this.m11) + this.m12);
        }
    }

    public final Point2D deltaTransform(Point2D point2D, Point2D point2D2) {
        if (point2D2 == null) {
            if (point2D instanceof Point2D.C3606a) {
                point2D2 = new Point2D.C3606a();
            } else {
                point2D2 = new Point2D.C3607b();
            }
        }
        double x = point2D.getX();
        double y = point2D.getY();
        point2D2.setLocation((this.m00 * x) + (this.m01 * y), (x * this.m10) + (y * this.m11));
        return point2D2;
    }

    public final void deltaTransform(double[] dArr, int i, double[] dArr2, int i2, int i3) {
        while (true) {
            i3--;
            if (i3 < 0) {
                return;
            }
            int i4 = i + 1;
            double d = dArr[i];
            i = i4 + 1;
            double d2 = dArr[i4];
            int i5 = i2 + 1;
            dArr2[i2] = (this.m00 * d) + (this.m01 * d2);
            i2 = i5 + 1;
            dArr2[i5] = (d * this.m10) + (d2 * this.m11);
        }
    }

    public final Point2D inverseTransform(Point2D point2D, Point2D point2D2) throws NoninvertibleTransformException {
        double determinant = getDeterminant();
        if (Math.abs(determinant) < ZERO) {
            throw new NoninvertibleTransformException(Messages.m2741a("awt.204"));
        }
        if (point2D2 == null) {
            if (point2D instanceof Point2D.C3606a) {
                point2D2 = new Point2D.C3606a();
            } else {
                point2D2 = new Point2D.C3607b();
            }
        }
        double x = point2D.getX() - this.m02;
        double y = point2D.getY() - this.m12;
        point2D2.setLocation(((this.m11 * x) - (this.m01 * y)) / determinant, ((y * this.m00) - (x * this.m10)) / determinant);
        return point2D2;
    }

    public final void inverseTransform(double[] dArr, int i, double[] dArr2, int i2, int i3) throws NoninvertibleTransformException {
        double determinant = getDeterminant();
        if (Math.abs(determinant) < ZERO) {
            throw new NoninvertibleTransformException(Messages.m2741a("awt.204"));
        }
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        while (true) {
            i6--;
            if (i6 < 0) {
                return;
            }
            int i7 = i4 + 1;
            double d = dArr[i4] - this.m02;
            i4 = i7 + 1;
            double d2 = dArr[i7] - this.m12;
            int i8 = i5 + 1;
            dArr2[i5] = ((this.m11 * d) - (this.m01 * d2)) / determinant;
            i5 = i8 + 1;
            dArr2[i8] = ((d2 * this.m00) - (d * this.m10)) / determinant;
        }
    }

    public final Shape createTransformedShape(Shape shape) {
        if (shape == null) {
            return null;
        }
        if (!(shape instanceof GeneralPath)) {
            PathIterator pathIterator = shape.getPathIterator(this);
            GeneralPath generalPath = new GeneralPath(pathIterator.mo2729a());
            while (!pathIterator.mo2726b()) {
                float[] fArr = new float[6];
                switch (pathIterator.mo2727a(fArr)) {
                    case 0:
                        float f = fArr[0];
                        float f2 = fArr[1];
                        if (generalPath.f19517c > 0 && generalPath.f19515a[generalPath.f19517c - 1] == 0) {
                            generalPath.f19516b[generalPath.f19518d - 2] = f;
                            generalPath.f19516b[generalPath.f19518d - 1] = f2;
                            break;
                        } else {
                            generalPath.m2738a(2, false);
                            byte[] bArr = generalPath.f19515a;
                            int i = generalPath.f19517c;
                            generalPath.f19517c = i + 1;
                            bArr[i] = 0;
                            float[] fArr2 = generalPath.f19516b;
                            int i2 = generalPath.f19518d;
                            generalPath.f19518d = i2 + 1;
                            fArr2[i2] = f;
                            float[] fArr3 = generalPath.f19516b;
                            int i3 = generalPath.f19518d;
                            generalPath.f19518d = i3 + 1;
                            fArr3[i3] = f2;
                            break;
                        }
                        break;
                    case 1:
                        float f3 = fArr[0];
                        float f4 = fArr[1];
                        generalPath.m2738a(2, true);
                        byte[] bArr2 = generalPath.f19515a;
                        int i4 = generalPath.f19517c;
                        generalPath.f19517c = i4 + 1;
                        bArr2[i4] = 1;
                        float[] fArr4 = generalPath.f19516b;
                        int i5 = generalPath.f19518d;
                        generalPath.f19518d = i5 + 1;
                        fArr4[i5] = f3;
                        float[] fArr5 = generalPath.f19516b;
                        int i6 = generalPath.f19518d;
                        generalPath.f19518d = i6 + 1;
                        fArr5[i6] = f4;
                        break;
                    case 2:
                        float f5 = fArr[0];
                        float f6 = fArr[1];
                        float f7 = fArr[2];
                        float f8 = fArr[3];
                        generalPath.m2738a(4, true);
                        byte[] bArr3 = generalPath.f19515a;
                        int i7 = generalPath.f19517c;
                        generalPath.f19517c = i7 + 1;
                        bArr3[i7] = 2;
                        float[] fArr6 = generalPath.f19516b;
                        int i8 = generalPath.f19518d;
                        generalPath.f19518d = i8 + 1;
                        fArr6[i8] = f5;
                        float[] fArr7 = generalPath.f19516b;
                        int i9 = generalPath.f19518d;
                        generalPath.f19518d = i9 + 1;
                        fArr7[i9] = f6;
                        float[] fArr8 = generalPath.f19516b;
                        int i10 = generalPath.f19518d;
                        generalPath.f19518d = i10 + 1;
                        fArr8[i10] = f7;
                        float[] fArr9 = generalPath.f19516b;
                        int i11 = generalPath.f19518d;
                        generalPath.f19518d = i11 + 1;
                        fArr9[i11] = f8;
                        break;
                    case 3:
                        float f9 = fArr[0];
                        float f10 = fArr[1];
                        float f11 = fArr[2];
                        float f12 = fArr[3];
                        float f13 = fArr[4];
                        float f14 = fArr[5];
                        generalPath.m2738a(6, true);
                        byte[] bArr4 = generalPath.f19515a;
                        int i12 = generalPath.f19517c;
                        generalPath.f19517c = i12 + 1;
                        bArr4[i12] = 3;
                        float[] fArr10 = generalPath.f19516b;
                        int i13 = generalPath.f19518d;
                        generalPath.f19518d = i13 + 1;
                        fArr10[i13] = f9;
                        float[] fArr11 = generalPath.f19516b;
                        int i14 = generalPath.f19518d;
                        generalPath.f19518d = i14 + 1;
                        fArr11[i14] = f10;
                        float[] fArr12 = generalPath.f19516b;
                        int i15 = generalPath.f19518d;
                        generalPath.f19518d = i15 + 1;
                        fArr12[i15] = f11;
                        float[] fArr13 = generalPath.f19516b;
                        int i16 = generalPath.f19518d;
                        generalPath.f19518d = i16 + 1;
                        fArr13[i16] = f12;
                        float[] fArr14 = generalPath.f19516b;
                        int i17 = generalPath.f19518d;
                        generalPath.f19518d = i17 + 1;
                        fArr14[i17] = f13;
                        float[] fArr15 = generalPath.f19516b;
                        int i18 = generalPath.f19518d;
                        generalPath.f19518d = i18 + 1;
                        fArr15[i18] = f14;
                        break;
                    case 4:
                        if (generalPath.f19517c != 0 && generalPath.f19515a[generalPath.f19517c - 1] == 4) {
                            break;
                        } else {
                            generalPath.m2738a(0, true);
                            byte[] bArr5 = generalPath.f19515a;
                            int i19 = generalPath.f19517c;
                            generalPath.f19517c = i19 + 1;
                            bArr5[i19] = 4;
                            break;
                        }
                        break;
                }
                pathIterator.mo2725c();
            }
            return generalPath;
        }
        GeneralPath generalPath2 = (GeneralPath) ((GeneralPath) shape).clone();
        transform(generalPath2.f19516b, 0, generalPath2.f19516b, 0, generalPath2.f19518d / 2);
        return generalPath2;
    }

    public final String toString() {
        return getClass().getName() + "[[" + this.m00 + ", " + this.m01 + ", " + this.m02 + "], [" + this.m10 + ", " + this.m11 + ", " + this.m12 + "]]";
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public final int hashCode() {
        HashCode hashCode = new HashCode();
        hashCode.m2743a(this.m00);
        hashCode.m2743a(this.m01);
        hashCode.m2743a(this.m02);
        hashCode.m2743a(this.m10);
        hashCode.m2743a(this.m11);
        hashCode.m2743a(this.m12);
        return hashCode.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AffineTransform) {
            AffineTransform affineTransform = (AffineTransform) obj;
            return this.m00 == affineTransform.m00 && this.m01 == affineTransform.m01 && this.m02 == affineTransform.m02 && this.m10 == affineTransform.m10 && this.m11 == affineTransform.m11 && this.m12 == affineTransform.m12;
        }
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.type = -1;
    }
}
