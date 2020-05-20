package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.mopub.common.AdType;
import com.mopub.common.DataKeys;
import com.mopub.common.FullAdType;
import com.mopub.common.IntentActions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.common.util.Reflection;
import com.mopub.mobileads.BaseVideoViewController;
import com.mopub.mraid.MraidVideoViewController;

/* loaded from: classes.dex */
public class MraidVideoPlayerActivity extends BaseVideoPlayerActivity implements BaseVideoViewController.BaseVideoViewControllerListener {

    /* renamed from: a */
    private BaseVideoViewController f20384a;

    /* renamed from: b */
    private long f20385b;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        this.f20385b = getIntent().getLongExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, -1L);
        try {
            this.f20384a = m2390a(bundle);
            this.f20384a.onCreate();
        } catch (IllegalStateException unused) {
            BaseBroadcastReceiver.m2454a(this, this.f20385b, IntentActions.ACTION_INTERSTITIAL_FAIL);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        BaseVideoViewController baseVideoViewController = this.f20384a;
        if (baseVideoViewController != null) {
            baseVideoViewController.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        BaseVideoViewController baseVideoViewController = this.f20384a;
        if (baseVideoViewController != null) {
            baseVideoViewController.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.BaseVideoPlayerActivity, android.app.Activity
    public void onDestroy() {
        BaseVideoViewController baseVideoViewController = this.f20384a;
        if (baseVideoViewController != null) {
            baseVideoViewController.onDestroy();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        BaseVideoViewController baseVideoViewController = this.f20384a;
        if (baseVideoViewController != null) {
            baseVideoViewController.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        BaseVideoViewController baseVideoViewController = this.f20384a;
        if (baseVideoViewController != null) {
            baseVideoViewController.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        BaseVideoViewController baseVideoViewController = this.f20384a;
        if (baseVideoViewController == null || !baseVideoViewController.backButtonEnabled()) {
            return;
        }
        super.onBackPressed();
        this.f20384a.onBackPressed();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        BaseVideoViewController baseVideoViewController = this.f20384a;
        if (baseVideoViewController != null) {
            baseVideoViewController.mo2366a(i, i2);
        }
    }

    /* renamed from: a */
    private BaseVideoViewController m2390a(Bundle bundle) throws IllegalStateException {
        String stringExtra = getIntent().getStringExtra(BaseVideoPlayerActivity.VIDEO_CLASS_EXTRAS_KEY);
        if (FullAdType.VAST.equals(stringExtra)) {
            return new VastVideoViewController(this, getIntent().getExtras(), bundle, this.f20385b, this);
        }
        if (AdType.MRAID.equals(stringExtra)) {
            return new MraidVideoViewController(this, getIntent().getExtras(), bundle, this);
        }
        if ("native".equals(stringExtra)) {
            Class[] clsArr = {Context.class, Bundle.class, Bundle.class, BaseVideoViewController.BaseVideoViewControllerListener.class};
            Object[] objArr = {this, getIntent().getExtras(), bundle, this};
            if (!Reflection.classFound("com.mopub.nativeads.NativeVideoViewController")) {
                throw new IllegalStateException("Missing native video module");
            }
            try {
                return (BaseVideoViewController) Reflection.instantiateClassWithConstructor("com.mopub.nativeads.NativeVideoViewController", BaseVideoViewController.class, clsArr, objArr);
            } catch (Exception unused) {
                throw new IllegalStateException("Missing native video module");
            }
        }
        throw new IllegalStateException("Unsupported video type: ".concat(String.valueOf(stringExtra)));
    }

    @Override // com.mopub.mobileads.BaseVideoViewController.BaseVideoViewControllerListener
    public void onSetContentView(View view) {
        setContentView(view);
    }

    @Override // com.mopub.mobileads.BaseVideoViewController.BaseVideoViewControllerListener
    public void onSetRequestedOrientation(int i) {
        setRequestedOrientation(i);
    }

    @Override // com.mopub.mobileads.BaseVideoViewController.BaseVideoViewControllerListener
    public void onFinish() {
        finish();
    }

    @Override // com.mopub.mobileads.BaseVideoViewController.BaseVideoViewControllerListener
    public void onStartActivityForResult(Class<? extends Activity> cls, int i, Bundle bundle) {
        if (cls == null) {
            return;
        }
        try {
            startActivityForResult(Intents.getStartActivityIntent(this, cls, bundle), i);
        } catch (ActivityNotFoundException unused) {
            MoPubLog.m2498d("Activity " + cls.getName() + " not found. Did you declare it in your AndroidManifest.xml?");
        }
    }
}
