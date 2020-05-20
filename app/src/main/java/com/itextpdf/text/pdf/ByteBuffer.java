package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;
import org.codehaus.jackson.smile.SmileConstants;

/* loaded from: classes.dex */
public class ByteBuffer extends OutputStream {
    private static int byteCacheSize;
    protected byte[] buf;
    protected int count;
    private static byte[][] byteCache = new byte[0];
    private static final char[] chars = {'0', '1', PdfWriter.VERSION_1_2, PdfWriter.VERSION_1_3, PdfWriter.VERSION_1_4, PdfWriter.VERSION_1_5, PdfWriter.VERSION_1_6, PdfWriter.VERSION_1_7, '8', '9'};
    public static final byte ZERO = 48;
    private static final byte[] bytes = {ZERO, 49, 50, 51, SmileConstants.TOKEN_KEY_LONG_STRING, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    public static boolean HIGH_PRECISION = false;
    private static final DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.US);

    public ByteBuffer() {
        this(128);
    }

    public ByteBuffer(int i) {
        this.buf = new byte[i <= 0 ? 128 : i];
    }

    public static void setCacheSize(int i) {
        if (i > 3276700) {
            i = 3276700;
        }
        int i2 = byteCacheSize;
        if (i <= i2) {
            return;
        }
        byte[][] bArr = new byte[i];
        System.arraycopy(byteCache, 0, bArr, 0, i2);
        byteCache = bArr;
        byteCacheSize = i;
    }

    public static void fillCache(int i) {
        int i2;
        switch (i) {
            case 0:
                i2 = 100;
                break;
            case 1:
                i2 = 10;
                break;
            default:
                i2 = 1;
                break;
        }
        for (int i3 = 1; i3 < byteCacheSize; i3 += i2) {
            byte[][] bArr = byteCache;
            if (bArr[i3] == null) {
                bArr[i3] = convertToBytes(i3);
            }
        }
    }

    private static byte[] convertToBytes(int i) {
        double d = i;
        int floor = (int) Math.floor(Math.log(d) / Math.log(10.0d));
        int i2 = i % 100;
        if (i2 != 0) {
            floor += 2;
        }
        int i3 = i % 10;
        if (i3 != 0) {
            floor++;
        }
        if (i < 100) {
            floor++;
            if (i < 10) {
                floor++;
            }
        }
        int i4 = floor - 1;
        byte[] bArr = new byte[i4];
        int i5 = i4 - 1;
        if (i < 100) {
            bArr[0] = ZERO;
        }
        if (i3 != 0) {
            bArr[i5] = bytes[i3];
            i5--;
        }
        if (i2 != 0) {
            bArr[i5] = bytes[(i / 10) % 10];
            bArr[i5 - 1] = 46;
        }
        int floor2 = ((int) Math.floor(Math.log(d) / Math.log(10.0d))) - 1;
        for (int i6 = 0; i6 < floor2; i6++) {
            bArr[i6] = bytes[(i / ((int) Math.pow(10.0d, (floor2 - i6) + 1))) % 10];
        }
        return bArr;
    }

    public ByteBuffer append_i(int i) {
        int i2 = this.count + 1;
        byte[] bArr = this.buf;
        if (i2 > bArr.length) {
            byte[] bArr2 = new byte[Math.max(bArr.length << 1, i2)];
            System.arraycopy(this.buf, 0, bArr2, 0, this.count);
            this.buf = bArr2;
        }
        this.buf[this.count] = (byte) i;
        this.count = i2;
        return this;
    }

