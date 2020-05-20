package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import org.apache.http.conn.ssl.TokenParser;

/* loaded from: classes.dex */
public class TextField extends BaseField {
    private String[] choiceExports;
    private ArrayList<Integer> choiceSelections;
    private String[] choices;
    private String defaultText;
    private BaseFont extensionFont;
    private float extraMarginLeft;
    private float extraMarginTop;
    private ArrayList<BaseFont> substitutionFonts;
    private int topFirst;

    public TextField(PdfWriter pdfWriter, Rectangle rectangle, String str) {
        super(pdfWriter, rectangle, str);
        this.choiceSelections = new ArrayList<>();
    }

    private static boolean checkRTL(String str) {
        char[] charArray;
        if (str == null || str.length() == 0) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (c >= 1424 && c < 1920) {
                return true;
            }
        }
        return false;
    }

    private static void changeFontSize(Phrase phrase, float f) {
        for (int i = 0; i < phrase.size(); i++) {
            ((Chunk) phrase.get(i)).getFont().setSize(f);
        }
    }

    private Phrase composePhrase(String str, BaseFont baseFont, BaseColor baseColor, float f) {
        ArrayList<BaseFont> arrayList;
        if (this.extensionFont == null && ((arrayList = this.substitutionFonts) == null || arrayList.isEmpty())) {
            return new Phrase(new Chunk(str, new Font(baseFont, f, 0, baseColor)));
        }
        FontSelector fontSelector = new FontSelector();
        fontSelector.addFont(new Font(baseFont, f, 0, baseColor));
        BaseFont baseFont2 = this.extensionFont;
        if (baseFont2 != null) {
            fontSelector.addFont(new Font(baseFont2, f, 0, baseColor));
        }
        if (this.substitutionFonts != null) {
            for (int i = 0; i < this.substitutionFonts.size(); i++) {
                fontSelector.addFont(new Font(this.substitutionFonts.get(i), f, 0, baseColor));
            }
        }
        return fontSelector.process(str);
    }

    public static String removeCRLF(String str) {
        if (str.indexOf(10) >= 0 || str.indexOf(13) >= 0) {
            char[] charArray = str.toCharArray();
            StringBuffer stringBuffer = new StringBuffer(charArray.length);
            int i = 0;
            while (i < charArray.length) {
                char c = charArray[i];
                if (c == '\n') {
                    stringBuffer.append(TokenParser.f24154SP);
                } else if (c == '\r') {
                    stringBuffer.append(TokenParser.f24154SP);
                    if (i < charArray.length - 1) {
                        int i2 = i + 1;
                        if (charArray[i2] == '\n') {
                            i = i2;
                        }
                    }
                } else {
                    stringBuffer.append(c);
                }
                i++;
            }
            return stringBuffer.toString();
        }
        return str;
    }

    public static String obfuscatePassword(String str) {
        char[] cArr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            cArr[i] = '*';
        }
        return new String(cArr);
    }

    public PdfAppearance getAppearance() throws IOException, DocumentException {
        String str;
        float width;
        int i;
        PdfAppearance borderAppearance = getBorderAppearance();
        borderAppearance.beginVariableText();
        if (this.text == null || this.text.length() == 0) {
            borderAppearance.endVariableText();
            return borderAppearance;
        }
        boolean z = this.borderStyle == 2 || this.borderStyle == 3;
        float height = (this.box.getHeight() - (this.borderWidth * 2.0f)) - this.extraMarginTop;
        float f = this.borderWidth;
        if (z) {
            height -= this.borderWidth * 2.0f;
            f *= 2.0f;
        }
        float max = Math.max(f, 1.0f);
        float min = Math.min(f, max);
        borderAppearance.saveState();
        float f2 = min * 2.0f;
        borderAppearance.rectangle(min, min, this.box.getWidth() - f2, this.box.getHeight() - f2);
        borderAppearance.clip();
        borderAppearance.newPath();
        if ((this.options & 8192) != 0) {
            str = obfuscatePassword(this.text);
        } else if ((this.options & 4096) == 0) {
            str = removeCRLF(this.text);
        } else {
            str = this.text;
        }
        BaseFont realFont = getRealFont();
        BaseColor baseColor = this.textColor == null ? GrayColor.GRAYBLACK : this.textColor;
        int i2 = checkRTL(str) ? 2 : 1;
        float f3 = this.fontSize;
        Phrase composePhrase = composePhrase(str, realFont, baseColor, f3);
        if ((this.options & 4096) != 0) {
            float width2 = (this.box.getWidth() - (max * 4.0f)) - this.extraMarginLeft;
            float fontDescriptor = realFont.getFontDescriptor(8, 1.0f) - realFont.getFontDescriptor(6, 1.0f);
            ColumnText columnText = new ColumnText(null);
            if (f3 == ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                f3 = height / fontDescriptor;
                if (f3 > 4.0f) {
                    if (f3 > 12.0f) {
                        f3 = 12.0f;
                    }
                    float max2 = Math.max((f3 - 4.0f) / 10.0f, 0.2f);
                    columnText.setSimpleColumn(ColumnText.GLOBAL_SPACE_CHAR_RATIO, -height, width2, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                    columnText.setAlignment(this.alignment);
                    columnText.setRunDirection(i2);
                    while (f3 > 4.0f) {
                        columnText.setYLine(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                        changeFontSize(composePhrase, f3);
                        columnText.setText(composePhrase);
                        columnText.setLeading(fontDescriptor * f3);
                        if ((columnText.m2715go(true) & 2) == 0) {
                            break;
                        }
                        f3 -= max2;
                    }
                }
                if (f3 < 4.0f) {
                    f3 = 4.0f;
                }
            }
            changeFontSize(composePhrase, f3);
            columnText.setCanvas(borderAppearance);
            float f4 = fontDescriptor * f3;
            float fontDescriptor2 = (height + max) - realFont.getFontDescriptor(8, f3);
            float f5 = max * 2.0f;
            columnText.setSimpleColumn(this.extraMarginLeft + f5, -20000.0f, this.box.getWidth() - f5, fontDescriptor2 + f4);
            columnText.setLeading(f4);
            columnText.setAlignment(this.alignment);
            columnText.setRunDirection(i2);
            columnText.setText(composePhrase);
            columnText.m2716go();
        } else {
            if (f3 == ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                float fontDescriptor3 = height / (realFont.getFontDescriptor(7, 1.0f) - realFont.getFontDescriptor(6, 1.0f));
                changeFontSize(composePhrase, 1.0f);
                float width3 = ColumnText.getWidth(composePhrase, i2, 0);
                f3 = width3 == ColumnText.GLOBAL_SPACE_CHAR_RATIO ? fontDescriptor3 : Math.min(fontDescriptor3, ((this.box.getWidth() - this.extraMarginLeft) - (max * 4.0f)) / width3);
                if (f3 < 4.0f) {
                    f3 = 4.0f;
                }
            }
            changeFontSize(composePhrase, f3);
            float height2 = (((this.box.getHeight() - f2) - realFont.getFontDescriptor(1, f3)) / 2.0f) + min;
            if (height2 < min) {
                height2 = min;
            }
            if (height2 - min < (-realFont.getFontDescriptor(3, f3))) {
                height2 = Math.min((-realFont.getFontDescriptor(3, f3)) + min, Math.max(height2, (this.box.getHeight() - min) - realFont.getFontDescriptor(1, f3)));
            }
            if ((this.options & 16777216) != 0 && this.maxCharacterLength > 0) {
                int min2 = Math.min(this.maxCharacterLength, str.length());
                if (this.alignment == 2) {
                    i = this.maxCharacterLength - min2;
                } else {
                    i = this.alignment == 1 ? (this.maxCharacterLength - min2) / 2 : 0;
                }
                float width4 = (this.box.getWidth() - this.extraMarginLeft) / this.maxCharacterLength;
                float f6 = (width4 / 2.0f) + (i * width4);
                if (this.textColor == null) {
                    borderAppearance.setGrayFill(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                } else {
                    borderAppearance.setColorFill(this.textColor);
                }
                borderAppearance.beginText();
                int i3 = 0;
                while (i3 < composePhrase.size()) {
                    Chunk chunk = (Chunk) composePhrase.get(i3);
                    BaseFont baseFont = chunk.getFont().getBaseFont();
                    borderAppearance.setFontAndSize(baseFont, f3);
                    StringBuffer append = chunk.append("");
                    float f7 = f6;
                    int i4 = 0;
                    while (i4 < append.length()) {
                        int i5 = i4 + 1;
                        String substring = append.substring(i4, i5);
                        borderAppearance.setTextMatrix((this.extraMarginLeft + f7) - (baseFont.getWidthPoint(substring, f3) / 2.0f), height2 - this.extraMarginTop);
                        borderAppearance.showText(substring);
                        f7 += width4;
                        i4 = i5;
                    }
                    i3++;
                    f6 = f7;
                }
                borderAppearance.endText();
            } else {
                switch (this.alignment) {
                    case 1:
                        width = this.extraMarginLeft + (this.box.getWidth() / 2.0f);
                        break;
                    case 2:
                        width = (this.extraMarginLeft + this.box.getWidth()) - (max * 2.0f);
                        break;
                    default:
                        width = this.extraMarginLeft + (max * 2.0f);
                        break;
                }
                ColumnText.showTextAligned(borderAppearance, this.alignment, composePhrase, width, height2 - this.extraMarginTop, ColumnText.GLOBAL_SPACE_CHAR_RATIO, i2, 0);
            }
        }
        borderAppearance.restoreState();
        borderAppearance.endVariableText();
        return borderAppearance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfAppearance getListAppearance() throws IOException, DocumentException {
        PdfAppearance borderAppearance = getBorderAppearance();
        String[] strArr = this.choices;
        if (strArr == null || strArr.length == 0) {
            return borderAppearance;
        }
        borderAppearance.beginVariableText();
        int topChoice = getTopChoice();
        BaseFont realFont = getRealFont();
        float f = this.fontSize;
        float f2 = f == ColumnText.GLOBAL_SPACE_CHAR_RATIO ? 12.0f : f;
        boolean z = this.borderStyle == 2 || this.borderStyle == 3;
        float height = this.box.getHeight() - (this.borderWidth * 2.0f);
        float f3 = this.borderWidth;
        if (z) {
            height -= this.borderWidth * 2.0f;
            f3 *= 2.0f;
        }
        float fontDescriptor = realFont.getFontDescriptor(8, f2) - realFont.getFontDescriptor(6, f2);
        int i = ((int) (height / fontDescriptor)) + 1 + topChoice;
        String[] strArr2 = this.choices;
        int length = i > strArr2.length ? strArr2.length : i;
        this.topFirst = topChoice;
        borderAppearance.saveState();
        float f4 = f3 * 2.0f;
        borderAppearance.rectangle(f3, f3, this.box.getWidth() - f4, this.box.getHeight() - f4);
        borderAppearance.clip();
        borderAppearance.newPath();
        BaseColor baseColor = this.textColor == null ? GrayColor.GRAYBLACK : this.textColor;
        borderAppearance.setColorFill(new BaseColor(10, 36, 106));
        for (int i2 = 0; i2 < this.choiceSelections.size(); i2++) {
            int intValue = this.choiceSelections.get(i2).intValue();
            if (intValue >= topChoice && intValue <= length) {
                borderAppearance.rectangle(f3, (f3 + height) - (((intValue - topChoice) + 1) * fontDescriptor), this.box.getWidth() - f4, fontDescriptor);
                borderAppearance.fill();
            }
        }
        int i3 = topChoice;
        float fontDescriptor2 = (f3 + height) - realFont.getFontDescriptor(8, f2);
        while (i3 < length) {
            String str = this.choices[i3];
            ColumnText.showTextAligned(borderAppearance, 0, composePhrase(removeCRLF(str), realFont, this.choiceSelections.contains(Integer.valueOf(i3)) ? GrayColor.GRAYWHITE : baseColor, f2), f4, fontDescriptor2, ColumnText.GLOBAL_SPACE_CHAR_RATIO, checkRTL(str) ? 2 : 1, 0);
            i3++;
            fontDescriptor2 -= fontDescriptor;
        }
        borderAppearance.restoreState();
        borderAppearance.endVariableText();
        return borderAppearance;
    }

    public PdfFormField getTextField() throws IOException, DocumentException {
        if (this.maxCharacterLength <= 0) {
            this.options &= -16777217;
        }
        if ((this.options & 16777216) != 0) {
            this.options &= -4097;
        }
        PdfFormField createTextField = PdfFormField.createTextField(this.writer, false, false, this.maxCharacterLength);
        createTextField.setWidget(this.box, PdfAnnotation.HIGHLIGHT_INVERT);
        switch (this.alignment) {
            case 1:
                createTextField.setQuadding(1);
                break;
            case 2:
                createTextField.setQuadding(2);
                break;
        }
        if (this.rotation != 0) {
            createTextField.setMKRotation(this.rotation);
        }
        if (this.fieldName != null) {
            createTextField.setFieldName(this.fieldName);
            if (!"".equals(this.text)) {
                createTextField.setValueAsString(this.text);
            }
            String str = this.defaultText;
            if (str != null) {
                createTextField.setDefaultValueAsString(str);
            }
            if ((this.options & 1) != 0) {
                createTextField.setFieldFlags(1);
            }
            if ((this.options & 2) != 0) {
                createTextField.setFieldFlags(2);
            }
            if ((this.options & 4096) != 0) {
                createTextField.setFieldFlags(4096);
            }
            if ((this.options & 8388608) != 0) {
                createTextField.setFieldFlags(8388608);
            }
            if ((this.options & 8192) != 0) {
                createTextField.setFieldFlags(8192);
            }
            if ((this.options & 1048576) != 0) {
                createTextField.setFieldFlags(1048576);
            }
            if ((this.options & 4194304) != 0) {
                createTextField.setFieldFlags(4194304);
            }
            if ((this.options & 16777216) != 0) {
                createTextField.setFieldFlags(16777216);
            }
        }
        createTextField.setBorderStyle(new PdfBorderDictionary(this.borderWidth, this.borderStyle, new PdfDashPattern(3.0f)));
        PdfAppearance appearance = getAppearance();
        createTextField.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, appearance);
        PdfAppearance pdfAppearance = (PdfAppearance) appearance.getDuplicate();
        pdfAppearance.setFontAndSize(getRealFont(), this.fontSize);
        if (this.textColor == null) {
            pdfAppearance.setGrayFill(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        } else {
            pdfAppearance.setColorFill(this.textColor);
        }
        createTextField.setDefaultAppearanceString(pdfAppearance);
        if (this.borderColor != null) {
            createTextField.setMKBorderColor(this.borderColor);
        }
        if (this.backgroundColor != null) {
            createTextField.setMKBackgroundColor(this.backgroundColor);
        }
        switch (this.visibility) {
            case 1:
                createTextField.setFlags(6);
                break;
            case 2:
                break;
            case 3:
                createTextField.setFlags(36);
                break;
            default:
                createTextField.setFlags(4);
                break;
        }
        return createTextField;
    }

    public PdfFormField getComboField() throws IOException, DocumentException {
        return getChoiceField(false);
    }

    public PdfFormField getListField() throws IOException, DocumentException {
        return getChoiceField(true);
    }

    private int getTopChoice() {
        Integer num;
        ArrayList<Integer> arrayList = this.choiceSelections;
        if (arrayList == null || arrayList.size() == 0 || (num = this.choiceSelections.get(0)) == null || this.choices == null) {
            return 0;
        }
        return Math.max(0, Math.min(num.intValue(), this.choices.length));
    }

    protected PdfFormField getChoiceField(boolean z) throws IOException, DocumentException {
        String[][] strArr;
        PdfFormField createCombo;
        PdfAppearance appearance;
        this.options &= -16781313;
        String[] strArr2 = this.choices;
        if (strArr2 == null) {
            strArr2 = new String[0];
        }
        int topChoice = getTopChoice();
        if (strArr2.length > 0 && topChoice >= 0) {
            this.text = strArr2[topChoice];
        }
        if (this.text == null) {
            this.text = "";
        }
        if (this.choiceExports != null) {
            String[][] strArr3 = (String[][]) Array.newInstance(String.class, strArr2.length, 2);
            for (int i = 0; i < strArr3.length; i++) {
                String[] strArr4 = strArr3[i];
                String[] strArr5 = strArr3[i];
                String str = strArr2[i];
                strArr5[1] = str;
                strArr4[0] = str;
            }
            int min = Math.min(strArr2.length, this.choiceExports.length);
            for (int i2 = 0; i2 < min; i2++) {
                String[] strArr6 = this.choiceExports;
                if (strArr6[i2] != null) {
                    strArr3[i2][0] = strArr6[i2];
                }
            }
            if (z) {
                strArr = strArr3;
                createCombo = PdfFormField.createList(this.writer, strArr3, topChoice);
            } else {
                strArr = strArr3;
                createCombo = PdfFormField.createCombo(this.writer, (262144 & this.options) != 0, strArr3, topChoice);
            }
        } else if (z) {
            createCombo = PdfFormField.createList(this.writer, strArr2, topChoice);
            strArr = null;
        } else {
            createCombo = PdfFormField.createCombo(this.writer, (262144 & this.options) != 0, strArr2, topChoice);
            strArr = null;
        }
        createCombo.setWidget(this.box, PdfAnnotation.HIGHLIGHT_INVERT);
        if (this.rotation != 0) {
            createCombo.setMKRotation(this.rotation);
        }
        if (this.fieldName != null) {
            createCombo.setFieldName(this.fieldName);
            if (strArr2.length > 0) {
                if (strArr != null) {
                    if (this.choiceSelections.size() < 2) {
                        createCombo.setValueAsString(strArr[topChoice][0]);
                        createCombo.setDefaultValueAsString(strArr[topChoice][0]);
                    } else {
                        writeMultipleValues(createCombo, strArr);
                    }
                } else if (this.choiceSelections.size() < 2) {
                    createCombo.setValueAsString(this.text);
                    createCombo.setDefaultValueAsString(this.text);
                } else {
                    writeMultipleValues(createCombo, null);
                }
            }
            if ((this.options & 1) != 0) {
                createCombo.setFieldFlags(1);
            }
            if ((this.options & 2) != 0) {
                createCombo.setFieldFlags(2);
            }
            if ((this.options & 4194304) != 0) {
                createCombo.setFieldFlags(4194304);
            }
            if ((this.options & 2097152) != 0) {
                createCombo.setFieldFlags(2097152);
            }
        }
        createCombo.setBorderStyle(new PdfBorderDictionary(this.borderWidth, this.borderStyle, new PdfDashPattern(3.0f)));
        if (z) {
            appearance = getListAppearance();
            if (this.topFirst > 0) {
                createCombo.put(PdfName.f19776TI, new PdfNumber(this.topFirst));
            }
        } else {
            appearance = getAppearance();
        }
        createCombo.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, appearance);
        PdfAppearance pdfAppearance = (PdfAppearance) appearance.getDuplicate();
        pdfAppearance.setFontAndSize(getRealFont(), this.fontSize);
        if (this.textColor == null) {
            pdfAppearance.setGrayFill(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        } else {
            pdfAppearance.setColorFill(this.textColor);
        }
        createCombo.setDefaultAppearanceString(pdfAppearance);
        if (this.borderColor != null) {
            createCombo.setMKBorderColor(this.borderColor);
        }
        if (this.backgroundColor != null) {
            createCombo.setMKBackgroundColor(this.backgroundColor);
        }
        switch (this.visibility) {
            case 1:
                createCombo.setFlags(6);
                break;
            case 2:
                break;
            case 3:
                createCombo.setFlags(36);
                break;
            default:
                createCombo.setFlags(4);
                break;
        }
        return createCombo;
    }

    private void writeMultipleValues(PdfFormField pdfFormField, String[][] strArr) {
        PdfArray pdfArray = new PdfArray();
        PdfArray pdfArray2 = new PdfArray();
        for (int i = 0; i < this.choiceSelections.size(); i++) {
            int intValue = this.choiceSelections.get(i).intValue();
            pdfArray.add(new PdfNumber(intValue));
            if (strArr != null) {
                pdfArray2.add(new PdfString(strArr[intValue][0]));
            } else {
                String[] strArr2 = this.choices;
                if (strArr2 != null) {
                    pdfArray2.add(new PdfString(strArr2[intValue]));
                }
            }
        }
        pdfFormField.put(PdfName.f19787V, pdfArray2);
        pdfFormField.put(PdfName.f19729I, pdfArray);
    }

    public String getDefaultText() {
        return this.defaultText;
    }

    public void setDefaultText(String str) {
        this.defaultText = str;
    }

    public String[] getChoices() {
        return this.choices;
    }

    public void setChoices(String[] strArr) {
        this.choices = strArr;
    }

    public String[] getChoiceExports() {
        return this.choiceExports;
    }

    public void setChoiceExports(String[] strArr) {
        this.choiceExports = strArr;
    }

    public int getChoiceSelection() {
        return getTopChoice();
    }

    public ArrayList<Integer> getChoiceSelections() {
        return this.choiceSelections;
    }

    public void setChoiceSelection(int i) {
        this.choiceSelections = new ArrayList<>();
        this.choiceSelections.add(Integer.valueOf(i));
    }

    public void addChoiceSelection(int i) {
        if ((this.options & 2097152) != 0) {
            this.choiceSelections.add(Integer.valueOf(i));
        }
    }

    public void setChoiceSelections(ArrayList<Integer> arrayList) {
        if (arrayList != null) {
            this.choiceSelections = new ArrayList<>(arrayList);
            if (this.choiceSelections.size() <= 1 || (this.options & 2097152) != 0) {
                return;
            }
            while (this.choiceSelections.size() > 1) {
                this.choiceSelections.remove(1);
            }
            return;
        }
        this.choiceSelections.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getTopFirst() {
        return this.topFirst;
    }

    public void setExtraMargin(float f, float f2) {
        this.extraMarginLeft = f;
        this.extraMarginTop = f2;
    }

    public ArrayList<BaseFont> getSubstitutionFonts() {
        return this.substitutionFonts;
    }

    public void setSubstitutionFonts(ArrayList<BaseFont> arrayList) {
        this.substitutionFonts = arrayList;
    }

    public BaseFont getExtensionFont() {
        return this.extensionFont;
    }

    public void setExtensionFont(BaseFont baseFont) {
        this.extensionFont = baseFont;
    }
}
