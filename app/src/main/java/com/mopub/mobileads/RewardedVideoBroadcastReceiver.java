package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.mopub.common.IntentActions;
import com.mopub.mobileads.RewardedVastVideoInterstitial;

/* loaded from: classes.dex */
public class RewardedVideoBroadcastReceiver extends BaseBroadcastReceiver {

    /* renamed from: a */
    private static IntentFilter f20394a;

    /* renamed from: b */
    private RewardedVastVideoInterstitial.InterfaceC3734a f20395b;

    public RewardedVideoBroadcastReceiver(RewardedVastVideoInterstitial.InterfaceC3734a interfaceC3734a, long j) {
        super(j);
        this.f20395b = interfaceC3734a;
        getIntentFilter();
    }

    @Override // com.mopub.mobileads.BaseBroadcastReceiver
    public IntentFilter getIntentFilter() {
        if (f20394a == null) {
            IntentFilter intentFilter = new IntentFilter();
            f20394a = intentFilter;
            intentFilter.addAction(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
        }
        return f20394a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f20395b != null && shouldConsumeBroadcast(intent) && IntentActions.ACTION_REWARDED_VIDEO_COMPLETE.equals(intent.getAction())) {
            this.f20395b.onVideoComplete();
            unregister(this);
        }
    }
}
