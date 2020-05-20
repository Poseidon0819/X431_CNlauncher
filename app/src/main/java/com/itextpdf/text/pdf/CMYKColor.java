package com.itextpdf.text.pdf;

/* loaded from: classes.dex */
public class CMYKColor extends ExtendedColor {
    private static final long serialVersionUID = 5940378778276468452L;
    float black;
    float cyan;
    float magenta;
    float yellow;

    public CMYKColor(int i, int i2, int i3, int i4) {
        this(i / 255.0f, i2 / 255.0f, i3 / 255.0f, i4 / 255.0f);
    }

    public CMYKColor(float f, float f2, float f3, float f4) {
        super(2, (1.0f - f) - f4, (1.0f - f2) - f4, (1.0f - f3) - f4);
        this.cyan = normalize(f);
        this.magenta = normalize(f2);
        this.yellow = normalize(f3);
        this.black = normalize(f4);
    }

    public float getCyan() {
        return this.cyan;
    }

    public float getMagenta() {
        return this.magenta;
    }

    public float getYellow() {
        return this.yellow;
    }

    public float getBlack() {
        return this.black;
    }

    @Override // com.itextpdf.text.BaseColor
    public boolean equals(Object obj) {
        if (obj instanceof CMYKColor) {
            CMYKColor cMYKColor = (CMYKColor) obj;
            return this.cyan == cMYKColor.cyan && this.magenta == cMYKColor.magenta && this.yellow == cMYKColor.yellow && this.black == cMYKColor.black;
        }
        return false;
    }

    @Override // com.itextpdf.text.BaseColor
    public int hashCode() {
        return ((Float.floatToIntBits(this.cyan) ^ Float.floatToIntBits(this.magenta)) ^ Float.floatToIntBits(this.yellow)) ^ Float.floatToIntBits(this.black);
    }
}
