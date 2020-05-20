package com.mopub.mobileads;

import android.view.View;
import com.mopub.common.IntentActions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.BaseInterstitialActivity;
import com.mopub.mraid.MraidController;

/* compiled from: MraidActivity.java */
/* renamed from: com.mopub.mobileads.ae */
/* loaded from: classes.dex */
final class C3745ae implements MraidController.MraidListener {

    /* renamed from: a */
    final /* synthetic */ MraidActivity f20507a;

    @Override // com.mopub.mraid.MraidController.MraidListener
    public final void onExpand() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3745ae(MraidActivity mraidActivity) {
        this.f20507a = mraidActivity;
    }

    @Override // com.mopub.mraid.MraidController.MraidListener
    public final void onLoaded(View view) {
        MraidController mraidController;
        mraidController = this.f20507a.f20382d;
        mraidController.loadJavascript(BaseInterstitialActivity.EnumC3774a.WEB_VIEW_DID_APPEAR.getJavascript());
    }

    @Override // com.mopub.mraid.MraidController.MraidListener
    public final void onFailedToLoad() {
        MoPubLog.m2498d("MraidActivity failed to load. Finishing the activity");
        MraidActivity mraidActivity = this.f20507a;
        EventForwardingBroadcastReceiver.m2454a(mraidActivity, mraidActivity.f20580c.longValue(), IntentActions.ACTION_INTERSTITIAL_FAIL);
        this.f20507a.finish();
    }

    @Override // com.mopub.mraid.MraidController.MraidListener
    public final void onClose() {
        MraidController mraidController;
        mraidController = this.f20507a.f20382d;
        mraidController.loadJavascript(BaseInterstitialActivity.EnumC3774a.WEB_VIEW_DID_CLOSE.getJavascript());
        this.f20507a.finish();
    }

    @Override // com.mopub.mraid.MraidController.MraidListener
    public final void onOpen() {
        MraidActivity mraidActivity = this.f20507a;
        EventForwardingBroadcastReceiver.m2454a(mraidActivity, mraidActivity.f20580c.longValue(), IntentActions.ACTION_INTERSTITIAL_CLICK);
    }
}
