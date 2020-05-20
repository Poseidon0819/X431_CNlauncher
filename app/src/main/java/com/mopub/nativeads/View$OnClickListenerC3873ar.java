package com.mopub.nativeads;

import android.view.View;
import com.mopub.mobileads.BaseVideoViewController;
import com.mopub.nativeads.NativeVideoViewController;

/* compiled from: NativeVideoViewController.java */
/* renamed from: com.mopub.nativeads.ar */
/* loaded from: classes2.dex */
final class View$OnClickListenerC3873ar implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ NativeVideoViewController f21081a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC3873ar(NativeVideoViewController nativeVideoViewController) {
        this.f21081a = nativeVideoViewController;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        BaseVideoViewController.BaseVideoViewControllerListener baseVideoViewControllerListener;
        this.f21081a.m2113a(NativeVideoViewController.EnumC3856a.PAUSED, true);
        baseVideoViewControllerListener = this.f21081a.mBaseVideoViewControllerListener;
        baseVideoViewControllerListener.onFinish();
    }
}
