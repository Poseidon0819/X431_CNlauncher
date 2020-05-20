package com.cnlaunch.p120d.p121a;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.launch.p365b.C3671a;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppCrashHandler.java */
/* renamed from: com.cnlaunch.d.a.c */
/* loaded from: classes.dex */
public final class C1417c extends Thread {

    /* renamed from: a */
    final /* synthetic */ Throwable f6768a;

    /* renamed from: b */
    final /* synthetic */ AppCrashHandler f6769b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1417c(AppCrashHandler appCrashHandler, Throwable th) {
        this.f6769b = appCrashHandler;
        this.f6768a = th;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        Context context3;
        Looper.prepare();
        AppCrashHandler appCrashHandler = this.f6769b;
        context = appCrashHandler.f6756a;
        AppCrashHandler.m9610a(appCrashHandler, context, this.f6768a);
        context2 = this.f6769b.f6756a;
        AppCrashHandler.m9612a(context2, this.f6768a);
        AppCrashHandler appCrashHandler2 = this.f6769b;
        String[] list = appCrashHandler2.f6756a.getFilesDir().list(new C1418d(appCrashHandler2));
        if (list != null && list.length > 0) {
            for (String str : list) {
                File file = new File(appCrashHandler2.f6756a.getFilesDir(), str);
                if (file.exists() && appCrashHandler2.f6758c != null && appCrashHandler2.f6758c.mo6072a(file)) {
                    file.delete();
                }
            }
        }
        context3 = this.f6769b.f6756a;
        Toast.makeText(context3, C3671a.C3674c.crash_hint, 0).show();
        Looper.loop();
    }
}
