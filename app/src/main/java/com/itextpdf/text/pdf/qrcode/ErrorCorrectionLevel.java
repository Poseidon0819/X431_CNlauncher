package com.itextpdf.text.pdf.qrcode;

/* loaded from: classes.dex */
public final class ErrorCorrectionLevel {
    private final int bits;
    private final String name;
    private final int ordinal;

    /* renamed from: L */
    public static final ErrorCorrectionLevel f19859L = new ErrorCorrectionLevel(0, 1, "L");

    /* renamed from: M */
    public static final ErrorCorrectionLevel f19860M = new ErrorCorrectionLevel(1, 0, "M");

    /* renamed from: Q */
    public static final ErrorCorrectionLevel f19861Q = new ErrorCorrectionLevel(2, 3, "Q");

    /* renamed from: H */
    public static final ErrorCorrectionLevel f19858H = new ErrorCorrectionLevel(3, 2, "H");
    private static final ErrorCorrectionLevel[] FOR_BITS = {f19860M, f19859L, f19858H, f19861Q};

    private ErrorCorrectionLevel(int i, int i2, String str) {
        this.ordinal = i;
        this.bits = i2;
        this.name = str;
    }

    public final int ordinal() {
        return this.ordinal;
    }

    public final int getBits() {
        return this.bits;
    }

    public final String getName() {
        return this.name;
    }

    public final String toString() {
        return this.name;
    }

    public static ErrorCorrectionLevel forBits(int i) {
        if (i >= 0) {
            ErrorCorrectionLevel[] errorCorrectionLevelArr = FOR_BITS;
            if (i < errorCorrectionLevelArr.length) {
                return errorCorrectionLevelArr[i];
            }
        }
        throw new IllegalArgumentException();
    }
}
