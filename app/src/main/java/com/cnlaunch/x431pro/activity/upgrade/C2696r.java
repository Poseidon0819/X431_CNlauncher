package com.cnlaunch.x431pro.activity.upgrade;

import android.content.Context;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DownloadFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.r */
/* loaded from: classes.dex */
final class C2696r extends Thread {

    /* renamed from: a */
    final /* synthetic */ DownloadFragment f15423a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2696r(DownloadFragment downloadFragment) {
        this.f15423a = downloadFragment;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Context context;
        ThreadPoolExecutor threadPoolExecutor;
        try {
            threadPoolExecutor = this.f15423a.f15362N;
            threadPoolExecutor.awaitTermination(10000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        context = this.f15423a.mContext;
        LoadDialog.m4681b(context);
        this.f15423a.f15403x.sendMessage(this.f15423a.f15403x.obtainMessage(10, 1, 0));
    }
}
