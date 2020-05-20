package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.IntentActions;
import com.mopub.mobileads.VastWebView;
import com.mopub.network.TrackingRequest;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VastVideoViewController.java */
/* renamed from: com.mopub.mobileads.bf */
/* loaded from: classes.dex */
public final class C3769bf implements VastWebView.InterfaceC3770a {

    /* renamed from: a */
    final /* synthetic */ VastCompanionAdConfig f20567a;

    /* renamed from: b */
    final /* synthetic */ Context f20568b;

    /* renamed from: c */
    final /* synthetic */ VastVideoViewController f20569c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3769bf(VastVideoViewController vastVideoViewController, VastCompanionAdConfig vastCompanionAdConfig, Context context) {
        this.f20569c = vastVideoViewController;
        this.f20567a = vastCompanionAdConfig;
        this.f20568b = context;
    }

    @Override // com.mopub.mobileads.VastWebView.InterfaceC3770a
    public final void onVastWebViewClick() {
        int i;
        VastVideoConfig vastVideoConfig;
        this.f20569c.m2450a(IntentActions.ACTION_INTERSTITIAL_CLICK);
        List<VastTracker> clickTrackers = this.f20567a.getClickTrackers();
        i = this.f20569c.f20455C;
        TrackingRequest.makeVastTrackingHttpRequest(clickTrackers, null, Integer.valueOf(i), null, this.f20568b);
        VastCompanionAdConfig vastCompanionAdConfig = this.f20567a;
        Context context = this.f20568b;
        vastVideoConfig = this.f20569c.f20466j;
        vastCompanionAdConfig.handleClick(context, 1, null, vastVideoConfig.getDspCreativeId());
    }
}
