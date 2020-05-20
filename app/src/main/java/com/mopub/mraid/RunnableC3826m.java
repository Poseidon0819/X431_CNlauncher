package com.mopub.mraid;

import android.content.Context;

/* compiled from: MraidController.java */
/* renamed from: com.mopub.mraid.m */
/* loaded from: classes.dex */
final class RunnableC3826m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ MraidController f20722a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC3826m(MraidController mraidController) {
        this.f20722a = mraidController;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MraidBridge mraidBridge;
        Context context;
        Context context2;
        Context context3;
        Context context4;
        MraidBridge mraidBridge2;
        ViewState viewState;
        MraidBridge mraidBridge3;
        PlacementType placementType;
        MraidBridge mraidBridge4;
        MraidBridge mraidBridge5;
        MraidBridge mraidBridge6;
        MraidNativeCommandHandler unused;
        MraidNativeCommandHandler unused2;
        MraidNativeCommandHandler unused3;
        MraidNativeCommandHandler unused4;
        mraidBridge = this.f20722a.f20666j;
        unused = this.f20722a.f20678v;
        context = this.f20722a.f20657a;
        boolean m2217b = MraidNativeCommandHandler.m2217b(context);
        unused2 = this.f20722a.f20678v;
        context2 = this.f20722a.f20657a;
        boolean m2221a = MraidNativeCommandHandler.m2221a(context2);
        unused3 = this.f20722a.f20678v;
        context3 = this.f20722a.f20657a;
        boolean m2215c = MraidNativeCommandHandler.m2215c(context3);
        unused4 = this.f20722a.f20678v;
        context4 = this.f20722a.f20657a;
        mraidBridge.m2263a(m2217b, m2221a, m2215c, MraidNativeCommandHandler.isStorePictureSupported(context4), MraidController.m2232f(this.f20722a));
        mraidBridge2 = this.f20722a.f20666j;
        viewState = this.f20722a.f20662f;
        mraidBridge2.m2267a(viewState);
        mraidBridge3 = this.f20722a.f20666j;
        placementType = this.f20722a.f20658b;
        mraidBridge3.m2268a(placementType);
        mraidBridge4 = this.f20722a.f20666j;
        mraidBridge5 = this.f20722a.f20666j;
        mraidBridge4.m2264a(mraidBridge5.m2276a());
        mraidBridge6 = this.f20722a.f20666j;
        mraidBridge6.m2266a("mraidbridge.notifyReadyEvent();");
    }
}
