package com.cnlaunch.x431pro.activity.upgrade.p238a;

import android.view.View;

/* compiled from: UpgradeAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.a.n */
/* loaded from: classes.dex */
final class View$OnClickListenerC2617n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f15056a;

    /* renamed from: b */
    final /* synthetic */ int f15057b;

    /* renamed from: c */
    final /* synthetic */ UpgradeAdapter f15058c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2617n(UpgradeAdapter upgradeAdapter, boolean z, int i) {
        this.f15058c = upgradeAdapter;
        this.f15056a = z;
        this.f15057b = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f15058c.f15037e != null) {
            if (this.f15056a) {
                this.f15058c.f15037e.collapseGroup(this.f15057b);
            } else {
                this.f15058c.f15037e.expandGroup(this.f15057b, true);
            }
        }
    }
}
