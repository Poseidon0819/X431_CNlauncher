package com.cnlaunch.x431pro.activity.setting;

import android.content.Context;
import android.widget.CompoundButton;
import com.cnlaunch.p120d.p121a.PreferencesManager;

/* compiled from: SettingFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.bb */
/* loaded from: classes.dex */
final class C2545bb implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ SettingFragment f14678a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2545bb(SettingFragment settingFragment) {
        this.f14678a = settingFragment;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        PreferencesManager.m9595a((Context) this.f14678a.getActivity()).m9587a("expired_remind", z);
    }
}
