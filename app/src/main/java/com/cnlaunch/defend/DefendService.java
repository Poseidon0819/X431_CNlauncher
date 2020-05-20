package com.cnlaunch.defend;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

/* loaded from: classes.dex */
public class DefendService extends Service {

    /* renamed from: a */
    final String f7253a = "com.cnlaunch.im.service.GoloMessageService";

    /* renamed from: b */
    private DefendTimer f7254b = null;

    /* renamed from: c */
    private BroadcastReceiver f7255c = new C1436a(this);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d("Sanda", "DefendService: onCreate()");
        this.f7254b = new DefendTimer(getApplicationContext(), "golo_is_enable", "com.cnlaunch.im.service.GoloMessageService", 2);
        this.f7254b.m9428a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("app_exit");
        registerReceiver(this.f7255c, intentFilter);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Log.d("Sanda", "DefendService: onDestroy()");
        try {
            unregisterReceiver(this.f7255c);
            if (this.f7254b != null) {
                this.f7254b.m9427b();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
