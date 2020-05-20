package com.mopub.mobileads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.mopub.common.AdReport;
import com.mopub.common.DataKeys;
import com.mopub.common.IntentActions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.CustomEventInterstitial;
import com.mopub.mraid.MraidController;
import com.mopub.mraid.MraidWebViewDebugListener;
import com.mopub.mraid.PlacementType;
import com.mopub.network.Networking;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* loaded from: classes.dex */
public class MraidActivity extends BaseInterstitialActivity {

    /* renamed from: d */
    private MraidController f20382d;

    /* renamed from: e */
    private MraidWebViewDebugListener f20383e;

    public static void preRenderHtml(Context context, CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener, String str) {
        BaseWebView baseWebView = new BaseWebView(context);
        baseWebView.m2448a(false);
        baseWebView.m2449a();
        baseWebView.setWebViewClient(new C3744ad(customEventInterstitialListener));
        baseWebView.loadDataWithBaseURL(Networking.getBaseUrlScheme() + "://ads.mopub.com/", str, "text/html", "UTF-8", null);
    }

    @Override // com.mopub.mobileads.BaseInterstitialActivity
    public View getAdView() {
        String stringExtra = getIntent().getStringExtra(DataKeys.HTML_RESPONSE_BODY_KEY);
        if (stringExtra == null) {
            MoPubLog.m2490w("MraidActivity received a null HTML body. Finishing the activity.");
            finish();
            return new View(this);
        }
        this.f20382d = new MraidController(this, this.f20578a, PlacementType.INTERSTITIAL);
        this.f20382d.setDebugListener(this.f20383e);
        this.f20382d.setMraidListener(new C3745ae(this));
        this.f20382d.setUseCustomCloseListener(new C3746af(this));
        this.f20382d.loadContent(stringExtra);
        return this.f20382d.getAdContainer();
    }

    @Override // com.mopub.mobileads.BaseInterstitialActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventForwardingBroadcastReceiver.m2454a(this, this.f20580c.longValue(), IntentActions.ACTION_INTERSTITIAL_SHOW);
        if (Build.VERSION.SDK_INT >= 14) {
            getWindow().setFlags(16777216, 16777216);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        MraidController mraidController = this.f20382d;
        if (mraidController != null) {
            mraidController.pause(isFinishing());
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        MraidController mraidController = this.f20382d;
        if (mraidController != null) {
            mraidController.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseInterstitialActivity, android.app.Activity
    public void onDestroy() {
        MraidController mraidController = this.f20382d;
        if (mraidController != null) {
            mraidController.destroy();
        }
        EventForwardingBroadcastReceiver.m2454a(this, this.f20580c.longValue(), IntentActions.ACTION_INTERSTITIAL_DISMISS);
        super.onDestroy();
    }

    @VisibleForTesting
    public void setDebugListener(MraidWebViewDebugListener mraidWebViewDebugListener) {
        this.f20383e = mraidWebViewDebugListener;
        MraidController mraidController = this.f20382d;
        if (mraidController != null) {
            mraidController.setDebugListener(mraidWebViewDebugListener);
        }
    }

    public static void start(Context context, AdReport adReport, String str, long j) {
        Intent intent = new Intent(context, MraidActivity.class);
        intent.putExtra(DataKeys.HTML_RESPONSE_BODY_KEY, str);
        intent.putExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, j);
        intent.putExtra(DataKeys.AD_REPORT_KEY, adReport);
        intent.addFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Log.d("MraidInterstitial", "MraidActivity.class not found. Did you declare MraidActivity in your manifest?");
        }
    }
}
