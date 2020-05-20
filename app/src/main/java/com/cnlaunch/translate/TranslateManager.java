package com.cnlaunch.translate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.OkHttpClient;

/* loaded from: classes.dex */
public class TranslateManager {
    public static final int TIME_OUT = 20000;
    private ExecutorService executor;
    private OkHttpClient okHttpClient;

    private TranslateManager() {
        this.okHttpClient = getHttpClient();
        this.executor = Executors.newSingleThreadExecutor();
    }

    /* loaded from: classes.dex */
    static class SingletonInstance {
        private static final TranslateManager INSTANCE = new TranslateManager();

        private SingletonInstance() {
        }
    }

    public static TranslateManager getInstance() {
        return SingletonInstance.INSTANCE;
    }

    public void translate(TranslateEntity translateEntity, boolean z, TranslateCallBack translateCallBack) {
        if (z) {
            translate(translateEntity, translateCallBack);
        } else {
            new TranslateRunnable(this.okHttpClient, translateEntity, translateCallBack).translate();
        }
    }

    public void translate(TranslateEntity translateEntity, TranslateCallBack translateCallBack) {
        this.executor.execute(new TranslateRunnable(this.okHttpClient, translateEntity, translateCallBack));
    }

    private OkHttpClient getHttpClient() {
        return new OkHttpClient();
    }
}
