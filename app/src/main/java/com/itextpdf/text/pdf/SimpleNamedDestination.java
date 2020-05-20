package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
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
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.http.HttpHeaders;
import org.apache.http.conn.ssl.TokenParser;

/* loaded from: classes.dex */
public final class SimpleNamedDestination implements SimpleXMLDocHandler {
    private HashMap<String, String> xmlLast;
    private HashMap<String, String> xmlNames;

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public final void endDocument() {
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public final void startDocument() {
    }

    private SimpleNamedDestination() {
    }

    public static HashMap<String, String> getNamedDestination(PdfReader pdfReader, boolean z) {
        IntHashtable intHashtable = new IntHashtable();
        int numberOfPages = pdfReader.getNumberOfPages();
        for (int i = 1; i <= numberOfPages; i++) {
            intHashtable.put(pdfReader.getPageOrigRef(i).getNumber(), i);
        }
        HashMap<String, PdfObject> namedDestinationFromNames = z ? pdfReader.getNamedDestinationFromNames() : pdfReader.getNamedDestinationFromStrings();
        HashMap<String, String> hashMap = new HashMap<>(namedDestinationFromNames.size());
        for (Map.Entry<String, PdfObject> entry : namedDestinationFromNames.entrySet()) {
            PdfArray pdfArray = (PdfArray) entry.getValue();
            StringBuffer stringBuffer = new StringBuffer();
            try {
                stringBuffer.append(intHashtable.get(pdfArray.getAsIndirectObject(0).getNumber()));
                stringBuffer.append(TokenParser.f24154SP);
                stringBuffer.append(pdfArray.getPdfObject(1).toString().substring(1));
                for (int i2 = 2; i2 < pdfArray.size(); i2++) {
                    stringBuffer.append(TokenParser.f24154SP);
                    stringBuffer.append(pdfArray.getPdfObject(i2).toString());
                }
                hashMap.put(entry.getKey(), stringBuffer.toString());
            } catch (Exception unused) {
            }
        }
        return hashMap;
    }

    public static void exportToXML(HashMap<String, String> hashMap, OutputStream outputStream, String str, boolean z) throws IOException {
        exportToXML(hashMap, new BufferedWriter(new OutputStreamWriter(outputStream, IanaEncodings.getJavaEncoding(str))), str, z);
    }

    public static void exportToXML(HashMap<String, String> hashMap, Writer writer, String str, boolean z) throws IOException {
        writer.write("<?xml version=\"1.0\" encoding=\"");
        writer.write(XMLUtil.escapeXML(str, z));
        writer.write("\"?>\n<Destination>\n");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            writer.write("  <Name Page=\"");
            writer.write(XMLUtil.escapeXML(entry.getValue(), z));
            writer.write("\">");
            writer.write(XMLUtil.escapeXML(escapeBinaryString(entry.getKey()), z));
            writer.write("</Name>\n");
        }
        writer.write("</Destination>\n");
        writer.flush();
    }

    public static HashMap<String, String> importFromXML(InputStream inputStream) throws IOException {
        SimpleNamedDestination simpleNamedDestination = new SimpleNamedDestination();
        SimpleXMLParser.parse(simpleNamedDestination, inputStream);
        return simpleNamedDestination.xmlNames;
    }

    public static HashMap<String, String> importFromXML(Reader reader) throws IOException {
        SimpleNamedDestination simpleNamedDestination = new SimpleNamedDestination();
        SimpleXMLParser.parse(simpleNamedDestination, reader);
        return simpleNamedDestination.xmlNames;
    }

