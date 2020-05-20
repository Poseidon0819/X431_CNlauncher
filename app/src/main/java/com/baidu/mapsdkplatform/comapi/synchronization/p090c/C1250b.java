package com.baidu.mapsdkplatform.comapi.synchronization.p090c;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapsdkplatform.comapi.synchronization.p091d.C1255a;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.c.b */
/* loaded from: classes.dex */
public class C1250b {

    /* renamed from: b */
    public static boolean f6191b = true;

    /* renamed from: c */
    private static final String f6192c = "b";

    /* renamed from: a */
    HttpURLConnection f6193a;

    /* renamed from: d */
    private String f6194d = null;

    /* renamed from: e */
    private String f6195e = null;

    /* renamed from: f */
    private int f6196f;

    /* renamed from: g */
    private int f6197g;

    /* renamed from: h */
    private String f6198h;

    /* renamed from: i */
    private AbstractC1253c f6199i;

    /* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.c.b$a */
    /* loaded from: classes.dex */
    public enum EnumC1252a {
        SUCCESS,
        NETWORK_ERROR,
        INNER_ERROR,
        REQUEST_ERROR,
        SERVER_ERROR
    }

    public C1250b(String str, AbstractC1253c abstractC1253c) {
        this.f6198h = str;
        this.f6199i = abstractC1253c;
    }

