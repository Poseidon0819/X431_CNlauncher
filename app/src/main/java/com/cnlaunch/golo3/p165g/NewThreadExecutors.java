package com.cnlaunch.golo3.p165g;

import com.mopub.nativeads.MoPubNativeAdPositioning;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.cnlaunch.golo3.g.o */
/* loaded from: classes.dex */
public final class NewThreadExecutors {
    /* renamed from: a */
    public static ExecutorService m9127a() {
        return new ThreadPoolExecutor(0, MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT, 60L, TimeUnit.SECONDS, new SynchronousQueue());
    }
}
