package com.itextpdf.text.error_messages;

import com.itextpdf.text.pdf.BaseFont;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class MessageLocalization {
    private static final String BASE_PATH = "com/itextpdf/text/l10n/error/";
    private static HashMap<String, String> currentLanguage;
    private static HashMap<String, String> defaultLanguage;

    static {
        defaultLanguage = new HashMap<>();
        try {
            defaultLanguage = getLanguageMessages("en", null);
        } catch (Exception unused) {
        }
        if (defaultLanguage == null) {
            defaultLanguage = new HashMap<>();
        }
    }

    private MessageLocalization() {
    }

    public static String getMessage(String str) {
        String str2;
        HashMap<String, String> hashMap = currentLanguage;
        if (hashMap == null || (str2 = hashMap.get(str)) == null) {
            String str3 = defaultLanguage.get(str);
            return str3 != null ? str3 : "No message found for ".concat(String.valueOf(str));
        }
        return str2;
    }

    public static String getComposedMessage(String str, int i) {
        return getComposedMessage(str, String.valueOf(i), null, null, null);
    }

    public static String getComposedMessage(String str, Object... objArr) {
        String message2 = getMessage(str);
        if (objArr != null) {
            int i = 1;
            for (Object obj : objArr) {
                if (obj != null) {
                    message2 = message2.replace("{" + i + "}", obj.toString());
                }
                i++;
            }
        }
        return message2;
    }

    public static boolean setLanguage(String str, String str2) throws IOException {
        HashMap<String, String> languageMessages = getLanguageMessages(str, str2);
        if (languageMessages == null) {
            return false;
        }
        currentLanguage = languageMessages;
        return true;
    }

    public static void setMessages(Reader reader) throws IOException {
        currentLanguage = readLanguageStream(reader);
    }

    private static HashMap<String, String> getLanguageMessages(String str, String str2) throws IOException {
        String str3;
        if (str == null) {
            throw new IllegalArgumentException("The language cannot be null.");
        }
        InputStream inputStream = null;
        try {
            if (str2 != null) {
                str3 = str + "_" + str2 + ".lng";
            } else {
                str3 = str + ".lng";
            }
            InputStream resourceStream = BaseFont.getResourceStream(BASE_PATH.concat(String.valueOf(str3)), new MessageLocalization().getClass().getClassLoader());
            try {
                if (resourceStream != null) {
                    HashMap<String, String> readLanguageStream = readLanguageStream(resourceStream);
                    if (resourceStream != null) {
                        try {
                            resourceStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    return readLanguageStream;
                } else if (str2 == null) {
                    if (resourceStream != null) {
                        try {
                            resourceStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    return null;
                } else {
                    InputStream resourceStream2 = BaseFont.getResourceStream(BASE_PATH.concat(String.valueOf(str + ".lng")), new MessageLocalization().getClass().getClassLoader());
                    if (resourceStream2 == null) {
                        if (resourceStream2 != null) {
                            try {
                                resourceStream2.close();
                            } catch (Exception unused3) {
                            }
                        }
                        return null;
                    }
                    try {
                        HashMap<String, String> readLanguageStream2 = readLanguageStream(resourceStream2);
                        if (resourceStream2 != null) {
                            try {
                                resourceStream2.close();
                            } catch (Exception unused4) {
                            }
                        }
                        return readLanguageStream2;
                    } catch (Throwable th) {
                        inputStream = resourceStream2;
                        th = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception unused5) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = resourceStream;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static HashMap<String, String> readLanguageStream(InputStream inputStream) throws IOException {
        return readLanguageStream(new InputStreamReader(inputStream, "UTF-8"));
    }

    private static HashMap<String, String> readLanguageStream(Reader reader) throws IOException {
        HashMap<String, String> hashMap = new HashMap<>();
        BufferedReader bufferedReader = new BufferedReader(reader);
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return hashMap;
            }
            int indexOf = readLine.indexOf(61);
            if (indexOf >= 0) {
                String trim = readLine.substring(0, indexOf).trim();
                if (!trim.startsWith("#")) {
                    hashMap.put(trim, readLine.substring(indexOf + 1));
                }
            }
        }
    }
}
