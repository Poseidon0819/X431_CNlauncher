package com.mopub.nativeads;

import android.view.View;
import com.mopub.nativeads.VisibilityTracker;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoPubRecyclerAdapter.java */
/* renamed from: com.mopub.nativeads.x */
/* loaded from: classes2.dex */
public final class C3905x implements VisibilityTracker.InterfaceC3884d {

    /* renamed from: a */
    final /* synthetic */ MoPubRecyclerAdapter f21171a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3905x(MoPubRecyclerAdapter moPubRecyclerAdapter) {
        this.f21171a = moPubRecyclerAdapter;
    }

    @Override // com.mopub.nativeads.VisibilityTracker.InterfaceC3884d
    public final void onVisibilityChanged(List<View> list, List<View> list2) {
        MoPubRecyclerAdapter.m2138a(this.f21171a, list);
    }
}
