package com.mopub.mobileads;

import android.app.Activity;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class CustomEventRewardedVideo {

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public interface CustomEventRewardedVideoListener {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public abstract String mo2425a();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo2423b();

    /* renamed from: b */
    protected abstract void mo2422b(Activity activity, Map<String, Object> map, Map<String, String> map2) throws Exception;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public abstract boolean mo2420c();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public abstract void mo2418d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2441a(Activity activity, Map<String, Object> map, Map<String, String> map2) {
        try {
            mo2422b(activity, map, map2);
        } catch (Exception e) {
            MoPubLog.m2496e(e.getMessage());
        }
    }
}
