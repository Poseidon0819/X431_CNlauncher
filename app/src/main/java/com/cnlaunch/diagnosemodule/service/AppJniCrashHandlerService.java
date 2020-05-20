package com.cnlaunch.diagnosemodule.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.physics.p205k.C1856n;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: classes.dex */
public class AppJniCrashHandlerService extends Service {
    private Context mContext = null;
    private String mDebugPath = null;
    Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.cnlaunch.diagnosemodule.service.AppJniCrashHandlerService.1
        @Override // android.os.Handler
        public void handleMessage(Message message2) {
            C1856n.m8130a("AppJniCrashHandlerService", "AppJniCrashHandlerService handleMessage test");
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            AppJniCrashHandlerService.this.saveDebug();
            AppJniCrashHandlerService.this.stopSelf();
            C1856n.m8130a("AppJniCrashHandlerService", "AppJniCrashHandlerService stop");
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mContext = this;
        C1856n.m8130a("AppJniCrashHandlerService", "AppJniCrashHandlerService onCreate");
        this.mHandler.sendEmptyMessage(0);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        this.mDebugPath = intent.getStringExtra("app_jni_crash_debug_path");
        C1856n.m8130a("AppJniCrashHandlerService", "mDebugPath = " + this.mDebugPath);
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C1856n.m8126c("AppJniCrashHandlerService", "AppJniCrashHandlerService onDestroy");
        Process.killProcess(Process.myPid());
    }

    private void sendCrashInfoBroadcast() {
        this.mContext.sendBroadcast(new Intent(DiagnoseConstants.DIAG_ERROR_BROADCAST));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveDebug() {
        DataOutputStream dataOutputStream;
        int read;
        String str = this.mDebugPath;
        if (str == null || str.isEmpty()) {
            return;
        }
        DataInputStream dataInputStream = null;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(new File(this.mDebugPath)));
            try {
                try {
                    DataInputStream dataInputStream2 = new DataInputStream(Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-t", DiagnoseConstants.UI_TYPE_ACTIVE_TEST, "-v", "threadtime"}).getInputStream());
                    try {
                        byte[] bArr = new byte[1024];
                        do {
                            read = dataInputStream2.read(bArr);
                            if (read > 0) {
                                dataOutputStream.write(bArr, 0, read);
                                continue;
                            }
                        } while (read > 0);
                        dataInputStream2.close();
                        dataOutputStream.close();
                        try {
                            dataInputStream2.close();
                            dataOutputStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        dataInputStream = dataInputStream2;
                        e.printStackTrace();
                        try {
                            dataInputStream.close();
                            dataOutputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    } catch (Throwable th) {
                        th = th;
                        dataInputStream = dataInputStream2;
                        try {
                            dataInputStream.close();
                            dataOutputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Exception e6) {
            e = e6;
            dataOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
        }
    }
}
