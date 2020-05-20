package com.mopub.mobileads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.mopub.common.AdReport;
import com.mopub.common.CreativeOrientation;
import com.mopub.common.DataKeys;
import com.mopub.common.IntentActions;
import com.mopub.common.util.DeviceUtils;
import com.mopub.mobileads.BaseInterstitialActivity;
import com.mopub.mobileads.CustomEventInterstitial;
import com.mopub.mobileads.factories.HtmlInterstitialWebViewFactory;
import java.io.Serializable;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* loaded from: classes.dex */
public class MoPubActivity extends BaseInterstitialActivity {

    /* renamed from: d */
    private HtmlInterstitialWebView f20338d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m2440a(Context context, AdReport adReport, CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener, String str) {
        HtmlInterstitialWebView create = HtmlInterstitialWebViewFactory.create(context, adReport, customEventInterstitialListener, false, null, null);
        create.m2448a(false);
        create.m2449a();
        create.setWebViewClient(new C3781l(customEventInterstitialListener));
        create.m2452a(str);
    }

    @Override // com.mopub.mobileads.BaseInterstitialActivity
    public View getAdView() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(DataKeys.SCROLLABLE_KEY, false);
        String stringExtra = intent.getStringExtra(DataKeys.REDIRECT_URL_KEY);
        String stringExtra2 = intent.getStringExtra(DataKeys.CLICKTHROUGH_URL_KEY);
        String stringExtra3 = intent.getStringExtra(DataKeys.HTML_RESPONSE_BODY_KEY);
        this.f20338d = HtmlInterstitialWebViewFactory.create(getApplicationContext(), this.f20578a, new C3724a(), booleanExtra, stringExtra, stringExtra2);
        this.f20338d.m2452a(stringExtra3);
        return this.f20338d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseInterstitialActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        CreativeOrientation creativeOrientation;
        super.onCreate(bundle);
        Serializable serializableExtra = getIntent().getSerializableExtra(DataKeys.CREATIVE_ORIENTATION_KEY);
        if (serializableExtra == null || !(serializableExtra instanceof CreativeOrientation)) {
            creativeOrientation = CreativeOrientation.UNDEFINED;
        } else {
            creativeOrientation = (CreativeOrientation) serializableExtra;
        }
        DeviceUtils.lockOrientation(this, creativeOrientation);
        EventForwardingBroadcastReceiver.m2454a(this, this.f20580c.longValue(), IntentActions.ACTION_INTERSTITIAL_SHOW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseInterstitialActivity, android.app.Activity
    public void onDestroy() {
        this.f20338d.loadUrl(BaseInterstitialActivity.EnumC3774a.WEB_VIEW_DID_CLOSE.getUrl());
        this.f20338d.destroy();
        EventForwardingBroadcastReceiver.m2454a(this, this.f20580c.longValue(), IntentActions.ACTION_INTERSTITIAL_DISMISS);
        super.onDestroy();
    }

    /* renamed from: com.mopub.mobileads.MoPubActivity$a */
    /* loaded from: classes.dex */
    class C3724a implements CustomEventInterstitial.CustomEventInterstitialListener {
        @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
        public final void onInterstitialDismissed() {
        }

        @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
        public final void onInterstitialShown() {
        }

        @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
        public final void onLeaveApplication() {
        }

        C3724a() {
        }

        @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
        public final void onInterstitialLoaded() {
            MoPubActivity.this.f20338d.loadUrl(BaseInterstitialActivity.EnumC3774a.WEB_VIEW_DID_APPEAR.getUrl());
        }

        @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
        public final void onInterstitialFailed(MoPubErrorCode moPubErrorCode) {
            MoPubActivity moPubActivity = MoPubActivity.this;
            EventForwardingBroadcastReceiver.m2454a(moPubActivity, moPubActivity.f20580c.longValue(), IntentActions.ACTION_INTERSTITIAL_FAIL);
            MoPubActivity.this.finish();
        }

        @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
        public final void onInterstitialClicked() {
            MoPubActivity moPubActivity = MoPubActivity.this;
            EventForwardingBroadcastReceiver.m2454a(moPubActivity, moPubActivity.f20580c.longValue(), IntentActions.ACTION_INTERSTITIAL_CLICK);
        }
    }

    public static void start(Context context, String str, AdReport adReport, boolean z, String str2, String str3, CreativeOrientation creativeOrientation, long j) {
        Intent intent = new Intent(context, MoPubActivity.class);
        intent.putExtra(DataKeys.HTML_RESPONSE_BODY_KEY, str);
        intent.putExtra(DataKeys.SCROLLABLE_KEY, z);
        intent.putExtra(DataKeys.CLICKTHROUGH_URL_KEY, str3);
        intent.putExtra(DataKeys.REDIRECT_URL_KEY, str2);
        intent.putExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, j);
        intent.putExtra(DataKeys.AD_REPORT_KEY, adReport);
        intent.putExtra(DataKeys.CREATIVE_ORIENTATION_KEY, creativeOrientation);
        intent.addFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Log.d("MoPubActivity", "MoPubActivity not found - did you declare it in AndroidManifest.xml?");
        }
    }
}
