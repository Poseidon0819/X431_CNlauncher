package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class BaseField {
    public static final float BORDER_WIDTH_MEDIUM = 2.0f;
    public static final float BORDER_WIDTH_THICK = 3.0f;
    public static final float BORDER_WIDTH_THIN = 1.0f;
    public static final int COMB = 16777216;
    public static final int DO_NOT_SCROLL = 8388608;
    public static final int DO_NOT_SPELL_CHECK = 4194304;
    public static final int EDIT = 262144;
    public static final int FILE_SELECTION = 1048576;
    public static final int HIDDEN = 1;
    public static final int HIDDEN_BUT_PRINTABLE = 3;
    public static final int MULTILINE = 4096;
    public static final int MULTISELECT = 2097152;
    public static final int PASSWORD = 8192;
    public static final int READ_ONLY = 1;
    public static final int REQUIRED = 2;
    public static final int VISIBLE = 0;
    public static final int VISIBLE_BUT_DOES_NOT_PRINT = 2;
    private static final HashMap<PdfName, Integer> fieldKeys;
    protected BaseColor backgroundColor;
    protected BaseColor borderColor;
    protected Rectangle box;
    protected String fieldName;
    protected BaseFont font;
    protected int maxCharacterLength;
    protected int options;
    protected String text;
    protected BaseColor textColor;
    protected int visibility;
    protected PdfWriter writer;
    protected float borderWidth = 1.0f;
    protected int borderStyle = 0;
    protected float fontSize = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    protected int alignment = 0;
    protected int rotation = 0;

    static {
        HashMap<PdfName, Integer> hashMap = new HashMap<>();
        fieldKeys = hashMap;
        hashMap.putAll(PdfCopyFieldsImp.fieldKeys);
        fieldKeys.put(PdfName.f19772T, 1);
    }

    public BaseField(PdfWriter pdfWriter, Rectangle rectangle, String str) {
        this.writer = pdfWriter;
        setBox(rectangle);
        this.fieldName = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseFont getRealFont() throws IOException, DocumentException {
        BaseFont baseFont = this.font;
        return baseFont == null ? BaseFont.createFont("Helvetica", "Cp1252", false) : baseFont;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PdfAppearance getBorderAppearance() {
        BaseColor baseColor;
        BaseColor baseColor2;
        BaseColor baseColor3;
        PdfAppearance createAppearance = PdfAppearance.createAppearance(this.writer, this.box.getWidth(), this.box.getHeight());
        int i = this.rotation;
        if (i == 90) {
            createAppearance.setMatrix(ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f, -1.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, this.box.getHeight(), ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        } else if (i == 180) {
            createAppearance.setMatrix(-1.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, -1.0f, this.box.getWidth(), this.box.getHeight());
        } else if (i == 270) {
            createAppearance.setMatrix(ColumnText.GLOBAL_SPACE_CHAR_RATIO, -1.0f, 1.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, this.box.getWidth());
        }
        createAppearance.saveState();
        BaseColor baseColor4 = this.backgroundColor;
        if (baseColor4 != null) {
            createAppearance.setColorFill(baseColor4);
            createAppearance.rectangle(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, this.box.getWidth(), this.box.getHeight());
            createAppearance.fill();
        }
        int i2 = this.borderStyle;
        if (i2 == 4) {
            if (this.borderWidth != ColumnText.GLOBAL_SPACE_CHAR_RATIO && (baseColor3 = this.borderColor) != null) {
                createAppearance.setColorStroke(baseColor3);
                createAppearance.setLineWidth(this.borderWidth);
                createAppearance.moveTo(ColumnText.GLOBAL_SPACE_CHAR_RATIO, this.borderWidth / 2.0f);
                createAppearance.lineTo(this.box.getWidth(), this.borderWidth / 2.0f);
                createAppearance.stroke();
            }
        } else if (i2 == 2) {
            if (this.borderWidth != ColumnText.GLOBAL_SPACE_CHAR_RATIO && (baseColor2 = this.borderColor) != null) {
                createAppearance.setColorStroke(baseColor2);
                createAppearance.setLineWidth(this.borderWidth);
                float f = this.borderWidth;
                createAppearance.rectangle(f / 2.0f, f / 2.0f, this.box.getWidth() - this.borderWidth, this.box.getHeight() - this.borderWidth);
                createAppearance.stroke();
            }
            BaseColor baseColor5 = this.backgroundColor;
            if (baseColor5 == null) {
                baseColor5 = BaseColor.WHITE;
            }
            createAppearance.setGrayFill(1.0f);
            drawTopFrame(createAppearance);
            createAppearance.setColorFill(baseColor5.darker());
            drawBottomFrame(createAppearance);
        } else if (i2 == 3) {
            if (this.borderWidth != ColumnText.GLOBAL_SPACE_CHAR_RATIO && (baseColor = this.borderColor) != null) {
                createAppearance.setColorStroke(baseColor);
                createAppearance.setLineWidth(this.borderWidth);
                float f2 = this.borderWidth;
                createAppearance.rectangle(f2 / 2.0f, f2 / 2.0f, this.box.getWidth() - this.borderWidth, this.box.getHeight() - this.borderWidth);
                createAppearance.stroke();
            }
            createAppearance.setGrayFill(0.5f);
            drawTopFrame(createAppearance);
            createAppearance.setGrayFill(0.75f);
            drawBottomFrame(createAppearance);
        } else if (this.borderWidth != ColumnText.GLOBAL_SPACE_CHAR_RATIO && this.borderColor != null) {
            if (i2 == 1) {
                createAppearance.setLineDash(3.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
            }
            createAppearance.setColorStroke(this.borderColor);
            createAppearance.setLineWidth(this.borderWidth);
            float f3 = this.borderWidth;
            createAppearance.rectangle(f3 / 2.0f, f3 / 2.0f, this.box.getWidth() - this.borderWidth, this.box.getHeight() - this.borderWidth);
            createAppearance.stroke();
            if ((this.options & 16777216) != 0 && this.maxCharacterLength > 1) {
                float width = this.box.getWidth() / this.maxCharacterLength;
                float f4 = this.borderWidth / 2.0f;
                float height = this.box.getHeight() - (this.borderWidth / 2.0f);
                for (int i3 = 1; i3 < this.maxCharacterLength; i3++) {
                    float f5 = i3 * width;
                    createAppearance.moveTo(f5, f4);
                    createAppearance.lineTo(f5, height);
                }
                createAppearance.stroke();
            }
        }
        createAppearance.restoreState();
        return createAppearance;
    }

    protected static ArrayList<String> getHardBreaks(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < length) {
            char c = charArray[i];
            if (c == '\r') {
                int i2 = i + 1;
                if (i2 < length && charArray[i2] == '\n') {
                    i = i2;
                }
                arrayList.add(stringBuffer.toString());
                stringBuffer = new StringBuffer();
            } else if (c == '\n') {
                arrayList.add(stringBuffer.toString());
                stringBuffer = new StringBuffer();
            } else {
                stringBuffer.append(c);
            }
            i++;
        }
        arrayList.add(stringBuffer.toString());
        return arrayList;
    }

    protected static void trimRight(StringBuffer stringBuffer) {
        int length = stringBuffer.length();
        while (length != 0) {
            length--;
            if (stringBuffer.charAt(length) != ' ') {
                return;
            }
            stringBuffer.setLength(length);
        }
    }

    protected static ArrayList<String> breakLines(ArrayList<String> arrayList, BaseFont baseFont, float f, float f2) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        int i2 = 0;
        while (i2 < arrayList.size()) {
            stringBuffer.setLength(i);
            char[] charArray = arrayList.get(i2).toCharArray();
            int length = charArray.length;
            int i3 = 0;
            char c = 0;
            float f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            int i4 = -1;
            int i5 = 0;
            while (i3 < length) {
                char c2 = charArray[i3];
                switch (c) {
                    case 0:
                        f3 += baseFont.getWidthPoint(c2, f);
                        stringBuffer.append(c2);
                        if (f3 <= f2) {
                            if (c2 == ' ') {
                                break;
                            } else {
                                c = 1;
                                break;
                            }
                        } else {
                            if (stringBuffer.length() > 1) {
                                i3--;
                                stringBuffer.setLength(stringBuffer.length() - 1);
                            }
                            arrayList2.add(stringBuffer.toString());
                            stringBuffer.setLength(0);
                            if (c2 != ' ') {
                                i5 = i3;
                                c = 1;
                                f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                                break;
                            } else {
                                i5 = i3;
                                c = 2;
                                f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                                break;
                            }
                        }
                    case 1:
                        f3 += baseFont.getWidthPoint(c2, f);
                        stringBuffer.append(c2);
                        if (c2 == ' ') {
                            i4 = i3;
                        }
                        if (f3 > f2) {
                            if (i4 >= 0) {
                                stringBuffer.setLength(i4 - i5);
                                trimRight(stringBuffer);
                                arrayList2.add(stringBuffer.toString());
                                stringBuffer.setLength(0);
                                i3 = i4;
                                i5 = i3;
                                c = 2;
                                f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                                i4 = -1;
                                break;
                            } else {
                                if (stringBuffer.length() > 1) {
                                    i3--;
                                    stringBuffer.setLength(stringBuffer.length() - 1);
                                }
                                arrayList2.add(stringBuffer.toString());
                                stringBuffer.setLength(0);
                                if (c2 != ' ') {
                                    i5 = i3;
                                    f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                                    break;
                                } else {
                                    i5 = i3;
                                    c = 2;
                                    f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                                    break;
                                }
                            }
                        } else {
                            break;
                        }
                    case 2:
                        if (c2 == ' ') {
                            break;
                        } else {
                            i3--;
                            c = 1;
                            f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                            break;
                        }
                }
                i3++;
            }
            trimRight(stringBuffer);
            arrayList2.add(stringBuffer.toString());
            i2++;
            i = 0;
        }
        return arrayList2;
    }

    private void drawTopFrame(PdfAppearance pdfAppearance) {
        float f = this.borderWidth;
        pdfAppearance.moveTo(f, f);
        pdfAppearance.lineTo(this.borderWidth, this.box.getHeight() - this.borderWidth);
        pdfAppearance.lineTo(this.box.getWidth() - this.borderWidth, this.box.getHeight() - this.borderWidth);
        pdfAppearance.lineTo(this.box.getWidth() - (this.borderWidth * 2.0f), this.box.getHeight() - (this.borderWidth * 2.0f));
        pdfAppearance.lineTo(this.borderWidth * 2.0f, this.box.getHeight() - (this.borderWidth * 2.0f));
        float f2 = this.borderWidth;
        pdfAppearance.lineTo(f2 * 2.0f, f2 * 2.0f);
        float f3 = this.borderWidth;
        pdfAppearance.lineTo(f3, f3);
        pdfAppearance.fill();
    }

    private void drawBottomFrame(PdfAppearance pdfAppearance) {
        float f = this.borderWidth;
        pdfAppearance.moveTo(f, f);
        float width = this.box.getWidth();
        float f2 = this.borderWidth;
        pdfAppearance.lineTo(width - f2, f2);
        pdfAppearance.lineTo(this.box.getWidth() - this.borderWidth, this.box.getHeight() - this.borderWidth);
        pdfAppearance.lineTo(this.box.getWidth() - (this.borderWidth * 2.0f), this.box.getHeight() - (this.borderWidth * 2.0f));
        float width2 = this.box.getWidth();
        float f3 = this.borderWidth;
        pdfAppearance.lineTo(width2 - (f3 * 2.0f), f3 * 2.0f);
        float f4 = this.borderWidth;
        pdfAppearance.lineTo(f4 * 2.0f, f4 * 2.0f);
        float f5 = this.borderWidth;
        pdfAppearance.lineTo(f5, f5);
        pdfAppearance.fill();
    }

    public float getBorderWidth() {
        return this.borderWidth;
    }

    public void setBorderWidth(float f) {
        this.borderWidth = f;
    }

    public int getBorderStyle() {
        return this.borderStyle;
    }

    public void setBorderStyle(int i) {
        this.borderStyle = i;
    }

    public BaseColor getBorderColor() {
        return this.borderColor;
    }

    public void setBorderColor(BaseColor baseColor) {
        this.borderColor = baseColor;
    }

    public BaseColor getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setBackgroundColor(BaseColor baseColor) {
        this.backgroundColor = baseColor;
    }

    public BaseColor getTextColor() {
        return this.textColor;
    }

    public void setTextColor(BaseColor baseColor) {
        this.textColor = baseColor;
    }

    public BaseFont getFont() {
        return this.font;
    }

    public void setFont(BaseFont baseFont) {
        this.font = baseFont;
    }

    public float getFontSize() {
        return this.fontSize;
    }

    public void setFontSize(float f) {
        this.fontSize = f;
    }

    public int getAlignment() {
        return this.alignment;
    }

    public void setAlignment(int i) {
        this.alignment = i;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public Rectangle getBox() {
        return this.box;
    }

    public void setBox(Rectangle rectangle) {
        if (rectangle == null) {
            this.box = null;
            return;
        }
        this.box = new Rectangle(rectangle);
        this.box.normalize();
    }

    public int getRotation() {
        return this.rotation;
    }

    public void setRotation(int i) {
        if (i % 90 != 0) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("rotation.must.be.a.multiple.of.90", new Object[0]));
        }
        int i2 = i % 360;
        if (i2 < 0) {
            i2 += 360;
        }
        this.rotation = i2;
    }

    public void setRotationFromPage(Rectangle rectangle) {
        setRotation(rectangle.getRotation());
    }

    public int getVisibility() {
        return this.visibility;
    }

    public void setVisibility(int i) {
        this.visibility = i;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public void setFieldName(String str) {
        this.fieldName = str;
    }

    public int getOptions() {
        return this.options;
    }

    public void setOptions(int i) {
        this.options = i;
    }

    public int getMaxCharacterLength() {
        return this.maxCharacterLength;
    }

    public void setMaxCharacterLength(int i) {
        this.maxCharacterLength = i;
    }

    public PdfWriter getWriter() {
        return this.writer;
    }

    public void setWriter(PdfWriter pdfWriter) {
        this.writer = pdfWriter;
    }

    public static void moveFields(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2) {
        Iterator<PdfName> it = pdfDictionary.getKeys().iterator();
        while (it.hasNext()) {
            PdfName next = it.next();
            if (fieldKeys.containsKey(next)) {
                if (pdfDictionary2 != null) {
                    pdfDictionary2.put(next, pdfDictionary.get(next));
                }
                it.remove();
            }
        }
    }
}
