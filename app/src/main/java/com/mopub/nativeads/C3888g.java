package com.mopub.nativeads;

import android.view.View;
import com.mopub.nativeads.VisibilityTracker;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoPubAdAdapter.java */
/* renamed from: com.mopub.nativeads.g */
/* loaded from: classes2.dex */
public final class C3888g implements VisibilityTracker.InterfaceC3884d {

    /* renamed from: a */
    final /* synthetic */ MoPubAdAdapter f21151a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3888g(MoPubAdAdapter moPubAdAdapter) {
        this.f21151a = moPubAdAdapter;
    }

    @Override // com.mopub.nativeads.VisibilityTracker.InterfaceC3884d
    public final void onVisibilityChanged(List<View> list, List<View> list2) {
        MoPubAdAdapter.m2180a(this.f21151a, list);
    }
}
