package com.alipay.sdk.p072b;

import com.itextpdf.text.DocWriter;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;

/* renamed from: com.alipay.sdk.b.a */
/* loaded from: classes.dex */
public final class C0746a {

    /* renamed from: a */
    private static final byte[] f3541a = new byte[128];

    /* renamed from: b */
    private static final char[] f3542b = new char[64];

    /* renamed from: a */
    private static boolean m12530a(char c) {
        return c == '=';
    }

    static {
        int i;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < 128; i4++) {
            f3541a[i4] = -1;
        }
        for (int i5 = 90; i5 >= 65; i5--) {
            f3541a[i5] = (byte) (i5 - 65);
        }
        int i6 = Opcodes.ISHR;
        while (true) {
            i = 26;
            if (i6 < 97) {
                break;
            }
            f3541a[i6] = (byte) ((i6 - 97) + 26);
            i6--;
        }
        int i7 = 57;
        while (true) {
            i2 = 52;
            if (i7 < 48) {
                break;
            }
            f3541a[i7] = (byte) ((i7 - 48) + 52);
            i7--;
        }
        byte[] bArr = f3541a;
        bArr[43] = DocWriter.f19585GT;
        bArr[47] = 63;
        for (int i8 = 0; i8 <= 25; i8++) {
            f3542b[i8] = (char) (i8 + 65);
        }
        int i9 = 0;
        while (i <= 51) {
            f3542b[i] = (char) (i9 + 97);
            i++;
            i9++;
        }
        while (i2 <= 61) {
            f3542b[i2] = (char) (i3 + 48);
            i2++;
            i3++;
        }
        char[] cArr = f3542b;
        cArr[62] = SignatureVisitor.EXTENDS;
        cArr[63] = '/';
    }

    /* renamed from: b */
    private static boolean m12528b(char c) {
        return c < 128 && f3541a[c] != -1;
    }

    /* renamed from: a */
    public static byte[] m12529a(String str) {
        int i;
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        if (charArray == null) {
            i = 0;
        } else {
            int length = charArray.length;
            i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                char c = charArray[i2];
                if (!(c == ' ' || c == '\r' || c == '\n' || c == '\t')) {
                    charArray[i] = charArray[i2];
                    i++;
                }
            }
        }
        if (i % 4 != 0) {
            return null;
        }
        int i3 = i / 4;
        if (i3 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i3 * 3];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < i3 - 1) {
            int i7 = i5 + 1;
            char c2 = charArray[i5];
            if (m12528b(c2)) {
                int i8 = i7 + 1;
                char c3 = charArray[i7];
                if (m12528b(c3)) {
                    int i9 = i8 + 1;
                    char c4 = charArray[i8];
                    if (m12528b(c4)) {
                        int i10 = i9 + 1;
                        char c5 = charArray[i9];
                        if (m12528b(c5)) {
                            byte[] bArr2 = f3541a;
                            byte b = bArr2[c2];
                            byte b2 = bArr2[c3];
                            byte b3 = bArr2[c4];
                            byte b4 = bArr2[c5];
                            int i11 = i6 + 1;
                            bArr[i6] = (byte) ((b << 2) | (b2 >> 4));
                            int i12 = i11 + 1;
                            bArr[i11] = (byte) (((b2 & 15) << 4) | ((b3 >> 2) & 15));
                            i6 = i12 + 1;
                            bArr[i12] = (byte) ((b3 << 6) | b4);
                            i4++;
                            i5 = i10;
                        }
                    }
                }
            }
            return null;
        }
        int i13 = i5 + 1;
        char c6 = charArray[i5];
        if (m12528b(c6)) {
            int i14 = i13 + 1;
            char c7 = charArray[i13];
            if (m12528b(c7)) {
                byte[] bArr3 = f3541a;
                byte b5 = bArr3[c6];
                byte b6 = bArr3[c7];
                int i15 = i14 + 1;
                char c8 = charArray[i14];
                char c9 = charArray[i15];
                if (!m12528b(c8) || !m12528b(c9)) {
                    if (m12530a(c8) && m12530a(c9)) {
                        if ((b6 & 15) != 0) {
                            return null;
                        }
                        int i16 = i4 * 3;
                        byte[] bArr4 = new byte[i16 + 1];
                        System.arraycopy(bArr, 0, bArr4, 0, i16);
                        bArr4[i6] = (byte) ((b5 << 2) | (b6 >> 4));
                        return bArr4;
                    } else if (m12530a(c8) || !m12530a(c9)) {
                        return null;
                    } else {
                        byte b7 = f3541a[c8];
                        if ((b7 & 3) != 0) {
                            return null;
                        }
                        int i17 = i4 * 3;
                        byte[] bArr5 = new byte[i17 + 2];
                        System.arraycopy(bArr, 0, bArr5, 0, i17);
                        bArr5[i6] = (byte) ((b5 << 2) | (b6 >> 4));
                        bArr5[i6 + 1] = (byte) (((b7 >> 2) & 15) | ((b6 & 15) << 4));
                        return bArr5;
                    }
                }
                byte[] bArr6 = f3541a;
                byte b8 = bArr6[c8];
                byte b9 = bArr6[c9];
                int i18 = i6 + 1;
                bArr[i6] = (byte) ((b5 << 2) | (b6 >> 4));
                bArr[i18] = (byte) (((b6 & 15) << 4) | ((b8 >> 2) & 15));
                bArr[i18 + 1] = (byte) (b9 | (b8 << 6));
                return bArr;
            }
        }
        return null;
    }
}
