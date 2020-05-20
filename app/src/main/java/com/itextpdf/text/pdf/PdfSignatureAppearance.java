package com.itextpdf.text.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.security.CertificateInfo;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.conn.ssl.TokenParser;

/* loaded from: classes.dex */
public class PdfSignatureAppearance {
    public static final int CERTIFIED_FORM_FILLING = 2;
    public static final int CERTIFIED_FORM_FILLING_AND_ANNOTATIONS = 3;
    public static final int CERTIFIED_NO_CHANGES_ALLOWED = 1;
    private static final float MARGIN = 2.0f;
    public static final int NOT_CERTIFIED = 0;
    private static final float TOP_SECTION = 0.3f;
    public static final String questionMark = "% DSUnknown\nq\n1 G\n1 g\n0.1 0 0 0.1 9 0 cm\n0 J 0 j 4 M []0 d\n1 i \n0 g\n313 292 m\n313 404 325 453 432 529 c\n478 561 504 597 504 645 c\n504 736 440 760 391 760 c\n286 760 271 681 265 626 c\n265 625 l\n100 625 l\n100 828 253 898 381 898 c\n451 898 679 878 679 650 c\n679 555 628 499 538 435 c\n488 399 467 376 467 292 c\n313 292 l\nh\n308 214 170 -164 re\nf\n0.44 G\n1.2 w\n1 1 0.4 rg\n287 318 m\n287 430 299 479 406 555 c\n451 587 478 623 478 671 c\n478 762 414 786 365 786 c\n260 786 245 707 239 652 c\n239 651 l\n74 651 l\n74 854 227 924 355 924 c\n425 924 653 904 653 676 c\n653 581 602 525 512 461 c\n462 425 441 402 441 318 c\n287 318 l\nh\n282 240 170 -164 re\nB\nQ\n";
    private byte[] bout;
    private int boutLen;
    private String contact;
    private PdfDictionary cryptoDictionary;
    private HashMap<PdfName, PdfLiteral> exclusionLocations;
    private PdfTemplate frm;
    private Image image;
    private float imageScale;
    private Font layer2Font;
    private String layer2Text;
    private String layer4Text;
    private String location;
    private boolean newField;
    private OutputStream originalout;
    private Rectangle pageRect;
    private RandomAccessFile raf;
    private long[] range;
    private String reason;
    private Rectangle rect;
    private Certificate signCertificate;
    private SignatureEvent signatureEvent;
    private ByteBuffer sigout;
    private PdfStamper stamper;
    private File tempFile;
    private PdfStamperImp writer;
    private int certificationLevel = 0;
    private int page = 1;
    private RenderingMode renderingMode = RenderingMode.DESCRIPTION;
    private Image signatureGraphic = null;
    private boolean acro6Layers = true;
    private PdfTemplate[] app = new PdfTemplate[5];
    private int runDirection = 1;
    private boolean preClosed = false;
    private Calendar signDate = new GregorianCalendar();
    private String fieldName = getNewSigName();

    /* loaded from: classes.dex */
    public enum RenderingMode {
        DESCRIPTION,
        NAME_AND_DESCRIPTION,
        GRAPHIC_AND_DESCRIPTION,
        GRAPHIC
    }

    /* loaded from: classes.dex */
    public interface SignatureEvent {
        void getSignatureDictionary(PdfDictionary pdfDictionary);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfSignatureAppearance(PdfStamperImp pdfStamperImp) {
        this.writer = pdfStamperImp;
    }

    public void setCertificationLevel(int i) {
        this.certificationLevel = i;
    }

    public int getCertificationLevel() {
        return this.certificationLevel;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String str) {
        this.contact = str;
    }

    public Calendar getSignDate() {
        return this.signDate;
    }

    public void setSignDate(Calendar calendar) {
        this.signDate = calendar;
    }

    public InputStream getRangeStream() {
        return new RangeStream(this.raf, this.bout, this.range);
    }

    /* loaded from: classes.dex */
    static class RangeStream extends InputStream {

        /* renamed from: b */
        private byte[] f19802b;
        private byte[] bout;
        private RandomAccessFile raf;
        private long[] range;
        private long rangePosition;

