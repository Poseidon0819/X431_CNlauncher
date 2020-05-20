package com.cnlaunch.x431pro.utils;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.activity.upgrade.p239b.SimpleOnDownloadListener;
import com.cnlaunch.x431pro.activity.upgrade.p240c.ApkUpgradeAndDownloadLogic;
import com.cnlaunch.x431pro.module.p269j.p271b.LatestApkVersionInfo;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.google.gson.Gson;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ApkUpgradeUtils.java */
/* renamed from: com.cnlaunch.x431pro.utils.i */
/* loaded from: classes.dex */
public final class C2776i extends SimpleOnDownloadListener {

    /* renamed from: a */
    final /* synthetic */ ApkUpgradeAndDownloadLogic f15901a;

    /* renamed from: b */
    final /* synthetic */ ApkUpgradeUtils f15902b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2776i(ApkUpgradeUtils apkUpgradeUtils, ApkUpgradeAndDownloadLogic apkUpgradeAndDownloadLogic) {
        this.f15902b = apkUpgradeUtils;
        this.f15901a = apkUpgradeAndDownloadLogic;
    }

    @Override // com.cnlaunch.x431pro.activity.upgrade.p239b.SimpleOnDownloadListener, com.cnlaunch.x431pro.activity.upgrade.p239b.OnDownloadListener
    /* renamed from: b */
    public final void mo4930b(String str, int i) {
        Handler handler;
        Handler handler2;
        if (i != 0) {
            handler = this.f15902b.f15718c;
            if (handler != null) {
                handler2 = this.f15902b.f15718c;
                handler2.sendEmptyMessage(-116);
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.upgrade.p239b.SimpleOnDownloadListener, com.cnlaunch.x431pro.activity.upgrade.p239b.OnDownloadListener
    /* renamed from: d */
    public final void mo4929d(String str, int i) {
        Handler handler;
        Context context;
        LatestApkVersionInfo latestApkVersionInfo;
        Handler handler2;
        if (i != 0) {
            handler = this.f15902b.f15718c;
            if (handler != null) {
                handler2 = this.f15902b.f15718c;
                handler2.sendEmptyMessage(i);
            }
            if (i == -2 || i == -7 || i == -6) {
                context = this.f15902b.f15717b;
                String m9591a = PreferencesManager.m9595a(context).m9591a("apk_soft_info");
                if (TextUtils.isEmpty(m9591a) || (latestApkVersionInfo = (LatestApkVersionInfo) new Gson().fromJson(m9591a, (Class<Object>) LatestApkVersionInfo.class)) == null || TextUtils.isEmpty(latestApkVersionInfo.getVersionNo())) {
                    return;
                }
                String m5625c = this.f15901a.m5625c(latestApkVersionInfo.getVersionNo());
                if (TextUtils.isEmpty(m5625c)) {
                    return;
                }
                File file = new File(PathUtils.m4852e() + m5625c);
                if (file.exists()) {
                    FileUtils.m5020a(file);
                }
            }
        }
    }
}
