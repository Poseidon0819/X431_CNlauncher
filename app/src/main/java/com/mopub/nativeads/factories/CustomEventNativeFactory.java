package com.mopub.nativeads.factories;

import com.mopub.common.Preconditions;
import com.mopub.nativeads.CustomEventNative;
import com.mopub.nativeads.MoPubCustomEventNative;
import java.lang.reflect.Constructor;

/* loaded from: classes2.dex */
public class CustomEventNativeFactory {

    /* renamed from: a */
    protected static CustomEventNativeFactory f21150a = new CustomEventNativeFactory();

    public static CustomEventNative create(String str) throws Exception {
        if (str != null) {
            Class<? extends U> asSubclass = Class.forName(str).asSubclass(CustomEventNative.class);
            Preconditions.checkNotNull(asSubclass);
            Constructor declaredConstructor = asSubclass.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            return (CustomEventNative) declaredConstructor.newInstance(new Object[0]);
        }
        return new MoPubCustomEventNative();
    }

    @Deprecated
    public static void setInstance(CustomEventNativeFactory customEventNativeFactory) {
        Preconditions.checkNotNull(customEventNativeFactory);
        f21150a = customEventNativeFactory;
    }
}
