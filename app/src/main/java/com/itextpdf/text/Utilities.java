package com.itextpdf.text;

import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.PdfBoolean;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;

/* loaded from: classes.dex */
public class Utilities {
    public static int convertToUtf32(char c, char c2) {
        return ((((c - 55296) * 1024) + c2) - 56320) + 65536;
    }

    public static final float inchesToMillimeters(float f) {
        return f * 25.4f;
    }

    public static final float inchesToPoints(float f) {
        return f * 72.0f;
    }

    public static boolean isSurrogateHigh(char c) {
        return c >= 55296 && c <= 56319;
    }

    public static boolean isSurrogateLow(char c) {
        return c >= 56320 && c <= 57343;
    }

    public static final float millimetersToInches(float f) {
        return f / 25.4f;
    }

    public static final float pointsToInches(float f) {
        return f / 72.0f;
    }

    @Deprecated
    public static <K, V> Set<K> getKeySet(Hashtable<K, V> hashtable) {
        return hashtable == null ? Collections.emptySet() : hashtable.keySet();
    }

    public static Object[][] addToArray(Object[][] objArr, Object[] objArr2) {
        if (objArr == null) {
            return new Object[][]{objArr2};
        }
        Object[][] objArr3 = new Object[objArr.length + 1];
        System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
        objArr3[objArr.length] = objArr2;
        return objArr3;
    }

    public static boolean checkTrueOrFalse(Properties properties, String str) {
        return PdfBoolean.TRUE.equalsIgnoreCase(properties.getProperty(str));
    }

    public static String unEscapeURL(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] charArray = str.toCharArray();
        int i = 0;
        while (i < charArray.length) {
            char c = charArray[i];
            if (c == '%') {
                int i2 = i + 2;
                if (i2 >= charArray.length) {
                    stringBuffer.append(c);
                } else {
                    int hex = PRTokeniser.getHex(charArray[i + 1]);
                    int hex2 = PRTokeniser.getHex(charArray[i2]);
                    if (hex < 0 || hex2 < 0) {
                        stringBuffer.append(c);
                    } else {
                        stringBuffer.append((char) ((hex * 16) + hex2));
                        i = i2;
                    }
                }
            } else {
                stringBuffer.append(c);
            }
            i++;
        }
        return stringBuffer.toString();
    }

    public static URL toURL(String str) throws MalformedURLException {
        try {
            return new URL(str);
        } catch (Exception unused) {
            return new File(str).toURI().toURL();
        }
    }

    public static void skip(InputStream inputStream, int i) throws IOException {
        while (i > 0) {
            long j = i;
            long skip = inputStream.skip(j);
            if (skip <= 0) {
                return;
            }
            i = (int) (j - skip);
        }
    }

    public static final float millimetersToPoints(float f) {
        return inchesToPoints(millimetersToInches(f));
    }

    public static final float pointsToMillimeters(float f) {
        return inchesToMillimeters(pointsToInches(f));
    }

    public static boolean isSurrogatePair(String str, int i) {
        return i >= 0 && i <= str.length() + (-2) && isSurrogateHigh(str.charAt(i)) && isSurrogateLow(str.charAt(i + 1));
    }

    public static boolean isSurrogatePair(char[] cArr, int i) {
        return i >= 0 && i <= cArr.length + (-2) && isSurrogateHigh(cArr[i]) && isSurrogateLow(cArr[i + 1]);
    }

    public static int convertToUtf32(char[] cArr, int i) {
        return ((((cArr[i] - 55296) * 1024) + cArr[i + 1]) - 56320) + 65536;
    }

    public static int convertToUtf32(String str, int i) {
        return ((((str.charAt(i) - 55296) * 1024) + str.charAt(i + 1)) - 56320) + 65536;
    }

    public static String convertFromUtf32(int i) {
        if (i < 65536) {
            return Character.toString((char) i);
        }
        int i2 = i - 65536;
        return new String(new char[]{(char) ((i2 / 1024) + 55296), (char) ((i2 % 1024) + 56320)});
    }

    public static String readFileToString(String str) throws IOException {
        return readFileToString(new File(str));
    }

    public static String readFileToString(File file) throws IOException {
        byte[] bArr = new byte[(int) file.length()];
        new FileInputStream(file).read(bArr);
        return new String(bArr);
    }
}
