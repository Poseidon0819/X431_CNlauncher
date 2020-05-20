package com.itextpdf.text.pdf.codec;

import com.itextpdf.text.DocWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.DeflaterOutputStream;

/* loaded from: classes.dex */
public class PngWriter {
    private static int[] crc_table;
    private OutputStream outp;
    private static final byte[] PNG_SIGNTURE = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final byte[] IHDR = DocWriter.getISOBytes(PngImage.IHDR);
    private static final byte[] PLTE = DocWriter.getISOBytes(PngImage.PLTE);
    private static final byte[] IDAT = DocWriter.getISOBytes(PngImage.IDAT);
    private static final byte[] IEND = DocWriter.getISOBytes(PngImage.IEND);
    private static final byte[] iCCP = DocWriter.getISOBytes(PngImage.iCCP);

    public PngWriter(OutputStream outputStream) throws IOException {
        this.outp = outputStream;
        outputStream.write(PNG_SIGNTURE);
    }

    public void writeHeader(int i, int i2, int i3, int i4) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        outputInt(i, byteArrayOutputStream);
        outputInt(i2, byteArrayOutputStream);
        byteArrayOutputStream.write(i3);
        byteArrayOutputStream.write(i4);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(0);
        writeChunk(IHDR, byteArrayOutputStream.toByteArray());
    }

    public void writeEnd() throws IOException {
        writeChunk(IEND, new byte[0]);
    }

    public void writeData(byte[] bArr, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        int i2 = 0;
        while (i2 < bArr.length - i) {
            deflaterOutputStream.write(0);
            deflaterOutputStream.write(bArr, i2, i);
            i2 += i;
        }
        int length = bArr.length - i2;
        if (length > 0) {
            deflaterOutputStream.write(0);
            deflaterOutputStream.write(bArr, i2, length);
        }
        deflaterOutputStream.finish();
        writeChunk(IDAT, byteArrayOutputStream.toByteArray());
    }

    public void writePalette(byte[] bArr) throws IOException {
        writeChunk(PLTE, bArr);
    }

    public void writeIccProfile(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(73);
        byteArrayOutputStream.write(67);
        byteArrayOutputStream.write(67);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(0);
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        deflaterOutputStream.write(bArr);
        deflaterOutputStream.finish();
        writeChunk(iCCP, byteArrayOutputStream.toByteArray());
    }

    private static void make_crc_table() {
        if (crc_table != null) {
            return;
        }
        int[] iArr = new int[256];
        for (int i = 0; i < 256; i++) {
            int i2 = i;
            for (int i3 = 0; i3 < 8; i3++) {
                i2 = (i2 & 1) != 0 ? (i2 >>> 1) ^ (-306674912) : i2 >>> 1;
            }
            iArr[i] = i2;
        }
        crc_table = iArr;
    }

    private static int update_crc(int i, byte[] bArr, int i2, int i3) {
        if (crc_table == null) {
            make_crc_table();
        }
        for (int i4 = 0; i4 < i3; i4++) {
            i = (i >>> 8) ^ crc_table[(bArr[i4 + i2] ^ i) & 255];
        }
        return i;
    }

    private static int crc(byte[] bArr, int i, int i2) {
        return update_crc(-1, bArr, i, i2) ^ (-1);
    }

    private static int crc(byte[] bArr) {
        return update_crc(-1, bArr, 0, bArr.length) ^ (-1);
    }

    public void outputInt(int i) throws IOException {
        outputInt(i, this.outp);
    }

    public static void outputInt(int i, OutputStream outputStream) throws IOException {
        outputStream.write((byte) (i >> 24));
        outputStream.write((byte) (i >> 16));
        outputStream.write((byte) (i >> 8));
        outputStream.write((byte) i);
    }

    public void writeChunk(byte[] bArr, byte[] bArr2) throws IOException {
        outputInt(bArr2.length);
        this.outp.write(bArr, 0, 4);
        this.outp.write(bArr2);
        outputInt(update_crc(update_crc(-1, bArr, 0, bArr.length), bArr2, 0, bArr2.length) ^ (-1));
    }
}
