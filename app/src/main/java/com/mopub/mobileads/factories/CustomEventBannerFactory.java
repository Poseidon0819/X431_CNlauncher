package com.mopub.mobileads.factories;

import com.mopub.mobileads.CustomEventBanner;
import java.lang.reflect.Constructor;

/* loaded from: classes.dex */
public class CustomEventBannerFactory {

    /* renamed from: a */
    private static CustomEventBannerFactory f20585a = new CustomEventBannerFactory();

    @Deprecated
    public static void setInstance(CustomEventBannerFactory customEventBannerFactory) {
        f20585a = customEventBannerFactory;
    }

    public static CustomEventBanner create(String str) throws Exception {
        Constructor declaredConstructor = Class.forName(str).asSubclass(CustomEventBanner.class).getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return (CustomEventBanner) declaredConstructor.newInstance(new Object[0]);
    }
}
