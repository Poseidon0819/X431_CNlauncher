package com.baidu.lbsapi.auth;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.util.Base64;
import com.itextpdf.text.pdf.PdfWriter;
import com.unionpay.tsmservice.p373mi.data.Constant;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Locale;

/* renamed from: com.baidu.lbsapi.auth.b */
/* loaded from: classes.dex */
class C0873b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.lbsapi.auth.b$a */
    /* loaded from: classes.dex */
    public static class C0874a {
        /* renamed from: a */
        public static String m12356a(byte[] bArr) {
            char[] cArr = {'0', '1', PdfWriter.VERSION_1_2, PdfWriter.VERSION_1_3, PdfWriter.VERSION_1_4, PdfWriter.VERSION_1_5, PdfWriter.VERSION_1_6, PdfWriter.VERSION_1_7, '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            for (int i = 0; i < bArr.length; i++) {
                sb.append(cArr[(bArr[i] & 240) >> 4]);
                sb.append(cArr[bArr[i] & 15]);
            }
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m12366a() {
        return Locale.getDefault().getLanguage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static String m12365a(Context context) {
        String packageName = context.getPackageName();
        String m12364a = m12364a(context, packageName);
        return m12364a + ";" + packageName;
    }

    /* renamed from: a */
    private static String m12364a(Context context, String str) {
        String str2 = "";
        try {
            str2 = m12363a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray())));
        } catch (PackageManager.NameNotFoundException | CertificateException unused) {
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
    static String m12363a(X509Certificate x509Certificate) {
        try {
            return C0874a.m12356a(m12362a(x509Certificate.getEncoded()));
        } catch (CertificateEncodingException unused) {
            return null;
        }
    }

    /* renamed from: a */
    static byte[] m12362a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA1").digest(bArr);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public static String[] m12361b(Context context) {
        String packageName = context.getPackageName();
        String[] m12360b = m12360b(context, packageName);
        if (m12360b == null || m12360b.length <= 0) {
            return null;
        }
        String[] strArr = new String[m12360b.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = m12360b[i] + ";" + packageName;
            if (C0872a.f3743a) {
                C0872a.m12369a("mcode" + strArr[i]);
            }
        }
        return strArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String[] m12360b(android.content.Context r6, java.lang.String r7) {
        /*
            r0 = 0
            r1 = 0
            android.content.pm.PackageManager r6 = r6.getPackageManager()     // Catch: java.lang.Throwable -> L3c
            r2 = 64
            android.content.pm.PackageInfo r6 = r6.getPackageInfo(r7, r2)     // Catch: java.lang.Throwable -> L3c
            android.content.pm.Signature[] r6 = r6.signatures     // Catch: java.lang.Throwable -> L3c
            if (r6 == 0) goto L3c
            int r7 = r6.length     // Catch: java.lang.Throwable -> L3c
            if (r7 <= 0) goto L3c
            int r7 = r6.length     // Catch: java.lang.Throwable -> L3c
            java.lang.String[] r7 = new java.lang.String[r7]     // Catch: java.lang.Throwable -> L3c
            r2 = 0
        L17:
            int r3 = r6.length     // Catch: java.lang.Throwable -> L3a
            if (r2 >= r3) goto L3d
            java.lang.String r3 = "X.509"
            java.security.cert.CertificateFactory r3 = java.security.cert.CertificateFactory.getInstance(r3)     // Catch: java.lang.Throwable -> L3a
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L3a
            r5 = r6[r2]     // Catch: java.lang.Throwable -> L3a
            byte[] r5 = r5.toByteArray()     // Catch: java.lang.Throwable -> L3a
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L3a
            java.security.cert.Certificate r3 = r3.generateCertificate(r4)     // Catch: java.lang.Throwable -> L3a
            java.security.cert.X509Certificate r3 = (java.security.cert.X509Certificate) r3     // Catch: java.lang.Throwable -> L3a
            java.lang.String r3 = m12363a(r3)     // Catch: java.lang.Throwable -> L3a
            r7[r2] = r3     // Catch: java.lang.Throwable -> L3a
            int r2 = r2 + 1
            goto L17
        L3a:
            goto L3d
        L3c:
            r7 = r0
        L3d:
            if (r7 == 0) goto L81
            int r6 = r7.length
            if (r6 <= 0) goto L81
            int r6 = r7.length
            java.lang.String[] r0 = new java.lang.String[r6]
            r6 = 0
        L46:
            int r2 = r7.length
            if (r6 >= r2) goto L81
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            r3 = 0
        L4f:
            r4 = r7[r6]
            int r4 = r4.length()
            if (r3 >= r4) goto L78
            r4 = r7[r6]
            char r4 = r4.charAt(r3)
            r2.append(r4)
            if (r3 <= 0) goto L75
            int r4 = r3 % 2
            r5 = 1
            if (r4 != r5) goto L75
            r4 = r7[r6]
            int r4 = r4.length()
            int r4 = r4 - r5
            if (r3 >= r4) goto L75
            java.lang.String r4 = ":"
            r2.append(r4)
        L75:
            int r3 = r3 + 1
            goto L4f
        L78:
            java.lang.String r2 = r2.toString()
            r0[r6] = r2
            int r6 = r6 + 1
            goto L46
        L81:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.C0873b.m12360b(android.content.Context, java.lang.String):java.lang.String[]");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static String m12359c(Context context) {
        String string = context.getSharedPreferences(Constant.KEY_MAC, 0).getString("macaddr", null);
        if (string == null) {
            String m12357d = m12357d(context);
            if (m12357d != null) {
                string = Base64.encodeToString(m12357d.getBytes(), 0);
                if (!TextUtils.isEmpty(string)) {
                    context.getSharedPreferences(Constant.KEY_MAC, 0).edit().putString("macaddr", string).commit();
                }
            } else {
                string = "";
            }
        }
        if (C0872a.f3743a) {
            C0872a.m12369a("getMacID mac_adress: ".concat(String.valueOf(string)));
        }
        return string;
    }

    /* renamed from: c */
    private static boolean m12358c(Context context, String str) {
        boolean z = context.checkCallingOrSelfPermission(str) != -1;
        if (C0872a.f3743a) {
            C0872a.m12369a("hasPermission " + z + " | " + str);
        }
        return z;
    }

    /* renamed from: d */
    static String m12357d(Context context) {
        String format;
        String str = null;
        try {
        } catch (Exception e) {
            if (C0872a.f3743a) {
                C0872a.m12369a(e.toString());
            }
        }
        if (!m12358c(context, "android.permission.ACCESS_WIFI_STATE")) {
            if (C0872a.f3743a) {
            }
            return str;
        }
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        str = connectionInfo.getMacAddress();
        if (!TextUtils.isEmpty(str)) {
            Base64.encode(str.getBytes(), 0);
        }
        format = C0872a.f3743a ? String.format("ssid=%s mac=%s", connectionInfo.getSSID(), connectionInfo.getMacAddress()) : "You need the android.Manifest.permission.ACCESS_WIFI_STATE permission. Open AndroidManifest.xml and just before the final </manifest> tag add:android.permission.ACCESS_WIFI_STATE";
        return str;
        C0872a.m12369a(format);
        return str;
    }
}
