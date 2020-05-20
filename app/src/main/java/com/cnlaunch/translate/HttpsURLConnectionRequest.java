package com.cnlaunch.translate;

import android.util.Log;
import com.baidu.mapapi.UIMsg;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ConnectTimeoutException;

/* loaded from: classes.dex */
public class HttpsURLConnectionRequest implements TranslateRequest {
    private TranslateCallBack callBack;
    private TranslateEntity entity;
    private InputStream inputStream;
    private boolean isTimeOut;
    private HttpsURLConnection urlConnection;
    private String url = "https://www.googleapis.com/language/translate/v2";
    private Timer timer = new Timer(true);
    private TimerTask task = new TimerTask() { // from class: com.cnlaunch.translate.HttpsURLConnectionRequest.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Log.e("TranslateRunnable", "request time out!");
            HttpsURLConnectionRequest.this.isTimeOut = true;
            if (HttpsURLConnectionRequest.this.urlConnection != null) {
                HttpsURLConnectionRequest.this.urlConnection.disconnect();
                if (HttpsURLConnectionRequest.this.callBack != null) {
                    HttpsURLConnectionRequest.this.callBack.fail(0, "request time out");
                }
            }
        }
    };

    public HttpsURLConnectionRequest(TranslateEntity translateEntity, TranslateCallBack translateCallBack) {
        Log.i("TranslateRunnable", "start the google translate request by HttpsURLConnection");
        this.entity = translateEntity;
        this.callBack = translateCallBack;
    }

    private void initTimer() {
        this.timer.schedule(this.task, 20000L);
    }

    @Override // com.cnlaunch.translate.TranslateRequest
    public void translate() {
        String str;
        initTimer();
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("key=");
                                    sb.append(this.entity.key);
                                    sb.append("&");
                                    sb.append("target=");
                                    sb.append(this.entity.target);
                                    sb.append("&");
                                    sb.append("q=");
                                    sb.append(URLEncoder.encode(this.entity.f10342q, "UTF-8"));
                                    sb.append("&");
                                    sb.append("format=text");
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(this.url);
                                    if (sb.length() > 0) {
                                        str = "?" + sb.toString();
                                    } else {
                                        str = "";
                                    }
                                    sb2.append(str);
                                    URL url = new URL(sb2.toString());
                                    Log.e("TranslateRunnable", "urlPath : ".concat(String.valueOf(url)));
                                    this.urlConnection = (HttpsURLConnection) url.openConnection();
                                    this.urlConnection.setSSLSocketFactory(new SSLSocketFactoryCompat());
                                    this.urlConnection.setConnectTimeout(UIMsg.m_AppUI.MSG_APP_GPS);
                                    this.urlConnection.setReadTimeout(UIMsg.m_AppUI.MSG_APP_GPS);
                                    this.urlConnection.setRequestMethod("GET");
                                    this.urlConnection.connect();
                                    int responseCode = this.urlConnection.getResponseCode();
                                    Log.e("TranslateRunnable", "code2=".concat(String.valueOf(responseCode)));
                                    if (responseCode == 200) {
                                        this.inputStream = this.urlConnection.getInputStream();
                                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.inputStream));
                                        StringBuilder sb3 = new StringBuilder();
                                        while (true) {
                                            String readLine = bufferedReader.readLine();
                                            if (readLine == null) {
                                                break;
                                            }
                                            sb3.append(readLine);
                                        }
                                        String sb4 = sb3.toString();
                                        Log.e("TranslateRunnable", "str=".concat(String.valueOf(sb4)));
                                        if (this.callBack != null) {
                                            success((TranslateResult) new Gson().fromJson(sb4, (Class<Object>) TranslateResult.class));
                                        }
                                    } else {
                                        fail(responseCode, "");
                                    }
                                    HttpsURLConnection httpsURLConnection = this.urlConnection;
                                    if (httpsURLConnection != null) {
                                        httpsURLConnection.disconnect();
                                    }
                                } catch (ProtocolException e) {
                                    Log.e("ProtocolException", e.getMessage());
                                    e.printStackTrace();
                                    fail(0, e.getMessage());
                                    HttpsURLConnection httpsURLConnection2 = this.urlConnection;
                                    if (httpsURLConnection2 != null) {
                                        httpsURLConnection2.disconnect();
                                    }
                                } catch (UnknownHostException e2) {
                                    e2.printStackTrace();
                                    Log.e("UnknownHostException", "No address associated with hostname");
                                    fail(0, "No address associated with hostname");
                                    HttpsURLConnection httpsURLConnection3 = this.urlConnection;
                                    if (httpsURLConnection3 != null) {
                                        httpsURLConnection3.disconnect();
                                    }
                                }
                            } catch (ConnectException e3) {
                                e3.printStackTrace();
                                Log.e("ConnectException", "Network is unreachable ");
                                fail(0, "Network is unreachable ");
                                HttpsURLConnection httpsURLConnection4 = this.urlConnection;
                                if (httpsURLConnection4 != null) {
                                    httpsURLConnection4.disconnect();
                                }
                            }
                        } catch (MalformedURLException e4) {
                            Log.e("MalformedURLException", "request url is malformed");
                            fail(0, e4.getMessage());
                            e4.printStackTrace();
                            HttpsURLConnection httpsURLConnection5 = this.urlConnection;
                            if (httpsURLConnection5 != null) {
                                httpsURLConnection5.disconnect();
                            }
                        }
                    } catch (SocketTimeoutException e5) {
                        e5.printStackTrace();
                        Log.e("SocketTimeoutException", "Http Socket Time  out ");
                        fail(0, "Http Socket Time  out ");
                        HttpsURLConnection httpsURLConnection6 = this.urlConnection;
                        if (httpsURLConnection6 != null) {
                            httpsURLConnection6.disconnect();
                        }
                    }
                } catch (IOException e6) {
                    e6.printStackTrace();
                    Log.e("IOException", e6.getMessage());
                    fail(0, e6.getMessage());
                    HttpsURLConnection httpsURLConnection7 = this.urlConnection;
                    if (httpsURLConnection7 != null) {
                        httpsURLConnection7.disconnect();
                    }
                }
            } catch (ConnectTimeoutException e7) {
                e7.printStackTrace();
                Log.e("ConnectTimeoutException", "Http Connect Time  out ");
                fail(0, "Http Connect Time  out ");
                HttpsURLConnection httpsURLConnection8 = this.urlConnection;
                if (httpsURLConnection8 != null) {
                    httpsURLConnection8.disconnect();
                }
            }
        } catch (Throwable th) {
            HttpsURLConnection httpsURLConnection9 = this.urlConnection;
            if (httpsURLConnection9 != null) {
                httpsURLConnection9.disconnect();
            }
            throw th;
        }
    }

    private void fail(int i, String str) {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
        TranslateCallBack translateCallBack = this.callBack;
        if (translateCallBack == null || this.isTimeOut) {
            return;
        }
        translateCallBack.fail(i, str);
    }

    private void success(TranslateResult translateResult) {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
        TranslateCallBack translateCallBack = this.callBack;
        if (translateCallBack == null || this.isTimeOut) {
            return;
        }
        translateCallBack.success(translateResult);
    }
}
