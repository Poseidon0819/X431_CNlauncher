package com.mopub.mobileads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.mopub.common.AdReport;
import com.mopub.common.CloseableLayout;
import com.mopub.common.DataKeys;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.mobileads.e */
/* loaded from: classes.dex */
public abstract class BaseInterstitialActivity extends Activity {

    /* renamed from: a */
    protected AdReport f20578a;

    /* renamed from: b */
    CloseableLayout f20579b;

    /* renamed from: c */
    Long f20580c;

    public abstract View getAdView();

    /* compiled from: BaseInterstitialActivity.java */
    /* renamed from: com.mopub.mobileads.e$a */
    /* loaded from: classes.dex */
    enum EnumC3774a {
        WEB_VIEW_DID_APPEAR("webviewDidAppear();"),
        WEB_VIEW_DID_CLOSE("webviewDidClose();");
        
        private String mJavascript;

        EnumC3774a(String str) {
            this.mJavascript = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final String getJavascript() {
            return this.mJavascript;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final String getUrl() {
            return "javascript:" + this.mJavascript;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.f20580c = intent.hasExtra(DataKeys.BROADCAST_IDENTIFIER_KEY) ? Long.valueOf(intent.getLongExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, -1L)) : null;
        this.f20578a = m2281a(intent);
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        View adView = getAdView();
        this.f20579b = new CloseableLayout(this);
        this.f20579b.setOnCloseListener(new C3775f(this));
        this.f20579b.addView(adView, new FrameLayout.LayoutParams(-1, -1));
        setContentView(this.f20579b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        this.f20579b.removeAllViews();
        super.onDestroy();
    }

    /* renamed from: a */
    private static AdReport m2281a(Intent intent) {
        try {
            return (AdReport) intent.getSerializableExtra(DataKeys.AD_REPORT_KEY);
        } catch (ClassCastException unused) {
            return null;
        }
    }
}
