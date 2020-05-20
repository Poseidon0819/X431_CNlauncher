package com.itextpdf.text;

import com.itextpdf.text.Font;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.BaseFont;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class FontFactoryImp implements FontProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(FontFactoryImp.class);
    private static String[] TTFamilyOrder = {"3", "1", "1033", "3", "0", "1033", "1", "0", "0", "0", "3", "0"};
    private final Hashtable<String, String> trueTypeFonts = new Hashtable<>();
    private final Hashtable<String, ArrayList<String>> fontFamilies = new Hashtable<>();
    public String defaultEncoding = "Cp1252";
    public boolean defaultEmbedding = false;

    public FontFactoryImp() {
        this.trueTypeFonts.put("Courier".toLowerCase(), "Courier");
        this.trueTypeFonts.put("Courier-Bold".toLowerCase(), "Courier-Bold");
        this.trueTypeFonts.put("Courier-Oblique".toLowerCase(), "Courier-Oblique");
        this.trueTypeFonts.put("Courier-BoldOblique".toLowerCase(), "Courier-BoldOblique");
        this.trueTypeFonts.put("Helvetica".toLowerCase(), "Helvetica");
        this.trueTypeFonts.put("Helvetica-Bold".toLowerCase(), "Helvetica-Bold");
        this.trueTypeFonts.put("Helvetica-Oblique".toLowerCase(), "Helvetica-Oblique");
        this.trueTypeFonts.put("Helvetica-BoldOblique".toLowerCase(), "Helvetica-BoldOblique");
        this.trueTypeFonts.put("Symbol".toLowerCase(), "Symbol");
        this.trueTypeFonts.put("Times-Roman".toLowerCase(), "Times-Roman");
        this.trueTypeFonts.put("Times-Bold".toLowerCase(), "Times-Bold");
        this.trueTypeFonts.put("Times-Italic".toLowerCase(), "Times-Italic");
        this.trueTypeFonts.put("Times-BoldItalic".toLowerCase(), "Times-BoldItalic");
        this.trueTypeFonts.put("ZapfDingbats".toLowerCase(), "ZapfDingbats");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Courier");
        arrayList.add("Courier-Bold");
        arrayList.add("Courier-Oblique");
        arrayList.add("Courier-BoldOblique");
        this.fontFamilies.put("Courier".toLowerCase(), arrayList);
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("Helvetica");
        arrayList2.add("Helvetica-Bold");
        arrayList2.add("Helvetica-Oblique");
        arrayList2.add("Helvetica-BoldOblique");
        this.fontFamilies.put("Helvetica".toLowerCase(), arrayList2);
        ArrayList<String> arrayList3 = new ArrayList<>();
        arrayList3.add("Symbol");
        this.fontFamilies.put("Symbol".toLowerCase(), arrayList3);
        ArrayList<String> arrayList4 = new ArrayList<>();
        arrayList4.add("Times-Roman");
        arrayList4.add("Times-Bold");
        arrayList4.add("Times-Italic");
        arrayList4.add("Times-BoldItalic");
        this.fontFamilies.put(FontFactory.TIMES.toLowerCase(), arrayList4);
        this.fontFamilies.put("Times-Roman".toLowerCase(), arrayList4);
        ArrayList<String> arrayList5 = new ArrayList<>();
        arrayList5.add("ZapfDingbats");
        this.fontFamilies.put("ZapfDingbats".toLowerCase(), arrayList5);
    }

    @Override // com.itextpdf.text.FontProvider
    public Font getFont(String str, String str2, boolean z, float f, int i, BaseColor baseColor) {
        return getFont(str, str2, z, f, i, baseColor, true);
    }

    public Font getFont(String str, String str2, boolean z, float f, int i, BaseColor baseColor, boolean z2) {
        String str3;
        boolean z3;
        int i2 = i;
        if (str == null) {
            return new Font(Font.FontFamily.UNDEFINED, f, i2, baseColor);
        }
        ArrayList<String> arrayList = this.fontFamilies.get(str.toLowerCase());
        if (arrayList != null) {
            int i3 = i2 == -1 ? 0 : i2;
            Iterator<String> it = arrayList.iterator();
            int i4 = 0;
            while (true) {
                z3 = true;
                if (!it.hasNext()) {
                    str3 = str;
                    z3 = false;
                    break;
                }
                String next = it.next();
                String lowerCase = next.toLowerCase();
                int i5 = lowerCase.toLowerCase().indexOf(HtmlTags.BOLD) != -1 ? 1 : 0;
                int i6 = (lowerCase.toLowerCase().indexOf(HtmlTags.ITALIC) == -1 && lowerCase.toLowerCase().indexOf(HtmlTags.OBLIQUE) == -1) ? i5 : i5 | 2;
                if ((i3 & 3) == i6) {
                    str3 = next;
                    i4 = i6;
                    break;
                }
                i4 = i6;
            }
            if (i2 != -1 && z3) {
                i2 &= i4 ^ (-1);
            }
        } else {
            str3 = str;
        }
        BaseFont baseFont = null;
        try {
            try {
                baseFont = BaseFont.createFont(str3, str2, z, z2, null, null, true);
            } catch (IOException unused) {
                return new Font(Font.FontFamily.UNDEFINED, f, i2, baseColor);
            } catch (NullPointerException unused2) {
                return new Font(Font.FontFamily.UNDEFINED, f, i2, baseColor);
            }
        } catch (DocumentException unused3) {
        }
        if (baseFont == null) {
            try {
                String str4 = this.trueTypeFonts.get(str3.toLowerCase());
                if (str4 == null) {
                    return new Font(Font.FontFamily.UNDEFINED, f, i2, baseColor);
                }
                baseFont = BaseFont.createFont(str4, str2, z, z2, null, null);
            } catch (DocumentException e) {
                throw new ExceptionConverter(e);
            }
        }
        return new Font(baseFont, f, i2, baseColor);
    }

    public Font getFont(String str, String str2, boolean z, float f, int i) {
        return getFont(str, str2, z, f, i, null);
    }

    public Font getFont(String str, String str2, boolean z, float f) {
        return getFont(str, str2, z, f, -1, null);
    }

    public Font getFont(String str, String str2, boolean z) {
        return getFont(str, str2, z, -1.0f, -1, null);
    }

    public Font getFont(String str, String str2, float f, int i, BaseColor baseColor) {
        return getFont(str, str2, this.defaultEmbedding, f, i, baseColor);
    }

    public Font getFont(String str, String str2, float f, int i) {
        return getFont(str, str2, this.defaultEmbedding, f, i, null);
    }

    public Font getFont(String str, String str2, float f) {
        return getFont(str, str2, this.defaultEmbedding, f, -1, null);
    }

    public Font getFont(String str, float f, BaseColor baseColor) {
        return getFont(str, this.defaultEncoding, this.defaultEmbedding, f, -1, baseColor);
    }

    public Font getFont(String str, String str2) {
        return getFont(str, str2, this.defaultEmbedding, -1.0f, -1, null);
    }

    public Font getFont(String str, float f, int i, BaseColor baseColor) {
        return getFont(str, this.defaultEncoding, this.defaultEmbedding, f, i, baseColor);
    }

    public Font getFont(String str, float f, int i) {
        return getFont(str, this.defaultEncoding, this.defaultEmbedding, f, i, null);
    }

    public Font getFont(String str, float f) {
        return getFont(str, this.defaultEncoding, this.defaultEmbedding, f, -1, null);
    }

    public Font getFont(String str) {
        return getFont(str, this.defaultEncoding, this.defaultEmbedding, -1.0f, -1, null);
    }

    public void registerFamily(String str, String str2, String str3) {
        if (str3 != null) {
            this.trueTypeFonts.put(str2, str3);
        }
        ArrayList<String> arrayList = this.fontFamilies.get(str);
        if (arrayList == null) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            arrayList2.add(str2);
            this.fontFamilies.put(str, arrayList2);
            return;
        }
        int length = str2.length();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= arrayList.size()) {
                break;
            } else if (arrayList.get(i).length() >= length) {
                arrayList.add(i, str2);
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return;
        }
        arrayList.add(str2);
    }

    public void register(String str) {
        register(str, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0196 A[Catch: IOException -> 0x01a6, DocumentException -> 0x01ad, TRY_LEAVE, TryCatch #2 {DocumentException -> 0x01ad, IOException -> 0x01a6, blocks: (B:3:0x0004, B:5:0x0014, B:7:0x0020, B:10:0x002e, B:13:0x003c, B:14:0x0043, B:15:0x0048, B:17:0x004b, B:60:0x018c, B:62:0x0196, B:18:0x0065, B:20:0x0071, B:22:0x007d, B:23:0x00b2, B:25:0x00c7, B:26:0x00d0, B:28:0x00db, B:29:0x00eb, B:30:0x00f3, B:32:0x00f8, B:34:0x00fc, B:36:0x010a, B:38:0x0118, B:40:0x0126, B:41:0x0135, B:42:0x0138, B:44:0x013c, B:46:0x0149, B:47:0x014c, B:49:0x0151, B:51:0x015d, B:53:0x016b, B:55:0x0179, B:57:0x0181, B:58:0x0186, B:59:0x0189), top: B:71:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void register(java.lang.String r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.FontFactoryImp.register(java.lang.String, java.lang.String):void");
    }

    public int registerDirectory(String str) {
        return registerDirectory(str, false);
    }

    public int registerDirectory(String str, boolean z) {
        if (LOGGER.isLogging(Level.DEBUG)) {
            LOGGER.debug(String.format("Registering directory %s, looking for fonts", str));
        }
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                String[] list = file.list();
                if (list == null) {
                    return 0;
                }
                int i = 0;
                for (String str2 : list) {
                    try {
                        try {
                            File file2 = new File(str, str2);
                            if (!file2.isDirectory()) {
                                String path = file2.getPath();
                                String lowerCase = path.length() < 4 ? null : path.substring(path.length() - 4).toLowerCase();
                                if (!".afm".equals(lowerCase) && !".pfm".equals(lowerCase)) {
                                    if (".ttf".equals(lowerCase) || ".otf".equals(lowerCase) || ".ttc".equals(lowerCase)) {
                                        register(path, null);
                                        i++;
                                    }
                                }
                                if (new File(path.substring(0, path.length() - 4) + ".pfb").exists()) {
                                    register(path, null);
                                    i++;
                                }
                            } else if (z) {
                                i += registerDirectory(file2.getAbsolutePath(), true);
                            }
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        return i;
                    }
                }
                return i;
            }
            return 0;
        } catch (Exception unused3) {
            return 0;
        }
    }

    public int registerDirectories() {
        String str = System.getenv("windir");
        String property = System.getProperty("file.separator");
        int i = 0;
        if (str != null && property != null) {
            i = 0 + registerDirectory(str + property + "fonts");
        }
        return i + registerDirectory("/usr/share/X11/fonts", true) + registerDirectory("/usr/X/lib/X11/fonts", true) + registerDirectory("/usr/openwin/lib/X11/fonts", true) + registerDirectory("/usr/share/fonts", true) + registerDirectory("/usr/X11R6/lib/X11/fonts", true) + registerDirectory("/Library/Fonts") + registerDirectory("/System/Library/Fonts");
    }

    public Set<String> getRegisteredFonts() {
        return this.trueTypeFonts.keySet();
    }

    public Set<String> getRegisteredFamilies() {
        return this.fontFamilies.keySet();
    }

    @Override // com.itextpdf.text.FontProvider
    public boolean isRegistered(String str) {
        return this.trueTypeFonts.containsKey(str.toLowerCase());
    }
}