    /* renamed from: a */
    private void m10472a(InputStream inputStream, BufferedReader bufferedReader, HttpURLConnection httpURLConnection) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                C1255a.m10456a(f6192c, "IOException happened when release res", e);
            }
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    /* renamed from: a */
    private void m10470a(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            C1255a.m10453b(f6192c, "responseCode is: ".concat(String.valueOf(responseCode)));
            if (200 != responseCode) {
                m10469a(httpURLConnection, responseCode);
            } else {
                m10465b(httpURLConnection);
            }
        } catch (IOException unused) {
            httpURLConnection.disconnect();
            C1255a.m10453b(f6192c, "Catch connection exception, INNER_ERROR");
            this.f6199i.mo10322a(EnumC1252a.INNER_ERROR);
        }
    }

    /* renamed from: a */
    private void m10469a(HttpURLConnection httpURLConnection, int i) {
        EnumC1252a enumC1252a = EnumC1252a.SUCCESS;
        EnumC1252a enumC1252a2 = i >= 500 ? EnumC1252a.SERVER_ERROR : i >= 400 ? EnumC1252a.REQUEST_ERROR : EnumC1252a.INNER_ERROR;
        InputStream errorStream = httpURLConnection.getErrorStream();
        C1255a.m10457a(f6192c, errorStream.toString());
        String str = f6192c;
        C1255a.m10457a(str, "Response error, response code = " + i + ", error = " + enumC1252a2);
        if (errorStream != null) {
            try {
                errorStream.close();
            } catch (IOException e) {
                C1255a.m10456a(f6192c, "IOException caught", e);
            }
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f6199i.mo10322a(enumC1252a2);
    }

    /* renamed from: a */
    private boolean m10474a() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) JNIInitializer.getCachedContext().getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isAvailable();
        } catch (Exception e) {
            C1255a.m10456a(f6192c, "Exception happened when check network", e);
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    private HttpURLConnection m10468b() {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(this.f6194d);
            if (f6191b) {
                httpURLConnection = (HttpsURLConnection) url.openConnection();
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier() { // from class: com.baidu.mapsdkplatform.comapi.synchronization.c.b.1
                    @Override // javax.net.ssl.HostnameVerifier
                    public boolean verify(String str, SSLSession sSLSession) {
                        return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
                    }
                });
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setRequestMethod(this.f6198h);
            httpURLConnection.setDoOutput(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setConnectTimeout(this.f6196f);
            httpURLConnection.setReadTimeout(this.f6197g);
            return httpURLConnection;
        } catch (Exception e) {
            C1255a.m10456a(f6192c, "url connect failed", e);
            return null;
        }
    }

    /* renamed from: b */
    private void m10465b(HttpURLConnection httpURLConnection) {
        BufferedReader bufferedReader;
        Throwable th;
        InputStream inputStream;
        IOException e;
        try {
            inputStream = httpURLConnection.getInputStream();
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            } catch (IOException e2) {
                bufferedReader = null;
                e = e2;
            } catch (Throwable th2) {
                bufferedReader = null;
                th = th2;
                m10472a(inputStream, bufferedReader, httpURLConnection);
                throw th;
            }
        } catch (IOException e3) {
            bufferedReader = null;
            e = e3;
            inputStream = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            inputStream = null;
        }
        try {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    int read = bufferedReader.read();
                    if (read == -1) {
                        this.f6195e = stringBuffer.toString();
                        m10464c(this.f6195e);
                        m10472a(inputStream, bufferedReader, httpURLConnection);
                        this.f6199i.mo10321a(this.f6195e);
                        return;
                    }
                    stringBuffer.append((char) read);
                }
            } catch (Throwable th4) {
                th = th4;
                m10472a(inputStream, bufferedReader, httpURLConnection);
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            C1255a.m10456a(f6192c, "Catch exception. INNER_ERROR", e);
            this.f6199i.mo10322a(EnumC1252a.INNER_ERROR);
            m10472a(inputStream, bufferedReader, httpURLConnection);
        }
    }

    /* renamed from: b */
    private boolean m10466b(String str) {
        if (TextUtils.isEmpty(str) || this.f6199i == null) {
            String str2 = f6192c;
            C1255a.m10453b(str2, "RequestUrl or ResultCallback is null. RequestUrl = " + str + "; ResultCallback is: " + this.f6199i);
            this.f6199i.mo10322a(EnumC1252a.REQUEST_ERROR);
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private void m10464c(String str) {
        if (m10463d(str)) {
            C1255a.m10453b(f6192c, "Permission check failed, try again");
            int permissionCheck = PermissionCheck.permissionCheck();
            if (permissionCheck != 0) {
                C1255a.m10453b(f6192c, "The authorized result is: ".concat(String.valueOf(permissionCheck)));
            }
        }
    }

    /* renamed from: d */
    private boolean m10463d(String str) {
        return m10462e(str) || m10461f(str);
    }

    /* renamed from: e */
    private boolean m10462e(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("status") || jSONObject.has("status_sp")) {
                int i = jSONObject.getInt(jSONObject.has("status") ? "status" : "status_sp");
                if (106 == i || 105 == i) {
                    C1255a.m10457a(f6192c, "Permission check failed due token");
                    return true;
                }
                return false;
            }
            return false;
        } catch (JSONException e) {
            C1255a.m10456a(f6192c, "Parse json happened exception", e);
            return false;
        }
    }

    /* renamed from: f */
    private boolean m10461f(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError") && jSONObject.optJSONObject("SDK_InnerError").has("PermissionCheckError")) {
                C1255a.m10453b(f6192c, "Permission check error due other");
                return true;
            }
            return false;
        } catch (JSONException e) {
            C1255a.m10456a(f6192c, "Parse json happened exception", e);
            return false;
        }
    }

    /* renamed from: a */
    public void m10473a(int i) {
        this.f6197g = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m10471a(String str) {
        AbstractC1253c abstractC1253c;
        EnumC1252a enumC1252a;
        if (m10466b(str)) {
            this.f6194d = str;
            String str2 = f6192c;
            C1255a.m10453b(str2, "mRequestUrl is: " + this.f6194d);
            if (m10474a()) {
                this.f6193a = m10468b();
                HttpURLConnection httpURLConnection = this.f6193a;
                if (httpURLConnection != null) {
                    m10470a(httpURLConnection);
                    return;
                }
                C1255a.m10453b(f6192c, "url connection failed");
                abstractC1253c = this.f6199i;
                enumC1252a = EnumC1252a.INNER_ERROR;
            } else {
                abstractC1253c = this.f6199i;
                enumC1252a = EnumC1252a.NETWORK_ERROR;
            }
            abstractC1253c.mo10322a(enumC1252a);
        }
    }

    /* renamed from: b */
    public void m10467b(int i) {
        this.f6196f = i;
    }
}
