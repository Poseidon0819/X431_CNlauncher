package com.baidu.android.bbalbs.common.util;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.ErrnoException;
import android.system.Os;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.bbalbs.common.p077a.C0858a;
import com.baidu.android.bbalbs.common.p077a.C0859b;
import com.baidu.android.bbalbs.common.p077a.C0860c;
import com.baidu.android.bbalbs.common.p077a.C0861d;
import com.itextpdf.text.DocWriter;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.crypto.Cipher;
import org.apache.mina.proxy.handlers.http.HttpProxyConstants;
import org.apache.mina.proxy.handlers.socks.SocksProxyConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.bbalbs.common.util.b */
/* loaded from: classes.dex */
public final class C0863b {

    /* renamed from: a */
    private static final String f3711a;

    /* renamed from: e */
    private static C0866b f3712e;

    /* renamed from: b */
    private final Context f3713b;

    /* renamed from: c */
    private int f3714c = 0;

    /* renamed from: d */
    private PublicKey f3715d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.android.bbalbs.common.util.b$a */
    /* loaded from: classes.dex */
    public static class C0865a {

        /* renamed from: a */
        public ApplicationInfo f3717a;

        /* renamed from: b */
        public int f3718b;

        /* renamed from: c */
        public boolean f3719c;

        /* renamed from: d */
        public boolean f3720d;

        private C0865a() {
            this.f3718b = 0;
            this.f3719c = false;
            this.f3720d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.android.bbalbs.common.util.b$b */
    /* loaded from: classes.dex */
    public static class C0866b {

        /* renamed from: a */
        public String f3721a;

        /* renamed from: b */
        public String f3722b;

        /* renamed from: c */
        public int f3723c;

        private C0866b() {
            this.f3723c = 2;
        }

        /* renamed from: a */
        public static C0866b m12395a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("deviceid");
                String string2 = jSONObject.getString("imei");
                int i = jSONObject.getInt("ver");
                if (!TextUtils.isEmpty(string) && string2 != null) {
                    C0866b c0866b = new C0866b();
                    c0866b.f3721a = string;
                    c0866b.f3722b = string2;
                    c0866b.f3723c = i;
                    return c0866b;
                }
            } catch (JSONException e) {
                C0863b.m12409b(e);
            }
            return null;
        }

        /* renamed from: a */
        public String m12396a() {
            try {
                return new JSONObject().put("deviceid", this.f3721a).put("imei", this.f3722b).put("ver", this.f3723c).toString();
            } catch (JSONException e) {
                C0863b.m12409b(e);
                return null;
            }
        }

        /* renamed from: b */
        public String m12394b() {
            String str = this.f3722b;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            String stringBuffer = new StringBuffer(str).reverse().toString();
            return this.f3721a + "|" + stringBuffer;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.android.bbalbs.common.util.b$c */
    /* loaded from: classes.dex */
    public static class C0867c {
        /* renamed from: a */
        static boolean m12393a(String str, int i) {
            try {
                Os.chmod(str, i);
                return true;
            } catch (ErrnoException e) {
                C0863b.m12409b(e);
                return false;
            }
        }
    }

    static {
        String str = new String(C0859b.m12432a(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, DocWriter.EQUALS}));
        String str2 = new String(C0859b.m12432a(new byte[]{SocksProxyConstants.V4_REPLY_REQUEST_GRANTED, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, DocWriter.EQUALS}));
        f3711a = str + str2;
    }

    private C0863b(Context context) {
        this.f3713b = context.getApplicationContext();
        m12424a();
    }

