package com.itextpdf.text.pdf.codec;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.BidiOrder;
import com.itextpdf.text.pdf.ByteBuffer;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.codec.net.StringEncodings;
import org.apache.mina.proxy.handlers.socks.SocksProxyConstants;
import org.codehaus.jackson.smile.SmileConstants;
import org.xbill.DNS.TTL;

/* loaded from: classes.dex */
public class Base64 {
    public static final int DECODE = 0;
    public static final int DONT_BREAK_LINES = 8;
    public static final int ENCODE = 1;
    private static final byte EQUALS_SIGN = 61;
    private static final byte EQUALS_SIGN_ENC = -1;
    public static final int GZIP = 2;
    private static final int MAX_LINE_LENGTH = 76;
    private static final byte NEW_LINE = 10;
    public static final int NO_OPTIONS = 0;
    public static final int ORDERED = 32;
    private static final String PREFERRED_ENCODING = "UTF-8";
    public static final int URL_SAFE = 16;
    private static final byte WHITE_SPACE_ENC = -5;
    private static final byte[] _STANDARD_ALPHABET = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, SocksProxyConstants.V4_REPLY_REQUEST_GRANTED, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, ByteBuffer.ZERO, 49, 50, 51, SmileConstants.TOKEN_KEY_LONG_STRING, 53, 54, 55, 56, 57, 43, DocWriter.FORWARD};
    private static final byte[] _STANDARD_DECODABET = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, DocWriter.f19585GT, -9, -9, -9, 63, SmileConstants.TOKEN_KEY_LONG_STRING, 53, 54, 55, 56, 57, SmileConstants.HEADER_BYTE_1, 59, DocWriter.f19586LT, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, BidiOrder.f19669WS, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, SmileConstants.TOKEN_LITERAL_NULL, 34, SmileConstants.TOKEN_LITERAL_TRUE, 36, 37, 38, 39, 40, SmileConstants.HEADER_BYTE_2, 42, 43, 44, 45, 46, DocWriter.FORWARD, ByteBuffer.ZERO, 49, 50, 51, -9, -9, -9, -9};
    private static final byte[] _URL_SAFE_ALPHABET = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, SocksProxyConstants.V4_REPLY_REQUEST_GRANTED, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, ByteBuffer.ZERO, 49, 50, 51, SmileConstants.TOKEN_KEY_LONG_STRING, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] _URL_SAFE_DECODABET = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, DocWriter.f19585GT, -9, -9, SmileConstants.TOKEN_KEY_LONG_STRING, 53, 54, 55, 56, 57, SmileConstants.HEADER_BYTE_1, 59, DocWriter.f19586LT, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, BidiOrder.f19669WS, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, SmileConstants.TOKEN_LITERAL_NULL, 34, SmileConstants.TOKEN_LITERAL_TRUE, 36, 37, 38, 39, 40, SmileConstants.HEADER_BYTE_2, 42, 43, 44, 45, 46, DocWriter.FORWARD, ByteBuffer.ZERO, 49, 50, 51, -9, -9, -9, -9};
    private static final byte[] _ORDERED_ALPHABET = {45, ByteBuffer.ZERO, 49, 50, 51, SmileConstants.TOKEN_KEY_LONG_STRING, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, SocksProxyConstants.V4_REPLY_REQUEST_GRANTED, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    private static final byte[] _ORDERED_DECODABET = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, BidiOrder.f19669WS, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, SmileConstants.TOKEN_LITERAL_NULL, 34, SmileConstants.TOKEN_LITERAL_TRUE, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, SmileConstants.HEADER_BYTE_2, 42, 43, 44, 45, 46, DocWriter.FORWARD, ByteBuffer.ZERO, 49, 50, 51, SmileConstants.TOKEN_KEY_LONG_STRING, 53, 54, 55, 56, 57, SmileConstants.HEADER_BYTE_1, 59, DocWriter.f19586LT, 61, DocWriter.f19585GT, 63, -9, -9, -9, -9};

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] getAlphabet(int i) {
        if ((i & 16) == 16) {
            return _URL_SAFE_ALPHABET;
        }
        if ((i & 32) == 32) {
            return _ORDERED_ALPHABET;
        }
        return _STANDARD_ALPHABET;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] getDecodabet(int i) {
        if ((i & 16) == 16) {
            return _URL_SAFE_DECODABET;
        }
        if ((i & 32) == 32) {
            return _ORDERED_DECODABET;
        }
        return _STANDARD_DECODABET;
    }

    private Base64() {
    }

    private static final void usage(String str) {
        System.err.println(str);
        System.err.println("Usage: java Base64 -e|-d inputfile outputfile");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] encode3to4(byte[] bArr, byte[] bArr2, int i, int i2) {
        encode3to4(bArr2, 0, i, bArr, 0, i2);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] encode3to4(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        byte[] alphabet = getAlphabet(i4);
        int i5 = (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0) | (i2 > 2 ? (bArr[i + 2] << 24) >>> 24 : 0);
        switch (i2) {
            case 1:
                bArr2[i3] = alphabet[i5 >>> 18];
                bArr2[i3 + 1] = alphabet[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = 61;
                bArr2[i3 + 3] = 61;
                return bArr2;
            case 2:
                bArr2[i3] = alphabet[i5 >>> 18];
                bArr2[i3 + 1] = alphabet[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = alphabet[(i5 >>> 6) & 63];
                bArr2[i3 + 3] = 61;
                return bArr2;
            case 3:
                bArr2[i3] = alphabet[i5 >>> 18];
                bArr2[i3 + 1] = alphabet[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = alphabet[(i5 >>> 6) & 63];
                bArr2[i3 + 3] = alphabet[i5 & 63];
                return bArr2;
            default:
                return bArr2;
        }
    }

    public static String encodeObject(Serializable serializable) {
        return encodeObject(serializable, 0);
    }

    public static String encodeObject(Serializable serializable, int i) {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        OutputStream outputStream;
        ObjectOutputStream objectOutputStream;
        GZIPOutputStream gZIPOutputStream2;
        int i2 = i & 2;
        ObjectOutputStream objectOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                outputStream = new OutputStream(byteArrayOutputStream, i | 1);
                try {
                    if (i2 == 2) {
                        gZIPOutputStream = new GZIPOutputStream(outputStream);
                        try {
                            gZIPOutputStream2 = gZIPOutputStream;
                            objectOutputStream = new ObjectOutputStream(gZIPOutputStream);
                        } catch (IOException e) {
                            e = e;
                            gZIPOutputStream2 = gZIPOutputStream;
                            objectOutputStream = null;
                            e.printStackTrace();
                            try {
                                objectOutputStream.close();
                            } catch (Exception unused) {
                            }
                            try {
                                gZIPOutputStream2.close();
                            } catch (Exception unused2) {
                            }
                            try {
                                outputStream.close();
                            } catch (Exception unused3) {
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused4) {
                            }
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            try {
                                objectOutputStream2.close();
                            } catch (Exception unused5) {
                            }
                            try {
                                gZIPOutputStream.close();
                            } catch (Exception unused6) {
                            }
                            try {
                                outputStream.close();
                            } catch (Exception unused7) {
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused8) {
                            }
                            throw th;
                        }
                    } else {
                        objectOutputStream = new ObjectOutputStream(outputStream);
                        gZIPOutputStream2 = null;
                    }
                } catch (IOException e2) {
                    e = e2;
                    objectOutputStream = null;
                    gZIPOutputStream2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    gZIPOutputStream = null;
                }
            } catch (IOException e3) {
                e = e3;
                objectOutputStream = null;
                gZIPOutputStream2 = null;
                outputStream = null;
            } catch (Throwable th3) {
                th = th3;
                gZIPOutputStream = null;
                outputStream = null;
            }
        } catch (IOException e4) {
            e = e4;
            objectOutputStream = null;
            gZIPOutputStream2 = null;
            byteArrayOutputStream = null;
            outputStream = null;
        } catch (Throwable th4) {
            th = th4;
            gZIPOutputStream = null;
            byteArrayOutputStream = null;
            outputStream = null;
        }
        try {
            try {
                objectOutputStream.writeObject(serializable);
                try {
                    objectOutputStream.close();
                } catch (Exception unused9) {
                }
                try {
                    gZIPOutputStream2.close();
                } catch (Exception unused10) {
                }
                try {
                    outputStream.close();
                } catch (Exception unused11) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception unused12) {
                }
                try {
                    return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                } catch (UnsupportedEncodingException unused13) {
                    return new String(byteArrayOutputStream.toByteArray());
                }
            } catch (Throwable th5) {
                th = th5;
                objectOutputStream2 = objectOutputStream;
                gZIPOutputStream = gZIPOutputStream2;
                objectOutputStream2.close();
                gZIPOutputStream.close();
                outputStream.close();
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            e.printStackTrace();
            objectOutputStream.close();
            gZIPOutputStream2.close();
            outputStream.close();
            byteArrayOutputStream.close();
            return null;
        }
    }

    public static String encodeBytes(byte[] bArr) {
        return encodeBytes(bArr, 0, bArr.length, 0);
    }

    public static String encodeBytes(byte[] bArr, int i) {
        return encodeBytes(bArr, 0, bArr.length, i);
    }

    public static String encodeBytes(byte[] bArr, int i, int i2) {
        return encodeBytes(bArr, i, i2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r3v16, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [com.itextpdf.text.pdf.codec.Base64$OutputStream] */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.itextpdf.text.pdf.codec.Base64$OutputStream] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.io.OutputStream, com.itextpdf.text.pdf.codec.Base64$OutputStream] */
    public static String encodeBytes(byte[] bArr, int i, int i2, int i3) {
        int i4;
        GZIPOutputStream gZIPOutputStream;
        int i5 = i3 & 8;
        ?? r3 = i3 & 2;
        ?? r5 = 2;
        if (r3 == 2) {
            GZIPOutputStream gZIPOutputStream2 = null;
            try {
                try {
                    r3 = new ByteArrayOutputStream();
                    try {
                        r5 = new OutputStream(r3, i3 | 1);
                    } catch (IOException e) {
                        e = e;
                        gZIPOutputStream = null;
                        r3 = r3;
                        r5 = gZIPOutputStream;
                        e.printStackTrace();
                        try {
                            gZIPOutputStream.close();
                        } catch (Exception unused) {
                        }
                        try {
                            r5.close();
                        } catch (Exception unused2) {
                        }
                        try {
                            r3.close();
                        } catch (Exception unused3) {
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        r5 = 0;
                    }
                    try {
                        gZIPOutputStream = new GZIPOutputStream(r5);
                    } catch (IOException e2) {
                        e = e2;
                        gZIPOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            gZIPOutputStream2.close();
                        } catch (Exception unused4) {
                        }
                        try {
                            r5.close();
                        } catch (Exception unused5) {
                        }
                        try {
                            r3.close();
                        } catch (Exception unused6) {
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    r3 = 0;
                    gZIPOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    r3 = 0;
                    r5 = 0;
                }
                try {
                    gZIPOutputStream.write(bArr, i, i2);
                    gZIPOutputStream.close();
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception unused7) {
                    }
                    try {
                        r5.close();
                    } catch (Exception unused8) {
                    }
                    try {
                        r3.close();
                    } catch (Exception unused9) {
                    }
                    try {
                        return new String(r3.toByteArray(), "UTF-8");
                    } catch (UnsupportedEncodingException unused10) {
                        return new String(r3.toByteArray());
                    }
                } catch (IOException e4) {
                    e = e4;
                    e.printStackTrace();
                    gZIPOutputStream.close();
                    r5.close();
                    r3.close();
                    return null;
                }
            } catch (Throwable th4) {
                th = th4;
                gZIPOutputStream2 = 1;
            }
        } else {
            boolean z = i5 == 0;
            int i6 = (i2 * 4) / 3;
            byte[] bArr2 = new byte[(i2 % 3 > 0 ? 4 : 0) + i6 + (z ? i6 / 76 : 0)];
            int i7 = i2 - 2;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            while (i8 < i7) {
                encode3to4(bArr, i8 + i, 3, bArr2, i9, i3);
                int i11 = i10 + 4;
                if (z && i11 == 76) {
                    bArr2[i9 + 4] = 10;
                    i9++;
                    i10 = 0;
                } else {
                    i10 = i11;
                }
                i8 += 3;
                i9 += 4;
            }
            if (i8 < i2) {
                encode3to4(bArr, i8 + i, i2 - i8, bArr2, i9, i3);
                i4 = i9 + 4;
            } else {
                i4 = i9;
            }
            try {
                return new String(bArr2, 0, i4, "UTF-8");
            } catch (UnsupportedEncodingException unused11) {
                return new String(bArr2, 0, i4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int decode4to3(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        byte[] decodabet = getDecodabet(i3);
        int i4 = i + 2;
        if (bArr[i4] == 61) {
            bArr2[i2] = (byte) ((((decodabet[bArr[i + 1]] & 255) << 12) | ((decodabet[bArr[i]] & 255) << 18)) >>> 16);
            return 1;
        }
        int i5 = i + 3;
        if (bArr[i5] == 61) {
            int i6 = (decodabet[bArr[i + 1]] & 255) << 12;
            int i7 = ((decodabet[bArr[i4]] & 255) << 6) | i6 | ((decodabet[bArr[i]] & 255) << 18);
            bArr2[i2] = (byte) (i7 >>> 16);
            bArr2[i2 + 1] = (byte) (i7 >>> 8);
            return 2;
        }
        try {
            int i8 = ((decodabet[bArr[i]] & 255) << 18) | ((decodabet[bArr[i + 1]] & 255) << 12) | ((decodabet[bArr[i4]] & 255) << 6) | (decodabet[bArr[i5]] & 255);
            bArr2[i2] = (byte) (i8 >> 16);
            bArr2[i2 + 1] = (byte) (i8 >> 8);
            bArr2[i2 + 2] = (byte) i8;
            return 3;
        } catch (Exception unused) {
            PrintStream printStream = System.out;
            printStream.println(((int) bArr[i]) + ": " + ((int) decodabet[bArr[i]]));
            PrintStream printStream2 = System.out;
            StringBuilder sb = new StringBuilder();
            int i9 = i + 1;
            sb.append((int) bArr[i9]);
            sb.append(": ");
            sb.append((int) decodabet[bArr[i9]]);
            printStream2.println(sb.toString());
            PrintStream printStream3 = System.out;
            printStream3.println(((int) bArr[i4]) + ": " + ((int) decodabet[bArr[i4]]));
            PrintStream printStream4 = System.out;
            printStream4.println(((int) bArr[i5]) + ": " + ((int) decodabet[bArr[i5]]));
            return -1;
        }
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        byte[] decodabet = getDecodabet(i3);
        byte[] bArr2 = new byte[(i2 * 3) / 4];
        byte[] bArr3 = new byte[4];
        int i4 = 0;
        int i5 = 0;
        for (int i6 = i; i6 < i + i2; i6++) {
            byte b = (byte) (bArr[i6] & Byte.MAX_VALUE);
            byte b2 = decodabet[b];
            if (b2 < -5) {
                PrintStream printStream = System.err;
                printStream.println("Bad Base64 input character at " + i6 + ": " + ((int) bArr[i6]) + "(decimal)");
                return null;
            }
            if (b2 >= -1) {
                int i7 = i4 + 1;
                bArr3[i4] = b;
                if (i7 > 3) {
                    i5 += decode4to3(bArr3, 0, bArr2, i5, i3);
                    if (b == 61) {
                        break;
                    }
                    i4 = 0;
                } else {
                    i4 = i7;
                }
            }
        }
        byte[] bArr4 = new byte[i5];
        System.arraycopy(bArr2, 0, bArr4, 0, i5);
        return bArr4;
    }

    public static byte[] decode(String str) {
        return decode(str, 0);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0052 -> B:58:0x0052). Please submit an issue!!! */
    public static byte[] decode(String str, int i) {
        byte[] bytes;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayInputStream byteArrayInputStream;
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        byte[] decode = decode(bytes, 0, bytes.length, i);
        if (decode != null && decode.length >= 4 && 35615 == ((decode[0] & 255) | ((decode[1] << 8) & 65280))) {
            byte[] bArr = new byte[2048];
            GZIPInputStream gZIPInputStream = null;
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(decode);
                        try {
                            GZIPInputStream gZIPInputStream2 = new GZIPInputStream(byteArrayInputStream);
                            while (true) {
                                try {
                                    int read = gZIPInputStream2.read(bArr);
                                    if (read < 0) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, read);
                                } catch (IOException unused2) {
                                    gZIPInputStream = gZIPInputStream2;
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception unused3) {
                                    }
                                    gZIPInputStream.close();
                                    byteArrayInputStream.close();
                                } catch (Throwable th) {
                                    th = th;
                                    gZIPInputStream = gZIPInputStream2;
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception unused4) {
                                    }
                                    try {
                                        gZIPInputStream.close();
                                    } catch (Exception unused5) {
                                    }
                                    try {
                                        byteArrayInputStream.close();
                                    } catch (Exception unused6) {
                                    }
                                    throw th;
                                }
                            }
                            decode = byteArrayOutputStream.toByteArray();
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused7) {
                            }
                            gZIPInputStream2.close();
                        } catch (IOException unused8) {
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (IOException unused9) {
                        byteArrayInputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayInputStream = null;
                    }
                } catch (IOException unused10) {
                    byteArrayOutputStream = null;
                    byteArrayInputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = null;
                    byteArrayInputStream = null;
                }
            } catch (Exception unused11) {
            }
            try {
                byteArrayInputStream.close();
            } catch (Exception unused12) {
            }
        }
        return decode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v5 */
    public static Object decodeToObject(String str) {
        ByteArrayInputStream byteArrayInputStream;
        ObjectInputStream objectInputStream;
        ?? decode = decode(str);
        ObjectInputStream objectInputStream2 = null;
        r0 = null;
        Object obj = null;
        objectInputStream2 = null;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(decode);
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                } catch (IOException e) {
                    e = e;
                    objectInputStream = null;
                } catch (ClassNotFoundException e2) {
                    e = e2;
                    objectInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception unused) {
                    }
                    try {
                        objectInputStream2.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
                try {
                    obj = objectInputStream.readObject();
                    decode = objectInputStream;
                } catch (IOException e3) {
                    e = e3;
                    e.printStackTrace();
                    decode = objectInputStream;
                    byteArrayInputStream.close();
                    decode.close();
                    return obj;
                } catch (ClassNotFoundException e4) {
                    e = e4;
                    e.printStackTrace();
                    decode = objectInputStream;
                    byteArrayInputStream.close();
                    decode.close();
                    return obj;
                }
            } catch (IOException e5) {
                e = e5;
                objectInputStream = null;
                byteArrayInputStream = null;
            } catch (ClassNotFoundException e6) {
                e = e6;
                objectInputStream = null;
                byteArrayInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayInputStream = null;
            }
            try {
                byteArrayInputStream.close();
            } catch (Exception unused3) {
            }
            try {
                decode.close();
            } catch (Exception unused4) {
            }
            return obj;
        } catch (Throwable th3) {
            objectInputStream2 = decode;
            th = th3;
        }
    }

    public static boolean encodeToFile(byte[] bArr, String str) {
        OutputStream outputStream;
        boolean z = true;
        OutputStream outputStream2 = null;
        try {
            try {
                outputStream = new OutputStream(new FileOutputStream(str), 1);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                outputStream.write(bArr);
                outputStream.close();
            } catch (IOException unused2) {
                outputStream2 = outputStream;
                z = false;
                outputStream2.close();
                return z;
            } catch (Throwable th2) {
                th = th2;
                outputStream2 = outputStream;
                try {
                    outputStream2.close();
                } catch (Exception unused3) {
                }
                throw th;
            }
        } catch (Exception unused4) {
        }
        return z;
    }

    public static boolean decodeToFile(String str, String str2) {
        boolean z = false;
        OutputStream outputStream = null;
        try {
            try {
                OutputStream outputStream2 = new OutputStream(new FileOutputStream(str2), 0);
                try {
                    outputStream2.write(str.getBytes("UTF-8"));
                    z = true;
                    outputStream2.close();
                } catch (IOException unused) {
                    outputStream = outputStream2;
                    outputStream.close();
                    return z;
                } catch (Throwable th) {
                    th = th;
                    outputStream = outputStream2;
                    try {
                        outputStream.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (IOException unused3) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused4) {
        }
        return z;
    }

    public static byte[] decodeFromFile(String str) {
        byte[] bArr;
        InputStream inputStream = null;
        try {
            try {
                File file = new File(str);
                if (file.length() > TTL.MAX_VALUE) {
                    System.err.println("File is too big for this convenience method (" + file.length() + " bytes).");
                    return null;
                }
                byte[] bArr2 = new byte[(int) file.length()];
                InputStream inputStream2 = new InputStream(new BufferedInputStream(new FileInputStream(file)), 0);
                int i = 0;
                while (true) {
                    try {
                        try {
                            int read = inputStream2.read(bArr2, i, 4096);
                            if (read < 0) {
                                byte[] bArr3 = new byte[i];
                                try {
                                    System.arraycopy(bArr2, 0, bArr3, 0, i);
                                    try {
                                        inputStream2.close();
                                        return bArr3;
                                    } catch (Exception unused) {
                                        return bArr3;
                                    }
                                } catch (IOException unused2) {
                                    bArr = bArr3;
                                    inputStream = inputStream2;
                                    System.err.println("Error decoding from file ".concat(String.valueOf(str)));
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception unused3) {
                                        }
                                    }
                                    return bArr;
                                }
                            }
                            i += read;
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception unused4) {
                                }
                            }
                            throw th;
                        }
                    } catch (IOException unused5) {
                        bArr = null;
                        inputStream = inputStream2;
                    }
                }
            } catch (IOException unused6) {
                bArr = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String encodeFromFile(String str) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            File file = new File(str);
            double length = file.length();
            Double.isNaN(length);
            byte[] bArr = new byte[Math.max((int) (length * 1.4d), 40)];
            inputStream = new InputStream(new BufferedInputStream(new FileInputStream(file)), 1);
            int i = 0;
            while (true) {
                try {
                    try {
                        int read = inputStream.read(bArr, i, 4096);
                        if (read < 0) {
                            break;
                        }
                        i += read;
                    } catch (Throwable th) {
                        th = th;
                        inputStream2 = inputStream;
                        try {
                            inputStream2.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                } catch (IOException unused2) {
                    System.err.println("Error encoding from file ".concat(String.valueOf(str)));
                    try {
                        inputStream.close();
                        return null;
                    } catch (Exception unused3) {
                        return null;
                    }
                }
            }
            String str2 = new String(bArr, 0, i, "UTF-8");
            try {
                inputStream.close();
            } catch (Exception unused4) {
            }
            return str2;
        } catch (IOException unused5) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream2.close();
            throw th;
        }
    }

    public static void encodeFileToFile(String str, String str2) {
        String encodeFromFile = encodeFromFile(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
                try {
                    bufferedOutputStream2.write(encodeFromFile.getBytes(StringEncodings.US_ASCII));
                    try {
                        bufferedOutputStream2.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e) {
                    e = e;
                    bufferedOutputStream = bufferedOutputStream2;
                    e.printStackTrace();
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused2) {
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused3) {
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void decodeFileToFile(String str, String str2) {
        byte[] decodeFromFile = decodeFromFile(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
                try {
                    bufferedOutputStream2.write(decodeFromFile);
                    try {
                        bufferedOutputStream2.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e) {
                    e = e;
                    bufferedOutputStream = bufferedOutputStream2;
                    e.printStackTrace();
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused2) {
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused3) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    /* loaded from: classes.dex */
    public static class InputStream extends FilterInputStream {
        private byte[] alphabet;
        private boolean breakLines;
        private byte[] buffer;
        private int bufferLength;
        private byte[] decodabet;
        private boolean encode;
        private int lineLength;
        private int numSigBytes;
        private int options;
        private int position;

        public InputStream(java.io.InputStream inputStream) {
            this(inputStream, 0);
        }

        public InputStream(java.io.InputStream inputStream, int i) {
            super(inputStream);
            this.breakLines = (i & 8) != 8;
            this.encode = (i & 1) == 1;
            this.bufferLength = this.encode ? 4 : 3;
            this.buffer = new byte[this.bufferLength];
            this.position = -1;
            this.lineLength = 0;
            this.options = i;
            this.alphabet = Base64.getAlphabet(i);
            this.decodabet = Base64.getDecodabet(i);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read;
            if (this.position < 0) {
                if (this.encode) {
                    byte[] bArr = new byte[3];
                    int i = 0;
                    for (int i2 = 0; i2 < 3; i2++) {
                        try {
                            int read2 = this.in.read();
                            if (read2 >= 0) {
                                bArr[i2] = (byte) read2;
                                i++;
                            }
                        } catch (IOException e) {
                            if (i2 == 0) {
                                throw e;
                            }
                        }
                    }
                    if (i <= 0) {
                        return -1;
                    }
                    Base64.encode3to4(bArr, 0, i, this.buffer, 0, this.options);
                    this.position = 0;
                    this.numSigBytes = 4;
                } else {
                    byte[] bArr2 = new byte[4];
                    int i3 = 0;
                    while (i3 < 4) {
                        do {
                            read = this.in.read();
                            if (read < 0) {
                                break;
                            }
                        } while (this.decodabet[read & 127] <= -5);
                        if (read < 0) {
                            break;
                        }
                        bArr2[i3] = (byte) read;
                        i3++;
                    }
                    if (i3 != 4) {
                        if (i3 == 0) {
                            return -1;
                        }
                        throw new IOException(MessageLocalization.getComposedMessage("improperly.padded.base64.input", new Object[0]));
                    }
                    this.numSigBytes = Base64.decode4to3(bArr2, 0, this.buffer, 0, this.options);
                    this.position = 0;
                }
            }
            int i4 = this.position;
            if (i4 >= 0) {
                if (i4 >= this.numSigBytes) {
                    return -1;
                }
                if (this.encode && this.breakLines && this.lineLength >= 76) {
                    this.lineLength = 0;
                    return 10;
                }
                this.lineLength++;
                byte[] bArr3 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                byte b = bArr3[i5];
                if (this.position >= this.bufferLength) {
                    this.position = -1;
                }
                return b & 255;
            }
            throw new IOException(MessageLocalization.getComposedMessage("error.in.base64.code.reading.stream", new Object[0]));
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                int read = read();
                if (read >= 0) {
                    bArr[i + i3] = (byte) read;
                    i3++;
                } else if (i3 == 0) {
                    return -1;
                }
            }
            return i3;
        }
    }

    /* loaded from: classes.dex */
    public static class OutputStream extends FilterOutputStream {
        private byte[] alphabet;

        /* renamed from: b4 */
        private byte[] f19812b4;
        private boolean breakLines;
        private byte[] buffer;
        private int bufferLength;
        private byte[] decodabet;
        private boolean encode;
        private int lineLength;
        private int options;
        private int position;
        private boolean suspendEncoding;

        public OutputStream(java.io.OutputStream outputStream) {
            this(outputStream, 1);
        }

        public OutputStream(java.io.OutputStream outputStream, int i) {
            super(outputStream);
            this.breakLines = (i & 8) != 8;
            this.encode = (i & 1) == 1;
            this.bufferLength = this.encode ? 3 : 4;
            this.buffer = new byte[this.bufferLength];
            this.position = 0;
            this.lineLength = 0;
            this.suspendEncoding = false;
            this.f19812b4 = new byte[4];
            this.options = i;
            this.alphabet = Base64.getAlphabet(i);
            this.decodabet = Base64.getDecodabet(i);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            if (this.suspendEncoding) {
                ((FilterOutputStream) this).out.write(i);
            } else if (this.encode) {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) i;
                if (this.position >= this.bufferLength) {
                    this.out.write(Base64.encode3to4(this.f19812b4, this.buffer, this.bufferLength, this.options));
                    this.lineLength += 4;
                    if (this.breakLines && this.lineLength >= 76) {
                        this.out.write(10);
                        this.lineLength = 0;
                    }
                    this.position = 0;
                }
            } else {
                byte[] bArr2 = this.decodabet;
                int i3 = i & 127;
                if (bArr2[i3] > -5) {
                    byte[] bArr3 = this.buffer;
                    int i4 = this.position;
                    this.position = i4 + 1;
                    bArr3[i4] = (byte) i;
                    if (this.position >= this.bufferLength) {
                        this.out.write(this.f19812b4, 0, Base64.decode4to3(bArr3, 0, this.f19812b4, 0, this.options));
                        this.position = 0;
                    }
                } else if (bArr2[i3] != -5) {
                    throw new IOException(MessageLocalization.getComposedMessage("invalid.character.in.base64.data", new Object[0]));
                }
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.suspendEncoding) {
                ((FilterOutputStream) this).out.write(bArr, i, i2);
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }

        public void flushBase64() throws IOException {
            if (this.position > 0) {
                if (this.encode) {
                    this.out.write(Base64.encode3to4(this.f19812b4, this.buffer, this.position, this.options));
                    this.position = 0;
                    return;
                }
                throw new IOException(MessageLocalization.getComposedMessage("base64.input.not.properly.padded", new Object[0]));
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            flushBase64();
            super.close();
            this.buffer = null;
            this.out = null;
        }

        public void suspendEncoding() throws IOException {
            flushBase64();
            this.suspendEncoding = true;
        }

        public void resumeEncoding() {
            this.suspendEncoding = false;
        }
    }
}
