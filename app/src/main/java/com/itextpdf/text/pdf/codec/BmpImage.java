package com.itextpdf.text.pdf.codec;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.ImgRaw;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfString;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

/* loaded from: classes.dex */
public class BmpImage {
    private static final int BI_BITFIELDS = 3;
    private static final int BI_RGB = 0;
    private static final int BI_RLE4 = 2;
    private static final int BI_RLE8 = 1;
    private static final int LCS_CALIBRATED_RGB = 0;
    private static final int LCS_CMYK = 2;
    private static final int LCS_sRGB = 1;
    private static final int VERSION_2_1_BIT = 0;
    private static final int VERSION_2_24_BIT = 3;
    private static final int VERSION_2_4_BIT = 1;
    private static final int VERSION_2_8_BIT = 2;
    private static final int VERSION_3_1_BIT = 4;
    private static final int VERSION_3_24_BIT = 7;
    private static final int VERSION_3_4_BIT = 5;
    private static final int VERSION_3_8_BIT = 6;
    private static final int VERSION_3_NT_16_BIT = 8;
    private static final int VERSION_3_NT_32_BIT = 9;
    private static final int VERSION_4_16_BIT = 13;
    private static final int VERSION_4_1_BIT = 10;
    private static final int VERSION_4_24_BIT = 14;
    private static final int VERSION_4_32_BIT = 15;
    private static final int VERSION_4_4_BIT = 11;
    private static final int VERSION_4_8_BIT = 12;
    private int alphaMask;
    private long bitmapFileSize;
    private int bitsPerPixel;
    private int blueMask;
    private long compression;
    private int greenMask;
    int height;
    private long imageSize;
    private int imageType;
    private InputStream inputStream;
    private boolean isBottomUp;
    private int numBands;
    private byte[] palette;
    private int redMask;
    int width;
    private long xPelsPerMeter;
    private long yPelsPerMeter;
    public HashMap<String, Object> properties = new HashMap<>();
    private long bitmapOffset = 0;

    private int findMask(int i) {
        for (int i2 = 0; i2 < 32 && (i & 1) != 1; i2++) {
            i >>>= 1;
        }
        return i;
    }

    private int findShift(int i) {
        int i2 = 0;
        while (i2 < 32 && (i & 1) != 1) {
            i >>>= 1;
            i2++;
        }
        return i2;
    }

    BmpImage(InputStream inputStream, boolean z, int i) throws IOException {
        this.bitmapFileSize = i;
        process(inputStream, z);
    }

