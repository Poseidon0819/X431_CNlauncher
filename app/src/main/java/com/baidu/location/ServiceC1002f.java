package com.baidu.location;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.location.p083f.ServiceC1003a;
import com.baidu.location.p084g.C1016g;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;

/* renamed from: com.baidu.location.f */
/* loaded from: classes.dex */
public class ServiceC1002f extends Service {
    public static boolean isServing = false;
    public static boolean isStartedServing = false;

    /* renamed from: mC */
    public static Context f4470mC = null;
    public static String replaceFileName = "repll.jar";

    /* renamed from: a */
    LLSInterface f4471a = null;

    /* renamed from: b */
    LLSInterface f4472b = null;

    /* renamed from: c */
    LLSInterface f4473c = null;

    /* renamed from: a */
    private boolean m11615a(File file) {
        int readInt;
        boolean z = false;
        try {
            File file2 = new File(C1016g.m11549h() + "/grtcfrsa.dat");
            if (file2.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                randomAccessFile.seek(200L);
                if (randomAccessFile.readBoolean() && randomAccessFile.readBoolean() && (readInt = randomAccessFile.readInt()) != 0) {
                    byte[] bArr = new byte[readInt];
                    randomAccessFile.read(bArr, 0, readInt);
                    String str = new String(bArr);
                    String m11566a = C1016g.m11566a(file, "SHA-256");
                    if (m11566a != null && C1016g.m11558b(m11566a, str, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB")) {
                        z = true;
                    }
                }
                randomAccessFile.close();
            }
        } catch (Exception unused) {
        }
        return z;
    }

    public static float getFrameVersion() {
        return 7.51f;
    }

    public static String getJarFileName() {
        return "app.jar";
    }

    public static Context getServiceContext() {
        return f4470mC;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f4473c.onBind(intent);
    }

    @Override // android.app.Service
    @SuppressLint({"NewApi"})
    public void onCreate() {
        f4470mC = getApplicationContext();
        System.currentTimeMillis();
        this.f4472b = new ServiceC1003a();
        try {
            File file = new File(C1016g.m11549h() + File.separator + replaceFileName);
            File file2 = new File(C1016g.m11549h() + File.separator + "app.jar");
            if (file.exists()) {
                if (file2.exists()) {
                    file2.delete();
                }
                file.renameTo(file2);
            }
            if (file2.exists()) {
                if (m11615a(new File(C1016g.m11549h() + File.separator + "app.jar"))) {
                    this.f4471a = (LLSInterface) new DexClassLoader(C1016g.m11549h() + File.separator + "app.jar", C1016g.m11549h(), null, getClassLoader()).loadClass("com.baidu.serverLoc.LocationService").newInstance();
                }
            }
        } catch (Exception unused) {
            this.f4471a = null;
        }
        LLSInterface lLSInterface = this.f4471a;
        if (lLSInterface == null || lLSInterface.getVersion() < this.f4472b.getVersion()) {
            this.f4473c = this.f4472b;
            this.f4471a = null;
        } else {
            this.f4473c = this.f4471a;
            this.f4472b = null;
        }
        isServing = true;
        this.f4473c.onCreate(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        isServing = false;
        this.f4473c.onDestroy();
        if (isStartedServing) {
            stopForeground(true);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            try {
                int intExtra = intent.getIntExtra("command", 0);
                if (intExtra == 1) {
                    startForeground(intent.getIntExtra("id", 0), (Notification) intent.getParcelableExtra("notification"));
                    isStartedServing = true;
                } else if (intExtra == 2) {
                    stopForeground(intent.getBooleanExtra("removenotify", true));
                    isStartedServing = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.f4473c.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        this.f4473c.onTaskRemoved(intent);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return this.f4473c.onUnBind(intent);
    }
}