    static PdfArray createDestinationArray(String str, PdfWriter pdfWriter) {
        PdfArray pdfArray = new PdfArray();
        StringTokenizer stringTokenizer = new StringTokenizer(str);
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
            for (int i = 0; i < 4 && stringTokenizer.hasMoreTokens(); i++) {
                String nextToken2 = stringTokenizer.nextToken();
                if (nextToken2.equals("null")) {
                    pdfArray.add(PdfNull.PDFNULL);
                } else {
                    pdfArray.add(new PdfNumber(nextToken2));
                }
            }
        }
        return pdfArray;
    }

    public static PdfDictionary outputNamedDestinationAsNames(HashMap<String, String> hashMap, PdfWriter pdfWriter) {
        PdfDictionary pdfDictionary = new PdfDictionary();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            try {
                pdfDictionary.put(new PdfName(entry.getKey()), createDestinationArray(entry.getValue(), pdfWriter));
            } catch (Exception unused) {
            }
        }
        return pdfDictionary;
    }

    public static PdfDictionary outputNamedDestinationAsStrings(HashMap<String, String> hashMap, PdfWriter pdfWriter) throws IOException {
        HashMap hashMap2 = new HashMap(hashMap.size());
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            try {
                hashMap2.put(entry.getKey(), pdfWriter.addToBody(createDestinationArray(entry.getValue(), pdfWriter)).getIndirectReference());
            } catch (Exception unused) {
            }
        }
        return PdfNameTree.writeTree(hashMap2, pdfWriter);
    }

    public static String escapeBinaryString(String str) {
        char[] charArray;
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : str.toCharArray()) {
            if (c < ' ') {
                stringBuffer.append(TokenParser.ESCAPE);
                stringBuffer.append(("00" + Integer.toOctalString(c)).substring(str2.length() - 3));
            } else if (c == '\\') {
                stringBuffer.append("\\\\");
            } else {
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();
    }

    public static String unEscapeBinaryString(String str) {
        char c;
        StringBuffer stringBuffer = new StringBuffer();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            char c2 = charArray[i];
            if (c2 == '\\') {
                i++;
                if (i >= length) {
                    stringBuffer.append(TokenParser.ESCAPE);
                    break;
                }
                char c3 = charArray[i];
                if (c3 >= '0' && c3 <= '7') {
                    int i2 = c3 - '0';
                    int i3 = i + 1;
                    for (int i4 = 0; i4 < 2 && i3 < length && (c = charArray[i3]) >= '0' && c <= '7'; i4++) {
                        i3++;
                        i2 = ((i2 * 8) + c) - 48;
                    }
                    i = i3 - 1;
                    stringBuffer.append((char) i2);
                } else {
                    stringBuffer.append(c3);
                }
            } else {
                stringBuffer.append(c2);
            }
            i++;
        }
        return stringBuffer.toString();
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public final void endElement(String str) {
        if (str.equals(HttpHeaders.DESTINATION)) {
            if (this.xmlLast != null || this.xmlNames == null) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("destination.end.tag.out.of.place", new Object[0]));
            }
        } else if (!str.equals("Name")) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.end.tag.1", str));
        } else {
            HashMap<String, String> hashMap = this.xmlLast;
            if (hashMap == null || this.xmlNames == null) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("name.end.tag.out.of.place", new Object[0]));
            }
            if (!hashMap.containsKey("Page")) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("page.attribute.missing", new Object[0]));
            }
            this.xmlNames.put(unEscapeBinaryString(this.xmlLast.get("Name")), this.xmlLast.get("Page"));
            this.xmlLast = null;
        }
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public final void startElement(String str, Map<String, String> map) {
        if (this.xmlNames == null) {
            if (str.equals(HttpHeaders.DESTINATION)) {
                this.xmlNames = new HashMap<>();
                return;
            }
            throw new RuntimeException(MessageLocalization.getComposedMessage("root.element.is.not.destination", new Object[0]));
        } else if (!str.equals("Name")) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("tag.1.not.allowed", str));
        } else {
            if (this.xmlLast != null) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("nested.tags.are.not.allowed", new Object[0]));
            }
            this.xmlLast = new HashMap<>(map);
            this.xmlLast.put("Name", "");
        }
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public final void text(String str) {
        HashMap<String, String> hashMap = this.xmlLast;
        if (hashMap == null) {
            return;
        }
        this.xmlLast.put("Name", hashMap.get("Name") + str);
    }
}
