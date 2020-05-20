package com.mopub.common.factories;

import com.mopub.common.util.Reflection;

/* loaded from: classes.dex */
public class MethodBuilderFactory {

    /* renamed from: a */
    protected static MethodBuilderFactory f20212a = new MethodBuilderFactory();

    @Deprecated
    public static void setInstance(MethodBuilderFactory methodBuilderFactory) {
        f20212a = methodBuilderFactory;
    }

    public static Reflection.MethodBuilder create(Object obj, String str) {
        return new Reflection.MethodBuilder(obj, str);
    }
}
