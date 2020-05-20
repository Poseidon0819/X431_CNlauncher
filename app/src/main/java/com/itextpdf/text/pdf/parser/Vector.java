package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.pdf.ColumnText;
import java.util.Arrays;

/* loaded from: classes.dex */
public class Vector {

    /* renamed from: I1 */
    public static final int f19855I1 = 0;

    /* renamed from: I2 */
    public static final int f19856I2 = 1;

    /* renamed from: I3 */
    public static final int f19857I3 = 2;
    private final float[] vals = {ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO};

    public Vector(float f, float f2, float f3) {
        float[] fArr = this.vals;
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
    }

    public float get(int i) {
        return this.vals[i];
    }

    public Vector cross(Matrix matrix) {
        return new Vector((this.vals[0] * matrix.get(0)) + (this.vals[1] * matrix.get(3)) + (this.vals[2] * matrix.get(6)), (this.vals[0] * matrix.get(1)) + (this.vals[1] * matrix.get(4)) + (this.vals[2] * matrix.get(7)), (this.vals[0] * matrix.get(2)) + (this.vals[1] * matrix.get(5)) + (this.vals[2] * matrix.get(8)));
    }

    public Vector subtract(Vector vector) {
        float[] fArr = this.vals;
        float f = fArr[0];
        float[] fArr2 = vector.vals;
        return new Vector(f - fArr2[0], fArr[1] - fArr2[1], fArr[2] - fArr2[2]);
    }

    public Vector cross(Vector vector) {
        float[] fArr = this.vals;
        float f = fArr[1];
        float[] fArr2 = vector.vals;
        return new Vector((f * fArr2[2]) - (fArr[2] * fArr2[1]), (fArr[2] * fArr2[0]) - (fArr[0] * fArr2[2]), (fArr[0] * fArr2[1]) - (fArr[1] * fArr2[0]));
    }

    public Vector normalize() {
        float length = length();
        float[] fArr = this.vals;
        return new Vector(fArr[0] / length, fArr[1] / length, fArr[2] / length);
    }

    public Vector multiply(float f) {
        float[] fArr = this.vals;
        return new Vector(fArr[0] * f, fArr[1] * f, fArr[2] * f);
    }

    public float dot(Vector vector) {
        float[] fArr = this.vals;
        float f = fArr[0];
        float[] fArr2 = vector.vals;
        return (f * fArr2[0]) + (fArr[1] * fArr2[1]) + (fArr[2] * fArr2[2]);
    }

    public float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    public float lengthSquared() {
        float[] fArr = this.vals;
        return (fArr[0] * fArr[0]) + (fArr[1] * fArr[1]) + (fArr[2] * fArr[2]);
    }

    public String toString() {
        return this.vals[0] + "," + this.vals[1] + "," + this.vals[2];
    }

    public int hashCode() {
        return Arrays.hashCode(this.vals) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && Arrays.equals(this.vals, ((Vector) obj).vals);
    }
}
