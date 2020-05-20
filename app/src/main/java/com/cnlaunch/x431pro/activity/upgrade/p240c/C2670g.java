package com.cnlaunch.x431pro.activity.upgrade.p240c;

import com.cnlaunch.x431pro.activity.GDApplication;
import com.cnlaunch.x431pro.activity.upgrade.p239b.OnDownloadListener;
import com.cnlaunch.x431pro.activity.upgrade.p239b.SimpleOnDownloadListener;
import com.cnlaunch.x431pro.widget.ApkUpgradeProgressDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: ApkUpgradeAndDownloadLogic.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.c.g */
/* loaded from: classes.dex */
public final class C2670g implements OnDownloadListener {

    /* renamed from: a */
    final /* synthetic */ SimpleOnDownloadListener f15292a;

    /* renamed from: b */
    final /* synthetic */ ApkUpgradeAndDownloadLogic f15293b;

    public C2670g(ApkUpgradeAndDownloadLogic apkUpgradeAndDownloadLogic, SimpleOnDownloadListener simpleOnDownloadListener) {
        this.f15293b = apkUpgradeAndDownloadLogic;
        this.f15292a = simpleOnDownloadListener;
    }

    @Override // com.cnlaunch.x431pro.activity.upgrade.p239b.OnDownloadListener
    /* renamed from: a */
    public final void mo5615a(String str) {
        ApkUpgradeProgressDialog apkUpgradeProgressDialog;
        ApkUpgradeProgressDialog apkUpgradeProgressDialog2;
        ApkUpgradeProgressDialog apkUpgradeProgressDialog3;
        if (str.equals(this.f15293b.f15256E)) {
            apkUpgradeProgressDialog = this.f15293b.f15263g;
            apkUpgradeProgressDialog.m4731a(R.string.down_state_1);
            GDApplication.m7908c();
            apkUpgradeProgressDialog2 = this.f15293b.f15263g;
            apkUpgradeProgressDialog2.m4725c(R.drawable.progressbar_mini_downloading);
            apkUpgradeProgressDialog3 = this.f15293b.f15263g;
            apkUpgradeProgressDialog3.m4722d(R.color.downloading);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.upgrade.p239b.OnDownloadListener
    /* renamed from: a */
    public final void mo5614a(String str, int i) {
        ApkUpgradeProgressDialog apkUpgradeProgressDialog;
        ApkUpgradeProgressDialog apkUpgradeProgressDialog2;
        ApkUpgradeProgressDialog apkUpgradeProgressDialog3;
        ApkUpgradeProgressDialog apkUpgradeProgressDialog4;
        if (str.equals(this.f15293b.f15256E)) {
            apkUpgradeProgressDialog = this.f15293b.f15263g;
            apkUpgradeProgressDialog.m4731a(R.string.down_state_1);
            GDApplication.m7908c();
            apkUpgradeProgressDialog2 = this.f15293b.f15263g;
            apkUpgradeProgressDialog2.m4725c(R.drawable.progressbar_mini_downloading);
            apkUpgradeProgressDialog3 = this.f15293b.f15263g;
            apkUpgradeProgressDialog3.m4722d(R.color.downloading);
            apkUpgradeProgressDialog4 = this.f15293b.f15263g;
            apkUpgradeProgressDialog4.m4728b(i);
            SimpleOnDownloadListener simpleOnDownloadListener = this.f15292a;
            if (simpleOnDownloadListener != null) {
                simpleOnDownloadListener.mo5614a(str, i);
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.upgrade.p239b.OnDownloadListener
    /* renamed from: b */
    public final void mo4930b(String str, int i) {
        ApkUpgradeProgressDialog apkUpgradeProgressDialog;
        ApkUpgradeProgressDialog apkUpgradeProgressDialog2;
        ApkUpgradeProgressDialog apkUpgradeProgressDialog3;
        ApkUpgradeProgressDialog apkUpgradeProgressDialog4;
        ApkUpgradeProgressDialog apkUpgradeProgressDialog5;
        ApkUpgradeProgressDialog apkUpgradeProgressDialog6;
        ApkUpgradeProgressDialog apkUpgradeProgressDialog7;
        ApkUpgradeProgressDialog apkUpgradeProgressDialog8;
        if (str.equals(this.f15293b.f15256E)) {
            if (i == 0) {
                apkUpgradeProgressDialog6 = this.f15293b.f15263g;
                apkUpgradeProgressDialog6.m4731a(R.string.down_state_2);
                SimpleOnDownloadListener simpleOnDownloadListener = this.f15292a;
                if (simpleOnDownloadListener != null) {
                    simpleOnDownloadListener.mo4930b(str, i);
                }
                GDApplication.m7908c();
                apkUpgradeProgressDialog7 = this.f15293b.f15263g;
                apkUpgradeProgressDialog7.m4725c(R.drawable.progressbar_mini_downloading);
                apkUpgradeProgressDialog8 = this.f15293b.f15263g;
                apkUpgradeProgressDialog8.m4728b(100);
                return;
            }
            apkUpgradeProgressDialog = this.f15293b.f15263g;
            apkUpgradeProgressDialog.m4731a(R.string.down_state_3);
            apkUpgradeProgressDialog2 = this.f15293b.f15263g;
            apkUpgradeProgressDialog2.m4722d(R.color.download_fail);
            apkUpgradeProgressDialog3 = this.f15293b.f15263g;
            apkUpgradeProgressDialog3.m4725c(R.drawable.progressbar_mini_fail);
            apkUpgradeProgressDialog4 = this.f15293b.f15263g;
            apkUpgradeProgressDialog4.m4721e();
            apkUpgradeProgressDialog5 = this.f15293b.f15263g;
            apkUpgradeProgressDialog5.m4723d();
            SimpleOnDownloadListener simpleOnDownloadListener2 = this.f15292a;
            if (simpleOnDownloadListener2 != null) {
                simpleOnDownloadListener2.mo4930b(str, i);
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.upgrade.p239b.OnDownloadListener
    /* renamed from: b */
    public final void mo5613b(String str) {
        ApkUpgradeProgressDialog apkUpgradeProgressDialog;
        ApkUpgradeProgressDialog apkUpgradeProgressDialog2;
        ApkUpgradeProgressDialog apkUpgradeProgressDialog3;
        ApkUpgradeProgressDialog apkUpgradeProgressDialog4;
        ApkUpgradeProgressDialog apkUpgradeProgressDialog5;
        ApkUpgradeProgressDialog apkUpgradeProgressDialog6;
        ApkUpgradeProgressDialog apkUpgradeProgressDialog7;
        if (str.equals(this.f15293b.f15256E)) {
            if (this.f15293b.f15262f == 0) {
                apkUpgradeProgressDialog6 = this.f15293b.f15263g;
                apkUpgradeProgressDialog6.m4721e();
                apkUpgradeProgressDialog7 = this.f15293b.f15263g;
                apkUpgradeProgressDialog7.m4723d();
                return;
            }
            apkUpgradeProgressDialog = this.f15293b.f15263g;
            apkUpgradeProgressDialog.m4731a(R.string.down_state_7);
            apkUpgradeProgressDialog2 = this.f15293b.f15263g;
            apkUpgradeProgressDialog2.m4722d(R.color.installing);
            apkUpgradeProgressDialog3 = this.f15293b.f15263g;
            apkUpgradeProgressDialog3.m4728b(100);
            apkUpgradeProgressDialog4 = this.f15293b.f15263g;
            apkUpgradeProgressDialog4.setCancelable(false);
            GDApplication.m7908c();
            apkUpgradeProgressDialog5 = this.f15293b.f15263g;
            apkUpgradeProgressDialog5.m4725c(R.drawable.progressbar_mini_installing);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.upgrade.p239b.OnDownloadListener
    /* renamed from: c */
    public final void mo5612c(String str, int i) {
        SimpleOnDownloadListener simpleOnDownloadListener;
        if (!str.equals(this.f15293b.f15256E) || (simpleOnDownloadListener = this.f15292a) == null) {
            return;
        }
        simpleOnDownloadListener.mo5612c(str, i);
    }

    @Override // com.cnlaunch.x431pro.activity.upgrade.p239b.OnDownloadListener
    /* renamed from: d */
    public final void mo4929d(String str, int i) {
        ApkUpgradeProgressDialog apkUpgradeProgressDialog;
        ApkUpgradeProgressDialog apkUpgradeProgressDialog2;
        ApkUpgradeProgressDialog apkUpgradeProgressDialog3;
        ApkUpgradeProgressDialog apkUpgradeProgressDialog4;
        ApkUpgradeProgressDialog apkUpgradeProgressDialog5;
        ApkUpgradeProgressDialog apkUpgradeProgressDialog6;
        ApkUpgradeProgressDialog apkUpgradeProgressDialog7;
        ApkUpgradeProgressDialog apkUpgradeProgressDialog8;
        ApkUpgradeProgressDialog apkUpgradeProgressDialog9;
        if (str.equals(this.f15293b.f15256E)) {
            this.f15293b.f15258b = false;
            if (this.f15293b.f15262f == 1) {
                apkUpgradeProgressDialog = this.f15293b.f15263g;
                apkUpgradeProgressDialog.m4721e();
                if (i == 0) {
                    apkUpgradeProgressDialog7 = this.f15293b.f15263g;
                    apkUpgradeProgressDialog7.m4731a(R.string.down_state_4);
                    apkUpgradeProgressDialog8 = this.f15293b.f15263g;
                    apkUpgradeProgressDialog8.m4722d(R.color.install_success);
                    GDApplication.m7908c();
                    apkUpgradeProgressDialog9 = this.f15293b.f15263g;
                    apkUpgradeProgressDialog9.m4725c(R.drawable.progressbar_mini);
                } else {
                    apkUpgradeProgressDialog2 = this.f15293b.f15263g;
                    apkUpgradeProgressDialog2.m4731a(R.string.down_state_5);
                    apkUpgradeProgressDialog3 = this.f15293b.f15263g;
                    apkUpgradeProgressDialog3.m4722d(R.color.download_fail);
                    apkUpgradeProgressDialog4 = this.f15293b.f15263g;
                    apkUpgradeProgressDialog4.m4725c(R.drawable.progressbar_mini_fail);
                }
                apkUpgradeProgressDialog5 = this.f15293b.f15263g;
                apkUpgradeProgressDialog5.mo4729b();
                apkUpgradeProgressDialog6 = this.f15293b.f15263g;
                apkUpgradeProgressDialog6.m4723d();
            }
            SimpleOnDownloadListener simpleOnDownloadListener = this.f15292a;
            if (simpleOnDownloadListener != null) {
                simpleOnDownloadListener.mo4929d(str, i);
            }
        }
    }
}
