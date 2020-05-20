package com.cnlaunch.x431pro.activity.upgrade.p240c;

import android.content.Context;
import com.cnlaunch.x431pro.activity.upgrade.p239b.SimpleOnDownloadListener;
import com.cnlaunch.x431pro.widget.ApkUpgradeProgressDialog;

/* compiled from: ApkUpgradeAndDownloadLogic.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.c.f */
/* loaded from: classes.dex */
public final class DialogC2669f extends ApkUpgradeProgressDialog {

    /* renamed from: a */
    final /* synthetic */ SimpleOnDownloadListener f15290a;

    /* renamed from: b */
    final /* synthetic */ ApkUpgradeAndDownloadLogic f15291b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2669f(ApkUpgradeAndDownloadLogic apkUpgradeAndDownloadLogic, Context context, SimpleOnDownloadListener simpleOnDownloadListener) {
        super(context);
        this.f15291b = apkUpgradeAndDownloadLogic;
        this.f15290a = simpleOnDownloadListener;
    }

    @Override // com.cnlaunch.x431pro.widget.ApkUpgradeProgressDialog
    /* renamed from: b */
    public final void mo4729b() {
        ApkUpgradeAndDownloadLogic.m5617k(this.f15291b);
    }
}
