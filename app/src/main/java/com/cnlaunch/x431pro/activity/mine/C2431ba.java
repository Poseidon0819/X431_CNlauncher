package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.x431pro.module.p258f.p259a.PayAction;

/* compiled from: MyOrderFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.ba */
/* loaded from: classes.dex */
final class C2431ba extends Thread {

    /* renamed from: a */
    final /* synthetic */ View$OnClickListenerC2414az f13909a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2431ba(View$OnClickListenerC2414az view$OnClickListenerC2414az) {
        this.f13909a = view$OnClickListenerC2414az;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Context context;
        try {
            context = this.f13909a.f13718d.mContext;
            new PayAction(context).m5352a(this.f13909a.f13715a.getOrderid());
        } catch (C1425f e) {
            e.printStackTrace();
        }
    }
}
