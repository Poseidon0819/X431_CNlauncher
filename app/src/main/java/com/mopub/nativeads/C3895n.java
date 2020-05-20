package com.mopub.nativeads;

import android.view.View;
import com.mopub.nativeads.MoPubCustomEventVideoNative;
import com.mopub.nativeads.VisibilityTracker;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoPubCustomEventVideoNative.java */
/* renamed from: com.mopub.nativeads.n */
/* loaded from: classes2.dex */
public final class C3895n implements VisibilityTracker.InterfaceC3884d {

    /* renamed from: a */
    final /* synthetic */ MoPubCustomEventVideoNative.MoPubVideoNativeAd f21161a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3895n(MoPubCustomEventVideoNative.MoPubVideoNativeAd moPubVideoNativeAd) {
        this.f21161a = moPubVideoNativeAd;
    }

    @Override // com.mopub.nativeads.VisibilityTracker.InterfaceC3884d
    public final void onVisibilityChanged(List<View> list, List<View> list2) {
        boolean z;
        boolean z2;
        if (!list.isEmpty()) {
            z2 = this.f21161a.f20853x;
            if (!z2) {
                this.f21161a.f20853x = true;
                this.f21161a.m2159e();
                return;
            }
        }
        if (list2.isEmpty()) {
            return;
        }
        z = this.f21161a.f20853x;
        if (z) {
            this.f21161a.f20853x = false;
            this.f21161a.m2159e();
        }
    }
}
