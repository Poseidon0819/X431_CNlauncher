package com.itextpdf.text;

import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.pdf.BaseFont;

/* loaded from: classes.dex */
public class Font implements Comparable<Font> {
    public static final int BOLD = 1;
    public static final int BOLDITALIC = 3;
    public static final int DEFAULTSIZE = 12;
    public static final int ITALIC = 2;
    public static final int NORMAL = 0;
    public static final int STRIKETHRU = 8;
    public static final int UNDEFINED = -1;
    public static final int UNDERLINE = 4;
    private BaseFont baseFont;
    private BaseColor color;
    private FontFamily family;
    private float size;
    private int style;

    /* loaded from: classes.dex */
    public enum FontFamily {
        COURIER,
        HELVETICA,
        TIMES_ROMAN,
        SYMBOL,
        ZAPFDINGBATS,
        UNDEFINED
    }

    /* loaded from: classes.dex */
    public enum FontStyle {
        NORMAL(HtmlTags.NORMAL),
        BOLD(HtmlTags.BOLD),
        ITALIC(HtmlTags.ITALIC),
        OBLIQUE(HtmlTags.OBLIQUE),
        UNDERLINE(HtmlTags.UNDERLINE),
        LINETHROUGH(HtmlTags.LINETHROUGH);
        
        private String code;

        FontStyle(String str) {
            this.code = str;
        }

        public final String getValue() {
            return this.code;
        }
    }

    public Font(Font font) {
        this.family = FontFamily.UNDEFINED;
        this.size = -1.0f;
        this.style = -1;
        this.color = null;
        this.baseFont = null;
        this.family = font.family;
        this.size = font.size;
        this.style = font.style;
        this.color = font.color;
        this.baseFont = font.baseFont;
    }

    public Font(FontFamily fontFamily, float f, int i, BaseColor baseColor) {
        this.family = FontFamily.UNDEFINED;
        this.size = -1.0f;
        this.style = -1;
        this.color = null;
        this.baseFont = null;
        this.family = fontFamily;
        this.size = f;
        this.style = i;
        this.color = baseColor;
    }

    public Font(BaseFont baseFont, float f, int i, BaseColor baseColor) {
        this.family = FontFamily.UNDEFINED;
        this.size = -1.0f;
        this.style = -1;
        this.color = null;
        this.baseFont = null;
        this.baseFont = baseFont;
        this.size = f;
        this.style = i;
        this.color = baseColor;
    }

    public Font(BaseFont baseFont, float f, int i) {
        this(baseFont, f, i, (BaseColor) null);
    }

    public Font(BaseFont baseFont, float f) {
        this(baseFont, f, -1, (BaseColor) null);
    }

    public Font(BaseFont baseFont) {
        this(baseFont, -1.0f, -1, (BaseColor) null);
    }

    public Font(FontFamily fontFamily, float f, int i) {
        this(fontFamily, f, i, (BaseColor) null);
    }

    public Font(FontFamily fontFamily, float f) {
        this(fontFamily, f, -1, (BaseColor) null);
    }

    public Font(FontFamily fontFamily) {
        this(fontFamily, -1.0f, -1, (BaseColor) null);
    }

    public Font() {
        this(FontFamily.UNDEFINED, -1.0f, -1, (BaseColor) null);
    }

    @Override // java.lang.Comparable
    public int compareTo(Font font) {
        if (font == null) {
            return -1;
        }
        try {
            if (this.baseFont == null || this.baseFont.equals(font.getBaseFont())) {
                if (this.family != font.getFamily()) {
                    return 1;
                }
                if (this.size != font.getSize()) {
                    return 2;
                }
                if (this.style != font.getStyle()) {
                    return 3;
                }
                return this.color == null ? font.color == null ? 0 : 4 : (font.color != null && this.color.equals(font.getColor())) ? 0 : 4;
            }
            return -2;
        } catch (ClassCastException unused) {
            return -3;
        }
    }

    public FontFamily getFamily() {
        return this.family;
    }

    public String getFamilyname() {
        String[][] familyFontName;
        String str = Meta.UNKNOWN;
        switch (getFamily()) {
            case COURIER:
                return "Courier";
            case HELVETICA:
                return "Helvetica";
            case TIMES_ROMAN:
                return "Times-Roman";
            case SYMBOL:
                return "Symbol";
            case ZAPFDINGBATS:
                return "ZapfDingbats";
            default:
                BaseFont baseFont = this.baseFont;
                if (baseFont != null) {
                    for (String[] strArr : baseFont.getFamilyFontName()) {
                        if ("0".equals(strArr[2])) {
                            return strArr[3];
                        }
                        if ("1033".equals(strArr[2])) {
                            str = strArr[3];
                        }
                        if ("".equals(strArr[2])) {
                            str = strArr[3];
                        }
                    }
                }
                return str;
        }
    }

    public void setFamily(String str) {
        this.family = getFamily(str);
    }

    public static FontFamily getFamily(String str) {
        if (str.equalsIgnoreCase("Courier")) {
            return FontFamily.COURIER;
        }
        if (str.equalsIgnoreCase("Helvetica")) {
            return FontFamily.HELVETICA;
        }
        if (str.equalsIgnoreCase("Times-Roman")) {
            return FontFamily.TIMES_ROMAN;
        }
        if (str.equalsIgnoreCase("Symbol")) {
            return FontFamily.SYMBOL;
        }
        if (str.equalsIgnoreCase("ZapfDingbats")) {
            return FontFamily.ZAPFDINGBATS;
        }
        return FontFamily.UNDEFINED;
    }

