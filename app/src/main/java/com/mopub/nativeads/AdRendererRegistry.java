package com.mopub.nativeads;

import com.mopub.common.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class AdRendererRegistry {

    /* renamed from: a */
    private final ArrayList<MoPubAdRenderer> f20747a = new ArrayList<>();

    public void registerAdRenderer(MoPubAdRenderer moPubAdRenderer) {
        this.f20747a.add(moPubAdRenderer);
    }

    public int getAdRendererCount() {
        return this.f20747a.size();
    }

    public Iterable<MoPubAdRenderer> getRendererIterable() {
        return this.f20747a;
    }

    public int getViewTypeForAd(NativeAd nativeAd) {
        Preconditions.checkNotNull(nativeAd);
        for (int i = 0; i < this.f20747a.size(); i++) {
            if (nativeAd.getMoPubAdRenderer() == this.f20747a.get(i)) {
                return i + 1;
            }
        }
        return 0;
    }

    public MoPubAdRenderer getRendererForAd(BaseNativeAd baseNativeAd) {
        Preconditions.checkNotNull(baseNativeAd);
        Iterator<MoPubAdRenderer> it = this.f20747a.iterator();
        while (it.hasNext()) {
            MoPubAdRenderer next = it.next();
            if (next.supports(baseNativeAd)) {
                return next;
            }
        }
        return null;
    }

    public MoPubAdRenderer getRendererForViewType(int i) {
        try {
            return this.f20747a.get(i - 1);
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }
}
