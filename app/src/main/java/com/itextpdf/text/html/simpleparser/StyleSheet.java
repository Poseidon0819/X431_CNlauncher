package com.itextpdf.text.html.simpleparser;

import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.html.HtmlUtilities;
import com.itextpdf.text.pdf.ColumnText;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* loaded from: classes.dex */
public class StyleSheet {
    protected Map<String, Map<String, String>> tagMap = new HashMap();
    protected Map<String, Map<String, String>> classMap = new HashMap();

    public void loadTagStyle(String str, Map<String, String> map) {
        this.tagMap.put(str.toLowerCase(), map);
    }

    public void loadTagStyle(String str, String str2, String str3) {
        String lowerCase = str.toLowerCase();
        Map<String, String> map = this.tagMap.get(lowerCase);
        if (map == null) {
            map = new HashMap<>();
            this.tagMap.put(lowerCase, map);
        }
        map.put(str2, str3);
    }

    public void loadStyle(String str, HashMap<String, String> hashMap) {
        this.classMap.put(str.toLowerCase(), hashMap);
    }

    public void loadStyle(String str, String str2, String str3) {
        String lowerCase = str.toLowerCase();
        Map<String, String> map = this.classMap.get(lowerCase);
        if (map == null) {
            map = new HashMap<>();
            this.classMap.put(lowerCase, map);
        }
        map.put(str2, str3);
    }

    public void applyStyle(String str, Map<String, String> map) {
        Map<String, String> map2;
        Map<String, String> map3 = this.tagMap.get(str.toLowerCase());
        if (map3 != null) {
            HashMap hashMap = new HashMap(map3);
            hashMap.putAll(map);
            map.putAll(hashMap);
        }
        String str2 = map.get(HtmlTags.CLASS);
        if (str2 == null || (map2 = this.classMap.get(str2.toLowerCase())) == null) {
            return;
        }
        map.remove(HtmlTags.CLASS);
        HashMap hashMap2 = new HashMap(map2);
        hashMap2.putAll(map);
        map.putAll(hashMap2);
    }

    public static void resolveStyleAttribute(Map<String, String> map, ChainedProperties chainedProperties) {
        String str = map.get(HtmlTags.STYLE);
        if (str == null) {
            return;
        }
        Properties parseAttributes = HtmlUtilities.parseAttributes(str);
        for (String str2 : parseAttributes.keySet()) {
            if (str2.equals(HtmlTags.FONTFAMILY)) {
                map.put(HtmlTags.FACE, parseAttributes.getProperty(str2));
            } else if (str2.equals(HtmlTags.FONTSIZE)) {
                float parseLength = HtmlUtilities.parseLength(chainedProperties.getProperty(HtmlTags.SIZE), 12.0f);
                if (parseLength <= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                    parseLength = 12.0f;
                }
                map.put(HtmlTags.SIZE, Float.toString(HtmlUtilities.parseLength(parseAttributes.getProperty(str2), parseLength)) + "pt");
            } else if (str2.equals(HtmlTags.FONTSTYLE)) {
                String lowerCase = parseAttributes.getProperty(str2).trim().toLowerCase();
                if (lowerCase.equals(HtmlTags.ITALIC) || lowerCase.equals(HtmlTags.OBLIQUE)) {
                    map.put(HtmlTags.f19629I, null);
                }
            } else if (str2.equals(HtmlTags.FONTWEIGHT)) {
                String lowerCase2 = parseAttributes.getProperty(str2).trim().toLowerCase();
                if (lowerCase2.equals(HtmlTags.BOLD) || lowerCase2.equals(DiagnoseConstants.UI_TYPE_FAULTCODE) || lowerCase2.equals(DiagnoseConstants.UI_TYPE_DATASTREAM) || lowerCase2.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM)) {
                    map.put(HtmlTags.f19619B, null);
                }
            } else if (str2.equals(HtmlTags.TEXTDECORATION)) {
                if (parseAttributes.getProperty(str2).trim().toLowerCase().equals(HtmlTags.UNDERLINE)) {
                    map.put(HtmlTags.f19637U, null);
                }
            } else if (str2.equals(HtmlTags.COLOR)) {
                BaseColor decodeColor = HtmlUtilities.decodeColor(parseAttributes.getProperty(str2));
                if (decodeColor != null) {
                    String concat = "000000".concat(String.valueOf(Integer.toHexString(decodeColor.getRGB())));
                    map.put(HtmlTags.COLOR, "#" + concat.substring(concat.length() - 6));
                }
            } else if (str2.equals(HtmlTags.LINEHEIGHT)) {
                String trim = parseAttributes.getProperty(str2).trim();
                float parseLength2 = HtmlUtilities.parseLength(chainedProperties.getProperty(HtmlTags.SIZE), 12.0f);
                float parseLength3 = HtmlUtilities.parseLength(parseAttributes.getProperty(str2), parseLength2 > ColumnText.GLOBAL_SPACE_CHAR_RATIO ? parseLength2 : 12.0f);
                if (trim.endsWith("%")) {
                    map.put(HtmlTags.LEADING, "0," + (parseLength3 / 100.0f));
                    return;
                } else if (HtmlTags.NORMAL.equalsIgnoreCase(trim)) {
                    map.put(HtmlTags.LEADING, "0,1.5");
                    return;
                } else {
                    map.put(HtmlTags.LEADING, parseLength3 + ",0");
                }
            } else if (str2.equals(HtmlTags.TEXTALIGN)) {
                map.put(HtmlTags.ALIGN, parseAttributes.getProperty(str2).trim().toLowerCase());
            } else if (str2.equals(HtmlTags.PADDINGLEFT)) {
                map.put(HtmlTags.INDENT, Float.toString(HtmlUtilities.parseLength(parseAttributes.getProperty(str2).trim().toLowerCase())));
            }
        }
    }
}
