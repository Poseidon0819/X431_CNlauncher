package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.XfaForm;
import com.itextpdf.text.pdf.codec.Base64;
import com.itextpdf.text.pdf.security.PdfPKCS7;
import com.itextpdf.text.xml.XmlToTxt;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.apache.http.conn.ssl.TokenParser;
import org.w3c.dom.Node;

/* loaded from: classes.dex */
public class AcroFields {
    public static final int DA_COLOR = 2;
    public static final int DA_FONT = 0;
    public static final int DA_SIZE = 1;
    public static final int FIELD_TYPE_CHECKBOX = 2;
    public static final int FIELD_TYPE_COMBO = 6;
    public static final int FIELD_TYPE_LIST = 5;
    public static final int FIELD_TYPE_NONE = 0;
    public static final int FIELD_TYPE_PUSHBUTTON = 1;
    public static final int FIELD_TYPE_RADIOBUTTON = 3;
    public static final int FIELD_TYPE_SIGNATURE = 7;
    public static final int FIELD_TYPE_TEXT = 4;
    private static final PdfName[] buttonRemove;
    private static final HashMap<String, String[]> stdFieldFontNames;
    private boolean append;
    private float extraMarginLeft;
    private float extraMarginTop;
    private Map<String, TextField> fieldCache;
    Map<String, Item> fields;
    private boolean lastWasString;
    private ArrayList<String> orderedSignatureNames;
    PdfReader reader;
    private HashMap<String, int[]> sigNames;
    private ArrayList<BaseFont> substitutionFonts;
    private int topFirst;
    private int totalRevisions;
    PdfWriter writer;
    private XfaForm xfa;
    private HashMap<Integer, BaseFont> extensionFonts = new HashMap<>();
    private boolean generateAppearances = true;
    private HashMap<String, BaseFont> localFonts = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.itextpdf.text.pdf.AcroFields$1 */
    /* loaded from: classes.dex */
    public class C36291 {
    }

    /* loaded from: classes.dex */
    public static class FieldPosition {
        public int page;
        public Rectangle position;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AcroFields(PdfReader pdfReader, PdfWriter pdfWriter) {
        this.reader = pdfReader;
        this.writer = pdfWriter;
        try {
            this.xfa = new XfaForm(pdfReader);
            if (pdfWriter instanceof PdfStamperImp) {
                this.append = ((PdfStamperImp) pdfWriter).isAppend();
            }
            fill();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    void fill() {
        PdfArray pdfArray;
        this.fields = new HashMap();
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease(this.reader.getCatalog().get(PdfName.ACROFORM));
        if (pdfDictionary == null || (pdfArray = (PdfArray) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.FIELDS))) == null || pdfArray.size() == 0) {
            return;
        }
        for (int i = 1; i <= this.reader.getNumberOfPages(); i++) {
            PdfDictionary pageNRelease = this.reader.getPageNRelease(i);
            PdfArray pdfArray2 = (PdfArray) PdfReader.getPdfObjectRelease(pageNRelease.get(PdfName.ANNOTS), pageNRelease);
            if (pdfArray2 != null) {
                for (int i2 = 0; i2 < pdfArray2.size(); i2++) {
                    PdfDictionary asDict = pdfArray2.getAsDict(i2);
                    if (asDict == null) {
                        PdfReader.releaseLastXrefPartial(pdfArray2.getAsIndirectObject(i2));
                    } else if (!PdfName.WIDGET.equals(asDict.getAsName(PdfName.SUBTYPE))) {
                        PdfReader.releaseLastXrefPartial(pdfArray2.getAsIndirectObject(i2));
                    } else {
                        PdfDictionary pdfDictionary2 = new PdfDictionary();
                        pdfDictionary2.putAll(asDict);
                        PdfObject pdfObject = null;
                        PdfDictionary pdfDictionary3 = null;
                        String str = "";
                        for (PdfDictionary pdfDictionary4 = asDict; pdfDictionary4 != null; pdfDictionary4 = pdfDictionary4.getAsDict(PdfName.PARENT)) {
                            pdfDictionary2.mergeDifferent(pdfDictionary4);
                            PdfString asString = pdfDictionary4.getAsString(PdfName.f19772T);
                            if (asString != null) {
                                str = asString.toUnicodeString() + "." + str;
                            }
                            if (pdfObject == null && pdfDictionary4.get(PdfName.f19787V) != null) {
                                pdfObject = PdfReader.getPdfObjectRelease(pdfDictionary4.get(PdfName.f19787V));
                            }
                            if (pdfDictionary3 == null && asString != null) {
                                if (pdfDictionary4.get(PdfName.f19787V) == null && pdfObject != null) {
                                    pdfDictionary4.put(PdfName.f19787V, pdfObject);
                                }
                                pdfDictionary3 = pdfDictionary4;
                            }
                        }
                        if (str.length() > 0) {
                            str = str.substring(0, str.length() - 1);
                        }
                        Item item = this.fields.get(str);
                        if (item == null) {
                            item = new Item();
                            this.fields.put(str, item);
                        }
                        if (pdfDictionary3 == null) {
                            item.addValue(asDict);
                        } else {
                            item.addValue(pdfDictionary3);
                        }
                        item.addWidget(asDict);
                        item.addWidgetRef(pdfArray2.getAsIndirectObject(i2));
                        if (pdfDictionary != null) {
                            pdfDictionary2.mergeDifferent(pdfDictionary);
                        }
                        item.addMerged(pdfDictionary2);
                        item.addPage(i);
                        item.addTabOrder(i2);
                    }
                }
            }
        }
        PdfNumber asNumber = pdfDictionary.getAsNumber(PdfName.SIGFLAGS);
        if (asNumber == null || (asNumber.intValue() & 1) != 1) {
            return;
        }
        for (int i3 = 0; i3 < pdfArray.size(); i3++) {
            PdfDictionary asDict2 = pdfArray.getAsDict(i3);
            if (asDict2 == null) {
                PdfReader.releaseLastXrefPartial(pdfArray.getAsIndirectObject(i3));
            } else if (!PdfName.WIDGET.equals(asDict2.getAsName(PdfName.SUBTYPE))) {
                PdfReader.releaseLastXrefPartial(pdfArray.getAsIndirectObject(i3));
            } else if (((PdfArray) PdfReader.getPdfObjectRelease(asDict2.get(PdfName.KIDS))) == null) {
                PdfDictionary pdfDictionary5 = new PdfDictionary();
                pdfDictionary5.putAll(asDict2);
                PdfString asString2 = asDict2.getAsString(PdfName.f19772T);
                if (asString2 != null) {
                    String unicodeString = asString2.toUnicodeString();
                    if (!this.fields.containsKey(unicodeString)) {
                        Item item2 = new Item();
                        this.fields.put(unicodeString, item2);
                        item2.addValue(pdfDictionary5);
                        item2.addWidget(pdfDictionary5);
                        item2.addWidgetRef(pdfArray.getAsIndirectObject(i3));
                        item2.addMerged(pdfDictionary5);
                        item2.addPage(-1);
                        item2.addTabOrder(-1);
                    }
                }
            }
        }
    }

