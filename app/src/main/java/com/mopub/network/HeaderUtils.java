package com.mopub.network;

import com.mopub.common.util.ResponseHeader;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

/* loaded from: classes2.dex */
public class HeaderUtils {
    public static String extractHeader(Map<String, String> map, ResponseHeader responseHeader) {
        return map.get(responseHeader.getKey());
    }

    public static Integer extractIntegerHeader(Map<String, String> map, ResponseHeader responseHeader) {
        return m2027a(extractHeader(map, responseHeader));
    }

    public static boolean extractBooleanHeader(Map<String, String> map, ResponseHeader responseHeader, boolean z) {
        return m2026a(extractHeader(map, responseHeader), z);
    }

    public static Integer extractPercentHeader(Map<String, String> map, ResponseHeader responseHeader) {
        Integer m2027a;
        String extractHeader = extractHeader(map, responseHeader);
        if (extractHeader != null && (m2027a = m2027a(extractHeader.replace("%", ""))) != null && m2027a.intValue() >= 0 && m2027a.intValue() <= 100) {
            return m2027a;
        }
        return null;
    }

    public static String extractPercentHeaderString(Map<String, String> map, ResponseHeader responseHeader) {
        Integer extractPercentHeader = extractPercentHeader(map, responseHeader);
        if (extractPercentHeader != null) {
            return extractPercentHeader.toString();
        }
        return null;
    }

    public static String extractHeader(HttpResponse httpResponse, ResponseHeader responseHeader) {
        Header firstHeader = httpResponse.getFirstHeader(responseHeader.getKey());
        if (firstHeader != null) {
            return firstHeader.getValue();
        }
        return null;
    }

    public static boolean extractBooleanHeader(HttpResponse httpResponse, ResponseHeader responseHeader, boolean z) {
        return m2026a(extractHeader(httpResponse, responseHeader), z);
    }

    public static Integer extractIntegerHeader(HttpResponse httpResponse, ResponseHeader responseHeader) {
        return m2027a(extractHeader(httpResponse, responseHeader));
    }

    public static int extractIntHeader(HttpResponse httpResponse, ResponseHeader responseHeader, int i) {
        Integer extractIntegerHeader = extractIntegerHeader(httpResponse, responseHeader);
        return extractIntegerHeader == null ? i : extractIntegerHeader.intValue();
    }

    /* renamed from: a */
    private static boolean m2026a(String str, boolean z) {
        return str == null ? z : str.equals("1");
    }

    /* renamed from: a */
    private static Integer m2027a(String str) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        numberFormat.setParseIntegerOnly(true);
        try {
            return Integer.valueOf(numberFormat.parse(str.trim()).intValue());
        } catch (Exception unused) {
            return null;
        }
    }
}
