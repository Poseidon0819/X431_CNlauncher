package com.baidu.mapapi.http;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.common.Logger;
import com.baidu.mapsdkplatform.comapi.util.C1304e;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class HttpClient {
    public static boolean isHttpsEnable = false;

    /* renamed from: a */
    HttpURLConnection f4897a;

    /* renamed from: b */
    private String f4898b = null;

    /* renamed from: c */
    private String f4899c = null;

    /* renamed from: d */
    private int f4900d;

    /* renamed from: e */
    private int f4901e;

    /* renamed from: f */
    private String f4902f;

    /* renamed from: g */
    private ProtoResultCallback f4903g;

    /* loaded from: classes.dex */
    public enum HttpStateError {
        NO_ERROR,
        NETWORK_ERROR,
        INNER_ERROR,
        REQUEST_ERROR,
        SERVER_ERROR
    }

    /* loaded from: classes.dex */
    public static abstract class ProtoResultCallback {
        public abstract void onFailed(HttpStateError httpStateError);

        public abstract void onSuccess(String str);
    }

    public HttpClient(String str, ProtoResultCallback protoResultCallback) {
        this.f4902f = str;
        this.f4903g = protoResultCallback;
    }

    /* renamed from: a */
    private HttpURLConnection m11263a() {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(this.f4898b);
            if (isHttpsEnable) {
                httpURLConnection = (HttpsURLConnection) url.openConnection();
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier() { // from class: com.baidu.mapapi.http.HttpClient.1
                    @Override // javax.net.ssl.HostnameVerifier
                    public boolean verify(String str, SSLSession sSLSession) {
                        return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
                    }
                });
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setRequestMethod(this.f4902f);
            httpURLConnection.setDoOutput(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setConnectTimeout(this.f4900d);
            httpURLConnection.setReadTimeout(this.f4901e);
            return httpURLConnection;
        } catch (Exception e) {
            Log.e("HttpClient", "url connect failed");
            if (Logger.debugEnable()) {
                e.printStackTrace();
                return null;
            }
            Logger.logW("HttpClient", e.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    private void m11262a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("status") || jSONObject.has("status_sp")) {
                switch (jSONObject.getInt(jSONObject.has("status") ? "status" : "status_sp")) {
                    case 105:
                    case 106:
                        int permissionCheck = PermissionCheck.permissionCheck();
                        if (permissionCheck != 0) {
                            Log.e("HttpClient", "permissionCheck result is: ".concat(String.valueOf(permissionCheck)));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        } catch (JSONException e) {
            Log.e("HttpClient", "Parse json happened exception");
            e.printStackTrace();
        }
    }

    public static String getAuthToken() {
        return C1304e.f6430z;
    }

    public static String getPhoneInfo() {
        return C1304e.m10069c();
    }

    protected boolean checkNetwork() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) JNIInitializer.getCachedContext().getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isAvailable();
        } catch (Exception e) {
            if (Logger.debugEnable()) {
                e.printStackTrace();
            } else {
                Logger.logW("HttpClient", e.getMessage());
            }
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0154 A[Catch: Exception -> 0x015a, TryCatch #3 {Exception -> 0x015a, blocks: (B:14:0x0039, B:26:0x0079, B:27:0x007f, B:29:0x0083, B:78:0x014a, B:79:0x0150, B:81:0x0154, B:82:0x0159, B:70:0x0135, B:71:0x013b, B:73:0x013f, B:55:0x0101, B:57:0x0105), top: B:92:0x0039 }] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void request(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.http.HttpClient.request(java.lang.String):void");
    }

    public void setMaxTimeOut(int i) {
        this.f4900d = i;
    }

    public void setReadTimeOut(int i) {
        this.f4901e = i;
    }
}
