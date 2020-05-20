package com.itextpdf.text.pdf.codec;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.ImgRaw;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.ICC_Profile;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfLiteral;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* loaded from: classes.dex */
public class PngImage {
    public static final String IDAT = "IDAT";
    public static final String IEND = "IEND";
    public static final String IHDR = "IHDR";
    public static final String PLTE = "PLTE";
    private static final int PNG_FILTER_AVERAGE = 3;
    private static final int PNG_FILTER_NONE = 0;
    private static final int PNG_FILTER_PAETH = 4;
    private static final int PNG_FILTER_SUB = 1;
    private static final int PNG_FILTER_UP = 2;
    private static final int TRANSFERSIZE = 4096;
    public static final String cHRM = "cHRM";
    public static final String gAMA = "gAMA";
    public static final String iCCP = "iCCP";
    public static final String pHYs = "pHYs";
    public static final String sRGB = "sRGB";
    public static final String tRNS = "tRNS";
    float XYRatio;
    int bitDepth;
    int bytesPerPixel;
    byte[] colorTable;
    int colorType;
    int compressionMethod;
    DataInputStream dataStream;
    int dpiX;
    int dpiY;
    int filterMethod;
    boolean genBWMask;
    int height;
    ICC_Profile icc_profile;
    byte[] image;
    int inputBands;
    PdfName intent;
    int interlaceMethod;

    /* renamed from: is */
    InputStream f19822is;
    boolean palShades;
    byte[] smask;
    byte[] trans;
    int width;

    /* renamed from: xB */
    float f19823xB;

    /* renamed from: xG */
    float f19824xG;

    /* renamed from: xR */
    float f19825xR;

    /* renamed from: xW */
    float f19826xW;

    /* renamed from: yB */
    float f19827yB;

    /* renamed from: yG */
    float f19828yG;

    /* renamed from: yR */
    float f19829yR;

    /* renamed from: yW */
    float f19830yW;
    public static final int[] PNGID = {137, 80, 78, 71, 13, 10, 26, 10};
    private static final PdfName[] intents = {PdfName.PERCEPTUAL, PdfName.RELATIVECOLORIMETRIC, PdfName.SATURATION, PdfName.ABSOLUTECOLORIMETRIC};
    PdfDictionary additional = new PdfDictionary();
    NewByteArrayOutputStream idat = new NewByteArrayOutputStream();
    int transRedGray = -1;
    int transGreen = -1;
    int transBlue = -1;
    float gamma = 1.0f;
    boolean hasCHRM = false;

    PngImage(InputStream inputStream) {
        this.f19822is = inputStream;
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
        return new PngImage(inputStream).getImage();
    }

    public static Image getImage(String str) throws IOException {
        return getImage(Utilities.toURL(str));
    }

    public static Image getImage(byte[] bArr) throws IOException {
        Image image = getImage(new ByteArrayInputStream(bArr));
        image.setOriginalData(bArr);
        return image;
    }

