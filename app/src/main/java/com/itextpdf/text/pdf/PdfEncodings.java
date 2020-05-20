package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.ExceptionConverter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.HashMap;
import org.apache.http.conn.ssl.TokenParser;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;
import org.codehaus.jackson.smile.SmileConstants;

/* loaded from: classes.dex */
public class PdfEncodings {
    static final char[] winansiByteToChar = {0, 1, 2, 3, 4, 5, 6, 7, '\b', '\t', '\n', 11, '\f', TokenParser.f24151CR, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, TokenParser.f24154SP, '!', TokenParser.DQUOTE, '#', '$', '%', '&', '\'', '(', ')', '*', SignatureVisitor.EXTENDS, ',', SignatureVisitor.SUPER, '.', '/', '0', '1', PdfWriter.VERSION_1_2, PdfWriter.VERSION_1_3, PdfWriter.VERSION_1_4, PdfWriter.VERSION_1_5, PdfWriter.VERSION_1_6, PdfWriter.VERSION_1_7, '8', '9', ':', ';', '<', SignatureVisitor.INSTANCEOF, '>', '?', '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '[', TokenParser.ESCAPE, ']', '^', '_', '`', 'a', 'b', Barcode128.CODE_AB_TO_C, Barcode128.CODE_AC_TO_B, Barcode128.CODE_BC_TO_A, Barcode128.FNC1_INDEX, Barcode128.START_A, Barcode128.START_B, Barcode128.START_C, 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '{', '|', '}', '~', 127, 8364, 65533, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 65533, 381, 65533, 65533, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 65533, 382, 376, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, Barcode128.DEL, Barcode128.FNC3, Barcode128.FNC2, Barcode128.SHIFT, Barcode128.CODE_C, 200, 201, Barcode128.FNC1, Barcode128.STARTA, Barcode128.STARTB, Barcode128.STARTC, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255};
    static final char[] pdfEncodingByteToChar = {0, 1, 2, 3, 4, 5, 6, 7, '\b', '\t', '\n', 11, '\f', TokenParser.f24151CR, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, TokenParser.f24154SP, '!', TokenParser.DQUOTE, '#', '$', '%', '&', '\'', '(', ')', '*', SignatureVisitor.EXTENDS, ',', SignatureVisitor.SUPER, '.', '/', '0', '1', PdfWriter.VERSION_1_2, PdfWriter.VERSION_1_3, PdfWriter.VERSION_1_4, PdfWriter.VERSION_1_5, PdfWriter.VERSION_1_6, PdfWriter.VERSION_1_7, '8', '9', ':', ';', '<', SignatureVisitor.INSTANCEOF, '>', '?', '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '[', TokenParser.ESCAPE, ']', '^', '_', '`', 'a', 'b', Barcode128.CODE_AB_TO_C, Barcode128.CODE_AC_TO_B, Barcode128.CODE_BC_TO_A, Barcode128.FNC1_INDEX, Barcode128.START_A, Barcode128.START_B, Barcode128.START_C, 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '{', '|', '}', '~', 127, 8226, 8224, 8225, 8230, 8212, 8211, 402, 8260, 8249, 8250, 8722, 8240, 8222, 8220, 8221, 8216, 8217, 8218, 8482, 64257, 64258, 321, 338, 352, 376, 381, 305, 322, 339, 353, 382, 65533, 8364, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, Barcode128.DEL, Barcode128.FNC3, Barcode128.FNC2, Barcode128.SHIFT, Barcode128.CODE_C, 200, 201, Barcode128.FNC1, Barcode128.STARTA, Barcode128.STARTB, Barcode128.STARTC, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255};
    static final IntHashtable winansi = new IntHashtable();
    static final IntHashtable pdfEncoding = new IntHashtable();
    static HashMap<String, ExtraEncoding> extraEncodings = new HashMap<>();

    /* renamed from: com.itextpdf.text.pdf.PdfEncodings$1 */
    /* loaded from: classes.dex */
    class C36331 {
    }

    static {
        for (int i = 128; i < 161; i++) {
            char c = winansiByteToChar[i];
            if (c != 65533) {
                winansi.put(c, i);
            }
        }
        for (int i2 = 128; i2 < 161; i2++) {
            char c2 = pdfEncodingByteToChar[i2];
            if (c2 != 65533) {
                pdfEncoding.put(c2, i2);
            }
        }
        addExtraEncoding("Wingdings", new WingdingsConversion(null));
        addExtraEncoding("Symbol", new SymbolConversion(true));
        addExtraEncoding("ZapfDingbats", new SymbolConversion(false));
        addExtraEncoding("SymbolTT", new SymbolTTConversion(null));
        addExtraEncoding("Cp437", new Cp437Conversion(null));
    }

    public static final byte[] convertToBytes(String str, String str2) {
        byte[] charToByte;
        int i = 0;
        if (str == null) {
            return new byte[0];
        }
        if (str2 == null || str2.length() == 0) {
            int length = str.length();
            byte[] bArr = new byte[length];
            while (i < length) {
                bArr[i] = (byte) str.charAt(i);
                i++;
            }
            return bArr;
        }
        ExtraEncoding extraEncoding = extraEncodings.get(str2.toLowerCase());
        if (extraEncoding == null || (charToByte = extraEncoding.charToByte(str, str2)) == null) {
            IntHashtable intHashtable = null;
            if (str2.equals("Cp1252")) {
                intHashtable = winansi;
            } else if (str2.equals(PdfObject.TEXT_PDFDOCENCODING)) {
                intHashtable = pdfEncoding;
            }
            if (intHashtable != null) {
                char[] charArray = str.toCharArray();
                int length2 = charArray.length;
                byte[] bArr2 = new byte[length2];
                int i2 = 0;
                for (char c : charArray) {
                    char c2 = c;
                    if (c >= 128) {
                        c2 = c;
                        if (c <= 160 || c > 255) {
                            c2 = intHashtable.get(c);
                        }
                    }
                    if (c2 != 0) {
                        bArr2[i2] = (byte) c2;
                        i2++;
                    }
                }
                if (i2 == length2) {
                    return bArr2;
                }
                byte[] bArr3 = new byte[i2];
                System.arraycopy(bArr2, 0, bArr3, 0, i2);
                return bArr3;
            } else if (str2.equals(PdfObject.TEXT_UNICODE)) {
                char[] charArray2 = str.toCharArray();
                int length3 = charArray2.length;
                int i3 = 2;
                byte[] bArr4 = new byte[(charArray2.length * 2) + 2];
                bArr4[0] = -2;
                bArr4[1] = -1;
                while (i < length3) {
                    char c3 = charArray2[i];
                    int i4 = i3 + 1;
                    bArr4[i3] = (byte) (c3 >> '\b');
                    i3 = i4 + 1;
                    bArr4[i4] = (byte) (c3 & 255);
                    i++;
                }
                return bArr4;
            } else {
                try {
                    CharsetEncoder newEncoder = Charset.forName(str2).newEncoder();
                    newEncoder.onUnmappableCharacter(CodingErrorAction.IGNORE);
                    java.nio.ByteBuffer encode = newEncoder.encode(CharBuffer.wrap(str.toCharArray()));
                    encode.rewind();
                    byte[] bArr5 = new byte[encode.limit()];
                    encode.get(bArr5);
                    return bArr5;
                } catch (IOException e) {
                    throw new ExceptionConverter(e);
                }
            }
        }
        return charToByte;
    }

    public static final byte[] convertToBytes(char c, String str) {
        byte[] charToByte;
        if (str == null || str.length() == 0) {
            return new byte[]{(byte) c};
        }
        ExtraEncoding extraEncoding = extraEncodings.get(str.toLowerCase());
        if (extraEncoding == null || (charToByte = extraEncoding.charToByte(c, str)) == null) {
            IntHashtable intHashtable = null;
            if (str.equals("Cp1252")) {
                intHashtable = winansi;
            } else if (str.equals(PdfObject.TEXT_PDFDOCENCODING)) {
                intHashtable = pdfEncoding;
            }
            if (intHashtable != null) {
                char c2 = c;
                if (c >= 128) {
                    c2 = c;
                    if (c <= 160 || c > 255) {
                        c2 = intHashtable.get(c);
                    }
                }
                return c2 != 0 ? new byte[]{(byte) c2} : new byte[0];
            } else if (str.equals(PdfObject.TEXT_UNICODE)) {
                return new byte[]{-2, -1, (byte) (c >> '\b'), (byte) (c & 255)};
            } else {
                try {
                    CharsetEncoder newEncoder = Charset.forName(str).newEncoder();
                    newEncoder.onUnmappableCharacter(CodingErrorAction.IGNORE);
                    java.nio.ByteBuffer encode = newEncoder.encode(CharBuffer.wrap(new char[]{c}));
                    encode.rewind();
                    byte[] bArr = new byte[encode.limit()];
                    encode.get(bArr);
                    return bArr;
                } catch (IOException e) {
                    throw new ExceptionConverter(e);
                }
            }
        }
        return charToByte;
    }

    public static final String convertToString(byte[] bArr, String str) {
        String byteToChar;
        if (bArr == null) {
            return "";
        }
        int i = 0;
        if (str == null || str.length() == 0) {
            char[] cArr = new char[bArr.length];
            while (i < bArr.length) {
                cArr[i] = (char) (bArr[i] & 255);
                i++;
            }
            return new String(cArr);
        }
        ExtraEncoding extraEncoding = extraEncodings.get(str.toLowerCase());
        if (extraEncoding == null || (byteToChar = extraEncoding.byteToChar(bArr, str)) == null) {
            char[] cArr2 = null;
            if (str.equals("Cp1252")) {
                cArr2 = winansiByteToChar;
            } else if (str.equals(PdfObject.TEXT_PDFDOCENCODING)) {
                cArr2 = pdfEncodingByteToChar;
            }
            if (cArr2 != null) {
                int length = bArr.length;
                char[] cArr3 = new char[length];
                while (i < length) {
                    cArr3[i] = cArr2[bArr[i] & 255];
                    i++;
                }
                return new String(cArr3);
            }
            try {
                return new String(bArr, str);
            } catch (UnsupportedEncodingException e) {
                throw new ExceptionConverter(e);
            }
        }
        return byteToChar;
    }

    public static boolean isPdfDocEncoding(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt >= 128 && ((charAt <= 160 || charAt > 255) && !pdfEncoding.containsKey(charAt))) {
                return false;
            }
        }
        return true;
    }

    public static void addExtraEncoding(String str, ExtraEncoding extraEncoding) {
        synchronized (extraEncodings) {
            HashMap<String, ExtraEncoding> hashMap = (HashMap) extraEncodings.clone();
            hashMap.put(str.toLowerCase(), extraEncoding);
            extraEncodings = hashMap;
        }
    }

    /* loaded from: classes.dex */
    static class WingdingsConversion implements ExtraEncoding {
        private static final byte[] table = {0, SmileConstants.TOKEN_LITERAL_TRUE, 34, 0, 0, 0, SmileConstants.HEADER_BYTE_2, DocWriter.f19585GT, 81, 42, 0, 0, 65, 63, 0, 0, 0, 0, 0, -4, 0, 0, 0, -5, 0, 0, 0, 0, 0, 0, 86, 0, 88, 89, 0, 0, 0, 0, 0, 0, 0, 0, -75, 0, 0, 0, 0, 0, -74, 0, 0, 0, -83, -81, -84, 0, 0, 0, 0, 0, 0, 0, 0, 124, 123, 0, 0, 0, 84, 0, 0, 0, 0, 0, 0, 0, 0, -90, 0, 0, 0, 113, 114, 0, 0, 0, 117, 0, 0, 0, 0, 0, 0, 125, 126, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -116, -115, -114, -113, -112, -111, -110, -109, -108, -107, -127, -126, -125, -124, -123, -122, -121, -120, -119, -118, -116, -115, -114, -113, -112, -111, -110, -109, -108, -107, -24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -24, -40, 0, 0, -60, -58, 0, 0, -16, 0, 0, 0, 0, 0, 0, 0, 0, 0, -36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public String byteToChar(byte[] bArr, String str) {
            return null;
        }

        private WingdingsConversion() {
        }

        /* synthetic */ WingdingsConversion(C36331 c36331) {
            this();
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public byte[] charToByte(char c, String str) {
            byte b;
            return c == ' ' ? new byte[]{(byte) c} : (c < 9985 || c > 10174 || (b = table[c + 55552]) == 0) ? new byte[0] : new byte[]{b};
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public byte[] charToByte(String str, String str2) {
            byte b;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            int length = charArray.length;
            int i = 0;
            for (char c : charArray) {
                if (c == ' ') {
                    bArr[i] = (byte) c;
                    i++;
                } else if (c >= 9985 && c <= 10174 && (b = table[c - 9984]) != 0) {
                    bArr[i] = b;
                    i++;
                }
            }
            if (i == length) {
                return bArr;
            }
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            return bArr2;
        }
    }

    /* loaded from: classes.dex */
    static class Cp437Conversion implements ExtraEncoding {
        private static IntHashtable c2b = new IntHashtable();
        private static final char[] table = {Barcode128.CODE_C, 252, 233, 226, 228, 224, 229, 231, 234, 235, 232, 239, 238, 236, Barcode128.FNC3, Barcode128.FNC2, 201, 230, Barcode128.SHIFT, 244, 246, 242, 251, 249, 255, 214, 220, 162, 163, 165, 8359, 402, 225, 237, 243, 250, 241, 209, 170, 186, 191, 8976, 172, 189, 188, 161, 171, 187, 9617, 9618, 9619, 9474, 9508, 9569, 9570, 9558, 9557, 9571, 9553, 9559, 9565, 9564, 9563, 9488, 9492, 9524, 9516, 9500, 9472, 9532, 9566, 9567, 9562, 9556, 9577, 9574, 9568, 9552, 9580, 9575, 9576, 9572, 9573, 9561, 9560, 9554, 9555, 9579, 9578, 9496, 9484, 9608, 9604, 9612, 9616, 9600, 945, 223, 915, 960, 931, 963, 181, 964, 934, 920, 937, 948, 8734, 966, 949, 8745, 8801, 177, 8805, 8804, 8992, 8993, 247, 8776, 176, 8729, 183, 8730, 8319, 178, 9632, 160};

        private Cp437Conversion() {
        }

        /* synthetic */ Cp437Conversion(C36331 c36331) {
            this();
        }

        static {
            int i = 0;
            while (true) {
                char[] cArr = table;
                if (i >= cArr.length) {
                    return;
                }
                c2b.put(cArr[i], i + 128);
                i++;
            }
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public byte[] charToByte(String str, String str2) {
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            int length = charArray.length;
            int i = 0;
            for (char c : charArray) {
                if (c < 128) {
                    bArr[i] = (byte) c;
                    i++;
                } else {
                    byte b = (byte) c2b.get(c);
                    if (b != 0) {
                        bArr[i] = b;
                        i++;
                    }
                }
            }
            if (i == length) {
                return bArr;
            }
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            return bArr2;
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public byte[] charToByte(char c, String str) {
            if (c < 128) {
                return new byte[]{(byte) c};
            }
            byte b = (byte) c2b.get(c);
            return b != 0 ? new byte[]{b} : new byte[0];
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public String byteToChar(byte[] bArr, String str) {
            char[] cArr = new char[bArr.length];
            int i = 0;
            for (byte b : bArr) {
                int i2 = b & 255;
                if (i2 >= 32) {
                    if (i2 < 128) {
                        cArr[i] = (char) i2;
                        i++;
                    } else {
                        cArr[i] = table[i2 - 128];
                        i++;
                    }
                }
            }
            return new String(cArr, 0, i);
        }
    }

    /* loaded from: classes.dex */
    static class SymbolConversion implements ExtraEncoding {

        /* renamed from: t1 */
        private static final IntHashtable f19676t1 = new IntHashtable();

        /* renamed from: t2 */
        private static final IntHashtable f19677t2 = new IntHashtable();
        private static final char[] table1 = {TokenParser.f24154SP, '!', 8704, '#', 8707, '%', '&', 8715, '(', ')', '*', SignatureVisitor.EXTENDS, ',', SignatureVisitor.SUPER, '.', '/', '0', '1', PdfWriter.VERSION_1_2, PdfWriter.VERSION_1_3, PdfWriter.VERSION_1_4, PdfWriter.VERSION_1_5, PdfWriter.VERSION_1_6, PdfWriter.VERSION_1_7, '8', '9', ':', ';', '<', SignatureVisitor.INSTANCEOF, '>', '?', 8773, 913, 914, 935, 916, 917, 934, 915, 919, 921, 977, 922, 923, 924, 925, 927, 928, 920, 929, 931, 932, 933, 962, 937, 926, 936, 918, '[', 8756, ']', 8869, '_', 773, 945, 946, 967, 948, 949, 981, 947, 951, 953, 966, 954, 955, 956, 957, 959, 960, 952, 961, 963, 964, 965, 982, 969, 958, 968, 950, '{', '|', '}', '~', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8364, 978, 8242, 8804, 8260, 8734, 402, 9827, 9830, 9829, 9824, 8596, 8592, 8593, 8594, 8595, 176, 177, 8243, 8805, 215, 8733, 8706, 8226, 247, 8800, 8801, 8776, 8230, 9474, 9472, 8629, 8501, 8465, 8476, 8472, 8855, 8853, 8709, 8745, 8746, 8835, 8839, 8836, 8834, 8838, 8712, 8713, 8736, 8711, 174, 169, 8482, 8719, 8730, 8226, 172, 8743, 8744, 8660, 8656, 8657, 8658, 8659, 9674, 9001, 0, 0, 0, 8721, 9115, 9116, 9117, 9121, 9122, 9123, 9127, 9128, 9129, 9130, 0, 9002, 8747, 8992, 9134, 8993, 9118, 9119, 9120, 9124, 9125, 9126, 9131, 9132, 9133, 0};
        private static final char[] table2 = {TokenParser.f24154SP, 9985, 9986, 9987, 9988, 9742, 9990, 9991, 9992, 9993, 9755, 9758, 9996, 9997, 9998, 9999, 10000, 10001, 10002, 10003, 10004, 10005, 10006, 10007, 10008, 10009, 10010, 10011, 10012, 10013, 10014, 10015, 10016, 10017, 10018, 10019, 10020, 10021, 10022, 10023, 9733, 10025, 10026, 10027, 10028, 10029, 10030, 10031, 10032, 10033, 10034, 10035, 10036, 10037, 10038, 10039, 10040, 10041, 10042, 10043, 10044, 10045, 10046, 10047, 10048, 10049, 10050, 10051, 10052, 10053, 10054, 10055, 10056, 10057, 10058, 10059, 9679, 10061, 9632, 10063, 10064, 10065, 10066, 9650, 9660, 9670, 10070, 9687, 10072, 10073, 10074, 10075, 10076, 10077, 10078, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10081, 10082, 10083, 10084, 10085, 10086, 10087, 9827, 9830, 9829, 9824, 9312, 9313, 9314, 9315, 9316, 9317, 9318, 9319, 9320, 9321, 10102, 10103, 10104, 10105, 10106, 10107, 10108, 10109, 10110, 10111, 10112, 10113, 10114, 10115, 10116, 10117, 10118, 10119, 10120, 10121, 10122, 10123, 10124, 10125, 10126, 10127, 10128, 10129, 10130, 10131, 10132, 8594, 8596, 8597, 10136, 10137, 10138, 10139, 10140, 10141, 10142, 10143, 10144, 10145, 10146, 10147, 10148, 10149, 10150, 10151, 10152, 10153, 10154, 10155, 10156, 10157, 10158, 10159, 0, 10161, 10162, 10163, 10164, 10165, 10166, 10167, 10168, 10169, 10170, 10171, 10172, 10173, 10174, 0};
        private IntHashtable translation;

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public String byteToChar(byte[] bArr, String str) {
            return null;
        }

        static {
            int i = 0;
            int i2 = 0;
            while (true) {
                char[] cArr = table1;
                if (i2 >= cArr.length) {
                    break;
                }
                char c = cArr[i2];
                if (c != 0) {
                    f19676t1.put(c, i2 + 32);
                }
                i2++;
            }
            while (true) {
                char[] cArr2 = table2;
                if (i >= cArr2.length) {
                    return;
                }
                char c2 = cArr2[i];
                if (c2 != 0) {
                    f19677t2.put(c2, i + 32);
                }
                i++;
            }
        }

        SymbolConversion(boolean z) {
            if (z) {
                this.translation = f19676t1;
            } else {
                this.translation = f19677t2;
            }
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public byte[] charToByte(String str, String str2) {
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            int length = charArray.length;
            int i = 0;
            for (char c : charArray) {
                byte b = (byte) this.translation.get(c);
                if (b != 0) {
                    bArr[i] = b;
                    i++;
                }
            }
            if (i == length) {
                return bArr;
            }
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            return bArr2;
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public byte[] charToByte(char c, String str) {
            byte b = (byte) this.translation.get(c);
            return b != 0 ? new byte[]{b} : new byte[0];
        }
    }

    /* loaded from: classes.dex */
    static class SymbolTTConversion implements ExtraEncoding {
        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public String byteToChar(byte[] bArr, String str) {
            return null;
        }

        private SymbolTTConversion() {
        }

        /* synthetic */ SymbolTTConversion(C36331 c36331) {
            this();
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public byte[] charToByte(char c, String str) {
            int i = 65280 & c;
            return (i == 0 || i == 61440) ? new byte[]{(byte) c} : new byte[0];
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public byte[] charToByte(String str, String str2) {
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            int length = charArray.length;
            int i = 0;
            for (char c : charArray) {
                int i2 = 65280 & c;
                if (i2 == 0 || i2 == 61440) {
                    bArr[i] = (byte) c;
                    i++;
                }
            }
            if (i == length) {
                return bArr;
            }
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            return bArr2;
        }
    }
}
