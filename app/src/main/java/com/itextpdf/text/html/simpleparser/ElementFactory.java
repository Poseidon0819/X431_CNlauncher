package com.itextpdf.text.html.simpleparser;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocListener;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.FontProvider;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.html.HtmlUtilities;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.HyphenationAuto;
import com.itextpdf.text.pdf.HyphenationEvent;
import com.mopub.common.Constants;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class ElementFactory {
    private FontProvider provider = FontFactory.getFontImp();

    public void setFontProvider(FontProvider fontProvider) {
        this.provider = fontProvider;
    }

    public FontProvider getFontProvider() {
        return this.provider;
    }

    public Font getFont(ChainedProperties chainedProperties) {
        String str;
        String property = chainedProperties.getProperty(HtmlTags.FACE);
        if (property == null || property.trim().length() == 0) {
            property = chainedProperties.getProperty(HtmlTags.FONTFAMILY);
        }
        int i = 0;
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ",");
            while (true) {
                if (!stringTokenizer.hasMoreTokens()) {
                    str = property;
                    break;
                }
                property = stringTokenizer.nextToken().trim();
                if (property.startsWith("\"")) {
                    property = property.substring(1);
                }
                if (property.endsWith("\"")) {
                    property = property.substring(0, property.length() - 1);
                }
                if (this.provider.isRegistered(property)) {
                    str = property;
                    break;
                }
            }
        } else {
            str = property;
        }
        String property2 = chainedProperties.getProperty(HtmlTags.ENCODING);
        String str2 = property2 == null ? "Cp1252" : property2;
        String property3 = chainedProperties.getProperty(HtmlTags.SIZE);
        float parseFloat = property3 != null ? Float.parseFloat(property3) : 12.0f;
        String property4 = chainedProperties.getProperty(HtmlTags.TEXTDECORATION);
        if (property4 != null && property4.trim().length() != 0) {
            if (HtmlTags.UNDERLINE.equals(property4)) {
                i = 4;
            } else if (HtmlTags.LINETHROUGH.equals(property4)) {
                i = 8;
            }
        }
        if (chainedProperties.hasProperty(HtmlTags.f19629I)) {
            i |= 2;
        }
        if (chainedProperties.hasProperty(HtmlTags.f19619B)) {
            i |= 1;
        }
        if (chainedProperties.hasProperty(HtmlTags.f19637U)) {
            i |= 4;
        }
        return this.provider.getFont(str, str2, true, parseFloat, chainedProperties.hasProperty(HtmlTags.f19633S) ? i | 8 : i, HtmlUtilities.decodeColor(chainedProperties.getProperty(HtmlTags.COLOR)));
    }

    public Chunk createChunk(String str, ChainedProperties chainedProperties) {
        Font font = getFont(chainedProperties);
        Chunk chunk = new Chunk(str, font);
        if (chainedProperties.hasProperty(HtmlTags.SUB)) {
            chunk.setTextRise((-font.getSize()) / 2.0f);
        } else if (chainedProperties.hasProperty(HtmlTags.SUP)) {
            chunk.setTextRise(font.getSize() / 2.0f);
        }
        chunk.setHyphenation(getHyphenation(chainedProperties));
        return chunk;
    }

    public Paragraph createParagraph(ChainedProperties chainedProperties) {
        Paragraph paragraph = new Paragraph();
        updateElement(paragraph, chainedProperties);
        return paragraph;
    }

    public ListItem createListItem(ChainedProperties chainedProperties) {
        ListItem listItem = new ListItem();
        updateElement(listItem, chainedProperties);
        return listItem;
    }

    protected void updateElement(Paragraph paragraph, ChainedProperties chainedProperties) {
        paragraph.setAlignment(HtmlUtilities.alignmentValue(chainedProperties.getProperty(HtmlTags.ALIGN)));
        paragraph.setHyphenation(getHyphenation(chainedProperties));
        setParagraphLeading(paragraph, chainedProperties.getProperty(HtmlTags.LEADING));
        String property = chainedProperties.getProperty(HtmlTags.AFTER);
        if (property != null) {
            try {
                paragraph.setSpacingBefore(Float.parseFloat(property));
            } catch (Exception unused) {
            }
        }
        String property2 = chainedProperties.getProperty(HtmlTags.AFTER);
        if (property2 != null) {
            try {
                paragraph.setSpacingAfter(Float.parseFloat(property2));
            } catch (Exception unused2) {
            }
        }
        String property3 = chainedProperties.getProperty(HtmlTags.EXTRAPARASPACE);
        if (property3 != null) {
            try {
                paragraph.setExtraParagraphSpace(Float.parseFloat(property3));
            } catch (Exception unused3) {
            }
        }
        String property4 = chainedProperties.getProperty(HtmlTags.INDENT);
        if (property4 != null) {
            try {
                paragraph.setIndentationLeft(Float.parseFloat(property4));
            } catch (Exception unused4) {
            }
        }
    }

    protected static void setParagraphLeading(Paragraph paragraph, String str) {
        if (str == null) {
            paragraph.setLeading(ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.5f);
            return;
        }
        try {
            StringTokenizer stringTokenizer = new StringTokenizer(str, " ,");
            float parseFloat = Float.parseFloat(stringTokenizer.nextToken());
            if (!stringTokenizer.hasMoreTokens()) {
                paragraph.setLeading(parseFloat, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
            } else {
                paragraph.setLeading(parseFloat, Float.parseFloat(stringTokenizer.nextToken()));
            }
        } catch (Exception unused) {
            paragraph.setLeading(ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.5f);
        }
    }

    public HyphenationEvent getHyphenation(ChainedProperties chainedProperties) {
        int parseInt;
        String property = chainedProperties.getProperty(HtmlTags.HYPHENATION);
        if (property == null || property.length() == 0) {
            return null;
        }
        int indexOf = property.indexOf(95);
        int i = 2;
        if (indexOf == -1) {
            return new HyphenationAuto(property, null, 2, 2);
        }
        String substring = property.substring(0, indexOf);
        String substring2 = property.substring(indexOf + 1);
        int indexOf2 = substring2.indexOf(44);
        if (indexOf2 == -1) {
            return new HyphenationAuto(substring, substring2, 2, 2);
        }
        String substring3 = substring2.substring(indexOf2 + 1);
        String substring4 = substring2.substring(0, indexOf2);
        int indexOf3 = substring3.indexOf(44);
        if (indexOf3 == -1) {
            parseInt = Integer.parseInt(substring3);
        } else {
            parseInt = Integer.parseInt(substring3.substring(0, indexOf3));
            i = Integer.parseInt(substring3.substring(indexOf3 + 1));
        }
        return new HyphenationAuto(substring, substring4, parseInt, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.itextpdf.text.pdf.draw.LineSeparator createLineSeparator(java.util.Map<java.lang.String, java.lang.String> r10, float r11) {
        /*
            r9 = this;
            java.lang.String r0 = "size"
            java.lang.Object r0 = r10.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r1 = 0
            r2 = 1094713344(0x41400000, float:12.0)
            if (r0 == 0) goto L17
            float r0 = com.itextpdf.text.html.HtmlUtilities.parseLength(r0, r2)
            int r3 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r3 <= 0) goto L17
            r4 = r0
            goto L1b
        L17:
            r0 = 1065353216(0x3f800000, float:1.0)
            r4 = 1065353216(0x3f800000, float:1.0)
        L1b:
            java.lang.String r0 = "width"
            java.lang.Object r0 = r10.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r3 = 1120403456(0x42c80000, float:100.0)
            if (r0 == 0) goto L3f
            float r2 = com.itextpdf.text.html.HtmlUtilities.parseLength(r0, r2)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 <= 0) goto L30
            goto L32
        L30:
            r2 = 1120403456(0x42c80000, float:100.0)
        L32:
            java.lang.String r1 = "%"
            boolean r0 = r0.endsWith(r1)
            if (r0 != 0) goto L3d
            r5 = 1120403456(0x42c80000, float:100.0)
            goto L41
        L3d:
            r5 = r2
            goto L41
        L3f:
            r5 = 1120403456(0x42c80000, float:100.0)
        L41:
            java.lang.String r0 = "align"
            java.lang.Object r10 = r10.get(r0)
            java.lang.String r10 = (java.lang.String) r10
            int r7 = com.itextpdf.text.html.HtmlUtilities.alignmentValue(r10)
            com.itextpdf.text.pdf.draw.LineSeparator r10 = new com.itextpdf.text.pdf.draw.LineSeparator
            r6 = 0
            r3 = r10
            r8 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.html.simpleparser.ElementFactory.createLineSeparator(java.util.Map, float):com.itextpdf.text.pdf.draw.LineSeparator");
    }

    public Image createImage(String str, Map<String, String> map, ChainedProperties chainedProperties, DocListener docListener, ImageProvider imageProvider, HashMap<String, Image> hashMap, String str2) throws DocumentException, IOException {
        Image image;
        Image image2 = imageProvider != null ? imageProvider.getImage(str, map, chainedProperties, docListener) : null;
        if (image2 == null && hashMap != null && (image = hashMap.get(str)) != null) {
            image2 = Image.getInstance(image);
        }
        if (image2 != null) {
            return image2;
        }
        if (!str.startsWith(Constants.HTTP) && str2 != null) {
            str = str2 + str;
        } else if (image2 == null && !str.startsWith(Constants.HTTP)) {
            String property = chainedProperties.getProperty(HtmlTags.IMAGEPATH);
            if (property == null) {
                property = "";
            }
            str = new File(property, str).getPath();
        }
        Image image3 = Image.getInstance(str);
        if (image3 == null) {
            return null;
        }
        float parseLength = HtmlUtilities.parseLength(chainedProperties.getProperty(HtmlTags.SIZE), 12.0f);
        if (parseLength <= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            parseLength = 12.0f;
        }
        float parseLength2 = HtmlUtilities.parseLength(map.get("width"), parseLength);
        float parseLength3 = HtmlUtilities.parseLength(map.get("height"), parseLength);
        if (parseLength2 > ColumnText.GLOBAL_SPACE_CHAR_RATIO && parseLength3 > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            image3.scaleAbsolute(parseLength2, parseLength3);
        } else if (parseLength2 > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            image3.scaleAbsolute(parseLength2, (image3.getHeight() * parseLength2) / image3.getWidth());
        } else if (parseLength3 > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            image3.scaleAbsolute((image3.getWidth() * parseLength3) / image3.getHeight(), parseLength3);
        }
        String property2 = chainedProperties.getProperty(HtmlTags.BEFORE);
        if (property2 != null) {
            image3.setSpacingBefore(Float.parseFloat(property2));
        }
        String property3 = chainedProperties.getProperty(HtmlTags.AFTER);
        if (property3 != null) {
            image3.setSpacingAfter(Float.parseFloat(property3));
        }
        image3.setWidthPercentage(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        return image3;
    }

    public List createList(String str, ChainedProperties chainedProperties) {
        List list;
        if (HtmlTags.f19638UL.equalsIgnoreCase(str)) {
            list = new List(false);
            list.setListSymbol("• ");
        } else {
            list = new List(true);
        }
        try {
            list.setIndentationLeft(new Float(chainedProperties.getProperty(HtmlTags.INDENT)).floatValue());
        } catch (Exception unused) {
            list.setAutoindent(true);
        }
        return list;
    }
}
