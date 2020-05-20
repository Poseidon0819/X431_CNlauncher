package com.cnlaunch.gmap.map.p151c;

import com.itextpdf.text.html.HtmlTags;
import java.util.Locale;

/* renamed from: com.cnlaunch.gmap.map.c.e */
/* loaded from: classes.dex */
public final class LanguageUtils {
    /* renamed from: a */
    public static boolean m9284a() {
        return m9283b().equals("zh");
    }

    /* renamed from: b */
    public static String m9283b() {
        String str = Locale.getDefault().getLanguage().toString();
        return str.equalsIgnoreCase("IT") ? "it" : str.equalsIgnoreCase("EN") ? "en" : str.startsWith("zh") ? Locale.getDefault().getCountry().equalsIgnoreCase("cn") ? "zh" : "zh_tw" : str.equalsIgnoreCase("DE") ? "de" : str.equalsIgnoreCase("JA") ? "ja" : str.equalsIgnoreCase("RU") ? "ru" : str.equalsIgnoreCase("FR") ? "fr" : str.equalsIgnoreCase("ES") ? "es" : str.equalsIgnoreCase("PT") ? "pt" : str.equalsIgnoreCase("PL") ? "pl" : str.equalsIgnoreCase("TR") ? HtmlTags.f19636TR : str.equalsIgnoreCase("NL") ? "nl" : str.equalsIgnoreCase("EL") ? "el" : str.equalsIgnoreCase("HU") ? "hu" : str.equalsIgnoreCase("AR") ? "ar" : str.equalsIgnoreCase("DA") ? "da" : str.equalsIgnoreCase("KO") ? "ko" : str.equalsIgnoreCase("FA") ? "fa" : str.equalsIgnoreCase("RO") ? "ro" : str.equalsIgnoreCase("SR") ? "sr" : str.equalsIgnoreCase("FI") ? "fi" : str.equalsIgnoreCase("SV") ? "sv" : str.equalsIgnoreCase("CS") ? "cs" : "en";
    }
}
