package com.mopub.mraid;

import com.mopub.common.VisibleForTesting;
import com.mopub.mobileads.CustomEventBanner;

/* loaded from: classes.dex */
class MraidBanner extends CustomEventBanner {

    /* renamed from: a */
    private MraidController f20643a;

    /* renamed from: b */
    private MraidWebViewDebugListener f20644b;

    MraidBanner() {
    }

    @Override // com.mopub.mobileads.CustomEventBanner
    public final void onInvalidate() {
        MraidController mraidController = this.f20643a;
        if (mraidController != null) {
            mraidController.setMraidListener(null);
            this.f20643a.destroy();
        }
    }

    @VisibleForTesting
    public void setDebugListener(MraidWebViewDebugListener mraidWebViewDebugListener) {
        this.f20644b = mraidWebViewDebugListener;
        MraidController mraidController = this.f20643a;
        if (mraidController != null) {
            mraidController.setDebugListener(mraidWebViewDebugListener);
        }
    }
}
