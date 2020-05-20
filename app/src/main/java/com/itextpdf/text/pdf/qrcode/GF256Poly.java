package com.itextpdf.text.pdf.qrcode;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class GF256Poly {
    private final int[] coefficients;
    private final GF256 field;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GF256Poly(GF256 gf256, int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.field = gf256;
        int length = iArr.length;
        int i = 1;
        if (length > 1 && iArr[0] == 0) {
            while (i < length && iArr[i] == 0) {
                i++;
            }
            if (i == length) {
                this.coefficients = gf256.getZero().coefficients;
                return;
            }
            this.coefficients = new int[length - i];
            int[] iArr2 = this.coefficients;
            System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
            return;
        }
        this.coefficients = iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int[] getCoefficients() {
        return this.coefficients;
    }

    final int getDegree() {
        return this.coefficients.length - 1;
    }

    final boolean isZero() {
        return this.coefficients[0] == 0;
    }

    final int getCoefficient(int i) {
        int[] iArr = this.coefficients;
        return iArr[(iArr.length - 1) - i];
    }

    final int evaluateAt(int i) {
        if (i == 0) {
            return getCoefficient(0);
        }
        int[] iArr = this.coefficients;
        int length = iArr.length;
        if (i == 1) {
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                i2 = GF256.addOrSubtract(i2, this.coefficients[i3]);
            }
            return i2;
        }
        int i4 = iArr[0];
        for (int i5 = 1; i5 < length; i5++) {
            i4 = GF256.addOrSubtract(this.field.multiply(i, i4), this.coefficients[i5]);
        }
        return i4;
    }

    final GF256Poly addOrSubtract(GF256Poly gF256Poly) {
        if (!this.field.equals(gF256Poly.field)) {
            throw new IllegalArgumentException("GF256Polys do not have same GF256 field");
        }
        if (isZero()) {
            return gF256Poly;
        }
        if (gF256Poly.isZero()) {
            return this;
        }
        int[] iArr = this.coefficients;
        int[] iArr2 = gF256Poly.coefficients;
        if (iArr.length > iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr2.length];
        int length = iArr2.length - iArr.length;
        System.arraycopy(iArr2, 0, iArr3, 0, length);
        for (int i = length; i < iArr2.length; i++) {
            iArr3[i] = GF256.addOrSubtract(iArr[i - length], iArr2[i]);
        }
        return new GF256Poly(this.field, iArr3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final GF256Poly multiply(GF256Poly gF256Poly) {
        if (!this.field.equals(gF256Poly.field)) {
            throw new IllegalArgumentException("GF256Polys do not have same GF256 field");
        }
        if (isZero() || gF256Poly.isZero()) {
            return this.field.getZero();
        }
        int[] iArr = this.coefficients;
        int length = iArr.length;
        int[] iArr2 = gF256Poly.coefficients;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = i + i3;
                iArr3[i4] = GF256.addOrSubtract(iArr3[i4], this.field.multiply(i2, iArr2[i3]));
            }
        }
        return new GF256Poly(this.field, iArr3);
    }

    final GF256Poly multiply(int i) {
        if (i == 0) {
            return this.field.getZero();
        }
        if (i == 1) {
            return this;
        }
        int length = this.coefficients.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.field.multiply(this.coefficients[i2], i);
        }
        return new GF256Poly(this.field, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final GF256Poly multiplyByMonomial(int i, int i2) {
        if (i >= 0) {
            if (i2 == 0) {
                return this.field.getZero();
            }
            int length = this.coefficients.length;
            int[] iArr = new int[i + length];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.field.multiply(this.coefficients[i3], i2);
            }
            return new GF256Poly(this.field, iArr);
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final GF256Poly[] divide(GF256Poly gF256Poly) {
        if (!this.field.equals(gF256Poly.field)) {
            throw new IllegalArgumentException("GF256Polys do not have same GF256 field");
        }
        if (gF256Poly.isZero()) {
            throw new IllegalArgumentException("Divide by 0");
        }
        GF256Poly zero = this.field.getZero();
        int inverse = this.field.inverse(gF256Poly.getCoefficient(gF256Poly.getDegree()));
        GF256Poly gF256Poly2 = zero;
        GF256Poly gF256Poly3 = this;
        while (gF256Poly3.getDegree() >= gF256Poly.getDegree() && !gF256Poly3.isZero()) {
            int degree = gF256Poly3.getDegree() - gF256Poly.getDegree();
            int multiply = this.field.multiply(gF256Poly3.getCoefficient(gF256Poly3.getDegree()), inverse);
            GF256Poly multiplyByMonomial = gF256Poly.multiplyByMonomial(degree, multiply);
            gF256Poly2 = gF256Poly2.addOrSubtract(this.field.buildMonomial(degree, multiply));
            gF256Poly3 = gF256Poly3.addOrSubtract(multiplyByMonomial);
        }
        return new GF256Poly[]{gF256Poly2, gF256Poly3};
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer(getDegree() * 8);
        for (int degree = getDegree(); degree >= 0; degree--) {
            int coefficient = getCoefficient(degree);
            if (coefficient != 0) {
                if (coefficient < 0) {
                    stringBuffer.append(" - ");
                    coefficient = -coefficient;
                } else if (stringBuffer.length() > 0) {
                    stringBuffer.append(" + ");
                }
                if (degree == 0 || coefficient != 1) {
                    int log = this.field.log(coefficient);
                    if (log == 0) {
                        stringBuffer.append('1');
                    } else if (log == 1) {
                        stringBuffer.append('a');
                    } else {
                        stringBuffer.append("a^");
                        stringBuffer.append(log);
                    }
                }
                if (degree != 0) {
                    if (degree == 1) {
                        stringBuffer.append('x');
                    } else {
                        stringBuffer.append("x^");
                        stringBuffer.append(degree);
                    }
                }
            }
        }
        return stringBuffer.toString();
    }
}
