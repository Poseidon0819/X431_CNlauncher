package com.mopub.mobileads;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.mopub.common.Preconditions;
import com.mopub.common.util.Utils;
import com.mopub.common.util.VersionCode;
import com.mopub.network.Networking;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.mobileads.bg */
/* loaded from: classes.dex */
public final class VastWebView extends BaseWebView {

    /* renamed from: b */
    InterfaceC3770a f20570b;

    /* compiled from: VastWebView.java */
    /* renamed from: com.mopub.mobileads.bg$a */
    /* loaded from: classes.dex */
    interface InterfaceC3770a {
        void onVastWebViewClick();
    }

    private VastWebView(Context context) {
        super(context);
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        getSettings().setSupportZoom(false);
        setScrollBarStyle(0);
        getSettings().setJavaScriptEnabled(true);
        if (VersionCode.currentApiLevel().isAtLeast(VersionCode.ICE_CREAM_SANDWICH)) {
            m2448a(true);
        }
        setBackgroundColor(0);
        setOnTouchListener(new View$OnTouchListenerC3771b());
        setId((int) Utils.generateUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2290a(String str) {
        loadDataWithBaseURL(Networking.getBaseUrlScheme() + "://ads.mopub.com/", str, "text/html", "utf-8", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static VastWebView m2291a(Context context, VastResource vastResource) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(vastResource);
        VastWebView vastWebView = new VastWebView(context);
        vastResource.initializeWebView(vastWebView);
        return vastWebView;
    }

    /* compiled from: VastWebView.java */
    /* renamed from: com.mopub.mobileads.bg$b */
    /* loaded from: classes.dex */
    class View$OnTouchListenerC3771b implements View.OnTouchListener {

        /* renamed from: b */
        private boolean f20572b;

        View$OnTouchListenerC3771b() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.f20572b = true;
                    break;
                case 1:
                    if (!this.f20572b) {
                        return false;
                    }
                    this.f20572b = false;
                    if (VastWebView.this.f20570b != null) {
                        VastWebView.this.f20570b.onVastWebViewClick();
                        break;
                    }
                    break;
            }
            return false;
        }
    }
}
