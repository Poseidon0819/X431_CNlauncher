package com.unionpay.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.unionpay.utils.b */
/* loaded from: classes2.dex */
public final class C4644b {

    /* renamed from: a */
    private static SimpleDateFormat f23756a = new SimpleDateFormat("yyyyMMddhhmmss");

    /* renamed from: b */
    private static HashMap f23757b = new C4645c();

    /* renamed from: a */
    public static String m464a(Context context) {
        int i;
        String str = "";
        String m473a = UPUtils.m473a(context, "configs");
        String m473a2 = UPUtils.m473a(context, "mode");
        String m473a3 = UPUtils.m473a(context, "or");
        if (!TextUtils.isEmpty(m473a) && !TextUtils.isEmpty(m473a2) && !TextUtils.isEmpty(m473a3)) {
            try {
                JSONObject jSONObject = new JSONObject(m473a);
                String m438a = C4651i.m438a(jSONObject, "sign");
                try {
                    i = Integer.parseInt(m473a2);
                } catch (NumberFormatException unused) {
                    i = 0;
                }
                String str2 = new String(Base64.decode(jSONObject.getString("configs"), 2));
                String str3 = jSONObject.has("sePayConf") ? new String(Base64.decode(jSONObject.getString("sePayConf"), 2)) : "";
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                String m461a = m461a(UPUtils.m471a(str2 + str3 + m473a3));
                String forConfig = UPUtils.forConfig(i, m438a);
                if (!TextUtils.isEmpty(forConfig)) {
                    if (forConfig.equals(m461a)) {
                        str = str2;
                    }
                }
            } catch (Exception unused2) {
            }
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                Object m439a = C4651i.m439a(jSONArray, i2);
                if (m439a != null) {
                    JSONObject jSONObject2 = (JSONObject) m439a;
                    if ("app".equals(C4651i.m438a(jSONObject2, VastExtensionXmlManager.TYPE))) {
                        return new String(Base64.decode(C4651i.m438a(jSONObject2, "ca"), 2));
                    }
                }
            }
            return "";
        } catch (JSONException unused3) {
            return "";
        }
    }

    /* renamed from: a */
    public static String m462a(InputStream inputStream, String str) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    return byteArrayOutputStream.toString(str);
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    /* renamed from: a */
    public static String m461a(String str) {
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

    /* renamed from: a */
    private static String m460a(byte[] bArr) {
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
    public static boolean m463a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static String m459b(Context context, String str) {
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
            str2 = m460a(MessageDigest.getInstance("SHA1").digest(x509Certificate.getEncoded()));
        } catch (NoSuchAlgorithmException e4) {
            e4.printStackTrace();
        } catch (CertificateEncodingException e5) {
            e5.printStackTrace();
        }
        return str2.replaceAll(":", "");
    }

    /* renamed from: b */
    public static String m458b(String str) {
        File file = new File(str);
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            try {
                MappedByteBuffer map = fileInputStream.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, file.length());
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(map);
                String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
                try {
                    fileInputStream.close();
                    return bigInteger;
                } catch (IOException e) {
                    e.printStackTrace();
                    return bigInteger;
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                throw th;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            try {
                fileInputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: c */
    public static String m457c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    /* renamed from: c */
    public static void m456c(String str) {
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    m456c(file2.getPath());
                }
            }
            file.delete();
        }
    }

    /* renamed from: d */
    public static String m454d(String str) {
        return !TextUtils.isEmpty((CharSequence) f23757b.get(str)) ? (String) f23757b.get(str) : str;
    }

    /* renamed from: d */
    public static boolean m455d(Context context, String str) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException | Exception unused) {
        }
        return packageInfo != null;
    }

    /* renamed from: e */
    public static final boolean m453e(String str) {
        return !Pattern.compile("[^0-9]+").matcher(str).find();
    }
}
