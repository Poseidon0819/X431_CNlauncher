package com.itextpdf.text.pdf.codec;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.pdf.BidiOrder;
import com.itextpdf.text.pdf.ByteBuffer;
import org.apache.mina.proxy.handlers.socks.SocksProxyConstants;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import org.codehaus.jackson.smile.SmileConstants;

/* loaded from: classes.dex */
public class TIFFFaxDecompressor {
    private int bitPointer;
    private int bitsPerScanline;
    private byte[] buffer;
    private int bytePointer;
    protected int compression;
    private int[] currChangingElems;
    private byte[] data;
    public int fails;
    protected int fillOrder;

    /* renamed from: h */
    private int f19833h;
    private int lineBitNum;
    protected int oneD;
    private int[] prevChangingElems;
    private int t4Options;
    private int t6Options;

    /* renamed from: w */
    private int f19834w;
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
    protected int uncompressedMode = 0;
    protected int fillBits = 0;
    private int changingElemSize = 0;
    private int lastChangingElement = 0;

    public void SetOptions(int i, int i2, int i3, int i4) {
        this.fillOrder = i;
        this.compression = i2;
        this.t4Options = i3;
        this.t6Options = i4;
        this.oneD = i3 & 1;
        this.uncompressedMode = (i3 & 2) >> 1;
        this.fillBits = (i3 & 4) >> 2;
    }

