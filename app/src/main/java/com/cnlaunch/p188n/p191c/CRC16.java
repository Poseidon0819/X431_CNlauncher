package com.cnlaunch.p188n.p191c;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.Jpeg;
import com.itextpdf.text.pdf.BidiOrder;
import com.itextpdf.text.pdf.ByteBuffer;
import com.itextpdf.text.pdf.PdfContentParser;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import org.apache.mina.proxy.handlers.socks.SocksProxyConstants;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import org.codehaus.jackson.smile.SmileConstants;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* renamed from: com.cnlaunch.n.c.b */
/* loaded from: classes.dex */
public class CRC16 {

    /* renamed from: c */
    private static CRC16 f9636c;

    /* renamed from: d */
    private static final byte[] f9637d = {0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64};

    /* renamed from: e */
    private static final byte[] f9638e = {0, -64, -63, 1, -61, 3, 2, -62, -58, 6, 7, -57, 5, -59, -60, 4, -52, 12, 13, -51, 15, -49, -50, 14, 10, -54, -53, 11, -55, 9, 8, -56, -40, 24, 25, -39, 27, -37, -38, 26, 30, -34, -33, 31, -35, 29, 28, -36, 20, -44, -43, 21, -41, 23, 22, -42, -46, 18, 19, -45, BidiOrder.f19669WS, -47, -48, 16, -16, ByteBuffer.ZERO, 49, -15, 51, -13, -14, 50, 54, -10, -9, 55, -11, 53, SmileConstants.TOKEN_KEY_LONG_STRING, -12, DocWriter.f19586LT, -4, -3, DocWriter.EQUALS, -1, 63, DocWriter.f19585GT, -2, -6, SmileConstants.HEADER_BYTE_1, 59, -5, 57, -7, -8, 56, 40, -24, -23, SmileConstants.HEADER_BYTE_2, -21, 43, 42, -22, -18, 46, DocWriter.FORWARD, -17, 45, -19, -20, 44, -28, 36, 37, -27, 39, -25, -26, 38, 34, -30, -29, SmileConstants.TOKEN_LITERAL_TRUE, -31, SmileConstants.TOKEN_LITERAL_NULL, 32, -32, -96, 96, 97, -95, 99, -93, -94, 98, 102, -90, -89, 103, -91, 101, 100, -92, 108, -84, -83, 109, -81, 111, 110, -82, -86, 106, 107, -85, 105, -87, -88, 104, 120, -72, -71, 121, -69, 123, 122, -70, -66, 126, Byte.MAX_VALUE, -65, 125, -67, -68, 124, -76, 116, 117, -75, 119, -73, -74, 118, 114, -78, -77, 115, -79, 113, 112, -80, 80, -112, -111, 81, -109, 83, 82, -110, -106, 86, 87, -105, 85, -107, -108, 84, -100, SocksProxyConstants.V4_REPLY_REQUEST_FAILED_NO_IDENTD, SocksProxyConstants.V4_REPLY_REQUEST_FAILED_ID_NOT_CONFIRMED, -99, 95, -97, -98, 94, SocksProxyConstants.V4_REPLY_REQUEST_GRANTED, -102, -101, SocksProxyConstants.V4_REPLY_REQUEST_REJECTED_OR_FAILED, -103, 89, 88, -104, -120, 72, 73, -119, 75, -117, -118, 74, 78, -114, -113, 79, -115, 77, 76, -116, 68, -124, -123, 69, -121, 71, 70, -122, -126, 66, 67, -125, 65, -127, Byte.MIN_VALUE, 64};

    /* renamed from: a */
    public int[] f9639a = {0, Opcodes.INSTANCEOF, 129, 64, 1, 192, 128, 65, 1, 192, 128, 65, 0, Opcodes.INSTANCEOF, 129, 64, 1, 192, 128, 65, 0, Opcodes.INSTANCEOF, 129, 64, 0, Opcodes.INSTANCEOF, 129, 64, 1, 192, 128, 65, 1, 192, 128, 65, 0, Opcodes.INSTANCEOF, 129, 64, 0, Opcodes.INSTANCEOF, 129, 64, 1, 192, 128, 65, 0, Opcodes.INSTANCEOF, 129, 64, 1, 192, 128, 65, 1, 192, 128, 65, 0, Opcodes.INSTANCEOF, 129, 64, 1, 192, 128, 65, 0, Opcodes.INSTANCEOF, 129, 64, 0, Opcodes.INSTANCEOF, 129, 64, 1, 192, 128, 65, 0, Opcodes.INSTANCEOF, 129, 64, 1, 192, 128, 65, 1, 192, 128, 65, 0, Opcodes.INSTANCEOF, 129, 64, 0, Opcodes.INSTANCEOF, 129, 64, 1, 192, 128, 65, 1, 192, 128, 65, 0, Opcodes.INSTANCEOF, 129, 64, 1, 192, 128, 65, 0, Opcodes.INSTANCEOF, 129, 64, 0, Opcodes.INSTANCEOF, 129, 64, 1, 192, 128, 65, 1, 192, 128, 65, 0, Opcodes.INSTANCEOF, 129, 64, 0, Opcodes.INSTANCEOF, 129, 64, 1, 192, 128, 65, 0, Opcodes.INSTANCEOF, 129, 64, 1, 192, 128, 65, 1, 192, 128, 65, 0, Opcodes.INSTANCEOF, 129, 64, 0, Opcodes.INSTANCEOF, 129, 64, 1, 192, 128, 65, 1, 192, 128, 65, 0, Opcodes.INSTANCEOF, 129, 64, 1, 192, 128, 65, 0, Opcodes.INSTANCEOF, 129, 64, 0, Opcodes.INSTANCEOF, 129, 64, 1, 192, 128, 65, 0, Opcodes.INSTANCEOF, 129, 64, 1, 192, 128, 65, 1, 192, 128, 65, 0, Opcodes.INSTANCEOF, 129, 64, 1, 192, 128, 65, 0, Opcodes.INSTANCEOF, 129, 64, 0, Opcodes.INSTANCEOF, 129, 64, 1, 192, 128, 65, 1, 192, 128, 65, 0, Opcodes.INSTANCEOF, 129, 64, 0, Opcodes.INSTANCEOF, 129, 64, 1, 192, 128, 65, 0, Opcodes.INSTANCEOF, 129, 64, 1, 192, 128, 65, 1, 192, 128, 65, 0, Opcodes.INSTANCEOF, 129, 64};

