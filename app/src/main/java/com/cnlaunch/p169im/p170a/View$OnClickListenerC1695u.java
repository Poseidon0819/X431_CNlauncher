package com.cnlaunch.p169im.p170a;

import android.content.Context;
import android.view.View;
import com.cnlaunch.p169im.p174db.GoloDBManager;
import com.cnlaunch.x431pro.activity.golo.p225b.OnFaceTouchListener;

/* compiled from: MessageInfoAdapter.java */
/* renamed from: com.cnlaunch.im.a.u */
/* loaded from: classes.dex */
final class View$OnClickListenerC1695u implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f9034a;

    /* renamed from: b */
    final /* synthetic */ MessageInfoAdapter f9035b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1695u(MessageInfoAdapter messageInfoAdapter, int i) {
        this.f9035b = messageInfoAdapter;
        this.f9034a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        OnFaceTouchListener onFaceTouchListener;
        Context context;
        OnFaceTouchListener onFaceTouchListener2;
        onFaceTouchListener = this.f9035b.f9024f;
        if (onFaceTouchListener != null) {
            context = this.f9035b.f9025g;
            boolean z = GoloDBManager.m8756a(context).m8755a(this.f9035b.f9019a.get(this.f9034a).f9270b) != null;
            onFaceTouchListener2 = this.f9035b.f9024f;
            onFaceTouchListener2.mo7021a(this.f9035b.f9019a.get(this.f9034a).f9271c, this.f9035b.f9019a.get(this.f9034a).f9270b, z);
        }
    }
}
