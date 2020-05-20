package com.cnlaunch.x431pro.activity;

import android.content.Intent;
import android.view.View;
import com.cnlaunch.p120d.p121a.PreferencesManager;

/* compiled from: AdvertiseShowActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.a */
/* loaded from: classes.dex */
final class View$OnClickListenerC1968a implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AdvertiseShowActivity f10762a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1968a(AdvertiseShowActivity advertiseShowActivity) {
        this.f10762a = advertiseShowActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PreferencesManager.m9595a(this.f10762a.f10981q).m9587a("advertises_readed", true);
        this.f10762a.startActivity(new Intent(this.f10762a.f10981q, MainActivity.class));
        this.f10762a.finish();
    }
}
