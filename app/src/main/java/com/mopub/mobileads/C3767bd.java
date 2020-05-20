package com.mopub.mobileads;

import android.content.Context;
import com.mopub.mobileads.VastWebView;
import com.mopub.network.TrackingRequest;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VastVideoViewController.java */
/* renamed from: com.mopub.mobileads.bd */
/* loaded from: classes.dex */
public final class C3767bd implements VastWebView.InterfaceC3770a {

    /* renamed from: a */
    final /* synthetic */ VastIconConfig f20562a;

    /* renamed from: b */
    final /* synthetic */ Context f20563b;

    /* renamed from: c */
    final /* synthetic */ VastVideoViewController f20564c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3767bd(VastVideoViewController vastVideoViewController, VastIconConfig vastIconConfig, Context context) {
        this.f20564c = vastVideoViewController;
        this.f20562a = vastIconConfig;
        this.f20563b = context;
    }

    @Override // com.mopub.mobileads.VastWebView.InterfaceC3770a
    public final void onVastWebViewClick() {
        VastVideoConfig vastVideoConfig;
        TrackingRequest.makeVastTrackingHttpRequest(this.f20562a.getClickTrackingUris(), null, Integer.valueOf(this.f20564c.f20457a.getCurrentPosition()), this.f20564c.m2360b(), this.f20563b);
        VastIconConfig vastIconConfig = this.f20562a;
        Context context = this.f20564c.mContext;
        vastVideoConfig = this.f20564c.f20466j;
        vastIconConfig.handleClick(context, null, vastVideoConfig.getDspCreativeId());
    }
}
