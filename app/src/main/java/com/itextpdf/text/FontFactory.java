package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;
import java.util.Set;

/* loaded from: classes.dex */
public final class FontFactory {
    public static final String COURIER = "Courier";
    public static final String COURIER_BOLD = "Courier-Bold";
    public static final String COURIER_BOLDOBLIQUE = "Courier-BoldOblique";
    public static final String COURIER_OBLIQUE = "Courier-Oblique";
    public static final String HELVETICA = "Helvetica";
    public static final String HELVETICA_BOLD = "Helvetica-Bold";
    public static final String HELVETICA_BOLDOBLIQUE = "Helvetica-BoldOblique";
    public static final String HELVETICA_OBLIQUE = "Helvetica-Oblique";
    public static final String SYMBOL = "Symbol";
    public static final String TIMES = "Times";
    public static final String TIMES_BOLD = "Times-Bold";
    public static final String TIMES_BOLDITALIC = "Times-BoldItalic";
    public static final String TIMES_ITALIC = "Times-Italic";
    public static final String TIMES_ROMAN = "Times-Roman";
    public static final String ZAPFDINGBATS = "ZapfDingbats";
    private static FontFactoryImp fontImp = new FontFactoryImp();
    public static String defaultEncoding = "Cp1252";
    public static boolean defaultEmbedding = false;

    private FontFactory() {
    }

    public static Font getFont(String str, String str2, boolean z, float f, int i, BaseColor baseColor) {
        return fontImp.getFont(str, str2, z, f, i, baseColor);
    }

    public static Font getFont(String str, String str2, boolean z, float f, int i, BaseColor baseColor, boolean z2) {
        return fontImp.getFont(str, str2, z, f, i, baseColor, z2);
    }

    public static Font getFont(String str, String str2, boolean z, float f, int i) {
        return getFont(str, str2, z, f, i, null);
    }

    public static Font getFont(String str, String str2, boolean z, float f) {
        return getFont(str, str2, z, f, -1, null);
    }

    public static Font getFont(String str, String str2, boolean z) {
        return getFont(str, str2, z, -1.0f, -1, null);
    }

    public static Font getFont(String str, String str2, float f, int i, BaseColor baseColor) {
        return getFont(str, str2, defaultEmbedding, f, i, baseColor);
    }

    public static Font getFont(String str, String str2, float f, int i) {
        return getFont(str, str2, defaultEmbedding, f, i, null);
    }

    public static Font getFont(String str, String str2, float f) {
        return getFont(str, str2, defaultEmbedding, f, -1, null);
    }

    public static Font getFont(String str, String str2) {
        return getFont(str, str2, defaultEmbedding, -1.0f, -1, null);
    }

    public static Font getFont(String str, float f, int i, BaseColor baseColor) {
        return getFont(str, defaultEncoding, defaultEmbedding, f, i, baseColor);
    }

    public static Font getFont(String str, float f, BaseColor baseColor) {
        return getFont(str, defaultEncoding, defaultEmbedding, f, -1, baseColor);
    }

    public static Font getFont(String str, float f, int i) {
        return getFont(str, defaultEncoding, defaultEmbedding, f, i, null);
    }

    public static Font getFont(String str, float f) {
        return getFont(str, defaultEncoding, defaultEmbedding, f, -1, null);
    }

    public static Font getFont(String str) {
        return getFont(str, defaultEncoding, defaultEmbedding, -1.0f, -1, null);
    }

    public static void registerFamily(String str, String str2, String str3) {
        fontImp.registerFamily(str, str2, str3);
    }

    public static void register(String str) {
        register(str, null);
    }

    public static void register(String str, String str2) {
        fontImp.register(str, str2);
    }

    public static int registerDirectory(String str) {
        return fontImp.registerDirectory(str);
    }

    public static int registerDirectory(String str, boolean z) {
        return fontImp.registerDirectory(str, z);
    }

    public static int registerDirectories() {
        return fontImp.registerDirectories();
    }

    public static Set<String> getRegisteredFonts() {
        return fontImp.getRegisteredFonts();
    }

    public static Set<String> getRegisteredFamilies() {
        return fontImp.getRegisteredFamilies();
    }

    public static boolean contains(String str) {
        return fontImp.isRegistered(str);
    }

    public static boolean isRegistered(String str) {
        return fontImp.isRegistered(str);
    }

    public static FontFactoryImp getFontImp() {
        return fontImp;
    }

    public static void setFontImp(FontFactoryImp fontFactoryImp) {
        if (fontFactoryImp == null) {
            throw new NullPointerException(MessageLocalization.getComposedMessage("fontfactoryimp.cannot.be.null", new Object[0]));
        }
        fontImp = fontFactoryImp;
    }
}
