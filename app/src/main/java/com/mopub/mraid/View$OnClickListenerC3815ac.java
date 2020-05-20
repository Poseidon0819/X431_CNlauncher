package com.mopub.mraid;

import android.view.View;
import com.mopub.mobileads.BaseVideoViewController;

/* compiled from: MraidVideoViewController.java */
/* renamed from: com.mopub.mraid.ac */
/* loaded from: classes.dex */
final class View$OnClickListenerC3815ac implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MraidVideoViewController f20709a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC3815ac(MraidVideoViewController mraidVideoViewController) {
        this.f20709a = mraidVideoViewController;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        BaseVideoViewController.BaseVideoViewControllerListener baseVideoViewControllerListener;
        baseVideoViewControllerListener = this.f20709a.mBaseVideoViewControllerListener;
        baseVideoViewControllerListener.onFinish();
    }
}
