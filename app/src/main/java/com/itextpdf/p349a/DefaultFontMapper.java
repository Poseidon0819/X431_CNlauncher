package com.itextpdf.p349a;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.pdf.BaseFont;
import java.awt.Font;
import java.util.HashMap;

/* renamed from: com.itextpdf.a.a */
/* loaded from: classes.dex */
public final class DefaultFontMapper implements FontMapper {

    /* renamed from: a */
    private HashMap<String, String> f19469a = new HashMap<>();

    /* renamed from: b */
    private HashMap<String, C3601a> f19470b = new HashMap<>();

    /* compiled from: DefaultFontMapper.java */
    /* renamed from: com.itextpdf.a.a$a */
    /* loaded from: classes.dex */
    public static class C3601a {

        /* renamed from: a */
        public String f19471a;

        /* renamed from: b */
        public String f19472b;

        /* renamed from: c */
        public boolean f19473c;

        /* renamed from: d */
        public boolean f19474d;

        /* renamed from: e */
        public byte[] f19475e;

        /* renamed from: f */
        public byte[] f19476f;
    }

    @Override // com.itextpdf.p349a.FontMapper
    /* renamed from: a */
    public final BaseFont mo2724a(Font font) {
        C3601a c3601a;
        String str;
        try {
            String fontName = font.getFontName();
            String str2 = this.f19469a.get(fontName);
            if (str2 == null) {
                c3601a = this.f19470b.get(fontName);
            } else {
                C3601a c3601a2 = this.f19470b.get(str2);
                c3601a = c3601a2 == null ? this.f19470b.get(fontName) : c3601a2;
            }
            if (c3601a != null) {
                return BaseFont.createFont(c3601a.f19471a, c3601a.f19472b, c3601a.f19473c, c3601a.f19474d, c3601a.f19475e, c3601a.f19476f);
            }
            String name = font.getName();
            if (!name.equalsIgnoreCase("DialogInput") && !name.equalsIgnoreCase("Monospaced") && !name.equalsIgnoreCase("Courier")) {
                if (!name.equalsIgnoreCase("Serif") && !name.equalsIgnoreCase("TimesRoman")) {
                    if (font.isItalic()) {
                        str = font.isBold() ? "Helvetica-BoldOblique" : "Helvetica-Oblique";
                    } else {
                        str = font.isBold() ? "Helvetica-Bold" : "Helvetica";
                    }
                    return BaseFont.createFont(str, "Cp1252", false);
                }
                if (font.isItalic()) {
                    str = font.isBold() ? "Times-BoldItalic" : "Times-Italic";
                } else {
                    str = font.isBold() ? "Times-Bold" : "Times-Roman";
                }
                return BaseFont.createFont(str, "Cp1252", false);
            }
            if (font.isItalic()) {
                str = font.isBold() ? "Courier-BoldOblique" : "Courier-Oblique";
            } else {
                str = font.isBold() ? "Courier-Bold" : "Courier";
            }
            return BaseFont.createFont(str, "Cp1252", false);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }
}
