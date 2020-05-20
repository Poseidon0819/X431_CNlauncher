package com.cnlaunch.x431pro.activity.mine;

/* compiled from: FirmwareFixFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.ag */
/* loaded from: classes.dex */
final class C2397ag extends Thread {

    /* renamed from: a */
    final /* synthetic */ HandlerC2396af f13647a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2397ag(HandlerC2396af handlerC2396af) {
        this.f13647a = handlerC2396af;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
