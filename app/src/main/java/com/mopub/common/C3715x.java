package com.mopub.common;

import android.content.Context;
import com.mopub.common.UrlResolutionTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UrlHandler.java */
/* renamed from: com.mopub.common.x */
/* loaded from: classes.dex */
public final class C3715x implements UrlResolutionTask.InterfaceC3684a {

    /* renamed from: a */
    final /* synthetic */ Context f20245a;

    /* renamed from: b */
    final /* synthetic */ boolean f20246b;

    /* renamed from: c */
    final /* synthetic */ Iterable f20247c;

    /* renamed from: d */
    final /* synthetic */ String f20248d;

    /* renamed from: e */
    final /* synthetic */ UrlHandler f20249e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3715x(UrlHandler urlHandler, Context context, boolean z, Iterable iterable, String str) {
        this.f20249e = urlHandler;
        this.f20245a = context;
        this.f20246b = z;
        this.f20247c = iterable;
        this.f20248d = str;
    }

    @Override // com.mopub.common.UrlResolutionTask.InterfaceC3684a
    public final void onSuccess(String str) {
        UrlHandler.m2544a(this.f20249e);
        this.f20249e.handleResolvedUrl(this.f20245a, str, this.f20246b, this.f20247c);
    }

    @Override // com.mopub.common.UrlResolutionTask.InterfaceC3684a
    public final void onFailure(String str, Throwable th) {
        UrlHandler.m2544a(this.f20249e);
        this.f20249e.m2542a(this.f20248d, (UrlAction) null, str, th);
    }
}
