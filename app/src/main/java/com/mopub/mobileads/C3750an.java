package com.mopub.mobileads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VastIconConfig.java */
/* renamed from: com.mopub.mobileads.an */
/* loaded from: classes.dex */
public final class C3750an implements UrlHandler.ResultActions {

    /* renamed from: a */
    final /* synthetic */ String f20528a;

    /* renamed from: b */
    final /* synthetic */ Context f20529b;

    /* renamed from: c */
    final /* synthetic */ VastIconConfig f20530c;

    @Override // com.mopub.common.UrlHandler.ResultActions
    public final void urlHandlingFailed(String str, UrlAction urlAction) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3750an(VastIconConfig vastIconConfig, String str, Context context) {
        this.f20530c = vastIconConfig;
        this.f20528a = str;
        this.f20529b = context;
    }

    @Override // com.mopub.common.UrlHandler.ResultActions
    public final void urlHandlingSucceeded(String str, UrlAction urlAction) {
        if (urlAction == UrlAction.OPEN_IN_APP_BROWSER) {
            Bundle bundle = new Bundle();
            bundle.putString(MoPubBrowser.DESTINATION_URL_KEY, str);
            if (!TextUtils.isEmpty(this.f20528a)) {
                bundle.putString(MoPubBrowser.DSP_CREATIVE_ID, this.f20528a);
            }
            try {
                Intents.startActivity(this.f20529b, Intents.getStartActivityIntent(this.f20529b, MoPubBrowser.class, bundle));
            } catch (IntentNotResolvableException e) {
                MoPubLog.m2498d(e.getMessage());
            }
        }
    }
}
