package com.itextpdf.text.pdf.qrcode;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class ReedSolomonEncoder {
    private final ArrayList<GF256Poly> cachedGenerators;
    private final GF256 field;

    public ReedSolomonEncoder(GF256 gf256) {
        if (!GF256.QR_CODE_FIELD.equals(gf256)) {
            throw new IllegalArgumentException("Only QR Code is supported at this time");
        }
        this.field = gf256;
        this.cachedGenerators = new ArrayList<>();
        this.cachedGenerators.add(new GF256Poly(gf256, new int[]{1}));
    }

    private GF256Poly buildGenerator(int i) {
        if (i >= this.cachedGenerators.size()) {
            ArrayList<GF256Poly> arrayList = this.cachedGenerators;
            GF256Poly gF256Poly = arrayList.get(arrayList.size() - 1);
            for (int size = this.cachedGenerators.size(); size <= i; size++) {
                GF256 gf256 = this.field;
                gF256Poly = gF256Poly.multiply(new GF256Poly(gf256, new int[]{1, gf256.exp(size - 1)}));
                this.cachedGenerators.add(gF256Poly);
            }
        }
        return this.cachedGenerators.get(i);
    }

    public final void encode(int[] iArr, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        GF256Poly buildGenerator = buildGenerator(i);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] coefficients = new GF256Poly(this.field, iArr2).multiplyByMonomial(i, 1).divide(buildGenerator)[1].getCoefficients();
        int length2 = i - coefficients.length;
        for (int i2 = 0; i2 < length2; i2++) {
            iArr[length + i2] = 0;
        }
        System.arraycopy(coefficients, 0, iArr, length + length2, coefficients.length);
    }
}
