package com.itextpdf.text.xml;

import com.itextpdf.text.xml.xmp.XmpWriter;

/* loaded from: classes.dex */
public class XMLUtil {
    public static boolean isValidCharacterValue(int i) {
        if (i == 9 || i == 10 || i == 13) {
            return true;
        }
        if (i < 32 || i > 55295) {
            if (i < 57344 || i > 65533) {
                return i >= 65536 && i <= 1114111;
            }
            return true;
        }
        return true;
    }

    public static String escapeXML(String str, boolean z) {
        char[] charArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : charArray) {
            if (c != '\"') {
                if (c != '<') {
                    if (c == '>') {
                        stringBuffer.append("&gt;");
                    } else {
                        switch (c) {
                            case '&':
                                stringBuffer.append("&amp;");
                                continue;
                            case '\'':
                                stringBuffer.append("&apos;");
                                continue;
                            default:
                                if (isValidCharacterValue(c)) {
                                    if (z && c > 127) {
                                        stringBuffer.append("&#");
                                        stringBuffer.append((int) c);
                                        stringBuffer.append(';');
                                        break;
                                    } else {
                                        stringBuffer.append(c);
                                        break;
                                    }
                                } else {
                                    continue;
                                }
                                break;
                        }
                    }
                } else {
                    stringBuffer.append("&lt;");
                }
            } else {
                stringBuffer.append("&quot;");
            }
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String unescapeXML(String str) {
        int i;
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        while (i2 < length) {
            char c = charArray[i2];
            if (c == '&' && (i = findInArray(';', charArray, i2 + 3)) >= 0) {
                String str2 = new String(charArray, i2 + 1, (i - i2) - 1);
                if (str2.startsWith("#")) {
                    String substring = str2.substring(1);
                    if (isValidCharacterValue(substring)) {
                        c = (char) Integer.parseInt(substring);
                    } else {
                        i2 = i + 1;
                    }
                } else {
                    int unescape = unescape(str2);
                    if (unescape > 0) {
                        c = unescape;
                    }
                }
                stringBuffer.append(c);
                i2 = i + 1;
            }
            i = i2;
            stringBuffer.append(c);
            i2 = i + 1;
        }
        return stringBuffer.toString();
    }

    public static int unescape(String str) {
        if ("apos".equals(str)) {
            return 39;
        }
        if ("quot".equals(str)) {
            return 34;
        }
        if ("lt".equals(str)) {
            return 60;
        }
        if ("gt".equals(str)) {
            return 62;
        }
        return "amp".equals(str) ? 38 : -1;
    }

    public static boolean isValidCharacterValue(String str) {
        try {
            return isValidCharacterValue(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static int findInArray(char c, char[] cArr, int i) {
        while (i < cArr.length) {
            if (cArr[i] == ';') {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static String getEncodingName(byte[] bArr) {
        int i = bArr[0] & 255;
        int i2 = bArr[1] & 255;
        if (i == 254 && i2 == 255) {
            return XmpWriter.UTF16BE;
        }
        if (i == 255 && i2 == 254) {
            return XmpWriter.UTF16LE;
        }
        int i3 = bArr[2] & 255;
        if (i == 239 && i2 == 187 && i3 == 191) {
            return "UTF-8";
        }
        int i4 = bArr[3] & 255;
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 60) ? "ISO-10646-UCS-4" : (i == 60 && i2 == 0 && i3 == 0 && i4 == 0) ? "ISO-10646-UCS-4" : (i == 0 && i2 == 0 && i3 == 60 && i4 == 0) ? "ISO-10646-UCS-4" : (i == 0 && i2 == 60 && i3 == 0 && i4 == 0) ? "ISO-10646-UCS-4" : (i == 0 && i2 == 60 && i3 == 0 && i4 == 63) ? XmpWriter.UTF16BE : (i == 60 && i2 == 0 && i3 == 63 && i4 == 0) ? XmpWriter.UTF16LE : (i == 76 && i2 == 111 && i3 == 167 && i4 == 148) ? "CP037" : "UTF-8";
    }
}