    /* renamed from: b */
    public int[] f9640b = {0, 192, Opcodes.INSTANCEOF, 1, Opcodes.MONITOREXIT, 3, 2, Opcodes.MONITORENTER, Opcodes.IFNULL, 6, 7, Opcodes.IFNONNULL, 5, Opcodes.MULTIANEWARRAY, SmileConstants.MIN_BUFFER_FOR_POSSIBLE_SHORT_STRING, 4, 204, 12, 13, 205, 15, 207, 206, 14, 10, 202, 203, 11, 201, 9, 8, PdfContentParser.COMMAND_TYPE, 216, 24, 25, 217, 27, 219, 218, 26, 30, 222, 223, 31, 221, 29, 28, 220, 20, 212, 213, 21, 215, 23, 22, 214, 210, 18, 19, 211, 17, 209, 208, 16, 240, 48, 49, 241, 51, WKSRecord.Service.SUR_MEAS, 242, 50, 54, 246, MetaDo.META_CREATEPALETTE, 55, 245, 53, 52, 244, 60, 252, 253, 61, 255, 63, 62, 254, Type.TSIG, 58, 59, Type.IXFR, 57, Type.TKEY, 248, 56, 40, SmileConstants.TOKEN_MISC_BINARY_7BIT, 233, 41, 235, 43, 42, 234, Jpeg.M_APPE, 46, 47, 239, 45, Jpeg.M_APPD, SmileConstants.TOKEN_MISC_SHARED_STRING_LONG, 44, SmileConstants.TOKEN_MISC_LONG_TEXT_UNICODE, 36, 37, 229, 39, 231, 230, 38, 34, Jpeg.M_APP2, 227, 35, 225, 33, 32, 224, 160, 96, 97, 161, 99, Opcodes.IF_ICMPGT, 162, 98, 102, Opcodes.IF_ACMPNE, 167, 103, Opcodes.IF_ACMPEQ, 101, 100, Opcodes.IF_ICMPLE, 108, Opcodes.IRETURN, Opcodes.LRETURN, 109, Opcodes.DRETURN, 111, 110, Opcodes.FRETURN, Opcodes.TABLESWITCH, 106, 107, Opcodes.LOOKUPSWITCH, 105, Opcodes.RET, Opcodes.JSR, 104, Opcodes.ISHL, Opcodes.INVOKESTATIC, Opcodes.INVOKEINTERFACE, 121, Opcodes.NEW, 123, Opcodes.ISHR, Opcodes.INVOKEDYNAMIC, Opcodes.ARRAYLENGTH, Opcodes.IAND, 127, Opcodes.ATHROW, 125, Opcodes.ANEWARRAY, Opcodes.NEWARRAY, Opcodes.IUSHR, Opcodes.GETFIELD, Opcodes.INEG, 117, Opcodes.PUTFIELD, 119, Opcodes.INVOKESPECIAL, Opcodes.INVOKEVIRTUAL, Opcodes.FNEG, 114, Opcodes.GETSTATIC, Opcodes.PUTSTATIC, 115, Opcodes.RETURN, 113, 112, Opcodes.ARETURN, 80, Opcodes.D2F, Opcodes.I2B, 81, Opcodes.I2S, 83, 82, Opcodes.I2C, 150, 86, 87, Opcodes.DCMPL, 85, Opcodes.FCMPL, Opcodes.LCMP, 84, Opcodes.IFGE, 92, 93, Opcodes.IFGT, 95, Opcodes.IF_ICMPEQ, Opcodes.IFLE, 94, 90, Opcodes.IFNE, Opcodes.IFLT, 91, Opcodes.IFEQ, 89, 88, Opcodes.DCMPG, 136, 72, 73, 137, 75, 139, 138, 74, 78, 142, Opcodes.D2L, 79, 141, 77, 76, 140, 68, 132, 133, 69, 135, 71, 70, 134, 130, 66, 67, 131, 65, 129, 128, 64};

    /* renamed from: a */
    public static CRC16 m8528a() {
        if (f9636c == null) {
            synchronized (CRC16.class) {
                if (f9636c == null) {
                    f9636c = new CRC16();
                }
            }
        }
        return f9636c;
    }

    /* renamed from: a */
    public static int m8527a(byte[] bArr) {
        int i = 0;
        for (byte b : bArr) {
            i ^= SocketTools.m8519a(b);
        }
        return i;
    }

    /* renamed from: a */
    public static int m8526a(byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 ^= SocketTools.m8519a(bArr[i3]);
        }
        return i2;
    }
}
