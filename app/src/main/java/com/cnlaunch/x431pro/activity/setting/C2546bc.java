package com.cnlaunch.x431pro.activity.setting;

import android.content.Context;
import android.widget.CompoundButton;
import com.cnlaunch.p120d.p121a.PreferencesManager;

/* compiled from: SettingFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.bc */
/* loaded from: classes.dex */
final class C2546bc implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ SettingFragment f14679a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2546bc(SettingFragment settingFragment) {
        this.f14679a = settingFragment;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        Context context;
        context = this.f14679a.mContext;
        PreferencesManager.m9595a(context).m9588a("show_identifix_tips", z ? "1" : "0");
    }
}
