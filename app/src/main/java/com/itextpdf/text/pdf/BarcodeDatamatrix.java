package com.itextpdf.text.pdf;

import com.baidu.mapapi.UIMsg;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Jpeg;
import com.itextpdf.text.pdf.codec.CCITTG4Encoder;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import com.mopub.volley.DefaultRetryPolicy;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.image.MemoryImageSource;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Hashtable;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import org.codehaus.jackson.smile.SmileConstants;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes.dex */
public class BarcodeDatamatrix {
    public static final int DM_ASCII = 1;
    public static final int DM_AUTO = 0;
    public static final int DM_B256 = 4;
    public static final int DM_C40 = 2;
    public static final int DM_EDIFACT = 6;
    public static final int DM_ERROR_EXTENSION = 5;
    public static final int DM_ERROR_INVALID_SQUARE = 3;
    public static final int DM_ERROR_TEXT_TOO_BIG = 1;
    public static final int DM_EXTENSION = 32;
    public static final int DM_NO_ERROR = 0;
    public static final int DM_RAW = 7;
    public static final int DM_TEST = 64;
    public static final int DM_TEXT = 3;
    public static final int DM_X21 = 5;
    private static final DmParams[] dmSizes = {new DmParams(10, 10, 10, 10, 3, 3, 5), new DmParams(12, 12, 12, 12, 5, 5, 7), new DmParams(8, 18, 8, 18, 5, 5, 7), new DmParams(14, 14, 14, 14, 8, 8, 10), new DmParams(8, 32, 8, 16, 10, 10, 11), new DmParams(16, 16, 16, 16, 12, 12, 12), new DmParams(12, 26, 12, 26, 16, 16, 14), new DmParams(18, 18, 18, 18, 18, 18, 14), new DmParams(20, 20, 20, 20, 22, 22, 18), new DmParams(12, 36, 12, 18, 22, 22, 18), new DmParams(22, 22, 22, 22, 30, 30, 20), new DmParams(16, 36, 16, 18, 32, 32, 24), new DmParams(24, 24, 24, 24, 36, 36, 24), new DmParams(26, 26, 26, 26, 44, 44, 28), new DmParams(16, 48, 16, 24, 49, 49, 28), new DmParams(32, 32, 16, 16, 62, 62, 36), new DmParams(36, 36, 18, 18, 86, 86, 42), new DmParams(40, 40, 20, 20, 114, 114, 48), new DmParams(44, 44, 22, 22, Opcodes.D2F, Opcodes.D2F, 56), new DmParams(48, 48, 24, 24, Opcodes.FRETURN, Opcodes.FRETURN, 68), new DmParams(52, 52, 26, 26, 204, 102, 42), new DmParams(64, 64, 16, 16, TIFFConstants.TIFFTAG_MINSAMPLEVALUE, 140, 56), new DmParams(72, 72, 18, 18, 368, 92, 36), new DmParams(80, 80, 20, 20, 456, 114, 48), new DmParams(88, 88, 22, 22, 576, Opcodes.D2F, 56), new DmParams(96, 96, 24, 24, 696, Opcodes.FRETURN, 68), new DmParams(104, 104, 26, 26, 816, 136, 56), new DmParams(Opcodes.ISHL, Opcodes.ISHL, 20, 20, 1050, Opcodes.DRETURN, 68), new DmParams(132, 132, 22, 22, 1304, Opcodes.IF_ICMPGT, 62), new DmParams(Opcodes.D2F, Opcodes.D2F, 24, 24, 1558, Opcodes.IFGE, 62)};
    private static final String x12 = "\r*> 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int extOut;
    private int height;
    private byte[] image;
    private int options;
    private short[] place;
    private int width;

    /* renamed from: ws */
    private int f19649ws;

    private static boolean isDigit(int i) {
        return i >= 48 && i <= 57;
    }

    private void setBit(int i, int i2, int i3) {
        byte[] bArr = this.image;
        int i4 = (i2 * i3) + (i / 8);
        bArr[i4] = (byte) (((byte) (128 >> (i & 7))) | bArr[i4]);
    }

    private void draw(byte[] bArr, int i, DmParams dmParams) {
        int i2;
        int i3 = ((dmParams.width + (this.f19649ws * 2)) + 7) / 8;
        Arrays.fill(this.image, (byte) 0);
        int i4 = this.f19649ws;
        while (true) {
            int i5 = dmParams.height;
            int i6 = this.f19649ws;
            if (i4 >= i5 + i6) {
                break;
            }
            while (i6 < dmParams.width + this.f19649ws) {
                setBit(i6, i4, i3);
                i6 += 2;
            }
            i4 += dmParams.heightSection;
        }
        int i7 = dmParams.heightSection - 1;
        int i8 = this.f19649ws;
        while (true) {
            i7 += i8;
            int i9 = dmParams.height;
            i2 = this.f19649ws;
            if (i7 >= i9 + i2) {
                break;
            }
            while (i2 < dmParams.width + this.f19649ws) {
                setBit(i2, i7, i3);
                i2++;
            }
            i8 = dmParams.heightSection;
        }
        while (true) {
            int i10 = dmParams.width;
            int i11 = this.f19649ws;
            if (i2 >= i10 + i11) {
                break;
            }
            while (i11 < dmParams.height + this.f19649ws) {
                setBit(i2, i11, i3);
                i11++;
            }
            i2 += dmParams.widthSection;
        }
        int i12 = dmParams.widthSection - 1;
        int i13 = this.f19649ws;
        while (true) {
            i12 += i13;
            int i14 = dmParams.width;
            int i15 = this.f19649ws;
            if (i12 >= i14 + i15) {
                break;
            }
            for (int i16 = i15 + 1; i16 < dmParams.height + this.f19649ws; i16 += 2) {
                setBit(i12, i16, i3);
            }
            i13 = dmParams.widthSection;
        }
        int i17 = 0;
        int i18 = 0;
        while (i17 < dmParams.height) {
            int i19 = i18;
            int i20 = 1;
            while (i20 < dmParams.heightSection - 1) {
                int i21 = i19;
                int i22 = 0;
                while (i22 < dmParams.width) {
                    int i23 = i21;
                    int i24 = 1;
                    while (i24 < dmParams.widthSection - 1) {
                        int i25 = i23 + 1;
                        short s = this.place[i23];
                        if (s != 1) {
                            if (s > 1) {
                                if (((128 >> (s % 8)) & bArr[(s / 8) - 1] & 255) == 0) {
                                }
                            }
                            i24++;
                            i23 = i25;
                        }
                        int i26 = this.f19649ws;
                        setBit(i24 + i22 + i26, i20 + i17 + i26, i3);
                        i24++;
                        i23 = i25;
                    }
                    i22 += dmParams.widthSection;
                    i21 = i23;
                }
                i20++;
                i19 = i21;
            }
            i17 += dmParams.heightSection;
            i18 = i19;
        }
    }

