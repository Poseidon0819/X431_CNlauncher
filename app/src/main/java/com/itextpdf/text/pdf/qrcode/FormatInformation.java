package com.itextpdf.text.pdf.qrcode;

import com.mopub.nativeads.MoPubNativeAdPositioning;

/* loaded from: classes.dex */
final class FormatInformation {
    private final byte dataMask;
    private final ErrorCorrectionLevel errorCorrectionLevel;
    private static final int FORMAT_INFO_MASK_QR = 21522;
    private static final int[][] FORMAT_INFO_DECODE_LOOKUP = {new int[]{FORMAT_INFO_MASK_QR, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};
    private static final int[] BITS_SET_IN_HALF_BYTE = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};

    private FormatInformation(int i) {
        this.errorCorrectionLevel = ErrorCorrectionLevel.forBits((i >> 3) & 3);
        this.dataMask = (byte) (i & 7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int numBitsDiffering(int i, int i2) {
        int i3 = i ^ i2;
        int[] iArr = BITS_SET_IN_HALF_BYTE;
        return iArr[i3 & 15] + iArr[(i3 >>> 4) & 15] + iArr[(i3 >>> 8) & 15] + iArr[(i3 >>> 12) & 15] + iArr[(i3 >>> 16) & 15] + iArr[(i3 >>> 20) & 15] + iArr[(i3 >>> 24) & 15] + iArr[(i3 >>> 28) & 15];
    }

    static FormatInformation decodeFormatInformation(int i, int i2) {
        FormatInformation doDecodeFormatInformation = doDecodeFormatInformation(i, i2);
        return doDecodeFormatInformation != null ? doDecodeFormatInformation : doDecodeFormatInformation(i ^ FORMAT_INFO_MASK_QR, i2 ^ FORMAT_INFO_MASK_QR);
    }

    private static FormatInformation doDecodeFormatInformation(int i, int i2) {
        int[] iArr;
        int numBitsDiffering;
        int i3 = 0;
        int i4 = MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;
        int i5 = 0;
        while (true) {
            int[][] iArr2 = FORMAT_INFO_DECODE_LOOKUP;
            if (i3 >= iArr2.length) {
                if (i4 <= 3) {
                    return new FormatInformation(i5);
                }
                return null;
            }
            iArr = iArr2[i3];
            int i6 = iArr[0];
            if (i6 == i || i6 == i2) {
                break;
            }
            int numBitsDiffering2 = numBitsDiffering(i, i6);
            if (numBitsDiffering2 < i4) {
                i5 = iArr[1];
                i4 = numBitsDiffering2;
            }
            if (i != i2 && (numBitsDiffering = numBitsDiffering(i2, i6)) < i4) {
                i5 = iArr[1];
                i4 = numBitsDiffering;
            }
            i3++;
        }
        return new FormatInformation(iArr[1]);
    }

    final ErrorCorrectionLevel getErrorCorrectionLevel() {
        return this.errorCorrectionLevel;
    }

    final byte getDataMask() {
        return this.dataMask;
    }

    public final int hashCode() {
        return (this.errorCorrectionLevel.ordinal() << 3) | this.dataMask;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof FormatInformation) {
            FormatInformation formatInformation = (FormatInformation) obj;
            return this.errorCorrectionLevel == formatInformation.errorCorrectionLevel && this.dataMask == formatInformation.dataMask;
        }
        return false;
    }
}
