package com.mopub.mobileads;

import android.util.Pair;
import com.mopub.common.MoPubReward;
import com.mopub.mobileads.CustomEventRewardedVideo;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.mobileads.ah */
/* loaded from: classes.dex */
public final class RewardedVideoData {

    /* renamed from: f */
    String f20515f;

    /* renamed from: g */
    String f20516g;

    /* renamed from: a */
    final Map<String, CustomEventRewardedVideo> f20510a = new TreeMap();

    /* renamed from: b */
    final Map<String, MoPubReward> f20511b = new TreeMap();

    /* renamed from: c */
    final Map<String, String> f20512c = new TreeMap();

    /* renamed from: d */
    final Map<Class<? extends CustomEventRewardedVideo>, MoPubReward> f20513d = new HashMap();

    /* renamed from: h */
    private final Map<C3748a, Set<String>> f20517h = new HashMap();

    /* renamed from: e */
    final Set<CustomEventRewardedVideo.CustomEventRewardedVideoListener> f20514e = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final CustomEventRewardedVideo m2313a(String str) {
        return this.f20510a.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final Set<String> m2315a(Class<? extends CustomEventRewardedVideo> cls, String str) {
        if (str == null) {
            HashSet hashSet = new HashSet();
            for (Map.Entry<C3748a, Set<String>> entry : this.f20517h.entrySet()) {
                if (cls == entry.getKey().f20518a) {
                    hashSet.addAll(entry.getValue());
                }
            }
            return hashSet;
        }
        C3748a c3748a = new C3748a(cls, str);
        return this.f20517h.containsKey(c3748a) ? this.f20517h.get(c3748a) : Collections.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2314a(Class<? extends CustomEventRewardedVideo> cls, String str, String str2) {
        C3748a c3748a = new C3748a(cls, str);
        Iterator<Map.Entry<C3748a, Set<String>>> it = this.f20517h.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<C3748a, Set<String>> next = it.next();
            if (!next.getKey().equals(c3748a) && next.getValue().contains(str2)) {
                next.getValue().remove(str2);
                if (next.getValue().isEmpty()) {
                    it.remove();
                }
            }
        }
        Set<String> set = this.f20517h.get(c3748a);
        if (set == null) {
            set = new HashSet<>();
            this.f20517h.put(c3748a, set);
        }
        set.add(str2);
    }

    /* compiled from: RewardedVideoData.java */
    /* renamed from: com.mopub.mobileads.ah$a */
    /* loaded from: classes.dex */
    static class C3748a extends Pair<Class<? extends CustomEventRewardedVideo>, String> {

        /* renamed from: a */
        final Class<? extends CustomEventRewardedVideo> f20518a;

        /* renamed from: b */
        final String f20519b;

        public C3748a(Class<? extends CustomEventRewardedVideo> cls, String str) {
            super(cls, str);
            this.f20518a = cls;
            this.f20519b = str;
        }
    }
}
