package com.baidu.mapapi;

import com.baidu.mapsdkplatform.comjni.tools.C1312a;

/* loaded from: classes.dex */
public class OpenLogUtil {

    /* renamed from: a */
    private static ModuleName f4863a;

    public static void setModuleLogEnable(ModuleName moduleName, boolean z) {
        f4863a = moduleName;
        C1312a.m9961a(z, f4863a.ordinal());
    }
}
