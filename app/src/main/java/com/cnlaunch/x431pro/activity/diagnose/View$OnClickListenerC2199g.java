package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.activity.login.RegistActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CarIconFragmentForAll.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.g */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2199g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CarIconFragmentForAll f12473a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2199g(CarIconFragmentForAll carIconFragmentForAll) {
        this.f12473a = carIconFragmentForAll;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        Context context2;
        Context context3;
        context = this.f12473a.mContext;
        PreferencesManager.m9595a(context).m9587a("REGIST_SHOWTIPS", true);
        context2 = this.f12473a.mContext;
        Intent intent = new Intent(context2, RegistActivity.class);
        intent.setFlags(67108864);
        context3 = this.f12473a.mContext;
        context3.startActivity(intent);
    }
}