    public void decodeRaw(byte[] bArr, byte[] bArr2, int i, int i2) {
        this.buffer = bArr;
        this.data = bArr2;
        this.f19834w = i;
        this.f19833h = i2;
        this.bitsPerScanline = i;
        this.lineBitNum = 0;
        this.bitPointer = 0;
        this.bytePointer = 0;
        int i3 = i + 1;
        this.prevChangingElems = new int[i3];
        this.currChangingElems = new int[i3];
        this.fails = 0;
        try {
            if (this.compression == 2) {
                decodeRLE();
            } else if (this.compression == 3) {
                decodeT4();
            } else if (this.compression == 4) {
                this.uncompressedMode = (this.t6Options & 2) >> 1;
                decodeT6();
            } else {
                throw new RuntimeException("Unknown compression type " + this.compression);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
        }
    }

    public void decodeRLE() {
        for (int i = 0; i < this.f19833h; i++) {
            decodeNextScanline();
            if (this.bitPointer != 0) {
                this.bytePointer++;
                this.bitPointer = 0;
            }
            this.lineBitNum += this.bitsPerScanline;
        }
    }

    public void decodeNextScanline() {
        this.changingElemSize = 0;
        int i = 0;
        boolean z = true;
        while (true) {
            if (i >= this.f19834w) {
                break;
            }
            int i2 = i;
            while (z && i2 < this.f19834w) {
                int nextNBits = nextNBits(10);
                short s = white[nextNBits];
                int i3 = s & 1;
                int i4 = (s >>> 1) & 15;
                if (i4 == 12) {
                    short s2 = additionalMakeup[(12 & (nextNBits << 2)) | nextLesserThan8Bits(2)];
                    i2 += (s2 >>> 4) & 4095;
                    updatePointer(4 - ((s2 >>> 1) & 7));
                } else if (i4 == 0) {
                    this.fails++;
                } else if (i4 == 15) {
                    this.fails++;
                    return;
                } else {
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
            if (i2 == this.f19834w) {
                int i6 = i2 - i;
                if (z && i6 != 0 && i6 % 64 == 0 && nextNBits(8) != 53) {
                    this.fails++;
                    updatePointer(8);
                }
                i = i2;
            } else {
                i = i2;
                while (!z && i < this.f19834w) {
                    short s3 = initBlack[nextLesserThan8Bits(4)];
                    int i7 = (s3 >>> 1) & 15;
                    int i8 = (s3 >>> 5) & 2047;
                    if (i8 == 100) {
                        short s4 = black[nextNBits(9)];
                        int i9 = s4 & 1;
                        int i10 = (s4 >>> 1) & 15;
                        int i11 = (s4 >>> 5) & 2047;
                        if (i10 == 12) {
                            updatePointer(5);
                            short s5 = additionalMakeup[nextLesserThan8Bits(4)];
                            int i12 = (s5 >>> 4) & 4095;
                            setToBlack(i, i12);
                            i += i12;
                            updatePointer(4 - ((s5 >>> 1) & 7));
                        } else if (i10 == 15) {
                            this.fails++;
                            return;
                        } else {
                            setToBlack(i, i11);
                            i += i11;
                            updatePointer(9 - i10);
                            if (i9 == 0) {
                                int[] iArr2 = this.currChangingElems;
                                int i13 = this.changingElemSize;
                                this.changingElemSize = i13 + 1;
                                iArr2[i13] = i;
                                z = true;
                            }
                        }
                    } else if (i8 == 200) {
                        short s6 = twoBitBlack[nextLesserThan8Bits(2)];
                        int i14 = (s6 >>> 5) & 2047;
                        setToBlack(i, i14);
                        i += i14;
                        updatePointer(2 - ((s6 >>> 1) & 15));
                        int[] iArr3 = this.currChangingElems;
                        int i15 = this.changingElemSize;
                        this.changingElemSize = i15 + 1;
                        iArr3[i15] = i;
                        z = true;
                    } else {
                        setToBlack(i, i8);
                        i += i8;
                        updatePointer(4 - i7);
                        int[] iArr4 = this.currChangingElems;
                        int i16 = this.changingElemSize;
                        this.changingElemSize = i16 + 1;
                        iArr4[i16] = i;
                        z = true;
                    }
                }
                if (i == this.f19834w) {
                    int i17 = i - i2;
                    if (!z && i17 != 0 && i17 % 64 == 0 && nextNBits(10) != 55) {
                        this.fails++;
                        updatePointer(10);
                    }
                }
            }
        }
        int[] iArr5 = this.currChangingElems;
        int i18 = this.changingElemSize;
        this.changingElemSize = i18 + 1;
        iArr5[i18] = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d9, code lost:
        r15.fails++;
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00df, code lost:
        if (r5 == 1) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e1, code lost:
        r5 = findNextLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e5, code lost:
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e8, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e9, code lost:
        r6 = r6 + (r8 - 1);
        updatePointer(13);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void decodeT4() {
        /*
            Method dump skipped, instructions count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.TIFFFaxDecompressor.decodeT4():void");
    }

    public synchronized void decodeT6() {
        int i;
        int i2;
        int i3 = this.f19833h;
        int[] iArr = new int[2];
        int[] iArr2 = this.currChangingElems;
        int i4 = 0;
        this.changingElemSize = 0;
        int i5 = this.changingElemSize;
        this.changingElemSize = i5 + 1;
        iArr2[i5] = this.f19834w;
        int i6 = this.changingElemSize;
        this.changingElemSize = i6 + 1;
        iArr2[i6] = this.f19834w;
        int i7 = 0;
        while (i7 < i3) {
            int[] iArr3 = this.prevChangingElems;
            this.prevChangingElems = this.currChangingElems;
            this.currChangingElems = iArr3;
            this.lastChangingElement = i4;
            int i8 = 0;
            int i9 = 0;
            int i10 = -1;
            boolean z = true;
            while (i8 < this.f19834w) {
                getNextChangingElement(i10, z, iArr);
                int i11 = iArr[i4];
                int i12 = iArr[1];
                int i13 = twoDCodes[nextLesserThan8Bits(7)] & 255;
                int i14 = (i13 & Opcodes.ISHL) >>> 3;
                int i15 = i13 & 7;
                if (i14 == 0) {
                    if (z) {
                        i10 = i12;
                    } else {
                        if (i12 > this.f19834w) {
                            i12 = this.f19834w;
                        }
                        setToBlack(i8, i12 - i8);
                        i10 = i12;
                    }
                    updatePointer(7 - i15);
                    i8 = i10;
                    i4 = 0;
                } else if (i14 == 1) {
                    updatePointer(7 - i15);
                    if (z) {
                        int decodeWhiteCodeWord = i8 + decodeWhiteCodeWord();
                        int i16 = i9 + 1;
                        iArr3[i9] = decodeWhiteCodeWord;
                        int decodeBlackCodeWord = decodeBlackCodeWord();
                        if (decodeBlackCodeWord > this.f19834w - decodeWhiteCodeWord) {
                            decodeBlackCodeWord = this.f19834w - decodeWhiteCodeWord;
                        }
                        setToBlack(decodeWhiteCodeWord, decodeBlackCodeWord);
                        int i17 = decodeWhiteCodeWord + decodeBlackCodeWord;
                        i9 = i16 + 1;
                        iArr3[i16] = i17;
                        i10 = i17;
                    } else {
                        int decodeBlackCodeWord2 = decodeBlackCodeWord();
                        if (decodeBlackCodeWord2 > this.f19834w - i8) {
                            decodeBlackCodeWord2 = this.f19834w - i8;
                        }
                        setToBlack(i8, decodeBlackCodeWord2);
                        int i18 = i8 + decodeBlackCodeWord2;
                        int i19 = i9 + 1;
                        iArr3[i9] = i18;
                        int decodeWhiteCodeWord2 = i18 + decodeWhiteCodeWord();
                        i9 = i19 + 1;
                        iArr3[i19] = decodeWhiteCodeWord2;
                        i10 = decodeWhiteCodeWord2;
                    }
                    i8 = i10;
                    i4 = 0;
                } else if (i14 <= 8) {
                    int i20 = i11 + (i14 - 5);
                    int i21 = i9 + 1;
                    iArr3[i9] = i20;
                    if (z) {
                        i10 = i20;
                    } else {
                        if (i20 > this.f19834w) {
                            i20 = this.f19834w;
                        }
                        setToBlack(i8, i20 - i8);
                        i10 = i20;
                    }
                    z = !z;
                    updatePointer(7 - i15);
                    i9 = i21;
                    i8 = i10;
                    i4 = 0;
                } else if (i14 == 11) {
                    nextLesserThan8Bits(3);
                    int i22 = i8;
                    boolean z2 = false;
                    int i23 = 0;
                    while (!z2) {
                        while (nextLesserThan8Bits(1) != 1) {
                            i23++;
                        }
                        if (i23 > 5) {
                            i23 -= 6;
                            if (z || i23 <= 0) {
                                i2 = i9;
                            } else {
                                i2 = i9 + 1;
                                iArr3[i9] = i22;
                            }
                            i22 += i23;
                            if (i23 > 0) {
                                z = true;
                            }
                            if (nextLesserThan8Bits(1) == 0) {
                                if (!z) {
                                    iArr3[i2] = i22;
                                    i2++;
                                }
                                i9 = i2;
                                z = true;
                            } else {
                                if (z) {
                                    iArr3[i2] = i22;
                                    i2++;
                                }
                                i9 = i2;
                                z = false;
                            }
                            z2 = true;
                        }
                        if (i23 == 5) {
                            if (!z) {
                                iArr3[i9] = i22;
                                i9++;
                            }
                            i22 += i23;
                            z = true;
                        } else {
                            int i24 = i22 + i23;
                            iArr3[i9] = i24;
                            setToBlack(i24, 1);
                            i22 = i24 + 1;
                            i9++;
                            z = false;
                        }
                    }
                    i8 = i22;
                    i4 = 0;
                } else {
                    i4 = 0;
                }
            }
            if (i9 <= this.f19834w) {
                i = i9 + 1;
                iArr3[i9] = i8;
            } else {
                i = i9;
            }
            this.changingElemSize = i;
            this.lineBitNum += this.bitsPerScanline;
            i7++;
            i4 = 0;
        }
    }

    private void setToBlack(int i, int i2) {
        int i3 = i + this.lineBitNum;
        int i4 = i2 + i3;
        int i5 = i3 >> 3;
        int i6 = i3 & 7;
        if (i6 > 0) {
            int i7 = 1 << (7 - i6);
            byte b = this.buffer[i5];
            while (i7 > 0 && i3 < i4) {
                b = (byte) (b | i7);
                i7 >>= 1;
                i3++;
            }
            this.buffer[i5] = b;
        }
        int i8 = i3 >> 3;
        while (i3 < i4 - 7) {
            this.buffer[i8] = -1;
            i3 += 8;
            i8++;
        }
        while (i3 < i4) {
            int i9 = i3 >> 3;
            byte[] bArr = this.buffer;
            bArr[i9] = (byte) (bArr[i9] | (1 << (7 - (i3 & 7))));
            i3++;
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
                throw new RuntimeException("Error 0");
            } else {
                if (i3 == 15) {
                    throw new RuntimeException("Error 1");
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
                    throw new RuntimeException("Error 2");
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

    private int findNextLine() {
        int length = (this.data.length * 8) - 1;
        int i = length - 12;
        int i2 = (this.bytePointer * 8) + this.bitPointer;
        while (i2 <= i) {
            int nextNBits = nextNBits(12);
            i2 += 12;
            while (nextNBits != 1 && i2 < length) {
                nextNBits = ((nextNBits & 2047) << 1) | (nextLesserThan8Bits(1) & 1);
                i2++;
            }
            if (nextNBits == 1) {
                if (this.oneD != 1) {
                    return 1;
                }
                if (i2 < length) {
                    return nextLesserThan8Bits(1);
                }
            }
        }
        throw new RuntimeException();
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
            throw new RuntimeException("Invalid FillOrder");
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
            throw new RuntimeException("Invalid FillOrder");
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
        if (i > 8) {
            this.bytePointer -= i / 8;
            i %= 8;
        }
        int i2 = this.bitPointer - i;
        if (i2 < 0) {
            this.bytePointer--;
            this.bitPointer = i2 + 8;
            return;
        }
        this.bitPointer = i2;
    }
}
