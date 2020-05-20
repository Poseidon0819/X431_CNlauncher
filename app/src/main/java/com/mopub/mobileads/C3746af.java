package com.mopub.mobileads;

import com.mopub.mraid.MraidController;

/* compiled from: MraidActivity.java */
/* renamed from: com.mopub.mobileads.af */
/* loaded from: classes.dex */
final class C3746af implements MraidController.UseCustomCloseListener {

    /* renamed from: a */
    final /* synthetic */ MraidActivity f20508a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3746af(MraidActivity mraidActivity) {
        this.f20508a = mraidActivity;
    }

    @Override // com.mopub.mraid.MraidController.UseCustomCloseListener
    public final void useCustomCloseChanged(boolean z) {
        if (z) {
            this.f20508a.f20579b.setCloseVisible(false);
        } else {
            this.f20508a.f20579b.setCloseVisible(true);
        }
    }
}
