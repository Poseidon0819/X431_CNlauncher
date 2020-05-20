package com.mopub.nativeads;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/* compiled from: NativeVideoViewController.java */
/* renamed from: com.mopub.nativeads.as */
/* loaded from: classes2.dex */
final class View$OnClickListenerC3874as implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ NativeVideoViewController f21082a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC3874as(NativeVideoViewController nativeVideoViewController) {
        this.f21082a = nativeVideoViewController;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        NativeVideoController nativeVideoController;
        NativeFullScreenVideoView nativeFullScreenVideoView;
        NativeVideoController nativeVideoController2;
        Context context;
        nativeVideoController = this.f21082a.f20990d;
        nativeVideoController.setPlayWhenReady(false);
        NativeVideoViewController nativeVideoViewController = this.f21082a;
        nativeFullScreenVideoView = nativeVideoViewController.f20989c;
        nativeVideoViewController.f20991e = nativeFullScreenVideoView.getTextureView().getBitmap();
        nativeVideoController2 = this.f21082a.f20990d;
        context = this.f21082a.mContext;
        nativeVideoController2.handleCtaClick((Activity) context);
    }
}
