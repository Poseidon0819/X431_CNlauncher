package com.cnlaunch.x431pro.activity.diagnose.p221d;

/* compiled from: MenuListFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.ba */
/* loaded from: classes.dex */
final class C2137ba extends Thread {

    /* renamed from: a */
    final /* synthetic */ MenuListFragment f12070a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2137ba(MenuListFragment menuListFragment) {
        this.f12070a = menuListFragment;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MenuListFragment.m7212a(this.f12070a);
    }
}
