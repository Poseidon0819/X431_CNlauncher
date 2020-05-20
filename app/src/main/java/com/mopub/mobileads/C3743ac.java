package com.mopub.mobileads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.mopub.common.util.Visibility;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoPubView.java */
/* renamed from: com.mopub.mobileads.ac */
/* loaded from: classes.dex */
public final class C3743ac extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ MoPubView f20505a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3743ac(MoPubView moPubView) {
        this.f20505a = moPubView;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int i;
        i = this.f20505a.f20380f;
        if (!Visibility.isScreenVisible(i) || intent == null) {
            return;
        }
        String action = intent.getAction();
        if ("android.intent.action.USER_PRESENT".equals(action)) {
            this.f20505a.setAdVisibility(0);
        } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
            this.f20505a.setAdVisibility(8);
        }
    }
}
