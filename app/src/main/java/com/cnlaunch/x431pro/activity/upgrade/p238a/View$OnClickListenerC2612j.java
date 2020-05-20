package com.cnlaunch.x431pro.activity.upgrade.p238a;

import android.view.View;

/* compiled from: ExpiredAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.a.j */
/* loaded from: classes.dex */
final class View$OnClickListenerC2612j implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f15030a;

    /* renamed from: b */
    final /* synthetic */ int f15031b;

    /* renamed from: c */
    final /* synthetic */ ExpiredAdapter f15032c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2612j(ExpiredAdapter expiredAdapter, boolean z, int i) {
        this.f15032c = expiredAdapter;
        this.f15030a = z;
        this.f15031b = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f15032c.f15037e != null) {
            if (this.f15030a) {
                this.f15032c.f15037e.collapseGroup(this.f15031b);
            } else {
                this.f15032c.f15037e.expandGroup(this.f15031b, true);
            }
        }
    }
}