    private static void makePadding(byte[] bArr, int i, int i2) {
        if (i2 <= 0) {
            return;
        }
        int i3 = i + 1;
        bArr[i] = -127;
        while (true) {
            i2--;
            if (i2 <= 0) {
                return;
            }
            int i4 = i3 + 1;
            int i5 = ((i4 * Opcodes.FCMPL) % 253) + 129 + 1;
            if (i5 > 254) {
                i5 += UIMsg.m_AppUI.V_WM_LISTLISTUPDATE;
            }
            bArr[i3] = (byte) i5;
            i3 = i4;
        }
    }

    private static int asciiEncodation(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int i5 = i2 + i;
        int i6 = i4 + i3;
        int i7 = i3;
        while (i < i5) {
            if (i7 >= i6) {
                return -1;
            }
            int i8 = i + 1;
            int i9 = bArr[i] & 255;
            if (isDigit(i9) && i8 < i5 && isDigit(bArr[i8] & 255)) {
                bArr2[i7] = (byte) (((((i9 - 48) * 10) + (bArr[i8] & 255)) - 48) + 130);
                i7++;
                i = i8 + 1;
            } else if (i9 > 127) {
                int i10 = i7 + 1;
                if (i10 >= i6) {
                    return -1;
                }
                bArr2[i7] = -21;
                i7 = i10 + 1;
                bArr2[i10] = (byte) ((i9 - 128) + 1);
                i = i8;
            } else {
                bArr2[i7] = (byte) (i9 + 1);
                i7++;
                i = i8;
            }
        }
        return i7 - i3;
    }

    private static int b256Encodation(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        if (i2 == 0) {
            return 0;
        }
        if (i2 >= 250 || i2 + 2 <= i4) {
            if (i2 < 250 || i2 + 3 <= i4) {
                bArr2[i3] = -25;
                if (i2 < 250) {
                    bArr2[i3 + 1] = (byte) i2;
                    i5 = 2;
                } else {
                    bArr2[i3 + 1] = (byte) ((i2 / Type.TSIG) + Type.TKEY);
                    bArr2[i3 + 2] = (byte) (i2 % Type.TSIG);
                    i5 = 3;
                }
                System.arraycopy(bArr, i, bArr2, i5 + i3, i2);
                int i6 = i5 + i2 + i3;
                int i7 = i3 + 1;
                while (i7 < i6) {
                    int i8 = i7 + 1;
                    int i9 = (bArr2[i7] & 255) + ((i8 * Opcodes.FCMPL) % 255) + 1;
                    if (i9 > 255) {
                        i9 -= 256;
                    }
                    bArr2[i7] = (byte) i9;
                    i7 = i8;
                }
                return i6 - i3;
            }
            return -1;
        }
        return -1;
    }

