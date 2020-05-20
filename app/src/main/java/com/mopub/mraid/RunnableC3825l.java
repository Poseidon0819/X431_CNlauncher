package com.mopub.mraid;

import android.content.Context;

/* compiled from: MraidController.java */
/* renamed from: com.mopub.mraid.l */
/* loaded from: classes.dex */
final class RunnableC3825l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ MraidController f20721a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC3825l(MraidController mraidController) {
        this.f20721a = mraidController;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MraidBridge mraidBridge;
        Context context;
        Context context2;
        Context context3;
        Context context4;
        MraidBridge mraidBridge2;
        PlacementType placementType;
        MraidBridge mraidBridge3;
        MraidBridge mraidBridge4;
        MraidBridge mraidBridge5;
        MraidNativeCommandHandler unused;
        MraidNativeCommandHandler unused2;
        mraidBridge = this.f20721a.f20673q;
        unused = this.f20721a.f20678v;
        context = this.f20721a.f20657a;
        boolean m2217b = MraidNativeCommandHandler.m2217b(context);
        unused2 = this.f20721a.f20678v;
        context2 = this.f20721a.f20657a;
        boolean m2221a = MraidNativeCommandHandler.m2221a(context2);
        context3 = this.f20721a.f20657a;
        boolean m2215c = MraidNativeCommandHandler.m2215c(context3);
        context4 = this.f20721a.f20657a;
        mraidBridge.m2263a(m2217b, m2221a, m2215c, MraidNativeCommandHandler.isStorePictureSupported(context4), MraidController.m2232f(this.f20721a));
        mraidBridge2 = this.f20721a.f20673q;
        placementType = this.f20721a.f20658b;
        mraidBridge2.m2268a(placementType);
        mraidBridge3 = this.f20721a.f20673q;
        mraidBridge4 = this.f20721a.f20673q;
        mraidBridge3.m2264a(mraidBridge4.m2276a());
        mraidBridge5 = this.f20721a.f20673q;
        mraidBridge5.m2266a("mraidbridge.notifyReadyEvent();");
    }
}
