package com.itextpdf.text.pdf.security;

import com.itextpdf.text.ExceptionConverter;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;

/* loaded from: classes.dex */
public class KeyStoreUtil {
    public static KeyStore loadCacertsKeyStore(String str) {
        KeyStore keyStore;
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(new File(new File(new File(System.getProperty("java.home"), "lib"), "security"), "cacerts"));
                try {
                    if (str == null) {
                        keyStore = KeyStore.getInstance("JKS");
                    } else {
                        keyStore = KeyStore.getInstance("JKS", str);
                    }
                    keyStore.load(fileInputStream2, null);
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused) {
                    }
                    return keyStore;
                } catch (Exception e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    throw new ExceptionConverter(e);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static KeyStore loadCacertsKeyStore() {
        return loadCacertsKeyStore(null);
    }
}
