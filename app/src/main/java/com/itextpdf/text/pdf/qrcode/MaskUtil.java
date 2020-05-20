package com.itextpdf.text.pdf.qrcode;

/* loaded from: classes.dex */
public final class MaskUtil {
    private MaskUtil() {
    }

    public static int applyMaskPenaltyRule1(ByteMatrix byteMatrix) {
        return applyMaskPenaltyRule1Internal(byteMatrix, true) + applyMaskPenaltyRule1Internal(byteMatrix, false);
    }

    public static int applyMaskPenaltyRule2(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i = 0;
        int i2 = 0;
        while (i < height - 1) {
            int i3 = i2;
            int i4 = 0;
            while (i4 < width - 1) {
                byte b = array[i][i4];
                int i5 = i4 + 1;
                if (b == array[i][i5]) {
                    int i6 = i + 1;
                    if (b == array[i6][i4] && b == array[i6][i5]) {
                        i3 += 3;
                    }
                }
                i4 = i5;
            }
            i++;
            i2 = i3;
        }
        return i2;
    }

    public static int applyMaskPenaltyRule3(ByteMatrix byteMatrix) {
        int i;
        int i2;
        int i3;
        int i4;
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i5 = 0;
        int i6 = 0;
        while (i5 < height) {
            int i7 = i6;
            for (int i8 = 0; i8 < width; i8++) {
                int i9 = i8 + 6;
                if (i9 < width && array[i5][i8] == 1 && array[i5][i8 + 1] == 0 && array[i5][i8 + 2] == 1 && array[i5][i8 + 3] == 1 && array[i5][i8 + 4] == 1 && array[i5][i8 + 5] == 0 && array[i5][i9] == 1 && (((i3 = i8 + 10) < width && array[i5][i8 + 7] == 0 && array[i5][i8 + 8] == 0 && array[i5][i8 + 9] == 0 && array[i5][i3] == 0) || (i8 - 4 >= 0 && array[i5][i8 - 1] == 0 && array[i5][i8 - 2] == 0 && array[i5][i8 - 3] == 0 && array[i5][i4] == 0))) {
                    i7 += 40;
                }
                int i10 = i5 + 6;
                if (i10 < height && array[i5][i8] == 1 && array[i5 + 1][i8] == 0 && array[i5 + 2][i8] == 1 && array[i5 + 3][i8] == 1 && array[i5 + 4][i8] == 1 && array[i5 + 5][i8] == 0 && array[i10][i8] == 1 && (((i = i5 + 10) < height && array[i5 + 7][i8] == 0 && array[i5 + 8][i8] == 0 && array[i5 + 9][i8] == 0 && array[i][i8] == 0) || (i5 - 4 >= 0 && array[i5 - 1][i8] == 0 && array[i5 - 2][i8] == 0 && array[i5 - 3][i8] == 0 && array[i2][i8] == 0))) {
                    i7 += 40;
                }
            }
            i5++;
            i6 = i7;
        }
        return i6;
    }

    public static int applyMaskPenaltyRule4(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i = 0;
        int i2 = 0;
        while (i < height) {
            int i3 = i2;
            for (int i4 = 0; i4 < width; i4++) {
                if (array[i][i4] == 1) {
                    i3++;
                }
            }
            i++;
            i2 = i3;
        }
        double d = i2;
        double height2 = byteMatrix.getHeight() * byteMatrix.getWidth();
        Double.isNaN(d);
        Double.isNaN(height2);
        return (Math.abs((int) (((d / height2) * 100.0d) - 50.0d)) / 5) * 10;
    }

    public static boolean getDataMaskBit(int i, int i2, int i3) {
        int i4;
        if (!QRCode.isValidMaskPattern(i)) {
            throw new IllegalArgumentException("Invalid mask pattern");
        }
        switch (i) {
            case 0:
                i4 = (i3 + i2) & 1;
                break;
            case 1:
                i4 = i3 & 1;
                break;
            case 2:
                i4 = i2 % 3;
                break;
            case 3:
                i4 = (i3 + i2) % 3;
                break;
            case 4:
                i4 = ((i3 >>> 1) + (i2 / 3)) & 1;
                break;
            case 5:
                int i5 = i3 * i2;
                i4 = (i5 & 1) + (i5 % 3);
                break;
            case 6:
                int i6 = i3 * i2;
                i4 = ((i6 & 1) + (i6 % 3)) & 1;
                break;
            case 7:
                i4 = (((i3 * i2) % 3) + ((i3 + i2) & 1)) & 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid mask pattern: ".concat(String.valueOf(i)));
        }
        return i4 == 0;
    }

    private static int applyMaskPenaltyRule1Internal(ByteMatrix byteMatrix, boolean z) {
        int height = z ? byteMatrix.getHeight() : byteMatrix.getWidth();
        int width = z ? byteMatrix.getWidth() : byteMatrix.getHeight();
        byte[][] array = byteMatrix.getArray();
        int i = 0;
        int i2 = 0;
        byte b = -1;
        while (i < height) {
            byte b2 = b;
            int i3 = 0;
            int i4 = i2;
            for (int i5 = 0; i5 < width; i5++) {
                byte b3 = z ? array[i][i5] : array[i5][i];
                if (b3 == b2) {
                    i3++;
                    if (i3 == 5) {
                        i4 += 3;
                    } else if (i3 > 5) {
                        i4++;
                    }
                } else {
                    b2 = b3;
                    i3 = 1;
                }
            }
            i++;
            i2 = i4;
            b = b2;
        }
        return i2;
    }
}
