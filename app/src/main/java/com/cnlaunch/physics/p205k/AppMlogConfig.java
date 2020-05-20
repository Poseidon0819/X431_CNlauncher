package com.cnlaunch.physics.p205k;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.physics.PropertyFileOperation;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

/* renamed from: com.cnlaunch.physics.k.a */
/* loaded from: classes.dex */
public final class AppMlogConfig {

    /* renamed from: l */
    private static AppMlogConfig f10028l;

    /* renamed from: a */
    public boolean f10029a;

    /* renamed from: b */
    private final String f10030b = "cnlaunch";

    /* renamed from: c */
    private final String f10031c = "app_mlog";

    /* renamed from: d */
    private final String f10032d = "app_mlog_config.properties";

    /* renamed from: e */
    private final String f10033e = "debug";

    /* renamed from: f */
    private final String f10034f = "app_mlog_debug";

    /* renamed from: g */
    private String f10035g;

    /* renamed from: h */
    private String f10036h;

    /* renamed from: i */
    private String f10037i;

    /* renamed from: j */
    private String f10038j;

    /* renamed from: k */
    private PropertyFileOperation f10039k;

    /* renamed from: m */
    private C1853a f10040m;

    /* compiled from: AppMlogConfig.java */
    /* renamed from: com.cnlaunch.physics.k.a$a */
    /* loaded from: classes.dex */
    public static class C1853a {

        /* renamed from: b */
        boolean f10042b = false;

        /* renamed from: a */
        Process f10041a = null;
    }

    private AppMlogConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f10035g = Environment.getExternalStorageDirectory().getPath() + File.separator + "cnlaunch" + File.separator + "app_mlog" + File.separator + "app_mlog_config.properties";
            this.f10036h = Environment.getExternalStorageDirectory().getPath() + File.separator + "cnlaunch" + File.separator + "app_mlog" + File.separator + "app_mlog_debug";
            StringBuilder sb = new StringBuilder();
            sb.append(Environment.getExternalStorageDirectory().getPath());
            sb.append(File.separator);
            sb.append("cnlaunch");
            sb.append(File.separator);
            sb.append("app_mlog");
            this.f10037i = sb.toString();
        } else {
            this.f10035g = str + File.separator + "app_mlog" + File.separator + "app_mlog_config.properties";
            this.f10036h = str + File.separator + "app_mlog" + File.separator + "app_mlog_debug";
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(File.separator);
            sb2.append("app_mlog");
            this.f10037i = sb2.toString();
        }
        Log.d("AppMlogConfig", String.format("settingsFile=%s,appMLogDebugFolder=%s,appMLogConfigFolder=%s", this.f10035g, this.f10036h, this.f10037i));
        this.f10039k = new PropertyFileOperation(this.f10035g);
        this.f10029a = Boolean.parseBoolean(this.f10039k.m8090a("debug"));
        Log.d("AppMlogConfig", "DebugSwitch is" + this.f10029a);
        this.f10038j = "";
        this.f10040m = new C1853a();
    }

    /* renamed from: c */
    private String m8213c() {
        if (TextUtils.isEmpty(this.f10038j)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH);
            try {
                File file = new File(this.f10036h);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(this.f10036h + File.separator + simpleDateFormat.format(new Date()) + ".log");
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                        this.f10038j = file2.getAbsolutePath();
                    } catch (Exception unused) {
                        this.f10038j = "";
                    }
                } else {
                    this.f10038j = file2.getAbsolutePath();
                }
            } catch (Exception e) {
                e.printStackTrace();
                this.f10038j = "";
            }
            if (TextUtils.isEmpty(this.f10038j)) {
                this.f10038j = this.f10036h + File.separator + simpleDateFormat.format(new Date()) + ".log";
            }
        }
        Log.d("AppMlogConfig", "getDebugAbsoluteFilename  is" + this.f10038j);
        return this.f10038j;
    }

    /* renamed from: a */
    public static AppMlogConfig m8215a() {
        if (f10028l == null) {
            f10028l = new AppMlogConfig("");
        }
        return f10028l;
    }

    /* renamed from: b */
    public final void m8214b() {
        C1853a c1853a;
        try {
            if (!this.f10029a || this.f10040m.f10042b) {
                return;
            }
            String str = this.f10036h;
            Vector vector = new Vector();
            File[] listFiles = new File(str).listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (!file.isDirectory() && file.getName().endsWith(".log")) {
                        vector.add(file);
                    }
                }
                int i = 0;
                while (i < vector.size() - 1) {
                    int i2 = i + 1;
                    File file2 = (File) vector.elementAt(i);
                    for (int i3 = i2; i3 < vector.size(); i3++) {
                        if (file2.lastModified() > ((File) vector.elementAt(i3)).lastModified()) {
                            vector.setElementAt(vector.elementAt(i3), i);
                            vector.setElementAt(file2, i3);
                            file2 = (File) vector.elementAt(i);
                        }
                    }
                    i = i2;
                }
            }
            if (vector.size() >= 5) {
                int size = (vector.size() + 1) - 5;
                for (int i4 = 0; i4 < size; i4++) {
                    File file3 = (File) vector.elementAt(i4);
                    if (file3 != null) {
                        file3.delete();
                    }
                }
            }
            String format = String.format("logcat  -v  threadtime  -f   %s &", m8213c());
            Log.d("AppMlogConfig", "save App Log command=".concat(String.valueOf(format)));
            Process exec = Runtime.getRuntime().exec(format);
            this.f10040m.f10042b = true;
            this.f10040m.f10041a = exec;
            if (C1856n.f10135a) {
                C1856n.m8130a("AppMlogConfig", " AppLogRunState  setProcess = " + c1853a.f10041a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
