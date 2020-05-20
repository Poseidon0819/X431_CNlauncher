package com.baidu.platform.domain;

import com.baidu.mapapi.http.HttpClient;

/* renamed from: com.baidu.platform.domain.d */
/* loaded from: classes.dex */
public class C1383d {
    /* renamed from: a */
    public static InterfaceC1382c m9769a() {
        return HttpClient.isHttpsEnable ? new C1381b() : new C1380a();
    }
}
