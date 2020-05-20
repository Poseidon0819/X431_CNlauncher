package com.mopub.mraid;

import com.mopub.mobileads.ViewGestureDetector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MraidBridge.java */
/* renamed from: com.mopub.mraid.b */
/* loaded from: classes.dex */
public final class C3816b implements ViewGestureDetector.UserClickListener {

    /* renamed from: a */
    final /* synthetic */ MraidBridge f20710a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3816b(MraidBridge mraidBridge) {
        this.f20710a = mraidBridge;
    }

    @Override // com.mopub.mobileads.ViewGestureDetector.UserClickListener
    public final void onUserClick() {
        this.f20710a.f20652h = true;
    }

    @Override // com.mopub.mobileads.ViewGestureDetector.UserClickListener
    public final void onResetUserClick() {
        this.f20710a.f20652h = false;
    }

    @Override // com.mopub.mobileads.ViewGestureDetector.UserClickListener
    public final boolean wasClicked() {
        boolean z;
        z = this.f20710a.f20652h;
        return z;
    }
}