    boolean checkMarker(String str) {
        if (str.length() != 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x039b, code lost:
        throw new java.io.IOException(com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage("corrupted.png.file", new java.lang.Object[0]));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void readPng() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 934
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.PngImage.readPng():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    PdfObject getColorspace() {
        if (this.icc_profile != null) {
            if ((this.colorType & 2) == 0) {
                return PdfName.DEVICEGRAY;
            }
            return PdfName.DEVICERGB;
        } else if (this.gamma == 1.0f && !this.hasCHRM) {
            if ((this.colorType & 2) == 0) {
                return PdfName.DEVICEGRAY;
            }
            return PdfName.DEVICERGB;
        } else {
            PdfArray pdfArray = new PdfArray();
            PdfDictionary pdfDictionary = new PdfDictionary();
            if ((this.colorType & 2) == 0) {
                if (this.gamma == 1.0f) {
                    return PdfName.DEVICEGRAY;
                }
                pdfArray.add(PdfName.CALGRAY);
                pdfDictionary.put(PdfName.GAMMA, new PdfNumber(this.gamma));
                pdfDictionary.put(PdfName.WHITEPOINT, new PdfLiteral("[1 1 1]"));
                pdfArray.add(pdfDictionary);
            } else {
                PdfLiteral pdfLiteral = new PdfLiteral("[1 1 1]");
                pdfArray.add(PdfName.CALRGB);
                if (this.gamma != 1.0f) {
                    PdfArray pdfArray2 = new PdfArray();
                    PdfNumber pdfNumber = new PdfNumber(this.gamma);
                    pdfArray2.add(pdfNumber);
                    pdfArray2.add(pdfNumber);
                    pdfArray2.add(pdfNumber);
                    pdfDictionary.put(PdfName.GAMMA, pdfArray2);
                }
                if (this.hasCHRM) {
                    float f = this.f19830yW;
                    float f2 = this.f19824xG;
                    float f3 = this.f19823xB;
                    float f4 = this.f19829yR;
                    float f5 = this.f19825xR;
                    float f6 = this.f19828yG;
                    float f7 = this.f19827yB;
                    float f8 = ((((f2 - f3) * f4) - ((f5 - f3) * f6)) + ((f5 - f2) * f7)) * f;
                    float f9 = this.f19826xW;
                    float f10 = (((((f2 - f3) * f) - ((f9 - f3) * f6)) + ((f9 - f2) * f7)) * f4) / f8;
                    float f11 = (f10 * f5) / f4;
                    float f12 = (((1.0f - f5) / f4) - 1.0f) * f10;
                    float f13 = ((-f6) * ((((f5 - f3) * f) - ((f9 - f3) * f4)) + ((f9 - f5) * f7))) / f8;
                    float f14 = (f13 * f2) / f6;
                    float f15 = f13 * (((1.0f - f2) / f6) - 1.0f);
                    float f16 = (((((f5 - f2) * f) - ((f9 - f2) * f)) + ((f9 - f5) * f6)) * f7) / f8;
                    float f17 = (f16 * f3) / f7;
                    float f18 = (((1.0f - f3) / f7) - 1.0f) * f16;
                    PdfArray pdfArray3 = new PdfArray();
                    pdfArray3.add(new PdfNumber(f11 + f14 + f17));
                    pdfArray3.add(new PdfNumber(1.0f));
                    pdfArray3.add(new PdfNumber(f12 + f15 + f18));
                    PdfArray pdfArray4 = new PdfArray();
                    pdfArray4.add(new PdfNumber(f11));
                    pdfArray4.add(new PdfNumber(f10));
                    pdfArray4.add(new PdfNumber(f12));
                    pdfArray4.add(new PdfNumber(f14));
                    pdfArray4.add(new PdfNumber(f13));
                    pdfArray4.add(new PdfNumber(f15));
                    pdfArray4.add(new PdfNumber(f17));
                    pdfArray4.add(new PdfNumber(f16));
                    pdfArray4.add(new PdfNumber(f18));
                    pdfDictionary.put(PdfName.MATRIX, pdfArray4);
                    pdfLiteral = pdfArray3;
                }
                pdfDictionary.put(PdfName.WHITEPOINT, pdfLiteral);
                pdfArray.add(pdfDictionary);
            }
            return pdfArray;
        }
    }

    Image getImage() throws IOException {
        int i;
        int i2;
        Image imgRaw;
        readPng();
        boolean z = false;
        try {
            this.palShades = false;
            if (this.trans != null) {
                int i3 = 0;
                i = 0;
                i2 = 0;
                while (true) {
                    if (i3 < this.trans.length) {
                        int i4 = this.trans[i3] & 255;
                        if (i4 == 0) {
                            i++;
                            i2 = i3;
                        }
                        if (i4 != 0 && i4 != 255) {
                            this.palShades = true;
                            break;
                        }
                        i3++;
                    } else {
                        break;
                    }
                }
            } else {
                i = 0;
                i2 = 0;
            }
            if ((this.colorType & 4) != 0) {
                this.palShades = true;
            }
            this.genBWMask = !this.palShades && (i > 1 || this.transRedGray >= 0);
            if (!this.palShades && !this.genBWMask && i == 1) {
                PdfDictionary pdfDictionary = this.additional;
                PdfName pdfName = PdfName.MASK;
                pdfDictionary.put(pdfName, new PdfLiteral("[" + i2 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + i2 + "]"));
            }
            z = (this.interlaceMethod == 1 || this.bitDepth == 16 || (this.colorType & 4) != 0 || this.palShades || this.genBWMask) ? true : true;
            int i5 = this.colorType;
            int i6 = 3;
            if (i5 == 0) {
                this.inputBands = 1;
            } else if (i5 != 6) {
                switch (i5) {
                    case 2:
                        this.inputBands = 3;
                        break;
                    case 3:
                        this.inputBands = 1;
                        break;
                    case 4:
                        this.inputBands = 2;
                        break;
                }
            } else {
                this.inputBands = 4;
            }
            if (z) {
                decodeIdat();
            }
            int i7 = this.inputBands;
            int i8 = (this.colorType & 4) != 0 ? i7 - 1 : i7;
            int i9 = this.bitDepth;
            int i10 = i9 == 16 ? 8 : i9;
            if (this.image != null) {
                if (this.colorType == 3) {
                    imgRaw = new ImgRaw(this.width, this.height, i8, i10, this.image);
                } else {
                    imgRaw = Image.getInstance(this.width, this.height, i8, i10, this.image);
                }
            } else {
                imgRaw = new ImgRaw(this.width, this.height, i8, i10, this.idat.toByteArray());
                imgRaw.setDeflated(true);
                PdfDictionary pdfDictionary2 = new PdfDictionary();
                pdfDictionary2.put(PdfName.BITSPERCOMPONENT, new PdfNumber(this.bitDepth));
                pdfDictionary2.put(PdfName.PREDICTOR, new PdfNumber(15));
                pdfDictionary2.put(PdfName.COLUMNS, new PdfNumber(this.width));
                pdfDictionary2.put(PdfName.COLORS, new PdfNumber((this.colorType == 3 || (this.colorType & 2) == 0) ? 1 : 1));
                this.additional.put(PdfName.DECODEPARMS, pdfDictionary2);
            }
            if (this.additional.get(PdfName.COLORSPACE) == null) {
                this.additional.put(PdfName.COLORSPACE, getColorspace());
            }
            if (this.intent != null) {
                this.additional.put(PdfName.INTENT, this.intent);
            }
            if (this.additional.size() > 0) {
                imgRaw.setAdditional(this.additional);
            }
            if (this.icc_profile != null) {
                imgRaw.tagICC(this.icc_profile);
            }
            if (this.palShades) {
                Image image = Image.getInstance(this.width, this.height, 1, 8, this.smask);
                image.makeMask();
                imgRaw.setImageMask(image);
            }
            if (this.genBWMask) {
                Image image2 = Image.getInstance(this.width, this.height, 1, 1, this.smask);
                image2.makeMask();
                imgRaw.setImageMask(image2);
            }
            imgRaw.setDpi(this.dpiX, this.dpiY);
            imgRaw.setXYRatio(this.XYRatio);
            imgRaw.setOriginalType(2);
            return imgRaw;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    void decodeIdat() {
        int i = this.bitDepth;
        if (i == 16) {
            i = 8;
        }
        this.bytesPerPixel = this.bitDepth == 16 ? 2 : 1;
        int i2 = this.colorType;
        if (i2 == 0) {
            r2 = (((i * this.width) + 7) / 8) * this.height;
        } else if (i2 != 6) {
            switch (i2) {
                case 2:
                    r2 = this.width * 3 * this.height;
                    this.bytesPerPixel *= 3;
                    break;
                case 3:
                    r2 = this.interlaceMethod == 1 ? (((i * this.width) + 7) / 8) * this.height : -1;
                    this.bytesPerPixel = 1;
                    break;
                case 4:
                    r2 = this.width * this.height;
                    this.bytesPerPixel *= 2;
                    break;
            }
        } else {
            r2 = this.width * 3 * this.height;
            this.bytesPerPixel *= 4;
        }
        if (r2 >= 0) {
            this.image = new byte[r2];
        }
        if (this.palShades) {
            this.smask = new byte[this.width * this.height];
        } else if (this.genBWMask) {
            this.smask = new byte[((this.width + 7) / 8) * this.height];
        }
        this.dataStream = new DataInputStream(new InflaterInputStream(new ByteArrayInputStream(this.idat.getBuf(), 0, this.idat.size()), new Inflater()));
        if (this.interlaceMethod != 1) {
            decodePass(0, 0, 1, 1, this.width, this.height);
            return;
        }
        decodePass(0, 0, 8, 8, (this.width + 7) / 8, (this.height + 7) / 8);
        decodePass(4, 0, 8, 8, (this.width + 3) / 8, (this.height + 7) / 8);
        decodePass(0, 4, 4, 8, (this.width + 3) / 4, (this.height + 3) / 8);
        decodePass(2, 0, 4, 4, (this.width + 1) / 4, (this.height + 3) / 4);
        decodePass(0, 2, 2, 4, (this.width + 1) / 2, (this.height + 1) / 4);
        decodePass(1, 0, 2, 2, this.width / 2, (this.height + 1) / 2);
        decodePass(0, 1, 1, 2, this.width, this.height / 2);
    }

    void decodePass(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        if (i5 == 0 || i6 == 0) {
            return;
        }
        int i8 = (((this.inputBands * i5) * this.bitDepth) + 7) / 8;
        int i9 = i2;
        byte[] bArr = new byte[i8];
        byte[] bArr2 = new byte[i8];
        int i10 = 0;
        while (i10 < i6) {
            try {
                i7 = this.dataStream.read();
                try {
                    this.dataStream.readFully(bArr, 0, i8);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                i7 = 0;
            }
            switch (i7) {
                case 0:
                    break;
                case 1:
                    decodeSubFilter(bArr, i8, this.bytesPerPixel);
                    break;
                case 2:
                    decodeUpFilter(bArr, bArr2, i8);
                    break;
                case 3:
                    decodeAverageFilter(bArr, bArr2, i8, this.bytesPerPixel);
                    break;
                case 4:
                    decodePaethFilter(bArr, bArr2, i8, this.bytesPerPixel);
                    break;
                default:
                    throw new RuntimeException(MessageLocalization.getComposedMessage("png.filter.unknown", new Object[0]));
            }
            processPixels(bArr, i, i3, i9, i5);
            i10++;
            i9 += i4;
            byte[] bArr3 = bArr2;
            bArr2 = bArr;
            bArr = bArr3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void processPixels(byte[] r25, int r26, int r27, int r28, int r29) {
        /*
            Method dump skipped, instructions count: 392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.PngImage.processPixels(byte[], int, int, int, int):void");
    }

    static int getPixel(byte[] bArr, int i, int i2, int i3, int i4) {
        if (i3 == 8) {
            return bArr[(i4 * i2) + i] & 255;
        }
        int i5 = i4 * i2;
        int i6 = 8 / i3;
        return (bArr[i5 + (i / i6)] >> ((8 - ((i % i6) * i3)) - i3)) & ((1 << i3) - 1);
    }

    static void setPixel(byte[] bArr, int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        if (i5 == 8) {
            int i8 = (i6 * i4) + (i3 * i2);
            while (i7 < i2) {
                bArr[i8 + i7] = (byte) iArr[i7 + i];
                i7++;
            }
        } else if (i5 != 16) {
            int i9 = 8 / i5;
            int i10 = (i6 * i4) + (i3 / i9);
            bArr[i10] = (byte) ((iArr[i] << ((8 - ((i3 % i9) * i5)) - i5)) | bArr[i10]);
        } else {
            int i11 = (i6 * i4) + (i3 * i2);
            while (i7 < i2) {
                bArr[i11 + i7] = (byte) (iArr[i7 + i] >>> 8);
                i7++;
            }
        }
    }

    int[] getPixel(byte[] bArr) {
        int i = this.bitDepth;
        int i2 = 0;
        if (i == 8) {
            int[] iArr = new int[bArr.length];
            while (i2 < iArr.length) {
                iArr[i2] = bArr[i2] & 255;
                i2++;
            }
            return iArr;
        } else if (i == 16) {
            int[] iArr2 = new int[bArr.length / 2];
            while (i2 < iArr2.length) {
                int i3 = i2 * 2;
                iArr2[i2] = ((bArr[i3] & 255) << 8) + (bArr[i3 + 1] & 255);
                i2++;
            }
            return iArr2;
        } else {
            int[] iArr3 = new int[(bArr.length * 8) / i];
            int i4 = 8 / i;
            int i5 = (1 << i) - 1;
            int i6 = 0;
            while (i2 < bArr.length) {
                int i7 = i4 - 1;
                while (i7 >= 0) {
                    iArr3[i6] = (bArr[i2] >>> (this.bitDepth * i7)) & i5;
                    i7--;
                    i6++;
                }
                i2++;
            }
            return iArr3;
        }
    }

    private static void decodeSubFilter(byte[] bArr, int i, int i2) {
        for (int i3 = i2; i3 < i; i3++) {
            bArr[i3] = (byte) ((bArr[i3] & 255) + (bArr[i3 - i2] & 255));
        }
    }

    private static void decodeUpFilter(byte[] bArr, byte[] bArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((bArr[i2] & 255) + (bArr2[i2] & 255));
        }
    }

    private static void decodeAverageFilter(byte[] bArr, byte[] bArr2, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) ((bArr[i3] & 255) + ((bArr2[i3] & 255) / 2));
        }
        for (int i4 = i2; i4 < i; i4++) {
            bArr[i4] = (byte) ((bArr[i4] & 255) + (((bArr[i4 - i2] & 255) + (bArr2[i4] & 255)) / 2));
        }
    }

    private static int paethPredictor(int i, int i2, int i3) {
        int i4 = (i + i2) - i3;
        int abs = Math.abs(i4 - i);
        int abs2 = Math.abs(i4 - i2);
        int abs3 = Math.abs(i4 - i3);
        return (abs > abs2 || abs > abs3) ? abs2 <= abs3 ? i2 : i3 : i;
    }

    private static void decodePaethFilter(byte[] bArr, byte[] bArr2, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) ((bArr[i3] & 255) + (bArr2[i3] & 255));
        }
        for (int i4 = i2; i4 < i; i4++) {
            int i5 = i4 - i2;
            bArr[i4] = (byte) ((bArr[i4] & 255) + paethPredictor(bArr[i5] & 255, bArr2[i4] & 255, bArr2[i5] & 255));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class NewByteArrayOutputStream extends ByteArrayOutputStream {
        NewByteArrayOutputStream() {
        }

        public byte[] getBuf() {
            return this.buf;
        }
    }

    public static final int getInt(InputStream inputStream) throws IOException {
        return (inputStream.read() << 24) + (inputStream.read() << 16) + (inputStream.read() << 8) + inputStream.read();
    }

    public static final int getWord(InputStream inputStream) throws IOException {
        return (inputStream.read() << 8) + inputStream.read();
    }

    public static final String getString(InputStream inputStream) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            stringBuffer.append((char) inputStream.read());
        }
        return stringBuffer.toString();
    }
}
