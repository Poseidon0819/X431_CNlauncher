package com.cnlaunch.x431pro.activity.diagnose.p221d;

/* compiled from: MenuListFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.az */
/* loaded from: classes.dex */
final class C2135az extends Thread {

    /* renamed from: a */
    final /* synthetic */ MenuListFragment f12068a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2135az(MenuListFragment menuListFragment) {
        this.f12068a = menuListFragment;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MenuListFragment.m7212a(this.f12068a);
    }
}
