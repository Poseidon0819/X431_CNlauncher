package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VastCompanionAdConfig.java */
/* renamed from: com.mopub.mobileads.ak */
/* loaded from: classes.dex */
public final class C3749ak implements UrlHandler.ResultActions {

    /* renamed from: a */
    final /* synthetic */ String f20522a;

    /* renamed from: b */
    final /* synthetic */ Context f20523b;

    /* renamed from: c */
    final /* synthetic */ int f20524c;

    /* renamed from: d */
    final /* synthetic */ VastCompanionAdConfig f20525d;

    @Override // com.mopub.common.UrlHandler.ResultActions
    public final void urlHandlingFailed(String str, UrlAction urlAction) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3749ak(VastCompanionAdConfig vastCompanionAdConfig, String str, Context context, int i) {
        this.f20525d = vastCompanionAdConfig;
        this.f20522a = str;
        this.f20523b = context;
        this.f20524c = i;
    }

    @Override // com.mopub.common.UrlHandler.ResultActions
    public final void urlHandlingSucceeded(String str, UrlAction urlAction) {
        if (urlAction == UrlAction.OPEN_IN_APP_BROWSER) {
            Bundle bundle = new Bundle();
            bundle.putString(MoPubBrowser.DESTINATION_URL_KEY, str);
            if (!TextUtils.isEmpty(this.f20522a)) {
                bundle.putString(MoPubBrowser.DSP_CREATIVE_ID, this.f20522a);
            }
            try {
                ((Activity) this.f20523b).startActivityForResult(Intents.getStartActivityIntent(this.f20523b, MoPubBrowser.class, bundle), this.f20524c);
            } catch (ActivityNotFoundException unused) {
                MoPubLog.m2498d("Activity " + MoPubBrowser.class.getName() + " not found. Did you declare it in your AndroidManifest.xml?");
            }
        }
    }
}
