package com.cnlaunch.translate;

import android.util.Log;
import com.baidu.mapapi.UIMsg;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.conn.ConnectTimeoutException;

/* loaded from: classes.dex */
public class HttpURLConnectionRequest implements TranslateRequest {
    private TranslateCallBack callBack;
    private TranslateEntity entity;
    private InputStream inputStream;
    private boolean isTimeOut;
    private HttpURLConnection urlConnection;
    private String url = "http://aitus.golo365.com/Home/Index/translateGoogle/";
    private Timer timer = new Timer(true);
    private TimerTask task = new TimerTask() { // from class: com.cnlaunch.translate.HttpURLConnectionRequest.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Log.e("TranslateRunnable", "request time out!");
            HttpURLConnectionRequest.this.isTimeOut = true;
            if (HttpURLConnectionRequest.this.urlConnection != null) {
                HttpURLConnectionRequest.this.urlConnection.disconnect();
                if (HttpURLConnectionRequest.this.callBack != null) {
                    HttpURLConnectionRequest.this.callBack.fail(0, "request time out");
                }
            }
        }
    };

    public HttpURLConnectionRequest(TranslateEntity translateEntity, TranslateCallBack translateCallBack) {
        Log.i("TranslateRunnable", "start the google translate request by HttpURLConnection");
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
                                    this.urlConnection = (HttpURLConnection) url.openConnection();
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
                                    HttpURLConnection httpURLConnection = this.urlConnection;
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                } catch (ProtocolException e) {
                                    Log.e("ProtocolException", e.getMessage());
                                    e.printStackTrace();
                                    fail(0, e.getMessage());
                                    HttpURLConnection httpURLConnection2 = this.urlConnection;
                                    if (httpURLConnection2 != null) {
                                        httpURLConnection2.disconnect();
                                    }
                                } catch (UnknownHostException e2) {
                                    e2.printStackTrace();
                                    Log.e("UnknownHostException", "No address associated with hostname");
                                    fail(0, "No address associated with hostname");
                                    HttpURLConnection httpURLConnection3 = this.urlConnection;
                                    if (httpURLConnection3 != null) {
                                        httpURLConnection3.disconnect();
                                    }
                                }
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                Log.e("IOException", e3.getMessage());
                                fail(0, e3.getMessage());
                                HttpURLConnection httpURLConnection4 = this.urlConnection;
                                if (httpURLConnection4 != null) {
                                    httpURLConnection4.disconnect();
                                }
                            }
                        } catch (ConnectTimeoutException e4) {
                            e4.printStackTrace();
                            Log.e("ConnectTimeoutException", "Http Connect Time  out ");
                            fail(0, "Http Connect Time  out ");
                            HttpURLConnection httpURLConnection5 = this.urlConnection;
                            if (httpURLConnection5 != null) {
                                httpURLConnection5.disconnect();
                            }
                        }
                    } catch (ConnectException e5) {
                        e5.printStackTrace();
                        Log.e("ConnectException", "Network is unreachable ");
                        fail(0, "Network is unreachable ");
                        HttpURLConnection httpURLConnection6 = this.urlConnection;
                        if (httpURLConnection6 != null) {
                            httpURLConnection6.disconnect();
                        }
                    }
                } catch (MalformedURLException e6) {
                    Log.e("MalformedURLException", "request url is malformed");
                    fail(0, e6.getMessage());
                    e6.printStackTrace();
                    HttpURLConnection httpURLConnection7 = this.urlConnection;
                    if (httpURLConnection7 != null) {
                        httpURLConnection7.disconnect();
                    }
                }
            } catch (SocketTimeoutException e7) {
                e7.printStackTrace();
                Log.e("SocketTimeoutException", "Http Socket Time  out ");
                fail(0, "Http Socket Time  out ");
                HttpURLConnection httpURLConnection8 = this.urlConnection;
                if (httpURLConnection8 != null) {
                    httpURLConnection8.disconnect();
                }
            }
        } catch (Throwable th) {
            HttpURLConnection httpURLConnection9 = this.urlConnection;
            if (httpURLConnection9 != null) {
                httpURLConnection9.disconnect();
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