    /* renamed from: a */
    public static String m12423a(Context context) {
        return m12407c(context).m12394b();
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m12421a(java.io.File r5) {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2c
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2c
            r5 = 8192(0x2000, float:1.148E-41)
            char[] r5 = new char[r5]     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3c
            java.io.CharArrayWriter r2 = new java.io.CharArrayWriter     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3c
            r2.<init>()     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3c
        Lf:
            int r3 = r1.read(r5)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3c
            if (r3 <= 0) goto L1a
            r4 = 0
            r2.write(r5, r4, r3)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3c
            goto Lf
        L1a:
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3c
            r1.close()     // Catch: java.lang.Exception -> L22
            goto L26
        L22:
            r0 = move-exception
            m12409b(r0)
        L26:
            return r5
        L27:
            r5 = move-exception
            goto L2e
        L29:
            r5 = move-exception
            r1 = r0
            goto L3d
        L2c:
            r5 = move-exception
            r1 = r0
        L2e:
            m12409b(r5)     // Catch: java.lang.Throwable -> L3c
            if (r1 == 0) goto L3b
            r1.close()     // Catch: java.lang.Exception -> L37
            goto L3b
        L37:
            r5 = move-exception
            m12409b(r5)
        L3b:
            return r0
        L3c:
            r5 = move-exception
        L3d:
            if (r1 == 0) goto L47
            r1.close()     // Catch: java.lang.Exception -> L43
            goto L47
        L43:
            r0 = move-exception
            m12409b(r0)
        L47:
            throw r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.bbalbs.common.util.C0863b.m12421a(java.io.File):java.lang.String");
    }

    /* renamed from: a */
    private static String m12417a(byte[] bArr) {
        StringBuilder sb;
        if (bArr != null) {
            String str = "";
            for (byte b : bArr) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    sb = new StringBuilder();
                    sb.append(str);
                    str = "0";
                } else {
                    sb = new StringBuilder();
                }
                sb.append(str);
                sb.append(hexString);
                str = sb.toString();
            }
            return str.toLowerCase();
        }
        throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
    }

