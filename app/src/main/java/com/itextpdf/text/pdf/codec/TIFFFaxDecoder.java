package com.itextpdf.text.pdf.codec;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.BidiOrder;
import com.itextpdf.text.pdf.ByteBuffer;
import org.apache.mina.proxy.handlers.socks.SocksProxyConstants;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import org.codehaus.jackson.smile.SmileConstants;

/* loaded from: classes.dex */
public class TIFFFaxDecoder {
    private int[] currChangingElems;
    private byte[] data;
    private int fillOrder;

    /* renamed from: h */
    private int f19831h;
    private int oneD;
    private int[] prevChangingElems;

    /* renamed from: w */
    private int f19832w;
    static int[] table1 = {0, 1, 3, 7, 15, 31, 63, 127, 255};
    static int[] table2 = {0, 128, 192, 224, 240, 248, 252, 254, 255};
    static byte[] flipTable = {0, Byte.MIN_VALUE, 64, -64, 32, -96, 96, -32, 16, -112, 80, -48, ByteBuffer.ZERO, -80, 112, -16, 8, -120, 72, -56, 40, -88, 104, -24, 24, -104, 88, -40, 56, -72, 120, -8, 4, -124, 68, -60, 36, -92, 100, -28, 20, -108, 84, -44, SmileConstants.TOKEN_KEY_LONG_STRING, -76, 116, -12, 12, -116, 76, -52, 44, -84, 108, -20, 28, -100, SocksProxyConstants.V4_REPLY_REQUEST_FAILED_NO_IDENTD, -36, DocWriter.f19586LT, -68, 124, -4, 2, -126, 66, -62, 34, -94, 98, -30, 18, -110, 82, -46, 50, -78, 114, -14, 10, -118, 74, -54, 42, -86, 106, -22, 26, -102, SocksProxyConstants.V4_REPLY_REQUEST_GRANTED, -38, SmileConstants.HEADER_BYTE_1, -70, 122, -6, 6, -122, 70, -58, 38, -90, 102, -26, 22, -106, 86, -42, 54, -74, 118, -10, 14, -114, 78, -50, 46, -82, 110, -18, 30, -98, 94, -34, DocWriter.f19585GT, -66, 126, -2, 1, -127, 65, -63, SmileConstants.TOKEN_LITERAL_NULL, -95, 97, -31, BidiOrder.f19669WS, -111, 81, -47, 49, -79, 113, -15, 9, -119, 73, -55, SmileConstants.HEADER_BYTE_2, -87, 105, -23, 25, -103, 89, -39, 57, -71, 121, -7, 5, -123, 69, -59, 37, -91, 101, -27, 21, -107, 85, -43, 53, -75, 117, -11, 13, -115, 77, -51, 45, -83, 109, -19, 29, -99, SocksProxyConstants.V4_REPLY_REQUEST_FAILED_ID_NOT_CONFIRMED, -35, DocWriter.EQUALS, -67, 125, -3, 3, -125, 67, -61, SmileConstants.TOKEN_LITERAL_TRUE, -93, 99, -29, 19, -109, 83, -45, 51, -77, 115, -13, 11, -117, 75, -53, 43, -85, 107, -21, 27, -101, SocksProxyConstants.V4_REPLY_REQUEST_REJECTED_OR_FAILED, -37, 59, -69, 123, -5, 7, -121, 71, -57, 39, -89, 103, -25, 23, -105, 87, -41, 55, -73, 119, -9, 15, -113, 79, -49, DocWriter.FORWARD, -81, 111, -17, 31, -97, 95, -33, 63, -65, Byte.MAX_VALUE, -1};
    static short[] white = {6430, 6400, 6400, 6400, 3225, 3225, 3225, 3225, 944, 944, 944, 944, 976, 976, 976, 976, 1456, 1456, 1456, 1456, 1488, 1488, 1488, 1488, 718, 718, 718, 718, 718, 718, 718, 718, 750, 750, 750, 750, 750, 750, 750, 750, 1520, 1520, 1520, 1520, 1552, 1552, 1552, 1552, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 654, 654, 654, 654, 654, 654, 654, 654, 1072, 1072, 1072, 1072, 1104, 1104, 1104, 1104, 1136, 1136, 1136, 1136, 1168, 1168, 1168, 1168, 1200, 1200, 1200, 1200, 1232, 1232, 1232, 1232, 622, 622, 622, 622, 622, 622, 622, 622, 1008, 1008, 1008, 1008, 1040, 1040, 1040, 1040, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 1712, 1712, 1712, 1712, 1744, 1744, 1744, 1744, 846, 846, 846, 846, 846, 846, 846, 846, 1264, 1264, 1264, 1264, 1296, 1296, 1296, 1296, 1328, 1328, 1328, 1328, 1360, 1360, 1360, 1360, 1392, 1392, 1392, 1392, 1424, 1424, 1424, 1424, 686, 686, 686, 686, 686, 686, 686, 686, 910, 910, 910, 910, 910, 910, 910, 910, 1968, 1968, 1968, 1968, 2000, 2000, 2000, 2000, 2032, 2032, 2032, 2032, 16, 16, 16, 16, 10257, 10257, 10257, 10257, 12305, 12305, 12305, 12305, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 878, 878, 878, 878, 878, 878, 878, 878, 1904, 1904, 1904, 1904, 1936, 1936, 1936, 1936, -18413, -18413, -16365, -16365, -14317, -14317, -10221, -10221, 590, 590, 590, 590, 590, 590, 590, 590, 782, 782, 782, 782, 782, 782, 782, 782, 1584, 1584, 1584, 1584, 1616, 1616, 1616, 1616, 1648, 1648, 1648, 1648, 1680, 1680, 1680, 1680, 814, 814, 814, 814, 814, 814, 814, 814, 1776, 1776, 1776, 1776, 1808, 1808, 1808, 1808, 1840, 1840, 1840, 1840, 1872, 1872, 1872, 1872, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, 14353, 14353, 14353, 14353, 16401, 16401, 16401, 16401, 22547, 22547, 24595, 24595, 20497, 20497, 20497, 20497, 18449, 18449, 18449, 18449, 26643, 26643, 28691, 28691, 30739, 30739, -32749, -32749, -30701, -30701, -28653, -28653, -26605, -26605, -24557, -24557, -22509, -22509, -20461, -20461, 8207, 8207, 8207, 8207, 8207, 8207, 8207, 8207, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 
    232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232};
    static short[] additionalMakeup = {28679, 28679, 31752, -32759, -31735, -30711, -29687, -28663, 29703, 29703, 30727, 30727, -27639, -26615, -25591, -24567};
    static short[] initBlack = {3226, 6412, 200, 168, 38, 38, 134, 134, 100, 100, 100, 100, 68, 68, 68, 68};
    static short[] twoBitBlack = {292, 260, 226, 226};
    static short[] black = {62, 62, 30, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 588, 588, 588, 588, 588, 588, 588, 588, 1680, 1680, 20499, 22547, 24595, 26643, 1776, 1776, 1808, 1808, -24557, -22509, -20461, -18413, 1904, 1904, 1936, 1936, -16365, -14317, 782, 782, 782, 782, 814, 814, 814, 814, -12269, -10221, 10257, 10257, 12305, 12305, 14353, 14353, 16403, 18451, 1712, 1712, 1744, 1744, 28691, 30739, -32749, -30701, -28653, -26605, 2061, 2061, 2061, 2061, 2061, 2061, 2061, 2061, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 750, 750, 750, 750, 1616, 1616, 1648, 1648, 1424, 1424, 1456, 1456, 1488, 1488, 1520, 1520, 1840, 1840, 1872, 1872, 1968, 1968, 8209, 8209, 524, 524, 524, 524, 524, 524, 524, 524, 556, 556, 556, 556, 556, 556, 556, 556, 1552, 1552, 1584, 1584, 2000, 2000, 2032, 2032, 976, 976, 1008, 1008, 1040, 1040, 1072, 1072, 1296, 1296, 1328, 1328, 718, 718, 718, 718, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 4113, 4113, 6161, 6161, 848, 848, 880, 880, 912, 912, 944, 944, 622, 622, 622, 622, 654, 654, 654, 654, 1104, 1104, 1136, 1136, 1168, 1168, 1200, 1200, 1232, 1232, 1264, 1264, 686, 686, 686, 686, 1360, 1360, 1392, 1392, 12, 12, 12, 12, 12, 12, 12, 12, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390};
    static byte[] twoDCodes = {80, 88, 23, 71, 30, 30, DocWriter.f19585GT, DocWriter.f19585GT, 4, 4, 4, 4, 4, 4, 4, 4, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, SmileConstants.TOKEN_LITERAL_TRUE, SmileConstants.TOKEN_LITERAL_TRUE, SmileConstants.TOKEN_LITERAL_TRUE, SmileConstants.TOKEN_LITERAL_TRUE, SmileConstants.TOKEN_LITERAL_TRUE, SmileConstants.TOKEN_LITERAL_TRUE, SmileConstants.TOKEN_LITERAL_TRUE, SmileConstants.TOKEN_LITERAL_TRUE, SmileConstants.TOKEN_LITERAL_TRUE, SmileConstants.TOKEN_LITERAL_TRUE, SmileConstants.TOKEN_LITERAL_TRUE, SmileConstants.TOKEN_LITERAL_TRUE, SmileConstants.TOKEN_LITERAL_TRUE, SmileConstants.TOKEN_LITERAL_TRUE, SmileConstants.TOKEN_LITERAL_TRUE, SmileConstants.TOKEN_LITERAL_TRUE, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2, SmileConstants.HEADER_BYTE_2};
    private int changingElemSize = 0;
    private int lastChangingElement = 0;
    private int compression = 2;
    private int uncompressedMode = 0;
    private int fillBits = 0;
    private int bitPointer = 0;
    private int bytePointer = 0;