    public ByteBuffer append(byte[] bArr, int i, int i2) {
        int i3;
        if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0 || i2 == 0) {
            return this;
        }
        int i4 = this.count + i2;
        byte[] bArr2 = this.buf;
        if (i4 > bArr2.length) {
            byte[] bArr3 = new byte[Math.max(bArr2.length << 1, i4)];
            System.arraycopy(this.buf, 0, bArr3, 0, this.count);
            this.buf = bArr3;
        }
        System.arraycopy(bArr, i, this.buf, this.count, i2);
        this.count = i4;
        return this;
    }

    public ByteBuffer append(byte[] bArr) {
        return append(bArr, 0, bArr.length);
    }

    public ByteBuffer append(String str) {
        return str != null ? append(DocWriter.getISOBytes(str)) : this;
    }

    public ByteBuffer append(char c) {
        return append_i(c);
    }

    public ByteBuffer append(ByteBuffer byteBuffer) {
        return append(byteBuffer.buf, 0, byteBuffer.count);
    }

    public ByteBuffer append(int i) {
        return append(i);
    }

    public ByteBuffer append(long j) {
        return append(Long.toString(j));
    }

    public ByteBuffer append(byte b) {
        return append_i(b);
    }

    public ByteBuffer appendHex(byte b) {
        append(bytes[(b >> 4) & 15]);
        return append(bytes[b & 15]);
    }

    public ByteBuffer append(float f) {
        return append(f);
    }

    public ByteBuffer append(double d) {
        append(formatDouble(d, this));
        return this;
    }

    public static String formatDouble(double d) {
        return formatDouble(d, null);
    }

    public static String formatDouble(double d, ByteBuffer byteBuffer) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        double d2 = d;
        if (HIGH_PRECISION) {
            String format = new DecimalFormat("0.######", dfs).format(d2);
            if (byteBuffer == null) {
                return format;
            }
            byteBuffer.append(format);
            return null;
        } else if (Math.abs(d) < 1.5E-5d) {
            if (byteBuffer != null) {
                byteBuffer.append(ZERO);
                return null;
            }
            return "0";
        } else {
            int i5 = 0;
            if (d2 < 0.0d) {
                d2 = -d2;
                z = true;
            } else {
                z = false;
            }
            int i6 = 100000;
            if (d2 < 1.0d) {
                double d3 = d2 + 5.0E-6d;
                if (d3 >= 1.0d) {
                    if (!z) {
                        if (byteBuffer != null) {
                            byteBuffer.append((byte) 49);
                            return null;
                        }
                        return "1";
                    } else if (byteBuffer != null) {
                        byteBuffer.append((byte) 45);
                        byteBuffer.append((byte) 49);
                        return null;
                    } else {
                        return "-1";
                    }
                } else if (byteBuffer != null) {
                    int i7 = (int) (d3 * 100000.0d);
                    if (z) {
                        byteBuffer.append((byte) 45);
                    }
                    byteBuffer.append(ZERO);
                    byteBuffer.append((byte) 46);
                    byteBuffer.append((byte) ((i7 / 10000) + 48));
                    if (i7 % 10000 != 0) {
                        byteBuffer.append((byte) (((i7 / 1000) % 10) + 48));
                        if (i7 % 1000 != 0) {
                            byteBuffer.append((byte) (((i7 / 100) % 10) + 48));
                            if (i7 % 100 != 0) {
                                byteBuffer.append((byte) (((i7 / 10) % 10) + 48));
                                int i8 = i7 % 10;
                                if (i8 != 0) {
                                    byteBuffer.append((byte) (i8 + 48));
                                }
                            }
                        }
                    }
                    return null;
                } else {
                    int i9 = (int) (d3 * 100000.0d);
                    StringBuilder sb = new StringBuilder();
                    if (z) {
                        sb.append(SignatureVisitor.SUPER);
                    }
                    sb.append("0.");
                    while (true) {
                        i6 /= 10;
                        if (i9 >= i6) {
                            break;
                        }
                        sb.append('0');
                    }
                    sb.append(i9);
                    int length = sb.length() - 1;
                    while (sb.charAt(length) == '0') {
                        length--;
                    }
                    sb.setLength(length + 1);
                    return sb.toString();
                }
            } else if (d2 > 32767.0d) {
                long j = (long) (d2 + 0.5d);
                if (z) {
                    return "-" + Long.toString(j);
                }
                return Long.toString(j);
            } else {
                int i10 = (int) ((d2 + 0.005d) * 100.0d);
                if (i10 < byteCacheSize) {
                    byte[][] bArr = byteCache;
                    if (bArr[i10] != null) {
                        if (byteBuffer != null) {
                            if (z) {
                                byteBuffer.append((byte) 45);
                            }
                            byteBuffer.append(byteCache[i10]);
                            return null;
                        }
                        String convertToString = PdfEncodings.convertToString(bArr[i10], null);
                        return z ? "-".concat(String.valueOf(convertToString)) : convertToString;
                    }
                }
                if (byteBuffer != null) {
                    if (i10 < byteCacheSize) {
                        int i11 = i10 >= 1000000 ? 5 : i10 >= 100000 ? 4 : i10 >= 10000 ? 3 : i10 >= 1000 ? 2 : i10 >= 100 ? 1 : 0;
                        int i12 = i10 % 100;
                        if (i12 != 0) {
                            i11 += 2;
                        }
                        int i13 = i10 % 10;
                        if (i13 != 0) {
                            i11++;
                        }
                        byte[] bArr2 = new byte[i11];
                        if (i10 >= 1000000) {
                            bArr2[0] = bytes[i10 / 1000000];
                            i5 = 1;
                        }
                        if (i10 >= 100000) {
                            bArr2[i5] = bytes[(i10 / 100000) % 10];
                            i5++;
                        }
                        if (i10 >= 10000) {
                            bArr2[i5] = bytes[(i10 / 10000) % 10];
                            i5++;
                        }
                        if (i10 >= 1000) {
                            i3 = i5 + 1;
                            bArr2[i5] = bytes[(i10 / 1000) % 10];
                        } else {
                            i3 = i5;
                        }
                        if (i10 >= 100) {
                            i4 = i3 + 1;
                            bArr2[i3] = bytes[(i10 / 100) % 10];
                        } else {
                            i4 = i3;
                        }
                        if (i12 != 0) {
                            int i14 = i4 + 1;
                            bArr2[i4] = 46;
                            int i15 = i14 + 1;
                            byte[] bArr3 = bytes;
                            bArr2[i14] = bArr3[(i10 / 10) % 10];
                            if (i13 != 0) {
                                bArr2[i15] = bArr3[i13];
                            }
                        }
                        byteCache[i10] = bArr2;
                    }
                    if (z) {
                        byteBuffer.append((byte) 45);
                    }
                    if (i10 >= 1000000) {
                        byteBuffer.append(bytes[i10 / 1000000]);
                    }
                    if (i10 >= 100000) {
                        byteBuffer.append(bytes[(i10 / 100000) % 10]);
                    }
                    if (i10 >= 10000) {
                        byteBuffer.append(bytes[(i10 / 10000) % 10]);
                        i2 = 1000;
                    } else {
                        i2 = 1000;
                    }
                    if (i10 >= i2) {
                        byteBuffer.append(bytes[(i10 / 1000) % 10]);
                    }
                    if (i10 >= 100) {
                        byteBuffer.append(bytes[(i10 / 100) % 10]);
                    }
                    if (i10 % 100 != 0) {
                        byteBuffer.append((byte) 46);
                        byteBuffer.append(bytes[(i10 / 10) % 10]);
                        int i16 = i10 % 10;
                        if (i16 != 0) {
                            byteBuffer.append(bytes[i16]);
                            return null;
                        }
                        return null;
                    }
                    return null;
                }
                StringBuilder sb2 = new StringBuilder();
                if (z) {
                    sb2.append(SignatureVisitor.SUPER);
                }
                if (i10 >= 1000000) {
                    sb2.append(chars[i10 / 1000000]);
                }
                if (i10 >= 100000) {
                    sb2.append(chars[(i10 / 100000) % 10]);
                }
                if (i10 >= 10000) {
                    sb2.append(chars[(i10 / 10000) % 10]);
                    i = 1000;
                } else {
                    i = 1000;
                }
                if (i10 >= i) {
                    sb2.append(chars[(i10 / 1000) % 10]);
                }
                if (i10 >= 100) {
                    sb2.append(chars[(i10 / 100) % 10]);
                }
                if (i10 % 100 != 0) {
                    sb2.append('.');
                    sb2.append(chars[(i10 / 10) % 10]);
                    int i17 = i10 % 10;
                    if (i17 != 0) {
                        sb2.append(chars[i17]);
                    }
                }
                return sb2.toString();
            }
        }
    }

    public void reset() {
        this.count = 0;
    }

    public byte[] toByteArray() {
        int i = this.count;
        byte[] bArr = new byte[i];
        System.arraycopy(this.buf, 0, bArr, 0, i);
        return bArr;
    }

    public int size() {
        return this.count;
    }

    public void setSize(int i) {
        if (i > this.count || i < 0) {
            throw new IndexOutOfBoundsException(MessageLocalization.getComposedMessage("the.new.size.must.be.positive.and.lt.eq.of.the.current.size", new Object[0]));
        }
        this.count = i;
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    public String toString(String str) throws UnsupportedEncodingException {
        return new String(this.buf, 0, this.count, str);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.buf, 0, this.count);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        append((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        append(bArr, i, i2);
    }

    public byte[] getBuffer() {
        return this.buf;
    }
}
