package com.mopub.nativeads;

import android.view.View;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes2.dex */
public abstract class BaseNativeAd {

    /* renamed from: b */
    NativeEventListener f20753b;

    /* renamed from: a */
    final Set<String> f20752a = new HashSet();

    /* renamed from: c */
    private final Set<String> f20754c = new HashSet();

    /* loaded from: classes2.dex */
    public interface NativeEventListener {
        void onAdClicked();

        void onAdImpressed();
    }

    public abstract void clear(View view);

    public abstract void destroy();

    public abstract void prepare(View view);

    public void setNativeEventListener(NativeEventListener nativeEventListener) {
        this.f20753b = nativeEventListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m2205a() {
        NativeEventListener nativeEventListener = this.f20753b;
        if (nativeEventListener != null) {
            nativeEventListener.onAdImpressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m2204a(Object obj) throws ClassCastException {
        if (!(obj instanceof JSONArray)) {
            throw new ClassCastException("Expected impression trackers of type JSONArray.");
        }
        JSONArray jSONArray = (JSONArray) obj;
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                addImpressionTracker(jSONArray.getString(i));
            } catch (JSONException unused) {
                MoPubLog.m2498d("Unable to parse impression trackers.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final void m2202b(Object obj) throws ClassCastException {
        if (!(obj instanceof JSONArray)) {
            throw new ClassCastException("Expected click trackers of type JSONArray.");
        }
        JSONArray jSONArray = (JSONArray) obj;
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                addClickTracker(jSONArray.getString(i));
            } catch (JSONException unused) {
                MoPubLog.m2498d("Unable to parse click trackers.");
            }
        }
    }

    public final void addImpressionTracker(String str) {
        if (Preconditions.NoThrow.checkNotNull(str, "impressionTracker url is not allowed to be null")) {
            this.f20752a.add(str);
        }
    }

    public final void addClickTracker(String str) {
        if (Preconditions.NoThrow.checkNotNull(str, "clickTracker url is not allowed to be null")) {
            this.f20754c.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final Set<String> m2203b() {
        return new HashSet(this.f20754c);
    }
}
