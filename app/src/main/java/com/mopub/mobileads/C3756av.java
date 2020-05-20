package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VastVideoConfig.java */
/* renamed from: com.mopub.mobileads.av */
/* loaded from: classes.dex */
public final class C3756av implements UrlHandler.ResultActions {

    /* renamed from: a */
    final /* synthetic */ Context f20543a;

    /* renamed from: b */
    final /* synthetic */ Integer f20544b;

    /* renamed from: c */
    final /* synthetic */ VastVideoConfig f20545c;

    @Override // com.mopub.common.UrlHandler.ResultActions
    public final void urlHandlingFailed(String str, UrlAction urlAction) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3756av(VastVideoConfig vastVideoConfig, Context context, Integer num) {
        this.f20545c = vastVideoConfig;
        this.f20543a = context;
        this.f20544b = num;
    }

    @Override // com.mopub.common.UrlHandler.ResultActions
    public final void urlHandlingSucceeded(String str, UrlAction urlAction) {
        String str2;
        if (urlAction == UrlAction.OPEN_IN_APP_BROWSER) {
            Bundle bundle = new Bundle();
            bundle.putString(MoPubBrowser.DESTINATION_URL_KEY, str);
            str2 = this.f20545c.mDspCreativeId;
            bundle.putString(MoPubBrowser.DSP_CREATIVE_ID, str2);
            Intent startActivityIntent = Intents.getStartActivityIntent(this.f20543a, MoPubBrowser.class, bundle);
            try {
                if (this.f20543a instanceof Activity) {
                    Preconditions.checkNotNull(this.f20544b);
                    ((Activity) this.f20543a).startActivityForResult(startActivityIntent, this.f20544b.intValue());
                    return;
                }
                Intents.startActivity(this.f20543a, startActivityIntent);
            } catch (ActivityNotFoundException unused) {
                MoPubLog.m2498d("Activity " + MoPubBrowser.class.getName() + " not found. Did you declare it in your AndroidManifest.xml?");
            } catch (IntentNotResolvableException unused2) {
                MoPubLog.m2498d("Activity " + MoPubBrowser.class.getName() + " not found. Did you declare it in your AndroidManifest.xml?");
            }
        }
    }
}
