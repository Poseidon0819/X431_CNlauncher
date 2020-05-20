package com.unionpay.mobile.android.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.utils.c */
/* loaded from: classes2.dex */
public final class C4382c {

    /* renamed from: a */
    private static String f23180a = "[{\"type\":\"app\",\"sort\":100,\"package_info\":[{\"schema\":\"com.unionpay.uppay\",\"version\":\".*\",\"sign\":\"23137B5BE6AEF6682B41E6536F08367E0949A1CC\",\"sort\":101}],\"need_install\":true,\"install_msg\":\"�Ƿ����ذ�װ��������֧������\",\"url\":\"https://mobile.unionpay.com/getclient?platform=android&type=securepayplugin\",\"download_app\":\"UPPayPluginEx.apk\",\"download_title\":\"��������֧������\",\"download_desp\":\"��������֧������\",\"md5\":\"D75BB2802E61738A9A03BF014F927D9A\"},{\"type\":\"jar\",\"sort\":200}]";

    /* renamed from: b */
    private static SimpleDateFormat f23181b = new SimpleDateFormat("yyyyMMddhhmmss");

    /* renamed from: c */
    private static HashMap<String, String> f23182c = new C4383d();

    /* renamed from: d */
    private static long[] f23183d = new long[256];

    static {
        for (int i = 0; i < 256; i++) {
            long j = i;
            for (int i2 = 0; i2 < 8; i2++) {
                j = (j >> 1) ^ ((((int) j) & 1) != 0 ? -7661587058870466123L : 0L);
            }
            f23183d[i] = j;
        }
    }

    /* renamed from: a */
    public static String m888a() {
        return f23181b.format(new Date(System.currentTimeMillis()));
    }

    /* renamed from: a */
    public static String m887a(Context context) {
        int i;
        String str = "";
        String m904a = PreferenceUtils.m904a(context, "configs");
        String m904a2 = PreferenceUtils.m904a(context, "mode");
        String m904a3 = PreferenceUtils.m904a(context, "or");
        if (!TextUtils.isEmpty(m904a) && !TextUtils.isEmpty(m904a2) && !TextUtils.isEmpty(m904a3)) {
            try {
                JSONObject jSONObject = new JSONObject(m904a);
                String m846a = C4389j.m846a(jSONObject, "sign");
                try {
                    i = Integer.parseInt(m904a2);
                } catch (NumberFormatException unused) {
                    i = 0;
                }
                String str2 = new String(Base64.decode(jSONObject.getString("configs"), 2));
                String str3 = jSONObject.has("sePayConf") ? new String(Base64.decode(jSONObject.getString("sePayConf"), 2)) : "";
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                if (PreferenceUtils.forConfig(i, m846a).equals(m881b(m877f(str2 + str3 + m904a3)))) {
                    str = str2;
                }
            } catch (Exception unused2) {
            }
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                Object m845b = C4389j.m845b(jSONArray, i2);
                if (m845b != null) {
                    JSONObject jSONObject2 = (JSONObject) m845b;
                    if ("app".equals(C4389j.m846a(jSONObject2, VastExtensionXmlManager.TYPE))) {
                        return new String(Base64.decode(C4389j.m846a(jSONObject2, "ca"), 2));
                    }
                }
            }
            return "";
        } catch (JSONException unused3) {
            return "";
        }
    }

    /* renamed from: a */
    private static String m884a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i]);
            int length = hexString.length();
            if (length == 1) {
                hexString = "0".concat(String.valueOf(hexString));
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb.append(hexString.toUpperCase());
            if (i < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static boolean m886a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m885a(String str) {
        return str.matches("[0-9A-Fa-f]+");
    }

    /* renamed from: b */
    public static String m883b(Context context) {
        String str = f23182c.get(C4385f.m869b(context));
        return !TextUtils.isEmpty(str) ? str : DiagnoseConstants.UI_TYPE_NO_UI_CMD;
    }

    /* renamed from: b */
    public static String m882b(Context context, String str) {
        PackageInfo packageInfo;
        CertificateFactory certificateFactory;
        X509Certificate x509Certificate;
        String str2 = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 64);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(packageInfo.signatures[0].toByteArray());
        try {
            certificateFactory = CertificateFactory.getInstance("X509");
        } catch (CertificateException e2) {
            e2.printStackTrace();
            certificateFactory = null;
        }
        try {
            x509Certificate = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
        } catch (CertificateException e3) {
            e3.printStackTrace();
            x509Certificate = null;
        }
        try {
            str2 = m884a(MessageDigest.getInstance("SHA1").digest(x509Certificate.getEncoded()));
        } catch (NoSuchAlgorithmException e4) {
            e4.printStackTrace();
        } catch (CertificateEncodingException e5) {
            e5.printStackTrace();
        }
        return str2.replaceAll(":", "");
    }

    /* renamed from: b */
    public static String m881b(String str) {
        byte[] bytes;
        if (str == null) {
            return "";
        }
        char[] charArray = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        for (byte b : str.getBytes()) {
            sb.append(charArray[(b & 240) >> 4]);
            sb.append(charArray[b & 15]);
        }
        return sb.toString().trim();
    }

    /* renamed from: c */
    public static String m880c(String str) {
        try {
            return new BigDecimal(str).divide(new BigDecimal(DiagnoseConstants.UI_TYPE_DIALOG)).toString();
        } catch (Exception unused) {
            return "1";
        }
    }

    /* renamed from: d */
    public static String m879d(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() / 3; i++) {
            sb.append("cmd");
        }
        for (int i2 = 0; i2 < str.length() % 3; i2++) {
            sb.append("cmd".charAt(i2));
        }
        byte[] bytes = str.getBytes();
        byte[] bytes2 = sb.toString().getBytes();
        byte[] bArr = new byte[str.length()];
        for (int i3 = 0; i3 < bytes.length; i3++) {
            bArr[i3] = (byte) (bytes[i3] ^ bytes2[i3]);
        }
        return C4381b.m889a(bArr);
    }

    /* renamed from: e */
    public static String m878e(String str) {
        long j;
        char[] charArray;
        if (str == null || str.length() == 0) {
            j = 0;
        } else {
            byte[] bArr = new byte[str.length() * 2];
            int i = 0;
            for (char c : str.toCharArray()) {
                int i2 = i + 1;
                bArr[i] = (byte) (c & 255);
                i = i2 + 1;
                bArr[i2] = (byte) (c >> '\b');
            }
            j = -1;
            for (byte b : bArr) {
                j = (j >> 8) ^ f23183d[(b ^ ((int) j)) & 255];
            }
        }
        return Long.toHexString(j);
    }

    /* renamed from: f */
    private static String m877f(String str) {
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.reset();
            messageDigest.update(bytes);
            return C4381b.m889a(messageDigest.digest());
        } catch (Exception unused) {
            return null;
        }
    }
}
