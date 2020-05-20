package com.cnlaunch.x431pro.utils;

import android.content.Context;
import android.view.View;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.module.p269j.p271b.LatestApkVersionInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ApkUpgradeUtils.java */
/* renamed from: com.cnlaunch.x431pro.utils.d */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2748d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ LatestApkVersionInfo f15752a;

    /* renamed from: b */
    final /* synthetic */ ApkUpgradeUtils f15753b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2748d(ApkUpgradeUtils apkUpgradeUtils, LatestApkVersionInfo latestApkVersionInfo) {
        this.f15753b = apkUpgradeUtils;
        this.f15752a = latestApkVersionInfo;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        context = this.f15753b.f15717b;
        PreferencesManager.m9595a(context).m9588a("skip_upgrade_apk_version", this.f15752a.getVersionNo());
    }
}
