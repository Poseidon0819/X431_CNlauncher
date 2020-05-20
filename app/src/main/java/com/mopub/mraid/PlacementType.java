package com.mopub.mraid;

import java.util.Locale;

/* loaded from: classes.dex */
public enum PlacementType {
    INLINE,
    INTERSTITIAL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String toJavascriptString() {
        return toString().toLowerCase(Locale.US);
    }
}
