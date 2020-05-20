package com.mopub.mobileads;

import com.mopub.network.AdRequest;
import com.mopub.network.AdResponse;
import com.mopub.volley.VolleyError;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdViewController.java */
/* renamed from: com.mopub.mobileads.a */
/* loaded from: classes.dex */
public final class C3740a implements AdRequest.Listener {

    /* renamed from: a */
    final /* synthetic */ AdViewController f20502a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3740a(AdViewController adViewController) {
        this.f20502a = adViewController;
    }

    @Override // com.mopub.network.AdRequest.Listener
    public final void onSuccess(AdResponse adResponse) {
        this.f20502a.m2466a(adResponse);
    }

    @Override // com.mopub.volley.Response.ErrorListener
    public final void onErrorResponse(VolleyError volleyError) {
        this.f20502a.m2465a(volleyError);
    }
}
