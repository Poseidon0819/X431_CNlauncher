package com.baidu.mapsdkplatform.comapi.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.apache.http.conn.ssl.TokenParser;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.baidu.mapsdkplatform.comapi.util.d */
/* loaded from: classes.dex */
public final class C1303d {

    /* renamed from: a */
    private static volatile C1303d f6393a;

    /* renamed from: b */
    private boolean f6394b = false;

    /* renamed from: c */
    private boolean f6395c = true;

    /* renamed from: d */
    private final List<C1302c> f6396d = new ArrayList();

    /* renamed from: e */
    private C1302c f6397e = null;

    /* renamed from: f */
    private String f6398f;

    private C1303d() {
    }

    /* renamed from: a */
    public static C1303d m10083a() {
        if (f6393a == null) {
            synchronized (C1303d.class) {
                if (f6393a == null) {
                    f6393a = new C1303d();
                }
            }
        }
        return f6393a;
    }

    /* renamed from: a */
    private boolean m10080a(String str) {
        boolean z = false;
        try {
            File file = new File(str + "/test.0");
            if (file.exists()) {
                file.delete();
            }
            z = file.createNewFile();
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return z;
    }

    @SuppressLint({"NewApi"})
    @TargetApi(14)
    /* renamed from: c */
    private void m10077c(Context context) {
        boolean z;
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Method method2 = storageManager.getClass().getMethod("getVolumeState", String.class);
            Class<?> cls = Class.forName("android.os.storage.StorageVolume");
            Method method3 = cls.getMethod("isRemovable", new Class[0]);
            Method method4 = cls.getMethod("getPath", new Class[0]);
            Object[] objArr = (Object[]) method.invoke(storageManager, new Object[0]);
            if (objArr != null) {
                for (Object obj : objArr) {
                    String str = (String) method4.invoke(obj, new Object[0]);
                    if (str != null && str.length() > 0 && "mounted".equals(method2.invoke(storageManager, str))) {
                        boolean z2 = !((Boolean) method3.invoke(obj, new Object[0])).booleanValue();
                        if (Build.VERSION.SDK_INT <= 19 && m10080a(str)) {
                            this.f6396d.add(new C1302c(str, !z2, z2 ? "内置存储卡" : "外置存储卡", context));
                        } else if (Build.VERSION.SDK_INT >= 19) {
                            if (new File(str + File.separator + "BaiduMapSDKNew").exists() && str.equals(context.getSharedPreferences("map_pref", 0).getString("PREFFERED_SD_CARD", ""))) {
                                this.f6398f = str + File.separator + "BaiduMapSDKNew";
                            }
                        }
                    }
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    File[] externalFilesDirs = context.getExternalFilesDirs(null);
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.f6396d);
                    for (int i = 0; i < externalFilesDirs.length && externalFilesDirs[i] != null; i++) {
                        String absolutePath = externalFilesDirs[i].getAbsolutePath();
                        Iterator<C1302c> it = this.f6396d.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (absolutePath.startsWith(it.next().m10087a())) {
                                    z = true;
                                    break;
                                }
                            } else {
                                z = false;
                                break;
                            }
                        }
                        String str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
                        if (str2 != null && !z && absolutePath.indexOf(str2) != -1) {
                            arrayList.add(new C1302c(absolutePath, true, "外置存储卡", context));
                        }
                    }
                    this.f6396d.clear();
                    this.f6396d.addAll(arrayList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    private void m10076d(Context context) {
        Scanner scanner;
        String[] split;
        String[] split2;
        ArrayList<String> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Scanner scanner2 = null;
        try {
            try {
                File file = new File("/proc/mounts");
                if (file.exists()) {
                    scanner = new Scanner(file);
                    while (scanner.hasNext()) {
                        try {
                            String nextLine = scanner.nextLine();
                            if (nextLine.startsWith("/dev/block/vold/") && (split2 = nextLine.replace('\t', TokenParser.f24154SP).split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR)) != null && split2.length > 0) {
                                arrayList.add(split2[1]);
                            }
                        } catch (Exception e) {
                            e = e;
                            scanner2 = scanner;
                            e.printStackTrace();
                            if (scanner2 != null) {
                                scanner2.close();
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            scanner2 = scanner;
                            if (scanner2 != null) {
                                scanner2.close();
                            }
                            throw th;
                        }
                    }
                    scanner.close();
                }
                File file2 = new File("/system/etc/vold.fstab");
                if (file2.exists()) {
                    scanner = new Scanner(file2);
                    while (scanner.hasNext()) {
                        String nextLine2 = scanner.nextLine();
                        if (nextLine2.startsWith("dev_mount") && (split = nextLine2.replace('\t', TokenParser.f24154SP).split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR)) != null && split.length > 0) {
                            String str = split[2];
                            if (str.contains(":")) {
                                str = str.substring(0, str.indexOf(":"));
                            }
                            arrayList2.add(str);
                        }
                    }
                    scanner.close();
                }
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                this.f6396d.add(new C1302c(absolutePath, false, "Auto", context));
                for (String str2 : arrayList) {
                    if (arrayList2.contains(str2) && !str2.equals(absolutePath)) {
                        File file3 = new File(str2);
                        if (file3.exists() && file3.isDirectory() && file3.canWrite()) {
                            this.f6396d.add(new C1302c(str2, false, "Auto", context));
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* renamed from: a */
    public final void m10082a(Context context) {
        if (this.f6394b) {
            return;
        }
        this.f6394b = true;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                m10077c(context);
            } else {
                m10076d(context);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (this.f6396d.size() > 0) {
                C1302c c1302c = null;
                int i = 0;
                for (C1302c c1302c2 : this.f6396d) {
                    if (new File(c1302c2.m10086b()).exists()) {
                        i++;
                        c1302c = c1302c2;
                    }
                }
                if (i == 0) {
                    this.f6397e = m10078b(context);
                    if (this.f6397e == null) {
                        Iterator<C1302c> it = this.f6396d.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            C1302c next = it.next();
                            if (m10081a(context, next)) {
                                this.f6397e = next;
                                break;
                            }
                        }
                    }
                } else if (i != 1) {
                    this.f6397e = m10078b(context);
                } else if (m10081a(context, c1302c)) {
                    this.f6397e = c1302c;
                }
                if (this.f6397e == null) {
                    this.f6397e = this.f6396d.get(0);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (this.f6397e == null || !m10080a(this.f6397e.m10087a())) {
                this.f6395c = false;
                this.f6397e = new C1302c(context);
                this.f6396d.clear();
                this.f6396d.add(this.f6397e);
                return;
            }
            File file = new File(this.f6397e.m10086b());
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(this.f6397e.m10085c());
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(file2, ".nomedia");
            if (file3.exists()) {
                return;
            }
            file3.createNewFile();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: a */
    public final boolean m10081a(Context context, C1302c c1302c) {
        String m10087a = c1302c.m10087a();
        if (m10080a(m10087a)) {
            SharedPreferences.Editor edit = context.getSharedPreferences("map_pref", 0).edit();
            edit.putString("PREFFERED_SD_CARD", m10087a);
            return edit.commit();
        }
        return false;
    }

    /* renamed from: b */
    public final C1302c m10079b() {
        return this.f6397e;
    }

    /* renamed from: b */
    public final C1302c m10078b(Context context) {
        String string = context.getSharedPreferences("map_pref", 0).getString("PREFFERED_SD_CARD", "");
        if (string == null || string.length() <= 0) {
            return null;
        }
        for (C1302c c1302c : this.f6396d) {
            if (c1302c.m10087a().equals(string)) {
                return c1302c;
            }
        }
        return null;
    }
}
