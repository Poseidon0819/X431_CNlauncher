package com.mopub.common.util;

import java.util.Collection;
import java.util.Collections;

/* loaded from: classes.dex */
public class MoPubCollections {
    public static <T> void addAllNonNull(Collection<? super T> collection, T... tArr) {
        Collections.addAll(collection, tArr);
        collection.removeAll(Collections.singleton(null));
    }
}
