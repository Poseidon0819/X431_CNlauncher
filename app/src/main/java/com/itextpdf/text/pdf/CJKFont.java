package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.fonts.cmaps.CMapCache;
import com.itextpdf.text.pdf.fonts.cmaps.CMapCidByte;
import com.itextpdf.text.pdf.fonts.cmaps.CMapCidUni;
import com.itextpdf.text.pdf.fonts.cmaps.CMapUniCid;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import org.apache.http.conn.ssl.TokenParser;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CJKFont extends BaseFont {
    private static final int BRACKET = 1;
    static final String CJK_ENCODING = "UnicodeBigUnmarked";
    private static final int FIRST = 0;
    public static final String RESOURCE_PATH_CMAP = "com/itextpdf/text/pdf/fonts/cmaps/";
    private static final int SERIAL = 2;
    private static final int V1Y = 880;
    private String CMap;
    private CMapCidByte cidByte;
    private boolean cidDirect;
    private CMapCidUni cidUni;
    private HashMap<String, Object> fontDesc;
    private String fontName;
    private IntHashtable hMetrics;
    private String style;
    private CMapUniCid uniCid;
    private String uniMap;
    private IntHashtable vMetrics;
    private boolean vertical;
    static Properties cjkFonts = new Properties();
    static Properties cjkEncodings = new Properties();
    private static final HashMap<String, HashMap<String, Object>> allFonts = new HashMap<>();
    private static boolean propertiesLoaded = false;
    private static final HashMap<String, Set<String>> registryNames = new HashMap<>();

    @Override // com.itextpdf.text.pdf.BaseFont
    public int[] getCharBBox(int i) {
        return null;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public PdfStream getFullFontStream() {
        return null;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getKerning(int i, int i2) {
        return 0;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    protected int[] getRawCharBBox(int i, String str) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.BaseFont
    public int getRawWidth(int i, String str) {
        return 0;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean hasKernPairs() {
        return false;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean setCharAdvance(int i, int i2) {
        return false;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean setKerning(int i, int i2, int i3) {
        return false;
    }

    private static void loadProperties() {
        if (propertiesLoaded) {
            return;
        }
        synchronized (allFonts) {
            if (propertiesLoaded) {
                return;
            }
            try {
                loadRegistry();
                for (String str : registryNames.get("fonts")) {
                    allFonts.put(str, readFontProperties(str));
                }
            } catch (Exception unused) {
            }
            propertiesLoaded = true;
        }
    }

    private static void loadRegistry() throws IOException {
        InputStream resourceStream = getResourceStream("com/itextpdf/text/pdf/fonts/cmaps/cjk_registry.properties");
        Properties properties = new Properties();
        properties.load(resourceStream);
        resourceStream.close();
        for (String str : properties.keySet()) {
            String[] split = properties.getProperty(str).split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            HashSet hashSet = new HashSet();
            for (String str2 : split) {
                if (str2.length() > 0) {
                    hashSet.add(str2);
                }
            }
            registryNames.put(str, hashSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CJKFont(String str, String str2, boolean z) throws DocumentException {
        this.style = "";
        this.cidDirect = false;
        this.vertical = false;
        loadProperties();
        this.fontType = 2;
        String baseName = getBaseName(str);
        if (!isCJKFont(baseName, str2)) {
            throw new DocumentException(MessageLocalization.getComposedMessage("font.1.with.2.encoding.is.not.a.cjk.font", str, str2));
        }
        if (baseName.length() < str.length()) {
            this.style = str.substring(baseName.length());
            str = baseName;
        }
        this.fontName = str;
        this.encoding = CJK_ENCODING;
        this.vertical = str2.endsWith("V");
        this.CMap = str2;
        if (str2.equals(BaseFont.IDENTITY_H) || str2.equals(BaseFont.IDENTITY_V)) {
            this.cidDirect = true;
        }
        loadCMaps();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUniMap() {
        return this.uniMap;
    }

    private void loadCMaps() throws DocumentException {
        try {
            this.fontDesc = allFonts.get(this.fontName);
            this.hMetrics = (IntHashtable) this.fontDesc.get("W");
            this.vMetrics = (IntHashtable) this.fontDesc.get("W2");
            this.uniMap = "";
            HashMap<String, Set<String>> hashMap = registryNames;
            for (String str : hashMap.get(((String) this.fontDesc.get("Registry")) + "_Uni")) {
                this.uniMap = str;
                if (str.endsWith("V")) {
                    if (this.vertical) {
                        break;
                    }
                }
                if (!str.endsWith("V") && !this.vertical) {
                    break;
                }
            }
            if (this.cidDirect) {
                this.cidUni = CMapCache.getCachedCMapCidUni(this.uniMap);
                return;
            }
            this.uniCid = CMapCache.getCachedCMapUniCid(this.uniMap);
            this.cidByte = CMapCache.getCachedCMapCidByte(this.CMap);
        } catch (Exception e) {
            throw new DocumentException(e);
        }
    }

    public static String GetCompatibleFont(String str) {
        String str2;
        loadProperties();
        Iterator<Map.Entry<String, Set<String>>> it = registryNames.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                str2 = null;
                break;
            }
            Map.Entry<String, Set<String>> next = it.next();
            if (next.getValue().contains(str)) {
                str2 = next.getKey();
                break;
            }
        }
        if (str2 == null) {
            return null;
        }
        for (Map.Entry<String, HashMap<String, Object>> entry : allFonts.entrySet()) {
            if (str2.equals(entry.getValue().get("Registry"))) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static boolean isCJKFont(String str, String str2) {
        loadProperties();
        if (registryNames.containsKey("fonts") && registryNames.get("fonts").contains(str)) {
            if (str2.equals(BaseFont.IDENTITY_H) || str2.equals(BaseFont.IDENTITY_V)) {
                return true;
            }
            Set<String> set = registryNames.get((String) allFonts.get(str).get("Registry"));
            return set != null && set.contains(str2);
        }
        return false;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getWidth(int i) {
        int i2;
        if (!this.cidDirect) {
            i = this.uniCid.lookup(i);
        }
        if (this.vertical) {
            i2 = this.vMetrics.get(i);
        } else {
            i2 = this.hMetrics.get(i);
        }
        if (i2 > 0) {
            return i2;
        }
        return 1000;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getWidth(String str) {
        int i;
        int charAt;
        int i2 = 0;
        if (this.cidDirect) {
            i = 0;
            while (i2 < str.length()) {
                i += getWidth(str.charAt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < str.length()) {
                if (Utilities.isSurrogatePair(str, i2)) {
                    charAt = Utilities.convertToUtf32(str, i2);
                    i2++;
                } else {
                    charAt = str.charAt(i2);
                }
                i += getWidth(charAt);
                i2++;
            }
        }
        return i;
    }

    private PdfDictionary getFontDescriptor() {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONTDESCRIPTOR);
        pdfDictionary.put(PdfName.ASCENT, new PdfLiteral((String) this.fontDesc.get("Ascent")));
        pdfDictionary.put(PdfName.CAPHEIGHT, new PdfLiteral((String) this.fontDesc.get("CapHeight")));
        pdfDictionary.put(PdfName.DESCENT, new PdfLiteral((String) this.fontDesc.get("Descent")));
        pdfDictionary.put(PdfName.FLAGS, new PdfLiteral((String) this.fontDesc.get("Flags")));
        pdfDictionary.put(PdfName.FONTBBOX, new PdfLiteral((String) this.fontDesc.get("FontBBox")));
        PdfName pdfName = PdfName.FONTNAME;
        pdfDictionary.put(pdfName, new PdfName(this.fontName + this.style));
        pdfDictionary.put(PdfName.ITALICANGLE, new PdfLiteral((String) this.fontDesc.get("ItalicAngle")));
        pdfDictionary.put(PdfName.STEMV, new PdfLiteral((String) this.fontDesc.get("StemV")));
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        pdfDictionary2.put(PdfName.PANOSE, new PdfString((String) this.fontDesc.get("Panose"), null));
        pdfDictionary.put(PdfName.STYLE, pdfDictionary2);
        return pdfDictionary;
    }

    private PdfDictionary getCIDFont(PdfIndirectReference pdfIndirectReference, IntHashtable intHashtable) {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONT);
        pdfDictionary.put(PdfName.SUBTYPE, PdfName.CIDFONTTYPE0);
        PdfName pdfName = PdfName.BASEFONT;
        pdfDictionary.put(pdfName, new PdfName(this.fontName + this.style));
        pdfDictionary.put(PdfName.FONTDESCRIPTOR, pdfIndirectReference);
        int[] orderedKeys = intHashtable.toOrderedKeys();
        String convertToHCIDMetrics = convertToHCIDMetrics(orderedKeys, this.hMetrics);
        if (convertToHCIDMetrics != null) {
            pdfDictionary.put(PdfName.f19791W, new PdfLiteral(convertToHCIDMetrics));
        }
        if (this.vertical) {
            String convertToVCIDMetrics = convertToVCIDMetrics(orderedKeys, this.vMetrics, this.hMetrics);
            if (convertToVCIDMetrics != null) {
                pdfDictionary.put(PdfName.f19792W2, new PdfLiteral(convertToVCIDMetrics));
            }
        } else {
            pdfDictionary.put(PdfName.f19709DW, new PdfNumber(1000));
        }
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        if (this.cidDirect) {
            pdfDictionary2.put(PdfName.REGISTRY, new PdfString(this.cidUni.getRegistry(), null));
            pdfDictionary2.put(PdfName.ORDERING, new PdfString(this.cidUni.getOrdering(), null));
            pdfDictionary2.put(PdfName.SUPPLEMENT, new PdfNumber(this.cidUni.getSupplement()));
        } else {
            pdfDictionary2.put(PdfName.REGISTRY, new PdfString(this.cidByte.getRegistry(), null));
            pdfDictionary2.put(PdfName.ORDERING, new PdfString(this.cidByte.getOrdering(), null));
            pdfDictionary2.put(PdfName.SUPPLEMENT, new PdfNumber(this.cidByte.getSupplement()));
        }
        pdfDictionary.put(PdfName.CIDSYSTEMINFO, pdfDictionary2);
        return pdfDictionary;
    }

    private PdfDictionary getFontBaseType(PdfIndirectReference pdfIndirectReference) {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONT);
        pdfDictionary.put(PdfName.SUBTYPE, PdfName.TYPE0);
        String str = this.fontName;
        if (this.style.length() > 0) {
            str = str + "-" + this.style.substring(1);
        }
        pdfDictionary.put(PdfName.BASEFONT, new PdfName(str + "-" + this.CMap));
        pdfDictionary.put(PdfName.ENCODING, new PdfName(this.CMap));
        pdfDictionary.put(PdfName.DESCENDANTFONTS, new PdfArray(pdfIndirectReference));
        return pdfDictionary;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.BaseFont
    public void writeFont(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, Object[] objArr) throws DocumentException, IOException {
        IntHashtable intHashtable = (IntHashtable) objArr[0];
        PdfDictionary fontDescriptor = getFontDescriptor();
        PdfIndirectReference indirectReference = fontDescriptor != null ? pdfWriter.addToBody(fontDescriptor).getIndirectReference() : null;
        PdfDictionary cIDFont = getCIDFont(indirectReference, intHashtable);
        if (cIDFont != null) {
            indirectReference = pdfWriter.addToBody(cIDFont).getIndirectReference();
        }
        pdfWriter.addToBody(getFontBaseType(indirectReference), pdfIndirectReference);
    }

    private float getDescNumber(String str) {
        return Integer.parseInt((String) this.fontDesc.get(str));
    }

    private float getBBox(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer((String) this.fontDesc.get("FontBBox"), " []\r\n\t\f");
        String nextToken = stringTokenizer.nextToken();
        for (int i2 = 0; i2 < i; i2++) {
            nextToken = stringTokenizer.nextToken();
        }
        return Integer.parseInt(nextToken);
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public float getFontDescriptor(int i, float f) {
        switch (i) {
            case 1:
            case 9:
                return (getDescNumber("Ascent") * f) / 1000.0f;
            case 2:
                return (getDescNumber("CapHeight") * f) / 1000.0f;
            case 3:
            case 10:
                return (getDescNumber("Descent") * f) / 1000.0f;
            case 4:
                return getDescNumber("ItalicAngle");
            case 5:
                return (f * getBBox(0)) / 1000.0f;
            case 6:
                return (f * getBBox(1)) / 1000.0f;
            case 7:
                return (f * getBBox(2)) / 1000.0f;
            case 8:
                return (f * getBBox(3)) / 1000.0f;
            case 11:
                return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            case 12:
                return (f * (getBBox(2) - getBBox(0))) / 1000.0f;
            default:
                return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String getPostscriptFontName() {
        return this.fontName;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getFullFontName() {
        return new String[][]{new String[]{"", "", "", this.fontName}};
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getAllNameEntries() {
        return new String[][]{new String[]{"4", "", "", "", this.fontName}};
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getFamilyFontName() {
        return getFullFontName();
    }

    static IntHashtable createMetric(String str) {
        IntHashtable intHashtable = new IntHashtable();
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        while (stringTokenizer.hasMoreTokens()) {
            intHashtable.put(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));
        }
        return intHashtable;
    }

    static String convertToHCIDMetrics(int[] iArr, IntHashtable intHashtable) {
        if (iArr.length == 0) {
            return null;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i >= iArr.length) {
                break;
            }
            i2 = iArr[i];
            i3 = intHashtable.get(i2);
            if (i3 != 0) {
                i++;
                break;
            }
            i++;
        }
        if (i3 == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(i2);
        int i4 = i2;
        char c = 0;
        while (i < iArr.length) {
            int i5 = iArr[i];
            int i6 = intHashtable.get(i5);
            if (i6 != 0) {
                switch (c) {
                    case 0:
                        int i7 = i4 + 1;
                        if (i5 != i7 || i6 != i3) {
                            if (i5 == i7) {
                                sb.append('[');
                                sb.append(i3);
                                c = 1;
                                break;
                            } else {
                                sb.append('[');
                                sb.append(i3);
                                sb.append(']');
                                sb.append(i5);
                                break;
                            }
                        } else {
                            c = 2;
                            break;
                        }
                    case 1:
                        int i8 = i4 + 1;
                        if (i5 != i8 || i6 != i3) {
                            if (i5 == i8) {
                                sb.append(TokenParser.f24154SP);
                                sb.append(i3);
                                break;
                            } else {
                                sb.append(TokenParser.f24154SP);
                                sb.append(i3);
                                sb.append(']');
                                sb.append(i5);
                                c = 0;
                                break;
                            }
                        } else {
                            sb.append(']');
                            sb.append(i4);
                            c = 2;
                            break;
                        }
                    case 2:
                        if (i5 != i4 + 1 || i6 != i3) {
                            sb.append(TokenParser.f24154SP);
                            sb.append(i4);
                            sb.append(TokenParser.f24154SP);
                            sb.append(i3);
                            sb.append(TokenParser.f24154SP);
                            sb.append(i5);
                            c = 0;
                            break;
                        }
                }
                i4 = i5;
                i3 = i6;
            }
            i++;
        }
        switch (c) {
            case 0:
                sb.append('[');
                sb.append(i3);
                sb.append("]]");
                break;
            case 1:
                sb.append(TokenParser.f24154SP);
                sb.append(i3);
                sb.append("]]");
                break;
            case 2:
                sb.append(TokenParser.f24154SP);
                sb.append(i4);
                sb.append(TokenParser.f24154SP);
                sb.append(i3);
                sb.append(']');
                break;
        }
        return sb.toString();
    }

    static String convertToVCIDMetrics(int[] iArr, IntHashtable intHashtable, IntHashtable intHashtable2) {
        if (iArr.length == 0) {
            return null;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i >= iArr.length) {
                break;
            }
            i4 = iArr[i];
            i2 = intHashtable.get(i4);
            if (i2 != 0) {
                i++;
                break;
            }
            i3 = intHashtable2.get(i4);
            i++;
        }
        if (i2 == 0) {
            return null;
        }
        if (i3 == 0) {
            i3 = 1000;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(i4);
        char c = 0;
        while (true) {
            char c2 = 2;
            if (i < iArr.length) {
                int i5 = iArr[i];
                int i6 = intHashtable.get(i5);
                if (i6 != 0) {
                    int i7 = intHashtable2.get(i4);
                    int i8 = i7 == 0 ? 1000 : i7;
                    if (c != 0) {
                        if (c == 2 && (i5 != i4 + 1 || i6 != i2 || i8 != i3)) {
                            sb.append(TokenParser.f24154SP);
                            sb.append(i4);
                            sb.append(TokenParser.f24154SP);
                            sb.append(-i2);
                            sb.append(TokenParser.f24154SP);
                            sb.append(i3 / 2);
                            sb.append(TokenParser.f24154SP);
                            sb.append(V1Y);
                            sb.append(TokenParser.f24154SP);
                            sb.append(i5);
                            c2 = 0;
                            i3 = i8;
                            i4 = i5;
                            c = c2;
                            i2 = i6;
                        }
                        c2 = c;
                        i3 = i8;
                        i4 = i5;
                        c = c2;
                        i2 = i6;
                    } else {
                        if (i5 != i4 + 1 || i6 != i2 || i8 != i3) {
                            sb.append(TokenParser.f24154SP);
                            sb.append(i4);
                            sb.append(TokenParser.f24154SP);
                            sb.append(-i2);
                            sb.append(TokenParser.f24154SP);
                            sb.append(i3 / 2);
                            sb.append(TokenParser.f24154SP);
                            sb.append(V1Y);
                            sb.append(TokenParser.f24154SP);
                            sb.append(i5);
                            c2 = c;
                        }
                        i3 = i8;
                        i4 = i5;
                        c = c2;
                        i2 = i6;
                    }
                }
                i++;
            } else {
                sb.append(TokenParser.f24154SP);
                sb.append(i4);
                sb.append(TokenParser.f24154SP);
                sb.append(-i2);
                sb.append(TokenParser.f24154SP);
                sb.append(i3 / 2);
                sb.append(TokenParser.f24154SP);
                sb.append(V1Y);
                sb.append(" ]");
                return sb.toString();
            }
        }
    }

    private static HashMap<String, Object> readFontProperties(String str) throws IOException {
        InputStream resourceStream = getResourceStream(RESOURCE_PATH_CMAP.concat(String.valueOf(str + ".properties")));
        Properties properties = new Properties();
        properties.load(resourceStream);
        resourceStream.close();
        IntHashtable createMetric = createMetric(properties.getProperty("W"));
        properties.remove("W");
        IntHashtable createMetric2 = createMetric(properties.getProperty("W2"));
        properties.remove("W2");
        HashMap<String, Object> hashMap = new HashMap<>();
        Enumeration keys = properties.keys();
        while (keys.hasMoreElements()) {
            String str2 = (String) keys.nextElement();
            hashMap.put(str2, properties.getProperty(str2));
        }
        hashMap.put("W", createMetric);
        hashMap.put("W2", createMetric2);
        return hashMap;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getUnicodeEquivalent(int i) {
        if (this.cidDirect) {
            if (i == 32767) {
                return 10;
            }
            return this.cidUni.lookup(i);
        }
        return i;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getCidCode(int i) {
        return this.cidDirect ? i : this.uniCid.lookup(i);
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean charExists(int i) {
        return this.cidDirect || this.cidByte.lookup(this.uniCid.lookup(i)).length > 0;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public void setPostscriptFontName(String str) {
        this.fontName = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.BaseFont
    public byte[] convertToBytes(String str) {
        int charAt;
        if (this.cidDirect) {
            return super.convertToBytes(str);
        }
        try {
            int i = 0;
            if (str.length() == 1) {
                return convertToBytes(str.charAt(0));
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (i < str.length()) {
                if (Utilities.isSurrogatePair(str, i)) {
                    charAt = Utilities.convertToUtf32(str, i);
                    i++;
                } else {
                    charAt = str.charAt(i);
                }
                byteArrayOutputStream.write(convertToBytes(charAt));
                i++;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.BaseFont
    public byte[] convertToBytes(int i) {
        if (this.cidDirect) {
            return super.convertToBytes(i);
        }
        return this.cidByte.lookup(this.uniCid.lookup(i));
    }

    public boolean isIdentity() {
        return this.cidDirect;
    }
}