    public float getSize() {
        return this.size;
    }

    public float getCalculatedSize() {
        float f = this.size;
        if (f == -1.0f) {
            return 12.0f;
        }
        return f;
    }

    public float getCalculatedLeading(float f) {
        return f * getCalculatedSize();
    }

    public void setSize(float f) {
        this.size = f;
    }

    public int getStyle() {
        return this.style;
    }

    public int getCalculatedStyle() {
        int i = this.style;
        if (i == -1) {
            i = 0;
        }
        return (this.baseFont != null || this.family == FontFamily.SYMBOL || this.family == FontFamily.ZAPFDINGBATS) ? i : i & (-4);
    }

    public boolean isBold() {
        int i = this.style;
        return i != -1 && (i & 1) == 1;
    }

    public boolean isItalic() {
        int i = this.style;
        return i != -1 && (i & 2) == 2;
    }

    public boolean isUnderlined() {
        int i = this.style;
        return i != -1 && (i & 4) == 4;
    }

    public boolean isStrikethru() {
        int i = this.style;
        return i != -1 && (i & 8) == 8;
    }

    public void setStyle(int i) {
        this.style = i;
    }

    public void setStyle(String str) {
        if (this.style == -1) {
            this.style = 0;
        }
        this.style = getStyleValue(str) | this.style;
    }

    public static int getStyleValue(String str) {
        str.indexOf(FontStyle.NORMAL.getValue());
        int i = str.indexOf(FontStyle.BOLD.getValue()) != -1 ? 1 : 0;
        if (str.indexOf(FontStyle.ITALIC.getValue()) != -1) {
            i |= 2;
        }
        if (str.indexOf(FontStyle.OBLIQUE.getValue()) != -1) {
            i |= 2;
        }
        if (str.indexOf(FontStyle.UNDERLINE.getValue()) != -1) {
            i |= 4;
        }
        return str.indexOf(FontStyle.LINETHROUGH.getValue()) != -1 ? i | 8 : i;
    }

    public BaseColor getColor() {
        return this.color;
    }

    public void setColor(BaseColor baseColor) {
        this.color = baseColor;
    }

    public void setColor(int i, int i2, int i3) {
        this.color = new BaseColor(i, i2, i3);
    }

    public BaseFont getBaseFont() {
        return this.baseFont;
    }

    public BaseFont getCalculatedBaseFont(boolean z) {
        String str;
        BaseFont baseFont = this.baseFont;
        if (baseFont != null) {
            return baseFont;
        }
        int i = this.style;
        if (i == -1) {
            i = 0;
        }
        String str2 = "Cp1252";
        int i2 = C36141.$SwitchMap$com$itextpdf$text$Font$FontFamily[this.family.ordinal()];
        if (i2 == 1) {
            switch (i & 3) {
                case 1:
                    str = "Courier-Bold";
                    break;
                case 2:
                    str = "Courier-Oblique";
                    break;
                case 3:
                    str = "Courier-BoldOblique";
                    break;
                default:
                    str = "Courier";
                    break;
            }
        } else {
            switch (i2) {
                case 3:
                    switch (i & 3) {
                        case 1:
                            str = "Times-Bold";
                            break;
                        case 2:
                            str = "Times-Italic";
                            break;
                        case 3:
                            str = "Times-BoldItalic";
                            break;
                        default:
                            str = "Times-Roman";
                            break;
                    }
                case 4:
                    if (!z) {
                        str = "Symbol";
                        break;
                    } else {
                        str2 = "Symbol";
                        str = "Symbol";
                        break;
                    }
                case 5:
                    if (!z) {
                        str = "ZapfDingbats";
                        break;
                    } else {
                        str2 = "ZapfDingbats";
                        str = "ZapfDingbats";
                        break;
                    }
                default:
                    switch (i & 3) {
                        case 1:
                            str = "Helvetica-Bold";
                            break;
                        case 2:
                            str = "Helvetica-Oblique";
                            break;
                        case 3:
                            str = "Helvetica-BoldOblique";
                            break;
                        default:
                            str = "Helvetica";
                            break;
                    }
            }
        }
        try {
            return BaseFont.createFont(str, str2, false);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean isStandardFont() {
        return this.family == FontFamily.UNDEFINED && this.size == -1.0f && this.style == -1 && this.color == null && this.baseFont == null;
    }

    public Font difference(Font font) {
        if (font == null) {
            return this;
        }
        float f = font.size;
        if (f == -1.0f) {
            f = this.size;
        }
        int i = this.style;
        int style = font.getStyle();
        int i2 = -1;
        if (i != -1 || style != -1) {
            if (i == -1) {
                i = 0;
            }
            if (style == -1) {
                style = 0;
            }
            i2 = i | style;
        }
        BaseColor baseColor = font.color;
        if (baseColor == null) {
            baseColor = this.color;
        }
        BaseFont baseFont = font.baseFont;
        if (baseFont != null) {
            return new Font(baseFont, f, i2, baseColor);
        }
        if (font.getFamily() != FontFamily.UNDEFINED) {
            return new Font(font.family, f, i2, baseColor);
        }
        BaseFont baseFont2 = this.baseFont;
        if (baseFont2 != null) {
            if (i2 == i) {
                return new Font(baseFont2, f, i2, baseColor);
            }
            return FontFactory.getFont(getFamilyname(), f, i2, baseColor);
        }
        return new Font(this.family, f, i2, baseColor);
    }
}