    public TIFFFaxDecoder(int i, int i2, int i3) {
        this.fillOrder = i;
        this.f19832w = i2;
        this.f19831h = i3;
        int i4 = i2 * 2;
        this.prevChangingElems = new int[i4];
        this.currChangingElems = new int[i4];
    }

    public static void reverseBits(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = flipTable[bArr[i] & 255];
        }
    }

    public void decode1D(byte[] bArr, byte[] bArr2, int i, int i2) {
        this.data = bArr2;
        int i3 = (this.f19832w + 7) / 8;
        this.bitPointer = 0;
        this.bytePointer = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            decodeNextScanline(bArr, i4, i);
            i4 += i3;
        }
    }

    public void decodeNextScanline(byte[] bArr, int i, int i2) {
        this.changingElemSize = 0;
        boolean z = true;
        while (true) {
            if (i2 >= this.f19832w) {
                break;
            }
            while (z) {
                int nextNBits = nextNBits(10);
                short s = white[nextNBits];
                int i3 = s & 1;
                int i4 = (s >>> 1) & 15;
                if (i4 == 12) {
                    short s2 = additionalMakeup[(12 & (nextNBits << 2)) | nextLesserThan8Bits(2)];
                    i2 += (s2 >>> 4) & 4095;
                    updatePointer(4 - ((s2 >>> 1) & 7));
                } else if (i4 == 0) {
                    throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.code.encountered", new Object[0]));
                } else {
                    if (i4 == 15) {
                        throw new RuntimeException(MessageLocalization.getComposedMessage("eol.code.word.encountered.in.white.run", new Object[0]));
                    }
                    i2 += (s >>> 5) & 2047;
                    updatePointer(10 - i4);
                    if (i3 == 0) {
                        int[] iArr = this.currChangingElems;
                        int i5 = this.changingElemSize;
                        this.changingElemSize = i5 + 1;
                        iArr[i5] = i2;
                        z = false;
                    }
                }
            }
            if (i2 == this.f19832w) {
                if (this.compression == 2) {
                    advancePointer();
                }
            } else {
                while (!z) {
                    short s3 = initBlack[nextLesserThan8Bits(4)];
                    int i6 = (s3 >>> 1) & 15;
                    int i7 = (s3 >>> 5) & 2047;
                    if (i7 == 100) {
                        short s4 = black[nextNBits(9)];
                        int i8 = s4 & 1;
                        int i9 = (s4 >>> 1) & 15;
                        int i10 = (s4 >>> 5) & 2047;
                        if (i9 == 12) {
                            updatePointer(5);
                            short s5 = additionalMakeup[nextLesserThan8Bits(4)];
                            int i11 = (s5 >>> 4) & 4095;
                            setToBlack(bArr, i, i2, i11);
                            i2 += i11;
                            updatePointer(4 - ((s5 >>> 1) & 7));
                        } else if (i9 == 15) {
                            throw new RuntimeException(MessageLocalization.getComposedMessage("eol.code.word.encountered.in.black.run", new Object[0]));
                        } else {
                            setToBlack(bArr, i, i2, i10);
                            i2 += i10;
                            updatePointer(9 - i9);
                            if (i8 == 0) {
                                int[] iArr2 = this.currChangingElems;
                                int i12 = this.changingElemSize;
                                this.changingElemSize = i12 + 1;
                                iArr2[i12] = i2;
                                z = true;
                            }
                        }
                    } else if (i7 == 200) {
                        short s6 = twoBitBlack[nextLesserThan8Bits(2)];
                        int i13 = (s6 >>> 5) & 2047;
                        setToBlack(bArr, i, i2, i13);
                        i2 += i13;
                        updatePointer(2 - ((s6 >>> 1) & 15));
                        int[] iArr3 = this.currChangingElems;
                        int i14 = this.changingElemSize;
                        this.changingElemSize = i14 + 1;
                        iArr3[i14] = i2;
                        z = true;
                    } else {
                        setToBlack(bArr, i, i2, i7);
                        i2 += i7;
                        updatePointer(4 - i6);
                        int[] iArr4 = this.currChangingElems;
                        int i15 = this.changingElemSize;
                        this.changingElemSize = i15 + 1;
                        iArr4[i15] = i2;
                        z = true;
                    }
                }
                if (i2 == this.f19832w) {
                    if (this.compression == 2) {
                        advancePointer();
                    }
                }
            }
        }
        int[] iArr5 = this.currChangingElems;
        int i16 = this.changingElemSize;
        this.changingElemSize = i16 + 1;
        iArr5[i16] = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.itextpdf.text.pdf.codec.TIFFFaxDecoder] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public void decode2D(byte[] bArr, byte[] bArr2, int i, int i2, long j) {
        int i3;
        this.data = bArr2;
        this.compression = 3;
        ?? r4 = 0;
        this.bitPointer = 0;
        this.bytePointer = 0;
        int i4 = (this.f19832w + 7) / 8;
        int[] iArr = new int[2];
        this.oneD = (int) (j & 1);
        char c = 1;
        this.uncompressedMode = (int) ((j & 2) >> 1);
        this.fillBits = (int) ((j & 4) >> 2);
        if (readEOL(true) != 1) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("first.scanline.must.be.1d.encoded", new Object[0]));
        }
        decodeNextScanline(bArr, 0, i);
        int i5 = i4 + 0;
        int i6 = 1;
        while (i6 < i2) {
            if (readEOL(r4) == 0) {
                int[] iArr2 = this.prevChangingElems;
                this.prevChangingElems = this.currChangingElems;
                this.currChangingElems = iArr2;
                this.lastChangingElement = r4;
                int i7 = i;
                boolean z = true;
                int i8 = 0;
                int i9 = -1;
                while (i7 < this.f19832w) {
                    getNextChangingElement(i9, z, iArr);
                    int i10 = iArr[r4];
                    i9 = iArr[c];
                    int i11 = twoDCodes[nextLesserThan8Bits(7)] & 255;
                    int i12 = (i11 & Opcodes.ISHL) >>> 3;
                    int i13 = i11 & 7;
                    if (i12 == 0) {
                        if (!z) {
                            setToBlack(bArr, i5, i7, i9 - i7);
                        }
                        updatePointer(7 - i13);
                        i7 = i9;
                        r4 = 0;
                        c = 1;
                    } else if (i12 == 1) {
                        updatePointer(7 - i13);
                        if (z) {
                            int decodeWhiteCodeWord = i7 + decodeWhiteCodeWord();
                            int i14 = i8 + 1;
                            this.currChangingElems[i8] = decodeWhiteCodeWord;
                            int decodeBlackCodeWord = decodeBlackCodeWord();
                            setToBlack(bArr, i5, decodeWhiteCodeWord, decodeBlackCodeWord);
                            i7 = decodeWhiteCodeWord + decodeBlackCodeWord;
                            i3 = i14 + 1;
                            this.currChangingElems[i14] = i7;
                        } else {
                            int decodeBlackCodeWord2 = decodeBlackCodeWord();
                            setToBlack(bArr, i5, i7, decodeBlackCodeWord2);
                            int i15 = i7 + decodeBlackCodeWord2;
                            int i16 = i8 + 1;
                            this.currChangingElems[i8] = i15;
                            i7 = i15 + decodeWhiteCodeWord();
                            i3 = i16 + 1;
                            this.currChangingElems[i16] = i7;
                        }
                        i8 = i3;
                        i9 = i7;
                        r4 = 0;
                        c = 1;
                    } else if (i12 <= 8) {
                        int i17 = i10 + (i12 - 5);
                        int i18 = i8 + 1;
                        this.currChangingElems[i8] = i17;
                        if (!z) {
                            setToBlack(bArr, i5, i7, i17 - i7);
                        }
                        z = !z;
                        updatePointer(7 - i13);
                        i7 = i17;
                        i9 = i7;
                        i8 = i18;
                        r4 = 0;
                        c = 1;
                    } else {
                        throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.code.encountered.while.decoding.2d.group.3.compressed.data", new Object[0]));
                    }
                }
                this.currChangingElems[i8] = i7;
                this.changingElemSize = i8 + 1;
            } else {
                decodeNextScanline(bArr, i5, i);
            }
            i5 += i4;
            i6++;
            r4 = 0;
            c = 1;
        }
    }

    public void decodeT6(byte[] bArr, byte[] bArr2, int i, int i2, long j) {
        int decodeWhiteCodeWord;
        int i3;
        int i4;
        this.data = bArr2;
        this.compression = 4;
        int i5 = 0;
        this.bitPointer = 0;
        this.bytePointer = 0;
        int i6 = this.f19832w;
        int i7 = (i6 + 7) / 8;
        int[] iArr = new int[2];
        char c = 1;
        this.uncompressedMode = (int) ((j & 2) >> 1);
        int[] iArr2 = this.currChangingElems;
        this.changingElemSize = 0;
        int i8 = this.changingElemSize;
        this.changingElemSize = i8 + 1;
        iArr2[i8] = i6;
        int i9 = this.changingElemSize;
        this.changingElemSize = i9 + 1;
        iArr2[i9] = i6;
        int i10 = i2;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10) {
            int[] iArr3 = this.prevChangingElems;
            this.prevChangingElems = this.currChangingElems;
            this.currChangingElems = iArr3;
            this.lastChangingElement = i5;
            int i13 = i;
            int i14 = 0;
            int i15 = -1;
            boolean z = true;
            while (i13 < this.f19832w) {
                getNextChangingElement(i15, z, iArr);
                int i16 = iArr[i5];
                int i17 = iArr[c];
                int i18 = twoDCodes[nextLesserThan8Bits(7)] & 255;
                int i19 = (i18 & Opcodes.ISHL) >>> 3;
                int i20 = i18 & 7;
                if (i19 == 0) {
                    if (!z) {
                        setToBlack(bArr, i12, i13, i17 - i13);
                    }
                    updatePointer(7 - i20);
                    i13 = i17;
                    i15 = i13;
                    i5 = 0;
                    c = 1;
                } else if (i19 == 1) {
                    updatePointer(7 - i20);
                    if (z) {
                        int decodeWhiteCodeWord2 = i13 + decodeWhiteCodeWord();
                        int i21 = i14 + 1;
                        iArr3[i14] = decodeWhiteCodeWord2;
                        int decodeBlackCodeWord = decodeBlackCodeWord();
                        setToBlack(bArr, i12, decodeWhiteCodeWord2, decodeBlackCodeWord);
                        decodeWhiteCodeWord = decodeWhiteCodeWord2 + decodeBlackCodeWord;
                        i3 = i21 + 1;
                        iArr3[i21] = decodeWhiteCodeWord;
                    } else {
                        int decodeBlackCodeWord2 = decodeBlackCodeWord();
                        setToBlack(bArr, i12, i13, decodeBlackCodeWord2);
                        int i22 = i13 + decodeBlackCodeWord2;
                        int i23 = i14 + 1;
                        iArr3[i14] = i22;
                        decodeWhiteCodeWord = i22 + decodeWhiteCodeWord();
                        i3 = i23 + 1;
                        iArr3[i23] = decodeWhiteCodeWord;
                    }
                    i14 = i3;
                    i15 = decodeWhiteCodeWord;
                    i13 = i15;
                    i5 = 0;
                    c = 1;
                } else if (i19 <= 8) {
                    i15 = i16 + (i19 - 5);
                    int i24 = i14 + 1;
                    iArr3[i14] = i15;
                    if (!z) {
                        setToBlack(bArr, i12, i13, i15 - i13);
                    }
                    z = !z;
                    updatePointer(7 - i20);
                    i14 = i24;
                    i13 = i15;
                    i5 = 0;
                    c = 1;
                } else if (i19 == 11) {
                    if (nextLesserThan8Bits(3) != 7) {
                        throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.code.encountered.while.decoding.2d.group.4.compressed.data", new Object[0]));
                    }
                    boolean z2 = false;
                    int i25 = 0;
                    while (!z2) {
                        while (nextLesserThan8Bits(1) != 1) {
                            i25++;
                        }
                        if (i25 > 5) {
                            i25 -= 6;
                            if (!z && i25 > 0) {
                                iArr3[i14] = i13;
                                i14++;
                            }
                            i13 += i25;
                            if (i25 > 0) {
                                i4 = 1;
                                z = true;
                            } else {
                                i4 = 1;
                            }
                            if (nextLesserThan8Bits(i4) == 0) {
                                if (!z) {
                                    iArr3[i14] = i13;
                                    i14++;
                                }
                                z = true;
                            } else {
                                if (z) {
                                    iArr3[i14] = i13;
                                    i14++;
                                }
                                z = false;
                            }
                            z2 = true;
                        }
                        if (i25 == 5) {
                            if (!z) {
                                iArr3[i14] = i13;
                                i14++;
                            }
                            i13 += i25;
                            z = true;
                        } else {
                            int i26 = i13 + i25;
                            iArr3[i14] = i26;
                            setToBlack(bArr, i12, i26, 1);
                            i13 = i26 + 1;
                            i14++;
                            z = false;
                        }
                    }
                    i5 = 0;
                    c = 1;
                } else {
                    i13 = this.f19832w;
                    updatePointer(7 - i20);
                    i5 = 0;
                    c = 1;
                }
            }
            if (i14 < iArr3.length) {
                iArr3[i14] = i13;
                i14++;
            }
            this.changingElemSize = i14;
            i12 += i7;
            i11++;
            i5 = 0;
            i10 = i2;
            c = 1;
        }
    }

    private void setToBlack(byte[] bArr, int i, int i2, int i3) {
        int i4 = (i * 8) + i2;
        int i5 = i3 + i4;
        int i6 = i4 >> 3;
        int i7 = i4 & 7;
        if (i7 > 0) {
            int i8 = 1 << (7 - i7);
            byte b = bArr[i6];
            while (i8 > 0 && i4 < i5) {
                b = (byte) (b | i8);
                i8 >>= 1;
                i4++;
            }
            bArr[i6] = b;
        }
        int i9 = i4 >> 3;
        while (i4 < i5 - 7) {
            bArr[i9] = -1;
            i4 += 8;
            i9++;
        }
        while (i4 < i5) {
            int i10 = i4 >> 3;
            bArr[i10] = (byte) (bArr[i10] | (1 << (7 - (i4 & 7))));
            i4++;
        }
    }

    private int decodeWhiteCodeWord() {
        boolean z = true;
        int i = 0;
        while (z) {
            int nextNBits = nextNBits(10);
            short s = white[nextNBits];
            int i2 = s & 1;
            int i3 = (s >>> 1) & 15;
            if (i3 == 12) {
                short s2 = additionalMakeup[nextLesserThan8Bits(2) | ((nextNBits << 2) & 12)];
                i += (s2 >>> 4) & 4095;
                updatePointer(4 - ((s2 >>> 1) & 7));
            } else if (i3 == 0) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.code.encountered", new Object[0]));
            } else {
                if (i3 == 15) {
                    throw new RuntimeException(MessageLocalization.getComposedMessage("eol.code.word.encountered.in.white.run", new Object[0]));
                }
                i += (s >>> 5) & 2047;
                updatePointer(10 - i3);
                if (i2 == 0) {
                    z = false;
                }
            }
        }
        return i;
    }

    private int decodeBlackCodeWord() {
        boolean z = false;
        int i = 0;
        while (!z) {
            short s = initBlack[nextLesserThan8Bits(4)];
            int i2 = (s >>> 1) & 15;
            int i3 = (s >>> 5) & 2047;
            if (i3 == 100) {
                short s2 = black[nextNBits(9)];
                int i4 = s2 & 1;
                int i5 = (s2 >>> 1) & 15;
                int i6 = (s2 >>> 5) & 2047;
                if (i5 == 12) {
                    updatePointer(5);
                    short s3 = additionalMakeup[nextLesserThan8Bits(4)];
                    i += (s3 >>> 4) & 4095;
                    updatePointer(4 - ((s3 >>> 1) & 7));
                } else if (i5 == 15) {
                    throw new RuntimeException(MessageLocalization.getComposedMessage("eol.code.word.encountered.in.black.run", new Object[0]));
                } else {
                    i += i6;
                    updatePointer(9 - i5);
                    if (i4 == 0) {
                        z = true;
                    }
                }
            } else if (i3 == 200) {
                short s4 = twoBitBlack[nextLesserThan8Bits(2)];
                i += (s4 >>> 5) & 2047;
                updatePointer(2 - ((s4 >>> 1) & 15));
                z = true;
            } else {
                i += i3;
                updatePointer(4 - i2);
                z = true;
            }
        }
        return i;
    }

    private int readEOL(boolean z) {
        int nextNBits;
        int i = this.fillBits;
        if (i == 0) {
            int nextNBits2 = nextNBits(12);
            if (z && nextNBits2 == 0 && nextNBits(4) == 1) {
                this.fillBits = 1;
                return 1;
            } else if (nextNBits2 != 1) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("scanline.must.begin.with.eol.code.word", new Object[0]));
            }
        } else if (i == 1) {
            int i2 = 8 - this.bitPointer;
            if (nextNBits(i2) != 0) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("all.fill.bits.preceding.eol.code.must.be.0", new Object[0]));
            }
            if (i2 < 4 && nextNBits(8) != 0) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("all.fill.bits.preceding.eol.code.must.be.0", new Object[0]));
            }
            do {
                nextNBits = nextNBits(8);
                if (nextNBits != 1) {
                }
            } while (nextNBits == 0);
            throw new RuntimeException(MessageLocalization.getComposedMessage("all.fill.bits.preceding.eol.code.must.be.0", new Object[0]));
        }
        if (this.oneD == 0) {
            return 1;
        }
        return nextLesserThan8Bits(1);
    }

    private void getNextChangingElement(int i, boolean z, int[] iArr) {
        int[] iArr2 = this.prevChangingElems;
        int i2 = this.changingElemSize;
        int i3 = this.lastChangingElement;
        int i4 = i3 > 0 ? i3 - 1 : 0;
        int i5 = z ? i4 & (-2) : i4 | 1;
        while (true) {
            if (i5 >= i2) {
                break;
            }
            int i6 = iArr2[i5];
            if (i6 > i) {
                this.lastChangingElement = i5;
                iArr[0] = i6;
                break;
            }
            i5 += 2;
        }
        int i7 = i5 + 1;
        if (i7 < i2) {
            iArr[1] = iArr2[i7];
        }
    }

    private int nextNBits(int i) {
        byte b;
        byte b2;
        byte b3;
        int i2;
        int i3;
        byte[] bArr = this.data;
        int length = bArr.length - 1;
        int i4 = this.bytePointer;
        int i5 = this.fillOrder;
        if (i5 == 1) {
            b = bArr[i4];
            if (i4 == length) {
                b3 = 0;
                b2 = 0;
            } else {
                int i6 = i4 + 1;
                if (i6 == length) {
                    b3 = bArr[i6];
                    b2 = 0;
                } else {
                    byte b4 = bArr[i6];
                    b2 = bArr[i4 + 2];
                    b3 = b4;
                }
            }
        } else if (i5 == 2) {
            byte[] bArr2 = flipTable;
            byte b5 = bArr2[bArr[i4] & 255];
            if (i4 == length) {
                b = b5;
                b3 = 0;
                b2 = 0;
            } else {
                int i7 = i4 + 1;
                if (i7 == length) {
                    b3 = bArr2[bArr[i7] & 255];
                    b = b5;
                    b2 = 0;
                } else {
                    byte b6 = bArr2[bArr[i7] & 255];
                    byte b7 = bArr2[bArr[i4 + 2] & 255];
                    b = b5;
                    b2 = b7;
                    b3 = b6;
                }
            }
        } else {
            throw new RuntimeException(MessageLocalization.getComposedMessage("tiff.fill.order.tag.must.be.either.1.or.2", new Object[0]));
        }
        int i8 = 8 - this.bitPointer;
        int i9 = i - i8;
        if (i9 > 8) {
            i3 = i9 - 8;
            i2 = 8;
        } else {
            i2 = i9;
            i3 = 0;
        }
        this.bytePointer++;
        int i10 = (table1[i8] & b) << i9;
        int[] iArr = table2;
        int i11 = (b3 & iArr[i2]) >>> (8 - i2);
        if (i3 != 0) {
            i11 = (i11 << i3) | ((b2 & iArr[i3]) >>> (8 - i3));
            this.bytePointer++;
            this.bitPointer = i3;
        } else if (i2 == 8) {
            this.bitPointer = 0;
            this.bytePointer++;
        } else {
            this.bitPointer = i2;
        }
        return i10 | i11;
    }

    private int nextLesserThan8Bits(int i) {
        byte b;
        byte b2;
        byte[] bArr = this.data;
        int length = bArr.length - 1;
        int i2 = this.bytePointer;
        int i3 = this.fillOrder;
        if (i3 == 1) {
            b2 = bArr[i2];
            b = i2 == length ? (byte) 0 : bArr[i2 + 1];
        } else if (i3 == 2) {
            byte[] bArr2 = flipTable;
            byte b3 = bArr2[bArr[i2] & 255];
            if (i2 == length) {
                b2 = b3;
                b = 0;
            } else {
                b = bArr2[bArr[i2 + 1] & 255];
                b2 = b3;
            }
        } else {
            throw new RuntimeException(MessageLocalization.getComposedMessage("tiff.fill.order.tag.must.be.either.1.or.2", new Object[0]));
        }
        int i4 = this.bitPointer;
        int i5 = 8 - i4;
        int i6 = i - i5;
        int i7 = i5 - i;
        if (i7 >= 0) {
            int i8 = (table1[i5] & b2) >>> i7;
            this.bitPointer = i4 + i;
            if (this.bitPointer == 8) {
                this.bitPointer = 0;
                this.bytePointer++;
                return i8;
            }
            return i8;
        }
        int i9 = ((b & table2[i6]) >>> (8 - i6)) | ((table1[i5] & b2) << (-i7));
        this.bytePointer++;
        this.bitPointer = i6;
        return i9;
    }

    private void updatePointer(int i) {
        int i2 = this.bitPointer - i;
        if (i2 < 0) {
            this.bytePointer--;
            this.bitPointer = i2 + 8;
            return;
        }
        this.bitPointer = i2;
    }

    private boolean advancePointer() {
        if (this.bitPointer != 0) {
            this.bytePointer++;
            this.bitPointer = 0;
        }
        return true;
    }
}
