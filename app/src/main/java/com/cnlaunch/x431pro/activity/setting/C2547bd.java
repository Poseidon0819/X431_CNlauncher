package com.cnlaunch.x431pro.activity.setting;

import android.content.Context;
import android.widget.CompoundButton;
import com.cnlaunch.p120d.p121a.PreferencesManager;

/* compiled from: SettingFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.bd */
/* loaded from: classes.dex */
final class C2547bd implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ SettingFragment f14680a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2547bd(SettingFragment settingFragment) {
        this.f14680a = settingFragment;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        Context context;
        context = this.f14680a.mContext;
        PreferencesManager.m9595a(context).m9588a("show_navigatorpro_tips", z ? "1" : "0");
    }
}