    /* renamed from: a */
    private List<C0865a> m12422a(Intent intent, boolean z) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = this.f3713b.getPackageManager();
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.applicationInfo != null) {
                    try {
                        Bundle bundle = packageManager.getReceiverInfo(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name), 128).metaData;
                        if (bundle != null) {
                            String string = bundle.getString("galaxy_data");
                            if (!TextUtils.isEmpty(string)) {
                                byte[] m12432a = C0859b.m12432a(string.getBytes("utf-8"));
                                JSONObject jSONObject = new JSONObject(new String(m12432a));
                                C0865a c0865a = new C0865a();
                                c0865a.f3718b = jSONObject.getInt("priority");
                                c0865a.f3717a = resolveInfo.activityInfo.applicationInfo;
                                if (this.f3713b.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                    c0865a.f3720d = true;
                                }
                                if (z) {
                                    String string2 = bundle.getString("galaxy_sf");
                                    if (!TextUtils.isEmpty(string2)) {
                                        PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.applicationInfo.packageName, 64);
                                        JSONArray jSONArray = jSONObject.getJSONArray("sigs");
                                        String[] strArr = new String[jSONArray.length()];
                                        for (int i = 0; i < strArr.length; i++) {
                                            strArr[i] = jSONArray.getString(i);
                                        }
                                        if (m12414a(strArr, m12415a(packageInfo.signatures))) {
                                            byte[] m12416a = m12416a(C0859b.m12432a(string2.getBytes()), this.f3715d);
                                            if (m12416a != null && Arrays.equals(m12416a, C0861d.m12427a(m12432a))) {
                                                c0865a.f3719c = true;
                                            }
                                        }
                                    }
                                }
                                arrayList.add(c0865a);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        Collections.sort(arrayList, new Comparator<C0865a>() { // from class: com.baidu.android.bbalbs.common.util.b.1
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(C0865a c0865a2, C0865a c0865a3) {
                int i2 = c0865a3.f3718b - c0865a2.f3718b;
                if (i2 == 0) {
                    if (c0865a2.f3720d && c0865a3.f3720d) {
                        return 0;
                    }
                    if (c0865a2.f3720d) {
                        return -1;
                    }
                    if (c0865a3.f3720d) {
                        return 1;
                    }
                }
                return i2;
            }
        });
        return arrayList;
    }

    /* renamed from: a */
    private void m12424a() {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(C0862a.m12425a());
        } catch (Exception unused) {
        } catch (Throwable th2) {
            byteArrayInputStream = null;
            th = th2;
        }
        try {
            this.f3715d = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream).getPublicKey();
            try {
                byteArrayInputStream.close();
            } catch (Exception e) {
                m12409b(e);
            }
        } catch (Exception unused2) {
            byteArrayInputStream2 = byteArrayInputStream;
            if (byteArrayInputStream2 != null) {
                try {
                    byteArrayInputStream2.close();
                } catch (Exception e2) {
                    m12409b(e2);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (Exception e3) {
                    m12409b(e3);
                }
            }
            throw th;
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private boolean m12420a(String str) {
        int i = Build.VERSION.SDK_INT >= 24 ? 0 : 1;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                fileOutputStream = this.f3713b.openFileOutput("libcuid.so", i);
                fileOutputStream.write(str.getBytes());
                fileOutputStream.flush();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e) {
                        m12409b(e);
                    }
                }
                if (i == 0) {
                    return C0867c.m12393a(new File(this.f3713b.getFilesDir(), "libcuid.so").getAbsolutePath(), 436);
                }
                return true;
            } catch (Exception e2) {
                m12409b(e2);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e3) {
                        m12409b(e3);
                    }
                }
                return false;
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e4) {
                    m12409b(e4);
                }
            }
            throw th;
        }
    }

    /* renamed from: a */
    private boolean m12419a(String str, String str2) {
        try {
            return Settings.System.putString(this.f3713b.getContentResolver(), str, str2);
        } catch (Exception e) {
            m12409b(e);
            return false;
        }
    }

    /* renamed from: a */
    private boolean m12414a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            hashSet.add(str);
        }
        HashSet hashSet2 = new HashSet();
        for (String str2 : strArr2) {
            hashSet2.add(str2);
        }
        return hashSet.equals(hashSet2);
    }

    /* renamed from: a */
    private static byte[] m12416a(byte[] bArr, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, publicKey);
        return cipher.doFinal(bArr);
    }

    /* renamed from: a */
    private String[] m12415a(Signature[] signatureArr) {
        String[] strArr = new String[signatureArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = m12417a(C0861d.m12427a(signatureArr[i].toByteArray()));
        }
        return strArr;
    }

    /* renamed from: b */
    private C0866b m12413b() {
        boolean z;
        String str;
        List<C0865a> m12422a = m12422a(new Intent("com.baidu.intent.action.GALAXY").setPackage(this.f3713b.getPackageName()), true);
        boolean z2 = false;
        if (m12422a == null || m12422a.size() == 0) {
            for (int i = 0; i < 3; i++) {
                Log.w("DeviceId", "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
            }
            z = false;
        } else {
            C0865a c0865a = m12422a.get(0);
            z = c0865a.f3719c;
            if (!c0865a.f3719c) {
                for (int i2 = 0; i2 < 3; i2++) {
                    Log.w("DeviceId", "galaxy config err, In the release version of the signature should be matched");
                }
            }
        }
        File file = new File(this.f3713b.getFilesDir(), "libcuid.so");
        C0866b m12395a = file.exists() ? C0866b.m12395a(m12401f(m12421a(file))) : null;
        if (m12395a == null) {
            this.f3714c |= 16;
            List<C0865a> m12422a2 = m12422a(new Intent("com.baidu.intent.action.GALAXY"), z);
            if (m12422a2 != null) {
                String str2 = "files";
                File filesDir = this.f3713b.getFilesDir();
                if (!"files".equals(filesDir.getName())) {
                    Log.e("DeviceId", "fetal error:: app files dir name is unexpectedly :: " + filesDir.getAbsolutePath());
                    str2 = filesDir.getName();
                }
                for (C0865a c0865a2 : m12422a2) {
                    if (!c0865a2.f3720d) {
                        File file2 = new File(new File(c0865a2.f3717a.dataDir, str2), "libcuid.so");
                        if (file2.exists() && (m12395a = C0866b.m12395a(m12401f(m12421a(file2)))) != null) {
                            break;
                        }
                    }
                }
            }
        }
        if (m12395a == null) {
            m12395a = C0866b.m12395a(m12401f(m12411b("com.baidu.deviceid.v2")));
        }
        boolean m12406c = m12406c("android.permission.READ_EXTERNAL_STORAGE");
        if (m12395a == null && m12406c) {
            this.f3714c |= 2;
            m12395a = m12403e();
        }
        if (m12395a == null) {
            this.f3714c |= 8;
            m12395a = m12405d();
        }
        if (m12395a == null && m12406c) {
            this.f3714c |= 1;
            String m12399h = m12399h("");
            z2 = true;
            str = m12399h;
            m12395a = m12404d(m12399h);
        } else {
            str = null;
        }
        if (m12395a == null) {
            this.f3714c |= 4;
            if (!z2) {
                str = m12399h("");
            }
            m12395a = new C0866b();
            String m12412b = m12412b(this.f3713b);
            m12395a.f3721a = C0860c.m12428a((Build.VERSION.SDK_INT < 23 ? str + m12412b + UUID.randomUUID().toString() : "com.baidu".concat(String.valueOf(m12412b))).getBytes(), true);
            m12395a.f3722b = str;
        }
        File file3 = new File(this.f3713b.getFilesDir(), "libcuid.so");
        if ((this.f3714c & 16) != 0 || !file3.exists()) {
            r5 = TextUtils.isEmpty(null) ? m12402e(m12395a.m12396a()) : null;
            m12420a(r5);
        }
        boolean m12408c = m12408c();
        if (m12408c && ((this.f3714c & 2) != 0 || TextUtils.isEmpty(m12411b("com.baidu.deviceid.v2")))) {
            if (TextUtils.isEmpty(r5)) {
                r5 = m12402e(m12395a.m12396a());
            }
            m12419a("com.baidu.deviceid.v2", r5);
        }
        if (m12406c("android.permission.WRITE_EXTERNAL_STORAGE")) {
            File file4 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
            if ((this.f3714c & 8) != 0 || !file4.exists()) {
                if (TextUtils.isEmpty(r5)) {
                    r5 = m12402e(m12395a.m12396a());
                }
                m12400g(r5);
            }
        }
        if (m12408c && ((1 & this.f3714c) != 0 || TextUtils.isEmpty(m12411b("com.baidu.deviceid")))) {
            m12419a("com.baidu.deviceid", m12395a.f3721a);
        }
        if (m12408c && !TextUtils.isEmpty(m12395a.f3722b)) {
            File file5 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
            if ((this.f3714c & 2) != 0 || !file5.exists()) {
                m12410b(m12395a.f3722b, m12395a.f3721a);
            }
        }
        return m12395a;
    }

    /* renamed from: b */
    public static String m12412b(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        return TextUtils.isEmpty(string) ? "" : string;
    }

    /* renamed from: b */
    private String m12411b(String str) {
        try {
            return Settings.System.getString(this.f3713b.getContentResolver(), str);
        } catch (Exception e) {
            m12409b(e);
            return null;
        }
    }

    /* renamed from: b */
    private static void m12410b(String str, String str2) {
        File file;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file2 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
        File file3 = new File(file2, ".cuid");
        try {
            if (file2.exists() && !file2.isDirectory()) {
                Random random = new Random();
                File parentFile = file2.getParentFile();
                String name = file2.getName();
                do {
                    file = new File(parentFile, name + random.nextInt() + ".tmp");
                } while (file.exists());
                file2.renameTo(file);
                file.delete();
            }
            file2.mkdirs();
            FileWriter fileWriter = new FileWriter(file3, false);
            String str3 = f3711a;
            fileWriter.write(C0859b.m12430a(C0858a.m12434a(str3, str3, (str + "=" + str2).getBytes()), "utf-8"));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m12409b(Throwable th) {
    }

    /* renamed from: c */
    private static C0866b m12407c(Context context) {
        if (f3712e == null) {
            synchronized (C0866b.class) {
                if (f3712e == null) {
                    SystemClock.uptimeMillis();
                    f3712e = new C0863b(context).m12413b();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return f3712e;
    }

    /* renamed from: c */
    private boolean m12408c() {
        return m12406c("android.permission.WRITE_SETTINGS");
    }

    /* renamed from: c */
    private boolean m12406c(String str) {
        return this.f3713b.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    /* renamed from: d */
    private C0866b m12405d() {
        String m12411b = m12411b("com.baidu.deviceid");
        String m12411b2 = m12411b("bd_setting_i");
        if (TextUtils.isEmpty(m12411b2)) {
            m12411b2 = m12399h("");
            TextUtils.isEmpty(m12411b2);
        }
        if (TextUtils.isEmpty(m12411b)) {
            String m12412b = m12412b(this.f3713b);
            m12411b = m12411b(C0860c.m12428a(("com.baidu" + m12411b2 + m12412b).getBytes(), true));
        }
        if (TextUtils.isEmpty(m12411b)) {
            return null;
        }
        C0866b c0866b = new C0866b();
        c0866b.f3721a = m12411b;
        c0866b.f3722b = m12411b2;
        return c0866b;
    }

    /* renamed from: d */
    private C0866b m12404d(String str) {
        boolean z;
        boolean z2 = Build.VERSION.SDK_INT < 23;
        if (z2 && TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = "";
        File file = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
        if (file.exists()) {
            z = false;
        } else {
            file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
            z = true;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append(HttpProxyConstants.CRLF);
            }
            bufferedReader.close();
            String str3 = f3711a;
            String[] split = new String(C0858a.m12433b(str3, str3, C0859b.m12432a(sb.toString().getBytes()))).split("=");
            if (split != null && split.length == 2) {
                if (!z2 || !str.equals(split[0])) {
                    if (!z2) {
                        if (TextUtils.isEmpty(str)) {
                            str = split[1];
                        }
                    }
                }
                str2 = split[1];
            }
            if (!z) {
                m12410b(str, str2);
            }
        } catch (FileNotFoundException | IOException | Exception unused) {
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        C0866b c0866b = new C0866b();
        c0866b.f3721a = str2;
        c0866b.f3722b = str;
        return c0866b;
    }

    /* renamed from: e */
    private C0866b m12403e() {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (file.exists()) {
            String m12421a = m12421a(file);
            if (TextUtils.isEmpty(m12421a)) {
                return null;
            }
            try {
                String str = f3711a;
                return C0866b.m12395a(new String(C0858a.m12433b(str, str, C0859b.m12432a(m12421a.getBytes()))));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* renamed from: e */
    private static String m12402e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String str2 = f3711a;
            return C0859b.m12430a(C0858a.m12434a(str2, str2, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException | Exception e) {
            m12409b(e);
            return "";
        }
    }

    /* renamed from: f */
    private static String m12401f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String str2 = f3711a;
            return new String(C0858a.m12433b(str2, str2, C0859b.m12432a(str.getBytes())));
        } catch (Exception e) {
            m12409b(e);
            return "";
        }
    }

    /* renamed from: g */
    private static void m12400g(String str) {
        File file;
        File file2 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
        File file3 = new File(file2, ".cuid2");
        try {
            if (file2.exists() && !file2.isDirectory()) {
                Random random = new Random();
                File parentFile = file2.getParentFile();
                String name = file2.getName();
                do {
                    file = new File(parentFile, name + random.nextInt() + ".tmp");
                } while (file.exists());
                file2.renameTo(file);
                file.delete();
            }
            file2.mkdirs();
            FileWriter fileWriter = new FileWriter(file3, false);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | Exception unused) {
        }
    }

    /* renamed from: h */
    private String m12399h(String str) {
        String str2 = null;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f3713b.getSystemService("phone");
            if (telephonyManager != null) {
                str2 = telephonyManager.getDeviceId();
            }
        } catch (Exception e) {
            Log.e("DeviceId", "Read IMEI failed", e);
        }
        String m12398i = m12398i(str2);
        return TextUtils.isEmpty(m12398i) ? str : m12398i;
    }

    /* renamed from: i */
    private static String m12398i(String str) {
        return (str == null || !str.contains(":")) ? str : "";
    }
}
