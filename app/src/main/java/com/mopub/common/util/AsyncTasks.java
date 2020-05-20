package com.mopub.common.util;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class AsyncTasks {

    /* renamed from: a */
    private static Executor f20221a;

    @VisibleForTesting
    public static void setExecutor(Executor executor) {
        f20221a = executor;
    }

    @TargetApi(11)
    public static <P> void safeExecuteOnExecutor(AsyncTask<P, ?, ?> asyncTask, P... pArr) {
        Preconditions.checkNotNull(asyncTask, "Unable to execute null AsyncTask.");
        Preconditions.checkUiThread("AsyncTask must be executed on the main thread");
        if (Build.VERSION.SDK_INT >= 11) {
            asyncTask.executeOnExecutor(f20221a, pArr);
        } else {
            asyncTask.execute(pArr);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f20221a = AsyncTask.THREAD_POOL_EXECUTOR;
        } else {
            f20221a = Executors.newSingleThreadExecutor();
        }
    }
}
