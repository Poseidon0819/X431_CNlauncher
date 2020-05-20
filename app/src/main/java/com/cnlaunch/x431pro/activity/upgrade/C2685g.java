package com.cnlaunch.x431pro.activity.upgrade;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloadFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.g */
/* loaded from: classes.dex */
public final class C2685g extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ DownloadFragment f15412a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2685g(DownloadFragment downloadFragment) {
        this.f15412a = downloadFragment;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        ThreadPoolExecutor threadPoolExecutor;
        ThreadPoolExecutor threadPoolExecutor2;
        Context context2;
        if (intent.getAction().equalsIgnoreCase("logout")) {
            this.f15412a.f15401v.f7053a = null;
            this.f15412a.f15401v.m9549c();
            threadPoolExecutor = this.f15412a.f15362N;
            threadPoolExecutor.shutdownNow();
            threadPoolExecutor2 = this.f15412a.f15362N;
            if (!threadPoolExecutor2.isTerminating()) {
                this.f15412a.f15403x.sendMessage(this.f15412a.f15403x.obtainMessage(13, 0, 0));
            } else {
                new C2686h(this).start();
            }
            context2 = this.f15412a.mContext;
            if (PreferencesManager.m9595a(context2).m9583b("enable_upload_downloadlog", false)) {
                this.f15412a.m5475k();
            }
            if (this.f15412a.isVisible()) {
                return;
            }
            DownloadFragment.m5484f(this.f15412a);
        }
    }
}
