package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.xml.XMLUtil;
import com.itextpdf.text.xml.simpleparser.IanaEncodings;
import com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler;
import com.itextpdf.text.xml.simpleparser.SimpleXMLParser;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import org.apache.http.conn.ssl.TokenParser;

/* loaded from: classes.dex */
public final class SimpleBookmark implements SimpleXMLDocHandler {
    private final Stack<HashMap<String, Object>> attr = new Stack<>();
    private ArrayList<HashMap<String, Object>> topList;

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public final void endDocument() {
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public final void startDocument() {
    }

    private SimpleBookmark() {
    }

    private static List<HashMap<String, Object>> bookmarkDepth(PdfReader pdfReader, PdfDictionary pdfDictionary, IntHashtable intHashtable, boolean z) {
        ArrayList arrayList = new ArrayList();
        while (pdfDictionary != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("Title", ((PdfString) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.TITLE))).toUnicodeString());
            PdfArray pdfArray = (PdfArray) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.f19690C));
            if (pdfArray != null && pdfArray.size() == 3) {
                ByteBuffer byteBuffer = new ByteBuffer();
                byteBuffer.append(pdfArray.getAsNumber(0).floatValue()).append(TokenParser.f24154SP);
                byteBuffer.append(pdfArray.getAsNumber(1).floatValue()).append(TokenParser.f24154SP);
                byteBuffer.append(pdfArray.getAsNumber(2).floatValue());
                hashMap.put("Color", PdfEncodings.convertToString(byteBuffer.toByteArray(), null));
            }
            PdfNumber pdfNumber = (PdfNumber) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.f19712F));
            if (pdfNumber != null) {
                int intValue = pdfNumber.intValue();
                String str = (intValue & 1) != 0 ? "italic " : "";
                if ((intValue & 2) != 0) {
                    str = str + "bold ";
                }
                String trim = str.trim();
                if (trim.length() != 0) {
                    hashMap.put("Style", trim);
                }
            }
            PdfNumber pdfNumber2 = (PdfNumber) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.COUNT));
            if (pdfNumber2 != null && pdfNumber2.intValue() < 0) {
                hashMap.put("Open", PdfBoolean.FALSE);
            }
            try {
                PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.DEST));
                if (pdfObjectRelease != null) {
                    mapGotoBookmark(hashMap, pdfObjectRelease, intHashtable);
                } else {
                    PdfDictionary pdfDictionary2 = (PdfDictionary) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.f19679A));
                    if (pdfDictionary2 != null) {
                        if (PdfName.GOTO.equals(PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.f19767S)))) {
                            PdfObject pdfObjectRelease2 = PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.f19699D));
                            if (pdfObjectRelease2 != null) {
                                mapGotoBookmark(hashMap, pdfObjectRelease2, intHashtable);
                            }
                        } else if (PdfName.URI.equals(PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.f19767S)))) {
                            hashMap.put("Action", "URI");
                            hashMap.put("URI", ((PdfString) PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.URI))).toUnicodeString());
                        } else if (PdfName.JAVASCRIPT.equals(PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.f19767S)))) {
                            hashMap.put("Action", "JS");
                            hashMap.put("Code", PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.f19733JS)).toString());
                        } else if (PdfName.GOTOR.equals(PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.f19767S)))) {
                            PdfObject pdfObjectRelease3 = PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.f19699D));
                            if (pdfObjectRelease3 != null) {
                                if (pdfObjectRelease3.isString()) {
                                    hashMap.put("Named", pdfObjectRelease3.toString());
                                } else if (pdfObjectRelease3.isName()) {
                                    hashMap.put("NamedN", PdfName.decodeName(pdfObjectRelease3.toString()));
                                } else if (pdfObjectRelease3.isArray()) {
                                    PdfArray pdfArray2 = (PdfArray) pdfObjectRelease3;
                                    StringBuffer stringBuffer = new StringBuffer();
                                    stringBuffer.append(pdfArray2.getPdfObject(0).toString());
                                    stringBuffer.append(TokenParser.f24154SP);
                                    stringBuffer.append(pdfArray2.getPdfObject(1).toString());
                                    for (int i = 2; i < pdfArray2.size(); i++) {
                                        stringBuffer.append(TokenParser.f24154SP);
                                        stringBuffer.append(pdfArray2.getPdfObject(i).toString());
                                    }
                                    hashMap.put("Page", stringBuffer.toString());
                                }
                            }
                            hashMap.put("Action", "GoToR");
                            PdfObject pdfObjectRelease4 = PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.f19712F));
                            if (pdfObjectRelease4 != null) {
                                if (pdfObjectRelease4.isString()) {
                                    hashMap.put("File", ((PdfString) pdfObjectRelease4).toUnicodeString());
                                } else if (pdfObjectRelease4.isDictionary()) {
                                    PdfObject pdfObject = PdfReader.getPdfObject(((PdfDictionary) pdfObjectRelease4).get(PdfName.f19712F));
                                    if (pdfObject.isString()) {
                                        hashMap.put("File", ((PdfString) pdfObject).toUnicodeString());
                                    }
                                }
                            }
                            PdfObject pdfObjectRelease5 = PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.NEWWINDOW));
                            if (pdfObjectRelease5 != null) {
                                hashMap.put("NewWindow", pdfObjectRelease5.toString());
                            }
                        } else if (PdfName.LAUNCH.equals(PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.f19767S)))) {
                            hashMap.put("Action", "Launch");
                            PdfObject pdfObjectRelease6 = PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.f19712F));
                            if (pdfObjectRelease6 == null) {
                                pdfObjectRelease6 = PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.WIN));
                            }
                            if (pdfObjectRelease6 != null) {
                                if (pdfObjectRelease6.isString()) {
                                    hashMap.put("File", ((PdfString) pdfObjectRelease6).toUnicodeString());
                                } else if (pdfObjectRelease6.isDictionary()) {
                                    PdfObject pdfObjectRelease7 = PdfReader.getPdfObjectRelease(((PdfDictionary) pdfObjectRelease6).get(PdfName.f19712F));
                                    if (pdfObjectRelease7.isString()) {
                                        hashMap.put("File", ((PdfString) pdfObjectRelease7).toUnicodeString());
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
            PdfDictionary pdfDictionary3 = (PdfDictionary) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.FIRST));
            if (pdfDictionary3 != null) {
                hashMap.put("Kids", bookmarkDepth(pdfReader, pdfDictionary3, intHashtable, false));
            }
            arrayList.add(hashMap);
            pdfDictionary = !z ? (PdfDictionary) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.NEXT)) : null;
        }
        return arrayList;
    }

    private static void mapGotoBookmark(HashMap<String, Object> hashMap, PdfObject pdfObject, IntHashtable intHashtable) {
        if (pdfObject.isString()) {
            hashMap.put("Named", pdfObject.toString());
        } else if (pdfObject.isName()) {
            hashMap.put("Named", PdfName.decodeName(pdfObject.toString()));
        } else if (pdfObject.isArray()) {
            hashMap.put("Page", makeBookmarkParam((PdfArray) pdfObject, intHashtable));
        }
        hashMap.put("Action", "GoTo");
    }

    private static String makeBookmarkParam(PdfArray pdfArray, IntHashtable intHashtable) {
        StringBuffer stringBuffer = new StringBuffer();
        PdfObject pdfObject = pdfArray.getPdfObject(0);
        if (pdfObject.isNumber()) {
            stringBuffer.append(((PdfNumber) pdfObject).intValue() + 1);
        } else {
            stringBuffer.append(intHashtable.get(getNumber((PdfIndirectReference) pdfObject)));
        }
        stringBuffer.append(TokenParser.f24154SP);
        stringBuffer.append(pdfArray.getPdfObject(1).toString().substring(1));
        for (int i = 2; i < pdfArray.size(); i++) {
            stringBuffer.append(TokenParser.f24154SP);
            stringBuffer.append(pdfArray.getPdfObject(i).toString());
        }
        return stringBuffer.toString();
    }

    private static int getNumber(PdfIndirectReference pdfIndirectReference) {
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease(pdfIndirectReference);
        if (pdfDictionary.contains(PdfName.TYPE) && pdfDictionary.get(PdfName.TYPE).equals(PdfName.PAGES) && pdfDictionary.contains(PdfName.KIDS)) {
            pdfIndirectReference = (PdfIndirectReference) ((PdfArray) pdfDictionary.get(PdfName.KIDS)).getPdfObject(0);
        }
        return pdfIndirectReference.getNumber();
    }

    public static List<HashMap<String, Object>> getBookmark(PdfReader pdfReader) {
        PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(pdfReader.getCatalog().get(PdfName.OUTLINES));
        if (pdfObjectRelease == null || !pdfObjectRelease.isDictionary()) {
            return null;
        }
        return getBookmark(pdfReader, (PdfDictionary) pdfObjectRelease, false);
    }

    public static List<HashMap<String, Object>> getBookmark(PdfReader pdfReader, PdfDictionary pdfDictionary, boolean z) {
        pdfReader.getCatalog();
        if (pdfDictionary == null) {
            return null;
        }
        IntHashtable intHashtable = new IntHashtable();
        int numberOfPages = pdfReader.getNumberOfPages();
        for (int i = 1; i <= numberOfPages; i++) {
            intHashtable.put(pdfReader.getPageOrigRef(i).getNumber(), i);
            pdfReader.releasePage(i);
        }
        if (z) {
            return bookmarkDepth(pdfReader, pdfDictionary, intHashtable, true);
        }
        return bookmarkDepth(pdfReader, (PdfDictionary) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.FIRST)), intHashtable, false);
    }

    public static void eliminatePages(List<HashMap<String, Object>> list, int[] iArr) {
        String str;
        int parseInt;
        if (list == null) {
            return;
        }
        ListIterator<HashMap<String, Object>> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            HashMap<String, Object> next = listIterator.next();
            boolean z = false;
            if ("GoTo".equals(next.get("Action")) && (str = (String) next.get("Page")) != null) {
                String trim = str.trim();
                int indexOf = trim.indexOf(32);
                if (indexOf < 0) {
                    parseInt = Integer.parseInt(trim);
                } else {
                    parseInt = Integer.parseInt(trim.substring(0, indexOf));
                }
                int length = iArr.length & (-2);
                int i = 0;
                while (true) {
                    if (i < length) {
                        if (parseInt >= iArr[i] && parseInt <= iArr[i + 1]) {
                            z = true;
                            break;
                        }
                        i += 2;
                    } else {
                        break;
                    }
                }
            }
            List list2 = (List) next.get("Kids");
            if (list2 != null) {
                eliminatePages(list2, iArr);
                if (list2.isEmpty()) {
                    next.remove("Kids");
                    list2 = null;
                }
            }
            if (z) {
                if (list2 == null) {
                    listIterator.remove();
                } else {
                    next.remove("Action");
                    next.remove("Page");
                    next.remove("Named");
                }
            }
        }
    }

    public static void shiftPageNumbers(List<HashMap<String, Object>> list, int i, int[] iArr) {
        String str;
        int parseInt;
        if (list == null) {
            return;
        }
        ListIterator<HashMap<String, Object>> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            HashMap<String, Object> next = listIterator.next();
            if ("GoTo".equals(next.get("Action")) && (str = (String) next.get("Page")) != null) {
                String trim = str.trim();
                int indexOf = trim.indexOf(32);
                if (indexOf < 0) {
                    parseInt = Integer.parseInt(trim);
                } else {
                    parseInt = Integer.parseInt(trim.substring(0, indexOf));
                }
                boolean z = true;
                if (iArr != null) {
                    int length = iArr.length & (-2);
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            z = false;
                            break;
                        } else if (parseInt >= iArr[i2] && parseInt <= iArr[i2 + 1]) {
                            break;
                        } else {
                            i2 += 2;
                        }
                    }
                }
                if (z) {
                    if (indexOf < 0) {
                        trim = Integer.toString(parseInt + i);
                    } else {
                        trim = (parseInt + i) + trim.substring(indexOf);
                    }
                }
                next.put("Page", trim);
            }
            List list2 = (List) next.get("Kids");
            if (list2 != null) {
                shiftPageNumbers(list2, i, iArr);
            }
        }
    }

    static void createOutlineAction(PdfDictionary pdfDictionary, HashMap<String, Object> hashMap, PdfWriter pdfWriter, boolean z) {
        String str;
        try {
            String str2 = (String) hashMap.get("Action");
            int i = 0;
            if ("GoTo".equals(str2)) {
                String str3 = (String) hashMap.get("Named");
                if (str3 != null) {
                    if (z) {
                        pdfDictionary.put(PdfName.DEST, new PdfName(str3));
                        return;
                    } else {
                        pdfDictionary.put(PdfName.DEST, new PdfString(str3, null));
                        return;
                    }
                }
                String str4 = (String) hashMap.get("Page");
                if (str4 != null) {
                    PdfArray pdfArray = new PdfArray();
                    StringTokenizer stringTokenizer = new StringTokenizer(str4);
                    pdfArray.add(pdfWriter.getPageReference(Integer.parseInt(stringTokenizer.nextToken())));
                    if (!stringTokenizer.hasMoreTokens()) {
                        pdfArray.add(PdfName.XYZ);
                        pdfArray.add(new float[]{ColumnText.GLOBAL_SPACE_CHAR_RATIO, 10000.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO});
                    } else {
                        String nextToken = stringTokenizer.nextToken();
                        if (nextToken.startsWith("/")) {
                            nextToken = nextToken.substring(1);
                        }
                        pdfArray.add(new PdfName(nextToken));
                        while (i < 4 && stringTokenizer.hasMoreTokens()) {
                            String nextToken2 = stringTokenizer.nextToken();
                            if (nextToken2.equals("null")) {
                                pdfArray.add(PdfNull.PDFNULL);
                            } else {
                                pdfArray.add(new PdfNumber(nextToken2));
                            }
                            i++;
                        }
                    }
                    pdfDictionary.put(PdfName.DEST, pdfArray);
                }
            } else if ("GoToR".equals(str2)) {
                PdfDictionary pdfDictionary2 = new PdfDictionary();
                String str5 = (String) hashMap.get("Named");
                if (str5 != null) {
                    pdfDictionary2.put(PdfName.f19699D, new PdfString(str5, null));
                } else {
                    String str6 = (String) hashMap.get("NamedN");
                    if (str6 != null) {
                        pdfDictionary2.put(PdfName.f19699D, new PdfName(str6));
                    } else {
                        String str7 = (String) hashMap.get("Page");
                        if (str7 != null) {
                            PdfArray pdfArray2 = new PdfArray();
                            StringTokenizer stringTokenizer2 = new StringTokenizer(str7);
                            pdfArray2.add(new PdfNumber(stringTokenizer2.nextToken()));
                            if (!stringTokenizer2.hasMoreTokens()) {
                                pdfArray2.add(PdfName.XYZ);
                                pdfArray2.add(new float[]{ColumnText.GLOBAL_SPACE_CHAR_RATIO, 10000.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO});
                            } else {
                                String nextToken3 = stringTokenizer2.nextToken();
                                if (nextToken3.startsWith("/")) {
                                    nextToken3 = nextToken3.substring(1);
                                }
                                pdfArray2.add(new PdfName(nextToken3));
                                while (i < 4 && stringTokenizer2.hasMoreTokens()) {
                                    String nextToken4 = stringTokenizer2.nextToken();
                                    if (nextToken4.equals("null")) {
                                        pdfArray2.add(PdfNull.PDFNULL);
                                    } else {
                                        pdfArray2.add(new PdfNumber(nextToken4));
                                    }
                                    i++;
                                }
                            }
                            pdfDictionary2.put(PdfName.f19699D, pdfArray2);
                        }
                    }
                }
                String str8 = (String) hashMap.get("File");
                if (pdfDictionary2.size() <= 0 || str8 == null) {
                    return;
                }
                pdfDictionary2.put(PdfName.f19767S, PdfName.GOTOR);
                pdfDictionary2.put(PdfName.f19712F, new PdfString(str8));
                String str9 = (String) hashMap.get("NewWindow");
                if (str9 != null) {
                    if (str9.equals(PdfBoolean.TRUE)) {
                        pdfDictionary2.put(PdfName.NEWWINDOW, PdfBoolean.PDFTRUE);
                    } else if (str9.equals(PdfBoolean.FALSE)) {
                        pdfDictionary2.put(PdfName.NEWWINDOW, PdfBoolean.PDFFALSE);
                    }
                }
                pdfDictionary.put(PdfName.f19679A, pdfDictionary2);
            } else if ("URI".equals(str2)) {
                String str10 = (String) hashMap.get("URI");
                if (str10 != null) {
                    PdfDictionary pdfDictionary3 = new PdfDictionary();
                    pdfDictionary3.put(PdfName.f19767S, PdfName.URI);
                    pdfDictionary3.put(PdfName.URI, new PdfString(str10));
                    pdfDictionary.put(PdfName.f19679A, pdfDictionary3);
                }
            } else if ("JS".equals(str2)) {
                String str11 = (String) hashMap.get("Code");
                if (str11 != null) {
                    pdfDictionary.put(PdfName.f19679A, PdfAction.javaScript(str11, pdfWriter));
                }
            } else if (!"Launch".equals(str2) || (str = (String) hashMap.get("File")) == null) {
            } else {
                PdfDictionary pdfDictionary4 = new PdfDictionary();
                pdfDictionary4.put(PdfName.f19767S, PdfName.LAUNCH);
                pdfDictionary4.put(PdfName.f19712F, new PdfString(str));
                pdfDictionary.put(PdfName.f19679A, pdfDictionary4);
            }
        } catch (Exception unused) {
        }
    }

    public static Object[] iterateOutlines(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, List<HashMap<String, Object>> list, boolean z) throws IOException {
        PdfIndirectReference[] pdfIndirectReferenceArr = new PdfIndirectReference[list.size()];
        for (int i = 0; i < pdfIndirectReferenceArr.length; i++) {
            pdfIndirectReferenceArr[i] = pdfWriter.getPdfIndirectReference();
        }
        ListIterator<HashMap<String, Object>> listIterator = list.listIterator();
        int i2 = 0;
        int i3 = 0;
        while (listIterator.hasNext()) {
            HashMap<String, Object> next = listIterator.next();
            Object[] objArr = null;
            List list2 = (List) next.get("Kids");
            if (list2 != null && !list2.isEmpty()) {
                objArr = iterateOutlines(pdfWriter, pdfIndirectReferenceArr[i3], list2, z);
            }
            PdfDictionary pdfDictionary = new PdfDictionary();
            i2++;
            if (objArr != null) {
                pdfDictionary.put(PdfName.FIRST, (PdfIndirectReference) objArr[0]);
                pdfDictionary.put(PdfName.LAST, (PdfIndirectReference) objArr[1]);
                int intValue = ((Integer) objArr[2]).intValue();
                if (PdfBoolean.FALSE.equals(next.get("Open"))) {
                    pdfDictionary.put(PdfName.COUNT, new PdfNumber(-intValue));
                } else {
                    pdfDictionary.put(PdfName.COUNT, new PdfNumber(intValue));
                    i2 += intValue;
                }
            }
            pdfDictionary.put(PdfName.PARENT, pdfIndirectReference);
            if (i3 > 0) {
                pdfDictionary.put(PdfName.PREV, pdfIndirectReferenceArr[i3 - 1]);
            }
            if (i3 < pdfIndirectReferenceArr.length - 1) {
                pdfDictionary.put(PdfName.NEXT, pdfIndirectReferenceArr[i3 + 1]);
            }
            pdfDictionary.put(PdfName.TITLE, new PdfString((String) next.get("Title"), PdfObject.TEXT_UNICODE));
            String str = (String) next.get("Color");
            if (str != null) {
                try {
                    PdfArray pdfArray = new PdfArray();
                    StringTokenizer stringTokenizer = new StringTokenizer(str);
                    for (int i4 = 0; i4 < 3; i4++) {
                        float parseFloat = Float.parseFloat(stringTokenizer.nextToken());
                        if (parseFloat < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                            parseFloat = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                        }
                        if (parseFloat > 1.0f) {
                            parseFloat = 1.0f;
                        }
                        pdfArray.add(new PdfNumber(parseFloat));
                    }
                    pdfDictionary.put(PdfName.f19690C, pdfArray);
                } catch (Exception unused) {
                }
            }
            String str2 = (String) next.get("Style");
            if (str2 != null) {
                String lowerCase = str2.toLowerCase();
                int i5 = lowerCase.indexOf(HtmlTags.ITALIC) >= 0 ? 1 : 0;
                if (lowerCase.indexOf(HtmlTags.BOLD) >= 0) {
                    i5 |= 2;
                }
                if (i5 != 0) {
                    pdfDictionary.put(PdfName.f19712F, new PdfNumber(i5));
                }
            }
            createOutlineAction(pdfDictionary, next, pdfWriter, z);
            pdfWriter.addToBody(pdfDictionary, pdfIndirectReferenceArr[i3]);
            i3++;
        }
        return new Object[]{pdfIndirectReferenceArr[0], pdfIndirectReferenceArr[pdfIndirectReferenceArr.length - 1], Integer.valueOf(i2)};
    }

    public static void exportToXMLNode(List<HashMap<String, Object>> list, Writer writer, int i, boolean z) throws IOException {
        String str = "";
        if (i != -1) {
            for (int i2 = 0; i2 < i; i2++) {
                str = str + "  ";
            }
        }
        for (HashMap<String, Object> hashMap : list) {
            writer.write(str);
            writer.write("<Title ");
            String str2 = null;
            List list2 = null;
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                if (key.equals("Title")) {
                    str2 = (String) entry.getValue();
                } else if (key.equals("Kids")) {
                    list2 = (List) entry.getValue();
                } else {
                    writer.write(key);
                    writer.write("=\"");
                    String str3 = (String) entry.getValue();
                    if (key.equals("Named") || key.equals("NamedN")) {
                        str3 = SimpleNamedDestination.escapeBinaryString(str3);
                    }
                    writer.write(XMLUtil.escapeXML(str3, z));
                    writer.write("\" ");
                }
            }
            writer.write(">");
            if (str2 == null) {
                str2 = "";
            }
            writer.write(XMLUtil.escapeXML(str2, z));
            if (list2 != null) {
                writer.write("\n");
                exportToXMLNode(list2, writer, i == -1 ? i : i + 1, z);
                writer.write(str);
            }
            writer.write("</Title>\n");
        }
    }

    public static void exportToXML(List<HashMap<String, Object>> list, OutputStream outputStream, String str, boolean z) throws IOException {
        exportToXML(list, new BufferedWriter(new OutputStreamWriter(outputStream, IanaEncodings.getJavaEncoding(str))), str, z);
    }

    public static void exportToXML(List<HashMap<String, Object>> list, Writer writer, String str, boolean z) throws IOException {
        writer.write("<?xml version=\"1.0\" encoding=\"");
        writer.write(XMLUtil.escapeXML(str, z));
        writer.write("\"?>\n<Bookmark>\n");
        exportToXMLNode(list, writer, 1, z);
        writer.write("</Bookmark>\n");
        writer.flush();
    }

    public static List<HashMap<String, Object>> importFromXML(InputStream inputStream) throws IOException {
        SimpleBookmark simpleBookmark = new SimpleBookmark();
        SimpleXMLParser.parse(simpleBookmark, inputStream);
        return simpleBookmark.topList;
    }

    public static List<HashMap<String, Object>> importFromXML(Reader reader) throws IOException {
        SimpleBookmark simpleBookmark = new SimpleBookmark();
        SimpleXMLParser.parse(simpleBookmark, reader);
        return simpleBookmark.topList;
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public final void endElement(String str) {
        if (str.equals("Bookmark")) {
            if (!this.attr.isEmpty()) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("bookmark.end.tag.out.of.place", new Object[0]));
            }
        } else if (!str.equals("Title")) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.end.tag.1", str));
        } else {
            HashMap<String, Object> pop = this.attr.pop();
            pop.put("Title", ((String) pop.get("Title")).trim());
            String str2 = (String) pop.get("Named");
            if (str2 != null) {
                pop.put("Named", SimpleNamedDestination.unEscapeBinaryString(str2));
            }
            String str3 = (String) pop.get("NamedN");
            if (str3 != null) {
                pop.put("NamedN", SimpleNamedDestination.unEscapeBinaryString(str3));
            }
            if (this.attr.isEmpty()) {
                this.topList.add(pop);
                return;
            }
            HashMap<String, Object> peek = this.attr.peek();
            List list = (List) peek.get("Kids");
            if (list == null) {
                list = new ArrayList();
                peek.put("Kids", list);
            }
            list.add(pop);
        }
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public final void startElement(String str, Map<String, String> map) {
        if (this.topList == null) {
            if (str.equals("Bookmark")) {
                this.topList = new ArrayList<>();
                return;
            }
            throw new RuntimeException(MessageLocalization.getComposedMessage("root.element.is.not.bookmark.1", str));
        } else if (!str.equals("Title")) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("tag.1.not.allowed", str));
        } else {
            HashMap<String, Object> hashMap = new HashMap<>(map);
            hashMap.put("Title", "");
            hashMap.remove("Kids");
            this.attr.push(hashMap);
        }
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public final void text(String str) {
        if (this.attr.isEmpty()) {
            return;
        }
        HashMap<String, Object> peek = this.attr.peek();
        peek.put("Title", ((String) peek.get("Title")) + str);
    }
}
