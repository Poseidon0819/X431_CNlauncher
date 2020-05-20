package com.mopub.mraid;

import com.mopub.mraid.MraidNativeCommandHandler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MraidBridge.java */
/* renamed from: com.mopub.mraid.f */
/* loaded from: classes.dex */
public final class C3820f implements MraidNativeCommandHandler.InterfaceC3811c {

    /* renamed from: a */
    final /* synthetic */ MraidJavascriptCommand f20715a;

    /* renamed from: b */
    final /* synthetic */ MraidBridge f20716b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3820f(MraidBridge mraidBridge, MraidJavascriptCommand mraidJavascriptCommand) {
        this.f20716b = mraidBridge;
        this.f20715a = mraidJavascriptCommand;
    }

    @Override // com.mopub.mraid.MraidNativeCommandHandler.InterfaceC3811c
    public final void onFailure(MraidCommandException mraidCommandException) {
        this.f20716b.m2269a(this.f20715a, mraidCommandException.getMessage());
    }
}
