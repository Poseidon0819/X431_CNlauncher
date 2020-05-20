package com.itextpdf.text.pdf.codec.wmf;

import com.itextpdf.text.Document;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.BaseFont;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class MetaFont extends MetaObject {
    static final int BOLDTHRESHOLD = 600;
    static final int DEFAULT_PITCH = 0;
    static final int ETO_CLIPPED = 4;
    static final int ETO_OPAQUE = 2;
    static final int FF_DECORATIVE = 5;
    static final int FF_DONTCARE = 0;
    static final int FF_MODERN = 3;
    static final int FF_ROMAN = 1;
    static final int FF_SCRIPT = 4;
    static final int FF_SWISS = 2;
    static final int FIXED_PITCH = 1;
    static final int MARKER_BOLD = 1;
    static final int MARKER_COURIER = 0;
    static final int MARKER_HELVETICA = 4;
    static final int MARKER_ITALIC = 2;
    static final int MARKER_SYMBOL = 12;
    static final int MARKER_TIMES = 8;
    static final int VARIABLE_PITCH = 2;
    static final String[] fontNames = {"Courier", "Courier-Bold", "Courier-Oblique", "Courier-BoldOblique", "Helvetica", "Helvetica-Bold", "Helvetica-Oblique", "Helvetica-BoldOblique", "Times-Roman", "Times-Bold", "Times-Italic", "Times-BoldItalic", "Symbol", "ZapfDingbats"};
    static final int nameSize = 32;
    float angle;
    int bold;
    int charset;
    String faceName = "arial";
    BaseFont font = null;
    int height;
    int italic;
    int pitchAndFamily;
    boolean strikeout;
    boolean underline;

    public MetaFont() {
        this.type = 3;
    }

    public void init(InputMeta inputMeta) throws IOException {
        this.height = Math.abs(inputMeta.readShort());
        inputMeta.skip(2);
        double readShort = inputMeta.readShort();
        Double.isNaN(readShort);
        this.angle = (float) ((readShort / 1800.0d) * 3.141592653589793d);
        inputMeta.skip(2);
        this.bold = inputMeta.readShort() >= BOLDTHRESHOLD ? 1 : 0;
        this.italic = inputMeta.readByte() == 0 ? 0 : 2;
        this.underline = inputMeta.readByte() != 0;
        this.strikeout = inputMeta.readByte() != 0;
        this.charset = inputMeta.readByte();
        inputMeta.skip(3);
        this.pitchAndFamily = inputMeta.readByte();
        byte[] bArr = new byte[32];
        int i = 0;
        while (i < 32) {
            int readByte = inputMeta.readByte();
            if (readByte != 0) {
                bArr[i] = (byte) readByte;
                i++;
            }
        }
        try {
            this.faceName = new String(bArr, 0, i, "Cp1252");
        } catch (UnsupportedEncodingException unused) {
            this.faceName = new String(bArr, 0, i);
        }
        this.faceName = this.faceName.toLowerCase();
    }

    public BaseFont getFont() {
        String str;
        BaseFont baseFont = this.font;
        if (baseFont != null) {
            return baseFont;
        }
        this.font = FontFactory.getFont(this.faceName, "Cp1252", true, 10.0f, (this.italic != 0 ? 2 : 0) | (this.bold != 0 ? 1 : 0)).getBaseFont();
        BaseFont baseFont2 = this.font;
        if (baseFont2 != null) {
            return baseFont2;
        }
        if (this.faceName.indexOf("courier") != -1 || this.faceName.indexOf("terminal") != -1 || this.faceName.indexOf("fixedsys") != -1) {
            str = fontNames[this.italic + 0 + this.bold];
        } else if (this.faceName.indexOf("ms sans serif") != -1 || this.faceName.indexOf("arial") != -1 || this.faceName.indexOf("system") != -1) {
            str = fontNames[this.italic + 4 + this.bold];
        } else if (this.faceName.indexOf("arial black") != -1) {
            str = fontNames[this.italic + 4 + 1];
        } else if (this.faceName.indexOf("times") != -1 || this.faceName.indexOf("ms serif") != -1 || this.faceName.indexOf("roman") != -1) {
            str = fontNames[this.italic + 8 + this.bold];
        } else if (this.faceName.indexOf("symbol") != -1) {
            str = fontNames[12];
        } else {
            int i = this.pitchAndFamily;
            int i2 = i & 3;
            switch ((i >> 4) & 7) {
                case 1:
                    str = fontNames[this.italic + 8 + this.bold];
                    break;
                case 2:
                case 4:
                case 5:
                    str = fontNames[this.italic + 4 + this.bold];
                    break;
                case 3:
                    str = fontNames[this.italic + 0 + this.bold];
                    break;
                default:
                    if (i2 == 1) {
                        str = fontNames[this.italic + 0 + this.bold];
                        break;
                    } else {
                        str = fontNames[this.italic + 4 + this.bold];
                        break;
                    }
            }
        }
        try {
            this.font = BaseFont.createFont(str, "Cp1252", false);
            return this.font;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public float getAngle() {
        return this.angle;
    }

    public boolean isUnderline() {
        return this.underline;
    }

    public boolean isStrikeout() {
        return this.strikeout;
    }

    public float getFontSize(MetaState metaState) {
        return Math.abs(metaState.transformY(this.height) - metaState.transformY(0)) * Document.wmfFontCorrection;
    }
}
