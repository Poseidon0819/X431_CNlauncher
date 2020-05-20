package com.cnlaunch.x431pro.activity;

import android.content.Intent;
import android.view.View;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;

/* compiled from: GuideActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.o */
/* loaded from: classes.dex */
final class View$OnClickListenerC2501o implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ GuideActivity f14347a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2501o(GuideActivity guideActivity) {
        this.f14347a = guideActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intent intent = new Intent(this.f14347a.f10981q, MainActivity.class);
        if (C2744aa.m5137l() && C2778n.m4917a(this.f14347a.f10981q)) {
            intent = new Intent(this.f14347a.f10981q, AdvertiseShowActivity.class);
        }
        this.f14347a.startActivity(intent);
        this.f14347a.finish();
    }
}
