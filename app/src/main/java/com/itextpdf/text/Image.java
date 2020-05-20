package com.itextpdf.text;

import com.itextpdf.p349a.PdfGraphics2D;
import com.itextpdf.text.api.Indentable;
import com.itextpdf.text.api.Spaceable;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.ICC_Profile;
import com.itextpdf.text.pdf.PRIndirectReference;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfIndirectReference;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfOCG;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import com.itextpdf.text.pdf.codec.BmpImage;
import com.itextpdf.text.pdf.codec.CCITTG4Encoder;
import com.itextpdf.text.pdf.codec.GifImage;
import com.itextpdf.text.pdf.codec.JBIG2Image;
import com.itextpdf.text.pdf.codec.PngImage;
import com.itextpdf.text.pdf.codec.TiffImage;
import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes.dex */
public abstract class Image extends Rectangle implements Indentable, Spaceable {

    /* renamed from: AX */
    public static final int f19589AX = 0;

    /* renamed from: AY */
    public static final int f19590AY = 1;

    /* renamed from: BX */
    public static final int f19591BX = 2;

    /* renamed from: BY */
    public static final int f19592BY = 3;

    /* renamed from: CX */
    public static final int f19593CX = 4;

    /* renamed from: CY */
    public static final int f19594CY = 5;
    public static final int DEFAULT = 0;

    /* renamed from: DX */
    public static final int f19595DX = 6;

    /* renamed from: DY */
    public static final int f19596DY = 7;
    public static final int LEFT = 0;
    public static final int MIDDLE = 1;
    public static final int ORIGINAL_BMP = 4;
    public static final int ORIGINAL_GIF = 3;
    public static final int ORIGINAL_JBIG2 = 9;
    public static final int ORIGINAL_JPEG = 1;
    public static final int ORIGINAL_JPEG2000 = 8;
    public static final int ORIGINAL_NONE = 0;
    public static final int ORIGINAL_PNG = 2;
    public static final int ORIGINAL_PS = 7;
    public static final int ORIGINAL_TIFF = 5;
    public static final int ORIGINAL_WMF = 6;
    public static final int RIGHT = 2;
    public static final int TEXTWRAP = 4;
    public static final int UNDERLYING = 8;
    static long serialId;
    private float XYRatio;
    protected float absoluteX;
    protected float absoluteY;
    private PdfDictionary additional;
    protected int alignment;
    protected String alt;
    protected Annotation annotation;
    protected int bpc;
    protected int colorspace;
    protected int compressionLevel;
    protected boolean deflated;
    private PdfIndirectReference directReference;
    protected int dpiX;
    protected int dpiY;
    protected Image imageMask;
    protected float indentationLeft;
    protected float indentationRight;
    private float initialRotation;
    protected boolean interpolation;
    protected boolean invert;
    protected PdfOCG layer;
    protected boolean mask;
    protected Long mySerialId;
    protected byte[] originalData;
    protected int originalType;
    protected float plainHeight;
    protected float plainWidth;
    protected ICC_Profile profile;
    protected byte[] rawData;
    protected float rotationRadians;
    protected boolean scaleToFitLineWhenOverflow;
    protected float scaledHeight;
    protected float scaledWidth;
    private boolean smask;
    protected float spacingAfter;
    protected float spacingBefore;
    protected PdfTemplate[] template;
    protected int[] transparency;
    protected int type;
    protected URL url;
    private float widthPercentage;

    @Override // com.itextpdf.text.Rectangle, com.itextpdf.text.Element
    public boolean isNestable() {
        return true;
    }

