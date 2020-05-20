package com.mopub.common;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class MoPubLifecycleManager implements LifecycleListener {

    /* renamed from: a */
    private static MoPubLifecycleManager f20089a;

    /* renamed from: b */
    private final Set<LifecycleListener> f20090b = new HashSet();

    /* renamed from: c */
    private final WeakReference<Activity> f20091c;

    private MoPubLifecycleManager(Activity activity) {
        this.f20091c = new WeakReference<>(activity);
    }

    public static synchronized MoPubLifecycleManager getInstance(Activity activity) {
        MoPubLifecycleManager moPubLifecycleManager;
        synchronized (MoPubLifecycleManager.class) {
            if (f20089a == null) {
                f20089a = new MoPubLifecycleManager(activity);
            }
            moPubLifecycleManager = f20089a;
        }
        return moPubLifecycleManager;
    }

    public void addLifecycleListener(LifecycleListener lifecycleListener) {
        Activity activity;
        if (lifecycleListener == null || !this.f20090b.add(lifecycleListener) || (activity = this.f20091c.get()) == null) {
            return;
        }
        lifecycleListener.onCreate(activity);
        lifecycleListener.onStart(activity);
    }

    @Override // com.mopub.common.LifecycleListener
    public void onCreate(Activity activity) {
        for (LifecycleListener lifecycleListener : this.f20090b) {
            lifecycleListener.onCreate(activity);
        }
    }

    @Override // com.mopub.common.LifecycleListener
    public void onStart(Activity activity) {
        for (LifecycleListener lifecycleListener : this.f20090b) {
            lifecycleListener.onStart(activity);
        }
    }

    @Override // com.mopub.common.LifecycleListener
    public void onPause(Activity activity) {
        for (LifecycleListener lifecycleListener : this.f20090b) {
            lifecycleListener.onPause(activity);
        }
    }

    @Override // com.mopub.common.LifecycleListener
    public void onResume(Activity activity) {
        for (LifecycleListener lifecycleListener : this.f20090b) {
            lifecycleListener.onResume(activity);
        }
    }

    @Override // com.mopub.common.LifecycleListener
    public void onRestart(Activity activity) {
        for (LifecycleListener lifecycleListener : this.f20090b) {
            lifecycleListener.onRestart(activity);
        }
    }

    @Override // com.mopub.common.LifecycleListener
    public void onStop(Activity activity) {
        for (LifecycleListener lifecycleListener : this.f20090b) {
            lifecycleListener.onRestart(activity);
        }
    }

    @Override // com.mopub.common.LifecycleListener
    public void onDestroy(Activity activity) {
        for (LifecycleListener lifecycleListener : this.f20090b) {
            lifecycleListener.onRestart(activity);
        }
    }

    @Override // com.mopub.common.LifecycleListener
    public void onBackPressed(Activity activity) {
        for (LifecycleListener lifecycleListener : this.f20090b) {
            lifecycleListener.onBackPressed(activity);
        }
    }
}
