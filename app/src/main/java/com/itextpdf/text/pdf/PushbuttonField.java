package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;

/* loaded from: classes.dex */
public class PushbuttonField extends BaseField {
    public static final int LAYOUT_ICON_LEFT_LABEL_RIGHT = 5;
    public static final int LAYOUT_ICON_ONLY = 2;
    public static final int LAYOUT_ICON_TOP_LABEL_BOTTOM = 3;
    public static final int LAYOUT_LABEL_LEFT_ICON_RIGHT = 6;
    public static final int LAYOUT_LABEL_ONLY = 1;
    public static final int LAYOUT_LABEL_OVER_ICON = 7;
    public static final int LAYOUT_LABEL_TOP_ICON_BOTTOM = 4;
    public static final int SCALE_ICON_ALWAYS = 1;
    public static final int SCALE_ICON_IS_TOO_BIG = 3;
    public static final int SCALE_ICON_IS_TOO_SMALL = 4;
    public static final int SCALE_ICON_NEVER = 2;
    private boolean iconFitToBounds;
    private float iconHorizontalAdjustment;
    private PRIndirectReference iconReference;
    private float iconVerticalAdjustment;
    private Image image;
    private int layout;
    private boolean proportionalIcon;
    private int scaleIcon;
    private PdfTemplate template;

    /* renamed from: tp */
    private PdfTemplate f19806tp;

    public PushbuttonField(PdfWriter pdfWriter, Rectangle rectangle, String str) {
        super(pdfWriter, rectangle, str);
        this.layout = 1;
        this.scaleIcon = 1;
        this.proportionalIcon = true;
        this.iconVerticalAdjustment = 0.5f;
        this.iconHorizontalAdjustment = 0.5f;
    }

    public int getLayout() {
        return this.layout;
    }

    public void setLayout(int i) {
        if (i <= 0 || i > 7) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("layout.out.of.bounds", new Object[0]));
        }
        this.layout = i;
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        this.image = image;
        this.template = null;
    }

    public PdfTemplate getTemplate() {
        return this.template;
    }

    public void setTemplate(PdfTemplate pdfTemplate) {
        this.template = pdfTemplate;
        this.image = null;
    }

    public int getScaleIcon() {
        return this.scaleIcon;
    }

    public void setScaleIcon(int i) {
        this.scaleIcon = (i <= 0 || i > 4) ? 1 : 1;
    }

    public boolean isProportionalIcon() {
        return this.proportionalIcon;
    }

    public void setProportionalIcon(boolean z) {
        this.proportionalIcon = z;
    }

    public float getIconVerticalAdjustment() {
        return this.iconVerticalAdjustment;
    }

    public void setIconVerticalAdjustment(float f) {
        if (f < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        this.iconVerticalAdjustment = f;
    }

    public float getIconHorizontalAdjustment() {
        return this.iconHorizontalAdjustment;
    }

    public void setIconHorizontalAdjustment(float f) {
        if (f < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        this.iconHorizontalAdjustment = f;
    }

    private float calculateFontSize(float f, float f2) throws IOException, DocumentException {
        BaseFont realFont = getRealFont();
        float f3 = this.fontSize;
        if (f3 == ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            float widthPoint = realFont.getWidthPoint(this.text, 1.0f);
            float min = Math.min(widthPoint == ColumnText.GLOBAL_SPACE_CHAR_RATIO ? 12.0f : f / widthPoint, f2 / (1.0f - realFont.getFontDescriptor(3, 1.0f)));
            if (min < 4.0f) {
                return 4.0f;
            }
            return min;
        }
        return f3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:129:0x025e, code lost:
        r1 = Float.NaN;
        r3 = com.itextpdf.text.pdf.ColumnText.GLOBAL_SPACE_CHAR_RATIO;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0262, code lost:
        if (r6 == 7) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0265, code lost:
        if (r6 != 2) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0268, code lost:
        r14 = r1;
        r1 = r3;
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x026c, code lost:
        r14 = r1;
        r1 = r3;
        r3 = new com.itextpdf.text.Rectangle(r11.getLeft() + r4, r11.getBottom() + r4, r11.getRight() - r4, r11.getTop() - r4);
     */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x048c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.itextpdf.text.pdf.PdfAppearance getAppearance() throws java.io.IOException, com.itextpdf.text.DocumentException {
        /*
            Method dump skipped, instructions count: 1264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PushbuttonField.getAppearance():com.itextpdf.text.pdf.PdfAppearance");
    }

    public PdfFormField getField() throws IOException, DocumentException {
        PdfName pdfName;
        PdfFormField createPushButton = PdfFormField.createPushButton(this.writer);
        createPushButton.setWidget(this.box, PdfAnnotation.HIGHLIGHT_INVERT);
        if (this.fieldName != null) {
            createPushButton.setFieldName(this.fieldName);
            if ((this.options & 1) != 0) {
                createPushButton.setFieldFlags(1);
            }
            if ((this.options & 2) != 0) {
                createPushButton.setFieldFlags(2);
            }
        }
        if (this.text != null) {
            createPushButton.setMKNormalCaption(this.text);
        }
        if (this.rotation != 0) {
            createPushButton.setMKRotation(this.rotation);
        }
        createPushButton.setBorderStyle(new PdfBorderDictionary(this.borderWidth, this.borderStyle, new PdfDashPattern(3.0f)));
        PdfAppearance appearance = getAppearance();
        createPushButton.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, appearance);
        PdfAppearance pdfAppearance = (PdfAppearance) appearance.getDuplicate();
        pdfAppearance.setFontAndSize(getRealFont(), this.fontSize);
        if (this.textColor == null) {
            pdfAppearance.setGrayFill(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        } else {
            pdfAppearance.setColorFill(this.textColor);
        }
        createPushButton.setDefaultAppearanceString(pdfAppearance);
        if (this.borderColor != null) {
            createPushButton.setMKBorderColor(this.borderColor);
        }
        if (this.backgroundColor != null) {
            createPushButton.setMKBackgroundColor(this.backgroundColor);
        }
        switch (this.visibility) {
            case 1:
                createPushButton.setFlags(6);
                break;
            case 2:
                break;
            case 3:
                createPushButton.setFlags(36);
                break;
            default:
                createPushButton.setFlags(4);
                break;
        }
        PdfTemplate pdfTemplate = this.f19806tp;
        if (pdfTemplate != null) {
            createPushButton.setMKNormalIcon(pdfTemplate);
        }
        createPushButton.setMKTextPosition(this.layout - 1);
        PdfName pdfName2 = PdfName.f19679A;
        int i = this.scaleIcon;
        if (i == 3) {
            pdfName = PdfName.f19684B;
        } else if (i == 4) {
            pdfName = PdfName.f19767S;
        } else {
            pdfName = i == 2 ? PdfName.f19739N : pdfName2;
        }
        createPushButton.setMKIconFit(pdfName, this.proportionalIcon ? PdfName.f19752P : PdfName.f19679A, this.iconHorizontalAdjustment, this.iconVerticalAdjustment, this.iconFitToBounds);
        return createPushButton;
    }

    public boolean isIconFitToBounds() {
        return this.iconFitToBounds;
    }

    public void setIconFitToBounds(boolean z) {
        this.iconFitToBounds = z;
    }

    public PRIndirectReference getIconReference() {
        return this.iconReference;
    }

    public void setIconReference(PRIndirectReference pRIndirectReference) {
        this.iconReference = pRIndirectReference;
    }
}