    private static int X12Encodation(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int i5 = 0;
        if (i2 == 0) {
            return 0;
        }
        byte[] bArr3 = new byte[i2];
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i6 >= i2) {
                break;
            }
            int indexOf = x12.indexOf((char) bArr[i6 + i]);
            if (indexOf >= 0) {
                bArr3[i6] = (byte) indexOf;
                i7++;
            } else {
                bArr3[i6] = 100;
                if (i7 >= 6) {
                    i7 -= (i7 / 3) * 3;
                }
                for (int i8 = 0; i8 < i7; i8++) {
                    bArr3[(i6 - i8) - 1] = 100;
                }
                i7 = 0;
            }
            i6++;
        }
        if (i7 >= 6) {
            i7 -= (i7 / 3) * 3;
        }
        for (int i9 = 0; i9 < i7; i9++) {
            bArr3[(i6 - i9) - 1] = 100;
        }
        int i10 = 0;
        while (i5 < i2) {
            byte b = bArr3[i5];
            if (i10 >= i4) {
                break;
            } else if (b < 40) {
                if (i5 == 0 || (i5 > 0 && bArr3[i5 - 1] > 40)) {
                    bArr2[i10 + i3] = -18;
                    i10++;
                }
                if (i10 + 2 > i4) {
                    break;
                }
                i5 += 2;
                int i11 = (bArr3[i5] * 1600) + (bArr3[i5 + 1] * 40) + bArr3[i5] + 1;
                int i12 = i10 + 1;
                bArr2[i10 + i3] = (byte) (i11 / 256);
                i10 = i12 + 1;
                bArr2[i12 + i3] = (byte) i11;
                i5++;
            } else {
                if (i5 > 0 && bArr3[i5 - 1] < 40) {
                    bArr2[i10 + i3] = -2;
                    i10++;
                }
                int i13 = bArr[i5 + i] & 255;
                if (i13 > 127) {
                    bArr2[i10 + i3] = -21;
                    i13 -= 128;
                    i10++;
                }
                if (i10 >= i4) {
                    break;
                }
                bArr2[i10 + i3] = (byte) (i13 + 1);
                i10++;
                i5++;
            }
        }
        byte b2 = i2 > 0 ? bArr3[i2 - 1] : (byte) 100;
        if (i5 == i2) {
            if (b2 >= 40 || i10 < i4) {
                if (b2 < 40) {
                    int i14 = i10 + 1;
                    bArr2[i3 + i10] = -2;
                    return i14;
                }
                return i10;
            }
            return -1;
        }
        return -1;
    }

    private static int EdifactEncodation(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        if (i2 == 0) {
            return 0;
        }
        int i6 = 0;
        boolean z = true;
        int i7 = 0;
        int i8 = 18;
        int i9 = 0;
        while (i6 < i2) {
            int i10 = bArr[i6 + i] & 255;
            int i11 = i10 & 224;
            if ((i11 != 64 && i11 != 32) || i10 == 95) {
                if (!z) {
                    i7 |= 31 << i8;
                    if ((i9 + 3) - (i8 / 8) > i4) {
                        break;
                    }
                    int i12 = i9 + 1;
                    bArr2[i3 + i9] = (byte) (i7 >> 16);
                    if (i8 <= 12) {
                        bArr2[i3 + i12] = (byte) (i7 >> 8);
                        i12++;
                    }
                    if (i8 <= 6) {
                        bArr2[i3 + i12] = (byte) i7;
                        i12++;
                    }
                    i9 = i12;
                    z = true;
                    i7 = 0;
                    i8 = 18;
                }
                if (i10 > 127) {
                    if (i9 >= i4) {
                        break;
                    }
                    bArr2[i3 + i9] = -21;
                    i10 -= 128;
                    i9++;
                }
                if (i9 >= i4) {
                    break;
                }
                bArr2[i3 + i9] = (byte) (i10 + 1);
                i9++;
                i6++;
            } else {
                if (z) {
                    int i13 = i9 + 1;
                    if (i13 > i4) {
                        break;
                    }
                    bArr2[i3 + i9] = -16;
                    i9 = i13;
                    z = false;
                }
                i7 |= (i10 & 63) << i8;
                if (i8 != 0) {
                    i8 -= 6;
                } else if (i9 + 3 > i4) {
                    break;
                } else {
                    int i14 = i9 + 1;
                    bArr2[i3 + i9] = (byte) (i7 >> 16);
                    int i15 = i14 + 1;
                    bArr2[i3 + i14] = (byte) (i7 >> 8);
                    bArr2[i3 + i15] = (byte) i7;
                    i9 = i15 + 1;
                    i7 = 0;
                    i8 = 18;
                }
                i6++;
            }
        }
        if (i6 != i2) {
            return -1;
        }
        if (z) {
            return i9;
        }
        int i16 = (31 << i8) | i7;
        if ((i9 + 3) - (i8 / 8) > i4) {
            return -1;
        }
        int i17 = i9 + 1;
        bArr2[i3 + i9] = (byte) (i16 >> 16);
        if (i8 <= 12) {
            bArr2[i3 + i17] = (byte) (i16 >> 8);
            i5 = i17 + 1;
        } else {
            i5 = i17;
        }
        if (i8 <= 6) {
            int i18 = i5 + 1;
            bArr2[i3 + i5] = (byte) i16;
            return i18;
        }
        return i5;
    }

    private static int C40OrTextEncodation(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, boolean z) {
        String str;
        String str2;
        if (i2 == 0) {
            return 0;
        }
        if (z) {
            bArr2[i3 + 0] = -26;
        } else {
            bArr2[i3 + 0] = -17;
        }
        if (z) {
            str = " 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            str2 = "`abcdefghijklmnopqrstuvwxyz{|}~\u007f";
        } else {
            str = " 0123456789abcdefghijklmnopqrstuvwxyz";
            str2 = "`ABCDEFGHIJKLMNOPQRSTUVWXYZ{|}~\u007f";
        }
        int[] iArr = new int[(i2 * 4) + 10];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i5 < i2) {
            if (i6 % 3 == 0) {
                i7 = i5;
                i8 = i6;
            }
            int i9 = i5 + 1;
            int i10 = bArr[i + i5] & 255;
            if (i10 > 127) {
                i10 -= 128;
                int i11 = i6 + 1;
                iArr[i6] = 1;
                i6 = i11 + 1;
                iArr[i11] = 30;
            }
            char c = (char) i10;
            int indexOf = str.indexOf(c);
            if (indexOf >= 0) {
                iArr[i6] = indexOf + 3;
                i6++;
                i5 = i9;
            } else if (i10 < 32) {
                int i12 = i6 + 1;
                iArr[i6] = 0;
                i6 = i12 + 1;
                iArr[i12] = i10;
                i5 = i9;
            } else {
                int indexOf2 = "!\"#$%&'()*+,-./:;<=>?@[\\]^_".indexOf(c);
                if (indexOf2 >= 0) {
                    int i13 = i6 + 1;
                    iArr[i6] = 1;
                    i6 = i13 + 1;
                    iArr[i13] = indexOf2;
                    i5 = i9;
                } else {
                    int indexOf3 = str2.indexOf(c);
                    if (indexOf3 >= 0) {
                        int i14 = i6 + 1;
                        iArr[i6] = 2;
                        i6 = i14 + 1;
                        iArr[i14] = indexOf3;
                    }
                    i5 = i9;
                }
            }
        }
        if (i6 % 3 != 0) {
            i5 = i7;
        } else {
            i8 = i6;
        }
        if ((i8 / 3) * 2 > i4 - 2) {
            return -1;
        }
        int i15 = 1;
        for (int i16 = 0; i16 < i8; i16 += 3) {
            int i17 = (iArr[i16] * 1600) + (iArr[i16 + 1] * 40) + iArr[i16 + 2] + 1;
            int i18 = i15 + 1;
            bArr2[i3 + i15] = (byte) (i17 / 256);
            i15 = i18 + 1;
            bArr2[i3 + i18] = (byte) i17;
        }
        int i19 = i15 + 1;
        bArr2[i15] = -2;
        int asciiEncodation = asciiEncodation(bArr, i5, i2 - i5, bArr2, i19, i4 - i19);
        return asciiEncodation < 0 ? asciiEncodation : i19 + asciiEncodation;
    }

    private static int getEncodation(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, boolean z) {
        int[] iArr = new int[6];
        if (i4 < 0) {
            return -1;
        }
        int i6 = i5 & 7;
        if (i6 == 0) {
            iArr[0] = asciiEncodation(bArr, i, i2, bArr2, i3, i4);
            if (z && iArr[0] >= 0) {
                return iArr[0];
            }
            iArr[1] = C40OrTextEncodation(bArr, i, i2, bArr2, i3, i4, false);
            if (z && iArr[1] >= 0) {
                return iArr[1];
            }
            iArr[2] = C40OrTextEncodation(bArr, i, i2, bArr2, i3, i4, true);
            if (z && iArr[2] >= 0) {
                return iArr[2];
            }
            iArr[3] = b256Encodation(bArr, i, i2, bArr2, i3, i4);
            if (z && iArr[3] >= 0) {
                return iArr[3];
            }
            iArr[4] = X12Encodation(bArr, i, i2, bArr2, i3, i4);
            if (z && iArr[4] >= 0) {
                return iArr[4];
            }
            iArr[5] = EdifactEncodation(bArr, i, i2, bArr2, i3, i4);
            if (z && iArr[5] >= 0) {
                return iArr[5];
            }
            if (iArr[0] >= 0 || iArr[1] >= 0 || iArr[2] >= 0 || iArr[3] >= 0 || iArr[4] >= 0 || iArr[5] >= 0) {
                int i7 = 0;
                int i8 = 99999;
                for (int i9 = 0; i9 < 6; i9++) {
                    if (iArr[i9] >= 0 && iArr[i9] < i8) {
                        i8 = iArr[i9];
                        i7 = i9;
                    }
                }
                if (i7 == 0) {
                    return asciiEncodation(bArr, i, i2, bArr2, i3, i4);
                }
                if (i7 == 1) {
                    return C40OrTextEncodation(bArr, i, i2, bArr2, i3, i4, false);
                }
                if (i7 == 2) {
                    return C40OrTextEncodation(bArr, i, i2, bArr2, i3, i4, true);
                }
                if (i7 == 3) {
                    return b256Encodation(bArr, i, i2, bArr2, i3, i4);
                }
                return i7 == 4 ? X12Encodation(bArr, i, i2, bArr2, i3, i4) : i8;
            }
            return -1;
        }
        switch (i6) {
            case 1:
                return asciiEncodation(bArr, i, i2, bArr2, i3, i4);
            case 2:
                return C40OrTextEncodation(bArr, i, i2, bArr2, i3, i4, true);
            case 3:
                return C40OrTextEncodation(bArr, i, i2, bArr2, i3, i4, false);
            case 4:
                return b256Encodation(bArr, i, i2, bArr2, i3, i4);
            case 5:
                return X12Encodation(bArr, i, i2, bArr2, i3, i4);
            case 6:
                return EdifactEncodation(bArr, i, i2, bArr2, i3, i4);
            case 7:
                if (i2 > i4) {
                    return -1;
                }
                System.arraycopy(bArr, i, bArr2, i3, i2);
                return i2;
            default:
                return -1;
        }
    }

    private static int getNumber(byte[] bArr, int i, int i2) {
        int i3 = 0;
        int i4 = i;
        int i5 = 0;
        while (i3 < i2) {
            int i6 = i4 + 1;
            int i7 = bArr[i4] & 255;
            if (i7 < 48 || i7 > 57) {
                return -1;
            }
            i5 = ((i5 * 10) + i7) - 48;
            i3++;
            i4 = i6;
        }
        return i5;
    }

    private int processExtensions(byte[] bArr, int i, int i2, byte[] bArr2) {
        int number;
        int number2;
        int i3 = 0;
        if ((this.options & 32) == 0) {
            return 0;
        }
        int i4 = 0;
        int i5 = 0;
        while (i3 < i2 && i4 <= 20) {
            int i6 = i3 + 1;
            int i7 = bArr[i3 + i] & 255;
            i4++;
            if (i7 == 46) {
                this.extOut = i6;
                return i5;
            } else if (i7 != 109) {
                if (i7 != 112) {
                    if (i7 != 115) {
                        switch (i7) {
                            case 101:
                                i3 = i6 + 6;
                                if (i3 <= i2 && (number = getNumber(bArr, i6 + i, 6)) >= 0) {
                                    int i8 = i5 + 1;
                                    bArr2[i5] = -15;
                                    if (number >= 127) {
                                        if (number < 16383) {
                                            int i9 = i8 + 1;
                                            int i10 = number - 127;
                                            bArr2[i8] = (byte) ((i10 / 254) + 128);
                                            bArr2[i9] = (byte) ((i10 % 254) + 1);
                                            i5 = i9 + 1;
                                            break;
                                        } else {
                                            int i11 = i8 + 1;
                                            int i12 = number - 16383;
                                            bArr2[i8] = (byte) ((i12 / 64516) + 192);
                                            int i13 = i11 + 1;
                                            bArr2[i11] = (byte) (((i12 / 254) % 254) + 1);
                                            i5 = i13 + 1;
                                            bArr2[i13] = (byte) ((i12 % 254) + 1);
                                            break;
                                        }
                                    } else {
                                        i5 = i8 + 1;
                                        bArr2[i8] = (byte) (number + 1);
                                        break;
                                    }
                                } else {
                                    return -1;
                                }
                            case 102:
                                if (i4 == 1 || (i4 == 2 && (bArr[i] == 115 || bArr[i] == 109))) {
                                    bArr2[i5] = -24;
                                    i5++;
                                    i3 = i6;
                                    break;
                                } else {
                                    return -1;
                                }
                            default:
                                i3 = i6;
                                break;
                        }
                    } else if (i4 != 1 || i6 + 9 > i2 || (number2 = getNumber(bArr, i + i6, 2)) <= 0 || number2 > 16) {
                        return -1;
                    } else {
                        int i14 = i6 + 2;
                        int number3 = getNumber(bArr, i + i14, 2);
                        if (number3 <= 1 || number3 > 16) {
                            return -1;
                        }
                        int i15 = i14 + 2;
                        int number4 = getNumber(bArr, i + i15, 5);
                        if (number4 < 0 || number2 >= 64516) {
                            return -1;
                        }
                        int i16 = i15 + 5;
                        int i17 = i5 + 1;
                        bArr2[i5] = -23;
                        int i18 = i17 + 1;
                        bArr2[i17] = (byte) (((number2 - 1) << 4) | (17 - number3));
                        int i19 = i18 + 1;
                        bArr2[i18] = (byte) ((number4 / 254) + 1);
                        i5 = i19 + 1;
                        bArr2[i19] = (byte) ((number4 % 254) + 1);
                        i3 = i16;
                    }
                } else if (i4 != 1) {
                    return -1;
                } else {
                    bArr2[i5] = -22;
                    i5++;
                    i3 = i6;
                }
            } else if (i4 != 1 || (i3 = i6 + 1) > i2) {
                return -1;
            } else {
                int i20 = bArr[i6 + i] & 255;
                if (i20 != 53 && i20 != 53) {
                    return -1;
                }
                int i21 = i5 + 1;
                bArr2[i5] = -22;
                i5 = i21 + 1;
                bArr2[i21] = (byte) (i20 == 53 ? SmileConstants.TOKEN_MISC_SHARED_STRING_LONG : Jpeg.M_APPD);
            }
        }
        return -1;
    }

    public int generate(String str) throws UnsupportedEncodingException {
        byte[] bytes = str.getBytes("iso-8859-1");
        return generate(bytes, 0, bytes.length);
    }

    public int generate(byte[] bArr, int i, int i2) {
        int i3;
        DmParams dmParams;
        byte[] bArr2 = new byte[DefaultRetryPolicy.DEFAULT_TIMEOUT_MS];
        this.extOut = 0;
        int processExtensions = processExtensions(bArr, i, i2, bArr2);
        if (processExtensions < 0) {
            return 5;
        }
        if (this.height == 0 || this.width == 0) {
            DmParams[] dmParamsArr = dmSizes;
            DmParams dmParams2 = dmParamsArr[dmParamsArr.length - 1];
            int i4 = this.extOut;
            int encodation = getEncodation(bArr, i + i4, i2 - i4, bArr2, processExtensions, dmParams2.dataSize - processExtensions, this.options, false);
            if (encodation < 0) {
                return 1;
            }
            i3 = encodation + processExtensions;
            int i5 = 0;
            while (true) {
                DmParams[] dmParamsArr2 = dmSizes;
                if (i5 >= dmParamsArr2.length || dmParamsArr2[i5].dataSize >= i3) {
                    break;
                }
                i5++;
            }
            dmParams = dmSizes[i5];
            this.height = dmParams.height;
            this.width = dmParams.width;
        } else {
            int i6 = 0;
            while (true) {
                DmParams[] dmParamsArr3 = dmSizes;
                if (i6 >= dmParamsArr3.length || (this.height == dmParamsArr3[i6].height && this.width == dmSizes[i6].width)) {
                    break;
                }
                i6++;
            }
            DmParams[] dmParamsArr4 = dmSizes;
            if (i6 == dmParamsArr4.length) {
                return 3;
            }
            dmParams = dmParamsArr4[i6];
            int i7 = this.extOut;
            int encodation2 = getEncodation(bArr, i + i7, i2 - i7, bArr2, processExtensions, dmParams.dataSize - processExtensions, this.options, true);
            if (encodation2 < 0) {
                return 1;
            }
            i3 = encodation2 + processExtensions;
        }
        if ((this.options & 64) != 0) {
            return 0;
        }
        this.image = new byte[(((dmParams.width + (this.f19649ws * 2)) + 7) / 8) * (dmParams.height + (this.f19649ws * 2))];
        makePadding(bArr2, i3, dmParams.dataSize - i3);
        this.place = Placement.doPlacement(dmParams.height - ((dmParams.height / dmParams.heightSection) * 2), dmParams.width - ((dmParams.width / dmParams.widthSection) * 2));
        int i8 = dmParams.dataSize + (((dmParams.dataSize + 2) / dmParams.dataBlock) * dmParams.errorBlock);
        ReedSolomon.generateECC(bArr2, dmParams.dataSize, dmParams.dataBlock, dmParams.errorBlock);
        draw(bArr2, i8, dmParams);
        return 0;
    }

    public Image createImage() throws BadElementException {
        byte[] bArr = this.image;
        if (bArr == null) {
            return null;
        }
        int i = this.width;
        int i2 = this.f19649ws;
        byte[] compress = CCITTG4Encoder.compress(bArr, i + (i2 * 2), this.height + (i2 * 2));
        int i3 = this.width;
        int i4 = this.f19649ws;
        return Image.getInstance(i3 + (i4 * 2), this.height + (i4 * 2), false, 256, 0, compress, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class DmParams {
        int dataBlock;
        int dataSize;
        int errorBlock;
        int height;
        int heightSection;
        int width;
        int widthSection;

        DmParams(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.height = i;
            this.width = i2;
            this.heightSection = i3;
            this.widthSection = i4;
            this.dataSize = i5;
            this.dataBlock = i6;
            this.errorBlock = i7;
        }
    }

    public byte[] getImage() {
        return this.image;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getWs() {
        return this.f19649ws;
    }

    public void setWs(int i) {
        this.f19649ws = i;
    }

    public int getOptions() {
        return this.options;
    }

    public void setOptions(int i) {
        this.options = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Placement {
        private static final Hashtable<Integer, short[]> cache = new Hashtable<>();
        private short[] array;
        private int ncol;
        private int nrow;

        private Placement() {
        }

        static short[] doPlacement(int i, int i2) {
            Integer valueOf = Integer.valueOf((i * 1000) + i2);
            short[] sArr = cache.get(valueOf);
            if (sArr != null) {
                return sArr;
            }
            Placement placement = new Placement();
            placement.nrow = i;
            placement.ncol = i2;
            placement.array = new short[i * i2];
            placement.ecc200();
            cache.put(valueOf, placement.array);
            return placement.array;
        }

        private void module(int i, int i2, int i3, int i4) {
            if (i < 0) {
                int i5 = this.nrow;
                i += i5;
                i2 += 4 - ((i5 + 4) % 8);
            }
            if (i2 < 0) {
                int i6 = this.ncol;
                i2 += i6;
                i += 4 - ((i6 + 4) % 8);
            }
            this.array[(i * this.ncol) + i2] = (short) ((i3 * 8) + i4);
        }

        private void utah(int i, int i2, int i3) {
            int i4 = i - 2;
            int i5 = i2 - 2;
            module(i4, i5, i3, 0);
            int i6 = i2 - 1;
            module(i4, i6, i3, 1);
            int i7 = i - 1;
            module(i7, i5, i3, 2);
            module(i7, i6, i3, 3);
            module(i7, i2, i3, 4);
            module(i, i5, i3, 5);
            module(i, i6, i3, 6);
            module(i, i2, i3, 7);
        }

        private void corner1(int i) {
            module(this.nrow - 1, 0, i, 0);
            module(this.nrow - 1, 1, i, 1);
            module(this.nrow - 1, 2, i, 2);
            module(0, this.ncol - 2, i, 3);
            module(0, this.ncol - 1, i, 4);
            module(1, this.ncol - 1, i, 5);
            module(2, this.ncol - 1, i, 6);
            module(3, this.ncol - 1, i, 7);
        }

        private void corner2(int i) {
            module(this.nrow - 3, 0, i, 0);
            module(this.nrow - 2, 0, i, 1);
            module(this.nrow - 1, 0, i, 2);
            module(0, this.ncol - 4, i, 3);
            module(0, this.ncol - 3, i, 4);
            module(0, this.ncol - 2, i, 5);
            module(0, this.ncol - 1, i, 6);
            module(1, this.ncol - 1, i, 7);
        }

        private void corner3(int i) {
            module(this.nrow - 3, 0, i, 0);
            module(this.nrow - 2, 0, i, 1);
            module(this.nrow - 1, 0, i, 2);
            module(0, this.ncol - 2, i, 3);
            module(0, this.ncol - 1, i, 4);
            module(1, this.ncol - 1, i, 5);
            module(2, this.ncol - 1, i, 6);
            module(3, this.ncol - 1, i, 7);
        }

        private void corner4(int i) {
            module(this.nrow - 1, 0, i, 0);
            module(this.nrow - 1, this.ncol - 1, i, 1);
            module(0, this.ncol - 3, i, 2);
            module(0, this.ncol - 2, i, 3);
            module(0, this.ncol - 1, i, 4);
            module(1, this.ncol - 3, i, 5);
            module(1, this.ncol - 2, i, 6);
            module(1, this.ncol - 1, i, 7);
        }

        private void ecc200() {
            int i;
            int i2;
            Arrays.fill(this.array, (short) 0);
            int i3 = 4;
            int i4 = 0;
            int i5 = 1;
            while (true) {
                if (i3 == this.nrow && i4 == 0) {
                    corner1(i5);
                    i5++;
                }
                if (i3 == this.nrow - 2 && i4 == 0 && this.ncol % 4 != 0) {
                    corner2(i5);
                    i5++;
                }
                if (i3 == this.nrow - 2 && i4 == 0 && this.ncol % 8 == 4) {
                    corner3(i5);
                    i5++;
                }
                if (i3 == this.nrow + 4 && i4 == 2 && this.ncol % 8 == 0) {
                    corner4(i5);
                    i5++;
                }
                do {
                    if (i3 < this.nrow && i4 >= 0 && this.array[(this.ncol * i3) + i4] == 0) {
                        utah(i3, i4, i5);
                        i5++;
                    }
                    i3 -= 2;
                    i4 += 2;
                    if (i3 < 0) {
                        break;
                    }
                } while (i4 < this.ncol);
                int i6 = i3 + 1;
                int i7 = i4 + 3;
                do {
                    if (i6 >= 0) {
                        int i8 = this.ncol;
                        if (i7 < i8 && this.array[(i8 * i6) + i7] == 0) {
                            utah(i6, i7, i5);
                            i5++;
                        }
                    }
                    i6 += 2;
                    i7 -= 2;
                    if (i6 >= this.nrow) {
                        break;
                    }
                } while (i7 >= 0);
                i3 = i6 + 3;
                i4 = i7 + 1;
                i = this.nrow;
                if (i3 >= i && i4 >= (i2 = this.ncol)) {
                    break;
                }
            }
            short[] sArr = this.array;
            if (sArr[(i * i2) - 1] == 0) {
                sArr[((i * i2) - i2) - 2] = 1;
                sArr[(i * i2) - 1] = 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ReedSolomon {
        private static final int[] log = {0, 255, 1, 240, 2, 225, 241, 53, 3, 38, Jpeg.M_APP2, 133, 242, 43, 54, 210, 4, Opcodes.MONITOREXIT, 39, 114, 227, 106, 134, 28, WKSRecord.Service.SUR_MEAS, 140, 44, 23, 55, Opcodes.FNEG, 211, 234, 5, 219, SmileConstants.MIN_BUFFER_FOR_POSSIBLE_SHORT_STRING, 96, 40, 222, 115, 103, SmileConstants.TOKEN_MISC_LONG_TEXT_UNICODE, 78, 107, 125, 135, 8, 29, 162, 244, Opcodes.INVOKEDYNAMIC, 141, Opcodes.GETFIELD, 45, 99, 24, 49, 56, 13, 119, Opcodes.IFEQ, 212, Opcodes.IFNONNULL, 235, 91, 6, 76, 220, 217, Opcodes.MULTIANEWARRAY, 11, 97, Opcodes.INVOKESTATIC, 41, 36, 223, 253, Opcodes.INEG, 138, 104, Opcodes.INSTANCEOF, 229, 86, 79, Opcodes.LOOKUPSWITCH, 108, Opcodes.IF_ACMPEQ, Opcodes.IAND, Opcodes.I2B, 136, 34, 9, 74, 30, 32, Opcodes.IF_ICMPGT, 84, 245, Opcodes.LRETURN, Opcodes.NEW, 204, 142, 81, Opcodes.PUTFIELD, Opcodes.ARRAYLENGTH, 46, 88, 100, Opcodes.IF_ICMPEQ, 25, 231, 50, 207, 57, Opcodes.I2S, 14, 67, Opcodes.ISHL, 128, Opcodes.IFNE, 248, 213, 167, PdfContentParser.COMMAND_TYPE, 63, SmileConstants.TOKEN_MISC_SHARED_STRING_LONG, 110, 92, Opcodes.ARETURN, 7, 161, 77, Opcodes.IUSHR, 221, 102, 218, 95, Opcodes.IFNULL, 90, 12, Opcodes.DCMPG, 98, 48, Opcodes.INVOKEINTERFACE, Opcodes.PUTSTATIC, 42, 209, 37, 132, 224, 52, 254, 239, 117, 233, 139, 22, 105, 27, Opcodes.MONITORENTER, 113, 230, 206, 87, Opcodes.IFLE, 80, Opcodes.ANEWARRAY, Opcodes.IRETURN, 203, 109, Opcodes.DRETURN, Opcodes.IF_ACMPNE, 62, 127, MetaDo.META_CREATEPALETTE, Opcodes.I2C, 66, 137, 192, 35, 252, 10, Opcodes.INVOKESPECIAL, 75, 216, 31, 83, 33, 73, Opcodes.IF_ICMPLE, Opcodes.D2F, 85, Opcodes.TABLESWITCH, 246, 65, Opcodes.FRETURN, 61, Opcodes.NEWARRAY, 202, 205, Opcodes.IFGT, Opcodes.D2L, Opcodes.RET, 82, 72, Opcodes.INVOKEVIRTUAL, 215, Opcodes.ATHROW, Type.IXFR, 47, Opcodes.GETSTATIC, 89, Opcodes.DCMPL, 101, 94, 160, 123, 26, 112, SmileConstants.TOKEN_MISC_BINARY_7BIT, 21, 51, Jpeg.M_APPE, 208, 131, 58, 69, Opcodes.LCMP, 18, 15, 16, 68, 17, 121, Opcodes.FCMPL, 129, 19, Opcodes.IFLT, 59, Type.TKEY, 70, 214, Type.TSIG, Opcodes.JSR, 71, 201, Opcodes.IFGE, 64, 60, Jpeg.M_APPD, 130, 111, 20, 93, Opcodes.ISHR, Opcodes.RETURN, 150};
        private static final int[] alog = {1, 2, 4, 8, 16, 32, 64, 128, 45, 90, Opcodes.GETFIELD, 69, 138, 57, 114, SmileConstants.TOKEN_MISC_LONG_TEXT_UNICODE, 229, 231, 227, 235, Type.IXFR, 219, Opcodes.IFLT, 27, 54, 108, 216, Opcodes.IFGT, 23, 46, 92, Opcodes.INVOKESTATIC, 93, Opcodes.INVOKEDYNAMIC, 89, Opcodes.GETSTATIC, 73, Opcodes.I2C, 9, 18, 36, 72, Opcodes.D2F, 13, 26, 52, 104, 208, 141, 55, 110, 220, Opcodes.FCMPL, 7, 14, 28, 56, 112, 224, Jpeg.M_APPD, MetaDo.META_CREATEPALETTE, Opcodes.MONITOREXIT, Opcodes.LOOKUPSWITCH, 123, 246, Opcodes.INSTANCEOF, Opcodes.DRETURN, 115, 230, 225, 239, WKSRecord.Service.SUR_MEAS, 203, Opcodes.NEW, 91, Opcodes.INVOKEVIRTUAL, 65, 130, 41, 82, Opcodes.IF_ICMPLE, 101, 202, Opcodes.INVOKEINTERFACE, 95, Opcodes.ARRAYLENGTH, 81, 162, 105, 210, 137, 63, Opcodes.IAND, 252, 213, 135, 35, 70, 140, 53, 106, 212, 133, 39, 78, Opcodes.IFGE, 21, 42, 84, Opcodes.JSR, 125, Type.TSIG, 217, Opcodes.IF_ICMPEQ, 19, 38, 76, Opcodes.DCMPG, 29, 58, Opcodes.INEG, SmileConstants.TOKEN_MISC_BINARY_7BIT, 253, 215, 131, 43, 86, Opcodes.IRETURN, 117, 234, Type.TKEY, 223, Opcodes.I2S, 11, 22, 44, 88, Opcodes.ARETURN, 77, Opcodes.IFNE, 25, 50, 100, PdfContentParser.COMMAND_TYPE, Opcodes.ANEWARRAY, 87, Opcodes.FRETURN, 113, Jpeg.M_APP2, 233, 255, 211, 139, 59, Opcodes.FNEG, SmileConstants.TOKEN_MISC_SHARED_STRING_LONG, 245, Opcodes.IFNONNULL, Opcodes.IF_ICMPGT, 107, 214, 129, 47, 94, Opcodes.NEWARRAY, 85, Opcodes.TABLESWITCH, 121, 242, 201, Opcodes.ATHROW, 83, Opcodes.IF_ACMPNE, 97, Opcodes.MONITORENTER, Opcodes.RET, 127, 254, 209, Opcodes.D2L, 51, 102, 204, Opcodes.PUTFIELD, 71, 142, 49, 98, SmileConstants.MIN_BUFFER_FOR_POSSIBLE_SHORT_STRING, Opcodes.IF_ACMPEQ, 103, 206, Opcodes.RETURN, 79, Opcodes.IFLE, 17, 34, 68, 136, 61, Opcodes.ISHR, 244, Opcodes.MULTIANEWARRAY, 167, 99, Opcodes.IFNULL, 161, 111, 222, Opcodes.I2B, 15, 30, 60, Opcodes.ISHL, 240, 205, Opcodes.INVOKESPECIAL, 67, 134, 33, 66, 132, 37, 74, Opcodes.LCMP, 5, 10, 20, 40, 80, 160, 109, 218, Opcodes.IFEQ, 31, 62, Opcodes.IUSHR, 248, 221, Opcodes.DCMPL, 3, 6, 12, 24, 48, 96, 192, Opcodes.LRETURN, 119, Jpeg.M_APPE, 241, 207, Opcodes.PUTSTATIC, 75, 150, 1};
        private static final int[] poly5 = {SmileConstants.TOKEN_MISC_LONG_TEXT_UNICODE, 48, 15, 111, 62};
        private static final int[] poly7 = {23, 68, Opcodes.D2F, 134, 240, 92, 254};
        private static final int[] poly10 = {28, 24, Opcodes.INVOKEINTERFACE, Opcodes.IF_ACMPNE, 223, 248, Opcodes.INEG, 255, 110, 61};
        private static final int[] poly11 = {Opcodes.DRETURN, 138, 205, 12, Opcodes.MONITORENTER, Opcodes.JSR, 39, 245, 60, 97, Opcodes.ISHL};
        private static final int[] poly12 = {41, Opcodes.IFEQ, Opcodes.IFLE, 91, 61, 42, 142, 213, 97, Opcodes.GETSTATIC, 100, 242};
        private static final int[] poly14 = {Opcodes.IFGE, 97, 192, 252, 95, 9, Opcodes.IFGT, 119, 138, 45, 18, Opcodes.INVOKEDYNAMIC, 83, Opcodes.INVOKEINTERFACE};
        private static final int[] poly18 = {83, Opcodes.MONITOREXIT, 100, 39, Opcodes.NEWARRAY, 75, 66, 61, 241, 213, 109, 129, 94, 254, 225, 48, 90, Opcodes.NEWARRAY};
        private static final int[] poly20 = {15, Opcodes.MONITOREXIT, 244, 9, 233, 71, Opcodes.JSR, 2, Opcodes.NEWARRAY, 160, Opcodes.IFEQ, Opcodes.I2B, 253, 79, 108, 82, 27, Opcodes.FRETURN, Opcodes.INVOKEDYNAMIC, Opcodes.IRETURN};
        private static final int[] poly24 = {52, Opcodes.ARRAYLENGTH, 88, 205, 109, 39, Opcodes.ARETURN, 21, Opcodes.IFLT, Opcodes.MULTIANEWARRAY, Type.IXFR, 223, Opcodes.IFLT, 21, 5, Opcodes.IRETURN, 254, Opcodes.IUSHR, 12, Opcodes.PUTFIELD, Opcodes.INVOKESTATIC, 96, 50, Opcodes.INSTANCEOF};
        private static final int[] poly28 = {211, 231, 43, 97, 71, 96, 103, Opcodes.FRETURN, 37, Opcodes.DCMPL, Opcodes.TABLESWITCH, 53, 75, 34, Type.TKEY, 121, 17, 138, 110, 213, 141, 136, Opcodes.ISHL, Opcodes.DCMPL, 233, Opcodes.JSR, 93, 255};
        private static final int[] poly36 = {245, 127, 242, 218, 130, Type.TSIG, 162, Opcodes.PUTFIELD, 102, Opcodes.ISHL, 84, Opcodes.PUTSTATIC, 220, Type.IXFR, 80, Opcodes.INVOKEVIRTUAL, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, Opcodes.DRETURN, Opcodes.INVOKESTATIC, 59, 25, 225, 98, 81, 112};
        private static final int[] poly42 = {77, Opcodes.INSTANCEOF, 137, 31, 19, 38, 22, Opcodes.IFEQ, MetaDo.META_CREATEPALETTE, 105, Opcodes.ISHR, 2, 245, 133, 242, 8, Opcodes.DRETURN, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, Opcodes.RETURN, Jpeg.M_APP2, 5, 9, 5};
        private static final int[] poly48 = {245, 132, Opcodes.IRETURN, 223, 96, 32, 117, 22, Jpeg.M_APPE, 133, Jpeg.M_APPE, 231, 205, Opcodes.NEWARRAY, Jpeg.M_APPD, 87, Opcodes.ATHROW, 106, 16, Opcodes.I2S, Opcodes.FNEG, 23, 37, 90, Opcodes.TABLESWITCH, 205, 131, 88, Opcodes.ISHL, 100, 66, 138, Opcodes.INVOKEDYNAMIC, 240, 82, 44, Opcodes.ARETURN, 87, Opcodes.NEW, Opcodes.I2S, 160, Opcodes.DRETURN, 69, 213, 92, 253, 225, 19};
        private static final int[] poly56 = {Opcodes.DRETURN, 9, 223, Jpeg.M_APPE, 12, 17, 220, 208, 100, 29, Opcodes.DRETURN, Opcodes.TABLESWITCH, 230, 192, 215, 235, 150, Opcodes.IF_ICMPEQ, 36, 223, 38, PdfContentParser.COMMAND_TYPE, 132, 54, SmileConstants.TOKEN_MISC_LONG_TEXT_UNICODE, Opcodes.I2C, 218, 234, 117, 203, 29, SmileConstants.TOKEN_MISC_BINARY_7BIT, Opcodes.D2F, Jpeg.M_APPE, 22, 150, 201, 117, 62, 207, Opcodes.IF_ICMPLE, 13, 137, 245, 127, 67, MetaDo.META_CREATEPALETTE, 28, Opcodes.IFLT, 43, 203, 107, 233, 53, Opcodes.D2L, 46};
        private static final int[] poly62 = {242, 93, Opcodes.RET, 50, Opcodes.D2F, 210, 39, Opcodes.FNEG, 202, Opcodes.NEWARRAY, 201, Opcodes.ANEWARRAY, Opcodes.D2L, 108, SmileConstants.MIN_BUFFER_FOR_POSSIBLE_SHORT_STRING, 37, Opcodes.INVOKEINTERFACE, 112, 134, 230, 245, 63, Opcodes.MULTIANEWARRAY, Opcodes.ARRAYLENGTH, Type.TSIG, 106, Opcodes.INVOKEINTERFACE, 221, Opcodes.DRETURN, 64, 114, 71, 161, 44, Opcodes.I2S, 6, 27, 218, 51, 63, 87, 10, 40, 130, Opcodes.NEWARRAY, 17, Opcodes.IF_ICMPGT, 31, Opcodes.ARETURN, Opcodes.TABLESWITCH, 4, 107, SmileConstants.TOKEN_MISC_BINARY_7BIT, 7, 94, Opcodes.IF_ACMPNE, 224, Opcodes.IUSHR, 86, 47, 11, 204};
        private static final int[] poly68 = {220, SmileConstants.TOKEN_MISC_LONG_TEXT_UNICODE, Opcodes.LRETURN, 89, Type.IXFR, Opcodes.FCMPL, Opcodes.IF_ICMPEQ, 56, 89, 33, Opcodes.I2S, 244, Opcodes.IFNE, 36, 73, 127, 213, 136, 248, Opcodes.GETFIELD, 234, Opcodes.MULTIANEWARRAY, Opcodes.IFLE, Opcodes.RETURN, 68, Opcodes.ISHR, 93, 213, 15, 160, 227, SmileConstants.TOKEN_MISC_SHARED_STRING_LONG, 66, 139, Opcodes.IFEQ, Opcodes.INVOKEINTERFACE, 202, 167, Opcodes.PUTSTATIC, 25, 220, SmileConstants.TOKEN_MISC_BINARY_7BIT, 96, 210, 231, 136, 223, 239, Opcodes.PUTFIELD, 241, 59, 52, Opcodes.IRETURN, 25, 49, SmileConstants.TOKEN_MISC_BINARY_7BIT, 211, Opcodes.ANEWARRAY, 64, 54, 108, Opcodes.IFEQ, 132, 63, 96, 103, 82, Opcodes.INVOKEDYNAMIC};

        ReedSolomon() {
        }

        private static int[] getPoly(int i) {
            switch (i) {
                case 5:
                    return poly5;
                case 7:
                    return poly7;
                case 10:
                    return poly10;
                case 11:
                    return poly11;
                case 12:
                    return poly12;
                case 14:
                    return poly14;
                case 18:
                    return poly18;
                case 20:
                    return poly20;
                case 24:
                    return poly24;
                case 28:
                    return poly28;
                case 36:
                    return poly36;
                case 42:
                    return poly42;
                case 48:
                    return poly48;
                case 56:
                    return poly56;
                case 62:
                    return poly62;
                case 68:
                    return poly68;
                default:
                    return null;
            }
        }

        private static void reedSolomonBlock(byte[] bArr, int i, byte[] bArr2, int i2, int[] iArr) {
            byte b;
            for (int i3 = 0; i3 <= i2; i3++) {
                bArr2[i3] = 0;
            }
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = (bArr2[0] ^ bArr[i4]) & 255;
                int i6 = 0;
                while (i6 < i2) {
                    int i7 = i6 + 1;
                    byte b2 = bArr2[i7];
                    if (i5 == 0) {
                        b = 0;
                    } else {
                        int[] iArr2 = alog;
                        int[] iArr3 = log;
                        b = (byte) iArr2[(iArr3[i5] + iArr3[iArr[(i2 - i6) - 1]]) % 255];
                    }
                    bArr2[i6] = (byte) (b2 ^ b);
                    i6 = i7;
                }
            }
        }

        static void generateECC(byte[] bArr, int i, int i2, int i3) {
            int i4 = (i + 2) / i2;
            byte[] bArr2 = new byte[256];
            byte[] bArr3 = new byte[256];
            int[] poly = getPoly(i3);
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = i5;
                int i7 = 0;
                while (i6 < i) {
                    bArr2[i7] = bArr[i6];
                    i6 += i4;
                    i7++;
                }
                reedSolomonBlock(bArr2, i7, bArr3, i3, poly);
                int i8 = i5;
                int i9 = 0;
                while (i8 < i3 * i4) {
                    bArr[i + i8] = bArr3[i9];
                    i8 += i4;
                    i9++;
                }
            }
        }
    }

    public java.awt.Image createAwtImage(Color color, Color color2) {
        if (this.image == null) {
            return null;
        }
        int rgb = color.getRGB();
        int rgb2 = color2.getRGB();
        Canvas canvas = new Canvas();
        int i = this.width;
        int i2 = this.f19649ws;
        int i3 = i + (i2 * 2);
        int i4 = this.height + (i2 * 2);
        int[] iArr = new int[i3 * i4];
        int i5 = (i3 + 7) / 8;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i4) {
            int i8 = i6 * i5;
            int i9 = i7;
            int i10 = 0;
            while (i10 < i3) {
                int i11 = i9 + 1;
                iArr[i9] = (((this.image[(i10 / 8) + i8] & 255) << (i10 % 8)) & 128) == 0 ? rgb2 : rgb;
                i10++;
                i9 = i11;
            }
            i6++;
            i7 = i9;
        }
        return canvas.createImage(new MemoryImageSource(i3, i4, iArr, 0, i3));
    }
}
