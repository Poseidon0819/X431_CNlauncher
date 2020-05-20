package com.cnlaunch.physics.p205k;

import android.os.Environment;
import android.text.TextUtils;
import com.cnlaunch.physics.p197c.DPUHardwareInfo;
import com.cnlaunch.physics.p197c.DPUSoftInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* renamed from: com.cnlaunch.physics.k.i */
/* loaded from: classes.dex */
public final class DeviceProperties {

    /* renamed from: b */
    private static String f10109b = "X-431 PAD II";

    /* renamed from: c */
    private static String f10110c = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "cnlaunch" + File.separator + f10109b + File.separator;

    /* renamed from: e */
    private static Map<String, DeviceProperties> f10111e = new HashMap();

    /* renamed from: a */
    public Properties f10112a;

    /* renamed from: d */
    private String f10113d;

    /* renamed from: f */
    private String f10114f;

    /* renamed from: a */
    public static DeviceProperties m8157a(String str, String str2) {
        if (!f10111e.containsKey(str)) {
            f10111e.put(str, new DeviceProperties(str, str2));
        }
        return f10111e.get(str);
    }

    private DeviceProperties(String str, String str2) {
        String str3;
        this.f10114f = str;
        if (str2 == null) {
            f10110c = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "cnlaunch" + File.separator + f10109b + File.separator;
            StringBuilder sb = new StringBuilder();
            sb.append(f10110c);
            sb.append(str);
            sb.append(File.separator);
            sb.append("deviceInfo");
            str3 = sb.toString();
        } else {
            str3 = str2 + File.separator + str + File.separator + "deviceInfo";
        }
        this.f10113d = str3;
        this.f10112a = new Properties();
    }

    /* renamed from: a */
    public static void m8158a(String str) {
        f10109b = str;
    }

    /* renamed from: g */
    private void m8150g() {
        FileInputStream fileInputStream = null;
        try {
            try {
                File file = new File(this.f10113d);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    this.f10112a.load(fileInputStream2);
                    try {
                        fileInputStream2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            e = e5;
        }
    }

    /* renamed from: a */
    public final void m8159a(DPUHardwareInfo dPUHardwareInfo) {
        if (dPUHardwareInfo == null) {
            return;
        }
        this.f10112a.setProperty(DPUHardwareInfo.f9850a, dPUHardwareInfo.f9855f);
        this.f10112a.setProperty(DPUHardwareInfo.f9851b, dPUHardwareInfo.f9856g);
        this.f10112a.setProperty(DPUHardwareInfo.f9852c, dPUHardwareInfo.f9857h);
        this.f10112a.setProperty(DPUHardwareInfo.f9853d, dPUHardwareInfo.f9858i);
        this.f10112a.setProperty(DPUHardwareInfo.f9854e, dPUHardwareInfo.f9859j);
        m8154c();
    }

    /* renamed from: a */
    public final DPUHardwareInfo m8160a() {
        m8150g();
        DPUHardwareInfo dPUHardwareInfo = new DPUHardwareInfo();
        dPUHardwareInfo.f9855f = this.f10112a.getProperty(DPUHardwareInfo.f9850a);
        dPUHardwareInfo.f9856g = this.f10112a.getProperty(DPUHardwareInfo.f9851b);
        dPUHardwareInfo.f9857h = this.f10112a.getProperty(DPUHardwareInfo.f9852c);
        dPUHardwareInfo.f9858i = this.f10112a.getProperty(DPUHardwareInfo.f9853d);
        dPUHardwareInfo.f9859j = this.f10112a.getProperty(DPUHardwareInfo.f9854e);
        if (TextUtils.isEmpty(dPUHardwareInfo.f9855f) || TextUtils.isEmpty(dPUHardwareInfo.f9856g) || TextUtils.isEmpty(dPUHardwareInfo.f9857h) || TextUtils.isEmpty(dPUHardwareInfo.f9859j) || TextUtils.isEmpty(dPUHardwareInfo.f9858i)) {
            return null;
        }
        return dPUHardwareInfo;
    }

    /* renamed from: b */
    public final DPUSoftInfo m8156b() {
        m8150g();
        DPUSoftInfo dPUSoftInfo = new DPUSoftInfo();
        dPUSoftInfo.f9865f = this.f10112a.getProperty(DPUSoftInfo.f9860a);
        dPUSoftInfo.f9866g = this.f10112a.getProperty(DPUSoftInfo.f9861b);
        dPUSoftInfo.f9867h = this.f10112a.getProperty(DPUSoftInfo.f9862c);
        dPUSoftInfo.f9868i = this.f10112a.getProperty(DPUSoftInfo.f9863d);
        dPUSoftInfo.f9869j = this.f10112a.getProperty(DPUSoftInfo.f9864e);
        if (TextUtils.isEmpty(dPUSoftInfo.f9865f) && TextUtils.isEmpty(dPUSoftInfo.f9866g) && TextUtils.isEmpty(dPUSoftInfo.f9867h) && TextUtils.isEmpty(dPUSoftInfo.f9868i) && TextUtils.isEmpty(dPUSoftInfo.f9869j)) {
            return null;
        }
        return dPUSoftInfo;
    }

    /* renamed from: c */
    public final void m8154c() {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(this.f10113d);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(this.f10113d);
            } catch (FileNotFoundException e) {
                e = e;
            } catch (IOException e2) {
                e = e2;
            }
            try {
                this.f10112a.store(fileOutputStream, "utf-8");
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
            } catch (IOException e6) {
                e = e6;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: d */
    public final String m8153d() {
        m8150g();
        return this.f10112a.getProperty("activateTime");
    }

    /* renamed from: b */
    public final void m8155b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f10112a.setProperty(DPUSoftInfo.f9861b, str);
        m8154c();
    }

    /* renamed from: e */
    public final String m8152e() {
        m8150g();
        return this.f10112a.getProperty(DPUSoftInfo.f9861b);
    }

    /* renamed from: f */
    public final String m8151f() {
        m8150g();
        return this.f10112a.getProperty("blacklistState");
    }
}
