package com.cnlaunch.x431pro.activity.setting;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.cnlaunch.p120d.p121a.ActivityPageManager;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog;
import com.ifoer.pro.expeditionphone.WelcomeActivity;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* compiled from: OrientationSetting.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.an */
/* loaded from: classes.dex */
final class C2528an extends SelectMessageDialog {

    /* renamed from: a */
    final /* synthetic */ OrientationSetting f14585a;

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: b */
    public final void mo4608b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2528an(OrientationSetting orientationSetting) {
        this.f14585a = orientationSetting;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: a */
    public final void mo4611a() {
        int i;
        Activity activity = this.f14585a.getActivity();
        i = this.f14585a.f14582e;
        PreferencesManager.m9595a((Context) activity).m9590a("Orientation", i);
        ((AlarmManager) activity.getSystemService("alarm")).set(1, System.currentTimeMillis() + 500, PendingIntent.getActivity(activity, 123456, new Intent(activity, WelcomeActivity.class), NTLMConstants.FLAG_UNIDENTIFIED_11));
        ActivityPageManager.m9634a();
        ActivityPageManager.m9629b();
    }
}
