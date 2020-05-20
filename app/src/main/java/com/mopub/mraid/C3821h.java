package com.mopub.mraid;

import com.mopub.common.CloseableLayout;

/* compiled from: MraidController.java */
/* renamed from: com.mopub.mraid.h */
/* loaded from: classes.dex */
final class C3821h implements CloseableLayout.OnCloseListener {

    /* renamed from: a */
    final /* synthetic */ MraidController f20717a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3821h(MraidController mraidController) {
        this.f20717a = mraidController;
    }

    @Override // com.mopub.common.CloseableLayout.OnCloseListener
    public final void onClose() {
        this.f20717a.m2254a();
    }
}
