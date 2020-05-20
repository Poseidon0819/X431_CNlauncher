package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.pdf.ColumnText;
import java.util.Arrays;

/* loaded from: classes.dex */
public class Matrix {
    public static final int I11 = 0;
    public static final int I12 = 1;
    public static final int I13 = 2;
    public static final int I21 = 3;
    public static final int I22 = 4;
    public static final int I23 = 5;
    public static final int I31 = 6;
    public static final int I32 = 7;
    public static final int I33 = 8;
    private final float[] vals = {1.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f};

    public Matrix() {
    }

    public Matrix(float f, float f2) {
        float[] fArr = this.vals;
        fArr[6] = f;
        fArr[7] = f2;
    }

    public Matrix(float f, float f2, float f3, float f4, float f5, float f6) {
        float[] fArr = this.vals;
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = 0.0f;
        fArr[3] = f3;
        fArr[4] = f4;
        fArr[5] = 0.0f;
        fArr[6] = f5;
        fArr[7] = f6;
        fArr[8] = 1.0f;
    }

    public float get(int i) {
        return this.vals[i];
    }

    public Matrix multiply(Matrix matrix) {
        Matrix matrix2 = new Matrix();
        float[] fArr = this.vals;
        float[] fArr2 = matrix.vals;
        float[] fArr3 = matrix2.vals;
        fArr3[0] = (fArr[0] * fArr2[0]) + (fArr[1] * fArr2[3]) + (fArr[2] * fArr2[6]);
        fArr3[1] = (fArr[0] * fArr2[1]) + (fArr[1] * fArr2[4]) + (fArr[2] * fArr2[7]);
        fArr3[2] = (fArr[0] * fArr2[2]) + (fArr[1] * fArr2[5]) + (fArr[2] * fArr2[8]);
        fArr3[3] = (fArr[3] * fArr2[0]) + (fArr[4] * fArr2[3]) + (fArr[5] * fArr2[6]);
        fArr3[4] = (fArr[3] * fArr2[1]) + (fArr[4] * fArr2[4]) + (fArr[5] * fArr2[7]);
        fArr3[5] = (fArr[3] * fArr2[2]) + (fArr[4] * fArr2[5]) + (fArr[5] * fArr2[8]);
        fArr3[6] = (fArr[6] * fArr2[0]) + (fArr[7] * fArr2[3]) + (fArr[8] * fArr2[6]);
        fArr3[7] = (fArr[6] * fArr2[1]) + (fArr[7] * fArr2[4]) + (fArr[8] * fArr2[7]);
        fArr3[8] = (fArr[6] * fArr2[2]) + (fArr[7] * fArr2[5]) + (fArr[8] * fArr2[8]);
        return matrix2;
    }

    public Matrix subtract(Matrix matrix) {
        Matrix matrix2 = new Matrix();
        float[] fArr = this.vals;
        float[] fArr2 = matrix.vals;
        float[] fArr3 = matrix2.vals;
        fArr3[0] = fArr[0] - fArr2[0];
        fArr3[1] = fArr[1] - fArr2[1];
        fArr3[2] = fArr[2] - fArr2[2];
        fArr3[3] = fArr[3] - fArr2[3];
        fArr3[4] = fArr[4] - fArr2[4];
        fArr3[5] = fArr[5] - fArr2[5];
        fArr3[6] = fArr[6] - fArr2[6];
        fArr3[7] = fArr[7] - fArr2[7];
        fArr3[8] = fArr[8] - fArr2[8];
        return matrix2;
    }

    public float getDeterminant() {
        float[] fArr = this.vals;
        return ((((((fArr[0] * fArr[4]) * fArr[8]) + ((fArr[1] * fArr[5]) * fArr[6])) + ((fArr[2] * fArr[3]) * fArr[7])) - ((fArr[0] * fArr[5]) * fArr[7])) - ((fArr[1] * fArr[3]) * fArr[8])) - ((fArr[2] * fArr[4]) * fArr[6]);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Matrix) {
            return Arrays.equals(this.vals, ((Matrix) obj).vals);
        }
        return false;
    }

    public int hashCode() {
        int i = 1;
        int i2 = 0;
        while (true) {
            float[] fArr = this.vals;
            if (i2 >= fArr.length) {
                return i;
            }
            i = (i * 31) + Float.floatToIntBits(fArr[i2]);
            i2++;
        }
    }

    public String toString() {
        return this.vals[0] + "\t" + this.vals[1] + "\t" + this.vals[2] + "\n" + this.vals[3] + "\t" + this.vals[4] + "\t" + this.vals[2] + "\n" + this.vals[6] + "\t" + this.vals[7] + "\t" + this.vals[8];
    }
}
