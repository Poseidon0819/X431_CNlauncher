package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* renamed from: com.baidu.mapsdkplatform.comapi.util.c */
/* loaded from: classes.dex */
public final class C1302c {

    /* renamed from: a */
    private final boolean f6387a;

    /* renamed from: b */
    private final String f6388b;

    /* renamed from: c */
    private final String f6389c;

    /* renamed from: d */
    private final String f6390d;

    /* renamed from: e */
    private final String f6391e;

    /* renamed from: f */
    private final String f6392f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1302c(Context context) {
        this.f6387a = false;
        this.f6388b = Environment.getExternalStorageDirectory().getAbsolutePath();
        this.f6389c = this.f6388b + File.separator + "BaiduMapSDKNew";
        this.f6390d = context.getCacheDir().getAbsolutePath();
        this.f6391e = "";
        this.f6392f = "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1302c(String str, boolean z, String str2, Context context) {
        this.f6387a = z;
        this.f6388b = str;
        this.f6389c = this.f6388b + File.separator + "BaiduMapSDKNew";
        this.f6390d = this.f6389c + File.separator + "cache";
        this.f6391e = context.getCacheDir().getAbsolutePath();
        this.f6392f = str2;
    }

    /* renamed from: a */
    public final String m10087a() {
        return this.f6388b;
    }

    /* renamed from: b */
    public final String m10086b() {
        return this.f6388b + File.separator + "BaiduMapSDKNew";
    }

    /* renamed from: c */
    public final String m10085c() {
        return this.f6390d;
    }

    /* renamed from: d */
    public final String m10084d() {
        return this.f6391e;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !C1302c.class.isInstance(obj)) {
            return false;
        }
        return this.f6388b.equals(((C1302c) obj).f6388b);
    }
}
