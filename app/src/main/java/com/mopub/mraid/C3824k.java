package com.mopub.mraid;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import com.mopub.common.CloseableLayout;
import com.mopub.mraid.MraidBridge;
import java.net.URI;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MraidController.java */
/* renamed from: com.mopub.mraid.k */
/* loaded from: classes.dex */
public final class C3824k implements MraidBridge.MraidBridgeListener {

    /* renamed from: a */
    final /* synthetic */ MraidController f20720a;

    @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
    public final void onExpand(URI uri, boolean z) {
    }

    @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
    public final void onPageFailedToLoad() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3824k(MraidController mraidController) {
        this.f20720a = mraidController;
    }

    @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
    public final void onPageLoaded() {
        MraidController mraidController = this.f20720a;
        mraidController.m2247a(new RunnableC3826m(mraidController));
    }

    @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
    public final void onVisibilityChanged(boolean z) {
        MraidBridge mraidBridge;
        MraidBridge mraidBridge2;
        mraidBridge = this.f20720a.f20673q;
        mraidBridge.m2264a(z);
        mraidBridge2 = this.f20720a.f20666j;
        mraidBridge2.m2264a(z);
    }

    @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
    public final boolean onJsAlert(String str, JsResult jsResult) {
        return this.f20720a.m2245a(str, jsResult);
    }

    @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.f20720a.m2251a(consoleMessage);
    }

    @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
    public final void onResize(int i, int i2, int i3, int i4, CloseableLayout.ClosePosition closePosition, boolean z) throws MraidCommandException {
        throw new MraidCommandException("Not allowed to resize from an expanded state");
    }

    @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
    public final void onClose() {
        this.f20720a.m2254a();
    }

    @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
    public final void onUseCustomClose(boolean z) {
        this.f20720a.m2244a(z);
    }

    @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
    public final void onSetOrientationProperties(boolean z, MraidOrientation mraidOrientation) throws MraidCommandException {
        this.f20720a.m2243a(z, mraidOrientation);
    }

    @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
    public final void onOpen(URI uri) {
        this.f20720a.m2240b(uri.toString());
    }

    @Override // com.mopub.mraid.MraidBridge.MraidBridgeListener
    public final void onPlayVideo(URI uri) {
        this.f20720a.m2246a(uri.toString());
    }
}
