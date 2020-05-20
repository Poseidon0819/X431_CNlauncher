package com.cnlaunch.x431pro.activity.upgrade.p238a;

import android.view.View;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;

/* compiled from: ExpiredAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.a.h */
/* loaded from: classes.dex */
final class View$OnClickListenerC2610h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ X431PadDtoSoft f15025a;

    /* renamed from: b */
    final /* synthetic */ int f15026b;

    /* renamed from: c */
    final /* synthetic */ ExpiredAdapter f15027c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2610h(ExpiredAdapter expiredAdapter, X431PadDtoSoft x431PadDtoSoft, int i) {
        this.f15027c = expiredAdapter;
        this.f15025a = x431PadDtoSoft;
        this.f15026b = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f15027c.f15036d.mo4707a(view, this.f15025a.getSoftId(), this.f15026b);
    }
}