        private RangeStream(RandomAccessFile randomAccessFile, byte[] bArr, long[] jArr) {
            this.f19802b = new byte[1];
            this.rangePosition = 0L;
            this.raf = randomAccessFile;
            this.bout = bArr;
            this.range = jArr;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (read(this.f19802b) != 1) {
                return -1;
            }
            return this.f19802b[0] & 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3;
            if (bArr == null) {
                throw new NullPointerException();
            }
            if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
                throw new IndexOutOfBoundsException();
            }
            int i4 = 0;
            if (i2 == 0) {
                return 0;
            }
            long j = this.rangePosition;
            long[] jArr = this.range;
            if (j >= jArr[jArr.length - 2] + jArr[jArr.length - 1]) {
                return -1;
            }
            while (true) {
                long[] jArr2 = this.range;
                if (i4 >= jArr2.length) {
                    return -1;
                }
                long j2 = jArr2[i4];
                long j3 = jArr2[i4 + 1] + j2;
                if (this.rangePosition < j2) {
                    this.rangePosition = j2;
                }
                long j4 = this.rangePosition;
                if (j4 >= j2 && j4 < j3) {
                    int min = Math.min(i2, (int) (j3 - j4));
                    RandomAccessFile randomAccessFile = this.raf;
                    if (randomAccessFile == null) {
                        System.arraycopy(this.bout, (int) this.rangePosition, bArr, i, min);
                    } else {
                        randomAccessFile.seek(this.rangePosition);
                        this.raf.readFully(bArr, i, min);
                    }
                    this.rangePosition += min;
                    return min;
                }
                i4 += 2;
            }
        }
    }

    public PdfDictionary getCryptoDictionary() {
        return this.cryptoDictionary;
    }

    public void setCryptoDictionary(PdfDictionary pdfDictionary) {
        this.cryptoDictionary = pdfDictionary;
    }

    public void setCertificate(Certificate certificate) {
        this.signCertificate = certificate;
    }

    public Certificate getCertificate() {
        return this.signCertificate;
    }

    public SignatureEvent getSignatureEvent() {
        return this.signatureEvent;
    }

