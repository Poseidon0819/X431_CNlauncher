package com.cnlaunch.x431pro.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.cnlaunch.p120d.p130d.NLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.conn.ssl.TokenParser;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* compiled from: StringUtils.java */
/* renamed from: com.cnlaunch.x431pro.utils.z */
/* loaded from: classes.dex */
public class C2787z {

    /* renamed from: a */
    private static final String f15956a = "z";

    /* renamed from: a */
    public static boolean m4821a(String str) {
        return TextUtils.isEmpty(str) || "".equals(str);
    }

    /* renamed from: a */
    public static <T> boolean m4819a(List<T> list) {
        return list == null || list.isEmpty();
    }

    /* renamed from: b */
    public static boolean m4818b(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    /* renamed from: c */
    public static boolean m4816c(String str) {
        return Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)([a-zA-Z0-9_]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$").matcher(str).matches();
    }

    /* renamed from: d */
    public static boolean m4815d(String str) {
        return str.matches("^[1-9][0-9]{4,14}$");
    }

    /* renamed from: e */
    public static boolean m4814e(String str) {
        return str.matches("^[a-zA-Z0-9_@]{6,20}$");
    }

    /* renamed from: f */
    public static boolean m4813f(String str) {
        return str.length() > 5 && str.length() < 21 && Pattern.compile("^[a-zA-Z0-9_@]+$").matcher(str).matches();
    }

    /* renamed from: g */
    public static boolean m4812g(String str) {
        return Pattern.compile("^[a-zA-Z0-9_@]+$").matcher(str).matches();
    }

    /* renamed from: h */
    public static boolean m4811h(String str) {
        return Pattern.compile("^\\d{6,20}$").matcher(str).matches();
    }

    /* renamed from: i */
    public static boolean m4810i(String str) {
        if (str.length() != 11) {
            return false;
        }
        return Pattern.compile("^((13[0-9])|(15[0-9])|(18[0-9])|(17[0-9])|(14[0-9]))\\d{8}$").matcher(str).matches();
    }

    /* renamed from: j */
    public static Boolean m4809j(String str) {
        return Pattern.compile("^[a-zA-Z][0-9a-zA-Z_]{5,19}$").matcher(str).matches() ? Boolean.TRUE : Boolean.FALSE;
    }

    /* renamed from: k */
    public static boolean m4808k(String str) {
        return str.matches("^(\\d{5})$");
    }

    /* renamed from: l */
    public static boolean m4807l(String str) {
        Boolean bool = Boolean.FALSE;
        return str.matches("^([ABCEGHJKLMNPRSTVXYabceghjklmnprstvxy]\\d[A-Za-z][ -]\\d[A-Za-z]\\d)$");
    }

    /* renamed from: a */
    public static boolean m4820a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.isEmpty(str2) || str.compareToIgnoreCase(str2) > 0;
    }

    /* renamed from: m */
    public static boolean m4806m(String str) {
        if ("".equals(str)) {
            return false;
        }
        char[] charArray = str.toCharArray();
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char c = charArray[i2];
            if ((c < '0' || c > '9') && c != '.' && c != '-') {
                return false;
            }
            if (c == '-') {
                i++;
            }
        }
        return i <= 1;
    }

    /* renamed from: n */
    public static int m4805n(String str) {
        int i;
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            i = 0;
        }
        if (i > 0) {
            return i;
        }
        return 0;
    }

    /* renamed from: o */
    public static String m4804o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char charAt = str.charAt(i);
            if (charAt == '\\') {
                i = i2 + 1;
                char charAt2 = str.charAt(i2);
                if (charAt2 == 'u') {
                    int i3 = i;
                    int i4 = 0;
                    int i5 = 0;
                    while (i4 < 4) {
                        int i6 = i3 + 1;
                        char charAt3 = str.charAt(i3);
                        switch (charAt3) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                i5 = ((i5 << 4) + charAt3) - 48;
                                break;
                            default:
                                switch (charAt3) {
                                    case 'A':
                                    case 'B':
                                    case 'C':
                                    case 'D':
                                    case 'E':
                                    case 'F':
                                        i5 = (((i5 << 4) + 10) + charAt3) - 65;
                                        break;
                                    default:
                                        switch (charAt3) {
                                            case 'a':
                                            case 'b':
                                            case 'c':
                                            case 'd':
                                            case 'e':
                                            case 'f':
                                                i5 = (((i5 << 4) + 10) + charAt3) - 97;
                                                break;
                                            default:
                                                NLog.m9451c(f15956a, "Malformed encoding.aChar=".concat(String.valueOf(charAt3)));
                                                break;
                                        }
                                }
                        }
                        i4++;
                        i3 = i6;
                    }
                    stringBuffer.append((char) i5);
                    i = i3;
                } else {
                    if (charAt2 == 't') {
                        charAt2 = '\t';
                    } else if (charAt2 == 'r') {
                        charAt2 = TokenParser.f24151CR;
                    } else if (charAt2 == 'n') {
                        charAt2 = '\n';
                    } else if (charAt2 == 'f') {
                        charAt2 = '\f';
                    }
                    stringBuffer.append(charAt2);
                }
            } else {
                stringBuffer.append(charAt);
                i = i2;
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: p */
    public static boolean m4803p(String str) {
        return str.matches("^[a-z0-9A-Z]+$");
    }

    /* renamed from: b */
    public static String m4817b(List<String> list) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(list);
        String str = new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0));
        objectOutputStream.close();
        return str;
    }

    /* renamed from: q */
    public static List<String> m4802q(String str) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(str.getBytes(), 0)));
        List<String> list = (List) objectInputStream.readObject();
        objectInputStream.close();
        return list;
    }

    /* renamed from: r */
    public static boolean m4801r(String str) {
        return Pattern.compile("^[1-9][0-9]*").matcher(str).find();
    }

    /* renamed from: s */
    public static String m4800s(String str) {
        if (str == null) {
            return MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        }
        Matcher matcher = Pattern.compile("^[1-9][0-9]*").matcher(str);
        return matcher.find() ? matcher.group() : MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
    }

    /* renamed from: t */
    public static boolean m4799t(String str) {
        return Pattern.compile("^[1-9][0-9]*\\s+$|\\s+|^\\s+[1-9][0-9]*|^\\s+[1-9][0-9]*\\s+$").matcher(str).matches();
    }
}