    public String[] getAppearanceStates(String str) {
        PdfDictionary asDict;
        Item item = this.fields.get(str);
        if (item == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        PdfDictionary value = item.getValue(0);
        PdfString asString = value.getAsString(PdfName.OPT);
        if (asString != null) {
            hashSet.add(asString.toUnicodeString());
        } else {
            PdfArray asArray = value.getAsArray(PdfName.OPT);
            if (asArray != null) {
                for (int i = 0; i < asArray.size(); i++) {
                    PdfString asString2 = asArray.getAsString(i);
                    if (asString2 != null) {
                        hashSet.add(asString2.toUnicodeString());
                    }
                }
            }
        }
        for (int i2 = 0; i2 < item.size(); i2++) {
            PdfDictionary asDict2 = item.getWidget(i2).getAsDict(PdfName.f19682AP);
            if (asDict2 != null && (asDict = asDict2.getAsDict(PdfName.f19739N)) != null) {
                for (PdfName pdfName : asDict.getKeys()) {
                    hashSet.add(PdfName.decodeName(pdfName.toString()));
                }
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    private String[] getListOption(String str, int i) {
        Item fieldItem = getFieldItem(str);
        if (fieldItem == null) {
            return null;
        }
        PdfArray asArray = fieldItem.getMerged(0).getAsArray(PdfName.OPT);
        if (asArray == null) {
            return null;
        }
        String[] strArr = new String[asArray.size()];
        for (int i2 = 0; i2 < asArray.size(); i2++) {
            PdfObject directObject = asArray.getDirectObject(i2);
            try {
                if (directObject.isArray()) {
                    directObject = ((PdfArray) directObject).getDirectObject(i);
                }
                if (directObject.isString()) {
                    strArr[i2] = ((PdfString) directObject).toUnicodeString();
                } else {
                    strArr[i2] = directObject.toString();
                }
            } catch (Exception unused) {
                strArr[i2] = "";
            }
        }
        return strArr;
    }

    public String[] getListOptionExport(String str) {
        return getListOption(str, 0);
    }

    public String[] getListOptionDisplay(String str) {
        return getListOption(str, 1);
    }

    public boolean setListOption(String str, String[] strArr, String[] strArr2) {
        int i = 0;
        if (strArr == null && strArr2 == null) {
            return false;
        }
        if (strArr != null && strArr2 != null && strArr.length != strArr2.length) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.export.and.the.display.array.must.have.the.same.size", new Object[0]));
        }
        int fieldType = getFieldType(str);
        if (fieldType == 6 || fieldType == 5) {
            Item item = this.fields.get(str);
            String[] strArr3 = null;
            if (strArr == null && strArr2 != null) {
                strArr3 = strArr2;
            } else if (strArr != null && strArr2 == null) {
                strArr3 = strArr;
            }
            PdfArray pdfArray = new PdfArray();
            if (strArr3 != null) {
                while (i < strArr3.length) {
                    pdfArray.add(new PdfString(strArr3[i], PdfObject.TEXT_UNICODE));
                    i++;
                }
            } else {
                while (i < strArr.length) {
                    PdfArray pdfArray2 = new PdfArray();
                    pdfArray2.add(new PdfString(strArr[i], PdfObject.TEXT_UNICODE));
                    pdfArray2.add(new PdfString(strArr2[i], PdfObject.TEXT_UNICODE));
                    pdfArray.add(pdfArray2);
                    i++;
                }
            }
            item.writeToAll(PdfName.OPT, pdfArray, 5);
            return true;
        }
        return false;
    }

    public int getFieldType(String str) {
        PdfDictionary merged;
        PdfName asName;
        Item fieldItem = getFieldItem(str);
        if (fieldItem == null || (asName = (merged = fieldItem.getMerged(0)).getAsName(PdfName.f19720FT)) == null) {
            return 0;
        }
        PdfNumber asNumber = merged.getAsNumber(PdfName.f19715FF);
        int intValue = asNumber != null ? asNumber.intValue() : 0;
        if (PdfName.BTN.equals(asName)) {
            if ((65536 & intValue) != 0) {
                return 1;
            }
            return (intValue & 32768) != 0 ? 3 : 2;
        } else if (PdfName.f19782TX.equals(asName)) {
            return 4;
        } else {
            return PdfName.f19695CH.equals(asName) ? (intValue & 131072) != 0 ? 6 : 5 : PdfName.SIG.equals(asName) ? 7 : 0;
        }
    }

    public void exportAsFdf(FdfWriter fdfWriter) {
        for (Map.Entry<String, Item> entry : this.fields.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue().getMerged(0).get(PdfName.f19787V) != null) {
                String field = getField(key);
                if (this.lastWasString) {
                    fdfWriter.setFieldAsString(key, field);
                } else {
                    fdfWriter.setFieldAsName(key, field);
                }
            }
        }
    }

    public boolean renameField(String str, String str2) {
        Item item;
        int lastIndexOf = str.lastIndexOf(46) + 1;
        int lastIndexOf2 = str2.lastIndexOf(46) + 1;
        if (lastIndexOf == lastIndexOf2 && str.substring(0, lastIndexOf).equals(str2.substring(0, lastIndexOf2)) && !this.fields.containsKey(str2) && (item = this.fields.get(str)) != null) {
            String substring = str2.substring(lastIndexOf2);
            item.writeToAll(PdfName.f19772T, new PdfString(substring, PdfObject.TEXT_UNICODE), 5);
            item.markUsed(this, 4);
            this.fields.remove(str);
            this.fields.put(substring, item);
            return true;
        }
        return false;
    }

    public static Object[] splitDAelements(String str) {
        try {
            PRTokeniser pRTokeniser = new PRTokeniser(PdfEncodings.convertToBytes(str, (String) null));
            ArrayList arrayList = new ArrayList();
            Object[] objArr = new Object[3];
            while (pRTokeniser.nextToken()) {
                if (pRTokeniser.getTokenType() != PRTokeniser.TokenType.COMMENT) {
                    if (pRTokeniser.getTokenType() == PRTokeniser.TokenType.OTHER) {
                        String stringValue = pRTokeniser.getStringValue();
                        if (stringValue.equals("Tf")) {
                            if (arrayList.size() >= 2) {
                                objArr[0] = arrayList.get(arrayList.size() - 2);
                                objArr[1] = new Float((String) arrayList.get(arrayList.size() - 1));
                            }
                        } else if (stringValue.equals("g")) {
                            if (arrayList.size() > 0) {
                                float floatValue = new Float((String) arrayList.get(arrayList.size() - 1)).floatValue();
                                if (floatValue != ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                                    objArr[2] = new GrayColor(floatValue);
                                }
                            }
                        } else if (stringValue.equals("rg")) {
                            if (arrayList.size() >= 3) {
                                objArr[2] = new BaseColor(new Float((String) arrayList.get(arrayList.size() - 3)).floatValue(), new Float((String) arrayList.get(arrayList.size() - 2)).floatValue(), new Float((String) arrayList.get(arrayList.size() - 1)).floatValue());
                            }
                        } else if (stringValue.equals("k") && arrayList.size() >= 4) {
                            objArr[2] = new CMYKColor(new Float((String) arrayList.get(arrayList.size() - 4)).floatValue(), new Float((String) arrayList.get(arrayList.size() - 3)).floatValue(), new Float((String) arrayList.get(arrayList.size() - 2)).floatValue(), new Float((String) arrayList.get(arrayList.size() - 1)).floatValue());
                        }
                        arrayList.clear();
                    } else {
                        arrayList.add(pRTokeniser.getStringValue());
                    }
                }
            }
            return objArr;
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public void decodeGenericDictionary(PdfDictionary pdfDictionary, BaseField baseField) throws IOException, DocumentException {
        PdfDictionary asDict;
        PdfDictionary asDict2;
        PdfDictionary asDict3;
        PdfString asString = pdfDictionary.getAsString(PdfName.f19700DA);
        if (asString != null) {
            Object[] splitDAelements = splitDAelements(asString.toUnicodeString());
            if (splitDAelements[1] != null) {
                baseField.setFontSize(((Float) splitDAelements[1]).floatValue());
            }
            if (splitDAelements[2] != null) {
                baseField.setTextColor((BaseColor) splitDAelements[2]);
            }
            if (splitDAelements[0] != null && (asDict = pdfDictionary.getAsDict(PdfName.f19706DR)) != null && (asDict2 = asDict.getAsDict(PdfName.FONT)) != null) {
                PdfObject pdfObject = asDict2.get(new PdfName((String) splitDAelements[0]));
                if (pdfObject != null && pdfObject.type() == 10) {
                    PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
                    baseField.setFont(new DocumentFont(pRIndirectReference));
                    Integer valueOf = Integer.valueOf(pRIndirectReference.getNumber());
                    BaseFont baseFont = this.extensionFonts.get(valueOf);
                    if (baseFont == null && !this.extensionFonts.containsKey(valueOf) && (asDict3 = ((PdfDictionary) PdfReader.getPdfObject(pdfObject)).getAsDict(PdfName.FONTDESCRIPTOR)) != null) {
                        PRStream pRStream = (PRStream) PdfReader.getPdfObject(asDict3.get(PdfName.FONTFILE2));
                        if (pRStream == null) {
                            pRStream = (PRStream) PdfReader.getPdfObject(asDict3.get(PdfName.FONTFILE3));
                        }
                        if (pRStream == null) {
                            this.extensionFonts.put(valueOf, null);
                        } else {
                            try {
                                baseFont = BaseFont.createFont("font.ttf", BaseFont.IDENTITY_H, true, false, PdfReader.getStreamBytes(pRStream), null);
                            } catch (Exception unused) {
                            }
                            this.extensionFonts.put(valueOf, baseFont);
                        }
                    }
                    if (baseField instanceof TextField) {
                        ((TextField) baseField).setExtensionFont(baseFont);
                    }
                } else {
                    BaseFont baseFont2 = this.localFonts.get(splitDAelements[0]);
                    if (baseFont2 == null) {
                        String[] strArr = stdFieldFontNames.get(splitDAelements[0]);
                        if (strArr != null) {
                            try {
                                baseField.setFont(BaseFont.createFont(strArr[0], strArr.length > 1 ? strArr[1] : "winansi", false));
                            } catch (Exception unused2) {
                            }
                        }
                    } else {
                        baseField.setFont(baseFont2);
                    }
                }
            }
        }
        PdfDictionary asDict4 = pdfDictionary.getAsDict(PdfName.f19738MK);
        if (asDict4 != null) {
            BaseColor mKColor = getMKColor(asDict4.getAsArray(PdfName.f19685BC));
            baseField.setBorderColor(mKColor);
            if (mKColor != null) {
                baseField.setBorderWidth(1.0f);
            }
            baseField.setBackgroundColor(getMKColor(asDict4.getAsArray(PdfName.f19686BG)));
            PdfNumber asNumber = asDict4.getAsNumber(PdfName.f19760R);
            if (asNumber != null) {
                baseField.setRotation(asNumber.intValue());
            }
        }
        PdfNumber asNumber2 = pdfDictionary.getAsNumber(PdfName.f19712F);
        baseField.setVisibility(2);
        if (asNumber2 != null) {
            int intValue = asNumber2.intValue();
            int i = intValue & 4;
            if (i != 0 && (intValue & 2) != 0) {
                baseField.setVisibility(1);
            } else if (i != 0 && (intValue & 32) != 0) {
                baseField.setVisibility(3);
            } else if (i != 0) {
                baseField.setVisibility(0);
            }
        }
        PdfNumber asNumber3 = pdfDictionary.getAsNumber(PdfName.f19715FF);
        int intValue2 = asNumber3 != null ? asNumber3.intValue() : 0;
        baseField.setOptions(intValue2);
        if ((intValue2 & 16777216) != 0) {
            PdfNumber asNumber4 = pdfDictionary.getAsNumber(PdfName.MAXLEN);
            baseField.setMaxCharacterLength(asNumber4 != null ? asNumber4.intValue() : 0);
        }
        PdfNumber asNumber5 = pdfDictionary.getAsNumber(PdfName.f19759Q);
        if (asNumber5 != null) {
            if (asNumber5.intValue() == 1) {
                baseField.setAlignment(1);
            } else if (asNumber5.intValue() == 2) {
                baseField.setAlignment(2);
            }
        }
        PdfDictionary asDict5 = pdfDictionary.getAsDict(PdfName.f19689BS);
        if (asDict5 != null) {
            PdfNumber asNumber6 = asDict5.getAsNumber(PdfName.f19791W);
            if (asNumber6 != null) {
                baseField.setBorderWidth(asNumber6.floatValue());
            }
            PdfName asName = asDict5.getAsName(PdfName.f19767S);
            if (PdfName.f19699D.equals(asName)) {
                baseField.setBorderStyle(1);
                return;
            } else if (PdfName.f19684B.equals(asName)) {
                baseField.setBorderStyle(2);
                return;
            } else if (PdfName.f19729I.equals(asName)) {
                baseField.setBorderStyle(3);
                return;
            } else if (PdfName.f19783U.equals(asName)) {
                baseField.setBorderStyle(4);
                return;
            } else {
                return;
            }
        }
        PdfArray asArray = pdfDictionary.getAsArray(PdfName.BORDER);
        if (asArray != null) {
            if (asArray.size() >= 3) {
                baseField.setBorderWidth(asArray.getAsNumber(2).floatValue());
            }
            if (asArray.size() >= 4) {
                baseField.setBorderStyle(1);
            }
        }
    }

    PdfAppearance getAppearance(PdfDictionary pdfDictionary, String[] strArr, String str) throws IOException, DocumentException {
        TextField textField;
        int i = 0;
        this.topFirst = 0;
        String str2 = strArr.length > 0 ? strArr[0] : null;
        Map<String, TextField> map = this.fieldCache;
        if (map == null || !map.containsKey(str)) {
            TextField textField2 = new TextField(this.writer, null, null);
            textField2.setExtraMargin(this.extraMarginLeft, this.extraMarginTop);
            textField2.setBorderWidth(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
            textField2.setSubstitutionFonts(this.substitutionFonts);
            decodeGenericDictionary(pdfDictionary, textField2);
            Rectangle normalizedRectangle = PdfReader.getNormalizedRectangle(pdfDictionary.getAsArray(PdfName.RECT));
            if (textField2.getRotation() == 90 || textField2.getRotation() == 270) {
                normalizedRectangle = normalizedRectangle.rotate();
            }
            textField2.setBox(normalizedRectangle);
            Map<String, TextField> map2 = this.fieldCache;
            if (map2 != null) {
                map2.put(str, textField2);
            }
            textField = textField2;
        } else {
            textField = this.fieldCache.get(str);
            textField.setWriter(this.writer);
        }
        PdfName asName = pdfDictionary.getAsName(PdfName.f19720FT);
        if (PdfName.f19782TX.equals(asName)) {
            if (strArr.length > 0 && strArr[0] != null) {
                textField.setText(strArr[0]);
            }
            return textField.getAppearance();
        } else if (!PdfName.f19695CH.equals(asName)) {
            throw new DocumentException(MessageLocalization.getComposedMessage("an.appearance.was.requested.without.a.variable.text.field", new Object[0]));
        } else {
            PdfArray asArray = pdfDictionary.getAsArray(PdfName.OPT);
            PdfNumber asNumber = pdfDictionary.getAsNumber(PdfName.f19715FF);
            int intValue = (asNumber != null ? asNumber.intValue() : 0) & 131072;
            if (intValue != 0 && asArray == null) {
                textField.setText(str2);
                return textField.getAppearance();
            }
            if (asArray != null) {
                String[] strArr2 = new String[asArray.size()];
                String[] strArr3 = new String[asArray.size()];
                for (int i2 = 0; i2 < asArray.size(); i2++) {
                    PdfObject pdfObject = asArray.getPdfObject(i2);
                    if (pdfObject.isString()) {
                        String unicodeString = ((PdfString) pdfObject).toUnicodeString();
                        strArr3[i2] = unicodeString;
                        strArr2[i2] = unicodeString;
                    } else {
                        PdfArray pdfArray = (PdfArray) pdfObject;
                        strArr3[i2] = pdfArray.getAsString(0).toUnicodeString();
                        strArr2[i2] = pdfArray.getAsString(1).toUnicodeString();
                    }
                }
                if (intValue != 0) {
                    while (true) {
                        if (i >= strArr2.length) {
                            break;
                        } else if (str2.equals(strArr3[i])) {
                            str2 = strArr2[i];
                            break;
                        } else {
                            i++;
                        }
                    }
                    textField.setText(str2);
                    return textField.getAppearance();
                }
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < strArr3.length; i3++) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= strArr.length) {
                            break;
                        }
                        String str3 = strArr[i4];
                        if (str3 != null && str3.equals(strArr3[i3])) {
                            arrayList.add(Integer.valueOf(i3));
                            break;
                        }
                        i4++;
                    }
                }
                textField.setChoices(strArr2);
                textField.setChoiceExports(strArr3);
                textField.setChoiceSelections(arrayList);
            }
            PdfAppearance listAppearance = textField.getListAppearance();
            this.topFirst = textField.getTopFirst();
            return listAppearance;
        }
    }

    PdfAppearance getAppearance(PdfDictionary pdfDictionary, String str, String str2) throws IOException, DocumentException {
        return getAppearance(pdfDictionary, new String[]{str}, str2);
    }

    BaseColor getMKColor(PdfArray pdfArray) {
        if (pdfArray == null) {
            return null;
        }
        int size = pdfArray.size();
        if (size == 1) {
            return new GrayColor(pdfArray.getAsNumber(0).floatValue());
        }
        switch (size) {
            case 3:
                return new BaseColor(ExtendedColor.normalize(pdfArray.getAsNumber(0).floatValue()), ExtendedColor.normalize(pdfArray.getAsNumber(1).floatValue()), ExtendedColor.normalize(pdfArray.getAsNumber(2).floatValue()));
            case 4:
                return new CMYKColor(pdfArray.getAsNumber(0).floatValue(), pdfArray.getAsNumber(1).floatValue(), pdfArray.getAsNumber(2).floatValue(), pdfArray.getAsNumber(3).floatValue());
            default:
                return null;
        }
    }

    public String getFieldRichValue(String str) {
        Item item;
        PdfString asString;
        if (this.xfa.isXfaPresent() || (item = this.fields.get(str)) == null || (asString = item.getMerged(0).getAsString(PdfName.f19766RV)) == null) {
            return null;
        }
        return asString.toString();
    }

    public String getField(String str) {
        if (this.xfa.isXfaPresent()) {
            String findFieldName = this.xfa.findFieldName(str, this);
            if (findFieldName == null) {
                return null;
            }
            return XfaForm.getNodeText(this.xfa.findDatasetsNode(XfaForm.Xml2Som.getShortName(findFieldName)));
        }
        Item item = this.fields.get(str);
        if (item == null) {
            return null;
        }
        this.lastWasString = false;
        PdfDictionary merged = item.getMerged(0);
        PdfObject pdfObject = PdfReader.getPdfObject(merged.get(PdfName.f19787V));
        if (pdfObject == null) {
            return "";
        }
        if (pdfObject instanceof PRStream) {
            try {
                return new String(PdfReader.getStreamBytes((PRStream) pdfObject));
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }
        if (PdfName.BTN.equals(merged.getAsName(PdfName.f19720FT))) {
            PdfNumber asNumber = merged.getAsNumber(PdfName.f19715FF);
            if (((asNumber != null ? asNumber.intValue() : 0) & 65536) != 0) {
                return "";
            }
            String str2 = "";
            if (pdfObject instanceof PdfName) {
                str2 = PdfName.decodeName(pdfObject.toString());
            } else if (pdfObject instanceof PdfString) {
                str2 = ((PdfString) pdfObject).toUnicodeString();
            }
            PdfArray asArray = item.getValue(0).getAsArray(PdfName.OPT);
            if (asArray != null) {
                try {
                    str2 = asArray.getAsString(Integer.parseInt(str2)).toUnicodeString();
                    this.lastWasString = true;
                    return str2;
                } catch (Exception unused) {
                    return str2;
                }
            }
            return str2;
        } else if (!(pdfObject instanceof PdfString)) {
            return pdfObject instanceof PdfName ? PdfName.decodeName(pdfObject.toString()) : "";
        } else {
            this.lastWasString = true;
            return ((PdfString) pdfObject).toUnicodeString();
        }
    }

    public String[] getListSelection(String str) {
        PdfArray asArray;
        String field = getField(str);
        int i = 0;
        String[] strArr = field == null ? new String[0] : new String[]{field};
        Item item = this.fields.get(str);
        if (item == null || (asArray = item.getMerged(0).getAsArray(PdfName.f19729I)) == null) {
            return strArr;
        }
        String[] strArr2 = new String[asArray.size()];
        String[] listOptionExport = getListOptionExport(str);
        ListIterator<PdfObject> listIterator = asArray.listIterator();
        while (listIterator.hasNext()) {
            strArr2[i] = listOptionExport[((PdfNumber) listIterator.next()).intValue()];
            i++;
        }
        return strArr2;
    }

    public boolean setFieldProperty(String str, String str2, Object obj, int[] iArr) {
        PdfString asString;
        PdfString asString2;
        FontDetails addSimple;
        if (this.writer == null) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("this.acrofields.instance.is.read.only", new Object[0]));
        }
        try {
            Item item = this.fields.get(str);
            if (item == null) {
                return false;
            }
            InstHit instHit = new InstHit(iArr);
            if (str2.equalsIgnoreCase("textfont")) {
                for (int i = 0; i < item.size(); i++) {
                    if (instHit.isHit(i)) {
                        PdfDictionary merged = item.getMerged(i);
                        PdfString asString3 = merged.getAsString(PdfName.f19700DA);
                        PdfDictionary asDict = merged.getAsDict(PdfName.f19706DR);
                        if (asString3 != null && asDict != null) {
                            Object[] splitDAelements = splitDAelements(asString3.toUnicodeString());
                            PdfAppearance pdfAppearance = new PdfAppearance();
                            if (splitDAelements[0] != null) {
                                BaseFont baseFont = (BaseFont) obj;
                                PdfName pdfName = PdfAppearance.stdFieldFontNames.get(baseFont.getPostscriptFontName());
                                if (pdfName == null) {
                                    pdfName = new PdfName(baseFont.getPostscriptFontName());
                                }
                                PdfDictionary asDict2 = asDict.getAsDict(PdfName.FONT);
                                if (asDict2 == null) {
                                    asDict2 = new PdfDictionary();
                                    asDict.put(PdfName.FONT, asDict2);
                                }
                                PdfIndirectReference pdfIndirectReference = (PdfIndirectReference) asDict2.get(pdfName);
                                PdfDictionary asDict3 = this.reader.getCatalog().getAsDict(PdfName.ACROFORM);
                                markUsed(asDict3);
                                PdfDictionary asDict4 = asDict3.getAsDict(PdfName.f19706DR);
                                if (asDict4 == null) {
                                    asDict4 = new PdfDictionary();
                                    asDict3.put(PdfName.f19706DR, asDict4);
                                }
                                markUsed(asDict4);
                                PdfDictionary asDict5 = asDict4.getAsDict(PdfName.FONT);
                                if (asDict5 == null) {
                                    asDict5 = new PdfDictionary();
                                    asDict4.put(PdfName.FONT, asDict5);
                                }
                                markUsed(asDict5);
                                PdfIndirectReference pdfIndirectReference2 = (PdfIndirectReference) asDict5.get(pdfName);
                                if (pdfIndirectReference2 != null) {
                                    if (pdfIndirectReference == null) {
                                        asDict2.put(pdfName, pdfIndirectReference2);
                                    }
                                } else if (pdfIndirectReference == null) {
                                    if (baseFont.getFontType() == 4) {
                                        addSimple = new FontDetails(null, ((DocumentFont) baseFont).getIndirectReference(), baseFont);
                                    } else {
                                        baseFont.setSubset(false);
                                        addSimple = this.writer.addSimple(baseFont);
                                        this.localFonts.put(pdfName.toString().substring(1), baseFont);
                                    }
                                    asDict5.put(pdfName, addSimple.getIndirectReference());
                                    asDict2.put(pdfName, addSimple.getIndirectReference());
                                }
                                pdfAppearance.getInternalBuffer().append(pdfName.getBytes()).append(TokenParser.f24154SP).append(((Float) splitDAelements[1]).floatValue()).append(" Tf ");
                                if (splitDAelements[2] != null) {
                                    pdfAppearance.setColorFill((BaseColor) splitDAelements[2]);
                                }
                                PdfString pdfString = new PdfString(pdfAppearance.toString());
                                item.getMerged(i).put(PdfName.f19700DA, pdfString);
                                item.getWidget(i).put(PdfName.f19700DA, pdfString);
                                markUsed(item.getWidget(i));
                            }
                        }
                    }
                }
            } else if (str2.equalsIgnoreCase("textcolor")) {
                for (int i2 = 0; i2 < item.size(); i2++) {
                    if (instHit.isHit(i2) && (asString2 = item.getMerged(i2).getAsString(PdfName.f19700DA)) != null) {
                        Object[] splitDAelements2 = splitDAelements(asString2.toUnicodeString());
                        PdfAppearance pdfAppearance2 = new PdfAppearance();
                        if (splitDAelements2[0] != null) {
                            pdfAppearance2.getInternalBuffer().append(new PdfName((String) splitDAelements2[0]).getBytes()).append(TokenParser.f24154SP).append(((Float) splitDAelements2[1]).floatValue()).append(" Tf ");
                            pdfAppearance2.setColorFill((BaseColor) obj);
                            PdfString pdfString2 = new PdfString(pdfAppearance2.toString());
                            item.getMerged(i2).put(PdfName.f19700DA, pdfString2);
                            item.getWidget(i2).put(PdfName.f19700DA, pdfString2);
                            markUsed(item.getWidget(i2));
                        }
                    }
                }
            } else if (str2.equalsIgnoreCase("textsize")) {
                for (int i3 = 0; i3 < item.size(); i3++) {
                    if (instHit.isHit(i3) && (asString = item.getMerged(i3).getAsString(PdfName.f19700DA)) != null) {
                        Object[] splitDAelements3 = splitDAelements(asString.toUnicodeString());
                        PdfAppearance pdfAppearance3 = new PdfAppearance();
                        if (splitDAelements3[0] != null) {
                            pdfAppearance3.getInternalBuffer().append(new PdfName((String) splitDAelements3[0]).getBytes()).append(TokenParser.f24154SP).append(((Float) obj).floatValue()).append(" Tf ");
                            if (splitDAelements3[2] != null) {
                                pdfAppearance3.setColorFill((BaseColor) splitDAelements3[2]);
                            }
                            PdfString pdfString3 = new PdfString(pdfAppearance3.toString());
                            item.getMerged(i3).put(PdfName.f19700DA, pdfString3);
                            item.getWidget(i3).put(PdfName.f19700DA, pdfString3);
                            markUsed(item.getWidget(i3));
                        }
                    }
                }
            } else {
                if (!str2.equalsIgnoreCase(HtmlTags.BGCOLOR) && !str2.equalsIgnoreCase("bordercolor")) {
                    return false;
                }
                PdfName pdfName2 = str2.equalsIgnoreCase(HtmlTags.BGCOLOR) ? PdfName.f19686BG : PdfName.f19685BC;
                for (int i4 = 0; i4 < item.size(); i4++) {
                    if (instHit.isHit(i4)) {
                        PdfDictionary asDict6 = item.getMerged(i4).getAsDict(PdfName.f19738MK);
                        if (asDict6 != null) {
                            markUsed(asDict6);
                        } else if (obj == null) {
                            return true;
                        } else {
                            asDict6 = new PdfDictionary();
                            item.getMerged(i4).put(PdfName.f19738MK, asDict6);
                            item.getWidget(i4).put(PdfName.f19738MK, asDict6);
                            markUsed(item.getWidget(i4));
                        }
                        if (obj == null) {
                            asDict6.remove(pdfName2);
                        } else {
                            asDict6.put(pdfName2, PdfFormField.getMKColor((BaseColor) obj));
                        }
                    }
                }
            }
            return true;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean setFieldProperty(String str, String str2, int i, int[] iArr) {
        int i2 = 0;
        if (this.writer == null) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("this.acrofields.instance.is.read.only", new Object[0]));
        }
        Item item = this.fields.get(str);
        if (item == null) {
            return false;
        }
        InstHit instHit = new InstHit(iArr);
        if (str2.equalsIgnoreCase("flags")) {
            PdfNumber pdfNumber = new PdfNumber(i);
            while (i2 < item.size()) {
                if (instHit.isHit(i2)) {
                    item.getMerged(i2).put(PdfName.f19712F, pdfNumber);
                    item.getWidget(i2).put(PdfName.f19712F, pdfNumber);
                    markUsed(item.getWidget(i2));
                }
                i2++;
            }
            return true;
        } else if (str2.equalsIgnoreCase("setflags")) {
            for (int i3 = 0; i3 < item.size(); i3++) {
                if (instHit.isHit(i3)) {
                    PdfNumber asNumber = item.getWidget(i3).getAsNumber(PdfName.f19712F);
                    PdfNumber pdfNumber2 = new PdfNumber((asNumber != null ? asNumber.intValue() : 0) | i);
                    item.getMerged(i3).put(PdfName.f19712F, pdfNumber2);
                    item.getWidget(i3).put(PdfName.f19712F, pdfNumber2);
                    markUsed(item.getWidget(i3));
                }
            }
            return true;
        } else if (str2.equalsIgnoreCase("clrflags")) {
            for (int i4 = 0; i4 < item.size(); i4++) {
                if (instHit.isHit(i4)) {
                    PdfDictionary widget = item.getWidget(i4);
                    PdfNumber asNumber2 = widget.getAsNumber(PdfName.f19712F);
                    PdfNumber pdfNumber3 = new PdfNumber((asNumber2 != null ? asNumber2.intValue() : 0) & (i ^ (-1)));
                    item.getMerged(i4).put(PdfName.f19712F, pdfNumber3);
                    widget.put(PdfName.f19712F, pdfNumber3);
                    markUsed(widget);
                }
            }
            return true;
        } else if (str2.equalsIgnoreCase("fflags")) {
            PdfNumber pdfNumber4 = new PdfNumber(i);
            while (i2 < item.size()) {
                if (instHit.isHit(i2)) {
                    item.getMerged(i2).put(PdfName.f19715FF, pdfNumber4);
                    item.getValue(i2).put(PdfName.f19715FF, pdfNumber4);
                    markUsed(item.getValue(i2));
                }
                i2++;
            }
            return true;
        } else if (str2.equalsIgnoreCase("setfflags")) {
            for (int i5 = 0; i5 < item.size(); i5++) {
                if (instHit.isHit(i5)) {
                    PdfDictionary value = item.getValue(i5);
                    PdfNumber asNumber3 = value.getAsNumber(PdfName.f19715FF);
                    PdfNumber pdfNumber5 = new PdfNumber((asNumber3 != null ? asNumber3.intValue() : 0) | i);
                    item.getMerged(i5).put(PdfName.f19715FF, pdfNumber5);
                    value.put(PdfName.f19715FF, pdfNumber5);
                    markUsed(value);
                }
            }
            return true;
        } else if (str2.equalsIgnoreCase("clrfflags")) {
            for (int i6 = 0; i6 < item.size(); i6++) {
                if (instHit.isHit(i6)) {
                    PdfDictionary value2 = item.getValue(i6);
                    PdfNumber asNumber4 = value2.getAsNumber(PdfName.f19715FF);
                    PdfNumber pdfNumber6 = new PdfNumber((asNumber4 != null ? asNumber4.intValue() : 0) & (i ^ (-1)));
                    item.getMerged(i6).put(PdfName.f19715FF, pdfNumber6);
                    value2.put(PdfName.f19715FF, pdfNumber6);
                    markUsed(value2);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public void mergeXfaData(Node node) throws IOException, DocumentException {
        XfaForm.Xml2SomDatasets xml2SomDatasets = new XfaForm.Xml2SomDatasets(node);
        Iterator<String> it = xml2SomDatasets.getOrder().iterator();
        while (it.hasNext()) {
            String next = it.next();
            setField(next, XfaForm.getNodeText(xml2SomDatasets.getName2Node().get(next)));
        }
    }

    public void setFields(FdfReader fdfReader) throws IOException, DocumentException {
        for (String str : fdfReader.getFields().keySet()) {
            String fieldValue = fdfReader.getFieldValue(str);
            if (fieldValue != null) {
                setField(str, fieldValue);
            }
        }
    }

    public void setFields(XfdfReader xfdfReader) throws IOException, DocumentException {
        for (String str : xfdfReader.getFields().keySet()) {
            String fieldValue = xfdfReader.getFieldValue(str);
            if (fieldValue != null) {
                setField(str, fieldValue);
            }
            List<String> listValues = xfdfReader.getListValues(str);
            if (listValues != null) {
                setListSelection(fieldValue, (String[]) listValues.toArray(new String[listValues.size()]));
            }
        }
    }

    public boolean regenerateField(String str) throws IOException, DocumentException {
        String field = getField(str);
        return setField(str, field, field);
    }

    public boolean setField(String str, String str2) throws IOException, DocumentException {
        return setField(str, str2, null);
    }

    public boolean setFieldRichValue(String str, String str2) throws DocumentException, IOException {
        if (this.writer == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("this.acrofields.instance.is.read.only", new Object[0]));
        }
        Item fieldItem = getFieldItem(str);
        if (fieldItem != null && getFieldType(str) == 4) {
            PdfNumber asNumber = fieldItem.getMerged(0).getAsNumber(PdfName.f19715FF);
            if (((asNumber != null ? asNumber.intValue() : 0) | 67108864) == 0) {
                return false;
            }
            fieldItem.writeToAll(PdfName.f19766RV, new PdfString(str2), 5);
            fieldItem.writeToAll(PdfName.f19787V, new PdfString(XmlToTxt.parse(new ByteArrayInputStream(str2.getBytes()))), 5);
            return true;
        }
        return false;
    }

    public boolean setField(String str, String str2, String str3) throws IOException, DocumentException {
        int i = 0;
        if (this.writer == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("this.acrofields.instance.is.read.only", new Object[0]));
        }
        if (this.xfa.isXfaPresent()) {
            str = this.xfa.findFieldName(str, this);
            if (str == null) {
                return false;
            }
            String shortName = XfaForm.Xml2Som.getShortName(str);
            Node findDatasetsNode = this.xfa.findDatasetsNode(shortName);
            if (findDatasetsNode == null) {
                findDatasetsNode = this.xfa.getDatasetsSom().insertNode(this.xfa.getDatasetsNode(), shortName);
            }
            this.xfa.setNodeText(findDatasetsNode, str2);
        }
        Item item = this.fields.get(str);
        if (item == null) {
            return false;
        }
        PdfDictionary merged = item.getMerged(0);
        PdfName asName = merged.getAsName(PdfName.f19720FT);
        if (PdfName.f19782TX.equals(asName)) {
            PdfNumber asNumber = merged.getAsNumber(PdfName.MAXLEN);
            int intValue = asNumber != null ? asNumber.intValue() : 0;
            if (intValue > 0) {
                str2 = str2.substring(0, Math.min(intValue, str2.length()));
            }
        }
        if (str3 == null) {
            str3 = str2;
        }
        if (PdfName.f19782TX.equals(asName) || PdfName.f19695CH.equals(asName)) {
            PdfObject pdfString = new PdfString(str2, PdfObject.TEXT_UNICODE);
            while (i < item.size()) {
                PdfDictionary value = item.getValue(i);
                value.put(PdfName.f19787V, pdfString);
                value.remove(PdfName.f19729I);
                markUsed(value);
                PdfDictionary merged2 = item.getMerged(i);
                merged2.remove(PdfName.f19729I);
                merged2.put(PdfName.f19787V, pdfString);
                PdfDictionary widget = item.getWidget(i);
                if (this.generateAppearances) {
                    PdfAppearance appearance = getAppearance(merged2, str3, str);
                    if (PdfName.f19695CH.equals(asName)) {
                        PdfObject pdfNumber = new PdfNumber(this.topFirst);
                        widget.put(PdfName.f19776TI, pdfNumber);
                        merged2.put(PdfName.f19776TI, pdfNumber);
                    }
                    PdfDictionary asDict = widget.getAsDict(PdfName.f19682AP);
                    if (asDict == null) {
                        asDict = new PdfDictionary();
                        widget.put(PdfName.f19682AP, asDict);
                        merged2.put(PdfName.f19682AP, asDict);
                    }
                    asDict.put(PdfName.f19739N, appearance.getIndirectReference());
                    this.writer.releaseTemplate(appearance);
                } else {
                    widget.remove(PdfName.f19682AP);
                    merged2.remove(PdfName.f19682AP);
                }
                markUsed(widget);
                i++;
            }
            return true;
        } else if (PdfName.BTN.equals(asName)) {
            PdfNumber asNumber2 = item.getMerged(0).getAsNumber(PdfName.f19715FF);
            if (((asNumber2 != null ? asNumber2.intValue() : 0) & 65536) != 0) {
                try {
                    Image image = Image.getInstance(Base64.decode(str2));
                    PushbuttonField newPushbuttonFromField = getNewPushbuttonFromField(str);
                    newPushbuttonFromField.setImage(image);
                    replacePushbuttonField(str, newPushbuttonFromField.getField());
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            PdfName pdfName = new PdfName(str2);
            ArrayList arrayList = new ArrayList();
            PdfArray asArray = item.getValue(0).getAsArray(PdfName.OPT);
            if (asArray != null) {
                for (int i2 = 0; i2 < asArray.size(); i2++) {
                    PdfString asString = asArray.getAsString(i2);
                    if (asString != null) {
                        arrayList.add(asString.toUnicodeString());
                    } else {
                        arrayList.add(null);
                    }
                }
            }
            int indexOf = arrayList.indexOf(str2);
            if (indexOf >= 0) {
                pdfName = new PdfName(String.valueOf(indexOf));
            }
            while (i < item.size()) {
                PdfDictionary merged3 = item.getMerged(i);
                PdfDictionary widget2 = item.getWidget(i);
                PdfDictionary value2 = item.getValue(i);
                markUsed(item.getValue(i));
                value2.put(PdfName.f19787V, pdfName);
                merged3.put(PdfName.f19787V, pdfName);
                markUsed(widget2);
                if (isInAP(widget2, pdfName)) {
                    merged3.put(PdfName.f19683AS, pdfName);
                    widget2.put(PdfName.f19683AS, pdfName);
                } else {
                    merged3.put(PdfName.f19683AS, PdfName.Off);
                    widget2.put(PdfName.f19683AS, PdfName.Off);
                }
                i++;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean setListSelection(String str, String[] strArr) throws IOException, DocumentException {
        Item fieldItem = getFieldItem(str);
        if (fieldItem == null) {
            return false;
        }
        PdfDictionary merged = fieldItem.getMerged(0);
        if (PdfName.f19695CH.equals(merged.getAsName(PdfName.f19720FT))) {
            String[] listOptionExport = getListOptionExport(str);
            PdfArray pdfArray = new PdfArray();
            for (String str2 : strArr) {
                int i = 0;
                while (true) {
                    if (i >= listOptionExport.length) {
                        break;
                    } else if (listOptionExport[i].equals(str2)) {
                        pdfArray.add(new PdfNumber(i));
                        break;
                    } else {
                        i++;
                    }
                }
            }
            fieldItem.writeToAll(PdfName.f19729I, pdfArray, 5);
            PdfArray pdfArray2 = new PdfArray();
            for (String str3 : strArr) {
                pdfArray2.add(new PdfString(str3));
            }
            fieldItem.writeToAll(PdfName.f19787V, pdfArray2, 5);
            PdfAppearance appearance = getAppearance(merged, strArr, str);
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.put(PdfName.f19739N, appearance.getIndirectReference());
            fieldItem.writeToAll(PdfName.f19682AP, pdfDictionary, 3);
            this.writer.releaseTemplate(appearance);
            fieldItem.markUsed(this, 6);
            return true;
        }
        return false;
    }

    boolean isInAP(PdfDictionary pdfDictionary, PdfName pdfName) {
        PdfDictionary asDict;
        PdfDictionary asDict2 = pdfDictionary.getAsDict(PdfName.f19682AP);
        return (asDict2 == null || (asDict = asDict2.getAsDict(PdfName.f19739N)) == null || asDict.get(pdfName) == null) ? false : true;
    }

    public Map<String, Item> getFields() {
        return this.fields;
    }

    public Item getFieldItem(String str) {
        if (this.xfa.isXfaPresent() && (str = this.xfa.findFieldName(str, this)) == null) {
            return null;
        }
        return this.fields.get(str);
    }

    public String getTranslatedFieldName(String str) {
        String findFieldName;
        return (!this.xfa.isXfaPresent() || (findFieldName = this.xfa.findFieldName(str, this)) == null) ? str : findFieldName;
    }

    public List<FieldPosition> getFieldPositions(String str) {
        Item fieldItem = getFieldItem(str);
        if (fieldItem == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < fieldItem.size(); i++) {
            try {
                PdfArray asArray = fieldItem.getWidget(i).getAsArray(PdfName.RECT);
                if (asArray != null) {
                    Rectangle normalizedRectangle = PdfReader.getNormalizedRectangle(asArray);
                    int intValue = fieldItem.getPage(i).intValue();
                    int pageRotation = this.reader.getPageRotation(intValue);
                    FieldPosition fieldPosition = new FieldPosition();
                    fieldPosition.page = intValue;
                    if (pageRotation != 0) {
                        Rectangle pageSize = this.reader.getPageSize(intValue);
                        if (pageRotation == 90) {
                            normalizedRectangle = new Rectangle(normalizedRectangle.getBottom(), pageSize.getRight() - normalizedRectangle.getLeft(), normalizedRectangle.getTop(), pageSize.getRight() - normalizedRectangle.getRight());
                        } else if (pageRotation == 180) {
                            normalizedRectangle = new Rectangle(pageSize.getRight() - normalizedRectangle.getLeft(), pageSize.getTop() - normalizedRectangle.getBottom(), pageSize.getRight() - normalizedRectangle.getRight(), pageSize.getTop() - normalizedRectangle.getTop());
                        } else if (pageRotation == 270) {
                            normalizedRectangle = new Rectangle(pageSize.getTop() - normalizedRectangle.getBottom(), normalizedRectangle.getLeft(), pageSize.getTop() - normalizedRectangle.getTop(), normalizedRectangle.getRight());
                        }
                        normalizedRectangle.normalize();
                    }
                    fieldPosition.position = normalizedRectangle;
                    arrayList.add(fieldPosition);
                }
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    private int removeRefFromArray(PdfArray pdfArray, PdfObject pdfObject) {
        if (pdfObject == null || !pdfObject.isIndirect()) {
            return pdfArray.size();
        }
        PdfIndirectReference pdfIndirectReference = (PdfIndirectReference) pdfObject;
        int i = 0;
        while (i < pdfArray.size()) {
            PdfObject pdfObject2 = pdfArray.getPdfObject(i);
            if (pdfObject2.isIndirect() && ((PdfIndirectReference) pdfObject2).getNumber() == pdfIndirectReference.getNumber()) {
                pdfArray.remove(i);
                i--;
            }
            i++;
        }
        return pdfArray.size();
    }

    public boolean removeFieldsFromPage(int i) {
        if (i <= 0) {
            return false;
        }
        String[] strArr = new String[this.fields.size()];
        this.fields.keySet().toArray(strArr);
        boolean z = false;
        for (String str : strArr) {
            z = z || removeField(str, i);
        }
        return z;
    }

    public boolean removeField(String str, int i) {
        PdfDictionary pdfDictionary;
        PdfArray asArray;
        PdfIndirectReference asIndirectObject;
        Item fieldItem = getFieldItem(str);
        int i2 = 0;
        if (fieldItem == null || (pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(this.reader.getCatalog().get(PdfName.ACROFORM), this.reader.getCatalog())) == null || (asArray = pdfDictionary.getAsArray(PdfName.FIELDS)) == null) {
            return false;
        }
        while (i2 < fieldItem.size()) {
            int intValue = fieldItem.getPage(i2).intValue();
            if (i == -1 || i == intValue) {
                PdfIndirectReference widgetRef = fieldItem.getWidgetRef(i2);
                PdfDictionary widget = fieldItem.getWidget(i2);
                PdfDictionary pageN = this.reader.getPageN(intValue);
                PdfArray asArray2 = pageN.getAsArray(PdfName.ANNOTS);
                if (asArray2 != null) {
                    if (removeRefFromArray(asArray2, widgetRef) == 0) {
                        pageN.remove(PdfName.ANNOTS);
                        markUsed(pageN);
                    } else {
                        markUsed(asArray2);
                    }
                }
                PdfReader.killIndirect(widgetRef);
                while (true) {
                    asIndirectObject = widget.getAsIndirectObject(PdfName.PARENT);
                    if (asIndirectObject == null) {
                        break;
                    }
                    widget = widget.getAsDict(PdfName.PARENT);
                    if (removeRefFromArray(widget.getAsArray(PdfName.KIDS), widgetRef) != 0) {
                        break;
                    }
                    PdfReader.killIndirect(asIndirectObject);
                    widgetRef = asIndirectObject;
                }
                if (asIndirectObject == null) {
                    removeRefFromArray(asArray, widgetRef);
                    markUsed(asArray);
                }
                if (i != -1) {
                    fieldItem.remove(i2);
                    i2--;
                }
            }
            i2++;
        }
        if (i == -1 || fieldItem.size() == 0) {
            this.fields.remove(str);
        }
        return true;
    }

    public boolean removeField(String str) {
        return removeField(str, -1);
    }

    public boolean isGenerateAppearances() {
        return this.generateAppearances;
    }

    public void setGenerateAppearances(boolean z) {
        this.generateAppearances = z;
        PdfDictionary asDict = this.reader.getCatalog().getAsDict(PdfName.ACROFORM);
        if (z) {
            asDict.remove(PdfName.NEEDAPPEARANCES);
        } else {
            asDict.put(PdfName.NEEDAPPEARANCES, PdfBoolean.PDFTRUE);
        }
    }

    /* loaded from: classes.dex */
    public static class Item {
        public static final int WRITE_MERGED = 1;
        public static final int WRITE_VALUE = 4;
        public static final int WRITE_WIDGET = 2;
        protected ArrayList<PdfDictionary> values = new ArrayList<>();
        protected ArrayList<PdfDictionary> widgets = new ArrayList<>();
        protected ArrayList<PdfIndirectReference> widget_refs = new ArrayList<>();
        protected ArrayList<PdfDictionary> merged = new ArrayList<>();
        protected ArrayList<Integer> page = new ArrayList<>();
        protected ArrayList<Integer> tabOrder = new ArrayList<>();

        public void writeToAll(PdfName pdfName, PdfObject pdfObject, int i) {
            if ((i & 1) != 0) {
                for (int i2 = 0; i2 < this.merged.size(); i2++) {
                    getMerged(i2).put(pdfName, pdfObject);
                }
            }
            if ((i & 2) != 0) {
                for (int i3 = 0; i3 < this.widgets.size(); i3++) {
                    getWidget(i3).put(pdfName, pdfObject);
                }
            }
            if ((i & 4) != 0) {
                for (int i4 = 0; i4 < this.values.size(); i4++) {
                    getValue(i4).put(pdfName, pdfObject);
                }
            }
        }

        public void markUsed(AcroFields acroFields, int i) {
            if ((i & 4) != 0) {
                for (int i2 = 0; i2 < size(); i2++) {
                    acroFields.markUsed(getValue(i2));
                }
            }
            if ((i & 2) != 0) {
                for (int i3 = 0; i3 < size(); i3++) {
                    acroFields.markUsed(getWidget(i3));
                }
            }
        }

        public int size() {
            return this.values.size();
        }

        void remove(int i) {
            this.values.remove(i);
            this.widgets.remove(i);
            this.widget_refs.remove(i);
            this.merged.remove(i);
            this.page.remove(i);
            this.tabOrder.remove(i);
        }

        public PdfDictionary getValue(int i) {
            return this.values.get(i);
        }

        void addValue(PdfDictionary pdfDictionary) {
            this.values.add(pdfDictionary);
        }

        public PdfDictionary getWidget(int i) {
            return this.widgets.get(i);
        }

        void addWidget(PdfDictionary pdfDictionary) {
            this.widgets.add(pdfDictionary);
        }

        public PdfIndirectReference getWidgetRef(int i) {
            return this.widget_refs.get(i);
        }

        void addWidgetRef(PdfIndirectReference pdfIndirectReference) {
            this.widget_refs.add(pdfIndirectReference);
        }

        public PdfDictionary getMerged(int i) {
            return this.merged.get(i);
        }

        void addMerged(PdfDictionary pdfDictionary) {
            this.merged.add(pdfDictionary);
        }

        public Integer getPage(int i) {
            return this.page.get(i);
        }

        void addPage(int i) {
            this.page.add(Integer.valueOf(i));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void forcePage(int i, int i2) {
            this.page.set(i, Integer.valueOf(i2));
        }

        public Integer getTabOrder(int i) {
            return this.tabOrder.get(i);
        }

        void addTabOrder(int i) {
            this.tabOrder.add(Integer.valueOf(i));
        }
    }

    /* loaded from: classes.dex */
    static class InstHit {
        IntHashtable hits;

        public InstHit(int[] iArr) {
            if (iArr == null) {
                return;
            }
            this.hits = new IntHashtable();
            for (int i : iArr) {
                this.hits.put(i, 1);
            }
        }

        public boolean isHit(int i) {
            IntHashtable intHashtable = this.hits;
            if (intHashtable == null) {
                return true;
            }
            return intHashtable.containsKey(i);
        }
    }

    public boolean clearSignatureField(String str) {
        this.sigNames = null;
        getSignatureNames();
        if (this.sigNames.containsKey(str)) {
            Item item = this.fields.get(str);
            item.markUsed(this, 6);
            int size = item.size();
            for (int i = 0; i < size; i++) {
                clearSigDic(item.getMerged(i));
                clearSigDic(item.getWidget(i));
                clearSigDic(item.getValue(i));
            }
            return true;
        }
        return false;
    }

    private static void clearSigDic(PdfDictionary pdfDictionary) {
        pdfDictionary.remove(PdfName.f19682AP);
        pdfDictionary.remove(PdfName.f19683AS);
        pdfDictionary.remove(PdfName.f19787V);
        pdfDictionary.remove(PdfName.f19708DV);
        pdfDictionary.remove(PdfName.f19770SV);
        pdfDictionary.remove(PdfName.f19715FF);
        pdfDictionary.put(PdfName.f19712F, new PdfNumber(4));
    }

    public ArrayList<String> getSignatureNames() {
        PdfDictionary asDict;
        PdfArray asArray;
        int size;
        if (this.sigNames != null) {
            return new ArrayList<>(this.orderedSignatureNames);
        }
        this.sigNames = new HashMap<>();
        this.orderedSignatureNames = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Item> entry : this.fields.entrySet()) {
            PdfDictionary merged = entry.getValue().getMerged(0);
            if (PdfName.SIG.equals(merged.get(PdfName.f19720FT)) && (asDict = merged.getAsDict(PdfName.f19787V)) != null && asDict.getAsString(PdfName.CONTENTS) != null && (asArray = asDict.getAsArray(PdfName.BYTERANGE)) != null && (size = asArray.size()) >= 2) {
                arrayList.add(new Object[]{entry.getKey(), new int[]{asArray.getAsNumber(size - 1).intValue() + asArray.getAsNumber(size - 2).intValue(), 0}});
            }
        }
        Collections.sort(arrayList, new SorterComparator(null));
        if (!arrayList.isEmpty()) {
            if (((int[]) ((Object[]) arrayList.get(arrayList.size() - 1))[1])[0] == this.reader.getFileLength()) {
                this.totalRevisions = arrayList.size();
            } else {
                this.totalRevisions = arrayList.size() + 1;
            }
            int i = 0;
            while (i < arrayList.size()) {
                Object[] objArr = (Object[]) arrayList.get(i);
                String str = (String) objArr[0];
                int[] iArr = (int[]) objArr[1];
                i++;
                iArr[1] = i;
                this.sigNames.put(str, iArr);
                this.orderedSignatureNames.add(str);
            }
        }
        return new ArrayList<>(this.orderedSignatureNames);
    }

    public ArrayList<String> getBlankSignatureNames() {
        getSignatureNames();
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, Item> entry : this.fields.entrySet()) {
            if (PdfName.SIG.equals(entry.getValue().getMerged(0).getAsName(PdfName.f19720FT)) && !this.sigNames.containsKey(entry.getKey())) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    public PdfDictionary getSignatureDictionary(String str) {
        getSignatureNames();
        String translatedFieldName = getTranslatedFieldName(str);
        if (this.sigNames.containsKey(translatedFieldName)) {
            return this.fields.get(translatedFieldName).getMerged(0).getAsDict(PdfName.f19787V);
        }
        return null;
    }

    public boolean signatureCoversWholeDocument(String str) {
        getSignatureNames();
        String translatedFieldName = getTranslatedFieldName(str);
        return this.sigNames.containsKey(translatedFieldName) && ((long) this.sigNames.get(translatedFieldName)[0]) == this.reader.getFileLength();
    }

    public PdfPKCS7 verifySignature(String str) {
        return verifySignature(str, null);
    }

    public PdfPKCS7 verifySignature(String str, String str2) {
        PdfPKCS7 pdfPKCS7;
        PdfDictionary signatureDictionary = getSignatureDictionary(str);
        if (signatureDictionary == null) {
            return null;
        }
        try {
            PdfName asName = signatureDictionary.getAsName(PdfName.SUBFILTER);
            PdfString asString = signatureDictionary.getAsString(PdfName.CONTENTS);
            if (asName.equals(PdfName.ADBE_X509_RSA_SHA1)) {
                PdfString asString2 = signatureDictionary.getAsString(PdfName.CERT);
                if (asString2 == null) {
                    asString2 = signatureDictionary.getAsArray(PdfName.CERT).getAsString(0);
                }
                pdfPKCS7 = new PdfPKCS7(asString.getOriginalBytes(), asString2.getBytes(), str2);
            } else if (asName.equals(PdfName.ETSI_RFC3161)) {
                pdfPKCS7 = new PdfPKCS7(asString.getOriginalBytes(), true, str2);
            } else {
                pdfPKCS7 = new PdfPKCS7(asString.getOriginalBytes(), str2);
            }
            updateByteRange(pdfPKCS7, signatureDictionary);
            PdfString asString3 = signatureDictionary.getAsString(PdfName.f19737M);
            if (asString3 != null) {
                pdfPKCS7.setSignDate(PdfDate.decode(asString3.toString()));
            }
            PdfObject pdfObject = PdfReader.getPdfObject(signatureDictionary.get(PdfName.NAME));
            if (pdfObject != null) {
                if (pdfObject.isString()) {
                    pdfPKCS7.setSignName(((PdfString) pdfObject).toUnicodeString());
                } else if (pdfObject.isName()) {
                    pdfPKCS7.setSignName(PdfName.decodeName(pdfObject.toString()));
                }
            }
            PdfString asString4 = signatureDictionary.getAsString(PdfName.REASON);
            if (asString4 != null) {
                pdfPKCS7.setReason(asString4.toUnicodeString());
            }
            PdfString asString5 = signatureDictionary.getAsString(PdfName.LOCATION);
            if (asString5 != null) {
                pdfPKCS7.setLocation(asString5.toUnicodeString());
            }
            return pdfPKCS7;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    private void updateByteRange(PdfPKCS7 pdfPKCS7, PdfDictionary pdfDictionary) {
        PdfArray asArray = pdfDictionary.getAsArray(PdfName.BYTERANGE);
        RandomAccessFileOrArray safeFile = this.reader.getSafeFile();
        try {
            try {
                safeFile.reOpen();
                byte[] bArr = new byte[8192];
                int i = 0;
                while (i < asArray.size()) {
                    int intValue = asArray.getAsNumber(i).intValue();
                    int i2 = i + 1;
                    int intValue2 = asArray.getAsNumber(i2).intValue();
                    safeFile.seek(intValue);
                    while (intValue2 > 0) {
                        int read = safeFile.read(bArr, 0, Math.min(intValue2, 8192));
                        if (read > 0) {
                            intValue2 -= read;
                            pdfPKCS7.update(bArr, 0, read);
                        }
                    }
                    i = i2 + 1;
                }
                try {
                    safeFile.close();
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                try {
                    safeFile.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markUsed(PdfObject pdfObject) {
        if (this.append) {
            ((PdfStamperImp) this.writer).markUsed(pdfObject);
        }
    }

    public int getTotalRevisions() {
        getSignatureNames();
        return this.totalRevisions;
    }

    public int getRevision(String str) {
        getSignatureNames();
        String translatedFieldName = getTranslatedFieldName(str);
        if (this.sigNames.containsKey(translatedFieldName)) {
            return this.sigNames.get(translatedFieldName)[1];
        }
        return 0;
    }

    public InputStream extractRevision(String str) throws IOException {
        getSignatureNames();
        String translatedFieldName = getTranslatedFieldName(str);
        if (this.sigNames.containsKey(translatedFieldName)) {
            int i = this.sigNames.get(translatedFieldName)[0];
            RandomAccessFileOrArray safeFile = this.reader.getSafeFile();
            safeFile.reOpen();
            safeFile.seek(0L);
            return new RevisionStream(safeFile, i, null);
        }
        return null;
    }

    public Map<String, TextField> getFieldCache() {
        return this.fieldCache;
    }

    public void setFieldCache(Map<String, TextField> map) {
        this.fieldCache = map;
    }

    public void setExtraMargin(float f, float f2) {
        this.extraMarginLeft = f;
        this.extraMarginTop = f2;
    }

    public void addSubstitutionFont(BaseFont baseFont) {
        if (this.substitutionFonts == null) {
            this.substitutionFonts = new ArrayList<>();
        }
        this.substitutionFonts.add(baseFont);
    }

    static {
        HashMap<String, String[]> hashMap = new HashMap<>();
        stdFieldFontNames = hashMap;
        hashMap.put("CoBO", new String[]{"Courier-BoldOblique"});
        stdFieldFontNames.put("CoBo", new String[]{"Courier-Bold"});
        stdFieldFontNames.put("CoOb", new String[]{"Courier-Oblique"});
        stdFieldFontNames.put("Cour", new String[]{"Courier"});
        stdFieldFontNames.put("HeBO", new String[]{"Helvetica-BoldOblique"});
        stdFieldFontNames.put("HeBo", new String[]{"Helvetica-Bold"});
        stdFieldFontNames.put("HeOb", new String[]{"Helvetica-Oblique"});
        stdFieldFontNames.put("Helv", new String[]{"Helvetica"});
        stdFieldFontNames.put("Symb", new String[]{"Symbol"});
        stdFieldFontNames.put("TiBI", new String[]{"Times-BoldItalic"});
        stdFieldFontNames.put("TiBo", new String[]{"Times-Bold"});
        stdFieldFontNames.put("TiIt", new String[]{"Times-Italic"});
        stdFieldFontNames.put("TiRo", new String[]{"Times-Roman"});
        stdFieldFontNames.put("ZaDb", new String[]{"ZapfDingbats"});
        stdFieldFontNames.put("HySm", new String[]{"HYSMyeongJo-Medium", "UniKS-UCS2-H"});
        stdFieldFontNames.put("HyGo", new String[]{"HYGoThic-Medium", "UniKS-UCS2-H"});
        stdFieldFontNames.put("KaGo", new String[]{"HeiseiKakuGo-W5", "UniKS-UCS2-H"});
        stdFieldFontNames.put("KaMi", new String[]{"HeiseiMin-W3", "UniJIS-UCS2-H"});
        stdFieldFontNames.put("MHei", new String[]{"MHei-Medium", "UniCNS-UCS2-H"});
        stdFieldFontNames.put("MSun", new String[]{"MSung-Light", "UniCNS-UCS2-H"});
        stdFieldFontNames.put("STSo", new String[]{"STSong-Light", "UniGB-UCS2-H"});
        buttonRemove = new PdfName[]{PdfName.f19738MK, PdfName.f19712F, PdfName.f19715FF, PdfName.f19759Q, PdfName.f19689BS, PdfName.BORDER};
    }

    /* loaded from: classes.dex */
    static class RevisionStream extends InputStream {

        /* renamed from: b */
        private byte[] f19646b;
        private boolean closed;
        private int length;
        private RandomAccessFileOrArray raf;
        private int rangePosition;

        /* synthetic */ RevisionStream(RandomAccessFileOrArray randomAccessFileOrArray, int i, C36291 c36291) {
            this(randomAccessFileOrArray, i);
        }

        private RevisionStream(RandomAccessFileOrArray randomAccessFileOrArray, int i) {
            this.f19646b = new byte[1];
            this.rangePosition = 0;
            this.raf = randomAccessFileOrArray;
            this.length = i;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (read(this.f19646b) != 1) {
                return -1;
            }
            return this.f19646b[0] & 255;
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
            if (i2 == 0) {
                return 0;
            }
            int i4 = this.rangePosition;
            int i5 = this.length;
            if (i4 >= i5) {
                close();
                return -1;
            }
            int min = Math.min(i2, i5 - i4);
            this.raf.readFully(bArr, i, min);
            this.rangePosition += min;
            return min;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.raf.close();
            this.closed = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SorterComparator implements Comparator<Object[]> {
        private SorterComparator() {
        }

        /* synthetic */ SorterComparator(C36291 c36291) {
            this();
        }

        @Override // java.util.Comparator
        public int compare(Object[] objArr, Object[] objArr2) {
            return ((int[]) objArr[1])[0] - ((int[]) objArr2[1])[0];
        }
    }

    public ArrayList<BaseFont> getSubstitutionFonts() {
        return this.substitutionFonts;
    }

    public void setSubstitutionFonts(ArrayList<BaseFont> arrayList) {
        this.substitutionFonts = arrayList;
    }

    public XfaForm getXfa() {
        return this.xfa;
    }

    public void removeXfa() {
        this.reader.getCatalog().getAsDict(PdfName.ACROFORM).remove(PdfName.XFA);
        try {
            this.xfa = new XfaForm(this.reader);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public PushbuttonField getNewPushbuttonFromField(String str) {
        return getNewPushbuttonFromField(str, 0);
    }

    public PushbuttonField getNewPushbuttonFromField(String str, int i) {
        int i2;
        try {
            if (getFieldType(str) != 1) {
                return null;
            }
            Item fieldItem = getFieldItem(str);
            if (i >= fieldItem.size()) {
                return null;
            }
            PushbuttonField pushbuttonField = new PushbuttonField(this.writer, getFieldPositions(str).get(i).position, null);
            PdfDictionary merged = fieldItem.getMerged(i);
            decodeGenericDictionary(merged, pushbuttonField);
            PdfDictionary asDict = merged.getAsDict(PdfName.f19738MK);
            if (asDict != null) {
                PdfString asString = asDict.getAsString(PdfName.f19693CA);
                if (asString != null) {
                    pushbuttonField.setText(asString.toUnicodeString());
                }
                PdfNumber asNumber = asDict.getAsNumber(PdfName.f19779TP);
                if (asNumber != null) {
                    pushbuttonField.setLayout(asNumber.intValue() + 1);
                }
                PdfDictionary asDict2 = asDict.getAsDict(PdfName.f19731IF);
                if (asDict2 != null) {
                    PdfName asName = asDict2.getAsName(PdfName.f19771SW);
                    if (asName != null) {
                        if (asName.equals(PdfName.f19684B)) {
                            i2 = 3;
                        } else if (asName.equals(PdfName.f19767S)) {
                            i2 = 4;
                        } else {
                            i2 = asName.equals(PdfName.f19739N) ? 2 : 1;
                        }
                        pushbuttonField.setScaleIcon(i2);
                    }
                    PdfName asName2 = asDict2.getAsName(PdfName.f19767S);
                    if (asName2 != null && asName2.equals(PdfName.f19679A)) {
                        pushbuttonField.setProportionalIcon(false);
                    }
                    PdfArray asArray = asDict2.getAsArray(PdfName.f19679A);
                    if (asArray != null && asArray.size() == 2) {
                        float floatValue = asArray.getAsNumber(0).floatValue();
                        float floatValue2 = asArray.getAsNumber(1).floatValue();
                        pushbuttonField.setIconHorizontalAdjustment(floatValue);
                        pushbuttonField.setIconVerticalAdjustment(floatValue2);
                    }
                    PdfBoolean asBoolean = asDict2.getAsBoolean(PdfName.f19713FB);
                    if (asBoolean != null && asBoolean.booleanValue()) {
                        pushbuttonField.setIconFitToBounds(true);
                    }
                }
                PdfObject pdfObject = asDict.get(PdfName.f19729I);
                if (pdfObject != null && pdfObject.isIndirect()) {
                    pushbuttonField.setIconReference((PRIndirectReference) pdfObject);
                }
            }
            return pushbuttonField;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean replacePushbuttonField(String str, PdfFormField pdfFormField) {
        return replacePushbuttonField(str, pdfFormField, 0);
    }

    public boolean replacePushbuttonField(String str, PdfFormField pdfFormField, int i) {
        int i2 = 0;
        if (getFieldType(str) != 1) {
            return false;
        }
        Item fieldItem = getFieldItem(str);
        if (i >= fieldItem.size()) {
            return false;
        }
        PdfDictionary merged = fieldItem.getMerged(i);
        PdfDictionary value = fieldItem.getValue(i);
        PdfDictionary widget = fieldItem.getWidget(i);
        while (true) {
            PdfName[] pdfNameArr = buttonRemove;
            if (i2 >= pdfNameArr.length) {
                break;
            }
            merged.remove(pdfNameArr[i2]);
            value.remove(buttonRemove[i2]);
            widget.remove(buttonRemove[i2]);
            i2++;
        }
        for (PdfName pdfName : pdfFormField.getKeys()) {
            if (!pdfName.equals(PdfName.f19772T) && !pdfName.equals(PdfName.RECT)) {
                if (pdfName.equals(PdfName.f19715FF)) {
                    value.put(pdfName, pdfFormField.get(pdfName));
                } else {
                    widget.put(pdfName, pdfFormField.get(pdfName));
                }
                merged.put(pdfName, pdfFormField.get(pdfName));
            }
        }
        return true;
    }
}
