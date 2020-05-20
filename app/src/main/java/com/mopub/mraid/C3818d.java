package com.mopub.mraid;

import com.mopub.mraid.MraidBridge;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MraidBridge.java */
/* renamed from: com.mopub.mraid.d */
/* loaded from: classes.dex */
public final class C3818d implements MraidBridge.MraidWebView.OnVisibilityChangedListener {

    /* renamed from: a */
    final /* synthetic */ MraidBridge f20713a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3818d(MraidBridge mraidBridge) {
        this.f20713a = mraidBridge;
    }

    @Override // com.mopub.mraid.MraidBridge.MraidWebView.OnVisibilityChangedListener
    public final void onVisibilityChanged(boolean z) {
        MraidBridge.MraidBridgeListener mraidBridgeListener;
        MraidBridge.MraidBridgeListener mraidBridgeListener2;
        mraidBridgeListener = this.f20713a.f20645a;
        if (mraidBridgeListener != null) {
            mraidBridgeListener2 = this.f20713a.f20645a;
            mraidBridgeListener2.onVisibilityChanged(z);
        }
    }
}