    public static Image getImage(URL url) throws IOException {
        InputStream inputStream;
        try {
            inputStream = url.openStream();
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            Image image = getImage(inputStream);
            image.setUrl(url);
            if (inputStream != null) {
                inputStream.close();
            }
            return image;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public static Image getImage(InputStream inputStream) throws IOException {
        return getImage(inputStream, false, 0);
    }

    public static Image getImage(InputStream inputStream, boolean z, int i) throws IOException {
        BmpImage bmpImage = new BmpImage(inputStream, z, i);
        try {
            Image image = bmpImage.getImage();
            double d = bmpImage.xPelsPerMeter;
            Double.isNaN(d);
            int i2 = (int) ((d * 0.0254d) + 0.5d);
            double d2 = bmpImage.yPelsPerMeter;
            Double.isNaN(d2);
            image.setDpi(i2, (int) ((d2 * 0.0254d) + 0.5d));
            image.setOriginalType(4);
            return image;
        } catch (BadElementException e) {
            throw new ExceptionConverter(e);
        }
    }

    public static Image getImage(String str) throws IOException {
        return getImage(Utilities.toURL(str));
    }

    public static Image getImage(byte[] bArr) throws IOException {
        Image image = getImage(new ByteArrayInputStream(bArr));
        image.setOriginalData(bArr);
        return image;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void process(InputStream inputStream, boolean z) throws IOException {
        int i;
        int i2;
        int i3;
        if (z || (inputStream instanceof BufferedInputStream)) {
            this.inputStream = inputStream;
        } else {
            this.inputStream = new BufferedInputStream(inputStream);
        }
        if (!z) {
            if (readUnsignedByte(this.inputStream) != 66 || readUnsignedByte(this.inputStream) != 77) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.magic.value.for.bmp.file", new Object[0]));
            }
            this.bitmapFileSize = readDWord(this.inputStream);
            readWord(this.inputStream);
            readWord(this.inputStream);
            this.bitmapOffset = readDWord(this.inputStream);
        }
        long readDWord = readDWord(this.inputStream);
        if (readDWord == 12) {
            this.width = readWord(this.inputStream);
            this.height = readWord(this.inputStream);
        } else {
            this.width = readLong(this.inputStream);
            this.height = readLong(this.inputStream);
        }
        int readWord = readWord(this.inputStream);
        this.bitsPerPixel = readWord(this.inputStream);
        this.properties.put("color_planes", Integer.valueOf(readWord));
        this.properties.put("bits_per_pixel", Integer.valueOf(this.bitsPerPixel));
        this.numBands = 3;
        if (this.bitmapOffset == 0) {
            this.bitmapOffset = readDWord;
        }
        if (readDWord == 12) {
            this.properties.put("bmp_version", "BMP v. 2.x");
            int i4 = this.bitsPerPixel;
            if (i4 == 1) {
                this.imageType = 0;
            } else if (i4 == 4) {
                this.imageType = 1;
            } else if (i4 == 8) {
                this.imageType = 2;
            } else if (i4 == 24) {
                this.imageType = 3;
            }
            long j = this.bitmapOffset;
            int i5 = ((int) (((j - 14) - readDWord) / 3)) * 3;
            if (j == readDWord) {
                switch (this.imageType) {
                    case 0:
                        i5 = 6;
                        break;
                    case 1:
                        i5 = 48;
                        break;
                    case 2:
                        i5 = 768;
                        break;
                    case 3:
                        i5 = 0;
                        break;
                }
                this.bitmapOffset = readDWord + i5;
            }
            readPalette(i5);
        } else {
            this.compression = readDWord(this.inputStream);
            this.imageSize = readDWord(this.inputStream);
            this.xPelsPerMeter = readLong(this.inputStream);
            this.yPelsPerMeter = readLong(this.inputStream);
            long readDWord2 = readDWord(this.inputStream);
            long readDWord3 = readDWord(this.inputStream);
            switch ((int) this.compression) {
                case 0:
                    this.properties.put("compression", "BI_RGB");
                    break;
                case 1:
                    this.properties.put("compression", "BI_RLE8");
                    break;
                case 2:
                    this.properties.put("compression", "BI_RLE4");
                    break;
                case 3:
                    this.properties.put("compression", "BI_BITFIELDS");
                    break;
            }
            this.properties.put("x_pixels_per_meter", Long.valueOf(this.xPelsPerMeter));
            this.properties.put("y_pixels_per_meter", Long.valueOf(this.yPelsPerMeter));
            this.properties.put("colors_used", Long.valueOf(readDWord2));
            this.properties.put("colors_important", Long.valueOf(readDWord3));
            if (readDWord == 40 || readDWord == 52 || readDWord == 56) {
                switch ((int) this.compression) {
                    case 0:
                    case 1:
                    case 2:
                        int i6 = this.bitsPerPixel;
                        if (i6 == 1) {
                            this.imageType = 4;
                        } else if (i6 == 4) {
                            this.imageType = 5;
                        } else if (i6 == 8) {
                            this.imageType = 6;
                        } else if (i6 == 24) {
                            this.imageType = 7;
                        } else if (i6 == 16) {
                            this.imageType = 8;
                            this.redMask = 31744;
                            this.greenMask = 992;
                            this.blueMask = 31;
                            this.properties.put("red_mask", Integer.valueOf(this.redMask));
                            this.properties.put("green_mask", Integer.valueOf(this.greenMask));
                            this.properties.put("blue_mask", Integer.valueOf(this.blueMask));
                        } else if (i6 == 32) {
                            this.imageType = 9;
                            this.redMask = 16711680;
                            this.greenMask = 65280;
                            this.blueMask = 255;
                            this.properties.put("red_mask", Integer.valueOf(this.redMask));
                            this.properties.put("green_mask", Integer.valueOf(this.greenMask));
                            this.properties.put("blue_mask", Integer.valueOf(this.blueMask));
                        }
                        if (readDWord >= 52) {
                            this.redMask = (int) readDWord(this.inputStream);
                            this.greenMask = (int) readDWord(this.inputStream);
                            this.blueMask = (int) readDWord(this.inputStream);
                            this.properties.put("red_mask", Integer.valueOf(this.redMask));
                            this.properties.put("green_mask", Integer.valueOf(this.greenMask));
                            this.properties.put("blue_mask", Integer.valueOf(this.blueMask));
                        }
                        if (readDWord == 56) {
                            this.alphaMask = (int) readDWord(this.inputStream);
                            this.properties.put("alpha_mask", Integer.valueOf(this.alphaMask));
                        }
                        long j2 = this.bitmapOffset;
                        int i7 = ((int) (((j2 - 14) - readDWord) / 4)) * 4;
                        if (j2 == readDWord) {
                            switch (this.imageType) {
                                case 4:
                                    if (readDWord2 == 0) {
                                        readDWord2 = 2;
                                    }
                                    i7 = ((int) readDWord2) * 4;
                                    break;
                                case 5:
                                    if (readDWord2 == 0) {
                                        readDWord2 = 16;
                                    }
                                    i7 = ((int) readDWord2) * 4;
                                    break;
                                case 6:
                                    if (readDWord2 == 0) {
                                        readDWord2 = 256;
                                    }
                                    i7 = ((int) readDWord2) * 4;
                                    break;
                                default:
                                    i7 = 0;
                                    break;
                            }
                            this.bitmapOffset = readDWord + i7;
                        }
                        readPalette(i7);
                        this.properties.put("bmp_version", "BMP v. 3.x");
                        break;
                    case 3:
                        int i8 = this.bitsPerPixel;
                        if (i8 == 16) {
                            this.imageType = 8;
                        } else if (i8 == 32) {
                            this.imageType = 9;
                        }
                        this.redMask = (int) readDWord(this.inputStream);
                        this.greenMask = (int) readDWord(this.inputStream);
                        this.blueMask = (int) readDWord(this.inputStream);
                        if (readDWord == 56) {
                            this.alphaMask = (int) readDWord(this.inputStream);
                            this.properties.put("alpha_mask", Integer.valueOf(this.alphaMask));
                        }
                        this.properties.put("red_mask", Integer.valueOf(this.redMask));
                        this.properties.put("green_mask", Integer.valueOf(this.greenMask));
                        this.properties.put("blue_mask", Integer.valueOf(this.blueMask));
                        if (readDWord2 != 0) {
                            readPalette(((int) readDWord2) * 4);
                        }
                        this.properties.put("bmp_version", "BMP v. 3.x NT");
                        break;
                    default:
                        throw new RuntimeException("Invalid compression specified in BMP file.");
                }
            } else if (readDWord == 108) {
                this.properties.put("bmp_version", "BMP v. 4.x");
                this.redMask = (int) readDWord(this.inputStream);
                this.greenMask = (int) readDWord(this.inputStream);
                this.blueMask = (int) readDWord(this.inputStream);
                this.alphaMask = (int) readDWord(this.inputStream);
                long readDWord4 = readDWord(this.inputStream);
                int readLong = readLong(this.inputStream);
                int readLong2 = readLong(this.inputStream);
                int readLong3 = readLong(this.inputStream);
                int readLong4 = readLong(this.inputStream);
                int readLong5 = readLong(this.inputStream);
                int readLong6 = readLong(this.inputStream);
                int readLong7 = readLong(this.inputStream);
                int readLong8 = readLong(this.inputStream);
                int readLong9 = readLong(this.inputStream);
                long readDWord5 = readDWord(this.inputStream);
                long readDWord6 = readDWord(this.inputStream);
                long readDWord7 = readDWord(this.inputStream);
                int i9 = this.bitsPerPixel;
                if (i9 == 1) {
                    this.imageType = 10;
                } else if (i9 == 4) {
                    this.imageType = 11;
                } else if (i9 == 8) {
                    this.imageType = 12;
                } else if (i9 == 16) {
                    this.imageType = 13;
                    if (((int) this.compression) == 0) {
                        this.redMask = 31744;
                        this.greenMask = 992;
                        this.blueMask = 31;
                    }
                } else if (i9 == 24) {
                    this.imageType = 14;
                } else if (i9 == 32) {
                    this.imageType = 15;
                    if (((int) this.compression) == 0) {
                        this.redMask = 16711680;
                        this.greenMask = 65280;
                        this.blueMask = 255;
                    }
                }
                this.properties.put("red_mask", Integer.valueOf(this.redMask));
                this.properties.put("green_mask", Integer.valueOf(this.greenMask));
                this.properties.put("blue_mask", Integer.valueOf(this.blueMask));
                this.properties.put("alpha_mask", Integer.valueOf(this.alphaMask));
                long j3 = this.bitmapOffset;
                int i10 = ((int) (((j3 - 14) - readDWord) / 4)) * 4;
                if (j3 == readDWord) {
                    switch (this.imageType) {
                        case 10:
                            if (readDWord2 == 0) {
                                readDWord2 = 2;
                            }
                            i10 = ((int) readDWord2) * 4;
                            break;
                        case 11:
                            if (readDWord2 == 0) {
                                readDWord2 = 16;
                            }
                            i10 = ((int) readDWord2) * 4;
                            break;
                        case 12:
                            if (readDWord2 == 0) {
                                readDWord2 = 256;
                            }
                            i10 = ((int) readDWord2) * 4;
                            break;
                        default:
                            i10 = 0;
                            break;
                    }
                    this.bitmapOffset = readDWord + i10;
                }
                readPalette(i10);
                switch ((int) readDWord4) {
                    case 0:
                        this.properties.put("color_space", "LCS_CALIBRATED_RGB");
                        this.properties.put("redX", Integer.valueOf(readLong));
                        this.properties.put("redY", Integer.valueOf(readLong2));
                        this.properties.put("redZ", Integer.valueOf(readLong3));
                        this.properties.put("greenX", Integer.valueOf(readLong4));
                        this.properties.put("greenY", Integer.valueOf(readLong5));
                        this.properties.put("greenZ", Integer.valueOf(readLong6));
                        this.properties.put("blueX", Integer.valueOf(readLong7));
                        this.properties.put("blueY", Integer.valueOf(readLong8));
                        this.properties.put("blueZ", Integer.valueOf(readLong9));
                        this.properties.put("gamma_red", Long.valueOf(readDWord5));
                        this.properties.put("gamma_green", Long.valueOf(readDWord6));
                        this.properties.put("gamma_blue", Long.valueOf(readDWord7));
                        throw new RuntimeException("Not implemented yet.");
                    case 1:
                        this.properties.put("color_space", "LCS_sRGB");
                        break;
                    case 2:
                        this.properties.put("color_space", "LCS_CMYK");
                        throw new RuntimeException("Not implemented yet.");
                }
            } else {
                this.properties.put("bmp_version", "BMP v. 5.x");
                throw new RuntimeException("BMP version 5 not implemented yet.");
            }
        }
        int i11 = this.height;
        if (i11 > 0) {
            i = 1;
            this.isBottomUp = true;
            i2 = 0;
        } else {
            i = 1;
            i2 = 0;
            this.isBottomUp = false;
            this.height = Math.abs(i11);
        }
        int i12 = this.bitsPerPixel;
        if (i12 == i || i12 == 4 || i12 == 8) {
            this.numBands = 1;
            int i13 = this.imageType;
            if (i13 == 0 || i13 == 1 || i13 == 2) {
                int length = this.palette.length / 3;
                if (length > 256) {
                    length = 256;
                }
                byte[] bArr = new byte[length];
                byte[] bArr2 = new byte[length];
                byte[] bArr3 = new byte[length];
                while (i2 < length) {
                    int i14 = i2 * 3;
                    byte[] bArr4 = this.palette;
                    bArr3[i2] = bArr4[i14];
                    bArr2[i2] = bArr4[i14 + 1];
                    bArr[i2] = bArr4[i14 + 2];
                    i2++;
                }
                return;
            }
            int length2 = this.palette.length / 4;
            if (length2 > 256) {
                length2 = 256;
            }
            byte[] bArr5 = new byte[length2];
            byte[] bArr6 = new byte[length2];
            byte[] bArr7 = new byte[length2];
            while (i2 < length2) {
                int i15 = i2 * 4;
                byte[] bArr8 = this.palette;
                bArr7[i2] = bArr8[i15];
                bArr6[i2] = bArr8[i15 + 1];
                bArr5[i2] = bArr8[i15 + 2];
                i2++;
            }
            return;
        }
        if (i12 == 16) {
            i3 = 3;
        } else if (i12 == 32) {
            this.numBands = this.alphaMask == 0 ? 3 : 4;
            return;
        } else {
            i3 = 3;
        }
        this.numBands = i3;
    }

    private byte[] getPalette(int i) {
        byte[] bArr = this.palette;
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[(bArr.length / i) * 3];
        int length = bArr.length / i;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * i;
            int i4 = i2 * 3;
            byte[] bArr3 = this.palette;
            int i5 = i3 + 1;
            bArr2[i4 + 2] = bArr3[i3];
            bArr2[i4 + 1] = bArr3[i5];
            bArr2[i4] = bArr3[i5 + 1];
        }
        return bArr2;
    }

    private Image getImage() throws IOException, BadElementException {
        switch (this.imageType) {
            case 0:
                return read1Bit(3);
            case 1:
                return read4Bit(3);
            case 2:
                return read8Bit(3);
            case 3:
                byte[] bArr = new byte[this.width * this.height * 3];
                read24Bit(bArr);
                return new ImgRaw(this.width, this.height, 3, 8, bArr);
            case 4:
                return read1Bit(4);
            case 5:
                int i = (int) this.compression;
                if (i != 0) {
                    if (i == 2) {
                        return readRLE4();
                    }
                    throw new RuntimeException("Invalid compression specified for BMP file.");
                }
                return read4Bit(4);
            case 6:
                switch ((int) this.compression) {
                    case 0:
                        return read8Bit(4);
                    case 1:
                        return readRLE8();
                    default:
                        throw new RuntimeException("Invalid compression specified for BMP file.");
                }
            case 7:
                byte[] bArr2 = new byte[this.width * this.height * 3];
                read24Bit(bArr2);
                return new ImgRaw(this.width, this.height, 3, 8, bArr2);
            case 8:
                return read1632Bit(false);
            case 9:
                return read1632Bit(true);
            case 10:
                return read1Bit(4);
            case 11:
                int i2 = (int) this.compression;
                if (i2 != 0) {
                    if (i2 == 2) {
                        return readRLE4();
                    }
                    throw new RuntimeException("Invalid compression specified for BMP file.");
                }
                return read4Bit(4);
            case 12:
                switch ((int) this.compression) {
                    case 0:
                        return read8Bit(4);
                    case 1:
                        return readRLE8();
                    default:
                        throw new RuntimeException("Invalid compression specified for BMP file.");
                }
            case 13:
                return read1632Bit(false);
            case 14:
                byte[] bArr3 = new byte[this.width * this.height * 3];
                read24Bit(bArr3);
                return new ImgRaw(this.width, this.height, 3, 8, bArr3);
            case 15:
                return read1632Bit(true);
            default:
                return null;
        }
    }

    private Image indexedModel(byte[] bArr, int i, int i2) throws BadElementException {
        ImgRaw imgRaw = new ImgRaw(this.width, this.height, 1, i, bArr);
        PdfArray pdfArray = new PdfArray();
        pdfArray.add(PdfName.INDEXED);
        pdfArray.add(PdfName.DEVICERGB);
        byte[] palette = getPalette(i2);
        pdfArray.add(new PdfNumber((palette.length / 3) - 1));
        pdfArray.add(new PdfString(palette));
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.COLORSPACE, pdfArray);
        imgRaw.setAdditional(pdfDictionary);
        return imgRaw;
    }

