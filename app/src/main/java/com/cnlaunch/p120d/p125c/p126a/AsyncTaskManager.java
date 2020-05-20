package com.cnlaunch.p120d.p125c.p126a;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import com.cnlaunch.p120d.p130d.NLog;
import com.itextpdf.text.pdf.PdfContentParser;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.cnlaunch.d.c.a.a */
/* loaded from: classes.dex */
public class AsyncTaskManager {

    /* renamed from: b */
    public static Map<Integer, WeakReference<BaseAsyncTask>> f7035b;

    /* renamed from: e */
    private static volatile AsyncTaskManager f7036e;

    /* renamed from: f */
    private static ExecutorService f7037f;

    /* renamed from: d */
    private Context f7040d;

    /* renamed from: c */
    private final String f7039c = AsyncTaskManager.class.getSimpleName();

    /* renamed from: a */
    public final int f7038a = 10;

    private AsyncTaskManager(Context context) {
        this.f7040d = context;
        f7037f = Executors.newFixedThreadPool(10);
        f7035b = new WeakHashMap();
    }

    /* renamed from: a */
    public static AsyncTaskManager m9574a(Context context) {
        if (f7036e == null) {
            synchronized (AsyncTaskManager.class) {
                if (f7036e == null) {
                    f7036e = new AsyncTaskManager(context);
                }
            }
        }
        return f7036e;
    }

    /* renamed from: a */
    public final void m9575a(int i, boolean z, OnDataListener onDataListener) {
        DownLoad downLoad = new DownLoad(i, z, onDataListener);
        if (i > 0) {
            BaseAsyncTask baseAsyncTask = new BaseAsyncTask(downLoad, this.f7040d);
            if (Build.VERSION.SDK_INT >= 11) {
                baseAsyncTask.executeOnExecutor(f7037f, new Object[0]);
            } else {
                baseAsyncTask.execute(new Object[0]);
            }
            f7035b.put(Integer.valueOf(i), new WeakReference<>(baseAsyncTask));
            return;
        }
        NLog.m9451c(this.f7039c, "the error is requestCode < 0");
    }

    /* renamed from: a */
    public static void m9576a(int i) {
        BaseAsyncTask baseAsyncTask;
        WeakReference<BaseAsyncTask> weakReference = f7035b.get(Integer.valueOf(i));
        if (weakReference != null && (baseAsyncTask = weakReference.get()) != null) {
            baseAsyncTask.cancel(true);
        }
        f7035b.remove(Integer.valueOf(i));
    }

    /* renamed from: a */
    public static AsyncTask.Status m9577a() {
        BaseAsyncTask baseAsyncTask;
        WeakReference<BaseAsyncTask> weakReference = f7035b.get(Integer.valueOf((int) PdfContentParser.COMMAND_TYPE));
        if (weakReference == null || (baseAsyncTask = weakReference.get()) == null) {
            return null;
        }
        return baseAsyncTask.getStatus();
    }
}
