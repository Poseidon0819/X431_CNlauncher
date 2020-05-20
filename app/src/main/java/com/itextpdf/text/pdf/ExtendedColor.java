package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;

/* loaded from: classes.dex */
public abstract class ExtendedColor extends BaseColor {
    public static final int TYPE_CMYK = 2;
    public static final int TYPE_GRAY = 1;
    public static final int TYPE_PATTERN = 4;
    public static final int TYPE_RGB = 0;
    public static final int TYPE_SEPARATION = 3;
    public static final int TYPE_SHADING = 5;
    private static final long serialVersionUID = 2722660170712380080L;
    protected int type;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final float normalize(float f) {
        if (f < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    public ExtendedColor(int i) {
        super(0, 0, 0);
        this.type = i;
    }

    public ExtendedColor(int i, float f, float f2, float f3) {
        super(normalize(f), normalize(f2), normalize(f3));
        this.type = i;
    }

    public ExtendedColor(int i, int i2, int i3, int i4, int i5) {
        super(normalize(i2 / 255.0f), normalize(i3 / 255.0f), normalize(i4 / 255.0f), normalize(i5 / 255.0f));
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    public static int getType(BaseColor baseColor) {
        if (baseColor instanceof ExtendedColor) {
            return ((ExtendedColor) baseColor).getType();
        }
        return 0;
    }
}
