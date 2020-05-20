package com.itextpdf.text.pdf;

import com.cnlaunch.physics.PAD3DHCPForDoIP;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.HtmlTags;
import java.io.IOException;

/* loaded from: classes.dex */
public class RadioCheckField extends BaseField {
    public static final int TYPE_CHECK = 1;
    public static final int TYPE_CIRCLE = 2;
    public static final int TYPE_CROSS = 3;
    public static final int TYPE_DIAMOND = 4;
    public static final int TYPE_SQUARE = 5;
    public static final int TYPE_STAR = 6;
    private static String[] typeChars = {"4", PAD3DHCPForDoIP.f10141a, "8", HtmlTags.f19637U, "n", "H"};
    private int checkType;
    private boolean checked;
    private String onValue;

    public RadioCheckField(PdfWriter pdfWriter, Rectangle rectangle, String str, String str2) {
        super(pdfWriter, rectangle, str);
        setOnValue(str2);
        setCheckType(2);
    }

    public int getCheckType() {
        return this.checkType;
    }

    public void setCheckType(int i) {
        i = (i <= 0 || i > 6) ? 2 : 2;
        this.checkType = i;
        setText(typeChars[i - 1]);
        try {
            setFont(BaseFont.createFont("ZapfDingbats", "Cp1252", false));
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public String getOnValue() {
        return this.onValue;
    }

    public void setOnValue(String str) {
        this.onValue = str;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setChecked(boolean z) {
        this.checked = z;
    }

    public PdfAppearance getAppearance(boolean z, boolean z2) throws IOException, DocumentException {
        if (z && this.checkType == 2) {
            return getAppearanceRadioCircle(z2);
        }
        PdfAppearance borderAppearance = getBorderAppearance();
        if (z2) {
            BaseFont realFont = getRealFont();
            boolean z3 = this.borderStyle == 2 || this.borderStyle == 3;
            float height = this.box.getHeight() - (this.borderWidth * 2.0f);
            float f = this.borderWidth;
            if (z3) {
                height -= this.borderWidth * 2.0f;
                f *= 2.0f;
            }
            float min = Math.min(f, Math.max(z3 ? this.borderWidth * 2.0f : this.borderWidth, 1.0f));
            float f2 = min * 2.0f;
            float width = this.box.getWidth() - f2;
            float height2 = this.box.getHeight() - f2;
            float f3 = this.fontSize;
            if (f3 == ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                float widthPoint = realFont.getWidthPoint(this.text, 1.0f);
                f3 = Math.min(widthPoint == ColumnText.GLOBAL_SPACE_CHAR_RATIO ? 12.0f : width / widthPoint, height / realFont.getFontDescriptor(1, 1.0f));
            }
            borderAppearance.saveState();
            borderAppearance.rectangle(min, min, width, height2);
            borderAppearance.clip();
            borderAppearance.newPath();
            if (this.textColor == null) {
                borderAppearance.resetGrayFill();
            } else {
                borderAppearance.setColorFill(this.textColor);
            }
            borderAppearance.beginText();
            borderAppearance.setFontAndSize(realFont, f3);
            borderAppearance.setTextMatrix((this.box.getWidth() - realFont.getWidthPoint(this.text, f3)) / 2.0f, (this.box.getHeight() - realFont.getAscentPoint(this.text, f3)) / 2.0f);
            borderAppearance.showText(this.text);
            borderAppearance.endText();
            borderAppearance.restoreState();
            return borderAppearance;
        }
        return borderAppearance;
    }

    public PdfAppearance getAppearanceRadioCircle(boolean z) {
        PdfAppearance createAppearance = PdfAppearance.createAppearance(this.writer, this.box.getWidth(), this.box.getHeight());
        int i = this.rotation;
        if (i == 90) {
            createAppearance.setMatrix(ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f, -1.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, this.box.getHeight(), ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        } else if (i == 180) {
            createAppearance.setMatrix(-1.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, -1.0f, this.box.getWidth(), this.box.getHeight());
        } else if (i == 270) {
            createAppearance.setMatrix(ColumnText.GLOBAL_SPACE_CHAR_RATIO, -1.0f, 1.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, this.box.getWidth());
        }
        Rectangle rectangle = new Rectangle(createAppearance.getBoundingBox());
        float width = rectangle.getWidth() / 2.0f;
        float height = rectangle.getHeight() / 2.0f;
        float min = (Math.min(rectangle.getWidth(), rectangle.getHeight()) - this.borderWidth) / 2.0f;
        if (min <= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            return createAppearance;
        }
        if (this.backgroundColor != null) {
            createAppearance.setColorFill(this.backgroundColor);
            createAppearance.circle(width, height, (this.borderWidth / 2.0f) + min);
            createAppearance.fill();
        }
        if (this.borderWidth > ColumnText.GLOBAL_SPACE_CHAR_RATIO && this.borderColor != null) {
            createAppearance.setLineWidth(this.borderWidth);
            createAppearance.setColorStroke(this.borderColor);
            createAppearance.circle(width, height, min);
            createAppearance.stroke();
        }
        if (z) {
            if (this.textColor == null) {
                createAppearance.resetGrayFill();
            } else {
                createAppearance.setColorFill(this.textColor);
            }
            createAppearance.circle(width, height, min / 2.0f);
            createAppearance.fill();
        }
        return createAppearance;
    }

    public PdfFormField getRadioGroup(boolean z, boolean z2) {
        PdfFormField createRadioButton = PdfFormField.createRadioButton(this.writer, z);
        if (z2) {
            createRadioButton.setFieldFlags(33554432);
        }
        createRadioButton.setFieldName(this.fieldName);
        if ((this.options & 1) != 0) {
            createRadioButton.setFieldFlags(1);
        }
        if ((this.options & 2) != 0) {
            createRadioButton.setFieldFlags(2);
        }
        createRadioButton.setValueAsName(this.checked ? this.onValue : "Off");
        return createRadioButton;
    }

    public PdfFormField getRadioField() throws IOException, DocumentException {
        return getField(true);
    }

    public PdfFormField getCheckField() throws IOException, DocumentException {
        return getField(false);
    }

    protected PdfFormField getField(boolean z) throws IOException, DocumentException {
        PdfFormField createCheckBox;
        if (z) {
            createCheckBox = PdfFormField.createEmpty(this.writer);
        } else {
            createCheckBox = PdfFormField.createCheckBox(this.writer);
        }
        createCheckBox.setWidget(this.box, PdfAnnotation.HIGHLIGHT_INVERT);
        if (!z) {
            createCheckBox.setFieldName(this.fieldName);
            if ((this.options & 1) != 0) {
                createCheckBox.setFieldFlags(1);
            }
            if ((this.options & 2) != 0) {
                createCheckBox.setFieldFlags(2);
            }
            createCheckBox.setValueAsName(this.checked ? this.onValue : "Off");
            setCheckType(1);
        }
        if (this.text != null) {
            createCheckBox.setMKNormalCaption(this.text);
        }
        if (this.rotation != 0) {
            createCheckBox.setMKRotation(this.rotation);
        }
        createCheckBox.setBorderStyle(new PdfBorderDictionary(this.borderWidth, this.borderStyle, new PdfDashPattern(3.0f)));
        PdfAppearance appearance = getAppearance(z, true);
        PdfAppearance appearance2 = getAppearance(z, false);
        createCheckBox.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, this.onValue, appearance);
        createCheckBox.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, "Off", appearance2);
        createCheckBox.setAppearanceState(this.checked ? this.onValue : "Off");
        PdfAppearance pdfAppearance = (PdfAppearance) appearance.getDuplicate();
        pdfAppearance.setFontAndSize(getRealFont(), this.fontSize);
        if (this.textColor == null) {
            pdfAppearance.setGrayFill(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        } else {
            pdfAppearance.setColorFill(this.textColor);
        }
        createCheckBox.setDefaultAppearanceString(pdfAppearance);
        if (this.borderColor != null) {
            createCheckBox.setMKBorderColor(this.borderColor);
        }
        if (this.backgroundColor != null) {
            createCheckBox.setMKBackgroundColor(this.backgroundColor);
        }
        switch (this.visibility) {
            case 1:
                createCheckBox.setFlags(6);
                break;
            case 2:
                break;
            case 3:
                createCheckBox.setFlags(36);
                break;
            default:
                createCheckBox.setFlags(4);
                break;
        }
        return createCheckBox;
    }
}
