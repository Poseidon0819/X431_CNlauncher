package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.VastManager;
import com.mopub.mobileads.VideoDownloader;

/* compiled from: VastManager.java */
/* renamed from: com.mopub.mobileads.ar */
/* loaded from: classes.dex */
final class C3751ar implements VideoDownloader.InterfaceC3738a {

    /* renamed from: a */
    final /* synthetic */ VastVideoConfig f20533a;

    /* renamed from: b */
    final /* synthetic */ VastManager f20534b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3751ar(VastManager vastManager, VastVideoConfig vastVideoConfig) {
        this.f20534b = vastManager;
        this.f20533a = vastVideoConfig;
    }

    @Override // com.mopub.mobileads.VideoDownloader.InterfaceC3738a
    public final void onComplete(boolean z) {
        VastManager.VastManagerListener vastManagerListener;
        boolean m2378b;
        VastManager.VastManagerListener vastManagerListener2;
        if (z) {
            m2378b = VastManager.m2378b(this.f20533a);
            if (m2378b) {
                vastManagerListener2 = this.f20534b.f20410a;
                vastManagerListener2.onVastVideoConfigurationPrepared(this.f20533a);
                return;
            }
        }
        MoPubLog.m2498d("Failed to download VAST video.");
        vastManagerListener = this.f20534b.f20410a;
        vastManagerListener.onVastVideoConfigurationPrepared(null);
    }
}
