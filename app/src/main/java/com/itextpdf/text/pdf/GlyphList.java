package com.itextpdf.text.pdf;

import com.itextpdf.text.pdf.fonts.FontsResourceAnchor;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.StringTokenizer;
import org.apache.mina.proxy.handlers.http.HttpProxyConstants;

/* loaded from: classes.dex */
public class GlyphList {
    private static HashMap<Integer, String> unicode2names = new HashMap<>();
    private static HashMap<String, int[]> names2unicode = new HashMap<>();

    static {
        InputStream inputStream = null;
        try {
            try {
                InputStream resourceStream = BaseFont.getResourceStream("com/itextpdf/text/pdf/fonts/glyphlist.txt", new FontsResourceAnchor().getClass().getClassLoader());
                try {
                    if (resourceStream == null) {
                        throw new Exception("glyphlist.txt not found as resource. (It must exist as resource in the package com.itextpdf.text.pdf.fonts)");
                    }
                    byte[] bArr = new byte[1024];
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        int read = resourceStream.read(bArr);
                        if (read < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    resourceStream.close();
                    StringTokenizer stringTokenizer = new StringTokenizer(PdfEncodings.convertToString(byteArrayOutputStream.toByteArray(), null), HttpProxyConstants.CRLF);
                    while (stringTokenizer.hasMoreTokens()) {
                        String nextToken = stringTokenizer.nextToken();
                        if (!nextToken.startsWith("#")) {
                            StringTokenizer stringTokenizer2 = new StringTokenizer(nextToken, " ;\r\n\t\f");
                            if (stringTokenizer2.hasMoreTokens()) {
                                String nextToken2 = stringTokenizer2.nextToken();
                                if (stringTokenizer2.hasMoreTokens()) {
                                    Integer valueOf = Integer.valueOf(stringTokenizer2.nextToken(), 16);
                                    unicode2names.put(valueOf, nextToken2);
                                    names2unicode.put(nextToken2, new int[]{valueOf.intValue()});
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e = e;
                    inputStream = resourceStream;
                    System.err.println("glyphlist.txt loading error: " + e.getMessage());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream = resourceStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static int[] nameToUnicode(String str) {
        return names2unicode.get(str);
    }

    public static String unicodeToName(int i) {
        return unicode2names.get(Integer.valueOf(i));
    }
}