    public Image(URL url) {
        super(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        this.bpc = 1;
        this.template = new PdfTemplate[1];
        this.absoluteX = Float.NaN;
        this.absoluteY = Float.NaN;
        this.compressionLevel = -1;
        this.mySerialId = getSerialId();
        this.indentationLeft = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.indentationRight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.widthPercentage = 100.0f;
        this.scaleToFitLineWhenOverflow = true;
        this.annotation = null;
        this.originalType = 0;
        this.deflated = false;
        this.dpiX = 0;
        this.dpiY = 0;
        this.XYRatio = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.colorspace = -1;
        this.invert = false;
        this.profile = null;
        this.additional = null;
        this.mask = false;
        this.url = url;
        this.alignment = 0;
        this.rotationRadians = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    }

    public static Image getInstance(URL url) throws BadElementException, MalformedURLException, IOException {
        InputStream openStream;
        RandomAccessFileOrArray randomAccessFileOrArray;
        RandomAccessFileOrArray randomAccessFileOrArray2;
        InputStream inputStream = null;
        try {
            openStream = url.openStream();
        } catch (Throwable th) {
            th = th;
        }
        try {
            int read = openStream.read();
            int read2 = openStream.read();
            int read3 = openStream.read();
            int read4 = openStream.read();
            int read5 = openStream.read();
            int read6 = openStream.read();
            int read7 = openStream.read();
            int read8 = openStream.read();
            openStream.close();
            if (read == 71 && read2 == 73 && read3 == 70) {
                return new GifImage(url).getImage(1);
            }
            if (read == 255 && read2 == 216) {
                return new Jpeg(url);
            }
            if (read == 0 && read2 == 0 && read3 == 0 && read4 == 12) {
                return new Jpeg2000(url);
            }
            if (read == 255 && read2 == 79 && read3 == 255 && read4 == 81) {
                return new Jpeg2000(url);
            }
            if (read == PngImage.PNGID[0] && read2 == PngImage.PNGID[1] && read3 == PngImage.PNGID[2] && read4 == PngImage.PNGID[3]) {
                return PngImage.getImage(url);
            }
            if (read == 215 && read2 == 205) {
                return new ImgWMF(url);
            }
            if (read == 66 && read2 == 77) {
                return BmpImage.getImage(url);
            }
            if ((read == 77 && read2 == 77 && read3 == 0 && read4 == 42) || (read == 73 && read2 == 73 && read3 == 42 && read4 == 0)) {
                try {
                    if (url.getProtocol().equals(Annotation.FILE)) {
                        randomAccessFileOrArray2 = new RandomAccessFileOrArray(Utilities.unEscapeURL(url.getFile()));
                    } else {
                        randomAccessFileOrArray2 = new RandomAccessFileOrArray(url);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFileOrArray2 = null;
                }
                try {
                    Image tiffImage = TiffImage.getTiffImage(randomAccessFileOrArray2, 1);
                    tiffImage.url = url;
                    randomAccessFileOrArray2.close();
                    return tiffImage;
                } catch (Throwable th3) {
                    th = th3;
                    if (randomAccessFileOrArray2 != null) {
                        randomAccessFileOrArray2.close();
                    }
                    throw th;
                }
            } else if (read == 151 && read2 == 74 && read3 == 66 && read4 == 50 && read5 == 13 && read6 == 10 && read7 == 26 && read8 == 10) {
                try {
                    if (url.getProtocol().equals(Annotation.FILE)) {
                        randomAccessFileOrArray = new RandomAccessFileOrArray(Utilities.unEscapeURL(url.getFile()));
                    } else {
                        randomAccessFileOrArray = new RandomAccessFileOrArray(url);
                    }
                } catch (Throwable th4) {
                    th = th4;
                    randomAccessFileOrArray = null;
                }
                try {
                    Image jbig2Image = JBIG2Image.getJbig2Image(randomAccessFileOrArray, 1);
                    jbig2Image.url = url;
                    randomAccessFileOrArray.close();
                    return jbig2Image;
                } catch (Throwable th5) {
                    th = th5;
                    if (randomAccessFileOrArray != null) {
                        randomAccessFileOrArray.close();
                    }
                    throw th;
                }
            } else {
                throw new IOException(url.toString() + " is not a recognized imageformat.");
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream = openStream;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public static Image getInstance(String str) throws BadElementException, MalformedURLException, IOException {
        return getInstance(Utilities.toURL(str));
    }

    public static Image getInstance(byte[] bArr) throws BadElementException, MalformedURLException, IOException {
        ByteArrayInputStream byteArrayInputStream;
        RandomAccessFileOrArray randomAccessFileOrArray;
        RandomAccessFileOrArray randomAccessFileOrArray2;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
        } catch (Throwable th) {
            th = th;
        }
        try {
            int read = byteArrayInputStream.read();
            int read2 = byteArrayInputStream.read();
            int read3 = byteArrayInputStream.read();
            int read4 = byteArrayInputStream.read();
            byteArrayInputStream.close();
            if (read == 71 && read2 == 73 && read3 == 70) {
                return new GifImage(bArr).getImage(1);
            }
            if (read == 255 && read2 == 216) {
                return new Jpeg(bArr);
            }
            if (read == 0 && read2 == 0 && read3 == 0 && read4 == 12) {
                return new Jpeg2000(bArr);
            }
            if (read == 255 && read2 == 79 && read3 == 255 && read4 == 81) {
                return new Jpeg2000(bArr);
            }
            if (read == PngImage.PNGID[0] && read2 == PngImage.PNGID[1] && read3 == PngImage.PNGID[2] && read4 == PngImage.PNGID[3]) {
                return PngImage.getImage(bArr);
            }
            if (read == 215 && read2 == 205) {
                return new ImgWMF(bArr);
            }
            if (read == 66 && read2 == 77) {
                return BmpImage.getImage(bArr);
            }
            if ((read == 77 && read2 == 77 && read3 == 0 && read4 == 42) || (read == 73 && read2 == 73 && read3 == 42 && read4 == 0)) {
                try {
                    randomAccessFileOrArray2 = new RandomAccessFileOrArray(bArr);
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFileOrArray2 = null;
                }
                try {
                    Image tiffImage = TiffImage.getTiffImage(randomAccessFileOrArray2, 1);
                    if (tiffImage.getOriginalData() == null) {
                        tiffImage.setOriginalData(bArr);
                    }
                    randomAccessFileOrArray2.close();
                    return tiffImage;
                } catch (Throwable th3) {
                    th = th3;
                    if (randomAccessFileOrArray2 != null) {
                        randomAccessFileOrArray2.close();
                    }
                    throw th;
                }
            }
            if (read == 151 && read2 == 74 && read3 == 66 && read4 == 50) {
                ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(bArr);
                byteArrayInputStream3.skip(4L);
                int read5 = byteArrayInputStream3.read();
                int read6 = byteArrayInputStream3.read();
                int read7 = byteArrayInputStream3.read();
                int read8 = byteArrayInputStream3.read();
                if (read5 == 13 && read6 == 10 && read7 == 26 && read8 == 10) {
                    if ((byteArrayInputStream3.read() & 2) == 2) {
                        byteArrayInputStream3.read();
                        byteArrayInputStream3.read();
                        byteArrayInputStream3.read();
                        byteArrayInputStream3.read();
                    }
                    byteArrayInputStream3.close();
                    try {
                        randomAccessFileOrArray = new RandomAccessFileOrArray(bArr);
                    } catch (Throwable th4) {
                        th = th4;
                        randomAccessFileOrArray = null;
                    }
                    try {
                        Image jbig2Image = JBIG2Image.getJbig2Image(randomAccessFileOrArray, 1);
                        if (jbig2Image.getOriginalData() == null) {
                            jbig2Image.setOriginalData(bArr);
                        }
                        randomAccessFileOrArray.close();
                        byteArrayInputStream3.close();
                        return jbig2Image;
                    } catch (Throwable th5) {
                        th = th5;
                        if (randomAccessFileOrArray != null) {
                            randomAccessFileOrArray.close();
                        }
                        throw th;
                    }
                }
            }
            throw new IOException(MessageLocalization.getComposedMessage("the.byte.array.is.not.a.recognized.imageformat", new Object[0]));
        } catch (Throwable th6) {
            th = th6;
            byteArrayInputStream2 = byteArrayInputStream;
            if (byteArrayInputStream2 != null) {
                byteArrayInputStream2.close();
            }
            throw th;
        }
    }

    public static Image getInstance(int i, int i2, int i3, int i4, byte[] bArr) throws BadElementException {
        return getInstance(i, i2, i3, i4, bArr, (int[]) null);
    }

    public static Image getInstance(int i, int i2, byte[] bArr, byte[] bArr2) {
        return new ImgJBIG2(i, i2, bArr, bArr2);
    }

    public static Image getInstance(int i, int i2, boolean z, int i3, int i4, byte[] bArr) throws BadElementException {
        return getInstance(i, i2, z, i3, i4, bArr, null);
    }

    public static Image getInstance(int i, int i2, boolean z, int i3, int i4, byte[] bArr, int[] iArr) throws BadElementException {
        if (iArr != null && iArr.length != 2) {
            throw new BadElementException(MessageLocalization.getComposedMessage("transparency.length.must.be.equal.to.2.with.ccitt.images", new Object[0]));
        }
        ImgCCITT imgCCITT = new ImgCCITT(i, i2, z, i3, i4, bArr);
        imgCCITT.transparency = iArr;
        return imgCCITT;
    }

    public static Image getInstance(int i, int i2, int i3, int i4, byte[] bArr, int[] iArr) throws BadElementException {
        if (iArr == null || iArr.length == i3 * 2) {
            if (i3 == 1 && i4 == 1) {
                return getInstance(i, i2, false, 256, 1, CCITTG4Encoder.compress(bArr, i, i2), iArr);
            }
            ImgRaw imgRaw = new ImgRaw(i, i2, i3, i4, bArr);
            imgRaw.transparency = iArr;
            return imgRaw;
        }
        throw new BadElementException(MessageLocalization.getComposedMessage("transparency.length.must.be.equal.to.componentes.2", new Object[0]));
    }

    public static Image getInstance(PdfTemplate pdfTemplate) throws BadElementException {
        return new ImgTemplate(pdfTemplate);
    }

    public PdfIndirectReference getDirectReference() {
        return this.directReference;
    }

    public void setDirectReference(PdfIndirectReference pdfIndirectReference) {
        this.directReference = pdfIndirectReference;
    }

    public static Image getInstance(PRIndirectReference pRIndirectReference) throws BadElementException {
        Image image;
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease(pRIndirectReference);
        int intValue = ((PdfNumber) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.WIDTH))).intValue();
        int intValue2 = ((PdfNumber) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.HEIGHT))).intValue();
        PdfObject pdfObject = pdfDictionary.get(PdfName.SMASK);
        if (pdfObject != null && pdfObject.isIndirect()) {
            image = getInstance((PRIndirectReference) pdfObject);
        } else {
            PdfObject pdfObject2 = pdfDictionary.get(PdfName.MASK);
            image = (pdfObject2 != null && pdfObject2.isIndirect() && (PdfReader.getPdfObjectRelease(pdfObject2) instanceof PdfDictionary)) ? getInstance((PRIndirectReference) pdfObject2) : null;
        }
        ImgRaw imgRaw = new ImgRaw(intValue, intValue2, 1, 1, null);
        imgRaw.imageMask = image;
        ((Image) imgRaw).directReference = pRIndirectReference;
        return imgRaw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Image(Image image) {
        super(image);
        this.bpc = 1;
        this.template = new PdfTemplate[1];
        this.absoluteX = Float.NaN;
        this.absoluteY = Float.NaN;
        this.compressionLevel = -1;
        this.mySerialId = getSerialId();
        this.indentationLeft = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.indentationRight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.widthPercentage = 100.0f;
        this.scaleToFitLineWhenOverflow = true;
        this.annotation = null;
        this.originalType = 0;
        this.deflated = false;
        this.dpiX = 0;
        this.dpiY = 0;
        this.XYRatio = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.colorspace = -1;
        this.invert = false;
        this.profile = null;
        this.additional = null;
        this.mask = false;
        this.type = image.type;
        this.url = image.url;
        this.rawData = image.rawData;
        this.bpc = image.bpc;
        this.template = image.template;
        this.alignment = image.alignment;
        this.alt = image.alt;
        this.absoluteX = image.absoluteX;
        this.absoluteY = image.absoluteY;
        this.plainWidth = image.plainWidth;
        this.plainHeight = image.plainHeight;
        this.scaledWidth = image.scaledWidth;
        this.scaledHeight = image.scaledHeight;
        this.mySerialId = image.mySerialId;
        this.directReference = image.directReference;
        this.rotationRadians = image.rotationRadians;
        this.initialRotation = image.initialRotation;
        this.indentationLeft = image.indentationLeft;
        this.indentationRight = image.indentationRight;
        this.spacingBefore = image.spacingBefore;
        this.spacingAfter = image.spacingAfter;
        this.widthPercentage = image.widthPercentage;
        this.scaleToFitLineWhenOverflow = image.scaleToFitLineWhenOverflow;
        this.annotation = image.annotation;
        this.layer = image.layer;
        this.interpolation = image.interpolation;
        this.originalType = image.originalType;
        this.originalData = image.originalData;
        this.deflated = image.deflated;
        this.dpiX = image.dpiX;
        this.dpiY = image.dpiY;
        this.XYRatio = image.XYRatio;
        this.colorspace = image.colorspace;
        this.invert = image.invert;
        this.profile = image.profile;
        this.additional = image.additional;
        this.mask = image.mask;
        this.imageMask = image.imageMask;
        this.smask = image.smask;
        this.transparency = image.transparency;
    }

    public static Image getInstance(Image image) {
        if (image == null) {
            return null;
        }
        try {
            return (Image) image.getClass().getDeclaredConstructor(Image.class).newInstance(image);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    @Override // com.itextpdf.text.Rectangle, com.itextpdf.text.Element
    public int type() {
        return this.type;
    }

    public boolean isJpeg() {
        return this.type == 32;
    }

    public boolean isImgRaw() {
        return this.type == 34;
    }

    public boolean isImgTemplate() {
        return this.type == 35;
    }

    public URL getUrl() {
        return this.url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public byte[] getRawData() {
        return this.rawData;
    }

    public int getBpc() {
        return this.bpc;
    }

    public PdfTemplate getTemplateData() {
        return this.template[0];
    }

    public void setTemplateData(PdfTemplate pdfTemplate) {
        this.template[0] = pdfTemplate;
    }

    public int getAlignment() {
        return this.alignment;
    }

    public void setAlignment(int i) {
        this.alignment = i;
    }

    public String getAlt() {
        return this.alt;
    }

    public void setAlt(String str) {
        this.alt = str;
    }

    public void setAbsolutePosition(float f, float f2) {
        this.absoluteX = f;
        this.absoluteY = f2;
    }

    public boolean hasAbsoluteX() {
        return !Float.isNaN(this.absoluteX);
    }

    public float getAbsoluteX() {
        return this.absoluteX;
    }

    public boolean hasAbsoluteY() {
        return !Float.isNaN(this.absoluteY);
    }

    public float getAbsoluteY() {
        return this.absoluteY;
    }

    public float getScaledWidth() {
        return this.scaledWidth;
    }

    public float getScaledHeight() {
        return this.scaledHeight;
    }

    public float getPlainWidth() {
        return this.plainWidth;
    }

    public float getPlainHeight() {
        return this.plainHeight;
    }

    public void scaleAbsolute(float f, float f2) {
        this.plainWidth = f;
        this.plainHeight = f2;
        float[] matrix = matrix();
        this.scaledWidth = matrix[6] - matrix[4];
        this.scaledHeight = matrix[7] - matrix[5];
        setWidthPercentage(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
    }

    public void scaleAbsoluteWidth(float f) {
        this.plainWidth = f;
        float[] matrix = matrix();
        this.scaledWidth = matrix[6] - matrix[4];
        this.scaledHeight = matrix[7] - matrix[5];
        setWidthPercentage(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
    }

    public void scaleAbsoluteHeight(float f) {
        this.plainHeight = f;
        float[] matrix = matrix();
        this.scaledWidth = matrix[6] - matrix[4];
        this.scaledHeight = matrix[7] - matrix[5];
        setWidthPercentage(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
    }

    public void scalePercent(float f) {
        scalePercent(f, f);
    }

    public void scalePercent(float f, float f2) {
        this.plainWidth = (getWidth() * f) / 100.0f;
        this.plainHeight = (getHeight() * f2) / 100.0f;
        float[] matrix = matrix();
        this.scaledWidth = matrix[6] - matrix[4];
        this.scaledHeight = matrix[7] - matrix[5];
        setWidthPercentage(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
    }

    public void scaleToFit(float f, float f2) {
        scalePercent(100.0f);
        float scaledWidth = (f * 100.0f) / getScaledWidth();
        float scaledHeight = (f2 * 100.0f) / getScaledHeight();
        if (scaledWidth >= scaledHeight) {
            scaledWidth = scaledHeight;
        }
        scalePercent(scaledWidth);
        setWidthPercentage(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
    }

    public float[] matrix() {
        float[] fArr = new float[8];
        float cos = (float) Math.cos(this.rotationRadians);
        float sin = (float) Math.sin(this.rotationRadians);
        float f = this.plainWidth;
        fArr[0] = f * cos;
        fArr[1] = f * sin;
        float f2 = this.plainHeight;
        fArr[2] = (-f2) * sin;
        fArr[3] = f2 * cos;
        float f3 = this.rotationRadians;
        if (f3 < 1.5707963267948966d) {
            fArr[4] = fArr[2];
            fArr[5] = 0.0f;
            fArr[6] = fArr[0];
            fArr[7] = fArr[1] + fArr[3];
        } else if (f3 < 3.141592653589793d) {
            fArr[4] = fArr[0] + fArr[2];
            fArr[5] = fArr[3];
            fArr[6] = 0.0f;
            fArr[7] = fArr[1];
        } else if (f3 < 4.71238898038469d) {
            fArr[4] = fArr[0];
            fArr[5] = fArr[1] + fArr[3];
            fArr[6] = fArr[2];
            fArr[7] = 0.0f;
        } else {
            fArr[4] = 0.0f;
            fArr[5] = fArr[1];
            fArr[6] = fArr[0] + fArr[2];
            fArr[7] = fArr[3];
        }
        return fArr;
    }

    protected static synchronized Long getSerialId() {
        Long valueOf;
        synchronized (Image.class) {
            long j = serialId + 1;
            serialId = j;
            valueOf = Long.valueOf(j);
        }
        return valueOf;
    }

    public Long getMySerialId() {
        return this.mySerialId;
    }

    public float getImageRotation() {
        double d = this.rotationRadians - this.initialRotation;
        Double.isNaN(d);
        float f = (float) (d % 6.283185307179586d);
        if (f < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            double d2 = f;
            Double.isNaN(d2);
            return (float) (d2 + 6.283185307179586d);
        }
        return f;
    }

    public void setRotation(float f) {
        double d = f + this.initialRotation;
        Double.isNaN(d);
        this.rotationRadians = (float) (d % 6.283185307179586d);
        float f2 = this.rotationRadians;
        if (f2 < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            double d2 = f2;
            Double.isNaN(d2);
            this.rotationRadians = (float) (d2 + 6.283185307179586d);
        }
        float[] matrix = matrix();
        this.scaledWidth = matrix[6] - matrix[4];
        this.scaledHeight = matrix[7] - matrix[5];
    }

    public void setRotationDegrees(float f) {
        setRotation((f / 180.0f) * 3.1415927f);
    }

    public float getInitialRotation() {
        return this.initialRotation;
    }

    public void setInitialRotation(float f) {
        this.initialRotation = f;
        setRotation(this.rotationRadians - this.initialRotation);
    }

    @Override // com.itextpdf.text.api.Indentable
    public float getIndentationLeft() {
        return this.indentationLeft;
    }

    @Override // com.itextpdf.text.api.Indentable
    public void setIndentationLeft(float f) {
        this.indentationLeft = f;
    }

    @Override // com.itextpdf.text.api.Indentable
    public float getIndentationRight() {
        return this.indentationRight;
    }

    @Override // com.itextpdf.text.api.Indentable
    public void setIndentationRight(float f) {
        this.indentationRight = f;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public float getSpacingBefore() {
        return this.spacingBefore;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public void setSpacingBefore(float f) {
        this.spacingBefore = f;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public float getSpacingAfter() {
        return this.spacingAfter;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public void setSpacingAfter(float f) {
        this.spacingAfter = f;
    }

    public float getWidthPercentage() {
        return this.widthPercentage;
    }

    public void setWidthPercentage(float f) {
        this.widthPercentage = f;
    }

    public boolean isScaleToFitLineWhenOverflow() {
        return this.scaleToFitLineWhenOverflow;
    }

    public void setScaleToFitLineWhenOverflow(boolean z) {
        this.scaleToFitLineWhenOverflow = z;
    }

    public void setAnnotation(Annotation annotation) {
        this.annotation = annotation;
    }

    public Annotation getAnnotation() {
        return this.annotation;
    }

    public PdfOCG getLayer() {
        return this.layer;
    }

    public void setLayer(PdfOCG pdfOCG) {
        this.layer = pdfOCG;
    }

    public boolean isInterpolation() {
        return this.interpolation;
    }

    public void setInterpolation(boolean z) {
        this.interpolation = z;
    }

    public int getOriginalType() {
        return this.originalType;
    }

    public void setOriginalType(int i) {
        this.originalType = i;
    }

    public byte[] getOriginalData() {
        return this.originalData;
    }

    public void setOriginalData(byte[] bArr) {
        this.originalData = bArr;
    }

    public boolean isDeflated() {
        return this.deflated;
    }

    public void setDeflated(boolean z) {
        this.deflated = z;
    }

    public int getDpiX() {
        return this.dpiX;
    }

    public int getDpiY() {
        return this.dpiY;
    }

    public void setDpi(int i, int i2) {
        this.dpiX = i;
        this.dpiY = i2;
    }

    public float getXYRatio() {
        return this.XYRatio;
    }

    public void setXYRatio(float f) {
        this.XYRatio = f;
    }

    public int getColorspace() {
        return this.colorspace;
    }

    public boolean isInverted() {
        return this.invert;
    }

    public void setInverted(boolean z) {
        this.invert = z;
    }

    public void tagICC(ICC_Profile iCC_Profile) {
        this.profile = iCC_Profile;
    }

    public boolean hasICCProfile() {
        return this.profile != null;
    }

    public ICC_Profile getICCProfile() {
        return this.profile;
    }

    public PdfDictionary getAdditional() {
        return this.additional;
    }

    public void setAdditional(PdfDictionary pdfDictionary) {
        this.additional = pdfDictionary;
    }

    public void simplifyColorspace() {
        PdfArray asArray;
        PdfArray asArray2;
        PdfDictionary pdfDictionary = this.additional;
        if (pdfDictionary == null || (asArray = pdfDictionary.getAsArray(PdfName.COLORSPACE)) == null) {
            return;
        }
        PdfObject simplifyColorspace = simplifyColorspace(asArray);
        if (simplifyColorspace.isName()) {
            asArray = simplifyColorspace;
        } else if (PdfName.INDEXED.equals(asArray.getAsName(0)) && asArray.size() >= 2 && (asArray2 = asArray.getAsArray(1)) != null) {
            asArray.set(1, simplifyColorspace(asArray2));
        }
        this.additional.put(PdfName.COLORSPACE, asArray);
    }

    private PdfObject simplifyColorspace(PdfArray pdfArray) {
        if (pdfArray == null) {
            return pdfArray;
        }
        PdfName asName = pdfArray.getAsName(0);
        if (PdfName.CALGRAY.equals(asName)) {
            return PdfName.DEVICEGRAY;
        }
        return PdfName.CALRGB.equals(asName) ? PdfName.DEVICERGB : pdfArray;
    }

    public boolean isMask() {
        return this.mask;
    }

    public void makeMask() throws DocumentException {
        if (!isMaskCandidate()) {
            throw new DocumentException(MessageLocalization.getComposedMessage("this.image.can.not.be.an.image.mask", new Object[0]));
        }
        this.mask = true;
    }

    public boolean isMaskCandidate() {
        return (this.type == 34 && this.bpc > 255) || this.colorspace == 1;
    }

    public Image getImageMask() {
        return this.imageMask;
    }

    public void setImageMask(Image image) throws DocumentException {
        if (this.mask) {
            throw new DocumentException(MessageLocalization.getComposedMessage("an.image.mask.cannot.contain.another.image.mask", new Object[0]));
        }
        if (!image.mask) {
            throw new DocumentException(MessageLocalization.getComposedMessage("the.image.mask.is.not.a.mask.did.you.do.makemask", new Object[0]));
        }
        this.imageMask = image;
        int i = image.bpc;
        boolean z = true;
        this.smask = (i <= 1 || i > 8) ? false : false;
    }

    public boolean isSmask() {
        return this.smask;
    }

    public void setSmask(boolean z) {
        this.smask = z;
    }

    public int[] getTransparency() {
        return this.transparency;
    }

    public void setTransparency(int[] iArr) {
        this.transparency = iArr;
    }

    public int getCompressionLevel() {
        return this.compressionLevel;
    }

    public void setCompressionLevel(int i) {
        if (i < 0 || i > 9) {
            this.compressionLevel = -1;
        } else {
            this.compressionLevel = i;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.itextpdf.text.Image getInstance(java.awt.Image r18, java.awt.Color r19, boolean r20) throws com.itextpdf.text.BadElementException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 537
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.Image.getInstance(java.awt.Image, java.awt.Color, boolean):com.itextpdf.text.Image");
    }

    public static Image getInstance(java.awt.Image image, Color color) throws BadElementException, IOException {
        return getInstance(image, color, false);
    }

    public static Image getInstance(PdfWriter pdfWriter, java.awt.Image image, float f) throws BadElementException, IOException {
        return getInstance(new PdfContentByte(pdfWriter), image, f);
    }

    public static Image getInstance(PdfContentByte pdfContentByte, java.awt.Image image, float f) throws BadElementException, IOException {
        PixelGrabber pixelGrabber = new PixelGrabber(image, 0, 0, -1, -1, true);
        try {
            pixelGrabber.grabPixels();
            if ((pixelGrabber.getStatus() & 128) != 0) {
                throw new IOException(MessageLocalization.getComposedMessage("java.awt.image.fetch.aborted.or.errored", new Object[0]));
            }
            float width = pixelGrabber.getWidth();
            float height = pixelGrabber.getHeight();
            PdfTemplate createTemplate = pdfContentByte.createTemplate(width, height);
            PdfGraphics2D pdfGraphics2D = new PdfGraphics2D(createTemplate, width, height, null, false, true, f);
            pdfGraphics2D.m2720a(image);
            int width2 = image.getWidth((ImageObserver) null);
            int height2 = image.getHeight((ImageObserver) null);
            pdfGraphics2D.m2720a(image);
            double d = width2;
            double width3 = image.getWidth((ImageObserver) null);
            Double.isNaN(d);
            Double.isNaN(width3);
            double d2 = d / width3;
            double d3 = height2;
            double height3 = image.getHeight((ImageObserver) null);
            Double.isNaN(d3);
            Double.isNaN(height3);
            AffineTransform translateInstance = AffineTransform.getTranslateInstance(0.0d, 0.0d);
            translateInstance.scale(d2, d3 / height3);
            pdfGraphics2D.m2719a(image, translateInstance);
            pdfGraphics2D.m2723a();
            return getInstance(createTemplate);
        } catch (InterruptedException unused) {
            throw new IOException(MessageLocalization.getComposedMessage("java.awt.image.interrupted.waiting.for.pixels", new Object[0]));
        }
    }
}
