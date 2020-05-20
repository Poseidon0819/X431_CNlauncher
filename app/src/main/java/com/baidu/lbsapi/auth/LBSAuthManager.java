package com.baidu.lbsapi.auth;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.lbsapi.auth.C0875c;
import com.baidu.lbsapi.auth.C0878d;
import com.itextpdf.text.Annotation;
import com.mopub.common.AdType;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.packet.PrivacyItem;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class LBSAuthManager {
    public static final int CODE_AUTHENTICATE_SUCC = 0;
    public static final int CODE_AUTHENTICATING = 602;
    public static final int CODE_INNER_ERROR = -1;
    public static final int CODE_KEY_NOT_EXIST = 101;
    public static final int CODE_NETWORK_FAILED = -11;
    public static final int CODE_NETWORK_INVALID = -10;
    public static final int CODE_UNAUTHENTICATE = 601;
    public static final String VERSION = "1.0.22";

    /* renamed from: a */
    private static Context f3724a;

    /* renamed from: d */
    private static C0883f f3725d;

    /* renamed from: e */
    private static int f3726e;

    /* renamed from: f */
    private static Hashtable<String, LBSAuthManagerListener> f3727f = new Hashtable<>();

    /* renamed from: g */
    private static LBSAuthManager f3728g;

    /* renamed from: b */
    private C0875c f3729b = null;

    /* renamed from: c */
    private C0878d f3730c = null;

    /* renamed from: h */
    private final Handler f3731h = new Handler(Looper.getMainLooper()) { // from class: com.baidu.lbsapi.auth.LBSAuthManager.1
        @Override // android.os.Handler
        public void handleMessage(Message message2) {
            if (C0872a.f3743a) {
                C0872a.m12369a("handleMessage !!");
            }
            LBSAuthManagerListener lBSAuthManagerListener = (LBSAuthManagerListener) LBSAuthManager.f3727f.get(message2.getData().getString("listenerKey"));
            if (C0872a.f3743a) {
                C0872a.m12369a("handleMessage listener = ".concat(String.valueOf(lBSAuthManagerListener)));
            }
            if (lBSAuthManagerListener != null) {
                lBSAuthManagerListener.onAuthResult(message2.what, message2.obj.toString());
            }
        }
    };

    private LBSAuthManager(Context context) {
        f3724a = context;
        C0883f c0883f = f3725d;
        if (c0883f != null && !c0883f.isAlive()) {
            f3725d = null;
        }
        C0872a.m12368b("BaiduApiAuth SDK Version:1.0.22");
        m12374d();
    }

    /* renamed from: a */
    private int m12382a(String str) {
        int i = -1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                jSONObject.put("status", -1);
            }
            i = jSONObject.getInt("status");
            if (jSONObject.has("current") && i == 0) {
                long j = jSONObject.getLong("current");
                long currentTimeMillis = System.currentTimeMillis();
                double d = currentTimeMillis - j;
                Double.isNaN(d);
                if (d / 3600000.0d < 24.0d) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    if (!simpleDateFormat.format(Long.valueOf(currentTimeMillis)).equals(simpleDateFormat.format(Long.valueOf(j)))) {
                    }
                }
                i = CODE_UNAUTHENTICATE;
            }
            if (jSONObject.has("current") && i == 602) {
                return ((double) ((System.currentTimeMillis() - jSONObject.getLong("current")) / 1000)) > 180.0d ? CODE_UNAUTHENTICATE : i;
            }
            return i;
        } catch (JSONException e) {
            e.printStackTrace();
            return i;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0073, code lost:
        if (r6 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0083, code lost:
        if (r6 == null) goto L13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0080  */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.InputStreamReader] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m12389a(int r6) throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L66 java.io.FileNotFoundException -> L76
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L66 java.io.FileNotFoundException -> L76
            java.lang.String r3 = "/proc/"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L66 java.io.FileNotFoundException -> L76
            r2.append(r6)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L66 java.io.FileNotFoundException -> L76
            java.lang.String r6 = "/cmdline"
            r2.append(r6)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L66 java.io.FileNotFoundException -> L76
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L66 java.io.FileNotFoundException -> L76
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L66 java.io.FileNotFoundException -> L76
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L66 java.io.FileNotFoundException -> L76
            r6.<init>(r1)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L66 java.io.FileNotFoundException -> L76
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4f java.io.FileNotFoundException -> L51
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4f java.io.FileNotFoundException -> L51
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L46 java.io.FileNotFoundException -> L48
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L46 java.io.FileNotFoundException -> L48
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L3d java.io.FileNotFoundException -> L3f
            r2.close()
            r1.close()
        L32:
            r6.close()
            goto L86
        L37:
            r0 = move-exception
            r4 = r2
            r2 = r6
            r6 = r0
            r0 = r4
            goto L56
        L3d:
            goto L69
        L3f:
            goto L79
        L41:
            r2 = move-exception
            r4 = r2
            r2 = r6
            r6 = r4
            goto L56
        L46:
            r2 = r0
            goto L69
        L48:
            r2 = r0
            goto L79
        L4a:
            r1 = move-exception
            r2 = r6
            r6 = r1
            r1 = r0
            goto L56
        L4f:
            r1 = r0
            goto L68
        L51:
            r1 = r0
            goto L78
        L53:
            r6 = move-exception
            r1 = r0
            r2 = r1
        L56:
            if (r0 == 0) goto L5b
            r0.close()
        L5b:
            if (r1 == 0) goto L60
            r1.close()
        L60:
            if (r2 == 0) goto L65
            r2.close()
        L65:
            throw r6
        L66:
            r6 = r0
            r1 = r6
        L68:
            r2 = r1
        L69:
            if (r2 == 0) goto L6e
            r2.close()
        L6e:
            if (r1 == 0) goto L73
            r1.close()
        L73:
            if (r6 == 0) goto L86
            goto L85
        L76:
            r6 = r0
            r1 = r6
        L78:
            r2 = r1
        L79:
            if (r2 == 0) goto L7e
            r2.close()
        L7e:
            if (r1 == 0) goto L83
            r1.close()
        L83:
            if (r6 == 0) goto L86
        L85:
            goto L32
        L86:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.LBSAuthManager.m12389a(int):java.lang.String");
    }

    /* renamed from: a */
    private String m12388a(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        String str = null;
        try {
            str = m12389a(myPid);
        } catch (IOException unused) {
        }
        return str != null ? str : f3724a.getPackageName();
    }

    /* renamed from: a */
    private String m12387a(Context context, String str) {
        ApplicationInfo applicationInfo;
        LBSAuthManagerListener lBSAuthManagerListener;
        String str2;
        String str3 = "";
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException unused) {
            LBSAuthManagerListener lBSAuthManagerListener2 = f3727f.get(str);
            if (lBSAuthManagerListener2 != null) {
                lBSAuthManagerListener2.onAuthResult(101, ErrorMessage.m12392a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
            }
        }
        if (applicationInfo.metaData == null) {
            lBSAuthManagerListener = f3727f.get(str);
            str2 = lBSAuthManagerListener != null ? "AndroidManifest.xml的application中没有meta-data标签" : "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值";
            return str3;
        }
        str3 = applicationInfo.metaData.getString("com.baidu.lbsapi.API_KEY");
        if ((str3 == null || str3.equals("")) && (lBSAuthManagerListener = f3727f.get(str)) != null) {
        }
        return str3;
        lBSAuthManagerListener.onAuthResult(101, ErrorMessage.m12392a(101, str2));
        return str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m12381a(String str, String str2) {
        if (str == null) {
            str = m12373e();
        }
        Message obtainMessage = this.f3731h.obtainMessage();
        int i = -1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                jSONObject.put("status", -1);
            }
            if (!jSONObject.has("current")) {
                jSONObject.put("current", System.currentTimeMillis());
            }
            m12375c(jSONObject.toString());
            if (jSONObject.has("current")) {
                jSONObject.remove("current");
            }
            i = jSONObject.getInt("status");
            obtainMessage.what = i;
            obtainMessage.obj = jSONObject.toString();
            Bundle bundle = new Bundle();
            bundle.putString("listenerKey", str2);
            obtainMessage.setData(bundle);
            this.f3731h.sendMessage(obtainMessage);
        } catch (JSONException e) {
            e.printStackTrace();
            obtainMessage.what = i;
            obtainMessage.obj = new JSONObject();
            Bundle bundle2 = new Bundle();
            bundle2.putString("listenerKey", str2);
            obtainMessage.setData(bundle2);
            this.f3731h.sendMessage(obtainMessage);
        }
        if (f3725d != null) {
            f3725d.m12332c();
        }
        f3726e--;
        if (C0872a.f3743a) {
            C0872a.m12369a("httpRequest called mAuthCounter-- = " + f3726e);
        }
        if (f3726e == 0 && f3725d != null) {
            f3725d.m12334a();
            f3725d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12380a(boolean z, String str, Hashtable<String, String> hashtable, final String str2) {
        String str3;
        String m12387a = m12387a(f3724a, str2);
        if (m12387a == null || m12387a.equals("")) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(Annotation.URL, "https://api.map.baidu.com/sdkcs/verify");
        C0872a.m12369a("url:https://api.map.baidu.com/sdkcs/verify");
        hashMap.put("output", AdType.STATIC_NATIVE);
        hashMap.put("ak", m12387a);
        C0872a.m12369a("ak:".concat(String.valueOf(m12387a)));
        hashMap.put("mcode", C0873b.m12365a(f3724a));
        hashMap.put(PrivacyItem.PrivacyRule.SUBSCRIPTION_FROM, "lbs_yunsdk");
        if (hashtable != null && hashtable.size() > 0) {
            for (Map.Entry<String, String> entry : hashtable.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    hashMap.put(key, value);
                }
            }
        }
        String str4 = "";
        try {
            str4 = CommonParam.m12426a(f3724a);
        } catch (Exception unused) {
        }
        C0872a.m12369a("cuid:".concat(String.valueOf(str4)));
        if (TextUtils.isEmpty(str4)) {
            hashMap.put("cuid", "");
        } else {
            hashMap.put("cuid", str4);
        }
        hashMap.put("pcn", f3724a.getPackageName());
        hashMap.put("version", VERSION);
        String str5 = "";
        try {
            str5 = C0873b.m12359c(f3724a);
        } catch (Exception unused2) {
        }
        if (TextUtils.isEmpty(str5)) {
            hashMap.put("macaddr", "");
        } else {
            hashMap.put("macaddr", str5);
        }
        String str6 = "";
        try {
            str6 = C0873b.m12366a();
        } catch (Exception unused3) {
        }
        if (TextUtils.isEmpty(str6)) {
            hashMap.put("language", "");
        } else {
            hashMap.put("language", str6);
        }
        if (z) {
            hashMap.put("force", z ? "1" : "0");
        }
        if (str == null) {
            str3 = "from_service";
            str = "";
        } else {
            str3 = "from_service";
        }
        hashMap.put(str3, str);
        this.f3729b = new C0875c(f3724a);
        this.f3729b.m12351a(hashMap, new C0875c.InterfaceC0877a<String>() { // from class: com.baidu.lbsapi.auth.LBSAuthManager.3
            @Override // com.baidu.lbsapi.auth.C0875c.InterfaceC0877a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void mo12349a(String str7) {
                LBSAuthManager.this.m12381a(str7, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12379a(boolean z, String str, Hashtable<String, String> hashtable, String[] strArr, final String str2) {
        String str3;
        String m12387a = m12387a(f3724a, str2);
        if (m12387a == null || m12387a.equals("")) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(Annotation.URL, "https://api.map.baidu.com/sdkcs/verify");
        hashMap.put("output", AdType.STATIC_NATIVE);
        hashMap.put("ak", m12387a);
        hashMap.put(PrivacyItem.PrivacyRule.SUBSCRIPTION_FROM, "lbs_yunsdk");
        if (hashtable != null && hashtable.size() > 0) {
            for (Map.Entry<String, String> entry : hashtable.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    hashMap.put(key, value);
                }
            }
        }
        String str4 = "";
        try {
            str4 = CommonParam.m12426a(f3724a);
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(str4)) {
            hashMap.put("cuid", "");
        } else {
            hashMap.put("cuid", str4);
        }
        hashMap.put("pcn", f3724a.getPackageName());
        hashMap.put("version", VERSION);
        String str5 = "";
        try {
            str5 = C0873b.m12359c(f3724a);
        } catch (Exception unused2) {
        }
        if (TextUtils.isEmpty(str5)) {
            hashMap.put("macaddr", "");
        } else {
            hashMap.put("macaddr", str5);
        }
        String str6 = "";
        try {
            str6 = C0873b.m12366a();
        } catch (Exception unused3) {
        }
        if (TextUtils.isEmpty(str6)) {
            hashMap.put("language", "");
        } else {
            hashMap.put("language", str6);
        }
        if (z) {
            hashMap.put("force", z ? "1" : "0");
        }
        if (str == null) {
            str3 = "from_service";
            str = "";
        } else {
            str3 = "from_service";
        }
        hashMap.put(str3, str);
        this.f3730c = new C0878d(f3724a);
        this.f3730c.m12344a(hashMap, strArr, new C0878d.InterfaceC0880a<String>() { // from class: com.baidu.lbsapi.auth.LBSAuthManager.4
            @Override // com.baidu.lbsapi.auth.C0878d.InterfaceC0880a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void mo12342a(String str7) {
                LBSAuthManager.this.m12381a(str7, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m12377b(String str) {
        JSONObject jSONObject;
        String m12387a = m12387a(f3724a, str);
        String str2 = "";
        try {
            jSONObject = new JSONObject(m12373e());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jSONObject.has("ak")) {
            str2 = jSONObject.getString("ak");
            return (m12387a == null || str2 == null || m12387a.equals(str2)) ? false : true;
        }
        return true;
    }

    /* renamed from: c */
    private void m12375c(String str) {
        Context context = f3724a;
        context.getSharedPreferences("authStatus_" + m12388a(f3724a), 0).edit().putString("status", str).commit();
    }

    /* renamed from: d */
    private void m12374d() {
        synchronized (LBSAuthManager.class) {
            if (f3725d == null) {
                C0883f c0883f = new C0883f("auth");
                f3725d = c0883f;
                c0883f.start();
                while (f3725d.f3758a == null) {
                    try {
                        if (C0872a.f3743a) {
                            C0872a.m12369a("wait for create auth thread.");
                        }
                        Thread.sleep(3L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: e */
    private String m12373e() {
        Context context = f3724a;
        return context.getSharedPreferences("authStatus_" + m12388a(f3724a), 0).getString("status", "{\"status\":601}");
    }

    public static LBSAuthManager getInstance(Context context) {
        if (f3728g == null) {
            synchronized (LBSAuthManager.class) {
                if (f3728g == null) {
                    f3728g = new LBSAuthManager(context);
                }
            }
        } else if (context != null) {
            f3724a = context;
        } else if (C0872a.f3743a) {
            C0872a.m12367c("input context is null");
            new RuntimeException("here").printStackTrace();
        }
        return f3728g;
    }

    public int authenticate(final boolean z, final String str, final Hashtable<String, String> hashtable, LBSAuthManagerListener lBSAuthManagerListener) {
        synchronized (LBSAuthManager.class) {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            final String sb2 = sb.toString();
            if (lBSAuthManagerListener != null) {
                f3727f.put(sb2, lBSAuthManagerListener);
            }
            String m12387a = m12387a(f3724a, sb2);
            if (m12387a != null && !m12387a.equals("")) {
                f3726e++;
                if (C0872a.f3743a) {
                    C0872a.m12369a(" mAuthCounter  ++ = " + f3726e);
                }
                String m12373e = m12373e();
                if (C0872a.f3743a) {
                    C0872a.m12369a("getAuthMessage from cache:".concat(String.valueOf(m12373e)));
                }
                final int m12382a = m12382a(m12373e);
                if (m12382a == 601) {
                    try {
                        m12375c(new JSONObject().put("status", CODE_AUTHENTICATING).toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                m12374d();
                if (f3725d != null && f3725d.f3758a != null) {
                    if (C0872a.f3743a) {
                        C0872a.m12369a("mThreadLooper.mHandler = " + f3725d.f3758a);
                    }
                    f3725d.f3758a.post(new Runnable() { // from class: com.baidu.lbsapi.auth.LBSAuthManager.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (C0872a.f3743a) {
                                C0872a.m12369a("status = " + m12382a + "; forced = " + z + "checkAK = " + LBSAuthManager.this.m12377b(sb2));
                            }
                            int i = m12382a;
                            if (i != 601 && !z && i != -1 && !LBSAuthManager.this.m12377b(sb2)) {
                                if (602 != m12382a) {
                                    if (C0872a.f3743a) {
                                        C0872a.m12369a("authenticate else  ");
                                    }
                                    LBSAuthManager.this.m12381a((String) null, sb2);
                                    return;
                                }
                                if (C0872a.f3743a) {
                                    C0872a.m12369a("authenticate wait  ");
                                }
                                if (LBSAuthManager.f3725d != null) {
                                    LBSAuthManager.f3725d.m12333b();
                                }
                                LBSAuthManager.this.m12381a((String) null, sb2);
                                return;
                            }
                            if (C0872a.f3743a) {
                                C0872a.m12369a("authenticate sendAuthRequest");
                            }
                            String[] m12361b = C0873b.m12361b(LBSAuthManager.f3724a);
                            if (C0872a.f3743a) {
                                C0872a.m12369a("authStrings.length:" + m12361b.length);
                            }
                            if (m12361b == null || m12361b.length <= 1) {
                                LBSAuthManager.this.m12380a(z, str, hashtable, sb2);
                                return;
                            }
                            if (C0872a.f3743a) {
                                C0872a.m12369a("more sha1 auth");
                            }
                            LBSAuthManager.this.m12379a(z, str, hashtable, m12361b, sb2);
                        }
                    });
                    return m12382a;
                }
                return -1;
            }
            return 101;
        }
    }

    public String getCUID() {
        Context context = f3724a;
        if (context == null) {
            return "";
        }
        try {
            return CommonParam.m12426a(context);
        } catch (Exception e) {
            if (C0872a.f3743a) {
                e.printStackTrace();
                return "";
            }
            return "";
        }
    }

    public String getKey() {
        Context context = f3724a;
        if (context == null) {
            return "";
        }
        try {
            return getPublicKey(context);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getMCode() {
        Context context = f3724a;
        return context == null ? "" : C0873b.m12365a(context);
    }

    public String getPublicKey(Context context) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.baidu.lbsapi.API_KEY");
    }
}
