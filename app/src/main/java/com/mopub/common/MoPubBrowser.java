package com.mopub.common;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.mopub.common.event.BaseEvent;
import com.mopub.common.event.Event;
import com.mopub.common.event.MoPubEvents;
import com.mopub.common.util.Drawables;
import com.mopub.mobileads.BaseWebView;
import com.mopub.mobileads.util.WebViews;

/* loaded from: classes.dex */
public class MoPubBrowser extends Activity {
    public static final String DESTINATION_URL_KEY = "URL";
    public static final String DSP_CREATIVE_ID = "mopub-dsp-creative-id";
    public static final int MOPUB_BROWSER_REQUEST_CODE = 1;

    /* renamed from: a */
    private WebView f20082a;

    /* renamed from: b */
    private ImageButton f20083b;

    /* renamed from: c */
    private ImageButton f20084c;

    /* renamed from: d */
    private ImageButton f20085d;

    /* renamed from: e */
    private ImageButton f20086e;

    /* renamed from: f */
    private DoubleTimeTracker f20087f;

    /* renamed from: g */
    private String f20088g;

    public ImageButton getBackButton() {
        return this.f20083b;
    }

    public ImageButton getCloseButton() {
        return this.f20086e;
    }

    public ImageButton getForwardButton() {
        return this.f20084c;
    }

    public ImageButton getRefreshButton() {
        return this.f20085d;
    }

    public WebView getWebView() {
        return this.f20082a;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setResult(-1);
        getWindow().requestFeature(2);
        getWindow().setFeatureInt(2, -1);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(relativeLayout);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setBackgroundDrawable(Drawables.BACKGROUND.createDrawable(this));
        relativeLayout.addView(linearLayout2);
        this.f20083b = m2559a(Drawables.LEFT_ARROW.createDrawable(this));
        this.f20084c = m2559a(Drawables.RIGHT_ARROW.createDrawable(this));
        this.f20085d = m2559a(Drawables.REFRESH.createDrawable(this));
        this.f20086e = m2559a(Drawables.CLOSE.createDrawable(this));
        linearLayout2.addView(this.f20083b);
        linearLayout2.addView(this.f20084c);
        linearLayout2.addView(this.f20085d);
        linearLayout2.addView(this.f20086e);
        this.f20082a = new BaseWebView(this);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(2, 1);
        this.f20082a.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.f20082a);
        setContentView(linearLayout);
        this.f20087f = new DoubleTimeTracker();
        WebSettings settings = this.f20082a.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        this.f20088g = getIntent().getStringExtra(DSP_CREATIVE_ID);
        this.f20082a.loadUrl(getIntent().getStringExtra(DESTINATION_URL_KEY));
        this.f20082a.setWebViewClient(new BrowserWebViewClient(this));
        this.f20082a.setWebChromeClient(new C3693g(this));
        this.f20083b.setBackgroundColor(0);
        this.f20083b.setOnClickListener(new View$OnClickListenerC3694h(this));
        this.f20084c.setBackgroundColor(0);
        this.f20084c.setOnClickListener(new View$OnClickListenerC3695i(this));
        this.f20085d.setBackgroundColor(0);
        this.f20085d.setOnClickListener(new View$OnClickListenerC3696j(this));
        this.f20086e.setBackgroundColor(0);
        this.f20086e.setOnClickListener(new View$OnClickListenerC3697k(this));
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().startSync();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        CookieSyncManager.getInstance().stopSync();
        WebViews.onPause(this.f20082a, isFinishing());
        this.f20087f.pause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
        WebViews.onResume(this.f20082a);
        this.f20087f.start();
    }

    @Override // android.app.Activity
    public void finish() {
        ((ViewGroup) getWindow().getDecorView()).removeAllViews();
        super.finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f20082a.destroy();
        this.f20082a = null;
        MoPubEvents.log(new Event.Builder(BaseEvent.Name.AD_DWELL_TIME, BaseEvent.Category.AD_INTERACTIONS, BaseEvent.SamplingRate.AD_INTERACTIONS.getSamplingRate()).withDspCreativeId(this.f20088g).withPerformanceDurationMs(Double.valueOf(this.f20087f.getInterval())).build());
    }

    /* renamed from: a */
    private ImageButton m2559a(Drawable drawable) {
        ImageButton imageButton = new ImageButton(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
        layoutParams.gravity = 16;
        imageButton.setLayoutParams(layoutParams);
        imageButton.setImageDrawable(drawable);
        return imageButton;
    }
}