    public void setSignatureEvent(SignatureEvent signatureEvent) {
        this.signatureEvent = signatureEvent;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public String getNewSigName() {
        AcroFields acroFields = this.writer.getAcroFields();
        boolean z = false;
        int i = 0;
        while (!z) {
            i++;
            String str = "Signature" + i;
            if (acroFields.getFieldItem(str) == null) {
                String str2 = str + ".";
                Iterator<String> it = acroFields.getFields().keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    } else if (it.next().startsWith(str2)) {
                        z = false;
                        break;
                    }
                }
            }
        }
        return "Signature" + i;
    }

    public boolean isNewField() {
        return this.newField;
    }

    public int getPage() {
        return this.page;
    }

    public Rectangle getRect() {
        return this.rect;
    }

    public Rectangle getPageRect() {
        return this.pageRect;
    }

    public boolean isInvisible() {
        Rectangle rectangle = this.rect;
        return rectangle == null || rectangle.getWidth() == ColumnText.GLOBAL_SPACE_CHAR_RATIO || this.rect.getHeight() == ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    }

    public void setVisibleSignature(Rectangle rectangle, int i, String str) {
        if (str != null) {
            if (str.indexOf(46) >= 0) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("field.names.cannot.contain.a.dot", new Object[0]));
            }
            if (this.writer.getAcroFields().getFieldItem(str) != null) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.field.1.already.exists", str));
            }
            this.fieldName = str;
        }
        if (i <= 0 || i > this.writer.reader.getNumberOfPages()) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("invalid.page.number.1", i));
        }
        this.pageRect = new Rectangle(rectangle);
        this.pageRect.normalize();
        this.rect = new Rectangle(this.pageRect.getWidth(), this.pageRect.getHeight());
        this.page = i;
        this.newField = true;
    }

    public void setVisibleSignature(String str) {
        AcroFields.Item fieldItem = this.writer.getAcroFields().getFieldItem(str);
        if (fieldItem == null) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.field.1.does.not.exist", str));
        }
        PdfDictionary merged = fieldItem.getMerged(0);
        if (!PdfName.SIG.equals(PdfReader.getPdfObject(merged.get(PdfName.f19720FT)))) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.field.1.is.not.a.signature.field", str));
        }
        this.fieldName = str;
        PdfArray asArray = merged.getAsArray(PdfName.RECT);
        this.pageRect = new Rectangle(asArray.getAsNumber(0).floatValue(), asArray.getAsNumber(1).floatValue(), asArray.getAsNumber(2).floatValue(), asArray.getAsNumber(3).floatValue());
        this.pageRect.normalize();
        this.page = fieldItem.getPage(0).intValue();
        int pageRotation = this.writer.reader.getPageRotation(this.page);
        Rectangle pageSizeWithRotation = this.writer.reader.getPageSizeWithRotation(this.page);
        if (pageRotation == 90) {
            this.pageRect = new Rectangle(this.pageRect.getBottom(), pageSizeWithRotation.getTop() - this.pageRect.getLeft(), this.pageRect.getTop(), pageSizeWithRotation.getTop() - this.pageRect.getRight());
        } else if (pageRotation == 180) {
            this.pageRect = new Rectangle(pageSizeWithRotation.getRight() - this.pageRect.getLeft(), pageSizeWithRotation.getTop() - this.pageRect.getBottom(), pageSizeWithRotation.getRight() - this.pageRect.getRight(), pageSizeWithRotation.getTop() - this.pageRect.getTop());
        } else if (pageRotation == 270) {
            this.pageRect = new Rectangle(pageSizeWithRotation.getRight() - this.pageRect.getBottom(), this.pageRect.getLeft(), pageSizeWithRotation.getRight() - this.pageRect.getTop(), this.pageRect.getRight());
        }
        if (pageRotation != 0) {
            this.pageRect.normalize();
        }
        this.rect = new Rectangle(this.pageRect.getWidth(), this.pageRect.getHeight());
    }

    public RenderingMode getRenderingMode() {
        return this.renderingMode;
    }

    public void setRenderingMode(RenderingMode renderingMode) {
        this.renderingMode = renderingMode;
    }

    public Image getSignatureGraphic() {
        return this.signatureGraphic;
    }

    public void setSignatureGraphic(Image image) {
        this.signatureGraphic = image;
    }

    public boolean isAcro6Layers() {
        return this.acro6Layers;
    }

    public void setAcro6Layers(boolean z) {
        this.acro6Layers = z;
    }

    public PdfTemplate getLayer(int i) {
        if (i >= 0) {
            PdfTemplate[] pdfTemplateArr = this.app;
            if (i >= pdfTemplateArr.length) {
                return null;
            }
            PdfTemplate pdfTemplate = pdfTemplateArr[i];
            if (pdfTemplate == null) {
                PdfTemplate pdfTemplate2 = new PdfTemplate(this.writer);
                pdfTemplateArr[i] = pdfTemplate2;
                pdfTemplate2.setBoundingBox(this.rect);
                this.writer.addDirectTemplateSimple(pdfTemplate2, new PdfName("n".concat(String.valueOf(i))));
                return pdfTemplate2;
            }
            return pdfTemplate;
        }
        return null;
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public float getImageScale() {
        return this.imageScale;
    }

    public void setImageScale(float f) {
        this.imageScale = f;
    }

    public void setLayer2Text(String str) {
        this.layer2Text = str;
    }

    public String getLayer2Text() {
        return this.layer2Text;
    }

    public Font getLayer2Font() {
        return this.layer2Font;
    }

    public void setLayer2Font(Font font) {
        this.layer2Font = font;
    }

    public void setRunDirection(int i) {
        if (i < 0 || i > 3) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.run.direction.1", i));
        }
        this.runDirection = i;
    }

    public int getRunDirection() {
        return this.runDirection;
    }

    public void setLayer4Text(String str) {
        this.layer4Text = str;
    }

    public String getLayer4Text() {
        return this.layer4Text;
    }

    public PdfTemplate getTopLayer() {
        if (this.frm == null) {
            this.frm = new PdfTemplate(this.writer);
            this.frm.setBoundingBox(this.rect);
            this.writer.addDirectTemplateSimple(this.frm, new PdfName("FRM"));
        }
        return this.frm;
    }

    public PdfTemplate getAppearance() throws DocumentException {
        Font font;
        PdfTemplate pdfTemplate;
        Font font2;
        Rectangle rectangle;
        PdfTemplate pdfTemplate2;
        Rectangle rectangle2 = null;
        if (isInvisible()) {
            PdfTemplate pdfTemplate3 = new PdfTemplate(this.writer);
            pdfTemplate3.setBoundingBox(new Rectangle(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO));
            this.writer.addDirectTemplateSimple(pdfTemplate3, null);
            return pdfTemplate3;
        }
        PdfTemplate[] pdfTemplateArr = this.app;
        if (pdfTemplateArr[0] == null) {
            PdfTemplate pdfTemplate4 = new PdfTemplate(this.writer);
            pdfTemplateArr[0] = pdfTemplate4;
            pdfTemplate4.setBoundingBox(new Rectangle(100.0f, 100.0f));
            this.writer.addDirectTemplateSimple(pdfTemplate4, new PdfName("n0"));
            pdfTemplate4.setLiteral("% DSBlank\n");
        }
        PdfTemplate[] pdfTemplateArr2 = this.app;
        if (pdfTemplateArr2[1] == null && !this.acro6Layers) {
            PdfTemplate pdfTemplate5 = new PdfTemplate(this.writer);
            pdfTemplateArr2[1] = pdfTemplate5;
            pdfTemplate5.setBoundingBox(new Rectangle(100.0f, 100.0f));
            this.writer.addDirectTemplateSimple(pdfTemplate5, new PdfName("n1"));
            pdfTemplate5.setLiteral(questionMark);
        }
        if (this.app[2] == null) {
            String str = this.layer2Text;
            if (str == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Digitally signed by ");
                String field = CertificateInfo.getSubjectFields((X509Certificate) this.signCertificate).getField("CN");
                if (field == null) {
                    field = CertificateInfo.getSubjectFields((X509Certificate) this.signCertificate).getField("E");
                }
                if (field == null) {
                    field = "";
                }
                sb.append(field);
                sb.append('\n');
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss z");
                sb.append("Date: ");
                sb.append(simpleDateFormat.format(this.signDate.getTime()));
                if (this.reason != null) {
                    sb.append('\n');
                    sb.append("Reason: ");
                    sb.append(this.reason);
                }
                if (this.location != null) {
                    sb.append('\n');
                    sb.append("Location: ");
                    sb.append(this.location);
                }
                str = sb.toString();
            }
            PdfTemplate[] pdfTemplateArr3 = this.app;
            PdfTemplate pdfTemplate6 = new PdfTemplate(this.writer);
            pdfTemplateArr3[2] = pdfTemplate6;
            pdfTemplate6.setBoundingBox(this.rect);
            this.writer.addDirectTemplateSimple(pdfTemplate6, new PdfName("n2"));
            Image image = this.image;
            if (image != null) {
                float f = this.imageScale;
                if (f == ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                    pdfTemplate = pdfTemplate6;
                    pdfTemplate6.addImage(image, this.rect.getWidth(), ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, this.rect.getHeight(), ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                } else {
                    pdfTemplate = pdfTemplate6;
                    if (f < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                        f = Math.min(this.rect.getWidth() / this.image.getWidth(), this.rect.getHeight() / this.image.getHeight());
                    }
                    float width = this.image.getWidth() * f;
                    float height = this.image.getHeight() * f;
                    pdfTemplate.addImage(this.image, width, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, height, (this.rect.getWidth() - width) / 2.0f, (this.rect.getHeight() - height) / 2.0f);
                }
            } else {
                pdfTemplate = pdfTemplate6;
            }
            Font font3 = this.layer2Font;
            if (font3 == null) {
                font2 = new Font();
            } else {
                font2 = new Font(font3);
            }
            float size = font2.getSize();
            if (this.renderingMode == RenderingMode.NAME_AND_DESCRIPTION || (this.renderingMode == RenderingMode.GRAPHIC_AND_DESCRIPTION && this.signatureGraphic != null)) {
                Rectangle rectangle3 = new Rectangle(2.0f, 2.0f, (this.rect.getWidth() / 2.0f) - 2.0f, this.rect.getHeight() - 2.0f);
                Rectangle rectangle4 = new Rectangle((this.rect.getWidth() / 2.0f) + 1.0f, 2.0f, this.rect.getWidth() - 1.0f, this.rect.getHeight() - 2.0f);
                if (this.rect.getHeight() > this.rect.getWidth()) {
                    rectangle2 = new Rectangle(2.0f, this.rect.getHeight() / 2.0f, this.rect.getWidth() - 2.0f, this.rect.getHeight());
                    rectangle = new Rectangle(2.0f, 2.0f, this.rect.getWidth() - 2.0f, (this.rect.getHeight() / 2.0f) - 2.0f);
                } else {
                    rectangle2 = rectangle3;
                    rectangle = rectangle4;
                }
            } else if (this.renderingMode == RenderingMode.GRAPHIC) {
                if (this.signatureGraphic == null) {
                    throw new IllegalStateException(MessageLocalization.getComposedMessage("a.signature.image.should.be.present.when.rendering.mode.is.graphic.only", new Object[0]));
                }
                rectangle = null;
                rectangle2 = new Rectangle(2.0f, 2.0f, this.rect.getWidth() - 2.0f, this.rect.getHeight() - 2.0f);
            } else {
                rectangle = new Rectangle(2.0f, 2.0f, this.rect.getWidth() - 2.0f, (this.rect.getHeight() * 0.7f) - 2.0f);
            }
            switch (this.renderingMode) {
                case NAME_AND_DESCRIPTION:
                    pdfTemplate2 = pdfTemplate;
                    String field2 = CertificateInfo.getSubjectFields((X509Certificate) this.signCertificate).getField("CN");
                    if (field2 == null) {
                        field2 = CertificateInfo.getSubjectFields((X509Certificate) this.signCertificate).getField("E");
                    }
                    if (field2 == null) {
                        field2 = "";
                    }
                    float fitText = ColumnText.fitText(font2, field2, new Rectangle(rectangle2.getWidth() - 2.0f, rectangle2.getHeight() - 2.0f), -1.0f, this.runDirection);
                    ColumnText columnText = new ColumnText(pdfTemplate2);
                    columnText.setRunDirection(this.runDirection);
                    columnText.setSimpleColumn(new Phrase(field2, font2), rectangle2.getLeft(), rectangle2.getBottom(), rectangle2.getRight(), rectangle2.getTop(), fitText, 0);
                    columnText.m2716go();
                    break;
                case GRAPHIC_AND_DESCRIPTION:
                    pdfTemplate2 = pdfTemplate;
                    if (this.signatureGraphic == null) {
                        throw new IllegalStateException(MessageLocalization.getComposedMessage("a.signature.image.should.be.present.when.rendering.mode.is.graphic.and.description", new Object[0]));
                    }
                    ColumnText columnText2 = new ColumnText(pdfTemplate2);
                    columnText2.setRunDirection(this.runDirection);
                    columnText2.setSimpleColumn(rectangle2.getLeft(), rectangle2.getBottom(), rectangle2.getRight(), rectangle2.getTop(), ColumnText.GLOBAL_SPACE_CHAR_RATIO, 2);
                    Image image2 = Image.getInstance(this.signatureGraphic);
                    image2.scaleToFit(rectangle2.getWidth(), rectangle2.getHeight());
                    Paragraph paragraph = new Paragraph();
                    paragraph.add((Element) new Chunk(image2, ((rectangle2.getWidth() - image2.getScaledWidth()) / 2.0f) + ColumnText.GLOBAL_SPACE_CHAR_RATIO + ((rectangle2.getWidth() - image2.getScaledWidth()) / 2.0f), ((-image2.getScaledHeight()) + 15.0f) - ((rectangle2.getHeight() - image2.getScaledHeight()) / 2.0f), false));
                    columnText2.addElement(paragraph);
                    columnText2.m2716go();
                    break;
                case GRAPHIC:
                    pdfTemplate2 = pdfTemplate;
                    ColumnText columnText3 = new ColumnText(pdfTemplate2);
                    columnText3.setRunDirection(this.runDirection);
                    columnText3.setSimpleColumn(rectangle2.getLeft(), rectangle2.getBottom(), rectangle2.getRight(), rectangle2.getTop(), ColumnText.GLOBAL_SPACE_CHAR_RATIO, 2);
                    Image image3 = Image.getInstance(this.signatureGraphic);
                    image3.scaleToFit(rectangle2.getWidth(), rectangle2.getHeight());
                    Paragraph paragraph2 = new Paragraph(rectangle2.getHeight());
                    paragraph2.add((Element) new Chunk(image3, (rectangle2.getWidth() - image3.getScaledWidth()) / 2.0f, (rectangle2.getHeight() - image3.getScaledHeight()) / 2.0f, false));
                    columnText3.addElement(paragraph2);
                    columnText3.m2716go();
                    break;
                default:
                    pdfTemplate2 = pdfTemplate;
                    break;
            }
            if (this.renderingMode != RenderingMode.GRAPHIC) {
                float fitText2 = size <= ColumnText.GLOBAL_SPACE_CHAR_RATIO ? ColumnText.fitText(font2, str, new Rectangle(rectangle.getWidth(), rectangle.getHeight()), 12.0f, this.runDirection) : size;
                ColumnText columnText4 = new ColumnText(pdfTemplate2);
                columnText4.setRunDirection(this.runDirection);
                columnText4.setSimpleColumn(new Phrase(str, font2), rectangle.getLeft(), rectangle.getBottom(), rectangle.getRight(), rectangle.getTop(), fitText2, 0);
                columnText4.m2716go();
            }
        }
        PdfTemplate[] pdfTemplateArr4 = this.app;
        if (pdfTemplateArr4[3] == null && !this.acro6Layers) {
            PdfTemplate pdfTemplate7 = new PdfTemplate(this.writer);
            pdfTemplateArr4[3] = pdfTemplate7;
            pdfTemplate7.setBoundingBox(new Rectangle(100.0f, 100.0f));
            this.writer.addDirectTemplateSimple(pdfTemplate7, new PdfName("n3"));
            pdfTemplate7.setLiteral("% DSBlank\n");
        }
        PdfTemplate[] pdfTemplateArr5 = this.app;
        if (pdfTemplateArr5[4] == null && !this.acro6Layers) {
            PdfTemplate pdfTemplate8 = new PdfTemplate(this.writer);
            pdfTemplateArr5[4] = pdfTemplate8;
            pdfTemplate8.setBoundingBox(new Rectangle(ColumnText.GLOBAL_SPACE_CHAR_RATIO, this.rect.getHeight() * 0.7f, this.rect.getRight(), this.rect.getTop()));
            this.writer.addDirectTemplateSimple(pdfTemplate8, new PdfName("n4"));
            Font font4 = this.layer2Font;
            if (font4 == null) {
                font = new Font();
            } else {
                font = new Font(font4);
            }
            String str2 = this.layer4Text;
            String str3 = str2 != null ? str2 : "Signature Not Verified";
            float fitText3 = ColumnText.fitText(font, str3, new Rectangle(this.rect.getWidth() - 4.0f, (this.rect.getHeight() * TOP_SECTION) - 4.0f), 15.0f, this.runDirection);
            ColumnText columnText5 = new ColumnText(pdfTemplate8);
            columnText5.setRunDirection(this.runDirection);
            columnText5.setSimpleColumn(new Phrase(str3, font), 2.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, this.rect.getWidth() - 2.0f, this.rect.getHeight() - 2.0f, fitText3, 0);
            columnText5.m2716go();
        }
        int pageRotation = this.writer.reader.getPageRotation(this.page);
        Rectangle rectangle5 = new Rectangle(this.rect);
        for (int i = pageRotation; i > 0; i -= 90) {
            rectangle5 = rectangle5.rotate();
        }
        if (this.frm == null) {
            this.frm = new PdfTemplate(this.writer);
            this.frm.setBoundingBox(rectangle5);
            this.writer.addDirectTemplateSimple(this.frm, new PdfName("FRM"));
            float min = Math.min(this.rect.getWidth(), this.rect.getHeight()) * 0.9f;
            float width2 = (this.rect.getWidth() - min) / 2.0f;
            float height2 = (this.rect.getHeight() - min) / 2.0f;
            float f2 = min / 100.0f;
            if (pageRotation == 90) {
                this.frm.concatCTM(ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f, -1.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, this.rect.getHeight(), ColumnText.GLOBAL_SPACE_CHAR_RATIO);
            } else if (pageRotation == 180) {
                this.frm.concatCTM(-1.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, -1.0f, this.rect.getWidth(), this.rect.getHeight());
            } else if (pageRotation == 270) {
                this.frm.concatCTM(ColumnText.GLOBAL_SPACE_CHAR_RATIO, -1.0f, 1.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, this.rect.getWidth());
            }
            this.frm.addTemplate(this.app[0], ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
            if (!this.acro6Layers) {
                this.frm.addTemplate(this.app[1], f2, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, f2, width2, height2);
            }
            this.frm.addTemplate(this.app[2], ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
            if (!this.acro6Layers) {
                this.frm.addTemplate(this.app[3], f2, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, f2, width2, height2);
                this.frm.addTemplate(this.app[4], ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
            }
        }
        PdfTemplate pdfTemplate9 = new PdfTemplate(this.writer);
        pdfTemplate9.setBoundingBox(rectangle5);
        this.writer.addDirectTemplateSimple(pdfTemplate9, null);
        pdfTemplate9.addTemplate(this.frm, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        return pdfTemplate9;
    }

    public PdfStamper getStamper() {
        return this.stamper;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStamper(PdfStamper pdfStamper) {
        this.stamper = pdfStamper;
    }

    ByteBuffer getSigout() {
        return this.sigout;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSigout(ByteBuffer byteBuffer) {
        this.sigout = byteBuffer;
    }

    OutputStream getOriginalout() {
        return this.originalout;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOriginalout(OutputStream outputStream) {
        this.originalout = outputStream;
    }

    public File getTempFile() {
        return this.tempFile;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTempFile(File file) {
        this.tempFile = file;
    }

    public boolean isPreClosed() {
        return this.preClosed;
    }

    public void preClose(HashMap<PdfName, Integer> hashMap) throws IOException, DocumentException {
        if (this.preClosed) {
            throw new DocumentException(MessageLocalization.getComposedMessage("document.already.pre.closed", new Object[0]));
        }
        this.stamper.mergeVerification();
        this.preClosed = true;
        AcroFields acroFields = this.writer.getAcroFields();
        String fieldName = getFieldName();
        boolean z = (isInvisible() || isNewField()) ? false : true;
        PdfIndirectReference pdfIndirectReference = this.writer.getPdfIndirectReference();
        int i = 3;
        this.writer.setSigFlags(3);
        PdfDictionary pdfDictionary = null;
        if (z) {
            PdfDictionary widget = acroFields.getFieldItem(fieldName).getWidget(0);
            this.writer.markUsed(widget);
            PdfDictionary asDict = widget.getAsDict(PdfName.LOCK);
            if (asDict == null || asDict.contains(PdfName.FIELDS)) {
                pdfDictionary = asDict;
            }
            widget.put(PdfName.f19752P, this.writer.getPageReference(getPage()));
            widget.put(PdfName.f19787V, pdfIndirectReference);
            PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(widget.get(PdfName.f19712F));
            widget.put(PdfName.f19712F, new PdfNumber(((pdfObjectRelease == null || !pdfObjectRelease.isNumber()) ? 0 : ((PdfNumber) pdfObjectRelease).intValue()) | 128));
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            pdfDictionary2.put(PdfName.f19739N, getAppearance().getIndirectReference());
            widget.put(PdfName.f19682AP, pdfDictionary2);
        } else {
            PdfFormField createSignature = PdfFormField.createSignature(this.writer);
            createSignature.setFieldName(fieldName);
            createSignature.put(PdfName.f19787V, pdfIndirectReference);
            createSignature.setFlags(132);
            int page = getPage();
            if (!isInvisible()) {
                createSignature.setWidget(getPageRect(), null);
            } else {
                createSignature.setWidget(new Rectangle(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO), null);
            }
            createSignature.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, getAppearance());
            createSignature.setPage(page);
            this.writer.addAnnotation(createSignature, page);
        }
        this.exclusionLocations = new HashMap<>();
        if (this.cryptoDictionary == null) {
            throw new DocumentException("No crypto dictionary defined.");
        }
        PdfLiteral pdfLiteral = new PdfLiteral(80);
        this.exclusionLocations.put(PdfName.BYTERANGE, pdfLiteral);
        this.cryptoDictionary.put(PdfName.BYTERANGE, pdfLiteral);
        for (Map.Entry<PdfName, Integer> entry : hashMap.entrySet()) {
            PdfName key = entry.getKey();
            PdfLiteral pdfLiteral2 = new PdfLiteral(entry.getValue().intValue());
            this.exclusionLocations.put(key, pdfLiteral2);
            this.cryptoDictionary.put(key, pdfLiteral2);
        }
        if (this.certificationLevel > 0) {
            addDocMDP(this.cryptoDictionary);
        }
        if (pdfDictionary != null) {
            addFieldMDP(this.cryptoDictionary, pdfDictionary);
        }
        SignatureEvent signatureEvent = this.signatureEvent;
        if (signatureEvent != null) {
            signatureEvent.getSignatureDictionary(this.cryptoDictionary);
        }
        this.writer.addToBody((PdfObject) this.cryptoDictionary, pdfIndirectReference, false);
        if (this.certificationLevel > 0) {
            PdfDictionary pdfDictionary3 = new PdfDictionary();
            pdfDictionary3.put(new PdfName("DocMDP"), pdfIndirectReference);
            this.writer.reader.getCatalog().put(new PdfName("Perms"), pdfDictionary3);
        }
        this.writer.close(this.stamper.getMoreInfo());
        this.range = new long[this.exclusionLocations.size() * 2];
        long position = this.exclusionLocations.get(PdfName.BYTERANGE).getPosition();
        this.exclusionLocations.remove(PdfName.BYTERANGE);
        int i2 = 1;
        for (PdfLiteral pdfLiteral3 : this.exclusionLocations.values()) {
            long position2 = pdfLiteral3.getPosition();
            long[] jArr = this.range;
            int i3 = i2 + 1;
            jArr[i2] = position2;
            i2 = i3 + 1;
            jArr[i3] = pdfLiteral3.getPosLength() + position2;
        }
        long[] jArr2 = this.range;
        Arrays.sort(jArr2, 1, jArr2.length - 1);
        while (true) {
            long[] jArr3 = this.range;
            if (i >= jArr3.length - 2) {
                break;
            }
            jArr3[i] = jArr3[i] - jArr3[i - 1];
            i += 2;
        }
        File file = this.tempFile;
        if (file == null) {
            this.bout = this.sigout.getBuffer();
            this.boutLen = this.sigout.size();
            long[] jArr4 = this.range;
            jArr4[jArr4.length - 1] = this.boutLen - jArr4[jArr4.length - 2];
            ByteBuffer byteBuffer = new ByteBuffer();
            byteBuffer.append('[');
            int i4 = 0;
            while (true) {
                long[] jArr5 = this.range;
                if (i4 < jArr5.length) {
                    byteBuffer.append(jArr5[i4]).append(TokenParser.f24154SP);
                    i4++;
                } else {
                    byteBuffer.append(']');
                    System.arraycopy(byteBuffer.getBuffer(), 0, this.bout, (int) position, byteBuffer.size());
                    return;
                }
            }
        } else {
            try {
                this.raf = new RandomAccessFile(file, "rw");
                this.range[this.range.length - 1] = this.raf.length() - this.range[this.range.length - 2];
                ByteBuffer byteBuffer2 = new ByteBuffer();
                byteBuffer2.append('[');
                for (int i5 = 0; i5 < this.range.length; i5++) {
                    byteBuffer2.append(this.range[i5]).append(TokenParser.f24154SP);
                }
                byteBuffer2.append(']');
                this.raf.seek(position);
                this.raf.write(byteBuffer2.getBuffer(), 0, byteBuffer2.size());
            } catch (IOException e) {
                try {
                    this.raf.close();
                } catch (Exception unused) {
                }
                try {
                    this.tempFile.delete();
                } catch (Exception unused2) {
                }
                throw e;
            }
        }
    }

    private void addDocMDP(PdfDictionary pdfDictionary) {
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        PdfDictionary pdfDictionary3 = new PdfDictionary();
        pdfDictionary3.put(PdfName.f19752P, new PdfNumber(this.certificationLevel));
        pdfDictionary3.put(PdfName.f19787V, new PdfName("1.2"));
        pdfDictionary3.put(PdfName.TYPE, PdfName.TRANSFORMPARAMS);
        pdfDictionary2.put(PdfName.TRANSFORMMETHOD, PdfName.DOCMDP);
        pdfDictionary2.put(PdfName.TYPE, PdfName.SIGREF);
        pdfDictionary2.put(PdfName.TRANSFORMPARAMS, pdfDictionary3);
        pdfDictionary2.put(new PdfName("DigestValue"), new PdfString("aa"));
        PdfArray pdfArray = new PdfArray();
        pdfArray.add(new PdfNumber(0));
        pdfArray.add(new PdfNumber(0));
        pdfDictionary2.put(new PdfName("DigestLocation"), pdfArray);
        pdfDictionary2.put(new PdfName("DigestMethod"), new PdfName("MD5"));
        pdfDictionary2.put(PdfName.DATA, this.writer.reader.getTrailer().get(PdfName.ROOT));
        PdfArray pdfArray2 = new PdfArray();
        pdfArray2.add(pdfDictionary2);
        pdfDictionary.put(PdfName.REFERENCE, pdfArray2);
    }

    private void addFieldMDP(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2) {
        PdfDictionary pdfDictionary3 = new PdfDictionary();
        PdfDictionary pdfDictionary4 = new PdfDictionary();
        pdfDictionary4.putAll(pdfDictionary2);
        pdfDictionary4.put(PdfName.TYPE, PdfName.TRANSFORMPARAMS);
        pdfDictionary4.put(PdfName.f19787V, new PdfName("1.2"));
        pdfDictionary3.put(PdfName.TRANSFORMMETHOD, PdfName.FIELDMDP);
        pdfDictionary3.put(PdfName.TYPE, PdfName.SIGREF);
        pdfDictionary3.put(PdfName.TRANSFORMPARAMS, pdfDictionary4);
        pdfDictionary3.put(new PdfName("DigestValue"), new PdfString("aa"));
        PdfArray pdfArray = new PdfArray();
        pdfArray.add(new PdfNumber(0));
        pdfArray.add(new PdfNumber(0));
        pdfDictionary3.put(new PdfName("DigestLocation"), pdfArray);
        pdfDictionary3.put(new PdfName("DigestMethod"), new PdfName("MD5"));
        pdfDictionary3.put(PdfName.DATA, this.writer.reader.getTrailer().get(PdfName.ROOT));
        PdfArray pdfArray2 = new PdfArray();
        pdfArray2.add(pdfDictionary3);
        pdfDictionary.put(PdfName.REFERENCE, pdfArray2);
    }

    public void close(PdfDictionary pdfDictionary) throws IOException, DocumentException {
        OutputStream outputStream;
        try {
            if (!this.preClosed) {
                throw new DocumentException(MessageLocalization.getComposedMessage("preclose.must.be.called.first", new Object[0]));
            }
            ByteBuffer byteBuffer = new ByteBuffer();
            for (PdfName pdfName : pdfDictionary.getKeys()) {
                PdfObject pdfObject = pdfDictionary.get(pdfName);
                PdfLiteral pdfLiteral = this.exclusionLocations.get(pdfName);
                if (pdfLiteral == null) {
                    throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.key.1.didn.t.reserve.space.in.preclose", pdfName.toString()));
                }
                byteBuffer.reset();
                pdfObject.toPdf(null, byteBuffer);
                if (byteBuffer.size() > pdfLiteral.getPosLength()) {
                    throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.key.1.is.too.big.is.2.reserved.3", pdfName.toString(), String.valueOf(byteBuffer.size()), String.valueOf(pdfLiteral.getPosLength())));
                }
                if (this.tempFile == null) {
                    System.arraycopy(byteBuffer.getBuffer(), 0, this.bout, (int) pdfLiteral.getPosition(), byteBuffer.size());
                } else {
                    this.raf.seek(pdfLiteral.getPosition());
                    this.raf.write(byteBuffer.getBuffer(), 0, byteBuffer.size());
                }
            }
            if (pdfDictionary.size() != this.exclusionLocations.size()) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.update.dictionary.has.less.keys.than.required", new Object[0]));
            }
            if (this.tempFile == null) {
                this.originalout.write(this.bout, 0, this.boutLen);
            } else if (this.originalout != null) {
                this.raf.seek(0L);
                long length = this.raf.length();
                byte[] bArr = new byte[8192];
                while (length > 0) {
                    int read = this.raf.read(bArr, 0, (int) Math.min(8192L, length));
                    if (read < 0) {
                        throw new EOFException(MessageLocalization.getComposedMessage("unexpected.eof", new Object[0]));
                    }
                    this.originalout.write(bArr, 0, read);
                    length -= read;
                }
            }
            if (outputStream != null) {
                try {
                    this.originalout.close();
                } catch (Exception unused) {
                }
            }
        } finally {
            if (this.tempFile != null) {
                try {
                    this.raf.close();
                } catch (Exception unused2) {
                }
                if (this.originalout != null) {
                    try {
                        this.tempFile.delete();
                    } catch (Exception unused3) {
                    }
                }
            }
            outputStream = this.originalout;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception unused4) {
                }
            }
        }
    }
}
