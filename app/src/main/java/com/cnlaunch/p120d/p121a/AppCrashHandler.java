package com.cnlaunch.p120d.p121a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/* renamed from: com.cnlaunch.d.a.b */
/* loaded from: classes.dex */
public class AppCrashHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: e */
    private static String f6754e = "X-431 PAD II";

    /* renamed from: f */
    private static AppCrashHandler f6755f;

    /* renamed from: a */
    public Context f6756a;

    /* renamed from: b */
    public Thread.UncaughtExceptionHandler f6757b;

    /* renamed from: c */
    public InterfaceC1416a f6758c;

    /* renamed from: d */
    private final String f6759d = AppCrashHandler.class.getSimpleName();

    /* renamed from: g */
    private Properties f6760g = new Properties();

    /* renamed from: h */
    private final String f6761h = "trace";

    /* renamed from: i */
    private final String f6762i = "exception";

    /* renamed from: j */
    private final String f6763j = "versionName";

    /* renamed from: k */
    private final String f6764k = "versionCode";

    /* renamed from: l */
    private final String f6765l = "crash_";

    /* renamed from: m */
    private final String f6766m = "yyyy-MM-dd hh:mm:ss";

    /* renamed from: n */
    private final String f6767n = ".cr";

    /* compiled from: AppCrashHandler.java */
    /* renamed from: com.cnlaunch.d.a.b$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1416a {
        /* renamed from: a */
        boolean mo6072a(File file);
    }

    /* renamed from: a */
    public static AppCrashHandler m9613a() {
        if (f6755f == null) {
            f6755f = new AppCrashHandler();
        }
        return f6755f;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        if (!m9608a(th) && (uncaughtExceptionHandler = this.f6757b) != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        try {
            Thread.sleep(500L);
            ActivityPageManager.m9634a();
            ActivityPageManager.m9632a(this.f6756a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private boolean m9608a(Throwable th) {
        if (th == null) {
            return true;
        }
        if (TextUtils.isEmpty(th.getStackTrace().toString())) {
            return false;
        }
        new C1417c(this, th).start();
        try {
            Thread.sleep(1000L);
            ActivityPageManager.m9634a();
            ActivityPageManager.m9632a(this.f6756a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    /* renamed from: a */
    public static void m9609a(String str) {
        f6754e = str;
    }

    /* renamed from: b */
    private static String m9607b() {
        return "crash_" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + ".cr";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m9610a(AppCrashHandler appCrashHandler, Context context, Throwable th) {
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
            StringBuilder sb = new StringBuilder();
            Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd,HH-mm-ss");
            sb.append(String.format("Devices Model: %s\n", Build.MODEL));
            sb.append(String.format("Devices SDK Version: %s\n", Integer.valueOf(Build.VERSION.SDK_INT)));
            if (packageInfo != null) {
                sb.append(String.format("Software Version Name: %s\n", packageInfo.versionName));
                sb.append(String.format("Software Version Code: %s\n", Integer.valueOf(packageInfo.versionCode)));
            }
            sb.append(String.format("Software Type: %s\n", "X431PADII"));
            sb.append(String.format("Crash Time: %s\n", simpleDateFormat.format(date)));
            sb.append(stringWriter.toString());
            printWriter.close();
            FileOutputStream openFileOutput = appCrashHandler.f6756a.openFileOutput(m9607b(), 0);
            openFileOutput.write(sb.toString().getBytes());
            openFileOutput.flush();
            openFileOutput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m9612a(Context context, Throwable th) {
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
            StringBuilder sb = new StringBuilder();
            Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd,HH-mm-ss");
            sb.append(String.format("Devices Model: %s\n", Build.MODEL));
            sb.append(String.format("Devices SDK Version: %s\n", Integer.valueOf(Build.VERSION.SDK_INT)));
            if (packageInfo != null) {
                sb.append(String.format("Software Version Name: %s\n", packageInfo.versionName));
                sb.append(String.format("Software Version Code: %s\n", Integer.valueOf(packageInfo.versionCode)));
            }
            sb.append(String.format("Software Type: %s\n", "X431PADII"));
            sb.append(String.format("Crash Time: %s\n", simpleDateFormat.format(date)));
            sb.append(stringWriter.toString());
            printWriter.close();
            String replaceAll = m9607b().replaceAll(":", "-");
            if (Environment.getExternalStorageState().equals("mounted")) {
                StringBuffer stringBuffer = new StringBuffer();
                if (f6754e.equalsIgnoreCase("X431Pro")) {
                    stringBuffer.append(Environment.getExternalStorageDirectory());
                    stringBuffer.append("/cnlaunch//Log/");
                } else {
                    stringBuffer.append(Environment.getExternalStorageDirectory());
                    stringBuffer.append("/cnlaunch/");
                    stringBuffer.append(f6754e);
                    stringBuffer.append("/Log/");
                }
                String stringBuffer2 = stringBuffer.toString();
                File file = new File(stringBuffer2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(stringBuffer2 + replaceAll);
                fileOutputStream.write(sb.toString().getBytes());
                fileOutputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
