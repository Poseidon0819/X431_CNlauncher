package com.cnlaunch.translate;

import android.os.Build;
import okhttp3.OkHttpClient;

/* loaded from: classes.dex */
public class TranslateRunnable implements Runnable {
    private TranslateCallBack callBack;
    private TranslateEntity entity;
    private OkHttpClient okHttpClient;

    public TranslateRunnable(OkHttpClient okHttpClient, TranslateEntity translateEntity, TranslateCallBack translateCallBack) {
        this.okHttpClient = okHttpClient;
        this.entity = translateEntity;
        this.callBack = translateCallBack;
    }

    @Override // java.lang.Runnable
    public void run() {
        translate();
    }

    public void translate() {
        if (Build.VERSION.SDK_INT > 20) {
            new OkHttpRequest(this.okHttpClient, this.entity, this.callBack).translate();
        } else {
            new HttpURLConnectionRequest(this.entity, this.callBack).translate();
        }
    }
}
