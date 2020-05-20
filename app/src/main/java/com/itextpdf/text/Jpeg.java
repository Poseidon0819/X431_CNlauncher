package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.ICC_Profile;
import com.itextpdf.text.pdf.PdfContentParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;

/* loaded from: classes.dex */
public class Jpeg extends Image {
    public static final int M_APP0 = 224;
    public static final int M_APP2 = 226;
    public static final int M_APPD = 237;
    public static final int M_APPE = 238;
    public static final int NOPARAM_MARKER = 2;
    public static final int NOT_A_MARKER = -1;
    public static final int UNSUPPORTED_MARKER = 1;
    public static final int VALID_MARKER = 0;
    private byte[][] icc;
    public static final int[] VALID_MARKERS = {192, Opcodes.INSTANCEOF, Opcodes.MONITORENTER};
    public static final int[] UNSUPPORTED_MARKERS = {Opcodes.MONITOREXIT, Opcodes.MULTIANEWARRAY, Opcodes.IFNULL, Opcodes.IFNONNULL, PdfContentParser.COMMAND_TYPE, 201, 202, 203, 205, 206, 207};
    public static final int[] NOPARAM_MARKERS = {208, 209, 210, 211, 212, 213, 214, 215, 216, 1};
    public static final byte[] JFIF_ID = {74, 70, 73, 70, 0};
    public static final byte[] PS_8BIM_RESO = {56, 66, 73, 77, 3, -19};

    Jpeg(Image image) {
        super(image);
    }

    public Jpeg(URL url) throws BadElementException, IOException {
        super(url);
        processParameters();
    }

    public Jpeg(byte[] bArr) throws BadElementException, IOException {
        super((URL) null);
        this.rawData = bArr;
        this.originalData = bArr;
        processParameters();
    }

    public Jpeg(byte[] bArr, float f, float f2) throws BadElementException, IOException {
        this(bArr);
        this.scaledWidth = f;
        this.scaledHeight = f2;
    }

    private static final int getShort(InputStream inputStream) throws IOException {
        return (inputStream.read() << 8) + inputStream.read();
    }

