package com.cnlaunch.translate;

import android.util.Log;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.conn.ConnectTimeoutException;

/* loaded from: classes.dex */
public class OkHttpRequest implements TranslateRequest {
    private Call call;
    private TranslateCallBack callBack;
    private TranslateEntity entity;
    private boolean isTimeOut;
    private OkHttpClient okHttpClient;
    private String url = "https://www.googleapis.com/language/translate/v2";
    private Timer timer = new Timer(true);
    private TimerTask task = new TimerTask() { // from class: com.cnlaunch.translate.OkHttpRequest.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Log.e("TranslateRunnable", "request time out!");
            OkHttpRequest.this.isTimeOut = true;
            if (OkHttpRequest.this.call != null) {
                OkHttpRequest.this.call.cancel();
                if (OkHttpRequest.this.callBack != null) {
                    OkHttpRequest.this.callBack.fail(0, "request time out");
                }
            }
        }
    };

    public OkHttpRequest(OkHttpClient okHttpClient, TranslateEntity translateEntity, TranslateCallBack translateCallBack) {
        Log.i("TranslateRunnable", "start the google translate request by okhttp");
        this.okHttpClient = okHttpClient;
        this.entity = translateEntity;
        this.callBack = translateCallBack;
    }

    @Override // com.cnlaunch.translate.TranslateRequest
    public void translate() {
        initTimer();
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("key", this.entity.key);
        builder.add("target", this.entity.target);
        builder.add("q", this.entity.f10342q);
        builder.add("format", "text");
        try {
            this.call = this.okHttpClient.newCall(new Request.Builder().url(this.url).post(builder.build()).build());
            Log.e("TranslateRunnable", "start the google translate request：" + this.url);
            Response execute = this.call.execute();
            int code = execute.code();
            Log.e("TranslateRunnable", "response code ：".concat(String.valueOf(code)));
            if (code == 200) {
                String string = execute.body().string();
                Log.e("Response  data", string);
                if (this.callBack != null) {
                    success((TranslateResult) new Gson().fromJson(string, (Class<Object>) TranslateResult.class));
                    return;
                }
                return;
            }
            fail(code, "");
        } catch (ConnectException e) {
            e.printStackTrace();
            Log.e("ConnectException", "Network is unreachable ");
            fail(0, "Network is unreachable ");
        } catch (SocketTimeoutException e2) {
            e2.printStackTrace();
            Log.e("SocketTimeoutException", "Http Socket Time  out ");
            fail(0, "Http Socket Time  out ");
        } catch (UnknownHostException e3) {
            e3.printStackTrace();
            Log.e("UnknownHostException", "No address associated with hostname");
            fail(0, "No address associated with hostname");
        } catch (ConnectTimeoutException e4) {
            e4.printStackTrace();
            Log.e("ConnectTimeoutException", "Http Connect Time  out ");
            fail(0, "Http Connect Time  out ");
        } catch (IOException e5) {
            e5.printStackTrace();
            Log.e("IOException", e5.getMessage());
            fail(0, e5.getMessage());
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

    private void initTimer() {
        this.timer.schedule(this.task, 20000L);
    }
}
