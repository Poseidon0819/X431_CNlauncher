package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.mobileads.VastManager;

/* loaded from: classes.dex */
public class VastManagerFactory {

    /* renamed from: a */
    protected static VastManagerFactory f20592a = new VastManagerFactory();

    public static VastManager create(Context context) {
        return f20592a.internalCreate(context, true);
    }

    public static VastManager create(Context context, boolean z) {
        return f20592a.internalCreate(context, z);
    }

    public VastManager internalCreate(Context context, boolean z) {
        return new VastManager(context, z);
    }

    @Deprecated
    public static void setInstance(VastManagerFactory vastManagerFactory) {
        f20592a = vastManagerFactory;
    }
}
