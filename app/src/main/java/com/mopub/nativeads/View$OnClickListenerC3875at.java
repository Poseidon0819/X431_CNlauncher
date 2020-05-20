package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;

/* compiled from: NativeVideoViewController.java */
/* renamed from: com.mopub.nativeads.at */
/* loaded from: classes2.dex */
final class View$OnClickListenerC3875at implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ NativeVideoViewController f21083a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC3875at(NativeVideoViewController nativeVideoViewController) {
        this.f21083a = nativeVideoViewController;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        NativeVideoController nativeVideoController;
        NativeFullScreenVideoView nativeFullScreenVideoView;
        Context context;
        nativeVideoController = this.f21083a.f20990d;
        nativeVideoController.setPlayWhenReady(false);
        NativeVideoViewController nativeVideoViewController = this.f21083a;
        nativeFullScreenVideoView = nativeVideoViewController.f20989c;
        nativeVideoViewController.f20991e = nativeFullScreenVideoView.getTextureView().getBitmap();
        UrlHandler build = new UrlHandler.Builder().withSupportedUrlActions(UrlAction.OPEN_IN_APP_BROWSER, new UrlAction[0]).build();
        context = this.f21083a.mContext;
        build.handleUrl(context, "https://www.mopub.com/optout/");
    }
}
