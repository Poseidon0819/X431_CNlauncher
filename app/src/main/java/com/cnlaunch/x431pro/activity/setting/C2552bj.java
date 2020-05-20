package com.cnlaunch.x431pro.activity.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.cnlaunch.p120d.p121a.ActivityPageManager;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog;

/* compiled from: ThemeSettingFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.bj */
/* loaded from: classes.dex */
final class C2552bj extends SelectMessageDialog {

    /* renamed from: a */
    final /* synthetic */ ThemeSettingFragment f14691a;

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: b */
    public final void mo4608b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2552bj(ThemeSettingFragment themeSettingFragment) {
        this.f14691a = themeSettingFragment;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: a */
    public final void mo4611a() {
        int i;
        Activity activity = this.f14691a.getActivity();
        i = this.f14691a.f14688d;
        PreferencesManager.m9595a((Context) activity).m9590a("theme_type", i);
        ActivityPageManager.m9634a();
        ActivityPageManager.m9629b();
        Intent launchIntentForPackage = activity.getApplicationContext().getPackageManager().getLaunchIntentForPackage(activity.getApplicationContext().getPackageName());
        launchIntentForPackage.addFlags(67108864);
        activity.startActivity(launchIntentForPackage);
    }
}
