package com.mopub.mobileads.factories;

import com.mopub.mobileads.CustomEventInterstitial;
import java.lang.reflect.Constructor;

/* loaded from: classes.dex */
public class CustomEventInterstitialFactory {

    /* renamed from: a */
    private static CustomEventInterstitialFactory f20587a = new CustomEventInterstitialFactory();

    @Deprecated
    public static void setInstance(CustomEventInterstitialFactory customEventInterstitialFactory) {
        f20587a = customEventInterstitialFactory;
    }

    public static CustomEventInterstitial create(String str) throws Exception {
        Constructor declaredConstructor = Class.forName(str).asSubclass(CustomEventInterstitial.class).getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return (CustomEventInterstitial) declaredConstructor.newInstance(new Object[0]);
    }
}