    private void readPalette(int i) throws IOException {
        if (i == 0) {
            return;
        }
        this.palette = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = this.inputStream.read(this.palette, i2, i - i2);
            if (read < 0) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("incomplete.palette", new Object[0]));
            }
            i2 += read;
        }
        this.properties.put("palette", this.palette);
    }

    private Image read1Bit(int i) throws IOException, BadElementException {
        int i2 = this.width;
        byte[] bArr = new byte[((i2 + 7) / 8) * this.height];
        double d = i2;
        Double.isNaN(d);
        int ceil = (int) Math.ceil(d / 8.0d);
        int i3 = ceil % 4;
        int i4 = 0;
        int i5 = (i3 != 0 ? 4 - i3 : 0) + ceil;
        int i6 = this.height * i5;
        byte[] bArr2 = new byte[i6];
        int i7 = 0;
        while (i7 < i6) {
            i7 += this.inputStream.read(bArr2, i7, i6 - i7);
        }
        if (this.isBottomUp) {
            while (i4 < this.height) {
                int i8 = i4 + 1;
                System.arraycopy(bArr2, i6 - (i8 * i5), bArr, i4 * ceil, ceil);
                i4 = i8;
            }
        } else {
            while (i4 < this.height) {
                System.arraycopy(bArr2, i4 * i5, bArr, i4 * ceil, ceil);
                i4++;
            }
        }
        return indexedModel(bArr, 1, i);
    }

    private Image read4Bit(int i) throws IOException, BadElementException {
        int i2 = this.width;
        byte[] bArr = new byte[((i2 + 1) / 2) * this.height];
        double d = i2;
        Double.isNaN(d);
        int ceil = (int) Math.ceil(d / 2.0d);
        int i3 = ceil % 4;
        int i4 = 0;
        int i5 = (i3 != 0 ? 4 - i3 : 0) + ceil;
        int i6 = this.height * i5;
        byte[] bArr2 = new byte[i6];
        int i7 = 0;
        while (i7 < i6) {
            i7 += this.inputStream.read(bArr2, i7, i6 - i7);
        }
        if (this.isBottomUp) {
            while (i4 < this.height) {
                int i8 = i4 + 1;
                System.arraycopy(bArr2, i6 - (i8 * i5), bArr, i4 * ceil, ceil);
                i4 = i8;
            }
        } else {
            while (i4 < this.height) {
                System.arraycopy(bArr2, i4 * i5, bArr, i4 * ceil, ceil);
                i4++;
            }
        }
        return indexedModel(bArr, 4, i);
    }

    private Image read8Bit(int i) throws IOException, BadElementException {
        int i2;
        int i3 = this.width;
        byte[] bArr = new byte[this.height * i3];
        int i4 = i3 * 8;
        int i5 = 0;
        if (i4 % 32 != 0) {
            double d = (((i4 / 32) + 1) * 32) - i4;
            Double.isNaN(d);
            i2 = (int) Math.ceil(d / 8.0d);
        } else {
            i2 = 0;
        }
        int i6 = (this.width + i2) * this.height;
        byte[] bArr2 = new byte[i6];
        int i7 = 0;
        while (i7 < i6) {
            i7 += this.inputStream.read(bArr2, i7, i6 - i7);
        }
        if (this.isBottomUp) {
            while (i5 < this.height) {
                int i8 = i5 + 1;
                int i9 = this.width;
                System.arraycopy(bArr2, i6 - ((i9 + i2) * i8), bArr, i5 * i9, i9);
                i5 = i8;
            }
        } else {
            while (i5 < this.height) {
                int i10 = this.width;
                System.arraycopy(bArr2, (i10 + i2) * i5, bArr, i5 * i10, i10);
                i5++;
            }
        }
        return indexedModel(bArr, 8, i);
    }

    private void read24Bit(byte[] bArr) {
        int i;
        int i2 = this.width * 24;
        if (i2 % 32 != 0) {
            double d = (((i2 / 32) + 1) * 32) - i2;
            Double.isNaN(d);
            i = (int) Math.ceil(d / 8.0d);
        } else {
            i = 0;
        }
        int i3 = (((this.width * 3) + 3) / 4) * 4 * this.height;
        byte[] bArr2 = new byte[i3];
        int i4 = 0;
        while (i4 < i3) {
            try {
                int read = this.inputStream.read(bArr2, i4, i3 - i4);
                if (read < 0) {
                    break;
                }
                i4 += read;
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }
        if (this.isBottomUp) {
            int i5 = ((this.width * this.height) * 3) - 1;
            int i6 = -i;
            int i7 = 0;
            while (i7 < this.height) {
                i7++;
                int i8 = (i5 - ((this.width * i7) * 3)) + 1;
                int i9 = i6 + i;
                for (int i10 = 0; i10 < this.width; i10++) {
                    int i11 = i9 + 1;
                    bArr[i8 + 2] = bArr2[i9];
                    int i12 = i11 + 1;
                    bArr[i8 + 1] = bArr2[i11];
                    i9 = i12 + 1;
                    bArr[i8] = bArr2[i12];
                    i8 += 3;
                }
                i6 = i9;
            }
            return;
        }
        int i13 = -i;
        int i14 = 0;
        int i15 = 0;
        while (i14 < this.height) {
            int i16 = i15;
            int i17 = i13 + i;
            for (int i18 = 0; i18 < this.width; i18++) {
                int i19 = i17 + 1;
                bArr[i16 + 2] = bArr2[i17];
                int i20 = i19 + 1;
                bArr[i16 + 1] = bArr2[i19];
                i17 = i20 + 1;
                bArr[i16] = bArr2[i20];
                i16 += 3;
            }
            i14++;
            i13 = i17;
            i15 = i16;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.itextpdf.text.Image read1632Bit(boolean r21) throws java.io.IOException, com.itextpdf.text.BadElementException {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.BmpImage.read1632Bit(boolean):com.itextpdf.text.Image");
    }

    private Image readRLE8() throws IOException, BadElementException {
        int i = (int) this.imageSize;
        if (i == 0) {
            i = (int) (this.bitmapFileSize - this.bitmapOffset);
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        int i3 = 0;
        while (i3 < i) {
            i3 += this.inputStream.read(bArr, i3, i - i3);
        }
        byte[] decodeRLE = decodeRLE(true, bArr);
        int i4 = this.width;
        int i5 = this.height * i4;
        if (this.isBottomUp) {
            byte[] bArr2 = new byte[decodeRLE.length];
            while (i2 < this.height) {
                int i6 = i2 + 1;
                System.arraycopy(decodeRLE, i5 - (i6 * i4), bArr2, i2 * i4, i4);
                i2 = i6;
            }
            decodeRLE = bArr2;
        }
        return indexedModel(decodeRLE, 8, 4);
    }

    private Image readRLE4() throws IOException, BadElementException {
        int i = (int) this.imageSize;
        if (i == 0) {
            i = (int) (this.bitmapFileSize - this.bitmapOffset);
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            i2 += this.inputStream.read(bArr, i2, i - i2);
        }
        byte[] decodeRLE = decodeRLE(false, bArr);
        if (this.isBottomUp) {
            int i3 = this.width;
            int i4 = this.height;
            byte[] bArr2 = new byte[i3 * i4];
            int i5 = 0;
            for (int i6 = i4 - 1; i6 >= 0; i6--) {
                int i7 = this.width;
                int i8 = i6 * i7;
                int i9 = i7 + i5;
                while (i5 != i9) {
                    bArr2[i5] = decodeRLE[i8];
                    i5++;
                    i8++;
                }
            }
            decodeRLE = bArr2;
        }
        int i10 = (this.width + 1) / 2;
        byte[] bArr3 = new byte[this.height * i10];
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < this.height) {
            int i14 = i12;
            for (int i15 = 0; i15 < this.width; i15++) {
                if ((i15 & 1) == 0) {
                    bArr3[(i15 / 2) + i13] = (byte) (decodeRLE[i14] << 4);
                    i14++;
                } else {
                    int i16 = (i15 / 2) + i13;
                    bArr3[i16] = (byte) (((byte) (decodeRLE[i14] & 15)) | bArr3[i16]);
                    i14++;
                }
            }
            i13 += i10;
            i11++;
            i12 = i14;
        }
        return indexedModel(bArr3, 4, 4);
    }

    private byte[] decodeRLE(boolean z, byte[] bArr) {
        int i;
        byte[] bArr2 = new byte[this.width * this.height];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 < this.height && i3 < bArr.length) {
            try {
                int i6 = i3 + 1;
                int i7 = bArr[i3] & 255;
                if (i7 != 0) {
                    int i8 = i6 + 1;
                    int i9 = bArr[i6] & 255;
                    if (z) {
                        int i10 = i5;
                        int i11 = i7;
                        while (i11 != 0) {
                            bArr2[i10] = (byte) i9;
                            i11--;
                            i10++;
                        }
                        i5 = i10;
                    } else {
                        int i12 = i5;
                        int i13 = 0;
                        while (i13 < i7) {
                            int i14 = i12 + 1;
                            bArr2[i12] = (byte) ((i13 & 1) == 1 ? i9 & 15 : (i9 >>> 4) & 15);
                            i13++;
                            i12 = i14;
                        }
                        i5 = i12;
                    }
                    i4 += i7;
                    i3 = i8;
                } else {
                    i3 = i6 + 1;
                    int i15 = bArr[i6] & 255;
                    if (i15 == 1) {
                        break;
                    } else if (i15 == 0) {
                        i2++;
                        i5 = i2 * this.width;
                        i4 = 0;
                    } else if (i15 != 2) {
                        if (z) {
                            i = i3;
                            int i16 = i15;
                            while (i16 != 0) {
                                bArr2[i5] = (byte) (bArr[i] & 255);
                                i16--;
                                i5++;
                                i++;
                            }
                        } else {
                            i = i3;
                            int i17 = 0;
                            int i18 = 0;
                            while (i17 < i15) {
                                int i19 = i17 & 1;
                                if (i19 == 0) {
                                    i18 = bArr[i] & 255;
                                    i++;
                                }
                                int i20 = i5 + 1;
                                bArr2[i5] = (byte) (i19 == 1 ? i18 & 15 : (i18 >>> 4) & 15);
                                i17++;
                                i5 = i20;
                            }
                        }
                        i4 += i15;
                        if (z) {
                            i3 = (i15 & 1) == 1 ? i + 1 : i;
                        } else {
                            int i21 = i15 & 3;
                            if (i21 != 1 && i21 != 2) {
                            }
                        }
                    } else {
                        int i22 = i3 + 1;
                        i4 += bArr[i3] & 255;
                        i3 = i22 + 1;
                        i2 += bArr[i22] & 255;
                        i5 = (this.width * i2) + i4;
                    }
                }
            } catch (RuntimeException unused) {
            }
        }
        return bArr2;
    }

    private int readUnsignedByte(InputStream inputStream) throws IOException {
        return inputStream.read() & 255;
    }

    private int readUnsignedShort(InputStream inputStream) throws IOException {
        return ((readUnsignedByte(inputStream) << 8) | readUnsignedByte(inputStream)) & 65535;
    }

    private int readShort(InputStream inputStream) throws IOException {
        return (readUnsignedByte(inputStream) << 8) | readUnsignedByte(inputStream);
    }

    private int readWord(InputStream inputStream) throws IOException {
        return readUnsignedShort(inputStream);
    }

    private long readUnsignedInt(InputStream inputStream) throws IOException {
        int readUnsignedByte = readUnsignedByte(inputStream);
        int readUnsignedByte2 = readUnsignedByte(inputStream);
        return ((readUnsignedByte(inputStream) << 24) | (readUnsignedByte(inputStream) << 16) | (readUnsignedByte2 << 8) | readUnsignedByte) & (-1);
    }

    private int readInt(InputStream inputStream) throws IOException {
        int readUnsignedByte = readUnsignedByte(inputStream);
        int readUnsignedByte2 = readUnsignedByte(inputStream);
        return (readUnsignedByte(inputStream) << 24) | (readUnsignedByte(inputStream) << 16) | (readUnsignedByte2 << 8) | readUnsignedByte;
    }

    private long readDWord(InputStream inputStream) throws IOException {
        return readUnsignedInt(inputStream);
    }

    private int readLong(InputStream inputStream) throws IOException {
        return readInt(inputStream);
    }
}
