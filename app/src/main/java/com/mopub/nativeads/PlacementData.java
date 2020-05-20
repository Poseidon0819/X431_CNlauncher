package com.mopub.nativeads;

import com.itextpdf.text.pdf.PdfContentParser;
import com.mopub.common.logging.MoPubLog;

/* renamed from: com.mopub.nativeads.av */
/* loaded from: classes2.dex */
final class PlacementData {
    public static final int NOT_FOUND = -1;

    /* renamed from: e */
    private int f21089e;

    /* renamed from: c */
    private final int[] f21087c = new int[PdfContentParser.COMMAND_TYPE];

    /* renamed from: d */
    private final int[] f21088d = new int[PdfContentParser.COMMAND_TYPE];

    /* renamed from: f */
    private final int[] f21090f = new int[PdfContentParser.COMMAND_TYPE];

    /* renamed from: a */
    final int[] f21085a = new int[PdfContentParser.COMMAND_TYPE];

    /* renamed from: g */
    private final NativeAd[] f21091g = new NativeAd[PdfContentParser.COMMAND_TYPE];

    /* renamed from: b */
    int f21086b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlacementData(int[] iArr) {
        this.f21089e = 0;
        this.f21089e = Math.min(iArr.length, (int) PdfContentParser.COMMAND_TYPE);
        System.arraycopy(iArr, 0, this.f21088d, 0, this.f21089e);
        System.arraycopy(iArr, 0, this.f21087c, 0, this.f21089e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean m2081a(int i) {
        return m2078a(this.f21088d, this.f21089e, i) >= 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final int m2077b(int i) {
        int m2074c = m2074c(this.f21088d, this.f21089e, i);
        if (m2074c == this.f21089e) {
            return -1;
        }
        return this.f21088d[m2074c];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2079a(int i, NativeAd nativeAd) {
        int m2076b = m2076b(this.f21088d, this.f21089e, i);
        if (m2076b == this.f21089e || this.f21088d[m2076b] != i) {
            MoPubLog.m2490w("Attempted to insert an ad at an invalid position");
            return;
        }
        int i2 = this.f21087c[m2076b];
        int m2074c = m2074c(this.f21090f, this.f21086b, i2);
        int i3 = this.f21086b;
        if (m2074c < i3) {
            int i4 = i3 - m2074c;
            int[] iArr = this.f21090f;
            int i5 = m2074c + 1;
            System.arraycopy(iArr, m2074c, iArr, i5, i4);
            int[] iArr2 = this.f21085a;
            System.arraycopy(iArr2, m2074c, iArr2, i5, i4);
            NativeAd[] nativeAdArr = this.f21091g;
            System.arraycopy(nativeAdArr, m2074c, nativeAdArr, i5, i4);
        }
        this.f21090f[m2074c] = i2;
        this.f21085a[m2074c] = i;
        this.f21091g[m2074c] = nativeAd;
        this.f21086b++;
        int i6 = (this.f21089e - m2076b) - 1;
        int[] iArr3 = this.f21088d;
        int i7 = m2076b + 1;
        System.arraycopy(iArr3, i7, iArr3, m2076b, i6);
        int[] iArr4 = this.f21087c;
        System.arraycopy(iArr4, i7, iArr4, m2076b, i6);
        this.f21089e--;
        while (m2076b < this.f21089e) {
            int[] iArr5 = this.f21088d;
            iArr5[m2076b] = iArr5[m2076b] + 1;
            m2076b++;
        }
        while (true) {
            m2074c++;
            if (m2074c >= this.f21086b) {
                return;
            }
            int[] iArr6 = this.f21085a;
            iArr6[m2074c] = iArr6[m2074c] + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final NativeAd m2075c(int i) {
        int m2078a = m2078a(this.f21085a, this.f21086b, i);
        if (m2078a < 0) {
            return null;
        }
        return this.f21091g[m2078a];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final int m2073d(int i) {
        int m2078a = m2078a(this.f21085a, this.f21086b, i);
        if (m2078a < 0) {
            return i - (m2078a ^ (-1));
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public final int m2072e(int i) {
        return i + m2074c(this.f21090f, this.f21086b, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public final int m2071f(int i) {
        if (i == 0) {
            return 0;
        }
        return m2072e(i - 1) + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final int m2080a(int i, int i2) {
        int i3 = this.f21086b;
        int[] iArr = new int[i3];
        int[] iArr2 = new int[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < this.f21086b; i5++) {
            int i6 = this.f21090f[i5];
            int i7 = this.f21085a[i5];
            if (i <= i7 && i7 < i2) {
                iArr[i4] = i6;
                iArr2[i4] = i7 - i4;
                this.f21091g[i5].destroy();
                this.f21091g[i5] = null;
                i4++;
            } else if (i4 > 0) {
                int i8 = i5 - i4;
                this.f21090f[i8] = i6;
                this.f21085a[i8] = i7 - i4;
                NativeAd[] nativeAdArr = this.f21091g;
                nativeAdArr[i8] = nativeAdArr[i5];
            }
        }
        if (i4 == 0) {
            return 0;
        }
        int m2076b = m2076b(this.f21088d, this.f21089e, iArr2[0]);
        for (int i9 = this.f21089e - 1; i9 >= m2076b; i9--) {
            int[] iArr3 = this.f21087c;
            int i10 = i9 + i4;
            iArr3[i10] = iArr3[i9];
            int[] iArr4 = this.f21088d;
            iArr4[i10] = iArr4[i9] - i4;
        }
        for (int i11 = 0; i11 < i4; i11++) {
            int i12 = m2076b + i11;
            this.f21087c[i12] = iArr[i11];
            this.f21088d[i12] = iArr2[i11];
        }
        this.f21089e += i4;
        this.f21086b -= i4;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public final void m2070g(int i) {
        for (int m2076b = m2076b(this.f21087c, this.f21089e, i); m2076b < this.f21089e; m2076b++) {
            int[] iArr = this.f21087c;
            iArr[m2076b] = iArr[m2076b] + 1;
            int[] iArr2 = this.f21088d;
            iArr2[m2076b] = iArr2[m2076b] + 1;
        }
        for (int m2076b2 = m2076b(this.f21090f, this.f21086b, i); m2076b2 < this.f21086b; m2076b2++) {
            int[] iArr3 = this.f21090f;
            iArr3[m2076b2] = iArr3[m2076b2] + 1;
            int[] iArr4 = this.f21085a;
            iArr4[m2076b2] = iArr4[m2076b2] + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public final void m2069h(int i) {
        for (int m2074c = m2074c(this.f21087c, this.f21089e, i); m2074c < this.f21089e; m2074c++) {
            int[] iArr = this.f21087c;
            iArr[m2074c] = iArr[m2074c] - 1;
            int[] iArr2 = this.f21088d;
            iArr2[m2074c] = iArr2[m2074c] - 1;
        }
        for (int m2074c2 = m2074c(this.f21090f, this.f21086b, i); m2074c2 < this.f21086b; m2074c2++) {
            int[] iArr3 = this.f21090f;
            iArr3[m2074c2] = iArr3[m2074c2] - 1;
            int[] iArr4 = this.f21085a;
            iArr4[m2074c2] = iArr4[m2074c2] - 1;
        }
    }

    /* renamed from: b */
    private static int m2076b(int[] iArr, int i, int i2) {
        int m2078a = m2078a(iArr, i, i2);
        if (m2078a < 0) {
            return m2078a ^ (-1);
        }
        int i3 = iArr[m2078a];
        while (m2078a >= 0 && iArr[m2078a] == i3) {
            m2078a--;
        }
        return m2078a + 1;
    }

    /* renamed from: c */
    private static int m2074c(int[] iArr, int i, int i2) {
        int m2078a = m2078a(iArr, i, i2);
        if (m2078a < 0) {
            return m2078a ^ (-1);
        }
        int i3 = iArr[m2078a];
        while (m2078a < i && iArr[m2078a] == i3) {
            m2078a++;
        }
        return m2078a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static int m2078a(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else if (i6 <= i2) {
                return i5;
            } else {
                i3 = i5 - 1;
            }
        }
        return i4 ^ (-1);
    }
}