    private static final int marker(int i) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr = VALID_MARKERS;
            if (i3 >= iArr.length) {
                int i4 = 0;
                while (true) {
                    int[] iArr2 = NOPARAM_MARKERS;
                    if (i4 >= iArr2.length) {
                        while (true) {
                            int[] iArr3 = UNSUPPORTED_MARKERS;
                            if (i2 >= iArr3.length) {
                                return -1;
                            }
                            if (i == iArr3[i2]) {
                                return 1;
                            }
                            i2++;
                        }
                    } else if (i == iArr2[i4]) {
                        return 2;
                    } else {
                        i4++;
                    }
                }
            } else if (i == iArr[i3]) {
                return 0;
            } else {
                i3++;
            }
        }
    }

    private void processParameters() throws BadElementException, IOException {
        InputStream inputStream;
        String url;
        boolean z;
        byte[][] bArr;
        boolean z2;
        this.type = 32;
        this.originalType = 1;
        try {
            if (this.rawData == null) {
                try {
                    inputStream = this.url.openStream();
                } catch (Throwable th) {
                    th = th;
                    inputStream = null;
                }
                try {
                    url = this.url.toString();
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th;
                }
            } else {
                inputStream = new ByteArrayInputStream(this.rawData);
                url = "Byte array";
            }
            int i = 255;
            int i2 = 0;
            if (inputStream.read() != 255 || inputStream.read() != 216) {
                throw new BadElementException(MessageLocalization.getComposedMessage("1.is.not.a.valid.jpeg.file", url));
            }
            boolean z3 = true;
            while (true) {
                int read = inputStream.read();
                if (read < 0) {
                    throw new IOException(MessageLocalization.getComposedMessage("premature.eof.while.reading.jpg", new Object[0]));
                }
                if (read == i) {
                    int read2 = inputStream.read();
                    if (z3 && read2 == 224) {
                        int i3 = getShort(inputStream);
                        if (i3 < 16) {
                            Utilities.skip(inputStream, i3 - 2);
                        } else {
                            byte[] bArr2 = new byte[JFIF_ID.length];
                            if (inputStream.read(bArr2) != bArr2.length) {
                                Object[] objArr = new Object[1];
                                objArr[i2] = url;
                                throw new BadElementException(MessageLocalization.getComposedMessage("1.corrupted.jfif.marker", objArr));
                            }
                            int i4 = 0;
                            while (true) {
                                if (i4 >= bArr2.length) {
                                    z2 = true;
                                    break;
                                } else if (bArr2[i4] != JFIF_ID[i4]) {
                                    z2 = false;
                                    break;
                                } else {
                                    i4++;
                                }
                            }
                            if (!z2) {
                                Utilities.skip(inputStream, (i3 - 2) - bArr2.length);
                            } else {
                                Utilities.skip(inputStream, 2);
                                int read3 = inputStream.read();
                                int i5 = getShort(inputStream);
                                int i6 = getShort(inputStream);
                                if (read3 == 1) {
                                    this.dpiX = i5;
                                    this.dpiY = i6;
                                } else if (read3 == 2) {
                                    this.dpiX = (int) ((i5 * 2.54f) + 0.5f);
                                    this.dpiY = (int) ((i6 * 2.54f) + 0.5f);
                                }
                                Utilities.skip(inputStream, ((i3 - 2) - bArr2.length) - 7);
                            }
                        }
                        z3 = false;
                    } else {
                        if (read2 == 238) {
                            int i7 = getShort(inputStream) - 2;
                            byte[] bArr3 = new byte[i7];
                            for (int i8 = 0; i8 < i7; i8++) {
                                bArr3[i8] = (byte) inputStream.read();
                            }
                            if (bArr3.length >= 12 && new String(bArr3, i2, 5, "ISO-8859-1").equals("Adobe")) {
                                this.invert = true;
                            }
                        } else if (read2 == 226) {
                            int i9 = getShort(inputStream) - 2;
                            byte[] bArr4 = new byte[i9];
                            for (int i10 = 0; i10 < i9; i10++) {
                                bArr4[i10] = (byte) inputStream.read();
                            }
                            if (bArr4.length >= 14 && new String(bArr4, i2, 11, "ISO-8859-1").equals("ICC_PROFILE")) {
                                int i11 = bArr4[12] & i;
                                int i12 = bArr4[13] & i;
                                if (i11 <= 0) {
                                    i11 = 1;
                                }
                                if (i12 <= 0) {
                                    i12 = 1;
                                }
                                if (this.icc == null) {
                                    this.icc = new byte[i12];
                                }
                                this.icc[i11 - 1] = bArr4;
                            }
                        } else if (read2 == 237) {
                            int i13 = getShort(inputStream) - 2;
                            byte[] bArr5 = new byte[i13];
                            for (int i14 = 0; i14 < i13; i14++) {
                                bArr5[i14] = (byte) inputStream.read();
                            }
                            int i15 = 0;
                            while (i15 < i13 - PS_8BIM_RESO.length) {
                                int i16 = 0;
                                while (true) {
                                    if (i16 >= PS_8BIM_RESO.length) {
                                        z = true;
                                        break;
                                    } else if (bArr5[i15 + i16] != PS_8BIM_RESO[i16]) {
                                        z = false;
                                        break;
                                    } else {
                                        i16++;
                                    }
                                }
                                if (z) {
                                    break;
                                }
                                i15++;
                            }
                            int length = i15 + PS_8BIM_RESO.length;
                            if (length < i13 - PS_8BIM_RESO.length) {
                                byte b = (byte) (bArr5[length] + 1);
                                if (b % 2 == 1) {
                                    b = (byte) (b + 1);
                                }
                                int i17 = length + b;
                                if ((bArr5[i17] << 24) + (bArr5[i17 + 1] << 16) + (bArr5[i17 + 2] << 8) + bArr5[i17 + 3] == 16) {
                                    int i18 = i17 + 4;
                                    int i19 = (bArr5[i18] << 8) + bArr5[i18 + 1];
                                    int i20 = i18 + 2 + 2;
                                    int i21 = (bArr5[i20] << 8) + bArr5[i20 + 1];
                                    int i22 = i20 + 2 + 2;
                                    int i23 = (bArr5[i22] << 8) + bArr5[i22 + 1];
                                    int i24 = i22 + 2 + 2;
                                    int i25 = (bArr5[i24] << 8) + bArr5[i24 + 1];
                                    if (i21 == 1 || i21 == 2) {
                                        if (i21 == 2) {
                                            i19 = (int) ((i19 * 2.54f) + 0.5f);
                                        }
                                        if (this.dpiX == 0 || this.dpiX == i19) {
                                            this.dpiX = i19;
                                        }
                                    }
                                    if (i25 == 1 || i25 == 2) {
                                        if (i25 == 2) {
                                            i23 = (int) ((i23 * 2.54f) + 0.5f);
                                        }
                                        if (this.dpiY == 0 || this.dpiY == i23) {
                                            this.dpiY = i23;
                                        }
                                    }
                                }
                            }
                        } else {
                            int marker = marker(read2);
                            if (marker == 0) {
                                Utilities.skip(inputStream, 2);
                                if (inputStream.read() != 8) {
                                    throw new BadElementException(MessageLocalization.getComposedMessage("1.must.have.8.bits.per.component", url));
                                }
                                this.scaledHeight = getShort(inputStream);
                                setTop(this.scaledHeight);
                                this.scaledWidth = getShort(inputStream);
                                setRight(this.scaledWidth);
                                this.colorspace = inputStream.read();
                                this.bpc = 8;
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                this.plainWidth = getWidth();
                                this.plainHeight = getHeight();
                                if (this.icc == null) {
                                    return;
                                }
                                int i26 = 0;
                                int i27 = 0;
                                while (true) {
                                    byte[][] bArr6 = this.icc;
                                    if (i26 < bArr6.length) {
                                        if (bArr6[i26] == null) {
                                            this.icc = null;
                                            return;
                                        } else {
                                            i27 += bArr6[i26].length - 14;
                                            i26++;
                                        }
                                    } else {
                                        byte[] bArr7 = new byte[i27];
                                        int i28 = 0;
                                        int i29 = 0;
                                        while (true) {
                                            byte[][] bArr8 = this.icc;
                                            if (i28 < bArr8.length) {
                                                System.arraycopy(bArr8[i28], 14, bArr7, i29, bArr8[i28].length - 14);
                                                i29 += this.icc[i28].length - 14;
                                                i28++;
                                            } else {
                                                try {
                                                    break;
                                                } catch (IllegalArgumentException unused) {
                                                    bArr = null;
                                                }
                                            }
                                        }
                                        tagICC(ICC_Profile.getInstance(bArr7, this.colorspace));
                                        bArr = null;
                                        this.icc = bArr;
                                        return;
                                    }
                                }
                            } else if (marker == 1) {
                                throw new BadElementException(MessageLocalization.getComposedMessage("1.unsupported.jpeg.marker.2", url, String.valueOf(read2)));
                            } else {
                                if (marker != 2) {
                                    Utilities.skip(inputStream, getShort(inputStream) - 2);
                                }
                                z3 = false;
                            }
                        }
                        i = 255;
                        i2 = 0;
                    }
                }
                i = 255;
                i2 = 0;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }
}
