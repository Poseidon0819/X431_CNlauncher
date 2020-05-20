package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.PackageManager;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/* renamed from: com.baidu.mapsdkplatform.comapi.util.a */
/* loaded from: classes.dex */
public class C1298a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mapsdkplatform.comapi.util.a$a */
    /* loaded from: classes.dex */
    public static class C1299a {
        /* renamed from: a */
        public static String m10098a(byte[] bArr) {
            char[] cArr = {'0', '1', PdfWriter.VERSION_1_2, PdfWriter.VERSION_1_3, PdfWriter.VERSION_1_4, PdfWriter.VERSION_1_5, PdfWriter.VERSION_1_6, PdfWriter.VERSION_1_7, '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            for (int i = 0; i < bArr.length; i++) {
                sb.append(cArr[(bArr[i] & 240) >> 4]);
                sb.append(cArr[bArr[i] & 15]);
            }
            return sb.toString();
        }
    }

    /* renamed from: a */
    public static String m10102a(Context context) {
        String packageName = context.getPackageName();
        String m10101a = m10101a(context, packageName);
        return m10101a + ";" + packageName;
    }

    /* renamed from: a */
    private static String m10101a(Context context, String str) {
        String str2 = "";
        try {
            str2 = m10100a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray())));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (CertificateException e2) {
            e2.printStackTrace();
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str2.length(); i++) {
            stringBuffer.append(str2.charAt(i));
            if (i > 0 && i % 2 == 1 && i < str2.length() - 1) {
                stringBuffer.append(":");
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    static String m10100a(X509Certificate x509Certificate) {
        try {
            return C1299a.m10098a(m10099a(x509Certificate.getEncoded()));
        } catch (CertificateEncodingException unused) {
            return null;
        }
    }

    /* renamed from: a */
    static byte[] m10099a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA1").digest(bArr);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
