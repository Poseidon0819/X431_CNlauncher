package com.cnlaunch.x431pro.module.rtu;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseSelectFragment.java */
/* renamed from: com.cnlaunch.x431pro.module.rtu.b */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2738b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BaseSelectFragment f15691a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2738b(BaseSelectFragment baseSelectFragment) {
        this.f15691a = baseSelectFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        long j;
        long j2;
        int i;
        j = this.f15691a.f15689o;
        if (j == 0) {
            this.f15691a.f15689o = System.currentTimeMillis();
            BaseSelectFragment.m5203b(this.f15691a);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        j2 = this.f15691a.f15689o;
        if (currentTimeMillis - j2 > 1500) {
            this.f15691a.f15689o = 0L;
            BaseSelectFragment.m5201c(this.f15691a);
            return;
        }
        this.f15691a.f15689o = System.currentTimeMillis();
        BaseSelectFragment.m5203b(this.f15691a);
        i = this.f15691a.f15690p;
        if (i == 5) {
            this.f15691a.f15675a.mo5199a(7);
            this.f15691a.f15689o = 0L;
            BaseSelectFragment.m5201c(this.f15691a);
        }
    }
}
