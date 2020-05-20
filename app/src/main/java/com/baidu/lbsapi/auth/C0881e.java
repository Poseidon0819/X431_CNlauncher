package com.baidu.lbsapi.auth;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.itextpdf.text.Annotation;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.apache.http.client.methods.HttpPostHC4;

/* renamed from: com.baidu.lbsapi.auth.e */
/* loaded from: classes.dex */
public class C0881e {

    /* renamed from: a */
    private Context f3753a;

    /* renamed from: b */
    private String f3754b = null;

    /* renamed from: c */
    private HashMap<String, String> f3755c = null;

    /* renamed from: d */
    private String f3756d = null;

    public C0881e(Context context) {
        this.f3753a = context;
    }

    /* renamed from: a */
    private String m12340a(Context context) {
        NetworkInfo activeNetworkInfo;
        String str = "wifi";
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (extraInfo != null && (extraInfo.trim().toLowerCase().equals("cmwap") || extraInfo.trim().toLowerCase().equals("uniwap") || extraInfo.trim().toLowerCase().equals("3gwap") || extraInfo.trim().toLowerCase().equals("ctwap"))) {
                    if (extraInfo.trim().toLowerCase().equals("ctwap")) {
                        return "ctwap";
                    }
                    str = "cmwap";
                }
                return str;
            }
            return null;
        } catch (Exception e) {
            if (C0872a.f3743a) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x0184, code lost:
        if (com.baidu.lbsapi.auth.C0872a.f3743a == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01b2, code lost:
        if (com.baidu.lbsapi.auth.C0872a.f3743a == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00fb, code lost:
        if (com.baidu.lbsapi.auth.C0872a.f3743a == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00fd, code lost:
        r13.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0157, code lost:
        if (com.baidu.lbsapi.auth.C0872a.f3743a == false) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0160 A[Catch: all -> 0x012a, TryCatch #12 {all -> 0x012a, blocks: (B:7:0x0028, B:86:0x012f, B:88:0x0133, B:89:0x0136, B:99:0x015c, B:101:0x0160, B:102:0x0163, B:112:0x018a, B:114:0x018e, B:115:0x0191), top: B:150:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x018e A[Catch: all -> 0x012a, TryCatch #12 {all -> 0x012a, blocks: (B:7:0x0028, B:86:0x012f, B:88:0x0133, B:89:0x0136, B:99:0x015c, B:101:0x0160, B:102:0x0163, B:112:0x018a, B:114:0x018e, B:115:0x0191), top: B:150:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01b8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x00f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0150 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x017d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b2 A[Catch: all -> 0x0102, TryCatch #3 {all -> 0x0102, blocks: (B:45:0x00ae, B:47:0x00b2, B:48:0x00ca), top: B:142:0x00ae }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ee A[Catch: Exception -> 0x0113, IOException -> 0x0116, MalformedURLException -> 0x0119, all -> 0x011d, TRY_LEAVE, TryCatch #22 {all -> 0x011d, blocks: (B:8:0x002c, B:64:0x0107, B:66:0x010f, B:67:0x0112, B:51:0x00e6, B:53:0x00ee, B:31:0x0092, B:33:0x009a), top: B:155:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0105 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010f A[Catch: Exception -> 0x0113, IOException -> 0x0116, MalformedURLException -> 0x0119, all -> 0x011d, TryCatch #22 {all -> 0x011d, blocks: (B:8:0x002c, B:64:0x0107, B:66:0x010f, B:67:0x0112, B:51:0x00e6, B:53:0x00ee, B:31:0x0092, B:33:0x009a), top: B:155:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0133 A[Catch: all -> 0x012a, TryCatch #12 {all -> 0x012a, blocks: (B:7:0x0028, B:86:0x012f, B:88:0x0133, B:89:0x0136, B:99:0x015c, B:101:0x0160, B:102:0x0163, B:112:0x018a, B:114:0x018e, B:115:0x0191), top: B:150:0x0028 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m12338a(javax.net.ssl.HttpsURLConnection r13) {
        /*
            Method dump skipped, instructions count: 526
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.C0881e.m12338a(javax.net.ssl.HttpsURLConnection):void");
    }

    /* renamed from: b */
    private static String m12336b(HashMap<String, String> hashMap) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            sb.append("=");
            sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        return sb.toString();
    }

    /* renamed from: b */
    private HttpsURLConnection m12337b() {
        String str;
        try {
            URL url = new URL(this.f3754b);
            C0872a.m12369a("https URL: " + this.f3754b);
            String m12340a = m12340a(this.f3753a);
            if (m12340a != null && !m12340a.equals("")) {
                C0872a.m12369a("checkNetwork = ".concat(String.valueOf(m12340a)));
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) (m12340a.equals("cmwap") ? url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80))) : m12340a.equals("ctwap") ? url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80))) : url.openConnection());
                httpsURLConnection.setHostnameVerifier(new HostnameVerifier() { // from class: com.baidu.lbsapi.auth.e.1
                    @Override // javax.net.ssl.HostnameVerifier
                    public boolean verify(String str2, SSLSession sSLSession) {
                        if ("api.map.baidu.com".equals(str2)) {
                            return true;
                        }
                        return HttpsURLConnection.getDefaultHostnameVerifier().verify(str2, sSLSession);
                    }
                });
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setRequestMethod(HttpPostHC4.METHOD_NAME);
                httpsURLConnection.setConnectTimeout(50000);
                httpsURLConnection.setReadTimeout(50000);
                return httpsURLConnection;
            }
            C0872a.m12367c("Current network is not available.");
            this.f3756d = ErrorMessage.m12392a(-10, "Current network is not available.");
            return null;
        } catch (MalformedURLException e) {
            if (C0872a.f3743a) {
                e.printStackTrace();
                C0872a.m12369a(e.getMessage());
            }
            str = "Auth server could not be parsed as a URL.";
            this.f3756d = ErrorMessage.m12392a(-11, str);
            return null;
        } catch (Exception e2) {
            if (C0872a.f3743a) {
                e2.printStackTrace();
                C0872a.m12369a(e2.getMessage());
            }
            str = "Init httpsurlconnection failed.";
            this.f3756d = ErrorMessage.m12392a(-11, str);
            return null;
        }
    }

    /* renamed from: c */
    private HashMap<String, String> m12335c(HashMap<String, String> hashMap) {
        HashMap<String, String> hashMap2 = new HashMap<>();
        for (String str : hashMap.keySet()) {
            String str2 = str.toString();
            hashMap2.put(str2, hashMap.get(str2));
        }
        return hashMap2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public String m12339a(HashMap<String, String> hashMap) {
        this.f3755c = m12335c(hashMap);
        this.f3754b = this.f3755c.get(Annotation.URL);
        HttpsURLConnection m12337b = m12337b();
        if (m12337b == null) {
            C0872a.m12367c("syncConnect failed,httpsURLConnection is null");
        } else {
            m12338a(m12337b);
        }
        return this.f3756d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public boolean m12341a() {
        NetworkInfo activeNetworkInfo;
        C0872a.m12369a("checkNetwork start");
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f3753a.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            if (activeNetworkInfo.isAvailable()) {
                C0872a.m12369a("checkNetwork end");
                return true;
            }
            return false;
        } catch (Exception e) {
            if (C0872a.f3743a) {
                e.printStackTrace();
            }
            return false;
        }
    }
}
