package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.cnlaunch.x431pro.activity.login.LoginActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CarIconFragmentForAll.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.h */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2200h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CarIconFragmentForAll f12474a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2200h(CarIconFragmentForAll carIconFragmentForAll) {
        this.f12474a = carIconFragmentForAll;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        Context context2;
        context = this.f12474a.mContext;
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(67108864);
        context2 = this.f12474a.mContext;
        context2.startActivity(intent);
    }
}
